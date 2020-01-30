package com.ge.aloc.util;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ALOCCommonHelperTest.class, AttachmentBOListTest.class,
		DelegationConfigBOListTest.class, JSONHelperTest.class,
		SiteAdminHelperTest.class })
public class AllUtilTests {

}
