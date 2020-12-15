package com.aps.model;

import java.util.ArrayList;

public class Publication implements Model{
	private int id;
	private String title;
	
	private ArrayList<Integer> authors_collaborators_fk;
	private String conference;
	private int year;
	private int project;
	
	public Publication() {
		authors_collaborators_fk = new ArrayList<Integer>();
	}
	
	public Publication(String title, ArrayList<Integer> authors_collaborators_fk, String conference, int year, int project) {
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
	public ArrayList<Integer> getAuthors_collaborators_fk() {
		return authors_collaborators_fk;
	}
	public void setAuthors_collaborators_fk(ArrayList<Integer> authors) {
		this.authors_collaborators_fk = authors;
	}
	public String getConference() {
		return conference;
	}
	public void setConference(String conconference) {
		this.conference = conconference;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getProject() {
		return project;
	}
	public void setProject(int project) {
		this.project = project;
	}
}
