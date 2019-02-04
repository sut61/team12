import { Component, OnInit } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { EmployeeService } from '../service/employee.service';
import { MemberService } from '../service/member.service';
import { Router } from "@angular/router";
import { ActivatedRoute } from "@angular/router";
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { AdminService } from '../service/admin.service';

@Component({
  selector: 'app-member-register',
  templateUrl: './member-register.component.html',
  styleUrls: ['./member-register.component.css']
})
export class MemberRegisterComponent implements OnInit {

  privileges: Array<any>;
  titles: Array<any>;
  provinces: Array<any>;
  admins: Array<any>;

  firstName: string;
  lastName: string;
  age: number;
  birthDate: Date;
  phoneNumber: string;
  email: string;
  address: string;
  subDistrict: string;
  district: string;

  Members: any = {privilegeSelect: '', titleSelect: '', provinceSelect: '', adminSelect: ''}
  data:any={};


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



  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches)
    );

  constructor(private breakpointObserver: BreakpointObserver,private route:ActivatedRoute,private employeeService: EmployeeService ,private memberService: MemberService, private httpClient: HttpClient, private router:Router, private adminService: AdminService) { }

  ngOnInit() {
    // this.route.params.subscribe(prams=>{
    //   this.data = prams
    //   console.log(prams)
    // });
    this.memberService.getAdmins().subscribe(data => {
      this.admins = data;
      console.log(this.admins);
    });



    this.memberService.getPrivileges().subscribe(data => {
      this.privileges = data;
      console.log(this.privileges);
    });
    this.memberService.getTitles().subscribe(data => {
      this.titles = data;
      console.log(this.titles);
    });
    this.memberService.getProvinces().subscribe(data => {
      this.provinces = data;
      console.log(this.provinces);
    });
    this.memberService.getAdminLogin().subscribe(data => {
      this.adminLogin = data;
      console.log(this.adminLogin);
    });
    this.adminService.getAdminLogin().subscribe(data => {
      this.adminLogin = data;
      this.adminId = data.admin.adminId;
      this.adminName = data.admin.name;
    });
  }

  save() {
    if (this.Members.privilegeSelect === '' || this.Members.titleSelect === '' || this.Members.provinceSelect === '' || this.firstName === '' ||this.lastName === '' || this.phoneNumber === '' || this.email === '' || this.address === '' || this.subDistrict === '' || this.district === '') {
      alert('กรุณากรอกข้อมูลให้ครบถ้วน');
    } else {
      this.httpClient.post('http://localhost:8080/members/register/' + this.Members.privilegeSelect + '/' + this.Members.titleSelect + '/'+ this.firstName + '/'+ this.lastName + '/'+ this.age + '/'+ this.birthDate + '/'+ this.phoneNumber + '/'+ this.email + '/'+ this.address + '/'+ this.subDistrict + '/'+ this.district + '/' + this.Members.provinceSelect+ '/' + this.adminLogin.admin.adminId ,this.Members)
      .subscribe(
          data => {
              console.log('PUT Request is successful', data);
              this.router.navigate(['member-show'])
          },
          error => {
              console.log('Error', error);
          }
      );
    }
  }

}
