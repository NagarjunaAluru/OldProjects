<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
  <head>
     <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
	 <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	 
	 <%@include file="/jsp/common/includeCommonScripts.jsp" %>
	 <title><s:text name="label.request.feeSummaryDetail" /></title>
     <style type="text/css">
		h1 { color:#666!important; font-size:26px!important; font-weight:bold!important;}
	</style>
  </head>

  <body>
	<div class="container main">
	    <jsp:include page="/jsp/common/headerSection.jsp">
			<jsp:param name="createReqPopup" value="Yes"></jsp:param>
		</jsp:include>
		<div id="mainPage">
		
		<h1 class="page-title span12"><s:text name="label.request.feeSummaryDetail"/></h1>
		<p class="span12 left clear dashdesc"><s:label key="label.request.displayFee"/></p>
		<hr class="page-title-hr">	
		<s:if test="hasActionMessages()">
			<div class="row">
				<div class="span12">
					<div class="errorbox">
						<div class="errorHead">
							<p class="erroricon">
								<s:text name="label.eas.common.error" />
							</p>
						</div>
						<div class="errorContent">
							<p>
								<s:actionmessage />
							</p>
						</div>
					</div>
				</div>
			</div>
		</s:if>
		
		<div class="row">
			<div class="span12 bluebg">
				<h2 class="apmSummary"><s:text name="label.request.requestSummary"/> -
				<s:text name="label.request.AlocRecordNo"/> 
				<s:property value="apmDetails.feeSummaryDetails.feeRequestSummary.alocRecordId"/></h2><hr class="h2-hr">
				<div class="row lastrow">
					<div class="span2">
						<label class="right"><s:text name="label.request.AlocApplicantName"/> : </label>
					</div>
					<div class="span4"><p>
					<c:if test="${apmDetails.feeSummaryDetails.feeRequestSummary.applicant.userDetails.firstName eq null}">
	                 -</c:if>
   					 <s:property value="apmDetails.feeSummaryDetails.feeRequestSummary.applicant.userDetails.firstName"/></div>
				</div>
				<div class="row lastrow">
					<div class="span2">
						<label class="right"><s:text name="label.request.FTRNNo"/> :</label>
					</div>
					<div class="span2"><p>
					<c:if test="${apmDetails.feeSummaryDetails.feeRequestSummary.FTRNNumber eq null}">-
                    </c:if><s:property value="apmDetails.feeSummaryDetails.feeRequestSummary.FTRNNumber"/></div>
					<div class="span2">
						<label class="right"><s:text name="label.request.bankname"/> :</label>
					</div>
					<div class="span2"><p>
					<c:if test="${apmDetails.feeSummaryDetails.feeRequestSummary.winningBankName eq null}"> -
                    </c:if><s:property value="apmDetails.feeSummaryDetails.feeRequestSummary.winningBankName"/></p></div>
					<div class="span2">
						<label class="right"><s:text name="label.request.BankRefNo"/>:</label>
					</div>
					<div class="span2"><p>
					<c:if test="${apmDetails.feeSummaryDetails.feeRequestSummary.bankReferenceNumber eq null}"> -
                    </c:if><s:property value="apmDetails.feeSummaryDetails.feeRequestSummary.bankReferenceNumber"/></p></div>
				</div>
				
				<h2 class="apmSummary"><s:text name="label.request.feeSummary"/>  
				<s:property value="apmDetails.feeSummaryDetails.feeSummary.currencyCode"/></h2><hr class="h2-hr">
				<div class="row lastrow">
					<div class="span2">
						<label class="right"><s:text name="label.FeeSummary.totalPayment" /> :</label>
					</div>
					<div class="span2"><p>
					<c:if test="${apmDetails.feeSummaryDetails.feeSummary.totalPayment eq null}"> - 
                    </c:if><s:property value="apmDetails.feeSummaryDetails.feeSummary.totalPayment"/></div>
				</div>
				<div class="row">
					<div class="span2">
						<label class="right"><s:text name="label.rerquest.totalUS" /> :</label>
					</div>
					<div class="span2"><p>
					 <c:if test="${apmDetails.feeSummaryDetails.feeSummary.totalUS eq null}"> - 
                     </c:if><s:property value="apmDetails.feeSummaryDetails.feeSummary.totalUS"/></div>
					<div class="span2">
						<label class="right"><s:text name="label.request.TotalForeign" /> :</label>
					</div>
					<div class="span2"><p>
					<c:if test="${apmDetails.feeSummaryDetails.feeSummary.totalForeign eq null}"> - 
                    </c:if><s:property value="apmDetails.feeSummaryDetails.feeSummary.totalForeign"/></div>
					<div class="span2">
						<label class="right"><s:text name="label.request.TotalOther" /> :</label>
					</div>
					<div class="span2"><p>
					<c:if test="${apmDetails.feeSummaryDetails.feeSummary.totalOther eq null}"> - 
                    </c:if><s:property value="apmDetails.feeSummaryDetails.feeSummary.totalOther"/></div>
				</div>
			</div>
		</div>
	
		<div class="row">
			<div class="span12">
			    <s:url action="searchFeeHistory.action" namespace="/int/admin" var="feeHistoryURL" />
			    <s:url action="getFeePaymentRunCalculateFees.action" namespace="/int/apm" var="feePaymentRunURL" escapeAmp="false" encode="true">
			    	<s:param name="showCalculateFeeTable">true</s:param>
			    </s:url>
			    <c:choose>
				<c:when test="${pageFrom eq 'FeeHistory'}">
            	<a href="<s:property value="#feeHistoryURL" />" ><s:text name="label.request.returnFeeHistory"/></a>
           		</c:when>
           		<c:otherwise>
           		<a href="<s:property value="#feePaymentRunURL" />" ><s:text name="label.request.returnToFeePaymentRun" /> </a>
           		</c:otherwise>
           		</c:choose>
           		
           		<s:form name="feeSummaryForm" action="openRequest" namespace="/int">
	               	<s:hidden name="requestId" value="%{apmDetails.feeSummaryDetails.feeRequestSummary.requestId}"/>
	                <s:hidden name="dashboardViewType" value="ALLREQUESTS"/>
	                <s:hidden name="returnToPage" value="%{pageFrom}" />
	               	<s:hidden name="stage" value="%{apmDetails.feeSummaryDetails.WFDetails.WFStageID}"/>
	       			<s:hidden name="wfid" value="%{apmDetails.feeSummaryDetails.WFDetails.WFID}"/>
	       			<s:hidden name="queueName" value="%{apmDetails.feeSummaryDetails.WFDetails.queueName}"/>
	       			<s:hidden name="procedureName" value="%{apmDetails.feeSummaryDetails.WFDetails.procedureName}"/>
	       			<s:hidden name="stageName" value="%{apmDetails.feeSummaryDetails.WFDetails.WFStage}"/>
	                
	                <s:submit cssClass="submitLink right" value="View Full Request" action="openRequest" namespace="/int"/>
				</s:form>
			</div>
		</div>
   
		<div class="form-mod">
		    <h3><s:text name="label.request.USFees"/>
			<p><s:text name="label.request.USFees.note"/></p>
			</h3>
			
            <div class="row">
				<div class="span12">
					<table class="table table-striped table-bordered sortable no-bottom" id="usFeesTable">
						<thead>
							<tr>
						        <c:choose>
						        <c:when test="${pageFrom eq 'FeeHistory'}">
						     	<th colspan="1"><b><s:text name="label.request.USFees.lineItemType" /></b></th>
						        <th><b><s:text name="label.request.USFees.startPeriod"/></b></th>
						        <th><b><s:text name="label.request.USFees.endPeriod"/></b></th>
						        </c:when>
						        <c:otherwise>
						        <th><b><s:text name="label.request.chargeType" /></b></th>
						        </c:otherwise>
						        </c:choose>
						        <th><b><s:text name="label.request.USFees.numberOfDays"/></b></th>
						        <th><b><s:text name="label.request.USFees.bPsRateInArrears"/></b></th>
						        <th><b><s:text name="label.request.USFees.bPsRateInAdvance"/></b></th>
						        <th><b><s:text name="label.request.USFees.flatFeePA"/></b></th>
						        <th><b><s:text name="label.request.USFees.flatFeeLife"/></b></th>
						        <th><b><s:text name="label.request.USFees.partialPeriodAmount"/></b></th>
						        <th><b><s:text name="label.request.USFees.amendment"/></b></th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="apmDetails.feeSummaryDetails.USForeignFee.USFeeDetails.feeDetails">
			            	<tr>
                                <c:choose>
						        <c:when test="${pageFrom eq 'FeeHistory'}">
						         <c:set var="spanValue" value="9"></c:set>
						     	 <td><p><c:if test="${lineItemType eq null}"> -
                                </c:if><s:property value="lineItemType"/></p></td>
                                <td><p><c:if test="${startPeriod eq null}"> -
                                </c:if><s:property value="startPeriod"/></p></td>
								<td><p><c:if test="${endPeriod eq null}"> -
                                </c:if><s:property value="endPeriod"/></p></td>
						        </c:when>
						        <c:otherwise>
						         <c:set var="spanValue" value="7"></c:set>
						        <td><p><c:if test="${lineItemType eq null}"> -
                                </c:if><s:property value="lineItemType"/></p></td>
						        </c:otherwise>
						        </c:choose>
								<td><p><c:if test="${numberOfDays eq null}">
	                              -
                                </c:if><s:property value="numberOfDays"/></p></td>
								<td><p><c:if test="${bPsRateInArrears eq null}">
	                              -
                                </c:if><s:property value="bPsRateInArrearsString"/></p></td>
								<td><p><c:if test="${bPsRateInAdvance eq null}">
	                              -
                                </c:if><s:property value="bPsRateInAdvanceString"/></p></td>
								<td><p><c:if test="${flatFeePA eq null}">
	                              -
                                </c:if><s:property value="flatFeePA"/></p></td>
								<td><p><c:if test="${flatFeeLife eq null}">
	                              -
                                </c:if><s:property value="flatFeeLife"/></p></td>
								<td><p><c:if test="${partialPeriodAmount eq null}">
	                              -
                                </c:if><s:property value="partialPeriodAmount"/></p></td>
								<td><p><c:if test="${amendment eq null}">
	                              -
                                </c:if><s:property value="amendment"/></p></td>
							</tr> 
							</s:iterator>
							<tr>
								<td colspan="${spanValue}" align="center" style="border-right:0px Solid #000;"><span class="right"><s:text name="label.request.USFees.totalAmendment"/></span></td>
								<td colspan="1" align="center" style="border-left:0px Solid #000;"><span class=""><s:property value="apmDetails.feeSummaryDetails.USForeignFee.USTotalAmendment"/></span></td>
							</tr>
							<tr>
								<td colspan="${spanValue}" align="center" style="border-right:0px Solid #000;"><span class="right"><s:text name="label.request.USFees.totalPayment"/></span></td>
								<td colspan="1" align="center" style="border-left:0px Solid #000;"><span class=""><s:property value="apmDetails.feeSummaryDetails.USForeignFee.USTotalPayment"/></span></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			
		
			<h3><s:text name="label.request.foreignFees"/>
			<p><s:text name="label.request.foreignFees.note"/></p></h3>
            <div class="row">
				<div class="span12">
					<table class="table table-striped table-bordered sortable no-bottom" id="foreignFeesTable">
						<thead>
							<tr>
						        <c:choose>
						        <c:when test="${pageFrom eq 'FeeHistory'}">
						   		<th colspan="1"><b><s:text name="label.request.foreignFees.lineItemType"/></b></th>
						        <th><b><s:text name="label.request.foreignFees.startPeriod"/></b></th>
						        <th><b><s:text name="label.request.foreignFees.endPeriod"/></b></th>
						        </c:when>
						        <c:otherwise>
						        <th><b><s:text name="label.request.chargeType"/></b></th>
						        </c:otherwise>
						        </c:choose>
						        <th><b><s:text name="label.request.foreignFees.numberOfDays"/></b></th>
						        <th><b><s:text name="label.request.foreignFees.bPsRateInArrears"/></b></th>
						        <th><b><s:text name="label.request.foreignFees.bPsRateInAdvance"/></b></th>
						        <th><b><s:text name="label.request.foreignFees.flatFeePA"/></b></th>
						        <th><b><s:text name="label.request.foreignFees.flatFeeLife"/></b></th>
						        <th><b><s:text name="label.request.foreignFees.partialPeriodAmount"/></b></th>
						        <th><b><s:text name="label.request.foreignFees.amendment"/></b></th>
							</tr>
						</thead>
						<tbody>
						<s:iterator value="apmDetails.feeSummaryDetails.USForeignFee.foreignFeeDetails.feeDetails">
		            	<tr>
			                	<c:choose>
						        <c:when test="${pageFrom eq 'FeeHistory'}">
						     	 <td><p><c:if test="${lineItemType eq null}"> -
                                </c:if><s:property value="lineItemType"/></p></td>
                                <td><p><c:if test="${startPeriod eq null}"> -
                                </c:if><s:property value="startPeriod"/></p></td>
								<td><p><c:if test="${endPeriod eq null}"> -
                                </c:if><s:property value="endPeriod"/></p></td>
						        </c:when>
						        <c:otherwise>
						        <td><p><c:if test="${lineItemType eq null}"> -
                                </c:if><s:property value="lineItemType"/></p></td>
						        </c:otherwise>
						        </c:choose>
								<td><p><c:if test="${numberOfDays eq null}">
	                              -
                                </c:if><s:property value="numberOfDays"/></p></td>
								<td><p><c:if test="${bPsRateInArrears eq null}">
	                              -
                                </c:if><s:property value="bPsRateInArrearsString"/></p></td>
								<td><p><c:if test="${bPsRateInAdvance eq null}">
	                              -
                                </c:if><s:property value="bPsRateInAdvanceString"/></p></td>
								<td><p><c:if test="${flatFeePA eq null}">
	                              -
                                </c:if><s:property value="flatFeePA"/></p></td>
								<td><p><c:if test="${flatFeeLife eq null}">
	                              -
                                </c:if><s:property value="flatFeeLife"/></p></td>
								<td><p><c:if test="${partialPeriodAmount eq null}">
	                              -
                                </c:if><s:property value="partialPeriodAmount"/></p></td>
								<td><p><c:if test="${amendment eq null}">
	                              -
                                </c:if><s:property value="amendment"/></p></td>
						</tr> 
						</s:iterator>
							<tr>
								<td colspan="${spanValue}" align="center" style="border-right:0px Solid #000;"><span class="right"><s:text name="label.request.foreignFees.totalAmendment"/></span></td>
								<td colspan="1" align="center" style="border-left:0px Solid #000;"><span class=""><s:property value="apmDetails.feeSummaryDetails.USForeignFee.foreignTotalAmendment"/></span></td>
							</tr>
							<tr>
								<td colspan="${spanValue}" align="center" style="border-right:0px Solid #000;"><span class="right"><s:text name="label.request.foreignFees.totalPayment"/></span></td>
								<td colspan="1" align="center" style="border-left:0px Solid #000;"><span class=""><s:property value="apmDetails.feeSummaryDetails.USForeignFee.foreignTotalPayment"/></span></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<h3><s:text name="label.request.otherFees"/></h3>
            <div class="row">
				<div class="span12">
					<table class="table table-striped table-bordered sortable no-bottom" id="otherFeesTable">
						<thead>
							<tr>
							    <th colspan="1"><b><s:text name="label.request.otherFees.lineItemType"/></b></th>
						        <th><b><s:text name="label.request.otherFees.VATTaxes"/></b></th>
						        <th><b><s:text name="label.request.otherFees.stampTaxes"/></b></th>
						        <th><b><s:text name="label.request.otherFees.incidental"/></b></th>
						        <th><b><s:text name="label.request.otherFees.other"/></b></th>
						        <th><b><s:text name="label.request.otherFees.oneTime"/></b></th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="apmDetails.feeSummaryDetails.otherFees">
				            	<tr>
					                	<td><p><c:if test="${lineItemType eq null}">
			                              -
		                                </c:if><s:property value="lineItemType"/></p></td>
										<td><p><c:if test="${VATTaxes eq null}">
			                              -
		                                </c:if><s:property value="VATTaxes"/></p></td>
										<td><p><c:if test="${stampTaxes eq null}">
			                              -
		                                </c:if><s:property value="stampTaxes"/></p></td>
										<td><p><c:if test="${incidental eq null}">
			                              -
		                                </c:if><s:property value="incidental"/></p></td>
										<td><p><c:if test="${other eq null}">
			                              -
		                                </c:if><s:property value="other"/></p></td>
										<td><p><c:if test="${oneTime eq null}">
			                              -
		                                </c:if><s:property value="oneTime"/></p></td>
								</tr> 
							</s:iterator>
							<tr>
								<td colspan="5" align="center" style="border-right:0px Solid #000;"><span class="right"><s:text name="label.request.otherFees.Total"/></span></td>
								<td colspan="1" align="center" style="border-left:0px Solid #000;"><span class=""><s:property value="apmDetails.feeSummaryDetails.totalOther"/></span></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>	
			<div class="row">
				<div class="span12">
	            	<c:choose>
					<c:when test="${pageFrom eq 'FeeHistory'}">
	            	<a href="<s:property value="#feeHistoryURL" />" ><s:text name="label.request.returnFeeHistory"/></a>
	           		</c:when>
	           		<c:otherwise>
	           		<a href="<s:property value="#feePaymentRunURL" />" ><s:text name="label.request.returnToFeePaymentRun" /></a>
	           		</c:otherwise>
	           		</c:choose>			
			   </div>  
		  </div>  
        
	
	</div>
	</div>
	<%@include  file="/jsp/common/footerSection.jsp" %>
</body>
</html>