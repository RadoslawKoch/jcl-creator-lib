package com.pallas.jcl.creator.test.job.card;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.pallas.jcl.creator.datamodel.interfaces.Author;
import com.pallas.jcl.creator.datamodel.interfaces.JobCardDefinition;
import com.pallas.jcl.creator.job.card.JobCard;
import com.pallas.jcl.creator.job.card.params.Programmer;
import com.pallas.jcl.creator.job.exceptions.InvalidNameException;
import com.pallas.jcl.creator.job.general.CommentTool;

public class JobCardUnitTest {

	private String accountInfo = "JOB DESCRIPTION";
	private String jobDesc= "JOB COMMENT";
	private String jobName = "X135503X";
	private String fname = "Alan";
	private String lname = "Dulac";
	private Author autor;
	private JobCardDefinition card;
	
	@Before
	public void setup() throws InvalidNameException {
		this.autor = new Programmer(fname,lname);
		this.card = new JobCard(this.jobName);
		this.card.setAccountInfo(accountInfo);
		this.card.setAuthor(autor);
		this.card.setJobDesc(jobDesc);
		
	}
	
	@Test
	public void get_job_autor_returns_autor() {
		Author a = this.card.getAuthor();
		assertSame(a.getFname(),this.fname);
	}
	
	@Test
	public void set_job_autor_ends_ok() {
		String fn = "Jean";
		String ln = "Dubois";
		this.card.setAuthor(new Programmer(fn,ln));
		assertSame(fn,this.card.getAuthor().getFname());
	}
	
	@Test
	public void get_description_returns_description() {
		String a = this.card.getJobDesc();
		assertSame(a,this.jobDesc);
	}
	
	@Test
	public void set_description_ends_ok() {
		String fn = "NEW";
		this.card.setJobDesc(fn);
		assertSame(fn,this.card.getJobDesc());
	}
	
	@Test
	public void get_account_returns_account_info() {
		String a = this.card.getAccountInfo();
		assertSame(a,this.accountInfo);
	}
	
	@Test
	public void set_account_ends_ok() {
		String fn = "NEW";
		this.card.setAccountInfo(fn);
		assertSame(fn,this.card.getAccountInfo());
	}
	
	@Test
	public void to_string_format_validator() {
		StringBuilder content = new StringBuilder("//").append(this.jobName).append(String.format("%1$"+(12 - this.jobName.length())+"s","JOB"));
		content.append(" ").append("'"+accountInfo+"'").append(","+"'"+autor.getLname()+"'");
		content.append(CommentTool.generateComment(jobDesc, true));	
		assertTrue(content.toString().equals(card.toString()));
	}
	
}
