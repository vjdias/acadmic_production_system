package com.aps.util;

public class Util {
	
	public static String StringCapitalize(String s) {
		if (s == null || s.isBlank())  
			return s;
		return s.substring(0, 1).toUpperCase() + s.substring(1);
	}
	
	public static String StringGettify(String common_word, int length_ignore) {
		String gettify = "";
		
		if (common_word != null && common_word.length()>3) {
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

			if (gettify.substring(0,3).equals("get") && gettify.substring(3, 4).equals(gettify.substring(3,4).toUpperCase())) {
				return gettify;
				
			} else if (!gettify.substring(0,3).equals("get") && !gettify.substring(3, 4).equals(gettify.substring(3,4).toUpperCase())) {
				return "get" + gettify.substring(0,1).toUpperCase() + gettify.substring(1);
			
			} else if (gettify.substring(0,3).equals("get") && !gettify.substring(3, 4).equals(gettify.substring(3,4).toUpperCase())) {
				return gettify.substring(0,3) +gettify.substring(3,4).toUpperCase() + gettify.substring(4);
			
			}  else if (!gettify.substring(0,3).equals("get") && !gettify.substring(3, 4).equals(gettify.substring(3,4).toUpperCase())) {
				return "get" + gettify.substring(3,4).toUpperCase() + gettify.substring(4);
			} 
			
		}
		return gettify;
	}

	public static String StringDesGettify(String f) {
		if (f != null && f.length()>3) {
			if (f.substring(0,3).equals("get")) {
				f = f.substring(3);
			}
			f = f.toLowerCase();
		}
		return f;
	}
}
