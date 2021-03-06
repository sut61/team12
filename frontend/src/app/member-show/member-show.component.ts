import { Component, OnInit } from '@angular/core';
import {animate, state, style, transition, trigger} from '@angular/animations';
import { MemberService } from '../service/member.service';
import { Router } from "@angular/router";
import { ActivatedRoute } from "@angular/router";
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { ACTIVE_INDEX } from '@angular/core/src/render3/interfaces/container';
import { HttpClient } from '@angular/common/http';
import { AdminService } from '../service/admin.service';

@Component({
  selector: 'app-member-show',
  templateUrl: './member-show.component.html',
  styleUrls: ['./member-show.component.css'],
  animations: [
    trigger('detailExpand', [
      state('collapsed', style({height: '0px', minHeight: '0', display: 'none'})),
      state('expanded', style({height: '*'})),
      transition('expanded <=> collapsed', animate('225ms cubic-bezier(0.4, 0.0, 0.2, 1)')),
    ]),
  ],
})


export class MemberShowComponent implements OnInit {

  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
  .pipe(
    map(result => result.matches)
  );

  members: Array<any>
  adminId:any={}
  adminName:any={}
  
  dataColumns: string[] = ['memberId', 'firstName', 'lastName'];


  constructor(private breakpointObserver: BreakpointObserver, private memberService: MemberService , private httpClient: HttpClient, private adminService: AdminService) { }

  ngOnInit() {
    this.memberService.getMembers().subscribe(data => {
      this.members = data;
      console.log(this.members);
    });
    this.adminService.getAdminLogin().subscribe(data => {
      this.adminId = data.admin.adminId;
      this.adminName = data.admin.name;
    });

  }

}
