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
<script type="text/javascript">
//Show next leg navigation based on lastLeg value
//it needs the JSP variable so placed in JSP file
$(document).ready(function() {
    var lastLegVar = '<%=request.getAttribute("proceedtoNextLeg")%>';
	   if(lastLegVar=='yes')
		   {
		   $('#reviewNextLegID').show();
		   }else {
			   $('#reviewNextLegID').hide();
		   } 
	});	
</script>
<div class="alert fade in alert-danger hide" id="genericErrorComment">
            <a href="#" data-dismiss="alert" class="close">X</a>
            <strong>An error has occurred, see below.</strong> 
</div>

<% String servletContextUrl = request.getContextPath();%>

<c:set var="legNumber" value="${requestScope.legNumber}" />
<c:set var="legSummary" value="${deal:fetchLegSummaryObject(legNumber, pageContext.request)}" />
<c:set var="productType" value="${legSummary.legTypeId}" />
<c:set var="eventType" value="${legSummary.transactionEventTypeId}" />

<div class="clear"></div>
<div id="validateFlag" class="alert fade in alert-danger hide">
    <a href="#" class="close" onclick="javascript:closeMessage();">X</a>
    <strong><bean:message key="label.addLeg.pleaseFixErrors" /></strong> 
</div>
<div class="alert fade in alert-success hide" style="display: ${not empty requestScope.UpdateMessage ? 'block' : 'none'}">
    <a href="#" data-dismiss="alert" class="close">X</a>
    <strong>${requestScope.UpdateMessage}</strong> 
</div>
<div class="alert fade in alert-danger hide" style="display: ${not empty requestScope.atmtError ? 'block' : 'none'}">
      <a href="#" data-dismiss="alert" class="close">X</a>
      <strong>${requestScope.atmtError}</strong> 
</div>
		
<c:choose>
	<c:when test="${(productType eq 1 || productType eq 4 || productType eq 5 || productType eq 6 ) && (eventType eq 3)}">
		<jsp:include page="rca/rcaAssignmentfrontOffice.jsp" >
			<jsp:param value="${param.name}" name="name"/>
		</jsp:include>
			<input type="hidden" name="isCPA" id="isCPA" value="no" />
	</c:when>
	
	<c:when test="${(productType eq 1 || productType eq 4 || productType eq 5 || productType eq 6 ) && (eventType eq 4)}">
		<jsp:include page="rca/rcaAgreementExtensionfrontOffice.jsp" >
			<jsp:param value="${param.name}" name="name"/>
		</jsp:include>
			<input type="hidden" name="isCPA" id="isCPA" value="no" />
	</c:when>
	
	<c:when test="${(productType eq 1 || productType eq 4 || productType eq 5 || productType eq 6 ) && (eventType eq 5)}">
		<jsp:include page="rca/rcaAmendIncreaseDecreasefrontOffice.jsp" >
			<jsp:param value="${param.name}" name="name"/>
		</jsp:include>
			<input type="hidden" name="isCPA" id="isCPA" value="no" />
	</c:when>
	
	<c:when test="${(productType eq 1 || productType eq 4 || productType eq 5 || productType eq 6 ) && (eventType eq 6)}">
		<jsp:include page="rca/rcaGenAmendmentfrontOffice.jsp" >
			<jsp:param value="${param.name}" name="name"/>
		</jsp:include>
			<input type="hidden" name="isCPA" id="isCPA" value="no" />
	</c:when>
	
	<c:when test="${(productType eq 1 || productType eq 4 || productType eq 5 || productType eq 6 ) && (eventType eq 9)}">
		<jsp:include page="rca/rcaEarlyTerminationfrontOffice.jsp" >
			<jsp:param value="${param.name}" name="name"/>
		</jsp:include>
			<input type="hidden" name="isCPA" id="isCPA" value="no" />
	</c:when>
	
	<c:when test="${(productType eq 1 || productType eq 4 || productType eq 5 || productType eq 6 || productType eq 2) && (eventType eq 11)}">
		<jsp:include page="rca/rcaDebtEquityfrontOffice.jsp" >
			<jsp:param name="productType" value="${productType}"/>
			<jsp:param value="${param.name}" name="name"/>
		</jsp:include>
		<input type="hidden" name="isCPA" id="isCPA" value="no" />
	</c:when>
	
	<c:when test="${productType eq 3}">
	
		<jsp:include page="cpa/cpaFrontOffice.jsp">
			<jsp:param name="actionId" value="${param.actionId}"/>
			<jsp:param name="transactionEventTypeId" value="${legSummary.transactionEventTypeId}"/>
			<jsp:param value="${param.source}" name="path"/>
			<jsp:param value="${name}" name="origin"/>
			<jsp:param value="${param.source}" name="source"/>
			<jsp:param value="${param.name}" name="name"/>
		</jsp:include>
		<input type="hidden" name="isCPA" id="isCPA" value="yes" />
	</c:when>
	
	<c:when test="${productType eq 2 && (eventType eq 12)}">
		<jsp:include page="equity/equityFrontOffice.jsp">
			<jsp:param name="actionId" value="${param.actionId}"/>	
			<jsp:param value="${param.name}" name="name"/>
		</jsp:include>
		<input type="hidden" name="isCPA" id="isCPA" value="no" />
	</c:when>

</c:choose>

