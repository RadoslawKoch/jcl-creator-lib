package com.pallas.jcl.creator.test.job.card.params;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.pallas.jcl.creator.job.card.params.KeywordParam;
import com.pallas.jcl.creator.job.card.params.KeywordParamName;
import com.pallas.jcl.creator.job.exceptions.InvalidParameterException;

public class KeywordParamUnitTest {

	@Test
	public void to_string_format_validator() throws InvalidParameterException {
		KeywordParam par = new KeywordParam(KeywordParamName.CLASS,"X");
		assertTrue(par.toString().equals(par.getName()+"="+par.getValue()));	
	}
}
