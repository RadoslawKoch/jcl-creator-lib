package com.pallas.jcl.creator.test.builders;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.pallas.jcl.creator.builders.StepParamBuilder;
import com.pallas.jcl.creator.job.exceptions.InvalidParameterException;
import com.pallas.jcl.creator.job.steps.params.StepParamName;

public class StepParamBuilderUnitTest {

	private StepParamBuilder builder;
	
	@Before
	public void setup() {
		this.builder = new StepParamBuilder();
	}
	
	@Test
	public void create_step_param_with_valid_input_params() throws InvalidParameterException {
		StepParamName name = StepParamName.COND;
		assertTrue(this.builder
				.setName(name)
				.setValue("(99,NE)")
				.build().getName().equals(name));
	}
	
	@Test(expected=InvalidParameterException.class)
	public void create_step_param_with_invalid_params_throws_InvalidParameterException() throws InvalidParameterException {
		this.builder.setName(StepParamName.COND)
		.setValue("BAD")
		.build();
	}
	
	@Test(expected=NullPointerException.class)
	public void create_step_param_without_params_throws_InvalidParameterException() throws InvalidParameterException {
		this.builder
		.build();
	}
	

}
