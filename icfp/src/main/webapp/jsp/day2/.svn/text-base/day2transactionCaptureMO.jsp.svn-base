<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>
<c:set var="legNumber" value="${requestScope.legNumber}" />
<c:set var="legSummary" value="${deal:fetchLegSummaryObject(legNumber, pageContext.request)}" />
<c:set var="productType" value="${legSummary.legTypeId}" />
<c:set var="eventType" value="${legSummary.transactionEventTypeId}" />

<c:choose>
	<c:when test="${(productType eq 1 || productType eq 5 || productType eq 6 ) && (eventType eq 3)}">
		<jsp:include page="transactionCapture/rcaTCMOAssignment.jsp" />
	</c:when>
	
	<c:when test="${(productType eq 1 || productType eq 5 || productType eq 6 ) && (eventType eq 4)}">
		<jsp:include page="transactionCapture/rcaTCMOAgreementExtension.jsp" />
	</c:when>
	
	<c:when test="${(productType eq 1 ) && (eventType eq 5)}">
		<jsp:include page="transactionCapture/rcaTCMOAmendIncreaseDecrease.jsp" />
	</c:when>
	
	<c:when test="${(productType eq 1 || productType eq 5 || productType eq 6 ) && (eventType eq 6)}">
		<jsp:include page="transactionCapture/rcaTCMOGenAmendment.jsp" />
	</c:when>
	
	<c:when test="${(productType eq 1 || productType eq 5 || productType eq 6 ) && (eventType eq 7)}">
		<jsp:include page="transactionCapture/rcaTCMOPrepayment.jsp" />
	</c:when>
	
	<c:when test="${(productType eq 1 ) && (eventType eq 8)}">
		<jsp:include page="transactionCapture/rcaTCMODrawdown.jsp" />
	</c:when>
	
	<c:when test="${(productType eq 1 || productType eq 5 || productType eq 6 ) && (eventType eq 9)}">
		<jsp:include page="transactionCapture/rcaTCMOEarlyTermination.jsp" />
	</c:when>
	
	<c:when test="${(productType eq 1 || productType eq 5 || productType eq 6 || productType eq 2) && (eventType eq 10)}">
		<jsp:include page="transactionCapture/rcaTCMOCorrection.jsp" />
	</c:when>
	
	<c:when test="${(productType eq 1 || productType eq 5 || productType eq 6 || productType eq 2) && (eventType eq 11)}">
		<jsp:include page="transactionCapture/rcaTCMODebtEquityOther.jsp">
			<jsp:param name="productType" value="${param.productType}"/>
		</jsp:include>
	</c:when>
	
	<c:when test="${productType eq 3}">
		<jsp:include page="cpa/cpaTCMiddleOffice.jsp">
			<jsp:param name="actionId" value="${param.actionId}"/>
			<jsp:param name="transactionEventTypeId" value="${eventType}"/>
			<jsp:param name="wfStageId" value="${sessionScope.deal.WFStageId}"/>
		</jsp:include>
	</c:when>
	
	<c:when test="${productType eq 2 && (eventType eq 12)}">
		<jsp:include page="/jsp/day2/equity/equityTCMO.jsp">
			<jsp:param name="actionId" value="${param.actionId}"/>
			<jsp:param name="transactionEventTypeId" value="${legSummary.transactionEventTypeId}"/>
		</jsp:include>
	</c:when>
</c:choose>




