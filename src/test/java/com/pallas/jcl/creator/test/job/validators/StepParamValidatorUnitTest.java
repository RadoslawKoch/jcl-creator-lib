package com.pallas.jcl.creator.test.job.validators;

import static org.junit.Assert.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.pallas.jcl.creator.job.steps.params.StepParamName;
import com.pallas.jcl.creator.job.steps.params.StepParamValidator;

@RunWith(Parameterized.class)
public class StepParamValidatorUnitTest {

	
	private StepParamName name;
	private String value;
	private boolean expected;
	
	public StepParamValidatorUnitTest(StepParamName name,String value, boolean expected) {
		this.name = name;
		this.value = value;
		this.expected = expected;
	}
	
	@Parameters
	public static List<Object[]> getlist(){
		List<Object[]> list = new ArrayList<>();
		list.add(new Object[] {StepParamName.COND,"(0,NE)",true});
		list.add(new Object[] {StepParamName.COND,"(0,EQ)",true});
		list.add(new Object[] {StepParamName.COND,"(0,GT)",true});
		list.add(new Object[] {StepParamName.COND,"(0,LT)",true});
		list.add(new Object[] {StepParamName.COND,"(0,LE)",true});
		list.add(new Object[] {StepParamName.COND,"(0,GE)",true});
		
		list.add(new Object[] {StepParamName.COND,"(99,NE)",true});
		list.add(new Object[] {StepParamName.COND,"(99,EQ)",true});
		list.add(new Object[] {StepParamName.COND,"(99,GT)",true});
		list.add(new Object[] {StepParamName.COND,"(99,LT)",true});
		list.add(new Object[] {StepParamName.COND,"(99,LE)",true});
		list.add(new Object[] {StepParamName.COND,"(99,GE)",true});
		
		list.add(new Object[] {StepParamName.COND,"(05,NE)",true});
		list.add(new Object[] {StepParamName.COND,"(05,EQ)",true});
		list.add(new Object[] {StepParamName.COND,"(05,GT)",true});
		list.add(new Object[] {StepParamName.COND,"(05,LT)",true});
		list.add(new Object[] {StepParamName.COND,"(05,LE)",true});
		list.add(new Object[] {StepParamName.COND,"(05,GE)",true});
		
		list.add(new Object[] {StepParamName.COND,"(5,NE)",true});
		list.add(new Object[] {StepParamName.COND,"(5,EQ)",true});
		list.add(new Object[] {StepParamName.COND,"(5,GT)",true});
		list.add(new Object[] {StepParamName.COND,"(5,LT)",true});
		list.add(new Object[] {StepParamName.COND,"(5,LE)",true});
		list.add(new Object[] {StepParamName.COND,"(5,GE)",true});
		
		list.add(new Object[] {StepParamName.COND,"((5,NE),(5,NE))",true});
		list.add(new Object[] {StepParamName.COND,"((5,EQ),(5,NE))",true});
		list.add(new Object[] {StepParamName.COND,"((5,GT),(5,NE))",true});
		list.add(new Object[] {StepParamName.COND,"((5,LT),(5,NE))",true});
		list.add(new Object[] {StepParamName.COND,"((5,LE),(5,NE))",true});
		list.add(new Object[] {StepParamName.COND,"((5,GE),(5,NE))",true});
		
		list.add(new Object[] {StepParamName.COND,"((99,NE),(5,NE))",true});
		list.add(new Object[] {StepParamName.COND,"((99,EQ),(5,NE))",true});
		list.add(new Object[] {StepParamName.COND,"((99,GT),(5,NE))",true});
		list.add(new Object[] {StepParamName.COND,"((99,LT),(5,NE))",true});
		list.add(new Object[] {StepParamName.COND,"((99,LE),(5,NE))",true});
		list.add(new Object[] {StepParamName.COND,"((99,GE),(5,NE))",true});
		
		
		list.add(new Object[] {StepParamName.COND,"((99,NE),(5,NE),(5,NE))",true});
		list.add(new Object[] {StepParamName.COND,"((99,EQ),(5,NE),(5,NE),(5,NE))",true});
		list.add(new Object[] {StepParamName.COND,"((99,GT),(5,NE),(5,NE),(5,NE),(5,NE))",true});
		list.add(new Object[] {StepParamName.COND,"((99,LT),(5,NE),(5,NE),(5,NE),(5,NE),(5,NE),(5,NE))",true});
		list.add(new Object[] {StepParamName.COND,"((99,LE),(5,NE),(5,NE),(5,NE),(5,NE),(5,NE),(5,NE),(5,NE))",true});
		list.add(new Object[] {StepParamName.COND,"((99,GE),(5,NE),(5,NE),(5,NE),(5,NE),(5,NE),(5,NE),(5,NE),(5,NE),(5,NE))",true});
		
		
		
		
		list.add(new Object[] {StepParamName.COND,"(5,NE),(5,NE)",false});
		list.add(new Object[] {StepParamName.COND,"(5,EQ),(5,NE)",false});
		list.add(new Object[] {StepParamName.COND,"(5,GT),(5,NE)",false});
		list.add(new Object[] {StepParamName.COND,"(5,LT),(5,NE)",false});
		list.add(new Object[] {StepParamName.COND,"(5,LE),(5,NE)",false});
		list.add(new Object[] {StepParamName.COND,"(5,GE),(5,NE)",false});

		list.add(new Object[] {StepParamName.COND,"(5,NE),(5,NE))",false});
		list.add(new Object[] {StepParamName.COND,"(5,EQ),(5,NE))",false});
		list.add(new Object[] {StepParamName.COND,"(5,GT),(5,NE))",false});
		list.add(new Object[] {StepParamName.COND,"(5,LT),(5,NE))",false});
		list.add(new Object[] {StepParamName.COND,"(5,LE),(5,NE))",false});
		list.add(new Object[] {StepParamName.COND,"(5,GE),(5,NE))",false});
		
		list.add(new Object[] {StepParamName.COND,"(5,NE,(5,NE))",false});
		list.add(new Object[] {StepParamName.COND,"5,EQ),(5,NE)))",false});
		list.add(new Object[] {StepParamName.COND,"(((5,GT),(5,NE))",false});
		list.add(new Object[] {StepParamName.COND,"(5,LT),(5,NE",false});
		list.add(new Object[] {StepParamName.COND,"(5,LE),5,NE",false});
		list.add(new Object[] {StepParamName.COND,"5,GE,5,NE",false});
		
		list.add(new Object[] {StepParamName.COND,"(5,NE,(5,NE))",false});
		list.add(new Object[] {StepParamName.COND,"5,EQ),(5,NE)))",false});
		list.add(new Object[] {StepParamName.COND,"(((5,GT),(5,NE))",false});
		list.add(new Object[] {StepParamName.COND,"(5,LT),(5,NE",false});
		list.add(new Object[] {StepParamName.COND,"(5,LE),5,NE",false});
		list.add(new Object[] {StepParamName.COND,"5,GE,5,NE",false});
		
		list.add(new Object[] {StepParamName.COND,"((99,NE))",true});//A VOIR
		list.add(new Object[] {StepParamName.COND,"((99,EQ))",true});//A VOIR
		list.add(new Object[] {StepParamName.COND,"((99,GT))",true});//A VOIR
		list.add(new Object[] {StepParamName.COND,"((99,LT))",true});//A VOIR
		list.add(new Object[] {StepParamName.COND,"((99,LE))",true});//A VOIR
		list.add(new Object[] {StepParamName.COND,"((99,GE))",true});//A VOIR
		
		list.add(new Object[] {StepParamName.COND,"99,NE",false});
		list.add(new Object[] {StepParamName.COND,"99,EQ",false});
		list.add(new Object[] {StepParamName.COND,"99,GT",false});
		list.add(new Object[] {StepParamName.COND,"99,LT",false});
		list.add(new Object[] {StepParamName.COND,"99,LE",false});
		list.add(new Object[] {StepParamName.COND,"99,GE",false});
		
		list.add(new Object[] {StepParamName.COND,"NE",false});
		list.add(new Object[] {StepParamName.COND,"997",false});
		list.add(new Object[] {StepParamName.COND,"GT",false});
		list.add(new Object[] {StepParamName.COND,"9",false});
		list.add(new Object[] {StepParamName.COND,"LE",false});
		list.add(new Object[] {StepParamName.COND,"959",false});
		
		list.add(new Object[] {StepParamName.COND,"()",false});
		list.add(new Object[] {StepParamName.COND,"(,)",false});
		list.add(new Object[] {StepParamName.COND,"((,),(,),(,))",false});
		list.add(new Object[] {StepParamName.COND,"xxxxxx",false});
		list.add(new Object[] {StepParamName.COND,"Bonjour",false});
		list.add(new Object[] {StepParamName.COND,"valid",false});
		
		list.add(new Object[] {StepParamName.COND,"",false});
		list.add(new Object[] {StepParamName.COND," ",false});
		list.add(new Object[] {StepParamName.COND,"xd",false});
		list.add(new Object[] {StepParamName.COND,"X134403",false});
		list.add(new Object[] {StepParamName.COND,"why",false});
		list.add(new Object[] {StepParamName.COND,"02w9102",false});
		

		list.add(new Object[] {StepParamName.COND,",,,,,,",false});
		list.add(new Object[] {StepParamName.COND,"......",false});
		list.add(new Object[] {StepParamName.COND,"//////",false});
		list.add(new Object[] {StepParamName.COND,"((()))",false});
		
		list.add(new Object[] {StepParamName.COND,"((99,GE),EVEN)",true});
		list.add(new Object[] {StepParamName.COND,"((99,GE),ONLY)",true});
		list.add(new Object[] {StepParamName.COND,"((99,GE),(5,GT),EVEN)",true});
		list.add(new Object[] {StepParamName.COND,"((99,GE),(0,EQ),EVEN)",true});
		list.add(new Object[] {StepParamName.COND,"((99,GE),(0,EQ),(0,EQ),(0,EQ),(0,EQ),EVEN)",true});
		list.add(new Object[] {StepParamName.COND,"((99,GE),(0,EQ),(0,EQ),(0,EQ),ONLY)",true});
		list.add(new Object[] {StepParamName.COND,"((99,GE),(0,EQ),(0,EQ),(0,EQ),(0,EQ),(0,EQ),(0,EQ),(0,EQ),(5,GT),ONLY)",true});
		
		
		list.add(new Object[] {StepParamName.COND,"((99,GE),(0,EQ),NULL)",false});
		list.add(new Object[] {StepParamName.COND,"((99,GE),(0,EQ,LOL)",false});
		list.add(new Object[] {StepParamName.COND,"(99,GE,0,EQ,NULL=>)",false});
		
		list.add(new Object[] {StepParamName.COND,"))99,GE((,(0,EQ),NULL)",false});
		list.add(new Object[] {StepParamName.COND,")(99,GE(,)0,EQ,LOL(",false});
		list.add(new Object[] {StepParamName.COND,"(99,GE,0,EQ,NULL=>)",false});
		
		list.add(new Object[] {StepParamName.COND,")(99,GE),EVEN(",false});
		list.add(new Object[] {StepParamName.COND,"()99,GE(,ONLY(",false});
		list.add(new Object[] {StepParamName.COND,"((99,GE),(5,GT),EVEN",false});
		list.add(new Object[] {StepParamName.COND,"(99,GE),(5,GT),EVEN)",false});
		list.add(new Object[] {StepParamName.COND,"((99,GE),(5,GT),EVEN",false});
		list.add(new Object[] {StepParamName.COND,"99,GE),(0,EQ),EVEN)",false});
		list.add(new Object[] {StepParamName.COND,"99,GE),(0,EQ),EVEN)",false});
		list.add(new Object[] {StepParamName.COND,"))99,GE(,)0,EQ(,EVEN(",false});
		list.add(new Object[] {StepParamName.COND,"99,GE,0,EQ,EVEN",false});
		
		
		list.add(new Object[] {StepParamName.COND,"((99,GE),(0,EQ),(0,EQ),(0,EQ),(0,EQ),EVEN)",true});
		list.add(new Object[] {StepParamName.COND,"((99,GE),(0,EQ),(0,EQ),(0,EQ),ONLY)",true});
		list.add(new Object[] {StepParamName.COND,"((99,GE),(0,EQ),(0,EQ),(0,EQ),(0,EQ),(0,EQ),(0,EQ),(0,EQ),(5,GT),ONLY)",true});
		
		list.add(new Object[] {StepParamName.COND,"(99,EQ,STEP0001)",true});
		list.add(new Object[] {StepParamName.COND,"(99,EQ,SRWPXXXXXX)",false});


		list.add(new Object[] {StepParamName.COND,"((99,EQ,STEP0001),ONLY)",true});

		list.add(new Object[] {StepParamName.COND,"(99,EQ,STEP01,XXXX)",false});
		list.add(new Object[] {StepParamName.COND,"((99,EQ,STEP01,XXXX))",false});
		
		list.add(new Object[] {StepParamName.COND,"(99,EQ,STEP0001),ONLY)",false});
		
		list.add(new Object[] {StepParamName.COND,"((99,EQ,STEP0001),(5,GT,STEP0001),EVEN)",true});
		list.add(new Object[] {StepParamName.COND,"((99,EQ,STEP0001),(5,LT,STEP0001),ONLY)",true});
		
		list.add(new Object[] {StepParamName.COND,"((99,EQ,STEP0001),(5,GT,STEP0001),(5,GT,STEP0001),EVEN)",true});
		list.add(new Object[] {StepParamName.COND,"((99,EQ,STEP0001),(5,LT,STEP0001),(5,GT,STEP0001),(5,GT,STEP0001),ONLY)",true});
		
		list.add(new Object[] {StepParamName.COND,"((99,EQ,STEP0001),(5,GT,STEP0001),(5,GT,STEP0001))",true});
		list.add(new Object[] {StepParamName.COND,"((99,EQ,STEP0001),(5,LT,STEP0001),(5,GT,STEP0001),(5,GT,STEP0001))",true});
		
		list.add(new Object[] {StepParamName.COND,"((99,EQ,STEP0001),(5,GT,STEP0001),(5,GT,STEP0001),LOL)",false});
		list.add(new Object[] {StepParamName.COND,"((99,EQ,STEP0001),(5,LT,STEP0001),(5,GT,STEP0001),(5,GT,STEP0001),XD)", false});
		
		list.add(new Object[] {StepParamName.COND,"(99,EQ,STEP0001),(5,GT,STEP0001),(5,GT,STEP0001),LOL)",false});
		list.add(new Object[] {StepParamName.COND,"((99,EQ,STEP0001),(5,LT,STEP0001),(5,GT,STEP0001),(5,GT,STEP0001),XD", false});
		
		list.add(new Object[] {StepParamName.COND,"(99,EQ,STEP0001),(5,GT,STEP0001),(5,GT,STEP0001),)",false});
		list.add(new Object[] {StepParamName.COND,"((99,EQ,STEP0001),(5,LT,STEP0001),(5,GT,STEP0001),(5,GT,STEP0001)", false});
		
		list.add(new Object[] {StepParamName.COND,"((99,EQ,0x1344),(5,GT,STEP0001),(5,GT,STEP0001))",false});
		list.add(new Object[] {StepParamName.COND,"((99,EQ,),(5,LT,STEP0001),(5,GT,STEP0001),(5,GT,STEP0001))",false});
		
		list.add(new Object[] {StepParamName.COND,"((,EQ,0x1344),(5,GT,STEP0001),(5,GT,STEP0001))",false});
		list.add(new Object[] {StepParamName.COND,"(,EQ,),(5,LT,STEP0001),(5,GT,STEP0001),)",false});

		list.add(new Object[] {StepParamName.COND,"((5,NE),,(99,GT,STP01))",false});
		list.add(new Object[] {StepParamName.COND,"((99,EQ),(5,LT,STEP0001),(5,GT,STEP0001),())",false});
		list.add(new Object[] {StepParamName.COND,"((5,NE),,,,(99,GT,STP01))",false});
		list.add(new Object[] {StepParamName.COND,"(,,,,(99,GT,STP01))",false});
		list.add(new Object[] {StepParamName.COND,"(,(99,GT,STP01))",false});
		list.add(new Object[] {StepParamName.COND,"(,(99,GT,STP01),,,,)",false});
		list.add(new Object[] {StepParamName.COND,"((99,GT,STP01)))",false});
		list.add(new Object[] {StepParamName.COND,"(((99,GT,STP01)))",false});
		
		list.add(new Object[] {StepParamName.COND,"(100,GT,STP01)",false});
		list.add(new Object[] {StepParamName.COND,"(100,GT,)",false});
		list.add(new Object[] {StepParamName.COND,"(100,GT,0900)",false});
		
		list.add(new Object[] {StepParamName.COND,"(,,,)",false});
		list.add(new Object[] {StepParamName.COND,"(,GT,)",false});
		list.add(new Object[] {StepParamName.COND,"(100,GT,0900)",false});
		
		list.add(new Object[] {StepParamName.COND,"(xx,GT)",false});
		list.add(new Object[] {StepParamName.COND,"(1,zz)",false});
		
		list.add(new Object[] {StepParamName.COND,"(xx,GT)",false});
		list.add(new Object[] {StepParamName.COND,"(1,00)",false});
		
		list.add(new Object[] {StepParamName.COND,"(,)",false});
		list.add(new Object[] {StepParamName.COND,"(-,=)",false});
		list.add(new Object[] {StepParamName.COND,"(1,XX)",false});
		list.add(new Object[] {StepParamName.COND,"(XX,lol)",false});
		
		
		////////////
		list.add(new Object[] {StepParamName.TIME,"NOLIMIT",true});
		list.add(new Object[] {StepParamName.TIME,"MAXIMUM",true});
		list.add(new Object[] {StepParamName.TIME,"1440",true});
		list.add(new Object[] {StepParamName.TIME,"(357912,59)",true});
		list.add(new Object[] {StepParamName.TIME,"(xx,xx)",false});
		list.add(new Object[] {StepParamName.TIME,"(0,0)",true});
		list.add(new Object[] {StepParamName.TIME,"0,0",false});
		list.add(new Object[] {StepParamName.TIME,"357912,59",false});
		list.add(new Object[] {StepParamName.TIME,"(59)",false});
		list.add(new Object[] {StepParamName.TIME,"(0)",false});
		list.add(new Object[] {StepParamName.TIME,"357912",false});
		list.add(new Object[] {StepParamName.TIME,"59",false});
		list.add(new Object[] {StepParamName.TIME,"12:20",false});
		list.add(new Object[] {StepParamName.TIME,"99:99",false});
		list.add(new Object[] {StepParamName.TIME,"12:20",false});
		list.add(new Object[] {StepParamName.TIME,"MAX",false});
		list.add(new Object[] {StepParamName.TIME,"FULL",false});
		list.add(new Object[] {StepParamName.TIME,"X",false});
		list.add(new Object[] {StepParamName.TIME,"62,3",false});
		list.add(new Object[] {StepParamName.TIME,"12h00",false});
		list.add(new Object[] {StepParamName.TIME,"00,00",false});
		list.add(new Object[] {StepParamName.TIME,"9999,999",false});
		list.add(new Object[] {StepParamName.TIME,"(FULLMAX)",false});
		list.add(new Object[] {StepParamName.TIME,"(NOLIMIT)",false});
		list.add(new Object[] {StepParamName.TIME,"(1440)",false});
		list.add(new Object[] {StepParamName.TIME,"(MAXIMUM)",false});
		return list;
	}
	
	@Test
	public void verify_if_step_validator_works_as_expected() {
		StepParamValidator validator = StepParamValidator.getInstance();
			assertSame(validator.isValid(this.name,this.value), this.expected);
	}

}
