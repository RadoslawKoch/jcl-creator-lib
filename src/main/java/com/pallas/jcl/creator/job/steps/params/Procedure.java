package com.pallas.jcl.creator.job.steps.params;

import com.pallas.jcl.creator.datamodel.abstraction.Executable;
import com.pallas.jcl.creator.job.exceptions.InvalidNameException;

public class Procedure 
	extends Executable{

	public Procedure(String name) throws InvalidNameException {
		super(name);
	}

	@Override
	public String toString() {
		return "PROC=" + name;
	}	
}
