import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RegisterComponent } from '../register/register.component';
import { TestComponent } from '../test/test.component';



@NgModule({
  declarations: [
    RegisterComponent,
    TestComponent,
  ],
  imports: [
    CommonModule
  ],
  exports : [RegisterComponent]

})
export class AdminModule { }
