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
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<%@ taglib uri="/WEB-INF/config/tld/hwf-desktoptag.tld"
	prefix="wfdesktop"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en-US"/>

<%@ taglib prefix="security"  uri="hwf-securitytag" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>ICF | Risk Review</title>
<meta name="description" content="">
<meta name="author" content="">
<%@include file="../common/includeCssScripts.jsp" %>
<script src="<%=servletContextUrl%>/js/riskUnderwriting.js" type="text/javascript"></script> 
 
<script type="text/javascript">
//Defining the global variable, so this variable can be used by other javascript library included in this JSP 
 var contextURL = '<%=servletContextUrl%>';
</script>
	
<%String legLenforJS ="0";%>
					
<script type="text/javascript">
var legLen = '<%=legLenforJS%>';
</script>
<script type="text/javascript" 
src="<%=servletContextUrl%>/js/riskunderwriting/riskUnderwritingFourBlocker.js"></script>
  </head>


  <body>
	<div class="container main">
		<%@include file="../common/headerSection.jsp" %>
		
		<ul class="breadcrumb">
			<li><a href="<%=servletContextUrl%>/homePage.do">Home</a> <span class="divider">/</span></li>
			<li class="active">Risk Review</li>
		</ul>
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
		<div class="alert fade in alert-danger hide" id="genericErrorComment">
            <a href="#" data-dismiss="alert" class="close">X</a>
            <strong>Please fix the following fields highlighted in red.</strong> 
        </div>
		
		<h1 class="page-title span12">Risk Review</h1>
		<c:if test="${sessionScope.section eq 'myTasks'}">
		<p class="span12 left clear dashdesc"><bean:message key="label.fourBlocker.riskUnderWriting" />
			<a href="#" onclick="javascript:exportToPDF();" class="export"><img src="<%=servletContextUrl%>/img/pdf-ico.png" /></a>
		</p>
		<span class="required-fields"><span>*</span> = Required</span>
		</c:if>
		<c:if test="${sessionScope.section eq 'myAssignedTasks'}">
		<p class="span12 left clear dashdesc">View this transaction's
			summary below to Assign a Reviewer.
			<a href="#" onclick="javascript:exportToPDF();" class="export"><img src="<%=servletContextUrl%>/img/pdf-ico.png" /></a>
			</p>
			<span class="required-fields"><span>*</span> = Required</span>
		</c:if>
		<html:form action="/riskUnderwriting/riskUnderwriting.do" method="post" styleId="cashManagementFBId" enctype="multipart/form-data">
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
		</c:forEach>
		<jsp:include page="../common/inc/progreessBar.jsp">
			<jsp:param name="formName" value="riskFourBlockerForm"/>	
			<jsp:param name="reqInitiation" value="${reqInitiation}"/>
			<jsp:param name="plReview" value="${plReview}"/>	
			<jsp:param name="soComplete" value="${soComplete}"/>
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
			 
		<%@ include file="../common/inc/transactionPriorityAndTiming.jsp"%>
		
		<!-- Include Transaction Leg Summary -->
		
		<c:choose>
				<c:when test="${not empty requestScope.isCPA && requestScope.isCPA == true}">
					<jsp:include page="../common/inc/cpaRequestDetails.jsp">
						<jsp:param value="riskUnderwriting/riskUnderwriting" name="path"/>
					</jsp:include>
					<jsp:include page="../common/inc/cashPoolDetails.jsp" />
				</c:when>
				<c:otherwise>
					<jsp:include page="../common/inc/transactionLegs.jsp">
						<jsp:param value="riskUnderwriting/riskUnderwriting" name="path"/>
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
		<%@ include file="../common/inc/qualitativeAssessment.jsp"%>
        
		<div class="form-mod">
			<h2 class="span12 collapsible">Transaction Classification Level</h2> 
			<div class="row highlighted">
				<div class="span5">
					<div class="form-row">
						<p><b>Default Transaction Classification Level</b><br />
							<c:choose>
								<c:when test="${empty sessionScope.deal.dealTcl and empty sessionScope.deal.ruAmendedTcl}">
									--
								</c:when>
								<c:otherwise>
								${sessionScope.deal.dealTcl}
								</c:otherwise>
							</c:choose>
							<html:hidden name="updateStatusForm" property="fourBlocker.tClassificationLevel.defaultClassificationLevel" value="${sessionScope.deal.dealTcl}"/>
						</p>
					</div>
				</div><!-- end of block -->
			</div>
			 <div class="row">
				<div class="span5">
					<div class="form-row">
						<span class="required">*</span>
						<label>Risk Review override needed</label>
						<div class="radio-container conditional-radio" id="riskReviewOverviewNeededErrorBar">
							<label class="radio">
								<c:choose>
								<c:when test="${updateStatusForm.map['fourBlocker'].map['tClassificationLevel'].map['riskReviewOverride'] eq '1'}">
									<input type="radio" name="fourBlocker.tClassificationLevel.riskReviewOverride" class="condition" id="riskReviewOverrideNeeded" value="1" checked="checked"/>
								</c:when>
								<c:otherwise>
									<input type="radio" name="fourBlocker.tClassificationLevel.riskReviewOverride" class="condition" id="riskReviewOverrideNeeded" value="1" />
								</c:otherwise>
								</c:choose>
								Yes
							</label>
							<div id="revisedTransactionClassificationLevelDiv" class="form-row conditional-container">
								<div class="form-row">
									<span class="required">*</span>
									<label>Revised Transaction Classification Level<span class="ttip info" data-original-title="<bean:message key="tooltip.defaultClassifucationLevel.RU" />"></span></label>
									 <span id="revisedTransactionClassificationLevelErrorBar">&nbsp;</span>
									 <html:select name="updateStatusForm" property="fourBlocker.tClassificationLevel.RUAmendedTCL" styleId="revisedTransactionClassificationLevel" styleClass="dropdown">  
      									<html:option value="">Select...</html:option>
										<html:option value="0">0</html:option>
										<html:option value="1">1</html:option>
										<html:option value="2">2</html:option>
										<html:option value="3">3</html:option>  
									</html:select>
									
								</div>
								
								<div class="form-row autosize-container">
									<span class="required">*</span>
									<label>Revised Transaction Classification Level Comments</label>
									<span id="revisedTransactionClassificationLevelCommentErrorBar">&nbsp;</span>
									<div class="char-count">500</div>
									<html:textarea styleClass="xlarge autosize messageinput" name="updateStatusForm" rows="4" property="fourBlocker.tClassificationLevel.revisedTCLComments" styleId="revisedTransactionClassificationLevelComment" onblur="scriptInjection(this);"></html:textarea>
								</div>
								
							</div>
							<label class="radio">
							<c:choose>
								<c:when test="${updateStatusForm.map['fourBlocker'].map['tClassificationLevel'].map['riskReviewOverride'] eq '0'}">
								<input type="radio" name="fourBlocker.tClassificationLevel.riskReviewOverride" id="riskReviewOverrideNeeded" value="0" checked="checked"/>
								</c:when>
								<c:otherwise>
								<input type="radio" name="fourBlocker.tClassificationLevel.riskReviewOverride" id="riskReviewOverrideNeeded" value="0" />
								</c:otherwise>
							</c:choose>
			 					No
							</label>
						</div>
					</div>
				</div> 
			</div>
        </div><!-- end of form form-mod -->
        
		<%@ include file="../common/inc/dealTeam.jsp"%>
		<!-- Including decision page -->
	 	<jsp:include page="../common/inc/actionLog.jsp">
			<jsp:param name="formName" value="dealRequestForm"/>			
		</jsp:include>
		<jsp:include page="../../jsp/common/inc/commentsLog.jsp">
			<jsp:param name="pageType" value="deal"/>
			<jsp:param value="riskUnderwriting/riskUnderwriting" name="path"/>
			<jsp:param value="Risk Review" name="name"/>
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
			<jsp:param value="riskUnderwriting/riskUnderwriting" name="path"/>
			<jsp:param value="Risk Review" name="name"/>
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
							Risk Review completed
						</label>

						<label class="radio">
							<input type="radio" value="sendBack" name="submitDealFB">
							Send back
						</label>
						<label class="radio">
							<input type="radio" class="rejectRequest" value="reject" name="submitDealFB">
							Reject
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
						<input type="hidden" name="roleId" value="4">
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
			<div style="position:absolute;float:right;bottom:40px;right:260px;border:0px solid blue;height:30px;width:200px;">
				<c:if test="${sessionScope.section eq 'myTasks'}">
				<a class="btn right" id="saveAction" href="#" >Save</a>
				</c:if>
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
	<!-- Modals start -->
	<div class="modal hide fade" id="sendback">
		<div class="modal-header">
			<a class="close" data-dismiss="modal">X</a>
			<h3>Send Back</h3>
		</div>
		<div class="modal-body">
			
			<div class="row">
				<div class="span5"><p>To send back to front office, please enter your comment below</p>
				</div>
				<div class="span5">
					<div class="form-row autosize-container">
						<span class="required">*</span>
						<label>Comments</label>
						<span id="sendBackCommentsErrorBar">&nbsp;</span>
						<div class="char-count">
							<label id="sendBackCommentsSizeId"><bean:message key="label.commentMaxSize" /></label>
						</div>
						<textarea class="xlarge autosize messageinput" name="acctionComments" rows="4" id="sendBackComments" onblur="scriptInjection(this);"></textarea>
					</div>
				</div> <!-- end of block -->
			
			</div>
		</div>
		<div class="modal-footer">
			<a href="#derivatives-table" class="btn right btn-success" data-dismiss="modal" id="sendBack">Send back</a>
			<a href="#" class="btn-link right cancel single" data-dismiss="modal">Close window</a>
		</div>
	</div>
	<div class="modal hide fade" id="rejectRequest">
		<div class="modal-header">
			<a class="close" data-dismiss="modal">X</a>
			<h3>Reject</h3>
		</div>
		<div class="modal-body">
			
			<div class="row">
				<div class="span5"><p>Are you certain you want to reject this Request? <br />This action can not be undone.</p>
				</div>
				<div class="span5">
					<div class="form-row autosize-container">
						<span class="required">*</span>
						<label>Comments</label>
						<span id="rejectCommentsErrorBar">&nbsp;</span>
						<div class="char-count">
							<label id="rejectRequestCommentsSizeId"><bean:message key="label.commentMaxSize" /></label>
						</div>
						<textarea class="xlarge autosize messageinput" name="acctionComments" rows="4" id="rejectRequestComments" onblur="scriptInjection(this);"></textarea>
					</div>
				</div> <!-- end of block -->
			
			</div>
		</div>
		<div class="modal-footer">
			<a href="#" class="btn right btn-success" data-dismiss="modal"  id="reject">Reject this request</a>
			<a href="#" class="btn-link right cancel" data-dismiss="modal">Close window</a>
		</div>
	</div>
		
	<%@ include file="../common/inc/assignReviewer.jsp"%>
	<%@ include file="../common/confirmPages/inputsCompletedConfirm.jsp"%>
	<%@ include file="../common/confirmPages/saveConfirm.jsp"%>
  </body>
</html>
