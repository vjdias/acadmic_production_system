package com.aps;
import com.aps.util.Util;
import com.aps.view.Menu;


public class AcademicProductivitySystem {

	public static void main(String args[]) {
		Menu menu = new Menu();
		menu.test();

		menu.start();
		System.out.println(Util.fk_name("getCollaborators_fk", true));
	}
}
