<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<script src="${pageContext.request.contextPath}/js/others/jquery-zdate.js" type="text/javascript"></script>

<s:if test="%{#parameters.fieldId != null}">
	<s:set var="field" value="%{getField(#parameters.fieldId)}"  />
</s:if>
<s:else>
	<c:if test="${not empty param.fieldId}">
		<s:set name="fieldId">${param.fieldId}</s:set>
	</c:if> 
	<s:set var="field" value="%{getField(#fieldId)}"  />
</s:else>

<div class="left" style="width: 80%;">
<input type="hidden" name="template.filterIds" value="${param.fieldId}">
<input type="hidden" value="<s:property value="#field.name"/>" class="fieldName">
<s:if test="%{#field.sectionId == 'common'}">
	<s:include value="/jsp/reports/adhoc/commonField.jsp" />
</s:if>
<s:elseif test="%{#field.sectionId == 'tp'}">
	<s:include value="/jsp/reports/adhoc/transactionParties.jsp" />
</s:elseif>
<s:elseif test="%{#field.sectionId == 'pd'}">
	<s:include value="/jsp/reports/adhoc/projectDescription.jsp" />
</s:elseif>
<s:elseif test="%{#field.sectionId == 'id'}">
	<s:include value="/jsp/reports/adhoc/instrumentDetails.jsp" />
</s:elseif>
<s:elseif test="%{#field.sectionId == 'ir'}">
	<s:include value="/jsp/reports/adhoc/instrumentRisk.jsp" />
</s:elseif>
<s:elseif test="%{#field.sectionId == 'ira'}">
	<s:include value="/jsp/reports/adhoc/instrumentReportingAttributes.jsp" />
</s:elseif>
<s:elseif test="%{#field.sectionId == 'di'}">
	<s:include value="/jsp/reports/adhoc/deliveryInstructions.jsp" />
</s:elseif>
<s:elseif test="%{#field.sectionId == 'slcc'}">
	<s:include value="/jsp/reports/adhoc/standbyLetterOfCreditConditions.jsp" />
</s:elseif>
<s:elseif test="%{#field.sectionId == 'bt'}">
	<s:include value="/jsp/reports/adhoc/bondType.jsp" />
</s:elseif>
<s:elseif test="%{#field.sectionId == 'principal'}">
	<s:include value="/jsp/reports/adhoc/principal.jsp" />
</s:elseif>
<s:elseif test="%{#field.sectionId == 'obl'}">
	<s:include value="/jsp/reports/adhoc/obligee.jsp" />
</s:elseif>
<s:elseif test="%{#field.sectionId == 'br'}">
	<s:include value="/jsp/reports/adhoc/bondRequestor.jsp" />
</s:elseif>
<s:elseif test="%{#field.sectionId == 'rma'}">
	<s:include value="/jsp/reports/adhoc/requestorMailingAddress.jsp" />
</s:elseif>
<s:elseif test="%{#field.sectionId == 'bi'}">
	<s:include value="/jsp/reports/adhoc/bondInformation.jsp" />
</s:elseif>
<s:elseif test="%{#field.sectionId == 'cbd'}">
	<s:include value="/jsp/reports/adhoc/courtBondDetails.jsp" />
</s:elseif>
<s:elseif test="%{#field.sectionId == 'ai'}">
	<s:include value="/jsp/reports/adhoc/attorneyInformation.jsp" />
</s:elseif>
<s:elseif test="%{#field.sectionId == 'bb'}">
	<s:include value="/jsp/reports/adhoc/bidBond.jsp" />
</s:elseif>
<s:elseif test="%{#field.sectionId == 'cb'}">
	<s:include value="/jsp/reports/adhoc/contractBond.jsp" />
</s:elseif>
<s:elseif test="%{#field.sectionId == 'cstmb'}">
	<s:include value="/jsp/reports/adhoc/customBond.jsp" />
</s:elseif>
<s:elseif test="%{#field.sectionId == 'lb'}">
	<s:include value="/jsp/reports/adhoc/licenseBond.jsp" />
</s:elseif>
<s:elseif test="%{#field.sectionId == 'bcp'}">
	<s:include value="/jsp/reports/adhoc/bussinessContactPerson.jsp" />
</s:elseif>
<s:elseif test="%{#field.sectionId == 'ib'}">
	<s:include value="/jsp/reports/adhoc/issuingBank.jsp" />
</s:elseif>
<s:elseif test="%{#field.sectionId == 'dlocAppl'}">
	<s:include value="/jsp/reports/adhoc/applicantDLOC.jsp" />
</s:elseif>
<s:elseif test="%{#field.sectionId == 'dlocCust'}">
	<s:include value="/jsp/reports/adhoc/customerBeneficiaryDLOC.jsp" />
</s:elseif>
<s:elseif test="%{#field.sectionId == 'txd'}">
	<s:include value="/jsp/reports/adhoc/transactionDetails.jsp" />
</s:elseif>
<s:elseif test="%{#field.sectionId == 'ps'}">
	<s:include value="/jsp/reports/adhoc/paymentSchedule.jsp" />
</s:elseif>
<s:elseif test="%{#field.sectionId == 'dlocbm'}">
	<s:include value="/jsp/reports/adhoc/dloccBidMemoDetails.jsp" />
</s:elseif>
<s:elseif test="%{#field.sectionId == 'du'}">
	<s:include value="/jsp/reports/adhoc/documentationUpload.jsp" />
</s:elseif>
<s:elseif test="%{#field.sectionId == 'ipic'}">
	<s:include value="/jsp/reports/adhoc/indicativePricingInformationCompletedBy.jsp" />
</s:elseif>
<s:elseif test="%{#field.sectionId == 'cf'}">
	<s:include value="/jsp/reports/adhoc/confirmationFees.jsp" />
</s:elseif>
<s:elseif test="%{#field.sectionId == 'aed'}">
	<s:include value="/jsp/reports/adhoc/amendmentExpirationDates.jsp" />
</s:elseif>
<s:elseif test="%{#field.sectionId == 'aoc'}">
	<s:include value="/jsp/reports/adhoc/amendmentOtherChanges.jsp" />
</s:elseif>
<s:elseif test="%{#field.sectionId == 'rd'}">
	<s:include value="/jsp/reports/adhoc/riderBondInformation.jsp" />
</s:elseif>
<s:elseif test="%{#field.sectionId == 'red'}">
	<s:include value="/jsp/reports/adhoc/riderExpirationDates.jsp" />
</s:elseif>
<s:elseif test="%{#field.sectionId == 'iac'}">
	<s:include value="/jsp/reports/adhoc/instrumentAmountCurrency.jsp" />
</s:elseif>
<s:elseif test="%{#field.sectionId == 'bndl'}">
	<s:include value="/jsp/reports/adhoc/bundle.jsp" />
</s:elseif>
<s:elseif test="%{#field.sectionId == 'lnk'}">
	<s:include value="/jsp/reports/adhoc/link.jsp" />
</s:elseif>
<s:elseif test="%{#field.sectionId == 'apm'}">
	<s:include value="/jsp/reports/adhoc/apmFees.jsp" />
</s:elseif>
</div>
<div class="right" style="width: 20%;">
	<a href="javascript:;" class="addAsColumn">Add as column</a>
	<span class="ttip infoFilter" data-original-title="AAA"></span>
	<a href="javascript:;" class="deleteFilters" id="<s:property value="#field.id"/>">
	<img alt="delete" src="${pageContext.request.contextPath}/img/delete.gif" style="margin-top: 5px; margin-left: 5px;"></a>
</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/reports/filterController.js"></script>
