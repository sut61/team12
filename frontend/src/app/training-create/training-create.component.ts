import { Component ,OnInit} from '@angular/core';
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Router } from "@angular/router";
import { ActivatedRoute } from "@angular/router";
import { HttpClient} from '@angular/common/http';
import { EmployeeService } from '../service/employee.service';
import { AdminService } from '../service/admin.service';

@Component({
  selector: 'app-training-create',
  templateUrl: './training-create.component.html',
  styleUrls: ['./training-create.component.css']
})
export class TrainingCreateComponent implements OnInit {

  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
  .pipe(
    map(result => result.matches)
  );

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

  types: Array<any>
  programs: Array<any>

  select: any = {
    typeSelect:'',
    programSelect:''
  }

  title: string
  description: string
  instructor: string
  location: string
  enrollment: number
  cost: number
  dateFrom: Date
  dateTo: Date




  constructor(private breakpointObserver: BreakpointObserver, private route:ActivatedRoute, private employeeService: EmployeeService , private httpClient: HttpClient, private router:Router, private adminService: AdminService) {
  }

  ngOnInit() {
    this.employeeService.getTrainingType().subscribe(data => {
      this.types = data;
    })
    this.employeeService.getTrainingProgram().subscribe(data => {
      this.programs = data;
    })
    this.adminService.getAdminLogin().subscribe(data => {
      this.adminLogin = data;
      this.adminId = data.admin.adminId;
      this.adminName = data.admin.name;
    })
  }

  save() {
    if (this.adminLogin.admin.adminId === '' || this.title === '' || this.description === '' ||  this.dateFrom === null || this.dateTo === null || this.select.typeSelect === '' || this.select.programSelect === '' || this.instructor === '' || this.location === '' || this.enrollment === null || this.cost === null) {
      alert('กรุณากรอกข้อมูลให้ครบถ้วน');
    } else {
      this.httpClient.post('http://localhost:8080/training/create/' + this.adminLogin.admin.adminId + '/' + this.title + '/' + this.description + '/' + this.dateFrom + '/'+ this.dateTo + '/' + this.select.typeSelect + '/' + this.select.programSelect + '/' + this.instructor + '/' + this.location + '/' + this.enrollment + '/' + this.cost,this.select)
      .subscribe(
          data => {
              console.log('PUT Request is successful', data);
              this.router.navigate(['training-view'])
          },
          error => {
              console.log('Error', error);
          }
      );
    }
  }

}
