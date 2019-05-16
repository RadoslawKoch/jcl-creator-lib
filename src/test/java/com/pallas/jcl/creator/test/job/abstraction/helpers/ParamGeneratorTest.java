package com.pallas.jcl.creator.test.job.abstraction.helpers;

import java.util.List;

import com.pallas.jcl.creator.datamodel.abstraction.ParamGenerator;

public class ParamGeneratorTest extends ParamGenerator<ParameterTest>{

	public String testFormat(int counter, List<ParameterTest> list) {
		return this.getParam(counter, list);
	}
}
