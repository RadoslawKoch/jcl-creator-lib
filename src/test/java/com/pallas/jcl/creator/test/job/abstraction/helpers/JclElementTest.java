package com.pallas.jcl.creator.test.job.abstraction.helpers;

import com.pallas.jcl.creator.datamodel.interfaces.JclElement;

public class JclElementTest implements JclElement<String>{

	
	private String name;
	
	public JclElementTest(String name){
		this.name = name;
	}
	
	@Override
	public String getName() {
		return this.name;
	}

}
