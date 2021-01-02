package com.aps.util;

import java.util.ArrayList;
import java.util.Arrays;

public class Util {
	
	public static String StringCapitalize(String s) {
		if (s == null || s.isBlank())  
			return s;
		return s.substring(0, 1).toUpperCase() + s.substring(1);
	}
	
	public static String StringGettify(String common_word, int length_ignore) {
		String gettify = "";
		String gettify_ = "";
		String _char = "";
		
		if (common_word != null) {
			if (common_word.contains(" ")) {
				for (String words_btw_spaces : common_word.split(" ")) {
					
					if (!words_btw_spaces.toLowerCase().equals(words_btw_spaces.toUpperCase()) && words_btw_spaces.length() > length_ignore) {						
						if (gettify != "")
							gettify = gettify+"_"+words_btw_spaces;
						else
							gettify = words_btw_spaces;
					}
				}
			} else {
				gettify = common_word;
			}
		}
		
		if (gettify != null && gettify.length()>3) {

			if (!gettify.substring(0,3).equals("get"))
				gettify = "get" + gettify.substring(0,1).toUpperCase()+gettify.substring(1);
			
		} else {
			gettify = "get" + gettify.substring(0,1).toUpperCase()+gettify.substring(1);
		}

		gettify_ = gettify.substring(0, 4);

		for (int i = 4; i < gettify.length(); i++) {	
			_char = gettify.substring(i, i+1);
			if (_char.equals(_char.toUpperCase())) {
				gettify_ += "_"+_char.toLowerCase();
			} else 
				gettify_ += _char;
			 
		}	
		
		
		return gettify_;
	}

	public static String StringRemoveGet_(String f) {
		String _char = "";
		String new_f = "";
		Boolean skip = false;
		if (f != null && f.length()>3) {
			if (f.substring(0,3).equals("get")) {
				f = f.substring(3);
			}
			
			if (f.contains("_")) {
				for (int i = 0; i < f.length(); i++) {
					_char = f.substring(i, i+1);
					if (_char.equals("_")) {
						new_f += f.substring(i+1, i+2).toUpperCase();
						skip = true;
					} else if (skip == false)
						new_f += _char;
					 else
						skip = false;
				}	
			} else {
				new_f = f;
			}
		}
		return new_f;
	}

	public static ArrayList<String> Str2ArrayList(String str) {
		if (str.contains(","))
			return new ArrayList<String>(Arrays.asList(str.split(",")));
		else if (str.contains(" "))
			return new ArrayList<String>(Arrays.asList(str.split(" ")));
		return null;
	}
	
	public static boolean verify_str2integer(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (Exception e) {
			System.out.println("Valor digitado não é numerico, adicione um valor valido.");
		}
		return false;
	}
	
	public static String fk_name(String fk, boolean singular) {
		String[] _names = fk.split("_");	
		String name = StringRemoveGet_(_names[_names.length - 2]);
		
		if (name.substring( name.length()-1, name.length()).contains("s"))
			name = name.substring(0, name.length()-1);		
		
		if (singular && name.substring(name.length() - 3, name.length() - 2).equals("s")) {
			name = name.substring(0, name.length() - 3);
			return name;
		}

		return name;
	}

	public static boolean isEclipse() {
	    return System.getenv("in_production") == null;
	}	
	
	public static String verify_separator(String text) {
		if (text.contains(",")) {
			return ",";
		} else if (text.contains(" ")) {
			return " ";
		} 
		return "";
	}
	
}
