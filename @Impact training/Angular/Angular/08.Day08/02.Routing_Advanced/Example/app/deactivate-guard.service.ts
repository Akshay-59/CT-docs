import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanDeactivate, RouterStateSnapshot } from '@angular/router';
import { ModelFormsComponent } from './model-forms/model-forms.component';

@Injectable({
  providedIn: 'root'
})
export class DeactivateGuardService implements CanDeactivate<ModelFormsComponent> {

  constructor() { }

  canDeactivate(component:ModelFormsComponent,
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot,
    nextState: RouterStateSnapshot) : boolean {

    // canExit() is user defined method defined in ModelFormsComponent class
    return component.canExit();
}

}
