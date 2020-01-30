<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${param.includeScripts != false}">
	<link href="${pageContext.request.contextPath}/ext/public/css/common/pagenavi.css" type="text/css" rel="stylesheet" />
	<script src="${pageContext.request.contextPath}/ext/public/js/ext/apm.js" type="text/javascript"></script>
</c:if>

<s:url var="exportURL" action="exportInvoiceFeeHistory" namespace="/ext/admin" />
<s:url id="downloadFHSearchResultsURL" action="downloadFHSearchResults" namespace="/ext/admin" />
<div class="form-mod" id="getSummary">
			<div class="row" id="full">
				<div class="span12">
					<h3><span class="defaultViewType"><s:text name="label.apm.topLevelSummary" /></span></h3>
					<p><span class="defaultViewDesc"><s:text name="label.apm.topLevelDesc" /></span></p> 
					<div class="right" style="margin: -40px 20px 2px;"><s:a href="%{exportURL}" cssClass="exportToExcel btn-secondary"><s:text name="label.apm.generateInvoice" /></s:a>
						&nbsp;&nbsp;<s:a href="%{downloadFHSearchResultsURL}" cssClass="btn-secondary"><s:text name="label.apm.exportSearchResults"/></s:a>
					</div>
					<hr class="hr3">
			<div id="searchSort">
			   	<div class="leftColSort">
			       	<p id="itemsPerPage">
			       	    <span id="start"></span> - <span id="end"></span> of <span id="total"></span> items
			       	</p>
			    </div>
			    <div class="rightColSort">
			         	Show&nbsp;&nbsp;
					<select class="pagination-rows">
					<option>10</option>
					<option>20</option>
					<option>30</option>
					<option>40</option>
					<option>50</option>
					</select>&nbsp;&nbsp;results
			    </div>	
				<div class="clear"></div>
			</div>	
						
			<table id="paymentDetails" class="table table-striped table-bordered sortable no-bottom paginate">
				<thead>
		            <tr id="column_head">
			            <th colspan="1"><b><input type="checkbox" class="feeHistCheckAll" /></b></th>
			            <th colspan="1"><b><s:text name="label.apm.paymentId" /></b></th>
			            <th colspan="1"><b><s:text name="label.apm.alocRecNumber" /></b></th>
			            <th colspan="1"><b><s:text name="label.apm.bankRefNumber" /></b></th>
			            <th class="hide GEApplicant" colspan="1"><b><s:text name="label.apm.geApplicant" /></b></th>
			            <th class="hide triPartyApplicant" colspan="1"><b><s:text name="label.apm.triPartyApplicant" /></b></th>
			            <th class="hide beneficiaryName" colspan="1"><b><s:text name="label.apm.benficiaryName" /></b></th>
			            <th colspan="1"><b><s:text name="label.apm.paymentCurrency" /></b></th>
			            <th colspan="1"><b><s:text name="label.apm.paymentAmount"/></b></th>
			            <th colspan="1"><b><s:text name="label.apm.paymentDate" /></b></th>
						<th class="hide USDPaymentAmount" colspan="1"><b><s:text name="label.apm.usdPaymentAmount" /></b></th>
			            <th class="hide USFeeTotal" colspan="1"><b><s:text name="label.apm.usFeeTotal" /></b></th>
			            <th class="hide foreignFeeTotal" colspan="1"><b><s:text name="label.apm.foreignFeeTotal" /></b></th>
			            <th class="hide periodFeeCredits" colspan="1"><b><s:text name="label.apm.periodFeeCredits" /></b></th>
			            <th class="hide periodAmendmentFees" colspan="1"><b><s:text name="label.apm.periodAmendmentFees" /></b></th>
			            <th class="hide otherFees" colspan="1"><b><s:text name="label.apm.otherFees" /></b></th>
			            <th class="hide oneTimeFees" colspan="1"><b><s:text name="label.apm.oneTimeFees" /></b></th>
			            <th class="hide modelID" colspan="1"><b><s:text name="label.apm.modelId" /></b></th>
			            <th class="appPrnName" colspan="1"><b><s:text name="label.apm.appPrnName" /></b></th>
			            <th class="benOblName" colspan="1"><b><s:text name="label.apm.benOblName" /></b></th>
			        </tr>
		        </thead>
				 <tbody>	
				    <s:if test="%{apmDetails.feeHistoryDetails.fullSummaries.size>0}">
				 	<s:iterator value="apmDetails.feeHistoryDetails.fullSummaries" status="stat">
						<tr class="shown" id="paymentRow<s:property value="paymentId" />">
				            <td><input type="checkbox" id="<s:property value="ALOCRecordNumber" />" value="<s:property value="paymentID" />" class="feeHistPaymentId"/></td>
							<td><s:if test="%{paymentID==null}">-</s:if><s:else>
								<s:form name="fhFeeSummaryForm" action="getFHFeeSummary" namespace="/ext/apm">
									 <s:hidden name="ALOCRecordNumber" value="%{ALOCRecordNumber}" />
									 <s:hidden name="PaymentId" value="%{PaymentID}" />
									 <s:hidden name="pageFrom" value="FeeHistory" />
	 								 <s:submit cssClass="submitLink" value="%{paymentID}" action="getFHFeeSummary" namespace="/ext/apm" />
								</s:form></s:else></td>
							<td><s:if test="%{ALOCRecordNumber==null}">-</s:if><s:else>
								<s:form name="viewFullRequestForm" action="viewFullRequest" namespace="/ext/apm">
									 <s:hidden name="requestId" value="%{ALOCRecordNumber}" />
									 <s:hidden name="returnToPage" value="FeeHistory" />
	 								 <s:submit cssClass="submitLink" value="%{alocRecordId}" action="viewFullRequest" namespace="/ext/apm" />
								</s:form>
								</s:else></td>
							<td><s:if test="%{bankReferenceNumber==null}">-</s:if><s:else><s:property value="bankReferenceNumber" /></s:else></td>
							<td class="hide GEApplicant"><s:if test="%{GEApplicant==null}">-</s:if><s:else><s:property value="GEApplicant" /></s:else></td>
							<td class="hide triPartyApplicant"><s:if test="%{triPartyApplicant==null}">-</s:if><s:else><s:property value="triPartyApplicant" /></s:else></td>
							<td class="hide beneficiaryName"><s:if test="%{beneficiaryName==null}">-</s:if><s:else><s:property value="beneficiaryName" /></s:else></td>
							<td><s:if test="%{paymentCurrencyName==null}">-</s:if><s:else><s:property value="paymentCurrencyName" /></s:else></td>
							<td><s:if test="%{paymentAmount==null}">-</s:if><s:else><s:property value="paymentAmount" /></s:else></td>
							<td><s:if test="%{paymentDate==null}">-</s:if><s:else><s:property value="paymentDate" /></s:else></td>
							<td class="hide USDPaymentAmount"><s:if test="%{USDPaymentAmount==null}">-</s:if><s:else><s:property value="USDPaymentAmount" /></s:else></td>
							<td class="hide USFeeTotal"><s:if test="%{USFeeTotal==null}">-</s:if><s:else><s:property value="USFeeTotal" /></s:else></td>
							<td class="hide foreignFeeTotal"><s:if test="%{foreignFeeTotal==null}">-</s:if><s:else><s:property value="foreignFeeTotal" /></s:else></td>
							<td class="hide periodFeeCredits"><s:if test="%{periodFeeCredits==null}">-</s:if><s:else><s:property value="periodFeeCredits" /></s:else></td>
							<td class="hide periodAmendmentFees"><s:if test="%{periodAmendmentFees==null}">-</s:if><s:else><s:property value="periodAmendmentFees" /></s:else></td>
							<td class="hide otherFees"><s:if test="%{otherFees==null}">-</s:if><s:else><s:property value="otherFees" /></s:else></td>
							<td class="hide oneTimeFees"><s:if test="%{oneTimeFees==null}">-</s:if><s:else><s:property value="oneTimeFees" /></s:else></td>
							<td class="hide modelID"><s:if test="%{modelId==null}">-</s:if><s:else><s:property value="modelId" /></s:else></td>
							<td class="appPrnName"><s:if test="%{GEApplicant==null}">-</s:if><s:else><s:property value="GEApplicant" /></s:else></td>
							<td class="benOblName"><s:if test="%{beneficiaryName==null}">-</s:if><s:else><s:property value="beneficiaryName" /></s:else></td>
						</tr>
					</s:iterator>
				 </s:if>
				 <s:else>
	            		<tr>
	            			<td colspan="11" style="text-align:center;color:blue; size:40px;">Nothing to Display </td>
	            		</tr>
						
				   </s:else>
				</tbody>
			</table>
				
			<div class="clear"></div>
			<div id="searchSort">
			   	<div class="leftColSort">
					<p id="itemsPerPage1"> <span id="start"></span> - <span id="end"></span> of <span id="total"></span> items</p>
				</div>
			</div>
			<div style="height:50px;"></div>				
					
			</div>
			</div>
			
			<div class="clear"></div>
			<div style="height:50px;"></div>    
			<div class="row">
				<div class="span right">
					<div class="pagenavi left">	
				    </div>
					<div class="span3 jump-page">
							 Jump to
							<input type="text" class="span1 manual">
							<a class="btn btn-success-blue" type="submit">Go</a>
					</div>
				</div>
		  </div>
		  <input type='hidden' id='current_page' />
		  <script src="${pageContext.request.contextPath}/ext/public/js/common/pagination.js"></script>
		  
			<div class="clear"></div>
		</div>
		
