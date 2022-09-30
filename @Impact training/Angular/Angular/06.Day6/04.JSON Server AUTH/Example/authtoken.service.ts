import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthtokenService {


  constructor(private httpObj: HttpClient) {

  }

  getTokenForValidUser(uid:string, pwd:string) : Observable<any>
  {
    let userObj:any = { "email": uid,   "password": pwd  };
    let authUrl:string  = "http://localhost:3500/login";
    return this.httpObj.post(authUrl, userObj);
  }

}
