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

export interface Member {
  memberId;
  Priviledge:{}
  Title:{}
  firstName;
  lastName;
  age;
  birthDate;
  phoneNumber;
  email;
  address;
  subDistric;
  distric;
  Province:{}
  Admin:{
  }
}

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
  
  member = {} as Member;

  dataColumns: string[] = ['memberId', 'firstName', 'lastName'];


  constructor(private breakpointObserver: BreakpointObserver, private memberService: MemberService , private httpClient: HttpClient) { }

  ngOnInit() {
    this.memberService.getMembers().subscribe(data => {
      this.members = data;
      this.member = data[1];
      console.log(this.members);
      console.log(this.member)
    });

  }
  onClickDelete(element){
    // this.memberService.remove(element.memberId).subscribe(result => {
    //   this.members.splice(this.members.indexOf(element),1)
    //   console.log("Deleted!!")
    // }, error => console.error(error));
  }
}
