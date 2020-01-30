<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<script type="text/javascript">
	$('.ttip').tooltip({delay: { show: 300, hide: 1 }});
	$('.ttip.chart').tooltip();
</script>
	
<td height="1" style="padding:10px 0px 5px 0px;">
	<c:if test="${not empty param.bgGeReferenceFieldAddIndex}">
		<c:choose>
			<c:when test="${param.bgGeReferenceFieldAddIndex eq 1}">
			<s:textfield name="requestDetails.transactionParties.tpApplicantDetails.refDetails[%{#parameters['bgGeReferenceFieldAddIndex']}].refValue"
				theme="aloc" cssClass="referenceTextValue" required="false"
				key="label.request.geApplicantReference2" value="" maxlength="30">
			</s:textfield>
			</c:when>
			<c:when test="${param.bgGeReferenceFieldAddIndex eq 2}">
			<s:textfield name="requestDetails.transactionParties.tpApplicantDetails.refDetails[%{#parameters['bgGeReferenceFieldAddIndex']}].refValue"
				theme="aloc" cssClass="referenceTextValue" required="false"
				key="label.request.geApplicantReference3" value="" maxlength="30">
			</s:textfield>
			</c:when>
		</c:choose>
	</c:if>
	
	<c:if test="${not empty param.customerFieldAddIndex}">
		<c:choose>
			<c:when test="${param.customerFieldAddIndex eq 1}">
			<s:textfield name="requestDetails.transactionParties.customer.refDetails[%{#parameters['customerFieldAddIndex']}].refValue"
				theme="aloc" cssClass="referenceTextValue" required="false"
				key="label.request.customerReference2" value="" maxlength="30">
			</s:textfield>
			</c:when>
			<c:when test="${param.customerFieldAddIndex eq 2}">
			<s:textfield name="requestDetails.transactionParties.customer.refDetails[%{#parameters['customerFieldAddIndex']}].refValue"
				theme="aloc" cssClass="referenceTextValue" required="false"
				key="label.request.customerReference3" value="" maxlength="30">
			</s:textfield>
			</c:when>
		</c:choose>
	</c:if>
	
	<c:if test="${not empty param.gereferenceFieldAddIndex}">
		<c:choose>
			<c:when test="${param.gereferenceFieldAddIndex eq 1}">
			<s:textfield name="requestDetails.principal.refDetails[%{#parameters['gereferenceFieldAddIndex']}].refValue"
				cssClass="referenceTextValue" required="false"
				key="label.request.gePrincipalReference2" value="" theme="aloc" maxlength="30">
			</s:textfield>
			</c:when>
			<c:when test="${param.gereferenceFieldAddIndex eq 2}">
			<s:textfield name="requestDetails.principal.refDetails[%{#parameters['gereferenceFieldAddIndex']}].refValue"
				 cssClass="referenceTextValue" required="false"
				key="label.request.gePrincipalReference3" value="" theme="aloc" maxlength="30">
			</s:textfield>
			</c:when>
		</c:choose>
	</c:if>
	
	<c:if test="${not empty param.oblreferenceFieldAddIndex}">
		<c:choose>
			<c:when test="${param.oblreferenceFieldAddIndex eq 1}">
			<s:textfield name="requestDetails.obligee.obligeeReves[%{#parameters['oblreferenceFieldAddIndex']}].refValue"
				 cssClass="referenceTextValue" required="false"
				key="label.request.obligeeReference2" value="" theme="aloc" maxlength="30">
			</s:textfield>
			</c:when>
			<c:when test="${param.oblreferenceFieldAddIndex eq 2}">
			<s:textfield name="requestDetails.obligee.obligeeReves[%{#parameters['oblreferenceFieldAddIndex']}].refValue"
				cssClass="referenceTextValue" required="false"
				key="label.request.obligeeReference3" value="" theme="aloc" maxlength="30">
			</s:textfield>
			</c:when>
		</c:choose>
	</c:if>
	
	<c:if test="${not empty param.geregferenceFieldAddIndex}">
		<c:choose>
			<c:when test="${param.geregferenceFieldAddIndex eq 1}">
			<s:textfield name="requestDetails.applicantDetails.refDetails[%{#parameters['geregferenceFieldAddIndex']}].refValue"
				theme="aloc" cssClass="referenceTextValue" required="false"
				key="label.request.geApplicantReference2" value="" maxlength="30">
			</s:textfield>
			</c:when>
			<c:when test="${param.geregferenceFieldAddIndex eq 2}">
			<s:textfield name="requestDetails.applicantDetails.refDetails[%{#parameters['geregferenceFieldAddIndex']}].refValue"
				theme="aloc" cssClass="referenceTextValue" required="false"
				key="label.request.geApplicantReference3" value="" maxlength="30">
			</s:textfield>
			</c:when>
		</c:choose>
	</c:if>
	
	<c:if test="${not empty param.geBenificiaryFieldAddIndex}">
		<c:choose>
			<c:when test="${param.geBenificiaryFieldAddIndex eq 1}">
			<s:textfield name="requestDetails.beneficiaryDetails.refDetails[%{#parameters['geBenificiaryFieldAddIndex']}].refValue"
				theme="aloc" cssClass="referenceTextValue" required="false"
				key="label.request.customerReference2" value="" maxlength="30">
			</s:textfield>
			</c:when>
			<c:when test="${param.geBenificiaryFieldAddIndex eq 2}">
			<s:textfield name="requestDetails.beneficiaryDetails.refDetails[%{#parameters['geBenificiaryFieldAddIndex']}].refValue"
				theme="aloc" cssClass="referenceTextValue" required="false"
				key="label.request.customerReference3" value="" maxlength="30">
			</s:textfield>
			</c:when>
		</c:choose>
	</c:if>
	
	<c:if test="${not empty param.shipOrgCtryFieldAddIndex}">
		<c:choose>
			<c:when test="${param.shipOrgCtryFieldAddIndex eq 1}">
	         <sj:autocompleter id="shipCountryCd1" onChangeTopics="getAutocompleterName1" key="label.request.shipmentOriginCountry2Optional"
	         list="%{#attr['com.ge.aloc.MasterDataFactory'].countries}" 
	         name="requestDetails.transactionDetails.shipmentOrigins[%{#parameters['shipOrgCtryFieldAddIndex']}].countryCd" cssClass="referenceTextValue span3" 
	         listKey="countryCode" listValue="countryName" parentTheme="aloc" tooltip="%{getText('label.request.tooltip.originOfgoodsToolTipInfo')}"/>		
	         &nbsp;<a href="javascript:;" class="delete-ce" >Remove Shipment origin country</a>			   	
      		  <s:hidden name="requestDetails.transactionDetails.shipmentOrigins[%{#parameters['shipOrgCtryFieldAddIndex']}].countyName" id="shipCountry1"
      		  cssClass="autoCompleterName"></s:hidden>
			</c:when>
			<c:when test="${param.shipOrgCtryFieldAddIndex eq 2}">
             <sj:autocompleter id="shipCountryCd2" onChangeTopics="getAutocompleterName1" key="label.request.shipmentOriginCountry3Optional"
             list="%{#attr['com.ge.aloc.MasterDataFactory'].countries}" 
             name="requestDetails.transactionDetails.shipmentOrigins[%{#parameters['shipOrgCtryFieldAddIndex']}].countryCd" cssClass="referenceTextValue span3" 
             listKey="countryCode" listValue="countryName" parentTheme="aloc" tooltip="%{getText('label.request.tooltip.originOfgoodsToolTipInfo')}"/>		
             &nbsp;<a href="javascript:;" class="delete-ce" >Remove Shipment origin country</a>			   	
             <s:hidden name="requestDetails.transactionDetails.shipmentOrigins[%{#parameters['shipOrgCtryFieldAddIndex']}].countyName" id="shipCountry2"
             cssClass="autoCompleterName"></s:hidden>
			</c:when>
		</c:choose>
	</c:if>
	
	<c:if test="${not empty param.originGoodsFieldAddIndex}">
		<c:choose>
			<c:when test="${param.originGoodsFieldAddIndex eq 1}">
	            <sj:autocompleter id="originOfGoodsCd1" key="label.request.originOfGoods2Optional"
	             	list="%{#attr['com.ge.aloc.MasterDataFactory'].countries}" 
	            name="requestDetails.transactionDetails.goodsOrigins[%{#parameters['originGoodsFieldAddIndex']}].countryCd" cssClass="referenceTextValue span3" 
	            listKey="countryCode" listValue="countryName" parentTheme="aloc" onChangeTopics="getAutocompleterNameAndUS" tooltip="%{getText('label.request.tooltip.originOfgoodsToolTipInfo')}"/>
	            &nbsp;<a href="javascript:;" class="delete-ce" >Remove Origin of goods</a>
	            <s:hidden name="requestDetails.transactionDetails.goodsOrigins[%{#parameters['originGoodsFieldAddIndex']}].countyName" id="originOfGoods1"
	             cssClass="autoCompleterName"></s:hidden>
			</c:when>
			<c:when test="${param.originGoodsFieldAddIndex eq 2}">
	            <sj:autocompleter id="originOfGoodsCd2" key="label.request.originOfGoods3Optional"
	            list="%{#attr['com.ge.aloc.MasterDataFactory'].countries}" 
	            name="requestDetails.transactionDetails.goodsOrigins[%{#parameters['originGoodsFieldAddIndex']}].countryCd" cssClass="referenceTextValue span3" 
	            listKey="countryCode" listValue="countryName" parentTheme="aloc" onChangeTopics="getAutocompleterNameAndUS" tooltip="%{getText('label.request.tooltip.originOfgoodsToolTipInfo')}"/>
	            &nbsp;<a href="javascript:;" class="delete-ce" >Remove Origin of goods</a>
	           <s:hidden name="requestDetails.transactionDetails.goodsOrigins[%{#parameters['originGoodsFieldAddIndex']}].countyName" id="originOfGoods2"
	           cssClass="autoCompleterName"></s:hidden>
			</c:when>
		</c:choose>
	</c:if>
	
	<c:if test="${empty param.buContactPersonFieldAddIndex && empty param.shipOrgCtryFieldAddIndex && empty param.originGoodsFieldAddIndex}">
		&nbsp;<a href="javascript:;" class="delete-ce" >Remove reference</a>
	</c:if>
</td>

