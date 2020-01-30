package com.ge.aloc.dao.impl;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CreateBundleDAOTest.class,LinkTransactionDAOTest.class, 
		LookupDAOTest.class,
		ReferenceDataDAOTest.class, RequestDetailsDAOTest.class,
		RequestDetailsSectionDAOTest.class, SearchDAOTest.class,
		SiteDetailsDAOTest.class })
public class AllDAOTests {

}
