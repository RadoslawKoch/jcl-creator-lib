package com.pallas.jcl.creator.datamodel.abstraction;

import java.util.ArrayList;
import java.util.List;

import com.pallas.jcl.creator.builders.JobBuilderInterface;
import com.pallas.jcl.creator.datamodel.interfaces.Author;
import com.pallas.jcl.creator.datamodel.interfaces.JobDefinition;
import com.pallas.jcl.creator.datamodel.interfaces.KeywordParamDefinition;
import com.pallas.jcl.creator.datamodel.interfaces.StepDefinition;
import com.pallas.jcl.creator.job.exceptions.DuplicateJclElementException;
import com.pallas.jcl.creator.job.exceptions.InvalidNameException;

public abstract class JobBuilderDefinition implements JobBuilderInterface{

	protected String jobName;
	protected Author author;
	protected String accountInfo;
	protected String jobDescription;
	protected List<StepDefinition> steps = new ArrayList<>();
	protected List<KeywordParamDefinition> keywords = new ArrayList<>();
	
	@Override
	public JobBuilderDefinition setJobName(String jobName) {
		this.jobName = jobName;
		return this;
	}
	
	@Override
	public JobBuilderDefinition setAuthor(Author author) {
		this.author = author;
		return this;
	}
	
	@Override
	public JobBuilderDefinition setAccountInfo(String accountInfo) {
		this.accountInfo = accountInfo;
		return this;
	}
	
	@Override
	public JobBuilderDefinition setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
		return this;
	}
	
	@Override
	public JobBuilderDefinition addStep(StepDefinition step) throws DuplicateJclElementException {
		if(steps.contains(step))
			throw new DuplicateJclElementException(step.getName());
		this.steps.add(step);
		return this;
	}
	
	@Override
	public JobBuilderDefinition addKeywordParam(KeywordParamDefinition kwd) throws DuplicateJclElementException {
		if(keywords.contains(kwd))
			throw new DuplicateJclElementException(kwd.getName().toString());
		this.keywords.add(kwd);
		return this;
	}
	
	@Override
	public abstract JobDefinition build() throws InvalidNameException, DuplicateJclElementException;
}
