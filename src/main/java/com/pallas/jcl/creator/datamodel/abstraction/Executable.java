package com.pallas.jcl.creator.datamodel.abstraction;

import com.pallas.jcl.creator.datamodel.interfaces.JclElement;
import com.pallas.jcl.creator.job.exceptions.InvalidNameException;
import com.pallas.jcl.creator.job.general.GlobalValidator;

public abstract class Executable 
	implements JclElement<String> {

	protected String name;

	public Executable(String name) throws InvalidNameException {
		if(!GlobalValidator.isNameValid(name))
			throw new InvalidNameException(name);
		this.name = name;
	}
	
	@Override
	public String getName() {
		return this.name;
	}
}
