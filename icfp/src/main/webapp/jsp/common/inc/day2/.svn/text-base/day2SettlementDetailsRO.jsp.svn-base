<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>
<c:set var="legSummaryVO" value="${deal:fetchLegSummary(requestScope.legNumber, pageContext.request)}" scope="page"/>

<div class="form-mod">
	<h2>Settlement Details</h2>
        <div class="clear"></div>
			
		<div class="row highlighted">
			<div class="span5">
					<label>Gross Settlement amount</label>
						<c:if test="${empty legSummaryVO.grossSettlementAmt}">-</c:if>
						<c:if test="${not empty legSummaryVO.grossSettlementAmt}"><fmt:formatNumber value="${legSummaryVO.grossSettlementAmt}" /></c:if>
			</div> <!-- end of block -->
		</div>
		<div class="row">
			<div class="span5">
				<label>Payer</label>
				<c:if test="${empty legSummaryVO.borrowerLegalEntity}">-</c:if>
				<c:if test="${not empty legSummaryVO.borrowerLegalEntity}">${legSummaryVO.borrowerLegalEntity}</c:if>
			</div>
		</div>
		<div class="row highlighted">
			<div class="span5">
				<label>Legal entity setup pending</label>
				<c:if test="${empty legSummaryVO.borrowerLegalEntity}">Yes</c:if>
				<c:if test="${not empty legSummaryVO.borrowerLegalEntity}">No</c:if>
			</div>
		</div>
</div>
