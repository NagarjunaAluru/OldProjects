<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:if test="${param.includeScripts != false}">
	<%@include file="../common/ncludeRequestSectionCommonScripts.jsp" %>
	<script src="${pageContext.request.contextPath}/js/common/toWord.js" type="text/javascript"></script>
</c:if>
<s:hidden name="validationSuccess"/>

<s:url id="applySectionURL" action="applySection" namespace="/int/requestor" />
<s:url id="saveSectionURL" action="saveSection" namespace="/int/requestor" />
<s:url action="cancel.action" namespace="/int/requestor" var="cancelBtnlURL"/>
<s:url id="createLandingPageRequestURL" action="createLandingPageRequest" namespace="/int/requestor" />

<s:url id="savecontinueSectionURL" action="saveAndViewRequestForm" namespace="/int/requestor" />

<c:choose>
	<c:when test="${param.sectionId eq 'request.section.transactionParties'}">
		<div id="transactionPartiesSection">
				<jsp:include page="/jsp/common/request/transactionParties.jsp" />
				<input type="hidden" name= "sectionId" value="${param.sectionId}" />
		</div>
	</c:when>
	
	<c:when test="${param.sectionId eq 'request.section.projectDescription'}">
		<div id="projectDescSection">
				<jsp:include page="/jsp/common/request/projectDescription.jsp" />
				<input type="hidden" name= "sectionId" value="${param.sectionId}" />
		</div>
	</c:when>
	
	<c:when test="${param.sectionId eq 'request.section.instrumentDetails'}">
		<div id="instrumentDetailsSection">
				<jsp:include page="/jsp/common/request/instrumentDetails.jsp" />
				<input type="hidden" name= "sectionId" value="${param.sectionId}" />
				
		</div>
	</c:when>
	
	<c:when test="${param.sectionId eq 'request.section.instrumentRisk'}">
		<div id="instrumentRiskSection">
				<jsp:include page="/jsp/common/request/instrumentRisk.jsp" />
				<input type="hidden" name= "sectionId" value="${param.sectionId}" />
		</div>
	</c:when>
	
	<c:when test="${param.sectionId eq 'request.section.standbyLetterofCredit'}">
		<div id="standbyLetterofCreditSection">
				<jsp:include page="/jsp/common/request/standbyLOCConditions.jsp" />
				<input type="hidden" name= "sectionId" value="${param.sectionId}" />
		</div>
	</c:when>
	
	<c:when test="${param.sectionId eq 'request.section.instrumentReporting'}">
		<div id="instrumentReportingSection">
				<jsp:include page="/jsp/common/request/instrumentReportingAttributes.jsp" />
				<input type="hidden" name= "sectionId" value="${param.sectionId}" />
				
		</div>	
	</c:when>
	
	<c:when test="${param.sectionId eq 'request.section.format'}">
		<div id="formatSection">
				<jsp:include page="/jsp/common/request/format.jsp" />
				<input type="hidden" name= "sectionId" value="${param.sectionId}" />
		</div>		
	</c:when>
	
	<c:when test="${param.sectionId eq 'request.section.deliveryInstructions'}">
		<div id="deliveryInstructionsSection">
				<jsp:include page="/jsp/common/request/deliveryInstructions.jsp" />
				<input type="hidden" name= "sectionId" value="${param.sectionId}" />
				
		</div>		
	</c:when>

	<c:when test="${param.sectionId eq 'request.section.attachments'}">
		<div id="attachmentsSection" >	
				<jsp:include page="/jsp/common/request/attachments.jsp" />
				<input type="hidden" name= "sectionId" value="${param.sectionId}" /> 
		</div>			
	</c:when>
	<c:when test="${param.sectionId eq 'request.section.businessDelegation'}">
		<div id="businessDelegationSection">			
			<s:form id="businessDelegationForm" namespace="/int/requestor" action="submitToReview">
				<jsp:include page="/jsp/common/request/businessDelegation.jsp" />
				<input type="hidden" name= "sectionId" value="${param.sectionId}" />
				<input type="hidden" name= "actionType" id="actionTypeId" />
				<s:submit 
					key="label.attachment.saveAndContinueToReviewAndSubmit"
					cssClass="btn btn-success" cssStyle="margin-left: 20px;" onclick="javascript:submitAction(0);"
					/>					
				<s:submit 
					key="label.request.saveAsDraft"
					cssClass="btn btn-success" cssStyle="margin-left: 20px;" onclick="javascript:submitAction(1);"
				/>
				<a href="<s:property value="#cancelBtnlURL" />" class="btn-tertiary cancel"><s:text name="label.request.common.cancel"></s:text></a>
			</s:form> 
		</div>
	</c:when>
</c:choose>
