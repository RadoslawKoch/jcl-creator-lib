package com.pallas.jcl.creator.job.steps.dd.params;

import java.util.Arrays;
import java.util.List;

import com.pallas.jcl.creator.datamodel.interfaces.JclValidator;
import com.pallas.jcl.creator.job.general.GlobalValidator;

public class DDValidator 
	implements JclValidator<DDParamName> {

	private static DDValidator instance = new DDValidator();
	
	private DDValidator() {}
	
	public static DDValidator getValidator() {
		return instance;
	}
	
	private final List<String> recfms = Arrays.asList("D","DA","DB","DBA","DBS","DBSA","DS","DSA","F","FA","FB","FBA","FBM","FBS",
									"FBSA","FBSM","FBT","FBTA","FBTM","FM","FS","FSA","FSM","FT","FTA","FTM","U","UA","UM",
									"UT","UTA","UTM","V","VA", "VB","VBA","VBM","VBS","VBSA","VBSM","VBST","VBSTA","VBSTM", "VBT", 
									"VBTA","VBTM","VM", "VS", "VSA","VSM", "VT", "VTA","VTM");
	
	@Override
	public boolean isValid(DDParamName name, String value) {
		try {
			switch(name) {
				case VOLSER:
					return isVolserValid(value);
				case SPACE:
					return isSpaceValid(value);
				case DSN:
					return isDSNValid(value);
				case LRECL:
					return isLreclValid(value);
				case RECFM:
					return isRecmfValid(value);
				case DISP:
					return isDispValid(value);
				case DUMMY:
					return true;
				default:
					return false;
			}	
		}catch(Exception ex) {
			return false;
		}
	}
	
	private boolean isNameValid(String name) {
		return GlobalValidator.isNameValid(name);
	}
	

	private boolean isDSNValid(String dsn) {
		if(dsn.startsWith("\\.") || dsn.endsWith("\\.") || dsn.contains(".."))
			return false;
		
		String[]tab = dsn.split("\\.");
		int last = tab.length;
		if(tab.length < 1 || tab.length > 5 || tab.length > 4 && dsn.contains(")"))
			return false;
		for(String z : tab) {
			--last;
			if(last==0) {
				String[]tmp = z.split("\\(");

				for(String x : tmp) {
					if(x.endsWith(")")) {
						x = x.substring(0,x.length()-1);
					}
					if(!isNameValid(x))
						return false;					
				}	
				return true;

			}
			if(!isNameValid(z))
				return false;
		}
		return true;
		
	}
	

	
	private boolean isSpaceValid(String space) {
		if(!GlobalValidator.paranthaisesVerif(space.toCharArray())) 
			return false;
		
		space = space.toUpperCase();
		String[]tab = space.split(",");
		
		String unit = tab[0];
		if(unit.startsWith("(")) {
			unit = unit.substring(1);		
		}
		if(!unit.equals("CYL") && !unit.equals("TRK"))
			return false;		
		String primarySpace = tab[1];
		String secondarySpace = tab[2];
		if(primarySpace.startsWith("(")){
			primarySpace = primarySpace.substring(1);			
		}
		if(secondarySpace.endsWith(")")){
			secondarySpace = secondarySpace.substring(0,secondarySpace.length()-1);
		}
		if(secondarySpace.endsWith(")")){
			secondarySpace = secondarySpace.substring(0,secondarySpace.length()-1);
		}
		int primary = Integer.parseInt(primarySpace);
		int secondary = Integer.parseInt(secondarySpace);
		if(primary > 16777215 || primary < 0)
			return false;
		if(secondary > 16777215 || secondary < 0)
			return false;
		
		if(tab.length==4) {
			String rlse = tab[3];
			if(rlse.endsWith(")")){
				rlse = rlse.substring(0,rlse.length()-1);
			}
			if(!rlse.equals("RLSE"))
				return false;
		}	
		return true;
	}
	
	private boolean isLreclValid(String lrecl) {
		if(lrecl.length()<1 || lrecl.length() > 5)
			return false;
		Integer length = Integer.parseInt(lrecl);
		return (length >= 0 && length <= 32761);
	}
	
	private boolean isRecmfValid(String recfm) {
		recfm = recfm.toUpperCase();
		return recfms.contains(recfm);
	}
	
	private boolean isVolserValid(String volser) {
		if(volser.length()<1 || volser.length() > 6)
			return false;
		if(Integer.parseInt(volser)<0)
			return false;
		return true;
	}
	
	private boolean isDispValid(String disp) {
		disp = disp.toUpperCase();
		if(!disp.contains("(")){
			if(disp.equals("SHR") || disp.equals("NEW") || disp.equals("OLD")|| disp.equals("MOD"))
				return true;
			
			return false;
		}
		if(!disp.startsWith("(") || !disp.endsWith(")"))
			return false;
		
		String tab = disp.substring(1, disp.length()-1);
		if(tab.endsWith(","))
			return false;
		String[] content = tab.split(",");
		
		if(content.length>3)
			return false;
		
		if(!content[0].equals("SHR") && !content[0].equals("NEW") && !content[0].equals("OLD")&& !content[0].equals("MOD"))
			return false;
		
		
		if(!content[1].equals("DELETE") && !content[1].equals("CATLG") && !content[1].equals("KEEP")&& !content[1].equals("PASS")&& !content[1].equals("UNCATLG"))
			return false;
		
		if(content.length==3) 
			if(!content[2].equals("DELETE") && !content[2].equals("CATLG") && !content[2].equals("KEEP")&& !content[2].equals("PASS")&& !content[2].equals("UNCATLG"))
				return false;
		
		return true;
		
	}

	
	
}
