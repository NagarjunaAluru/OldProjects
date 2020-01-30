<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en-US"/>
		<div class="form-mod">
			<h2 class="span12" id="legTable">Transaction Legs</h2>
			<div class="row">
				<div class="span12">

				 <table class="table table-striped table-bordered sortable no-bottom table-nested">
					<thead>
					  <tr>
						<th rowspan="2">#</th>
						<th rowspan="2">Action</th>
						<th rowspan="2">Leg #</th>
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
						<logic:notEmpty name="fourBlockerForm" property="deal.legSummaries" >
							<logic:iterate name="fourBlockerForm" property="deal.legSummaries" id="legSummary" indexId="itemNo" type="com.ge.icfp.model.LegSummary">
									<tr>
										<td><a href="#" data-nested="nested1" class="exp"></a></td>
										<td><a title="View this leg" href="07._RCA_-_Transfer_Pricing_-_Input.html" class="view-file"></a></td>
										<td>${legSummary.legId}</td>
										<td>${legSummary.productType}</td>
										<td>${legSummary.termInMonths}</td>
										<td>${legSummary.lenderProviderInfo.entity.legalEntityGoldId}</td>
										<td>${legSummary.lenderProviderInfo.entity.legalEntityGoldId}</td>
										<td>${legSummary.borrowerRecipientInfo.entity.legalEntityGoldId}</td>
										<td>${legSummary.borrowerRecipientInfo.entity.legalEntityGoldId}</td>
										<td>${legSummary.originalCCY}</td>
										<td>${legSummary.originalCCYAmount}</td>
										<td>${legSummary.originalCCYAmount}</td>
										<td>${legSummary.productType}</td>
										<td>${legSummary.productType}</td>
									</tr>
							</logic:iterate>
					</logic:notEmpty>
					</tbody>
				  </table>
				</div>
				

									<table class="table table-striped table-bordered sortable no-bottom nested" id="nested1">
										<thead>
										  <tr>
											<th rowspan="2">Item No.</th>
											<th rowspan="2">Derivatives</th>
											<th rowspan="2">Derivatives Type</th>
											<th colspan="3" class="nosort">Currency 1</th>
											<th colspan="3" class="nosort">Currency 2</th>
											<th rowspan="2" >Hedge Degnation</th>
											<th rowspan="2" >Tax Degnation</th>
										  </tr>
										  <tr>
											<th>Currency</th>
											<th>Amount</th>
											<th>Fixed/Float</th>
											<th>Currency</th>
											<th>Amount</th>
											<th>Fixed/Float</th>
										  </tr>
										</thead>
										<tbody>
										<logic:notEmpty name="fourBlockerForm" property="deal.legSummaries" >
											<logic:iterate name="fourBlockerForm" property="deal.legSummaries" id="legSummary" indexId="itemNo" type="com.ge.icfp.model.LegSummary">
										
											<c:forEach var="derivative" items="${legSummary.derivativesRequests}">
													<tr>
														<td></td>
														<td>${derivative.derivativeType}</td>
														<td>${derivative.internalOrExternalDerivative}</td>
														<td>${derivative.derivativeType}</td>
														<td>${derivative.currencySpreadPairs[0].currency}</td>
														<td>${derivative.currencySpreadPairs[0].spread}</td>
														<td>${derivative.currencySpreadPairs[0].spread}</td>
														<td>${derivative.currencySpreadPairs[1].currency}</td>
														<td>${derivative.currencySpreadPairs[1].spread}</td>
														<td>${derivative.currencySpreadPairs[1].spread}</td>
														<td>${derivative.hedgeDesignation}</td>
														<td>${derivative.taxDesigation}</td>
													</tr>		
											</c:forEach>
											</logic:iterate>
											</logic:notEmpty>				
										</tbody>
									  </table>
							</div>		  
			        </div><!-- end of form form-mod -->
