import { Component, OnInit } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { EmployeeService } from '../service/employee.service';
import { Router } from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  admin: any ={
    username:'',
    password:''
  }

  data: any ={
    id:'',
    name:'',
    username:'',
    password:''
  }

  adminData: any ={
    id:'',
    name:'',
    username:'',
    password:''
  }

  check:any =''

  constructor(private employeeService: EmployeeService , private httpClient: HttpClient, private router:Router) { }

  ngOnInit() {
    
  }

  getAdminDetail(){
    this.employeeService.getAdminDetail(this.admin.username).subscribe(data => {
      this.adminData = data;
      console.log(this.adminData);
    });
  }

  login(){
    if (this.admin.username === '' || this.admin.password === '') {
      alert('กรุณากรอกข้อมูลให้ครบถ้วน');
    } else {
      this.httpClient.get('http://localhost:8080/admin/' + this.admin.username + '/' + this.admin.password,this.admin)
      .subscribe(
        data =>   {
          this.check = data;
          console.log('PUT Request is successful', data);
          if (this.check === true) {
            // this.httpClient.post('http://localhost:8080/admin/login/' + this.admin.username, this.admin)
            // .subscribe(data => {
            //   console.log(data)
            // })
            //  alert('login sucessful');
            this.router.navigate(['nav'])

            // this.router.navigate(['nav',{
            //   id: this.data.id = this.adminData.adminId,
            //   name: this.data.name = this.adminData.name,
            //   username: this.data.username = this.adminData.username,
            //   password: this.data.password = this.adminData.password
            //   }]);
              
          }else {
            console.log('else : ', data);
            alert('username หรือ password ของท่านไม่ถูกต้อง กรุณา login ใหม่');
          }
        },
        error =>  {
          console.log('Error', error);
          alert('username หรือ password ของท่านไม่ถูกต้อง กรุณา login ใหม่'); 
        }
      );
    }

  }

}
