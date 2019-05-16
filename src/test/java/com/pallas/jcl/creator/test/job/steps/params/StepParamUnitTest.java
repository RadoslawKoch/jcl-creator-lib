package com.pallas.jcl.creator.test.job.steps.params;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.pallas.jcl.creator.job.exceptions.InvalidParameterException;
import com.pallas.jcl.creator.job.steps.params.StepParam;
import com.pallas.jcl.creator.job.steps.params.StepParamName;

public class StepParamUnitTest {

	@Test
	public void to_string_format_validator() throws InvalidParameterException {
		StepParam dd = new StepParam(StepParamName.COND,"(99,NE)");
		assertTrue(dd.toString().equals(dd.getName()+"="+dd.getValue()));	
	}
}
