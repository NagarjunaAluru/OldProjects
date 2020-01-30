<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en-US"/>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<%@ taglib prefix="security"  uri="hwf-securitytag" %>
<%	String servletContextUrl = request.getContextPath();%>

		
		<c:set var="legSummaryVO" value="${deal:fetchLegSummary(requestScope.legNumber, pageContext.request)}" scope="page"/>
		<c:set var="day2legSummaryVO" value="${deal:fetchDay2LegSummary(requestScope.legNumber, pageContext.request)}" scope="page"/>
		
		<jsp:include page="../common/originalTPTransactionDetails.jsp" />
		<jsp:include page="../common/originalTPLenderBorrower.jsp" />
		
			<h2 class="span12">Amendment : Agreement Extension Details</h2>
			<div class="clear"></div>
			
			<div class="row highlighted">
				<div class="span5">
					<label>Amended Maturity Date</label>
					<c:if test="${empty day2legSummaryVO.amendmentMaturityDt}">-</c:if>
					<c:if test="${not empty day2legSummaryVO.amendmentMaturityDt}">${day2legSummaryVO.amendmentMaturityDt}</c:if>
				</div>
                <div class="span5 right">
					<label>Deal Currency</label>
					<c:if test="${empty legSummaryVO.originalCurrency}">-</c:if>
					<c:if test="${not empty legSummaryVO.originalCurrency}">${legSummaryVO.originalCurrency}</c:if>
				</div> 
			</div>
			
			<div class="row">
				<div class="span5">
						<label>Original Maturity Date</label>
						<c:if test="${not empty legSummaryVO.maturityDt}">${legSummaryVO.maturityDt}</c:if>
				</div> 
				<div class="span5 right">
					<label>Facility Amount</label>
					<c:if test="${empty legSummaryVO.orgAmount}">-</c:if>
					<c:if test="${not empty legSummaryVO.orgAmount}"><fmt:formatNumber value="${legSummaryVO.orgAmount}"/></c:if> 
				</div>
			</div>
			
			<div class="row">
				<div class="span5">
					<label>Original Legal Agreement Attached</label>
					<c:if test="${legSummaryVO.isEventNoticeAttachedFlag eq true}">Yes</c:if>
					<c:if test="${legSummaryVO.isEventNoticeAttachedFlag eq false}">No</c:if>
				</div>
				<div class="span5 right">
					<label>USD Equivalent</label>
					<c:if test="${empty legSummaryVO.usdEqui}">-</c:if>
					<c:if test="${not empty legSummaryVO.usdEqui}"><fmt:formatNumber value="${legSummaryVO.usdEqui}" /></c:if>
				</div> <!-- end of block -->
			</div>
			 
			<div class="row highlighted">
				<div class="span5">
					<label>Request Derivatives</label>
					<c:if test="${not empty legSummaryVO.derivatives}">${legSummaryVO.derivatives}</c:if>
				</div>                               
			</div>
				
			 <jsp:include page="../common/derivativesDetails.jsp" />
			 <jsp:include page="../common/tpTermsAndConditions.jsp" />

			