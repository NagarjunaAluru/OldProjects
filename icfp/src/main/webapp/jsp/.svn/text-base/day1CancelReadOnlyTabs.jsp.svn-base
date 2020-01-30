<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en-US"/>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>

<% String servletContextUrl = request.getContextPath();%>
<c:set var="legSummary" value="${deal:fetchLegSummaryObject(legNumber, pageContext.request)}" />
<c:set var="productType" value="${legSummary.legTypeId}" />
<c:set var="legSummaryVO" value="${deal:fetchLegSummary(param.id, pageContext.request)}" scope="page"/>
<script type="text/javascript">
//Defining the global variable, so this variable can be used by other javascript library included in this JSP 
 var contextURL = '<%=servletContextUrl%>';
</script>
<c:choose>
	<c:when test="${productType != '3' && actionId eq 1}">
		<a href="javascript:redirectFundingRequest('?command=redirectFundingRequest');" class="right cancel single" style="margin-top:95px">Cancel</a>
	</c:when>
			
	<c:when test="${productType eq 3 && actionId eq 1}">
		<a href="javascript:redirectFundingRequest('?command=redirectFundingRequest');" class="right cancel single" style="margin-top:95px">Cancel</a>
	</c:when>
			
	<c:when test="${productType != '3' && actionId eq 2}">
		<c:choose>
			<c:when test="${(not empty param.derivativeFlag) && param.derivativeFlag eq 'yes'}">
				<a href="<%=servletContextUrl%>/frontoffice/RCALegRequest.do?command=redirectFundingRequest&isFrontOffice=Yes');" class="right cancel single" style="margin-top:95px">Cancel</a>
			</c:when>
			<c:otherwise>
				<a href="javascript:redirectFundingRequest('?command=redirectFundingRequest&isFrontOffice=Yes');" class="right cancel single" style="margin-top:95px">Cancel</a>
			</c:otherwise>
		</c:choose>
	</c:when>
			
	<c:when test="${productType eq 3 && actionId eq 2}">
		<a href="${pageContext.request.contextPath}/frontoffice/fourBlocker.do?command=load&DealRequestID=${sessionScope.deal.dealSeqId}" class="right cancel single" style="margin-top:95px">Cancel</a>
	</c:when>
			
	<c:when test="${actionId eq 3}">
		<a href="${pageContext.request.contextPath}/transferPricing/transferPricing.do?command=load&DealRequestID=${sessionScope.deal.dealSeqId}" class="right cancel single" style="margin-top:95px">Cancel</a>			
		
	</c:when>
			
	<c:when test="${actionId eq 4}">
		<a href="${pageContext.request.contextPath}/cashManagement/cashManagement.do?command=load&DealRequestID=${sessionScope.deal.dealSeqId}" class="right cancel single" style="margin-top:95px">Cancel</a>
		
	</c:when>
			
	<c:when test="${actionId eq 5}">
		<a href="${pageContext.request.contextPath}/treasuryLegal/treasuryLegal.do?command=load&DealRequestID=${sessionScope.deal.dealSeqId}" class="right cancel single" style="margin-top:95px">Cancel</a>
					
	</c:when>
			
	<c:when test="${actionId eq 6}">
		<a href="${pageContext.request.contextPath}/treasuryTax/treasuryTax.do?command=load&DealRequestID=${sessionScope.deal.dealSeqId}" class="right cancel single" style="margin-top:95px">Cancel</a>
	</c:when>
		
	<c:when test="${actionId eq 7}">
		<a href="${pageContext.request.contextPath}/middleOffice/middleOffice.do?command=load&DealRequestID=${sessionScope.deal.dealSeqId}" class="right cancel single" style="margin-top:95px">Cancel</a>
	</c:when>
			
	<c:when test="${actionId eq 8}">
		<a href="${pageContext.request.contextPath}/countryTax/countryTax.do?command=load&DealRequestID=${sessionScope.deal.dealSeqId}" class="right cancel single" style="margin-top:95px">Cancel</a>
	</c:when>
			
	<c:when test="${actionId eq 10}">
		<a href="${pageContext.request.contextPath}/pipelineReview/pipelineReviewDeal.do?command=getPipelineReviewDealDetail&source=${param.sourcePage}" class="right cancel single" style="margin-top:95px">Cancel</a>
	</c:when>	
	
	<c:when test="${actionId eq 11}">
		<a href="${pageContext.request.contextPath}/searchResults.do?command=getSearchDealDetail&DealRequestID=${sessionScope.deal.dealSeqId}" class="right cancel single" style="margin-top:95px">Cancel</a>
	</c:when>
	
	<c:when test="${(not empty param.derivativeFlag && param.derivativeFlag eq 'yes') && (actionId eq 31 || actionId eq 32 || actionId eq 33 || actionId eq 34 || actionId eq 35 || actionId eq 36 || actionId eq 37 || actionId eq 38 || actionId eq 39) }">
		<a href="${pageContext.request.contextPath}/${param.source}.do?command=load&DealRequestID=${sessionScope.deal.dealSeqId}&source=${param.source}&id=${legNumber}&pType=${productType}" class="right cancel single" style="margin-top:95px">Cancel</a>
	</c:when>
		
	<%-- This is for view derivative --%>
	<c:when test="${not empty param.derivativeFlag && param.derivativeFlag eq 'yes' && actionId eq 9999 }">
		<a href="${pageContext.request.contextPath}/${param.source}.do?command=load&DealRequestID=${sessionScope.deal.dealSeqId}&source=${param.source}&id=${legNumber}&pType=${productType}" class="right cancel single" style="margin-top:95px">Cancel</a>
	</c:when>
</c:choose> 
		
		