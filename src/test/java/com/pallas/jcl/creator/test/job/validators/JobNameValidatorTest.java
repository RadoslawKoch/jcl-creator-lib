package com.pallas.jcl.creator.test.job.validators;

import static org.junit.Assert.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.pallas.jcl.creator.job.exceptions.InvalidNameException;
import com.pallas.jcl.creator.job.general.GlobalValidator;

@RunWith(Parameterized.class)
public class JobNameValidatorTest {
	
	
	private String jobName;
	private boolean expected;
	
	public JobNameValidatorTest(String jobName, boolean expected) {
		this.jobName = jobName;
		this.expected = expected;
	}
	

	@Parameters
	public static List<Object[]> getParams() {
		
		List<Object[]> params = new ArrayList<>();
		params.add(new Object[] {"012342",false});
		params.add(new Object[] {"-asdsad=",false});
		params.add(new Object[] {"----",false});
		params.add(new Object[] {"",false});
		params.add(new Object[] {"xsdkaldksaldksal",false});
		params.add(new Object[] {"xxxxxxxxx",false});
		params.add(new Object[] {"0X13550*",false});
		params.add(new Object[] {"-",false});
		params.add(new Object[] {"\\1202",false});
		params.add(new Object[] {"-",false});
		params.add(new Object[] {"x135505\\",false});
		params.add(new Object[] {"x135505\\",false});
		params.add(new Object[] {"x135505*",false});
		params.add(new Object[] {"",false});
		params.add(new Object[] {"00000",false});
		params.add(new Object[] {"X135504XX",false});
		
		
		
		
		params.add(new Object[] {"X135505",true});
		params.add(new Object[] {"E1234567",true});
		params.add(new Object[] {"X",true});
		params.add(new Object[] {"X2",true});
		params.add(new Object[] {"C0103",true});
		params.add(new Object[] {"Z00912X",true});
		params.add(new Object[] {"EUX91056",true});
		params.add(new Object[] {"ZX135504",true});
		params.add(new Object[] {"X1X3X4",true});
		params.add(new Object[] {"C09",true});
		params.add(new Object[] {"A121",true});
		params.add(new Object[] {"D12222",true});
		params.add(new Object[] {"XXXX1XXX",true});
		params.add(new Object[] {"ZZZ99999",true});
		return params;
	}
	
	
	@Test
	public void testing_if_name_validator_works_as_expected() throws InvalidNameException {
		assertSame(GlobalValidator.isNameValid(this.jobName),expected);
	}
	


}

