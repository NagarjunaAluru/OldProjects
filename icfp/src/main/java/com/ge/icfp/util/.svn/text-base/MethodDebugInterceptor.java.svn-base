/**
 * 
 */
package com.ge.icfp.util;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;

/**
 * This class intercepts all the method invocation and add log statement on its 
 * Entry and exist of it.
 * 
 * @author chaitanya
 *
 */
public class MethodDebugInterceptor implements MethodInterceptor {
	public static final String METHOD_SEPERATOR = "#";
	private static final String BEGIN_BRACE = "(";
	private static final String END_BRACE = ")";
	private static final String PARAMETER_TYPE_SEPERATOR = " : ";
	private static final String PARAMETER_SEPERATOR = ", ";
	private static final String RETURN_TYPE_SEPERATOR = " ";
	/**
	 * 
	 * @param parameterTypes
	 * @param parameterValues
	 */
	public static void appendParameters(StringBuffer buffer, Class<?>[] parameterTypes, Object[] parameterValues, boolean logValues) {
		int paramCount = parameterTypes.length;
		for(int i = 0; i<paramCount; i++) {
			if(logValues) {
				buffer.append(parameterValues[i]).append(PARAMETER_TYPE_SEPERATOR);
			}
			buffer.append(parameterTypes[i].getName());
			if(i < paramCount - 1) {
				buffer.append(PARAMETER_SEPERATOR);
			}
		}
	}
	
	/**
	 * 
	 * Returns method description
	 * @param thisObject
	 * @param method
	 * @param parameterValues
	 * @param logValues
	 * @return
	 */
	public static String getMethodDescription(Class<?> thisObject, Method method, Object[] parameterValues, boolean logValues) {
		StringBuffer buffer = new StringBuffer().append(thisObject.getName()).append(METHOD_SEPERATOR)
		.append(method.getName()).append(BEGIN_BRACE);
		Class<?>[] parameterTypes = method.getParameterTypes();
		appendParameters(buffer, parameterTypes, parameterValues, logValues);
		buffer.append(END_BRACE);
		return buffer.toString();
	}
	
	private boolean logParameters = true;
	
	/**
	 * Invoke the method
	 */
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		Logger logger = Logger.getLogger(methodInvocation.getThis().getClass());
		boolean loggerEnabled = logger.isDebugEnabled();
		if(loggerEnabled) {
			enterLog(logger, methodInvocation);
		}
		Object returnValue = methodInvocation.proceed();
		
		if(loggerEnabled) {
			exitLog(logger, methodInvocation, returnValue);
		}
		return returnValue;
	}
	
	/**
	 * Add the log statement for the given method name on its entry and exit 
	 * 
	 * @param logger
	 * @param methodInvocation
	 */
	private void enterLog(Logger logger, MethodInvocation methodInvocation) {
		String methodDescription = getMethodDescription(methodInvocation.getThis().getClass(),
				methodInvocation.getMethod(), methodInvocation.getArguments(), logParameters);
		StringBuffer enteringMsg = new StringBuffer().append("Entering ").append(methodDescription);
		if(methodInvocation.getMethod().getReturnType() != null) {
			enteringMsg.append(RETURN_TYPE_SEPERATOR).append(methodInvocation.getMethod().getReturnType().getName());
		}
				
		logger.debug(enteringMsg.toString());
	}

	/**
	 * 
	 * @param logger
	 * @param methodInvocation
	 * @param returnValue
	 */
	private void exitLog(Logger logger, MethodInvocation methodInvocation, Object returnValue) {
		String methodDescription = getMethodDescription(methodInvocation.getThis().getClass(),
				methodInvocation.getMethod(), methodInvocation.getArguments(), logParameters);
		StringBuffer exitingMsg = new StringBuffer().append("Exiting ").append(methodDescription);
		if(methodInvocation.getMethod().getReturnType() != null) {
			exitingMsg.append(RETURN_TYPE_SEPERATOR).append(returnValue).append(PARAMETER_TYPE_SEPERATOR)
			.append(methodInvocation.getMethod().getReturnType().getName());
		}
		logger.debug(exitingMsg.toString());
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean isLogParameters() {
		return logParameters;
	}

	/**
	 * 
	 * @param logParameters
	 */
	public void setLogParameters(boolean logParameters) {
		this.logParameters = logParameters;
	}
}
