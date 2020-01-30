<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="../common/error.jsp" %>
<%@taglib uri="http://ge.com/icfp/taglibs/staticdata" prefix="staticdata" %>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>
<div class="alert fade in alert-danger hide" id="genericErrorComment">
	<a href="#" data-dismiss="alert" class="close">X</a> <strong>An
		error has occurred, see below.</strong>
</div>
<div class="alert fade in alert-success hide" style="display: ${not empty requestScope.UpdateMessage ? 'block' : 'none'}">
            <a href="#" data-dismiss="alert" class="close">X</a>
            <strong>${requestScope.UpdateMessage}</strong> 
</div>
<logic:messagesPresent >
		       <div class="alert fade in alert-danger show" >
            		<a href="#" data-dismiss="alert" class="close">X</a>
            	<strong>Please fix the following fields highlighted in red.</strong> 
        	   </div>
</logic:messagesPresent>
<% String servletContextUrl = request.getContextPath();%>

<c:set var="legNumber" value="${requestScope.legNumber}" />
<c:set var="legSummary" value="${deal:fetchLegSummaryObject(legNumber, pageContext.request)}" />
<c:set var="productType" value="${legSummary.legTypeId}" />
<c:set var="eventType" value="${legSummary.transactionEventTypeId}" />

<c:choose>
	<c:when test="${(productType eq 1 || productType eq 5 || productType eq 6 ) && (eventType eq 3 || eventType eq 4 || eventType eq 6 || eventType eq 9 || eventType eq 11)
						|| (productType eq 2 && eventType eq 11)}">
		<jsp:include page="transferPricing/rcaTPEvents.jsp">
			<jsp:param name="eventType" value="${eventType}"/>
			<jsp:param name="productType" value="${productType}"/>
		</jsp:include>
	</c:when>
	
	<c:when test="${(productType eq 1) && (eventType eq 5)}">
		<jsp:include page="transferPricing/rcaTPEvents.jsp">
			<jsp:param name="eventType" value="${eventType}"/>
		</jsp:include>
	</c:when>
	
	<c:when test="${(productType eq 2 && (eventType eq 12))}">
		<jsp:include page="equity/equityTransferPricing.jsp">
			<jsp:param name="actionId" value="${param.actionId}"/>
			<jsp:param name="id" value="${legNumber}"/>
		</jsp:include>
	</c:when>
	
	<c:when test="${(productType eq 3)}">
		<jsp:include page="cpa/cpaTransferPricing.jsp" >
			<jsp:param name="actionId" value="${param.actionId}"/>
			<jsp:param name="transactionEventTypeId" value="${legSummary.transactionEventTypeId}"/>
		</jsp:include>
	</c:when>
	
</c:choose>

