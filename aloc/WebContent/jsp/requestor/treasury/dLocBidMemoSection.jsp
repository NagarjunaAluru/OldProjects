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
	<c:when	test="${param.sectionId eq 'request.section.businessContactPerson'}">
		<div id="businessContactPersonSection">
			<jsp:include page="/jsp/common/request/businessContactPerson.jsp" >
				<jsp:param value="${param.isTaxonomy}" name="isTaxonomy"/>
			</jsp:include>
			<input type="hidden" name="sectionId" value="${param.sectionId}" />
		</div>
	</c:when>
	
	<c:when test="${param.sectionId eq 'request.section.issuingBank'}">
		<div id="issuingBankSection">
			<jsp:include page="/jsp/common/request/issuingBank.jsp" >
				<jsp:param value="${param.isTaxonomy}" name="isTaxonomy"/>
			</jsp:include>
			<input type="hidden" name="sectionId" value="${param.sectionId}" />
		</div>
	</c:when>
				
	<c:when test="${param.sectionId eq 'request.section.applicant'}">
		<div id="applicantSection">
			<jsp:include page="/jsp/common/request/applicant.jsp" >
				<jsp:param name="page" value="BidMemo" />
				<jsp:param value="${param.isTaxonomy}" name="isTaxonomy"/>
			</jsp:include>
			<input type="hidden" name="sectionId" value="${param.sectionId}" />
		</div>
	</c:when>
	
	<c:when test="${param.sectionId eq 'request.section.beneficiary'}">
		<div id="beneficiarySection">
			<jsp:include page="/jsp/common/request/beneficiary.jsp" >
				<jsp:param value="${param.isTaxonomy}" name="isTaxonomy"/>
			</jsp:include>
			<input type="hidden" name="sectionId" value="${param.sectionId}" />
		</div>
	</c:when>
			
	<c:when test="${param.sectionId eq 'request.section.instrumentTransactionDetails'}">
		<div id="instrumentTransactionDetailsSection">
			<jsp:include page="/jsp/common/request/instrumentTransactionDetails.jsp" >
				<jsp:param value="${param.isTaxonomy}" name="isTaxonomy"/>
			</jsp:include>
				<input type="hidden" name="sectionId" value="${param.sectionId}" />
		</div>
	</c:when>
			
	<c:when test="${param.sectionId eq 'request.section.paymentSchedule'}">
		<div id="paymentScheduleSection">
			<jsp:include page="/jsp/common/request/paymentSchedule.jsp" >
				<jsp:param value="${param.isTaxonomy}" name="isTaxonomy"/>
			</jsp:include>
			<input type="hidden" name="sectionId" value="${param.sectionId}" />
		</div>
	</c:when>
			
	<c:when test="${param.sectionId eq 'request.section.format'}">
		<div id="formatSection">
			<jsp:include page="/jsp/common/request/format.jsp">
				<jsp:param value="${param.isTaxonomyView}" name="isTaxonomyView"/>
			</jsp:include>
			<input type="hidden" name="sectionId" value="${param.sectionId}" />
		</div>
	</c:when>
			
	<c:when test="${param.sectionId eq 'request.section.attachments'}">
		<div id="attachmentsSection">
			<jsp:include page="/jsp/common/request/attachments.jsp" />
			<input type="hidden" name="sectionId" value="${param.sectionId}" />
		</div>
	</c:when>
	
	<c:when test="${param.sectionId eq 'request.section.bidMemoDetails'}">
		<jsp:include page="/jsp/common/request/dLocBidMemoDetails.jsp" />		
	</c:when>
	
	<c:when test="${param.sectionId eq 'request.section.bankSelection'}">
		<div id="bankSelectionSection">
				<jsp:include page="/jsp/common/request/bankSelection.jsp" />
				<input type="hidden" name= "sectionId" value="${param.sectionId}" />
		</div>		
	</c:when>

</c:choose>
