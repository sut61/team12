import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable({
  providedIn: 'root'
})
export class LockerService {

  public API = '//localhost:8080'

  constructor(private http: HttpClient) { }

  getMembers(): Observable<any> {
    return this.http.get(this.API + '/members');
  }
  getAdminLogin(): Observable<any>{
    return this.http.get(this.API + '/admin/login/getByLoginId/1')
  }
  getLockers(): Observable<any>{
    return this.http.get(this.API + '/locker')
  }
  getLockerDuration(): Observable<any>{
    return this.http.get(this.API + '/lockerDuration')
  }
  getLockerOrder(): Observable<any>{
    return this.http.get(this.API + '/lockerOrder')
  }

  

}
