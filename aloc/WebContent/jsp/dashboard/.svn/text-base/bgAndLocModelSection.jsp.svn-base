<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<!DOCTYPE html>
<c:if test="${param.includeScripts != false}">
<html>
  <head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<%@include file="../common/includeCommonScripts.jsp" %>
	<script src="${pageContext.request.contextPath}/js/requestor/requestor.js" type="text/javascript"></script>
</head>
<body>
</c:if>

<s:set name="isEditMode" value="editMode"/>
<s:hidden name="currentSectionId" id="currentSectionId"/>
<c:choose>
	<c:when test="${param.sectionId eq 'request.section.transactionParties'}">
		<div id="transactionPartiesSection">
		<jsp:include page="/jsp/common/request/transactionParties.jsp" />
		<input type="hidden" name= "sectionId" value="${param.sectionId}" />
	</div>
	</c:when>	
	<c:when test="${param.sectionId eq 'request.section.projectDescription'}">
		<div id="projectDescriptionSection">
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
	
	<c:when test="${param.sectionId eq 'request.section.deliveryInstructions'}">
		<div id="deliveryInstructionsSection">
				<jsp:include page="/jsp/common/request/deliveryInstructions.jsp" />
				<input type="hidden" name= "sectionId" value="${param.sectionId}" />
		</div>		
	</c:when>

</c:choose>
<c:if test="${param.includeScripts != false}">
	</body>
	</html>
</c:if>