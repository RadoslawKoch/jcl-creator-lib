package com.pallas.jcl.creator.builders;

import com.pallas.jcl.creator.job.card.params.KeywordParam;
import com.pallas.jcl.creator.job.card.params.KeywordParamName;
import com.pallas.jcl.creator.job.exceptions.InvalidParameterException;

public class KeywordParamBuilder {

	private KeywordParamName name;
	private String value;
	
	
	public KeywordParamBuilder setName(KeywordParamName name) {
		this.name = name;
		return this;
	}
	public KeywordParamBuilder setValue(String value) {
		this.value = value;
		return this;
	}
	
	public KeywordParam build() throws InvalidParameterException {
		return new KeywordParam(this.name,this.value);
	}
	
	
}
