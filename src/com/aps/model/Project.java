package com.aps.model;

import java.util.ArrayList;

public class Project implements Model {
	private Integer id;
	private String title;
	private int start_year;
	private int conclusion_year;

	private String financing_company;
	private String financing_amount;
	private String description;
	private ArrayList<Integer> collaborators_fk;
	private ArrayList<Integer> publications_fk;
	private ArrayList<Integer> orientations_fk;
	private String status;
	
	public Project() {
		collaborators_fk = new ArrayList<Integer>();
		publications_fk = new ArrayList<Integer>();
		orientations_fk = new ArrayList<Integer>();
	}

	public String toString() {
		return "Title: "+getTitle()+", Status: "+getStatus();
	}
	
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

