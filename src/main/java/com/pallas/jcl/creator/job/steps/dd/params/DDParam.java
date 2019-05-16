package com.pallas.jcl.creator.job.steps.dd.params;

import com.pallas.jcl.creator.datamodel.abstraction.Parameter;
import com.pallas.jcl.creator.datamodel.interfaces.DDParamDefinition;
import com.pallas.jcl.creator.job.exceptions.InvalidParameterException;

public class DDParam 
	extends Parameter<DDParamName> 
	implements DDParamDefinition{
	
	public DDParam(DDParamName name, String value) throws InvalidParameterException {
		super(name,value,DDValidator.getValidator());
	}
		
	@Override
	public String toString() {
		if(name==DDParamName.VOLSER) 
			return "VOL=SER="+this.value;
		if(name==DDParamName.DUMMY) 
			return "DUMMY";
		return this.name + "="+this.value;
	}	
}
