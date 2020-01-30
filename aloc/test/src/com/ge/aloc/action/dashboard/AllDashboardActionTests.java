package com.ge.aloc.action.dashboard;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ BidProcessDashboardActionTest.class,
		BundleDashboardActionTest.class, DashboardBaseActionTest.class,
		DashboardRefDataActionTest.class })
public class AllDashboardActionTests {

}
