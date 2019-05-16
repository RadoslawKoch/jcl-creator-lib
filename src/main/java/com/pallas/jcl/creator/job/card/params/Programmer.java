package com.pallas.jcl.creator.job.card.params;

import com.pallas.jcl.creator.datamodel.interfaces.Author;

public class Programmer 
	implements Author{

	private String fname;
	private String lname;
	
	public Programmer(String fname, String lname) {
		this.fname = fname;
		this.lname =lname;
	}

	@Override
	public String getFname() {
		return this.fname;
	}

	@Override
	public String getLname() {
		return this.lname;
	}	
}
