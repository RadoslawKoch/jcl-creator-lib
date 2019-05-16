package com.pallas.jcl.creator.builders;

import com.pallas.jcl.creator.datamodel.abstraction.Executable;
import com.pallas.jcl.creator.job.exceptions.InvalidNameException;
import com.pallas.jcl.creator.job.steps.params.ExecType;
import com.pallas.jcl.creator.job.steps.params.Procedure;
import com.pallas.jcl.creator.job.steps.params.Program;

public class ExecutableBuilder {

	private ExecType type;
	private String name;
	
	public ExecutableBuilder setType(ExecType type) {
		this.type = type;
		return this;
	}
	public ExecutableBuilder setName(String name) {
		this.name = name;
		return this;
	}
	
	public Executable build() throws InvalidNameException {
		if(type==ExecType.PGM) {
			return new Program(this.name);
		}
		return new Procedure(this.name);
	}
	
}
