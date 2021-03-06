import { BrowserModule } from '@angular/platform-browser';
import { NgModule, Component } from '@angular/core';

import { FormsModule } from '@angular/forms';
import { CommonModule} from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule, Routes} from '@angular/router';

import { FlatpickrModule } from 'angularx-flatpickr';
import { CalendarModule, DateAdapter } from 'angular-calendar';
import { adapterFactory } from 'angular-calendar/date-adapters/date-fns';
import { NgbModalModule } from '@ng-bootstrap/ng-bootstrap';


import { AppComponent } from './app.component';




import {
  MatAutocompleteModule,
  MatBadgeModule,
  MatBottomSheetModule,
  MatButtonModule,
  MatButtonToggleModule,
  MatCardModule,
  MatCheckboxModule,
  MatChipsModule,
  MatDatepickerModule,
  MatDialogModule,
  MatDividerModule,
  MatExpansionModule,
  MatGridListModule,
  MatIconModule,
  MatInputModule,
  MatListModule,
  MatMenuModule,
  MatNativeDateModule,
  MatPaginatorModule,
  MatProgressBarModule,
  MatProgressSpinnerModule,
  MatRadioModule,
  MatRippleModule,
  MatSelectModule,
  MatSidenavModule,
  MatSliderModule,
  MatSlideToggleModule,
  MatSnackBarModule,
  MatSortModule,
  MatStepperModule,
  MatTableModule,
  MatTabsModule,
  MatToolbarModule,
  MatTooltipModule,
  MatTreeModule,
} from '@angular/material';

import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { EmployeeRegisterComponent } from './employee-register/employee-register.component';
import { EmployeeInfoComponent } from './employee-info/employee-info.component';
import { EmployeeManageComponent } from './employee-manage/employee-manage.component';
import { MainNavComponent } from './main-nav/main-nav.component';
import { LayoutModule } from '@angular/cdk/layout';
import { LeaseOrderComponent } from './lease-order/lease-order.component';
import { LeaseShowComponent } from './lease-show/lease-show.component';
import { MemberShowComponent } from './member-show/member-show.component';
import { RoomCreateComponent } from './room-create/room-create.component';
import { RoomViewComponent } from './room-view/room-view.component';
import { FieldOrderComponent } from './field-order/field-order.component';
import { FieldViewComponent } from './field-view/field-view.component';
import { MemberRegisterComponent } from './member-register/member-register.component';
import { TrainingCreateComponent } from './training-create/training-create.component';
import { TrainingViewComponent } from './training-view/training-view.component';
import { TicketComponent } from './ticket/ticket.component';
import { TicketShowComponent } from './ticket-show/ticket-show.component';
// <<<<<<< HEAD
import { LockerOrderComponent } from './locker-order/locker-order.component';
import { LockerViewComponent } from './locker-view/locker-view.component';
// =======
import { NotificationComponent } from './notification/notification.component';
import { NotificationShowComponent } from './notification-show/notification-show.component';
import { RoomCancelComponent } from './room-cancel/room-cancel.component';
import { RoomShowComponent } from './room-show/room-show.component';
// >>>>>>> fc6597251952134c48376ec5eae5af8d988a836d

const routes: Routes = [
  {path: '', redirectTo: '/login', pathMatch:'full'},
  {path: 'home',component: HomeComponent},
  {path: 'login',component: LoginComponent},
  {path: 'empinfo',component: EmployeeInfoComponent},
  {path: 'empreg',component: EmployeeRegisterComponent},
  {path: 'empmanage',component: EmployeeManageComponent},
  {path: 'nav',component: MainNavComponent},
  {path: 'lease',component: LeaseOrderComponent},
  {path: 'leaseshow',component: LeaseShowComponent},
  {path: 'member-register',component: MemberRegisterComponent},
  {path: 'member-show',component: MemberShowComponent},
  {path: 'roomcreate',component: RoomCreateComponent},
  {path: 'roomview',component: RoomViewComponent},
  {path: 'field-order',component: FieldOrderComponent},
  {path: 'field-view',component: FieldViewComponent},
  {path: 'training-create',component: TrainingCreateComponent},
  {path: 'training-view',component: TrainingViewComponent},
  {path: 'ticket',component: TicketComponent},
  {path: 'ticket-show',component: TicketShowComponent},
// <<<<<<< HEAD
  {path: 'locker-order',component: LockerOrderComponent},
  {path: 'locker-view',component: LockerViewComponent},
// =======
  {path: 'notification',component: NotificationComponent},
  {path: 'notification-show',component: NotificationShowComponent},
// >>>>>>> fc6597251952134c48376ec5eae5af8d988a836d
{path: 'roomcancel',component: RoomCancelComponent},
  {path: 'roomshow',component: RoomShowComponent}
]

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    EmployeeRegisterComponent,
    EmployeeInfoComponent,
    EmployeeManageComponent,
    MainNavComponent,
    LeaseOrderComponent,
    LeaseShowComponent,
    MemberRegisterComponent,
    MemberShowComponent,
    RoomCreateComponent,
    RoomViewComponent,
    FieldOrderComponent,
    FieldViewComponent,
    TrainingCreateComponent,
    TrainingViewComponent,
    TicketComponent,
    TicketShowComponent,
// <<<<<<< HEAD
    LockerOrderComponent,
    LockerViewComponent,
// =======
    NotificationComponent,
    NotificationShowComponent,
    RoomCancelComponent,
    RoomShowComponent
// >>>>>>> fc6597251952134c48376ec5eae5af8d988a836d
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    CommonModule,
    RouterModule.forRoot(routes),
    MatAutocompleteModule,
    MatBadgeModule,
    MatBottomSheetModule,
    MatButtonModule,
    MatButtonToggleModule,
    MatCardModule,
    MatCheckboxModule,
    MatChipsModule,
    MatDatepickerModule,
    MatDialogModule,
    MatDividerModule,
    MatExpansionModule,
    MatGridListModule,
    MatIconModule,
    MatInputModule,
    MatListModule,
    MatMenuModule,
    MatNativeDateModule,
    MatPaginatorModule,
    MatProgressBarModule,
    MatProgressSpinnerModule,
    MatRadioModule,
    MatRippleModule,
    MatSelectModule,
    MatSidenavModule,
    MatSliderModule,
    MatSlideToggleModule,
    MatSnackBarModule,
    MatSortModule,
    MatStepperModule,
    MatTableModule,
    MatTabsModule,
    MatToolbarModule,
    MatTooltipModule,
    MatTreeModule,
    LayoutModule,
    NgbModalModule,
    FlatpickrModule.forRoot(),
    CalendarModule.forRoot({
      provide: DateAdapter,
      useFactory: adapterFactory
    })
  ],
  
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
