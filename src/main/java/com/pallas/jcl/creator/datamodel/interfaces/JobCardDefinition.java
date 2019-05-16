package com.pallas.jcl.creator.datamodel.interfaces;

import com.pallas.jcl.creator.job.card.params.KeywordParamName;

public interface JobCardDefinition 
	extends JclContainer<KeywordParamName,KeywordParamDefinition>,
	JclElement<String>{

	String getJobDesc();
	void setJobDesc(String jobDesc);
	String getAccountInfo();
	void setAccountInfo(String accountInfo);	
	Author getAuthor();	
	void setAuthor(Author autor);
}
