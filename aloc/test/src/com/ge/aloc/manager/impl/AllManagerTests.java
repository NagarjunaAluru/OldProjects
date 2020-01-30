package com.ge.aloc.manager.impl;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ALOCAttachmentManagerTest.class, CreateBundleManagerTest.class, LinkTransactionManagerTest.class,
		LookupManagerTest.class, ReferenceDataManagerTest.class,
		RequestDetailsManagerTest.class,
		RequestDetailsSectionManagerTest.class, SearchManagerTest.class,
		SiteDetailsManagerTest.class })
public class AllManagerTests {

}
