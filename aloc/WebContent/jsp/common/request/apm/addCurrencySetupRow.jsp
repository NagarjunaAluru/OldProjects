<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
	
	<td>
		&nbsp;
	</td>
	
	<td>
		<sj:autocompleter list="%{#attr['com.ge.aloc.MasterDataFactory'].currencies}" onChangeTopics="setCurName"
					name="apmDetails.FXRateHistoryAndCurrencySetup.currencySetups[%{#parameters['curIndex']}].currencyCode" cssClass="span3 currencyCode" 
					listKey="currencyCode" listValue="currencyName" theme="aloc" cssStyle="width:160px;"/>
		<p style="padding-top:5px;"><i><s:text name="label.request.searchForCurrency"></s:text></i></p>
		<div style="color: red;"><s:fielderror fieldName="currencySetup.currencyCode" ></s:fielderror></div>
	</td>
	
	<td><s:radio theme="aloc" cssClass="radio rateDirection"  list="#{'Multiply':'Multiply','Divide':'Divide'}" 
		name="apmDetails.FXRateHistoryAndCurrencySetup.currencySetups[%{#parameters['curIndex']}].rateDirection"   />
		<div style="color: red;"><s:fielderror fieldName="currencySetup.rateDirection"></s:fielderror></div>
		</td>
	
	<td><s:textfield name="apmDetails.FXRateHistoryAndCurrencySetup.currencySetups[%{#parameters['curIndex']}].tickerSymbol" 
		maxlength="20" cssStyle="width:70px;"  cssClass="tickerSymbol"/>
		<div style="color: red;"><s:fielderror fieldName="currencySetup.tickerSymbol"></s:fielderror></div>	
	</td>
	<td>
		<s:select list="#{'0':'0','1':'1','2':'2','3':'3','4':'4'}"  headerValue="Select..." cssClass="decimalPrecision span2" headerKey="" 
		name="apmDetails.FXRateHistoryAndCurrencySetup.currencySetups[%{#parameters['curIndex']}].decimalPrecision"/>
		<div style="color: red;"><s:fielderror fieldName="currencySetup.decimalPrecision"></s:fielderror></div>
	</td>
	
	<td><s:radio theme="aloc" cssClass="radio apmPaymentCurrencyFlag"  list="#{'Yes':'Yes','No':'No'}" 
		name="apmDetails.FXRateHistoryAndCurrencySetup.currencySetups[%{#parameters['curIndex']}].APMPaymentCurrencyFlag"  />
		<div style="color: red;"><s:fielderror fieldName="currencySetup.APMPaymentCurrencyFlag"></s:fielderror></div>	
	</td>
	
	<td>
		<s:textfield name="apmDetails.FXRateHistoryAndCurrencySetup.currencySetups[%{#parameters['curIndex']}].BUC" 
		maxlength="6" cssStyle="width:70px;"  cssClass="BUC"/>
		<img alt="Loading..." class="bucProcessImg" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px;">
		<span class="hide invalidBucMsg"  style="color: red;"></span>
		<div style="color: red;"><s:fielderror fieldName="currencySetup.BUC"></s:fielderror></div>
	</td>
	
	<td>
		<s:textfield name="apmDetails.FXRateHistoryAndCurrencySetup.currencySetups[%{#parameters['curIndex']}].ADN" 
		maxlength="23" cssStyle="width:70px;"  cssClass="ADN"/>
		<div style="color: red;"><s:fielderror fieldName="currencySetup.ADN"></s:fielderror></div>
	</td>
		
	<td class="hide">
		<s:textfield name="apmDetails.FXRateHistoryAndCurrencySetup.currencySetups[%{#parameters['curIndex']}].currencyConfigId" 
			cssClass="currencyConfigId"/>
	</td>
	
	<td class="hide"> <s:textfield name="curIndex" cssClass="curIndex" value="%{#parameters['curIndex']}"/></td>
	<td class="hide"> 
		<s:textfield name="apmDetails.FXRateHistoryAndCurrencySetup.currencySetups[%{#parameters['curIndex']}].currencyName"
		 cssClass="currName" />
	</td>
	<td class="hide currSetupErrorId"> <s:property value="%{errorShow}"/></td>
	
	<script src="${pageContext.request.contextPath}/js/requestor/apmCurrencySetup.js" type="text/javascript"></script>