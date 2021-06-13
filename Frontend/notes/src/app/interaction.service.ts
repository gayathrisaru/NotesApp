import { Injectable } from '@angular/core';
import { BehaviorSubject, Subject } from 'rxjs';
import { NotesService } from 'src/notes.service';
import { NotesList } from './notesList.model';

@Injectable({
  providedIn: 'root'
})
export class InteractionService {
  subject =new Subject<any>();
  constructor(private notesService:NotesService) { }
}
