package com.pallas.jcl.creator.test.job.card;

import static org.junit.Assert.assertSame;

import org.junit.Test;

import com.pallas.jcl.creator.job.card.JobCard;
import com.pallas.jcl.creator.job.card.params.KeywordParam;
import com.pallas.jcl.creator.job.card.params.KeywordParamName;
import com.pallas.jcl.creator.job.card.params.Programmer;
import com.pallas.jcl.creator.job.exceptions.DuplicateJclElementException;
import com.pallas.jcl.creator.job.exceptions.InvalidNameException;
import com.pallas.jcl.creator.job.exceptions.InvalidParameterException;
import com.pallas.jcl.creator.job.exceptions.JclElementNotFoundException;


public class CreateJobCardUnitTest {

	private String name = "X135503X";
	private String desc = "JOB DE TEST";
	private String step = "STEP0001";
	private String fname = "Alan";
	private String lname = "Dulac";
	private KeywordParamName param = KeywordParamName.RESTART;
	
	
	@Test(expected=InvalidNameException.class)
	public void throws_InvalidNameException_when_creating_job_card_with_invalid_name() throws InvalidNameException {
		new JobCard("X135503XXX");
	}
	
	@Test
	public void create_a_new_job_card_after_giving_a_correct_name() throws InvalidNameException {
		JobCard card = new JobCard(name);
		assertSame(card.getName(),name);
	}
	
	@Test
	public void setting_a_programmer_to_the_job_card() throws InvalidNameException {
		Programmer programmer = new Programmer(fname,lname);
		JobCard card = new JobCard(this.name);
		card.setAuthor(programmer);
		assertSame(card.getAuthor().getLname(),lname);
	}
	
	@Test
	public void adding_a_correct_param_to_the_jobcard() throws InvalidParameterException, InvalidNameException, DuplicateJclElementException, JclElementNotFoundException {
		JobCard card = new JobCard(this.name);
		KeywordParam param = new KeywordParam(this.param,this.step);
		card.add(param);
		assert(card.getById(this.param)!=null);
	}
	
	@Test(expected=DuplicateJclElementException.class)
	public void adding_an_existing_param_to_the_jobcard_throws_KeyWordParamAlreadyExistException ()
			throws InvalidParameterException, InvalidNameException, DuplicateJclElementException {
		JobCard card = new JobCard(this.name);
		KeywordParam param = new KeywordParam(this.param,this.step);
		card.add(param);
		param = new KeywordParam(this.param,this.step);
		card.add(param);
	}
	
	@Test(expected=JclElementNotFoundException.class)
	public void deleting_an_existing_parameter_from_job_card() throws InvalidNameException, InvalidParameterException, DuplicateJclElementException, JclElementNotFoundException {
		JobCard card = new JobCard(this.name);
		card.add(new KeywordParam(this.param,this.step));
		card.deleteById(this.param);
		card.getById(this.param);
	}
	
	@Test
	public void setting_job_description_to_the_job_card() throws InvalidNameException, DuplicateJclElementException {
		JobCard card = new JobCard(this.name);
		card.setJobDesc(this.desc);
		assert(card.getJobDesc().equals(this.desc));
	}
	
	
	
	
}
