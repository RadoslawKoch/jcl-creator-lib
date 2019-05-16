package com.pallas.jcl.creator.job.exceptions;

public class JclElementNotFoundException 
	extends Exception{

	private String cause;
	
	private static final long serialVersionUID = -6309333835540736780L;
	
	public JclElementNotFoundException(String cause) {
		this.cause = cause;
	}

	@Override
	public String getMessage() {
		return "Jcl Element << "+this.cause+" >> is not found.";
	}
}
