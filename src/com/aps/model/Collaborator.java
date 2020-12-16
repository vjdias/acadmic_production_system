package com.aps.model;

import java.util.ArrayList;

public class Collaborator implements Model {
	private int id;
	private String name;
	private String email;
	private String academic_degree;
	private ArrayList<Integer> history_project_participation_fk;
	private ArrayList<Integer> history_project_production_fk;

	public Collaborator() {
		history_project_participation_fk = new ArrayList<Integer>();
		history_project_production_fk = new ArrayList<Integer>();
	}
	
	public Collaborator(String name, String email, String academic_degree) {
		this.name = name;
		this.email = email;
		this.academic_degree = academic_degree;
	}

	public String toString() {
		return "Name: "+getName()+", Degree: "+getAcademic_degree();
	}
	
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAcademic_degree() {
		return academic_degree;
	}
	public void setAcademic_degree(String academic_degree) {
		this.academic_degree = academic_degree;
	}
	public ArrayList<Integer> getHistory_project_participation_fk() {
		return history_project_participation_fk;
	}
	public void setHistory_project_participation_fk(ArrayList<Integer> history_project_participation_fk) {
		this.history_project_participation_fk = history_project_participation_fk;
	}
	public ArrayList<Integer> getHistory_project_production_fk() {
		return history_project_production_fk;
	}
	public void setHistory_project_production_fk(ArrayList<Integer> history_project_production_fk) {
		this.history_project_production_fk = history_project_production_fk;
	}
}
