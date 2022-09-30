import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-userinfo',
  templateUrl: './userinfo.component.html',
  styleUrls: ['./userinfo.component.css']
})
export class UserinfoComponent implements OnInit {

  public uname:string  = "Scott";
  public email:string  = "scott@gmail.com";
  public age:number  = 25;
  public isValidUser:boolean = true;

  constructor() { }

  ngOnInit(): void {
  }

}
