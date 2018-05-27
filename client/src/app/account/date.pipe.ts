import { Pipe, PipeTransform } from '@angular/core';

@Pipe({name: 'datePipe'})
export class DatePipe implements PipeTransform {
  transform(value: string): string {
    const d = new Date(value);
    const day = d.getDate() + 1;
    const month = "00".substring(0, 2 - d.getMonth().toString().length) + (d.getMonth() + 1);
    const year = d.getFullYear();
    return day + "/" + month + "/" + year;
  }
}