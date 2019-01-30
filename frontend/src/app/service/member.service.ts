import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class MemberService {

  public API = '//localhost:8080';

  constructor(private http: HttpClient) { }

  getMembers(): Observable<any> {
    return this.http.get(this.API + '/members');
  }
  getPrivileges(): Observable<any> {
    return this.http.get(this.API + '/privileges');
  }
  getTitles(): Observable<any> {
    return this.http.get(this.API + '/title');
  }
  getProvinces(): Observable<any> {
    return this.http.get(this.API + '/provinces');
  }
  getAdmins(): Observable<any> {
    return this.http.get(this.API + '/admin');
  }
  getAdminLogin(): Observable<any>{
    return this.http.get(this.API + '/admin/login/getByLoginId/1')
  }
}
