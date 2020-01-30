<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page autoFlush="true" %>
<%@ page errorPage="../common/error.jsp" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:common></t:common>
<% String servletContextUrl = request.getContextPath();  %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<%@ taglib prefix="security"  uri="hwf-securitytag" %>
<fmt:setLocale value="en-US"/>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>ICFP | Inbox Page</title>
    <meta name="description" content="">
    <meta name="author" content="">
<%@include file="../common/includeCssScripts.jsp" %>
<script type="text/javascript" >
//Defining the global variable, so this variable can be used by other javascript library included in this JSP 
 var contextURL = '<%=servletContextUrl%>';
</script>
<script src="<%=servletContextUrl%>/js/inbox.js" type="text/javascript"></script>
<script src="<%=servletContextUrl%>/js/header-fix.js" type="text/javascript"></script>
</head>
<body>
<div class="container main">
<%@include file="../common/headerSection.jsp" %>
<ul class="breadcrumb">
	<li><a href="${context}/homePage.do">Home</a> <span class="divider">/</span></li>
	<li class="active">Dashboard</li>
	
</ul>
 <div id="deleteDealFlag" style="display:none;" class="alert fade in alert-danger hide">
 	<a href="#" data-dismiss="alert" class="close">X</a>
 	<strong>Please select at least One deal to Delete</strong> 
 </div>       
 <div class="alert fade in alert-success hide" style="display: ${empty requestScope.UpdateMessage ? 'none' : 'block'}">
            <a href="#" data-dismiss="alert" class="close">X</a>
            <strong>${requestScope.UpdateMessage}</strong> 
 </div>
 <div class="alert fade in alert-danger hide" style="display: ${not empty requestScope.atmtError ? 'block' : 'none'}">
             <a href="#" data-dismiss="alert" class="close">X</a>
             <strong>${requestScope.atmtError}</strong> 
  </div>
<h1 class="page-title span12 collapsible">Welcome to Intercompany Finance <a class="right">Hide this</a></h1>
<div class="clear"></div>
<div class="row">
<div class="span12">
<p class="span12 left clear dashdesc">
This site is used for creating and tracking intercompany new financing and new event requests. Saved drafts and submitted requests appear in the Dashboard below.
</p>
</div>
</div>
<c:set var="dealCategoriesMap" value="${deal:getAllDealCategories(pageContext.request)}" />
<c:set var="wfStageDescMap" value="${deal:getWorkflowStageDescMap(pageContext.request)}" />
<c:set var="dateFormat" value="${deal:getDateFormat('MMM dd, yyyy')}" />

<html:form action="/inbox.do" styleId="inboxForm">
<html:hidden name="inboxForm" property="type" styleId="typeId"/>
<html:hidden name="inboxForm" property="deleteRequestList" styleId="deleteRequestListId"/>

<div class="form-mod">
	<h2 class="span12">My Dashboard 
	<security:hasRoles appName="icfp" domainName="ICFP_AUTH_ACTIONS" domainType="component" compName="NotManageDelegateActions">
	<a class="btn" href="${context}/manageDelegation.do?command=openManageDelegations">Manage my delegations</a>
	</security:hasRoles>
	</h2>
	
	<ul class="nav nav-tabs tabs">
		<li class="active"><a data-toggle="tab" href="#1" id="myTask">My Tasks : ${fn:length(sessionScope.taskData.workItems)}</a></li>
		<%-- <security:hasRoles appName="icfp" domainName="ICFP_AUTH_ACTIONS" domainType="component" compName="AssignReviewer"> --%>
			<li><a data-toggle="tab" href="#2" id="unassignedTask">Group Tasks : ${not empty sessionScope.MyUnassignedTaskCount ? sessionScope.MyUnassignedTaskCount: '0'}</a></li>
		<%-- </security:hasRoles> --%>
		<li><a data-toggle="tab" href="#3" id="myRequest">My Requests : ${not empty sessionScope.MyRequestCount ? sessionScope.MyRequestCount: '0'}</a></li>
		<li><a data-toggle="tab" href="#4" id="closedRequest">Closed Requests : ${not empty sessionScope.MyCloseCount ? sessionScope.MyCloseCount : '0'}</a></li>
		<li><a data-toggle="tab" href="#5" id="draftRequest">Draft Requests : ${not empty sessionScope.MyDraftCount ? sessionScope.MyDraftCount : '0'}</a></li>
	</ul>
	
	<div class="tab-content" id="myTabContent" style="overflow:visible;padding-left:0px;">
		<div id="1" class="tab-pane fade active in">
			<c:if test="${empty sessionScope.taskData.workItems}">
				<p>You Currently have no tasks.</p>
			</c:if>
			<c:set var="requestorShown" value="false"/>
			<security:hasRoles appName="icfp" domainName="ICFP_AUTH_ACTIONS" domainType="component" compName="CreateRequestActions">
						<c:set var="requestorShown" value="true"/>
			</security:hasRoles>
			<c:if test="${not empty sessionScope.taskData.workItems and (empty param.type or param.type eq 'MYTASKS')}">
			<div class="row">
			<div class="span12 pipeline-management-tables">
			<table id="taskData" class="table table-striped table-bordered sortable active paginate flyout">
				<thead>
					<tr>
						<th rowspan="2">Request Date</th>
						<th rowspan="2">Deal ID</th>
						<th rowspan="2">Deal Name</th>
						<th rowspan="2">Deal Category</th>
						<th rowspan="2">Event</th>
						<th colspan="2" class="nosort">(USD Equivalent)</th>
						<th rowspan="2">Transaction Owner</th>
						<th rowspan="2">Value Date</th>
						<th rowspan="2">Days Remaining</th>
						<th rowspan="2">Priority</th>
						<th rowspan="2">Work Flow State</th>
						<th rowspan="2">Deal Status</th>
						<th rowspan="2">Clone</th>
					</tr>
					<tr>
						<th>Debt Value</th>
						<th>Equity Value</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach var="taskData" items="${sessionScope.taskData.workItems}">
					<tr>
						<td><div style="width:65px;overflow:auto">
						<c:if test="${empty taskData.dateCreated}">
							-
						</c:if>
						<c:if test="${not empty taskData.dateCreated}">
							${taskData.dateCreated}
						</c:if>
					</div>
						</td>
						<td><div style="width:65px;overflow:auto">
					<c:choose>
					<c:when test="${taskData.currentStage eq 'PLERIVEW'}">
					<a href="${context}/pipelineReview/pipelineReviewDeal.do?command=getPipelineReviewDealDetail&DealRequestID=${ taskData.dealSeqID }&section=myTasks&source=dashboard" >
						${taskData.businessRequestID}</a>
					</c:when>
					<c:otherwise>
						<a href="${context}/<t:getActionPath stage="${taskData.currentStage}"></t:getActionPath>.do?command=load&DealRequestID=${ taskData.dealSeqID }&section=myTasks" >
						${taskData.businessRequestID}</a>
				   </c:otherwise>
				   </c:choose>
						</div></td>
						<td style="word-wrap:break-word;"><div style="width:150px;overflow:auto">${taskData.dealName}</div></td>
						<td>${dealCategoriesMap[taskData.dealCategory]}</td>
						<td style="word-wrap:break-word;"><div style="width:100px;overflow:auto">
							<c:if test="${not empty taskData.event}">
								${taskData.event}
							</c:if>
							<c:if test="${empty taskData.event}">
								${taskData.event}
							</c:if>
						</div></td>
						<td><fmt:formatNumber type="number" maxFractionDigits="3" value="${taskData.debtValue}" /></td>
						<td><fmt:formatNumber type="number" maxFractionDigits="3" value="${taskData.equityValue}" /></td>
						<td style="word-wrap:break-word;">
							<div style="width:65px;overflow:auto">${taskData.transactionOwner}</div>
						</td>
						<td>
						<c:if test="${empty taskData.valueDate}">
							-
						</c:if>
						<c:if test="${not empty taskData.valueDate}">
							${deal:formatDate(taskData.valueDate, dateFormat)}
						</c:if>
						</td>
						<td>${taskData.numberOfDaysRem}</td>
						<td>${taskData.priority}</td>
						<td style="word-wrap:break-word;"><div style="width:80px;overflow:auto">${wfStageDescMap[taskData.currentStage]}</div></td>
						<td>${taskData.dealStatus}</td>
						<td>
						<c:if test="${requestorShown}" >
						<a href="${context}/fundingRequest/newFundingRequestView.do?command=cloneDeal&dealRequestID=${ taskData.dealSeqID }" ><img src="${context}/img/clone.png" height="15" width="15"/></a>
						</c:if>
						<c:if test="${not requestorShown}" >
							-
						</c:if>
						</td>
						
					</tr>
					</c:forEach>
				</tbody>
			</table>
			</div>
			</div>
			</c:if>
		</div>

		<div id="2" class="tab-pane fade in">
		<c:if test="${empty sessionScope.assignData.workItems}">
			<p>You Currently have no completed tasks.</p>
		</c:if>
		<c:if test="${param.type eq 'MYASSIGNEDTASKS' and not empty sessionScope.assignData.workItems}">
		<div class="row">
		<div class="span12 pipeline-management-tables">
		<table id="assignedTask" class="table table-striped table-bordered sortable paginate active">
			<thead>
				<tr>
					<th rowspan="2">Request Date</th>
					<th rowspan="2">Deal ID</th>
					<th rowspan="2">Deal Name</th>
					<th rowspan="2">Deal Category</th>
					<th rowspan="2">Event</th>
					<th colspan="2" class="nosort">(USD Equivalent)</th>
					<th rowspan="2">Transaction Owner</th>
					<th rowspan="2">Value Date</th>
					<th rowspan="2">Days Remaining</th>
					<th rowspan="2">Priority</th>
					<th rowspan="2">Work Flow State</th>
					<th rowspan="2">Deal Status</th>
					<th rowspan="2">Assigned Name</th> 
					<th rowspan="2">Clone</th>
				</tr>
				<tr>
					<th>Debt Value</th>
					<th>Equity Value</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="assignedData" items="${ sessionScope.assignData.workItems }">
				<tr>
					<td><div style="width:65px;overflow:auto">
					<c:if test="${empty assignedData.dateCreated}">
						--
					</c:if>
					<c:if test="${not empty assignedData.dateCreated}">
						${assignedData.dateCreated}
					</c:if></div>
					</td>
					<td><div style="width:65px;overflow:auto">
					<c:choose>
					<c:when test="${assignedData.currentStage eq 'PLERIVEW'}">
					<a href="${context}/pipelineReview/pipelineReviewDeal.do?command=getPipelineReviewDealDetail&DealRequestID=${ assignedData.dealSeqID }&section=myTasks&source=dashboard" >
						${assignedData.businessRequestID}</a>
					</c:when>
					<c:otherwise>
						<a href="${context}/<t:getActionPath stage="${assignedData.currentStage}"></t:getActionPath>.do?command=load&DealRequestID=${ assignedData.dealSeqID }&section=myAssignedTasks" >
					${ assignedData.businessRequestID }</a>
				   </c:otherwise>
				   </c:choose>
				   </div></td>
				   <td style="word-wrap:break-word;">
				   	<div style="width:150px;overflow:auto">${assignedData.dealName}</div>
				   </td>
					<td>${dealCategoriesMap[assignedData.dealCategory]}</td>
					<td>
						<c:if test="${not empty assignedData.event}">
							${assignedData.event}
						</c:if>
						<c:if test="${empty assignedData.event}">
							${assignedData.event}
						</c:if>
					</td>
					<td><fmt:formatNumber type="number" maxFractionDigits="3" value="${assignedData.debtValue}" /></td>
					<td><fmt:formatNumber type="number" maxFractionDigits="3" value="${assignedData.equityValue}" /></td>
					<td style="word-wrap:break-word;">
						<div style="width:65px;overflow:auto">
							${assignedData.transactionOwner}
						</div>
					</td>
					<td><div style="width:65px;overflow:auto">
					<c:if test="${empty assignedData.valueDate}">
						--
					</c:if>
					<c:if test="${not empty assignedData.valueDate}">
						${deal:formatDate(assignedData.valueDate, dateFormat)}
					</c:if></div>
					</td>
					<td>${assignedData.numberOfDaysRem}</td>
					<td>${assignedData.priority}</td>
					<td style="word-wrap:break-word;">
						<div style="width:50px;overflow:auto">
							${wfStageDescMap[assignedData.currentStage]}
						</div>
					</td>
					<td>${assignedData.dealStatus}</td>
					<td style="word-wrap:break-word;">
						<div style="width:50px;overflow:auto">
							${deal:getAssigned(assignedData)}
						</div>
					</td>
					<td>
					<c:if test="${requestorShown}" >
						<a href="${context}/fundingRequest/newFundingRequestView.do?command=cloneDeal&dealRequestID=${ assignedData.dealSeqID }" ><img src="${context}/img/clone.png" height="15" width="15"/></a>
					</c:if>
					<c:if test="${not requestorShown}" >
							-
					</c:if>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		</div>
		</div>
		</c:if>
		</div>
		
		<div id="3" class="tab-pane fade in">
			<c:if test="${empty sessionScope.myRequestData.workItems}">
				<p>You Currently have no requests.</p>
			</c:if>
			<c:if test="${not empty sessionScope.myRequestData.workItems}">
			<div class="row">
			<div class="span12 pipeline-management-tables">
			<table id="myRequestData" class="table table-striped table-bordered sortable paginate flyout">
				<thead>
					<tr>
						<th rowspan="2">Request Date</th>
						<th rowspan="2">Deal ID</th>
						<th rowspan="2">Deal Name</th>
						<th rowspan="2">Deal Category</th>
						<th rowspan="2">Event</th>
						<th colspan="2" class="nosort">(USD Equivalent)</th>
						<th rowspan="2">Transaction Owner</th>
						<th rowspan="2">Value Date</th>
						<th rowspan="2">Days Remaining</th>
						<th rowspan="2">Priority</th>
						<th rowspan="2">Work Flow State</th>
						<th rowspan="2">Deal Status</th>
						<th rowspan="2">Clone</th>
					</tr>
					<tr>
						<th>Debt Value</th>
						<th>Equity Value</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="myRequestData" items="${sessionScope.myRequestData.workItems}">
					<tr>
						<td><div style="width:65px;overflow:auto">
						<c:if test="${empty myRequestData.dateCreated}">
							--
						</c:if>
						<c:if test="${not empty myRequestData.dateCreated}">
							${myRequestData.dateCreated}
						</c:if></div>
						</td>
						<td><div style="width:65px;overflow:auto">
						<a href="${context}/fundingRequest/newFundingRequest.do?command=load&DealRequestID=${ myRequestData.dealSeqID }&section=myRequests" >
						${myRequestData.businessRequestID}</a>
						</div></td>
						<td style="word-wrap:break-word;"><div style="width:150px;overflow:auto">${myRequestData.dealName}</div></td>
						<td>${dealCategoriesMap[myRequestData.dealCategory]}</td>
						<td>
							<c:if test="${not empty myRequestData.event}">
								${myRequestData.event}
							</c:if>
							<c:if test="${empty myRequestData.event}">
								-
							</c:if>
						</td>
						<td><fmt:formatNumber type="number" maxFractionDigits="3" value="${myRequestData.debtValue}" /></td>
						<td><fmt:formatNumber type="number" maxFractionDigits="3" value="${myRequestData.equityValue}" /></td>
						<td style="word-wrap:break-word;">
							<div style="width:65px;overflow:auto">
								${myRequestData.transactionOwner}
							</div>
						</td>
						<td><div style="width:65px;overflow:auto">
						<c:if test="${empty myRequestData.valueDate}">
							--
						</c:if>
						<c:if test="${not empty myRequestData.valueDate}">
							${deal:formatDate(myRequestData.valueDate, dateFormat)}
						</c:if></div>
						</td>
						<td>${myRequestData.numberOfDaysRem}</td>
						<td>${myRequestData.priority}</td>
						<td style="word-wrap:break-word;">
							<div style="width:80px;overflow:auto">
								${wfStageDescMap[myRequestData.currentStage]}
							</div>
						</td>
						<td>${myRequestData.dealStatus}</td>
						<td>
						<c:if test="${requestorShown}" >
						<a href="${context}/fundingRequest/newFundingRequestView.do?command=cloneDeal&dealRequestID=${ myRequestData.dealSeqID }" ><img src="${context}/img/clone.png" height="15" width="15"/></a>
						</c:if>
						<c:if test="${not requestorShown}" >
							-
						</c:if>
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			</div>
			</div>

			</c:if>
		</div>
		<div id="4" class="tab-pane fade in">
			<c:if test="${empty sessionScope.myCloseData.workItems}">
				<p>You Currently have no closed requests.</p>
			</c:if>
			<c:if test="${not empty sessionScope.myCloseData.workItems}">
			<div class="row">
			<div class="span12 pipeline-management-tables">
			<table id="myCloseData" class="table table-striped table-bordered sortable paginate flyout">
				<thead>
					<tr>
						<th rowspan="2">Request Date</th>
						<th rowspan="2">Deal ID</th>
						<th rowspan="2">Deal Name</th>
						<th rowspan="2">Deal Category</th>
						<th rowspan="2">Event</th>
						<th colspan="2" class="nosort">(USD Equivalent)</th>
						<th rowspan="2">Transaction Owner</th>
						<th rowspan="2">Value Date</th>
						<th rowspan="2">Days Remaining</th>
						<th rowspan="2">Priority</th>
						<th rowspan="2">Work Flow State</th>
						<th rowspan="2">Deal Status</th>
						<th rowspan="2">Clone</th>
					</tr>
					<tr>
						<th>Debt Value</th>
						<th>Equity Value</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="myCloseData" items="${sessionScope.myCloseData.workItems}">
					<tr>
						<td><div style="width:65px;overflow:auto">
						<c:if test="${empty myCloseData.dateCreated}">
							--
						</c:if>
						<c:if test="${not empty myCloseData.dateCreated}">
							${myCloseData.dateCreated}
						</c:if></div>
						</td>
						<td><div style="width:65px;overflow:auto">
						<a href="${context}/fundingRequest/newFundingRequest.do?command=load&DealRequestID=${ myCloseData.dealSeqID }&section=myRequests" >
						${myCloseData.businessRequestID}</a>
						</div></td>
						<td style="word-wrap:break-word;"><div style="width:150px;overflow:auto">${myCloseData.dealName}</div></td>
						<td>${dealCategoriesMap[myCloseData.dealCategory]}</td>
						<td>
							<c:if test="${not empty myCloseData.event}">
								${myCloseData.event}
							</c:if>
							<c:if test="${empty myCloseData.event}">
								-
							</c:if>
						</td>
						<td><fmt:formatNumber type="number" maxFractionDigits="3" value="${myCloseData.debtValue}" /></td>
						<td><fmt:formatNumber type="number" maxFractionDigits="3" value="${myCloseData.equityValue}" /></td>
						<td style="word-wrap:break-word;">
							<div style="width:80px;overflow:auto">
								${myCloseData.transactionOwner}
							</div>
						</td>
						<td><div style="width:65px;overflow:auto">
						<c:if test="${empty myCloseData.valueDate}">
							--
						</c:if>
						<c:if test="${not empty myCloseData.valueDate}">
							${deal:formatDate(myCloseData.valueDate, dateFormat)}
						</c:if></div>
						</td>
						<td>${myCloseData.numberOfDaysRem}</td>
						<td>${myCloseData.priority}</td>
						<td style="word-wrap:break-word;">
							<div style="width:80px;overflow:auto">
								${wfStageDescMap[myCloseData.currentStage]}
							</div>
						</td>
						<td>${myCloseData.dealStatus}</td>
						<td>
						<c:if test="${requestorShown}" >
						<a href="${context}/fundingRequest/newFundingRequestView.do?command=cloneDeal&dealRequestID=${ myCloseData.dealSeqID }" ><img src="${context}/img/clone.png" height="15" width="15"/></a>
						</c:if>
						<c:if test="${not requestorShown}" >
							-
						</c:if>
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			</div>
			</div>
			</c:if>
		</div>
		<div id="5" class="tab-pane fade in">
			<c:if test="${empty sessionScope.myDraftData.workItems}">
				<p>You Currently have no draft requests.</p>
			</c:if>
			<c:if test="${not empty sessionScope.myDraftData.workItems}">
			<div class="row">
			<div class="span12 pipeline-management-tables">
			<table id="myDraftData" class="table table-striped table-bordered sortable paginate flyout active">
				<thead>
					<tr>
						<td rowspan="2" class="nosort" style="text-align: center; vertical-align: bottom; width:20px">
						<label class="checkbox apply-to-all" >
							<input type="checkbox" class="check-all-draft" id="optionsCheckbox" value="option1">
						</label>
						</td>
						<th rowspan="2">Date Saved</th>
						<th rowspan="2">Deal ID</th>
						<th rowspan="2">Deal Name</th>
						<th rowspan="2">Deal Category</th>
						<th rowspan="2">Event</th>
						<th colspan="2" class="nosort">(USD Equivalent)</th>
						<th rowspan="2">Transaction Owner</th>
						<th rowspan="2">Value Date</th>
						<th rowspan="2">Days Remaining</th>
						<th rowspan="2">Priority</th>
						<th rowspan="2">Work Flow State</th>
						<th rowspan="2">Deal Status</th>
						<th rowspan="2">Clone</th>
					</tr>
					<tr>
						<th>Debt Value</th>
						<th>Equity Value</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="myDraftData" items="${sessionScope.myDraftData.workItems}">
					<tr>
						<td>
						<input type="checkbox" value="${myDraftData.dealSeqID}" name="deleteRequest">
						</td>
						<td><div style="width:65px;overflow:auto">
						<c:if test="${empty myDraftData.dateCreated}">
							--
						</c:if>
						<c:if test="${not empty myDraftData.dateCreated}">
							${myDraftData.dateCreated}
						</c:if></div>
						</td>
						<td><div style="width:65px;overflow:auto">
						<a href="${context}/fundingRequest/newFundingRequest.do?command=load&DealRequestID=${ myDraftData.dealSeqID }&section=myRequests" >
						${myDraftData.businessRequestID}</a>
						</div></td>
						<td style="word-wrap:break-word;"><div style="width:150px;overflow:auto">${myDraftData.dealName}</div></td>
						<td>${dealCategoriesMap[myDraftData.dealCategory]}</td>
						<td>
							<c:if test="${not empty myDraftData.event}">
								${myDraftData.event}
							</c:if>
							<c:if test="${empty myDraftData.event}">
								-
							</c:if>
						</td>
						<td><fmt:formatNumber type="number" maxFractionDigits="3" value="${myDraftData.debtValue}" /></td>
						<td><fmt:formatNumber type="number" maxFractionDigits="3" value="${myDraftData.equityValue}" /></td>
						<td style="word-wrap:break-word;">
							<div style="width:65px;overflow:auto">
							${myDraftData.transactionOwner}
							</div>
						</td>
						<td><div style="width:65px;overflow:auto">
						<c:if test="${empty myDraftData.valueDate}">
							--
						</c:if>
						<c:if test="${not empty myDraftData.valueDate}">
							${deal:formatDate(myDraftData.valueDate, dateFormat)}
						</c:if></div>
						</td>
						<td>${myDraftData.numberOfDaysRem}</td>
						<td>${myDraftData.priority}</td>
						<td style="word-wrap:break-word;">
							<div style="width:65px;overflow:auto">
								${wfStageDescMap[myDraftData.currentStage]}
							</div>
						</td>
						<td>${myDraftData.dealStatus}</td>
						<td>
						<c:if test="${requestorShown}" >
						<a href="${context}/fundingRequest/newFundingRequestView.do?command=cloneDeal&dealRequestID=${ myDraftData.dealSeqID }" ><img src="${context}/img/clone.png" height="15" width="15"/></a>
						</c:if>
						<c:if test="${not requestorShown}" >
							-
						</c:if>
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			</div>
			</div>
			</c:if>
		</div>
		<div class="row">
			<c:if test="${param.type eq 'MYDRAFT'}">
				<div class="span3 jump-page">
					<a class="btn" href="javascript:void(0);" onclick="javascript:deleteDeal();">Delete Selected Requests</a>
				</div>
				<div class="span6 pagination pagination-right" style="margin-left: -50px;">
     				<ul></ul>
     			</div>
        		<div class="span2 jump-page">
	     		Jump to
	    		<input type="text" class="span1 manual">
				<a class="btn jumpto" type="submit">Go</a>
				</div>				
			</c:if>
			<c:if test="${param.type ne 'MYDRAFT'}">

  			<div class="span8 pagination pagination-right">
     			<ul></ul>
     		</div>
     		<div class="span3 jump-page">
        		Jump to <input type="text" class="span1 manual">        		
        		<a class="btn jumpto" type="submit">Go</a>
        	</div>
        	
			</c:if>
			<div class="jump-page">	
				<select class="span1 pagination-rows">				
					<option value="10">10</option>					
					<option value="20">20</option>
					<option value="30">30</option>
					<option value="40">40</option>					
					<option value="50" selected="selected">50</option>
				</select>
			</div>
		
		<input type='hidden' id='current_page' />	
	</div>
</div>
</div>
</html:form>

<script src="${pageContext.request.contextPath}/js/pagination.js"></script>
</div>
<%@include file="../common/footerSection.jsp" %>
</body>
</html>