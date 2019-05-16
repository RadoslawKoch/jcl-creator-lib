package com.pallas.jcl.creator.builders;

import java.util.ArrayList;
import java.util.List;

import com.pallas.jcl.creator.datamodel.abstraction.Executable;
import com.pallas.jcl.creator.datamodel.interfaces.DDStatementDefinition;
import com.pallas.jcl.creator.datamodel.interfaces.StepDefinition;
import com.pallas.jcl.creator.datamodel.interfaces.StepParamDefinition;
import com.pallas.jcl.creator.job.exceptions.DuplicateJclElementException;
import com.pallas.jcl.creator.job.exceptions.InvalidNameException;
import com.pallas.jcl.creator.job.steps.Step;

public class StepBuilder {

	
	private String name;
	private Executable execPosition;
	private List<DDStatementDefinition> ddStatements = new ArrayList<>();
	private List<StepParamDefinition> params = new ArrayList<>();
	private String comment;
	
	
	public StepBuilder setExecPosition(Executable execPosition) {
		this.execPosition = execPosition;
		return this;
	}
	
	public StepBuilder setName(String name) {
		this.name = name;
		return this;
	}
	
	public StepBuilder addDD(DDStatementDefinition ddStatement) throws DuplicateJclElementException {
		if(this.ddStatements.contains(ddStatement)) {
			throw new DuplicateJclElementException(ddStatement.getName());
		}
		this.ddStatements.add(ddStatement);
		return this;
	}
	
	public StepBuilder addParam(StepParamDefinition param) throws DuplicateJclElementException {
		if(this.params.contains(param)) {
			throw new DuplicateJclElementException(param.getName().toString());
		}
		this.params.add(param);	
		return this;
	}
	
	public StepBuilder setComment(String comment) {
		this.comment = comment;
		return this;
	}
	
	public StepDefinition build() throws InvalidNameException {
		StepDefinition def = new Step(this.name,this.execPosition);
		if(this.comment!=null) {
			def.setComment(comment);
		}
		if(!ddStatements.isEmpty()) {
			def.setDdStatements(ddStatements);
			this.ddStatements = new ArrayList<>();
		}
		if(!params.isEmpty()) {
			def.setElements(params);
			this.params = new ArrayList<>();
		}
		return def;
	}
	
	
	
	
}
