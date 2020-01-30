<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
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
	<h2 class="span12 collapsible">Transaction Summary</h2>
	<div class="row">
	   <input type="hidden" name="legID" value='${legSummaryVO.legSeqId}'/>
		<div class="span12" >
			<label>${legSummaryVO.legSeqId}</label>
			<table
				class="table table-striped table-bordered sortable no-bottom table-nested">
				<thead>
					<tr>
						<th rowspan="2">#</th>
						<th rowspan="2">Action</th>
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
					
					<c:choose>
          					<c:when test="${legSummaryVO.derivatives eq 'Yes'}">
								<td><a href="#" data-nested="<c:out value="nested1"></c:out>" class="exp"></a></td>
							</c:when>
							<c:otherwise>
								<td>-</td>
							</c:otherwise>
						</c:choose>
						<td>-</td>
					    <c:if test="${empty legSummaryVO.transactionId}">
							<td>-</td>
						</c:if>
						<c:if test="${not empty legSummaryVO.transactionId}"> 
							<td>${legSummaryVO.transactionId}</td>
						</c:if>
						<c:if test="${empty legSummaryVO.legSeqId}">
							<td>-</td>
						</c:if>
						<c:if test="${not empty legSummaryVO.legSeqId}">
							<td>${legSummaryVO.legSeqId}</td>
						</c:if>
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
						
						
						<td>
							<c:choose>
										<c:when test="${empty legSummaryVO.transactionEventType}">
											<c:if test="${empty legSummaryVO.originalAmount}">
												-
											</c:if>
											<c:if test="${not empty legSummaryVO.originalAmount}">
												${legSummaryVO.originalAmount}
											</c:if>
											
										</c:when>
										<c:otherwise>
											<c:if test="${legSummaryVO.transactionEventTypeId eq 5}">
												<c:if test="${empty day2legSummaryVO.facilityIncDecAmt}">-</c:if>
												<c:if test="${not empty day2legSummaryVO.facilityIncDecAmt}"><fmt:formatNumber value="${day2legSummaryVO.facilityIncDecAmt}" /></c:if>	
											</c:if>
											<c:if test="${legSummaryVO.transactionEventTypeId != 5}">
												<c:if test="${empty legSummaryVO.originalAmount}">
												-
											</c:if>
											<c:if test="${not empty legSummaryVO.originalAmount}">
												${legSummaryVO.originalAmount}
											</c:if>
											</c:if>
										</c:otherwise>								
							</c:choose>							
						</td>
						<td>
							<c:choose>
								<c:when test="${empty legSummaryVO.transactionEventType}">
									<c:choose>
										<c:when test="${empty legSummaryVO.usdEquivalent}">
											-
										</c:when>	
										<c:otherwise>
											${legSummaryVO.usdEquivalent}
										</c:otherwise>
									</c:choose>	
								</c:when>
								<c:otherwise>
									<c:if test="${legSummaryVO.transactionEventTypeId eq 5}">
										<c:if test="${empty day2legSummaryVO.facilityIncDecUSDEquivalentAmt}">-</c:if>
										<c:if test="${not empty day2legSummaryVO.facilityIncDecUSDEquivalentAmt}"><fmt:formatNumber value="${day2legSummaryVO.facilityIncDecUSDEquivalentAmt}" /></c:if>	
									</c:if>
									<c:if test="${legSummaryVO.transactionEventTypeId != 5}">
										<c:choose>
											<c:when test="${empty legSummaryVO.usdEquivalent}">
												-
											</c:when>	
											<c:otherwise>
												${legSummaryVO.usdEquivalent}
											</c:otherwise>
										</c:choose>	
									</c:if>
								</c:otherwise>								
							</c:choose>	
						</td>	
						<td>
						<c:choose>
						<c:when test="${legSummaryVO.productType eq 'EQUITY'}"><bean:message key="label.addLeg.no" />
							<c:set var="eBoardARFlagValue" scope="request" value="yes" />
						</c:when>
						<c:otherwise>
							<c:set var="eBoardARFlagValue" scope="request" value="no" />
						${legSummaryVO.derivatives}
						</c:otherwise>
						</c:choose>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<c:choose>
          		<c:when test="${legSummaryVO.derivatives eq 'Yes'}">
				<table
					class="table table-striped table-bordered sortable no-bottom nested"
					id="nested1">
					<thead>
						<tr>
							<th rowspan="2"><bean:message key = "columnHeader.derivatives.itemNo" /></th>
							<th rowspan="2"><bean:message key = "columnHeader.derivatives.derivativeName" /></th>
							<th rowspan="2"><bean:message key = "columnHeader.derivatives.derivativeType" /></th>
							<th colspan="3" class="nosort"><bean:message key = "columnHeader.derivatives.currencyOne" /></th>
							<th colspan="3" class="nosort"><bean:message key = "columnHeader.derivatives.currencyTwo" /></th>
							<th rowspan="2"><bean:message key = "columnHeader.derivatives.hedgeDesg" /></th>
							<th rowspan="2"><bean:message key = "columnHeader.derivatives.taxDesg" /></th>
						</tr>
						<tr>
							<th><bean:message key = "columnHeader.derivatives.currency" /></th>
							<th><bean:message key = "columnHeader.derivatives.amount" /></th>
							<th><bean:message key = "columnHeader.derivatives.fixedFloat" /></th>
							<th><bean:message key = "columnHeader.derivatives.currency" /></th>
							<th><bean:message key = "columnHeader.derivatives.amount" /></th>
							<th><bean:message key = "columnHeader.derivatives.fixedFloat" /></th>
						</tr>
					</thead>
					<tbody>
					<c:set var="derivativeList" value="${deal:fetchDerivatives(legSummaryVO.legNumber,pageContext)}" />
					<c:forEach var="derivativesSummaryId" items="${derivativeList}" >
						<tr>
							<td>${derivativesSummaryId.derivativeNumber} </td>
							<td>${derivativesSummaryId.internalOrExternal }</td>
							<td>${derivativesSummaryId.derivativeType }</td>
							<td>${derivativesSummaryId.currency1 }</td>
							<td>${derivativesSummaryId.derivativeAmount1 }</td>
							<td>${derivativesSummaryId.fixedOrFloat1 }</td>
							<td>${derivativesSummaryId.currency2 }</td>
							<td>${derivativesSummaryId.derivativeAmount2 }</td>
							<td>${derivativesSummaryId.fixedOrFloat2 }</td>
							<td>${derivativesSummaryId.hedgeDesigation }</td>
							<td>${derivativesSummaryId.taxDesigation }</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
				
				</c:when>
				<c:otherwise>
				</c:otherwise>
			</c:choose>
		
		
	</div>
</div>


