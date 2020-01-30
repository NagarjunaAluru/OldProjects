<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>
<c:set var="legSummaryVO" value="${deal:fetchLegSummary(requestScope.legNumber, pageContext.request)}" scope="page"/>

	<h2 class="span12">Dividend Payment Details</h2>
	
	<div class="clear"></div>
	<div class="row highlighted">
		<div class="span5">
			<div class="form-row">
				<b>Currency</b><br>
 			<c:if test="${empty legSummaryVO.originalCurrency}">
				<td>-</td>
			</c:if>
			<c:if test="${not empty legSummaryVO.originalCurrency}"> 
				<td>${legSummaryVO.originalCurrency}</td>
			</c:if>
 
 			</div>
		</div>
		<!-- end of block -->
 		<div class="span5 right ">
			<div class="form-row">
				<b>Amount</b><br>
			<c:if test="${empty legSummaryVO.originalAmount}">
				<td>-</td>
			</c:if>
			<c:if test="${not empty legSummaryVO.originalAmount}"> 
				<td>${legSummaryVO.originalAmount}</td>
			</c:if>
			</div>
		</div>
		<!-- end of block -->

	</div>
	<div class="row">
		<div class="span5 right ">
			<div class="form-row">
				<p>
					<b>USD Equivalent</b><br>
				</p>
				<c:if test="${empty legSummaryVO.usdEquivalent}">
					<td>-</td>
				</c:if>
				<c:if test="${not empty legSummaryVO.usdEquivalent}"> 
					<td>${legSummaryVO.usdEquivalent}</td>
				</c:if>
			</div>
		</div>
		<!-- end of block -->
	</div>
			 <div class="row highlighted">
					<div class="span5 right">
						<div class="form-row">
							<p>
								<b>eBoardroom Eligible</b><br />  ${deal:getEBoardApprovalRequiredFlag(requestScope.legNumber, pageContext.request)}
							</p>
						</div>
					</div>
			</div>
