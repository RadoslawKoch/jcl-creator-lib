package com.pallas.jcl.creator.job.exceptions;

public class InvalidParameterException 
	extends Exception {

	private static final long serialVersionUID = -3138645715056850540L;
	private String cause;
	

	public InvalidParameterException(String cause) {
		super();
		this.cause = cause;
	}
	
	@Override
	public String getMessage() {
		return "Parameter << "+this.cause+" >> is invalid.";
	}

	
	
}
