import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent
{
   uid:string = "admin";
   pwd:string = "admin123";
   result:string = "";

   constructor(private _router: Router, private _route: ActivatedRoute) { }



   public login_click():void
   {
     let url:string = this._route.snapshot.queryParams["returnUrl"];

     if(url == undefined)
     {
        url  = "/";
     }

      if(this.uid == "admin"  &&  this.pwd  == "admin123")
      {
        sessionStorage.setItem("AUTH_TOKEN", this.uid);
        this._router.navigate([url]);
      }
      else
      {
        this.result = "Invalid user id or password.";
      }
   }
}
