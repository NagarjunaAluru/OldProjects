package com.ge.aloc.action;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CreateBundleActionTest.class, LinkTransactionActionTest.class,
		ReferenceDataActionTest.class })
public class AllActionTests {

}
