import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuardService } from './auth-guard.service';
import { DeactivateGuardService } from './deactivate-guard.service';
import { DemoComponent } from './demo/demo.component';
import { DeptListComponent } from './dept-list/dept-list.component';
import { EmpDetailsComponent } from './emp-details/emp-details.component';
import { EmpListResolverService } from './emp-list-resolver.service';
import { EmpListComponent } from './emp-list/emp-list.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { ModelFormsComponent } from './model-forms/model-forms.component';

const routes: Routes = [
  { path : "", component: HomeComponent  },
  { path : "Emps", component: EmpListComponent, resolve: {empsData: EmpListResolverService}  },
  { path : "Depts", component: DeptListComponent, canActivate : [AuthGuardService]  },
  { path : "Login", component: LoginComponent },
  { path : "MaterailDemo", component: DemoComponent },
  { path : "Register", component: ModelFormsComponent, canDeactivate : [DeactivateGuardService]},
  { path : "Details/:id", component: EmpDetailsComponent },
  { path: 'admin', loadChildren: () => import('./admin/admin.module').then(m => m.AdminModule) },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
