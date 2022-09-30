import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-demo',
  templateUrl: './demo.component.html',
  styleUrls: ['./demo.component.css']
})
export class DemoComponent implements OnInit {

  customersArray: any[] = [];

  constructor(private httpObj:HttpClient) { }

  ngOnInit(): void {
  }


  getData_click()
  {
      let url = "https://www.w3schools.com/angular/customers.php";		// server url

			this.httpObj.get(url).subscribe( (resData:any) =>
			{
					// code to handle the result that comes from server
          // console.log(resData);
          console.log(resData.records);
          this.customersArray = resData.records;
			});
  }

}
