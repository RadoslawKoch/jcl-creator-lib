package com.pallas.jcl.creator.test.job.general;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.pallas.jcl.creator.job.general.GlobalSettings;

public class GlobalSettingsUnitTest {

	@Test
	public void create_new_GlobalSettings_class_instance() {
		assertTrue(new GlobalSettings()!=null);
	}
}
