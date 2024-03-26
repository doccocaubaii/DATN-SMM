import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {AppConfig} from "../../config";
import {ApiConstatnt} from "../../const/api.constatnt";

@Injectable({
  providedIn: 'root'
})
export class ProfileService {

  constructor(private http: HttpClient) {
  }

  editInfo(dto: object): Observable<any> {
    return this.http.post(AppConfig.baseUrl + ApiConstatnt.EDIT_PROFILE, dto);
  }

  getInfo(): Observable<any> {
    return this.http.get(AppConfig.baseUrl + ApiConstatnt.GET_PROFILE);
  }
}
