package com.aps.model;

import java.util.ArrayList;
import java.util.Date;

public class Orientation implements Model {
	private int id;
	private ArrayList<Integer> professors_collaborators_fk;
	private String description;
	private Boolean active;
	private Date date_begin;
	private Date date_ending;
	
	public Orientation() {}
	
	public Orientation(ArrayList<Integer> professors_collaborators_fk, String description) {
		this.professors_collaborators_fk = professors_collaborators_fk;
		this.setDescription(description);
		this.active = true;
		this.date_begin = new Date(System.currentTimeMillis());
	}

	public Orientation(ArrayList<Integer> professors_collaborators_fk, String description, Boolean active, Date date_begin, 
			Date date_ending) {
		this.professors_collaborators_fk = professors_collaborators_fk;
		this.setDescription(description);
		this.active = active;
		this.date_begin = date_begin;
		this.date_ending = date_ending;
	}
	
	public String toString() {
		return "Collaborator: "+getProfessors_collaborators_fk()+", Description: "+getDescription();
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

	public ArrayList<Integer> getProfessors_collaborators_fk() {
		return professors_collaborators_fk;
	}

	public void setProfessors_collaborators_fk(ArrayList<Integer> professors_collaborators_fk) {
		this.professors_collaborators_fk = professors_collaborators_fk;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
