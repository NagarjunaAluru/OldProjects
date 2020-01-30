<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<s:url action="openRecordsRetentionManagement.action" namespace="/int/admin" var="backURL" />
<html>
<head>
 <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><s:text name="label.recordsretntionmgmt.pageTitle" /></title>
<%@include file="../common/includeCommonScripts.jsp" %>
<link href="${pageContext.request.contextPath}/css/common/pagenavi.css" type="text/css" rel="stylesheet" />
<script src="${pageContext.request.contextPath}/js/admin/treasuryAdminManagement.js" type="text/javascript"></script> 
</head>
<s:url action="treasuryAdminPortal.action" namespace="/int/admin" var="cancelBtnlURL"/> 
<c:if test="${param.viewLog eq '2'}">
	<s:url action="openPurgeReport.action" namespace="/int/admin" var="backURL" />
</c:if>
<c:if test="${param.viewLog eq '1'}">
	<s:url action="openRecordsRetentionManagement.action" namespace="/int/admin" var="backURL" />
</c:if>
<body>
<div class="container main">
	<jsp:include page="../common/headerSection.jsp">
		<jsp:param name="createReqPopup" value="Yes"></jsp:param>
	</jsp:include>
	<div class="row">
			<div class="span12">
				<span class="left"><a href="<s:property value="#backURL" />" class="right" style="font-size: 12px;"><s:text name="label.recordsretntionmgmt.back" /></a></span>
			</div>
		</div>
<!-- Audit Log -->
	<div class="form-mod">
		<h2 id="auditLog" class=" acc_trigger1 acc_blue section_flip">
			<a href="javascript:;"><s:text name="label.standardFormatMgmt.auditLog" /> -
				<s:if test="%{recordRetention.RecordRetentionAuditLogs.size > 0}">
				  <s:property value="recordRetention.RecordRetentionAuditLogs.size"/>
				</s:if>
			    <s:else>
			    <s:property value="0"/>
			    </s:else>
			</a>
		</h2><hr class="h2-hr">
		<div class="acc_container1" id="auditLogPanel">
			<div class="row">
				<div class="span12">
				<div id="searchSort">
				   	<div class="leftColSort">
				       	<p id="itemsPerPage">
				       	    <span id="start"></span> - <span id="end"></span> of <span id="total"></span> items
				       	</p>
				    </div>
				    <div class="rightColSort">
				         	Show&nbsp;&nbsp;
						<select class="pagination-rows">
						<option>10</option>
						<option>20</option>
						<option>30</option>
						<option>40</option>
						<option>50</option>
						</select>&nbsp;&nbsp;results
				    </div>
					<div class="clear"></div>
				</div>
					<table id="retentionFullAuditLogTable" class="table table-striped table-bordered sortable paginate">
					<thead>
					    <tr>
					        <th colspan="1" class="headerSortUp"><s:text name="label.recordsretntionmgmt.updatedDate"/></th>
							<th colspan="1"><s:text name="label.recordsretntionmgmt.numberOfYears"/></th>
						    <th colspan="1"><s:text name="label.recordsretntionmgmt.scheduleFreq"/></th>
						    <th colspan="1"><s:text name="label.recordsretntionmgmt.frequencyInMonths"/></th>
						    <th colspan="1"><s:text name="label.recordsretntionmgmt.oneTimeDate"/></th>
						    <th colspan="1"><s:text name="label.recordsretntionmgmt.approverAction"/></th>
						    <th colspan="1"><s:text name="label.recordsretntionmgmt.reasonForReturn"/></th>
						    <th colspan="1"><s:text name="label.recordsretntionmgmt.submittedBy"/></th>
						    <th colspan="1"><s:text name="label.recordsretntionmgmt.approverName"/></th>
					    </tr>
					</thead>
					<tbody>
						<s:if test="%{recordRetention.RecordRetentionAuditLogs.size>0}">
						  <s:iterator value="recordRetention.RecordRetentionAuditLogs">
						    <tr class="shown">
							    <td><s:date name="updatedDt" format="MMM dd, yyyy  HH:mm aa zzz"/></td>
							    <td><s:property value="numberofYears"/></td>
							    <td><s:property value="scheduleFrequency"/></td>
								<td><s:property value="frequencyMonths"/></td>
								<td><s:property value="onetimeRundate"/></td>
								<td><s:property value="approverAction"/></td>
								<td style="word-wrap: break-word;"><div style="width: 155px; overflow: auto;"><s:property value="reasonReturn"/></div></td>
								<td>
									<s:property value="auditModifierLastname"/>,&nbsp;&nbsp;
									<s:property value="auditModifierFirstname"/>
								</td>
								<td>
									<s:property value="approverLastname"/>,&nbsp;&nbsp;
									<s:property value="approverFirstname"/>
								</td>
						    </tr> 
						  </s:iterator>
						</s:if>
						<s:else>
						<tr class="spantr2">
						<td colspan="9" style="text-align: center;"><s:text name="label.recordsretntionmgmt.AuditLog"/></td>
						</tr>
						</s:else>
					</tbody>
				</table>
			</div>
		</div>
		</div>
	</div>
	<div id="searchSort">
	   	<div class="leftColSort">
			<p id="itemsPerPage1"> <span id="start"></span> - <span id="end"></span> of <span id="total"></span> items</p>
		</div>
	</div>
	<!-- PAGE NAVIGATION STARTS HERE -->
	      <div class="row">
	          <div class="span right">
	          	<div class="pagenavi left">
	          	
	              </div>
	              <div class="span3 jump-page">
	               Jump to
				<input type="text" class="span1 manual">
				<a class="btn btn-success-blue" type="submit">Go</a>
	              </div>
	          </div>
	      </div>
	      <input type='hidden' id='current_page' />
	    	<script src="${pageContext.request.contextPath}/js/common/pagination.js"></script>
	<!-- PAGE NAVIGATION ENDS HERE -->

</div>
<%@include file="../common/footerSection.jsp"%>
</body>
</html>