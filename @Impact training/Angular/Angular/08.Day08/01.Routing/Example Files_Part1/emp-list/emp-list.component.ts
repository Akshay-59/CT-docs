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
  public empsArray:any[] = [
    {empno: 1025, ename : "Scott", job : "Manager", sal : 56000},
  {empno: 1026, ename : "Smith", job : "Sr.Manager", sal : 65000},
  {empno: 1027, ename : "Sandy", job : "Lead", sal : 45000},
  {empno: 1028, ename : "Sam", job : "Group Manager", sal : 75000},];

    constructor(private _dataService:DataService) { }

    ngOnInit()
    {
      this.getData_click();
    }

    getData_click()
    {
      // this.empsArray = this._dataService.getEmpData();
    }

}
