import { CustomHttpInterceptorService } from './custom-http-interceptor.service';
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
import { DirectivesDemoComponent } from './directives-demo/directives-demo.component';
import { DemoComponent } from './demo/demo.component';
import { RxjsDemoComponent } from './rxjs-demo/rxjs-demo.component';

import {HttpClientModule, HTTP_INTERCEPTORS} from '@angular/common/http';
import { StudentsListComponent } from './students-list/students-list.component';

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
    FilterPipe,
    DirectivesDemoComponent,
    DemoComponent,
    RxjsDemoComponent,
    StudentsListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    AdminModule,
    HttpClientModule
  ],
  providers: [
     {provide : HTTP_INTERCEPTORS, useClass: CustomHttpInterceptorService, multi:true}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
