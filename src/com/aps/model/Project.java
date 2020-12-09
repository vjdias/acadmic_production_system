package com.aps.model;

import java.util.ArrayList;
import java.util.Date;

public class Project implements Model {
	private int id;
	private String title;
	private Date date_begin;
	private Date date_ending;
	private String financing_company;
	private String financing_amount;
	private String description;
	private ArrayList<Integer> collaborators_fk;
	private ArrayList<Integer> publications_fk;
	private ArrayList<Integer> orientations_fk;

	private String status;
	
	public Project(String title) {
		this.title = title;
	}
	
	public Project(String title, Date date_begin, Date date_ending, String financing_company, 
			String financing_amount, String description, ArrayList<Integer> collaborators_fk, 
			ArrayList<Integer> publications_fk, ArrayList<Integer> orientations_fk, String status) {
		
		this.title = title;
		this.date_begin = date_begin;
		this.date_ending = date_ending;
		this.financing_company = financing_company;
		this.financing_amount = financing_amount;
		this.description = description;
		this.collaborators_fk = collaborators_fk;
		this.publications_fk = publications_fk;
		this.status = status;
	}

	public String toString() {
		return "Title: "+getTitle()+", Status: "+getStatus();
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

	public ArrayList<Integer> getCollaborators_fk() {
		return collaborators_fk;
	}

	public void setCollaborators_fk(ArrayList<Integer> collaborators_fk) {
		this.collaborators_fk = collaborators_fk;
	}

	public ArrayList<Integer> getPublications_fk() {
		return publications_fk;
	}

	public void setPublications_fk(ArrayList<Integer> publications_fk) {
		this.publications_fk = publications_fk;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

	public ArrayList<Integer> getOrientations_fk() {
		return orientations_fk;
	}

	public void setOrientations_fk(ArrayList<Integer> orientations_fk) {
		this.orientations_fk = orientations_fk;
	}
	
}

