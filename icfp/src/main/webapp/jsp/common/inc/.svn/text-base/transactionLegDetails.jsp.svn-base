<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en-US"/>
<t:common/>
<div class="form-mod">
<%String hasEBoard = null;%>
	<c:set var="legSummaryVO" value="${deal:fetchLegSummary(param.id, pageContext.request)}" scope="page"/>
	<c:set var="day2legSummaryVO" value="${deal:fetchDay2LegSummary(requestScope.legNumber, pageContext.request)}" scope="page"/>
	<div class="row">
	   <input type="hidden" name="legID" value='${legSummaryVO.legSeqId}'/>
		<div class="span12">
			<label>${legSummaryVO.legSeqId}</label>
			<table
				class="table table-striped table-bordered sortable no-bottom">
				<thead>
					<tr>
						<th rowspan="2">Trade ID</th>
						<th rowspan="2">Leg #</th>
						<th rowspan="2"><bean:message key = "columnHeader.transactionLegs.productType" /></th>
						<th rowspan="2">Event</th>
						<th rowspan="2"><bean:message key = "columnHeader.transactionLegs.term" /></th>
						<th colspan="2" class="nosort"><bean:message key = "columnHeader.transactionLegs.lender" /></th>
						<th colspan="2" class="nosort"><bean:message key = "columnHeader.transactionLegs.borrower" /></th>
						<th colspan="2" class="nosort"><bean:message key = "columnHeader.transactionLegs.origCurr" /></th>
						<th rowspan="2"><bean:message key = "columnHeader.transactionLegs.usdEquivalent" /></th>
						<th rowspan="2"><bean:message key = "columnHeader.transactionLegs.derivatives" /></th>
					</tr>
					<tr>
						<th><bean:message key = "columnHeader.transactionLegs.legalEntity" /></th>
						<th><bean:message key = "columnHeader.transactionLegs.country" /></th>
						<th><bean:message key = "columnHeader.transactionLegs.legalEntity" /></th>
						<th><bean:message key = "columnHeader.transactionLegs.country" /></th>
						<th><bean:message key = "columnHeader.transactionLegs.currency" /></th>
						<th><bean:message key = "columnHeader.transactionLegs.amount" /></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${not empty legSummaryVO.transactionId ? legSummaryVO.transactionId : '-'}</td>
						<td>${legSummaryVO.legSeqId}</td>
						<td>${legSummaryVO.productType}</td>
						<c:if test="${empty legSummaryVO.transactionEventType}">
							<td>-</td>
						</c:if>
						<c:if test="${not empty legSummaryVO.transactionEventType}"> 
							<td>
								<c:if test="${legSummaryVO.transactionEventTypeId eq 5}">
									<c:if test="${day2legSummaryVO.facilityTypeId eq 1}">Amendment - Facility Increase</c:if>
									<c:if test="${day2legSummaryVO.facilityTypeId eq 2}">Amendment - Facility Decrease</c:if>
								</c:if>
								<c:if test="${legSummaryVO.transactionEventTypeId != 5}">
										${legSummaryVO.transactionEventType}
								</c:if>
							</td>
						</c:if>
						<c:if test="${empty legSummaryVO.termsInMths}">
							<td>-</td>
						</c:if>
						<c:if test="${not empty legSummaryVO.termsInMths}"> 
							<td>${legSummaryVO.termsInMths}</td>
						</c:if>
						<c:if test="${empty legSummaryVO.lenderLegalEntity}">
							<td>-</td>
						</c:if>
						<c:if test="${not empty legSummaryVO.lenderLegalEntity}"> 
							<td>${legSummaryVO.lenderLegalEntity}</td>
						</c:if>
						<c:if test="${empty legSummaryVO.lenderCountry}">
							<td>-</td>
						</c:if>
						<c:if test="${not empty legSummaryVO.lenderCountry}"> 
							<td>${legSummaryVO.lenderCountry}</td>
						</c:if>
						<c:if test="${empty legSummaryVO.borrowerLegalEntity}">
							<td>-</td>
						</c:if>
						<c:if test="${not empty legSummaryVO.borrowerLegalEntity}"> 
							<td>${legSummaryVO.borrowerLegalEntity}</td>
						</c:if>
						<c:if test="${empty legSummaryVO.borrowerCountry}">
							<td>-</td>
						</c:if>
						<c:if test="${not empty legSummaryVO.borrowerCountry}"> 
							<td>${legSummaryVO.borrowerCountry}</td>
						</c:if>
						<c:if test="${empty legSummaryVO.originalCurrency}">
							<td>-</td>
						</c:if>
						<c:if test="${not empty legSummaryVO.originalCurrency}"> 
							<td>${legSummaryVO.originalCurrency}</td>
						</c:if>
						<c:if test="${empty legSummaryVO.originalAmount}">
							<td>-</td>
						</c:if>
						<c:if test="${not empty legSummaryVO.originalAmount}"> 
							<td>${legSummaryVO.originalAmount}</td>
						</c:if>
						<c:if test="${empty legSummaryVO.usdEquivalent}">
							<td>-</td>
						</c:if>
						<c:if test="${not empty legSummaryVO.usdEquivalent}"> 
							<td>${legSummaryVO.usdEquivalent}</td>
						</c:if>
						<td>
						<c:choose>
						<c:when test="${legSummaryVO.productType eq 'EQUITY'}"><bean:message key="label.addLeg.no" />
							<c:set var="eBoardARFlagValue" scope="request" value="yes" />
						</c:when>
						<c:otherwise>
						${legSummaryVO.derivatives}
						<c:set var="eBoardARFlagValue" scope="request" value="no" />
						
						</c:otherwise>
						</c:choose>
						</td>
					
				
				
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>