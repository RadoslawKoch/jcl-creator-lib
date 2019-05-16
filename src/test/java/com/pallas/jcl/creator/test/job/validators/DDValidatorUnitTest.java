package com.pallas.jcl.creator.test.job.validators;

import static org.junit.Assert.assertSame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.pallas.jcl.creator.job.steps.dd.params.DDParamName;
import com.pallas.jcl.creator.job.steps.dd.params.DDValidator;

@RunWith(Parameterized.class)
public class DDValidatorUnitTest {

	
	private DDParamName name;
	private String value;
	private boolean expected;
	private static final List<String> recfms = Arrays.asList("D","DA","DB","DBA","DBS","DBSA","DS","DSA","F","FA","FB","FBA","FBM","FBS",
			"FBSA","FBSM","FBT","FBTA","FBTM","FM","FS","FSA","FSM","FT","FTA","FTM","U","UA","UM",
			"UT","UTA","UTM","V","VA", "VB","VBA","VBM","VBS","VBSA","VBSM","VBST","VBSTA","VBSTM", "VBT", 
			"VBTA","VBTM","VM", "VS", "VSA","VSM", "VT", "VTA","VTM");
	
	public DDValidatorUnitTest(DDParamName name, String value, boolean expected) {
		this.name = name;
		this.value = value;
		this.expected = expected;
	}
	
	@Parameters 
	public static List<Object[]> getParams(){
		List<Object[]> params = new ArrayList<>();
		///////DISP PARAM VALIDATION
		params.add(new Object[] {DDParamName.DISP,"SHR",true});
		params.add(new Object[] {DDParamName.DISP,"OLD",true});
		params.add(new Object[] {DDParamName.DISP,"NEW",true});
		params.add(new Object[] {DDParamName.DISP,"MOD",true});
		params.add(new Object[] {DDParamName.DISP,"(NEW,CATLG,CATLG)",true});
		params.add(new Object[] {DDParamName.DISP,"(NEW,DELETE,KEEP)",true});
		params.add(new Object[] {DDParamName.DISP,"(NEW,CATLG,DELETE)",true});
		params.add(new Object[] {DDParamName.DISP,"(NEW,DELETE,KEEP)",true});
		
		params.add(new Object[] {DDParamName.DISP,"(SHR,DELETE)",true});
		params.add(new Object[] {DDParamName.DISP,"(SHR,CATLG)",true});
		params.add(new Object[] {DDParamName.DISP,"(SHR,KEEP)",true});
		params.add(new Object[] {DDParamName.DISP,"(SHR,PASS)",true});
		params.add(new Object[] {DDParamName.DISP,"(SHR,UNCATLG)",true});
		
		params.add(new Object[] {DDParamName.DISP,"(OLD,DELETE)",true});
		params.add(new Object[] {DDParamName.DISP,"(OLD,CATLG)",true});
		params.add(new Object[] {DDParamName.DISP,"(OLD,KEEP)",true});
		params.add(new Object[] {DDParamName.DISP,"(OLD,PASS)",true});
		params.add(new Object[] {DDParamName.DISP,"(OLD,UNCATLG)",true});
		
		params.add(new Object[] {DDParamName.DISP,"(NEW,DELETE)",true});
		params.add(new Object[] {DDParamName.DISP,"(NEW,CATLG)",true});
		params.add(new Object[] {DDParamName.DISP,"(NEW,KEEP)",true});
		params.add(new Object[] {DDParamName.DISP,"(NEW,PASS)",true});
		params.add(new Object[] {DDParamName.DISP,"(NEW,UNCATLG)",true});
		
		params.add(new Object[] {DDParamName.DISP,"(MOD,DELETE)",true});
		params.add(new Object[] {DDParamName.DISP,"(MOD,CATLG)",true});
		params.add(new Object[] {DDParamName.DISP,"(MOD,KEEP)",true});
		params.add(new Object[] {DDParamName.DISP,"(MOD,PASS)",true});
		params.add(new Object[] {DDParamName.DISP,"(MOD,UNCATLG)",true});
		
		params.add(new Object[] {DDParamName.DISP,"(MOD,KEEP,DELETE)",true});
		params.add(new Object[] {DDParamName.DISP,"(MOD,KEEP,CATLG)",true});
		params.add(new Object[] {DDParamName.DISP,"(MOD,KEEP,KEEP)",true});
		params.add(new Object[] {DDParamName.DISP,"(MOD,KEEP,PASS)",true});
		params.add(new Object[] {DDParamName.DISP,"(MOD,KEEP,UNCATLG)",true});
		
		
		params.add(new Object[] {DDParamName.DISP,"(NEW,KEEP,DELETE)",true});
		params.add(new Object[] {DDParamName.DISP,"(NEW,DELETE,CATLG)",true});
		params.add(new Object[] {DDParamName.DISP,"(NEW,CATLG,KEEP)",true});
		params.add(new Object[] {DDParamName.DISP,"(NEW,CATLG,PASS)",true});
		params.add(new Object[] {DDParamName.DISP,"(NEW,CATLG,UNCATLG)",true});
		
		params.add(new Object[] {DDParamName.DISP,"(SHR)",false});
		params.add(new Object[] {DDParamName.DISP,"(OLD)",false});
		params.add(new Object[] {DDParamName.DISP,"(NEW,CATLG,UNCATLG,DELETE)",false});
		params.add(new Object[] {DDParamName.DISP,"(NEW,CATLG,XD)",false});
		params.add(new Object[] {DDParamName.DISP,"(NEW,CATLG,UNCATLG,NEW,CATLG)",false});
		params.add(new Object[] {DDParamName.DISP,"(NEW)",false});
		params.add(new Object[] {DDParamName.DISP,"(MOD)",false});
		
		params.add(new Object[] {DDParamName.DISP,"XD",false});
		params.add(new Object[] {DDParamName.DISP,"LOL",false});
		params.add(new Object[] {DDParamName.DISP,"(cxxcx",false});
		params.add(new Object[] {DDParamName.DISP,"tmp",false});
		
		params.add(new Object[] {DDParamName.DISP,"(NEW,CATLG,CATLG",false});
		params.add(new Object[] {DDParamName.DISP,"NEW,DELETE,KEEP",false});
		params.add(new Object[] {DDParamName.DISP,"(NEW,CATLG,DELETE",false});
		params.add(new Object[] {DDParamName.DISP,"(NEW,DELETE,KEEP",false});
		params.add(new Object[] {DDParamName.DISP,"(,,",false});
		params.add(new Object[] {DDParamName.DISP,",,",false});
		params.add(new Object[] {DDParamName.DISP,"(,,)",false});
		params.add(new Object[] {DDParamName.DISP,"),,(",false});
		params.add(new Object[] {DDParamName.DISP,"(NEW,DELETE,)",false});
		params.add(new Object[] {DDParamName.DISP,"(,,KEEP)",false});
		params.add(new Object[] {DDParamName.DISP,"(00,00,00)",false});
		params.add(new Object[] {DDParamName.DISP,"2999",false});
		params.add(new Object[] {DDParamName.DISP,"2lsdklsadksa",false});
		params.add(new Object[] {DDParamName.DISP,"",false});
		params.add(new Object[] {DDParamName.DISP," ",false});
		params.add(new Object[] {DDParamName.DISP,"=",false});
		
		params.add(new Object[] {DDParamName.DISP,"(TEST,DELETE)",false});
		params.add(new Object[] {DDParamName.DISP,"(MOD,TEST)",false});
		params.add(new Object[] {DDParamName.DISP,"(LOL,000)",false});
		params.add(new Object[] {DDParamName.DISP,"(MOD,NEW)",false});
		params.add(new Object[] {DDParamName.DISP,"(MOD,MOD)",false});
		
		
	///////DSN PARAM VALIDATION
		params.add(new Object[] {DDParamName.DSN,"X135505.T098000.D190602",true});
		params.add(new Object[] {DDParamName.DSN,"X135505.T098000.D190602",true});
		params.add(new Object[] {DDParamName.DSN,"X135505X.T0980000.D1906020.TESTTEST",true});
		params.add(new Object[] {DDParamName.DSN,"X135505X.T0980000.D1906020.XXXXX(X135503XXxx)",false});
		params.add(new Object[] {DDParamName.DSN,"X135505X(X135503)",true});
		params.add(new Object[] {DDParamName.DSN,"X135505X.X1234567.X1234567.X1234567(X135503X)",true});
		params.add(new Object[] {DDParamName.DSN,"X135505X.X1234567.X1234567(X135503X)",true});
		params.add(new Object[] {DDParamName.DSN,"X135.T09.D19",true});
		params.add(new Object[] {DDParamName.DSN,"X135",true});
		params.add(new Object[] {DDParamName.DSN,"X135503.D1234567",true});
		params.add(new Object[] {DDParamName.DSN,"X135503.D1234567.D1234567",true});
		params.add(new Object[] {DDParamName.DSN,"X135503.D1234567.D1234567.D1234567",true});
		params.add(new Object[] {DDParamName.DSN,"X135505XX",false});
		params.add(new Object[] {DDParamName.DSN,"X135505X.T098000XXXXX.D190602",false});
		params.add(new Object[] {DDParamName.DSN,"00000000",false});
		params.add(new Object[] {DDParamName.DSN,"0xxxxx.T098000XXXXX.D190602",false});
		params.add(new Object[] {DDParamName.DSN,"X135505X...",false});
		params.add(new Object[] {DDParamName.DSN,"....",false});
		params.add(new Object[] {DDParamName.DSN,"X1344.XX..X",false});
		params.add(new Object[] {DDParamName.DSN,",,,,",false});
		params.add(new Object[] {DDParamName.DSN,"x13550x,lol,txt,xd",false});
		params.add(new Object[] {DDParamName.DSN,"X135505X.X1234567.X1234567.ZZZZZZ(X135503Xzzz)",false});
		params.add(new Object[] {DDParamName.DSN,"X135505X.X1234567.X1234567.ZZZZZZ.XXXX(X135503X)",false});
		params.add(new Object[] {DDParamName.DSN,"X135505X.X1234567..X1234567.ZZZZZZ(X135503X)",false});
		params.add(new Object[] {DDParamName.DSN,"X135505X.X1234567. .ZZZZZZ(X135503X)",false});
		params.add(new Object[] {DDParamName.DSN,"X135505X.X1234567.ZZZZZZ(X135 03X)",false});
		
		///////DSN PARAM VALIDATION
		params.add(new Object[] {DDParamName.DUMMY,"DUMMY",true});
		
		//////////////////////////////////////
		params.add(new Object[] {DDParamName.LRECL,"0",true});/////VERIFIED
		params.add(new Object[] {DDParamName.LRECL,"",false});
		params.add(new Object[] {DDParamName.LRECL,"-200",false});
		params.add(new Object[] {DDParamName.LRECL,"32761",true});
		params.add(new Object[] {DDParamName.LRECL,"12",true});
		params.add(new Object[] {DDParamName.LRECL,"327",true});
		params.add(new Object[] {DDParamName.LRECL,"(32761)",false});
		params.add(new Object[] {DDParamName.LRECL,"(0)",false});
		params.add(new Object[] {DDParamName.LRECL,"xxxx",false});
		params.add(new Object[] {DDParamName.LRECL,"z",false});
		params.add(new Object[] {DDParamName.LRECL,"xxxx",false});
		params.add(new Object[] {DDParamName.LRECL,"666666",false});
		params.add(new Object[] {DDParamName.LRECL,"-1",false});
		params.add(new Object[] {DDParamName.LRECL,"----",false});
		params.add(new Object[] {DDParamName.LRECL,"000000012",false});
		///////////////////////
		
		for(String x : recfms) {
			params.add(new Object[] {DDParamName.RECFM,x,true});
		}
		params.add(new Object[] {DDParamName.RECFM,"",false});
		params.add(new Object[] {DDParamName.RECFM," ",false});
		params.add(new Object[] {DDParamName.RECFM," X",false});
		params.add(new Object[] {DDParamName.RECFM,"TEST",false});
		params.add(new Object[] {DDParamName.RECFM,"01",false});
		params.add(new Object[] {DDParamName.RECFM,"Z1",false});
		
		///////////////////////16777219
		params.add(new Object[] {DDParamName.SPACE,"(CYL,(-1,-2))",false});
		params.add(new Object[] {DDParamName.SPACE,"(CYL,(16777219,16777219))",false});
		params.add(new Object[] {DDParamName.SPACE,"(CYL,(2,16777219))",false});
		params.add(new Object[] {DDParamName.SPACE,"(CYL,(16777219,1))",false});
		params.add(new Object[] {DDParamName.SPACE,"(CYL,(16777219,1))",false});
		params.add(new Object[] {DDParamName.SPACE,"(CYL,(1,1))",true});
		params.add(new Object[] {DDParamName.SPACE,"(CYL,(1,0))",true});
		params.add(new Object[] {DDParamName.SPACE,"(CYL,(1,0),RLSE)",true});
		params.add(new Object[] {DDParamName.SPACE,"(TRK,(1,0),RLSE)",true});
		params.add(new Object[] {DDParamName.SPACE,"(TRK,(1,0),)",false});
		params.add(new Object[] {DDParamName.SPACE,"(,(1,0),)",false});		
		params.add(new Object[] {DDParamName.SPACE,"(CYL,1)",false});
		
		params.add(new Object[] {DDParamName.SPACE,"(CYL,(1,2)",false});
		
		params.add(new Object[] {DDParamName.SPACE,"(CYL,(z,z))",false});
		params.add(new Object[] {DDParamName.SPACE,"(x,(20,1))",false});
		params.add(new Object[] {DDParamName.SPACE,"(TRK,(20,1),test)",false});
		params.add(new Object[] {DDParamName.SPACE,"xxxxxxx",false});
		params.add(new Object[] {DDParamName.SPACE,"0122102",false});
		
		////////////////////////
		params.add(new Object[] {DDParamName.VOLSER,"0",true});
		params.add(new Object[] {DDParamName.VOLSER,"00000000000000000",false});
		params.add(new Object[] {DDParamName.VOLSER,"",false});
		params.add(new Object[] {DDParamName.VOLSER,"999999",true});
		params.add(new Object[] {DDParamName.VOLSER,"-10",false});
		params.add(new Object[] {DDParamName.VOLSER,"9999999",false});
		params.add(new Object[] {DDParamName.VOLSER,"-10",false});
		params.add(new Object[] {DDParamName.VOLSER,"x",false});
		params.add(new Object[] {DDParamName.VOLSER,"zzzz",false});
		params.add(new Object[] {DDParamName.VOLSER,"0xcx",false});
		params.add(new Object[] {DDParamName.VOLSER,"zzzz",false});
		params.add(new Object[] {DDParamName.VOLSER,"0xcx",false});
		params.add(new Object[] {DDParamName.VOLSER,"-=-=",false});
		

		return params;
	}
	
	@Test
	public void test_if_DD_Validator_works_as_expected() {
		assertSame(DDValidator.getValidator().isValid(name, value),expected);
	}
}
