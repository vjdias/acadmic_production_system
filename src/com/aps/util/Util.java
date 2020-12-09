package com.aps.util;

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

}
