import { Component, OnInit } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { NotificationService } from '../service/notification.service';
import { Router } from "@angular/router";
import { ActivatedRoute } from "@angular/router";
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { AdminService } from '../service/admin.service';

@Component({
  selector: 'app-notification-show',
  templateUrl: './notification-show.component.html',
  styleUrls: ['./notification-show.component.css']
})
export class NotificationShowComponent implements OnInit {

  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
  .pipe(
    map(result => result.matches)
  );

  notifications: Array<any>
  adminId:any={}
  adminName:any={}

  dataColumns: string[] = ['no', 'name', 'fields','note'];

  constructor(private breakpointObserver: BreakpointObserver, private notificationService: NotificationService , private httpClient: HttpClient, private adminService: AdminService) { }

  ngOnInit() {
    this.notificationService.getNotification().subscribe(data => {
      this.notifications = data;
      console.log(this.notifications);
    });
    this.adminService.getAdminLogin().subscribe(data => {
      this.adminId = data.admin.adminId;
      this.adminName = data.admin.name;
    });
  }

}
