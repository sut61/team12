import { Component, OnInit } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { EmployeeService } from '../service/employee.service';
import { Router } from "@angular/router";
import { ActivatedRoute } from "@angular/router";
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';


@Component({
  selector: 'app-employee-register',
  templateUrl: './employee-register.component.html',
  styleUrls: ['./employee-register.component.css']
})
export class EmployeeRegisterComponent implements OnInit {

  admins: Array<any>
  titles: Array<any>
  degrees: Array<any>
  positions: Array<any>
  // adminLogin: Array<any>
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
    adminSelect:'',
    titleSelect:'',
    degreeSelect:'',
    positionSelect:''
  }

  id: string
  firstName: string
  lastName: string
  birthDate: Date
  // birthDate:String = new Date().toISOString();
  phone: string
  email: string
  address: string

  data:any={}

  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches)
    );

  constructor(private breakpointObserver: BreakpointObserver,private route:ActivatedRoute,private employeeService: EmployeeService , private httpClient: HttpClient, private router:Router) { }

  ngOnInit() {
    // this.route.params.subscribe(prams=>{
    //   this.data = prams
    //   console.log(prams)
    // });
    this.employeeService.getAdmins().subscribe(data => {
      this.admins = data;
      console.log(this.admins);
    });
    this.employeeService.getTitles().subscribe(data => {
      this.titles = data;
      console.log(this.titles);
    });
    this.employeeService.getDegrees().subscribe(data => {
      this.degrees = data;
      console.log(this.degrees);
    });
    this.employeeService.getPositions().subscribe(data => {
      this.positions = data;
      console.log(this.positions);
    });
    this.employeeService.getAdminLogin().subscribe(data => {
      this.adminLogin = data;
      console.log(this.adminLogin);
    })
    console.log(this.birthDate);
  }

  save() {
    if (this.adminLogin.admin.adminId === '' || this.select.titleSelect === '' || this.select.degreeSelect === '' || this.select.positionSelect === '' ||  this.firstName === '' || this.lastName === '' || this.phone === '' || this.email === '' || this.address === '') {
      alert('กรุณากรอกข้อมูลให้ครบถ้วน');
    } else {
      this.httpClient.post('http://localhost:8080/employee/register/' + this.adminLogin.admin.adminId + '/' + this.select.titleSelect + '/' + this.select.degreeSelect + '/' + this.select.positionSelect + '/'+ this.id + '/' + this.firstName + '/' + this.lastName + '/' + this.phone + '/' + this.email + '/' + this.address + '/' + this.birthDate,this.select)
      .subscribe(
          data => {
              console.log('PUT Request is successful', data);
              this.router.navigate(['empinfo'])
          },
          error => {
              console.log('Error', error);
          }
      );
    }
  }

}
