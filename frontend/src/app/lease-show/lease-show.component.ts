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
  selector: 'app-lease-show',
  templateUrl: './lease-show.component.html',
  styleUrls: ['./lease-show.component.css']
})
export class LeaseShowComponent implements OnInit {

  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
  .pipe(
    map(result => result.matches)
  );

  leases: Array<any>
  id
  adminId:any={}
  adminName:any={}

  dataColumns: string[] = ['no', 'name', 'accessory', 'duration','note','edit','delete'];

  constructor(private breakpointObserver: BreakpointObserver, private leaseService: LeaseService , private httpClient: HttpClient, private adminService: AdminService) { }

  ngOnInit() {
    this.leaseService.getLease().subscribe(data => {
      this.leases = data;
      console.log(this.leases);
    });
    this.adminService.getAdminLogin().subscribe(data => {
      this.adminId = data.admin.adminId;
      this.adminName = data.admin.name;
    });

  }

  editLease(){
    // this.employeeService.editEmployee();
  }
  deleteLease(){
    this.leaseService.deleteLease(this.id);
  }

}
