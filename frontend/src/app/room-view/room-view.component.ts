import { Component, OnInit } from '@angular/core';
import { RoomService } from '../service/room.service';
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-room-view',
  templateUrl: './room-view.component.html',
  styleUrls: ['./room-view.component.css']
})
export class RoomViewComponent implements OnInit {
  orders: Array<any>



  dataColumns: string[] = ['no'
  // , 'admin', 'member'
  // , 'room','roomDuration','date'
];

  constructor(private breakpointObserver: BreakpointObserver,private roomService: RoomService , private httpClient: HttpClient) { }

  ngOnInit() {

    this.roomService.getRoomOrder().subscribe(data => {
      this.orders = data;
      console.log(this.orders);
    });

  }

}
