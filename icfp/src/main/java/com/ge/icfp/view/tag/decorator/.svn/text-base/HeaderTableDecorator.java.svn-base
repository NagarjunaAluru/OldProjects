/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: HeaderTableDecorator.java
 * Purpose: HeaderTableDecorator used to provide feasibility to open the deal while clicking on Request ID and Status.
 */
package com.ge.icfp.view.tag.decorator;

import org.displaytag.decorator.TableDecorator;

import com.ge.icfp.pipeline.form.PipelineDetails;
/**
 * @author arijit.biswas
 *
 */
public class HeaderTableDecorator extends TableDecorator {
	/**
	 * Get RequestID
	 * @return requestID
	 */
	public String getRequestID(){
		PipelineDetails pipelineDetails = (PipelineDetails) getCurrentRowObject();
		String requestID = "<a href='javascript:void(0);' onclick='javascript:openTransaction("+pipelineDetails.getRequestID()+");'>"+pipelineDetails.getRequestID()+"</a>";
		return requestID;
		
	}
	/**
	 * Get Status
	 * @return status
	 */
	public String getStatus(){
		PipelineDetails pipelineDetails = (PipelineDetails) getCurrentRowObject();
		String status = pipelineDetails.getStatus()+"% <a href=\"#\" class=\"chart ttip\" title=\"View chart\"></a>";
		return status;
	}
	
}