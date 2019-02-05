import { Component, OnInit } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { NotificationService } from '../service/notification.service';
import { Router } from "@angular/router";
import { ActivatedRoute } from "@angular/router";
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { AdminService } from '../service/admin.service';

@Component({
  selector: 'app-notification',
  templateUrl: './notification.component.html',
  styleUrls: ['./notification.component.css']
})
export class NotificationComponent implements OnInit {

  admins: Array<any>
  employees: Array<any>
  fields: Array<any>

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
  select: any = {
    adminSelect: '',
    employeeSelect: '',
    fieldSelect: ''
  }
  note: String
  data: any={}

  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches)
    );

  constructor(private breakpointObserver: BreakpointObserver,private route:ActivatedRoute,private notificationService: NotificationService , private httpClient: HttpClient, private router:Router, private adminService: AdminService) { }

  ngOnInit() {
    this.notificationService.getEmployees().subscribe(data => {
      this.employees = data;
      console.log(this.employees);
    })
    this.notificationService.getFields().subscribe(data => {
      this.fields = data;
      console.log(this.fields);
    })
    this.notificationService.getAdminLogin().subscribe(data => {
      this.adminLogin = data;
      console.log(this.adminLogin);
    });
    this.adminService.getAdminLogin().subscribe(data => {
      this.adminLogin = data;
      this.adminId = data.admin.adminId;
      this.adminName = data.admin.name;
    });

  }

  submit() {
    if (this.adminLogin.admin.adminId === '' || this.select.employeeSelect === '' || this.select.fieldSelect === '' || this.note === '') {
      alert('กรุณากรอกข้อมูลให้ครบถ้วน');
    } else {
      this.httpClient.post('http://localhost:8080/notification/' + this.adminLogin.admin.adminId + '/' + this.select.employeeSelect + '/' + this.select.fieldSelect+ '/'+ this.note,this.select)
      .subscribe(
          data => {
              console.log('PUT Request is successful', data);
              this.router.navigate(['notification-show'])
          },
          error => {
              console.log('Error', error);
          }
      );
    }
  }
}
