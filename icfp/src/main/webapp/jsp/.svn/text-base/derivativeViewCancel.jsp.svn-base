<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en-US"/>

<% String servletContextUrl = request.getContextPath();%>
<c:set var="legSummary" value="${deal:fetchLegSummaryObject(legNumber, pageContext.request)}" />
<c:set var="productType" value="${legSummary.legTypeId}" />
<c:set var="legSummaryVO" value="${deal:fetchLegSummary(param.id, pageContext.request)}" scope="page"/>
<script type="text/javascript">
</script>

		<c:choose>
			<c:when test="${productType != '3' && actionId eq 2}">
				<ul class="breadcrumb">
				   <a href="${pageContext.request.contextPath}/frontoffice/fourBlocker.do?command=openLeg&modify=true&legNumber=${legNumber}" class="right cancel single" style="margin-top:95px"> Cancel</a>
				</ul>
			</c:when>
			
			<c:when test="${actionId eq 3}">
				<ul class="breadcrumb">
					  <a href="${pageContext.request.contextPath}/transferPricing/transferPricing.do?command=legDetails&id=${legNumber}&pType=${productType}" class="right cancel single" style="margin-top:95px"> Cancel</a>					
				</ul>
			</c:when>
			
			<c:when test="${actionId eq 4}">
				<ul class="breadcrumb">
					<a href="${pageContext.request.contextPath}/cashManagement/cashManagement.do?command=legDetails&id=${legNumber}&pType=${productType}" class="right cancel single" style="margin-top:95px"> Cancel</a>
				</ul>
			  </c:when>
			
			<c:when test="${actionId eq 5}">
				<ul class="breadcrumb">
					<a href="${pageContext.request.contextPath}/treasuryLegal/treasuryLegal.do?command=legDetails&id=${legNumber}&pType=${productType}" class="right cancel single" style="margin-top:95px"> Cancel</a>
				</ul>
			</c:when>
			
			<c:when test="${actionId eq 6}">
				<ul class="breadcrumb">
					<a href="${pageContext.request.contextPath}/treasuryTax/treasuryTax.do?command=legDetails&id=${legNumber}&pType=${productType}" class="right cancel single" style="margin-top:95px"> Cancel</a>
				</ul>
			</c:when>
		
			<c:when test="${actionId eq 7}">
				<ul class="breadcrumb">
					 <a href="${pageContext.request.contextPath}/middleOffice/middleOffice.do?command=legDetails&id=${legNumber}&pType=${productType}" class="right cancel single" style="margin-top:95px"> Cancel</a>
				</ul>
			</c:when>
			<c:when test="${actionId eq 10}">
				<ul class="breadcrumb">
					   <a href="${pageContext.request.contextPath}/pipelineReview/pipelineReviewDeal.do?command=viewInputScreens&id=${legNumber}&pType=${productType}&source=${param.source}" >Cancel</a>
				</ul>
			</c:when>
			<c:when test="${actionId eq 31 || actionId eq 32 || actionId eq 33 || actionId eq 34 || actionId eq 35 || actionId eq 36 || actionId eq 37 || actionId eq 39}">
				<ul class="breadcrumb">
				   <a href="${pageContext.request.contextPath}/${param.source}.do?command=viewInputScreens&source=${param.source}&id=${legNumber}&pType=${productType}">Cancel </a>
				</ul>
			</c:when>
			<c:when test="${(actionId eq 38) }">
				<ul class="breadcrumb">
				   <a href="${pageContext.request.contextPath}/${param.source}.do?command=legDetails&id=${legNumber}&pType=${productType}">Cancel </a>
				</ul>
			</c:when>
			<%-- This is for view derivative --%>
			<c:when test="${actionId eq 9999}">
				<ul class="breadcrumb">
				   <a href="${pageContext.request.contextPath}/${param.source}.do?command=viewInputScreens&source=${param.source}&id=${legNumber}&pType=${productType}">Cancel </a>
				</ul>
			</c:when>
			
		</c:choose> 
		
		