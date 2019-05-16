package com.pallas.jcl.creator.job.card.params;


import com.pallas.jcl.creator.datamodel.interfaces.JclValidator;
import com.pallas.jcl.creator.job.general.GlobalValidator;



public class KeywordValidator 
	implements JclValidator<KeywordParamName>{
	
	private static KeywordValidator instance = new KeywordValidator();
	
	public static KeywordValidator getValidator() {
		return instance;
	}
	
	@Override
	public boolean isValid(KeywordParamName name, String value) {
		try {
			switch(name) {
				case USER:
					return this.isUserValid(value);
				case MSGCLASS:
					return this.isMsgClassValid(value);
				case CLASS:
					return this.isJobClassValid(value);
				case MSGLEVEL:
					return this.isMsgLevelValid(value);
				case TIME:
					return this.isTimeValid(value);
				case TYPERUN:
					return this.isTyprunValid(value);
				case NOTIFY:
					return this.isNotifyValid(value);
				case RESTART:
					return this.isRestartValid(value);
				case COND:
					return this.isCondValid(value);
				case REGION:
					return this.isRegionValid(value);
				case LINES:
					return this.isLinesValid(value);
				case SCHENV:
					return this.isSchenvValid(value);
				default:
					return false;			
			}
		}catch(Exception ex) {
			return false;
		}
	}

	private boolean isUserValid(String userName) {
		if(userName.length()<2 || userName.length()>7)
			return false;
		return GlobalValidator.isNameValid(userName);
	}
	
	private boolean isMsgClassValid(String msgClass) {
		if(msgClass.length()!=1)
			return false;
		msgClass = msgClass.toLowerCase();
		char toVerif = msgClass.toCharArray()[0];
		return (toVerif <= 122 && toVerif >= 97);			
	}
	
	private boolean isNotifyValid(String notify) {
		return this.isUserValid(notify) || notify.equals("&SYSUID");
	}
	
	private boolean isJobClassValid(String jobClass) {
		return this.isMsgClassValid(jobClass);
	}
	
	private boolean isRestartValid(String restart) {
		return GlobalValidator.isNameValid(restart);
	}
	
	private boolean isMsgLevelValid(String msg) {
		msg = msg.toUpperCase();
		if(!msg.contains("(")) {
			if(msg.equals("0") || msg.equals("1")|| msg.equals("2"))
				return true;
			
			return false;
		}
		String[]tab = msg.split(",");
		if(tab.length!=2)
			return false;
		if(!tab[0].equals("(0") && !tab[0].equals("(1")&& !tab[0].equals("(2"))
			return false;
		if(!tab[1].equals("0)") && !tab[1].equals("1)"))
			return false;
		
		return true;
	}
	
	private boolean isTimeValid(String time) {
		return GlobalValidator.isTimeValid(time);
	}
	
	private boolean isCondValid(String cond) {
		return GlobalValidator.isCondValid(cond);
	}
	
	private boolean isTyprunValid(String typrun) {
		typrun = typrun.toUpperCase();
		return (typrun.equals("HOLD") || typrun.equals("SCAN") || typrun.equals("COPY") || typrun.equals("JCLHOLD"));
	}
	
	private boolean isRegionValid(String region) {
		if(region.length()< 2 || region.length() > 8)
			return false;
		region = region.toUpperCase();
		if(region.equals("0K") || region.equals("0M"))
			return true;
		if(!region.endsWith("M") && !region.endsWith("K"))
			return false;
		if(region.endsWith("K")) {
			
			String toVerif = region.substring(0, region.length()-1);
			int number = Integer.parseInt(toVerif);
			if(number < 0 ||number > 2096128) 
				return false;

		}
		if(region.endsWith("M")) {
			String toVerif = region.substring(0, region.length()-1);
			int number = Integer.parseInt(toVerif);
			if(number < 0 || number > 2047) 
				return false;
		}
		return true;
	}
	
	private boolean isLinesValid(String lines) {
		if(lines.length()>6 || lines.length()<1)
			return false;
		int tmp = Integer.parseInt(lines);
		return (tmp >= 0 && tmp <= 999999);
	}
	
	private boolean isSchenvValid(String schenv) {
		return GlobalValidator.isNameValid(schenv);
	}
	
	
}
