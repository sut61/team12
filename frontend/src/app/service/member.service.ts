import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Member } from '../member-show/member-show.component';

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
  // remove(member: Member | number): Observable<Member>{
  //   const id = typeof member === 'number' ? member : member.memberId;
  //   const url = `${this.API}/${id}`;
  //   return this.http.delete<Member>(url);
  // }
}
