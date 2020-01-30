<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="form-mod" id="transactionHistoryLogDiv">
 
	<s:set name="noOfTransactionLog" value="requestDetails.actionLogs.size"/>
	<div id="transactionHistoryLogPanel">
	<div class="row">
		<div class="span12">
			<table class="table table-striped table-bordered sortable no-bottom paginate" id="transactionTable">
				<thead>
					  <tr id="column_head">
						<th><s:text name="label.request.transactionHistoryLog.tableHeader.1"/></th>
						<th><s:text name="label.request.transactionHistoryLog.tableHeader.2"/></th>
						<th><s:text name="label.request.transactionHistoryLog.tableHeader.3"/></th>
						<th><s:text name="label.request.transactionHistoryLog.tableHeader.4"/></th>
						<th><s:text name="label.request.transactionHistoryLog.tableHeader.7"/></th>
						<th><s:text name="label.request.transactionHistoryLog.tableHeader.6"/></th>
					</tr>
				</thead>
	            <tbody>
	            	<s:if test="%{#noOfTransactionLog == 0}">
	            		<tr>
	            			<td colspan="6"><s:text name="label.request.noTransactionHistoryDetails" /> </td>
	            		</tr>
	            	</s:if>
	            	
	            	
	            	<s:if test="%{#noOfTransactionLog > 0}">
	            		<s:iterator value="requestDetails.actionLogs" status="rowStatus" >
	            			<s:if test="%{#rowStatus.index !=6}">
	            				<s:if test="%{actionId!=36}">
				            		<tr class="shown">
					                	<td><p><s:date name="auditCreatedDt" format="dd MMM yyyy HH:mm aa zzz"/></p></td>
										<td><p><c:if test="${stageName eq 'Outstanding' and actionName eq 'CompleteTransaction'}">
											<s:text name="Closed"/>
										</c:if>
										<c:if test="${stageName ne 'Outstanding' or actionName ne 'CompleteTransaction'}">
											<s:property value="stageName"/>
										</c:if>
										</p></td>
										<td><p><c:if test="${stageName eq 'Outstanding' and actionName eq 'CompleteTransaction'}">
											<s:text name="Closed Transaction"/>
										</c:if>
										<c:if test="${stageName ne 'Outstanding' or actionName ne 'CompleteTransaction'}">
											<s:property value="actionName"/>
										</c:if>
										</p></td>
										<td style="word-wrap: break-word;"><p><c:if test="${empty reasonForRejection}">-</c:if><c:if test="${not empty reasonForRejection}"><div style="width: 155px; overflow: auto;"><s:property value="reasonForRejection"/></div></c:if></p></td>
										<td style="word-wrap: break-word;"><p><c:if test="${empty comments}">-</c:if><c:if test="${not empty comments}"><div style="width: 155px; overflow: auto;"><s:property value="comments"/></div></c:if></p></td>
										<td><p><s:property value="approverLastName"/>, <s:property value="approverFirstName"/></p></td>
									</tr>
								</s:if>
							</s:if>
						</s:iterator>
	            	</s:if>
			</table>
		</div>
	</div>
	  
	</div>
</div>