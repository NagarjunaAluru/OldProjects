<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en-US"/>

<c:set var="legNumber" value="${requestScope.legNumber}" />
<c:set var="legSummary" value="${deal:fetchLegSummaryObject(legNumber, pageContext.request)}" />
<c:set var="productType" value="${legSummary.legTypeId}" />

<c:choose>
	<c:when test="${productType eq 1 || productType eq 2 || productType eq 4 || productType eq 5 || productType eq 6}">
		<jsp:include page="/jsp/frontOffice/addLeg.jsp" />
	</c:when>
	
	<c:when test="${productType eq 3}">
		<jsp:include page="/jsp/frontOffice/addFOCPARequest.jsp" />
	</c:when>
</c:choose>