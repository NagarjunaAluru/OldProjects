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

<script> var servletContextUrl = '<%=servletContextUrl%>';</script>
        
		<c:set var="legSummaryVO" value="${deal:fetchLegSummary(requestScope.legNumber, pageContext.request)}" scope="page"/>
		<c:set var="day2legSummaryVO" value="${deal:fetchDay2LegSummary(requestScope.legNumber, pageContext.request)}" scope="page"/>
		
		<jsp:include page="../common/originalTPTransactionDetails.jsp" />
		<jsp:include page="../common/originalTPLenderBorrower.jsp" />
        <jsp:include page="../common/newTPLenderBorrower.jsp" />
      
			<div class="row highlighted">
					<div class="span5">
							<label>Accrued Interest Amount</label>
							<c:if test="${empty legSummaryVO.accruedInterestAmt}">-</c:if>
							<c:if test="${not empty legSummaryVO.accruedInterestAmt}"><fmt:formatNumber value="${legSummaryVO.accruedInterestAmt}" /></c:if>
					</div> <!-- end of block -->
					<div class="span5 right">
							<label>Currency</label>
							<c:if test="${not empty legSummaryVO.originalCurrency}">${legSummaryVO.originalCurrency}</c:if>
					</div> <!-- end of block --> 
				</div>
				
				<div class="row">
					<div class="span5">
							<label>Fees</label>
							<c:if test="${empty legSummaryVO.fees}">-</c:if>
							<c:if test="${not empty legSummaryVO.fees}"><fmt:formatNumber value="${legSummaryVO.fees}" /></c:if>
					</div>
					<div class="span5 right">
							<label>Principal Amount</label>
							<c:if test="${empty legSummaryVO.orgAmount}">-</c:if>
							<c:if test="${not empty legSummaryVO.orgAmount}"><fmt:formatNumber value="${legSummaryVO.orgAmount}"/></c:if>
					</div> <!-- end of block -->   
				</div>
				
				<div class="row highlighted">
					<div class="span5">
							<label>P&amp;L Amount from Lender/Provider perspective</label>
							<c:if test="${empty day2legSummaryVO.pandLAmount}">-</c:if>
							<c:if test="${not empty day2legSummaryVO.pandLAmount}"><fmt:formatNumber value="${day2legSummaryVO.pandLAmount}"/></c:if>
					</div>
					<div class="span5 right">
							<label>USD Equivalent</label>
							<c:if test="${empty legSummaryVO.usdEqui}">-</c:if>
							<c:if test="${not empty legSummaryVO.usdEqui}"><fmt:formatNumber value="${legSummaryVO.usdEqui}" /></c:if>
					</div> <!-- end of block -->
				</div>
				
				<div class="row">
					<div class="span5">
						<label>Request Derivatives</label>
						<c:if test="${not empty legSummaryVO.derivatives}">${legSummaryVO.derivatives}</c:if>
					</div>  
					<div class="span5 right">
						<label>Original Legal Agreement Attached</label>
						<c:if test="${legSummaryVO.isEventNoticeAttachedFlag eq true}">Yes</c:if>
						<c:if test="${legSummaryVO.isEventNoticeAttachedFlag eq false}">No</c:if>
					</div>
				</div> <!-- end of block --> 
				
			<jsp:include page="../common/derivativesDetails.jsp" />
			<jsp:include page="../common/tpSettlementDetails.jsp" />
			<jsp:include page="../common/otherTPConsiderations.jsp" />
