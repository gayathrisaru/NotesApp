import { Inject } from '@angular/core';
import { Component, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { NotesService } from 'src/notes.service';
import { InteractionService } from '../interaction.service';
import { Notes } from '../note.model';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.scss']
})
export class DetailsComponent implements OnInit {
  notesData:Notes=new Notes(0,'','',new Date(),false,false);
  constructor(public dialogRef: MatDialogRef<DetailsComponent>,private notesService: NotesService,private interactionService:InteractionService,@Inject(MAT_DIALOG_DATA) public data:{NoteValue:Notes,value:boolean}) { }
  
  ngOnInit(): void {
    if(this.data.value){
      this.notesData=this.data.NoteValue;
    }else{
      this.notesData={id:0,title:'',note:'',date:new Date(),mrngChecked:false,evngChecked:false};
    }
  }
  onNoClick(){
    this.dialogRef.close();
  }
  save(notesData){
    this.notesData=notesData;
    this.notesService.saveNote(this.notesData).subscribe(response => {
      this.onNoClick();
      this.interactionService.subject.next();
    });
  }
}
