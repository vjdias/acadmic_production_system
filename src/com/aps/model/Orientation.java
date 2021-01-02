package com.aps.model;

import java.util.ArrayList;

public class Orientation implements Model {
	private Integer id;
	private ArrayList<Integer> professors_collaborators_fk;
	private String description;
	private Boolean active;
	private int start_year;
	private int conclusion_year;
	
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
	
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
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
	public int getStart_year() {
		return start_year;
	}
	public void setStart_year(int start_year) {
		this.start_year = start_year;
	}
	public int getConclusion_year() {
		return conclusion_year;
	}
	public void setConclusion_year(int conclusion_year) {
		this.conclusion_year = conclusion_year;
	}
}
