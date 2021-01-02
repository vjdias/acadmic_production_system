package com.aps.controller;

import static java.util.Map.entry;

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
		managePublication = new ManagePublication();
		manageProject = new ManageProject(manageCollaborator, manageParticipation, managePublication, manageOrientation);

	}
	
	public int invoke_and_add(String ST, Map<String, String> fields_and_values) {
		try {
			if (ST.toLowerCase().equals("collaborator")) {
				Collaborator coll = new Collaborator();
				return manageCollaborator.invoke_and_add(fields_and_values, coll);
	
			} else if (ST.toLowerCase().equals("orientation")) {
				Orientation orien = new Orientation();
				return manageOrientation.invoke_and_add(fields_and_values, orien);
			
			} else if (ST.toLowerCase().equals("participation")) {
				Participation part = new Participation();
				return manageParticipation.invoke_and_add(fields_and_values, part);
			
			} else if (ST.toLowerCase().equals("project")) {
				Project proj = new Project();
				return manageProject.invoke_and_add(fields_and_values, proj);
			
			} else if (ST.toLowerCase().equals("publication")) {
				Publication pub = new Publication();
				return managePublication.invoke_and_add(fields_and_values, pub);
			}
			
		} catch (ClassCastException c) {
			System.out.println("Erro de cast ao ler o objeto: "+ST);
		}
		return -1;
	}
	
	public Boolean add_publication_project(int id_project, int publication_fk) {
		return manageProject.add_publication_project(id_project, publication_fk);
	}
	
	public ArrayList<String> listFields(String ST, Boolean show, Boolean no_id) {
		if (ST.toLowerCase().equals("collaborator")) {
			Collaborator coll = new Collaborator();
			return manageCollaborator.listFields(show, no_id, coll);
		}
		else if (ST.toLowerCase().equals("orientation")) {
			Orientation orien = new Orientation();
			return manageOrientation.listFields(show, no_id, orien);
		}
		else if (ST.toLowerCase().equals("participation")) {
			Participation part = new Participation();
			return manageParticipation.listFields(show, no_id, part);
		}
		else if (ST.toLowerCase().equals("project"))  {
			Project proj = new Project();
			return manageProject.listFields(show, no_id, proj);
		}
		else if (ST.toLowerCase().equals("publication")) {
			Publication pub = new Publication();
			return managePublication.listFields(show, no_id, pub);
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

	public Boolean set_value(String ST, String search_field, String search_value, 
			String field, String new_value) {
		if (ST.toLowerCase().equals("collaborator"))
			return manageCollaborator.set_value(search_field, search_value, field, new_value);
		
		else if (ST.toLowerCase().equals("orientation"))
			return manageOrientation.set_value(search_field, search_value, field, new_value);
		
		else if (ST.toLowerCase().equals("participation"))
			return manageParticipation.set_value(search_field, search_value, field, new_value);	
		
		else if (ST.toLowerCase().equals("project"))
			return manageProject.set_value(search_field, search_value, field, new_value);
		
		else if (ST.toLowerCase().equals("publication"))
			return managePublication.set_value(search_field, search_value, field, new_value);
		
		return false;
	}

	public int get_size(String ST) {
		if (ST.toLowerCase().contains("collaborator"))
			return manageCollaborator.get_size();
		
		else if (ST.toLowerCase().contains("orientation"))
			return manageOrientation.get_size();
		
		else if (ST.toLowerCase().contains("participation"))
			return manageParticipation.get_size();
		
		else if (ST.toLowerCase().contains("project"))
			return manageProject.get_size();
		
		else if (ST.toLowerCase().contains("publication"))
			return managePublication.get_size();
		return 0;
	}

	
	public int search(String ST, String field, String data, int spc_field, Boolean sort_by) {
		if (ST.toLowerCase().equals("collaborator")) {
			Collaborator coll = new Collaborator();
			return manageCollaborator.search(field, data, spc_field, coll, sort_by);
		}
		else if (ST.toLowerCase().equals("orientation")) {
			Orientation orien = new Orientation();
			return manageOrientation.search(field, data, spc_field, orien, sort_by);
		}
		else if (ST.toLowerCase().equals("participation")) {
			Participation part = new Participation();
			return manageParticipation.search(field, data, spc_field, part, sort_by);
		}
		else if (ST.toLowerCase().equals("project")) {
			Project proj = new Project();
			return manageProject.search(field, data, spc_field, proj, sort_by);
		}
		else if (ST.toLowerCase().equals("publication")) {
			Publication pub = new Publication();
			return managePublication.search(field, data, spc_field, pub, sort_by);
		}
	
		return -1;
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

	public void test() {
		invoke_and_add("collaborator", Map.ofEntries(entry("getName", "Maria"), 
											  entry("getEmail", "ma@com"), 
											  entry("getAcademic_degree", "Professor"), 
											  entry("getHistory_project_participation_fk", "0")));
		
		invoke_and_add("collaborator", Map.ofEntries(entry("getName", "João"), 
											  entry("getEmail", "jo@com"), 
											  entry("getAcademic_degree", "Professor"), 
											  entry("getHistory_project_participation_fk", "1")));
		
		invoke_and_add("collaborator", Map.ofEntries(entry("getName", "Camila"), 
											  entry("getEmail", "ma@com"), 
											  entry("getAcademic_degree", "University student"), 
											  entry("getHistory_project_participation_fk", "0")));
		
		invoke_and_add("collaborator", Map.ofEntries(entry("getName", "Valdir"), 
											  entry("getEmail", "va@com"), 
											  entry("getAcademic_degree", "University student"), 
											  entry("getHistory_project_participation_fk", "")));
		
		invoke_and_add("collaborator", Map.ofEntries(entry("getName", "José"), 
											  entry("getEmail", "jos@com"), 
											  entry("getAcademic_degree", "University student"), 
											  entry("getHistory_project_participation_fk", "1")));
		
		invoke_and_add("project", Map.ofEntries(entry("getTitle", "Teste de qualidade da água."), 
										 entry("getFinancing_company", "Coca-Cola"), 
										 entry("getFinancing_amount", "8000"), 
										 entry("getDescription", "Teste de qualidade da água fornecida para faculdade"), 
										 entry("getStart_year", "2021"),
										 entry("getConclusion_year", "2022"),
										 entry("getStatus", "in preparation"), 
										 entry("getCollaborators_fk", "0,2")));

		invoke_and_add("project", Map.ofEntries(entry("getTitle", "Estudo dos efeitos da PLE nos universitarios."), 
										 entry("getFinancing_company", "Ufal"), 
										 entry("getFinancing_amount", "0"), 
										 entry("getDescription", "Analise da qualidade do aprendizado dos universitarios."), 
										 entry("getStart_year", "2023"),
										 entry("getConclusion_year", "2025"), 
										 entry("getStatus", "in preparation"), 
										 entry("getCollaborators_fk", "1,4")));
		

		invoke_and_add("orientation", Map.ofEntries(entry("getDescription", "Orientação artigo sobre PLE"), 
											entry("getActive", "true"), 
											entry("getStart_year", "2023"), 
											entry("getConclusion_year", "2024"), 
											entry("getProfessors_collaborators_fk", "1")));

		invoke_and_add("orientation", Map.ofEntries(entry("getDescription", "Orientação artigo sobre qualidade da água"), 
											entry("getActive", "true"), 
											entry("getStart_year", "2023"), 
											entry("getConclusion_year", "2024"),
											entry("getProfessors_collaborators_fk", "0")));
			
		invoke_and_add("publication", Map.ofEntries(entry("getTitle", "Publicação do artigo sobre PLE"), 
											entry("getConference", "Conferencia Internacional"), 
											entry("getYear", "2023"), 
											entry("getProject_fk", "0"),
											entry("getAuthors_collaborators_fk", "0 2")));
									

		invoke_and_add("publication", Map.ofEntries(entry("getTitle", "Publicação do artigo sobre qualidade da água"),
											entry("getConference", "Conferencia Nacional"), 
											entry("getYear", "2023"), 
											entry("getProject_fk", "1"),
											entry("getAuthors_collaborators_fk", "1 4")));
		
	}
}
