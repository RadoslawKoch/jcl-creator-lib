package com.pallas.jcl.creator.builders;

import java.util.ArrayList;
import java.util.List;

import com.pallas.jcl.creator.datamodel.interfaces.Author;
import com.pallas.jcl.creator.datamodel.interfaces.JobDefinition;
import com.pallas.jcl.creator.datamodel.interfaces.KeywordParamDefinition;
import com.pallas.jcl.creator.datamodel.interfaces.StepDefinition;
import com.pallas.jcl.creator.job.exceptions.DuplicateJclElementException;
import com.pallas.jcl.creator.job.exceptions.InvalidNameException;

public interface JobBuilderInterface {

	
	JobBuilderInterface setJobName(String jobName);
	JobBuilderInterface setAuthor(Author author);
	JobBuilderInterface setAccountInfo(String accountInfo);
	JobBuilderInterface setJobDescription(String jobDescription);
	JobBuilderInterface addStep(StepDefinition step) throws DuplicateJclElementException;
	JobBuilderInterface addKeywordParam(KeywordParamDefinition kwd) throws DuplicateJclElementException;
	JobDefinition build() throws InvalidNameException, DuplicateJclElementException;
}
