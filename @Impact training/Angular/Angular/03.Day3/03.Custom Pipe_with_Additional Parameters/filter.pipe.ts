import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filterpipe',
  pure : true
})
export class FilterPipe implements PipeTransform {

  transform(inputData:any[], key:string, value:string): any[]
  {
    console.log("hi");
    return inputData.filter(item => item[key] == value);
  }

}
