package com.aps.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.aps.controller.APS;
import com.aps.controller.ManageProject;
import com.aps.model.Collaborator;
import com.aps.model.Orientation;
import com.aps.util.TextCmd;
import com.aps.util.Util;

public class Menu {
	
	Map<String, Object> managers;
	BufferedReader reader;
	String cmd;
	TextCmd text_cmd;
	APS aps;

	public Menu() {
		aps = new APS();
		text_cmd = new TextCmd();
		text_cmd.add("welcome", "Academic Productivity System\nSeja bem vindo!");
		text_cmd.add("home","Selecione uma das seguintes opções para prosseguir:", new ArrayList<String>(Arrays.asList(
				"Gerenciar dados", 
				"Imprimir relatorio de produção academica", 
				"Sair")));
		text_cmd.add("manage_list","Selecione qual setor deseja gerenciar:",  new ArrayList<String>(Arrays.asList(aps.getNamesModels())));
		text_cmd.addOpt("manage_list", "Voltar");
		text_cmd.addOpt("manage_list", "Sair");
		
		text_cmd.add("manage_opt_home","Selecione uma das seguintes opções para prosseguir:", new ArrayList<String>(Arrays.asList(
				"Buscar",
				"Adicionar",
				"Modificar",
				"Excluir",
				"Voltar",
				"Sair")));
		
		text_cmd.add("manage_opt_search","Digite campo e valor para fazer a busca: (Exp: name Valdir)");
		text_cmd.add("manage_opt_search_result","Resultado da busca:");
		text_cmd.add("manage_opt_add","Digite os valores correspondentes aos seguintes campos:");

		text_cmd.add("goodbye","Adeus!");

	}
	
		public void test() {
		Collaborator co = new Collaborator("Valdir", "inv@gmail.com", "humble wise");
		aps.add("collaborator", co);
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
						text_cmd.opt_selected(panel, text_cmd.getHistoryInput(0));
						panel = "manage_list";
						break;
					case 1:
						intro = false;
						text_cmd.opt_selected(panel, text_cmd.getHistoryInput(0));
						aps.academicReport(true);
						text_cmd.opt(panel);
						text_cmd._n(1);
						cmd = reader.readLine();
						text_cmd._n(2);
						break;
					case 2:	
						panel = "0";
						text_cmd.opt_selected(panel, text_cmd.getHistoryInput(0));
						text_cmd.text("goodbye");
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
					case 5:
						intro = true;
						panel = "home";
						break;
					case 6:
						panel = "0";
						text_cmd.text("goodbye");
						break;
					default:
						intro = true;
						text_cmd.getOpt(panel, text_cmd.getHistoryInput(0));
						panel = "manage_opt_home";
					}
				}
				
				
				else if (panel == "manage_opt_home") {
					if (intro) {
						aps.showNameModel(text_cmd.getHistoryInput(0));
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
					case 0:
						intro = true;
						aps.showNameModel(text_cmd.getHistoryInput(1));
						if (aps.listFields(aps.getNamesModels()[text_cmd.getHistoryInput(1)], true) != null) {						
							text_cmd.text("manage_opt_search");
							cmd = reader.readLine();
							text_cmd.text("manage_opt_search_result");		
							aps.search(aps.getNamesModels()[text_cmd.getHistoryInput(1)], cmd.split(" ")[0], cmd.split(" ")[1], 10);
						}
						text_cmd.HistoryInput_remove_last();
						text_cmd._n(1);
						break;
					case 1:
						intro = false;
						text_cmd.getOpt(panel, text_cmd.getHistoryInput(0));
						text_cmd.text("manage_opt_add");
						Map<String, String> fields_and_values = new HashMap<String, String>();
							for (String namefields: aps.listFields(aps.getNamesModels()[text_cmd.getHistoryInput(1)], false)) {
								System.out.print("\n"+Util.StringRemoveGet_(namefields)+":\n>");
								cmd = reader.readLine();
								fields_and_values.put(namefields, cmd);
							}
							aps.add(aps.getNamesModels()[text_cmd.getHistoryInput(1)], fields_and_values);
						
						break;
					case 2:
						intro = true;
						panel = "manage_opt_update";
						break;
					case 3:
						intro = true;
						panel = "manage_opt_delete";
						break;
					case 4:
						intro = true;
						panel = "manage_list";
						break;
					case 5:
						panel = "0";
						text_cmd.text("goodbye");
						break;
					}
				}
			}	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void objects_manage() {
		try { 
			for (Method meth : new Orientation().getClass().getMethods()) {
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
