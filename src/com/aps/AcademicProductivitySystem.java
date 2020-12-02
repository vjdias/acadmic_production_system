package com.aps;
import com.aps.model.*;
import com.aps.controller.*;

public class AcademicProductivitySystem {

	public static void main(String args[]) {

		ProjectManager prjm = new ProjectManager();
		Project prj = new Project("Projeto da uiu");
		prjm.add(prj);

		Project prj1 = new Project("");
		
		if (prjm.get("getTitle", "Projeto da uiu").size() > 0) {
			prj1 = prjm.get("getTitle", "Projeto da uiu").get(0);
		}
		
		System.out.println(prj1.getTitle());
	}
}
