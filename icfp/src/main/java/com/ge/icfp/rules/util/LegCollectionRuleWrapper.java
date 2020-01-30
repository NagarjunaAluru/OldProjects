/**
 * 
 */
package com.ge.icfp.rules.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.ge.icfp.action.ICFPException;
import com.ge.icfp.common.helper.ICFPDay2LegHelper;
import com.ge.icfp.common.helper.ICFPLegHelper;
import com.ge.icfp.util.EventType;
import com.ge.icfp.util.ProductType;

/**
 * @author chaitanya
 *
 */
public class LegCollectionRuleWrapper {
	
	private List<Object> allLegs;
	private List<Object> day1Legs;
	private List<Object> day2Legs;
	
	/**
	 * 
	 * @param legs
	 * @throws ICFPException 
	 */
	public LegCollectionRuleWrapper(List<Object> legs) throws ICFPException {
		allLegs = new LinkedList<Object>();
		
		if(legs != null && !legs.isEmpty()) {
			for(Object leg : legs) {
				addLeg(leg);
			}
		}
	}
	
	/**
	 * Returns the all legs.
	 * 
	 * @return
	 */
	public List<Object> getAllLegs() {
		return allLegs;
	}

	/**
	 * Returns only Day1 legs
	 * @return
	 */
	public List<Object> getDay1Legs() {
		return day1Legs;
	}

	/**
	 * Returns only Day2 legs
	 * @return
	 */
	public List<Object> getDay2Legs() {
		return day2Legs;
	}
	
	/**
	 * Returns true; if this collection contains Day1 legs.
	 * 
	 * @return
	 */
	public boolean hasDay1Legs() {
		return (!day1Legs.isEmpty());
	}
	
	/**
	 * Returns true; if this collection contains Day2 legs.
	 * 
	 * @return
	 */
	public boolean hasDay2Legs() {
		return (!day2Legs.isEmpty());
	}
	
	/**
	 * Returns the filtered legs depends on specified {@link ProductType} and {@link EventType}
	 * 
	 * @param productType
	 * @param eventType
	 * @return
	 * @throws ICFPException 
	 */
	public List<Object> searchLegs(final Integer productTypeId, final Integer eventTypeId) throws ICFPException {
		// Replacing with 0 if specified product type and event type are null.
		Integer vProductTypeId = (productTypeId == null) ? 0 : productTypeId;
		Integer vEventTypeId = (eventTypeId == null) ? 0 : eventTypeId;
		
		boolean anyProductType = vProductTypeId.equals(-1);
		boolean anyEventType = vEventTypeId.equals(-1);
		List<Object> filteredLegs = new LinkedList<Object>();
		
		// Return all legs; if search is for any productType and any eventType
		if(anyProductType && anyEventType) {
			filteredLegs.addAll(allLegs);
		}
		
		for(Object leg : allLegs) {
			ProductType legProductType = ICFPLegHelper.getProductType(leg);
			EventType legEventType = ICFPDay2LegHelper.getEventType(leg);
			
			// Replacing with 0 if leg product type and event type are null
			Integer legProductTypeId = (legProductType != null) ? legProductType.getId() : 0;
			Integer legEventTypeId = (legEventType != null) ? legEventType.getId() : 0;
			
			boolean match = false;
			if(anyProductType) {
				match = vEventTypeId.equals(legEventTypeId);
			} else if(anyEventType) {
				match = vProductTypeId.equals(productTypeId);
			} else {
				match = (vProductTypeId.equals(legProductTypeId) && vEventTypeId.equals(legEventTypeId));
			}
			
			if(match) {
				filteredLegs.add(leg);
			}
		}
		return filteredLegs;
	}
	
	/**
	 * Returns event types of the all legs in the same order; if {@link EventType} of leg is null; this function assigns null.
	 * 
	 * @return
	 * @throws ICFPException 
	 */
	public List<EventType> getEventTypesOfAllLegs() throws ICFPException {
		List<EventType> result = new ArrayList<EventType>();
		for(Object leg: allLegs) {
			result.add(ICFPDay2LegHelper.getEventType(leg));
		}
		return result;
	}
	
	/**
	 * Returns the {@link Set} of different event types of legs.
	 * 
	 * @return
	 * @throws ICFPException
	 */
	public Set<EventType> getEventTypes() throws ICFPException {
		Set<EventType> eventTypes = new HashSet<EventType>();
		List<EventType> legEventTypes = getEventTypesOfAllLegs();
		for(EventType eachEventType : legEventTypes) {
			if(eachEventType != null && !eventTypes.contains(eachEventType)) {
				eventTypes.add(eachEventType);
			}
		}
		return eventTypes;
	}
	
	/**
	 * This method returns true; if all the legs has the specivied event type.
	 * 
	 * @param eventType
	 * @param ignoreDay1
	 * @return
	 * @throws ICFPException
	 */
	public boolean hasOnlyEventTypeLegs(EventType eventType, boolean ignoreDay1) throws ICFPException {
		Set<EventType> eventTypes = getEventTypes();
		boolean result = eventTypes.size() == 1 && eventTypes.contains(eventType);
		if(result && !ignoreDay1 && !day1Legs.isEmpty()) {
			result = false;
		}
		return result;
	}
	
	/**
	 * Filters the Day2 leg list based on specified eventTypes
	 * 
	 * @param eventTypes
	 * @return
	 * @throws ICFPException 
	 */
	public List<Object> filterLegs(EventType... eventTypes) throws ICFPException {
		List<Object> legList = new ArrayList<Object>();
		if(!day2Legs.isEmpty() && eventTypes != null && eventTypes.length > 0) {
			List<EventType> eventTypeList = Arrays.asList(eventTypes);
			for(Object leg : day2Legs) {
				EventType eventType = ICFPDay2LegHelper.getEventType(leg);
				if(eventTypeList.contains(eventType)) {
					legList.add(leg);
				}
			}
		}
		return legList;
	}
	
	/**
	 * Adds leg to Day1 collection
	 * 
	 * @param leg
	 */
	protected void addDay1Leg(Object leg) {
		if(day1Legs == null) {
			day1Legs = new LinkedList<Object>();
		}
		day1Legs.add(leg);
	}
	
	/**
	 * Adds leg to Day2 collection
	 * 
	 * @param leg
	 */
	protected void addDay2leg(Object leg) {
		if(day2Legs == null) {
			day2Legs = new LinkedList<Object>();
		}
		day2Legs.add(leg);
	}
	
	/**
	 * Adds the leg to corresponding collection
	 * 
	 * @param leg
	 * @throws ICFPException 
	 */
	public void addLeg(Object leg) throws ICFPException {
		allLegs.add(leg);
		if(ICFPDay2LegHelper.isDay2Leg(leg)) {
			addDay2leg(leg);
		} else {
			addDay1Leg(leg);
		}
	}
}
