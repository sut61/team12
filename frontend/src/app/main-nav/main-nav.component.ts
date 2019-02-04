import { Component ,OnInit} from '@angular/core';
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { ActivatedRoute } from "@angular/router";
import { HttpClient} from '@angular/common/http';
import { EmployeeService } from '../service/employee.service';
import { Router } from "@angular/router";
import { AdminService } from '../service/admin.service';

export interface adminLogin {
  loginId:1
  admin:{
    adminId:'',
    name:'',
    username:'',
    password:''
  }
} 

@Component({
  selector: 'app-main-nav',
  templateUrl: './main-nav.component.html',
  styleUrls: ['./main-nav.component.css']
})
export class MainNavComponent {

  adminId:any
  adminName:any
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

  constructor(private breakpointObserver: BreakpointObserver, private route:ActivatedRoute, private employeeService: EmployeeService , private httpClient: HttpClient, private router:Router, private adminService: AdminService) {
  
  }

  ngOnInit() {
    this.adminService.getAdminLogin().subscribe(data => {
      this.adminLogin = data;
      this.adminId = data.admin.adminId;
      this.adminName = data.admin.name;
    });
  }

}
