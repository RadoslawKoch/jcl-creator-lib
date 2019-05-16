package com.pallas.jcl.creator.job.steps.params;

import com.pallas.jcl.creator.datamodel.interfaces.JclValidator;
import com.pallas.jcl.creator.job.general.GlobalValidator;

public class StepParamValidator 
	implements JclValidator<StepParamName>{

	private static StepParamValidator instance = new StepParamValidator();
	
	private StepParamValidator() {}
	
	public static StepParamValidator getInstance() {
		return instance;
	}
	
	@Override
	public boolean isValid(StepParamName name, String value) {

			switch(name) {
				case COND:
					return GlobalValidator.isCondValid(value);
				case TIME:
					return GlobalValidator.isTimeValid(value);
				default:
					return false;
			}

	}
}
