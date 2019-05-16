package com.pallas.jcl.creator.datamodel.abstraction;

import com.pallas.jcl.creator.datamodel.interfaces.JclParam;
import com.pallas.jcl.creator.datamodel.interfaces.JclValidator;
import com.pallas.jcl.creator.job.exceptions.InvalidParameterException;

public abstract class Parameter<T> 
	implements JclParam<T>{

	protected T name;
	protected String value;	
	
	public Parameter(T name, String value, JclValidator<T> validator) throws InvalidParameterException {
		if(!validator.isValid(name, value)) 
			throw new InvalidParameterException("name="+name + " ,value="+value);
		this.name = name;
		this.value = value;
	}
	
	@Override
	public T getName() {
		return name;
	}

	@Override
	public String getValue() {
		return value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}


	
}
