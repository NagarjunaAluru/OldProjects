/*
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: RequestDetailsBO.java
 * Purpose: RequestDetailsBO used for the all request operations
 */
package com.ge.aloc.bo;

import java.util.List;

import com.ge.aloc.model.RequestDetails;
import com.ge.aloc.util.AttachmentBOList;

/**
 * @author chaitanya.n
 *
 */
public class RequestDetailsBO extends AbstractModel<RequestDetails> {

	private FormatBO formatBO;
	private List<AttachmentBO> attachmentBOList;
	private BidMemoDetailsBO bidMemoDetailsBO;
	private BidReplyDetailsBO bidReplyDetailsBO;
	private IndicativePricingCompletedDetailsBO indicativePricingCompletedDetailsBO;

	/**
	 * This is a constructor for Request Details bo
	 * @param requestDetails
	 */
	public RequestDetailsBO(RequestDetails requestDetails) {
		super(requestDetails);
	}

	/**
	 * This is method is used to get the format bo
	 * @return FormatBO
	 */
	public FormatBO getFormatBO() {
		if(getModel().getFormat() == null) {
			return null;
		}

		if(formatBO == null || formatBO.getModel() != getModel().getFormat()) {
			formatBO = new FormatBO(getModel().getFormat());
		}
		return formatBO;
	}

	/**
	 * This method is used to set the format bo
	 * @param formatBO
	 */
	public void setFormatBO(FormatBO formatBO) {
		this.formatBO = formatBO;
		getModel().setFormat(formatBO.getModel());
	}
	
	/**
	 * This method is used to get the Attachment bo list
	 * @return
	 */
	public List<AttachmentBO> getAttachmentBOList() { 
		if(attachmentBOList == null || ((AttachmentBOList) attachmentBOList).getAttachmentList() != getModel().getAttachments()) {
			attachmentBOList = new AttachmentBOList(getModel().getAttachments());
		}
		return attachmentBOList;
	}

	/**
	 * This method is used to get bid memo details Returns the bid memo details bo
	 * 
	 * @return BidMemoDetailsBO
	 */
	public BidMemoDetailsBO getBidMemoDetailsBO() {
		if (bidMemoDetailsBO == null || bidMemoDetailsBO.getModel() != getModel().getBidmemoDetails()) {
			bidMemoDetailsBO = new BidMemoDetailsBO(getModel().getBidmemoDetails());
		}
		return bidMemoDetailsBO;
	}

	/**
	 * This method is used to Set the bid memo details bo
	 * 
	 * @param bidMemoDetailsBO
	 */
	public void setBidMemoDetailsBO(BidMemoDetailsBO bidMemoDetailsBO) {
		this.bidMemoDetailsBO = bidMemoDetailsBO;
		getModel().setBidmemoDetails(bidMemoDetailsBO.getModel());
	}

	/**
	 * This method is used to Return the bid reply details bo
	 * 
	 * @return BidReplyDetailsBO
	 */
	public BidReplyDetailsBO getBidReplyDetailsBO() {
		if (bidReplyDetailsBO == null || bidReplyDetailsBO.getModel() != getModel().getBidReplyDetails()) {
			bidReplyDetailsBO = new BidReplyDetailsBO(getModel().getBidReplyDetails());
		}
		return bidReplyDetailsBO;
	}

	/**
	 * This method is used to Set the bid reply details bo
	 * 
	 * @param bidReplyDetailsBO
	 */
	public void setBidReplyDetailsBO(BidReplyDetailsBO bidReplyDetailsBO) {
		this.bidReplyDetailsBO = bidReplyDetailsBO;
		getModel().setBidReplyDetails(bidReplyDetailsBO.getModel());
	}

	/**
	 * Returns the indicative pricing completed details bo
	 * 
	 * @return IndicativePricingCompletedDetailsBO
	 */
	public IndicativePricingCompletedDetailsBO getIndicativePricingCompletedDetailsBO() {
		if (indicativePricingCompletedDetailsBO == null || indicativePricingCompletedDetailsBO.getModel() != getModel().getIndicativePricingCompletedDetails()) {
			indicativePricingCompletedDetailsBO = new IndicativePricingCompletedDetailsBO(getModel().getIndicativePricingCompletedDetails());
		}
		return indicativePricingCompletedDetailsBO;
	}

	/**
	 * Sets the indicative pricing completed details bo
	 * 
	 * @param bidReplyDetailsBO
	 */
	public void setIndicativePricingCompletedDetailsBO(IndicativePricingCompletedDetailsBO indicativePricingCompletedDetailsBO) {
		this.indicativePricingCompletedDetailsBO = indicativePricingCompletedDetailsBO;
		getModel().setIndicativePricingCompletedDetails(indicativePricingCompletedDetailsBO.getModel());
	}

}
