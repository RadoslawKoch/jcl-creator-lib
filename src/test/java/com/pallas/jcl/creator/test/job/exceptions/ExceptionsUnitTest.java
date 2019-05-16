package com.pallas.jcl.creator.test.job.exceptions;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.pallas.jcl.creator.job.exceptions.DuplicateJclElementException;
import com.pallas.jcl.creator.job.exceptions.InvalidNameException;
import com.pallas.jcl.creator.job.exceptions.InvalidParameterException;
import com.pallas.jcl.creator.job.exceptions.JclElementNotFoundException;

public class ExceptionsUnitTest {

	private String nameElement = "X135503X";
	private DuplicateJclElementException dup;
	private InvalidNameException name;
	private InvalidParameterException param;
	private JclElementNotFoundException found;
	
	@Before
	public void setup() {
		this.dup = new DuplicateJclElementException(this.nameElement);
		this.name = new InvalidNameException(this.nameElement);
		this.param = new InvalidParameterException(this.nameElement);
		this.found = new JclElementNotFoundException(this.nameElement);
	}
	
	@Test
	public void get_message_from_DuplicateJclElementException_returns_valid_message() {
		String expected = "Jcl Element << "+this.nameElement+" >> already exists.";
		assertTrue(expected.equals(this.dup.getMessage()));
	}
	
	@Test
	public void get_message_from_InvalidNameException_returns_valid_message() {
		String expected = "Name << "+this.nameElement+" >> is invalid.";
		assertTrue(expected.equals(this.name.getMessage()));
	}
	
	@Test
	public void get_message_from_InvalidParameterException_returns_valid_message() {
		String expected = "Parameter << "+this.nameElement+" >> is invalid.";
		assertTrue(expected.equals(this.param.getMessage()));
	}
	
	@Test
	public void get_message_from_JclElementNotFoundException_returns_valid_message() {
		String expected = "Jcl Element << "+this.nameElement+" >> is not found.";
		assertTrue(expected.equals(this.found.getMessage()));
	}
}
