package com.aps.controller;
import java.util.ArrayList;
import java.util.Date;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;

public class Manage<T> {
	protected ArrayList<T> obj_list = new ArrayList<T>();
	
	public void add(T obj) {
		obj_list.add(obj);
	}
	
	public ArrayList<T> get(String field, String data) {
		ArrayList<T> get_obj = new ArrayList<T>();
		
		try {
			for(T obj: obj_list) {
				Method meth = obj.getClass().getMethod(field);

				if (obj.getClass().getMethod(field).getReturnType().equals(String.class)) {
					System.out.println(meth.invoke(obj));
					if (meth.invoke(obj).equals(data)) {
						get_obj.add(obj);
					}
				
				} else if (obj.getClass().getMethod(field).getReturnType().equals(int.class)) {
					if (meth.invoke(obj).equals(Integer.parseInt(data))) {
						get_obj.add(obj);
					}
				
				} else if (obj.getClass().getMethod(field).getReturnType().equals(Date.class)) {
			        SimpleDateFormat date_format = new SimpleDateFormat("dd/MM/yyyy"); 
					
					if (date_format.format(meth.invoke(obj)).contains(data)) {
						get_obj.add(obj);
					}
				}
			}

		} catch (Exception e) {
			System.out.print("Errrou ");
		}
		
		return get_obj;
	}
	
	public void remove(T obj) {
		obj_list.remove(obj);
	}
	
}
