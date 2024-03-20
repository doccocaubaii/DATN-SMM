import {Injectable} from '@angular/core';
import {
  HttpErrorResponse,
  HttpEvent,
  HttpHandler,
  HttpInterceptor,
  HttpRequest,
  HttpResponse
} from '@angular/common/http';
import {catchError, Observable, tap, throwError} from 'rxjs';
import {ToastrService} from "ngx-toastr";
import {SessionStorageService} from "./SessionStorageService";

@Injectable()
export class HttpInterceptorService implements HttpInterceptor {
  constructor(private toast: ToastrService,
              private sessionService: SessionStorageService) {
  }

  intercept(
    request: HttpRequest<any>,
    next: HttpHandler
  ): Observable<HttpEvent<any>> {
    // Thêm JWT vào header của request
    const currentUser = this.sessionService.getItem('principle');
    if (currentUser && currentUser.jwt) {
      request = request.clone({
        setHeaders: {
          Authorization: `Bearer ${currentUser.jwt}`
        }
      });
    }
    console.log("Hello this is go")

    return next.handle(request).pipe(
      tap((event: HttpEvent<any>) => {
        console.log("PP this is back")
        if (event instanceof HttpResponse) {
          // Nếu response là HttpResponse, trả về body của response
          return event.body;
        }
      }),
      catchError((error: HttpErrorResponse) => {
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

