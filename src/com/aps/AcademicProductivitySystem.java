package com.aps;
import com.aps.model.*;

import java.lang.reflect.Method;

import com.aps.controller.*;

public class AcademicProductivitySystem {

	@SuppressWarnings("unchecked")
	public static void main(String args[]) {
		
//		Manage<Publication> ManagePublication = new Manage<Publication>(); 
		Manage<Collaborator> ManageCollaborator = new Manage<Collaborator>();
		Manage<Participation> ManageParticipation = new Manage<Participation>();
		
		ManageProject prjm = new ManageProject(ManageCollaborator, ManageParticipation);
		Project prj = new Project("Projeto da uiu");
		prjm.add(prj);

		Project prj1 = new Project("");
		
		if (prjm.get("getTitle", "Projeto da uiu").size() > 0) {
			prj1 = prjm.get("getTitle", "Projeto da uiu").get(0);
		}
		
		System.out.println(prj1.getTitle());
		
		Manage<Collaborator> mColl = new Manage<Collaborator>();
		mColl.add(new Collaborator("Valdir", "inv@gmail.com", "university student"));

		System.out.println(mColl.get("name ", "Valdir").toString());
		System.out.println(mColl.get("getname", "Valdir").toString());

		try { 
			for (Method meth : new Production().getClass().getMethods()) {
				String _name = meth.getName();
				if (_name.length() > 12) {

//					System.out.println(_name);
					//System.out.print(_name.substring(9, _name.length()-3));
					//System.out.println(_name.substring(_name.length()-3));

					
					if (_name.substring(0, 9).equals("toString_") && _name.substring(_name.length()-3).equals("_fk")) {
						System.out.println(_name.substring(9, _name.length()-3));
					}
				}
			}
			
			Class<Manage<Collaborator>> manageClass = (Class<Manage<Collaborator>>) Class.forName("com.aps.controller.Manage");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
}
