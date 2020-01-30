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
public class RxBLoadJobExecutorQ {

	private static final ConcurrentLinkedQueue<Map<String,Boolean>> JOB_EXECUTOR_Q = new ConcurrentLinkedQueue<Map<String,Boolean>>();

	public static void addToQ (Map<String,Boolean> eofFile)
	{
		JOB_EXECUTOR_Q.add(eofFile);
	}

	public static void addAllToQ (List<Map<String,Boolean>> eofFileNameList)
	{
		JOB_EXECUTOR_Q.addAll(eofFileNameList);
	}

	public static Map<String,Boolean> getFromQ()
	{
		return JOB_EXECUTOR_Q.poll();
	}

	public static int getQSize()
	{
		return JOB_EXECUTOR_Q.size();
	}

	public static boolean isQEmpty()
	{
		return JOB_EXECUTOR_Q.isEmpty();
	}
	
	public static Object[] getArray()
	{
		return JOB_EXECUTOR_Q.toArray() ;
	}
	
	public static boolean removeAll(Object[] objects)
	{
		boolean flag=false;
		for (Object obj : objects) {
			JOB_EXECUTOR_Q.remove(obj);
			flag=true;
		}
		return flag;
	}

}
