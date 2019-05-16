package com.pallas.jcl.creator.builders;

import com.pallas.jcl.creator.datamodel.interfaces.StepParamDefinition;
import com.pallas.jcl.creator.job.exceptions.InvalidParameterException;
import com.pallas.jcl.creator.job.steps.params.StepParam;
import com.pallas.jcl.creator.job.steps.params.StepParamName;

public class StepParamBuilder {

	private StepParamName name;
	private String value;
	
	public StepParamBuilder setName(StepParamName name) {
		this.name = name;
		return this;
	}
	public StepParamBuilder setValue(String value) {
		this.value = value;
		return this;
	}
	
	public StepParamDefinition build() throws InvalidParameterException {
		return new StepParam(this.name,this.value);
	}
	
}
