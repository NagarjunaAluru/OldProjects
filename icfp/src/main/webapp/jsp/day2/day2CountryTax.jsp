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
<div class="alert fade in alert-success hide" style="display: ${not empty requestScope.UpdateMessage ? 'block' : 'none'}">
     <a href="#" data-dismiss="alert" class="close">X</a>
     <strong>${requestScope.UpdateMessage}</strong> 
</div>
<div class="alert fade in alert-danger hide" style="display: ${not empty requestScope.atmtError ? 'block' : 'none'}">
     <a href="#" data-dismiss="alert" class="close">X</a>
     <strong>${requestScope.atmtError}</strong> 
</div>
<% String servletContextUrl = request.getContextPath();%>

<c:set var="legNumber" value="${requestScope.legNumber}" />
<c:set var="legSummary" value="${deal:fetchLegSummaryObject(legNumber, pageContext.request)}" />
<c:set var="productType" value="${legSummary.legTypeId}" />
<c:set var="eventType" value="${legSummary.transactionEventTypeId}" />

<c:choose>
	<c:when test="${(productType eq 3)}">
		<jsp:include page="cpa/cpaCashManagement.jsp">
			<jsp:param name="actionId" value="${param.actionId}"/>
			<jsp:param name="activeId" value="8"/>
			<jsp:param name="transactionEventTypeId" value="${eventType}"/>
			<jsp:param name="page" value="countryTax"/>
		</jsp:include>
	</c:when>
</c:choose>
