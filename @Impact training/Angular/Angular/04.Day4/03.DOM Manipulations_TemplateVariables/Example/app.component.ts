import { Component, ElementRef, QueryList, ViewChild, ViewChildren, OnInit } from '@angular/core';
import { GreetingComponent } from './greeting/greeting.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  @ViewChild(GreetingComponent)   greetingChild!: GreetingComponent;
  @ViewChildren(GreetingComponent) greetingChildren!: QueryList<GreetingComponent>;

  // p1 is a template that we declare in template file
  @ViewChild('p1') paraRef!: ElementRef;
  //@ViewChildren('p', {read : ElementRef}) paraList!: QueryList<ElementRef>;


  ngOnInit()
  {

  }

  ngAfterViewInit(): void {
    this.getInfo();
  }

  getInfo()
  {
     console.log("---------  Single/First Child --------------");
      console.log(this.greetingChild);
      console.log(this.greetingChild.uname);

      console.log("---------  Multiple Children --------------");
      console.log(this.greetingChildren);
      console.log(this.greetingChildren.toArray());
      for(let item of this.greetingChildren.toArray())
      {
        console.log(item.uname);
      }


      console.log("-------- Single / First paragraphs -----")  ;
    console.log(this.paraRef);

    // nativeElement property is actually refers the physical dom element
    console.log(this.paraRef.nativeElement);
    console.log(this.paraRef.nativeElement.innerText);
    this.paraRef.nativeElement.style.color = "Red";
  }

}
