package com.pallas.jcl.creator.test.job.steps.dd.params;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.pallas.jcl.creator.job.exceptions.InvalidParameterException;
import com.pallas.jcl.creator.job.steps.dd.params.DDParam;
import com.pallas.jcl.creator.job.steps.dd.params.DDParamName;

public class DDParamUnitTest {

	@Test
	public void to_string_format_validator() throws InvalidParameterException {
		DDParam dd = new DDParam(DDParamName.DISP,"SHR");
		assertTrue(dd.toString().equals(dd.getName()+"="+dd.getValue()));	
	}
	
	@Test
	public void to_string_format_validator_for_dummy() throws InvalidParameterException {
		DDParam dd = new DDParam(DDParamName.DUMMY,"SHR");
		assertTrue(dd.toString().equals("DUMMY"));	
	}
	
	@Test
	public void to_string_format_validator_for_volser() throws InvalidParameterException {
		DDParam dd = new DDParam(DDParamName.VOLSER,"0000");
		assertTrue(dd.toString().equals("VOL=SER="+dd.getValue()));	
	}
}
