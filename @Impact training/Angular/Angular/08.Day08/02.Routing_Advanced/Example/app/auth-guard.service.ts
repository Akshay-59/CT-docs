import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthGuardService implements CanActivate
{
  constructor(private _router: Router) { }

  canActivate(next: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {

    if( sessionStorage.getItem("AUTH_TOKEN") == null)
    {
      // alert("Message from AuthGuardService -- without Token");
      // alert(state.url);
      this._router.navigate(['/Login'], { queryParams : {  returnUrl : state.url }});
      return false;
    }
    else
    {
      // alert("Message from AuthGuardService -- With Token");
      return true;
    }
  }
}
