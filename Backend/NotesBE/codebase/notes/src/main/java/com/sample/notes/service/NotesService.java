package com.sample.notes.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sample.notes.DTO.NotesDTO;
import com.sample.notes.manager.NotesManager;
import com.sample.notes.model.Notes;

@Service
public class NotesService {
	
	@Resource
	NotesManager notesManager;

	public void createNote(NotesDTO notesDTO) throws Exception {
		try {
			Notes notes = new Notes();
			if(notesDTO.getId() != 0) {
				notes.setId(notesDTO.getId());
			}
			notes.setTitle(notesDTO.getTitle());
			notes.setNote(notesDTO.getNote());
			notes.setDate(notesDTO.getDate());
			if(notesDTO.getMrngChecked() == true) {
			  notes.setMrngChecked(true);
			}else {
				notes.setMrngChecked(false);
			}
			if(notesDTO.getEvngChecked() == true) {
				  notes.setEvngChecked(true);
			}else {
				notes.setEvngChecked(false);
			}
			notes.setIsActive(true);
			notes.setCreatedOn(new Date());
			notes.setUpdatedOn(new Date());
			notes.setCreatedBy(1);
			notes.setUpdatedBy(1);
			notesManager.saveNote(notes);
		}catch(Exception ex) {
			throw new Exception("error while save new note");
		}
	}
	public void editNote(Integer id,NotesDTO notes) throws Exception {
        try {
        	Optional<Notes> editNotes=notesManager.findNotesById(id);
        	editNotes.get().setId(notes.getId());
        	editNotes.get().setTitle(notes.getTitle());
        	editNotes.get().setNote(notes.getNote());
        	editNotes.get().setDate(notes.getDate());
        	if(notes.getMrngChecked() == true) {
        		editNotes.get().setMrngChecked(true);
  			}else {
  				editNotes.get().setMrngChecked(false);
  			}
  			if(notes.getEvngChecked() == true) {
  				editNotes.get().setEvngChecked(true);
  			}else {
  				editNotes.get().setEvngChecked(false);
  			}
			notesManager.saveNote(editNotes.get());
		}catch(Exception ex) {
			throw new Exception("error in update");
		}
	}
	public void deleteNote(Integer id) throws Exception {
		try {
			Optional<Notes> notes=notesManager.findNotesById(id);
			notes.get().setIsActive(false);
			notes.get().setUpdatedBy(1);
			notes.get().setUpdatedOn(new Date());
			notesManager.saveNote(notes.get());
		} catch (Exception ex) {
			throw new Exception("error in deleting note");
		}
	}
	public List<NotesDTO> getAllNotes() throws Exception {
		try {
			List<NotesDTO> noteList=new ArrayList<>();
			List<Notes> allNotes=notesManager.getAllNotes();
			for(Notes note:allNotes) {
				NotesDTO noteDTO =new NotesDTO();
				noteDTO.setId(note.getId());
				noteDTO.setTitle(note.getTitle());
				noteDTO.setNote(note.getNote());
				noteDTO.setDate(note.getDate());
				noteDTO.setMrngChecked(note.getMrngChecked());
				noteDTO.setEvngChecked(note.getEvngChecked());
				noteDTO.setCreatedOn(note.getCreatedOn());
				noteList.add(noteDTO);
			}
			return noteList;
		} catch (Exception ex) {
			throw new Exception(ex);
		}
	}
	public NotesDTO getNote(Integer id) throws Exception {
		try {
			Optional<Notes> notes=notesManager.findNotesById(id);
			NotesDTO noteDTO=new NotesDTO();
			noteDTO.setId(notes.get().getId());
			noteDTO.setDate(notes.get().getDate());
			noteDTO.setTitle(notes.get().getTitle());
			noteDTO.setNote(notes.get().getNote());
			if(notes.get().getMrngChecked() != null) {
			    noteDTO.setMrngChecked(notes.get().getMrngChecked());
			}
			else {
				noteDTO.setMrngChecked(notes.get().getMrngChecked());
			}
			if(notes.get().getEvngChecked() != null) {
			   noteDTO.setEvngChecked(notes.get().getEvngChecked());
			}
			else {
			   noteDTO.setEvngChecked(notes.get().getEvngChecked());
			}
			return noteDTO;
	    }catch(Exception ex){
	    	throw new Exception("error in getting notes");
		}
	}
}
