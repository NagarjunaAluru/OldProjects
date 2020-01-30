<%@page import="com.hydus.wff.core.context.UserContext"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@ page errorPage="../common/error.jsp" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en-US"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%String servletContextUrl = request.getContextPath();
%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/config/tld/hwf-desktoptag.tld" prefix="wfdesktop" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<%@ taglib prefix="security"  uri="hwf-securitytag" %>
<html lang="en">
  <head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
     <c:choose>
	        <c:when test="${not empty requestScope.isCPA && requestScope.isCPA == true}">
			<title>ICF | TESG Approvals</title>
			</c:when>
			<c:otherwise>
			<title>ICF | IDAG, TESG Approvals</title>
			</c:otherwise>
      </c:choose>
        
    <meta name="description" content="">
    <meta name="author" content="">
<%@include file="../common/includeCssScripts.jsp" %>
<script type="text/javascript">
//Defining the global variable, so this variable can be used by other javascript library included in this JSP 
 var contextURL = '<%=servletContextUrl%>';
</script>
	
<%String legLenforJS ="0"; %>
					
<script type="text/javascript">
var legLen = '<%=legLenforJS%>';
</script>

	<script type="text/javascript">
		//Defining the global variable, so this variable can be used by other javascript library included in this JSP 
 var contextURL = '<%=servletContextUrl%>';
	</script>
	<script src="<%=servletContextUrl%>/js/tesgFourBlockerSuperUser.js" type="text/javascript"></script>
  </head>

  <body>
	<div class="container main">
		<%@include file="../common/headerSection.jsp" %>
		<c:choose>
	        <c:when test="${not empty requestScope.isCPA && requestScope.isCPA == true}">
	        <c:set var="pageName" value="TESG Approvals"></c:set>
			</c:when>
			<c:otherwise>
			<c:set var="pageName" value="IDAG, TESG Approvals"></c:set>
			</c:otherwise>
        </c:choose>
		
		<ul class="breadcrumb">
			<li><a href="<%=servletContextUrl%>/homePage.do">Home</a> <span class="divider">/</span></li>
			<li class="active">${pageName}</li>
		</ul>
		<div class="alert fade in alert-danger hide" id="genericErrorComment" id="topErrorDiv">
            <a href="#" data-dismiss="alert" class="close">X</a>
            <strong>Please fix the following fields highlighted in red.</strong><br/> 
            <strong>${requestScope.failureMsg}</strong> 
        </div>
        
        <div class="alert fade in alert-danger hide" style="display: ${empty requestScope.failureMsg ? 'none' : 'block'}" >
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
        <h1 class="page-title span12">${pageName}</h1>
        
		<p class="span12 left clear dashdesc"><bean:message key="label.idagEag.fourBlockerSuperUser" />
		<a href="#" onclick="javascript:exportToPDF();" class="export"><img src="<%=servletContextUrl%>/img/pdf-ico.png" /></a></p>
		
		<html:form action="/idagEag/idagEag.do" styleId="cashManagementFBId" method="post" enctype="multipart/form-data">
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
			<jsp:param name="formName" value="idagEagTesg"/>	
			<jsp:param name="reqInitiation" value="${reqInitiation}"/>
			<jsp:param name="plReview" value="${plReview}"/>	
			<jsp:param name="soComplete" value="${soComplete}"/>	
			<jsp:param name="riskReview" value="${riskReview}"/>	
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
					<jsp:param name="formName" value="riskFourBlockerForm"/>	
				</jsp:include>
			</c:when>
			<c:otherwise>
				<jsp:include page="../common/inc/transctionSummaryAndOwner.jsp">
					<jsp:param name="formName" value="riskFourBlockerForm"/>	
				</jsp:include>
			</c:otherwise>
		</c:choose>
		<%@ include file="../common/inc/transactionPriorityAndTiming.jsp"%>
		<!-- Include Transaction Leg Summary -->
		<c:choose>
			<c:when test="${not empty requestScope.isCPA && requestScope.isCPA == true}">
				<jsp:include page="../common/inc/cpaRequestDetails.jsp">
					<jsp:param value="tesg/tesg" name="path"/>
				</jsp:include>
				<jsp:include page="../common/inc/cashPoolDetails.jsp" />
			</c:when>
			<c:otherwise>
				<jsp:include page="../common/inc/transactionLegs.jsp">
					<jsp:param value="tesg/tesg" name="path"/>
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
		<%@ include file="../common/inc/transactionClassificationLevelView.jsp"%>
		<%@ include file="../common/inc/dealTeam.jsp"%>
		<jsp:include page="../common/inc/actionLog.jsp">
				<jsp:param name="formName" value="updateStatusForm"/>			
		</jsp:include>
		<security:hasRoles appName="icfp" domainName="ICFP_AUTH_ACTIONS" domainType="component" compName="IDAGEAGLeadActions">
			<jsp:include page="../common/inc/eBoardroom.jsp">
				<jsp:param value="page" name="view"/>
			</jsp:include>
		</security:hasRoles>
		<jsp:include page="../common/inc/commentsLog.jsp">
				<jsp:param name="pageType" value="deal"/>
				<jsp:param value="tesg/tesg" name="path"/>
			    <jsp:param value="TESG Approvals" name="name"/>
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
			<jsp:param value="tesg/tesg" name="path"/>
			<jsp:param value="TESG Approvals" name="name"/>
			<jsp:param value="load" name="method"/>
			<jsp:param value="${param.source}" name="sourcePage"/>
		    <jsp:param value="${param.section}" name="section"/>			
		</jsp:include>
		
		<div class="span12 right btn-container">
			<div class="span3 right submit-box">
				<div class="form-row">
					<div class="radio-container" id="submitErrorBar">
					<c:set var="IdagMemberShown" value="false"/>
					<c:set var="isEquity" value="${deal:getEquityInfusionsDividendsFlag(pageContext.request)}"/>
					<c:set var="isInPending" value="${deal:isUserInTESGPending(pageContext.request)}" />

					<security:hasRoles appName="icfp" domainName="ICFP_AUTH_ACTIONS" domainType="component" compName="TESGMemberActions">	
					<c:set var="IdagMemberShown" value="true"/>
					<c:if test="${isInPending}">
						<label class="radio">
							<input type="radio" value="approve" name="submitbutton" id="submitbutton">
							Affirm
						</label>
						<label class="radio">
								<input type="radio" value="approveWithModification" name="submitbutton" class="approveWithMod" id="submitbutton">
								Affirm with modifications
						</label>
					</c:if>	
					</security:hasRoles>

					<security:hasRoles appName="icfp" domainName="ICFP_AUTH_ACTIONS" domainType="component" compName="IDAGEAGLeadActions">
					<c:if test="${fn:length(sessionScope.TESGMemberList) == 0}">
					<c:if test="${not empty sessionScope.postIdag && sessionScope.postIdag == 'Y'}">
					<label class="radio">
						<input type="radio" value="approve" name="submitbutton" id="submitbutton">
						Send to Transaction Capture
					</label>
					</c:if>
					</c:if>
					</security:hasRoles>
					<security:hasRoles appName="icfp" domainName="ICFP_AUTH_ACTIONS" domainType="component" compName="IDAGEAGLeadActions">
					<c:if test="${fn:length(sessionScope.TESGMemberList) > 0}">
						<label class="radio">
							<input type="radio" value="approveOnBehalfTesg" name="submitbutton" class="approveOnBehalf" id="submitbutton"> 
							Affirm on behalf of TESG
						</label>
					</c:if>	
					
					<c:if test="${fn:length(sessionScope.TESGMemberList) > 0}">
						<label class="radio">
							<input type="radio" value="rejectOnBehalfIdagEag" name="submitbutton" class="rejectOnBehalf" id="submitbutton"> 
							Reject on behalf TESG
						</label>
					</c:if>
					<c:if test="${fn:length(sessionScope.TESGMemberList) == 0}">
					<c:if test="${not empty sessionScope.postIdag && sessionScope.postIdag == 'Y'}">
					<label class="radio">
						<input type="radio" value="rejectDealRequest" name="submitbutton" class="rejectRequest" id="submitbutton">
						Reject
					</label>
					</c:if>
					</c:if>
				 	</security:hasRoles>
					<security:hasRoles appName="icfp" domainName="ICFP_AUTH_ACTIONS" domainType="component" compName="TESGMemberActions">	
					<c:if test="${isInPending}">
						<label class="radio">
							<input type="radio" value="rejectDealRequest" name="submitbutton" class="rejectRequest" id="submitbutton">
							Reject
						</label>
					</c:if>
					</security:hasRoles>
					<security:hasRoles appName="icfp" domainName="ICFP_AUTH_ACTIONS" domainType="component" compName="IDAGEAGLeadActions">
					<c:if test="${fn:length(sessionScope.TESGMemberList) == 0}">
					<label class="radio">
						<input type="radio" value="sendToeBoardroom" name="submitbutton" class="sendToeBoardroom" id="submitbutton"> <!-- make modal -->
						Send to eBoardroom
					</label>
					</c:if>
					<label class="radio">
						<input type="radio" value="sendBackToFO" name="submitbutton" id="submitbutton"> 
						Send back 
					</label>
					</security:hasRoles>
														
					<input type="hidden" name="actionId" id="actionID" >
					<input type="hidden" name="forwardPage" id="forwardPageId"> 
					<security:hasRoles appName="icfp" domainName="ICFP_AUTH_ACTIONS" domainType="component" compName="IDAGEAGLeadActions">
						<input type="hidden" name="roleId" value="46">
					</security:hasRoles>
					<security:hasRoles appName="icfp" domainName="ICFP_AUTH_ACTIONS" domainType="component" compName="TESGMemberActions">
						<input type="hidden" name="roleId" value="50">
					</security:hasRoles>
					<input type="hidden" name="approveReject" id="approveRejectId">
					<input type="hidden" name="ebordRoomFlag" id="ebordRoomFlag">
					<input type="hidden" name="WFId" value="${param.WFId}">
					<input type="hidden" name="WFStage" value="${param.WFStage}">
					<input type="hidden" name="queueName" value="${param.queueName}">
					<input type="hidden" name="acctionComments" id="actionCommentsID">
					<input type="hidden" name="comments" id="commentsID">
					<input type="hidden" name="eboardComments">
					<input type="hidden" name="approverList" id="approverListId"> 
					</div>
				</div>
				<div id="actionButton">
				<a class="btn btn-success btn-large" href="#" id="submit">Submit</a>
				</div>
				</div>
				<div style="position:absolute;float:right;bottom:40px;right:260px;border:0px solid blue;height:30px;width:200px;">
				<a class="btn right" id="saveAction" href="#" >Save</a>
				<a href="#confirm" class="btn-link right cancel single" data-toggle="modal" style="margin-top: 10px;">Cancel</a>
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
	<div class="modal hide fade" id="rejectRequest">
		<div class="modal-header">
			<a class="close" data-dismiss="modal">X</a>
			<h3>Reject this Request</h3>
		</div>
		<div class="modal-body">
			
			<div class="row">
				<div class="span5"><p>Are you certain you want to reject this request?<br /> the request will permanently be deleted.</p>
				</div>
				<div class="span5">
					<div class="form-row autosize-container">
						<span class="required">*</span>
						<label>Comments</label>
						<span id="rejectRequestCommentsErrorBar">&nbsp;</span>
						<div class="char-count">
							<label id="rejectRequestCommentsSizeId"><bean:message key="label.commentMaxSize" /></label>
						</div>
						<textarea class="xlarge autosize messageinput" name="acctionComments" rows="4" id="rejectRequestComments" onblur="scriptInjection(this);"></textarea>
					</div>
				</div> <!-- end of block -->
			
			</div>
		</div>
		<div class="modal-footer">
			<a href="#" class="btn right btn-success" id="rejectDealRequest" data-dismiss="modal">Reject this request</a>
			<a href="#" class="btn-link right cancel" data-dismiss="modal">Close window</a>
		</div>
	</div>
	<div class="modal hide fade" id="approveWithMod">
		<div class="modal-header">
			<a class="close" data-dismiss="modal">X</a>
			<h3>Affirm with Modifications</h3>
		</div>
		<div class="modal-body">
			
			<div class="row">
				<div class="span5"><p>To affirm with modifications, please enter your comment below.</p>
				</div>
				<div class="span5">
					<div class="form-row autosize-container">
						<span class="required">*</span>
						<label>Comments</label>
						<span id="approveWithModCommentsErrorBar">&nbsp;</span>
						<div class="char-count">
							<label id="approveWithModCommentsSizeId"><bean:message key="label.commentMaxSize" /></label>
						</div>
						<textarea class="xlarge autosize messageinput" name="acctionComments" rows="4" id="approveWithModComments" onblur="scriptInjection(this);"></textarea>
					</div>
				</div> <!-- end of block -->
			
			</div>
		</div>
		<div class="modal-footer">
			<a href="#" class="btn right btn-success" data-dismiss="modal" id="approveWithModification">Approve this request</a>
			<a href="#" class="btn-link right cancel" data-dismiss="modal">Close window</a>
		</div>
	</div>
	
	<div class="modal hide fade" id="approveOnBehalf">
			<div class="modal-header">
				<a class="close" data-dismiss="modal">X</a>
				<h3>Affirm on behalf TESG</h3>
			</div>
			<div class="modal-body" style="overflow-x: auto;">
			<form>
			<div id="topErrorDiv" style="display:none;" class="alert fade in alert-danger hide">
            	<a href="#" data-dismiss="alert" class="close">X</a>
            	<strong></strong> 
        	</div>
			<p>Select the individuals to affirm this request on behalf of. Include your comment below.</p>
				<div class="row">
					<div class="span9">
						<label class="checkbox apply-to-all" >
							<input type="checkbox" class="check-all-behalf" id="optionsCheckbox" value="option1">
							Select all
						</label>
						 <table class="table table-striped table-bordered sortable no-bottom">
							<thead>
							  <tr>
								<th class="nosort" style="width:20px;"></th>
								<th>Group</th>
								<th>Name</th>
								<th>Action Taken</th>
								<th>Action Taken By</th>
								<th>Action Date</th>
							  </tr>
							</thead>
							<tbody>
								<c:forEach var="TESGMember" items="${TESGMemberList}" >
									<tr>
										<td><input type='checkbox' value='${TESGMember.SSOID}' name='approverOnBehalf' id='approverOnBehalf'></td>
										<td>${TESGMember.group}</td>
										<td>${TESGMember.name}</td>	
										<td>-</td>
										<td>-</td>
										<td>-</td>							
								    </tr>
								</c:forEach>
							 	<c:forEach var="TESGMemberPopup" items="${TESGMemberListPopup}" >
							 		<tr>
							 			<td><input type='checkbox' value='${TESGMemberPopup.tesgSSO}' name='approverOnBehalf' id='approverOnBehalf'></td>
							 			<td>ICFP_TESG</td>
							 			<td style="word-wrap:break-word;"><div style="width:150px;overflow:auto">${TESGMemberPopup.tesgName}</div></td>
							 			<td>${TESGMemberPopup.action}</td>
							 			<td style="word-wrap:break-word;"><div style="width:150px;overflow:auto">${TESGMemberPopup.actorName}</div></td>
							 			<td>${TESGMemberPopup.actionDate}</td>
							 		</tr>
							 	</c:forEach>
							</tbody>
						  </table>
						 
				</div><!-- end of block -->
				
				</div>
			
				
				<div class="row comment-container">
				<div class="span5">
					<div class="form-row autosize-container">
						<span class="required">*</span>
						<label>Comments</label>
						<span id="approveOnBehalfCommentsErrorBar">&nbsp;</span>
						<div class="char-count">
							<label id="approveOnBehalfCommentsSizeId"><bean:message key="label.commentMaxSize" /></label>
						</div>
						<textarea class="xlarge autosize messageinput" name="acctionComments" rows="4" id="approveOnBehalfComments" onblur="scriptInjection(this);"></textarea>
					</div>
				</div> <!-- end of block -->
			</div>
			</form>
			</div>
			<div class="modal-footer">
				<a href="#" class="btn right btn-success" id="approveOnBehalfTesg" data-dismiss="modal">Affirm on behalf TESG</a>
				<a href="#" class="btn-link right cancel" data-dismiss="modal">Close window</a>
			</div>
	</div>
	
	<div class="modal hide fade" id="rejectOnBehalf">
			<div class="modal-header">
				<a class="close" data-dismiss="modal">X</a>
				<h3>Reject on behalf TESG</h3>
			</div>
			<div class="modal-body" style="overflow-x: auto;">
			<form>
			<div id="topErrorDiv1" style="display:none;" class="alert fade in alert-danger hide">
            	<a href="#" data-dismiss="alert" class="close">X</a>
            	<strong></strong> 
        	</div>
			<p>Select the individuals to reject this request on behalf of. Include your comment below.</p>
				<div class="row">
					<div class="span9">
						<label class="checkbox apply-to-all" >
							<input type="checkbox" class="check-all-behalf" id="optionsCheckbox" value="option1">
							Select all
						</label>
						 <table class="table table-striped table-bordered sortable no-bottom">
							<thead>
							  <tr>
								<th class="nosort" style="width:20px;"></th>
								<th>Group</th>
								<th>Name</th>
								<th>Action Taken</th>
								<th>Action Taken By</th>
								<th>Action Date</th>
							  </tr>
							</thead>
							<tbody>
								<c:forEach var="TESGMember" items="${TESGMemberList}" >
									<tr>
										<td><input type='checkbox' value='${TESGMember.SSOID}'  name='rejecterOnBehalf' id='rejecterOnBehalf'></td>
										<td>${TESGMember.group}</td>
										<td>${TESGMember.name}</td>
										<td>-</td>
										<td>-</td>
										<td>-</td>						
								    </tr>
								</c:forEach>
								<c:forEach var="TESGMemberPopup" items="${TESGMemberListPopup}" >
							 		<tr>
							 			<td><input type='checkbox' value='${TESGMemberPopup.tesgSSO}'  name='rejecterOnBehalf' id='rejecterOnBehalf'></td>
							 			<td>ICFP_TESG</td>
							 			<td style="word-wrap:break-word;"><div style="width:150px;overflow:auto">${TESGMemberPopup.tesgName}</div></td>
							 			<td>${TESGMemberPopup.action}</td>
							 			<td style="word-wrap:break-word;"><div style="width:150px;overflow:auto">${TESGMemberPopup.actorName}</div></td>
							 			<td>${TESGMemberPopup.actionDate}</td>
							 		</tr>
							 	</c:forEach>
							</tbody>
						  </table>
						 
				</div><!-- end of block -->
				
				</div>
				<div class="row comment-container">
				<div class="span5">
					<div class="form-row autosize-container">
						<span class="required">*</span>
						<label>Comments</label>
						<span id="rejectOnBehalfCommentsErrorBar">&nbsp;</span>
						<div class="char-count">
							<label id="rejectOnBehalfCommentsSizeId"><bean:message key="label.commentMaxSize" /></label>
						</div>
						<textarea class="xlarge autosize messageinput" name="acctionComments" rows="4" id="rejectOnBehalfComments" onblur="scriptInjection(this);"></textarea>
					</div>
				</div> <!-- end of block -->
			</div>
			</form>
			</div>
			<div class="modal-footer">
				<a href="#" class="btn right btn-success" id="rejectOnBehalfTesg" data-dismiss="modal">Reject on behalf TESG</a>
				<a href="#" class="btn-link right cancel" data-dismiss="modal">Close window</a>
			</div>
	</div>
	<div class="modal hide fade" id="sendToeBoardroom">
		<div class="modal-header">
			<a class="close" data-dismiss="modal">X</a>
			<h3>Send to eBoardroom</h3>
		</div>
		<div class="modal-body">
			<jsp:include page="../common/inc/eBoardroom.jsp">
				<jsp:param value="modal" name="view"/>
			</jsp:include>
			
			<div class="row span8 autosize-container" style="margin-top:-30px">
				<span class="required">*</span>
				<label>Summary of Transaction</label>
				<div class="char-count">500</div>
				<textarea  class="xlarge autosize messageinput" name="eboardComments" data-max="500" rows="5" onblur="scriptInjection(this);"></textarea>	
			</div>
		</div>	
		<div class="modal-footer">
				<a href="#" class="btn right btn-success" id="sendbackToeBoardroom">Send to eBoardroom</a>
				<a href="#" class="btn-link right cancel" data-dismiss="modal">Close window</a>
		</div>
	</div>
	<div class="modal hide fade" id="sendback">
		<div class="modal-header">
			<a class="close" data-dismiss="modal">X</a>
			<h3>Send Back to Front Office</h3>
		</div>
		<div class="modal-body">
			
			<div class="row">
				<div class="span5"><p>This request will be send back to Front Office, please enter your comment below.</p>
				</div>
				<div class="span5">
					<div class="form-row autosize-container">
						<span class="required">*</span>
						<label>Comments</label>
						<span id="sendbackCommentsErrorBar">&nbsp;</span>
						<div class="char-count">
							<label id="sendbackCommentsSizeId"><bean:message key="label.commentMaxSize" /></label>
						</div>
						<textarea class="xlarge autosize messageinput" name="acctionComments" rows="4" id="sendbackComments" onblur="scriptInjection(this);"></textarea>
					</div>
				</div> <!-- end of block -->
			
			</div>
		</div>
		<div class="modal-footer">
			<a href="#derivatives-table" class="btn right btn-success" data-dismiss="modal" id="sendbackToFO">Send back</a>
			<a href="#" class="btn-link right cancel" data-dismiss="modal">Close window</a>
		</div>
	</div>
	<div class="modal hide fade" id="sendbackToRiskUnderwriting">
		<div class="modal-header">
			<a class="close" data-dismiss="modal">X</a>
			<h3>Send Back to Risk Underwriting</h3>
		</div>
		<div class="modal-body">
			
			<div class="row">
				<div class="span5"><p>This request will be send back to Risk Underwriting, please enter your comment below.</p>
				</div>
				<div class="span5">
					<div class="form-row autosize-container">
						<span class="required">*</span>
						<label>Comments</label>
						<span id="sendbackToRiskUnderwritingCommentsErrorBar">&nbsp;</span>
						<div class="char-count">
							<label id="sendbackToRiskUnderwritingCommentsSizeId"><bean:message key="label.commentMaxSize" /></label>
						</div>
						<textarea class="xlarge autosize messageinput" name="acctionComments" rows="4" id="sendbackToRiskUnderwritingComments" onblur="scriptInjection(this);"></textarea>
					</div>
				</div> <!-- end of block -->
			
			</div>
		</div>
		<div class="modal-footer">
			<a href="#derivatives-table" class="btn right btn-success" data-dismiss="modal" id="sendbackToRU">Send back</a>
			<a href="#" class="btn-link right cancel" data-dismiss="modal">Close window</a>
		</div>
	</div>
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
			<button type="submit" class="btn right btn-success" data-toggle="modal" id="wantToContinue">Yes, Continue</button>
			<a href="#" class="btn-link right cancel" data-dismiss="modal">No, take me back to the request</a>
		</div>
      </div>
       <%@ include file="../common/confirmPages/saveConfirm.jsp"%>
  </body>
</html>

