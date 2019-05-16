package com.pallas.jcl.creator.job.card.params;

import com.pallas.jcl.creator.datamodel.abstraction.Parameter;
import com.pallas.jcl.creator.datamodel.interfaces.KeywordParamDefinition;
import com.pallas.jcl.creator.job.exceptions.InvalidParameterException;

public class KeywordParam 
	extends Parameter<KeywordParamName> 
	implements KeywordParamDefinition{
	
	public KeywordParam(KeywordParamName name, String value) throws InvalidParameterException {
		super(name,value,KeywordValidator.getValidator());
	}

	@Override
	public String toString() {
		return name + "=" + value;
	}	
	
}
