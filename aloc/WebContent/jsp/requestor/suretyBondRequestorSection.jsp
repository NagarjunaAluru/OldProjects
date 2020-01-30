<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp"%>
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
<%@include file="../common/ncludeRequestSectionCommonScripts.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/attachments/attachmentOperations.js"></script>
</head>
<body>
</c:if>
<%-- <s:hidden name="validationSuccess" /> --%>
<c:choose>
	<c:when test="${param.sectionId eq 'request.section.bondDetails'}">
		<div id="bondDetailsSection">
			<c:if test="${param.resubmit == true }">
				<jsp:include page="/jsp/common/request/bondDetailsReadonly.jsp" />
				<input type="hidden" name="sectionId" value="${param.sectionId}" />
			</c:if>
			<c:if test="${empty param.resubmit or param.resubmit ne true}">
				<jsp:include page="/jsp/common/request/bondDetails.jsp" />
				<input type="hidden" name="sectionId" value="${param.sectionId}" />
			</c:if>
		</div>

	</c:when>

	<c:when test="${param.sectionId eq 'request.section.principal'}">
		<div id="principalSection">
			<jsp:include page="../common/request/principalDetails.jsp" />
			<input type="hidden" name="sectionId" value="${param.sectionId}" />
		</div>

	</c:when>

	<c:when test="${param.sectionId eq 'request.section.obligee'}">
		<div id="obligeeSection">
			<jsp:include page="../common/request/obligeeDetails.jsp" />
			<input type="hidden" name="sectionId" value="${param.sectionId}" />
		</div>
	</c:when>

	<c:when test="${param.sectionId eq 'request.section.bondRequestor'}">
		<div id="bondRequestorSection">
			<jsp:include page="../common/request/bondRequestor.jsp" />
			<input type="hidden" name="sectionId" value="${param.sectionId}" />
		</div>
	</c:when>

	<c:when
		test="${param.sectionId eq 'request.section.requestorMailingAddress'}">
		<div id="requestorMailingAddressSection">
			<jsp:include page="../common/request/mailingAddress.jsp" />
			<input type="hidden" name="sectionId" value="${param.sectionId}" />
		</div>
	</c:when>

	<c:when
		test="${param.sectionId eq 'request.section.deliveryInstructions'}">
		<div id="deliveryInstructionsSection">
			<jsp:include page="../common/request/sbDeliveryInstructions.jsp" />
			<input type="hidden" name="sectionId" value="${param.sectionId}" />
		</div>
	</c:when>

	<c:when test="${param.sectionId eq 'request.section.bondInformation'}">
		<div id="bondInformationSection">
			<jsp:include page="../common/request/bondInformation.jsp">
				<jsp:param name="bondTypeId" value="${requestDetails.bondDetails.bondTypeId}"/>
				<jsp:param name="includeScripts" value="false" />
			</jsp:include>
			<input type="hidden" name="sectionId" value="${param.sectionId}" />
		</div>
	</c:when>
	
	<c:when
		test="${param.sectionId eq 'request.section.format'}">
		<div id="formatSection">
			<jsp:include page="/jsp/common/request/format.jsp" />
			<input type="hidden" name= "sectionId" value="${param.sectionId}" />
		</div>
	</c:when>
	
	<c:when
		test="${param.sectionId eq 'request.section.attachments'}">
		<div id="attachmentsSection">
			<jsp:include page="/jsp/common/request/attachments.jsp" />
			<input type="hidden" name= "sectionId" value="${param.sectionId}" />
		</div>
	</c:when>
	
</c:choose>

<c:if test="${param.includeScripts != false}">
	</body>
	</html>
</c:if>