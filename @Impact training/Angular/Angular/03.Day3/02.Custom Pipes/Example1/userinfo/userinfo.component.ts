import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-userinfo',
  templateUrl: './userinfo.component.html',
  styleUrls: ['./userinfo.component.css']
})
export class UserinfoComponent   {

  public userObj1:any = {uname:"Scott", gender: "M"};
  public userObj2:any = {uname:"Nancy", gender: "F"};

  public usersArray:any[]  =
  [
    {uname  :  "Smith",  gender:  "M"},
    {uname  :  "Scott",  gender:  "m"},
    {uname  :  "Nancy",  gender:  "F"},
    {uname  :  "Ruth",  gender:  "f"},
  ];

}
