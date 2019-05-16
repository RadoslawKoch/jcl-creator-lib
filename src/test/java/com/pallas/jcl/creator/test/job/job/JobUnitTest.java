package com.pallas.jcl.creator.test.job.job;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.pallas.jcl.creator.datamodel.interfaces.JobCardDefinition;
import com.pallas.jcl.creator.datamodel.interfaces.JobDefinition;
import com.pallas.jcl.creator.job.Job;
import com.pallas.jcl.creator.job.card.JobCard;
import com.pallas.jcl.creator.job.exceptions.InvalidNameException;

public class JobUnitTest {

	private String jobName = "X135503X";
	private JobDefinition job;

	private JobCardDefinition card;
	
	@Before
	public void setup() throws InvalidNameException {
		this.card = new JobCard(this.jobName);
		this.job = new Job(this.card);
	}
	
	@Test
	public void get_job_card_returns_job_card() {
		JobCardDefinition jc  = this.job.getJobCard();
		assertTrue(jc.getName().equals(jobName));
	}
	
	@Test
	public void set_job_card_ends_OK() throws InvalidNameException {
		String tmp = "TESTXX";
		JobCardDefinition jc = new JobCard(tmp);
		this.job.setJobCard(jc);
		assertTrue(this.job.getJobCard().getName().equals(tmp));		
	}
	
	@Test(expected=InvalidNameException.class)
	public void set_job_card_throws_InvalidNameException() throws InvalidNameException {
		String tmp = "TESTXXXXXXXXXXXXXX";
		this.job.setJobCard(new JobCard(tmp));		
	}
	
	@Test
	public void to_string_format_validation() {
		String result = card.toString().concat("\n//********************************");
		assertTrue(result.equals(job.toString()));
	}
	
	
}
