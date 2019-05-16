package com.pallas.jcl.creator.test.job.card.params;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.pallas.jcl.creator.datamodel.interfaces.Author;
import com.pallas.jcl.creator.job.card.params.Programmer;

public class ProgrammerUnitTest {

	
	private String fname = "Alan";
	private String lname = "Dulac";
	private Author autor;
	
	@Before
	public void setup() {
		this.autor = new Programmer(this.fname,this.lname);
	}
	
	@Test
	public void create_new_programmer_ends_ok() {
		Programmer pgm = new Programmer("XXXXX","XXXXX");
		assertTrue(pgm!=null);
	}
	
	@Test
	public void get_lname_returns_lname() {
		String ln = this.autor.getLname();
		assertSame(ln,this.lname);
	}
	
	@Test
	public void get_fname_returns_fname() {
		String fn = this.autor.getFname();
		assertSame(fn,this.fname);
	}
}
