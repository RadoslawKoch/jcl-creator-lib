package com.pallas.jcl.creator.test.builders;

import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;

import com.pallas.jcl.creator.builders.ExecutableBuilder;
import com.pallas.jcl.creator.job.exceptions.InvalidNameException;
import com.pallas.jcl.creator.job.steps.params.ExecType;

public class ExecutableBuilderUnitTest {

	private String validName = "CARDATA";
	private String invalidName = "XXXXXXXXXXXXX";
	private ExecutableBuilder builder;
	
	@Before
	public void setup() {
		this.builder = new ExecutableBuilder();
	}
	
	@Test
	public void build_generates_valid_program_object() throws InvalidNameException {
		assertSame(this.builder
				.setName(validName)
				.setType(ExecType.PGM)
				.build().getName(),this.validName);
	}
	
	@Test
	public void build_generates_valid_procedure_object() throws InvalidNameException {
		assertSame(this.builder
				.setName(validName)
				.setType(ExecType.PROC)
				.build().getName(),this.validName);
	}
	
	@Test(expected=InvalidNameException.class)
	public void build_throws_InvalidNameException() throws InvalidNameException {
		this.builder
		.setName(invalidName)
		.setType(ExecType.PROC)
		.build();
	}
}
