<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="../common/error.jsp" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en-US"/>
<%
	String servletContextUrl = request.getContextPath();
%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:common/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<%@ taglib uri="/WEB-INF/config/tld/attachment" prefix="attachment"%>
<%@ taglib uri="/WEB-INF/config/tld/hwf-desktoptag.tld"
	prefix="wfdesktop"%>

<%@ taglib prefix="security"  uri="hwf-securitytag" %>

<title>ICF | Regulatory/Jurisdictional Reviews</title>
<meta name="description" content="">
<meta name="author" content="">
<script type="text/javascript">
//Defining the global variable, so this variable can be used by other javascript library included in this JSP 
 var contextURL = '<%=servletContextUrl%>';
</script>
<script type="text/javascript" src="<%=servletContextUrl%>/js/cpa/countryTaxInput.js"></script>
<%String lastLeg = (String) request.getAttribute("proceedtoNextLeg");%>
	
<%String legLenforJS ="0";%> 
					
<script type="text/javascript">
var legLen = '<%=legLenforJS%>';
//Show next leg navigation based on lastLeg value
//it needs the JSP variable so placed in JSP file
$(document).ready(function() {
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

		<div id="validateFlag" style="display:none;" class="alert fade in alert-danger hide">
            <a href="#" data-dismiss="alert" class="close">X</a>
            <strong>Please fix the following fields highlighted in red.</strong> 
        </div>
        
        <div class="alert fade in alert-success hide" style="display: ${requestScope.save eq 'success' ? 'block' : 'none'}">
            <a href="#" data-dismiss="alert" class="close">X</a>
            <strong>You have successfully updated the leg for this transaction.</strong> 
        </div>
        <div class="alert fade in alert-success hide" style="display: ${not empty requestScope.UpdateMessage ? 'block' : 'none'}">
            <a href="#" data-dismiss="alert" class="close">X</a>
            <strong>${requestScope.UpdateMessage}</strong>
         </div>
         <div class="alert fade in alert-danger hide" style="display: ${not empty requestScope.atmtError ? 'block' : 'none'}">
            <a href="#" data-dismiss="alert" class="close">X</a>
            <strong>${requestScope.atmtError}</strong> 
        </div>
         
		<form name="legSummary" id="legSummary"  action="${context}/countryTax/countryTaxLeg.do" method="POST" enctype="multipart/form-data">
			<input type="hidden" name="legNumber" value="${ param.id }">
			<c:set var="nonStandardDocsFlag" value="${deal:getNonStandardDocsFlag(pageContext.request)}" />
			<jsp:include page="../../common/inc/cpaRequestDetailInput.jsp" >
				<jsp:param value="countryTax" name="page"/>
			</jsp:include>
			<c:choose>
				<c:when test="${nonStandardDocsFlag eq 'Yes'}">
					<jsp:include page="/jsp/common/legPageExceptions.jsp">
						<jsp:param value="view" name="mode"/>
						<jsp:param value="${legNumber}" name="legIndex"/>      	
				      </jsp:include>
				</c:when>
				<c:otherwise>
				</c:otherwise>
			</c:choose>
			<!-- end of form form-mod -->
			
			<jsp:include page="../../common/inc/qualitativeAssessment_LegSummary.jsp">
				<jsp:param name="factors" value="Regulatory/Jurisdictional Reviews Risk"/>	
				<jsp:param value="CPA" name="legType"/>		
			</jsp:include>
			<!-- end of form form-mod -->
			<div class="form-mod">
				<jsp:include page="../../common/inc/commentsLog.jsp">
					<jsp:param name="formName" value="fourBlockerForm"/>
					<jsp:param value="countryTax/countryTax" name="path"/>
			        <jsp:param value="Leg ${legSummaryVO.legSeqId}: Summary" name="name"/>
			        <jsp:param value="legDetails" name="method"/>
			        <jsp:param value="Regulatory/Jurisdictional Reviews" name="origin"/>
			        <jsp:param value="${legSummaryVO.legNumber}" name="legNumber"/>			
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
			<jsp:include page="/jsp/common/attachments/cpaLegPageAttachments.jsp">
				<jsp:param name="mode" value="edit" />
			</jsp:include> 
			<!-- end uploads -->
			<jsp:include page="../../common/inc/auditLog.jsp">
				<jsp:param name="formName" value="fourBlockerForm"/>
				<jsp:param value="countryTax/countryTax" name="path"/>
			    <jsp:param value="Leg ${legSummaryVO.legSeqId}: Summary" name="name"/>
			    <jsp:param value="legDetails" name="method"/>
			    <jsp:param value="Regulatory/Jurisdictional Reviews" name="origin"/>
			    <jsp:param value="${legSummaryVO.legNumber}" name="legNumber"/>
			</jsp:include>
			<input type="hidden" name="legSeqId" value="${legSummaryVO.legSeqId}" />
			<!-- end of form form-mod -->
			<div class="span12 right btn-container" style="margin-left: -20px;">
				<c:if test="${sessionScope.section eq 'myTasks'}">
				<div class="span3 right" style="background-color: #D9EDF7;   border:1px solid #A6C2D6;padding:5px;">
					<div class="form-row" style="margin-bottom:15px;">
						<div id="saveRadioDiv" class="radio-container conditional-required">
							<label class="radio" id="reviewNextLegID"  style="color:#3A87AD;margin-bottom: 10px;"  onmouseover="this.style.color='#348433'" onmouseout="this.style.color='#3A87AD'" >
								<input type="radio" name="saveAction" value="saveNextLeg" class="condition">
								Save and go to next Leg
							</label>
							<label class="radio" style="color:#3A87AD;margin-bottom: 10px;" onmouseover="this.style.color='#348433'" onmouseout="this.style.color='#3A87AD'">
								<input type="radio" name="saveAction" value="saveReturnDeal" class="condition">
								Save and return to request
							</label>
						</div>
					</div>
					
					<button  type="button" name="command" value="saveLeg"  id="submitID" onclick="javascript:saveCountryTax();" 
					class="btn btn-success btn-large" style="display: block;width: 80%;">Submit</button>
					
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
			<input type="hidden" name="pType" value="${legSummaryVO.product}">
		</form>
		<hr>

	<!-- Modals start -->
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
			<a href="${context}/countryTax/countryTax.do?command=load&DealRequestID=${sessionScope.deal.dealSeqId}" class="btn right btn-success">Yes, cancel the Leg</a>
			<a href="javascript:closeConfirmModal()" class="btn-link right cancel">No, take me back to the Leg</a>
		</div>
      </div>

