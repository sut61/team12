import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from "@angular/router";
import { HttpClient} from '@angular/common/http';
import { EmployeeService } from '../service/employee.service';
import { Router } from "@angular/router";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  data:any={}

  data1:any={}

  constructor(private route:ActivatedRoute, private employeeService: EmployeeService , private httpClient: HttpClient, private router:Router) { }

  ngOnInit() {
    this.route.params.subscribe(prams=>{
      this.data = prams
      console.log(prams)
    });
    
    
  }

  register(){
    this.router.navigate(['empreg',{
      id: this.data1.id = this.data.id,
      name: this.data1.name = this.data.name,
      username: this.data1.username = this.data.username,
      password: this.data1.password = this.data.password
      }]);
  }

}
