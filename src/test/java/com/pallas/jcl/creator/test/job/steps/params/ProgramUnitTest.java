package com.pallas.jcl.creator.test.job.steps.params;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.pallas.jcl.creator.datamodel.abstraction.Executable;
import com.pallas.jcl.creator.job.exceptions.InvalidNameException;
import com.pallas.jcl.creator.job.steps.params.Program;

public class ProgramUnitTest {

	private String pgmName = "CARDATA";
	private Executable exec;
	
	@Before
	public void setup() throws InvalidNameException {
		this.exec = new Program(this.pgmName);
	}
	
	@Test
	public void get_name_returns_name() {
		String name = this.exec.getName();
		assertSame(name,this.pgmName);
	}
	
	@Test
	public void to_string_returns_correct_format() {
		assertTrue(this.exec.toString().equals("PGM="+this.pgmName));
	}
	
	@Test
	public void create_a_new_Program_ends_OK() throws InvalidNameException {
		Executable ex = new Program(this.pgmName);
		assertTrue(ex!=null);
	}
	
	@Test(expected=InvalidNameException.class)
	public void create_a_new_Program_throws_InvalidNameException() throws InvalidNameException {
		new Program("XXXXXXXXXXXXXXXXXXX");
	}

	
}