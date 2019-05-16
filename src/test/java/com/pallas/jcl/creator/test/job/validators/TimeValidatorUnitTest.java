package com.pallas.jcl.creator.test.job.validators;

import static org.junit.Assert.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.pallas.jcl.creator.job.general.GlobalValidator;

@RunWith(Parameterized.class)
public class TimeValidatorUnitTest {

	private String input;
	private boolean expected;
	
	
	public TimeValidatorUnitTest(String input,boolean expected) {
		this.input = input;
		this.expected = expected;
	}
	
	@Parameters
	public static List<Object[]> getParams(){
		
		List<Object[]> params = new ArrayList<>();
		params.add(new Object[] {"NOLIMIT",true});
		params.add(new Object[] {"MAXIMUM",true});
		params.add(new Object[] {"1440",true});
		params.add(new Object[] {"(357912,59)",true});
		params.add(new Object[] {"(xx,xx)",false});
		params.add(new Object[] {"(0,0)",true});
		params.add(new Object[] {"0,0",false});
		params.add(new Object[] {"357912,59",false});
		params.add(new Object[] {"(59)",false});
		params.add(new Object[] {"(0)",false});
		params.add(new Object[] {"357912",false});
		params.add(new Object[] {"59",false});
		params.add(new Object[] {"12:20",false});
		params.add(new Object[] {"99:99",false});
		params.add(new Object[] {"12:20",false});
		params.add(new Object[] {"MAX",false});
		params.add(new Object[] {"FULL",false});
		params.add(new Object[] {"X",false});
		params.add(new Object[] {"62,3",false});
		params.add(new Object[] {"12h00",false});
		params.add(new Object[] {"00,00",false});
		params.add(new Object[] {"9999,999",false});
		params.add(new Object[] {"(FULLMAX)",false});
		params.add(new Object[] {"(NOLIMIT)",false});
		params.add(new Object[] {"(1440)",false});
		params.add(new Object[] {"(MAXIMUM)",false});
		
		
		return params;
	}	
	
	@Test
	public void verify_if_Time_Validator_works_as_expected() {
		assertSame(GlobalValidator.isTimeValid(this.input),this.expected);
	}
}
