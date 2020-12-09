package com.aps.model;

import java.util.Date;

public class Participation implements Model {
	private int id;
	private int project_fk;
	private Boolean active;
	private Date date_begin;
	private Date date_ending;

	public Participation() {}

	
	public Participation(int project_fk, Boolean active, Date date_begin) {
		this.active = active;
		this.project_fk= project_fk;
		this.active = true;
		this.date_begin = new Date(System.currentTimeMillis());
	}

	public Participation(int project_fk, Boolean active, Date date_begin, Date date_ending) {
		this.active = active;
		this.project_fk = project_fk;
		this.active = active;
		this.date_begin = date_begin;
		this.date_ending = date_ending;
	}

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
