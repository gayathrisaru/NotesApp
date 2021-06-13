package com.sample.notes.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.notes.model.Notes;

public interface NotesRepository extends JpaRepository<Notes,Integer> {

	public List<Notes> findByIsActiveTrueOrderByCreatedOnDesc();
	
	public Optional<Notes> findById(Integer id);


}
