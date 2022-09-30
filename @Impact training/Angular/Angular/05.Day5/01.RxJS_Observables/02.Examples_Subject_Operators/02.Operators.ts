  import { Component, OnInit } from '@angular/core';
  import { Observable, Subject, of, from, filter } from 'rxjs';

  @Component({
    selector: 'app-rxjs-demo',
    templateUrl: './rxjs-demo.component.html',
    styleUrls: ['./rxjs-demo.component.css']
  })
  export class RxjsDemoComponent {

    getData_click()
    {
      // observable with strongly typed data
     // const source:Observable<number> = from([1, 2, 3, 4, 5]);
      const observableObj:Observable<number> = of(1, 2, 3, 4, 5);

      // output: Generates all items
      observableObj.subscribe( val => console.log(`Result number: ${val}`));
      console.log("----------------------------");


      //filter out non-even numbers
      const filteredSource:Observable<number> = observableObj.pipe(filter(num => num % 2 === 0));
      filteredSource.subscribe(val => console.log(`Result number: ${val}`));

    }
  }

