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
<c:choose>
	<c:when
		test="${param.sectionId eq 'request.section.bidMemoDetails'}">

		<div id="bidMemoDetailsSection">
				<jsp:include page="/jsp/common/request/bidMemoDetails.jsp" />
				<input type="hidden" name="sectionId" value="${param.sectionId}" />
		</div>
	</c:when>
	
	<c:when test="${param.sectionId eq 'request.section.issuingBank'}">
		<div id="issuingBankSection">
				<jsp:include page="/jsp/common/request/issuingBank.jsp" >
				<jsp:param name="page" value="BidReply" />
				</jsp:include>
				<input type="hidden" name="sectionId" value="${param.sectionId}" />
		</div>
	</c:when>
	
	<c:when test="${param.sectionId eq 'request.section.applicant'}">
		<div id="applicantSection">
				<jsp:include page="/jsp/common/request/applicant.jsp" >
					<jsp:param name="page" value="BidReply" />
				</jsp:include>
				<input type="hidden" name="sectionId" value="${param.sectionId}" />
		</div>
	</c:when>
	
	<c:when test="${param.sectionId eq 'request.section.beneficiary'}">
		<div id="beneficiarySection">
				<jsp:include page="/jsp/common/request/bidReplyBeneficiary.jsp" />
				<input type="hidden" name="sectionId" value="${param.sectionId}" />
		</div>
	</c:when>
	
	<c:when test="${param.sectionId eq 'request.section.instrumentDetails'}">
		<div id="instrumentDetailsSection">
				<jsp:include page="/jsp/common/request/instrumentTransactionDetails.jsp" >
					<jsp:param name="page" value="BidReply" />
				</jsp:include>
				<input type="hidden" name="sectionId" value="${param.sectionId}" />
		</div>
	</c:when>
	
	<c:when test="${param.sectionId eq 'request.section.paymentSchedule'}">
		<div id="paymentScheduleSection">
				<jsp:include page="/jsp/common/request/paymentSchedule.jsp" >
					<jsp:param name="page" value="BidReply" />
				</jsp:include>
				<input type="hidden" name="sectionId" value="${param.sectionId}" />
		</div>
	</c:when>
	
	<c:when test="${param.sectionId eq 'request.section.conformationFees'}">

		<div id="conformationFeesSection">
				<jsp:include page="/jsp/common/request/dLocConformationFees.jsp" />
				<input type="hidden" name="sectionId" value="${param.sectionId}" />
		</div>
	</c:when>
	
	<c:when test="${param.sectionId eq 'request.section.praposedBankBranch'}">

		<div id="praposedBankBranchSection">
				<jsp:include page="/jsp/common/request/dLocPraposedBankBranch.jsp" />
				<input type="hidden" name="sectionId" value="${param.sectionId}" />
		</div>
	</c:when>	
	
	<c:when test="${param.sectionId eq 'request.section.indicativePricingInformation'}">

		<div id="indicativePricingSection">
				<jsp:include page="/jsp/common/request/dLocIndicativePricingInformation.jsp" />
				<input type="hidden" name="sectionId" value="${param.sectionId}" />
		</div>
	</c:when>
	
	<c:when test="${param.sectionId eq 'request.section.optingOutComments'}">

		<div id="dLocOptingOutCommentsSection">
				<jsp:include page="/jsp/common/request/optingOutComments.jsp" />
				<input type="hidden" name="sectionId" value="${param.sectionId}" />
		</div>
	</c:when>
	
</c:choose>
<c:if test="${param.includeScripts != false}">
	</body>
	</html>
</c:if>