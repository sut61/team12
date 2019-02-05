import { Component, OnInit } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Router } from "@angular/router";
import { ActivatedRoute } from "@angular/router";
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { LockerService } from '../service/locker.service';
import { AdminService } from '../service/admin.service';


@Component({
  selector: 'app-locker-order',
  templateUrl: './locker-order.component.html',
  styleUrls: ['./locker-order.component.css']
})
export class LockerOrderComponent implements OnInit {


  members: Array<any>
  Lockers: Array<any>
  LockerDurations: Array<any>
  note: string;

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
    memberSelect:'',
    LockerSelect:'',
    LockerDurationSelect:''
  }

  date: Date



  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
  .pipe(
    map(result => result.matches)
  );

  constructor(private breakpointObserver: BreakpointObserver,private route:ActivatedRoute,private lockerService: LockerService , private httpClient: HttpClient, private router:Router, private adminService: AdminService) { }

  ngOnInit() {
    this.lockerService.getMembers().subscribe(data => {
      this.members = data;
      console.log(this.members);
    });
    this.lockerService.getLockers().subscribe(data => {
      this.Lockers = data;
      console.log(this.Lockers);
    });
    this.lockerService.getLockerDuration().subscribe(data => {
      this.LockerDurations = data;
      console.log(this.LockerDurations);
    });
    this.lockerService.getAdminLogin().subscribe(data => {
      this.adminLogin = data;
      console.log(this.adminLogin);
    });
    this.adminService.getAdminLogin().subscribe(data => {
      this.adminLogin = data;
      this.adminId = data.admin.adminId;
      this.adminName = data.admin.name;
    });
  }



  save() {
    if (this.adminLogin.admin.adminId === '' || this.select.memberSelect === '' || this.select.LockerSelect === '' || this.select.LockerDurationSelect === '' || this.note === '' ) {
      alert('กรุณากรอกข้อมูลให้ครบถ้วน');
    } else {
      this.httpClient.post('http://localhost:8080/lockerOrder/' + this.adminLogin.admin.adminId + '/' + this.select.memberSelect + '/' + this.select.LockerSelect + '/' + this.select.LockerDurationSelect + '/' + this.note + '/' + this.date,this.select)
      .subscribe(
          data => {
              console.log('PUT Request is successful', data);
              this.router.navigate(['locker-view'])
          },
          error => {
              console.log('Error', error);
          }
      );
    }
 }





  


}
