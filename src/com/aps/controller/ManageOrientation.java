package com.aps.controller;

import java.util.Map;

import com.aps.model.Collaborator;
import com.aps.model.Orientation;

public class ManageOrientation extends Manage<Orientation>{
	
	private Manage<Collaborator> ManageCollaborator;

	public ManageOrientation(Manage<Collaborator> ManageCollaborator) {
		this.ManageCollaborator = ManageCollaborator;
	}
	
	public Boolean add(Map<String, String> fields_and_values, Orientation obj) {
		
		obj = invoke_model(fields_and_values, obj);
		
		for (Integer coll_fk: obj.getProfessors_collaborators_fk()) {
			if (ManageCollaborator.get(coll_fk).getAcademic_degree() != "Professor") {
				System.out.println("Não é possivel adicionar um Estudante como Orientador.");
				return false;
			}
		}
		return add(obj);
	}
}
