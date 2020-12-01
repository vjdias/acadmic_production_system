package com.aps.model;

import java.util.ArrayList;
import java.util.Date;

public class Publication {
	private String title;
	private ArrayList<Collaborator> authors;
	private String conference;
	private Date year;
	private Project project;
	
	public Publication(String title, ArrayList<Collaborator> authors, String conference, Date year, Project project) {
		this.title = title;
		this.authors = authors;
		this.conference = conference;
		this.year = year;
		this.project = project;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public ArrayList<Collaborator> getAuthors() {
		return authors;
	}
	public void setAuthors(ArrayList<Collaborator> authors) {
		this.authors = authors;
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
