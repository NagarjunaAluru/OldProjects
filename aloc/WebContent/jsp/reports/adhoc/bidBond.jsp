<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<!-- Bid Bond Section -->

<s:if test="%{#field.id == 'bb_exactProjDesc'}">
	<s:hidden cssClass="fieldId" name="template.filters[\'%{#field.id}\'].fieldId" value="%{#field.id}"/>
	<s:select name="template.filters[\'%{#field.id}\'].condition" list="#{'OR':'Or', 'AND':'And'}" cssClass="condition left"/>
	<div class="fieldName"><s:property value="%{#field.name}"/></div>
	<s:select list="%{#field.operators}" listKey="value()" listValue="value()" name="template.filters[\'%{#field.id}\'].operator"/>
	<s:textfield name="template.filters[\'%{#field.id}\'].value[0]"></s:textfield>
</s:if>

<s:if test="%{#field.id == 'bb_obligationCity'}">
	<s:hidden cssClass="fieldId" name="template.filters[\'%{#field.id}\'].fieldId" value="%{#field.id}"/>
	<s:select name="template.filters[\'%{#field.id}\'].condition" list="#{'OR':'Or', 'AND':'And'}" cssClass="condition left"/>
	<div class="fieldName"><s:property value="%{#field.name}"/></div>
	<s:select list="%{#field.operators}" listKey="value()" listValue="value()" name="template.filters[\'%{#field.id}\'].operator"/>
	<s:textfield name="template.filters[\'%{#field.id}\'].value[0]"></s:textfield>
</s:if>

<s:if test="%{#field.id == 'bb_obligationCountryOrstate'}">
	<s:hidden cssClass="fieldId" name="template.filters[\'%{#field.id}\'].fieldId" value="%{#field.id}"/>
	<s:select name="template.filters[\'%{#field.id}\'].condition" list="#{'OR':'Or', 'AND':'And'}" cssClass="condition left"/>
	<div class="fieldName"><s:property value="%{#field.name}"/></div>
	<s:select list="%{#field.operators}" listKey="value()" listValue="value()" name="template.filters[\'%{#field.id}\'].operator"/>
	<sj:autocompleter list="%{#attr['com.ge.aloc.StaticDataFactory'].stateList}" 
		name="template.filters[\'%{#field.id}\'].value[0]" listKey="stateName" listValue="stateName" />
</s:if>

<s:if test="%{#field.id == 'bb_currencyCd'}">
	<s:hidden cssClass="fieldId" name="template.filters[\'%{#field.id}\'].fieldId" value="%{#field.id}"/>
	<s:select name="template.filters[\'%{#field.id}\'].condition" list="#{'OR':'Or', 'AND':'And'}" cssClass="condition left"/>
	<div class="fieldName"><s:property value="%{#field.name}"/></div>
	<s:select list="%{#field.operators}" listKey="value()" listValue="value()" name="template.filters[\'%{#field.id}\'].operator"/>
	<sj:autocompleter list="%{#attr['com.ge.aloc.StaticDataFactory'].reportCurrency}" 
		name="template.filters[\'%{#field.id}\'].value[0]" listKey="currencyName" listValue="currencyName" />
</s:if>

<s:if test="%{#field.id == 'bb_otherInfo'}">
	<s:hidden cssClass="fieldId" name="template.filters[\'%{#field.id}\'].fieldId" value="%{#field.id}"/>
	<s:select name="template.filters[\'%{#field.id}\'].condition" list="#{'OR':'Or', 'AND':'And'}" cssClass="condition left"/>
	<div class="fieldName"><s:property value="%{#field.name}"/></div>
	<s:select list="%{#field.operators}" listKey="value()" listValue="value()" name="template.filters[\'%{#field.id}\'].operator"/>
	<s:textfield name="template.filters[\'%{#field.id}\'].value[0]"></s:textfield>
</s:if>

<s:if test="%{#field.id == 'bb_bondFormType'}">
	<s:hidden cssClass="fieldId" name="template.filters[\'%{#field.id}\'].fieldId" value="%{#field.id}"/>
	<s:select name="template.filters[\'%{#field.id}\'].condition" list="#{'OR':'Or', 'AND':'And'}" cssClass="condition left"/>
	<div class="fieldName"><s:property value="%{#field.name}"/></div>
	<s:select list="%{#field.operators}" listKey="value()" listValue="value()" name="template.filters[\'%{#field.id}\'].operator"/>
	<s:select name="template.filters[\'%{#field.id}\'].value[0]" list="%{#attr['com.ge.aloc.StaticDataFactory'].bondTypes}" listKey="name" listValue="name" />
</s:if>

<s:if test="%{#field.id == 'bb_invitationOrBidNo'}">
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

<s:if test="%{#field.id == 'bb_bidDt'}">
	<div class="firstOperand left" style="width: 385px;">
		<s:hidden cssClass="fieldId" name="template.filters[\'%{#field.id}\'].fieldId" value="%{#field.id}"/>
		<s:select name="template.filters[\'%{#field.id}\'].condition" list="#{'OR':'Or', 'AND':'And'}" cssClass="condition left"/>
		<div class="fieldName"><s:property value="%{#field.name}"/></div>
		<s:select list="%{#field.operators}" listKey="value()" listValue="value()" name="template.filters[\'%{#field.id}\'].operator" cssClass="operator"/>
		<s:textfield name="template.filters[\'%{#field.id}\'].value[0]" cssClass="dateReports inBetween"></s:textfield>
		<s:hidden name="template.filters[\'%{#field.id}\'].dataType" value="%{#field.dataType}"></s:hidden>
	</div>
	<div class="secondOperand left hide" style="width: 125px;">
		&nbsp;and&nbsp;
		<s:textfield name="template.filters[\'%{#field.id}\'].value[1]" cssClass="dateReports inBetween"></s:textfield>
		<s:hidden name="template.filters[\'%{#field.id}\'].dataType" value="%{#field.dataType}"></s:hidden>
	</div>
</s:if>

<s:if test="%{#field.id == 'bb_estStartDt'}">
	<div class="firstOperand left" style="width: 385px;">
		<s:hidden cssClass="fieldId" name="template.filters[\'%{#field.id}\'].fieldId" value="%{#field.id}"/>
		<s:select name="template.filters[\'%{#field.id}\'].condition" list="#{'OR':'Or', 'AND':'And'}" cssClass="condition left"/>
		<div class="fieldName"><s:property value="%{#field.name}"/></div>
		<s:select list="%{#field.operators}" listKey="value()" listValue="value()" name="template.filters[\'%{#field.id}\'].operator" cssClass="operator"/>
		<s:textfield name="template.filters[\'%{#field.id}\'].value[0]" cssClass="dateReports inBetween"></s:textfield>
		<s:hidden name="template.filters[\'%{#field.id}\'].dataType" value="%{#field.dataType}"></s:hidden>
	</div>
	<div class="secondOperand left hide" style="width: 125px;">
		&nbsp;and&nbsp;
		<s:textfield name="template.filters[\'%{#field.id}\'].value[1]" cssClass="dateReports inBetween"></s:textfield>
		<s:hidden name="template.filters[\'%{#field.id}\'].dataType" value="%{#field.dataType}"></s:hidden>
	</div>
</s:if>

<s:if test="%{#field.id == 'bb_estCompletionDt'}">
	<div class="firstOperand left" style="width: 385px;">
		<s:hidden cssClass="fieldId" name="template.filters[\'%{#field.id}\'].fieldId" value="%{#field.id}"/>
		<s:select name="template.filters[\'%{#field.id}\'].condition" list="#{'OR':'Or', 'AND':'And'}" cssClass="condition left"/>
		<div class="fieldName"><s:property value="%{#field.name}"/></div>
		<s:select list="%{#field.operators}" listKey="value()" listValue="value()" name="template.filters[\'%{#field.id}\'].operator" cssClass="operator"/>
		<s:textfield name="template.filters[\'%{#field.id}\'].value[0]" cssClass="dateReports inBetween"></s:textfield>
		<s:hidden name="template.filters[\'%{#field.id}\'].dataType" value="%{#field.dataType}"></s:hidden>
	</div>
	<div class="secondOperand left hide" style="width: 125px;">
		&nbsp;and&nbsp;
		<s:textfield name="template.filters[\'%{#field.id}\'].value[1]" cssClass="dateReports inBetween"></s:textfield>
		<s:hidden name="template.filters[\'%{#field.id}\'].dataType" value="%{#field.dataType}"></s:hidden>
	</div>
</s:if>

<s:if test="%{#field.id == 'bb_estBidAmount'}">
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

<s:if test="%{#field.id == 'bb_bidBondAmount'}">
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

<s:if test="%{#field.id == 'bb_USDBidBondAmt'}">
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

<s:if test="%{#field.id == 'bb_warrantyTerm'}">
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

<s:if test="%{#field.id == 'bb_needByDt'}">
	<div class="firstOperand left" style="width: 385px;">
		<s:hidden cssClass="fieldId" name="template.filters[\'%{#field.id}\'].fieldId" value="%{#field.id}"/>
		<s:select name="template.filters[\'%{#field.id}\'].condition" list="#{'OR':'Or', 'AND':'And'}" cssClass="condition left"/>
		<div class="fieldName"><s:property value="%{#field.name}"/></div>
		<s:select list="%{#field.operators}" listKey="value()" listValue="value()" name="template.filters[\'%{#field.id}\'].operator" cssClass="operator"/>
		<s:textfield name="template.filters[\'%{#field.id}\'].value[0]" cssClass="dateReports inBetween"></s:textfield>
		<s:hidden name="template.filters[\'%{#field.id}\'].dataType" value="%{#field.dataType}"></s:hidden>
	</div>
	<div class="secondOperand left hide" style="width: 125px;">
		&nbsp;and&nbsp;
		<s:textfield name="template.filters[\'%{#field.id}\'].value[1]" cssClass="dateReports inBetween"></s:textfield>
		<s:hidden name="template.filters[\'%{#field.id}\'].dataType" value="%{#field.dataType}"></s:hidden>
	</div>
</s:if>