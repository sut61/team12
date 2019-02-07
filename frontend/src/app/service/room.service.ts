import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable({
  providedIn: 'root'
})
export class RoomService {
  public API = '//localhost:8080'

  constructor(private http: HttpClient) { }

  getAdmins(): Observable<any> {
    return this.http.get(this.API + '/admin');
  }
  getRoom(): Observable<any> {
    return this.http.get(this.API + '/room');
  }
  getRoomDuration(): Observable<any>{
    return this.http.get(this.API + '/roomDuration')
  }
  getRoomOrder(): Observable<any>{
    return this.http.get(this.API + '/roomOrders')
  }
  getMember(): Observable<any>{
    return this.http.get(this.API + '/members')
  }
  getStatus(): Observable<any>{
    return this.http.get(this.API + '/roomStatus')
  }
  getStatus1(): Observable<any>{
    return this.http.get(this.API + '/roomOrders/status/1')
  }
  getRoomCancel(): Observable<any>{
    return this.http.get(this.API + '/roomCancel')
  }
  getRoomShow(): Observable<any>{
    return this.http.get(this.API + '/roomShow')
  }
  getAdminDetail(username): Observable<any>{
    return this.http.get(this.API + '/admin/getByUsername/' + username)
  }
  getAdminLogin(): Observable<any>{
    return this.http.get(this.API + '/admin/login/getByLoginId/1')
  }
}
