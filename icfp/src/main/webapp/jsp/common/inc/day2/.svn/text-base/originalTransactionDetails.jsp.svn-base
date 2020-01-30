<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<fmt:setLocale value="en-US"/>

<div class="form-mod">
	<h2 class="span12">Original Transaction Details</h2>
	<div class="clear"></div>
	<div class="row">
		<div class="span5">
			<div class="form-row">
				<label>Product Type</label>
				<div class="radio-container">Equity</div>
			</div>
		</div>
		<div class="span5 right">
			<div class="form-row">
				<label>Trade Id /Loan Model Id</label>
				<html:text name="ICFPLegRequestForm" property="legSummary.transactionId" styleId="tradeIdId" />
			</div>
		</div>
		<!-- end of block -->
	</div>
	<div class="row">
		<div class="span5">

			<div class="form-row">
				<span class="required">*</span>
				<label>Non Standard Legal Agreement(s)</label>
				
				<span id="isNonStandardLegalSAgreementsErrorBar">&nbsp;</span>
				<label class="radio">
					<html:radio name="ICFPLegRequestForm" styleClass="condition" property="legSummary.originalLegalAgreementsFlag" styleId="isNonStandardLegalSAgreementsId"  value="1"/> Yes
				</label>
				<label class="radio">
					<html:radio name="ICFPLegRequestForm" styleClass="condition" property="legSummary.originalLegalAgreementsFlag" styleId="isNonStandardLegalSAgreementsId"  value="0"/> No
				</label>
			</div>
		</div>
		<div class="span5 right">
			<div class="form-row">
				<span class="required">*</span> <label>Currency</label> <input
					type="text" id="dayOneCCY" name="legSummary.dayOneCCY"
					value="<bean:write name="ICFPLegRequestForm" property="legSummary.dayOneCCY"/>"
					class="span2 dayOneCurrency" data-provide="typeahead"
					data-source="<c:out value="${applicationScope['com.ge.icfp.MasterData'].allCurrencies}"/>">
				<span id="dayOneCCYBar" class="req-error" style="display: none;">error</span>
			</div>
		</div>
		<!-- end of block -->
	</div>
	<div class="row">
		<div class="span5 right">
			<div class="form-row">
				<span class="required">*</span> <label>Principal Amount</label> 
				<span  class="help-block invalid error" style="display:none;">Invalid value </span>
				<input type="text" name="legSummary.dayOneCCYAmount" maxlength="20" class="span2 currency" 
					id="dayOneCCYAmount" data-for="dayOneCurrency" data-replace="transactionUsdEquiDiv2" data-whichfacility="transaction"
					value="<fmt:formatNumber  value="${sessionScope.ICFPLegRequestForm.map.legSummary.map.dayOneCCYAmount}" />" />

				<span class="req-error" style="display: none;">error</span>
				<span id="dayOneAmtBar" class="req-error" style="display: none;">error</span>
			</div>
		</div>
		<!-- end of block -->

	</div>

	<div class="row" id="transactionUsdEquiDiv2" style="display: none;">
		<div class="span5 right">
			<div class="form-row">
				<label>USD Equivalent</label>
				
				<html:hidden  name="ICFPLegRequestForm" property="legSummary.dayOneUSDEquivalent" styleId="dayOneUSDEquivalent"/>
						
				<c:if test="${sessionScope.ICFPLegRequestForm.map.legSummary.map.dayOneUSDEquivalent eq ''}">
					<p>-</p>
				</c:if>
				<c:if test="${sessionScope.ICFPLegRequestForm.map.legSummary.map.dayOneUSDEquivalent != ''}">
					<p>${sessionScope.ICFPLegRequestForm.map.legSummary.map.dayOneUSDEquivalent}</p>
				</c:if>
								
			</div>
		</div>
	</div>

</div>

