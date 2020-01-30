<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<div>
	<sj:autocompleter list="%{#attr['com.ge.aloc.MasterDataFactory'].currencies}"
		name="searchCriteria.searchPaymentDetails.paymentCurrencyCds[%{#parameters['newPaymentCurrency']}]"
		cssClass="span2" listKey="currencyCode" listValue="currencyName" onChangeTopics="getAutocompleterName"/>
	<br>
	<em> <s:text name="label.advanceSearch.em.currency"/> </em>
</div>