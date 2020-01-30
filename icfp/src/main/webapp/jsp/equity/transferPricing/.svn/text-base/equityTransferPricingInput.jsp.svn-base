<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<t:common/>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String servletContextUrl = request.getContextPath();
%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:common/>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="/WEB-INF/config/tld/attachment" prefix="attachment"%>
<fmt:setLocale value="en-US"/>
<%@ taglib uri="/WEB-INF/config/tld/hwf-desktoptag.tld"
	prefix="wfdesktop"%>

<%@ page errorPage="../common/error.jsp" %>
<%@ taglib prefix="security"  uri="hwf-securitytag" %>

<title>ICF | Transfer Pricing</title>
<meta name="description" content="">
<meta name="author" content="">
<script type="text/javascript">
//Defining the global variable, so this variable can be used by other javascript library included in this JSP 
 var contextURL = '<%=servletContextUrl%>';
</script>
	
<%String legLenforJS ="0";%>
					
<script type="text/javascript">
var legLen = '<%=legLenforJS%>';
</script>

<script src="<%=servletContextUrl%>/js/equityDay1TransferPricing.js" type="text/javascript"></script>


<%String lastLeg = (String) request.getAttribute("proceedtoNextLeg");%>

<script type="text/javascript">

$(document).ready(function() {
	//show next leg navigation if it is not last leg
	//it needs the JSP variable so placed in JSP file
	var lastLegVar = '<%=lastLeg%>';
	   if(lastLegVar=='yes')
		   {
		   $('#reviewNextLegID').hide();
		   }else {
			   $('#reviewNextLegID').show();
		   }
});

</script>	

		<c:set var="legSummaryVO" value="${deal:fetchLegSummary(param.id, pageContext.request)}" scope="page"/>
		
        <div class="alert fade in alert-success hide" style="display: ${requestScope.save eq 'success' ? 'block' : 'none'}">
            <a href="#" data-dismiss="alert" class="close">X</a>
            <strong>You have successfully updated the leg for this transaction.</strong> 
        </div>
        <logic:messagesPresent >
		       <div class="alert fade in alert-danger show" >
            		<a href="#" data-dismiss="alert" class="close">X</a>
            	<strong>Please fix the following fields highlighted in red.</strong> 
        	   </div>
         </logic:messagesPresent>        
		<form id="legSummary" action="${context}/transferPricing/equityTransferPricing.do" method="post"   enctype="multipart/form-data">
			<input type="hidden" name="legNumber" value="${ param.id }">
			<c:set var="nonStandardDocsFlag" value="${deal:getNonStandardDocsFlag(pageContext.request)}" />
			<%@ include file="../../common/inc/transactionSummary.jsp"%>
			
			<jsp:include page="../../common/inc/detailSummary.jsp" >
				<jsp:param value="transferPricing" name="page"/>
			</jsp:include>
	
				<c:if test="${legSummaryVO.productType eq 'EQUITY'}">
					<c:if test="${not empty deal:getEquityFormId(requestScope.legNumber, pageContext.request)}">
						<div>
						<h3 class="span12">Equity Details</h3>
						<div class="row">
						<div class="span12">
						 <table class="table table-striped table-bordered equity-validation">
							<thead>
							  <tr>
								<th class="header" style="width:35px;">Action</th>
								<c:if test="${deal:getEquityFormId(requestScope.legNumber, pageContext.request) eq 'Debt To Equity'}">
									<th class="header">Debt terms</th>
								</c:if>
								<th class="header">Share type</th>
								<th class="header">Number of shares</th>
								<th class="header">Par value per share</th>
							  </tr>
							</thead>
							<tbody>	
							<c:forEach var="shareInfo" items="${deal:getShareInfoList((requestScope.legNumber), pageContext.request)}" varStatus="itemNo">
								<tr>
									  <td>-</td>
									  <c:if test="${deal:getEquityFormId(requestScope.legNumber, pageContext.request) eq 'Debt To Equity'}">
									  	<td>${shareInfo.debtTerms}</td>
									  </c:if>
									  <td>${shareInfo.shareType}</td>
									   <td><fmt:formatNumber value="${shareInfo.numberOfShares}" /></td>
									  <td><fmt:formatNumber value="${shareInfo.shareValue}" /></td>
							    </tr>
							</c:forEach>
							</tbody>
							</table>
							</div>
							</div>
							</div>
					</c:if>
							
					<c:if test="${deal:getEquityFormId(requestScope.legNumber, pageContext.request) eq 'Debt To Equity'}">	
						<h3 class="span12">Description</h3>
						<div class="row comment-container">
							<div class="span5">
								<div class="form-row autosize-container">
									<span class="required"></span>
									<label>&nbsp;</label>
									<div class="char-count">1000</div>
										<textarea class="xlarge autosize messageinput" name="otherEquityComments" rows="4" id="dealCommentsId" data-max="1000" onblur="scriptInjection(this);">${requestScope.OtherComments}</textarea>
									</div>
							</div> <!-- end of block -->
						</div>
					</c:if>
					<c:if test="${deal:getEquityFormId(requestScope.legNumber, pageContext.request) eq 'Other'}">	
						<div class="row">
							<div class="span5">
									<h3 class="span12">Description</h3>
			                             ${deal:getOtherEquityComments(requestScope.legNumber, pageContext.request)}
							</div> <!-- end of block -->
						</div>
				    </c:if>
				</c:if>
			
			<jsp:include page="../../common/inc/transactionLegDetails.jsp" >
				<jsp:param value="transferPricing" name="page"/>
			</jsp:include>
			<!-- end of form form-mod -->
			<c:choose>
				<c:when test="${nonStandardDocsFlag eq 'Yes'}">
				<c:if test="${fn:length(legSummaryVO.exceptions) >0 }">
					<jsp:include page="/jsp/common/legPageExceptions.jsp">
						<jsp:param value="view" name="mode"/>
						<jsp:param value="${legNumber}" name="legIndex"/>      	
				      </jsp:include>
				</c:if>
					
				</c:when>
				<c:otherwise>
				</c:otherwise>
			</c:choose>

			<!-- end of form form-mod -->
			
			<div class="form-mod">
				<jsp:include page="../../common/inc/commentsLog.jsp">
					<jsp:param name="formName" value="fourBlockerForm"/> 
					<jsp:param value="transferPricing/transferPricing" name="path"/>
			        <jsp:param value="Leg ${legSummaryVO.legSeqId}: Summary" name="name"/>
			        <jsp:param value="legDetails" name="method"/>
			        <jsp:param value="Transfer Pricing" name="origin"/>
			        <jsp:param value="${legSummaryVO.legNumber}" name="legNumber"/>
				</jsp:include>
				<div class="row comment-container">
					<div class="span5">
						<div class="form-row autosize-container">
							<label>Comments</label>
							<div class="char-count">500</div>
							<textarea class="xlarge autosize messageinput" name="lComments"	rows="4" id="dealCommentsId" onblur="scriptInjection(this);">${legSummaryVO.comments}</textarea>
						</div>
					</div>
					<!-- end of block -->
				</div>
			</div>
			<!-- end of form form-mod -->
			<jsp:include page="/jsp/common/attachments/legPageAttachments.jsp">
        	<jsp:param name="mode" value="edit" />
        	<jsp:param name="legIndex" value="${legNumber}" />
        	</jsp:include>  
      	
			<jsp:include page="../../common/inc/auditLog.jsp">
				<jsp:param name="formName" value="fourBlockerForm"/>
				<jsp:param value="transferPricing/transferPricing" name="path"/>
			    <jsp:param value="Leg ${legSummaryVO.legSeqId}: Summary" name="name"/>
			    <jsp:param value="legDetails" name="method"/>
			    <jsp:param value="Transfer Pricing" name="origin"/>			
			    <jsp:param value="${legSummaryVO.legNumber}" name="legNumber"/>	
			</jsp:include>
			<input type="hidden" name="legSeqId" value="${legSummaryVO.legSeqId}" />
			<c:if test="${sessionScope.section eq 'myTasks'}">
			   <div class="span12 btn-container" style="margin-left:-10px!important;">
				<div class="span3 right" style="background-color: #D9EDF7;   border:1px solid #A6C2D6;padding:5px;">
					<div class="form-row" style="margin-bottom:15px;">
						<div id="saveRadioDiv" class="radio-container conditional-required">
							<label class="radio" style="color:#3A87AD;margin-bottom: 10px;" onmouseover="this.style.color='#348433'" onmouseout="this.style.color='#3A87AD'" id = "reviewNextLegID">
								<input type="radio" name="saveAction" value="saveNextLeg" class="condition">
								Save and go to next Leg
							</label>
							<label class="radio" style="color:#3A87AD;margin-bottom: 10px;" onmouseover="this.style.color='#348433'" onmouseout="this.style.color='#3A87AD'">
								<input type="radio" name="saveAction" value="saveReturnDeal" class="condition">
								Save and return to deal
							</label>
							
						</div>
					</div>
					
					<input type="button" value="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Submit&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" 
					class="btn btn-success btn-large" onclick="javascript:saveEquityTP(this);">
					
				</div>
				<a id="saveLeg1" class="btn right save-btn single" style="margin-top: 55px;">
				Save
				</a>	
				<a href="#confirm" class="btn-link right cancel modal-confirm" data-toggle="modal" style="margin-top:55px">Cancel</a>			
			</div>
			</c:if>
			<c:if test="${sessionScope.section eq 'myAssignedTasks'}">
			  
			   <div class="span12 right btn-container">
			   <a href="#confirm" class="btn-link right cancel modal-confirm" data-toggle="modal" style="margin-top:55px">Cancel</a>
				
				</div>
			</c:if>
			<input type="hidden" name="pType" value="${param.pType}">
		</form>
		<hr>
	
	
	<div class="modal hide fade" id="confirm">
		<div class="modal-header">
			<a class="close" href="javascript:closeConfirmModal()">X</a>
			<h3>Cancel Leg</h3>
		</div>
		<div class="modal-body" style="margin-top:-16px;">
			<div class="row">
				<p><b>Are you sure you want to cancel?</b><br>
			Any changes you have made will be lost
			</p>
			</div>
		</div>
		<div class="modal-footer">
			<a href="${context}/transferPricing/transferPricing.do?command=load&DealRequestID=${sessionScope.deal.dealSeqId}" class="btn right btn-success">Yes, cancel the Leg</a>
			<a href="javascript:closeConfirmModal()" class="btn-link right cancel">No, take me back to the Leg</a>
		</div>
      </div>
