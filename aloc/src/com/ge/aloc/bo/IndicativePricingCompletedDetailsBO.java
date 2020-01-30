package com.ge.aloc.bo;

import com.ge.aloc.model.IndicativePricingCompletedDetails;


/**
 * This class provides the business functionalities related to time model
 * 
 * @author ramakrishna.vadla
 */
public class IndicativePricingCompletedDetailsBO extends AbstractModel<IndicativePricingCompletedDetails>{

	private TimeBO pricingExpirationTime;

	/**
	 * Constructor takes the model as the argument
	 * 
	 * @param model
	 */
	protected IndicativePricingCompletedDetailsBO(IndicativePricingCompletedDetails model) {
		super(model);
	}

	/**
	 * Default constructor
	 */
	public IndicativePricingCompletedDetailsBO() {
		super(new IndicativePricingCompletedDetails());
	}

	/**
	 * Get the pricing expiration time bo
	 * 
	 * @return
	 */
	public TimeBO getPricingExpirationTime() {
		if(pricingExpirationTime==null){
			pricingExpirationTime = new TimeBO(getModel().getPricingExpirationDateTime());
		}
		return pricingExpirationTime;
	}
}
