  import { Component, OnInit } from '@angular/core';
  import { Observable, Subject, of, from, filter, map } from 'rxjs';

  @Component({
    selector: 'app-rxjs-demo',
    templateUrl: './rxjs-demo.component.html',
    styleUrls: ['./rxjs-demo.component.css']
  })
  export class RxjsDemoComponent {

    getData_click()
    {
      let observableObj:Observable<string> =  of("Hyderabad", "Pune", "Mumbai", "Chennai", "Goa");

      let filteredObj:Observable<string>  = observableObj.pipe(
        filter(x => x.length >= 4 ),
        map(x => x.toUpperCase()),
      );

      filteredObj.subscribe(x => console.log(x));
    }
  }
