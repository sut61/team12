import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TicketService {

  
  public API = '//localhost:8080';

  constructor(private http: HttpClient) { }

  getTicketTypes(): Observable<any> {
    return this.http.get(this.API + '/ticketTypes');
  }
  getTickets(): Observable<any> {
    return this.http.get(this.API + '/tickets');
  }
  getFields(): Observable<any> {
    return this.http.get(this.API + '/field');
  }
  getAdmins(): Observable<any> {
    return this.http.get(this.API + '/admin');
  }
  getAdminLogin(): Observable<any>{
    return this.http.get(this.API + '/admin/login/getByLoginId/1')
  }
  getLastTicket(): Observable<any>{
    return this.http.get(this.API + '/tickets/last');
  }
}
