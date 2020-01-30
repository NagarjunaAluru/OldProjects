<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
	
	<td><img class="actionImg editPayment" src="${pageContext.request.contextPath}/img/edit-leg.gif"  alt="<s:property value="%{#parameters['curIndex']}"/>_<s:property value="apmDetails.paymentPeriodDetails[%{#parameters['curIndex']}].APMConfigID" />"></td>
	<td><s:text name="apmDetails.paymentPeriodDetails[%{#parameters['curIndex']}].paymentPeriodStartDate"/></td>
						
	<td><s:text name="apmDetails.paymentPeriodDetails[%{#parameters['curIndex']}].paymentPeriodEndDate"/></td>
	
	<td><s:text name="apmDetails.paymentPeriodDetails[%{#parameters['curIndex']}].FXRateRevalueDate"/></td>
	
	<td><s:text name="apmDetails.paymentPeriodDetails[%{#parameters['curIndex']}].paymentPeriodCutoffDate"/></td>
	
	<td><s:text name="apmDetails.paymentPeriodDetails[%{#parameters['curIndex']}].minPaymentAmountUSD"/></td>
	
	<td><s:text name="apmDetails.paymentPeriodDetails[%{#parameters['curIndex']}].dayCount"/></td>
	<td><s:text name="apmDetails.paymentPeriodDetails[%{#parameters['curIndex']}].IBSFile"/></td>
	<td><s:text name="apmDetails.paymentPeriodDetails[%{#parameters['curIndex']}].WebCashFile"/></td>
	<td class="hide">
		<s:textfield name="apmDetails.paymentPeriodDetails[%{#parameters['curIndex']}].APMConfigID" 
			cssClass="configId"/>
	</td>
	<td class="hide"> <s:textfield name="curIndex" cssClass="curIndex" value="%{#parameters['curIndex']}"/></td>
	<td class="hide paymentErrorId"> <s:property value="%{errorShow}"/></td>
<script src="${pageContext.request.contextPath}/js/requestor/payment.js" type="text/javascript"></script>