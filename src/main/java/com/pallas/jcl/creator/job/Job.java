package com.pallas.jcl.creator.job;

import com.pallas.jcl.creator.datamodel.abstraction.JclMainElement;
import com.pallas.jcl.creator.datamodel.interfaces.JobCardDefinition;
import com.pallas.jcl.creator.datamodel.interfaces.JobDefinition;
import com.pallas.jcl.creator.datamodel.interfaces.StepDefinition;
import com.pallas.jcl.creator.job.exceptions.InvalidNameException;

public class Job 
	extends JclMainElement<String,StepDefinition>
	implements JobDefinition{

	private JobCardDefinition jobCard;

	public Job(JobCardDefinition jobCard) throws InvalidNameException {
		super(jobCard.getName());
		this.jobCard=jobCard;
	}
	
	@Override
	public JobCardDefinition getJobCard() {
		return this.jobCard;
	}
	
	@Override
	public void setJobCard(JobCardDefinition jobCard) {
		this.jobCard = jobCard;
	}

	@Override
	public String toString() {
		String result = jobCard.toString().concat("\n//********************************");
		for(StepDefinition x : this.elementList) {
			result+=x;
		}
		return result;
	}
	
	
	
	
	
}
