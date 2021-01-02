package com.aps.controller;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.aps.model.Model;
import com.aps.util.Util;


public class Manage<T extends Model> {
	protected ArrayList<T> obj_list = new ArrayList<T>();
	
	public int invoke_and_add(Map<String, String> fields_and_values, T obj) {
		if (obj == null) {
			return -1;
		}
		return add_or_update(invoke_model(fields_and_values, obj));
	}
	
	public Boolean add_test(T obj) {
		return true;
	} 
	
	public int add_or_update(T obj) {
		if (add_test(obj)) {
			if (((Model) obj).getId() == null) {
				((Model) obj).setId(obj_list.size());
				if (!obj_list.add(obj))
					return -1;
			} else {
				try {
					obj_list.set(((Model) obj).getId(), obj);
				} catch (IndexOutOfBoundsException e) {
					return -2;
				}
			}
			return obj_list.size();
		}
		return -3;
	}
	
	@SuppressWarnings("unchecked")
	public T invoke_model(Map<String, String> fields_and_values, T obj) {
		String setMethName = "";
		String getMethName = "";
		Method meth;
        for (Map.Entry<String, String> entry : fields_and_values.entrySet()) {	   
    		try {
	    		getMethName = entry.getKey();
				setMethName = entry.getKey().replace("get","set");
				if (!entry.getKey().contains("fk")) {
					if (obj.getClass().getMethod(getMethName).getReturnType().equals(String.class)) {
						meth = obj.getClass().getMethod(setMethName, String.class);
						meth.invoke(obj, entry.getValue());					
					
					} else if (obj.getClass().getMethod(getMethName).getReturnType().equals(Boolean.class)) {
						meth = obj.getClass().getMethod(setMethName, Boolean.class);
						meth.invoke(obj, Boolean.parseBoolean(entry.getValue()));					
	
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
						String separator = Util.verify_separator(entry.getValue());
						if (!separator.equals("")) {
							for (String id: entry.getValue().split(separator)) {
								try {
									((ArrayList<Integer>) meth.invoke(obj)).add(Integer.parseInt(id));
								} catch (NumberFormatException e) {
									System.out.println("Erro ao adicionar o valor '"+id+"' ao campo "+getMethName+
											", por favor insira um valor do tipo "+obj.getClass().getMethod(getMethName).getReturnType().toGenericString());
								}
							}
						} else 
							((ArrayList<Integer>) meth.invoke(obj)).add(Integer.parseInt(entry.getValue()));											 
					}
				}
    		} catch (NoSuchMethodException | SecurityException e) {
    			//e.printStackTrace();
				try {
					System.out.println("Erro ao adicionar o valor '"+entry.getValue()+"' ao campo "+getMethName+", por favor insira um valor do tipo "+obj.getClass().getMethod(getMethName).getReturnType());
				} catch (NoSuchMethodException | SecurityException e1) {
					e1.printStackTrace();
				}
    		
    		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
    			// e.printStackTrace();
    		}
        } 
	    return obj;
	}
	
	public Boolean update(Map<String, String> fields_and_values, T obj) {
		obj = invoke_model(fields_and_values, obj);
		obj_list.set(((Model) obj).getId(), obj);
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<T> get(String field, String data, Boolean sort_by, ArrayList<T> obj_list) {
		ArrayList<T> get_obj = new ArrayList<T>();
		
		try {
			for(T obj: obj_list) {
				Method meth = obj.getClass().getMethod(Util.StringGettify(field, 3));

				if (!meth.getName().contains("fk")) {	
					if (obj.getClass().getMethod(Util.StringGettify(field, 3)).getReturnType().equals(String.class)) {
						if (meth.invoke(obj).equals(data)) {
							get_obj.add(obj);
						}
					} else if (obj.getClass().getMethod(Util.StringGettify(field, 3)).getReturnType().equals(Boolean.class)) {
						if (meth.invoke(obj).equals(Boolean.parseBoolean(data))) {
							get_obj.add(obj);
						}
					} else if (obj.getClass().getMethod(Util.StringGettify(field, 3)).getReturnType().equals(int.class)) {
						if (meth.invoke(obj).equals(Integer.parseInt(data))) {
							get_obj.add(obj);
						}
					} else if (obj.getClass().getMethod(Util.StringGettify(field, 3)).getReturnType().equals(Integer.class)) {
						if (meth.invoke(obj).equals(Integer.parseInt(data))) {
							get_obj.add(obj);
							break;
						}
					} else if (obj.getClass().getMethod(Util.StringGettify(field, 3)).getReturnType().equals(Date.class)) {
				        SimpleDateFormat date_format = new SimpleDateFormat("dd/MM/yyyy");
						if (date_format.format(meth.invoke(obj)).contains(data)) {
							get_obj.add(obj);
						}
					}
				}  else {
					if (obj.getClass().getMethod(Util.StringGettify(field, 3)).getReturnType().equals(int.class)) {
						if (meth.invoke(obj).equals(Integer.parseInt(data))) {
							get_obj.add(obj);
						}
						
					} else {
						int data_fk = Integer.parseInt(data); 
						for (int fk: ((ArrayList<Integer>) meth.invoke(obj))) {
							if (fk == data_fk) {
								get_obj.add(obj);
								break;
							}
						}
					} 
				}
			}
		} catch (Exception e) {
			System.out.println("Não existe nenhum campo com o nome de "+field+", aka:("+Util.StringGettify(field, 3)+"), e o valor "+data);
		}
		
		return get_obj;
	}

	public T get(int id) {
		if (id >= 0 && id < obj_list.size())
			return obj_list.get(id);
		else 
			return null;
	}
	
	public String get_value(int id, String field) {
		Method meth;
		try {
			if (get_size() <= id) 
				return "-2";
			
			meth = obj_list.get(id).getClass().getMethod(Util.StringGettify(field, 3));
			if (meth.invoke(obj_list.get(id)) == null) 
				return "-1";
			
			return meth.invoke(obj_list.get(id)).toString();

		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return "-3";
	}
	
	@SuppressWarnings("serial")
	public Boolean set_value(String search_field, String search_value,
			String field, String new_value) {
		ArrayList<T> select = get(search_field, search_value, false, obj_list);
		
		if (select.size() == 1) {
			select.get(0);
			add_or_update(invoke_model(new HashMap<String,String>() {{
				put(Util.StringGettify(field, 2), new_value);
			}},select.get(0)));
		} else {
			System.out.println("Por favor ");
		}
		
		return false;
	}
	
	public ArrayList<String> listFields(Boolean show, Boolean not_id, T t) {
		String printer = "";
		ArrayList<String> getFields = new ArrayList<String>();
		for (Method meth: t.getClass().getDeclaredMethods()) {				
			if(meth.getName().contains("get")) {
				if (!(not_id && meth.getName().equals("getId"))) {
					getFields.add(meth.getName());	
					printer += "|"+Util.StringRemoveGet_(meth.getName())+"\n";
				}
			}
		}
		if (show)
			System.out.println(printer);
	
		return getFields;
		
	}
	
	public void show_table(ArrayList<T> t, int spc_field, T model) {	
		String printer = "";
		String printer0 = "|";
		Map<String, Integer> fields_and_values_len = new HashMap<String, Integer>();
		ArrayList<String> getFields = new ArrayList<String>();
		if (t.size() > 0) {
			try {
				
				Method m;
		        Object invoke;
		        String value;		        
				
				for (int i = 0; i < t.size(); i++) {

					for (Method meth: model.getClass().getDeclaredMethods()) {				
						if(meth.getName().contains("get")) {
													
							m = t.get(i).getClass().getMethod(meth.getName());
							invoke = m.invoke(t.get(i));
	
							if (!fields_and_values_len.containsKey(meth.getName())) {
								fields_and_values_len.put(meth.getName(), 0);
								getFields.add(meth.getName());
							}
							
							if (invoke != null) {
								value = invoke.toString();
								if (fields_and_values_len.get(meth.getName()) < value.length()+spc_field) {
									fields_and_values_len.put(meth.getName(), value.length()+spc_field);								
								}
								
								if (fields_and_values_len.get(meth.getName()) < Util.StringRemoveGet_(meth.getName()).length()+spc_field) {
									fields_and_values_len.put(meth.getName(),  Util.StringRemoveGet_(meth.getName()).length()+spc_field);																	
								}
							} else {
								fields_and_values_len.put(meth.getName(),  Util.StringRemoveGet_(meth.getName()).length()+spc_field);								
							}
						}
					}				
				}
				
				for (String methName: getFields) {				
					if(methName.contains("get")) {
						printer0 += Util.StringRemoveGet_(methName)+"_".repeat(fields_and_values_len.get(methName)-Util.StringRemoveGet_(methName).length())+"|";
					}
				}
				
				printer += " "+"_".repeat(printer0.length()-2)+"\n";
				printer += printer0+"\n";
				

				for (int i = 0; i < t.size(); i++) {
					printer += "|";
					for (String methName: getFields) {
						m = t.get(i).getClass().getMethod(methName);
						invoke = m.invoke(t.get(i));
						if (invoke != null) {
							value = invoke.toString();
							if (i == t.size()-1)
								printer += value.toString()+"_".repeat(fields_and_values_len.get(methName)-value.length())+"|";	
							else
								printer += value.toString()+" ".repeat(fields_and_values_len.get(methName)-value.length())+"|";	

						} else
							if (i == t.size()-1)
								printer += "()"+"_".repeat(fields_and_values_len.get(methName)-"()".length())+"|";	
							else
								printer += "()"+" ".repeat(fields_and_values_len.get(methName)-"()".length())+"|";	

					}
					printer += "\n";
				}			
				System.out.println(printer);
			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Não foram encontrados resultados para a sua busca.\n");
		}
		
	}
	
	public int search(String field, String data, int spc_field, T model, Boolean sort_by) {
		ArrayList<T> t = get(field, data, sort_by, obj_list);
		System.out.println(t.size());
		show_table(t, spc_field, model);
		
		if (!t.isEmpty())
			return t.size();

		return 0;
	}

	public void search(String field, String data, int spc_field, T model, Boolean sort_by, ArrayList<T> obj_list) {
		ArrayList<T> t = get(field, data, sort_by, obj_list);
		show_table(t, spc_field, model);
	}
	
	public void show_all(int spc_field, T model) {
		show_table(obj_list, spc_field, model);
	}

	
	public void show_all(int spc_field, T model, ArrayList<T> obj_list) {
		show_table(obj_list, spc_field, model);
	}
	
	public int get_size() {
		return obj_list.size();
	}
	
}
