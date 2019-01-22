import { Component } from '@angular/core';
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
// import { ObservableMedia, MediaChange } from '@angular/flex-layout';
// import { Subscription } from 'rxjs';
import { ActivatedRoute } from "@angular/router";
import { HttpClient} from '@angular/common/http';
import { EmployeeService } from './service/employee.service';
import { Router } from "@angular/router";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'frontend';
  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
  .pipe(
    map(result => result.matches)
  );

  constructor(private breakpointObserver: BreakpointObserver, private route:ActivatedRoute, private employeeService: EmployeeService , private httpClient: HttpClient, private router:Router) {
  }
}
