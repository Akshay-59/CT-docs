import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-depts',
  templateUrl: './depts.component.html',
  styleUrls: ['./depts.component.css']
})
export class DeptsComponent
{
	public depts:any =  [
	{deptno : 30,  dname : "Marketing", loc : "Hyd"},
	{deptno : 40,  dname : "Testing", loc : "Pune"},
  {deptno : 50,  dname : "Sales", loc : "Hyd"},
	{deptno : 60,  dname : "Accounts", loc : "Pune"},
	{deptno : 70,  dname : "Marketing", loc : "Hyd"},
	{deptno : 80,  dname : "Testing", loc : "Pune"},
  {deptno : 10,  dname : "Sales", loc : "Hyd"},
  {deptno : 20,  dname : "Accounts", loc : "Pune"},
	];

	public  removeDept(dno: number)
	{
		 var index =  this.depts.findIndex((x:any) => x.deptno == dno);
		 this.depts.splice(index, 1);
	}
}
