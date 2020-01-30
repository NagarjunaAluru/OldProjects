<%@page import="com.ge.icfp.model.DealRequest"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page errorPage="/jsp/common/error.jsp" %>
<t:common/>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/WEB-INF/config/tld/attachment" prefix="attachment"%>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<%@ taglib uri="/WEB-INF/config/tld/hwf-desktoptag.tld"
	prefix="wfdesktop"%>

<fmt:setLocale value="en-US"/>
<!DOCTYPE html>
<html lang="en">
  <head>
  	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title><bean:message key="label.transactionCapture.title"/></title>
    <meta name="description" content="">
    <meta name="author" content="">
 <%@include file="/jsp/common/includeCssScripts.jsp" %>

<% String servletContextUrl = request.getContextPath();%>
<script>//Defining the global variable, so this variable can be used by other javascript library included in this JSP 
 var contextURL = '<%=servletContextUrl%>';</script>	

<script src="<%=servletContextUrl%>/js/day2/rcaTCMOAmendIncreaseDecrease.js" type="text/javascript"></script>
	
<%String legLenforJS ="0";%>
					
<script type="text/javascript">
var legLen = '<%=legLenforJS%>';
</script>
  </head>
  <c:set var="legNumber" value="${requestScope.legNumber}" />
  <body>
	<div class="container main">
		<%@include file="/jsp/common/headerSection.jsp" %>
		<c:set var="day2legSummaryVO" value="${deal:fetchDay2LegSummary(legNumber, pageContext.request)}" scope="page"/>
		<c:set var="legSummaryVO" value="${deal:fetchLegSummary(legNumber, pageContext.request)}" scope="page"/>
		<ul class="breadcrumb">
			<li><a href="${context}/homePage.do">Home</a> <span class="divider">/</span></li>
			<li><a href="${context}/transactionCapture/transactionCaptureMOFourBlocker.do?command=load&DealRequestID=${sessionScope.deal.dealSeqId}">Transaction Capture & Closure</a> <span class="divider">/</span></li>
			<li class="active">${legSummaryVO.transactionEventType}</li>
		</ul>
		<div class="alert fade in alert-danger hide" style="display:<t:isError/>; ">
            <a href="#" data-dismiss="alert" class="close">X</a>
            <strong>Please fix the following fields highlighted in red.</strong> 
        </div>
        <div class="alert fade in alert-success hide" style="display: ${not empty requestScope.UpdateMessage ? 'block' : 'none'}">
            <a href="#" data-dismiss="alert" class="close">X</a>
            <strong>${requestScope.UpdateMessage}</strong>
        </div>
        
		<h1 class="page-title span12">${legSummaryVO.transactionEventType}</h1>
		<p class="span12 left clear dashdesc">
			Complete Increase/Decrease details below. <span class="required-fields"><span>*</span>= Required</span>
		</p>
		
		
        
		<html:form styleId="legSummary" method="post" action="/transactionCapture/transactionCaptureLeg.do" enctype="multipart/form-data">
		<input type="hidden" name="legNumber" value="${legNumber }">	
		<input type="hidden" name="legSeqId" value="${legSummaryVO.legSeqId}" />	
		<c:set var="nonStandardDocsFlag" value="${deal:getNonStandardDocsFlag(pageContext.request)}" />
		
		<jsp:include page="/jsp/day2/rca/currentLegdetails.jsp" >
			<jsp:param name="id" value="${legNumber }"/>
		</jsp:include>
		
		<div class="row highlighted">
			<div class="span5">
            <label>Activity</label>
            	<c:if test="${day2legSummaryVO.facilityTypeId eq 1}">Facility Increase</c:if>
            	<c:if test="${day2legSummaryVO.facilityTypeId eq 2}">Facility Decrease</c:if>
			</div>               
       	 </div>  
       	 
		<jsp:include page="/jsp/day2/common/originalTPTransactionDetails.jsp">
			<jsp:param name="id" value="${legNumber }"/>
		</jsp:include>
				
		<jsp:include page="/jsp/day2/common/originalTCMOLenderBorrower.jsp" >
			<jsp:param name="id" value="${legNumber }"/>
		</jsp:include>
         
			<c:if test="${day2legSummaryVO.facilityTypeId eq 1}">
        	<h2 class="span12">Amendment : Facility Increase Details</h2>
        </c:if>
        <c:if test="${day2legSummaryVO.facilityTypeId eq 2}">
        	<h2 class="span12">Amendment : Facility Decrease Details</h2>
        </c:if>
        
        <div class="clear"></div>
		<div class="row highlighted">
			<div class="span5">
				<label>Currency</label>
                 <c:if test="${not empty legSummaryVO.originalCurrency}">${legSummaryVO.originalCurrency}</c:if>
			</div>
			<div class="span5 right">
				<label>Facility <c:if test="${day2legSummaryVO.facilityTypeId eq 1}">Increase</c:if>
								<c:if test="${day2legSummaryVO.facilityTypeId eq 2}">Decrease</c:if> Amount</label>
				<c:if test="${empty day2legSummaryVO.facilityIncDecAmt}">-</c:if>
				<c:if test="${not empty day2legSummaryVO.facilityIncDecAmt}"><fmt:formatNumber value="${day2legSummaryVO.facilityIncDecAmt}" /></c:if>
			</div>
		</div>
		
		<div class="row">
			<div class="span5 right">
				<label>USD Equivalent</label>
				<c:if test="${empty day2legSummaryVO.facilityIncDecUSDEquivalentAmt}">-</c:if>
				<c:if test="${not empty day2legSummaryVO.facilityIncDecUSDEquivalentAmt}"><fmt:formatNumber value="${day2legSummaryVO.facilityIncDecUSDEquivalentAmt}" /></c:if>
			</div>
		</div>

		<div class="row highlighted">
			<div class="span5">
				<label>Current Facility Amount</label>
                   <c:if test="${empty legSummaryVO.orgAmount}">-</c:if>
					<c:if test="${not empty legSummaryVO.orgAmount}"><fmt:formatNumber value="${legSummaryVO.orgAmount}"/></c:if> 
			</div>
                    
			<div class="span5 right ">
				<label>Amended Facility Amount</label>
				<c:if test="${empty day2legSummaryVO.amendedFacilityAmt}">-</c:if>
				<c:if test="${not empty day2legSummaryVO.amendedFacilityAmt}"><fmt:formatNumber value="${day2legSummaryVO.amendedFacilityAmt}"/></c:if> 
            </div>
        </div>
        
		<div class="row">
			<div class="span5">
				<label>USD Equivalent</label>
				<c:if test="${empty legSummaryVO.usdEqui}">-</c:if>
				<c:if test="${not empty legSummaryVO.usdEqui}"><fmt:formatNumber value="${legSummaryVO.usdEqui}" /></c:if>
			</div>
			<div class="span5 right">
				<label>USD Equivalent</label>
				<c:if test="${empty day2legSummaryVO.amendedUSDEquivalentAmt}">-</c:if>
				<c:if test="${not empty day2legSummaryVO.amendedUSDEquivalentAmt}"><fmt:formatNumber value="${day2legSummaryVO.amendedUSDEquivalentAmt}" /></c:if>
			</div>
		</div>
                    
		<div class="row highlighted">
			<div class="span5">
				<label>Request Derivatives</label>
					<c:if test="${not empty legSummaryVO.derivatives}">${legSummaryVO.derivatives}</c:if>
			</div>
			<div class="span5 right">
				<label>Original Legal Agreement Attached</label>
					<c:if test="${legSummaryVO.isEventNoticeAttachedFlag eq true}">Yes</c:if>
					<c:if test="${legSummaryVO.isEventNoticeAttachedFlag eq false}">No</c:if>
			</div>       				
		</div>
				
		 <jsp:include page="../common/derivativesDetails.jsp" />
					
		 <jsp:include page="../common/tpTermsAndConditions.jsp" />
		
		 <jsp:include page="/jsp/day2/common/otherTPConsiderations.jsp" >
			<jsp:param name="id" value="${legNumber }"/>
		</jsp:include>
					
				
		<div class="form-mod">
			<h2 class="span12">${legSummaryVO.legSeqId}</h2>
			<div class="row">
				<div class="span5">
					<div class="form-row">
					<span class="required">*</span>
					<label><bean:message key="label.leg1.transactionCapturedIn" /></label>
		                <html:select styleId="selectedTransactionCapturedIn" property="selectedTransactionCapturedIn" styleClass="check" value="${legSummaryVO.selectedTransactionCapturedInId}">
					    <html:option value="">Select...</html:option>
  							<html:optionsCollection name="com.ge.icfp.StaticData" property="transactionCapturedIn" value="ID" label="name"/>						   
					</html:select>
					</div>
				</div> <!-- end of block -->
			</div>
								
			<div class="row">
				<div class="span5">
					<div class="form-row">
						<span class="required">*</span>
						<label><bean:message key="label.leg1.transactionidloanmodelid" />
						<span class="ttip info" data-original-title="<bean:message key="label.tooltip.tradeLoanmodelIDs" />"></span>
					    </label>
						<html:text property="transactionId" maxlength="50" tabindex="1" styleClass="span3" styleId="transactionId" value="${legSummaryVO.transactionId}" style="text-transform:uppercase"/>
					</div>
				</div>
			</div>
			<c:if test="${legSummaryVO.productType ne 'OTHERS'}">
			<div class="row">
				<div class="span5">
					<div class="form-row">
						<c:if test="${legSummaryVO.productType eq 'RCA'}">
							<span class="required">*</span>
						</c:if>
						<label>Facility ID/Instrument ID<span class="ttip info" data-original-title="<bean:message key="label.tooltip.facilityInstrumentIDs" />"></span></label>
						<html:text property="facilityId" maxlength="50" tabindex="1" styleClass="span3" styleId="facilityId" value="${legSummaryVO.instrumentId}" style="text-transform:uppercase"/>
					</div>
				</div>
			</div>
			</c:if>
			<c:if test="${legSummaryVO.derivatives eq 'Yes'}">
			
			<div class="row" style="display: block;">
				<div class="span12">
				<label>Derivative Trade ID(s)</label>
				 <table class="table table-striped table-bordered">
					<thead>
					  <tr>
						<th class="header" style="width:10px;">Derivative </th>
						<th class="header">Derivative Trade ID</th>
					  </tr>
					</thead>
					<tbody>
					<c:forEach var="derivativesSummaryId" items="${legSummaryVO.derivativeDetailsVOList}" varStatus="counter">
					  <tr>
						<td>${counter.count}</td>
						<td><html:text property="derivativeTradeId" maxlength="50" styleClass="span3" 
							styleId="derivativeTradeId" style="text-transform:uppercase" value="${derivativesSummaryId.derivativeTradeId}"/>
						<!-- <input type="text" class="span3"> --> </td>
					  </tr>
					</c:forEach>
					</tbody>
				  </table>
				</div>
			</div>
			
			<div class="row" style="display: block;">
				<div class="span12">
				<label>Manual Trade Request Workflow ID(s)</label>
				 <table class="table table-striped table-bordered workflow-validation">
					<thead>
					  <tr>
						<th class="header" style="width:10px;">Derivative </th>
						<th class="header">Manual Trade Request Workflow ID</th>
					  </tr>
					</thead>
					<tbody>
					<c:forEach var="derivativesId" items="${legSummaryVO.derivativeDetailsVOList}" varStatus="counter">
					  <tr>
						<td>${counter.count}</td>
						<td><span class="required">*</span><html:text property="tradeRequestWorkflowId" maxlength="50" styleClass="span3 request-exp" 
							styleId="workFlowID" value="${derivativesId.tradeRequestWorkflowId}"/>
						</td>
					  </tr>
					</c:forEach>
					</tbody>
				  </table>
				</div>
			</div>
			
			
			</c:if>
		</div> 
							
		<!-- end of form form-mod -->
		<div class="form-mod">
			<jsp:include page="/jsp/common/inc/commentsLog.jsp">
				<jsp:param name="formName" value="fourBlockerForm"/>
				<jsp:param value="transactionCapture/transactionCaptureMOFourBlocker" name="path"/>
			    <jsp:param value="Leg ${legSummaryVO.legSeqId}: Summary" name="name"/>
			    <jsp:param value="legDetails" name="method"/>
			    <jsp:param value="Transaction Capture & Closure" name="origin"/>
			    <jsp:param value="${legNumber}" name="legNumber"/>			
			</jsp:include>
			<div class="row comment-container">
				<div class="span5">
					<div class="form-row autosize-container">
						<label>Comments</label>
						<div class="char-count">500</div>
						<textarea class="xlarge autosize messageinput" name="lComments"	rows="4" onblur="scriptInjection(this);">${legSummaryVO.comments}</textarea>
					</div>
				</div>
			</div>
		</div>
		
				<!-- starts uploads-->
		<jsp:include page="/jsp/common/attachments/legPageAttachments.jsp">
		<jsp:param name="mode" value="edit" />
			<jsp:param name="legIndex" value="${legNumber}" />
		</jsp:include>  
		<!-- end uploads -->
		
		<jsp:include page="/jsp/common/inc/auditLog.jsp">
			<jsp:param name="formName" value="fourBlockerForm"/>
			<jsp:param value="transactionCapture/transactionCaptureMOFourBlocker" name="path"/>
		    <jsp:param value="Leg ${legSummaryVO.legSeqId}: Summary" name="name"/>
		    <jsp:param value="legDetails" name="method"/>
		    <jsp:param value="Transaction Capture & Closure" name="origin"/>
		    <jsp:param value="${legNumber}" name="legNumber"/>			
		</jsp:include>
		
		<!-- end of form form-mod -->
			<div class="span12 btn-container" style="margin-left:-10px!important;">
				<div class="span3 right" style="background-color: #D9EDF7;   border:1px solid #A6C2D6;padding:5px;">
					<div class="form-row" style="margin-bottom:15px;">
						<div class="radio-container conditional-required">
							<c:choose>
								<c:when test="${requestScope.proceedtoNextLeg ne 'yes'}">
									<label class="radio" style="color:#3A87AD;margin-bottom: 10px;" onmouseover="this.style.color='#348433'" onmouseout="this.style.color='#3A87AD'">
										<input type="radio" name="saveAction" value="saveNextLeg" class="condition">
										Save and go to next Leg
									</label>
								</c:when>
								<c:otherwise></c:otherwise>
							</c:choose>
							<label class="radio" style="color:#3A87AD;margin-bottom: 10px;" onmouseover="this.style.color='#348433'" onmouseout="this.style.color='#3A87AD'">
								<input type="radio" name="saveAction" value="saveReturnDeal" class="condition">
								Save and return to deal
							</label>
							
						</div>
					</div>
					<button id="saveLeg" type="submit" name="command" value="saveLeg" class="btn btn-success btn-large" style="display: block;">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Submit&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					</button>
					<button id="saveNextLeg" type="submit" name="command" value="saveNextLeg" class="btn btn-success btn-large" style="display: none;">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Submit&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					</button>
				</div>
				<c:choose>
					<c:when test="${requestScope.proceedtoNextLeg ne 'yes'}">
						<a id="saveLeg1" class="btn right save-btn single" style="margin-top: 85px;">Save</a>
						<a href="#confirm" class="btn-link right cancel modal-confirm" data-toggle="modal" style="margin-top:70px">Cancel</a>
					</c:when>
					<c:otherwise>
						<a id="saveLeg1" class="btn right save-btn single" style="margin-top: 60px;">Save</a>
						<a href="#confirm" class="btn-link right cancel modal-confirm" data-toggle="modal" style="margin-top:70px">Cancel</a>
					</c:otherwise>
				</c:choose>
				
				
					<input type="hidden" name="pType" value="${legSummaryVO.productType}">
				
			</div>
		</html:form>
    <hr>
    </div>
	<%@include  file="/jsp/common/footerSection.jsp" %>
	<!-- Modals start -->
	<div class="modal hide fade" id="confirm">
		<div class="modal-header">
			<a class="close" data-dismiss="modal">X</a>
			<h3>Cancel Leg</h3>
		</div>
		<div class="modal-body">
			<div class="row">
				<p><b>Are you sure you want to cancel?</b><br>
			Any changes you have made will be lost
			</p>
			</div>
		</div>
		<div class="modal-footer">
			<a href="${context}/transactionCapture/transactionCaptureMOFourBlocker.do?command=load&DealRequestID=${sessionScope.deal.dealSeqId}" class="btn right btn-success">Yes, cancel the Leg</a>
			<a href="#" class="btn-link right cancel" data-dismiss="modal">No, take me back to the Leg</a>
		</div>
    </div>
   
  </body>
</html>
 

