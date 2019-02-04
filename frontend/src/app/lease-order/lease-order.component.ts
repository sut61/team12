import { Component, OnInit } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { LeaseService } from '../service/lease.service';
import { Router } from "@angular/router";
import { ActivatedRoute } from "@angular/router";
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { AdminService } from '../service/admin.service';

@Component({
  selector: 'app-lease-order',
  templateUrl: './lease-order.component.html',
  styleUrls: ['./lease-order.component.css']
})
export class LeaseOrderComponent implements OnInit {

  admins: Array<any>
  members: Array<any>
  accessorys: Array<any>
  durations: Array<any>
  

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
    memberSelect: '',
    accessorySelect: '',
    durationSelect: ''
  }
  data: any={}

  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches)
    );

  constructor(private breakpointObserver: BreakpointObserver,private route:ActivatedRoute,private leaseService: LeaseService , private httpClient: HttpClient, private router:Router, private adminService: AdminService) { }

  ngOnInit() {
    // this.leaseService.getAdmins().subscribe(data => {
    //   this.admins = data;
    //   console.log(this.admins);
    // })
    this.leaseService.getMember().subscribe(data => {
      this.members = data;
      console.log(this.members);
    })
    this.leaseService.getAccessory().subscribe(data => {
      this.accessorys = data;
      console.log(this.accessorys);
    })
    this.leaseService.getDuration().subscribe(data => {
      this.durations = data;
      console.log(this.durations);
    })
    this.leaseService.getAdminLogin().subscribe(data => {
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
    if (this.adminLogin.admin.adminId === '' || this.select.memberSelect === '' || this.select.accessorySelect === '' || this.select.durationSelect === '' ) {
      alert('กรุณากรอกข้อมูลให้ครบถ้วน');
    } else {
      this.httpClient.post('http://localhost:8080/lease/' + this.adminLogin.admin.adminId + '/' + this.select.memberSelect + '/' + this.select.accessorySelect + '/' + this.select.durationSelect,this.select)
      .subscribe(
          data => {
              console.log('PUT Request is successful', data);
              this.router.navigate(['leaseshow'])
          },
          error => {
              console.log('Error', error);
          }
      );
    }
  }

}
