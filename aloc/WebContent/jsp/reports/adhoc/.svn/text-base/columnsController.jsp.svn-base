<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:if test="%{#parameters.fieldId != null}">
	<s:set var="field" value="%{getField(#parameters.fieldId)}"  />
</s:if>
<s:else>
	<c:if test="${not empty param.fieldId}">
		<s:set name="fieldId">${param.fieldId}</s:set>
	</c:if> 
	<s:set var="field" value="%{getField(#fieldId)}"  />
</s:else>

<th style="width: 80px;"> 
	<div style="height: 75px;">
		<s:property value="%{#field.name}" />
		<s:hidden cssClass="columnFieldId"
		name="template.columns[\'%{#field.id}\'].fieldId"
		value="%{#field.id}" />
		<input type="hidden" name="template.columnIds" value="${param.fieldId}">
	</div>
	<div style="width: 80px;">
		<img alt="setting" src="${pageContext.request.contextPath}/img/arrow-left-ico.png" style="margin-left: 0px; float: left;">
		<img alt="setting" src="${pageContext.request.contextPath}/img/arrow-right-ico.png" style="margin-left: 0px; float: left;">
		<a class="settings up right" id="<s:property value="%{#field.id}" />">
		<img alt="setting" src="${pageContext.request.contextPath}/img/setting-ico.png" style="margin-left: 0px;">
		</a>
	</div>
	<div class="hide columnOrderPriority">
		<a href="javascript:;" class="right orderPriorityClose">X</a>
		<div class="left">
			<s:select key="label.report.sortOrder"
				name="template.columns[\'%{#field.id}\'].sortOrder"
				list="#{'asc':'Ascending' , 'desc':'Descending'}" theme="aloc" cssClass="sortOrder"/>
		</div>
		<div class="left" style="padding-left: 10px;">
			<s:select key="label.report.sortPriority" headerKey="0" headerValue="Select..."
				list="#{}" theme="aloc" cssClass="sortPriority"/>
			<s:hidden name="template.columns[\'%{#field.id}\'].sortPriority"
				cssClass="sortPriorityValue"></s:hidden>
		</div>
	</div>
</th>

