import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'gender'
})
export class GenderPipe implements PipeTransform {

  transform(input:string): string {
      let output: string = "";

      if(input == "M" || input == "m")  output = "Male";
      if(input == "F" || input == "f")  output = "Female";

    return output;
  }

}
