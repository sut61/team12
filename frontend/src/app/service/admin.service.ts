import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  public API = '//localhost:8080'

  constructor(private http: HttpClient) { }
  getAdminLogin(): Observable<any>{
    return this.http.get(this.API + '/admin/login/getByLoginId/1')
  }

}
