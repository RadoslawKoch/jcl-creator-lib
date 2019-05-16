package com.pallas.jcl.creator.test.job.abstraction.helpers;

import com.pallas.jcl.creator.datamodel.abstraction.JclMainElement;
import com.pallas.jcl.creator.job.exceptions.InvalidNameException;

public class JclMainElementTest extends JclMainElement<String,JclElementTest> {
	
	public JclMainElementTest(String name) throws InvalidNameException {
		super(name);
	}
	
	

}
