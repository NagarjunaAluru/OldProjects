<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:if test="${param.includeScripts != false}">
<!DOCTYPE html>
<html>
<head>
 <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%@include file="../../common/includeCommonScripts.jsp"%>
<script
	src="${pageContext.request.contextPath}/js/requestor/requestor.js"
	type="text/javascript"></script>
</head>
<body>
</c:if>

<s:set name="isEditMode" value="editMode" />
<s:hidden name="currentSectionId" id="currentSectionId" />
<c:choose>
	<c:when test="${param.sectionId eq 'request.section.transactionParties'}">
		<div id="transactionPartiesSection">
				<jsp:include page="/jsp/common/request/bgBidTransactionParties.jsp" >
					<jsp:param name="nameAndAddressOnly" value="false"></jsp:param>
				</jsp:include>
				<input type="hidden" name="sectionId" value="${param.sectionId}" />
		</div>
	</c:when>
	
	<c:when test="${param.sectionId eq 'request.section.instrumentDetails'}">
		<div id="instrumentDetailsSection">
				<jsp:include page="/jsp/common/request/instrumentDetails.jsp" >
					<jsp:param name="page" value="BGBidReply" />
			    </jsp:include>
				<input type="hidden" name="sectionId" value="${param.sectionId}" />
		</div>
	</c:when>
	
	<c:when test="${param.sectionId eq 'request.section.standbyLocConditions'}">
		<div id="standbyLocConditionsSection">
				<jsp:include page="/jsp/common/request/standbyLOCConditions.jsp" />
				<input type="hidden" name="sectionId" value="${param.sectionId}" />
		</div>
	</c:when>
	
	<c:when test="${param.sectionId eq 'request.section.bidReplyDetails'}">
		<div id="bgBidReplyDetailsSection">
				<jsp:include page="/jsp/common/request/bidReplyDetails.jsp" />
				<input type="hidden" name="sectionId" value="${param.sectionId}" />
		</div>
	</c:when>
	
	<c:when test="${param.sectionId eq 'request.section.issuingBankBranch'}">
		<div id="issuingBankBranchSection">
				<jsp:include page="/jsp/common/request/bgBidReplyIssuingBank.jsp" />
				<input type="hidden" name="sectionId" value="${param.sectionId}" />
		</div>
	</c:when>
	
	<c:when test="${param.sectionId eq 'request.section.pricingDetails'}">
		<div id="pricingDetailsSection">
				<jsp:include page="/jsp/common/request/pricingDetails.jsp" />
				<input type="hidden" name="sectionId" value="${param.sectionId}" />
		</div>
	</c:when>
	
		<c:when test="${param.sectionId eq 'request.section.preAgreedPricingDetails'}">

		<div id="preAgreedPricingDetailsSection">
				<jsp:include page="/jsp/common/request/preAgreedPricingDetails.jsp" />
				<input type="hidden" name="sectionId" value="${param.sectionId}" />
		</div>
	</c:when>
	
	<c:when test="${param.sectionId eq 'request.section.optingOutComments'}">

		<div id="optingOutCommentsSection">
				<jsp:include page="/jsp/common/request/optingOutComments.jsp" />
				<input type="hidden" name="sectionId" value="${param.sectionId}" />
		</div>
	</c:when>
	
</c:choose>
<c:if test="${param.includeScripts != false}">
	</body>
	</html>
</c:if>