<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<s:set name="isEditMode" value="editMode"/>
<s:if test="%{#isEditMode==true}">
<p class="required-fields"><s:text name="label.request.common.requiredFieldsUnlessSpecified"/></p>
<c:if test="${requestDetails.siteTypeName eq 'Financial Business'}">
<s:if test="%{requestDetails.transactionParties.triPartyRequestFlag}">
<input type="hidden" value="${requestDetails.amendment.transactionParties.triPartyApplicant.stateProvinceCd}" id="amdtriPartyAddStateCd">
<input type="hidden" value="${requestDetails.amendment.transactionParties.triPartyApplicant.countryCd}" id="amdtriPartyAddcountryCd">
	<h3 id="triPartyHeader">
		<s:text name="label.request.triPartyApplicant" /> 
		<span class="ttip info"
					data-original-title="<s:text name="label.request.tooltip.triPartyApplicant"/>"></span>
	</h3>

	<div class="row">
		<div class="span12">
			<div class="form-row">
				<s:textfield name="requestDetails.amendment.transactionParties.triPartyApplicant.name" 
					id="triPartyAddressName" 
					key="label.amendment.triPartyApplicantName" 
					theme="aloc"
				/>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="span12">
			<div class="form-row">
				<s:textfield name="requestDetails.amendment.transactionParties.triPartyApplicant.address[0]" 
					id="triPartyAddress1" 
					key="label.amendment.triPartyApplicantAddress1" 
					theme="aloc"
				/>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="span12">
			<div class="form-row">
				<s:textfield name="requestDetails.amendment.transactionParties.triPartyApplicant.address[1]" 
					id="triPartyAddress2" 
					key="label.amendment.triPartyApplicantAddress2" 
					required="false"
					theme="aloc"
				/>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="span12">
			<div class="form-row">
				<s:textfield name="requestDetails.amendment.transactionParties.triPartyApplicant.city" 
					id="triPartyAddressCity" 
					key="label.amendment.triPartyApplicantCity" 
					theme="aloc"
				/>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="span12">
			<div class="form-row">
				 <label class="optional"><s:text name="label.amendment.triPartyApplicantState"/> <s:text name="label.request.optional"/></label>
						<s:combobox listKey="stateName" listValue="stateName"
							headerKey="-1" headerValue="Select..."
							list="%{#attr['com.ge.aloc.StaticDataFactory'].stateList}"
							name="requestDetails.amendment.transactionParties.triPartyApplicant.stateProvince"
							id="triPartyAddressState" />
					</div>
		</div>
	</div>
	<div class="row">
		<div class="span12">
			<div class="form-row">
				<s:textfield name="requestDetails.amendment.transactionParties.triPartyApplicant.ZIPPostalCode" 
					id="triPartyAddressZip" 
					key="label.amendment.triPartyApplicantZip" 
					theme="aloc" maxlength="12"/>
				<p class="guidance"><s:text name="label.request.zipCodeGuidance" /></p>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="span12">
			<div class="form-row">
				<s:label key="label.amendment.triPartyApplicantCountry"/>
				<sj:autocompleter id="triPartyAddressCountryCd" list="%{#attr['com.ge.aloc.MasterDataFactory'].countries}" 
				name="requestDetails.amendment.transactionParties.triPartyApplicant.countryCd" 
				cssClass="span3" listKey="countryCode" listValue="countryName" parentTheme="aloc" onChangeTopics="getAutocompleterName"/>
				<s:hidden name="requestDetails.amendment.transactionParties.triPartyApplicant.country" id="triPartyAddressCountry" cssClass="autoCompleterName"></s:hidden>
			</div>
		</div>
	</div>
</s:if>
</c:if>

<s:if test="%{requestDetails.transactionParties.triPartyRequestFlag == null || requestDetails.transactionParties.triPartyRequestFlag == false}">
<h3><s:text name="label.request.applicant"/></h3>
<div class="row">
	<div class="span12">
		<div class="form-row">
			<s:textfield name="requestDetails.amendment.transactionParties.tpApplicantDetails.addressDtls.name" 
				id="applicantAddressName" 
				key="label.amendment.applicantName" 
				theme="aloc"
			/>
		</div>
	</div>
</div>
<div class="row">
	<div class="span12">
		<div class="form-row">
			<s:textfield name="requestDetails.amendment.transactionParties.tpApplicantDetails.addressDtls.address[0]" 
				id="applicantAddress1" 
				key="label.amendment.applicantAddress1" 
				theme="aloc"
			/>
		</div>
	</div>
</div>
<div class="row">
	<div class="span12">
		<div class="form-row">
			<s:textfield name="requestDetails.amendment.transactionParties.tpApplicantDetails.addressDtls.address[1]" 
				id="applicantAddress2" 
				key="label.amendment.applicantAddressOpt" 
				required="false"
				theme="aloc"
			/>
		</div>
	</div>
</div>
<div class="row">
	<div class="span12">
		<div class="form-row">
			<s:textfield name="requestDetails.amendment.transactionParties.tpApplicantDetails.addressDtls.city" 
				id="applicantAddressCity" 
				key="label.amendment.applicantCity" 
				theme="aloc"
			/>
		</div>
	</div>
</div>
<div class="row">
	<div class="span12">
		<div class="form-row">
			<label class="optional"><s:text name="label.amendment.applicantState"/> <s:text name="label.request.optional"/></label>
				<s:combobox listKey="stateName" listValue="stateName" headerKey="-1"
					headerValue="Select..."
					list="%{#attr['com.ge.aloc.StaticDataFactory'].stateList}"
					name="requestDetails.amendment.transactionParties.tpApplicantDetails.addressDtls.stateProvince"
					id="applicantAddressState" />
			</div>
	</div>
</div>
<div class="row">
	<div class="span12">
		<div class="form-row">
			<s:textfield name="requestDetails.amendment.transactionParties.tpApplicantDetails.addressDtls.ZIPPostalCode" 
				id="applicantAddressZip" 
				key="label.amendment.applicantZip" 
				theme="aloc" maxlength="12"/>
			<p class="guidance"><s:text name="label.request.zipCodeGuidance" /></p>
		</div>
	</div>
</div>
<div class="row">
	<div class="span12">
		<div class="form-row">
			<s:label key="label.amendment.applicantCountry"/>
			<sj:autocompleter id="applicantAddressCountryCd" list="%{#attr['com.ge.aloc.MasterDataFactory'].countries}" 
			name="requestDetails.amendment.transactionParties.tpApplicantDetails.addressDtls.countryCd" 
			cssClass="span3" listKey="countryCode" listValue="countryName" parentTheme="aloc" onChangeTopics="getAutocompleterName"/>
			<s:hidden name="requestDetails.amendment.transactionParties.tpApplicantDetails.addressDtls.country" id="applicantAddressCountry" cssClass="autoCompleterName"></s:hidden>
		</div>
	</div>
</div>
</s:if>
<div class="row review lastrow">
	<div class="form-mod lastrow">
		<h3 id="viewLE" class="acc_triggerA">
			<a href="javascript:;"><s:text name="label.amendment.viewLegalEntityDetails"/></a>
		</h3><hr class="h2-hr">
		<div id="viewLEPanel" class="acc_containerA">
			<div class="row smallrow">
				<div class="span22a">
					<div class="form-row">
						<s:label key="label.amendment.legalEntityName"/>
					</div>
				</div>
				<div class="span5 left">
					<div class="form-row">
						<p><s:property value="requestDetails.amendment.transactionParties.tpApplicantDetails.leName"/></p>
					</div>
				</div>
				<!-- end of block -->
			</div>
			<div class="row smallrow">
				<div class="span22a">
					<div class="form-row">
						<s:label key="label.amendment.legalEntityGoldID"/>
					</div>
				</div>
				<div class="span5 left">
					<div class="form-row">
						<p><s:property value="requestDetails.amendment.transactionParties.tpApplicantDetails.leGoldId"/></p>
					</div>
				</div>
				<!-- end of block -->
			</div>
			<div class="row lastrow">
				<div class="span22a">
					<div class="form-row">
						<s:label key="label.amendment.businessContactPerson"/>
					</div>
				</div>
				<div class="span5 left">
					<div class="form-row">
						<s:if test="%{requestDetails.transactionParties.tpApplicantDetails.tpBuContactPerson.ssoId != null && requestDetails.transactionParties.tpApplicantDetails.tpBuContactPerson.ssoId !=''}">
							<p><s:property value="requestDetails.amendment.transactionParties.tpApplicantDetails.tpBuContactPerson.lastName"/>, 
							<s:property value="requestDetails.amendment.transactionParties.tpApplicantDetails.tpBuContactPerson.firstName"/> 
							<s:property value="requestDetails.amendment.transactionParties.tpApplicantDetails.tpBuContactPerson.ssoId"/></p>
						</s:if>
					</div>
				</div>
				<!-- end of block -->
			</div>
		</div>
	</div>
</div>
<div class="clear"><p>&nbsp;</p></div>
<div class="row review">
	<div class="form-mod lastrow">
		<h3 id="geApplRef" class="acc_triggerB">
			<a href="javascript:;"> <s:text name="label.amendment.viewGEApplicantRef"/></a>
		</h3><hr class="h2-hr">
		<div id="geApplRefPanel" class="acc_containerB">
			<s:iterator value="requestDetails.amendment.transactionParties.tpApplicantDetails.refDetails" status="stat">
			<div class="row smallrow">
				<div class="span2">
					<div class="form-row">
						<label>
							<s:text name="label.amendment.geApplRef">
								<s:param><s:property value="#stat.count" /></s:param>
							</s:text> 
						</label>
					</div>
				</div>
				<div class="span5 left">
					<div class="form-row">
						<p class="padding40">
							<s:property value="refValue" />
							<s:hidden name="requestDetails.amendment.transactionParties.tpApplicantDetails.refDetails[%{#stat.index}].refValue"/>
						</p>
					</div>
				</div>
				<!-- end of block -->
			</div>
			</s:iterator>
			
		</div>
	</div>
</div>


<h3><s:text name="label.request.customer" /></h3>
<div class="row">
	<div class="span12">
		<div class="form-row">
			<s:textfield name="requestDetails.amendment.transactionParties.customer.addressDtls.name" 
				id="customerAddressName" 
				key="label.amendment.customerBeneficiaryName" 
				theme="aloc"
			/>
		</div>
	</div>
</div>
<div class="row">
	<div class="span12">
		<div class="form-row">
			<s:textfield name="requestDetails.amendment.transactionParties.customer.addressDtls.address[0]" 
				id="customerAddress1" 
				key="label.amendment.customerBeneficiaryAddress1" 
				theme="aloc"
			/>
		</div>
	</div>
</div>
<div class="row">
	<div class="span12">
		<div class="form-row">
			<s:textfield name="requestDetails.amendment.transactionParties.customer.addressDtls.address[1]" 
				id="customerAddress2" 
				key="label.amendment.customerBeneficiaryAddressOpt" 
				required="false"
				theme="aloc"
			/>
		</div>
	</div>
</div>
<div class="row">
	<div class="span12">
		<div class="form-row">
			<s:textfield name="requestDetails.amendment.transactionParties.customer.addressDtls.city" 
				id="customerAddressCity" 
				key="label.amendment.customerBeneficiaryCity" 
				theme="aloc"
			/>
		</div>
	</div>
</div>
<div class="row">
	<div class="span12">
		<div class="form-row">
			 <label class="optional"><s:text name="label.amendment.customerBeneficiaryState"/> <s:text name="label.request.optional"/></label>
				<s:combobox listKey="stateName" listValue="stateName" headerKey="-1"
					headerValue="Select..."
					list="%{#attr['com.ge.aloc.StaticDataFactory'].stateList}"
					name="requestDetails.amendment.transactionParties.customer.addressDtls.stateProvince"
					id="customerAddressState" />
			</div>
	</div>
</div>
<div class="row">
	<div class="span12">
		<div class="form-row">
			<s:textfield name="requestDetails.amendment.transactionParties.customer.addressDtls.ZIPPostalCode" 
				id="customerAddressZip" 
				key="label.amendment.customerBeneficiaryZip" 
				theme="aloc" maxlength="12"/>
			<p class="guidance"><s:text name="label.request.zipCodeGuidance" /></p>
		</div>
	</div>
</div>
<div class="row">
	<div class="span12">
		<div class="form-row">
			<s:label key="label.amendment.customerBeneficiaryCountry"/>
			<sj:autocompleter id="customerAddressCountryCd" list="%{#attr['com.ge.aloc.MasterDataFactory'].countries}" 
			name="requestDetails.amendment.transactionParties.customer.addressDtls.countryCd" 
			cssClass="span3" listKey="countryCode" listValue="countryName" parentTheme="aloc" onChangeTopics="getAutocompleterName"/>
			<s:hidden name="requestDetails.amendment.transactionParties.customer.addressDtls.country" id="customerAddressCountry" cssClass="autoCompleterName"></s:hidden>
		</div>
	</div>
</div>

<div class="row review">
	<div class="form-mod lastrow">
		<h3 id="geCustRef" class="acc_triggerC">
			<a href="javascript:;"><s:text name="label.amendment.viewGECustomerRef" /></a>
		</h3><hr class="h2-hr">
		<div id="geCustRef" class="acc_containerC">
			<s:iterator value="requestDetails.amendment.transactionParties.customer.refDetails" status="stat">
			<div class="row smallrow">
				<div class="span3">
					<div class="form-row">
						<label>
							<s:text name="label.amendment.geCustRef">
								<s:param><s:property value="#stat.count" /></s:param>
							</s:text>
						</label> 
					</div>
				</div>
				<div class="span5 left">
					<div class="form-row">
						<p>
							<s:property value="refValue" />
							<s:hidden name="requestDetails.amendment.transactionParties.customer.refDetails[%{#stat.index}].refValue"/>
						</p>
					</div>
				</div>
				<!-- end of block -->
			</div>
			</s:iterator>
			
		</div>
	</div>
</div>
</s:if>