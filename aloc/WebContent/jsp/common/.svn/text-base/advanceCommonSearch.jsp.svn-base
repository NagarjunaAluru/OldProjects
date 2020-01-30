<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="${pageContext.request.contextPath}/js/common/site.js" type="text/javascript"></script>

<div class="hide filterMsg" >
<s:form name="advanceSearchForm" id="advanceSearchFormID">

<h2 id="requestDetails" class="section_flip section_blue">
	<a href="javascript:;"><s:text name="label.advanceSearch.header.requestDetails" /> </a>
</h2><hr class="h2-hr">
<div id="requestDetailsPanel" class="section_panel">

	<table id="tableModel" class="table table-striped table-bordered">
		<thead>
			<tr>
				<td colspan="7"><s:text name="label.advanceSearch.header.instrumentType" /></td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<s:set name="instrTypeSize" value="%{#attr['com.ge.aloc.StaticDataFactory'].instrumentType.size}"></s:set>
				<td><s:checkbox name="searchCriteria.searchReqDetails.all" value="all" fieldValue="true" cssClass="checkall"/> <s:text name="label.advanceSearch.checkbox.all"/> </td>
				<s:iterator value="%{#attr['com.ge.aloc.StaticDataFactory'].instrumentType}" status="stat">
					<td>
						<s:checkbox name="instrumentTypes" value="%{name}" fieldValue="%{ID}" cssClass="instrTypes"/><s:property value="name"/>
						<s:if test="#instrTypeSize == #stat.count">
						<span class="ttip info"	data-original-title="This is an tooltip with more information"></span>
						</s:if>
					</td>
				</s:iterator>
				
			</tr>
		</tbody>
	</table>


	<div class="row">
		<div class="span2">
			<s:label key="label.advanceSearch.field.ALOCrecordnumber"/>
			<s:textfield name="searchCriteria.searchReqDetails.alocReqNo" cssClass="span2"></s:textfield>
		</div>

		<div class="span2">
			<s:label key="label.advanceSearch.field.name"/>
			<s:textfield name="searchCriteria.searchReqDetails.name" cssClass="span2"></s:textfield>
		</div>

		<div class="span2">
			<s:label key="label.advanceSearch.field.linkID"/>
			<s:textfield name="searchCriteria.searchReqDetails.linkId" cssClass="span2"></s:textfield>
		</div>

		<div class="span2">
			<s:label key="label.advanceSearch.field.bundleID"/>
			<s:textfield name="searchCriteria.searchReqDetails.bundleId" cssClass="span2"></s:textfield>
		</div>


	</div>

	<div class="row">
		<div class="span4">
			<s:hidden id="newInstrumentPurpose" name="newInstrumentPurpose" value="0"/>
			<s:label key="label.advanceSearch.field.instrumentPurpose"/>
			<table border="0" width="100%" cellpadding="5" cellspacing="0"
				id="instrumentST" style="margin-left: -5px;">
				<tr>
					<td height="1" class="noPadding">
						<s:select list="%{#attr['com.ge.aloc.StaticDataFactory'].instrumentPurpose}"
							listKey="ID" listValue="name" name="searchCriteria.searchReqDetails.instrPurposeTypes[0]"
							headerKey="" headerValue="Select..."/>
					</td>
				</tr>
			</table>
			<a href="javascript:;" class="add-exception" id="addInstrumentST"> 
				<s:text name="label.advanceSearch.addElement.instrumentPurpose"/> 
			</a>
		</div>

		<div class="span2">
			<s:label key="label.advanceSearch.field.StateProvince"/>
			<s:select list="%{#attr['com.ge.aloc.StaticDataFactory'].stateList}"
				listKey="stateCode" listValue="stateName" name="searchCriteria.searchReqDetails.stateProvince"
				headerKey="" headerValue="Select..."/>
		</div>

	</div>


</div>
<!-- trigger 1 ends here -->

<h2 id="nameDetails" class="section_flip section_blue">
	<a href="javascript:;"><s:text name="label.advanceSearch.header.appDetails" /></a>
</h2><hr class="h2-hr">
<div id="nameDetailsPanel" class="section_panel">

	<div class="row">
		<div class="span2">
			<s:label key="label.advanceSearch.field.applicantPrincipalName"/>
			<s:textfield name="searchCriteria.applicantDetails.addressDtls.name" cssClass="span2"></s:textfield>
		</div>

		<div class="span2">
			<s:label key="label.advanceSearch.field.beneficiaryObligeeName"/>
			<s:textfield name="searchCriteria.beneficiaryDetails.addressDtls.name" cssClass="span2"></s:textfield>
		</div>

	</div>

</div>
<!-- trigger 2 ends here -->


<h2 id="bankDetails" class="section_flip section_blue">
	<a href="javascript:;"> <s:text name="label.advanceSearch.header.bankDetails"/> </a>
</h2><hr class="h2-hr">
<div id="bankDetailsPanel" class="section_panel">

	<div class="row">
		<div class="span2">
			<s:label key="label.advanceSearch.field.issuingBankBranchName"/>
			<s:textfield name="searchCriteria.searchBankDetails.issuingBankBranchName" cssClass="span2"></s:textfield>
		</div>

		<div class="span2">
			<s:label key="label.advanceSearch.field.relationshipBankName"/>
			<s:textfield name="searchCriteria.searchBankDetails.relationshipBankName" cssClass="span2"></s:textfield>
		</div>

		<div class="span2">
			<s:label key="label.advanceSearch.field.bankReferenceNumber"/>
			<s:textfield name="searchCriteria.searchBankDetails.bankRefNo" cssClass="span2"></s:textfield>
		</div>

		<div class="span2">
			<s:label key="label.advanceSearch.field.bidReplyID"/>
			<s:textfield name="searchCriteria.searchBankDetails.bidReplyId" cssClass="span2"></s:textfield>
		</div>

	</div>

</div>
<!-- trigger 3 ends here -->


<h2 id="instrumentDetails" class="section_flip section_blue">
	<a href="javascript:;"> <s:text name="label.advanceSearch.header.instrumentDetails"/> </a>
</h2><hr class="h2-hr">
<div id="instrumentDetailsPanel" class="section_panel">

	<div class="row">

		<div class="span4">
			<s:hidden id="newInstrumentCurrency" name="newInstrumentCurrency" value="0"/>
			<s:label key="label.advanceSearch.field.instrumentCurrency"/>
			<table border="0" width="100%" cellpadding="5" cellspacing="0"
				id="instrumentC" style="margin-left: -5px;">
				<tr>
					<td height="1" class="noPadding">
						<sj:autocompleter list="%{#attr['com.ge.aloc.MasterDataFactory'].currencies}"
						name="searchCriteria.searchInstrDetails.instrCurrency[0]"
						cssClass="span2" listKey="currencyCode" listValue="currencyName"/>
						
						<br>
						<em> <s:text name="label.advanceSearch.em.currency"/> </em>
					</td>
				</tr>
			</table>
			<a href="javascript:;" class="add-exception" id="addInstrumentC"> <s:text name="label.advanceSearch.addElement.country"/> </a>
		</div>

		<div class="clear"></div>
		<p>&nbsp;</p>


		<div class="span4">
			<s:label key="label.advanceSearch.field.instrumentAmount"/>
			<s:textfield name="searchCriteria.searchInstrDetails.instrFromAmt" cssClass="span2"></s:textfield> 
			<s:text name="label.advanceSearch.to"/> 
			<s:textfield name="searchCriteria.searchInstrDetails.instrToAmt" cssClass="span2"></s:textfield>
		</div>

		<div class="clear"></div>
		<p>&nbsp;</p>

		<div class="span4">
			<s:hidden id="newIssuanceCountry" name="newIssuanceCountry" value="0"/>
			<s:label key="label.advanceSearch.field.countryOfIssuance"/>
			<table border="0" width="100%" cellpadding="5" cellspacing="0"
				id="countryI" style="margin-left: -5px;">
				<tr>
					<td height="1" class="noPadding">
						<sj:autocompleter list="%{#attr['com.ge.aloc.MasterDataFactory'].countries}"
						name="searchCriteria.searchInstrDetails.issuanceCountries[0]"
						cssClass="span2" listKey="countryCode" listValue="countryName" />
						<br>
						<em> <s:text name="label.advanceSearch.em.country"/> </em>
					</td>
				</tr>
			</table>
			<a href="javascript:;" class="add-exception" id="addCountryI"> <s:text name="label.dashboard.tableHeader.countryOfIssuance"/> </a>
		</div>

	</div>

</div>
<!-- trigger 4 ends here -->

<h2 id="dates" class="section_flip section_blue">
	<a href="javascript:;"> <s:text name="label.advanceSearch.header.dates"/> </a>
</h2><hr class="h2-hr">
<div id="datesPanel" class="section_panel">

	<div class="row">

		<div class="span4">
			<s:label key="label.advanceSearch.field.expirationDate"/>
			<s:textfield name="searchCriteria.searchDates.expiryFromDt" cssClass="date"/> 
			<s:text name="label.advanceSearch.to"/> 
			<s:textfield name="searchCriteria.searchDates.expiryToDt" cssClass="date"/> 
		</div>

	</div>

</div>
<!-- trigger 6 ends here -->

<p>&nbsp;</p>
<s:url action="advanceSearch.action" var="advanceSearchDashboardURL" namespace="/int/dashboard" encode="true" escapeAmp="false"/>
<a href="<s:property value="#advanceSearchDashboardURL" />" class="btn-primary advanceSearchBtn">
<s:text name="label.dashboard.search"/>
</a>
<a href="javascript:;" class="btn-tertiary collapse" > <s:text name="label.advanceSearch.link.collapseFilters"/> </a>
</s:form>
</div>
