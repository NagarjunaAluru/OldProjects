<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script src="${pageContext.request.contextPath}/js/requestor/calculateFeeExpand.js" type="text/javascript"></script>
	<div class="innerDiv">
		<div class="clear"></div>
		<table class="table table-striped table-bordered">
			<thead>
				<tr style="background-color:#819EB6!important;">
					<th colspan="1"><b><s:text name="label.request.quickView" /></b></th>
					<th colspan="1"><b><s:text name="label.apm.alocRecNumber" /></b></th>
					<th colspan="1"><b><s:text name="label.apm.bankRefNumber" /></b></th>
					<th colspan="1"><b><s:text name="label.request.bucadn" /></b></th>
					<th colspan="1"><b><s:text name="label.request.feeCalculationPeriod" /></b></th>
					<th colspan="1"><b><s:text name="label.apm.paymentAmount" /></b></th>
					<th colspan="1"><b><s:text name="label.request.usdEquivalent" /></b></th>
					<th colspan="1"><b><s:text name="label.request.periodAmendments" /></b></th>
					<th colspan="1"><b><s:text name="label.request.totalAmendments" /></b></th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="apmDetails.feePaymentRunDetails.requestFeeDetails" status="stat">
				<tr>
					<td><c:if test="${empty requestId}">-</c:if><c:if test="${not empty requestId}">
					<a href="javascript:;" id="quickViewIcon<s:property value="#stat.count" />" class="quickViewIcon"><span class="hide"><s:property  value="requestId"/></span><img src="${pageContext.request.contextPath}/img/eye-ico.png"></a>
							&nbsp;<img alt="Loading..." class="feeQuickViewProcess" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px;">
							<div id="newboxes${param.bankMDMId}<s:property value="#stat.count" />" class="hide newboxes">
				                	<a href="#" class="right popClose">X</a>
				            </div></c:if></td>
					<td><c:if test="${empty requestId}">-</c:if><c:if test="${not empty requestId}">
					<s:url action="viewFullRequest.action" namespace="/int/apm" var="viewFullRequestURL" escapeAmp="false" encode="true">
					 <s:param name="requestId"><s:property value="requestId" /></s:param>
					 <s:param name="returnToPage">FeePaymentRun</s:param>
				    </s:url>
					<a href="<s:property value="#viewFullRequestURL"/>" ><s:property value="alocRecordId"/></a>&nbsp;
					</c:if></td>
					<td><c:if test="${empty bankReferenceNumber}">-</c:if><c:if test="${not empty bankReferenceNumber}">
					<c:out value="${bankReferenceNumber}"/></c:if></td>
					<td><c:if test="${empty BUCADNError}">-</c:if>
					<c:if test="${not empty BUCADNError}">
					<s:url action="getBUCADNDetails.action" namespace="/int/apm" var="getBucAdnRequest" escapeAmp="false" encode="true">
						<s:param name="BUC"><s:property value="BUC"/></s:param>
						<s:param name="ADN"><s:property value="ADN"/></s:param>
					</s:url>
						<c:if test="${BUCADNError eq 'InValid' or BUCADNError eq 'Invalid'}">
							<a href="<s:property value="getBucAdnRequest"/>"><s:property value="BUCADNError"/></a>
						 </c:if>
						 <c:if test="${BUCADNError ne 'InValid' and BUCADNError ne 'Invalid'}">
						 	<c:out value="${BUCADNError}"/>
						 </c:if>
					</c:if>
					</td>
					<td><c:if test="${empty feeCalcPeriodStartDt and empty feeCalcPeriodEndDt}">-</c:if>
					<c:if test="${not empty feeCalcPeriodStartDt and not empty feeCalcPeriodEndDt}">
					<s:property value="feeCalcPeriodStartDt"/> -<br/>
					<s:property value="feeCalcPeriodEndDt"/></c:if></td>
					<td><c:if test="${empty paymentAmountString}">-</c:if>
					<c:if test="${not empty paymentAmountString}">
					<s:url action="getFeeSummary.action" namespace="/int/apm" var="getFeeSummary" escapeAmp="false" encode="true">
					 <s:param name="ALOCRecordNumber"><s:property value="requestId" /></s:param>
					 <s:param name="pageFrom">FeePaymentRun</s:param>
				    </s:url>
					<a href="<s:property value="#getFeeSummary"/>" ><s:property value="paymentAmountString" /></a></c:if></td>
					<td><c:if test="${empty USDEquivalString}">-</c:if><c:if test="${not empty USDEquivalString}">
					<c:out value="${USDEquivalString}"/></c:if></td>
					<td><c:if test="${empty periodAmendments}">-</c:if><c:if test="${not empty periodAmendments}">
					<c:out value="${periodAmendments}"/></c:if></td>
					<td><c:if test="${empty totalAmendments}">-</c:if><c:if test="${not empty totalAmendments}">
					<c:out value="${totalAmendments}"/></c:if></td>
				</tr>
				</s:iterator>
			</tbody>
		</table>
	</div>
	
	       