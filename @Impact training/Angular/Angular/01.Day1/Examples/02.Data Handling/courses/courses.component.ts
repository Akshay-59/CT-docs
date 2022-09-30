import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.css']
})
export class CoursesComponent implements OnInit {

  courseArray:string[] = ["Angular", "React JS", "VueJS", "Node JS", "Express JS"];

  constructor() { }

  // page load
  ngOnInit(): void {
  }

}
