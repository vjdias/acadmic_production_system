package com.aps.model;

import java.util.ArrayList;

public class Orientation implements Model {
	private int id;
	private ArrayList<Integer> professors_collaborators_fk;
	private String description;
	private Boolean active;
	private int date_begin;
	private int date_ending;
	
	public Orientation() {
		professors_collaborators_fk = new ArrayList<Integer>();
	}
	
	public Orientation(ArrayList<Integer> professors_collaborators_fk, String description) {
		this.professors_collaborators_fk = professors_collaborators_fk;
		this.setDescription(description);
		this.active = true;
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
	public int getDate_begin() {
		return date_begin;
	}
	public void setDate_begin(int date_begin) {
		this.date_begin = date_begin;
	}
	public int getDate_ending() {
		return date_ending;
	}
	public void setDate_ending(int date_ending) {
		this.date_ending = date_ending;
	}
}
