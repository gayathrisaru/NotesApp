package com.sample.notes.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="notes")
public class Notes {
	
	@Id
    @Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="title")
	private String title;
	@Column(name="note")
	private String note;
	@Column(name="stored_date")
	private Date date;
	@Column(name="is_morning")
	private Boolean mrngChecked;
	@Column(name="is_evening")
	private Boolean evngChecked;
	@Column(name="is_active")
	private Boolean isActive;
	@Column(name="created_on")
	private Date createdOn;
	@Column(name="updated_on")
	private Date updatedOn;
	@Column(name="created_by")
	private Integer createdBy;
	@Column(name="updated_by")
	private Integer updatedBy;
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
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public Date getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}
	public Integer getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	public Integer getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}
	@Override
	public String toString() {
		return "Notes [id=" + id + ", title=" + title + ", note=" + note + ", date=" + date + ", mrngChecked="
				+ mrngChecked + ", evngChecked=" + evngChecked + ", isActive=" + isActive + ", createdOn=" + createdOn
				+ ", updatedOn=" + updatedOn + ", createdBy=" + createdBy + ", updatedBy=" + updatedBy + "]";
	}
	
}
