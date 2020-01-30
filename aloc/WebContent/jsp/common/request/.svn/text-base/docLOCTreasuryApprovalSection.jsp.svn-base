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
		
		</head>
		<body>
</c:if>

			<s:set name="isEdit" value="editMode" />
			
			<c:choose>
				<c:when
					test="${param.sectionId eq 'request.section.businessContactPerson'}">
					<div id="businessContactPersonSection">
			
						<jsp:include page="/jsp/common/request/businessContactPerson.jsp" />
						<input type="hidden" name="sectionId" value="${param.sectionId}" />
			
					</div>
				</c:when>
			
				<c:when test="${param.sectionId eq 'request.section.issuingBank'}">
					<div id="issuingBankSection">
			
						<jsp:include page="/jsp/common/request/issuingBank.jsp" />
						<input type="hidden" name="sectionId" value="${param.sectionId}" />
			
					</div>
				</c:when>
			
				<c:when test="${param.sectionId eq 'request.section.applicant'}">
					<div id="applicantSection">
			
						<jsp:include page="/jsp/common/request/applicant.jsp" />
						<input type="hidden" name="sectionId" value="${param.sectionId}" />
			
					</div>
				</c:when>
			
				<c:when test="${param.sectionId eq 'request.section.beneficiary'}">
					<div id="beneficiarySection">
			
						<jsp:include page="/jsp/common/request/beneficiary.jsp" />
						<input type="hidden" name="sectionId" value="${param.sectionId}" />
			
					</div>
				</c:when>
			
				<c:when
					test="${param.sectionId eq 'request.section.instrumentTransactionDetails'}">
					<div id="instrumentTransactionDetailsSection">
			
						<jsp:include
							page="/jsp/common/request/instrumentTransactionDetails.jsp" />
						<input type="hidden" name="sectionId" value="${param.sectionId}" />
			
					</div>
				</c:when>
			
				<c:when test="${param.sectionId eq 'request.section.paymentSchedule'}">
					<div id="paymentScheduleSection">
			
						<jsp:include page="/jsp/common/request/paymentSchedule.jsp" />
						<input type="hidden" name="sectionId" value="${param.sectionId}" />
			
					</div>
				</c:when>
			
				<c:when test="${param.sectionId eq 'request.section.format'}">
					<div id="formatSection">
			
						<jsp:include page="/jsp/common/request/format.jsp" />
						<input type="hidden" name="sectionId" value="${param.sectionId}" />
			
					</div>
				</c:when>
			
				<c:when test="${param.sectionId eq 'request.section.attachments'}">
					<div id="attachmentsSection">
			
						<jsp:include page="/jsp/common/request/attachments.jsp" />
						<input type="hidden" name="sectionId" value="${param.sectionId}" />
			
					</div>
				</c:when>
			
				<c:when
					test="${param.sectionId eq 'request.section.treasuryDelegation'}">
					<div id="treasuryDelegation">
			
						<jsp:include page="/jsp/common/request/treasuryDelegation.jsp" />
						<input type="hidden" name="sectionId" value="${param.sectionId}" />
			
					</div>
				</c:when>
			</c:choose>
<c:if test="${param.includeScripts != false}">
	</body>
	</html>
</c:if>