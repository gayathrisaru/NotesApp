export class Notes{
    constructor(
        public id:number,
        public title:string,
        public note:string,
        public date:Date,
        public mrngChecked:boolean,
        public evngChecked:boolean
    ){}
}