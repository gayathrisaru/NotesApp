export class NotesList{
    constructor(
        public id:number,
        public title:string,
        public notes:string,
        public noteDate:Date,
        public isMrngChecked:string,
        public isEvngChecked:string,
        public createdOn:Date
    ){}
}