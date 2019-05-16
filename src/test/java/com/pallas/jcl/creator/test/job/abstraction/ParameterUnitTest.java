package com.pallas.jcl.creator.test.job.abstraction;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.pallas.jcl.creator.datamodel.interfaces.JclValidator;
import com.pallas.jcl.creator.job.exceptions.InvalidParameterException;
import com.pallas.jcl.creator.test.job.abstraction.helpers.ParameterTest;

@RunWith(MockitoJUnitRunner.class)
public class ParameterUnitTest {

	
	@Mock
	private JclValidator<String> validator;
	
	private String name = "TEST";
	private String value ="VALUE";
	private ParameterTest param;
	
	@Before
	public void setup() throws InvalidParameterException {
		when(validator.isValid(name, value)).thenReturn(true);
		when(validator.isValid("DIFF", value)).thenReturn(true);
		this.param = new ParameterTest(this.name,this.value,this.validator);	
	}
	
	@Test
	public void get_param_name_returns_name() {
		assertSame(this.param.getName(),this.name);
	}
	
	@Test
	public void get_param_value_returns_value() {
		assertSame(this.param.getValue(),this.value);
	}
	
	@Test
	public void create_param_ends_OK() throws InvalidParameterException {
		ParameterTest pr = new ParameterTest(name, value, validator);
		assertSame(pr.getName(),this.name);
	}
	
	@Test
	public void test_equals_method_returns_true() throws InvalidParameterException {
		ParameterTest pr = new ParameterTest(name, value, validator);
		assert(pr.equals(this.param));
	}
	
	@Test
	public void test_equals_method_returns_false() throws InvalidParameterException {
		ParameterTest pr = new ParameterTest("DIFF", value, validator);
		assertFalse(pr.equals(this.param));
	}
	
	@Test
	public void verify_hashcode_metod() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		assertEquals(this.param.hashCode(),result);
	}
}
