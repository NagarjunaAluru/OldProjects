<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<c:if test="${param.includeScripts != false}">
	<%@include file="../../common/includeCommonScripts.jsp" %>
	<script src="${pageContext.request.contextPath}/js/requestor/requestor.js" type="text/javascript"></script>
</c:if>

<c:choose>
	<c:when test="${param.sectionId eq 'request.section.transactionParties'}">

		<div id="transactionPartiesSection">
				<jsp:include page="/jsp/common/request/bgBidTransactionParties.jsp" />
				<input type="hidden" name= "sectionId" value="${param.sectionId}" />
		</div>
	</c:when>
	
	<c:when test="${param.sectionId eq 'request.section.instrumentDetails'}">
		
		<div id="instrumentDetailsSection">
				<jsp:include page="/jsp/common/request/instrumentDetails.jsp" />
				<input type="hidden" name= "sectionId" value="${param.sectionId}" />
		</div>
	</c:when>
	
	<c:when test="${param.sectionId eq 'request.section.standbyLetterofCredit'}">
		<div id="standbyLetterofCreditSection">
				<jsp:include page="/jsp/common/request/standbyLOCConditions.jsp" />
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
	
	<c:when test="${param.sectionId eq 'request.section.bidMemoDetails'}">
		<div id="bidMemoDetailsSection">
				<jsp:include page="/jsp/common/request/bidMemoCreationDetails.jsp" />
				<input type="hidden" name= "sectionId" value="${param.sectionId}" />
		</div>		
	</c:when>
	
	<c:when test="${param.sectionId eq 'request.section.pricingDetails'}">
		<div id="pricingDetailsSection">
				<jsp:include page="/jsp/common/request/pricingDetails.jsp" />
				<input type="hidden" name="sectionId" value="${param.sectionId}" />
		</div>
	</c:when>
	
	<c:when test="${param.sectionId eq 'request.section.additionalInstrumentDetails'}">
		<div id="additionalInstrumentDetailsSection">
				<jsp:include page="/jsp/common/request/additionalInstrumentDetails.jsp" />
				<input type="hidden" name= "sectionId" value="${param.sectionId}" />
		</div>		
	</c:when>
	
	<c:when test="${param.sectionId eq 'request.section.bankSelection'}">
		<div id="bankSelectionSection">
				<jsp:include page="/jsp/common/request/bankSelection.jsp" />
				<input type="hidden" name= "sectionId" value="${param.sectionId}" />
		</div>		
	</c:when>

</c:choose>
