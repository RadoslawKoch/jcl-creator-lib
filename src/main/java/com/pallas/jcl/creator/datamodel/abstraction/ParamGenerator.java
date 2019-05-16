package com.pallas.jcl.creator.datamodel.abstraction;

import java.util.List;

import com.pallas.jcl.creator.job.general.GlobalSettings;


public abstract class ParamGenerator<T> {

	protected String getParam(int signCounter, List<T> list) {
		StringBuilder content = new StringBuilder();
		
		int counter = 0;
		for(Object x : list) {
			int length = x.toString().length();
			if(!isInLine(signCounter,x.toString())) {
				content.append("\n//         ");
				signCounter = 11;
			}
			counter++;
			content.append(x);
			signCounter+=length;
			if(counter==list.size()) {
				break;
			}
			content.append(",");
		}
		return content.toString();
	}
	
	private boolean isInLine(int currentLength, String toAppend) {
		return (currentLength + toAppend.length())<GlobalSettings.LINE_LENGTH;
	}
	
}
