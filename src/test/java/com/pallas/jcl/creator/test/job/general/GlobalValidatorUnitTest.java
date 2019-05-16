package com.pallas.jcl.creator.test.job.general;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.pallas.jcl.creator.job.general.GlobalValidator;

public class GlobalValidatorUnitTest {

	@Test
	public void creaate_new_instance_of_class_GlobalValidator() {
		assertTrue(new GlobalValidator()!=null);
	}
}
