import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable({
  providedIn: 'root'
})
export class LeaseService {

  public API = '//localhost:8080'

  constructor(private http: HttpClient) { }

  getAdmins(): Observable<any> {
    return this.http.get(this.API + '/admin');
  }
  getMember(): Observable<any> {
    return this.http.get(this.API + '/members');
  }
  getAccessory(): Observable<any>{
    return this.http.get(this.API + '/accessory')
  }
  getDuration(): Observable<any>{
    return this.http.get(this.API + '/duration')
  }
  getAdminDetail(username): Observable<any>{
    return this.http.get(this.API + '/admin/getByUsername/' + username)
  }
  getAdminLogin(): Observable<any>{
    return this.http.get(this.API + '/admin/login/getByLoginId/1')
  }
  getLease(): Observable<any>{
    return this.http.get(this.API + '/lease');
  }

  editLease(id){
    return this.http.put(this.API + '/lease/edit' + id,id);
  }
  deleteLease(id){
    return this.http.delete(this.API + '/lease/' + id);
  }
}
