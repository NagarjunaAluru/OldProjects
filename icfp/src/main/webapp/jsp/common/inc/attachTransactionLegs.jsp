<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>
<t:common/>

	<%-- <h2 class="span9 collapsible" id="legTable"><bean:message key="heading.transactionLegs" /></h2> --%>
	
		
			<%-- <label><bean:message key="label.transactionLegs.noOfLegs" /> ${fourBlockerForm.deal.numberOfTransactions} 
				${fn:length(sessionScope.legDetails)} </label> --%>
			<table
				class="table table-striped table-bordered sortable no-bottom">
				<thead>
					<tr>
						<th rowspan="2"><bean:message key = "columnHeader.transactionLegs.select" /></th>
						<th rowspan="2"><bean:message key = "columnHeader.transactionLegs.legNo" /></th>
						<th rowspan="2"><bean:message key = "columnHeader.transactionLegs.productType" /></th>
						<th rowspan="2"><bean:message key = "columnHeader.transactionLegs.term" /></th>
						<th colspan="2" class="nosort"><bean:message key = "columnHeader.transactionLegs.lender" /></th>
						<th colspan="2" class="nosort"><bean:message key = "columnHeader.transactionLegs.borrower" /></th>
						<th colspan="2" class="nosort"><bean:message key = "columnHeader.transactionLegs.origCurr" /></th>
						<th rowspan="2"><bean:message key = "columnHeader.transactionLegs.usdEquivalent" /></th>
						<th rowspan="2"><bean:message key = "columnHeader.transactionLegs.derivatives" /></th>
						<th rowspan="2"><bean:message key = "columnHeader.transactionLegs.existing" /></th>
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
					<c:set var="rowCounter" value="1"></c:set>
					<c:forEach var="legDetailsId" items="${sessionScope.legDetails}" >
						<tr>
					
						<td><input type='radio' value='${legDetailsId.legSeqId}' name='optionsRadios'></td>
						<td>${legDetailsId.legNumber}</td>
						<td>${legDetailsId.productType}</td>
						<td>${legDetailsId.termsInMths}</td>
						<td>${legDetailsId.lenderLegalEntity}</td>
						<td>${legDetailsId.lenderCountry}</td>
						<td>${legDetailsId.borrowerLegalEntity}</td>
						<td>${legDetailsId.borrowerCountry}</td>
						<td>${legDetailsId.originalCurrency}</td>
						<td>${legDetailsId.originalAmount}</td>
						<td>${legDetailsId.usdEquivalent}</td>
						<td>${legDetailsId.derivatives}</td>
						<td>${legDetailsId.existing}</td>
						
					</tr>
					</c:forEach>
				</tbody>
			</table>
