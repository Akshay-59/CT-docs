import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  user1:string  = "John";
  user2:string  = "James";

  unamesArray:string[] = ["Kiran", "Ravi", "Krishna", "Ragu"];

}
