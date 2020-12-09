package com.aps.controller;

import java.util.ArrayList;
import java.util.Map;

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
			if (ST.toLowerCase().equals("collaborator"))
				return manageCollaborator.add((Collaborator)obj);
			
			else if (ST.toLowerCase().equals("orientation"))
				return manageOrientation.add((Orientation)obj);
			
			else if (ST.toLowerCase().equals("participation"))
				return manageParticipation.add((Participation)obj);
			
			else if (ST.toLowerCase().equals("project"))
				return manageProject.add((Project)obj);
			
			else if (ST.toLowerCase().equals("publication"))
				return managePublication.add((Publication)obj);
		
		} catch (ClassCastException c) {
			System.out.println("Erro de cast ao ler o objeto: "+ST);
		}
	
		return false;
	}
	
	public Boolean add(String ST, Map<String, String> fields_and_values) {
		try {
			if (ST.toLowerCase().equals("collaborator")) {
				Collaborator coll = new Collaborator();
				return manageCollaborator.add(fields_and_values,coll);
				
			} else if (ST.toLowerCase().equals("orientation")) {
				Orientation orien = new Orientation();
				return manageOrientation.add(fields_and_values, orien);
			
			} else if (ST.toLowerCase().equals("participation")) {
				Participation part = new Participation();
				return manageParticipation.add(fields_and_values, part);
			
			} else if (ST.toLowerCase().equals("project")) {
				Project proj = new Project();
				return manageProject.add(fields_and_values, proj);
			
			} else if (ST.toLowerCase().equals("publication")) {
				Publication pub = new Publication();
				return managePublication.add(fields_and_values, pub);
			}
			
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
	
	
	public ArrayList<String> listFields(String ST, Boolean show) {
		if (ST.toLowerCase().equals("collaborator")) {
			Collaborator coll = new Collaborator();
			return manageCollaborator.listFields(show, coll);
		}
		else if (ST.toLowerCase().equals("orientation")) {
			Orientation orien = new Orientation();
			return manageOrientation.listFields(show, orien);
		}
		else if (ST.toLowerCase().equals("participation")) {
			Participation part = new Participation();
			return manageParticipation.listFields(show, part);
		}
		else if (ST.toLowerCase().equals("project"))  {
			Project proj = new Project();
			return manageProject.listFields(show, proj);
		}
		else if (ST.toLowerCase().equals("publication")) {
			Publication pub = new Publication();
			return managePublication.listFields(show, pub);
		}
		return null;
	}
	
	public void search(String ST, String field, String data, int spc_field) {
		if (ST.toLowerCase().equals("collaborator")) {
			Collaborator coll = new Collaborator();
			manageCollaborator.search(field, data, spc_field, coll);
		}
		else if (ST.toLowerCase().equals("orientation")) {
			Orientation orien = new Orientation();
			manageOrientation.search(field, data, spc_field, orien);
		}
		else if (ST.toLowerCase().equals("participation")) {
			Participation part = new Participation();
			manageParticipation.search(field, data, spc_field, part);
		}
		else if (ST.toLowerCase().equals("project")) {
			Project proj = new Project();
			manageProject.search(field, data, spc_field, proj);
		}
		else if (ST.toLowerCase().equals("publication")) {
			Publication pub = new Publication();
			managePublication.search(field, data, spc_field, pub);
		}
	}
	
	public void show_all(String ST, String field, String data, int spc_field) {
		if (ST.toLowerCase().equals("collaborator")) {
			Collaborator coll = new Collaborator();
			manageCollaborator.show_all(spc_field, coll);
		}
		else if (ST.toLowerCase().equals("orientation")) {
			Orientation orien = new Orientation();
			manageOrientation.show_all(spc_field, orien);
		}
		else if (ST.toLowerCase().equals("participation")) {
			Participation part = new Participation();
			manageParticipation.show_all(spc_field, part);
		}
		else if (ST.toLowerCase().equals("project")) {
			Project proj = new Project();
			manageProject.show_all(spc_field, proj);
		}
		else if (ST.toLowerCase().equals("publication")) {
			Publication pub = new Publication();
			managePublication.show_all(spc_field, pub);
		}
	}
	public String[] getNamesModels() {
		return models;
	}

	public void showNameModel(int id) {
		System.out.println(models[id]);
	}
	
	public String academicReport(Boolean show) {
		return manageProject.academicReport(show);
	}
	
	public Boolean remove(String ST, int id) {
	
		if (ST.toLowerCase().equals("collaborator"))
			return manageCollaborator.remove(id);
		
		else if (ST.toLowerCase().equals("orientation"))
			return manageOrientation.remove(id);
		
		else if (ST.toLowerCase().equals("participation"))
			return manageParticipation.remove(id);
		
		else if (ST.toLowerCase().equals("project"))
			return manageProject.remove(id);
		
		else if (ST.toLowerCase().equals("publication"))
			return managePublication.remove(id);
		
		
		return false;
	}
}
