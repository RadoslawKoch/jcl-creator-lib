package com.pallas.jcl.creator.job.steps.params;


import com.pallas.jcl.creator.datamodel.abstraction.Parameter;
import com.pallas.jcl.creator.datamodel.interfaces.StepParamDefinition;
import com.pallas.jcl.creator.job.exceptions.InvalidParameterException;

public class StepParam 
	extends Parameter<StepParamName> 
	implements StepParamDefinition {
	
	public StepParam(StepParamName name, String value) throws InvalidParameterException  {
		super(name,value,StepParamValidator.getInstance());
	}
	
	@Override
	public String toString() {
		return name + "=" + value;
	}
}
