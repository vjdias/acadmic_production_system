package com.aps.controller;

import java.util.ArrayList;

import com.aps.model.Collaborator;
import com.aps.model.Orientation;
import com.aps.model.Participation;
import com.aps.model.Project;
import com.aps.model.Publication;

public class APS {
//	private Collaborator collaborator;
//	private Orientation orientation;
//	private Participation Participation;
//	private Project project;
//	private Publication publication;

	private Manage<Collaborator> manageCollaborator;
	private ManageOrientation manageOrientation;
	private Manage<Participation> manageParticipation;
	private ManageProject manageProject;
	private Manage<Publication> managePublication;
	private String[] models = {"Collaborator", "Orientation", "Participation", "Project", "Publication"};
	public APS() {
		manageCollaborator = new Manage<Collaborator>();
		manageOrientation = new ManageOrientation(manageCollaborator);
		manageParticipation = new Manage<Participation>();
		manageProject = new ManageProject(manageCollaborator, manageParticipation);
		managePublication = new Manage<Publication>();
	}
	
	public Boolean add(String ST, Object obj) {
		try {
			if (ST.equals("collaborator"))
				return manageCollaborator.add((Collaborator)obj);
			
			else if (ST.equals("orientation"))
				return manageOrientation.add((Orientation)obj);
			
			else if (ST.equals("participation"))
				return manageParticipation.add((Participation)obj);
			
			else if (ST.equals("project"))
				return manageProject.add((Project)obj);
			
			else if (ST.equals("publication"))
				return managePublication.add((Publication)obj);
		
		} catch (ClassCastException c) {
			System.out.println("Erro de cast ao ler o objeto: "+ST);
		}
	
		return false;
	}
	
	public Boolean add_collaborator_project(int id_project, int coll_fk) {
		return manageProject.add_collaborator_project(id_project, coll_fk);
	}
	
	public Boolean add_publication_project(int id_project, int publication_fk) {
		return manageProject.add_publication_project(id_project, publication_fk);
	}
	
	
	public ArrayList<String>  listFields(String ST, Boolean show) {
		if (ST.equals("collaborator"))
			return manageCollaborator.listFields(show);
		
		else if (ST.equals("orientation"))
			return manageOrientation.listFields(show);
		
		else if (ST.equals("participation"))
			return manageParticipation.listFields(show);
		
		else if (ST.equals("project"))
			return manageProject.listFields(show);
		
		else if (ST.equals("publication"))
			return managePublication.listFields(show);
		else {
			
		}
		return null;
	}
	
	public void search(String ST, String field, String data, int spc_field) {
		if (ST.equals("collaborator")) {
			manageCollaborator.search(field, data, spc_field);
		}
		else if (ST.equals("orientation"))
			manageOrientation.search(field, data, spc_field);
		
		else if (ST.equals("participation"))
			manageParticipation.search(field, data, spc_field);
		
		else if (ST.equals("project"))
			manageProject.search(field, data, spc_field);
		
		else if (ST.equals("publication"))
			managePublication.search(field, data, spc_field);
	}
	
	public String[] getModels() {
		return models;
	}
	
	public Boolean remove(String ST, int id) {
	
		if (ST.equals("collaborator"))
			return manageCollaborator.remove(id);
		
		else if (ST.equals("orientation"))
			return manageOrientation.remove(id);
		
		else if (ST.equals("participation"))
			return manageParticipation.remove(id);
		
		else if (ST.equals("project"))
			return manageProject.remove(id);
		
		else if (ST.equals("publication"))
			return managePublication.remove(id);
		
		
		return false;
	}
}
