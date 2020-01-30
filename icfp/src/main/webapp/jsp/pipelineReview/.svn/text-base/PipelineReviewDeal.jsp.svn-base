<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<% String servletContextUrl = request.getContextPath();  %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="/WEB-INF/config/tld/attachment" prefix="attachment" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page import="com.hydus.wff.core.context.UserContext"%>
<%@taglib uri="http://ge.com/icfp/taglibs/userInformation" prefix="userDetails" %>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<%@ taglib prefix="security" uri="hwf-securitytag" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>
<%@ page errorPage="../common/error.jsp" %>


<!DOCTYPE html>
<html lang="en">
  <head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title><bean:message key="title.pipeLineReviewDeal" /></title>
    <meta name="description" content="">
    <meta name="author" content="">

	<script type="text/javascript">
//Defining the global variable, so this variable can be used by other javascript library included in this JSP 
 var contextURL = '<%=servletContextUrl%>';
</script>
  	<%@include file="../common/includeCssScripts.jsp" %>
	<script src="../js/addLeg.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/pipelineReviewDeal.js" type="text/javascript"></script>
	<%String legLenforJS ="0";%>
					
<script type="text/javascript">
var legLen = '<%=legLenforJS%>';
</script>
	<%String lastDeal = (String)request.getAttribute("failureMsg");%>
	<%String wfStageIdMsgId = (String)request.getAttribute("wfStageIdMsg");%>
	<%String creatorLogInIdValue = (String)request.getAttribute("creatorLogInId");%>
	
	<script type='text/javascript'>
//show next leg navigation if it's not last leg
//it needs the JSP variable so placed in JSP file
	$(document).ready(function() {	
	$('textarea').keyup(function() {
	var len = this.value.length;
	if (len >= 500) {
	this.value = this.value.substring(0, 500);
	}
	});
	$('#cancelSendBack').click(function(){
		$('#sendback').find('div.char-count').text("500");
	});
	var lastDealVar = '<%=lastDeal%>';
	   if(lastDealVar!=null && lastDealVar!='null')
		   {
		   $('#reviewNextDealID').hide(); 
		   } 
	   else
		   {
		   $('#reviewNextDealID').show(); 
		   }
	  var wfStageIdMsgVar = '<%=wfStageIdMsgId%>';
	  var creatorLogInIdVar = '<%=creatorLogInIdValue%>';
			  
		if (creatorLogInIdVar != null && creatorLogInIdVar != 'null') {
		
				$('#workflowId').hide();
			} else if (wfStageIdMsgVar != null && wfStageIdMsgVar != 'null') {
				$('#workflowId').hide();
			} else {
				$('#workflowId').show();
			}
		});
	</script> 
  </head>

  <body>
	<div class="container main">
		<%@include  file="../common/headerSection.jsp" %>
		<ul class="breadcrumb">
			<li><a href="<%=servletContextUrl%>/homePage.do">Home</a> <span class="divider">/</span></li>
			<c:choose>
				<c:when test="${not empty sessionScope.deal.eventType && sessionScope.deal.eventType eq 'Y'}">
				<li><a href="<%=servletContextUrl%>/pipelineReview/pipelineReviewView.do?command=executeInboxMO"><bean:message key="heading.pipelineInboxMO.pageTitle"/></a><span class="divider">/</span></li>
				</c:when>
				<c:otherwise>
				<li><a href="<%=servletContextUrl%>/pipelineReview/pipelineReviewView.do?command=executeInbox"><bean:message key="heading.pipelineInbox.pageTitle"/></a><span class="divider">/</span></li>
				</c:otherwise>
			</c:choose>
			<li class="active">Pipeline Review</li>
		</ul>
		<div id="validateFlag" style="display:none;" class="alert fade in alert-danger hide">
            <a href="#" data-dismiss="alert" class="close">X</a>
            <strong>Please fix the following fields highlighted in red.</strong> 
        </div>
         <logic:messagesPresent >
		       <div class="alert fade in alert-danger show" >
            		<a href="#" data-dismiss="alert" class="close">X</a>
            	<strong>Please fix the following fields highlighted in red.</strong> 
        	   </div>
		       
         </logic:messagesPresent>
        
	   <html:form action="pipelineReview/pipelineReviewDeal.do"  styleId="pipelineReviewDealFBId" method="post"  enctype="multipart/form-data">  
	  	   <div class="alert fade in alert-success hide" style="display: ${empty requestScope.UpdateMessage ? 'none' : 'block'}">
            <a href="#" data-dismiss="alert" class="close">X</a>
            <strong>${requestScope.UpdateMessage}</strong> 
        </div>
	   
		<h1 class="page-title span12">Pipeline Review</h1>
		<p class="span12 left clear dashdesc">View this transaction's summary below to accept or send back to the requester with your comments.
		<a href="#" onclick="javascript:exportToPDF();" class="export"><img src="<%=servletContextUrl%>/img/pdf-ico.png" /></a>
		</p>
		<span class="required-fields"><span>*</span> = Required</span>
		<c:set var="nonStandardDocsFlag" value="${deal:getNonStandardDocsFlag(pageContext.request)}" />
	
		<c:choose>
			<c:when test="${not empty sessionScope.deal.WFStageId && sessionScope.deal.WFStageId gt 1}">
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
		</c:when>
		<c:otherwise>
			<c:forEach items="${sessionScope.deal.actionLogs}" var="actionSection">
			<c:if test="${actionSection.groupName eq 'Requestor' and actionSection.decision eq 'Submit'}">
				<c:set var="reqInitiation" value="${actionSection.actionDt}"></c:set>
			</c:if>
			</c:forEach>
		
		<jsp:include page="../common/inc/progreessBar.jsp">
			<jsp:param name="formName" value="pipeLineReviewForm"/>
			<jsp:param name="reqInitiation" value="${reqInitiation}"/>
		</jsp:include>
	</c:otherwise>
	</c:choose>
	
	<jsp:include page="../common/inc/projectSummary.jsp">
			<jsp:param name="formName" value="dealRequestForm"/>			
		</jsp:include>
        <c:if test="${param.source eq 'dashboard' or param.source eq 'FOPipeline'}">    	
        <jsp:include page="../common/inc/transactionLegs.jsp" >
        	<jsp:param value="pipelineReviewDealLeg" name="path"/>
        </jsp:include>
        </c:if>
        <jsp:include page="../common/inc/transctionSummaryAndOwner.jsp">
			<jsp:param name="formName" value="pipeline"/>			
		</jsp:include>
		
		<jsp:include page="../common/inc/transactionPriorityAndTiming.jsp" >
				<jsp:param value="valueDateEntered" name="page"/>
			</jsp:include>	
		<c:if test="${param.source eq 'MOPipeline'}">    	
        <jsp:include page="../common/inc/transactionLegs.jsp" >
        	<jsp:param value="pipelineReviewDealLeg" name="path"/>
        </jsp:include>
        </c:if>
		<c:choose>
		
    	<c:when test="${not empty sessionScope.deal.WFStageId && sessionScope.deal.WFStageId gt 1}">
    		<c:if test="${not empty sessionScope.deal.eventType && sessionScope.deal.eventType eq 'N'}">
    		  	<%@ include file="../common/inc/viewAdditionalApprovers.jsp"%>
				<c:if test="${not empty requestScope.isEquity && requestScope.isEquity == true}">
					<%@ include file="../common/inc/viewBusinessApprovers.jsp"%>
				</c:if>
				<%@ include file="../common/inc/qualitativeAssessment.jsp"%>
			
				<%@ include file="../common/inc/transactionClassificationLevelView.jsp"%>
				<jsp:include page="../common/inc/dealTeam.jsp"/>
			</c:if>
			<c:if test="${not empty sessionScope.deal.eventType && sessionScope.deal.eventType eq 'Y'}">
			  	<%@ include file="../common/inc/viewAdditionalApprovers.jsp"%>
				<c:if test="${not empty requestScope.isEquity && requestScope.isEquity == true}">
					<%@ include file="../common/inc/viewBusinessApprovers.jsp"%>
				</c:if>
				<%@ include file="../common/inc/qualitativeAssessment.jsp"%>
			
				<%@ include file="../common/inc/transactionClassificationLevelView.jsp"%>
				<jsp:include page="../common/inc/moPipelineDealTeam.jsp"/>
			</c:if>
    	</c:when>
    	<c:otherwise>
    	   <c:if test="${not empty sessionScope.deal.eventType && sessionScope.deal.eventType eq 'N'}">
				<jsp:include page="../common/inc/dealTeamSelection.jsp">
					<jsp:param name="formName" value="dealRequestForm"/>			
				</jsp:include>
			</c:if>
			<c:if test="${not empty sessionScope.deal.eventType && sessionScope.deal.eventType eq 'Y'}">
				<jsp:include page="../common/inc/modealTeamSelection.jsp">
					<jsp:param name="formName" value="dealRequestForm"/>			
				</jsp:include>
			</c:if>
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
		 
        <jsp:include page="../common/inc/actionLog.jsp">
			<jsp:param name="formName" value="dealRequestForm"/>			
		</jsp:include>
		
		<div class="form-mod">
			<jsp:include page="../common/inc/commentsLog.jsp">
				<jsp:param name="pageType" value="deal"/>
				<jsp:param value="pipelineReview/pipelineReviewDeal" name="path"/>
				<jsp:param value="Pipeline Review" name="name"/>
				<jsp:param value="getPipelineReviewDealDetail" name="method"/>
				<jsp:param value="${param.source}" name="sourcePage"/>
				<jsp:param value="${param.section}" name="section"/>
			</jsp:include>
			<c:choose>
			<c:when test="${not empty sessionScope.deal.WFStageId && sessionScope.deal.WFStageId gt 1}">
			<div class="row comment-container">
				<div class="span5">
					<div class="form-row autosize-container">
						<span class="required"></span>
						<label><bean:message key="label.pipelineReviewDeal.comments" /></label>
						
						<div class="char-count">500</div>
						<textarea class="xlarge autosize messageinput" name="comments"	rows="4" id="dealCommentsId" disabled="disabled" ></textarea>
					</div>
				</div> <!-- end of block -->
			</div>
			</c:when>
			<c:otherwise>
			
			<div class="row comment-container">
				<div class="span5">
					<div class="form-row autosize-container">
						<span class="required"></span>
						<b><bean:message key="label.pipelineReviewDeal.comments" />
						</b>
						<div class="char-count">500</div>
						<textarea class="xlarge autosize messageinput" name="comments"	rows="4" id="dealCommentsId" onblur="scriptInjection(this);"></textarea>
					</div>
				</div> <!-- end of block -->
			</div>
			
			</c:otherwise>
			</c:choose>
        </div><!-- end of form form-mod -->
		<% 
		String productType = null;
		if(request.getAttribute("productType")!=null) {
			productType = (String)request.getAttribute("productType");
		}
		
			if("EQUITY".equalsIgnoreCase(productType)) { 
		 %>
			<!-- starts uploads-->
			<jsp:include page="/jsp/common/attachments/dealPageAttachments.jsp">
				<jsp:param name="mode" value="edit" />
			</jsp:include> 
			<!-- end uploads -->
		    <%
		    } else if("CPA".equalsIgnoreCase(productType)) { %>
		  
			<!-- starts uploads-->
			<jsp:include page="/jsp/common/attachments/cpaDealPageAttachments.jsp">
				<jsp:param name="mode" value="edit" />
			</jsp:include> 
			<!-- end uploads -->
		    <% }  else {%>
		 
			 <!-- starts uploads-->
			<jsp:include page="/jsp/common/attachments/dealPageAttachments.jsp">
				<jsp:param name="mode" value="edit" />
			</jsp:include> 
			<!-- end uploads -->
		 
		   <% } %>
        <jsp:include page="../common/inc/auditLog.jsp">
			<jsp:param name="pageType" value="deal"/>
			<jsp:param value="pipelineReview/pipelineReviewDeal" name="path"/>
		    <jsp:param value="Pipeline Review" name="name"/>
		    <jsp:param value="getPipelineReviewDealDetail" name="method"/>
		    <jsp:param value="${param.source}" name="sourcePage"/>
		    <jsp:param value="${param.section}" name="section"/>	
		</jsp:include>
		
		
		<div class="span3 right btn-container">
			<security:hasRoles appName="icfp" domainName="ICFP_AUTH_ACTIONS" domainType="component" compName="PipelineAdmin">
			<div class="span3 right submit-box" id ="workflowId">
				<div class="form-row">
				<span class="help-block error" id="actionError"><!-- Please Select the Action --></span>
					<div class="radio-container">
						<label class="radio">
							<input type="radio" value="acceptRequest" name="optionsRadios">
							<bean:message key="radio.pipelineReviewDeal.acceptRequest" />
						</label>
						<label class="radio">
							<input type="radio" class="make-modal" value="sendBack" name="optionsRadios">
							<bean:message key="radio.pipelineReviewDeal.sendBackToRequestor" />
						</label>
						<label class="radio" id = "reviewNextDealID">
							<input type="radio" class="assignReviewer" value="reviewNextDeal" name="optionsRadios">
							<bean:message key="radio.pipelineReviewDeal.reviewNextDeal" />
						</label>
						
					</div>
				</div>
				<div id="actionButton">
				<a class="btn btn-success btn-large" id="submit" href="#">Submit</a>
				</div>
			</div>
			</security:hasRoles>
		</div>
		
		<div style="border:0px solid red; margin-top:130px;" class="right">
			<a href="#confirm" class="btn-link right cancel single" data-toggle="modal">Cancel</a>
		</div>


	<input type="hidden" name="queueName" value="${sessionScope.deal.WFQueueName}"/>
	<input type="hidden" name="WFId" value="${sessionScope.deal.WFId}"/>
	<input type="hidden" name="dealSeqId" value="${sessionScope.deal.dealSeqId}"/>
	<input type="hidden" name="eventFlag" id="eventFlag" value="${sessionScope.deal.eventType}"/>
	<input type="hidden" name="selectedComments" id="selectedCommentsID">
	<input type="hidden" name="sourcePage" value="${param.source}"/>
 </html:form>
   
 <hr>
    </div>
	<%@include  file="../common/footerSection.jsp" %>
    
    <!-- confirm starts here -->
	<div class="modal hide fade" id="confirm">
		<div class="modal-header">
			<a class="close" data-dismiss="modal">X</a>
			<h3>Cancel the Deal</h3>
		</div>
		<div class="modal-body">
			<div class="row">
				<p><b>Are you sure you want to cancel?</b><br>
			Any changes you have made will be lost
			</p>
			</div>
		</div>
		<div class="modal-footer">
			<c:choose>
				<c:when test="${not empty sessionScope.deal.eventType && sessionScope.deal.eventType eq 'Y'}">
				<a href="<%=servletContextUrl%>/pipelineReview/pipelineReviewView.do?command=executeInboxMO" class="btn right btn-success">Yes, cancel the Deal</a>
				</c:when>
				<c:otherwise>
				<a href="<%=servletContextUrl%>/pipelineReview/pipelineReviewView.do?command=executeInbox" class="btn right btn-success">Yes, cancel the Deal</a>
				</c:otherwise>
			</c:choose>
			
			<a href="#" class="btn-link right cancel" data-dismiss="modal">No, take me back to the Deal</a>
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
				<p>To send back to requestor, please enter your comment below</p>
				</div>
				<div class="span5">
					<div class="form-row autosize-container">
						<span class="required">*</span>
						<label><bean:message key="label.pipelineReviewDeal.comments" /></label>
						<span class="req-error" id="sbCommentsError1">error</span>
						<div class="char-count" style="color: #7fc47e; top: 29px;">500</div>
						<textarea class="xlarge autosize messageinput" name="acctionComments"
							rows="4" id="sendBackComments"></textarea><br />
							<span style="color: red" id="sbCommentsError2"><!-- Please enter the comments --></span>
							<span style="color: red" id="errorComents"></span>
					</div>
						
				</div> <!-- end of block -->
			
			</div>
		</div>
		<div class="modal-footer">
			<a href="#derivatives-table" class="btn right btn-success" data-dismiss="modal" id="sendBack">Send back</a>
			<a href="#" class="btn-link right cancel" data-dismiss="modal" id="cancelSendBack">Close window</a>
		</div>
	</div>
	<div class="modal hide fade" id="inputsCompletedModalID">
		<div class="modal-header">
			<a class="close" data-dismiss="modal">X</a>
			      <h3>Accept Request</h3>
		</div>
		<div class="modal-body">
			<div class="row">
				<p><b>Are you sure you want to Accept Request?</b><br>  </p>
			</div>
		</div>
		<div class="modal-footer">
		        <a href="#" class="btn right btn-success" onclick="inputsCompleted()">Yes, submit the request</a>
			    <a href="#" class="btn-link right cancel" data-dismiss="modal">No, take me back to the request</a>
		</div>
	</div>
	
	<div class="modal hide fade" id="inputsCompletedModalID1">
		<div class="modal-header">
			<a class="close" data-dismiss="modal">X</a>
			      <h3>Accept Request</h3>
		</div>
		<div class="modal-body">
			<div class="row">
				<p><b>Are you sure you want to Accept Request?</b><br>  </p>
			</div>
		</div>
		<div class="modal-footer">
		        <a href="#" class="btn right btn-success" onclick="inputsCompleted1()">Yes, submit the request</a>
			    <a href="#" class="btn-link right cancel" data-dismiss="modal">No, take me back to the request</a>
		</div>
	</div>
  </body>
</html>

