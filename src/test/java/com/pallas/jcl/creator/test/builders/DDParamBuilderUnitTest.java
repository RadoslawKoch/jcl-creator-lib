package com.pallas.jcl.creator.test.builders;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.pallas.jcl.creator.builders.DDParamBuilder;
import com.pallas.jcl.creator.job.exceptions.InvalidParameterException;
import com.pallas.jcl.creator.job.steps.dd.params.DDParamName;

public class DDParamBuilderUnitTest {

	private DDParamBuilder builder;
	
	@Before
	public void setup() {
		this.builder = new DDParamBuilder();
	}
	
	@Test
	public void create_dd_param_with_valid_input_params() throws InvalidParameterException {
		DDParamName name = DDParamName.DISP;
		assertTrue(builder
				.setName(name)
				.setValue("SHR")
				.build().getName().equals(name));
	}
	
	@Test(expected=InvalidParameterException.class)
	public void create_dd_param_with_invalid_params_throws_InvalidParameterException() throws InvalidParameterException {
		builder.setName(DDParamName.DISP)
		.setValue("BAD")
		.build();
	}
	
	@Test(expected=InvalidParameterException.class)
	public void create_dd_param_without_params_throws_InvalidParameterException() throws InvalidParameterException {
		builder
		.build();
	}


}
