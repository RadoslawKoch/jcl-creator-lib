package com.pallas.jcl.creator.job.steps.params;

import com.pallas.jcl.creator.datamodel.abstraction.Executable;
import com.pallas.jcl.creator.job.exceptions.InvalidNameException;

public class Program 
	extends Executable{

	public Program(String name) throws InvalidNameException {
		super(name);
	}

	@Override
	public String toString() {
		return "PGM="+name.toUpperCase();
	}	
}
