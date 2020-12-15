package com.aps.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

import com.aps.model.Collaborator;
import com.aps.model.Participation;
import com.aps.model.Project;

public class ManageProject extends Manage<Project> {
	
	private Manage<Collaborator> ManageCollaborator;
	private Manage<Participation> ManageParticipation;
	
	public ManageProject(Manage<Collaborator> ManageCollaborator, Manage<Participation> ManageParticipation) {
		this.ManageCollaborator = ManageCollaborator;
		
		this.ManageParticipation= ManageParticipation;
	}
	
	public Boolean add(Map<String, String> fields_and_values, Project obj) {

		obj = invoke_model(fields_and_values, obj);	
		if (obj.getStatus() == null) {	
			System.out.println("Não é possivel adicionar este projeto a este projeto, falta informar seu status");
			return false;
		}
		
		if (!obj.getStatus().equals("in preparation") && 
			obj.getCollaborators_fk() != null) {
			
			System.out.println("Não é possivel adicionar esse colaborador a este projeto, "
					+ "pois o projeto não esta em preparação.");						
			return false;
		}

		Boolean exist_professor = false;
		
		if (obj.getCollaborators_fk() != null) {
			for (Integer coll_fk: obj.getCollaborators_fk()) {
				
				Collaborator coll = ManageCollaborator.get(coll_fk);
				
				if (coll.getAcademic_degree().equals("Professor")) {
					exist_professor = true;
					
				} else if (coll.getAcademic_degree() == "University student") {
					for (int part_fk: coll.getHistory_project_participation_fk()) {
						Participation part = ManageParticipation.get(part_fk);
						if (part != null && part.getActive()) {
							if (get(part.getProject_fk()).getStatus() == "in progress") {
								System.out.println("Aluno ja esta em um projeto em andamento.");
								return false;
							}
						}
					}	
				}
			}
		}
		if (exist_professor) {
			return add(obj);
		} else {
			System.out.println("Este projeto precisa de no minimo um professor.");			
		}
		
		if (obj.getStatus() == "in progress" && obj.getCollaborators_fk().size() == 0) {
			System.out.println("Este projeto precisa de colaboradores.");			
		}
		
		return false;
	}
	
	public Boolean add_collaborator_project(int id_project, int coll_fk) {

			for (Integer coll_id: obj_list.get(id_project).getCollaborators_fk()) {
				if (coll_id == coll_fk) {
					System.out.print("Esse colaborador ja participa deste projeto");
					return false;
				}
			}
		
			if (obj_list.get(id_project).getStatus() != "in preparation") {
				System.out.println("Não é possivel adicionar esse colaborador a este projeto, "
						+ "pois o projeto não esta em preparação.");						
				return false;
			}
	
			Collaborator coll = ManageCollaborator.get(coll_fk);
			
			for (int part_fk: coll.getHistory_project_participation_fk()) {
				Participation part = ManageParticipation.get(part_fk);
				if (part.getActive()) {
					if (get(part.getProject_fk()).getStatus() == "in progress") {
						System.out.println("Aluno "+coll.getId()+":"+coll.getName()+" ja esta em um projeto em andamento.");
						return false;
					}
				}
			}
			
			ManageCollaborator.get(coll_fk).getHistory_project_participation_fk().add(id_project);
			
			return obj_list.get(id_project).getCollaborators_fk().add(coll_fk);
	}
	
	public Boolean add_publication_project(int id_project, int publication_fk) {
		
		if (obj_list.get(id_project).getStatus() != "in preparation") {
			System.out.println("Não é possivel adicionar publicação a este projeto.");						
			return false;
		}	
		
		return obj_list.get(id_project).getPublications_fk().add(publication_fk);
		
	}
	
	public String nextStatus(int id) {
		
		if (obj_list.get(id).getStatus() == null) {
			obj_list.get(id).setStatus("in preparation");
		}
		
		if (obj_list.get(id).getStatus().equals("in preparation")) {
			obj_list.get(id).setStatus("in progress");		
		} else if (obj_list.get(id).getStatus().equals("in progress")) {
			obj_list.get(id).setStatus("concluded");			
		} else {
			obj_list.get(id).setStatus("in preparation");
		}
		
		return obj_list.get(id).getStatus();
	}
	
	public String academicReport(Boolean show) {
		
		int[] info = {0,0,0,0,0,0,0};
		
		for (Project proj: obj_list) {
			
			info[0] += proj.getCollaborators_fk().size();
			
			if (proj.getStatus() == "in preparation")
				info[1] += 1;
			else if (proj.getStatus() == "in progress")
				info[2] += 1;
			else if (proj.getStatus() == "concluded")
				info[3] += 1;

			
			info[5] += proj.getPublications_fk().size();
			info[6] += proj.getOrientations_fk().size();

		}
		
		info[4] = obj_list.size();
		
		String report = "Número de colaboradores: "+info[0]
					+ "\nNúmero de projetos em elaboração: "+info[1]
					+ "\nNúmero de projetos em andamento: "+info[2]
					+ "\nNúmero de projetos concluídos: "+info[3]
					+ "\nNúmero total de projetos: "+info[4]
					+ "\nNúmero de produção acadêmica por tipo de produção:"
					+ "\n	Publicações: "+info[5]
					+ "\n	Orientações: "+info[6];
			
				
		if (show) 
			System.out.println(report);
		
		return report;
	}
	
	protected ArrayList<Project> get_obj_list(Boolean sort_by) {
		if (sort_by) {
			return (ArrayList<Project>) obj_list
					.stream().sorted(Comparator.comparing(Project::getStart_year).reversed())
					.collect(Collectors.toList());
		}
		return obj_list;
	}
	
}
