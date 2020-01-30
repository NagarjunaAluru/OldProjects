<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div id="feeSummaryQuickView">

					<h2 class="apmSummary"><s:text name="label.request.quickView.feeSummary" /> </h2><hr class="h2-hr">
					<div class="row lastrowQ">
						<div class="span3Q">
							<label class="rightQ"><s:text name="label.request.chargeType" />:</label>
						</div>
						<div class="span1Q">
							<p><c:if test="${not empty apmDetails.feeSummaryDetails.USForeignFee.USFeeDetails.feeDetails[0].lineItemType}">
							<s:property  value="apmDetails.feeSummaryDetails.USForeignFee.USFeeDetails.feeDetails[0].lineItemType"/></c:if>
							<c:if test="${empty apmDetails.feeSummaryDetails.USForeignFee.USFeeDetails.feeDetails[0].lineItemType}">-</c:if>
							 </p>
						</div>
						<div class="span3Q">
							<label class="rightQ"><s:text name="label.request.chargeType" />:</label>
						</div>
						<div class="span1Q">
							<p><c:if test="${not empty apmDetails.feeSummaryDetails.USForeignFee.foreignFeeDetails.feeDetails[0].lineItemType}">
							<s:property  value="apmDetails.feeSummaryDetails.USForeignFee.foreignFeeDetails.feeDetails[0].lineItemType"/></c:if>
							<c:if test="${empty apmDetails.feeSummaryDetails.USForeignFee.foreignFeeDetails.feeDetails[0].lineItemType}">-</c:if>
							 </p>
						</div>
					</div>
					<div class="row lastrowQ">
						<div class="span3Q">
							<label class="rightQ"><s:text name="label.request.USFees.numberOfDays" />:</label>
						</div>
						<div class="span1Q">
							<p><c:if test="${not empty apmDetails.feeSummaryDetails.USForeignFee.USFeeDetails.feeDetails[0].numberOfDays}">
							<s:property  value="apmDetails.feeSummaryDetails.USForeignFee.USFeeDetails.feeDetails[0].numberOfDays"/></c:if>
							<c:if test="${empty apmDetails.feeSummaryDetails.USForeignFee.USFeeDetails.feeDetails[0].numberOfDays}">-</c:if>
							 </p>
						</div>
						<div class="span3Q">
							<label class="rightQ"><s:text name="label.request.USFees.numberOfDays" />:</label>
						</div>
						<div class="span1Q">
							<p><c:if test="${not empty apmDetails.feeSummaryDetails.USForeignFee.foreignFeeDetails.feeDetails[0].numberOfDays}">
							<s:property  value="apmDetails.feeSummaryDetails.USForeignFee.foreignFeeDetails.feeDetails[0].numberOfDays"/></c:if>
							<c:if test="${empty apmDetails.feeSummaryDetails.USForeignFee.foreignFeeDetails.feeDetails[0].numberOfDays}">-</c:if>
							 </p>
						</div>
					</div>
					<div class="row lastrowQ">
						<div class="span3Q">
							<label class="rightQ"><s:text name="label.request.USFees.bPsRateInArrears" />:</label>
						</div>
						<div class="span1Q">
							<p><c:if test="${not empty apmDetails.feeSummaryDetails.USForeignFee.USFeeDetails.feeDetails[0].BPsRateInArrears}">
							<c:out  value="${apmDetails.feeSummaryDetails.USForeignFee.USFeeDetails.feeDetails[0].BPsRateInArrears}"/></c:if>
							<c:if test="${empty apmDetails.feeSummaryDetails.USForeignFee.USFeeDetails.feeDetails[0].BPsRateInArrears}">-</c:if>
							 </p>
						</div>
						<div class="span3Q">
							<label class="rightQ"><s:text name="label.request.foreignFees.bPsRateInArrears" />:</label>
						</div>
						<div class="span1Q">
							<p><c:if test="${not empty apmDetails.feeSummaryDetails.USForeignFee.foreignFeeDetails.feeDetails[0].BPsRateInArrears}">
							<c:out  value="${apmDetails.feeSummaryDetails.USForeignFee.foreignFeeDetails.feeDetails[0].BPsRateInArrears}"/></c:if>
							<c:if test="${empty apmDetails.feeSummaryDetails.USForeignFee.foreignFeeDetails.feeDetails[0].BPsRateInArrears}">-</c:if>
							 </p>
						</div>
					</div>
					<div class="row lastrowQ">
						<div class="span3Q">
							<label class="rightQ"><s:text name="label.request.USFees.bPsRateInAdvance" />:</label>
						</div>
						<div class="span1Q">
							<p><c:if test="${not empty apmDetails.feeSummaryDetails.USForeignFee.USFeeDetails.feeDetails[0].BPsRateInAdvance}">
							<c:out value="${apmDetails.feeSummaryDetails.USForeignFee.USFeeDetails.feeDetails[0].BPsRateInAdvance}"/></c:if>
							<c:if test="${empty apmDetails.feeSummaryDetails.USForeignFee.USFeeDetails.feeDetails[0].BPsRateInAdvance}">-</c:if>
							 </p>
						</div>
						<div class="span3Q">
							<label class="rightQ"><s:text name="label.request.foreignFees.bPsRateInAdvance" />:</label>
						</div>
						<div class="span1Q">
							<p><c:if test="${not empty apmDetails.feeSummaryDetails.USForeignFee.foreignFeeDetails.feeDetails[0].BPsRateInAdvance}">
							<c:out  value="${apmDetails.feeSummaryDetails.USForeignFee.foreignFeeDetails.feeDetails[0].BPsRateInAdvance}"/></c:if>
							<c:if test="${empty apmDetails.feeSummaryDetails.USForeignFee.foreignFeeDetails.feeDetails[0].BPsRateInAdvance}">-</c:if>
							 </p>
						</div>
					</div>
					<div class="row lastrowQ">
						<div class="span3Q">
							<label class="rightQ"><s:text name="label.request.quickView.usFlatFeesPA" />:</label>
						</div>
						<div class="span1Q">
							<p><c:if test="${not empty apmDetails.feeSummaryDetails.USForeignFee.USFeeDetails.feeDetails[0].flatFeePA}">
							<s:property  value="apmDetails.feeSummaryDetails.USForeignFee.USFeeDetails.feeDetails[0].flatFeePA"/></c:if>
							<c:if test="${empty apmDetails.feeSummaryDetails.USForeignFee.USFeeDetails.feeDetails[0].flatFeePA}">-</c:if>
							 </p>
						</div>
						<div class="span3Q">
							<label class="rightQ"><s:text name="label.request.quickView.foreignFlatFeesPA" />:</label>
						</div>
						<div class="span1Q">
							<p><c:if test="${not empty apmDetails.feeSummaryDetails.USForeignFee.foreignFeeDetails.feeDetails[0].flatFeePA}">
							<s:property  value="apmDetails.feeSummaryDetails.USForeignFee.foreignFeeDetails.feeDetails[0].flatFeePA"/></c:if>
							<c:if test="${empty apmDetails.feeSummaryDetails.USForeignFee.foreignFeeDetails.feeDetails[0].flatFeePA}">-</c:if>
							 </p>
						</div>
					</div>
					<div class="row lastrowQ">
						<div class="span3Q">
							<label class="rightQ"><s:text name="label.request.quickView.usFlatFeesLife" />:</label>
						</div>
						<div class="span1Q">
							<p><c:if test="${not empty apmDetails.feeSummaryDetails.USForeignFee.USFeeDetails.feeDetails[0].flatFeeLife}">
							<s:property  value="apmDetails.feeSummaryDetails.USForeignFee.USFeeDetails.feeDetails[0].flatFeeLife"/></c:if>
							<c:if test="${empty apmDetails.feeSummaryDetails.USForeignFee.USFeeDetails.feeDetails[0].flatFeeLife}">-</c:if>
							 </p>
						</div>
						<div class="span3Q">
							<label class="rightQ"><s:text name="label.request.quickView.foreignFlatFeesLife" />:</label>
						</div>
						<div class="span1Q">
							<p><c:if test="${not empty apmDetails.feeSummaryDetails.USForeignFee.foreignFeeDetails.feeDetails[0].flatFeeLife}">
							<s:property  value="apmDetails.feeSummaryDetails.USForeignFee.foreignFeeDetails.feeDetails[0].flatFeeLife"/></c:if>
							<c:if test="${empty apmDetails.feeSummaryDetails.USForeignFee.foreignFeeDetails.feeDetails[0].flatFeeLife}">-</c:if>
							 </p>
						</div>
					</div>
					<div class="row lastrowQ">
						<div class="span3Q">
							<label class="rightQ"><s:text name="label.request.USFees.partialPeriodAmount" />:</label>
						</div>
						<div class="span1Q">
							<p><c:if test="${not empty apmDetails.feeSummaryDetails.USForeignFee.USFeeDetails.feeDetails[0].partialPeriodAmount}">
							<s:property  value="apmDetails.feeSummaryDetails.USForeignFee.USFeeDetails.feeDetails[0].partialPeriodAmount"/></c:if>
							<c:if test="${empty apmDetails.feeSummaryDetails.USForeignFee.USFeeDetails.feeDetails[0].partialPeriodAmount}">-</c:if>
							 </p>
						</div>
						<div class="span3Q">
							<label class="rightQ"><s:text name="label.request.USFees.partialPeriodAmount" />:</label>
						</div>
						<div class="span1Q">
							<p><c:if test="${not empty apmDetails.feeSummaryDetails.USForeignFee.foreignFeeDetails.feeDetails[0].partialPeriodAmount}">
							<s:property  value="apmDetails.feeSummaryDetails.USForeignFee.foreignFeeDetails.feeDetails[0].partialPeriodAmount"/></c:if>
							<c:if test="${empty apmDetails.feeSummaryDetails.USForeignFee.foreignFeeDetails.feeDetails[0].partialPeriodAmount}">-</c:if>
							 </p>
						</div>
					</div>
					<div class="row lastrowQ">
						<div class="span3Q">
							<label class="rightQ"><s:text name="label.amendment" />:</label>
						</div>
						<div class="span1Q">
							<p><c:if test="${not empty apmDetails.feeSummaryDetails.USForeignFee.USFeeDetails.feeDetails[0].amendment}">
							<s:property  value="apmDetails.feeSummaryDetails.USForeignFee.USFeeDetails.feeDetails[0].amendment"/></c:if>
							<c:if test="${empty apmDetails.feeSummaryDetails.USForeignFee.USFeeDetails.feeDetails[0].amendment}">-</c:if>
							 </p>
						</div>
						<div class="span3Q">
							<label class="rightQ"><s:text name="label.amendment" />:</label>
						</div>
						<div class="span1Q">
							<p><c:if test="${not empty apmDetails.feeSummaryDetails.USForeignFee.foreignFeeDetails.feeDetails[0].amendment}">
							<s:property  value="apmDetails.feeSummaryDetails.USForeignFee.foreignFeeDetails.feeDetails[0].amendment"/></c:if>
							<c:if test="${empty apmDetails.feeSummaryDetails.USForeignFee.foreignFeeDetails.feeDetails[0].amendment}">-</c:if>
							 </p>
						</div>
					</div>
				</div>
