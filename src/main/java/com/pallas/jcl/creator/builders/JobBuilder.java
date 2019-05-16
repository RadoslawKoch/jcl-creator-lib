package com.pallas.jcl.creator.builders;

import java.util.ArrayList;
import java.util.List;

import com.pallas.jcl.creator.datamodel.abstraction.JobBuilderDefinition;
import com.pallas.jcl.creator.datamodel.interfaces.Author;
import com.pallas.jcl.creator.datamodel.interfaces.JobDefinition;
import com.pallas.jcl.creator.datamodel.interfaces.KeywordParamDefinition;
import com.pallas.jcl.creator.datamodel.interfaces.StepDefinition;
import com.pallas.jcl.creator.job.Job;
import com.pallas.jcl.creator.job.card.JobCard;
import com.pallas.jcl.creator.job.exceptions.DuplicateJclElementException;
import com.pallas.jcl.creator.job.exceptions.InvalidNameException;

public class JobBuilder extends JobBuilderDefinition{

//	private String jobName;
//	private Author author;
//	private String accountInfo;
//	private String jobDescription;
//	private List<StepDefinition> steps = new ArrayList<>();
//	private List<KeywordParamDefinition> keywords = new ArrayList<>();
//	
//	public JobBuilder setJobName(String jobName) {
//		this.jobName = jobName;
//		return this;
//	}
//	public JobBuilder setAuthor(Author author) {
//		this.author = author;
//		return this;
//	}
//	public JobBuilder setAccountInfo(String accountInfo) {
//		this.accountInfo = accountInfo;
//		return this;
//	}
//	public JobBuilder setJobDescription(String jobDescription) {
//		this.jobDescription = jobDescription;
//		return this;
//	}
//	
//	public JobBuilder addStep(StepDefinition step) throws DuplicateJclElementException {
//		if(steps.contains(step))
//			throw new DuplicateJclElementException(step.getName());
//		this.steps.add(step);
//		return this;
//	}
//	
//	public JobBuilder addKeywordParam(KeywordParamDefinition kwd) throws DuplicateJclElementException {
//		if(keywords.contains(kwd))
//			throw new DuplicateJclElementException(kwd.getName().toString());
//		this.keywords.add(kwd);
//		return this;
//	}
//	
	@Override
	public JobDefinition build() throws InvalidNameException, DuplicateJclElementException {
		JobCard card = new JobCard(jobName);
		if(this.author!=null) {
			card.setAuthor(this.author);
		}
		if(this.accountInfo!=null) {
			card.setAccountInfo(this.accountInfo);
		}
		if(this.jobDescription!=null) {
			card.setJobDesc(this.jobDescription);
		}	
		Job tmp = new Job(card);
		if(this.steps.size()!=0) {
			tmp.setElements(steps);
			this.steps = new ArrayList<>();
		}
		if(this.keywords.size()!=0) {
			tmp.getJobCard().setElements(keywords);
			this.keywords = new ArrayList<>();
		}
		return tmp;
	}
	
	
	

}
