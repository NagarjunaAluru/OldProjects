<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="../common/error.jsp" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="security"  uri="hwf-securitytag" %>
<t:common/>
<%
	String servletContextUrl = request.getContextPath();
%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="/WEB-INF/config/tld/attachment" prefix="attachment"%>
<%@ taglib uri="/WEB-INF/config/tld/hwf-desktoptag.tld"
	prefix="wfdesktop"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"  uri="hwf-securitytag" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Search Details</title>
<meta name="description" content="">
<meta name="author" content="">

<%@include file="../common/includeCssScripts.jsp"%>
<meta name="description" content="">
<meta name="author" content="">
<!-- TAB VIEW SCRIPTS -->
<script type="text/javascript">
//Defining the global variable, so this variable can be used by other javascript library included in this JSP 
 var contextURL = '<%=servletContextUrl%>';
</script>
<script src="<%=servletContextUrl%>/js/header-fix.js" type="text/javascript"></script>    
</head>

<body>
	<div class="container main">
		<%@include file="../common/headerSection.jsp"%>
		
		<ul class="breadcrumb">
			<li><a href="${context}/searchResults.do?command=returnToSearchResults">Home</a> <span class="divider">/</span></li>
			<li class="active">Search Details</li>
		</ul>
		<h1 class="page-title span12">Search Details</h1>

		<div class="alert fade in alert-danger hide" 
			style="display: ${empty requestScope.failureMsg ? 'none' : 'block'}">
            <a href="#" data-dismiss="alert" class="close">X</a>
            <strong>${requestScope.failureMsg}</strong> 
        </div>

		<!-- <p class="span12 left clear dashdesc">Your Searched for : &lt;Value&gt;, &lt;Value&gt;, &lt;Value&gt;
			<span class="required-fields"><span>*</span> = Required</span>
		</p> -->
		<form action="/searchResults.do" id="searchResults" name="updateStatusForm">
		<c:set var="transactionCaptureMO" value="No"></c:set>
		<c:forEach items="${sessionScope.deal.actionLogs}" var="actionSection">
			<c:if test="${actionSection.groupName eq 'Requestor' and actionSection.decision eq 'Submit'}">
				<c:set var="reqInitiation" value="${actionSection.actionDt}"></c:set>
			</c:if>
			<c:if test="${actionSection.groupName eq 'Pipeline Review'}">
				<c:set var="plReview" value="${actionSection.actionDt}"></c:set>
			</c:if>
			<c:if test="${actionSection.groupName eq 'S&U_Front Office' and actionSection.decision eq 'Inputs Completed'}">
				<c:set var="soComplete" value="${actionSection.actionDt}"></c:set>
			</c:if>
			<c:if test="${actionSection.groupName eq 'Risk Review'}">
				<c:set var="riskReview" value="${actionSection.actionDt}"></c:set>
			</c:if>
			<c:if test="${(actionSection.groupName eq 'IDAG' and (actionSection.decision eq 'Affirm' or actionSection.decision eq 'Affirm on behalf of IDAG/EAG')) or (actionSection.groupName eq 'TESG' and (actionSection.decision eq 'Affirm with Modifications' or actionSection.decision eq 'Affirm on behalf of TESG' or actionSection.decision eq 'Affirm'))}">
				<c:set var="idageag" value="${actionSection.actionDt}"></c:set>
			</c:if>
			<c:if test="${actionSection.groupName eq 'TC_Middle Office' and actionSection.decision ne 'Assigned To'}">
				<c:set var="transactionCapture" value="${actionSection.actionDt}"></c:set>
			</c:if>
		</c:forEach>
		<c:if test="${sessionScope.deal.WFStageId eq '25'}">
			<c:if test="${empty soComplete and empty riskReview and empty idageag and empty transactionCapture}">
				<c:set var="transactionCaptureMO" value="Yes"></c:set>
			</c:if>
		</c:if>
		<jsp:include page="../common/inc/progreessBar.jsp">
			<jsp:param name="formName" value="searchScreen" />
			<jsp:param name="reqInitiation" value="${reqInitiation}"/>
			<jsp:param name="plReview" value="${plReview}"/>	
			<jsp:param name="soComplete" value="${soComplete}"/>
			<jsp:param name="riskReview" value="${riskReview}"/>
			<jsp:param name="idageag" value="${idageag}"/>
			<jsp:param name="transactionCapture" value="${transactionCapture}"/>
			<jsp:param name="transactionCaptureMO" value="${transactionCaptureMO}"/>
		</jsp:include>
		
			<c:choose>
				<c:when test="${not empty requestScope.isCPA && requestScope.isCPA == true}">
					<jsp:include page="../common/inc/projectSummary.jsp">
				<jsp:param value="cpa" name="page" />
			</jsp:include>
				</c:when>
				<c:otherwise>
					<jsp:include page="../common/inc/projectSummary.jsp">
						<jsp:param value="rca" name="page" />
					</jsp:include>
				</c:otherwise>
			</c:choose>
			
			<!-- Include Transaction Summary And Owner -->			
			<c:choose>
				<c:when test="${not empty requestScope.isCPA && requestScope.isCPA == true}">
					<jsp:include page="../common/inc/transctionSummaryAndOwner.jsp">
						<jsp:param value="cpa" name="page" />
					</jsp:include>
				</c:when>
				<c:otherwise>
					<%@ include file="../common/inc/transctionSummaryAndOwner.jsp"%>
				</c:otherwise>
			</c:choose>
			<!-- Include Transaction Priority And Timing -->	
			 
			<%@ include file="../common/inc/transactionPriorityAndTiming.jsp"%>
			<!-- Include Transaction Leg Summary -->
			<c:choose>
				<c:when test="${not empty requestScope.isCPA && requestScope.isCPA == true}">
					<jsp:include page="../common/inc/cpaRequestDetails.jsp">
						<jsp:param value="searchResults" name="path"/>
					</jsp:include>
					<jsp:include page="../common/inc/cashPoolDetails.jsp" />
				</c:when>
				<c:otherwise>
					<jsp:include page="../common/inc/transactionLegs.jsp">
						<jsp:param value="searchResults" name="path"/>
					</jsp:include>
				</c:otherwise>
			</c:choose>
			<c:set var="nonStandardDocsFlag" value="${deal:getNonStandardDocsFlag(pageContext.request)}" />
			<c:choose>
				<c:when test="${nonStandardDocsFlag eq 'Yes'}">
					<%@ include file="../common/inc/exceptionDetails.jsp"%>
				</c:when>
				<c:otherwise>
				</c:otherwise>
			</c:choose>
			<jsp:include page="../common/inc/viewAdditionalApprovers.jsp">
        		<jsp:param value="Yes" name="searchResult"/>
        	</jsp:include>
			<c:if test="${not empty requestScope.isEquity && requestScope.isEquity == true}">
				<%@ include file="../common/inc/viewBusinessApprovers.jsp"%>
			</c:if>
			<%@ include file="../common/inc/qualitativeAssessment.jsp"%>
		
			<%@ include file="../common/inc/transactionClassificationLevelView.jsp"%>
        
			<%@ include file="../common/inc/dealTeam.jsp"%>
			<!-- Including decision page -->
	 		<jsp:include page="../common/inc/actionLog.jsp">
				<jsp:param name="formName" value="dealRequestForm"/>			
			</jsp:include>
			<div class="form-mod">
			<jsp:include page="../common/inc/commentsLog.jsp">
				<jsp:param name="pageType" value="deal"/>
				<jsp:param value="searchResults" name="path"/>
				<jsp:param value="Search Details" name="name"/>
				<jsp:param value="getSearchDealDetail" name="method"/>	
				<jsp:param value="${param.source}" name="sourcePage"/>
		    	<jsp:param value="${param.section}" name="section"/>			
			</jsp:include>
			</div>
			<c:choose>
				<c:when test="${not empty requestScope.isCPA && requestScope.isCPA == true}">
					<!-- starts uploads-->
				<jsp:include page="/jsp/common/attachments/cpaDealPageAttachments.jsp">
					<jsp:param name="mode" value="edit" />
				</jsp:include> 
				<!-- end uploads -->
				</c:when>
				<c:otherwise>
					<!-- starts uploads-->
					<jsp:include page="/jsp/common/attachments/dealPageAttachments.jsp">
						<jsp:param name="mode" value="edit" />
					</jsp:include> 
					<!-- end uploads -->
				</c:otherwise> 
			</c:choose>	
			<jsp:include page="../common/inc/auditLog.jsp">
				<jsp:param name="pageType" value="deal"/>
				<jsp:param value="searchResults" name="path"/>
				<jsp:param value="Search Details" name="name"/>
				<jsp:param value="getSearchDealDetail" name="method"/>
				<jsp:param value="${param.source}" name="sourcePage"/>
		    	<jsp:param value="${param.section}" name="section"/>				
			</jsp:include>
			<div class="span12 right btn-container">
			<security:hasRoles appName="icfp" domainName="ICFP_AUTH_ACTIONS" domainType="component" compName="AdminActions">
			<a href="${context}/admin/admin.do?command=modifyApprover&DealRequestID=${sessionScope.deal.dealSeqId}&businessID=${sessionScope.deal.businessRequestId}" class="btn right">Modify Approver</a>
			</security:hasRoles>
			<a href="#confirm" class="btn-link cancel right modal-confirm" data-toggle="modal" style="margin-top: 8px;">Cancel</a>			
			</div>
		</form>
		<hr>
	</div>
	<%@include file="../common/footerSection.jsp"%>
	<!-- Modals start -->
	<div class="modal hide fade" id="confirm">
		<div class="modal-header">
			<a class="close" data-dismiss="modal">X</a>
			<h3>Cancel Request</h3>
		</div>
		<div class="modal-body">
			<div class="row">
				<p><b>Are you sure you want to cancel?</b><br>
			Any changes you have made will be lost
			</p>
			</div>
		</div>
		<div class="modal-footer">
			<a href="<%=servletContextUrl%>/searchResults.do?command=returnToSearchResults" class="btn right btn-success">Yes, cancel the request</a>
			<a href="#" class="btn-link right cancel" data-dismiss="modal">No, take me back to the request</a>
		</div>
	</div>
</body>
</html>