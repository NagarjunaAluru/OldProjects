<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>
<c:set var="legSummaryVO" value="${deal:fetchLegSummary(param.id, pageContext.request)}" scope="page"/>

<h2 class="span12">Original Transaction Details</h2>
<div class="clear"></div>
<div class="row">
	<div class="span5">
		<div class="form-row">
			<label>Product Type</label>
			<div class="radio-container">Equity</div>
		</div>
	</div>
	<!-- end of block -->
	<div class="span5 right ">
		<div class="form-row">
			<p>
				<b>Trade Id /Loan Model Id</b>
			</p>
			<p>
			<c:if test="${empty legSummaryVO.transactionId}">
				<td>-</td>
			</c:if>
			<c:if test="${not empty legSummaryVO.transactionId}"> 
				<td>${legSummaryVO.transactionId}</td>
			</c:if>
			
		</div>
	</div>
	<!-- end of block -->
</div>

<div class="row">
	<div class="span5">

		<div class="form-row">
			<p>
				<b>Non Standard Legal Agreement(s)</b>
			</p>
			<c:if test="${empty legSummaryVO.originalLegalAgreementsFlag}">
				<td>-</td>
			</c:if>
			<c:if test="${not empty legSummaryVO.originalLegalAgreementsFlag}">
				<c:if test="${legSummaryVO.originalLegalAgreementsFlag eq 1}">Yes</c:if>
				<c:if test="${legSummaryVO.originalLegalAgreementsFlag eq 0}">No</c:if>
				<c:if test="${legSummaryVO.originalLegalAgreementsFlag eq 2}">N/A</c:if>
			</c:if>
		</div>
	</div>

	<div class="span5 right">
		<div class="form-row">
			<label>Currency</label>
			<c:if test="${empty legSummaryVO.dayOneCCY}">
				<td>-</td>
			</c:if>
			<c:if test="${not empty legSummaryVO.dayOneCCY}">
				${legSummaryVO.dayOneCCY}
			</c:if>
		</div>
	</div>
</div>

<div class="row">
	<div class="span5 right">
		<div class="form-row">
			<label>Principal Amount</label>
			<c:if test="${empty legSummaryVO.dayOneCCYAmount}">
				<td>-</td>
			</c:if>
			<c:if test="${not empty legSummaryVO.dayOneCCYAmount}">
				<fmt:formatNumber value="${legSummaryVO.dayOneCCYAmount}" />
			</c:if>
		</div>
	</div>
	<!-- end of block -->

</div>

<div class="row" id="transactionUsdEquiDiv">
	<div class="span5 right">
		<div class="form-row">
			<label>USD Equivalent</label>
			<c:if test="${empty legSummaryVO.dayOneUSD}">
				<td>-</td>
			</c:if>
			<c:if test="${not empty legSummaryVO.dayOneUSD}">
				<fmt:formatNumber value="${legSummaryVO.dayOneUSD}" />
			</c:if> 
		</div>
	</div>
	<!-- end of block -->
</div>


 