package com.pallas.jcl.creator.builders;

import com.pallas.jcl.creator.datamodel.interfaces.DDParamDefinition;
import com.pallas.jcl.creator.job.exceptions.InvalidParameterException;
import com.pallas.jcl.creator.job.steps.dd.params.DDParam;
import com.pallas.jcl.creator.job.steps.dd.params.DDParamName;

public class DDParamBuilder {

	private DDParamName name;
	private String value;
	
	public DDParamBuilder setName(DDParamName name) {
		this.name = name;
		return this;
	}
	public DDParamBuilder setValue(String value) {
		this.value = value;
		return this;
	}
	
	public DDParamDefinition build() throws InvalidParameterException {
		return new DDParam(this.name,this.value);
	}
	
	
}
