import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { CoursesComponent } from './courses/courses.component';
import { DeptDetailsComponent } from './dept-details/dept-details.component';
import { DeptListComponent } from './dept-list/dept-list.component';
import { UserinfoComponent } from './userinfo/userinfo.component';
import { FormsModule } from '@angular/forms';
import { GreetingComponent } from './greeting/greeting.component';
import { FilterOptionsComponent } from './filter-options/filter-options.component';
import { AdminModule } from './admin/admin.module';
import { StudentInfoComponent } from './student-info/student-info.component';
import { EmpListComponent } from './emp-list/emp-list.component';
import { GenderPipe } from './gender.pipe';
import { FilterPipe } from './filter.pipe';
import { DataService } from './data.service';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    CoursesComponent,
    DeptDetailsComponent,
    DeptListComponent,
    UserinfoComponent,
    GreetingComponent,
    FilterOptionsComponent,
    StudentInfoComponent,
    EmpListComponent,
    GenderPipe,
    FilterPipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    AdminModule
  ],
  providers: [],
  //  providers: [DataService],   // for root level injector registration
  bootstrap: [AppComponent]
})
export class AppModule { }
