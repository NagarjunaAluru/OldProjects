<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en-US"/>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:common/>
	
	
	<div class="form-mod">
			<h2 class="span12"></h2>
			<div class="row highlighted">
			<c:set var="legSummaryVO" value="${deal:fetchLegSummary(param.id, pageContext.request)}" scope="page"/>
				<div class="span5">
					<div class="form-row">
						<p><b>Product Type</b><br />
						${legSummaryVO.productType}</p>
					</div>
				</div><!-- end of block -->
				<div class="span5 right">
					<div class="form-row">
						<p><b>Deal Currency</b><br />
						${legSummaryVO.originalCurrency}</p>
					</div>
				</div><!-- end of block -->
			</div>
			<div class="row">
				<div class="span5">
					<div class="form-row">
						<p><b>Form of Equity</b><br />
						${ EquityLegRequest.equityFormId}</p>
					</div>
				</div><!-- end of block -->
				<div class="span5 right">
					<div class="form-row">
						<p><b>Amount</b><br />
						${legSummaryVO.originalAmount}</p>
					</div>
				</div><!-- end of block -->
			</div>
			<div class="row highlighted">
				<div class="span5">
					<div class="form-row">
						<p><b>Provider</b><br />
						${legSummaryVO.lenderLegalEntity}</p>
					</div>
				</div><!-- end of block -->
				<div class="span5 right">
					<div class="form-row">
						<p><b>USD equivalent</b><br />
						${legSummaryVO.usdEquivalent}</p>
					</div>
				</div><!-- end of block -->
			</div>
			<div class="row">
				<div class="span5">
					<div class="form-row">
						<p><b>Recipient</b><br />
						${legSummaryVO.borrowerLegalEntity}</p>
					</div>
				</div><!-- end of block -->
				<div class="span5 right">
					<div class="form-row">
						<p><b>Double leverage</b><br />
						${ EquityLegRequest.doubleLeverageFlag}</p>
					</div>
				</div><!-- end of block -->
			</div>
			<div class="row highlighted">
				<div class="span5">
					<div class="form-row">
						<p><b>Is this an existing Equity?</b><br />
						${legSummaryVO.existing}</p>
					</div>
				</div><!-- end of block -->
				<div class="span5 right">
					<div class="form-row">
						<p><b>eBoardroom eligible</b><br />
						${ EquityLegRequest.eBoardApprovalRequiredFlag}</p>
					</div>
				</div><!-- end of block -->
			</div>
			<div class="row ">
				<div class="span5">
					<div class="form-row">
						<p><b>Are there Derivatives?</b><br />
						${legSummaryVO.derivatives}</p>
					</div>
				</div><!-- end of block -->
			</div>
			<h3 class="span12">Equity Details</h3>
			<div class="row">
				<div class="span12">
				 <table class="table table-striped table-bordered sortable">
					<thead>
					  <tr>
						<th>Debt terms</th>
						<th>Share type</th>
						<th>Number of shares</th>
						<th>Par value per share</th>
					  </tr>
					</thead>
					<tbody>
					
					  <tr>
						<td>${ EquityLegRequest.debtTerms}</td>
						<td>${ EquityLegRequest.shareTypeId}</td>
						<td>${ EquityLegRequest.numberOfShares}</td>
						<td>${ EquityLegRequest.shareTypeId}</td>
					  </tr>
					 
					</tbody>
				  </table>
				</div>
			</div> 
			<h3 class="span12">Description</h3>
			<div class="row comment-container">
				<div class="span5">
					<div class="form-row autosize-container">
						<span class="required"></span>
						<label>Comments</label>
						<div class="char-count">1000</div>
						<textarea class="xlarge autosize messageinput" name="textarea2" rows="1" data-max="1000" onblur="scriptInjection(this);"></textarea>
					</div>
				</div> <!-- end of block -->
			</div>
		
		</div>
		<div class="form-mod">
			<div class="row">
				<div class="span12">
				<label class="leg-ref">${sessionScope.deal.dealSeqId} - ${legSummaryVO.legSeqId}</label>
				<table class="table table-striped table-bordered sortable no-bottom">
					<thead>
					  <tr>
					  <th rowspan="2">Leg No.</th>
						<th rowspan="2">Product Type</th>
						<th rowspan="2">Term <span class="small">in months</span></th>
						<th colspan="2" class="nosort">Lender/Provider</th>
						<th colspan="2" class="nosort">Borrower/Recipient</th>
						<th colspan="2" class="nosort">Original Currency</th>
						<th rowspan="2">USD Equivalent</th>
						<th rowspan="2">Derivatives</th>
					  </tr>
					  <tr>
						<th>Legal Entity</th>
						<th>Country</th>
						<th>Legal Entity</th>
						<th>Country</th>
						<th>Currency</th>
						<th>Amount</th>
					  </tr>
					</thead>
					<tbody>
					  <tr>
					  <td>${legSummaryVO.legSeqId}</td>
						<td>${legSummaryVO.productType }</td>
						<td>${legSummaryVO.termsInMths}</td>
						<td>${legSummaryVO.lenderLegalEntity}</td>
						<td>${legSummaryVO.lenderCountry}</td>
						<td>${legSummaryVO.borrowerLegalEntity}</td>
						<td>${legSummaryVO.borrowerCountry}</td>
						<td>${legSummaryVO.originalCurrency}</td>
						<td>${legSummaryVO.originalAmount}</td>
						<td>${legSummaryVO.usdEquivalent}</td>
						<td>${legSummaryVO.derivatives}</td>
					  </tr>
					</tbody>
				  </table>
				</div>
			</div> 
		</div>