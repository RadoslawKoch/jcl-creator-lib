package com.pallas.jcl.creator.datamodel.interfaces;

import java.util.List;

import com.pallas.jcl.creator.datamodel.abstraction.Executable;
import com.pallas.jcl.creator.job.exceptions.DuplicateJclElementException;
import com.pallas.jcl.creator.job.exceptions.JclElementNotFoundException;
import com.pallas.jcl.creator.job.steps.params.StepParamName;

public interface StepDefinition 
	extends JclContainer<StepParamName,StepParamDefinition>,
	JclElement<String>{
	
	String getComment();
	void setComment(String comment);
	DDStatementDefinition getDDByName(String name) throws JclElementNotFoundException;
	void deleteDD(String name) throws JclElementNotFoundException;
	List<DDStatementDefinition> getDDStatements();
	void addDD(DDStatementDefinition ddStatement) throws DuplicateJclElementException;
	Executable getExecPosition();
	void setDdStatements(List<DDStatementDefinition> ddStatements);
}
