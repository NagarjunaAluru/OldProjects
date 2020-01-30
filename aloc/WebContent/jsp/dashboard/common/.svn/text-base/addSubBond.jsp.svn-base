<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<td height="1" class="noPadding">
	<div class="span2c left">
		<s:select headerKey="" list="%{#attr['com.ge.aloc.StaticDataFactory'].bondTypes}" headerValue="Select..."
			key="label.advanceSearch.field.bondType" theme="aloc" name="bondSubBondList[%{#parameters['newSubBond']}].typeBond"
			listKey="ID" listValue="name" cssClass="span2 selectBondType">
		</s:select>
		<img alt="Loading..." class="indicator" src="${pageContext.request.contextPath}/img/loading.gif" 
			style="height: 20px; display:none">
	</div>
		
	<div class="span2 left"> 	
		<s:select list="#{}" key="label.advanceSearch.field.bondSubType" cssClass="span2 selectSubBondType"
			listKey="ID" listValue="name" theme="aloc">
		</s:select>
		<s:hidden name="bondSubBondList[%{#parameters['newSubBond']}].typeSubBond" cssClass="selectedSubBondType"></s:hidden>
	</div>
</td>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/others/addSubBond.js"></script>