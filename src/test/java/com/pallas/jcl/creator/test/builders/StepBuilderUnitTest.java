package com.pallas.jcl.creator.test.builders;

import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;

import com.pallas.jcl.creator.builders.StepBuilder;
import com.pallas.jcl.creator.job.exceptions.DuplicateJclElementException;
import com.pallas.jcl.creator.job.exceptions.InvalidNameException;
import com.pallas.jcl.creator.job.exceptions.InvalidParameterException;
import com.pallas.jcl.creator.job.steps.dd.DDStatement;
import com.pallas.jcl.creator.job.steps.params.Procedure;
import com.pallas.jcl.creator.job.steps.params.Program;
import com.pallas.jcl.creator.job.steps.params.StepParam;
import com.pallas.jcl.creator.job.steps.params.StepParamName;

public class StepBuilderUnitTest {

	private StepBuilder builder;
	private String validStepName = "STEP0001";
	private String execName = "CARDAT";
	
	@Before
	public void setup() {
		this.builder = new StepBuilder();
	}
	
	@Test
	public void build_generates_valid_step_with_pgm() throws InvalidNameException {
		assertSame(this.builder.setName(validStepName)
				.setExecPosition(new Program(this.execName))
				.build().getExecPosition().getName(),this.execName);
	}
	
	@Test
	public void build_generates_valid_step_with_proc() throws InvalidNameException {
		assertSame(this.builder.setName(validStepName)
				.setExecPosition(new Procedure(this.execName))
				.build().getExecPosition().getName(),this.execName);
	}
	
	@Test
	public void build_generates_valid_step_with_proc_and_comment() throws InvalidNameException {
		assertSame(this.builder.setName(validStepName)
				.setExecPosition(new Procedure(this.execName))
				.setComment("TEST")
				.build().getComment(),"TEST");
	}
	
	@Test
	public void build_generates_valid_step_with_one_parameter() throws InvalidNameException, DuplicateJclElementException, InvalidParameterException {
		assertSame(this.builder.setName(validStepName)
				.setExecPosition(new Procedure(this.execName))
				.addParam(new StepParam(StepParamName.TIME,"NOLIMIT"))
				.build().getElements().size(),1);
	}
	
	@Test
	public void build_generates_valid_step_with_one_dd() throws InvalidNameException, DuplicateJclElementException, InvalidParameterException {
		assertSame(this.builder.setName(validStepName)
				.setExecPosition(new Procedure(this.execName))
				.addDD(new DDStatement("DDIN"))
				.build().getDDStatements().size(),1);
	}
	
	@Test(expected=DuplicateJclElementException.class)
	public void build_throws_DuplicateJclElementException_with_dd() throws InvalidNameException, DuplicateJclElementException, InvalidParameterException {
		this.builder.setName(validStepName)
				.setExecPosition(new Procedure(this.execName))
				.addDD(new DDStatement("DDIN"))
				.addDD(new DDStatement("DDIN"))
				.build();
	}
	
	@Test(expected=DuplicateJclElementException.class)
	public void build_throws_DuplicateJclElementException_with_param() throws InvalidNameException, DuplicateJclElementException, InvalidParameterException {
		this.builder.setName(validStepName)
				.setExecPosition(new Procedure(this.execName))
				.addParam(new StepParam(StepParamName.TIME,"NOLIMIT"))
				.addParam(new StepParam(StepParamName.TIME,"NOLIMIT"))
				.build();
	}
	
	@Test(expected=InvalidNameException.class)
	public void build_throws_InvalidNameException_with_step_name() throws InvalidNameException, DuplicateJclElementException, InvalidParameterException {
		assertSame(this.builder
				.setName("XXXXXXXXXXXXXXXX")
				.setExecPosition(new Program(this.execName))
				.build().getExecPosition()
				.getName(),this.execName);
	}
	
	
}
