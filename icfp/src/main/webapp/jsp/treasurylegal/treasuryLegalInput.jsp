<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:common/>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="../common/error.jsp" %>
<%
	String servletContextUrl = request.getContextPath();
%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:common/>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<%@ taglib uri="/WEB-INF/config/tld/attachment" prefix="attachment"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="/WEB-INF/config/tld/hwf-desktoptag.tld"
	prefix="wfdesktop"%>

<%@ taglib prefix="security"  uri="hwf-securitytag" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>

<title><bean:message key="title.treasuryLegal" /></title>
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

<%String lastLeg = (String) request.getAttribute("proceedtoNextLeg");%>
<script type="text/javascript">
//show next leg navigation if it's not last leg
//it needs the JSP variable so placed in JSP file
$(document).ready(function() {
	$('#saveLeg1').click(function() {
		document.forms[0].action = contextURL + '/treasuryLegal/treasuryLegalLeg.do?command=saveLeg&Save=True';
		document.forms[0].submit();
	});	
	var lastLegVar = '<%=lastLeg%>';
	   if(lastLegVar=='yes')
		   {
		   $('#reviewNextLegID').hide();
		   }else {
			   $('#reviewNextLegID').show();
		   }
});
</script>
     <script src="<%=servletContextUrl%>/js/treasuryLegalInput.js" type="text/javascript"></script>
     
			
		<c:set var="legSummaryVO" value="${deal:fetchLegSummary(param.id, pageContext.request)}" scope="page"/>
		<div id="validateFlag" style="display:none;" class="alert fade in alert-danger hide">
            <a href="#" data-dismiss="alert" class="close">X</a>
            <strong>Please fix the following fields highlighted in red.</strong> 
        </div>
        <div class="alert fade in alert-success hide" style="display: ${not empty requestScope.UpdateMessage ? 'block' : 'none'}">
            <a href="#" data-dismiss="alert" class="close">X</a>
            <strong>${requestScope.UpdateMessage}</strong>
         </div>
         <div class="alert fade in alert-danger hide" style="display: ${not empty requestScope.atmtError ? 'block' : 'none'}">
             <a href="#" data-dismiss="alert" class="close">X</a>
             <strong>${requestScope.atmtError}</strong> 
        </div>
        
        <div class="alert fade in alert-success hide" style="display: ${requestScope.save eq 'success' ? 'block' : 'none'}">
            <a href="#" data-dismiss="alert" class="close">X</a>
            <strong>You have successfully updated the leg for this transaction.</strong> 
        </div>
		
		<form id="legSummary" action="${context}/treasuryLegal/treasuryLegalLeg.do" method="post"   enctype="multipart/form-data">
			<input type="hidden" name="legNumber" value="${ param.id }">
			<c:set var="nonStandardDocsFlag" value="${deal:getNonStandardDocsFlag(pageContext.request)}" />
			<c:choose>
			<c:when test="${param.pType ne 'CPA'}">
			<%@ include file="../common/inc/transactionSummary.jsp"%>
			
			<jsp:include page="../common/inc/detailSummary.jsp" >
				<jsp:param value="treasuryLegal" name="page"/>
			</jsp:include>
			
			<c:choose>
				<c:when test="${legSummaryVO.legTypeId eq 4}">
				<h2 class="span12">Description</h2>
				<div class="form-mod">
				 	<div class="row">
						<div class="span12">
							<div class="form-row autosize-container">
								<span class="required"></span>
								${deal:getOtherDescription(pageContext.request)}
								</div>
						</div> <!-- end of block -->
					</div>
				</div>
				</c:when>
			 </c:choose>

				<c:if test="${legSummaryVO.productType eq 'EQUITY'}">
					<%@ include file="../common/inc/equityDetails.jsp" %>
				</c:if>
			
			<jsp:include page="../common/inc/transactionLegDetails.jsp" >
				<jsp:param value="treasuryLegal" name="page"/>
			</jsp:include>
			
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
			
			<jsp:include page="../common/inc/qualitativeAssessment_LegSummary.jsp">
				<jsp:param name="factors" value="Legal Risk"/>			
				<jsp:param value="RCA" name="legType"/>
			</jsp:include>
			</c:when>
			<c:otherwise>
				<jsp:include page="../common/inc/cpaRequestDetailInput.jsp" >
					<jsp:param value="treasuryLegal" name="page"/>
				</jsp:include>
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
				<jsp:include page="../common/inc/qualitativeAssessment_LegSummary.jsp">
					<jsp:param name="factors" value="Legal Risk"/>
					<jsp:param value="CPA" name="legType"/>
				</jsp:include>
			</c:otherwise>
			</c:choose>
			<!-- end of form form-mod -->

			<div class="form-mod">
				<jsp:include page="../common/inc/commentsLog.jsp">
				    <jsp:param name="formName" value="fourBlockerForm"/>			
					<jsp:param value="treasuryLegal/treasuryLegal" name="path"/>
			        <jsp:param value="Leg ${legSummaryVO.legSeqId}: Summary" name="name"/>
			        <jsp:param value="legDetails" name="method"/>
			        <jsp:param value="Treasury Legal" name="origin"/>	
			        <jsp:param value="${legSummaryVO.legNumber}" name="legNumber"/>		
				</jsp:include>
				<div class="row comment-container">
					<div class="span5">
						<div class="form-row autosize-container">
							 <label><bean:message key="treasuryLegal.comments" /></label>
							<div class="char-count">500</div>
							<textarea class="xlarge autosize messageinput" name="lComments"	rows="4" onblur="scriptInjection(this);">${legSummaryVO.comments}</textarea>
						</div>
					</div>
					<!-- end of block -->
				</div>
			</div>
			<c:choose>
			<c:when test="${param.pType ne 'CPA'}">
				    		
					<!-- starts uploads-->
					<jsp:include page="/jsp/common/attachments/legPageAttachments.jsp">
						<jsp:param name="mode" value="edit" />
						<jsp:param name="legIndex" value="${legNumber}" />
					</jsp:include> 
					<!-- end uploads -->
			</c:when>
			<c:otherwise>
				
					<!-- starts uploads-->
					<jsp:include page="/jsp/common/attachments/cpaLegPageAttachments.jsp">
						<jsp:param name="mode" value="edit" />
					</jsp:include> 
					<!-- end uploads -->
			</c:otherwise>
			</c:choose>
			<!-- end of form form-mod -->
			<!-- end of form form-mod -->
			<jsp:include page="../common/inc/auditLog.jsp">
			    <jsp:param name="formName" value="fourBlockerForm"/>			
				<jsp:param value="treasuryLegal/treasuryLegal" name="path"/>
			    <jsp:param value="Leg ${legSummaryVO.legSeqId}: Summary" name="name"/>
			    <jsp:param value="legDetails" name="method"/>
			    <jsp:param value="Treasury Legal" name="origin"/>
			    <jsp:param value="${legSummaryVO.legNumber}" name="legNumber"/>			
			</jsp:include>
			<input type="hidden" name="legSeqId" value="${legSummaryVO.legSeqId}" />
			<div class="span12 btn-container" style="margin-left:-10px!important;">
				<c:if test="${sessionScope.section eq 'myTasks'}">
				<div class="span3 right" style="background-color: #D9EDF7;   border:1px solid #A6C2D6;padding:5px;">
					<div class="form-row" style="margin-bottom:15px;">
						<div id="saveRadioDiv" class="radio-container conditional-required">
							<label class="radio" style="color:#3A87AD;margin-bottom: 10px;" onmouseover="this.style.color='#348433'" onmouseout="this.style.color='#3A87AD'" id="reviewNextLegID">
								<input type="radio" name="saveAction" value="saveNextLeg" class="condition">
								Save and go to next Leg
							</label>
							<label class="radio" style="color:#3A87AD;margin-bottom: 10px;" onmouseover="this.style.color='#348433'" onmouseout="this.style.color='#3A87AD'">
								<input type="radio" name="saveAction" value="saveReturnDeal" class="condition">
								<c:choose>
								<c:when test="${param.pType eq 'CPA'}">
								Save and return to request
								</c:when>
								<c:otherwise>
								Save and return to deal
								</c:otherwise>
								</c:choose>
							</label>
							
						</div>
					</div>
					
					<input type="button" class="btn btn-success btn-large" onclick="javascript:saveTLegal(this);"
					value="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Submit&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" />
					
				</div>
				<c:choose>
					<c:when test="${requestScope.proceedtoNextLeg ne 'yes'}">
						<a id="saveLeg1" class="btn right save-btn single" style="margin-top: 85px;">Save</a>
						<a href="#confirm" class="btn-link right cancel modal-confirm" data-toggle="modal" style="margin-top:95px">Cancel</a>
					</c:when>
					<c:otherwise>
						<a id="saveLeg1" class="btn right save-btn single" style="margin-top: 60px;">Save</a>
						<a href="#confirm" class="btn-link right cancel modal-confirm" data-toggle="modal" style="margin-top:70px">Cancel</a>
					</c:otherwise>
				</c:choose>
				</c:if>
				<c:if test="${sessionScope.section eq 'myAssignedTasks'}">
				<a href="#confirm" class="btn-link right cancel modal-confirm" data-toggle="modal" style="margin-top:95px">Cancel</a>
				</c:if>
			</div>
			<c:choose>
				<c:when test="${param.pType ne 'CPA'}">
					<input type="hidden" name="pType" value="${legSummaryVO.productType}">
				</c:when>
				<c:otherwise>
					<input type="hidden" name="pType" value="${legSummaryVO.product}">
				</c:otherwise> 
			</c:choose>
		
		<hr>
	<div class="modal hide fade" id="confirm">
		<div class="modal-header">
			<a class="close"  href="javascript:closeConfirmModal()">X</a>
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
			<a href="${context}/treasuryLegal/treasuryLegal.do?command=load&DealRequestID=${sessionScope.deal.dealSeqId}" class="btn right btn-success">Yes, cancel the Leg</a>
			<a  href="javascript:closeConfirmModal()" class="btn-link right cancel">No, take me back to the Leg</a>
		</div>
      </div>
</form>