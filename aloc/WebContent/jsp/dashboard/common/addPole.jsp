<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<td height="1" class="noPadding">
	<s:select list="%{#attr['com.ge.aloc.StaticDataFactory'].polesDetails}" cssClass="poleSelectCls"
		listKey="ID" listValue="name" name="searchCriteria.poles[%{#parameters['newPole']}]"
		headerKey="" headerValue="Select..."/>
</td>