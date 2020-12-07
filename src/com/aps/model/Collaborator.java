package com.aps.model;

import java.util.ArrayList;

public class Collaborator extends Person implements Model {
	private int id;
	private String academic_degree;
	private ArrayList<Integer> history_project_participation_fk;
	private ArrayList<Integer> history_project_production_fk;
	
	public Collaborator(String name, String email, String academic_degree) {
		super(name, email);
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
