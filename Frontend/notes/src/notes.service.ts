import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Notes } from './app/note.model';
import { NotesList } from './app/notesList.model';
const baseURL = "http://localhost:8080";
@Injectable({
  providedIn: 'root'
})
export class NotesService {
  constructor(private httpClient:HttpClient) { }
  public saveNote(data:Notes):Observable<any>{
    return this.httpClient.put(baseURL+'/addNewNote',data);
  }
  public updateNote(updatedData:Notes,id:number):Observable<any>{
    return this.httpClient.post(baseURL+'/editNote/'+id,updatedData);
  }
  public deleteNote(id:number):Observable<any>{
    return this.httpClient.delete(baseURL+'/removeNote/'+id);
  }
  public getAllNotes():Observable<NotesList[]>{
    return this.httpClient.get<NotesList[]>(baseURL+'/getAllNotes');
  }
  public getNoteById(id:number):Observable<Notes>{
    return this.httpClient.get<Notes>(baseURL+'/getNoteById/'+id);
  }
}
