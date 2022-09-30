import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DeptListComponent } from './dept-list/dept-list.component';
import { EmpDetailsComponent } from './emp-details/emp-details.component';
import { EmpListComponent } from './emp-list/emp-list.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';

const routes: Routes = [
  { path : "", component: HomeComponent  },
  { path : "Emps", component: EmpListComponent, canActivate : []  },
  { path : "Depts", component: DeptListComponent  },
  { path : "Login", component: LoginComponent },
  { path : "Details/:id", component: EmpDetailsComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
