import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-student-info',
  templateUrl: './student-info.component.html',
  styleUrls: ['./student-info.component.css']
})
export class StudentInfoComponent{
  public sid:number  = 4654565;
  public sname:string  =  "narasimha RAO";
  public email:string  =  "tnRao.Trainer@Gmail.com";
  public course:string  =  "angUlAr";
  public fee:number  =   5000;
  public joinDate:Date  =   new Date();
  // public joinDate:Date  =   new Date("10/23/2020");
  //  public joinDate:Date  =   new Date(2020, 9, 15);




}
