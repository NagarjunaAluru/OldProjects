<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="hide filterMsg" >
<s:form name="advanceSearchForm" id="advanceSearchFormID">
<br/>
<div class="row advanceSearchNotification">
	<div class="span11as">
		<div class="errorbox">
			<div class="noteHead"><p class="noteicon"><s:text name="label.common.alert"/></p></div>
			<div class="noteContent">
				<p><s:text name="label.advanceSearch.message.search"/></p>
			</div>
		</div>
	</div>
</div>

<h2 id="requestDetails" class="section_flip section_blue section_noToggle">
	<a href="javascript:;"><s:text name="label.advanceSearch.header.requestDetails" /> </a>
</h2><hr class="h2-hr">
<div id="requestDetailsPanel" class="section_panel">

	<div class="row">	
		<div class="span2">
			<s:label key="label.advanceSearch.field.ALOCrecordnumber"/>
			<s:textfield name="apmSearch.ALOCRecordNumber" cssClass="span2"></s:textfield>
		</div>

		<div class="span2">
			<s:label key="label.advanceSearch.field.buc"/>
			<s:textfield name="apmSearch.BUC" cssClass="span2"></s:textfield>
		</div>

		<div class="span2">
			<s:label key="label.advanceSearch.field.adn"/>
			<s:textfield name="apmSearch.ADN" cssClass="span2"></s:textfield>
		</div>
	</div>
</div>
<!-- trigger 1 ends here -->

<h2 id="nameDetails" class="section_flip section_blue section_noToggle">
	<a href="javascript:;"><s:text name="label.advanceSearch.header.appDetails" /></a>
</h2><hr class="h2-hr">
<div id="nameDetailsPanel" class="section_panel">

	<div class="row">
		<div class="span2">
			<s:label key="label.advanceSearch.field.applicantPrincipalName"/>
			<s:textfield name="apmSearch.applicant" cssClass="span2"></s:textfield>
		</div>

		<div class="span2">
			<s:label key="label.advanceSearch.field.beneficiaryObligeeName"/>
			<s:textfield name="apmSearch.beneficiary" cssClass="span2"></s:textfield>
		</div>   
	</div>
</div>
<!-- trigger 2 ends here -->


<h2 id="bankDetails" class="section_flip section_blue section_noToggle">
	<a href="javascript:;"> <s:text name="label.advanceSearch.header.bankDetails"/> </a>
</h2><hr class="h2-hr">
<div id="bankDetailsPanel" class="section_panel">

	<div class="row">
		<div class="span2">
			<s:label key="label.advanceSearch.field.bankReferenceNumber"/>
			<s:textfield name="apmSearch.bankReferenceNumber" cssClass="span2"></s:textfield>
		</div>
	</div>

</div>
<!-- trigger 3 ends here -->


<h2 id="instrumentDetails" class="section_flip section_blue section_noToggle">
	<a href="javascript:;"> <s:text name="label.advanceSearch.header.instrumentDetails"/> </a>
</h2><hr class="h2-hr">
<div id="instrumentDetailsPanel" class="section_panel">

	<div class="row">
		<div class="span4">
			<s:label key="label.advanceSearch.field.instrumentAmount"/>
			<s:textfield name="apmSearch.instrumentAmountFrom" cssClass="span2"></s:textfield> 
			<s:text name="label.advanceSearch.to"/> 
			<s:textfield name="apmSearch.instrumentAmountTo" cssClass="span2"></s:textfield>
		</div>
		<div class="clear"></div>
		<p>&nbsp;</p>

		<div class="span4" id="countryI">
			<s:hidden id="newIssuanceCountry" name="newIssuanceCountry" value="0"/>
			<s:label key="label.advanceSearch.field.countryOfIssuance"/>
			<div class="form-row">
				    <sj:autocompleter list="%{#attr['com.ge.aloc.MasterDataFactory'].countries}"
					name="apmSearch.countryOfIssuences[0]"
					cssClass="span2" listKey="countryCode" listValue="countryName" onChangeTopics="getAutocompleterName"/>
					<br>
					<em> <s:text name="label.advanceSearch.em.country"/> </em>
			</div>
			<a href="javascript:;" class="add-exception" id="addCountryI"> <s:text name="label.advanceSearch.addElement.issuanceCountry"/> </a>
		</div>
	</div>

</div>
<!-- trigger 4 ends here -->
<h2 id="paymentDetails" class="section_flip section_blue section_noToggle">
	<a href="javascript:;"> <s:text name="label.advanceSearch.header.paymentDetails"></s:text> </a>
</h2><hr class="h2-hr">
<div id="paymentDetailsPanel" class="section_panel">
	<div class="row">
		<div class="span4">
       		<s:label key="label.advanceSearch.field.paymentDate"></s:label>
            <s:textfield name="apmSearch.paymentDateFrom" cssClass="date"></s:textfield> 
			<s:text name="label.advanceSearch.to"/> 
			<s:textfield name="apmSearch.paymentDateTo" cssClass="date"></s:textfield>
        </div>                    
		<div class="clear"></div>
        <p>&nbsp;</p>
        <div class="span2" id="paymentC">
        	<s:label key="label.advanceSearch.field.paymentCurrency"></s:label>
        	<s:hidden id="newPaymentCurrency" name="newPaymentCurrency" value="0"/>
        	<div class="form-row">
				    <sj:autocompleter list="%{#attr['com.ge.aloc.MasterDataFactory'].currencies}"
						name="apmSearch.paymentCurrencies[0]"
						cssClass="span2" listKey="currencyCode" listValue="currencyName" onChangeTopics="getAutocompleterName"/>			
					<br>
					<em> <s:text name="label.advanceSearch.em.currency"/> </em>
			</div>
        	<a href="javascript:;" class="add-exception" id="addPaymentC"> <s:text name="label.advanceSearch.addElement.country"/> </a>
        </div>
	</div>
</div>

<!-- trigger 5 ends here -->
<p>&nbsp;</p>
<s:url action="advanceFHSearch.action" var="advanceSearchDashboardURL" namespace="/ext/admin" encode="true" escapeAmp="false"/>
<a href="<s:property value="#advanceSearchDashboardURL" />" class="btn-primary advanceFHSearchBtn">
<s:text name="label.dashboard.search"/>
</a>
<a href="javascript:;" class="btn-tertiary collapse" > <s:text name="label.advanceSearch.link.collapseFilters"/> </a>
<img alt="Loading..." id="advSearchIndicator" class="indicator" src="${pageContext.request.contextPath}/ext/public/img/loading.gif" 
	style="height: 20px; display:none">
</s:form>
</div>
