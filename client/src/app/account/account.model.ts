import { Client } from './client.model';
import { Statement } from './statement.model';

export class Account {
    constructor(public id: number, 
        public agency: string,
        public number: string,
        public digit: string,
        public client: Client,
        public statements: Statement[]) {}
}
  