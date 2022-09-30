import { Component, OnInit } from '@angular/core';
import {Dept} from '../models/dept';

@Component({
  selector: 'app-dept-details',
  templateUrl: './dept-details.component.html',
  styleUrls: ['./dept-details.component.css']
})
export class DeptDetailsComponent implements OnInit {


   // Object initializer
   deptObj:Dept = { deptno : 10, dname  : "Scott", loc : "Hyd" };

   // deptObj:Dept = new Dept();
   // deptObj:any = { deptno : 10, dname  : "Scott", loc : "Hyd" };
   // deptObj:Object = { deptno : 10, dname  : "Scott", loc : "Hyd" };



  constructor() { }

  ngOnInit(): void {
  }

}

