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

	public Menu(Boolean test) {
		aps = new APS();
		
		if (test)
			aps.test();
		
		text_cmd = new TextCmd();
		text_cmd.clear_text();
		text_cmd.add("write", ">");
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
				"Atualizar",
				"Listar Todos",
				"Voltar",
				"Sair")));
		
		text_cmd.add("manage_opt_error_exceeds_size","Por favor escolha uma opção entre 0 e ");
		text_cmd.add("manage_opt_error_!int", "Por favor digite valor(es) inteiro(s) no campo ");
		text_cmd.add("manage_opt_error","Algum erro ocorreu durante o processo, deseja tentar novamente?", new ArrayList<String>(Arrays.asList(
				"Sim",
				"Não",
				"Sair")));
		
		text_cmd.add("manage_opt_search","Digite campo e valor para fazer a busca: (Exp: name Valdir)");
		text_cmd.add("manage_opt_search_error","Por favor digite a busca como este exemplo: 'Campo Valor'");
		text_cmd.add("manage_opt_search_result","Resultado da busca:");
		
		text_cmd.add("manage_opt_add","Digite os valores correspondentes aos seguintes campos:");	
		text_cmd.add("manage_opt_add_fk_opt", "Deseja adicionar este modelo a dados existentes ou a um novo?", new ArrayList<String>(Arrays.asList(
				"Criar um novo modelo para a associação", 
				"Adicionar a um modelo existente", 
				"Não adicionar")));
		text_cmd.add("manage_opt_add_sucess", " adicionado com sucesso!");
		text_cmd.add("manage_opt_add_association", "\nDigite o Id(s) que deseja associar a este modelo.");
		
		text_cmd.add("manage_opt_update_sucess", " atualizado com sucesso!");
		text_cmd.add("manage_opt_update_opt_model", "\nBusque o(s) modelo(s) que deseja modificar.");
		text_cmd.add("manage_opt_update_opt_model_id", "\nDigite o id do modelo que deseja modificar.");
		text_cmd.add("manage_opt_update_opt_model_fields", "\nOs seguintes campos estão disponíveis para alterações,"
				+ " escolha o seu novo valor digitando em após o nome do campo.");

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

	public void start() {
		try {
			reader = new BufferedReader(new InputStreamReader(System.in));
			text_cmd.textln("welcome", 1);			
			
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
			text_cmd.clear_text();
			break;
		case 1:
			intro = true;
			text_cmd.opt_selected(panel, text_cmd.getHistoryInput(0));
			panel = "update_project_home";
			text_cmd.clear_text();
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
		case 5:
			text_cmd.clear_text();
			intro = true;
			panel = "home";
			text_cmd.clear_text();
			break;
		case 6:
			panel = "0";
			text_cmd.text("goodbye");
			break;
		default:
			intro = true;
			model = text_cmd.getOpt(panel, text_cmd.getHistoryInput(0));
			panel = "manage_opt_home";
			text_cmd.clear_text();
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
			if (aps.listFields(model, true, false) != null) {						
				text_cmd.text("manage_opt_search");
				cmd = reader.readLine();
				text_cmd._n(1);
				text_cmd.text("manage_opt_search_result");
				if (Util.verify_separator(cmd).equals(" ")) {
					aps.search(model, cmd.split(" ")[0], cmd.split(" ")[1], 8, false);
				} else {
					text_cmd.text("manage_opt_search_error");
				}
			}
			text_cmd.HistoryInput_remove_last();
			text_cmd._n(1);
			break;
		case 1:
			intro = true;
			panel_manage_opt_add(model);
			break;
		case 2:
			text_cmd.text("manage_opt_update_opt_model");
			aps.show_all(model,8, false);
			text_cmd.text("write");
			String cmd1 = reader.readLine(); 
			if (Util.verify_separator(cmd1).equals(" ")) {
				
				if (aps.search(model, cmd1.split(" ")[0], cmd1.split(" ")[1], 8, false) == 1) {
					
					text_cmd.text("manage_opt_update_opt_model_fields");

					aps.listFields(model, true, true);
					text_cmd.textln("write",0);
					cmd = reader.readLine();
					
					if (Util.verify_separator(cmd).equals(" ")) {
						if (aps.set_value(model, cmd1.split(" ")[0], cmd1.split(" ")[1]					
								,cmd.split(" ")[0], cmd.split(" ")[1]))
							text_cmd.text("manage_opt_update_sucess");
					}
					
				} else {
					text_cmd.text("manage_opt_update_opt_model_id");
					cmd = reader.readLine(); 
					
					if (Util.verify_separator(cmd).equals(" ")) {
						if (aps.set_value(model, cmd1.split(" ")[0], cmd1.split(" ")[1]					
								,cmd.split(" ")[0], cmd.split(" ")[1]))
							text_cmd.text("manage_opt_update_sucess");

					} else {
						text_cmd.text("manage_opt_search_error");
					}					
				}
			
			} else {
				text_cmd.text("manage_opt_search_error");
			}
			
			break;
		case 3:
			text_cmd.clear_text();
			intro = true;
			panel = "manage_opt_home";
			text_cmd.text("manage_opt_search_result");		
			aps.show_all(model,8, false);
			break;
		case 4:
			text_cmd.clear_text();
			intro = true;
			panel = "manage_list";
			break;
		case 5:
			panel = "0";
			text_cmd.text("goodbye");
			break;
		}
	}
	
	private void panel_update_project_home() throws IOException {
		
		if (aps.get_size("Project") > 0) {
			text_cmd.text(panel);
			aps.show_all("Project",8, true);
//			System.out.print(">Id:");
			
			text_cmd.textln("write","Id:",true,0);
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
					text_cmd.clear_text();
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
	
	private int panel_manage_opt_add(String model) throws IOException {
		
		text_cmd.text("manage_opt_add");
		Boolean error = true;
		Map<String, String> fields_and_values = new HashMap<String, String>();

//		Boolean first_fk = false;
		int id_model = 0;
		for (String namefields: aps.listFields(model, false, false)) { 
			error = true;
			while(error) {
				try {
					if (namefields.contains("fk")) {
						System.out.println(Util.StringRemoveGet_(namefields)+":");
						if (aps.get_size(Util.fk_name(namefields, true))>0) {
							panel = "manage_opt_add_fk_opt";
							text_cmd.text(panel);
							text_cmd.opt(panel);
							cmd = reader.readLine();
							
							switch (text_cmd.selected(panel, cmd)) {
							case -1:
								break;
							case 0:
								fields_and_values.put(namefields, String.valueOf(panel_manage_opt_add(Util.fk_name(namefields, true))));
								break;
							case 1:
								
								String separator = "";
								text_cmd.text("manage_opt_add_association", Util.StringRemoveGet_(namefields), false);
								
								aps.show_all(Util.fk_name(namefields, true), 8, false);
								
								text_cmd.textln("write", 0);
								
								cmd = reader.readLine();
								separator = Util.verify_separator(cmd);
								
								if (!separator.equals("")) {
									for (String id: cmd.split(separator)) {
										if (!aps.get_value(Util.fk_name(namefields, true), Integer.parseInt(id), "Id").equals("-2")) {
											fields_and_values.put(namefields, cmd);
											error = false;
										} else {
											text_cmd.text("manage_opt_error_exceeds_size", (aps.get_size(namefields)-1));
										}
									}
									
								} else {
									if (!aps.get_value(Util.fk_name(namefields, true), Integer.parseInt(cmd), "Id").equals("-2")) {
										fields_and_values.put(namefields, cmd);
										error = false;
									} else {
										text_cmd.text("manage_opt_error_exceeds_size", (aps.get_size(namefields)-1));
									}
								}
								
								break;
							case 2:
								error = false;
								break;
							}
							
						} else {
							//fields_and_values.put(namefields, "0");
							text_cmd._n(1);
							error = false;

						}
//9						first_fk = false;
						
					} else if (!namefields.toLowerCase().contains("id"))  {
						text_cmd.textln("write",Util.StringRemoveGet_(namefields)+":\n",false, 0);
						cmd = reader.readLine();
						fields_and_values.put(namefields, cmd);
						error = false;

					} else {
						error = false;
					}
					
				} catch (NumberFormatException e) {
					text_cmd.text("manage_opt_error_!int",Util.StringRemoveGet_(namefields), true);
				}
			}
			text_cmd._n(1);
		}
		id_model = aps.invoke_and_add(model, fields_and_values);
		if (id_model >= 0) {
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
			text_cmd.clear_text();
			text_cmd.text("manage_opt_add_sucess",model, false);
			panel = "manage_opt_home";
			return 1;
		}
		return id_model;
	}
	
}
