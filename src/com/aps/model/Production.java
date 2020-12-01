package com.aps.model;

public class Production {
	private Collaborator collaborator;
	private String responsibility;
	
	public Production(Collaborator collaborator, String responsibility) {
		this.collaborator = collaborator;
		this.responsibility = responsibility;
	}
	
	public Collaborator getCollaborator() {
		return collaborator;
	}
	public void setCollaborator(Collaborator collaborator) {
		this.collaborator = collaborator;
	}
	public String getResponsibility() {
		return responsibility;
	}
	public void setResponsibility(String responsibility) {
		this.responsibility = responsibility;
	}
}
