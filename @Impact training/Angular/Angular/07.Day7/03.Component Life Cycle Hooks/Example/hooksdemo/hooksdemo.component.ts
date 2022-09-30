import { AfterContentChecked, AfterContentInit, Component, DoCheck, Input, OnChanges, OnDestroy, OnInit } from '@angular/core';

@Component({
  selector: 'app-hooksdemo',
  templateUrl: './hooksdemo.component.html',
  styleUrls: ['./hooksdemo.component.css']
})

export class HooksdemoComponent implements OnDestroy,  OnInit, OnChanges, DoCheck, AfterContentInit, AfterContentChecked  {

  @Input()
  public uname:string = "";

  public city:string = "Hyd";
  public result:string = "";

  constructor() {
    console.log("Constructor : " +  this.getCurrentTime());
  }

  ngOnChanges():void  {
    console.log("ngOnChanges : " +  this.getCurrentTime());
  }

  ngOnInit(): void {
    console.log("ngOnInit : " + this.getCurrentTime());
  }

  ngDoCheck():void  {
    console.log("ngDoCheck : " +  this.getCurrentTime());
  }

  ngAfterContentInit():void {
    console.log("ngAfterContentInit : " +  this.getCurrentTime());
  }

  ngAfterContentChecked():void {
    console.log("ngAfterContentChecked : " +  this.getCurrentTime());
  }


  ngOnDestroy()
  {
    console.log(" ngOnDestroy :  "  +  this.getCurrentTime());
  }

  getCurrentTime():string
  {
    var d = new Date();
    // Returns the time  hh:mm:ss:ms
    return d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds()  + ":" + d.getMilliseconds();
  }

}
