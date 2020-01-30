/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: Actions.java
 * Purpose: Actions is a utility class used to pass the appropriate action ID's.
 */
package com.ge.icfp.util;
/**
 * 
 * @author madhusudhan.gosula
 *
 */
public class Actions {
	
	/**
	 * 
	 * @author madhusudhan.gosula
	 *
	 */
	private static enum Action{
		save("save", "1"),
		submit("submit", "2"),
		approve("approve", "3"),
		reject("reject", "4"),
		affirm("affirm", "5"),
		sendBack("sendBack", "6"),
		reAffrim("reAffrim", "7"),
		assignReview("assignReview", "7"),
		approveWithMod("approveWithMod", "8"),
		approveOnBehalfIdagEag("approveOnBehalfIdagEag", "9"),
		rejectOnBehalfIdagEag("rejectOnBehalfIdagEag", "10"),
		sendToTESGApprove("sendToTESGApprove", "11"),
		sendToTESGApproveWithMod("sendToTESGApproveWithMod", "12"),
		sendToTESGApproveOnBehalfIdagEag("sendToTESGApproveOnBehalfIdagEag", "13"),
		sendToEboardroomApprove("sendToeBoardroomApprove", "14"),
		sendToEboardroomApproveWithMod("sendToEboardroomApproveWithMod", "15"),
		sendToEboardroomApproveOnBehalfIdagEag("sendToEboardroomApproveOnBehalfIdagEag", "16"),
		certify("certify", "17"),
		override("override", "18"),
		approveOverride("approveOverride","19"),
		close("close","20"),
		accept("accept", "21"),
		approveOnBehalfTesg("approveOnBehalfTesg", "25"),
		rejectOnBehalfTesg("rejectOnBehalfTesg", "26"),
		sendToTC("sendToTC", "30"),
		sendBackToRiskUnderwriting("sendBackToRiskUnderwriting", "6");
		/**
		 * 
		 */
		private String id;
		/**
		 * 
		 */
		private String name;
		/**
		 * 
		 * @param name
		 * @param id
		 */
		private Action(String name, String id){
			this.name = name;
			this.id = id;
		}
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public static String getID(String name){
		
		for(Action a : Action.values() ){
			
			if(name.equals( a.name ))
				return a.id;
		}
		
		return "";
	}
	
}
