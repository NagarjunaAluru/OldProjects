<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<!-- Instrument Details Section -->
<s:if test="%{#field.id == 'id_issuanceCountry'}">
	<s:hidden cssClass="fieldId" name="template.filters[\'%{#field.id}\'].fieldId" value="%{#field.id}"/>
	<s:select name="template.filters[\'%{#field.id}\'].condition" list="#{'OR':'Or', 'AND':'And'}" cssClass="condition left"/>
	<div class="fieldName"><s:property value="%{#field.name}"/></div>
	<s:select list="%{#field.operators}" listKey="value()" listValue="value()" name="template.filters[\'%{#field.id}\'].operator"/>
	<sj:autocompleter list="%{#attr['com.ge.aloc.MasterDataFactory'].countries}" 
		name="template.filters[\'%{#field.id}\'].value[0]" listKey="countryName" listValue="countryName" />
</s:if>

<s:if test="%{#field.id == 'id_instrumentCurrency'}">
	<s:hidden cssClass="fieldId" name="template.filters[\'%{#field.id}\'].fieldId" value="%{#field.id}"/>
	<s:select name="template.filters[\'%{#field.id}\'].condition" list="#{'OR':'Or', 'AND':'And'}" cssClass="condition left"/>
	<div class="fieldName"><s:property value="%{#field.name}"/></div>
	<s:select list="%{#field.operators}" listKey="value()" listValue="value()" name="template.filters[\'%{#field.id}\'].operator"/>
	<sj:autocompleter list="%{#attr['com.ge.aloc.StaticDataFactory'].reportCurrency}" 
		name="template.filters[\'%{#field.id}\'].value[0]" listKey="currencyName" listValue="currencyName" />
</s:if>

<s:if test="%{#field.id == 'id_maxPossibleExpo'}">
	<s:hidden cssClass="fieldId" name="template.filters[\'%{#field.id}\'].fieldId" value="%{#field.id}"/>
	<s:select name="template.filters[\'%{#field.id}\'].condition" list="#{'OR':'Or', 'AND':'And'}" cssClass="condition left"/>
	<div class="fieldName"><s:property value="%{#field.name}"/></div>
	<s:select list="%{#field.operators}" listKey="value()" listValue="value()" name="template.filters[\'%{#field.id}\'].operator"/>
	<s:textfield name="template.filters[\'%{#field.id}\'].value[0]"></s:textfield>
</s:if>

<s:if test="%{#field.id == 'id_autoExtendFlag'}">
	<s:hidden cssClass="fieldId" name="template.filters[\'%{#field.id}\'].fieldId" value="%{#field.id}"/>
	<s:select name="template.filters[\'%{#field.id}\'].condition" list="#{'OR':'Or', 'AND':'And'}" cssClass="condition left"/>
	<div class="fieldName"><s:property value="%{#field.name}"/></div>
	<s:select list="%{#field.operators}" listKey="value()" listValue="value()" name="template.filters[\'%{#field.id}\'].operator"/>
	<s:select name="template.filters[\'%{#field.id}\'].value[0]" list="#{'Y':'Yes', 'N':'No'}" />
</s:if>

<s:if test="%{#field.id == 'id_nonRenewalPeriod'}">
	<s:hidden cssClass="fieldId" name="template.filters[\'%{#field.id}\'].fieldId" value="%{#field.id}"/>
	<s:select name="template.filters[\'%{#field.id}\'].condition" list="#{'OR':'Or', 'AND':'And'}" cssClass="condition left"/>
	<div class="fieldName"><s:property value="%{#field.name}"/></div>
	<s:select list="%{#field.operators}" listKey="value()" listValue="value()" name="template.filters[\'%{#field.id}\'].operator"/>
	<s:select name="template.filters[\'%{#field.id}\'].value[0]" list="#{'30':'30 Days', '60':'60 days','90':'90 Days', 'other':'Other'}" />
</s:if>

<s:if test="%{#field.id == 'id_otherTimeframe'}">
	<s:hidden cssClass="fieldId" name="template.filters[\'%{#field.id}\'].fieldId" value="%{#field.id}"/>
	<s:select name="template.filters[\'%{#field.id}\'].condition" list="#{'OR':'Or', 'AND':'And'}" cssClass="condition left"/>
	<div class="fieldName"><s:property value="%{#field.name}"/></div>
	<s:select list="%{#field.operators}" listKey="value()" listValue="value()" name="template.filters[\'%{#field.id}\'].operator"/>
	<s:textfield name="template.filters[\'%{#field.id}\'].value[0]"></s:textfield>
</s:if>


<s:if test="%{#field.id == 'id_instrumentAmt'}">
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

<s:if test="%{#field.id == 'id_USDEquivalent'}">
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

<s:if test="%{#field.id == 'id_percentValueOfBid'}">
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

<s:if test="%{#field.id == 'id_issueDt'}">
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

<s:if test="%{#field.id == 'id_expiryDt'}">
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

<s:if test="%{#field.id == 'id_econoExpiryDt'}">
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

<s:if test="%{#field.id == 'id_initialExpiryDt'}">
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

<s:if test="%{#field.id == 'id_autoIncDecFlag'}">
	<s:hidden cssClass="fieldId" name="template.filters[\'%{#field.id}\'].fieldId" value="%{#field.id}"/>
	<s:select name="template.filters[\'%{#field.id}\'].condition" list="#{'OR':'Or', 'AND':'And'}" cssClass="condition left"/>
	<div class="fieldName"><s:property value="%{#field.name}"/></div>
	<s:select list="%{#field.operators}" listKey="value()" listValue="value()" name="template.filters[\'%{#field.id}\'].operator"/>
	<s:select name="template.filters[\'%{#field.id}\'].value[0]" list="#{'Y':'Yes', 'N':'No'}" />
</s:if>

<s:if test="%{#field.id == 'id_autoIncIndicator'}">
	<s:hidden cssClass="fieldId" name="template.filters[\'%{#field.id}\'].fieldId" value="%{#field.id}"/>
	<s:select name="template.filters[\'%{#field.id}\'].condition" list="#{'OR':'Or', 'AND':'And'}" cssClass="condition left"/>
	<div class="fieldName"><s:property value="%{#field.name}"/></div>
	<s:select list="%{#field.operators}" listKey="value()" listValue="value()" name="template.filters[\'%{#field.id}\'].operator"/>
	<s:select name="template.filters[\'%{#field.id}\'].value[0]" list="#{'increase':'Increase', 'decrease':'Decrease'}" />
</s:if>

<s:if test="%{#field.id == 'id_autoIncDt'}">
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

<s:if test="%{#field.id == 'id_autoIncAmt'}">
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
