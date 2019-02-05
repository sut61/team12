import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';


@Injectable({
  providedIn: 'root'
})
export class FieldService {

 
 public API = '//localhost:8080'

  constructor(private http: HttpClient) { }

  // getAdmins(): Observable<any> {
  //   return this.http.get(this.API + '/admin');
  // }
  getMembers(): Observable<any> {
    return this.http.get(this.API + '/members');
  }
  getFields(): Observable<any>{
    return this.http.get(this.API + '/field')
  }
  getFieldDuration(): Observable<any>{
    return this.http.get(this.API + '/fieldDuration')
  }
  getAdminLogin(): Observable<any>{
    return this.http.get(this.API + '/admin/login/getByLoginId/1')
  }
  getFieldOrder(): Observable<any>{
    return this.http.get(this.API + '/fieldOrder')
  }


  // editEmployee(id){
  //   return this.http.put(this.API + '/employee/edit' + id,id);
  // }
  // deleteEmployee(id){
  //   return this.http.delete(this.API + '/employee/' + id);
  // }
}
