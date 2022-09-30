import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-demo',
  templateUrl: './demo.component.html',
  styleUrls: ['./demo.component.css']
})
export class DemoComponent implements OnInit
{
  public s1:string = "";
  public s2:string = "";
  public s3:string = "";

  public depts:any[]  = [ ];


  ngOnInit()
  {
    this.getDepts();
  }

  public getDepts()
  {
    this.depts = [
      { Deptno:10,   Dname: "Accounts", Loc : "Hyd" } ,
      { Deptno:20,   Dname: "Sales", Loc : "Pune" } ,
      { Deptno:30,   Dname: "Admin", Loc : "Hyd" } ,
      { Deptno:40,   Dname: "Marketing", Loc : "Mumbai" },
      { Deptno:10,   Dname: "Accounts", Loc : "Hyd" } ,
      { Deptno:20,   Dname: "Sales", Loc : "Pune" } ,
      { Deptno:30,   Dname: "Admin", Loc : "Hyd" } ,
      { Deptno:40,   Dname: "Marketing", Loc : "Mumbai" },
      { Deptno:10,   Dname: "Accounts", Loc : "Hyd" } ,
      { Deptno:20,   Dname: "Sales", Loc : "Pune" } ,
      { Deptno:30,   Dname: "Admin", Loc : "Hyd" } ,
      { Deptno:40,   Dname: "Marketing", Loc : "Mumbai" }
    ];
  }

  public addDept()
  {
    let deptObj:any = {};
    deptObj.Deptno =  this.s1;
    deptObj.Dname = this.s2;
    deptObj.Loc = this.s3;

    this.depts.push(deptObj);
  }

  public removeDept(dno:number)
  {
    let index:number = this.depts.findIndex( x => x.Deptno == dno );
    this.depts.splice(index, 1);
  }

  public selectDept(dno:number)
  {
    let deptObj:any = this.depts.find( x => x.Deptno == dno );

    this.s1 = deptObj.Deptno;
    this.s2 = deptObj.Dname;
    this.s3 = deptObj.Loc;

  }


  public editDept()
  {
    let deptObj:any = this.depts.find( x => x.Deptno == this.s1 );
    deptObj.Dname = this.s2;
    deptObj.Loc = this.s3;
  }

}
