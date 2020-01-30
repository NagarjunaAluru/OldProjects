/**
 * 
 */
package com.optumrx.rxb.dataloader.orchestration.component;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 
 * @author Aluru.Nagarjuna
 *
 */
public class RxBLoadJobCreatorQ {

	private static final ConcurrentLinkedQueue<String> JOB_CREATOR_Q = new ConcurrentLinkedQueue<String>();

	public static void addToQ (String eofFileName)
	{
		JOB_CREATOR_Q.add(eofFileName);
	}

	public static void addAllToQ (List<String> eofFileNameList)
	{
		JOB_CREATOR_Q.addAll(eofFileNameList);
	}

	public static String getFromQ()
	{
		return JOB_CREATOR_Q.poll();
	}

	public static int getQSize()
	{
		return JOB_CREATOR_Q.size();
	}

	public static boolean isQEmpty()
	{
		return JOB_CREATOR_Q.isEmpty();
	}
}
