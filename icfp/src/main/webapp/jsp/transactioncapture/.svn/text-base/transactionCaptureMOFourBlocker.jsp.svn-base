<%@ page errorPage="../common/error.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>
<t:common/>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>ICF | Transaction Capture & Closure</title>
    <meta name="description" content="">
    <meta name="author" content="">
<%
	String servletContextUrl = request.getContextPath();
%>

	<%@include file="../common/includeCssScripts.jsp" %>	
	<script src="${pageContext.request.contextPath}/js/transactionCapture.js" type="text/javascript"></script>
	
	<script type="text/javascript">
	//Defining the global variable, so this variable can be used by other javascript library included in this JSP 
 var contextURL = '<%=servletContextUrl%>';
	</script>
	
		
		
	
	
	
	<%
		String legLenforJS = "0";
	%>
					
	<script type="text/javascript">
	var legLen = '<%=legLenforJS%>';
	</script>

  </head>

  <body>
	<div class="container main">
	
		
		<%@include file="../common/headerSection.jsp" %>
		
		<ul class="breadcrumb">
			<li><a href="${context}/homePage.do">Home</a> <span class="divider">/</span></li>
			<li class="active">Transaction Capture & Closure</li>
		</ul>
		<div class="alert fade in alert-danger hide" style="display: ${empty requestScope.failureMsg ? 'none' : 'block'}" id="topErrorDiv">
            <a href="#" data-dismiss="alert" class="close">X</a>
            <strong>${requestScope.failureMsg}</strong> 
        </div>
        
        <div class="alert fade in alert-success hide" style="display: ${not empty requestScope.saveMessage ? 'block' : 'none'}">
            <a href="#" data-dismiss="alert" class="close">X</a>
            <strong>${requestScope.saveMessage}</strong> 
        </div>
        <div class="alert fade in alert-success hide" style="display: ${not empty requestScope.UpdateMessage ? 'block' : 'none'}">
            <a href="#" data-dismiss="alert" class="close">X</a>
            <strong>${requestScope.UpdateMessage}</strong> 
        </div>
        
		<h1 class="page-title span12">Transaction Capture and Closure</h1>
		<p class="span12 left clear dashdesc">
		<a href="#" onclick="javascript:exportToPDF();" class="export"><img src="<%=servletContextUrl%>/img/pdf-ico.png" /></a>
		</p>
		<span class="required-fields"><span>*</span> = Required</span>
		
		<html:form styleId = "updateStatusForm" action="/transactionCapture/transactionCaptureMOFourBlocker.do" method="post" enctype="multipart/form-data">
		
	
	
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
			
		<%@include file="../common/inc/transactionPriorityAndTiming.jsp"%>
		
		 <!-- Including transaction legs -->
        <c:choose>
			<c:when test="${not empty requestScope.isCPA && requestScope.isCPA == true}">
				<jsp:include page="../common/inc/cpaRequestDetails.jsp">
					<jsp:param value="transactionCaptureMOFourBlocker" name="path"/>
				</jsp:include>
				<jsp:include page="../common/inc/cashPoolDetails.jsp" />
			</c:when>
			<c:otherwise>
				<jsp:include page="../common/inc/transactionLegs.jsp">
					<jsp:param value="transactionCaptureMOFourBlocker" name="path"/>
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
		<jsp:include page="../common/inc/qualitativeAssessment.jsp" />
		<%@ include file="../common/inc/transactionClassificationLevelView.jsp"%>
		<%@include file="../common/inc/dealTeam.jsp"%>
		<jsp:include page="../common/inc/actionLog.jsp"/>
		<%@include file="../common/inc/closingChecklistView.jsp"%>
		<div class="form-mod">
			<!-- reusing commentslog jsp -->
			<jsp:include page="../common/inc/commentsLog.jsp">
				<jsp:param name="pageType" value="deal"/>
				<jsp:param value="transactionCapture/transactionCaptureMOFourBlocker" name="path"/>
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
		<jsp:include page="../common/inc/auditLog.jsp">
			<jsp:param name="pageType" value="deal"/>
			<jsp:param value="transactionCapture/transactionCaptureMOFourBlocker" name="path"/>
			<jsp:param value="Transaction Capture & Closure" name="name"/>
			<jsp:param value="load" name="method"/>
			<jsp:param value="${param.source}" name="sourcePage"/>
			<jsp:param value="${param.section}" name="section"/>	
		</jsp:include>
		
		<div class="span12 right btn-container">
			<div class="span3 right submit-box">
				<div class="form-row">
					<div class="radio-container">
					<c:set var="isPreviousOverride" value="No"/>
						<c:forEach items="${sessionScope.deal.actionLogs}" var="actionSection">

						<c:if test="${actionSection.decision eq 'ApproveOverride'}">
						<c:set var="isPreviousOverride" value="Yes"/>
						</c:if>
						</c:forEach>
						<label class="radio">
							<input type="radio" value="moCloseOut" name="submitAction">
							Close out request
						</label>
						<c:if test="${isPreviousOverride eq 'No'}">
						<label class="radio">
							<input type="radio" class="sendback" value="sendBack" name="submitAction">
							Send Back
						</label>
						</c:if>
						<input type="hidden" name="actionId" id="actionID" >
						<input type="hidden" name="forwardPage" id="forwardPageId"> 
						<input type="hidden" name="roleId" value="5">
						<input type="hidden" name="WFId" value="${param.WFId}">
						<input type="hidden" name="WFStage" value="${param.WFStage}">
						<input type="hidden" name="queueName" value="${param.queueName}">
						<input type="hidden" name="comments" id="commentsID">
						<input type="hidden" name="acctionComments" id="actionCommentsID">
						<input type="hidden" name="validateVaultRequest" value="${requestScope.validateVaultRequest}" >
					</div>
				</div>
				<div id="actionButton">
				<a class="btn btn-success btn-large" id="submit" href="#">Submit</a>
				</div>
				</div>
				<div style="float: right;">
				<a class="btn right single" id="saveActionMO" href="javascript:void(0);" style="margin-top: 90px;">Save</a>
				<a href="#confirm" class="btn-link right cancel modal-confirm" data-toggle="modal" style="margin-top: 100px;">Cancel</a>
			</div>
		</div>
		</html:form>
    <hr>
    </div>
	<%@include  file="../common/footerSection.jsp" %>
	
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

	<div class="modal hide fade" id="closeOut">
		<div class="modal-header">
			<a class="close" data-dismiss="modal">X</a>
			<h3>Close Out</h3>
		</div>
		<div class="modal-body">
			
			<div class="row">
				<div class="span5"><p>Are you sure you want to close this request?
</p>
				</div>
				
			</div>
		</div>
		<div class="modal-footer">
			<a href="#derivatives-table" class="btn right btn-success" data-dismiss="modal">Close out this request</a>
			<a href="#" class="btn-link right cancel" data-dismiss="modal">Close window</a>
		</div>
	</div>
	
	<!-- Send Back Modal -->
	<div class="modal hide fade" id="sendback">
		<div class="modal-header">
			<a class="close" data-dismiss="modal">X</a>
			<h3>Send Back</h3>
		</div>
		<div class="override-modal-body">
			
			<div class="row">
				<div class="span5"><p>Are you certain you want to send this request back to IDAG/Pipeline for re-approval?</p>
				</div>
				<div class="span5">
					<div class="form-row autosize-container">
						<span class="required">*</span>
						<label>Comments</label>
						<div class="char-count">500</div>
						<textarea class="xlarge autosize messageinput" name="textarea2" rows="1" onblur="scriptInjection(this);"></textarea>
						<span class="req-error" id="sbCommentsError">error</span>
					</div>
				</div> <!-- end of block -->
			
			</div>
		</div>
		<div class="modal-footer">
			<a href="#derivatives-table" class="btn right btn-success" data-dismiss="modal">Send Back</a>
			<a href="#" class="btn-link right cancel" data-dismiss="modal">Close window</a>
		</div>
	</div>
  </body>
</html>

