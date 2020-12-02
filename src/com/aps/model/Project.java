package com.aps.model;

import java.util.ArrayList;
import java.util.Date;

public class Project {
	private String title;
	private Date date_begin;
	private Date date_ending;
	private String financing_company;
	private String financing_amount;
	private String description;
	private ArrayList<Collaborator> collaborators;
	private ArrayList<Publication> publications;
	private String status;
	
	public Project(String title, Date date_begin, Date date_ending, String financing_company, String financing_amount, 
			String description, ArrayList<Collaborator> collaborators, ArrayList<Publication> publications, String status) {
		this.title = title;
		this.date_begin = date_begin;
		this.date_ending = date_ending;
		this.financing_company = financing_company;
		this.financing_amount = financing_amount;
		this.description = description;
		this.collaborators = collaborators;
		this.publications = publications;
		this.status = status;
	}

	public Project(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getFinancing_company() {
		return financing_company;
	}

	public void setFinancing_company(String financing_company) {
		this.financing_company = financing_company;
	}

	public String getFinancing_amount() {
		return financing_amount;
	}

	public void setFinancing_amount(String financing_amount) {
		this.financing_amount = financing_amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ArrayList<Collaborator> getCollaborators() {
		return collaborators;
	}

	public void setCollaborators(ArrayList<Collaborator> collaborators) {
		this.collaborators = collaborators;
	}

	public ArrayList<Publication> getPublications() {
		return publications;
	}

	public void setPublications(ArrayList<Publication> publications) {
		this.publications = publications;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
}

