package com.aps.model;

import java.util.Date;

public class Production implements Model {
	private int id;
	private int collaborator_fk;
	private String responsibility;
	private Boolean active;
	private Date date_begin;
	private Date date_ending;
	
	public Production() {}
	
	public Production(int collaborator_fk, String responsibility) {
		this.collaborator_fk = collaborator_fk;
		this.responsibility = responsibility;
		this.active = true;
		this.date_begin = new Date(System.currentTimeMillis());
	}

	public Production(int collaborator_fk, String responsibility, Boolean active, Date date_begin, 
			Date date_ending) {
		this.collaborator_fk = collaborator_fk;
		this.responsibility = responsibility;
		this.active = active;
		this.date_begin = date_begin;
		this.date_ending = date_ending;
	}
	
	public String toString() {
		return "Collaborator: "+getCollaborator_fk()+", Responsability: "+getResponsibility();
	}
	
	public String toString_Collaborator_fk(String name) {
		return name;
	}
	
	public String toString_idCollaborator_fk(String id) {
		return id;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCollaborator_fk() {
		return collaborator_fk;
	}
	public void setCollaborator_fk(int collaborator_fk) {
		this.collaborator_fk = collaborator_fk;
	}
	public String getResponsibility() {
		return responsibility;
	}
	public void setResponsibility(String responsibility) {
		this.responsibility = responsibility;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public Date getDate_begin() {
		return date_begin;
	}
	public void setDate_begin(Date date_begin) {
		this.date_begin = date_begin;
	}
	public Date getDate_ending() {
		return date_ending;
	}
	public void setDate_ending(Date date_ending) {
		this.date_ending = date_ending;
	}
}
