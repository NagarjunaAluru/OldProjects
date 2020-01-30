<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en-US"/>

<div class="alert fade in alert-danger hide" id="genericErrorComment">
	<a href="#" data-dismiss="alert" class="close">X</a> <strong>An
		error has occurred, see below.</strong>
</div>

<% String servletContextUrl = request.getContextPath();%>
<script>//Defining the global variable, so this variable can be used by other javascript library included in this JSP 
 var contextURL = '<%=servletContextUrl%>';</script>
<script>
function closeMessage() {
	$('#validateFlag').hide();
}
</script>
<c:set var="legNumber" value="${requestScope.legNumber}" />
<c:set var="legSummary" value="${deal:fetchLegSummaryObject(legNumber, pageContext.request)}" />
<c:set var="productType" value="${legSummary.legTypeId}" />
<div class="clear"></div>
<logic:messagesNotPresent>
<div id="validateFlag" class="alert fade in alert-danger hide">
    <a href="#" class="close" onclick="javascript:closeMessage();">X</a>
    <strong><bean:message key="label.addLeg.pleaseFixErrors" /></strong> 
</div>
</logic:messagesNotPresent>

<div class="alert fade in alert-success hide" style="display: ${not empty requestScope.UpdateMessage ? 'block' : 'none'}">
    <a href="#" data-dismiss="alert" class="close">X</a>
    <strong><font color="green">${requestScope.UpdateMessage}</font></strong> 
</div>
        
<c:choose>
	<c:when test="${productType eq 1 || productType eq 5 || productType eq 6 }">
		<jsp:include page="/jsp/transferPricing/rcaTransferPricingInput.jsp" />
	</c:when>
	
	<c:when test="${productType eq 2}">
		<jsp:include page="/jsp/equity/transferPricing/equityTransferPricingInput.jsp" />
	</c:when>
	
	<c:when test="${productType eq 3}">
		<jsp:include page="/jsp/transferPricing/cpaTransferPricingInput.jsp" />
	</c:when>
	
	<c:when test="${productType eq 4}">
		<jsp:include page="/jsp/transferPricing/otherTransferPricingInput.jsp" />
	</c:when>
</c:choose>




