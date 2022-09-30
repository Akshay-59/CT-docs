import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  public uname:string  = "Scott";
  public email:string  = "scott@gmail.com";
  public age:number  = 35
  public isValidUser:boolean = true;
}
