package com.optumrx.rxb.dataloader.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

/**
 * 
 * @author Aluru.Nagarjuna
 *
 */
public class ExceptionUtil {
	private static final ExceptionUtil stackTrace = new ExceptionUtil();

	private ExceptionUtil() {
	}

	public static ExceptionUtil getInstance() {
		return stackTrace;
	}

	public static String getStackTrace(Throwable e) {
		final Writer result = new StringWriter();
		final PrintWriter printWriter = new PrintWriter(result);
		e.printStackTrace(printWriter);
		return result.toString();
	}

}
