<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<%@ taglib prefix="security"  uri="hwf-securitytag" %>
s<fmt:setLocale value="en-US"/>
<%	String servletContextUrl = request.getContextPath();%>

		
		<c:set var="legSummaryVO" value="${deal:fetchLegSummary(requestScope.legNumber, pageContext.request)}" scope="page"/>
		<c:set var="day2legSummaryVO" value="${deal:fetchDay2LegSummary(requestScope.legNumber, pageContext.request)}" scope="page"/>
		
		<div class="row highlighted">
					<div class="span5">
            <label>Activity</label>
            	<c:if test="${day2legSummaryVO.facilityTypeId eq 1}">Facility Increase</c:if>
            	<c:if test="${day2legSummaryVO.facilityTypeId eq 2}">Facility Decrease</c:if>
			</div>               
       	 </div>  
		
		<div>
			<h2 class="span12">Original Transaction Details</h2>
			<div class="clear"></div>		
			<div class="row highlighted">
					<div class="span5">
							<label>Product Type</label>
								<c:if test="${not empty legSummaryVO.productType}">${legSummaryVO.productType}</c:if>
					</div> <!-- end of block -->
					<div class="span5 right ">
							<label>Facility ID</label>
							<c:if test="${not empty legSummaryVO.transactionId}">${legSummaryVO.transactionId}</c:if>
					</div> <!-- end of block -->
				</div>
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
					<div class="span5">
							<label>Non Standard Legal Agreement(s)</label>
							<c:if test="${legSummaryVO.originalLegalAgreementsFlag eq 1}">Yes</c:if>
							<c:if test="${legSummaryVO.originalLegalAgreementsFlag eq 0}">No</c:if>
					</div><!-- end of block -->
					<div class="span5 right">
								<label>Currency</label>
								 <c:if test="${not empty legSummaryVO.dayOneCCY}">${legSummaryVO.dayOneCCY}</c:if>
						</div> <!-- end of block -->
				</div>
				
				<div class="row">
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
		
		<jsp:include page="../common/originalTPLenderBorrower.jsp" />
              
        <c:if test="${day2legSummaryVO.facilityTypeId eq 1}">
        	<h2 class="span12">Amendment : Facility Increase Details</h2>
        </c:if>
        <c:if test="${day2legSummaryVO.facilityTypeId eq 2}">
        	<h2 class="span12">Amendment : Facility Decrease Details</h2>
        </c:if>
        
        <div class="clear"></div>
		<div class="row highlighted">
			<div class="span5">
				<label>Currency</label>
                 <c:if test="${not empty legSummaryVO.originalCurrency}">${legSummaryVO.originalCurrency}</c:if>
			</div>
			<div class="span5 right">
				<label>Facility <c:if test="${day2legSummaryVO.facilityTypeId eq 1}">Increase</c:if>
								<c:if test="${day2legSummaryVO.facilityTypeId eq 2}">Decrease</c:if> Amount</label>
				<c:if test="${empty day2legSummaryVO.facilityIncDecAmt}">-</c:if>
				<c:if test="${not empty day2legSummaryVO.facilityIncDecAmt}"><fmt:formatNumber value="${day2legSummaryVO.facilityIncDecAmt}" /></c:if>
			</div>
		</div>
		
		<div class="row">
			<div class="span5 right">
				<label>USD Equivalent</label>
				<c:if test="${empty day2legSummaryVO.facilityIncDecUSDEquivalentAmt}">-</c:if>
				<c:if test="${not empty day2legSummaryVO.facilityIncDecUSDEquivalentAmt}"><fmt:formatNumber value="${day2legSummaryVO.facilityIncDecUSDEquivalentAmt}" /></c:if>
			</div>
		</div>

		<div class="row highlighted">
			<div class="span5">
				<label>Current Facility Amount</label>
                   <c:if test="${empty legSummaryVO.orgAmount}">-</c:if>
					<c:if test="${not empty legSummaryVO.orgAmount}"><fmt:formatNumber value="${legSummaryVO.orgAmount}"/></c:if> 
			</div>
                    
			<div class="span5 right ">
				<label>Amended Facility Amount</label>
				<c:if test="${empty day2legSummaryVO.amendedFacilityAmt}">-</c:if>
				<c:if test="${not empty day2legSummaryVO.amendedFacilityAmt}"><fmt:formatNumber value="${day2legSummaryVO.amendedFacilityAmt}"/></c:if> 
            </div>
        </div>
        
		<div class="row">
			<div class="span5">
				<label>USD Equivalent</label>
				<c:if test="${empty legSummaryVO.usdEqui}">-</c:if>
				<c:if test="${not empty legSummaryVO.usdEqui}"><fmt:formatNumber value="${legSummaryVO.usdEqui}" /></c:if>
			</div>
			<div class="span5 right">
				<label>USD Equivalent</label>
				<c:if test="${empty day2legSummaryVO.amendedUSDEquivalentAmt}">-</c:if>
				<c:if test="${not empty day2legSummaryVO.amendedUSDEquivalentAmt}"><fmt:formatNumber value="${day2legSummaryVO.amendedUSDEquivalentAmt}" /></c:if>
			</div>
		</div>
                    
		<div class="row highlighted">
			<div class="span5">
				<label>Request Derivatives</label>
					<c:if test="${not empty legSummaryVO.derivatives}">${legSummaryVO.derivatives}</c:if>
			</div>
			<div class="span5 right">
				<label>Original Legal Agreement Attached</label>
					<c:if test="${legSummaryVO.isEventNoticeAttachedFlag eq true}">Yes</c:if>
					<c:if test="${legSummaryVO.isEventNoticeAttachedFlag eq false}">No</c:if>
			</div>       				
		</div>
				
		 <jsp:include page="../common/derivativesDetails.jsp" />
			 
