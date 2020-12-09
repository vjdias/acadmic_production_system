package com.aps.controller;

import com.aps.model.Collaborator;
import com.aps.model.Orientation;

public class ManageOrientation extends Manage<Orientation>{
	
	private Manage<Collaborator> ManageCollaborator;

	public ManageOrientation(Manage<Collaborator> ManageCollaborator) {
		this.ManageCollaborator = ManageCollaborator;
	}
	
	public Boolean add(Orientation obj) {
		
		for (Integer coll_fk: obj.getProfessors_collaborators_fk()) {
			if (ManageCollaborator.get(coll_fk).getAcademic_degree() != "Professor") {
				System.out.println("Não é possivel adicionar um Estudante como Orientador.");
				return false;
			}
		}
		return true;
	}
}
