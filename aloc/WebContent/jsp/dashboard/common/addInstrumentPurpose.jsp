<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<td height="1" class="noPadding">
	<s:select list="%{#attr['com.ge.aloc.StaticDataFactory'].instrumentPurpose}"
		listKey="ID" listValue="name" name="searchCriteria.searchReqDetails.instrPurposeTypes[%{#parameters['newInstrumentPurpose']}]"
		headerKey="" headerValue="Select..."/>
</td>