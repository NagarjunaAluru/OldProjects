<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>
<c:set var="rateInfo" value="${deal:getInterest(param.id, pageContext.request)}" />
<div class="form-mod">
<h2 class="span12 collapsible">Terms and Conditions</h2>
	<div class="clear"></div>
	<div class="row highlighted">
		<div class="span5">
			<div class="form-row">
				<p><b>Currency</b><br/>
					${not empty legSummaryVO.originalAmount ? legSummaryVO.originalAmount : '-'}
			</div>
		</div><!-- end of block -->
		<div class="span5 right">
			<div class="form-row">
				<p><b>Principal amount</b><br />
					${not empty legSummaryVO.usdEquivalent ? legSummaryVO.usdEquivalent : '-'}
			</div>
		</div>
	</div> 

	<div class="row">
		<div class="span5">
			<div class="form-row">
				<p><b>Immediate Drawdown Applicable</b><br/>
					${not empty deal:getImmediateDrawdown(param.id, pageContext.request) ? deal:getImmediateDrawdown(param.id, pageContext.request) : '-'}
			</div>
		</div>
		<div class="span5 right">
			<div class="form-row">
				<p><b>Interest Type</b><br />
					<c:if test="${rateInfo.interestTypeId eq 1}">
						Fixed
					</c:if>
					<c:if test="${rateInfo.interestTypeId eq 2}">
						Float
					</c:if>
					<c:if test="${rateInfo.interestTypeId ne 2 and rateInfo.interestTypeId ne 1}">
						-
					</c:if>
			</div>
		</div>
	</div>
	<c:if test="${deal:getImmediateDrawdown(param.id, pageContext.request) eq 'Yes'}">
	<div class="row highlighted">
		<div class="span5">
			<div class="form-row">
				<p><b>Immediate drawdown Amount</b><br/>
					${not empty deal:getImmediateDrawdownAmount(param.id, pageContext.request) ? deal:getImmediateDrawdownAmount(param.id, pageContext.request) : '-'}
			</div>
		</div><!-- end of block -->
		<div class="span5 right">
			<div class="form-row">
				<p><b>Immediate Drawdown Value Date</b><br />
					${not empty deal:getImmediateDrawdownValDt(param.id, pageContext.request) ? deal:getImmediateDrawdownValDt(param.id, pageContext.request) : '-'}
			</div>
		</div>
	</div> 
	</c:if>
</div>
<c:if test="${rateInfo.interestTypeId eq 1}">
<div class="form-mod">
	<h3 class="span12">Fixed</h3>
	<div class="row">
		<div class="span5 ">
			<div class="form-row">
				<p><b>Base fixed rate %</b><br/>
				${not empty rateInfo.baseFixedRate ? rateInfo.baseFixedRate : '-'}
			</div>
		</div> 
		<div class="span5 right">
			<div class="form-row">
				<p><b>Spread (bps)</b><br/>
				${not empty rateInfo.spread ? rateInfo.spread : '-'}
			</div>
		</div> 
	</div>
</div>
</c:if>
<c:if test="${rateInfo.interestTypeId eq 2}">
<div class="form-mod">
	<h3 class="span12">Float</h3>
	<div class="row">
		<div class="span5 ">
			<div class="form-row">
				<p><b>Float Rate Index</b><br/>
				${not empty rateInfo.floatingRateIndex ? rateInfo.floatingRateIndex : '-'}
			</div>
		</div> 
		<div class="span5 right">
			<div class="form-row">
				<p><b>Spread (bps)</b><br/>
				${not empty rateInfo.spread ? rateInfo.spread : '-'}
			</div>
		</div> 
	</div>
	<div class="row">
		<div class="span5 ">
			<div class="form-row">
				<p><b>Float Rate Index term</b><br/>
				${not empty rateInfo.floatingRateIndexTerm ? rateInfo.floatingRateIndexTerm : '-'}
			</div>
		</div> 
	</div>
</div>
</c:if>
<div class="form-mod">
	<h3 class="span12">Fees and Withholding</h3>
	<div class="row">
	<c:if test="${not empty legSummaryVO.productType and legSummaryVO.productType eq 'RCA'}">
		<div class="span5">
			<div class="form-row">
				<p><b>Commitment fee applicable</b><br/>
				${not empty deal:getCommitmentFee(param.id, pageContext.request) ? deal:getCommitmentFee(param.id, pageContext.request) : '-'}
			</div>
		</div>
	</c:if>
		<div class="span5 right">
			<div class="form-row">
				<p><b>Withholding tax applicable</b><br/>
				${not empty deal:getWithholdingTax(param.id, pageContext.request) ? deal:getWithholdingTax(param.id, pageContext.request) : '-'}
			</div>
		</div>
	</div>
	<div class="row highlighted">
		<div class="span5">
			<div class="form-row">
				<p><b>Guarantee fee applicable</b><br/>
				${not empty deal:getGuaranteeFee(param.id, pageContext.request) ? deal:getGuaranteeFee(param.id, pageContext.request) : '-'}
			</div>
		</div>
	</div>
</div>


<c:if test="${deal:getGuaranteeFee(param.id, pageContext.request) eq 'Yes'}">

<div class="form-mod">
	<h3 class="span12"><bean:message key="label.addLeg.guarantorInfo" /></h3>
	<div class="row">
		<div class="span5">
			<div class="form-row">
				<p><b><bean:message key="label.addLeg.guarantorLegalEntityCDRCode" /></b><br/>
				${not empty legSummaryVO.guarantorCDR ? legSummaryVO.guarantorCDR : '-'}
			</div>
		</div>
		<div class="span5 right">
			<div class="form-row">
				<p><b><bean:message key="label.addLeg.legalEntityName" /></b><br/>
				${not empty legSummaryVO.guarantorLEName ? legSummaryVO.guarantorLEName : '-'}
			</div>
		</div>
	</div>
	<div class="row highlighted">
		<div class="span5">
			<div class="form-row">
				<p><b><bean:message key="label.addLeg.guarantorGoldId" /></b><br/>
				${not empty legSummaryVO.guarantorLEGoldId ? legSummaryVO.guarantorLEGoldId : '-'}
			</div>
		</div>
		<div class="span5 right">
			<div class="form-row">
				<p><b><bean:message key="label.addLeg.managementEntity" /></b><br/>
				${not empty legSummaryVO.guarantorME ? legSummaryVO.guarantorME : '-'}
			</div>
		</div>
	</div>
	<div class="row">
		<div class="span5">
			<div class="form-row">
				<p><b><bean:message key="label.addLeg.guarantorPrincipalEntity" /></b><br/>
				${not empty legSummaryVO.guarantorPrincipalEntity ? legSummaryVO.guarantorPrincipalEntity : '-'}
			</div>
		</div>
		<div class="span5 right">
			<div class="form-row">
				<p><b><bean:message key="label.addLeg.guarantorregulatedEntity" /></b><br/>
				${not empty legSummaryVO.guarantorRegulatedEntity ? legSummaryVO.guarantorRegulatedEntity : '-'}
			</div>
		</div>
	</div>
	<div class="row highlighted">
		<div class="span5">
			<div class="form-row">
				<p><b><bean:message key="label.addLeg.country" /></b><br/>
				${not empty legSummaryVO.guarantorCountry ? legSummaryVO.guarantorCountry : '-'}
			</div>
		</div>
	</div>
</div>

</c:if>