package com.pallas.jcl.creator.test.builders;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.pallas.jcl.creator.builders.DDStatementBuilder;
import com.pallas.jcl.creator.job.exceptions.DuplicateJclElementException;
import com.pallas.jcl.creator.job.exceptions.InvalidNameException;
import com.pallas.jcl.creator.job.exceptions.InvalidParameterException;
import com.pallas.jcl.creator.job.steps.dd.params.DDParam;
import com.pallas.jcl.creator.job.steps.dd.params.DDParamName;

public class DDStatementBuilderUnitTest {

	private DDStatementBuilder builder;
	private String ddName = "INDD1";
	private String invalidDDName = "XXXXXXXXXXX";
	
	@Before
	public void setup() {
		this.builder = new DDStatementBuilder();
	}
	
	@Test
	public void build_generates_correct_DD_statement_with_valid_input() throws InvalidNameException {
		assertTrue(this.builder
				.setName(ddName)
				.build().getName().equals(ddName));
	}
	
	@Test
	public void build_generates_DD_statement_with_one_valid_dd_param() throws InvalidNameException, InvalidParameterException, DuplicateJclElementException {
		DDParam param = new DDParam(DDParamName.DISP,"SHR");
		assertTrue(this.builder
				.setName(ddName)
				.addParam(param)
				.build().getElements().size()==1);
	}
	
	@Test(expected=DuplicateJclElementException.class)
	public void build_DD_throws_DuplicateJclElementException() throws InvalidNameException, InvalidParameterException, DuplicateJclElementException {
		DDParam param = new DDParam(DDParamName.DISP,"SHR");
		this.builder
		.setName(ddName)
		.addParam(param)
		.addParam(param)
		.build();
	}
	
	@Test(expected=InvalidNameException.class)
	public void build_DD_throws_InvalidNameException() throws InvalidNameException, InvalidParameterException, DuplicateJclElementException {
		this.builder
		.setName(invalidDDName)
		.build();
	}
}
