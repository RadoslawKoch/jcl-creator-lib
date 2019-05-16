package com.pallas.jcl.creator.builders;

import java.util.ArrayList;
import java.util.List;

import com.pallas.jcl.creator.datamodel.interfaces.DDParamDefinition;
import com.pallas.jcl.creator.datamodel.interfaces.DDStatementDefinition;
import com.pallas.jcl.creator.job.exceptions.DuplicateJclElementException;
import com.pallas.jcl.creator.job.exceptions.InvalidNameException;
import com.pallas.jcl.creator.job.steps.dd.DDStatement;

public class DDStatementBuilder {

	private String name;
	private List<DDParamDefinition> params = new ArrayList<>();
	
	public DDStatementBuilder setName(String name) {
		this.name = name;
		return this;
	}
	public DDStatementBuilder addParam(DDParamDefinition param) throws DuplicateJclElementException {
		if(this.params.contains(param))
			throw new DuplicateJclElementException(param.getName().toString());
		this.params.add(param);
		return this;
	}
	
	public DDStatementDefinition build() throws InvalidNameException {
		DDStatementDefinition def = new DDStatement(this.name);
		if(this.params.size()!=0) {
			def.setElements(params);
			this.params = new ArrayList<>();
		}
		return def;
	}


	
	
}
