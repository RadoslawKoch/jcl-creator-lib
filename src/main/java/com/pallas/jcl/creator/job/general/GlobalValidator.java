package com.pallas.jcl.creator.job.general;

public class GlobalValidator {

	public static boolean isNameValid(String name) {
		try {
			name = name.toLowerCase();
			if(name.length() < 1 || name.length() > 8)
				return false;
			char first = name.toCharArray()[0];
			if(first > 122 || first < 97 ) 
				return false;
			char[] toTest = name.substring(1).toCharArray();
			for(char x : toTest) {
				if(x <= 122 && x >= 97 || x >= 48 && x <=57)
					continue;
				return false;
			}
		}catch(Exception ex) {
			return false;
		}
		return true;
	}
	
	public static boolean isTimeValid(String time) {
		try {
			time = time.toUpperCase();
			if(time.equals("NOLIMIT") || time.equals("MAXIMUM") || time.equals("1440"))
				return true;
			if(time.startsWith("(") && time.endsWith(")")) {
				String[]tab; 
				if((tab= time.substring(1).split(",")).length!=2)
					return false;
				int	val1 = Integer.parseInt(tab[0]);
				int	val2 = Integer.parseInt(tab[1].substring(0, tab[1].length()-1));
	
				if((val1 <= 357912 && val1 >= 0) && (val2 < 60 && val2 >= 0))
					return true;
			}
		}catch(Exception ex) {
			return false;
		}
		return false;	
	}
	
	

	public static boolean isCondValid(String cond) {
		try {
			if(!cond.endsWith(")") && !cond.startsWith("(") || cond.endsWith(",)") || cond.startsWith("(((") || cond.endsWith(")))"))
				return false;
	
			if(!paranthaisesVerif(cond.toCharArray())) 
				return false;
	
			String tmp = cond.substring(1, cond.length()-1);
			String[] tab = tmp.toLowerCase().split(",");
			if(tab.length<2)
				return false;
			String last = tab[tab.length-1].toUpperCase();
			if(!last.contains(")") && tab[0].contains("(")){
				if(!last.equals("EVEN") && !last.equals("ONLY"))
					return false;
				tmp = tmp.substring(0,tmp.length()-5);
	
			}
			if(tmp.contains("(")) {
				tab = tmp.toLowerCase().split("\\),");
				for(String x : tab) {
					if(oneCond(x)==false) 
						return false;
				}
				return true;
			}
			return oneCond(cond);
		}catch(Exception ex) {
			return false;
		}

	}

	
	private static boolean oneCond(String cond) {
		if(!cond.startsWith("("))
			return false;
		
		if(cond.endsWith(")")) {
			cond = cond.substring(1,cond.length()-1);
		}else {
			cond = cond.substring(1);
		}
		
		if(cond.endsWith(",") || cond.startsWith(","))
			return false;
		
		String[] tab = cond.split(",");
		if(tab.length<2 || tab.length>3)
			return false;

		if(tab.length==3) 
			if(!isNameValid(tab[2]))
				return false;

		if(!isCCCodeValid(tab[0]))
			return false;
		
		return isParamOK(tab[1]);
	}
	
	
	public static boolean paranthaisesVerif(char[]arr) {
		int counter = 0;
		for(char x : arr) {
			if(x==40) 
				counter++;
			if(x==41) 
				counter--;
		}
		return counter==0;
	}
	
	
	private static boolean isParamOK(String cnd) {
		cnd = cnd.toUpperCase();
		if(!cnd.equals("EQ") && !cnd.equals("NE") && !cnd.equals("GT") && !cnd.equals("LT") && !cnd.equals("GE") && !cnd.equals("LE"))
			return false;
		return true;
	}
	
	private static boolean isCCCodeValid(String code) {
		Integer cd =Integer.parseInt(code);
		if(cd > 99 || cd < 0) 
			return false;		
		return true;	
	}
	
	
}
