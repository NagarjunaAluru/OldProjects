/*
 * Copyright © 2012 GE. ALL RIGHTS RESERVED.
 * FileName: ICFPAdminAction.java
 * Purpose: ICFPAdminAction used for static data maintaince and access approvals.
 */
package com.ge.icfp.admin.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ge.icfp.action.ICFPBaseAction;
import com.ge.icfp.admin.formbean.AdminForm;
import com.ge.icfp.common.helper.ICFPAdminHelper;
import com.ge.icfp.model.AdminDataMaintenance;
import com.ge.icfp.model.AdminDataMaintenance.AdminDataTable;
import com.ge.icfp.model.AuditLog;
import com.ge.icfp.model.ModifyApprover;
import com.ge.icfp.model.ModifyApprover.ModifyApprovers;
import com.ge.icfp.model.ModifyApprover.ModifyApprovers.Reassign;
import com.ge.icfp.model.MsgHeader;
import com.ge.icfp.model.Row;
import com.ge.icfp.model.Row.Column;
import com.ge.icfp.util.StaticDataFactory;
import com.hydus.wff.common.bw.ServiceClient;
import com.hydus.wff.core.context.UserContext;
import com.hydus.wff.core.exception.HWFServiceException;
import com.hydus.wff.core.exception.HWFStubException;
import static com.ge.icfp.common.constants.ICFPConstants.*;
/**
 * @author madhusudhan.gosula
 *
 */
public class ICFPAdminAction extends ICFPBaseAction {
	private static final String ROWS_CAN_NOT_BE_DELETED = " rows can not be deleted.";
	private static final String VALUES_CAN_NOT_BE_DELETED = " values can not be deleted.";
	private static final String ALL_THE = "All the ";
	private static final String BUSINESS_ID = "businessID";
	private static final String REQUEST_HAS_BEEN_REASSIGNED_SUCCESSFULLY = "Request has been reassigned successfully.";
	private static final String REQUEST_HAS_BEEN_REMOVED_FROM_THE_APPROVERS_SUCCESSFULLY = "Request has been removed from the approvers successfully.";
	private static final String MODIFYADMINOPERATIONS = "MODIFYADMINOPERATIONS";
	private static final String REASSIGN = "REASSIGN";
	private static final String ICFP_ADD_APPROVERS = "ICFP-ADD-Approvers";
	private static final String ROLE_ID = "roleId";
	private static final String MODIFY_APPROVER = "modifyApprover";
	private static final String MANAGE_DELEGATION = "manageDelegation";
	private static final String OPEN_MANAGE_ROLES = "openManageRoles";
	private static final String E_BOARDROOM_APPROVAL_REQUIRED_AMOUNT = "eBoardroom Approval Required Amount";
	private static final String COLUMN_VALUE7 = "columnValue7";
	private static final String COLUMN_VALUE6 = "columnValue6";
	private static final String COLUMN_VALUE5 = "columnValue5";
	private static final String COLUMN_VALUE4 = "columnValue4";
	private static final String COLUMN_VALUE3 = "columnValue3";
	private static final String COLUMN_VALUE2 = "columnValue2";
	private static final String COLUMN_VALUE1 = "columnValue1";
	private static final String COLUMN_HEADER_NAME = "columnHeaderName";
	private static final String ROW_ID = "rowId";
	private static final String EDIT_TABLE = "editTable";
	private static final String HAS_BEEN_MODIFIED_SUCCESSFULLY = " has been modified successfully.";
	private static final String ADMINOPERATIONS = "ADMINOPERATIONS";
	private static final String INPUT_NAME = "inputName";
	private static final String INPUT_VALUE = "inputValue";
	private static final String EDIT_STRING = "editString";
	private static final String EDIT_DROPDOWN = "editDropdown";
	private static final String PREFERRED_FILE_TYPES = "Preferred File Types";
	private static final String TABLE_NAME = "tableName";
	private static final String DELEGATE_SSO_ID = "delegateSSO";
	/**
	 * serviceClient
	 */
	private ServiceClient serviceClient;
	/**
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward loadStaticData(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HWFServiceException, HWFStubException {
		return mapping.findForward(SUCCESS);
	}
	
	
	/**
	 * Open the dropdowm maintenance view
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward openDropdown(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HWFServiceException, HWFStubException {
		AdminForm adminForm = (AdminForm) form;
		AdminDataMaintenance adminData = new AdminDataMaintenance();
		
		String tableName = request.getParameter(TABLE_NAME);
		String sourceName = request.getParameter(SOURCE);
		if(sourceName.equals(PREFERRED_FILE_TYPES)){
			adminData =loadStringAdminData(request,adminData);
		}else{
			adminData =loadAdminData(request,adminData);
		}
		List<AdminDataTable> adminDataTables = adminData.getAdminDataTables();
		AdminDataTable adminDataTable = adminDataTables.get(0);
		List<Row> row = (List<Row>) adminDataTable.getTableRows();
		List<Column> columns = new ArrayList<Column>();
		for(Row namevalue:row){
			List<Column> dbColumns =namevalue.getColumns();
			columns.addAll(dbColumns);
		}
		adminForm.setDropDownList(columns);
		List<AuditLog> auditLog = adminData.getAuditLogs();
		adminForm.setChangeLog(auditLog);
		adminForm.setTableName(tableName);
		adminForm.setSourceName(sourceName);
		return mapping.findForward(EDIT_DROPDOWN);
	}
	
	/**
	 * Open the single record maintained
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward openString(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HWFServiceException, HWFStubException {
		AdminForm adminForm = (AdminForm) form;
		AdminDataMaintenance adminData = new AdminDataMaintenance();
		adminData =loadStringAdminData(request,adminData);
		String tableName = request.getParameter(TABLE_NAME);
		String sourceName = request.getParameter(SOURCE);
		
		List<AdminDataTable> adminDataTables = adminData.getAdminDataTables();
		AdminDataTable adminDataTable = adminDataTables.get(0);
		List<Row> row = (List<Row>) adminDataTable.getTableRows();
		String eboardValue = null;
		for(Row namevalue:row){
			List<Column> dbColumns =namevalue.getColumns();
			eboardValue = dbColumns.get(0).getValue();
			adminForm.setEboardID(String.valueOf(dbColumns.get(0).getID()));
		}
		adminForm.setEboardValue(eboardValue);
		List<AuditLog> auditLog = adminData.getAuditLogs();
		adminForm.setChangeLog(auditLog);
		adminForm.setTableName(tableName);
		adminForm.setSourceName(sourceName);
		return mapping.findForward(EDIT_STRING);
	}
	/**
	 * Save the static data
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward saveStaticData(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HWFServiceException, HWFStubException {
		AdminForm adminForm = (AdminForm) form;
		
		String[] inputValues = request.getParameterValues(INPUT_VALUE);
		String[] inputNames= request.getParameterValues(INPUT_NAME);
		List<Column> dropDownList = adminForm.getDropDownList();
		if(inputValues == null || inputValues.length==0){
			request.setAttribute(FAILUREMSG, ALL_THE+adminForm.getSourceName()+VALUES_CAN_NOT_BE_DELETED);
			return mapping.findForward(EDIT_DROPDOWN);
		}else{
			AdminDataMaintenance adminData = new AdminDataMaintenance();
			List<String> inputValuesList = (inputValues != null && inputValues.length > 0) ? Arrays.asList(inputValues) : Collections.<String>emptyList();
			List<String> inputNamesList = (inputNames != null && inputNames.length > 0) ? Arrays.asList(inputNames) : Collections.<String>emptyList();
			List<AdminDataTable> adminDataTables = new ArrayList<AdminDataMaintenance.AdminDataTable>();
			AdminDataTable adminDataTable = new AdminDataTable();
			
			ICFPAdminHelper.fillColumnData(dropDownList, adminDataTable, inputValuesList, inputNamesList);
			
			adminDataTable.setTableName(adminForm.getTableName());
			adminDataTables.add(adminDataTable);
			adminData.setAdminDataTables(adminDataTables);
			
			adminData.setOpCode(INSERT);
			setMsgHeader(adminData, INSERT);
			adminData = serviceClient.invokeService(ADMINOPERATIONS, adminData,AdminDataMaintenance.class);
			request.setAttribute(SUCCESSMSG,adminForm.getSourceName() +HAS_BEEN_MODIFIED_SUCCESSFULLY);
			StaticDataFactory staticDataFactory = (StaticDataFactory) getServlet().getServletContext().getAttribute(StaticDataFactory.CTX_KEY);
			staticDataFactory.clearAll();
			return mapping.findForward(SUCCESS);
		}
		
	}
	
	/**
	 * Save the table data
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HWFServiceException
	 * @throws HWFStubException
	 */
	public ActionForward saveReferenceData(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HWFServiceException, HWFStubException {
		AdminForm adminForm = (AdminForm) form;
		
		String inputValues = request.getParameter(INPUT_VALUE);
		String inputNames = request.getParameter(INPUT_NAME);
		
		AdminDataMaintenance adminData = new AdminDataMaintenance();
			
		List<AdminDataTable> adminDataTables = new ArrayList<AdminDataMaintenance.AdminDataTable>();
		AdminDataTable adminDataTable = new AdminDataTable();
		
		List<Row> tableRows = (List<Row>) adminDataTable.getTableRows();
		Row modalRow = new Row();
		Column column = new Column();
		column.setValue(inputValues);
		column.setName(EBOARDAPPROVALAMOUNT);
		
		modalRow.getColumns().add(column);
		modalRow.setOpCode(UPDATE);
		modalRow.setID(Integer.valueOf(inputNames));
		tableRows.add(modalRow);
		adminDataTable.setTableRows(tableRows);
		
		adminDataTable.setTableName(adminForm.getTableName());
		adminDataTables.add(adminDataTable);
		adminData.setAdminDataTables(adminDataTables);
		adminData.setOpCode(UPDATE);
		setMsgHeader(adminData, INSERT);
		adminData = serviceClient.invokeService(ADMINOPERATIONS, adminData,AdminDataMaintenance.class);
		request.setAttribute(SUCCESSMSG,adminForm.getSourceName() +HAS_BEEN_MODIFIED_SUCCESSFULLY);
		StaticDataFactory staticDataFactory = (StaticDataFactory) getServlet().getServletContext().getAttribute(StaticDataFactory.CTX_KEY);
		staticDataFactory.clearAll();
		return mapping.findForward(SUCCESS);
	}
	
	/**
	 * Open the table view
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward openTable(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HWFServiceException, HWFStubException {
		AdminForm adminForm = (AdminForm) form;
		AdminDataMaintenance adminData = new AdminDataMaintenance();
		adminData =loadAdminData(request,adminData);
		String tableName = request.getParameter(TABLE_NAME);
		String sourceName = request.getParameter(SOURCE);
		List<AdminDataTable> adminDataTables = adminData.getAdminDataTables();
		AdminDataTable adminDataTable = adminDataTables.get(0);
		List<Row> rowList = (List<Row>) adminDataTable.getTableRows();
		ICFPAdminHelper.clearFilterValues(adminForm);
		adminForm = ICFPAdminHelper.fillFilterValues(adminForm, rowList);
		adminForm.setTableList(rowList);
		adminForm.setOldTableList(rowList);
		List<Column> columnList = new ArrayList<Column>();
		List<String> columnHeaderNameList = new ArrayList<String>();
		if(!rowList.isEmpty() && rowList.size()>0){
			columnList = rowList.get(0).getColumns();
		}
		for (Column colValue : columnList) {
			columnHeaderNameList.add(colValue.getName());
		}
		
		adminForm.setColumnHeaderNameList(columnHeaderNameList);
		List<AuditLog> auditLog = adminData.getAuditLogs();
		adminForm.setChangeLog(auditLog);
		adminForm.setTableName(tableName);
		adminForm.setSourceName(sourceName);
		return mapping.findForward(EDIT_TABLE);
	}
	
	
	/**
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward saveTableData(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HWFServiceException, HWFStubException {
		AdminForm adminForm = (AdminForm) form;
		
		String[] rowId = request.getParameterValues(ROW_ID);
		if(rowId ==null || rowId.length==0){
			request.setAttribute(FAILUREMSG, ALL_THE+adminForm.getSourceName()+ROWS_CAN_NOT_BE_DELETED);
			return mapping.findForward(EDIT_TABLE);
		}else{
			String[] columnHeaderName = request.getParameterValues(COLUMN_HEADER_NAME);
			String[] columnValue1= request.getParameterValues(COLUMN_VALUE1);
			String[] columnValue2 = request.getParameterValues(COLUMN_VALUE2);
			String[] columnValue3= request.getParameterValues(COLUMN_VALUE3);
			String[] columnValue4 = request.getParameterValues(COLUMN_VALUE4);
			String[] columnValue5= request.getParameterValues(COLUMN_VALUE5);
			String[] columnValue6 = request.getParameterValues(COLUMN_VALUE6);
			String[] columnValue7= request.getParameterValues(COLUMN_VALUE7);
			
			List<Row> tableRowList = adminForm.getTableList();
			
			AdminDataMaintenance adminData = new AdminDataMaintenance();
			List<String> rowIdList = (rowId != null && rowId.length > 0) ? Arrays.asList(rowId) : Collections.<String>emptyList();
			List<String> columnHeaderNameList = (columnHeaderName != null && columnHeaderName.length > 0) ? Arrays.asList(columnHeaderName) : Collections.<String>emptyList();
			List<String> columnValue1List = (columnValue1 != null && columnValue1.length > 0) ? Arrays.asList(columnValue1) : Collections.<String>emptyList();
			List<String> columnValue2List = (columnValue2 != null && columnValue2.length > 0) ? Arrays.asList(columnValue2) : Collections.<String>emptyList();
			List<String> columnValue3List = (columnValue3 != null && columnValue3.length > 0) ? Arrays.asList(columnValue3) : Collections.<String>emptyList();
			List<String> columnValue4List = (columnValue4 != null && columnValue4.length > 0) ? Arrays.asList(columnValue4) : Collections.<String>emptyList();
			List<String> columnValue5List = (columnValue5 != null && columnValue5.length > 0) ? Arrays.asList(columnValue5) : Collections.<String>emptyList();
			List<String> columnValue6List = (columnValue6 != null && columnValue6.length > 0) ? Arrays.asList(columnValue6) : Collections.<String>emptyList();
			List<String> columnValue7List = (columnValue7 != null && columnValue7.length > 0) ? Arrays.asList(columnValue7) : Collections.<String>emptyList();
			
			
			List<AdminDataTable> adminDataTables = new ArrayList<AdminDataMaintenance.AdminDataTable>();
			AdminDataTable adminDataTable = new AdminDataTable();
			
			
			ICFPAdminHelper.fillRowData(tableRowList, rowIdList, columnHeaderNameList,
					columnValue1List, columnValue2List, columnValue3List,
					columnValue4List, columnValue5List, columnValue6List,
					columnValue7List, adminDataTable);

			adminDataTable.setTableName(adminForm.getTableName());
			adminDataTables.add(adminDataTable);
			adminData.setAdminDataTables(adminDataTables);
			
			adminData.setOpCode(INSERT);
			setMsgHeader(adminData, INSERT);
			adminData = serviceClient.invokeService(ADMINOPERATIONS, adminData,AdminDataMaintenance.class);
			request.setAttribute(SUCCESSMSG,adminForm.getSourceName() +HAS_BEEN_MODIFIED_SUCCESSFULLY);
			return mapping.findForward(SUCCESS);
		}
		
	}
	
	/**
	 * loadAdminData
	 * @param request
	 * @throws HWFServiceException
	 * @throws HWFStubException
	 */
	private AdminDataMaintenance loadAdminData(HttpServletRequest request, AdminDataMaintenance adminData) throws HWFServiceException, HWFStubException {
		adminData.setOpCode(GET);
		setMsgHeader(adminData, GET);
		String tableName = request.getParameter(TABLE_NAME);
		AdminDataTable adminDataTable = new AdminDataTable();
		adminDataTable.setTableName(tableName);
		List<AdminDataTable> adminDataTables = new ArrayList<AdminDataMaintenance.AdminDataTable>();
		adminDataTables.add(adminDataTable);
		adminData.setAdminDataTables(adminDataTables);
		adminData = serviceClient.invokeService(ADMINOPERATIONS, adminData,AdminDataMaintenance.class);
		return adminData;
	}
	
	/**
	 * loadAdminData
	 * @param request
	 * @throws HWFServiceException
	 * @throws HWFStubException
	 */
	private AdminDataMaintenance loadStringAdminData(HttpServletRequest request, AdminDataMaintenance adminData) throws HWFServiceException, HWFStubException {
		adminData.setOpCode(GET);
		setMsgHeader(adminData, GET);
		String tableName = request.getParameter(TABLE_NAME);
		String sourceName = request.getParameter(SOURCE);
		AdminDataTable adminDataTable = new AdminDataTable();
		adminDataTable.setTableName(tableName);
		List<AdminDataTable> adminDataTables = new ArrayList<AdminDataMaintenance.AdminDataTable>();
		List<Row> rowList = new ArrayList<Row>();
		Row modalRow = new Row();
		Column column = new Column();
		if(sourceName.equals(E_BOARDROOM_APPROVAL_REQUIRED_AMOUNT)){
			column.setName(EBOARDAPPROVALAMOUNT);
		}else if(sourceName.equals(PREFERRED_FILE_TYPES)){
			column.setName(PREFFEREDFILETYPE);
		}
		modalRow.getColumns().add(column);
		rowList.add(modalRow);
		adminDataTable.setTableRows(rowList);
		adminDataTables.add(adminDataTable);
		adminData.setAdminDataTables(adminDataTables);
		adminData = serviceClient.invokeService(ADMINOPERATIONS, adminData,AdminDataMaintenance.class);
		return adminData;
	}
	
	/**
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HWFServiceException
	 * @throws HWFStubException
	 */
	public ActionForward search(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HWFServiceException, HWFStubException {
		AdminForm adminForm = (AdminForm) form;
		AdminDataMaintenance adminData = new AdminDataMaintenance();
		adminData =filterAdminData(request, adminData, adminForm);
		List<AdminDataTable> adminDataTables = adminData.getAdminDataTables();
		AdminDataTable adminDataTable = adminDataTables.get(0);
		List<Row> rowList = (List<Row>) adminDataTable.getTableRows();
		adminForm.setTableList(rowList);
		
		return mapping.findForward(EDIT_TABLE);
	}
	
	
	/**
	 * 
	 * @param request
	 * @param adminData
	 * @param adminForm
	 * @return
	 * @throws HWFServiceException
	 * @throws HWFStubException
	 */
	private AdminDataMaintenance filterAdminData(HttpServletRequest request,
			AdminDataMaintenance adminData, AdminForm adminForm)
			throws HWFServiceException, HWFStubException {
		adminData.setOpCode(SEARCH);
		setMsgHeader(adminData, SEARCH);
		AdminDataTable adminDataTable = new AdminDataTable();
		adminDataTable.setTableName(adminForm.getTableName());
		List<AdminDataTable> adminDataTables = new ArrayList<AdminDataMaintenance.AdminDataTable>();
		String[] columnHeaderName = request.getParameterValues(COLUMN_HEADER_NAME);
		List<String> columnHeaderNameList = (columnHeaderName != null && columnHeaderName.length > 0) ? Arrays.asList(columnHeaderName) : Collections.<String>emptyList();
		adminDataTable.getTableRows().clear();
		List<Row> rowList = new ArrayList<Row>();
		Row modalRow = new Row();
		//fill search criteria
		modalRow = ICFPAdminHelper.fillSearchCriteria(adminForm,rowList, columnHeaderNameList, modalRow);
		
		rowList.add(modalRow);
		adminDataTable.setTableRows(rowList);
		adminDataTables.add(adminDataTable);
		adminData.setAdminDataTables(adminDataTables);
		adminData = serviceClient.invokeService(ADMINOPERATIONS, adminData,AdminDataMaintenance.class);
		return adminData;
	}
	
	/**
	 * 
	 * @param adminData
	 * @param opcode
	 */
	protected void setMsgHeader(AdminDataMaintenance adminData, String opcode) {
		MsgHeader msgHeader = new MsgHeader();
		msgHeader.setOpcode(opcode);
		String currentUserId = UserContext.getCurrentUserContext().getId();
		String lastName = UserContext.getCurrentUserContext().getLastName();
		String firstName = UserContext.getCurrentUserContext().getFirstName();
		msgHeader.setAuditCreator(currentUserId);
		msgHeader.setAuditModifier(currentUserId);
		msgHeader.setAuditModifierFirstName(firstName);
		msgHeader.setAuditModifierLastName(lastName);
		msgHeader.setAuditCreatorFirstName(firstName);
		msgHeader.setAuditCreatorLastName(lastName);
		adminData.setMsgHeader(msgHeader);
	}
	
	/**
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward modifyApprover(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HWFServiceException, HWFStubException {
		AdminForm adminForm = (AdminForm) form;
		accessApprovers(adminForm, request);
		return mapping.findForward(MODIFY_APPROVER);
	}
	
	/**
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HWFServiceException
	 * @throws HWFStubException
	 */
	public ActionForward getTeamMembers(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HWFServiceException, HWFStubException {
		AdminForm adminForm = (AdminForm) form;
		String roleID = request.getParameter(ROLE_ID);
		
		Map<String,List<Reassign>> teamMembers = adminForm.getTeamMembers();
		
		List<Reassign> reasignList = teamMembers.get(roleID);
		
		Map <String, Reassign> reasignMap = new HashMap<String, Reassign>();

		for (int i = 0; i < reasignList.size(); i++) {
			Reassign roleInfo = reasignList.get(i);
			reasignMap.put(roleInfo.getSSOID(), roleInfo);
		}
		Collection<Reassign> reasions = reasignMap.values();
		adminForm.setReasignList(new ArrayList<ModifyApprover.ModifyApprovers.Reassign>(reasions));
		return mapping.findForward(MODIFY_APPROVER);
	}
	
	
	/**
	 * revokeTeamMembers
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HWFServiceException
	 * @throws HWFStubException
	 */
	public ActionForward revokeTeamMembers(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HWFServiceException, HWFStubException {
		AdminForm adminForm = (AdminForm) form;
		String roleID = request.getParameter(ROLE_ID);

		if (null != roleID) {
			
			ModifyApprover modifyApprover = new ModifyApprover();
			List<ModifyApprover.ModifyApprovers> modifyApprovers = new ArrayList<ModifyApprover.ModifyApprovers>();
			ModifyApprovers eachApprover = new ModifyApprovers();
			eachApprover.setDqlSeqId(adminForm.getDealRequestID());

			List<ModifyApprover.ModifyApprovers> oldModifyApprovers = adminForm
					.getModifyApprovers();
			for (ModifyApprovers oldApprover : oldModifyApprovers) {
				if (oldApprover.getRoleId().equals(roleID)) {

					fillModifyApprovers(eachApprover, oldApprover);
					if(FIFTYTWO.equals(roleID) && eachApprover.getQueueName()==null){
						eachApprover.setQueueName(ICFP_ADD_APPROVERS);
					}
					eachApprover.setOpCode(DELETE);
					break;
				}
			}
			setModMsgHeader(eachApprover, REASSIGN);
			modifyApprovers.add(eachApprover);
			modifyApprover.setModifyApprovers(modifyApprovers);
			modifyApprover = serviceClient.invokeService(MODIFYADMINOPERATIONS, modifyApprover, ModifyApprover.class);
			request.setAttribute(SUCCESSMSG,REQUEST_HAS_BEEN_REMOVED_FROM_THE_APPROVERS_SUCCESSFULLY);
		}
		adminForm.setModifyApprovers(null);
		adminForm.setTeamMembers(null);
		accessApprovers(adminForm, request);
		return mapping.findForward(MODIFY_APPROVER);
	}
	
	/**
	 * reassignApprover
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HWFServiceException
	 * @throws HWFStubException
	 */
	public ActionForward reassignApprover(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HWFServiceException, HWFStubException {

		AdminForm adminForm = (AdminForm) form;
		String roleID = request.getParameter(ROLE_ID);
		String ssoId = request.getParameter(TEAMMEMBERID);
		if (null != ssoId) {
			ModifyApprover modifyApprover = new ModifyApprover();
			List<ModifyApprover.ModifyApprovers> modifyApprovers = new ArrayList<ModifyApprover.ModifyApprovers>();
			ModifyApprovers eachApprover = new ModifyApprovers();
			eachApprover.setDqlSeqId(adminForm.getDealRequestID());

			List<Reassign> reasignMembers = new ArrayList<ModifyApprover.ModifyApprovers.Reassign>();
			Reassign reasignMember = new Reassign();

			List<Reassign> oldReasignList = adminForm.getReasignList();
			for (Reassign oldReasign : oldReasignList) {
				if (oldReasign.getSSOID().equals(ssoId)) {
					fillReasignDetails(reasignMember,oldReasign);
					break;
				}
			}

			List<ModifyApprover.ModifyApprovers> oldModifyApprovers = adminForm
					.getModifyApprovers();
			for (ModifyApprovers oldApprover : oldModifyApprovers) {
				if (oldApprover.getRoleId().equals(roleID)) {
					fillModifyApprovers(eachApprover, oldApprover);
					break;
				}
			}
			reasignMembers.add(reasignMember);
			eachApprover.setReassigns(reasignMembers);
			setModMsgHeader(eachApprover, REASSIGN);
			modifyApprovers.add(eachApprover);
			modifyApprover.setModifyApprovers(modifyApprovers);
			modifyApprover = serviceClient.invokeService(MODIFYADMINOPERATIONS, modifyApprover, ModifyApprover.class);
			request.setAttribute(SUCCESSMSG,REQUEST_HAS_BEEN_REASSIGNED_SUCCESSFULLY);
			
		}
		adminForm.setModifyApprovers(null);
		adminForm.setTeamMembers(null);
		accessApprovers(adminForm, request);
		return mapping.findForward(MODIFY_APPROVER);
	}
	
	
	/**
	 * manageDelegation
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HWFServiceException
	 * @throws HWFStubException
	 */
	public ActionForward manageDelegation(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HWFServiceException,
			HWFStubException {
		return mapping.findForward(MANAGE_DELEGATION);
	}
	/**
	 * loadManageDelegations
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HWFServiceException
	 * @throws HWFStubException
	 */
	public ActionForward loadManageDelegations(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HWFServiceException,
			HWFStubException {
		String delegateSSO = request.getParameter(DELEGATE_SSO_ID);
		request.getSession().setAttribute(DELEGATE_SSO_ID,delegateSSO);
		return mapping.findForward(OPEN_MANAGE_ROLES);
	}
	
	/**
	 * 
	 * @param reasignMember
	 * @param oldReasign
	 */
	private void fillReasignDetails(Reassign reasignMember, Reassign oldReasign) {
		reasignMember.setSSOID(oldReasign.getSSOID());
		reasignMember.setRoleId(oldReasign.getRoleId());
		reasignMember.setFirstName(oldReasign.getFirstName());
		reasignMember.setLastName(oldReasign.getLastName());
		reasignMember.setRoleName(oldReasign.getRoleName());
		
	}
	/**
	 * 
	 * @param eachApprover
	 * @param oldApprover
	 */
	private void fillModifyApprovers(ModifyApprovers eachApprover, ModifyApprovers oldApprover) {
		eachApprover.setRoleId(oldApprover.getRoleId());
		eachApprover.setSSOID(oldApprover.getSSOID());
		eachApprover.setRoleName(oldApprover.getRoleName());
		eachApprover.setLastName(oldApprover.getLastName());
		eachApprover.setFirstName(oldApprover.getFirstName());
		eachApprover.setWfId(oldApprover.getWfId());
		eachApprover.setQueueName(oldApprover.getQueueName());
		
	}
	/**
	 * 
	 * @param adminForm
	 * @param request
	 * @throws HWFServiceException
	 * @throws HWFStubException
	 */
	private void accessApprovers(AdminForm adminForm, HttpServletRequest request) throws HWFServiceException, HWFStubException{
		String dealRequestID = request.getParameter(DEALREQUESTID);
		String businessID = request.getParameter(BUSINESS_ID);		
		if(!StringUtils.isEmpty(dealRequestID)){
			adminForm.setDealRequestID(dealRequestID);
		}
		if(!StringUtils.isEmpty(businessID)){
			adminForm.setBusinessID(businessID);
		}
		ModifyApprover modifyApprover = new ModifyApprover();
		List<ModifyApprover.ModifyApprovers> modifyApprovers = new ArrayList<ModifyApprover.ModifyApprovers>();
		Map<String,List<Reassign>> teamMembers = new HashMap<String, List<Reassign>>();
		ModifyApprovers eachApprover = new ModifyApprovers();
		eachApprover.setDqlSeqId(adminForm.getDealRequestID());
		MsgHeader msgHeader = new MsgHeader();
		msgHeader.setOpcode(GET);
		String currentUserId = UserContext.getCurrentUserContext().getId();
		msgHeader.setAuditCreator(currentUserId);
		msgHeader.setAuditModifier(currentUserId);
		eachApprover.setMsgHeader(msgHeader);
		modifyApprovers.add(eachApprover);
		modifyApprover.setModifyApprovers(modifyApprovers);
		modifyApprover = serviceClient.invokeService(MODIFYADMINOPERATIONS, modifyApprover,ModifyApprover.class);
		
		List<ModifyApprovers> approverList = modifyApprover.getModifyApprovers();
		for(ModifyApprovers approver:approverList){
			List<Reassign> reasignMembers = approver.getReassigns();
			teamMembers.put(approver.getRoleId(), reasignMembers);
		}
		adminForm.setTeamMembers(teamMembers);
		adminForm.setModifyApprovers(approverList);
	}
	
	/**
	 * 
	 * @param modifyApprovers
	 * @param opcode
	 */
	protected void setModMsgHeader(ModifyApprovers modifyApprovers, String opcode) {
		MsgHeader msgHeader = new MsgHeader();
		msgHeader.setOpcode(opcode);
		String currentUserId = UserContext.getCurrentUserContext().getId();
		String lastName = UserContext.getCurrentUserContext().getLastName();
		String firstName = UserContext.getCurrentUserContext().getFirstName();
		msgHeader.setAuditCreator(currentUserId);
		msgHeader.setAuditModifier(currentUserId);
		msgHeader.setAuditModifierFirstName(firstName);
		msgHeader.setAuditModifierLastName(lastName);
		msgHeader.setAuditCreatorFirstName(firstName);
		msgHeader.setAuditCreatorLastName(lastName);
		modifyApprovers.setMsgHeader(msgHeader);
	}
	/**
	 * @return the serviceClient
	 */
	public ServiceClient getServiceClient() {
		return serviceClient;
	}

	/**
	 * @param serviceClient the serviceClient to set
	 */
	public void setServiceClient(ServiceClient serviceClient) {
		this.serviceClient = serviceClient;
	}
}
