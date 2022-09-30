import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { EmpListComponent } from './emp-list/emp-list.component';
import { DataService } from './data.service';
import { DemoComponent } from './demo/demo.component';

import {HttpClientModule, HTTP_INTERCEPTORS} from '@angular/common/http';
import { ModelFormsComponent } from './model-forms/model-forms.component';
import { HomeComponent } from './home/home.component';
import { EmpDetailsComponent } from './emp-details/emp-details.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MymaterialModule } from './mymaterial/mymaterial.module';

@NgModule({
  declarations: [
    AppComponent,    LoginComponent,

    EmpListComponent,

    DemoComponent,

    ModelFormsComponent,

    HomeComponent,
    EmpDetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MymaterialModule
  ],
  providers: [
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
