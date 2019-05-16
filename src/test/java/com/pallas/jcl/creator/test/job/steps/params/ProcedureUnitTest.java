package com.pallas.jcl.creator.test.job.steps.params;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.pallas.jcl.creator.datamodel.abstraction.Executable;
import com.pallas.jcl.creator.job.exceptions.InvalidNameException;
import com.pallas.jcl.creator.job.steps.params.Procedure;

public class ProcedureUnitTest {

	private String procName = "CARDATA";
	private Executable exec;
	
	@Before
	public void setup() throws InvalidNameException {
		this.exec = new Procedure(this.procName);
	}
	
	@Test
	public void get_name_returns_name() {
		String name = this.exec.getName();
		assertSame(name,this.procName);
	}
	
	@Test
	public void to_string_returns_correct_format() {
		assertTrue(this.exec.toString().equals("PROC="+this.procName));
	}
	
	@Test
	public void create_a_new_procedure_ends_OK() throws InvalidNameException {
		Executable ex = new Procedure(this.procName);
		assertTrue(ex!=null);
	}
	
	@Test(expected=InvalidNameException.class)
	public void create_a_new_procedure_throws_InvalidNameException() throws InvalidNameException {
		new Procedure("XXXXXXXXXXXXXXXXXXX");
	}

	
}