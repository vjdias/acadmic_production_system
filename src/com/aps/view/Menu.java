package com.aps.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.aps.controller.Manage;
import com.aps.controller.ManageProject;
import com.aps.model.Collaborator;
import com.aps.model.Participation;
import com.aps.model.Production;
import com.aps.model.Publication;
import com.aps.util.TextCmd;

public class Menu {
	
	Map<String, Object> managers;
	BufferedReader reader;
	String cmd;
	TextCmd text_cmd;

	@SuppressWarnings("unchecked")
	public Menu() {
		managers = new HashMap<String, Object>();
		managers.put("Collaborator", new Manage<Collaborator>());
		managers.put("Participation", new Manage<Collaborator>());
		managers.put("Production", new Manage<Production>());
		managers.put("Project", new ManageProject((Manage<Collaborator>) managers.get("Collaborator"), (Manage<Participation>)managers.get("Participation")));
		managers.put("Publication", new Manage<Publication>());
			
		text_cmd = new TextCmd();
		text_cmd.add("welcome", "Academic Productivity System\nSeja bem vindo!");
		text_cmd.add("home","Selecione uma das seguintes opções para prosseguir:", new ArrayList<String>(Arrays.asList(
				"Gerenciar dados", 
				"Imprimir relatorio de produção academica", 
				"Sair")));
		
		text_cmd.add("manage_list","Selecione qual setor deseja gerenciar:", new ArrayList<String>(managers.keySet()));
	}
	
	public void start() {
		try {
			reader = new BufferedReader(new InputStreamReader(System.in));
			String panel = "home";
			Boolean intro = true;
			
			text_cmd.textln("welcome",1);
			
			while (!panel.equals("0")) {
				
				if (panel == "home") {
					if (intro) {
						text_cmd.text(panel);
						text_cmd.opt(panel);	
						cmd = reader.readLine();
						text_cmd._n(2);
					}
					
					switch (text_cmd.selected(panel, cmd)) {
					case -1:
						intro = false;
						text_cmd.opt(panel);	
						cmd = reader.readLine();
						text_cmd._n(2);
						break;
					case 0:
						intro = true;
						panel = "manage_list";
						break;
					case 1:
						intro = false;

						
						
						break;
					case 2:	
						panel = "0";
						break;
					}
				}
				
				
				else if (panel == "manage_list") {
					if (intro) {
						text_cmd.text(panel);
						text_cmd.opt(panel);	
						cmd = reader.readLine();
						text_cmd._n(2);
					}
					
					switch (text_cmd.selected(panel, cmd)) {
					case -1:
						text_cmd.opt(panel);	
						cmd = reader.readLine();
						text_cmd._n(2);
						break;
					default:
						intro = true;
						text_cmd.getOpt(panel, text_cmd.getLast_opt());
						System.out.println(text_cmd.getOpt(panel, text_cmd.getLast_opt()));
					}
				}
				
				else if (panel == "") {
					
				}

			}	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void objects_manage() {
		try { 
			for (Method meth : new Production().getClass().getMethods()) {
				String _name = meth.getName();
				if (_name.length() > 12) {				
					if (_name.substring(0, 9).equals("toString_") && _name.substring(_name.length()-3).equals("_fk")) {
						System.out.println(_name.substring(9, _name.length()-3));
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
