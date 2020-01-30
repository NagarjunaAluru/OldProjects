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
<div class="alert fade in alert-danger hide" id="genericErrorComment">
	<a href="#" data-dismiss="alert" class="close">X</a> <strong>An
		error has occurred, see below.</strong>
</div>
<% String servletContextUrl = request.getContextPath();%>

<c:set var="legNumber" value="${requestScope.legNumber}" />
<c:set var="legSummary" value="${deal:fetchLegSummaryObject(legNumber, pageContext.request)}" />
<c:set var="productType" value="${legSummary.legTypeId}" />
<c:set var="eventType" value="${legSummary.transactionEventTypeId}" />

<c:choose>
	<c:when test="${(productType eq 1 || productType eq 5 || productType eq 6 ) && (eventType eq 3)}">
		<jsp:include page="viewLeg/rcaViewAssignment.jsp" />
	</c:when>
	
	<c:when test="${(productType eq 1 || productType eq 5 || productType eq 6 ) && (eventType eq 4)}">
		<jsp:include page="viewLeg/rcaViewAgreementExtension.jsp" />
	</c:when>
	
	<c:when test="${(productType eq 1) && (eventType eq 5)}">
		<jsp:include page="viewLeg/rcaViewAmendIncreaseDecrease.jsp" />
	</c:when>
	
	<c:when test="${(productType eq 1 || productType eq 5 || productType eq 6 ) && (eventType eq 6)}">
		<jsp:include page="viewLeg/rcaViewGenAmendment.jsp" />
	</c:when>
	
	<c:when test="${(productType eq 1 || productType eq 5 || productType eq 6 ) && (eventType eq 9)}">
		<jsp:include page="viewLeg/rcaViewEarlyTermination.jsp" />
	</c:when>
	
	<c:when test="${(productType eq 1 || productType eq 5 || productType eq 6  || productType eq 2) && (eventType eq 11)}">
		<jsp:include page="viewLeg/rcaViewDebtEquityOther.jsp" >
			<jsp:param name="productType" value="${productType}"/>
		</jsp:include>
	</c:when>
	
	<c:when test="${(productType eq 1 || productType eq 5 || productType eq 6  || productType eq 2) && (eventType eq 8)}">
		<jsp:include page="viewLeg/rcaViewDrawDown.jsp" />
	</c:when>
	
	<c:when test="${(productType eq 1 || productType eq 5 || productType eq 6  || productType eq 2) && (eventType eq 10)}">
		<jsp:include page="viewLeg/rcaViewCorrection.jsp" />
	</c:when>
	
	<c:when test="${(productType eq 1 || productType eq 5 || productType eq 6  || productType eq 2) && (eventType eq 7)}">
		<jsp:include page="viewLeg/rcaViewPrepayment.jsp" />
	</c:when>
	
	<c:when test="${productType eq 3}">
		<jsp:include page="cpa/cpaRequestor.jsp" >
			<jsp:param name="actionId" value="${param.actionId}"/>
			<jsp:param name="transactionEventTypeId" value="${eventType}"/>
		</jsp:include>
	</c:when>

	<c:when test="${productType eq 2 && eventType eq 12}">
		<jsp:include page="equity/equityRequestor.jsp">
			<jsp:param name="actionId" value="${param.actionId}"/>
		</jsp:include>
	</c:when>
</c:choose>








