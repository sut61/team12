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
  selector: 'app-room-create',
  templateUrl: './room-create.component.html',
  styleUrls: ['./room-create.component.css']
})

export class RoomCreateComponent implements OnInit {
  members: Array<any>
  rooms: Array<any>
  roomDurations: Array<any>
  admins:Array<any>

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
    roomSelect:'',
    roomDurationSelect:'',
    adminSelect:''
  }
  roomDate: Date
  id: string
  notee: string
  data:any={}

 isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches)
    );
  constructor(private breakpointObserver: BreakpointObserver,private route:ActivatedRoute,private roomService: RoomService , private httpClient: HttpClient, private router:Router, private adminService: AdminService) { }

  ngOnInit() {
    this.roomService.getMember().subscribe(data => {
      this.members = data;
      console.log(this.members);
    });
    this.roomService.getRoom().subscribe(data => {
      this.rooms = data;
      console.log(this.rooms);
    });
    this.roomService.getRoomDuration().subscribe(data => {
      this.roomDurations = data;
      console.log(this.roomDurations);
    });
    this.roomService.getAdminLogin().subscribe(data => {
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
    if (this.adminLogin.admin.adminId == null || this.select.memberSelect == null || this.select.roomSelect == null || this.select.roomDurationSelect == null || this.notee == null) {
      alert('กรุณากรอกข้อมูลให้ครบถ้วน');
    } else {
      this.httpClient.post('http://localhost:8080/roomOrders/' + this.adminLogin.admin.adminId + '/' + this.select.memberSelect + '/' + this.select.roomSelect + '/' + this.select.roomDurationSelect + '/' + this.roomDate + '/' + this.notee , this.select)
      .subscribe(
          data => {
              console.log('PUT Request is successful', data);
              this.router.navigate(['roomview'])
          },
          error => {
              console.log('Error', error);
          }
      );
    }
  }

}
