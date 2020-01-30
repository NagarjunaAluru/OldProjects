<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
	
	<td>
		<img class="actionImg editCurSetup" src="${pageContext.request.contextPath}/img/edit-leg.gif"  alt="<s:property value="%{#parameters['curIndex']}"/>">&nbsp;&nbsp;&nbsp;<a href="#deleteCurrency" data-toggle="modal" class="delCurSetup"><img src='${pageContext.request.contextPath}/img/delete.gif'/>
		<img alt="Loading..." class="editCurProcess" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px;"></a>
	</td>
	
	<td>
		<s:text name="apmDetails.FXRateHistoryAndCurrencySetup.currencySetups[%{#parameters['curIndex']}].currencyName" />
	</td>
	
	<td><s:text name="apmDetails.FXRateHistoryAndCurrencySetup.currencySetups[%{#parameters['curIndex']}].rateDirection" /></td>
	
	<td><s:text name="apmDetails.FXRateHistoryAndCurrencySetup.currencySetups[%{#parameters['curIndex']}].tickerSymbol" /></td>
	
	<td><s:text name="apmDetails.FXRateHistoryAndCurrencySetup.currencySetups[%{#parameters['curIndex']}].decimalPrecision" /></td>
	
	<td class="apmPaymentCurrencyFlag"><s:text name="apmDetails.FXRateHistoryAndCurrencySetup.currencySetups[%{#parameters['curIndex']}].APMPaymentCurrencyFlag" /></td>
	
	<td><s:text name="apmDetails.FXRateHistoryAndCurrencySetup.currencySetups[%{#parameters['curIndex']}].BUC" /></td>
	
	<td><s:text name="apmDetails.FXRateHistoryAndCurrencySetup.currencySetups[%{#parameters['curIndex']}].ADN" /></td>
	
	<td class="currencyConfigId hide">
		<s:text name="apmDetails.FXRateHistoryAndCurrencySetup.currencySetups[%{#parameters['curIndex']}].currencyConfigId" />
	</td>
	
	<td class="hide"> <s:textfield name="curIndex" cssClass="curIndex" value="%{#parameters['curIndex']}"/></td>
	
	<td class="currName hide"> 
		<s:text name="apmDetails.FXRateHistoryAndCurrencySetup.currencySetups[%{#parameters['curIndex']}].currencyName" />
	</td>
	
	<td class="currencyCode hide"> 
		<s:text name="apmDetails.FXRateHistoryAndCurrencySetup.currencySetups[%{#parameters['curIndex']}].currencyCode" />
	</td>
	
	<td class="hide currSetupErrorId"> <s:property value="%{errorShow}"/></td>
	
	<script src="${pageContext.request.contextPath}/js/requestor/apmCurrencySetup.js" type="text/javascript"></script>
	<jsp:include page="/jsp/common/request/apm/currencySetupDelPopups.jsp" />