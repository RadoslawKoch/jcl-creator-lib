package com.pallas.jcl.creator.test.job.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.pallas.jcl.creator.datamodel.abstraction.Executable;
import com.pallas.jcl.creator.datamodel.interfaces.DDStatementDefinition;
import com.pallas.jcl.creator.datamodel.interfaces.StepDefinition;
import com.pallas.jcl.creator.job.exceptions.DuplicateJclElementException;
import com.pallas.jcl.creator.job.exceptions.InvalidNameException;
import com.pallas.jcl.creator.job.exceptions.JclElementNotFoundException;
import com.pallas.jcl.creator.job.general.CommentTool;
import com.pallas.jcl.creator.job.general.GlobalSettings;
import com.pallas.jcl.creator.job.steps.Step;
import com.pallas.jcl.creator.job.steps.dd.DDStatement;
import com.pallas.jcl.creator.job.steps.params.Program;

public class StepUnitTest {

	private String comment = "COMMENT";
	private String stepName = "STEP0001";
	private String ddName = "DDIN1";
	private String ddNameToAdd = "DDIN2";
	private DDStatementDefinition dd;
	private DDStatementDefinition ddToAdd;
	private StepDefinition step;
	private String execName = "IEFBR14";
	private Executable exec;
	
	@Before
	public void setup() throws InvalidNameException {
		this.exec = new Program(this.execName);
		this.dd = new DDStatement(this.ddName);
		this.ddToAdd = new DDStatement(this.ddNameToAdd);
		this.step = new Step(this.stepName,this.exec);
		this.step.getDDStatements().add(dd);	
	}
	
	@Test
	public void get_existing_comment_returns_null() {
		assertSame(this.step.getComment(),null);
	}
	

	@Test
	public void set_and_get_comment_returns_comment() {
		this.step.setComment(comment);
		String result = this.step.getComment();
		assertSame(comment,result);
	}
	
	@Test
	public void get_exec_returns_exec_statement() {
		Executable exec = this.step.getExecPosition();
		assertSame(exec.getName(),this.execName);
	}
	
	@Test
	public void add_new_dd_to_step_ends_OK() throws DuplicateJclElementException {
		this.step.addDD(ddToAdd);
		assertTrue(this.step.getDDStatements().contains(ddToAdd));
	}
	
	@Test(expected=DuplicateJclElementException.class)
	public void add_new_dd_to_step_throws_DuplicateJclElementException() throws DuplicateJclElementException {
		this.step.addDD(dd);
	}
	
	@Test
	public void delete_dd_from_step_ends_OK() throws JclElementNotFoundException  {
		this.step.deleteDD(ddName);
		assertFalse(this.step.getDDStatements().contains(dd));
	}
	
	@Test(expected=JclElementNotFoundException.class)
	public void delete_dd_from_step_throws_JclElementNotFoundException() throws JclElementNotFoundException {
		this.step.deleteDD(this.ddNameToAdd);
	}
	
	@Test
	public void get_dd_from_step_ends_OK() throws JclElementNotFoundException  {
		DDStatementDefinition def = this.step.getDDByName(ddName);
		assertSame(def.getName(),ddName);
	}
	
	@Test(expected=JclElementNotFoundException.class)
	public void get_dd_from_step_throws_JclElementNotFoundException() throws JclElementNotFoundException {
		this.step.getDDByName(ddNameToAdd);
	}
	
	@Test
	public void get_dds_returns_dd_list() {
		List<DDStatementDefinition> list = this.step.getDDStatements();
		assertSame(list.size(),1);
	}
	
	@Test
	public void hash_code_returns_same_code() throws InvalidNameException {
		Step tmp = new Step(this.stepName,this.exec);
		assertEquals(tmp.hashCode(),this.step.hashCode());
	}
	
	@Test
	public void hash_code_returns_different_code() throws InvalidNameException {
		Step tmp = new Step("XXXX",this.exec);
		assertNotEquals(tmp.hashCode(),this.step.hashCode());
	}
	
	@Test
	public void equals_returns_same_true() throws InvalidNameException {
		Step tmp = new Step(this.stepName,this.exec);
		assertTrue(tmp.equals(step));
	}
	
	@Test
	public void equals_returns_false_DIFFERENT_NAME() throws InvalidNameException {
		Step tmp = new Step("XXXX",this.exec);
		assertFalse(tmp.equals(step));
	}
	
	@Test
	public void equals_returns_false_NULL() throws InvalidNameException {
		Step tmp = new Step("XXXX",this.exec);
		assertFalse(tmp.equals(null));
	}
	
	@Test
	public void equals_returns_false_DIFFERENT_CLASS() throws InvalidNameException {
		Step tmp = new Step("XXXX",this.exec);
		assertFalse(tmp.equals("XXXXXXXX"));
	}
	
	@Test
	public void to_string_returns_valid_format() {
		assertTrue(this.simulateToString(step).equals(step.toString()));
	}
	
	private String simulateToString(StepDefinition stp) {
		StringBuilder content = new StringBuilder();
		if(stp.getComment()!=null) {
			content.append(CommentTool.generateComment(this.comment, false));
		}
		content.append("\n//").append(stp.getName()).append(String.format("%1$"+(13 - stp.getName().length())+"s","EXEC")).append(" ").append(stp.getExecPosition());
		int signCounter = content.length();
		if(stp.getDDStatements().size()>0) {
			for(DDStatementDefinition x : stp.getDDStatements()) {
				if(signCounter+x.toString().length()+2 >  GlobalSettings.LINE_LENGTH) {
					signCounter=11;
				}
				signCounter+=x.toString().length()+2;
				content.append(x);				
			}			
		}
		return content.toString();
	}
	

}
