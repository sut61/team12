import { Component, OnInit } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { EmployeeService } from '../service/employee.service';
import { Router } from "@angular/router";
import { ActivatedRoute } from "@angular/router";
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { FieldService } from '../service/field.service';

@Component({
  selector: 'app-field-order',
  templateUrl: './field-order.component.html',
  styleUrls: ['./field-order.component.css']
})
export class FieldOrderComponent implements OnInit {

  members: Array<any>
  fields: Array<any>
  durations: Array<any>


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
    memberSelect:'',
    fieldSelect:'',
    durationSelect:''
  }

  date: Date



  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
  .pipe(
    map(result => result.matches)
  );

  constructor(private breakpointObserver: BreakpointObserver,private route:ActivatedRoute,private fieldService: FieldService , private httpClient: HttpClient, private router:Router) { }

  ngOnInit() {

    this.fieldService.getMembers().subscribe(data => {
      this.members = data;
      console.log(this.members);
    });
    this.fieldService.getFields().subscribe(data => {
      this.fields = data;
      console.log(this.fields);
    });
    this.fieldService.getFieldDuration().subscribe(data => {
      this.durations = data;
      console.log(this.durations);
    });
    this.fieldService.getAdminLogin().subscribe(data => {
      this.adminLogin = data;
      console.log(this.adminLogin);
    })
  }


  save() {
    if (this.adminLogin.admin.adminId === '' || this.select.memberSelect === '' || this.select.fieldSelect === '' || this.select.durationSelect === '' ) {
      alert('กรุณากรอกข้อมูลให้ครบถ้วน');
    } else {
      this.httpClient.post('http://localhost:8080/fieldOrder/' + this.adminLogin.admin.adminId + '/' + this.select.memberSelect + '/' + this.select.fieldSelect + '/' + this.select.durationSelect + '/' + this.date,this.select)
      .subscribe(
          data => {
              console.log('PUT Request is successful', data);
              this.router.navigate(['field-view'])
          },
          error => {
              console.log('Error', error);
          }
      );
    }
 }





}
