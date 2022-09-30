import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-template-forms',
  templateUrl: './template-forms.component.html',
  styleUrls: ['./template-forms.component.css']
})
export class TemplateFormsComponent implements OnInit {

  public  fname:string   = "";
	public  lname:string   = "";
	public  city:string   = "";
	public  email:string   = "";
	public  pincode:string   = "";

  constructor() { }

  ngOnInit(): void {
  }

  public submit_click():void
  {
      // ajax call to send data to server
      alert("Customer Details are registered.");
  }
}
