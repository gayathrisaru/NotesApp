import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { NotesService } from 'src/notes.service';
import { DetailsComponent } from '../details/details.component';
import { InteractionService } from '../interaction.service';
import { Notes } from '../note.model';
import { NotesList } from '../notesList.model';

@Component({
  selector: 'app-notes',
  templateUrl: './notes.component.html',
  styleUrls: ['./notes.component.scss']
})
export class NotesComponent implements OnInit {
  dialogValue: string;
  notesData: NotesList[]=[];
  notes:Notes=new Notes(0,'','',new Date(),false,false);
  constructor(private dialog:MatDialog,private notesService:NotesService,private interActionService:InteractionService,private router:Router) { }

  ngOnInit(): void {
    this.displayNotes();
    this.interActionService.subject.subscribe(res =>{
      this.displayNotes();
    })
  }
  openDialog(isEdit):void{
    console.log(isEdit);
      let dialogRef=this.dialog.open(DetailsComponent, {
      width:'500px',
      data:{NoteValue:this.notes,value:isEdit}
    });
  }
  deleteNote(id:number){
    this.notesService.deleteNote(id).subscribe(res=>{
      this.displayNotes();
    });
  }
  editNote(id:number){
    this.notesService.getNoteById(id).subscribe(res =>{
       this.notes=res;
       this.openDialog(true);
    });
  }
  displayNotes(){
    this.notesService.getAllNotes().subscribe(response =>{
      this.notesData=response;
    })
  }
  logout(){
    this.router.navigateByUrl('/login');
  }
}
