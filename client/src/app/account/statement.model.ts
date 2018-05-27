export class Statement {
    constructor(public id: number, 
        public date: string,
        public operation: string,
        public value: number,
        public balance: number) {}
}