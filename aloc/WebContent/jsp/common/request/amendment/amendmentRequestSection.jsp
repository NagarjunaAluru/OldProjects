<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:if test="${param.includeScripts != false}">
	<%@include file="../../../common/includeCommonScripts.jsp" %>
	<script src="${pageContext.request.contextPath}/js/requestor/requestor.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/common/toWord.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/common/amendment.js" type="text/javascript"></script>
</c:if>
<s:hidden name="validationSuccess" id="validationSuccessId"/>

<c:choose>
	<c:when test="${param.sectionId eq 'request.section.amendmentTransactionParties'}">
		<div id="transactionPartiesSection">
				<jsp:include page="/jsp/common/request/amendment/amendmentTransactionParties.jsp" />
				<input type="hidden" name= "sectionId" value="${param.sectionId}" />
		</div>
	</c:when>

	<c:when	test="${param.sectionId eq 'request.section.instrumentAmountCurrency'}">
		<div id="instrumentAmountCurrencySection">
			<jsp:include page="/jsp/common/request/amendment/instrumentAmountCurrency.jsp" />
			<input type="hidden" name="sectionId" value="${param.sectionId}" />
		</div>
	</c:when>
	
	<c:when	test="${param.sectionId eq 'request.section.expirationDates'}">
		<div id="expirationDatesSection">
			<jsp:include page="/jsp/common/request/amendment/expirationDates.jsp" />
			<input type="hidden" name="sectionId" value="${param.sectionId}" />
		</div>
	</c:when>
	
	<c:when	test="${param.sectionId eq 'request.section.otherChanges'}">
		<div id="otherChangesSection">
			<jsp:include page="/jsp/common/request/amendment/otherChanges.jsp" >
				<jsp:param name="pageSection" value="Current" />
			</jsp:include>
			<input type="hidden" name="sectionId" value="${param.sectionId}" />
		</div>
	</c:when>
	
	<c:when test="${param.sectionId eq 'request.section.deliveryInstructions'}">
		<div id="deliveryInstructionsSection">
				<jsp:include page="/jsp/common/request/amendment/deliveryInstructions.jsp">
					<jsp:param name="pageSection" value="Current" />
				</jsp:include>
				<input type="hidden" name= "sectionId" value="${param.sectionId}" />
				
		</div>		
	</c:when>
	
	<c:when test="${param.sectionId eq 'request.section.attachments'}">
		<div id="attachmentsSection" >	
			<jsp:include page="/jsp/common/request/requestAttachment.jsp" />
			<input type="hidden" name= "sectionId" value="${param.sectionId}" /> 
		</div>			
	</c:when>
		
</c:choose>
<c:if test="${param.includeScripts != false}">
	</body>
	</html>
</c:if>