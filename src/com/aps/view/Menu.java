package com.aps.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.aps.controller.APS;
import com.aps.util.TextCmd;
import com.aps.util.Util;


import static java.util.Map.entry;


public class Menu {
	
	private BufferedReader reader;
	private String cmd;
	private TextCmd text_cmd;
	private String panel = "home";
	private String model = "";
	private Boolean intro = true;
	
	int id_project = 0;
	int id_collab = 0;

	
	APS aps;

	public Menu() {
		aps = new APS();
		text_cmd = new TextCmd();
		text_cmd.add("welcome", "Academic Productivity System\nSeja bem vindo!");
		text_cmd.add("home","Selecione uma das seguintes opções para prosseguir:", new ArrayList<String>(Arrays.asList(
				"Gerenciar dados",
				"Atualizar projetos", 
				"Imprimir relatorio de produção academica", 
				"Sair")));
		text_cmd.add("manage_list","Selecione qual setor deseja gerenciar:",  new ArrayList<String>(Arrays.asList(aps.getNamesModels())));
		text_cmd.addOpt("manage_list", "Voltar");
		text_cmd.addOpt("manage_list", "Sair");
		
		text_cmd.add("manage_opt_home","Selecione uma das seguintes opções para prosseguir:", new ArrayList<String>(Arrays.asList(
				"Buscar",
				"Adicionar",
				"Listar Todos",
				"Voltar",
				"Sair")));
		
		text_cmd.add("manage_opt_search","Digite campo e valor para fazer a busca: (Exp: name Valdir)");
		text_cmd.add("manage_opt_search_result","Resultado da busca:");
		text_cmd.add("manage_opt_add","Digite os valores correspondentes aos seguintes campos:");
		text_cmd.add("manage_opt_error","Algum erro ocorreu durante o processo, deseja tentar novamente?", new ArrayList<String>(Arrays.asList(
				"Sim",
				"Não",
				"Sair")));
		
		text_cmd.add("update_project_home", "Informe qual id do projeto você deseja atualizar:");
	
		text_cmd.add("update_project_opt", "Selecione uma das seguintes opções para prosseguir", new ArrayList<String>(Arrays.asList(
				"Adicionar colaborador ao projeto",
				"Adicionar publicação ao projeto",
				"Atualizar estado do projeto",
				"Voltar",
				"Sair")));

		text_cmd.add("update_project_opt_0", "Escolha e digite os Id(s) correspondente(s) aos colaboradore(s) que você deseja adicionar ao projeto.");
		text_cmd.add("update_project_opt_0_sucess", "Colaborador(s) adicionado(s) ao projeto com sucesso!");

		text_cmd.add("update_project_opt_1", "Escolha e digite os Id(s) correspondente(s) as publicações (s) que você deseja adicionar ao projeto.");
		text_cmd.add("update_project_opt_1_sucess", "Publicações(s) adicionada(s) ao projeto com sucesso!");

		text_cmd.add("update_project_opt_3", "Deseja alterar o status do projeto?", new ArrayList<String>(Arrays.asList(
				"Sim",
				"Não")));

		text_cmd.add("update_project_opt_3_sucess", "O estatus do projeto foi mudado com sucesso para: ");
		
		text_cmd.add("0_or_1", "", new ArrayList<String>(Arrays.asList(
				"Sim",
				"Não")));
				
		
		text_cmd.add("goodbye","Adeus!");

	}
	
	public void test() {
		aps.add("collaborator", Map.ofEntries(entry("getName", "Maria"), 
											  entry("getEmail", "ma@com"), 
											  entry("getAcademic_degree", "Professor"), 
											  entry("getHistory_project_participation_fk", "0")));
		
		aps.add("collaborator", Map.ofEntries(entry("getName", "João"), 
											  entry("getEmail", "jo@com"), 
											  entry("getAcademic_degree", "Professor"), 
											  entry("getHistory_project_participation_fk", "1")));
		
		aps.add("collaborator", Map.ofEntries(entry("getName", "Camila"), 
											  entry("getEmail", "ma@com"), 
											  entry("getAcademic_degree", "University student"), 
											  entry("getHistory_project_participation_fk", "0")));
		
		aps.add("collaborator", Map.ofEntries(entry("getName", "Valdir"), 
											  entry("getEmail", "va@com"), 
											  entry("getAcademic_degree", "University student"), 
											  entry("getHistory_project_participation_fk", "")));
		
		aps.add("collaborator", Map.ofEntries(entry("getName", "José"), 
											  entry("getEmail", "jos@com"), 
											  entry("getAcademic_degree", "University student"), 
											  entry("getHistory_project_participation_fk", "1")));
		
		aps.add("project", Map.ofEntries(entry("getTitle", "Teste de qualidade da água."), 
										 entry("getFinancing_company", "Coca-Cola"), 
										 entry("getFinancing_amount", "8000"), 
										 entry("getDescription", "Teste de qualidade da água fornecida para faculdade"), 
										 entry("getStart_year", "2021"),
										 entry("getConclusion_year", "2022"),
										 entry("getStatus", "in preparation"), 
										 entry("getCollaborators_fk", "0,2")));

		aps.add("project", Map.ofEntries(entry("getTitle", "Estudo dos efeitos da PLE nos universitarios."), 
										 entry("getFinancing_company", "Ufal"), 
										 entry("getFinancing_amount", "0"), 
										 entry("getDescription", "Analise da qualidade do aprendizado dos universitarios."), 
										 entry("getStart_year", "2023"),
										 entry("getConclusion_year", "2025"), 
										 entry("getStatus", "in preparation"), 
										 entry("getCollaborators_fk", "1,4")));
		

		aps.add("orientation", Map.ofEntries(entry("getDescription", "Orientação artigo sobre PLE"), 
												entry("getActive", "true"), 
												entry("getStart_year", "2023"), 
												entry("getConclusion_year", "2024"), 
												entry("getProfessors_collaborators_fk", "1")));

		aps.add("orientation", Map.ofEntries(entry("getDescription", "Orientação artigo sobre qualidade da água"), 
											entry("getActive", "true"), 
											entry("getStart_year", "2023"), 
											entry("getConclusion_year", "2024"),
											entry("getProfessors_collaborators_fk", "0")));
			
		aps.add("publication", Map.ofEntries(entry("getDescription", "Publicação do artigo sobre PLE"), 
											entry("getConference", "Conferencia Internacional"), 
											entry("getYear", "2023"), 
											entry("getProject", "0"),
											entry("getAuthors_collaborators_fk", "0 2")));
									

		aps.add("publication", Map.ofEntries(entry("getDescription", "Publicação do artigo sobre qualidade da água"),
											entry("getConference", "Conferencia Nacional"), 
											entry("getYear", "2023"), 
											entry("getProject", "1"),
											entry("getAuthors_collaborators_fk", "1 4")));
	}
	
	public void start() {
		try {
			reader = new BufferedReader(new InputStreamReader(System.in));
			text_cmd.textln("welcome",1);			
			
			while (!panel.equals("0")) {
								
				if (panel == "home") {
					panel_home();
				
				} else if (panel == "manage_list") {
					panel_manage_list();
				}
				
				else if (panel == "manage_opt_home") {
					panel_manage_opt_home();
				}
				
				else if (panel == "update_project_home") {
					panel_update_project_home();
				}
			}	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void panel_home() throws IOException {
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
			intro = true;
			text_cmd.opt_selected(panel, text_cmd.getHistoryInput(0));
			panel = "update_project_home";
			break;
		case 2:
			intro = false;
			text_cmd.opt_selected(panel, text_cmd.getHistoryInput(0));
			aps.academicReport(true);
			text_cmd.opt(panel);
			text_cmd._n(1);
			cmd = reader.readLine();
			text_cmd._n(2);
			break;
		case 3:	
			panel = "0";
			text_cmd.text("goodbye");
			break;
		}
	}
	
	private void panel_manage_list() throws IOException {
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
		case 8:
			intro = true;
			panel = "home";
			break;
		case 6:
			panel = "0";
			text_cmd.text("goodbye");
			break;
		default:
			intro = true;
			model = text_cmd.getOpt(panel, text_cmd.getHistoryInput(0));
			panel = "manage_opt_home";
		}
	}
	
	private void panel_manage_opt_home() throws IOException {
		if (intro) {					
			System.out.println(model);
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
			System.out.println(model);
			if (aps.listFields(model, true) != null) {						
				text_cmd.text("manage_opt_search");
				cmd = reader.readLine();
				text_cmd._n(1);
				text_cmd.text("manage_opt_search_result");		
				aps.search(model, cmd.split(" ")[0], cmd.split(" ")[1], 8, false);
			}
			text_cmd.HistoryInput_remove_last();
			text_cmd._n(1);
			break;

		case 1:
			intro = true;
			text_cmd.text("manage_opt_add");
			
			Map<String, String> fields_and_values = new HashMap<String, String>();
			for (String namefields: aps.listFields(model, false)) {
				

				if (namefields.contains("fk")) {

					if (aps.get_size(Util.fk_name(namefields, true))>0) {
						System.out.println("\n"+Util.StringRemoveGet_(namefields)+
								"\nDigite o Id(s) que deseja associar a este modelo.");
						
						aps.show_all(Util.fk_name(namefields, true), 8, false);
						System.out.print(">");
						
						cmd = reader.readLine();
						fields_and_values.put(namefields, cmd);
					
					} else {
						System.out.println("\n"+Util.StringRemoveGet_(namefields)+
								"\nNão existe nenhum valor relacionado a esse objeto no banco de dados.");	
						text_cmd._n(1);
					}
					
				} else if (!namefields.toLowerCase().contains("id"))  {	
					System.out.print("\n"+Util.StringRemoveGet_(namefields)+":\n>");
					cmd = reader.readLine();
					fields_and_values.put(namefields, cmd);
				}
			}
			if (!aps.add(model, fields_and_values)) {
				text_cmd.text("manage_opt_error");
				text_cmd.opt("0_or_1");
				cmd = reader.readLine();				
				switch (text_cmd.selected("0_or_1", cmd)) {
				case -1:
					intro = false;
					text_cmd.opt("0_or_1");	
					cmd = reader.readLine();
					text_cmd._n(2);
					break;
				case 0:
					intro = true;
					panel = "manage_list";
					break;
				case 1:
					panel = "0";
					text_cmd.text("goodbye");
					break;
				}
			} else {
				System.out.println(model+" adicionado com sucesso!\n\n");							
			}
			break;
		case 2:
			intro = true;
			panel = "manage_opt_home";
			text_cmd.text("manage_opt_search_result");		
			aps.show_all(model,8, false);
			break;
		case 3:
			intro = true;
			panel = "manage_list";
			break;
		case 4:
			panel = "0";
			text_cmd.text("goodbye");
			break;
		}
	}
	
	private void panel_update_project_home() throws IOException {
		
		if (aps.get_size("Project") > 0) {
			text_cmd.text(panel);
			aps.show_all("Project",8, true);
			System.out.print(">Id:");
			cmd = reader.readLine();
			text_cmd._n(1);
	
			int id = Integer.parseInt(cmd);
			if (!aps.get_value("Project", id, "Id").equals("")) {
				panel = "update_project_opt";
				text_cmd.text(panel);
				text_cmd.opt(panel);
				cmd = reader.readLine();
				
				switch (text_cmd.selected(panel, cmd)) {
				case -1:
					text_cmd.opt(panel);	
					cmd = reader.readLine();
					text_cmd._n(2);
					break;
				case 0:					
					if (aps.get_size("Collaborator") > 0) {
						aps.show_all("Collaborator", 8, true);
						String colls = reader.readLine();
						
						if (Util.Str2ArrayList(colls) != null) {
							for (String str_coll_id: Util.Str2ArrayList(colls)) {
								if(!aps.get_value("Collaborator", Integer.parseInt(str_coll_id), "Id").equals("")) {
									aps.add_collaborator_project(id, Integer.parseInt(str_coll_id));
								}
							}
						} else {
							if(!aps.get_value("Collaborator", Integer.parseInt(colls), "Id").equals("")) {
								aps.add_collaborator_project(id, Integer.parseInt(colls));
							}
						}
						
						text_cmd.text("update_project_opt_0_sucess");

					} else {
						System.out.println("Não exites nenhuma opção para adicionar ao projeto no momento.");
					}
					
					intro = true;
					panel = "home";
					text_cmd._n(2);
					break;
				
				case 1:
					if (aps.get_size("Publication") > 0) {
						aps.show_all("Publication", 8, true);
						String colls = reader.readLine();
						
						if (Util.Str2ArrayList(colls) != null) {
							for (String str_coll_id: Util.Str2ArrayList(colls)) {
								if(!aps.get_value("Publication", Integer.parseInt(str_coll_id), "Id").equals("")) {
									aps.add_collaborator_project(id, Integer.parseInt(str_coll_id));
								}
							}
						} else {
							if(!aps.get_value("Publication", Integer.parseInt(colls), "Id").equals("")) {
								aps.add_collaborator_project(id, Integer.parseInt(colls));
							}
						}
						text_cmd.text("update_project_opt_0_sucess");
					
					} else {
						System.out.println("Não exites nenhuma opção para adicionar ao projeto no momento.");
					}
					
					intro = true;
					panel = "home";
					text_cmd._n(2);
					break;

				case 2:
					
					text_cmd.text("update_project_opt_3");
					System.out.println("Status atual: "+aps.get_value("Project", id, "getStatus"));
					
					text_cmd.opt("update_project_opt_3");					
					cmd = reader.readLine();
					
					switch (text_cmd.selected("0_or_1", cmd)) {
					case -1:
						intro = false;
						text_cmd.opt("0_or_1");	
						cmd = reader.readLine();
						text_cmd._n(2);
						break;
					case 0:
						text_cmd.text("update_project_opt_3_sucess");
						aps.nextStatus(id);
						System.out.println(aps.get_value("Project", id, "getStatus"));
						intro = true;
						panel = "home";
						text_cmd._n(2);		
					break;
					case 1:
						intro = true;
						panel = "home";
						text_cmd._n(2);		
					}
					
				case 3:
					intro = true;
					panel = "home";
					text_cmd._n(2);
					break;
				case 4:
					panel = "0";
					text_cmd.text("goodbye");
					break;
				}
				
			}
		} else {
			System.out.println("Não existe nenhum projeto no banco de dados.");
			panel = "home";
			intro = true;
		}
	}
}
