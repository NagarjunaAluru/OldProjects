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
	<c:when test="${(productType eq 1 || productType eq 5 || productType eq 6 ) && (eventType eq 3 || eventType eq 4 || eventType eq 6 || eventType eq 9 || eventType eq 11)}">
		<jsp:include page="treasuryLegal/rcaTLegalEventsView.jsp" >
			<jsp:param name="eventType" value="${eventType}"/>
			<jsp:param name="productType" value="${productType}"/>
			<jsp:param name="source" value="${param.source}"/>
		</jsp:include>
	</c:when>
	
	<c:when test="${(productType eq 1 && eventType eq 5) || (productType eq 2 && eventType eq 11 )}">
		<jsp:include page="treasuryLegal/rcaTLegalEventsView.jsp" >
			<jsp:param name="eventType" value="${eventType}"/>
			<jsp:param name="productType" value="${productType}"/>
			<jsp:param name="source" value="${param.source}"/>
		</jsp:include>
	</c:when>
	
	<c:when test="${(productType eq 2)}">
		<jsp:include page="equity/equityCashManagement.jsp">
			<jsp:param name="actionId" value="${param.actionId}"/>
			<jsp:param name="source" value="${param.source}"/>
			<jsp:param name="page" value="treasuryLegal"/>
		</jsp:include>
	</c:when>
	
	<c:when test="${(productType eq 3)}">
		<jsp:include page="cpa/cpaCashManagement.jsp">
			<jsp:param name="actionId" value="${param.actionId}"/>	
			<jsp:param name="source" value="${param.source}"/>
			<jsp:param name="page" value="treasuryLegal"/>
			<jsp:param name="transactionEventTypeId" value="${eventType}"/>
		</jsp:include>
	</c:when>
</c:choose>
