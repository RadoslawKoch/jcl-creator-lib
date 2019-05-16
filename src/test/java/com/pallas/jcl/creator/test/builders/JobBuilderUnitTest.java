package com.pallas.jcl.creator.test.builders;

import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;

import com.pallas.jcl.creator.builders.JobBuilder;
import com.pallas.jcl.creator.datamodel.interfaces.StepDefinition;
import com.pallas.jcl.creator.job.card.params.KeywordParam;
import com.pallas.jcl.creator.job.card.params.KeywordParamName;
import com.pallas.jcl.creator.job.card.params.Programmer;
import com.pallas.jcl.creator.job.exceptions.DuplicateJclElementException;
import com.pallas.jcl.creator.job.exceptions.InvalidNameException;
import com.pallas.jcl.creator.job.exceptions.InvalidParameterException;
import com.pallas.jcl.creator.job.steps.Step;
import com.pallas.jcl.creator.job.steps.params.Procedure;

public class JobBuilderUnitTest {

	private String validJobName = "EXUPL001";
	private String invalidJobName = "XXXXXXXXXXXXXXx";
	private JobBuilder builder;
	
	@Before
	public void setup() {
		this.builder = new JobBuilder();
	}
	
	@Test
	public void build_generates_correct_job_object_with_name_only() throws InvalidNameException, DuplicateJclElementException {
		assertSame(this.builder
				.setJobName(validJobName)
				.build().getJobCard().getName(),this.validJobName);
	}
	
	@Test
	public void build_generates_correct_job_object_with_name_and_account_info() throws InvalidNameException, DuplicateJclElementException {
		String accInfo = "XYZ";
		assertSame(this.builder
				.setJobName(validJobName).setAccountInfo(accInfo)
				.build().getJobCard().getAccountInfo(),accInfo);
	}
	
	@Test
	public void build_generates_correct_job_object_with_name_and_pgm_name() throws InvalidNameException, DuplicateJclElementException {
		String nm = "ALAN";
		assertSame(this.builder
				.setJobName(validJobName).setAuthor(new Programmer(nm,nm))
				.build().getJobCard().getAuthor().getLname(),nm);
	}
	
	@Test
	public void build_generates_correct_job_object_with_name_and_comment() throws InvalidNameException, DuplicateJclElementException {
		String nm = "ALAN";
		assertSame(this.builder
				.setJobName(validJobName).setJobDescription(nm)
				.build().getJobCard().getJobDesc(),nm);
	}
	
	@Test
	public void build_generates_correct_job_with_one_keyword_param() throws InvalidNameException, DuplicateJclElementException, InvalidParameterException {
		KeywordParam param = new KeywordParam(KeywordParamName.CLASS,"X");
		assertSame(this.builder
				.setJobName(validJobName)
				.addKeywordParam(param)
				.build().getJobCard().getElements().size(),1);
	}
	
	@Test
	public void build_generates_correct_job_with_one_step() throws InvalidNameException, DuplicateJclElementException, InvalidParameterException {
		StepDefinition step = new Step("STEP0001",new Procedure("CARDAT"));
		assertSame(this.builder
				.setJobName(validJobName)
				.addStep(step)
				.build().getElements().size(),1);
	}
	
	@Test(expected=DuplicateJclElementException.class)
	public void build_throws_DuplicateJclElementException_with_step() throws InvalidNameException, DuplicateJclElementException, InvalidParameterException {
		StepDefinition step = new Step("STEP0001",new Procedure("CARDAT"));
		this.builder
		.setJobName(validJobName)
		.addStep(step)
		.addStep(step)
		.build().getElements().size();
	}
	
	@Test(expected=DuplicateJclElementException.class)
	public void build_throws_DuplicateJclElementException_with_keyword() throws InvalidNameException, DuplicateJclElementException, InvalidParameterException {
		KeywordParam param = new KeywordParam(KeywordParamName.CLASS,"X");
		this.builder
		.setJobName(validJobName)
		.addKeywordParam(param)
		.addKeywordParam(param)
		.build();
	}
	
	@Test(expected=InvalidNameException.class)
	public void build_throws_InvalidNameException_with_job_name() throws InvalidNameException, DuplicateJclElementException, InvalidParameterException {
		this.builder
		.setJobName(invalidJobName)
		.build();
	}
}
