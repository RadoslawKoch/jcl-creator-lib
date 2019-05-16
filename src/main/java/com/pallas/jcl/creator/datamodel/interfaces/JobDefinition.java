package com.pallas.jcl.creator.datamodel.interfaces;


public interface JobDefinition 
	extends JclContainer<String,StepDefinition> {

	JobCardDefinition getJobCard();
	void setJobCard(JobCardDefinition jobCard);
}
