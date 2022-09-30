  import { Component, OnInit } from '@angular/core';
  import { Observable, Subject } from 'rxjs';

  @Component({
    selector: 'app-rxjs-demo',
    templateUrl: './rxjs-demo.component.html',
    styleUrls: ['./rxjs-demo.component.css']
  })
  export class RxjsDemoComponent {

    getData_click()
    {
      let subjectObj = new Subject();

      // First Subscriber
      subjectObj.subscribe((result) => {
            console.log("This is subscriber-1  :  " + result);
      });

      // Second Subscriber
      subjectObj.subscribe((result) => {
        console.log("This is subscriber-2  :  " + result);
      });

       // Third Subscriber
       subjectObj.subscribe((result) => {
        console.log("This is subscriber-3  :  " + result);
      });


      subjectObj.next (  Math.random()  );
      subjectObj.next ( "Message from Subject" );
    }
  }

