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
	<%@include file="../../../common/includeCommonScripts.jsp" %>
	<script src="${pageContext.request.contextPath}/js/requestor/requestor.js" type="text/javascript"></script>
</head>
<body>
</c:if>

<c:choose>
	
	<c:when test="${param.sectionId eq 'request.section.tpapplicant'}">
		<c:if test="${param.pageSection == 'Current'}">
		<jsp:include page="/jsp/common/request/amendment/tpApplicantDetails.jsp" >
			<jsp:param name="pageSection" value="Current" />
		</jsp:include>
		</c:if>
		<c:if test="${requestDetails.amendment.transactionParties.tpApplicantDetails.addressDtls.changeFlag eq 'Y'}">
			<c:if test="${param.pageSection == 'Previous'}">
				<div class="row smallrow">
					<div class="span2a">
						<h3 class="span12">Previous</h3>
					</div>
				</div>
				<jsp:include page="/jsp/common/request/amendment/tpApplicantDetails.jsp" >
					<jsp:param name="pageSection" value="Previous" />
				</jsp:include>
			</c:if>
		</c:if>
		<input type="hidden" name="sectionId" value="${param.sectionId}" />
	</c:when>
	
	<c:when	test="${param.sectionId eq 'request.section.tripartyAddress'}">
		<c:if test="${param.pageSection == 'Current'}">	
			<jsp:include page="/jsp/common/request/amendment/tripartyApplicant.jsp" >
				<jsp:param name="pageSection" value="Current" />
			</jsp:include>
		</c:if>
		
		<c:if test="${requestDetails.amendment.transactionParties.triPartyApplicant.changeFlag eq 'Y'}">
			<c:if test="${param.pageSection == 'Previous'}">
				<div class="row smallrow">
					<div class="span2a">
						<h3 class="span12">Previous</h3>
					</div>
				</div>
				<jsp:include page="/jsp/common/request/amendment/tripartyApplicant.jsp" >
					<jsp:param name="pageSection" value="Previous" />
				</jsp:include>
			</c:if>
		</c:if>
		<input type="hidden" name="sectionId" value="${param.sectionId}" />
			
	</c:when>
	
	<c:when	test="${param.sectionId eq 'request.section.tpCustomerbeneficiary'}">
		<c:if test="${param.pageSection == 'Current'}">	
			<jsp:include page="/jsp/common/request/amendment/tpCustomerDetails.jsp" >
				<jsp:param name="pageSection" value="Current" />
			</jsp:include>
		</c:if>
		
		<c:if test="${requestDetails.amendment.transactionParties.customer.addressDtls.changeFlag eq 'Y'}">
			<c:if test="${param.pageSection == 'Previous'}">
				<div class="row smallrow">
					<div class="span2a">
						<h3 class="span12">Previous</h3>
					</div>
				</div>
				<jsp:include page="/jsp/common/request/amendment/tpCustomerDetails.jsp" >
					<jsp:param name="pageSection" value="Previous" />
				</jsp:include>
			</c:if>
		</c:if>	
		<input type="hidden" name="sectionId" value="${param.sectionId}" />
	</c:when>

	<c:when	test="${param.sectionId eq 'request.section.instrumentAmountCurrency'}">
		<c:if test="${param.pageSection == 'Current'}">
			<jsp:include page="/jsp/common/request/amendment/instrumentAmountCurrency.jsp" >
				<jsp:param name="pageSection" value="Current" />
			</jsp:include>
		</c:if>
		<c:if test="${requestDetails.amendment.amendmentInstrumentAmountCurr.changeFlag eq 'Y'}">
			<c:if test="${param.pageSection == 'Previous'}">
				<div class="form-row">
					<h2 class="acc acc_active"><a href="javascript:;">Previous</a></h2><hr class="h2-hr">
				</div>
				<jsp:include page="/jsp/common/request/amendment/instrumentAmountCurrency.jsp" >
					<jsp:param name="pageSection" value="Previous" />
				</jsp:include>
			</c:if>
		</c:if>
		<input type="hidden" name="sectionId" value="${param.sectionId}" />
	</c:when>
	
	<c:when	test="${param.sectionId eq 'request.section.expirationDates'}">
		<c:if test="${param.pageSection == 'Current'}">
			<jsp:include page="/jsp/common/request/amendment/expirationDates.jsp" >
				<jsp:param name="pageSection" value="Current" />
			</jsp:include>
		</c:if>
		<c:if test="${requestDetails.amendment.expiryDate.changeFlag eq 'Y'}">
			<c:if test="${param.pageSection == 'Previous'}">
				<div class="form-row">
					<h2 class="acc acc_active"><a href="javascript:;">Previous</a></h2><hr class="h2-hr">
				</div>
				<jsp:include page="/jsp/common/request/amendment/expirationDates.jsp" >
					<jsp:param name="pageSection" value="Previous" />
				</jsp:include>
			</c:if>
	  </c:if>
		<input type="hidden" name="sectionId" value="${param.sectionId}" />
	</c:when>
	
	<c:when	test="${param.sectionId eq 'request.section.otherChanges'}">
		<div id="otherChangesSection">
			<jsp:include page="/jsp/common/request/amendment/otherChanges.jsp" />
			<input type="hidden" name="sectionId" value="${param.sectionId}" />
		</div>
	</c:when>
	
	<c:when test="${param.sectionId eq 'request.section.deliveryInstructions'}">
		<c:if test="${param.pageSection == 'Current'}">
			<jsp:include page="/jsp/common/request/amendment/deliveryInstructions.jsp">
				<jsp:param name="pageSection" value="Current" />
			</jsp:include>
		</c:if>
			<c:if test="${requestDetails.amendment.expiryDate.changeFlag eq 'Y'}">
			<c:if test="${param.pageSection == 'Previous'}">
				<div class="form-row">
					<h2 class="acc acc_active"><a href="javascript:;">Previous</a></h2><hr class="h2-hr">
				</div>
				<jsp:include page="/jsp/common/request/amendment/deliveryInstructions.jsp" >
					<jsp:param name="pageSection" value="Previous" />
				</jsp:include>
			</c:if>
			  </c:if>
	</c:when>
	
	<c:when test="${param.sectionId eq 'request.section.attachments'}">
		<div id="attachmentsSection">
			<jsp:include page="/jsp/common/request/attachments.jsp" />
			<input type="hidden" name="sectionId" value="${param.sectionId}" />
			<input type="hidden" name="actionType" value="2">
		</div>
	</c:when>

</c:choose>

<c:if test="${param.includeScripts != false}">
	</body>
	</html>
</c:if>