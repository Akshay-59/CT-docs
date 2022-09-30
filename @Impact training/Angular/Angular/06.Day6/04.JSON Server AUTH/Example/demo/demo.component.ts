import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';

@Component({
  selector: 'app-demo',
  templateUrl: './demo.component.html',
  styleUrls: ['./demo.component.css']
})
export class DemoComponent implements OnInit {

  result: any[] = [];

  constructor(private dataService:DataService) { }

  ngOnInit(): void {
  }


  getData1_click()
  {
    this.dataService.getStudentsByCity("Mumbai").subscribe(resData =>
      {
        this.result = resData;
      });
  }

  getData2_click()
  {
    this.dataService.getStudentNames().subscribe(resData =>
      {
        this.result = resData;
      });
  }

  getData3_click()
  {
      this.dataService.getStudentNameAndEmail().subscribe(resData =>
      {
        this.result = resData;
      });
  }

}
