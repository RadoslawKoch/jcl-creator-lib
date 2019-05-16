package com.pallas.jcl.creator.test.job.abstraction.helpers;

import com.pallas.jcl.creator.datamodel.abstraction.Parameter;
import com.pallas.jcl.creator.datamodel.interfaces.JclValidator;
import com.pallas.jcl.creator.job.exceptions.InvalidParameterException;

public class ParameterTest extends Parameter<String>{

	public ParameterTest(String name, String value, JclValidator<String> validator) throws InvalidParameterException {
		super(name, value, validator);
	}

	@Override
	public String toString() {
		return name + "=" + value;
	}	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Parameter other = (Parameter) obj;
		if (name == null) {
			if (other.getName() != null)
				return false;
		} else if (!name.equals(other.getName()))
			return false;
		if (value == null) {
			if (other.getValue() != null)
				return false;
		} else if (!value.equals(other.getValue()))
			return false;
		return true;
	}	
	
	
}
