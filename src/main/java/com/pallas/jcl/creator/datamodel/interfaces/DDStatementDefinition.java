package com.pallas.jcl.creator.datamodel.interfaces;

import com.pallas.jcl.creator.job.steps.dd.params.DDParamName;

public interface DDStatementDefinition 
	extends JclContainer<DDParamName,DDParamDefinition>,
	JclElement<String> {}
