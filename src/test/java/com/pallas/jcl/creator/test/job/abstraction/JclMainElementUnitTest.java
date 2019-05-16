package com.pallas.jcl.creator.test.job.abstraction;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.pallas.jcl.creator.datamodel.abstraction.JclMainElement;
import com.pallas.jcl.creator.datamodel.interfaces.JclElement;
import com.pallas.jcl.creator.job.exceptions.DuplicateJclElementException;
import com.pallas.jcl.creator.job.exceptions.InvalidNameException;
import com.pallas.jcl.creator.job.exceptions.JclElementNotFoundException;
import com.pallas.jcl.creator.test.job.abstraction.helpers.JclElementTest;
import com.pallas.jcl.creator.test.job.abstraction.helpers.JclMainElementTest;


public class JclMainElementUnitTest {
	
	
	private String elementName = "TEST";
	private String mainElementName = "X135503X";
	private JclElementTest element = new JclElementTest("TEST");
	private JclElementTest elementToAdd = new JclElementTest("TOADD");
	private JclMainElement<String,JclElementTest> main;
	
	@Before
	public void setup() throws InvalidNameException, com.pallas.jcl.creator.job.exceptions.InvalidNameException {
		main = new JclMainElementTest(this.mainElementName);
		main.getElements().add(element);		
	}
	
	@Test
	public void add_new_element_to_job() throws DuplicateJclElementException {
		this.main.add(this.elementToAdd);
		assertTrue(this.main.getElements().contains(this.elementToAdd));
	}
	
	@Test(expected=DuplicateJclElementException.class)
	public void add_new_element_throws_DuplicateJclElementException() throws DuplicateJclElementException {
		this.main.add(this.elementToAdd);
		this.main.add(this.elementToAdd);
	}
	
	@Test
	public void delete_element_by_id_ends_OK() throws JclElementNotFoundException {
		this.main.deleteById(element.getName());
		assertFalse(this.main.getElements().contains(element));
	}
	
	@Test(expected=JclElementNotFoundException.class)
	public void add_element_by_id_throws_JclElementNotFoundException() throws JclElementNotFoundException {
		this.main.deleteById("XXXX");
	}
	
	@Test
	public void delete_element_by_element_ends_OK() throws JclElementNotFoundException {
		this.main.delete(element);
		assertFalse(this.main.getElements().contains(element));
	}
	
	@Test(expected=JclElementNotFoundException.class)
	public void delete_element_by_element_JclElementNotFoundException() throws JclElementNotFoundException {
		this.main.delete(new JclElementTest("XXX"));
	}
	
	@Test
	public void get_element_by_name_throws_returns() throws JclElementNotFoundException {
		JclElement<String> el = this.main.getById(elementName);
		assertTrue(el.getName().equals(elementName));
	}
	
	@Test(expected=JclElementNotFoundException.class)
	public void add_element_by_element_throws_JclElementNotFoundException() throws JclElementNotFoundException {
		this.main.getById("XXX");
	}
	
	@Test
	public void get_main_element_name_returns_name() {
		String el = this.main.getName();
		assertTrue(el.equals(this.mainElementName));
	}
	
	@Test
	public void get_list_of_elements_returns_list() {
		assertTrue(this.main.getElements().size()==1);
	}
	
	
	
	
}
