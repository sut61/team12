import { Component, OnInit } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { EmployeeService } from '../service/employee.service';
import { Router } from "@angular/router";
import { ActivatedRoute } from "@angular/router";
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { FieldService } from '../service/field.service';


@Component({
  selector: 'app-field-view',
  templateUrl: './field-view.component.html',
  styleUrls: ['./field-view.component.css']
})
export class FieldViewComponent implements OnInit {

  orders: Array<any>



  dataColumns: string[] = ['no', 'admin', 'member', 'field','duration','date'];

  constructor(private breakpointObserver: BreakpointObserver,private route:ActivatedRoute,private fieldService: FieldService , private httpClient: HttpClient, private router:Router) { }

  ngOnInit() {

    this.fieldService.getFieldOrder().subscribe(data => {
      this.orders = data;
      console.log(this.orders);
    });


  }

}
