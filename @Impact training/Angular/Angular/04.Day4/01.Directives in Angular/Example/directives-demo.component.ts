import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-directives-demo',
  templateUrl: './directives-demo.component.html',
  styleUrls: ['./directives-demo.component.css']
})
export class DirectivesDemoComponent
{

  displayMode:string  = "List";

  public  studentsArray:any[] = [
      {sname  :  "Scott", course : "Angular"},
      {sname  :  "Smith", course : "HTML5"},
      {sname  :  "Smith", course : "React JS"},
      {sname  :  "James", course : "Angular"},
      {sname  :  "Adam", course : "Java Script"},
      {sname  :  "Sathya", course : "React JS"},
      {sname  :  "Mark", course : "Angular"},
      {sname  :  "Peter", course : "HTML5"},
      {sname  :  "Maneesh", course : "React JS"},
      {sname  :  "Ramesh", course : "Angular"},
      {sname  :  "Vinush", course : "Java Script"},
      {sname  :  "Haneesh", course : "React JS"}
     ];
}
