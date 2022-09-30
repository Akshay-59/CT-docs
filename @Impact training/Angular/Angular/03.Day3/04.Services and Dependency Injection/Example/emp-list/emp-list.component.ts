import { Component, OnInit } from '@angular/core';
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

    constructor(private _dataService:DataService) { }

    ngOnInit()
    {
      this.getData_click();
    }

    getData_click()
    {
       this.empsArray = this._dataService.getEmpData();
    }

}
