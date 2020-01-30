package com.ge.aloc.bo;

import java.text.DateFormat;

import com.ge.aloc.model.BidReplyDetails;

/**
 * This class provides the business functionalities related to BidReplyDetails
 * model
 * 
 * @author ramakrishna.vadla
 */
public class BidReplyDetailsBO extends AbstractModel<BidReplyDetails> {

	private TimeBO bidExpirationTime;

	/**
	 * Constructor takes the model as the argument
	 * 
	 * @param model
	 */
	protected BidReplyDetailsBO(BidReplyDetails model) {
		super(model);
	}

	/**
	 * Default constructor
	 */
	public BidReplyDetailsBO() {
		super(new BidReplyDetails());
	}

	/**
	 * Returns the time in h:mm a format from the date
	 * 
	 * @return
	 */
	public String getPricingExpirationTime() {
		String time = DateFormat.getTimeInstance(DateFormat.SHORT).format(getModel().getPricingExpirationDate().getTime());
		return time;
	}

	/**
	 * Get the bid expiration time bo
	 * 
	 * @return
	 */
	public TimeBO getBidExpirationTime() {
		if(bidExpirationTime==null){
			bidExpirationTime = new TimeBO(getModel().getBidExpirationDate());
		}
		return bidExpirationTime;
	}


}
