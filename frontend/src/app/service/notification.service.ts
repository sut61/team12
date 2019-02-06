import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
@Injectable({
  providedIn: 'root'
})
export class NotificationService {
  public API = '//localhost:8080'

  constructor(private http: HttpClient) { }

  getAdmins(): Observable<any> {
    return this.http.get(this.API + '/admin');
  }
  getAdminDetail(username): Observable<any>{
    return this.http.get(this.API + '/admin/getByUsername/' + username)
  }
  getAdminLogin(): Observable<any>{
    return this.http.get(this.API + '/admin/login/getByLoginId/1')
  }
  getNotification(): Observable<any>{
    return this.http.get(this.API + '/notification')
  }
  getEmployees(): Observable<any> {
    return this.http.get(this.API + '/employee');
  }
  getFields(): Observable<any>{
    return this.http.get(this.API + '/field')
  }


  
  editNotification(id){
    return this.http.put(this.API + '/notification/edit' + id,id);
  }
  deleteNotification(id){
    return this.http.delete(this.API + '/notification/' + id);
  }
}
