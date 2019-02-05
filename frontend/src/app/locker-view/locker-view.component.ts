import { Component, OnInit } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { EmployeeService } from '../service/employee.service';
import { Router } from "@angular/router";
import { ActivatedRoute } from "@angular/router";
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { LockerService } from '../service/locker.service';
import { AdminService } from '../service/admin.service';

@Component({
  selector: 'app-locker-view',
  templateUrl: './locker-view.component.html',
  styleUrls: ['./locker-view.component.css']
})
export class LockerViewComponent implements OnInit {


  LockerOrders: Array<any>

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


  dataColumns: string[] = ['no', 'admin', 'member', 'locker','lockerDuration','date','note'];


  constructor(private breakpointObserver: BreakpointObserver,private route:ActivatedRoute,private lockerService: LockerService , private httpClient: HttpClient, private router:Router, private adminService: AdminService) { }

  ngOnInit() {
    this.lockerService.getLockerOrder().subscribe(data => {
      this.LockerOrders = data;
      console.log(this.LockerOrders);
    });
    this.adminService.getAdminLogin().subscribe(data => {
      this.adminLogin = data;
      this.adminId = data.admin.adminId;
      this.adminName = data.admin.name;
    });



  }

}
