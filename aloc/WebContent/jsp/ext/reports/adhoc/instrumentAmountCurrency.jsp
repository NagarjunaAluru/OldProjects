<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<!-- License Bond Section -->

<s:if test="%{#field.id == 'iac_operation'}">
	<s:hidden cssClass="fieldId" name="template.filters[\'%{#field.id}\'].fieldId" value="%{#field.id}"/>
	<s:select name="template.filters[\'%{#field.id}\'].condition" list="#{'OR':'Or', 'AND':'And'}" cssClass="condition left"/>
	<div class="fieldName"><s:property value="%{#field.name}"/></div>
	<s:select list="%{#field.operators}" listKey="value()" listValue="value()" name="template.filters[\'%{#field.id}\'].operator"/>
	<s:select name="template.filters[\'%{#field.id}\'].value[0]" list="#{'INCREASE':'Increase','DECREASE':'Decrease'}"/>
</s:if>

<s:if test="%{#field.id == 'iac_revisedUsdAmt'}">
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

<s:if test="%{#field.id == 'iac_revisedUSDEquiAmt'}">
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

<%-- <s:if test="%{#field.id == 'iac_newInstrumentCurrCode'}">
	<s:hidden cssClass="fieldId" name="template.filters[\'%{#field.id}\'].fieldId" value="%{#field.id}"/>
	<s:select name="template.filters[\'%{#field.id}\'].condition" list="#{'OR':'Or', 'AND':'And'}" />
	<s:property value="%{#field.name}"/>
	<s:select name="template.filters[\'%{#field.id}\'].operator" list="%{#field.operators}" listKey="value()" listValue="value()" />
	<s:textfield name="template.filters[\'%{#field.id}\'].value[0]" ></s:textfield>
</s:if> --%>

<s:if test="%{#field.id == 'iac_newInstrumentCurr'}">
	<s:hidden cssClass="fieldId" name="template.filters[\'%{#field.id}\'].fieldId" value="%{#field.id}"/>
	<s:select name="template.filters[\'%{#field.id}\'].condition" list="#{'OR':'Or', 'AND':'And'}" cssClass="condition left"/>
	<div class="fieldName"><s:property value="%{#field.name}"/></div>
	<s:select list="%{#field.operators}" listKey="value()" listValue="value()" name="template.filters[\'%{#field.id}\'].operator"/>
	<sj:autocompleter list="%{#attr['com.ge.aloc.MasterDataFactory'].currencies}" 
		name="template.filters[\'%{#field.id}\'].value[0]" listKey="currencyName" listValue="currencyName" />
</s:if>

<s:if test="%{#field.id == 'iac_origInstAmt'}">
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
<s:if test="%{#field.id == 'iac_amountIncreaseDecrease'}">
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
<s:if test="%{#field.id == 'iac_revisedAmt'}">
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
<s:if test="%{#field.id == 'iac_revisedInstrumentAmt'}">
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
<s:if test="%{#field.id == 'iac_newInstAmt'}">
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
<s:if test="%{#field.id == 'iac_currentInstrumentAmount'}">
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