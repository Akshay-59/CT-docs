import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { DataService } from '../data.service';

@Component({
  selector: 'app-emp-list',
  templateUrl: './emp-list.component.html',
  styleUrls: ['./emp-list.component.css'],
  // providers: [DataService]   // this is for component level injector registration
})
export class EmpListComponent implements OnInit
{
  public empsArray:any[] = [];

    constructor(private _dataService:DataService, private _route:ActivatedRoute) { }

    ngOnInit()
    {
      this.empsArray=this._route.snapshot.data['empsData'];

     // this.getData_click();
    }

    getData_click()
    {
      this._dataService.getEmployees().subscribe(resData =>
        {
          this.empsArray = resData;
        });
    }

}
