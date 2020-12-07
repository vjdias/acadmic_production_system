package com.aps.controller;
import java.util.ArrayList;
import java.util.Date;

import com.aps.model.Model;
import com.aps.util.Util;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;

public class Manage<T extends Model> {
	protected ArrayList<T> obj_list = new ArrayList<T>();
	
	public Boolean add(T obj) {
		((Model) obj).setId(obj_list.size());
		return obj_list.add(obj);
	}
	
	public Boolean update(int id, T new_obj) {
		try {
			obj_list.set(id, new_obj);
			return true;			
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Erro->Índice fornecido não existe nos dados");
			System.out.println("      Índice: "+id+", Indices disponiveis de 0 a "+obj_list.size()+".");
			return false;
		}
	}
	
	public ArrayList<T> get(String field, String data) {
		ArrayList<T> get_obj = new ArrayList<T>();
		try {
			for(T obj: obj_list) {
				Method meth = obj.getClass().getMethod(Util.StringGettify(field, 3));

				if (obj.getClass().getMethod(Util.StringGettify(field, 3)).getReturnType().equals(String.class)) {
					if (meth.invoke(obj).equals(data)) {
						get_obj.add(obj);
					}
				
				} else if (obj.getClass().getMethod(Util.StringGettify(field, 3)).getReturnType().equals(int.class)) {
					if (meth.invoke(obj).equals(Integer.parseInt(data))) {
						get_obj.add(obj);
					}
				
				} else if (obj.getClass().getMethod(Util.StringGettify(field, 3)).getReturnType().equals(Date.class)) {
			        SimpleDateFormat date_format = new SimpleDateFormat("dd/MM/yyyy"); 
					
					if (date_format.format(meth.invoke(obj)).contains(data)) {
						get_obj.add(obj);
					}
				}
			}

		} catch (Exception e) {
			System.out.println("Não existe nenhum campo com o nome de "+field+", aka:("+Util.StringGettify(field, 3)+").");
		}
		
		return get_obj;
	}
	
	public T get(int id) {
		return obj_list.get(id);
	}
	
	public ArrayList<T> list() {
		return obj_list;
	}

}
