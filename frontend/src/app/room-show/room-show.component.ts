import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute} from "@angular/router";
import { RoomService } from '../service/room.service';
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { HttpClient } from '@angular/common/http';
import { AdminService } from '../service/admin.service';

@Component({
  selector: 'app-room-show',
  templateUrl: './room-show.component.html',
  styleUrls: ['./room-show.component.css']
})
export class RoomShowComponent implements OnInit {

  orders: Array<any>

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
   dataColumns: string[] = ['no','roomOrder','date','admin','note','status'];

    constructor(private breakpointObserver: BreakpointObserver,private route:ActivatedRoute,private roomService: RoomService , private httpClient: HttpClient, private router:Router, private adminService: AdminService) { }

   ngOnInit() {

    this.roomService. getRoomCancel().subscribe(data => {
      this.orders = data;
      console.log(this.orders);
    });
    this.adminService.getAdminLogin().subscribe(data => {
      this.adminLogin = data;
      this.adminId = data.admin.adminId;
      this.adminName = data.admin.name;
    });

  }

}


