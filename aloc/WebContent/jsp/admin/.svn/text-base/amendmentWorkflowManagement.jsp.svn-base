		<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
		<%@ page errorPage="/jsp/common/error.jsp"%>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		<%@ taglib prefix="s" uri="/struts-tags"%>
		<!DOCTYPE html>
		<html>
		<head>
		 <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<%@include file="../common/includeCommonScripts.jsp"%>
		<title><s:text name="label.amendment.pageTitle" /></title>
		<link href="${pageContext.request.contextPath}/css/common/pagenavi.css"
			type="text/css" rel="stylesheet" />
		<script
			src="${pageContext.request.contextPath}/js/requestor/requestor.js"
			type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/admin/treasuryAdminManagement.js" type="text/javascript"></script> 
		</head>
		<s:url action="cancelAmendmentWorkflowMgmt" namespace="/int/admin" var="cancelAmendmentWorkflowMgmtURL" />
        <s:url action="openfullAuditLog" namespace="/int/admin" var="openfullAuditLogURL" />
          <body>
			<div class="container main">
				<jsp:include page="../common/headerSection.jsp">
					<jsp:param name="createReqPopup" value="Yes"></jsp:param>
				</jsp:include>
				 <s:form action="saveAmendmentWorkflowMgmt">
				<div id="mainPage">
		       <h1 class="page-title span12"><s:text name="label.amendment.amendmentWorkflowManagement" /></h1>
		       <p class="span12 left clear dashdesc"><s:text name="label.amendment.enablesTreasuryUsersToModify" /></p>
					<hr class="page-title-hr">
					<div class="row">
						<div class="span12">
							<label>
								<s:text name="label.amendment.amendmentAmount" />
								<span class="ttip info"	data-original-title="<s:text name="label.treasuryAdminPortal.tooltip.amendmentAmount"/>"></span>
							</label>
							<s:textfield type="text" class="span3" name="amendmentWorkflow.amendmentAmount" theme="aloc" maxlength="21"/>
						</div>
					</div>
					<div class="form-mod">
						<h2 id="auditLog" class="section_flip section_blue">
							<a href="javascript:;"><s:text name="label.amendment.auditLog" /><s:property value="amendmentWorkflow.auditLogs.size"/></a></h2><hr class="h2-hr">
						<div id="auditLogPanel" class="section_panel">
		
							<div class="row">
								<div class="span12">
									<p>
										<s:text name="label.amendment.viewChangesToASingleTransaction" />
										<span class="right"><a href="<s:property value="#openfullAuditLogURL" />"><s:text
													name="label.amendment.viewFullAuditLog" /></a></span>
									</p>
								</div>
							</div>
							<div class="row">
								<div class="span12">
									<table class="table table-striped table-bordered sortable paginate" id="amendmentWorkflowAuditLogTable">
										<thead>
											<tr class="spantr1">
												<th colspan="1" class="headerSortUp"><s:text
														name="label.amendment.updatedDate" /><span
													class="ttip info"
													data-original-title="This is an tooltip with more information"></span></th>
												<th colspan="1"><s:text name="label.amendment.oldValue" /></th>
												<th colspan="1"><s:text
														name="label.amendment.updatedValue" /></th>
												<th colspan="1"><s:text
														name="label.amendment.actionTakenBy" /></th>
											</tr>
										</thead>
										<tbody>
										 <s:if test="%{amendmentWorkflow.auditLogs.size < 5}">
										     <s:set var="auditloglist" value="(amendmentWorkflow.auditLogs.size)-1"/>
										  </s:if>		
										  <s:else>
										     <s:set var="auditloglist" value="4"/>
										  </s:else>								  
											<s:iterator value="amendmentWorkflow.auditLogs"  begin="0" end="%{auditloglist}">					
												<tr class="spantr2">
													<td><s:date name="auditCreatedDt" format="dd MMM yyyy HH:mm aa zzz"/>
													</td>
													<td><s:property value="oldValue"/>
													</td>
													<td><s:property value="newValue"/>
													</td>
													<td><s:property value="auditCreator"/>
													</td>
												</tr>									
											</s:iterator>
										</tbody>
									</table>
								</div>
							</div>
		
						</div>
					</div>
					<div class="clear"></div>
					   <div class="highlighted">
				    	 <s:submit key="label.request.common.save" cssClass="btn-primary" formid="formid"/>		
							<a href="#" class="btn-tertiary cancel clearEntries" data-toggle="modal" ><s:text name="label.request.common.cancel"></s:text></a>								
						</div><!-- end of form form-mod -->

		           <div class="clear"></div>
				</div>
			</s:form>					
		</div>
		<%@include file="../common/footerSection.jsp"%>
		<jsp:include page="../admin/treasuryAdminExitPopup.jsp" />
	</body>
</html>