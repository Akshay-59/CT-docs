import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-emp-details',
  templateUrl: './emp-details.component.html',
  styleUrls: ['./emp-details.component.css']
})
export class EmpDetailsComponent implements OnInit {

  empObj:any = {};

  empsArray:any[] = [
    {empno: 1025, ename : "Scott", job : "Manager", sal : 56000},
    {empno: 1026, ename : "Smith", job : "Sr.Manager", sal : 65000},
    {empno: 1027, ename : "Sandy", job : "Lead", sal : 45000},
    {empno: 1028, ename : "Sam", job : "Group Manager", sal : 75000}
  ];


  constructor(private  route:ActivatedRoute){ }

  ngOnInit(): void {

    let selectedEmpno  =this.route.snapshot.params["id"];
    // Make ajax call to get the data from the server
    this.empObj = this.empsArray.find(item => item.empno == selectedEmpno);
    console.log(this.empObj);
  }

}
