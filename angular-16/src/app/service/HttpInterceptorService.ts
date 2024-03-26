import {Injectable} from '@angular/core';
import {HttpErrorResponse, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {ToastrService} from "ngx-toastr";
import {SessionStorageService} from "./SessionStorageService";
import {catchError, Observable, throwError} from "rxjs";
import {Router} from "@angular/router";

@Injectable()
export class HttpInterceptorService implements HttpInterceptor {
  constructor(private toast: ToastrService,
              private sessionService: SessionStorageService,
              private router: Router,
  ) {
  }

  // intercept(req: HttpRequest<any>, next: HttpHandler):
  //   Observable<HttpEvent<any>> {
  //   return next.handle(req);
  // }


  intercept(
    request: HttpRequest<any>,
    next: HttpHandler
  ): Observable<HttpEvent<any>> {
    // Thêm JWT vào header của request
    const jwt = this.sessionService.getItem('jwt');
    if (jwt) {
      request = request.clone({
        setHeaders: {
          Authorization: `Bearer ${jwt}`
        }
      });
    }
    // console.log("Hello this is go")

    return next.handle(request).pipe(
      // tap((event: HttpEvent<any>) => {
      //   // console.log("PP this is back")
      //   if (event instanceof HttpResponse) {
      //     // Nếu response là HttpResponse, trả về body của response
      //     return event.body;
      //     // return event;
      //   }
      // }),
      catchError((error: HttpErrorResponse) => {
        if (error.status == 0) {
          // Xử lý lỗi khi không thể kết nối với backend
          console.error('Lỗi không thể kết nối với server:', error.error);
          // Hiển thị thông báo cho người dùng hoặc thực hiện các hành động khác
          this.toast.error('Không thể kết nối với server, vui lòng kiểm tra lại kết nối internet.');
          return throwError(error);
        }

        if (error.status == 401) {
          const currentPath = this.router.url;
          // Kiểm tra xem đường dẫn hiện tại có phải là "/login" hay không
          if ("/login" != currentPath) this.router.navigate(['/login']);
        }

        // Xử lý lỗi
        if (error.error && error.error.message) {
          this.toast.error(error.error.message);
        }
        if (error.error && error.error.data) {
          console.error(error.error.data);
        }
        // Throw lại error để cho component hoặc interceptor khác xử lý tiếp
        return throwError(error);
      })
    );
  }
}

