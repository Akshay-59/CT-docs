import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-dept-details',
  templateUrl: './dept-details.component.html',
  styleUrls: ['./dept-details.component.css']
})
export class DeptDetailsComponent   {

  @Input()  deptObj:any = {};
  @Output() onDeptRemoved = new EventEmitter<number>();

 public remove(dno: number)
 {
 // event emitting
   this.onDeptRemoved.emit(dno);
 }
}

