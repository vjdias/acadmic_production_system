package com.aps.model;

public class Collaborator extends Person {
	
	private String academic_degree;
	
	public Collaborator(String name, String email, String academic_degree) {
		super(name, email);
		this.academic_degree = academic_degree;
	}

	public String getAcademic_degree() {
		return academic_degree;
	}

	public void setAcademic_degree(String academic_degree) {
		this.academic_degree = academic_degree;
	}

}
