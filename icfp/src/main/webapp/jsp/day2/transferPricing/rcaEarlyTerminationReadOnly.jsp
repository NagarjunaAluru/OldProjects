<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<%@ taglib prefix="security"  uri="hwf-securitytag" %>
<fmt:setLocale value="en-US"/>
<%	String servletContextUrl = request.getContextPath();%>

		<jsp:include page="../common/originalTPTransactionDetails.jsp" />
		<jsp:include page="../common/originalTPLenderBorrower.jsp" />
		
		<c:set var="legSummaryVO" value="${deal:fetchLegSummary(requestScope.legNumber, pageContext.request)}" scope="page"/>
		<c:set var="day2legSummaryVO" value="${deal:fetchDay2LegSummary(requestScope.legNumber, pageContext.request)}" scope="page"/>	
           
		<h2 class="span12">Early Termination Details</h2>
		<div class="clear"></div>
		<div class="row highlighted">
			<div class="span5">
				<label>Principal Termination Amount</label>
				<c:if test="${empty legSummaryVO.orgAmount}">-</c:if>
				<c:if test="${not empty legSummaryVO.orgAmount}"><fmt:formatNumber value="${legSummaryVO.orgAmount}"/></c:if> 
			</div>
		</div>
		
		<div class="row">
			<div class="span5">
				<label>Currency</label>
                     <c:if test="${not empty legSummaryVO.originalCurrency}">${legSummaryVO.originalCurrency}</c:if>
			</div>
			<div class="span5 right">
				<label>USD Equivalent</label>
				<c:if test="${empty legSummaryVO.usdEqui}">-</c:if>
				<c:if test="${not empty legSummaryVO.usdEqui}"><fmt:formatNumber value="${legSummaryVO.usdEqui}" /></c:if>
			</div>
		</div>
		
		<div class="row highlighted">
			<div class="span5">
				<label>Accrued Interest Amount</label>
				<c:if test="${empty legSummaryVO.accruedInterestAmt}">-</c:if>
				<c:if test="${not empty legSummaryVO.accruedInterestAmt}"><fmt:formatNumber value="${legSummaryVO.accruedInterestAmt}" /></c:if>
			</div>
			<div class="span5 right">
				<label>Termination Notice Attached</label>
                    <c:if test="${legSummaryVO.isEventNoticeAttachedFlag eq true}">Yes</c:if>
					<c:if test="${legSummaryVO.isEventNoticeAttachedFlag eq false}">No</c:if>                         
			</div>
		</div>
		
		<div class="row">
			<div class="span5">
				<label>Breakage Cost Amount</label>
				<c:if test="${empty day2legSummaryVO.brokerageCostAmt}">-</c:if>
				<c:if test="${not empty day2legSummaryVO.brokerageCostAmt}"><fmt:formatNumber value="${day2legSummaryVO.brokerageCostAmt}" /></c:if>
			</div>
		</div>
		
		<div class="row highlighted">
			<div class="span5">
				<label>Request Derivatives</label>
				<c:if test="${not empty legSummaryVO.derivatives}">${legSummaryVO.derivatives}</c:if>
			</div>
		</div>
		   
		<h2>Settlement Details</h2>
        <div class="clear"></div>
			
		<div class="row">
			<div class="span5">
					<label>Gross Settlement amount</label>
						<c:if test="${empty legSummaryVO.grossSettlementAmt}">-</c:if>
						<c:if test="${not empty legSummaryVO.grossSettlementAmt}"><fmt:formatNumber value="${legSummaryVO.grossSettlementAmt}" /></c:if>
			</div> <!-- end of block -->
		</div>
		<div class="row highlighted">
			<div class="span5">
				<label>Payor</label>
				<c:if test="${empty legSummaryVO.payorLegalEntity}">-</c:if>
				<c:if test="${not empty legSummaryVO.payorLegalEntity}">${legSummaryVO.payorLegalEntity}</c:if>
			</div>
		</div>
		<div class="row">
			<div class="span5">
				<label>Legal entity setup pending</label>
				<c:if test="${legSummaryVO.payorEntitySetupFlag eq 'Y'}">Yes</c:if>
				<c:if test="${legSummaryVO.payorEntitySetupFlag != 'Y'}">No</c:if>
			</div>
		</div>
		<jsp:include page="../common/derivativesDetails.jsp" />
		
