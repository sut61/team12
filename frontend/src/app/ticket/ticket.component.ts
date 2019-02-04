import { Component, OnInit } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { MemberService } from '../service/member.service';
import { Router } from "@angular/router";
import { ActivatedRoute } from "@angular/router";
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { TicketService } from '../service/ticket.service';
import { AdminService } from '../service/admin.service';

@Component({
  selector: 'app-ticket',
  templateUrl: './ticket.component.html',
  styleUrls: ['./ticket.component.css']
})
export class TicketComponent implements OnInit {

  ticketTypes: Array<any>;
  fields: Array<any>;
  admins: Array<any>;
  last: Array<any>;
  name: string;
  phoneNumber: string;
  Tickets: any = {ticketTypeSelect: '', fieldSelect: '', adminSelect: ''}
  data:any={};

  adminId:any={}
  adminName:any={}
  adminLogin:{
    loginId:1,
    admin:{
      adminId:'',
      name:'',
      username:'',
      passowrd:''
    }
  }

  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches)
    );

  constructor(private breakpointObserver: BreakpointObserver,private route:ActivatedRoute,private adminService: AdminService, private ticketService: TicketService, private httpClient: HttpClient, private router:Router) { }

  ngOnInit() {
    this.ticketService.getAdmins().subscribe(data => {
      this.admins = data;
      console.log(this.admins);
    });
    this.ticketService.getTicketTypes().subscribe(data => {
      this.ticketTypes = data;
      console.log(this.ticketTypes);
    });
    this.ticketService.getFields().subscribe(data => {
      this.fields = data;
      console.log(this.fields);
    });
    this.ticketService.getAdminLogin().subscribe(data => {
      this.adminLogin = data;
      console.log(this.adminLogin);
    });
    this.ticketService.getLastTicket().subscribe(data => {
      this.last = data;
      console.log(this.last);
    })
    this.adminService.getAdminLogin().subscribe(data => {
      this.adminLogin = data;
      this.adminId = data.admin.adminId;
      this.adminName = data.admin.name;
    })
  }

  submit() {
    if (this.Tickets.ticketTypeSelect === '' || this.Tickets.fieldSelect === '' || this.name === '' || this.phoneNumber === '' ) {
      alert('กรุณากรอกข้อมูลให้ครบถ้วน');
    } else {
      this.httpClient.post('http://localhost:8080/tickets/sell/' + this.Tickets.ticketTypeSelect + '/' + this.name + '/'+ this.phoneNumber + '/' + this.Tickets.fieldSelect + '/'+   this.adminLogin.admin.adminId ,this.Tickets)
      .subscribe(
          data => {
              console.log('PUT Request is successful', data);
              this.router.navigate(['ticket-show'])
          },
          error => {
              console.log('Error', error);
          }
      );
    }
  }

}
