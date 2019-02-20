import { Component, OnInit } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Router } from "@angular/router";
import { ActivatedRoute } from "@angular/router";
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { RoomService } from '../service/room.service';
import { AdminService } from '../service/admin.service';

@Component({
  selector: 'app-room-cancel',
  templateUrl: './room-cancel.component.html',
  styleUrls: ['./room-cancel.component.css']
})

export class RoomCancelComponent implements OnInit {
  roomOrders: Array<any>
  admins: Array<any>
  roomStatus: Array<any>

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
    roomOrderSelect:''
  }
  roomDate: Date
  note: string
  data:any={}

 isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches)
    );
  constructor(private breakpointObserver: BreakpointObserver,private route:ActivatedRoute,private roomService: RoomService , private httpClient: HttpClient, private router:Router, private adminService: AdminService) { }

  ngOnInit() {
    // this.roomService.getAdmins().subscribe(data => {
    //   this.admins = data;
    //   console.log(this.admins);
    // });
    this.roomService.getRoomOrder().subscribe(data => {
      this.roomOrders = data;
      console.log(this.roomOrders);
    });
    this.roomService.getAdminLogin().subscribe(data => {
      this.adminLogin = data;
      console.log(this.adminLogin);
    });
    this.roomService.getStatus1().subscribe(data => {
      this.roomStatus = data;
      console.log("room status: ",this.roomStatus);
    });
    this.adminService.getAdminLogin().subscribe(data => {
      this.adminLogin = data;
      this.adminId = data.admin.adminId;
      this.adminName = data.admin.name;
    });
  }
  save() {
    if (this.adminLogin.admin.adminId == null || this.select.roomOrderSelect == null || this.note == null) {
      alert('กรุณากรอกข้อมูลให้ครบถ้วน');
        } else {
      this.httpClient.post('http://localhost:8080/roomCancel/' + this.select.roomOrderSelect + '/' + this.note + '/' + this.adminLogin.admin.adminId , this.select)
      .subscribe(
          data => {
              console.log('PUT Request is successful', data);
              this.router.navigate(['roomshow'])
          },
          error => {
              console.log('Error', error);
          }
      );
    }
  }

}
