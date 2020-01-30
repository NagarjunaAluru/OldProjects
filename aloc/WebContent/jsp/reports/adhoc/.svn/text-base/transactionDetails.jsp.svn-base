<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<!-- License Bond Section -->

<s:if test="%{#field.id == 'txd_projDesc'}">
	<s:hidden cssClass="fieldId" name="template.filters[\'%{#field.id}\'].fieldId" value="%{#field.id}"/>
	<s:select name="template.filters[\'%{#field.id}\'].condition" list="#{'OR':'Or', 'AND':'And'}" cssClass="condition left"/>
	<div class="fieldName"><s:property value="%{#field.name}"/></div>
	<s:select list="%{#field.operators}" listKey="value()" listValue="value()" name="template.filters[\'%{#field.id}\'].operator"/>
	<s:textfield name="template.filters[\'%{#field.id}\'].value[0]"></s:textfield>
</s:if>

<s:if test="%{#field.id == 'txd_issuanceCountry'}">
	<s:hidden cssClass="fieldId" name="template.filters[\'%{#field.id}\'].fieldId" value="%{#field.id}"/>
	<s:select name="template.filters[\'%{#field.id}\'].condition" list="#{'OR':'Or', 'AND':'And'}" cssClass="condition left"/>
	<div class="fieldName"><s:property value="%{#field.name}"/></div>
	<s:select list="%{#field.operators}" listKey="value()" listValue="value()" name="template.filters[\'%{#field.id}\'].operator"/>
	<sj:autocompleter list="%{#attr['com.ge.aloc.MasterDataFactory'].countries}" 
		name="template.filters[\'%{#field.id}\'].value[0]" listKey="countryName" listValue="countryName" />
</s:if>

<s:if test="%{#field.id == 'txd_contractAmt'}">
	<div class="firstOperand left" style="width: 385px;">
		<s:hidden cssClass="fieldId" name="template.filters[\'%{#field.id}\'].fieldId" value="%{#field.id}"/>
		<s:select name="template.filters[\'%{#field.id}\'].condition" list="#{'OR':'Or', 'AND':'And'}" cssClass="condition left"/>
		<div class="fieldName"><s:property value="%{#field.name}"/></div>
		<s:select list="%{#field.operators}" listKey="value()" listValue="value()" name="template.filters[\'%{#field.id}\'].operator" cssClass="operator"/>
		<s:textfield name="template.filters[\'%{#field.id}\'].value[0]" cssClass="inBetween"></s:textfield>
	</div>
	<div class="secondOperand left hide" style="width: 125px;">
		&nbsp;and&nbsp;
		<s:textfield name="template.filters[\'%{#field.id}\'].value[1]" cssClass="inBetween"></s:textfield>
	</div>
</s:if>

<s:if test="%{#field.id == 'txd_contractCur'}">
	<s:hidden cssClass="fieldId" name="template.filters[\'%{#field.id}\'].fieldId" value="%{#field.id}"/>
	<s:select name="template.filters[\'%{#field.id}\'].condition" list="#{'OR':'Or', 'AND':'And'}" cssClass="condition left"/>
	<div class="fieldName"><s:property value="%{#field.name}"/></div>
	<s:select list="%{#field.operators}" listKey="value()" listValue="value()" name="template.filters[\'%{#field.id}\'].operator"/>
	<sj:autocompleter list="%{#attr['com.ge.aloc.StaticDataFactory'].reportCurrency}" 
		name="template.filters[\'%{#field.id}\'].value[0]" listKey="currencyName" listValue="currencyName" />
</s:if>

<s:if test="%{#field.id == 'txd_docLCCur'}">
	<s:hidden cssClass="fieldId" name="template.filters[\'%{#field.id}\'].fieldId" value="%{#field.id}"/>
	<s:select name="template.filters[\'%{#field.id}\'].condition" list="#{'OR':'Or', 'AND':'And'}" cssClass="condition left"/>
	<div class="fieldName"><s:property value="%{#field.name}"/></div>
	<s:select list="%{#field.operators}" listKey="value()" listValue="value()" name="template.filters[\'%{#field.id}\'].operator"/>
	<sj:autocompleter list="%{#attr['com.ge.aloc.StaticDataFactory'].reportCurrency}" 
		name="template.filters[\'%{#field.id}\'].value[0]" listKey="currencyName" listValue="currencyName" />
</s:if>

<s:if test="%{#field.id == 'txd_docLCAmt'}">
	<div class="firstOperand left" style="width: 385px;">
		<s:hidden cssClass="fieldId" name="template.filters[\'%{#field.id}\'].fieldId" value="%{#field.id}"/>
		<s:select name="template.filters[\'%{#field.id}\'].condition" list="#{'OR':'Or', 'AND':'And'}" cssClass="condition left"/>
		<div class="fieldName"><s:property value="%{#field.name}"/></div>
		<s:select list="%{#field.operators}" listKey="value()" listValue="value()" name="template.filters[\'%{#field.id}\'].operator" cssClass="operator"/>
		<s:textfield name="template.filters[\'%{#field.id}\'].value[0]" cssClass="inBetween"></s:textfield>
	</div>
	<div class="secondOperand left hide" style="width: 125px;">
		&nbsp;and&nbsp;
		<s:textfield name="template.filters[\'%{#field.id}\'].value[1]" cssClass="inBetween"></s:textfield>
	</div>
</s:if>

<s:if test="%{#field.id == 'txd_shipmentOrigin'}">
	<s:hidden cssClass="fieldId" name="template.filters[\'%{#field.id}\'].fieldId" value="%{#field.id}"/>
	<s:select name="template.filters[\'%{#field.id}\'].condition" list="#{'OR':'Or', 'AND':'And'}" cssClass="condition left"/>
	<div class="fieldName"><s:property value="%{#field.name}"/></div>
	<s:select list="%{#field.operators}" listKey="value()" listValue="value()" name="template.filters[\'%{#field.id}\'].operator"/>
	<sj:autocompleter list="%{#attr['com.ge.aloc.MasterDataFactory'].countries}" 
		name="template.filters[\'%{#field.id}\'].value[0]" listKey="countryName" listValue="countryName" />
</s:if>

<%-- <s:if test="%{#field.id == 'txd_shipmentOrigin1'}">
	<s:hidden cssClass="fieldId" name="template.filters[\'%{#field.id}\'].fieldId" value="%{#field.id}"/>
	<s:select name="template.filters[\'%{#field.id}\'].condition" list="#{'OR':'Or', 'AND':'And'}" />
	<s:property value="%{#field.name}"/>
	<s:select name="template.filters[\'%{#field.id}\'].operator" list="%{#field.operators}" listKey="value()" listValue="value()" />
	<s:textfield name="template.filters[\'%{#field.id}\'].value[0]" ></s:textfield>
</s:if>

<s:if test="%{#field.id == 'txd_shipmentOrigin2'}">
	<s:hidden cssClass="fieldId" name="template.filters[\'%{#field.id}\'].fieldId" value="%{#field.id}"/>
	<s:select name="template.filters[\'%{#field.id}\'].condition" list="#{'OR':'Or', 'AND':'And'}" />
	<s:property value="%{#field.name}"/>
	<s:select name="template.filters[\'%{#field.id}\'].operator" list="%{#field.operators}" listKey="value()" listValue="value()" />
	<s:textfield name="template.filters[\'%{#field.id}\'].value[0]" ></s:textfield>
</s:if>
 --%>
<s:if test="%{#field.id == 'txd_shipmentDestCountry'}">
	<s:hidden cssClass="fieldId" name="template.filters[\'%{#field.id}\'].fieldId" value="%{#field.id}"/>
	<s:select name="template.filters[\'%{#field.id}\'].condition" list="#{'OR':'Or', 'AND':'And'}" cssClass="condition left"/>
	<div class="fieldName"><s:property value="%{#field.name}"/></div>
	<s:select list="%{#field.operators}" listKey="value()" listValue="value()" name="template.filters[\'%{#field.id}\'].operator"/>
	<sj:autocompleter list="%{#attr['com.ge.aloc.MasterDataFactory'].countries}" 
		name="template.filters[\'%{#field.id}\'].value[0]" listKey="countryName" listValue="countryName" />
</s:if>

<s:if test="%{#field.id == 'txd_goodsOrigin'}">
	<s:hidden cssClass="fieldId" name="template.filters[\'%{#field.id}\'].fieldId" value="%{#field.id}"/>
	<s:select name="template.filters[\'%{#field.id}\'].condition" list="#{'OR':'Or', 'AND':'And'}" cssClass="condition left"/>
	<div class="fieldName"><s:property value="%{#field.name}"/></div>
	<s:select list="%{#field.operators}" listKey="value()" listValue="value()" name="template.filters[\'%{#field.id}\'].operator"/>
	<sj:autocompleter list="%{#attr['com.ge.aloc.MasterDataFactory'].countries}" 
		name="template.filters[\'%{#field.id}\'].value[0]" listKey="countryName" listValue="countryName" />
</s:if>

<%-- <s:if test="%{#field.id == 'txd_goodsOrigin1'}">
	<s:hidden cssClass="fieldId" name="template.filters[\'%{#field.id}\'].fieldId" value="%{#field.id}"/>
	<s:select name="template.filters[\'%{#field.id}\'].condition" list="#{'OR':'Or', 'AND':'And'}" />
	<s:property value="%{#field.name}"/>
	<s:select name="template.filters[\'%{#field.id}\'].operator" list="%{#field.operators}" listKey="value()" listValue="value()" />
	<s:textfield name="template.filters[\'%{#field.id}\'].value[0]" ></s:textfield>
</s:if>

<s:if test="%{#field.id == 'txd_goodsOrigin2'}">
	<s:hidden cssClass="fieldId" name="template.filters[\'%{#field.id}\'].fieldId" value="%{#field.id}"/>
	<s:select name="template.filters[\'%{#field.id}\'].condition" list="#{'OR':'Or', 'AND':'And'}" />
	<s:property value="%{#field.name}"/>
	<s:select name="template.filters[\'%{#field.id}\'].operator" list="%{#field.operators}" listKey="value()" listValue="value()" />
	<s:textfield name="template.filters[\'%{#field.id}\'].value[0]" ></s:textfield>
</s:if> --%>

<s:if test="%{#field.id == 'txd_USContentPercent'}">
	<s:hidden cssClass="fieldId" name="template.filters[\'%{#field.id}\'].fieldId" value="%{#field.id}"/>
	<s:select name="template.filters[\'%{#field.id}\'].condition" list="#{'OR':'Or', 'AND':'And'}" cssClass="condition left"/>
	<div class="fieldName"><s:property value="%{#field.name}"/></div>
	<s:select list="%{#field.operators}" listKey="value()" listValue="value()" name="template.filters[\'%{#field.id}\'].operator"/>
	<s:textfield name="template.filters[\'%{#field.id}\'].value[0]"></s:textfield>
</s:if>

<s:if test="%{#field.id == 'txd_LCPaymentTerm'}">
	<s:hidden cssClass="fieldId" name="template.filters[\'%{#field.id}\'].fieldId" value="%{#field.id}"/>
	<s:select name="template.filters[\'%{#field.id}\'].condition" list="#{'OR':'Or', 'AND':'And'}" cssClass="condition left"/>
	<div class="fieldName"><s:property value="%{#field.name}"/></div>
	<s:select list="%{#field.operators}" listKey="value()" listValue="value()" name="template.filters[\'%{#field.id}\'].operator"/>
	<s:select list="%{#attr['com.ge.aloc.StaticDataFactory'].lCPaymentTerms}" 
		name="template.filters[\'%{#field.id}\'].value[0]" listKey="name"
		listValue="name"/>
</s:if>

<s:if test="%{#field.id == 'txd_othPaymentDesc'}">
	<s:hidden cssClass="fieldId" name="template.filters[\'%{#field.id}\'].fieldId" value="%{#field.id}"/>
	<s:select name="template.filters[\'%{#field.id}\'].condition" list="#{'OR':'Or', 'AND':'And'}" cssClass="condition left"/>
	<div class="fieldName"><s:property value="%{#field.name}"/></div>
	<s:select list="%{#field.operators}" listKey="value()" listValue="value()" name="template.filters[\'%{#field.id}\'].operator"/>
	<s:textfield name="template.filters[\'%{#field.id}\'].value[0]"></s:textfield>
</s:if>

<s:if test="%{#field.id == 'txd_confirmationType'}">
	<s:hidden cssClass="fieldId" name="template.filters[\'%{#field.id}\'].fieldId" value="%{#field.id}"/>
	<s:select name="template.filters[\'%{#field.id}\'].condition" list="#{'OR':'Or', 'AND':'And'}" cssClass="condition left"/>
	<div class="fieldName"><s:property value="%{#field.name}"/></div>
	<s:select list="%{#field.operators}" listKey="value()" listValue="value()" name="template.filters[\'%{#field.id}\'].operator"/>
	<s:select list="#{'Open':'Open','Silent':'Silent'}" name="template.filters[\'%{#field.id}\'].value[0]"></s:select>
</s:if>

<s:if test="%{#field.id == 'txd_bankCharges'}">
	<s:hidden cssClass="fieldId" name="template.filters[\'%{#field.id}\'].fieldId" value="%{#field.id}"/>
	<s:select name="template.filters[\'%{#field.id}\'].condition" list="#{'OR':'Or', 'AND':'And'}" cssClass="condition left"/>
	<div class="fieldName"><s:property value="%{#field.name}"/></div>
	<s:select list="%{#field.operators}" listKey="value()" listValue="value()" name="template.filters[\'%{#field.id}\'].operator"/>
	<s:select list="%{#attr['com.ge.aloc.StaticDataFactory'].bankCharges}" 
		name="template.filters[\'%{#field.id}\'].value[0]" listKey="name" listValue="name"/>
</s:if>