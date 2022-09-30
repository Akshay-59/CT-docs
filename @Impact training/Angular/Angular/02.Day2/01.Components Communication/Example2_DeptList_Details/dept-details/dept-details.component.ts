import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import {Dept} from '../models/dept';

@Component({
  selector: 'app-dept-details',
  templateUrl: './dept-details.component.html',
  styleUrls: ['./dept-details.component.css']
})
export class DeptDetailsComponent   {

   @Input()
   deptObj:Dept = new Dept();

   @Output()
   onDeptRemove:EventEmitter<number>  = new EventEmitter();


   deptRemove_click_child(dno:number)
   {
     // alert("message from child - " + dno);
     this.onDeptRemove.emit(dno);  // emitting event to parent
   }
}

