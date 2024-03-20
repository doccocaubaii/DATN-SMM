import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ApiConstatnt} from "../../const/api.constatnt";
import {AppConfig} from "../../config";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) {
  }

  signIn(dto: object): Observable<any> {
    return this.http.post(AppConfig.baseUrl + ApiConstatnt.LOGIN_URL, dto);
  }

  signUp(dto: object): Observable<any> {
    return this.http.post(AppConfig.baseUrl + ApiConstatnt.SIGN_UP_URL, dto);
  }
}
