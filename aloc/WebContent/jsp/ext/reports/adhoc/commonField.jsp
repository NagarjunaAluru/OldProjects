<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<s:if test="%{#field.id == 'alocRecordNo'}">
	<s:hidden cssClass="fieldId" name="template.filters[\'%{#field.id}\'].fieldId" value="%{#field.id}"/>
	<s:select name="template.filters[\'%{#field.id}\'].condition" list="#{'OR':'Or', 'AND':'And'}" cssClass="condition left"/>
	<div class="fieldName"><s:property value="%{#field.name}"/></div>
	<s:select name="template.filters[\'%{#field.id}\'].operator" list="%{#field.operators}" listKey="value()" listValue="value()" />
	<s:textfield name="template.filters[\'%{#field.id}\'].value[0]"></s:textfield>
</s:if>