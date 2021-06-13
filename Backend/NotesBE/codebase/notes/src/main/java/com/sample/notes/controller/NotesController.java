package com.sample.notes.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sample.notes.DTO.NotesDTO;
import com.sample.notes.service.NotesService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class NotesController {
	
	@Resource
	NotesService notesService;

	@PutMapping("/addNewNote")
	public ResponseEntity<?> createNote(@RequestBody NotesDTO notes) {
		try {
			notesService.createNote(notes);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/editNote/{id}")
	public ResponseEntity<?> updateNote(@PathVariable(name = "id") Integer id,@RequestBody NotesDTO notes) {
		try {
			notesService.editNote(id,notes);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>("error while editing the note",HttpStatus.CONFLICT);
		}
	}

	@DeleteMapping("/removeNote/{id}")
	public ResponseEntity<?> deleteNote(@PathVariable(name = "id") Integer id) {
		try {
			notesService.deleteNote(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	@GetMapping("/getAllNotes")
	public ResponseEntity<List<NotesDTO>> getNotes() {
		try {
			List<NotesDTO> allNotes=notesService.getAllNotes();
			return new ResponseEntity<>(allNotes,HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	@GetMapping("/getNoteById/{id}")
	public ResponseEntity<?>getNote(@PathVariable(name="id") Integer id){
		try {
			NotesDTO notes=notesService.getNote(id);
			return new ResponseEntity<>(notes,HttpStatus.OK);
		}catch(Exception ex) {
			return new ResponseEntity<>(ex,HttpStatus.NOT_FOUND);
		}
	}
}
