/**
 * Copyright © 2012-2013 GE. ALL RIGHTS RESERVED.
 * FileName: TemplateBO.java
 * Purpose: TemplateBO used to manage configured Adhoc report fields.
 */
package com.ge.aloc.reports.adhoc;

import java.math.BigInteger;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import com.ge.aloc.InstrumentType;
import com.ge.aloc.constants.ALOCConstants;
import com.ge.aloc.model.Column;
import com.ge.aloc.model.Filter;
import com.ge.aloc.model.Template;
import com.ge.aloc.model.Template.SelectedBanks;
import com.ge.aloc.model.Template.SelectedSites;
import com.ge.aloc.util.ReportsHelper;

/**
 * @author chaitanya.n
 *
 */
public class TemplateBO {
	
	private String dateFilter;
	private String fromDate;
	private String toDate;
	private String templateName;
	private BigInteger templateId;
	private String description;
	private boolean bank;
	private boolean bussiness;
	private boolean treasury;
	private List<String> selectedSites;
	private List<String> selectedBanks;
	
	private Map<String, FilterBO> filters;
	private Map<String, ColumnBO> columns;
	
	private String[] filterIds;
	private String[] columnIds;
	private InstrumentType[] instrumentTypes;

	/**
	 * This constructor will be used by frameworks like Struts2
	 * to create object of this class
	 */
	public TemplateBO() {
	}
	
	/**
	 * This constructor helps to create object of this class from model {@link Template}
	 * 
	 * @param template
	 * @throws ParseException 
	 */
	public TemplateBO(Template template) throws ParseException {
		
		this.templateId = template.getTemplateID();
		this.templateName = template.getTemplateName();
		this.description = template.getDescription();
		this.bank = template.isBank();
		this.bussiness = template.isBussiness();
		this.treasury = template.isTreasury();
		
		List<String> selBankList = new ArrayList<String>();
		for (SelectedBanks selectedBanks : template.getSelectedBanks()) {
			selBankList.add(selectedBanks.getBankMDMID().toString());
		}
		this.selectedBanks = selBankList;
		
		List<String> selSiteList = new ArrayList<String>();
		for (SelectedSites selectedSites : template.getSelectedSites()) {
			selSiteList.add(selectedSites.getSiteID().toString());
		}
		this.selectedSites = selSiteList;
		
		if(CollectionUtils.isEmpty(this.filters)){
			this.filters = new LinkedHashMap<String, FilterBO>();
		}
		for (Filter filter : template.getFilters()) {
			if(filter.getUserColumnKey().equals(ALOCConstants.CREATED_DATE)){
				this.dateFilter = filter.getUserColumnKey();
				this.fromDate = DataType.DATE.displayTimestampFormat(filter.getValue1());
				this.toDate = DataType.DATE.displayTimestampFormat(filter.getValue2());
			}
			else if(filter.getUserColumnKey().equals(ALOCConstants.INSTRUMENT_ID)){
				if(StringUtils.isNotBlank(filter.getValue1())){
					String instrumentId[] = filter.getValue1().split(ALOCConstants.COMMA);
					int i=ALOCConstants.BASE_VALUE;
					this.instrumentTypes =  new InstrumentType[instrumentId.length];
					for(String instrId : instrumentId) {
						instrumentTypes[i++] = InstrumentType.fromId(Integer.parseInt(instrId));
					}
				}
				
			}
			else{
					FilterBO filterBO = new FilterBO();
					filterBO.setFieldId(filter.getUserColumnKey());
					filterBO.setCondition(filter.getCondition());
					Operator operator = (filter.getOperator() != null) ? Operator.fromSymbol(filter.getOperator()) : null;
					filterBO.setOperatorType(operator);
					
					List<String> filterValues = new ArrayList<String>();
				if(filter.getDataType().equals(DataType.DATE.value())){
					if(filter.getValue1() != null){
					filterValues.add(DataType.DATE.displayFormat(filter.getValue1()));
					}
					if(filter.getValue2() != null){
						filterValues.add(DataType.DATE.displayFormat(filter.getValue2()));
					}
				}
				else if(operator == Operator.LIKE){
					String value = filter.getValue1();
					if(StringUtils.isNotBlank(value)) {
						if(value.startsWith(ALOCConstants.PERCENTAGE)) {
							value = value.substring(ALOCConstants.MIN_VALUE);
							}
							
							if(value.endsWith(ALOCConstants.PERCENTAGE)) {
							value = value.substring(ALOCConstants.BASE_VALUE, value.length() - ALOCConstants.MIN_VALUE);
						}
							
							filterValues.add(value);
						}
					}
					else{
						filterValues.add(filter.getValue1());
						filterValues.add(filter.getValue2());
					}
					
					filterBO.setValue(filterValues);
					this.filters.put(filter.getUserColumnKey(), filterBO);
				}
			
				
		}
		if(CollectionUtils.isEmpty(this.columns)){
			this.columns = new LinkedHashMap<String, ColumnBO>();
		}
		for (Column column : template.getColumns()) {
			ColumnBO columnBO = new ColumnBO();
			columnBO.setFieldId(column.getUserColumnKey());
			columnBO.setSortOrder(column.getSortOrder());
			columnBO.setSortPriority(column.getSortPriority() != null ? Integer.valueOf(column.getSortPriority().toString()) : null);
			this.columns.put(column.getUserColumnKey(), columnBO);
		}
		
	}
	
	
	/**
	 * @return the dateFilter
	 */
	public String getDateFilter() {
		return dateFilter;
	}

	/**
	 * @param dateFilter the dateFilter to set
	 */
	public void setDateFilter(String dateFilter) {
		this.dateFilter = dateFilter;
	}

	/**
	 * @return the fromDate
	 */
	public String getFromDate() {
		return fromDate;
	}

	/**
	 * @return the toDate
	 */
	public String getToDate() {
		return toDate;
	}

	/**
	 * @return the criterions
	 */
	public Map<String, FilterBO> getFilters() {
		if(filters == null) {
			filters = new LinkedHashMap<String, FilterBO>();
		}
		return filters;
	}
	
	/**
	 * Method to get Filters
	 * @param fieldId
	 * @return
	 */
	public FilterBO getFilters(String fieldId) {
		return getFilters().get(fieldId);
	}
	
	/**
	 * Method to set Filters
	 * @param key
	 * @param criterion
	 */
	public void setFilters(String fieldId, FilterBO filter) {
		filter.setFieldId(fieldId);
		getFilters().put(fieldId, filter);
	}

	/**
	 * @param fromDate the fromDate to set
	 */
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	/**
	 * @param toDate the toDate to set
	 */
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	/**
	 * @return the columns
	 */
	public Map<String, ColumnBO> getColumns() {
		if(columns == null) {
			columns = new LinkedHashMap<String, ColumnBO>();
		}
		return columns;
	}
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	public ColumnBO getColumns(String fieldId) {
		return getColumns().get(fieldId);
	}
	
	/**
	 * 
	 * @param key
	 * @param criterion
	 */
	public void setColumns(String fieldId, ColumnBO column) {
		column.setFieldId(fieldId);
		getColumns().put(fieldId, column);
	}

	/**
	 * @return the templateName
	 */
	public String getTemplateName() {
		return templateName;
	}

	/**
	 * @param templateName the templateName to set
	 */
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	/**
	 * @return the bank
	 */
	public boolean isBank() {
		return bank;
	}

	/**
	 * @param bank the bank to set
	 */
	public void setBank(Boolean bank) {
		this.bank = bank;
	}

	/**
	 * @return the bussiness
	 */
	public boolean isBussiness() {
		return bussiness;
	}

	/**
	 * @param bussiness the bussiness to set
	 */
	public void setBussiness(Boolean bussiness) {
		this.bussiness = bussiness;
	}

	/**
	 * @return the treasury
	 */
	public boolean isTreasury() {
		return treasury;
	}

	/**
	 * @param treasury the treasury to set
	 */
	public void setTreasury(Boolean treasury) {
		this.treasury = treasury;
	}

	/**
	 * @return the selectedSites
	 */
	public List<String> getSelectedSites() {
		return selectedSites;
	}

	/**
	 * @param selectedSites the selectedSites to set
	 */
	public void setSelectedSites(List<String> selectedSites) {
		this.selectedSites = selectedSites;
	}

	/**
	 * @return the selectedBanks
	 */
	public List<String> getSelectedBanks() {
		return selectedBanks;
	}

	/**
	 * @param selectedBanks the selectedBanks to set
	 */
	public void setSelectedBanks(List<String> selectedBanks) {
		this.selectedBanks = selectedBanks;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * Create {@link Template} model object to communicate with DB.
	 * 
	 * @return
	 */
	public Template getTemplate() throws ParseException{
		// Make sure that filters and columns are in user order
		sortFiltersAndColumns();
		// Set Date and Instrument Filters
		setFilters(getDateFilter(), ReportsHelper.setDateFilterValues(this));
		if(instrumentTypes != null){
			if(instrumentTypes.length < ALOCConstants.NUM_INSTRTYPE_SIX){
				setFilters(ALOCConstants.INSTRUMENT_ID, ReportsHelper.getInstrumentFilter(instrumentTypes));
			}
		}
		Template template = fillTemplate();
		List<Filter> filterList = new ArrayList<Filter>();
		for (Map.Entry<String, FilterBO> entry : filters.entrySet()) {
			Filter filter = new Filter();
			filter.setUserColumnKey(entry.getValue().getFieldId());
			filter.setCondition(entry.getValue().getCondition());
			Operator operator = entry.getValue().getOperatorType();
			filter.setOperator((operator != null) ? operator.symbol() : null);
			if(entry.getValue().getDataType() == DataType.DATE){
				filter.setValue1(DataType.DATE.storageFormat(entry.getValue().getValue().get(ALOCConstants.BASE_VALUE)));
			}
			else if(operator == Operator.LIKE){
				String value = (!entry.getValue().getValue().isEmpty()) ? entry.getValue().getValue().get(ALOCConstants.BASE_VALUE) : null;
				StringBuffer sb = new StringBuffer();
				if(StringUtils.isNotBlank(value)){
					value = value.replaceAll(ALOCConstants.PERCENTAGE,ALOCConstants.EMPTY_STRING);
					if(StringUtils.isNotBlank(value)) {
						sb.append(ALOCConstants.PERCENTAGE).append(value).append(ALOCConstants.PERCENTAGE);
					}
					else{
						sb.append(ALOCConstants.PERCENTAGE);
					}
				}
				filter.setValue1(sb.toString());
			}
			else{
				filter.setValue1(entry.getValue().getValue().get(ALOCConstants.BASE_VALUE));
			}
			if(entry.getValue().getValue().size()>ALOCConstants.MIN_VALUE){
				if(entry.getValue().getDataType() == DataType.DATE){
					filter.setValue2(entry.getValue().getValue().get(ALOCConstants.MIN_VALUE) != null ? DataType.DATE.storageFormat(entry.getValue().getValue().get(ALOCConstants.MIN_VALUE)) : null);
				}
				else{
					filter.setValue2(entry.getValue().getValue().get(ALOCConstants.MIN_VALUE) != null ? entry.getValue().getValue().get(ALOCConstants.MIN_VALUE) : null);
				}
			}
			filterList.add(filter);
		}
		template.setFilters(filterList);
		template.setColumns(fetchColumnsList());
		
		if(selectedBanks != null){
			template.setSelectedBanks(fetchSelectedBanks());
		}
		if(selectedSites != null){
			template.setSelectedSites(fetchSelectedSites());
		}
		return template;
	}
	
	/**
	 * fetchColumnsList is used get the column list.
	 * @return columnList
	 */
	private List<Column> fetchColumnsList() {
		List<Column> columnList = new ArrayList<Column>();
		for (Map.Entry<String, ColumnBO> entry : columns.entrySet()) {
			Column column = new Column();
			column.setUserColumnKey(entry.getValue().getFieldId());
			column.setSortOrder(entry.getValue().getSortOrder());
			column.setSortPriority(entry.getValue().getSortPriority() != null? BigInteger.valueOf(entry.getValue().getSortPriority()) : null);
			columnList.add(column);
		}
		return columnList;
		
		
	}

	/**
	 * fillTemplate is used to fill the Template.
	 * @return template
	 */
	private Template fillTemplate() {
		Template template = new Template();
		template.setBank(this.bank);
		template.setBussiness(this.bussiness);
		template.setTreasury(this.treasury);
		template.setDescription(this.description);
		template.setTemplateName(this.templateName);
		template.setTemplateID(this.templateId);
		return template;
	}

	/**
	 * fetchSelectedBanks is used to retrieve selected banks 
	 * @return
	 */
	private List<Template.SelectedBanks> fetchSelectedBanks() {
		List<Template.SelectedBanks> banks = new ArrayList<Template.SelectedBanks>();
		Iterator<String> itr = selectedBanks.iterator();
		while(itr.hasNext()){
			SelectedBanks selected = new SelectedBanks();
			selected.setBankMDMID(BigInteger.valueOf(Long.parseLong(itr.next())));
			banks.add(selected);
		}
		return banks;
	}

	/**
	 * fetchSelectedSites is used to retrieve selected sites 
	 * @return
	 */
	private List<Template.SelectedSites> fetchSelectedSites() {
		List<Template.SelectedSites> sites = new ArrayList<Template.SelectedSites>();
		Iterator<String> itr = selectedSites.iterator();
		while(itr.hasNext()){
			SelectedSites selected = new SelectedSites();
			selected.setSiteID(BigInteger.valueOf(Long.parseLong(itr.next())));
			sites.add(selected);
		}
		return sites;
		
	}

	/**
	 * @return the templateId
	 */
	public BigInteger getTemplateId() {
		return templateId;
	}

	/**
	 * @param templateId the templateId to set
	 */
	public void setTemplateId(BigInteger templateId) {
		this.templateId = templateId;
	}
	
	/**
	 * @return the filterIds
	 */
	public String[] getFilterIds() {
		return filterIds;
	}
	/**
	 * @param filterIds the filterIds to set
	 */
	public void setFilterIds(String[] filterIds) {
		this.filterIds = filterIds;
	}
	/**
	 * @return the columnIds
	 */
	public String[] getColumnIds() {
		return columnIds;
	}
	/**
	 * @param columnIds the columnIds to set
	 */
	public void setColumnIds(String[] columnIds) {
		this.columnIds = columnIds;
	}
	
	/**
	 * Method to get Instrument Types
	 * @return the instruments
	 */
	public Integer[] getInstrumentTypes() {
		Integer[] result = null;
		if(instrumentTypes != null && instrumentTypes.length > ALOCConstants.NUM_ZERO) {
			result = new Integer[instrumentTypes.length];
			int i = ALOCConstants.BASE_VALUE;
			for(InstrumentType instrType : instrumentTypes) {
				result[i++] = instrType.getId();
			}
		}
		return result;
	}

	/**
	 * Method to set Instrument Types
	 * @param instruments the instruments to set
	 */
	public void setInstrumentTypes(Integer[] instrumentIds) {
		if(instrumentIds != null && instrumentIds.length > ALOCConstants.BASE_VALUE) {
			this.instrumentTypes = new InstrumentType[instrumentIds.length];
			int i = ALOCConstants.BASE_VALUE;
			for(Integer instrumentId : instrumentIds) {
				this.instrumentTypes[i++] = InstrumentType.fromId(instrumentId);
			}
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public InstrumentType[] getInstrumentTypeObjects() {
		return this.instrumentTypes;
	}
	
	/**
	 * Method to check get Selected Instrument 
	 * @param id
	 * @return
	 */
	public boolean isInstrumentSelected(String id) {
		boolean result = false;
		if(StringUtils.isNotBlank(id) && instrumentTypes != null && instrumentTypes.length > ALOCConstants.BASE_VALUE) {
			InstrumentType instType = InstrumentType.fromId(Integer.valueOf(id));
			for(InstrumentType inst : instrumentTypes) {
				if(inst == instType) {
					result = true;
					break;
				}
			}
		}
		return result;
	}
	
	/**
	 * Method to sort filters And columns 
	 */
	private void sortFiltersAndColumns() {
		if(filterIds != null && filterIds.length > ALOCConstants.NUM_ZERO) {
			HashMap<String, FilterBO> tempFilterMap = new LinkedHashMap<String, FilterBO>();
			for(String filterId : filterIds) {
				tempFilterMap.put(filterId, this.filters.get(filterId));
			}
			this.filters = tempFilterMap;
		}
		
		if(columnIds != null && columnIds.length > ALOCConstants.NUM_ZERO) {
			HashMap<String, ColumnBO> tempColumnMap = new LinkedHashMap<String, ColumnBO>();
			for(String columnId : columnIds) {
				tempColumnMap.put(columnId, this.columns.get(columnId));
			}
			this.columns = tempColumnMap;
		}
	}
}
