package com.pallas.jcl.creator.test.job.validators;

import static org.junit.Assert.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.pallas.jcl.creator.job.card.params.KeywordParamName;
import com.pallas.jcl.creator.job.card.params.KeywordValidator;


@RunWith(Parameterized.class)
public class CardValidatorUnitTest {

	private KeywordParamName name;
	private String value;
	private boolean expected;
	
	public CardValidatorUnitTest(KeywordParamName name, String value, boolean expected) {
		this.name = name;
		this.value = value;
		this.expected = expected;
	}
	
	@Parameters
	public static List<Object[]> getParams(){
		List<Object[]> params = new ArrayList<>();
		////////TESTING CLASS KEYWORD PARAM
		params.add(new Object[] {KeywordParamName.CLASS,"A",true});
		params.add(new Object[] {KeywordParamName.CLASS,"C",true});
		params.add(new Object[] {KeywordParamName.CLASS,"Z",true});
		params.add(new Object[] {KeywordParamName.CLASS,"X",true});
		params.add(new Object[] {KeywordParamName.CLASS,"00000",false});
		params.add(new Object[] {KeywordParamName.CLASS,"--",false});
		params.add(new Object[] {KeywordParamName.CLASS,"0",false});
		params.add(new Object[] {KeywordParamName.CLASS,"9",false});
		params.add(new Object[] {KeywordParamName.CLASS,"00",false});
		params.add(new Object[] {KeywordParamName.CLASS,"99",false});
		params.add(new Object[] {KeywordParamName.CLASS,"=",false});
		params.add(new Object[] {KeywordParamName.CLASS,".",false});
		params.add(new Object[] {KeywordParamName.CLASS,",",false});
		params.add(new Object[] {KeywordParamName.CLASS,"]",false});
		params.add(new Object[] {KeywordParamName.CLASS,"ZT",false});
		params.add(new Object[] {KeywordParamName.CLASS,"99999",false});
		params.add(new Object[] {KeywordParamName.CLASS,"X1",false});
		params.add(new Object[] {KeywordParamName.CLASS,"",false});
		////////TESTING LINES KEYWORD PARAM
		params.add(new Object[] {KeywordParamName.LINES,"0",true});
		params.add(new Object[] {KeywordParamName.LINES,"999999",true});
		params.add(new Object[] {KeywordParamName.LINES,"00001",true});
		params.add(new Object[] {KeywordParamName.LINES,"55",true});
		params.add(new Object[] {KeywordParamName.LINES,"A",false});
		params.add(new Object[] {KeywordParamName.LINES,"AAAAA",false});
		params.add(new Object[] {KeywordParamName.LINES,"===",false});
		params.add(new Object[] {KeywordParamName.LINES,"9999999",false});
		params.add(new Object[] {KeywordParamName.LINES,"]",false});
		params.add(new Object[] {KeywordParamName.LINES,"\\",false});
		params.add(new Object[] {KeywordParamName.LINES,"tmp",false});
		params.add(new Object[] {KeywordParamName.LINES,"]",false});
		params.add(new Object[] {KeywordParamName.LINES,"\\",false});
		params.add(new Object[] {KeywordParamName.LINES," ",false});
		params.add(new Object[] {KeywordParamName.LINES,"",false});
		///////////////TESTING MSGCLASS KEYWORD PARAM
		params.add(new Object[] {KeywordParamName.MSGCLASS,"0",false});
		params.add(new Object[] {KeywordParamName.MSGCLASS,"A",true});
		params.add(new Object[] {KeywordParamName.MSGCLASS,"C",true});
		params.add(new Object[] {KeywordParamName.MSGCLASS,"Z",true});
		params.add(new Object[] {KeywordParamName.MSGCLASS,"X",true});
		params.add(new Object[] {KeywordParamName.MSGCLASS,"00000",false});
		params.add(new Object[] {KeywordParamName.MSGCLASS,"--",false});
		params.add(new Object[] {KeywordParamName.MSGCLASS,"0",false});
		params.add(new Object[] {KeywordParamName.MSGCLASS,"9",false});
		params.add(new Object[] {KeywordParamName.MSGCLASS,"00",false});
		params.add(new Object[] {KeywordParamName.MSGCLASS,"99",false});
		params.add(new Object[] {KeywordParamName.MSGCLASS,"=",false});
		params.add(new Object[] {KeywordParamName.MSGCLASS,".",false});
		params.add(new Object[] {KeywordParamName.MSGCLASS,",",false});
		params.add(new Object[] {KeywordParamName.MSGCLASS,"]",false});
		params.add(new Object[] {KeywordParamName.MSGCLASS,"ZT",false});
		params.add(new Object[] {KeywordParamName.MSGCLASS,"99999",false});
		params.add(new Object[] {KeywordParamName.MSGCLASS,"X1",false});
		params.add(new Object[] {KeywordParamName.MSGCLASS,"",false});
		//////////TESTING MSGLEVEL KEYWORD PARAM
		params.add(new Object[] {KeywordParamName.MSGLEVEL,"0",true});
		params.add(new Object[] {KeywordParamName.MSGLEVEL,"1",true});
		params.add(new Object[] {KeywordParamName.MSGLEVEL,"2",true});
		params.add(new Object[] {KeywordParamName.MSGLEVEL,"(0,0)",true});
		params.add(new Object[] {KeywordParamName.MSGLEVEL,"(1,0)",true});
		params.add(new Object[] {KeywordParamName.MSGLEVEL,"(2,0)",true});
		params.add(new Object[] {KeywordParamName.MSGLEVEL,"(0,1)",true});
		params.add(new Object[] {KeywordParamName.MSGLEVEL,"(1,1)",true});
		params.add(new Object[] {KeywordParamName.MSGLEVEL,"(2,1)",true});	
		params.add(new Object[] {KeywordParamName.MSGLEVEL,"2,1",false});	
		params.add(new Object[] {KeywordParamName.MSGLEVEL,"2,1)",false});
		params.add(new Object[] {KeywordParamName.MSGLEVEL,"(2,1",false});
		params.add(new Object[] {KeywordParamName.MSGLEVEL,"(2)",false});
		params.add(new Object[] {KeywordParamName.MSGLEVEL,"(1)",false});
		params.add(new Object[] {KeywordParamName.MSGLEVEL,"(0)",false});
		params.add(new Object[] {KeywordParamName.MSGLEVEL,")0(",false});
		params.add(new Object[] {KeywordParamName.MSGLEVEL,")0,0(",false});
		params.add(new Object[] {KeywordParamName.MSGLEVEL,")1,1(",false});
		params.add(new Object[] {KeywordParamName.MSGLEVEL,")x,x(",false});
		params.add(new Object[] {KeywordParamName.MSGLEVEL,"x",false});
		params.add(new Object[] {KeywordParamName.MSGLEVEL,"z",false});
		params.add(new Object[] {KeywordParamName.MSGLEVEL,"(x,x)",false});
		params.add(new Object[] {KeywordParamName.MSGLEVEL,"(x,x",false});
		params.add(new Object[] {KeywordParamName.MSGLEVEL,"x,x)",false});
		//////////TESTING NOTIFY KEYWORD PARAM
		params.add(new Object[] {KeywordParamName.NOTIFY,"&SYSUID",true});
		params.add(new Object[] {KeywordParamName.NOTIFY,"X135503",true});
		params.add(new Object[] {KeywordParamName.NOTIFY,"A123560",true});
		params.add(new Object[] {KeywordParamName.NOTIFY,"ZZZZ",true});
		params.add(new Object[] {KeywordParamName.NOTIFY,"TEST",true});
		params.add(new Object[] {KeywordParamName.NOTIFY,"X1",true});
		params.add(new Object[] {KeywordParamName.NOTIFY,"X1",true});
		params.add(new Object[] {KeywordParamName.NOTIFY,"01",false});
		params.add(new Object[] {KeywordParamName.NOTIFY,"0",false});
		params.add(new Object[] {KeywordParamName.NOTIFY,"1234567",false});
		params.add(new Object[] {KeywordParamName.NOTIFY,"X135503X",false});
		params.add(new Object[] {KeywordParamName.NOTIFY,"XXXXXXXXXX",false});
		params.add(new Object[] {KeywordParamName.NOTIFY,"-----",false});
		params.add(new Object[] {KeywordParamName.NOTIFY,"\\=[=[=",false});
		params.add(new Object[] {KeywordParamName.NOTIFY,"ksaldksaldkdlsa",false});
		params.add(new Object[] {KeywordParamName.NOTIFY,"",false});
		params.add(new Object[] {KeywordParamName.NOTIFY,"  ",false});
		params.add(new Object[] {KeywordParamName.NOTIFY," ",false});
		params.add(new Object[] {KeywordParamName.NOTIFY,"x",false});
		//////////TESTING REGION KEYWORD PARAM
		params.add(new Object[] {KeywordParamName.REGION,"0K",true});
		params.add(new Object[] {KeywordParamName.REGION,"0M",true});
		params.add(new Object[] {KeywordParamName.REGION,"1K",true});//2047
		params.add(new Object[] {KeywordParamName.REGION,"1M",true});//2096128
		params.add(new Object[] {KeywordParamName.REGION,"2047M",true});
		params.add(new Object[] {KeywordParamName.REGION,"2096128K",true});
		params.add(new Object[] {KeywordParamName.REGION,"20M",true});
		params.add(new Object[] {KeywordParamName.REGION,"209K",true});
		params.add(new Object[] {KeywordParamName.REGION,"20",false});
		params.add(new Object[] {KeywordParamName.REGION,"209",false});
		params.add(new Object[] {KeywordParamName.REGION,"M20",false});
		params.add(new Object[] {KeywordParamName.REGION,"K209",false});
		params.add(new Object[] {KeywordParamName.REGION,"2XXXX",false});
		params.add(new Object[] {KeywordParamName.REGION,"ZZ2",false});
		params.add(new Object[] {KeywordParamName.REGION,"azy",false});
		params.add(new Object[] {KeywordParamName.REGION,"=0",false});
		params.add(new Object[] {KeywordParamName.REGION,"2047X",false});
		params.add(new Object[] {KeywordParamName.REGION,"2096128J",false});
		params.add(new Object[] {KeywordParamName.REGION,"20471M",false});
		params.add(new Object[] {KeywordParamName.REGION,"20961289K",false});
		params.add(new Object[] {KeywordParamName.REGION,"-2M",false});
		params.add(new Object[] {KeywordParamName.REGION,"-5K",false});
		params.add(new Object[] {KeywordParamName.REGION,"",false});
		params.add(new Object[] {KeywordParamName.REGION," ",false});
		//////////TESTING TYPERUN KEYWORD PARAM
		params.add(new Object[] {KeywordParamName.TYPERUN,"HOLD",true});
		params.add(new Object[] {KeywordParamName.TYPERUN,"SCAN",true});	
		params.add(new Object[] {KeywordParamName.TYPERUN,"COPY",true});	
		params.add(new Object[] {KeywordParamName.TYPERUN,"JCLHOLD",true});	
		params.add(new Object[] {KeywordParamName.TYPERUN,"hold",true});
		params.add(new Object[] {KeywordParamName.TYPERUN,"scan",true});	
		params.add(new Object[] {KeywordParamName.TYPERUN,"copy",true});	
		params.add(new Object[] {KeywordParamName.TYPERUN,"jclhold",true});	
		params.add(new Object[] {KeywordParamName.TYPERUN,"",false});
		params.add(new Object[] {KeywordParamName.TYPERUN," ",false});
		params.add(new Object[] {KeywordParamName.TYPERUN,"0",false});
		params.add(new Object[] {KeywordParamName.TYPERUN,"9",false});
		params.add(new Object[] {KeywordParamName.TYPERUN,"0zzzz",false});
		params.add(new Object[] {KeywordParamName.TYPERUN,"0909s0d9s090",false});
		params.add(new Object[] {KeywordParamName.TYPERUN,"0",false});
		//////////TESTING USER KEYWORD PARAM
		params.add(new Object[] {KeywordParamName.USER,"X135503",true});
		params.add(new Object[] {KeywordParamName.USER,"A123560",true});
		params.add(new Object[] {KeywordParamName.USER,"ZZZZ",true});
		params.add(new Object[] {KeywordParamName.USER,"TEST",true});
		params.add(new Object[] {KeywordParamName.USER,"X1",true});
		params.add(new Object[] {KeywordParamName.USER,"X1",true});
		params.add(new Object[] {KeywordParamName.USER,"01",false});
		params.add(new Object[] {KeywordParamName.USER,"0",false});
		params.add(new Object[] {KeywordParamName.USER,"1234567",false});
		params.add(new Object[] {KeywordParamName.USER,"X135503X",false});
		params.add(new Object[] {KeywordParamName.USER,"XXXXXXXXXX",false});
		params.add(new Object[] {KeywordParamName.USER,"-----",false});
		params.add(new Object[] {KeywordParamName.USER,"\\=[=[=",false});
		params.add(new Object[] {KeywordParamName.USER,"ksaldksaldkdlsa",false});
		params.add(new Object[] {KeywordParamName.USER,"",false});
		params.add(new Object[] {KeywordParamName.USER,"  ",false});
		params.add(new Object[] {KeywordParamName.USER," ",false});
		params.add(new Object[] {KeywordParamName.USER,"x",false});
		//////////END TESTING PARAMS
		return params;
	}
	
	@Test
	public void verify_if_card_validation_works_as_expected() {
		assertSame(KeywordValidator.getValidator().isValid(this.name,this.value),expected);
	}


}
