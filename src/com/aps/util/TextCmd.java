package com.aps.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TextCmd {
	private String name;
	private String text;
	private ArrayList<String> opt;
	private int last_opt;
	private String last_name;
	private Map<String, TextCmd> all_texts;
	
	public TextCmd() {
		last_name = "";
		all_texts = new HashMap<String, TextCmd>();
	}
	
	public TextCmd(String name, String text) {
		last_name = "";
		this.name = name;
		this.text = text;
	}
	
	public TextCmd(String name, String text, ArrayList<String> opt) {
		last_name = "";
		this.name = name;
		this.text = text;
		this.opt = opt;
	}	
	
	public void add(String name, String text, ArrayList<String> cmd) {
		all_texts.put(name, new TextCmd(name, text, cmd));
	}

	public void add(String name, String text) {
		all_texts.put(name, new TextCmd(name, text));
	}
	
	public void textln(String name, int bn) {
		System.out.println(this.all_texts.get(name).text+"\n".repeat(bn));
		last_name = name;
	}

	public void text(String name) {
		System.out.println(this.all_texts.get(name).text);		
		last_name = name;
	}

	public void opt(String name) {
		String all_opt = "";
		for (int i = 0; i < all_texts.get(name).opt.size(); i++) {
			all_opt += i+":"+all_texts.get(name).opt.get(i)+"\n";
		}
		System.out.print(all_opt+">");
	}
	
	public void _n(int n) {
		System.out.print("\n".repeat(n));
	}
 	
	public int selected(String name, String option) {
		for (int i = 0; i < all_texts.get(name).opt.size(); i++) {
			if (option.equals(Integer.toString(i)) || 
					option.toLowerCase().equals(all_texts.get(name).opt.get(i).toLowerCase())) {
				last_opt = i;
				return i;
			}			
		}
		System.out.println("Por favor digite uma opção valida");
		return -1;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getOpt(String name, int id) {
		return all_texts.get(name).opt.get(id);
	}

	public void setOpt(ArrayList<String> opt) {
		this.opt = opt;
	}

	public int getLast_opt() {
		return last_opt;
	}

	public void setLast_opt(int last_opt) {
		this.last_opt = last_opt;
	}

	public Map<String, TextCmd> getAll_texts() {
		return all_texts;
	}

	public void setAll_texts(Map<String, TextCmd> all_texts) {
		this.all_texts = all_texts;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	

}
