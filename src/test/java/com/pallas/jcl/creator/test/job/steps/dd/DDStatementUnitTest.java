package com.pallas.jcl.creator.test.job.steps.dd;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.pallas.jcl.creator.job.exceptions.InvalidNameException;
import com.pallas.jcl.creator.job.steps.dd.DDStatement;

public class DDStatementUnitTest {

	
	private DDStatement dd;
	
	@Before
	public void setup() throws InvalidNameException {
		this.dd  = new DDStatement("DDIN");
	}
	
	@Test
	public void test_hashcode_method() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dd.getName() == null) ? 0 : dd.getName().hashCode());
		assertEquals(this.dd.hashCode(),result);
	}
	
	@Test
	public void test_equals_method_returns_true() throws InvalidNameException {
		DDStatement nd = new DDStatement("DDIN");
		assertTrue(nd.equals(dd));				
	}
	
	@Test
	public void test_equals_method_returns_false_NULL() throws InvalidNameException {
		assertFalse(dd.equals(null));				
	}
	
	@Test
	public void test_equals_method_returns_false_NO_SAME_CLASS() throws InvalidNameException {
		assertFalse(dd.equals("STRRR"));				
	}
	
	
}
