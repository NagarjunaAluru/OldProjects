package com.ge.aloc.bo;

import java.text.DateFormat;

import com.ge.aloc.model.BidmemoDetails;


/**
 * This class provides the business functionalities related to BidmemoDetails
 * model
 * 
 * @author ramakrishna.vadla
 */
public class BidMemoDetailsBO extends AbstractModel<BidmemoDetails> {

	private TimeBO bidExpirationTime;

	/**
	 * Constructor with model argument
	 * 
	 * @param model
	 */
	protected BidMemoDetailsBO(BidmemoDetails model) {
		super(model);
	}

	/**
	 * Default constructor
	 */
	public BidMemoDetailsBO() {
		super(new BidmemoDetails());
	}

	/**
	 * Returns the time in h:mm a format from the date
	 * 
	 * @return
	 */
	public String getExpirationTime()
	{
		String time = DateFormat.getTimeInstance(DateFormat.SHORT).format(getModel().getExpirationDateTime().getTime());
		return time;
	}

	/**
	 * Get the bid expiration time bo
	 * 
	 * @return
	 */
	public TimeBO getBidExpirationTime() {
		if(bidExpirationTime==null){
			bidExpirationTime = new TimeBO(getModel().getExpirationDateTime());
		}
		return bidExpirationTime;
	}



}
