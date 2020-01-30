/**
 * 
 */
package com.optumrx.rxb.dataloader.orchestration.component;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;


/**
 * 
 * @author Aluru.Nagarjuna
 *
 */
public class RxBLoadReportExecutorQ {

	private static final ConcurrentLinkedQueue<Map<Integer,String>> REPORT_EXECUTOR_Q = new ConcurrentLinkedQueue<Map<Integer,String>>();

	public static void addToQ (Map<Integer,String> eofFile)
	{
		REPORT_EXECUTOR_Q.add(eofFile);
	}

	public static void addAllToQ (List<Map<Integer,String>> eofFileNameList)
	{
		REPORT_EXECUTOR_Q.addAll(eofFileNameList);
	}

	public static Map<Integer,String> getFromQ()
	{
		return REPORT_EXECUTOR_Q.poll();
	}

	public static int getQSize()
	{
		return REPORT_EXECUTOR_Q.size();
	}

	public static boolean isQEmpty()
	{
		return REPORT_EXECUTOR_Q.isEmpty();
	}
	
	public static Object[] getArray()
	{
		return REPORT_EXECUTOR_Q.toArray() ;
	}
	
	public static boolean removeAll(Object[] objects)
	{
		boolean flag=false;
		for (Object obj : objects) {
			REPORT_EXECUTOR_Q.remove(obj);
			flag=true;
		}
		return flag;
	}

}
