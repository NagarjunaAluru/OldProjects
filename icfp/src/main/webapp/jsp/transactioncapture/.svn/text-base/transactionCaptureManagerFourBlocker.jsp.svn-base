<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="../common/error.jsp" %>
<%
	String servletContextUrl = request.getContextPath();
%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="/WEB-INF/config/tld/attachment" prefix="attachment"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>


<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>ICF | Transaction Capture & Closure</title>
<meta name="description" content="">
<meta name="author" content="">
<%@include file="../common/includeCssScripts.jsp" %>
<script src="${pageContext.request.contextPath}/js/transactionCapture.js" type="text/javascript"></script>
<style type="text/css">
	.block { display: block; }
	form#updateStatusForm label.error { display: none; }	
</style>

<script type="text/javascript">
//Defining the global variable, so this variable can be used by other javascript library included in this JSP 
 var contextURL = '<%=servletContextUrl%>';
</script>


<%String legLenforJS ="0";%>
					
<script type="text/javascript">
var legLen = '<%=legLenforJS%>';
</script>

</head>
<script type="text/javascript">
//Defining the global variable, so this variable can be used by other javascript library included in this JSP 
 var contextURL = '<%=servletContextUrl%>';
</script>
<script type="text/javascript" 
src="${pageContext.request.contextPath}/js/transactioncapture/transactionCaptureManagerFourBlocker.js">
</script>
  <body>
	<div class="container main">
		<%@include file="../common/headerSection.jsp" %>
		<html:form styleId = "updateStatusForm" action="/transactionCapture/transactionCaptureManagerFourBlocker.do" method="post" enctype="multipart/form-data">
		
		<ul class="breadcrumb">
			<li><a href="${context}/homePage.do">Home</a> <span class="divider">/</span></li>
			<li class="active">Transaction Capture & Closure</li>
		</ul>
		<div class="alert fade in alert-danger hide" style="display: ${empty requestScope.failureMsg ? 'none' : 'block'}" id="topErrorDiv">
            <a href="#" data-dismiss="alert" class="close">X</a>
            <strong>${requestScope.failureMsg}</strong> 
        </div>
        
        <div class="alert fade in alert-success hide" style="display: ${requestScope.save eq 'success' ? 'block' : 'none'}">
            <a href="#" data-dismiss="alert" class="close">X</a>
            <strong>${requestScope.save}</strong> 
        </div>
        <div class="alert fade in alert-success hide" style="display: ${not empty requestScope.UpdateMessage ? 'block' : 'none'}">
            <a href="#" data-dismiss="alert" class="close">X</a>
            <strong>${requestScope.UpdateMessage}</strong>
        </div>
        <div class="alert fade in alert-danger hide" style="display: ${not empty requestScope.atmtError ? 'block' : 'none'}">
             <a href="#" data-dismiss="alert" class="close">X</a>
             <strong>${requestScope.atmtError}</strong> 
        </div>
        <div class="alert fade in alert-success hide" style="display: ${not empty requestScope.saveMessage ? 'block' : 'none'}">
            <a href="#" data-dismiss="alert" class="close">X</a>
            <strong>${requestScope.saveMessage}</strong> 
        </div>
		<h1 class="page-title span12">Transaction Capture and Closure</h1>
		<p class="span12 left clear dashdesc"><bean:message key="label.fourBlocker.transactionCaptureManager" />
			<a href="#" onclick="javascript:exportToPDF();" class="export"><img src="<%=servletContextUrl%>/img/pdf-ico.png" /></a>
		</p>
		<span class="required-fields"><span>*</span> = Required</span>
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
		</c:forEach>
		<jsp:include page="../common/inc/progreessBar.jsp">
			<jsp:param name="formName" value="transactionCaptureFourBlocker" />
			<jsp:param name="reqInitiation" value="${reqInitiation}"/>
			<jsp:param name="plReview" value="${plReview}"/>	
			<jsp:param name="soComplete" value="${soComplete}"/>
			<jsp:param name="riskReview" value="${riskReview}"/>
			<jsp:param name="idageag" value="${idageag}"/>
		</jsp:include>
		<!-- Include Project Summary -->
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
					<jsp:param name="formName" value="riskFourBlockerForm"/>	
				</jsp:include>
			</c:when>
			<c:otherwise>
				<jsp:include page="../common/inc/transctionSummaryAndOwner.jsp">
					<jsp:param name="formName" value="riskFourBlockerForm"/>	
				</jsp:include>
			</c:otherwise>
		</c:choose>		
			
		<!-- Include Transaction Priority And Timing -->
		<%@include file="../common/inc/transactionPriorityAndTiming.jsp"%>
		
        <!-- Including transaction legs -->
        <c:choose>
			<c:when test="${not empty requestScope.isCPA && requestScope.isCPA == true}">
				<jsp:include page="../common/inc/cpaRequestDetails.jsp">
					<jsp:param value="transactionCaptureManagerFourBlocker" name="path"/>
				</jsp:include>
				<jsp:include page="../common/inc/cashPoolDetails.jsp" />
			</c:when>
			<c:otherwise>
				<jsp:include page="../common/inc/transactionLegs.jsp">
					<jsp:param value="transactionCaptureManagerFourBlocker" name="path"/>
				</jsp:include>
			</c:otherwise>
		</c:choose>
		
		<!-- Including ExceptionDetails -->
		<c:set var="nonStandardDocsFlag" value="${deal:getNonStandardDocsFlag(pageContext.request)}" />
		<c:choose>
			<c:when test="${nonStandardDocsFlag eq 'Yes'}">
				<%@ include file="../common/inc/exceptionDetails.jsp"%>
			</c:when>
			<c:otherwise>
			</c:otherwise>
		</c:choose>
		<%@ include file="../common/inc/viewAdditionalApprovers.jsp"%>
		<c:if test="${not empty requestScope.isEquity && requestScope.isEquity == true}">
			<%@ include file="../common/inc/viewBusinessApprovers.jsp"%>
		</c:if>
		<!-- Including Qualitative Assessment -->
		<jsp:include page="../common/inc/qualitativeAssessment.jsp"></jsp:include>
		<%@ include file="../common/inc/transactionClassificationLevelView.jsp"%>
		<!-- reusing the deal team -->
		<%@include file="../common/inc/dealTeam.jsp"%>

		<div class="form-mod">
			<h2 class="span12 collapsible">Closing Checklist</h2>
			<div class="row">
				<div class="span5">
					<div class="form-row">
						<p><b>Has any change taken place post approvals?</b><br>
							 ${deal:getChangeAfterApprovalFlag(pageContext.request)}
						</p>
					</div>
				</div><!-- end of block -->
			</div>
			<div class="row">
				<div class="span5">
					<div class="form-row">
						<p><b>Are the changes Material or Immaterial? </b><br>
							<c:if test="${empty sessionScope.deal.changeTypeId}">
							--
							</c:if>
							<c:if test="${not empty sessionScope.deal.changeTypeId}">
								<c:if test="${sessionScope.deal.changeTypeId eq 1}">
									Material
								</c:if>
								<c:if test="${sessionScope.deal.changeTypeId eq 2}">
									Immaterial
								</c:if>
							</c:if>
						</p>
					</div>
				</div><!-- end of block -->
			</div>
			

		</div>
		
		<!-- Including decision page -->
 		<jsp:include page="../common/inc/actionLog.jsp">
			<jsp:param name="formName" value="dealRequestForm"/>			
		</jsp:include>
		<div class="form-mod">
			<!-- reusing commentslog jsp -->
			<jsp:include page="../common/inc/commentsLog.jsp">
				<jsp:param name="pageType" value="deal"/>
				<jsp:param value="transactionCapture/transactionCaptureManagerFourBlocker" name="path"/>
		        <jsp:param value="Transaction Capture & Closure" name="name"/>
		        <jsp:param value="load" name="method"/>
		        <jsp:param value="${param.source}" name="sourcePage"/>
		    	<jsp:param value="${param.section}" name="section"/>
			</jsp:include>

			<div class="row comment-container">
					<div class="span5">
						<div class="form-row autosize-container">
							<label>Comments</label>
							<div class="char-count">500</div>
							<textarea class="xlarge autosize messageinput" name="dealComments"	rows="4" id="dealCommentsId" onblur="scriptInjection(this);">${sessionScope.deal.comments}</textarea>
						</div>
					</div>
					<!-- end of block -->
				</div>
		</div>
		<!-- Include Attachemts -->
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
		
		<!--  Including Audid Log page -->
		<jsp:include page="../common/inc/auditLog.jsp">
			<jsp:param name="pageType" value="deal"/>
			<jsp:param value="transactionCapture/transactionCaptureManagerFourBlocker" name="path"/>
		    <jsp:param value="Transaction Capture & Closure" name="name"/>
		    <jsp:param value="load" name="method"/>
		    <jsp:param value="${param.source}" name="sourcePage"/>
		    <jsp:param value="${param.section}" name="section"/>
		</jsp:include>
		
		<!--  <div class="span8 right btn-container">
			<a class="btn right btn-success closeOut" href="#">Approve Override</a>
			<a class="btn right reject-btn" href="#">Reject Override</a>
			<a class="btn-link right cancel" href="#">Cancel</a>
		</div> -->
		
		<div class="span12 right btn-container">
			<div class="span3 right submit-box">
				<div class="form-row">
					<div class="radio-container">
						<label class="radio">
							<input type="radio" value="approveOverride" name="submitAction">
							Approve Override
						</label>
						<label class="radio">
							<input type="radio" class="rejectRequest" value="rejectRequest" name="submitAction">
							Reject Override
						</label>
						<input type="hidden" name="actionId" id="actionID" >
						<input type="hidden" name="forwardPage" id="forwardPageId"> 
						<input type="hidden" name="roleId" value="8">
						<input type="hidden" name="approveReject" id="approveRejectId">
						<input type="hidden" name="ordApprovFlag" id="ordApprovFlag">
						<input type="hidden" name="WFId" value="${param.WFId}">
						<input type="hidden" name="WFStage" value="${param.WFStage}">
						<input type="hidden" name="queueName" value="${param.queueName}">
						<input type="hidden" name="comments" id="commentsID">
						<input type="hidden" name="acctionComments" id="actionCommentsID">
					</div>
				</div>
				<div id="actionButton">
				<a class="btn btn-success btn-large" id="submit" href="#">Submit</a>
				</div>
				</div>
				<div style="float: right;">
				<a class="btn right single" id="saveActionManager" href="javascript:void(0);" style="margin-top: 90px;">Save</a>
				<a href="#confirm" class="btn-link right cancel modal-confirm" data-toggle="modal" style="margin-top: 100px;">Cancel</a>
			</div>
		</div>
		</html:form>
    <hr>
    </div>
	<%@include  file="../common/footerSection.jsp" %>
	<!-- Modals start -->
	
	<!-- Modals start -->
	<div class="modal hide fade" id="confirm">
		<div class="modal-header">
			<a class="close" data-dismiss="modal">X</a>
			<h3>Cancel Request</h3>
		</div>
		<div class="modal-body">
			<div class="row">
				<p>
					<b>Are you sure you want to cancel?</b><br> Any changes you
					have made will be lost
				</p>
			</div>
		</div>
		<div class="modal-footer">
			<a href="<%=servletContextUrl%>/homePage.do"
				class="btn right btn-success">Yes, cancel the request</a> <a
				href="#" class="btn-link right cancel" data-dismiss="modal">No,
				take me back to the request</a>
		</div>
	</div>
	<div class="modal hide fade" id="rejectRequest">
		<div class="modal-header">
			<a class="close" data-dismiss="modal">X</a>
			<h3>Reject this Override</h3>
		</div>
		<div class="modal-body">
			
			<div class="row">
				<div class="span5"><p>Are you certain you want to reject this override?</p>
				</div>
				<div class="span5">
					<div class="form-row autosize-container">
						<span class="required">*</span>
						<label>Comments</label>
						<div class="char-count">500</div>
						<textarea class="xlarge autosize messageinput" name="textarea2" rows="1" onblur="scriptInjection(this);"></textarea>
						<span class="req-error" id="roCommentsError">error</span>
					</div>
				</div> <!-- end of block -->
			
			</div>
		</div>
		<div class="modal-footer">
			<a href="#" class="btn right btn-success" data-dismiss="modal">Reject this override</a>
			<a href="#" class="btn-link right cancel" data-dismiss="modal">Close window</a>
		</div>
	</div>
	
	<div class="modal hide fade" id="approveOverride">
		<div class="modal-header">
			<a class="close" data-dismiss="modal">X</a>
			<h3>Approve Override</h3>
		</div>
		<div class="modal-body">
			
			<div class="row">
				<div class="span5"><p>Are you certain you want to send this approve this override?
</p>
				</div>
				
			</div>
		</div>
		<div class="modal-footer">
			<a href="#" class="btn right btn-success" data-dismiss="modal">Approve this override</a>
			<a href="#" class="btn-link right cancel" data-dismiss="modal">Close window</a>
		</div>
	</div>
  </body>
</html>

