import { Component, Input, OnChanges, OnInit } from '@angular/core';
import { Dept } from '../models/dept';

@Component({
  selector: 'app-dept-list',
  templateUrl: './dept-list.component.html',
  styleUrls: ['./dept-list.component.css']
})
export class DeptListComponent implements OnInit, OnChanges {

  @Input() location:string  = "";

  filteredArray:Dept[] = [];

  deptsArray:Dept[] = [
    {deptno : 10, dname : "Accounts",  loc :  "Mumbai"} ,
    {deptno : 20, dname : "Sales",  loc :  "Pune"},
    {deptno : 30, dname : "Marketing",  loc :  "Hyd"},
    {deptno : 40, dname : "Operations",  loc :  "Chennai"},
    {deptno : 50, dname : "Admin",  loc :  "Pune"},
    {deptno : 60, dname : "Finance",  loc :  "Hyd"},
    {deptno : 70, dname : "Testing",  loc :  "Mumbai"},
    {deptno : 80, dname : "IT",  loc :  "Chennai"} ,
    {deptno : 10, dname : "Accounts",  loc :  "Mumbai"} ,
    {deptno : 20, dname : "Sales",  loc :  "Pune"},
    {deptno : 30, dname : "Marketing",  loc :  "Hyd"},
    {deptno : 40, dname : "Operations",  loc :  "Chennai"},
    {deptno : 50, dname : "Admin",  loc :  "Pune"},
    {deptno : 60, dname : "Finance",  loc :  "Hyd"},
    {deptno : 70, dname : "Testing",  loc :  "Mumbai"},
    {deptno : 80, dname : "IT",  loc :  "Chennai"} ,
  ];

  ngOnInit()
  {
      // alert("From ngOnInit : " + this.location);
      // this.filteredArray = this.deptsArray.filter(item => item.loc == this.location);
  }

  ngOnChanges()
  {
    // alert("From ngOnChanges : " + this.location);
    if(this.location == "")
      this.filteredArray = this.deptsArray;
    else
      this.filteredArray = this.deptsArray.filter(item => item.loc == this.location);
  }

}
