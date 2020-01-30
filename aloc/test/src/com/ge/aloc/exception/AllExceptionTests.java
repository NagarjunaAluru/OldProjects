package com.ge.aloc.exception;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ALOCAttachmentExceptionTest.class, ALOCExceptionTest.class,
		ALOCRuntimeExceptionTest.class, NoActiveRequestExceptionTest.class })
public class AllExceptionTests {

}
