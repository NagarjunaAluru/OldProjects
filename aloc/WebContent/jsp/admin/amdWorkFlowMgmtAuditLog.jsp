
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
		 <s:url action="backtoWorkFlowMgmt" namespace="/int/admin" var="backURL" />
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
					<div class="form-mod">
						<h2 id="auditLog" class="section_flip section_blue">
							<a href="javascript:;"><s:text name="label.amendment.auditLog" /><s:property value="amendmentWorkflow.auditLogs.size"/></a></h2><hr class="h2-hr">
						<div id="auditLogPanel" class="section_panel">
						<div class="row">
								<div class="span12">
									<p>
										<s:text name="label.amendment.viewChangesToASingleTransaction" />
										<span class="right"><a href="<s:property value="#backURL" />">back</a></span>
									</p>
								</div>
					     </div>	
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
									<table id="amdWorkFlowFullAuditLogTable" class="table table-striped table-bordered sortable paginate">
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
											<s:iterator value="amendmentWorkflow.auditLogs">
												<tr class="shown">
													<td><s:date name="auditCreatedDt" format="dd MMM yyyy HH:mm aa zzz"/></td>
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
					
		           <div class="clear"></div>
				</div>
			</s:form>
			       <div class="clear"></div>
		</div>
		</body>
		</html>
		<%@include file="../common/footerSection.jsp"%>