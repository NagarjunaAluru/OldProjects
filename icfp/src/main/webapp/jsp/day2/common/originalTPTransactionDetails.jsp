<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en-US"/>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:common/>
	<c:set var="legSummaryVO" value="${deal:fetchLegSummary(requestScope.legNumber, pageContext.request)}" scope="page"/>
	<div>
			<h2 class="span12">Original Transaction Details</h2>
			<div class="clear"></div>		
			<div class="row highlighted">
					<div class="span5">
							<label>Product Type</label>
								<c:if test="${not empty legSummaryVO.productType}">${legSummaryVO.productType}</c:if>
					</div> <!-- end of block -->
					<div class="span5 right ">
							<label>Trade ID / Loan Model ID</label>
							<c:if test="${empty legSummaryVO.transactionId}">-</c:if>
							<c:if test="${not empty legSummaryVO.transactionId}">${legSummaryVO.transactionId}</c:if>
					</div> <!-- end of block -->
				</div>
				<c:if test="${param.productType ne '2'}">
					<div class="row">
						<div class="span5">
								<label>Terms (in months)</label>
								<c:if test="${not empty legSummaryVO.termsInMths}">${legSummaryVO.termsInMths}</c:if>
						</div> <!-- end of block -->
						<div class="span5 right">
								<label>Is Transaction Hedged</label>
								<c:if test="${legSummaryVO.isHedgedFlag eq 1}">Yes</c:if>
								<c:if test="${legSummaryVO.isHedgedFlag eq 0}">No</c:if>
						</div> <!-- end of block -->
					</div>
					<div class="row highlighted">
				</c:if>
					
				<c:if test="${param.productType eq '2'}">		
					<div class="row">
				</c:if>
					<div class="span5">
							<label>Non Standard Legal Agreement(s)</label>
							<c:if test="${legSummaryVO.originalLegalAgreementsFlag eq 1}">Yes</c:if>
							<c:if test="${legSummaryVO.originalLegalAgreementsFlag eq 0}">No</c:if>
					</div><!-- end of block -->
					<div class="span5 right">
								<label>Currency</label>
								 <c:if test="${empty legSummaryVO.dayOneCCY}">-</c:if>
								 <c:if test="${not empty legSummaryVO.dayOneCCY}">${legSummaryVO.dayOneCCY}</c:if>
						</div> <!-- end of block -->
				</div>
				
				<c:if test="${param.productType ne '2'}">
					<div class="row">
				</c:if>	
				<c:if test="${param.productType eq '2'}">		
					<div class="row highlighted">
				</c:if>
					<div class="span5">
							<label>Principal / Facility Amount</label>
							<c:if test="${empty legSummaryVO.dayOneCCYAmount}">-</c:if>
							<c:if test="${not empty legSummaryVO.dayOneCCYAmount}"><fmt:formatNumber value="${legSummaryVO.dayOneCCYAmount}" /></c:if>
					</div><!-- end of block -->
					<div class="span5 right">
								<label>USD Equivalent</label>
								<c:if test="${empty legSummaryVO.dayOneUSD}">-</c:if>
								<c:if test="${not empty legSummaryVO.dayOneUSD}"><fmt:formatNumber value="${legSummaryVO.dayOneUSD}" /></c:if>
					</div> <!-- end of block -->
				</div> 
					
		</div><!-- end of form form-mod -->