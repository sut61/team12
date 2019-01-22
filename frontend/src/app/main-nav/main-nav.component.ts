import { Component ,OnInit} from '@angular/core';
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
// import { ObservableMedia, MediaChange } from '@angular/flex-layout';
// import { Subscription } from 'rxjs';
import { ActivatedRoute } from "@angular/router";
import { HttpClient} from '@angular/common/http';
import { EmployeeService } from '../service/employee.service';
import { Router } from "@angular/router";

export interface adminLogin {
  loginId:1
  admin:{
    adminId:'',
    name:'',
    username:'',
    password:''
  }
} 

@Component({
  selector: 'app-main-nav',
  templateUrl: './main-nav.component.html',
  styleUrls: ['./main-nav.component.css']
})
export class MainNavComponent {

  data:any={}

  data1:any={}

  // adminLogin: Observable<any>;
  // adminLogin = {} as adminLogin;
  adminLogin: Array<any>

  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches)
    );


  constructor(private breakpointObserver: BreakpointObserver, private route:ActivatedRoute, private employeeService: EmployeeService , private httpClient: HttpClient, private router:Router) {
  }

  ngOnInit() {
    // this.route.params.subscribe(prams=>{
    //   this.data = prams
    //   console.log(prams)
    // });
    this.employeeService.getAdminLogin().subscribe(data => {
      this.adminLogin = data;
      // console.log(this.adminLogin);
    })
    
    
  }

  // register(){
  //   this.router.navigate(['empreg',{
  //     id: this.data1.id = this.data.id,
  //     name: this.data1.name = this.data.name,
  //     username: this.data1.username = this.data.username,
  //     password: this.data1.password = this.data.password
  //     }]);
  // }

}
