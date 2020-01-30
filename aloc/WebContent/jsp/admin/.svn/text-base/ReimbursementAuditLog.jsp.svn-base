<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link href="${pageContext.request.contextPath}/css/common/pagenavi.css" type="text/css" rel="stylesheet" />
<div class="form-mod" id="auditLogDiv">
		<div id="auditLogPanel">		
		  <div class="row">
			  <div class="span12">
			        <table class="table table-striped table-bordered sortable no-bottom paginate" id="treasuryAuditlogTable">
					    <thead>
							  <tr id="column_head">
								<th><s:text name="label.request.auditLog.tableHeader.1"/><span class="ttip info" data-original-title="<s:text name="label.request.auditLog.tooltip.initiationDate"/>"></span></th>
								<th><s:text name="label.request.auditLog.tableHeader.2"/><span class="ttip info" data-original-title="<s:text name="label.request.auditLog.tooltip.completionDate"/>"></span></th>
								<th><s:text name="label.request.auditLog.admintableHeader.3"/></th>
								<th><s:text name="label.request.auditLog.tableHeader.4"/></th>   
							    <th><s:text name="label.request.auditLog.tableHeader.5"/></th>
							    <th><s:text name="label.request.auditLog.tableHeader.7"/></th>
							    <th><s:text name="label.request.auditLog.tableHeader.8"/></th>
							</tr>
						</thead>
						
				  <tbody>		
	            	 <s:if test="%{reimbursement.auditLogs.size>0}">
							<s:iterator value="reimbursement.auditLogs" status="stat"> 
									<tr class="shown">
										<td><p><s:if test="%{auditCreatedDt==null}">-</s:if><s:else><s:date name="auditCreatedDt" format="dd MMM yyyy HH:mm aa zzz"/></s:else></p></td>
										<td><p><s:if test="%{transactionCompleteDt==null}">-</s:if><s:else><s:date name="transactionCompleteDt" format="dd MMM yyyy HH:mm aa zzz"/></s:else></p></td>
										<td><p><s:if test="%{agreementId==null}">-</s:if><s:else> <s:property value="agreementId"/></s:else></p></td>
										<td><p><s:if test="%{fieldName==null}">-</s:if><s:else><s:property value="fieldName"/></s:else></p></td>
										<td style="word-wrap: break-word;"><p><c:choose>
											       <c:when test="${empty oldValue}">-</c:when>
											       <c:when test="${oldValue eq 'Y'}">Yes</c:when>
											       <c:when test="${oldValue eq 'N'}">No</c:when>
											       <c:otherwise><div style="width: 155px; overflow: auto;"><s:property value="oldValue" escape="false"/></div></c:otherwise>
											   </c:choose></p></td>
										<td style="word-wrap: break-word;"><p> <c:choose>
											       <c:when test="${empty newValue}">-</c:when>
											       <c:when test="${newValue eq 'Y'}">Yes</c:when>
											       <c:when test="${newValue eq 'N'}">No</c:when>
											       <c:otherwise><div style="width: 155px; overflow: auto;"><s:property value="newValue" escape="false"/></div></c:otherwise>
											    </c:choose></p></td>
										<td><p><s:if test="%{authorFirstName==null}">-</s:if><s:else><s:property value="authorFirstName"/>,<s:property value="authorLastName"/></s:else></p></td>
									</tr> 
								
							</s:iterator>
					</s:if>		
					<s:else>
	            		<tr>
	            			<td colspan="11" style="text-align:center;color:blue; size:40px;"><s:text name="label.request.reimbursementAuditLogDesc"/> <s:property value="reimbursement.reimbursementAgreement.reimbursementAgreementName"/> </td>
	            		</tr>
						
				   </s:else> 
				   </tbody>
					</table>		
			  </div>
		  </div>	
	 </div>
</div>		