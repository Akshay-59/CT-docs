import { Directive, ElementRef, Input, OnInit } from '@angular/core';

@Directive({
  selector: '[appHighLighter]'
})
export class HighLighterDirective implements OnInit {

  @Input()
  appHighLighter:string  = "";

  constructor(private _element: ElementRef) {

   }

   ngOnInit()
   {
     if(this.appHighLighter == "")
     {
        this.appHighLighter = "Yellow";
     }

     this._element.nativeElement.style.backgroundColor = this.appHighLighter;
     this._element.nativeElement.style.border = "1px solid gray";
   }



}
