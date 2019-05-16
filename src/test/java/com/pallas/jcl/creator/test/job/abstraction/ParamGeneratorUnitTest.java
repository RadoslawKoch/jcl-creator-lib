package com.pallas.jcl.creator.test.job.abstraction;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.pallas.jcl.creator.datamodel.interfaces.JclValidator;
import com.pallas.jcl.creator.job.exceptions.InvalidParameterException;
import com.pallas.jcl.creator.job.general.GlobalSettings;
import com.pallas.jcl.creator.test.job.abstraction.helpers.ParamGeneratorTest;
import com.pallas.jcl.creator.test.job.abstraction.helpers.ParameterTest;

@RunWith(MockitoJUnitRunner.class)
public class ParamGeneratorUnitTest {

	@Mock
	JclValidator<String> val;
	
	private ParamGeneratorTest generator = new ParamGeneratorTest();
	private List<ParameterTest> list = new ArrayList<>();
	
	@Before
	public void setup() throws InvalidParameterException {
		when(this.val.isValid("TEST", "TEST")).thenReturn(true);
		list.add(new ParameterTest("TEST","TEST",val));
		list.add(new ParameterTest("TEST","TEST",val));
		list.add(new ParameterTest("TEST","TEST",val));
		list.add(new ParameterTest("TEST","TEST",val));
		list.add(new ParameterTest("TEST","TEST",val));
		list.add(new ParameterTest("TEST","TEST",val));
		list.add(new ParameterTest("TEST","TEST",val));
		list.add(new ParameterTest("TEST","TEST",val));
		list.add(new ParameterTest("TEST","TEST",val));
		list.add(new ParameterTest("TEST","TEST",val));
		list.add(new ParameterTest("TEST","TEST",val));
		list.add(new ParameterTest("TEST","TEST",val));
		list.add(new ParameterTest("TEST","TEST",val));
		list.add(new ParameterTest("TEST","TEST",val));
		list.add(new ParameterTest("TEST","TEST",val));
		list.add(new ParameterTest("TEST","TEST",val));
		list.add(new ParameterTest("TEST","TEST",val));
		list.add(new ParameterTest("TEST","TEST",val));
		list.add(new ParameterTest("TEST","TEST",val));
		list.add(new ParameterTest("TEST","TEST",val));
		
	}
	
	@Test
	public void get_params_returns_a_list_of_well_formated_params() {
		assertTrue(this.getParam(0, list).equals(this.generator.testFormat(0, list)));
	}
	
	
	
	
	
	
	private String getParam(int signCounter, List<ParameterTest> list) {
		StringBuilder content = new StringBuilder();
		
		int counter = 0;
		for(Object x : list) {
			int length = x.toString().length();
			if(!isInLine(signCounter,x.toString())) {
				content.append("\n//         ");
				signCounter = 11;
			}
			counter++;
			content.append(x);
			signCounter+=length;
			if(counter==list.size()) {
				break;
			}
			content.append(",");
		}
		return content.toString();
	}
	
	private boolean isInLine(int currentLength, String toAppend) {
		return (currentLength + toAppend.length())<GlobalSettings.LINE_LENGTH;
	}
}
 