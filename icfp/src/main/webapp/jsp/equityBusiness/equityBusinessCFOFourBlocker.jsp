<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<% String servletContextUrl = request.getContextPath();  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="/WEB-INF/config/tld/attachment" prefix="attachment" %>
<%@ taglib uri="/WEB-INF/config/tld/hwf-desktoptag.tld" prefix="wfdesktop" %>

<%@ page errorPage="../common/error.jsp" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en-US"/>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="security"  uri="hwf-securitytag" %>
<t:common/>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>ICF | Business CFO Approval</title>
    <meta name="description" content="">
    <meta name="author" content="">

   
     <script type="text/javascript" >
		//Defining the global variable, so this variable can be used by other javascript library included in this JSP 
 var contextURL = '<%=servletContextUrl%>';
	</script>
   	<%@include file="../common/includeCssScripts.jsp" %>
	<script src="<%=servletContextUrl%>/js/addDerivative.js" type="text/javascript"></script>
	
<%String legLenforJS ="0";%>
					
<script type="text/javascript">
var legLen = '<%=legLenforJS%>';
</script>

  <script src="<%=servletContextUrl%>/js/equityBusinessCFOFourBlocker.js" type="text/javascript"></script>
	
  </head>

  <body>
	<div class="container main">
		<%@include file="../common/headerSection.jsp" %>
		
		<ul class="breadcrumb">
			<li><a href="${context}/homePage.do">Home</a> <span class="divider">/</span></li>
			<li class="active">Business CFO Approval</li>
		</ul>
		<div class="alert fade in alert-danger hide" style="display: ${empty requestScope.failureMsg ? 'none' : 'block'}" id="topErrorDiv">
            <a href="#" data-dismiss="alert" class="close">X</a>
            <strong>${requestScope.failureMsg}</strong> 
        </div>
        
        <div class="alert fade in alert-success hide" style="display: ${requestScope.save eq 'success' ? 'block' : 'none'}">
            <a href="#" data-dismiss="alert" class="close">X</a>
            <strong>${requestScope.save}</strong> 
        </div>
        <div class="alert fade in alert-success hide" style="display: ${not empty requestScope.saveMessage ? 'block' : 'none'}">
            <a href="#" data-dismiss="alert" class="close">X</a>
            <strong>${requestScope.saveMessage}</strong> 
        </div>
		<h1 class="page-title span12">Business CFO Approval</h1>
		<p class="span12 left clear dashdesc">View this transaction's summary below to accept or send back to the front office with your comments.
	
			<a href="#" onclick="javascript:exportToPDF();" class="export"><img src="<%=servletContextUrl%>/img/pdf-ico.png" /></a>
			</p>
		
	 <html:form action="/equityBusinessCFO.do" styleId="cashManagementFBId" method="post"   enctype="multipart/form-data">
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
		</c:forEach>
		<jsp:include page="../common/inc/progreessBar.jsp">
			<jsp:param name="formName" value="equityBusinessCFOFourBlockerForm"/>	
			<jsp:param name="reqInitiation" value="${reqInitiation}"/>
			<jsp:param name="plReview" value="${plReview}"/>	
			<jsp:param name="soComplete" value="${soComplete}"/>
			<jsp:param name="riskReview" value="${riskReview}"/>		
		</jsp:include>
		<!-- Include Project Summary -->
		<%@include file="../common/inc/projectSummary.jsp"%>

		<!-- Include Transaction Summary And Owner -->
		<%@include file="../common/inc/transctionSummaryAndOwner.jsp"%>

		<%@ include file="../common/inc/transactionPriorityAndTiming.jsp"%>
		
		<!-- Including transaction legs -->
		<jsp:include page="../common/inc/transactionLegs.jsp">
			<jsp:param value="equityBusinessCFO" name="path"/>
		</jsp:include>
		
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
		<%@ include file="../common/inc/qualitativeAssessment.jsp"%>
		<!-- end of form form-mod -->
		
		<%@ include file="../common/inc/transactionClassificationLevelView.jsp"%>
        
        <!-- reusing the deal team -->
       
		<%@include file="../common/inc/dealTeam.jsp"%>
		
		<!-- Including decision page -->
 		<jsp:include page="../common/inc/actionLog.jsp">
			<jsp:param name="formName" value="dealRequestForm"/>			
		</jsp:include>		
		<div class="form-mod">
			<jsp:include page="../common/inc/commentsLog.jsp">
				<jsp:param name="pageType" value="deal"/>	
				<jsp:param value="equityBusinessCFO" name="path"/>
				<jsp:param value="Business CFO Approval" name="name"/>
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
        </div><!-- end of form form-mod -->
		<!-- Attachments need to be modifed-->
		
		<jsp:include page="/jsp/common/attachments/dealPageAttachments.jsp">
				<jsp:param name="mode" value="edit" />
			</jsp:include> 
		  
		<jsp:include page="../common/inc/auditLog.jsp">
			<jsp:param name="pageType" value="deal"/>
			<jsp:param value="equityBusinessCFO" name="path"/>
			<jsp:param value="Business CFO Approval" name="name"/>
			<jsp:param value="load" name="method"/>
			<jsp:param value="${param.source}" name="sourcePage"/>
		    <jsp:param value="${param.section}" name="section"/>				
		</jsp:include>
		<div class="span12 right btn-container">
			<div class="span3 right submit-box" >
				<div class="form-row" >
					<div class="radio-container">
						<label class="radio" >
							<input type="radio" value="affirm" name="submitDealFB">
							Affirm
						</label>

						<label class="radio">
							<input type="radio" value="sendBack" name="submitDealFB">
							Send back
						</label>
						<input type="hidden" name="actionId" id="actionID" >
						<input type="hidden" name="forwardPage" id="forwardPageId"> 
						<input type="hidden" name="roleId" value="5">
						<input type="hidden" name="approveReject" id="approveRejectId">
						<input type="hidden" name="WFId" value="${param.WFId}">
						<input type="hidden" name="WFStage" value="${param.WFStage}">
						<input type="hidden" name="queueName" value="${param.queueName}">
						
						<input type="hidden" name="acctionComments" id="actionCommentsID">
						<input type="hidden" name="comments" id="commentsID">
					</div>
				</div>
				<div id="actionButton">
				<a class="btn btn-success btn-large" id="submit" href="#" style="width: 190px;">Submit</a>
				</div>
			</div>
			<div style="margin-top: 90px; float: right;">
				<a class="btn right save-btn single" id="saveAction" href="#" >Save</a>
				<a href="#confirm" class="btn-link right cancel modal-confirm" data-toggle="modal" style="margin-top: 10px;">Cancel</a>
			</div>
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
	<!-- Want to Continue Popup -->
	<div class="modal hide fade" id="wantToContinuePopup">
		<div class="modal-header">
			<a class="close" data-dismiss="modal">X</a>
			<h3>Confirmation</h3>
		</div>
		<div class="modal-body">
			<div class="row">
				<p><b>Are you sure you want to continue? </b>
			</p>
			</div>
		</div>
		<div class="modal-footer">
			<!-- <button type="submit" class="btn right btn-success" data-toggle="modal" id="wantToContinue">Yes, Want to Continue</button> -->
			<a href="javascript:void(0);" class="btn right btn-success" id="wantToContinue">Yes, Continue</a>
			<a href="#" class="btn-link right cancel" data-dismiss="modal">No, take me back to the request</a>
		</div>
      </div>
      <%@ include file="../common/confirmPages/saveConfirm.jsp"%>
  </body>
</html>
    