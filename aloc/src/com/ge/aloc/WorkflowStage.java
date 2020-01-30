/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: WorkflowStage.java
 * Purpose: WorkflowStage used for the all workflow constants.
 */
package com.ge.aloc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * @author chaitanya.n
 *
 */
public enum WorkflowStage {
	DRAFT(0, "Draft"),
	REQUESTER(1,"Requestor"),
	BUSINESSAPPROVER(2,"BUSAPROV"),
	BNDWAIT1(3,"BNDWAIT1"),
	BNDWAIT3(5,"BNDWAIT3"),
	TREASURYANALYST(4,"ANLAPROV"),
	TREASURYAPPROVER(6,"TREAPROV"),
	BNDWAIT4(7,"BNDWAIT4"),
	TREASURYBIDMEMO(8,"BIDMEMO"),
	TREASURYBIDREPLY(9,"BIDREPLY"),
	TREASURYBIDISSUE(10,"BIDISSUE"),
	BIDCMPLT(11,"BIDCMPLT"),
	TRESEDIT(12,"TRESEDIT"),
	NEWMEMO(13,"NEWMEMO"),
	BANKISUE(14,"BANKISUE"),
	COMPLETE(15,"COMPLETE"),
	EVLREPLY(16,"EVLREPLY"),
	REREQUEST(17,"REQEST"),
	REQUEST(18,"REQUEST");

	@SuppressWarnings("serial")
	public static final Collection<WorkflowStage> REQUESTOR_STAGES = Collections.unmodifiableList(new ArrayList<WorkflowStage>() {
		{
			add(DRAFT);
			add(REQUESTER);
			add(BUSINESSAPPROVER);
			add(BNDWAIT1);
			add(BNDWAIT3);
			add(TREASURYANALYST);
			add(TREASURYAPPROVER);
			add(BNDWAIT4);
			add(TREASURYBIDMEMO);
			add(TREASURYBIDREPLY);
			add(TREASURYBIDISSUE);
			add(BIDCMPLT);
			add(TRESEDIT);
			add(NEWMEMO);
			add(BANKISUE);
			add(COMPLETE);
			add(EVLREPLY);
			add(REREQUEST);
			add(REQUEST);
		}
	});


	/**
	 * This method is used to get the workflow stage based on id.
	 * @param id
	 * @return
	 */
	public static WorkflowStage fromId(int id) {
		for(WorkflowStage workflowStage : values()) {
			if(workflowStage.id == id) {
				return workflowStage;
			}
		}
		return null;
	}

	/**
	 * This method returns workflow stage based on name.
	 * 
	 * @param name
	 * @return
	 */
	public static WorkflowStage fromName(String name) {
		for(WorkflowStage workflowStage : values()) {
			if(workflowStage.getName().equalsIgnoreCase(name)) {
				return workflowStage;
			}
		}
		return null;
	}
	/**
	 * 
	 */
	private int id;
	/**
	 * 
	 */
	private String name;
	/**
	 * constructor to create instance object.
	 * @param id
	 * @param name
	 */
	private WorkflowStage(int id, String name) {
		this.id = id;
		this.name = name;
	}

	/**
	 * This is used to get id attribute
	 * getId
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * This is used to get name attribute
	 * getName
	 * @return the name
	 */
	public String getName() {
		return name;
	}

}
