import { Pipe, PipeTransform } from '@angular/core';

@Pipe({name: 'currency'})
export class CurrencyPipe implements PipeTransform {
  transform(value: number, type: string): string {
    if(type == 'value' && value == 0) {
        return '--';
    }
    return 'R$ ' + value;
  }
}