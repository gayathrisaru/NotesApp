package com.sample.notes.manager;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.sample.notes.model.Notes;
import com.sample.notes.repository.NotesRepository;

@Component
public class NotesManager {
	
	@Resource
	NotesRepository notesRepository;

	public void saveNote(Notes notes) throws Exception {
		try {
			notesRepository.save(notes);
		} catch (Exception ex) {
			throw new Exception(ex);
		}
	}

	public List<Notes> getAllNotes() throws Exception {
		try {
			return notesRepository.findByIsActiveTrueOrderByCreatedOnDesc();
		} catch (Exception ex) {
			throw new Exception(ex);
		}
	}

	public Optional<Notes> findNotesById(Integer id) {
		return notesRepository.findById(id);
	}
}
