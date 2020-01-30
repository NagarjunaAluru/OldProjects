<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en-US"/>

<c:set var="legNumber" value="${requestScope.legNumber}" />
<c:set var="legSummary" value="${deal:fetchLegSummaryObject(legNumber, pageContext.request)}" />
<c:set var="productType" value="${legSummary.legTypeId}" />
<c:set var="eventType" value="${legSummary.transactionEventTypeId}" />
	<% String servletContextUrl = request.getContextPath();%>
<c:choose>
	<c:when test="${productType eq 1 || productType eq 2 || productType eq 4 || productType eq 5 || productType eq 6}">
		<script src="<%= servletContextUrl%>/js/downloadAttachmentFile.js" type="text/javascript"></script>
		<jsp:include page="/jsp/day1RCARequestorView.jsp" >
		  <jsp:param value="${param.derivativeViewFlag}" name="derivativeViewFlag"/>
		</jsp:include>
		
		<c:if test="${param.isSno ne false}">
			<div class="span8 right btn-container">
		 		<jsp:include page="day1CancelReadOnlyTabs.jsp" />
		 	</div>
		 </c:if>
	</c:when>
	
	<c:when test="${productType eq 3}">
		<script src="<%= servletContextUrl%>/js/downloadAttachmentFile.js" type="text/javascript"></script>
		
		<%@ include file="/jsp/pipelineReview/CPAOriginalTranscationDetailsRO.jsp"%>
		<jsp:include page="/jsp/pipelineReview/CPARequestDetailInput.jsp">
			<jsp:param name="transactionEventTypeId" value="${eventType}" />
		</jsp:include>
		<c:if test="${param.isSno ne false}">
		 	<div class="span8 right btn-container">
		 		<jsp:include page="day1CancelReadOnlyTabs.jsp" />
		 	</div>
		</c:if>
	</c:when>
</c:choose>