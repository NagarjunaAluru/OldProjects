<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<fmt:setLocale value="en-US"/>
<div class="form-mod">
	<h2 class="span12">Dividend Payment Details</h2>
	<div class="row">
		<div class="span5">
			<div class="form-row">
				<span class="required">*</span>
				<label>Currency</label>
				<span  class="help-block error" id="originalCCYValidate" style="display:none;">Please select Deal currency </span>
				<span  class="help-block error" id="originalCCYInvalid" style="display:none;">Invalid Deal currency </span>							
				<input type="text" id="originalCCY" name="legSummary.originalCCY" value="<bean:write name="ICFPLegRequestForm" property="legSummary.originalCCY"/>"
				class="span2 amount" data-provide="typeahead" 
				data-source="<c:out value="${applicationScope['com.ge.icfp.MasterData'].allCurrencies}"/>" >
				<span id="originalCCYValidateBar" class="req-error" style="display:none;">error</span>
			</div>
		</div>
		<!-- end of block -->
		<div class="span5 right ">
			<div class="form-row">
				<span class="required">*</span>
				<label>Amount</label>
				<span  class="help-block invalid error" style="display:none;">Invalid value </span>
				<input type="text"  name="legSummary.originalCCYAmount" id="dividendAmountId"
					maxlength="30" class="span2 currency" data-for="amount"
					value="<fmt:formatNumber  value="${sessionScope.ICFPLegRequestForm.map.legSummary.map.originalCCYAmount}" />"/>
					
					<span class="req-error" style="display:none;">error</span>  
					<span id="dividendAmountErrorBar" class="req-error" style="display:none;">error</span>  
			</div>
		</div>
		<!-- end of block -->

	</div>
	<div class="row">
		<div class="span5 right " id="usdEquiDiv">
			<div class="form-row">
				<p><b>USD equivalent</b></p>
				<html:hidden  name="ICFPLegRequestForm" property="legSummary.USDEquivalent" styleId="USDEquivalent"/>
				<span id="usdValidateBar" class="req-error" style="display:none;">error</span>
				<c:if test="${sessionScope.ICFPLegRequestForm.map.legSummary.map.USDEquivalent eq '0.00'}">
				   <p>-</p>
				</c:if>
				<c:if test="${sessionScope.ICFPLegRequestForm.map.legSummary.map.USDEquivalent != '0.00'}">
					<p>${sessionScope.ICFPLegRequestForm.map.legSummary.map.USDEquivalent}</p>
				</c:if>
			</div>
		</div>
		<!-- end of block -->
	</div>
	<div class="row">
		<div id="eBoardEligibleDiv" class="span5 right">
			<div class="form-row">
				<p><b>eBoardroom eligible</b></p>
				<c:if test="${sessionScope.ICFPLegRequestForm.map.eBoardApprovalRequiredFlag == null}"> 
					<p>-</p>
				</c:if>
				<c:if test="${sessionScope.ICFPLegRequestForm.map.eBoardApprovalRequiredFlag != null && sessionScope.ICFPLegRequestForm.map.eBoardApprovalRequiredFlag eq false}">
					<p>No</p>
				</c:if>
				<c:if test="${sessionScope.ICFPLegRequestForm.map.eBoardApprovalRequiredFlag != null && sessionScope.ICFPLegRequestForm.map.eBoardApprovalRequiredFlag eq true}"> 
					<p>Yes</p>
				</c:if>
			</div>
		</div><!-- end of block -->
	</div>
	<html:hidden  name="ICFPLegRequestForm" property="legSummary.legTypeId" styleId="productType"/>
</div>
