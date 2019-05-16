package com.pallas.jcl.creator.job.exceptions;


public class InvalidNameException 
	extends Exception{

	private static final long serialVersionUID = 5308657037818913020L;
	
	private String cause;
	
	public InvalidNameException(String cause) {
		this.cause = cause;
	}

	@Override
	public String getMessage() {
		return "Name << "+this.cause+" >> is invalid.";
	}

	
}
