package com.pallas.jcl.creator.job.exceptions;


public class DuplicateJclElementException 
	extends Exception {

	private static final long serialVersionUID = -4389579488511907830L;
	private String cause;
	
	public DuplicateJclElementException(String cause) {
		this.cause = cause;
	}

	@Override
	public String getMessage() {
		return "Jcl Element << "+this.cause+" >> already exists.";
	}
	
	
	
}
