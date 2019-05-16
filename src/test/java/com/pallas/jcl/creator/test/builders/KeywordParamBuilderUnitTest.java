package com.pallas.jcl.creator.test.builders;

import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;

import com.pallas.jcl.creator.builders.KeywordParamBuilder;
import com.pallas.jcl.creator.job.card.params.KeywordParamName;
import com.pallas.jcl.creator.job.exceptions.InvalidParameterException;

public class KeywordParamBuilderUnitTest {

	private KeywordParamBuilder builder;
	
	@Before
	public void setup() {
		this.builder = new KeywordParamBuilder();
	}
	
	@Test
	public void build_generates_valid_KeywordParam_object() throws InvalidParameterException {
		assertSame(this.builder
				.setName(KeywordParamName.CLASS)
				.setValue("X")
				.build().getName(),KeywordParamName.CLASS);
	}
	
	@Test(expected=InvalidParameterException.class)
	public void build_throws_InvalidParameterException_with_value() throws InvalidParameterException {
		this.builder
		.setName(KeywordParamName.CLASS)
		.setValue("XXXXXXXXXXXXXXXXXxxx")
		.build();
	}
	
	
	@Test(expected=InvalidParameterException.class)
	public void build_throws_InvalidParameterException_with_null() throws InvalidParameterException {
		this.builder
		.build();
	}
}
