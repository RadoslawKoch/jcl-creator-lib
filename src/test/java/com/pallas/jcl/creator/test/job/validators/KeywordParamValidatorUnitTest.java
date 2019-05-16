package com.pallas.jcl.creator.test.job.validators;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.pallas.jcl.creator.job.card.params.KeywordParamName;
import com.pallas.jcl.creator.job.card.params.KeywordValidator;

public class KeywordParamValidatorUnitTest {
	
	private KeywordValidator validator = KeywordValidator.getValidator();

	@Test
	public void is_time_valid() {
		assertTrue(this.validator.isValid(KeywordParamName.TIME, "1440"));
	}
	
	@Test
	public void is_time_invalid() {
		assertFalse(this.validator.isValid(KeywordParamName.TIME, ""));
	}
	
	@Test
	public void is_schenv_valid() {
		assertTrue(this.validator.isValid(KeywordParamName.SCHENV, "X13505"));
	}
	
	@Test
	public void is_schenv_invalid() {
		assertFalse(this.validator.isValid(KeywordParamName.SCHENV, ""));
	}
	
	@Test
	public void is_msgclass_valid_with_A_as_argument_returns_true() {
		assertTrue(this.validator.isValid(KeywordParamName.MSGCLASS, "A"));
	}
	
	@Test
	public void is_msgclass_valid_with_Z_as_argument_returns_true() {
		assertTrue(this.validator.isValid(KeywordParamName.MSGCLASS, "Z"));
	}
	
	@Test
	public void is_msgclass_valid_with_a_as_argument_returns_true() {
		assertTrue(this.validator.isValid(KeywordParamName.MSGCLASS, "a"));
	}
	
	@Test
	public void is_msgclass_valid_with_z_as_argument_returns_true() {
		assertTrue(this.validator.isValid(KeywordParamName.MSGCLASS, "z"));
	}

	@Test
	public void is_msgclass_valid_with_0_as_argument_returns_false() {
		assertFalse(this.validator.isValid(KeywordParamName.MSGCLASS, "0"));
	}
	
	@Test
	public void is_msgclass_valid_with_99999999999_as_argument_returns_false() {
		assertFalse(this.validator.isValid(KeywordParamName.MSGCLASS, "99999999999"));
	}
	
	@Test
	public void is_msgclass_valid_with_minus_10_as_argument_returns_false() {
		assertFalse(this.validator.isValid(KeywordParamName.MSGCLASS, "-10"));
	}
	

	
	

}
