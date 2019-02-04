import { Component, OnInit } from '@angular/core';
import { RoomService } from '../service/room.service';
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { HttpClient } from '@angular/common/http';
import { AdminService } from '../service/admin.service';

@Component({
  selector: 'app-room-view',
  templateUrl: './room-view.component.html',
  styleUrls: ['./room-view.component.css']
})
export class RoomViewComponent implements OnInit {
  orders: Array<any>

  adminId:any={}
  adminName:any={}
  dataColumns: string[] = ['no'
  // , 'admin', 'member'
  // , 'room','roomDuration','date'
];

  constructor(private breakpointObserver: BreakpointObserver,private roomService: RoomService , private httpClient: HttpClient, private adminService: AdminService) { }

  ngOnInit() {

    this.roomService.getRoomOrder().subscribe(data => {
      this.orders = data;
      console.log(this.orders);
    });
    this.adminService.getAdminLogin().subscribe(data => {
      this.adminId = data.admin.adminId;
      this.adminName = data.admin.name;
    });

  }

}
