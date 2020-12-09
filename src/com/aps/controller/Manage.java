package com.aps.controller;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import com.aps.model.Model;
import com.aps.util.Util;


public class Manage<T extends Model> {
	protected ArrayList<T> obj_list = new ArrayList<T>();

	@SuppressWarnings("unchecked")
	public Boolean add(Map<String, String> fields_and_values, T obj) {
		String setMethName = "";
		String getMethName = "";
		try {
	        for (Map.Entry<String, String> entry : fields_and_values.entrySet()) {
	        		
	        		System.out.println("--("+entry.getKey()+"  "+entry.getValue()+")--");
	        		getMethName = entry.getKey();
        			setMethName = entry.getKey().replace("get","set");
        			Method meth;
					if (!entry.getKey().contains("fk")) {
						if (obj.getClass().getMethod(getMethName).getReturnType().equals(String.class)) {
							meth = obj.getClass().getMethod(setMethName, String.class);
							meth.invoke(obj, entry.getValue());					
						
						} else if (obj.getClass().getMethod(getMethName).getReturnType().equals(int.class)) {
							meth = obj.getClass().getMethod(setMethName, int.class);
							meth.invoke(obj, Integer.parseInt(entry.getValue()));					
	
						} else if (obj.getClass().getMethod(getMethName).getReturnType().equals(Date.class)) {
							meth = obj.getClass().getMethod(setMethName, Date.class);
							SimpleDateFormat date_format = new SimpleDateFormat("dd/MM/yyyy"); 
					        meth.invoke(obj, date_format.format(entry.getValue()));
						}					
					} else {
						if (obj.getClass().getMethod(getMethName).getReturnType().equals(int.class)) {
							meth = obj.getClass().getMethod(setMethName, int.class);
							meth.invoke(obj, Integer.parseInt(entry.getValue()));					
						} else {
							meth = obj.getClass().getMethod(getMethName);							
							((ArrayList<Integer>) meth.invoke(obj)).add(Integer.parseInt(entry.getValue()));
						} 
					}
	        }
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return obj_list.add(obj);
	}
	
	
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
			System.out.println("Não existe nenhum campo com o nome de "+field+", aka:("+Util.StringGettify(field, 3)+"), e o valor "+data);
		}
		
		return get_obj;
	}
	
	public ArrayList<String> listFields(Boolean show, T t) {
		if (obj_list.size() > 0) {
			System.out.println("Não existe dado registrado para esse setor.");

		}
		String printer = "";
		ArrayList<String> getFields = new ArrayList<String>();
		for (Method meth: t.getClass().getDeclaredMethods()) {				
			if(meth.getName().contains("get")) {
				getFields.add(meth.getName());	
				printer += "|"+Util.StringRemoveGet_(meth.getName())+"\n";
			}
		}
		if (show)
			System.out.println(printer);
	
		return getFields;
		
	}
	
	public void search(String field, String data, int spc_field, T model) {
		ArrayList<T> t = get(field, data);
		String printer = "|";
		
		if (t.size() > 0) {
			ArrayList<String> getFields = new ArrayList<String>();
			for (Method meth: model.getClass().getDeclaredMethods()) {				
				if(meth.getName().contains("get")) {
					getFields.add(meth.getName());	
					printer += Util.StringRemoveGet_(meth.getName())+" ".repeat(spc_field)+"|";
				}
			}
			
			System.out.println(printer);
			printer = "|";
			try {
		        Method m;
		        Object invoke;
		        String value;
		        int len_skip = 0;
				for (T obj: t) {
					for (String methName: getFields) {
						m = obj.getClass().getMethod(methName);
						invoke = m.invoke(obj);
						if (invoke != null) {
							value = invoke.toString();
							len_skip =  Util.StringRemoveGet_(methName).length()+spc_field-value.length();
							if (len_skip < 0) 
								value = value.substring(0, value.length() + len_skip);
							printer += value.toString()+" ".repeat(Util.StringRemoveGet_(methName).length()+spc_field-value.length())+"|";	
						} else
							printer += "()"+" ".repeat(Util.StringRemoveGet_(methName).length()+spc_field-"()".length())+"|";	
					}
					System.out.println(printer);
				}			
			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		
	}

	
	public void show_all(int spc_field, T model) {
		ArrayList<T> t = obj_list;
		String printer = "|";
		
		if (t.size() > 0) {
			ArrayList<String> getFields = new ArrayList<String>();
			for (Method meth: model.getClass().getDeclaredMethods()) {				
				if(meth.getName().contains("get")) {
					getFields.add(meth.getName());	
					printer += Util.StringRemoveGet_(meth.getName())+" ".repeat(spc_field)+"|";
				}
			}
			
			System.out.println(printer);
			printer = "|";
			try {
		        Method m;
		        Object invoke;
		        String value;
		        int len_skip = 0;
				for (T obj: t) {
					for (String methName: getFields) {
						m = obj.getClass().getMethod(methName);
						invoke = m.invoke(obj);
						if (invoke != null) {
							value = invoke.toString();
							len_skip =  Util.StringRemoveGet_(methName).length()+spc_field-value.length();
							if (len_skip < 0) 
								value = value.substring(0, value.length() + len_skip);
							printer += value.toString()+" ".repeat(Util.StringRemoveGet_(methName).length()+spc_field-value.length())+"|";	
						} else
							printer += "()"+" ".repeat(Util.StringRemoveGet_(methName).length()+spc_field-"()".length())+"|";	
					}
					System.out.println(printer);
				}			
			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		
	}

	
	public T get(int id) {
		return obj_list.get(id);
	}
	
	public ArrayList<T> list() {
		return obj_list;
	}

	public Boolean remove(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
