import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  public API = '//localhost:8080'

  constructor(private http: HttpClient) { }

  getAdmins(): Observable<any> {
    return this.http.get(this.API + '/admin');
  }
  getTitles(): Observable<any> {
    return this.http.get(this.API + '/title');
  }
  getDegrees(): Observable<any>{
    return this.http.get(this.API + '/degree')
  }
  getPositions(): Observable<any>{
    return this.http.get(this.API + '/position')
  }
  getAdminDetail(username): Observable<any>{
    return this.http.get(this.API + '/admin/getByUsername/' + username)
  }
  getAdminLogin(): Observable<any>{
    return this.http.get(this.API + '/admin/login/getByLoginId/1')
  }
  getEmployee(): Observable<any>{
    return this.http.get(this.API + '/employee');
  }

  editEmployee(id){
    return this.http.put(this.API + '/employee/edit' + id,id);
  }
  deleteEmployee(id){
    return this.http.delete(this.API + '/employee/' + id);
  }
}
