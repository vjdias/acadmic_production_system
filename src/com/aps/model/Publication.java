package com.aps.model;

import java.util.ArrayList;
import java.util.Date;

public class Publication implements Model{
	private int id;
	private String title;
	
	private ArrayList<Integer> authors_collaborators_fk;
	private String conference;
	private Date year;
	private Project project;
	
	public Publication() {
		authors_collaborators_fk = new ArrayList<Integer>();
	}
	
	public Publication(String title, ArrayList<Integer> authors_collaborators_fk, String conference, Date year, Project project) {
		this.title = title;
		this.authors_collaborators_fk = authors_collaborators_fk;
		this.conference = conference;
		this.year = year;
		this.project = project;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public ArrayList<Integer> getAuthors_fk() {
		return authors_collaborators_fk;
	}
	public void setAuthors_fk(ArrayList<Integer> authors) {
		this.authors_collaborators_fk = authors;
	}
	public String getConference() {
		return conference;
	}
	public void setConference(String conconference) {
		this.conference = conconference;
	}
	public Date getYear() {
		return year;
	}
	public void setYear(Date year) {
		this.year = year;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
}
