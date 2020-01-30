<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<fmt:setLocale value="en-US"/>
<%	String servletContextUrl = request.getContextPath();%>
<script> 
var servletContextUrl = '<%=servletContextUrl%>';
</script>
<script type="text/javascript" src="<%=servletContextUrl%>/js/day2/timeline.js"></script>
<%
String addOrMofifyJS = (String)request.getSession().getAttribute("addOrModifyFlag");
String legLenforJS ="0";
if(addOrMofifyJS==null) {
	legLenforJS ="1"; 
} else {
	legLenforJS ="0";
}

%>

<script src="<%=servletContextUrl%>/js/rcaRequestor.js" type="text/javascript"></script>
<script src="<%=servletContextUrl%>/js/bootstrap-typeahead.js" type="text/javascript"></script>

	<html:form action="/RCALegRequest.do" styleId="ICFPLegRequestForm" method="post" enctype="multipart/form-data">
		<c:set var="legNumber" value="${sessionScope.ICFPLegRequestForm.map['legNumber']}" />
		<input type="hidden" id="legNumberID" name="legNumber" value="<bean:write name="ICFPLegRequestForm" property="legNumber" />" />
		<input type="hidden"  id="derivativeNumber" name="derivativeNumber" />
		
				
		<jsp:include page="originalTransactionUsd.jsp" />
		<jsp:include page="originalLenderBorrower.jsp" />
		
		<!-- General Amendments -->
		<jsp:include page="/jsp/common/legPageAmendments.jsp">
			<jsp:param value="edit" name="mode"/>
			<jsp:param value="${legNumber}" name="legIndex"/>
		</jsp:include>
         
        <div class="row">
			<div class="span5">
				<div class="form-row">
                   	<span class="required">*</span>
					<label>Original Legal Agreement Attached</label>
					<div id="originalAgmtDiv" class="radio-container">
						<label class="radio">
							<html:radio name="ICFPLegRequestForm" styleClass="condition" property="legSummary.eventNoticeAttachedFlag" styleId="isOrigLegalAgreementAttachedFlag" value="true"/>
							<bean:message key="label.addLeg.yes" />
						</label>
						<label class="radio">
							<html:radio name="ICFPLegRequestForm" property="legSummary.eventNoticeAttachedFlag" styleId="isOrigLegalAgreementAttachedFlag" value="false"/>
							<bean:message key="label.addLeg.no" />
						</label>
					</div> 
				</div>
			</div> <!-- end of block --> 
		</div>        
        <div class="row">
			<div class="span5">
				<div class="form-row">
                     <span class="required">*</span>
 					<label>Request Derivatives</label>
					<span  class="help-block error" id="derivativesfailed" style="display:none;">Please select Request Derivatives</span>
					<div id="derivativDiv" class="radio-container derivativesConditional">
						<label class="radio">
							<html:radio name="ICFPLegRequestForm" property="legSummary.derivativesFlag" styleId="derivativesFlag" value="true" styleClass="condition"/>
							<bean:message key="label.addLeg.yes" />
						</label>
						<label class="radio">
							<html:radio name="ICFPLegRequestForm" property="legSummary.derivativesFlag" styleId="derivativesFlag" value="false"/>
							<bean:message key="label.addLeg.no" />
						</label>
					</div>                               
				</div>
			</div> <!-- end of block -->
		</div>        
		
		<jsp:include page="rcaDerivativesCommon.jsp" />	 
                
		<jsp:include page="termsAndConditions.jsp" />
		<jsp:include page="otherConsiderations.jsp" />
        
                
		        
		       		
				 <!-- starts uploads-->
		<jsp:include page="/jsp/common/attachments/legPageAttachments.jsp">
		<jsp:param name="mode" value="edit" />
			<jsp:param name="legIndex" value="${legNumber}" />
		</jsp:include>  
		<!-- end uploads -->

		<div class="span12 right btn-container" style="margin-left: -20px;">
			<c:if test="${sessionScope.section eq 'myTasks'}">
				<input type="button" value="Save and return to Deal" class="btn right btn-success" onclick="javascript:validateGenAmendment('?command=saveAndReturnToDeal');">
            	<input type="button" value="Save" class="btn right" onclick="javascript:saveLeg('?command=saveAsDraft');">
			</c:if>
			<c:if test="${sessionScope.section eq 'myRequests'}">
				<c:choose>
						<c:when test="${empty deal.WFStage}">
						<c:if test="${deal.action eq 'Draft' || deal.action eq 'DRAFT' || empty deal.action}"> 
							<input type="button" value="Save and return to Deal" class="btn right btn-success" onclick="javascript:validateGenAmendment('?command=saveAndReturnToDeal');">
           					<input type="button" value="Save" class="btn right" onclick="javascript:saveLeg('?command=saveAsDraft');">
						</c:if>
						</c:when>
				</c:choose>
			</c:if>
			
			<a href="#confirm" class="btn-link right cancel modal-confirm" data-toggle="modal">Cancel</a>            
		</div>
		
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
				<a href="javascript:redirectFundingRequest('?command=redirectFundingRequest');" class="btn right btn-success">Yes, cancel the leg</a>
				<a href="javascript:closeConfirmModal()" class="btn-link right cancel" >No, take me back to the leg</a>
			</div>
		</div>
		
		<input type="hidden" id="actionId" value="${actionId}">
</html:form>

