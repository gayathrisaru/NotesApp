package com.sample.notes.DTO;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class NotesDTO {
	
	private Integer id;
    private String title;
    private String note;
    private Date date;
    private Boolean mrngChecked;
    private Boolean evngChecked;
    @JsonInclude(Include.NON_EMPTY)
    private Date createdOn;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Boolean getMrngChecked() {
		return mrngChecked;
	}
	public void setMrngChecked(Boolean mrngChecked) {
		this.mrngChecked = mrngChecked;
	}
	public Boolean getEvngChecked() {
		return evngChecked;
	}
	public void setEvngChecked(Boolean evngChecked) {
		this.evngChecked = evngChecked;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
    
}
