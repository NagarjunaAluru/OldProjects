<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="../common/error.jsp" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
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

<%@ taglib prefix="security" uri="hwf-securitytag" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>ICF | Cash Management</title>
<meta name="description" content="">
<meta name="author" content="">
<%@include file="../common/includeCssScripts.jsp" %>	
<script src="${pageContext.request.contextPath}/js/cashmanagement.js" type="text/javascript"></script>

<script type="text/javascript">
//Defining the global variable, so this variable can be used by other javascript library included in this JSP 
 var contextURL = '<%=servletContextUrl%>';
</script>

<%String legLenforJS ="0";%>
					
<script type="text/javascript">
var legLen = '<%=legLenforJS%>';
</script>
</head>
<body>
	<div class="container main">
		<%@include file="../common/headerSection.jsp" %>
		
		<c:choose>
			<c:when test="${not empty requestScope.isCPA && requestScope.isCPA == true}">
				<input type="hidden" name="isCPA" id="isCPA" value="yes" />
				
			</c:when>
			<c:otherwise>
				<input type="hidden" name="isCPA" id="isCPA" value="no" />
			</c:otherwise>
		</c:choose>
		<ul class="breadcrumb">
			<li><a href="${context}/homePage.do">Home</a> <span class="divider">/</span></li>
			<li class="active">Cash Management</li>
		</ul>
		
		<div id="validationsRequired" style="display:none;" class="alert fade in alert-danger hide">
            <a href="#" data-dismiss="alert" class="close">X</a>
            <strong>Please fix the following fields highlighted in red.</strong> 
        </div>
        
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
        <div class="alert fade in alert-danger hide" style="display: ${not empty requestScope.atmtError ? 'block' : 'none'}">
            <a href="#" data-dismiss="alert" class="close">X</a>
            <strong>${requestScope.atmtError}</strong> 
        </div>
		<html:form action="/cashManagement/cashManagement.do" styleId="cashManagementFBId" method="post"   enctype="multipart/form-data">
		
		<h1 class="page-title span12">Cash Management</h1>
		
		<c:if test="${sessionScope.section eq 'myTasks'}">
			<p class="span12 left clear dashdesc">View this transaction's
			summary below to accept or send back to the front office with your
			comments.
			<a href="#" onclick="javascript:exportToPDF();" class="export"><img src="<%=servletContextUrl%>/img/pdf-ico.png" /></a></p>
		</c:if>
		<c:if test="${sessionScope.section eq 'myAssignedTasks'}">
			<p class="span12 left clear dashdesc">View this transaction's
			summary below to Assign a Reviewer.
			<a href="#" onclick="javascript:exportToPDF();" class="export"><img src="<%=servletContextUrl%>/img/pdf-ico.png" /></a></p>
		</c:if>
		
		<c:forEach items="${sessionScope.deal.actionLogs}" var="actionSection">
			<c:if test="${actionSection.groupName eq 'Requestor' and actionSection.decision eq 'Submit'}">
				<c:set var="reqInitiation" value="${actionSection.actionDt}"></c:set>
			</c:if>
			<c:if test="${actionSection.groupName eq 'Pipeline Review'}">
				<c:set var="plReview" value="${actionSection.actionDt}"></c:set>
			</c:if>
		</c:forEach>
		<jsp:include page="../common/inc/progreessBar.jsp">
			<jsp:param name="formName" value="fourBlockerForm"/>
			<jsp:param name="reqInitiation" value="${reqInitiation}"/>
			<jsp:param name="plReview" value="${plReview}"/>
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
						<jsp:param value="cashManagement/cashManagement" name="path"/>
					</jsp:include>
					<jsp:include page="../common/inc/cashPoolDetails.jsp" />
				</c:when>
				<c:otherwise>
					<jsp:include page="../common/inc/transactionLegs.jsp">
						<jsp:param value="cashManagement/cashManagement" name="path"/>
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
			<%@ include file="../common/inc/viewAdditionalApprovers.jsp"%>
			<c:if test="${not empty requestScope.isEquity && requestScope.isEquity == true}">
			<%@ include file="../common/inc/viewBusinessApprovers.jsp"%>
			</c:if>
			<%@ include file="../common/inc/dealTeam.jsp"%>
			<!-- Including decision page -->
	 		<jsp:include page="../common/inc/actionLog.jsp">
				<jsp:param name="formName" value="dealRequestForm"/>				
			</jsp:include>
			<div class="form-mod">
			<jsp:include page="../common/inc/commentsLog.jsp">
				<jsp:param name="pageType" value="deal"/>
				<jsp:param value="cashManagement/cashManagement" name="path"/>
				<jsp:param value="Cash Management" name="name"/>
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
				<jsp:param value="cashManagement/cashManagement" name="path"/>
				<jsp:param value="Cash Management" name="name"/>
				<jsp:param value="load" name="method"/>		
				<jsp:param value="${param.source}" name="sourcePage"/>
		    	<jsp:param value="${param.section}" name="section"/>		
			</jsp:include>
			
			
			
			<div class="span12 right btn-container">
			<div class="span3 right submit-box" >
				<div class="form-row" >
					<div class="radio-container">
						<c:if test="${sessionScope.section eq 'myTasks'}">
							<label class="radio" >
								<input type="radio" value="affirm" name="submitDealFB">
								Inputs Completed
							</label>
	
							<label class="radio">
								<input type="radio" value="sendBack" name="submitDealFB">
								Send back
							</label>
							<security:hasRoles appName="icfp" domainName="ICFP_AUTH_ACTIONS" domainType="component" compName="AssignReviewer">
							<label class="radio" id="assignReviewerButton">
								<input type="radio" class="assignReviewer" value="assignAReviewer" name="submitDealFB">
								Assign a reviewer
							</label>
							</security:hasRoles>
						</c:if>
						<input type="hidden" name="actionId" id="actionID" >
						<input type="hidden" name="forwardPage" id="forwardPageId"> 
						<input type="hidden" name="roleId" value="8">
						<input type="hidden" name="approveReject" id="approveRejectId">
						<input type="hidden" name="WFId" value="${param.WFId}">
						<input type="hidden" name="WFStage" value="${param.WFStage}">
						<input type="hidden" name="queueName" value="${param.queueName}">
						<c:if test="${sessionScope.section eq 'myAssignedTasks'}">
							<label class="radio" id="assignReviewerButton">
								<input type="radio" class="assignReviewer" value="assignAReviewer" name="submitDealFB">
								Assign a reviewer
							</label>
						</c:if>
						<input type="hidden" name="acctionComments" id="actionCommentsID">
						<input type="hidden" name="comments" id="commentsID">
					</div>
				</div>
				<div id="actionButton">
				<a class="btn btn-success btn-large" id="submit" href="#" style="width: 190px;">Submit</a>
				</div>
			</div>
			<c:if test="${sessionScope.section eq 'myTasks'}">
			<c:set var="margin" value="60px"/>
			<security:hasRoles appName="icfp" domainName="ICFP_AUTH_ACTIONS" domainType="component" compName="AssignReviewer">
			<c:set var="margin" value="85px"/>
			</security:hasRoles>
			
			<div style="margin-top: ${margin}; float: right;">
				<a class="btn right save-btn single" id="saveAction" href="#" style="margin-top: 30px;">Save</a>
				<a href="#confirm" class="btn-link right cancel modal-confirm" data-toggle="modal" style="margin-top: 40px;">Cancel</a>
			</div>
			</c:if>
			<c:if test="${sessionScope.section eq 'myAssignedTasks'}">
			<div style="margin-top: 30px; float: right;">
				<a href="#confirm" class="btn-link right cancel modal-confirm" data-toggle="modal" style="margin-top: 40px;">Cancel</a>
			</div>
			</c:if>
		</div>
		</html:form>
		<hr>
	</div>
	<%@include  file="../common/footerSection.jsp" %>
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
			<a href="<%=servletContextUrl%>/homePage.do" class="btn right btn-success">Yes, cancel the request</a>
			<a href="#" class="btn-link right cancel" data-dismiss="modal">No, take me back to the request</a>
		</div>
	</div>
	<!-- Modals start -->
	<!-- Send Back Popup -->
	<div class="modal hide fade" id="sendback">
		<div class="modal-header">
			<a class="close" data-dismiss="modal">X</a>
			<h3>Send Back</h3>
		</div>
		<div class="modal-body">

			<div class="row">
				<div class="span5">
					<p>To send back to front office, please enter your comment below</p>
				</div>
				<div class="span5">
					<div class="form-row autosize-container">
						<span class="required">*</span> <label>Comments</label>
						<div class="char-count">500</div>
						<textarea class="xlarge autosize messageinput" name="acctionComments" rows="4" id="sendBackComments" onblur="scriptInjection(this);"></textarea>
						<span class="req-error" id="sbCommentsError1">error</span> 
						<span style="color: red" id="errorComents"></span>
					</div>
				</div>
				<!-- end of block -->

			</div>
		</div>
		<div class="modal-footer">
			<a href="#derivatives-table" class="btn right btn-success" id="sendBack">Send back</a> 
			<a href="#"	class="btn-link right cancel" data-dismiss="modal">Close window</a>
		</div>
	</div>
	 <div class="modal hide fade" id="assignReviewerpopup">
		<div class="modal-header">
			<a class="close" data-dismiss="modal">X</a>
			<h3>Assign Reviewer</h3>
		</div>
		<div class="modal-body">
			<div class="row">
				<p><b>Are you sure you want to Assign this request to <span id="lastfirstnames"></span> ? </b><br>
			Note: Any change made on the deal page prior to assigning a reviewer will not get saved.
			</p>
			</div>
		</div>
		<div class="modal-footer">
			<button type="submit" class="btn right btn-success" data-toggle="modal" onclick="assignMember()">Yes, Assign a Reviewer</button>
			<a href="#" class="btn-link right cancel" data-dismiss="modal">No, take me back to the request</a>
		</div>
      </div>
      
	<!-- Assign a Reviewer Popup -->
	<%@ include file="../common/inc/assignReviewer.jsp"%>
	<%@ include file="../common/confirmPages/inputsCompletedConfirm.jsp"%>
	<%@ include file="../common/confirmPages/saveConfirm.jsp"%>
	
	
</body>
</html>