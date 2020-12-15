package com.aps.controller;

import java.util.ArrayList;
import java.util.Map;

import com.aps.model.Collaborator;
import com.aps.model.Orientation;
import com.aps.model.Participation;
import com.aps.model.Project;
import com.aps.model.Publication;

public class APS {

	private Manage<Collaborator> manageCollaborator;
	private ManageOrientation manageOrientation;
	private Manage<Participation> manageParticipation;
	private ManageProject manageProject;
	private ManagePublication managePublication;
	private String[] models = {"Collaborator", "Orientation", "Participation", "Project", "Publication"};
		
	public APS() {

		manageCollaborator = new Manage<Collaborator>();
		manageOrientation = new ManageOrientation(manageCollaborator);
		manageParticipation = new Manage<Participation>();
		manageProject = new ManageProject(manageCollaborator, manageParticipation);
		managePublication = new ManagePublication();
	}
	
	public Boolean add(String ST, Map<String, String> fields_and_values) {
		try {
			if (ST.toLowerCase().equals("collaborator")) {
				Collaborator coll = new Collaborator();
				return manageCollaborator.add(fields_and_values, coll);
	
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

	public String get_value(String ST, int id, String field) {
		if (ST.toLowerCase().equals("collaborator"))
			return manageCollaborator.get_value(id, field);
		
		else if (ST.toLowerCase().equals("orientation"))
			return manageOrientation.get_value(id, field);
		
		else if (ST.toLowerCase().equals("participation"))
			return manageParticipation.get_value(id, field);
		
		else if (ST.toLowerCase().equals("project"))
			return manageProject.get_value(id, field);
		
		else if (ST.toLowerCase().equals("publication"))
			return managePublication.get_value(id, field);
		return "";
	}


	public int get_size(String ST) {
		if (ST.toLowerCase().equals("collaborator"))
			return manageCollaborator.get_size();
		
		else if (ST.toLowerCase().equals("orientation"))
			return manageOrientation.get_size();
		
		else if (ST.toLowerCase().equals("participation"))
			return manageParticipation.get_size();
		
		else if (ST.toLowerCase().equals("project"))
			return manageProject.get_size();
		
		else if (ST.toLowerCase().equals("publication"))
			return managePublication.get_size();
		return 0;
	}

	
	public void search(String ST, String field, String data, int spc_field, Boolean sort_by) {
		if (ST.toLowerCase().equals("collaborator")) {
			Collaborator coll = new Collaborator();
			manageCollaborator.search(field, data, spc_field, coll, sort_by);
		}
		else if (ST.toLowerCase().equals("orientation")) {
			Orientation orien = new Orientation();
			manageOrientation.search(field, data, spc_field, orien, sort_by);
		}
		else if (ST.toLowerCase().equals("participation")) {
			Participation part = new Participation();
			manageParticipation.search(field, data, spc_field, part, sort_by);
		}
		else if (ST.toLowerCase().equals("project")) {
			Project proj = new Project();
			manageProject.search(field, data, spc_field, proj, sort_by);
		}
		else if (ST.toLowerCase().equals("publication")) {
			Publication pub = new Publication();
			managePublication.search(field, data, spc_field, pub, sort_by);
		}
	}
	
	public void show_all(String ST, int spc_field, Boolean sort_by) {
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
			manageProject.show_all(spc_field, proj, manageProject.get_obj_list(true));
		}
		else if (ST.toLowerCase().equals("publication")) {
			Publication pub = new Publication();
			managePublication.show_all(spc_field, pub, managePublication.get_obj_list(true));
		}
	}
	
	public String[] getNamesModels() {
		return models;
	}

	public void showNameModel(int id) {
		System.out.println(models[id]);
	}
	
	public Boolean add_collaborator_project(int id_project, int coll_fk) {
		return manageProject.add_collaborator_project(id_project, coll_fk);
	}
		
	public String nextStatus(int id) {
		return manageProject.nextStatus(id);
	}
	
	public String academicReport(Boolean show) {
		return manageProject.academicReport(show);
	}
	
}
