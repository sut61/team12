import { Component, OnInit } from '@angular/core';
import {animate, state, style, transition, trigger} from '@angular/animations';
import { RoomService } from '../service/room.service';
import { Router } from "@angular/router";
import { ActivatedRoute } from "@angular/router";
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { ACTIVE_INDEX } from '@angular/core/src/render3/interfaces/container';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-room-view',
  templateUrl: './room-view.component.html',
  styleUrls: ['./room-view.component.css']
})
export class RoomViewComponent implements OnInit {
 isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches)
    );

    orders: Array<any>
  constructor(private breakpointObserver: BreakpointObserver, private roomService: RoomService , private httpClient: HttpClient) { }

  dataColumns: string[] = ['no', 'admin', 'member', 'room','duretion','date'];

  ngOnInit() {
    this.roomService.getPRoomOrder().subscribe(data => {
      this.orders = data;
      console.log(this.orders)
    });
    
  }

}
