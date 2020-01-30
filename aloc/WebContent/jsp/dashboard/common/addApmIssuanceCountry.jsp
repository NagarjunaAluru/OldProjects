<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="form-row">
	<sj:autocompleter list="%{#attr['com.ge.aloc.MasterDataFactory'].countries}"
	name="apmSearch.countryOfIssuences[%{#parameters['newIssuanceCountry']}]"
	cssClass="span2" listKey="countryCode" listValue="countryName"
	cssStyle="font-size: 11px;" onChangeTopics="getAutocompleterName"/>
	<br>
	<em><s:text name="label.advanceSearch.em.country"/></em>
</div>