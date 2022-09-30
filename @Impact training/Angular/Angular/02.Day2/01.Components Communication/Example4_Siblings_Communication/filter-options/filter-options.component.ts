import { Component, EventEmitter, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-filter-options',
  templateUrl: './filter-options.component.html',
  styleUrls: ['./filter-options.component.css']
})
export class FilterOptionsComponent {
  @Output()
  onLocationChanged:EventEmitter<string> = new EventEmitter();

  strLocation:string  = "";

  location_change()
  {
   // alert(this.strLocation);
    this.onLocationChanged.emit(this.strLocation);
  }
}
