package com.aps.model;

public class Participation implements Model {
	private int id;
	private int project_fk;
	private Boolean active;
	private int start_year;
	private int conclusion_year;

	public Participation() {}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProject_fk() {
		return project_fk;
	}
	public void setProject_fk(int project_fk) {
		this.project_fk = project_fk;
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
