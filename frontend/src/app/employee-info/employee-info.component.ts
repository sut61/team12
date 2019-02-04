import { Component, OnInit } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { EmployeeService } from '../service/employee.service';
import { Router } from "@angular/router";
import { ActivatedRoute } from "@angular/router";
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { ACTIVE_INDEX } from '@angular/core/src/render3/interfaces/container';
import { AdminService } from '../service/admin.service';

export interface Employee {
  employeeId;
  id;
  firstName;
  lastName;
  birthDate;
  phone;
  email;
  address;
  admin:{}
  Title:{}
  degree:{}
  position:{}
}

@Component({
  selector: 'app-employee-info',
  templateUrl: './employee-info.component.html',
  styleUrls: ['./employee-info.component.css']
})
export class EmployeeInfoComponent implements OnInit {
  data:any={}
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



  employees: Array<any>
  id
  employee = {} as Employee;

  dataColumns: string[] = ['no', 'id', 'name', 'birth','degree','position','phone','email','address','edit','delete'];

  constructor(private breakpointObserver: BreakpointObserver, private employeeService: EmployeeService , private httpClient: HttpClient, private adminService: AdminService) { }

  ngOnInit() {
    this.employeeService.getEmployee().subscribe(data => {
      this.employees = data;
      this.employee = data[1];
      console.log(this.employees);
      console.log(this.employee)
    });
    this.adminService.getAdminLogin().subscribe(data => {
      this.adminLogin = data;
      this.adminId = data.admin.adminId;
      this.adminName = data.admin.name;
    })
  }


  editEmployee(){
    // this.employeeService.editEmployee();
  }
  deleteEmployee(){
    this.employeeService.deleteEmployee(this.id);
  }
}
