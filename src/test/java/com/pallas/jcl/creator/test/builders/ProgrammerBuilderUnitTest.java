package com.pallas.jcl.creator.test.builders;

import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;

import com.pallas.jcl.creator.builders.ProgrammerBuilder;

public class ProgrammerBuilderUnitTest {

	private ProgrammerBuilder builder;
	
	@Before
	public void setup() {
		this.builder = new ProgrammerBuilder();
	}
	
	@Test
	public void build_creates_valid_Programmer_object_with_fname_and_lname() {
		assertSame(this.builder
				.setFirstName("ALAN")
				.setLastName("DULAC")
				.build().getLname(),"DULAC");
	}
	
	@Test
	public void build_creates_valid_Programmer_object_with_fname() {
		assertSame(this.builder
				.setFirstName("ALAN")
				.build().getFname(),"ALAN");
	}
	
	@Test
	public void build_creates_valid_Programmer_object_with_lname() {
		assertSame(this.builder
				.setLastName("DULAC")
				.build().getLname(),"DULAC");
	}
	
	@Test
	public void build_creates_valid_Programmer_object_with_nothing() {
		this.builder
		.build();
	}
}
