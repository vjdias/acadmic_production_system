package com.aps.controller;

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
	
	public Boolean add(Project obj) {
		Boolean exist_professor = false;
		
		if (obj.getCollaborators_fk() != null) {
			for (Integer coll_fk: obj.getCollaborators_fk()) {
				
				Collaborator coll = ManageCollaborator.get(coll_fk);
				
				if (coll.getAcademic_degree() == "Professor") {
					exist_professor = true;
					
				} else if (coll.getAcademic_degree() == "University student") {
					for (int part_fk: coll.getHistory_project_participation_fk()) {
						Participation part = ManageParticipation.get(part_fk);
						if (part.getActive()) {
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
			obj.setId(obj_list.size());
			return obj_list.add(obj);
		} else {
			System.out.println("Este projeto precisa de no minimo um professor.");			
		}
		
		if (obj.getStatus() == "in progress" && obj.getCollaborators_fk().size() == 0) {
			System.out.println("Este projeto precisa de colaboradores.");			
		}
		
		return false;
	}
	
	public Boolean add_collaborator_project(int id_project, int coll_fk) {
		if (obj_list.get(id_project).getStatus() != "in preparation") {
			System.out.println("Não é possivel adicionar colaborador a este projeto.");						
			return false;
		}

		Collaborator coll = ManageCollaborator.get(coll_fk);
		
		for (int part_fk: coll.getHistory_project_participation_fk()) {
			Participation part = ManageParticipation.get(part_fk);
			if (part.getActive()) {
				if (get(part.getProject_fk()).getStatus() == "in progress") {
					System.out.println("Aluno ja esta em um projeto em andamento.");
					return false;
				}
			}
		}
		
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
		if (obj_list.get(id).getStatus().equals("in preparation")) {
			obj_list.get(id).setStatus("in progress");		
		} else if (obj_list.get(id).getStatus().equals("in progress")) {
			obj_list.get(id).setStatus("concluded");			
		} else {
			obj_list.get(id).getStatus().equals("in preparation");
		}
		
		return obj_list.get(id).getStatus();
	}
	
	public String academicReport (Boolean show) {
		
		int[] info = {0,0,0,0,0,0};
		
		for (Project proj: obj_list) {
			
			info[0] += proj.getCollaborators_fk().size();
			
			if (proj.getStatus() == "in preparation")
				info[1] += 1;
			else if (proj.getStatus() == "in progress")
				info[2] += 1;
			else if (proj.getStatus() == "concluded")
				info[3] += 1;
		}
		
		
		String report = "Número de colaboradores: "
					+ "\nNúmero de projetos em elaboração: "
					+ "\nNúmero de projetos em andamento\n"
					+ "\nNúmero de projetos concluídos\n"
					+ "\nNúmero total de projetos\n"
					+ "\nNúmero de produção acadêmica por tipo de produção";
			
				
		if (show) 
			System.out.println(report);
		
		return report;
	}

	public Boolean remove(int id_project) {
		try {			
			if (obj_list.remove(obj_list.get(id_project))) {
				for (int i = id_project; i < obj_list.size(); i++) {
					obj_list.get(id_project).setId(obj_list.get(id_project).getId() - 1);			
				}
				return true;
			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Erro->Índice fornecido não existe nos dados");
			System.out.println("      Índice: "+id_project+", Indices disponiveis de 0 a "+obj_list.size()+".");
		}
		return false;
	}
}
