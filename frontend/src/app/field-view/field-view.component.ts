import { Component, OnInit } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Router } from "@angular/router";
import { ActivatedRoute } from "@angular/router";
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { FieldService } from '../service/field.service';
import { AdminService } from '../service/admin.service';

@Component({
  selector: 'app-field-view',
  templateUrl: './field-view.component.html',
  styleUrls: ['./field-view.component.css']
})
export class FieldViewComponent implements OnInit {

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



  dataColumns: string[] = ['no', 'admin', 'member', 'field','duration','date','note'];

  constructor(private breakpointObserver: BreakpointObserver,private route:ActivatedRoute,private fieldService: FieldService , private httpClient: HttpClient, private router:Router, private adminService: AdminService) { }

  ngOnInit() {

    this.fieldService.getFieldOrder().subscribe(data => {
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
