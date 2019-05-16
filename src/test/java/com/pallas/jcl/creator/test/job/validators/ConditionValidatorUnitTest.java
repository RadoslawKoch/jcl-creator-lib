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
public class ConditionValidatorUnitTest {

	private String conditon;
	private boolean expected;
	
	
	public ConditionValidatorUnitTest(String conditon, boolean expected) {
		this.conditon = conditon;
		this.expected = expected;
	}
	
	@Parameters
	public static List<Object[]> getParams(){
		List<Object[]> list = new ArrayList<>();
		list.add(new Object[] {"(0,NE)",true});
		list.add(new Object[] {"(0,EQ)",true});
		list.add(new Object[] {"(0,GT)",true});
		list.add(new Object[] {"(0,LT)",true});
		list.add(new Object[] {"(0,LE)",true});
		list.add(new Object[] {"(0,GE)",true});
		
		list.add(new Object[] {"(99,NE)",true});
		list.add(new Object[] {"(99,EQ)",true});
		list.add(new Object[] {"(99,GT)",true});
		list.add(new Object[] {"(99,LT)",true});
		list.add(new Object[] {"(99,LE)",true});
		list.add(new Object[] {"(99,GE)",true});
		
		list.add(new Object[] {"(05,NE)",true});
		list.add(new Object[] {"(05,EQ)",true});
		list.add(new Object[] {"(05,GT)",true});
		list.add(new Object[] {"(05,LT)",true});
		list.add(new Object[] {"(05,LE)",true});
		list.add(new Object[] {"(05,GE)",true});
		
		list.add(new Object[] {"(5,NE)",true});
		list.add(new Object[] {"(5,EQ)",true});
		list.add(new Object[] {"(5,GT)",true});
		list.add(new Object[] {"(5,LT)",true});
		list.add(new Object[] {"(5,LE)",true});
		list.add(new Object[] {"(5,GE)",true});
		
		list.add(new Object[] {"((5,NE),(5,NE))",true});
		list.add(new Object[] {"((5,EQ),(5,NE))",true});
		list.add(new Object[] {"((5,GT),(5,NE))",true});
		list.add(new Object[] {"((5,LT),(5,NE))",true});
		list.add(new Object[] {"((5,LE),(5,NE))",true});
		list.add(new Object[] {"((5,GE),(5,NE))",true});
		
		list.add(new Object[] {"((99,NE),(5,NE))",true});
		list.add(new Object[] {"((99,EQ),(5,NE))",true});
		list.add(new Object[] {"((99,GT),(5,NE))",true});
		list.add(new Object[] {"((99,LT),(5,NE))",true});
		list.add(new Object[] {"((99,LE),(5,NE))",true});
		list.add(new Object[] {"((99,GE),(5,NE))",true});
		
		
		list.add(new Object[] {"((99,NE),(5,NE),(5,NE))",true});
		list.add(new Object[] {"((99,EQ),(5,NE),(5,NE),(5,NE))",true});
		list.add(new Object[] {"((99,GT),(5,NE),(5,NE),(5,NE),(5,NE))",true});
		list.add(new Object[] {"((99,LT),(5,NE),(5,NE),(5,NE),(5,NE),(5,NE),(5,NE))",true});
		list.add(new Object[] {"((99,LE),(5,NE),(5,NE),(5,NE),(5,NE),(5,NE),(5,NE),(5,NE))",true});
		list.add(new Object[] {"((99,GE),(5,NE),(5,NE),(5,NE),(5,NE),(5,NE),(5,NE),(5,NE),(5,NE),(5,NE))",true});
		
		
		
		
		list.add(new Object[] {"(5,NE),(5,NE)",false});
		list.add(new Object[] {"(5,EQ),(5,NE)",false});
		list.add(new Object[] {"(5,GT),(5,NE)",false});
		list.add(new Object[] {"(5,LT),(5,NE)",false});
		list.add(new Object[] {"(5,LE),(5,NE)",false});
		list.add(new Object[] {"(5,GE),(5,NE)",false});

		list.add(new Object[] {"(5,NE),(5,NE))",false});
		list.add(new Object[] {"(5,EQ),(5,NE))",false});
		list.add(new Object[] {"(5,GT),(5,NE))",false});
		list.add(new Object[] {"(5,LT),(5,NE))",false});
		list.add(new Object[] {"(5,LE),(5,NE))",false});
		list.add(new Object[] {"(5,GE),(5,NE))",false});
		
		list.add(new Object[] {"(5,NE,(5,NE))",false});
		list.add(new Object[] {"5,EQ),(5,NE)))",false});
		list.add(new Object[] {"(((5,GT),(5,NE))",false});
		list.add(new Object[] {"(5,LT),(5,NE",false});
		list.add(new Object[] {"(5,LE),5,NE",false});
		list.add(new Object[] {"5,GE,5,NE",false});
		
		list.add(new Object[] {"(5,NE,(5,NE))",false});
		list.add(new Object[] {"5,EQ),(5,NE)))",false});
		list.add(new Object[] {"(((5,GT),(5,NE))",false});
		list.add(new Object[] {"(5,LT),(5,NE",false});
		list.add(new Object[] {"(5,LE),5,NE",false});
		list.add(new Object[] {"5,GE,5,NE",false});
		
		list.add(new Object[] {"((99,NE))",true});
		list.add(new Object[] {"((99,EQ))",true});
		list.add(new Object[] {"((99,GT))",true});
		list.add(new Object[] {"((99,LT))",true});
		list.add(new Object[] {"((99,LE))",true});
		list.add(new Object[] {"((99,GE))",true});
		
		list.add(new Object[] {"99,NE",false});
		list.add(new Object[] {"99,EQ",false});
		list.add(new Object[] {"99,GT",false});
		list.add(new Object[] {"99,LT",false});
		list.add(new Object[] {"99,LE",false});
		list.add(new Object[] {"99,GE",false});
		
		list.add(new Object[] {"NE",false});
		list.add(new Object[] {"997",false});
		list.add(new Object[] {"GT",false});
		list.add(new Object[] {"9",false});
		list.add(new Object[] {"LE",false});
		list.add(new Object[] {"959",false});
		
		list.add(new Object[] {"()",false});
		list.add(new Object[] {"(,)",false});
		list.add(new Object[] {"((,),(,),(,))",false});
		list.add(new Object[] {"xxxxxx",false});
		list.add(new Object[] {"Bonjour",false});
		list.add(new Object[] {"valid",false});
		
		list.add(new Object[] {"",false});
		list.add(new Object[] {" ",false});
		list.add(new Object[] {"xd",false});
		list.add(new Object[] {"X134403",false});
		list.add(new Object[] {"why",false});
		list.add(new Object[] {"02w9102",false});
		

		list.add(new Object[] {",,,,,,",false});
		list.add(new Object[] {"......",false});
		list.add(new Object[] {"//////",false});
		list.add(new Object[] {"((()))",false});
		
		list.add(new Object[] {"((99,GE),EVEN)",true});
		list.add(new Object[] {"((99,GE),ONLY)",true});
		list.add(new Object[] {"((99,GE),(5,GT),EVEN)",true});
		list.add(new Object[] {"((99,GE),(0,EQ),EVEN)",true});
		list.add(new Object[] {"((99,GE),(0,EQ),(0,EQ),(0,EQ),(0,EQ),EVEN)",true});
		list.add(new Object[] {"((99,GE),(0,EQ),(0,EQ),(0,EQ),ONLY)",true});
		list.add(new Object[] {"((99,GE),(0,EQ),(0,EQ),(0,EQ),(0,EQ),(0,EQ),(0,EQ),(0,EQ),(5,GT),ONLY)",true});
		
		
		list.add(new Object[] {"((99,GE),(0,EQ),NULL)",false});
		list.add(new Object[] {"((99,GE),(0,EQ,LOL)",false});
		list.add(new Object[] {"(99,GE,0,EQ,NULL=>)",false});
		
		list.add(new Object[] {"))99,GE((,(0,EQ),NULL)",false});
		list.add(new Object[] {")(99,GE(,)0,EQ,LOL(",false});
		list.add(new Object[] {"(99,GE,0,EQ,NULL=>)",false});
		
		list.add(new Object[] {")(99,GE),EVEN(",false});
		list.add(new Object[] {"()99,GE(,ONLY(",false});
		list.add(new Object[] {"((99,GE),(5,GT),EVEN",false});
		list.add(new Object[] {"(99,GE),(5,GT),EVEN)",false});
		list.add(new Object[] {"((99,GE),(5,GT),EVEN",false});
		list.add(new Object[] {"99,GE),(0,EQ),EVEN)",false});
		list.add(new Object[] {"99,GE),(0,EQ),EVEN)",false});
		list.add(new Object[] {"))99,GE(,)0,EQ(,EVEN(",false});
		list.add(new Object[] {"99,GE,0,EQ,EVEN",false});
		
		
		list.add(new Object[] {"((99,GE),(0,EQ),(0,EQ),(0,EQ),(0,EQ),EVEN)",true});
		list.add(new Object[] {"((99,GE),(0,EQ),(0,EQ),(0,EQ),ONLY)",true});
		list.add(new Object[] {"((99,GE),(0,EQ),(0,EQ),(0,EQ),(0,EQ),(0,EQ),(0,EQ),(0,EQ),(5,GT),ONLY)",true});
		
		list.add(new Object[] {"(99,EQ,STEP0001)",true});
		list.add(new Object[] {"(99,EQ,SRWPXXXXXX)",false});


		list.add(new Object[] {"((99,EQ,STEP0001),ONLY)",true});

		list.add(new Object[] {"(99,EQ,STEP01,XXXX)",false});
		list.add(new Object[] {"((99,EQ,STEP01,XXXX))",false});
		
		list.add(new Object[] {"(99,EQ,STEP0001),ONLY)",false});
		
		list.add(new Object[] {"((99,EQ,STEP0001),(5,GT,STEP0001),EVEN)",true});
		list.add(new Object[] {"((99,EQ,STEP0001),(5,LT,STEP0001),ONLY)",true});
		
		list.add(new Object[] {"((99,EQ,STEP0001),(5,GT,STEP0001),(5,GT,STEP0001),EVEN)",true});
		list.add(new Object[] {"((99,EQ,STEP0001),(5,LT,STEP0001),(5,GT,STEP0001),(5,GT,STEP0001),ONLY)",true});
		
		list.add(new Object[] {"((99,EQ,STEP0001),(5,GT,STEP0001),(5,GT,STEP0001))",true});
		list.add(new Object[] {"((99,EQ,STEP0001),(5,LT,STEP0001),(5,GT,STEP0001),(5,GT,STEP0001))",true});
		
		list.add(new Object[] {"((99,EQ,STEP0001),(5,GT,STEP0001),(5,GT,STEP0001),LOL)",false});
		list.add(new Object[] {"((99,EQ,STEP0001),(5,LT,STEP0001),(5,GT,STEP0001),(5,GT,STEP0001),XD)", false});
		
		list.add(new Object[] {"(99,EQ,STEP0001),(5,GT,STEP0001),(5,GT,STEP0001),LOL)",false});
		list.add(new Object[] {"((99,EQ,STEP0001),(5,LT,STEP0001),(5,GT,STEP0001),(5,GT,STEP0001),XD", false});
		
		list.add(new Object[] {"(99,EQ,STEP0001),(5,GT,STEP0001),(5,GT,STEP0001),)",false});
		list.add(new Object[] {"((99,EQ,STEP0001),(5,LT,STEP0001),(5,GT,STEP0001),(5,GT,STEP0001)", false});
		
		list.add(new Object[] {"((99,EQ,0x1344),(5,GT,STEP0001),(5,GT,STEP0001))",false});
		list.add(new Object[] {"((99,EQ,),(5,LT,STEP0001),(5,GT,STEP0001),(5,GT,STEP0001))",false});
		
		list.add(new Object[] {"((,EQ,0x1344),(5,GT,STEP0001),(5,GT,STEP0001))",false});
		list.add(new Object[] {"(,EQ,),(5,LT,STEP0001),(5,GT,STEP0001),)",false});

		list.add(new Object[] {"((5,NE),,(99,GT,STP01))",false});
		list.add(new Object[] {"((99,EQ),(5,LT,STEP0001),(5,GT,STEP0001),())",false});
		list.add(new Object[] {"((5,NE),,,,(99,GT,STP01))",false});
		list.add(new Object[] {"(,,,,(99,GT,STP01))",false});
		list.add(new Object[] {"(,(99,GT,STP01))",false});
		list.add(new Object[] {"(,(99,GT,STP01),,,,)",false});
		list.add(new Object[] {"((99,GT,STP01)))",false});
		list.add(new Object[] {"(((99,GT,STP01)))",false});
		
		list.add(new Object[] {"(100,GT,STP01)",false});
		list.add(new Object[] {"(100,GT,)",false});
		list.add(new Object[] {"(100,GT,0900)",false});
		
		list.add(new Object[] {"(,,,)",false});
		list.add(new Object[] {"(,GT,)",false});
		list.add(new Object[] {"(100,GT,0900)",false});
		
		list.add(new Object[] {"(xx,GT)",false});
		list.add(new Object[] {"(1,zz)",false});
		
		list.add(new Object[] {"(xx,GT)",false});
		list.add(new Object[] {"(1,00)",false});
		
		list.add(new Object[] {"(,)",false});
		list.add(new Object[] {"(-,=)",false});
		list.add(new Object[] {"(1,XX)",false});
		list.add(new Object[] {"(XX,lol)",false});
		return list;
	}
	
	@Test
	public void test_if_condition_validator_works_as_expected() {
		assertSame(GlobalValidator.isCondValid(this.conditon),this.expected);
	}
	
	
}
