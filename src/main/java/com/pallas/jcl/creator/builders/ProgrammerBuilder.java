package com.pallas.jcl.creator.builders;

import com.pallas.jcl.creator.job.card.params.Programmer;

public class ProgrammerBuilder {

	private String firstName;
	private String lastName;
	
	public ProgrammerBuilder setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}
	public ProgrammerBuilder setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}
	
	public Programmer build() {
		return new Programmer(this.firstName,this.lastName);
	}
	
	
}
