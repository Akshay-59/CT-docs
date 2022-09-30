import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent
{
   uid:string = "";
   pwd:string = "";
   result:string = "";
   count:number = 0;
   isDisabled:boolean = false;

   public login_click():void
   {
      if(this.uid == "admin" && this.pwd == "admin123")
      {
        this.result ="Welcome to Admin!";
      }
      else
      {
        this.count++;
        this.result = "Invalid username or password!"
        if(this.count == 3)
        {
          this.isDisabled = true;
        }
      }
   }
}
