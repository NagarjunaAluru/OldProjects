<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${param.includeScripts != false}">
	<link href="css/bootstrap/bootstrap.css" rel="stylesheet">
	<%@include file="../../includeCommonScripts.jsp" %>
</c:if>

<div class="form-mod" id="auditLogDiv">
		  <div class="row">
			  <div class="span12">
			        <table class="table table-striped table-bordered sortable no-bottom paginate" id="treasuryAuditlogTable">
					    <thead>
							  <tr id="column_head">
								<th><s:text name="label.request.auditLog.activityDateTime"/><span class="ttip info" data-original-title="<s:text name="label.request.auditLog.tooltip.initiationDate"/>"></span></th>
								<td><s:text name="label.request.auditLog.tableHeader.8"/></td>
								<td><s:text name="label.request.auditLog.tableHeader.4"/></td>
							    <td><s:text name="label.request.auditLog.tableHeader.5"/></td>
							    <td><s:text name="label.request.auditLog.tableHeader.7"/></td>
							    <td><s:text name="label.request.auditLog.reasonForChange"/></td>
							</tr>
						</thead>
						
				  <tbody>										
					<s:if test="%{updateReportingData.auditLogs.size>0}">
							<s:iterator value="updateReportingData.auditLogs" status="stat">
									<tr class="shown">
										<td><p><s:if test="%{auditCreatedDt==null}">-</s:if><s:else><s:date name="auditCreatedDt" format="dd MMM yyyy HH:mm aa zzz"/></s:else></p></td>
										<td><p><s:if test="%{authorFirstName==null}">-</s:if><s:else><s:property value="authorFirstName"/>,<s:property value="authorLastName"/></s:else></p></td>
										<td><p><s:if test="%{fieldName==null}">-</s:if><s:else><s:property value="fieldName"/></s:else></p></td>
										<td><p><s:if test="%{oldValue==null}">-</s:if><s:else><s:property value="oldValue"/></s:else></p></td>
										<td><p><s:if test="%{newValue==null}">-</s:if><s:else><s:property value="newValue"/></s:else></p></td>
										<td><p><s:if test="%{reasonForChange==null}">-</s:if><s:else><s:property value="reasonForChange"/></s:else></p></td>
									</tr> 
							</s:iterator>
					</s:if>
					<s:else>
	            		<tr>
	            			<td colspan="11" style="text-align:center;color:blue; size:40px;"><s:text name="label.request.auditLogDesc"/> <s:property value="requestDetails.alocRecordId"/> </td>
	            		</tr>
						
				   </s:else>
				   </tbody>
					</table>		
			  </div>
	 </div>
</div>		