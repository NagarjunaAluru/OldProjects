<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>

<s:set name="isEditMode" value="editMode"/>
	<s:if test="%{#isEditMode==true}">
		<c:if test="${param.pageSection == 'Current'}">
			<div class="row">
				<div class="span2a">
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
				<div class="span2a">
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
				<div class="span3">
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
				<div class="span2a">
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
				<div class="span3">
					<div class="form-row">
						<label class="optional"><s:text name="label.amendment.customerBeneficiaryState"/> <s:text name="label.request.optional"/></label>
							<s:combobox listKey="stateName" listValue="stateName" headerKey="-1" headerValue="Select..." list="%{#attr['com.ge.aloc.StaticDataFactory'].stateList}"
								name="requestDetails.amendment.transactionParties.customer.addressDtls.stateProvince" id="customerAddressState" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="span3">
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
				<div class="span2a">
					<div class="form-row">
						<s:label key="label.amendment.customerBeneficiaryCountry"/>
						<sj:autocompleter id="customerAddressCountryCd" list="%{#attr['com.ge.aloc.MasterDataFactory'].countries}" 
						name="requestDetails.amendment.transactionParties.customer.addressDtls.countryCd" 
						cssClass="span3" listKey="countryCode" listValue="countryName" parentTheme="aloc" onChangeTopics="getAutocompleterName"/>
						<s:hidden name="requestDetails.amendment.transactionParties.customer.addressDtls.country" 
						id="customerAddressCountry" cssClass="autoCompleterName"></s:hidden>
					</div>
				</div>
			</div>
		<c:if test="${param.subsectionId eq 'amendment.treasuryAnalyst.review.section'}">
			<jsp:include page="/jsp/common/request/amendment/amendmentCustBenRefDetails.jsp">
				<jsp:param value="TreasuryAnalyst" name="pageType"/>
			</jsp:include>
		</c:if>
		</c:if>
		<c:if test="${param.pageSection == 'Previous'}">
			<div class="row">
				<div class="span2a">
					<div class="form-row">
						<label>Customer/Beneficiary name/address:</label>
					</div>
				</div>
				<div class="span2 left">
					<div class="form-row">
						<p><s:property value="requestDetails.previousAmendment.transactionParties.customer.addressDtls.name" /></p>
						<s:iterator value="requestDetails.previousAmendment.transactionParties.customer.addressDtls.address">
							<p><s:property /></p>
						</s:iterator>
						<p><s:property value="requestDetails.previousAmendment.transactionParties.customer.addressDtls.city" />
						<s:property value="requestDetails.previousAmendment.transactionParties.customer.addressDtls.stateProvince" />
						<s:property	value="requestDetails.previousAmendment.transactionParties.customer.addressDtls.ZIPPostalCode" /></p>
						<p><s:property value="requestDetails.previousAmendment.transactionParties.customer.addressDtls.country" /></p>
					</div>
				</div>
			</div>
		</c:if>
		
	</s:if>
		
	<s:elseif test="%{#isEditMode==false}" >
		<c:if test="${param.pageSection == 'Current'}">
			<div class="row">
				<div class="span2a">
					<div class="form-row">
						<label>Customer/Beneficiary name/address:</label>
					</div>
				</div>
				<div class="span2 left">
					<div class="form-row">
						<p><s:property value="requestDetails.amendment.transactionParties.customer.addressDtls.name" /></p>
						<s:iterator value="requestDetails.amendment.transactionParties.customer.addressDtls.address">
							<p><s:property /></p>
						</s:iterator>
						<p><s:property value="requestDetails.amendment.transactionParties.customer.addressDtls.city" />
						<s:property value="requestDetails.amendment.transactionParties.customer.addressDtls.stateProvince" />
						<s:property	value="requestDetails.amendment.transactionParties.customer.addressDtls.ZIPPostalCode" /></p>
						<p><s:property value="requestDetails.amendment.transactionParties.customer.addressDtls.country" /></p>
						
						<s:hidden name="requestDetails.amendment.transactionParties.customer.addressDtls.address[0]" id="customerAddress1" />
						<s:hidden name="requestDetails.amendment.transactionParties.customer.addressDtls.address[1]" id="customerAddress2" />
						<s:hidden name="requestDetails.amendment.transactionParties.customer.addressDtls.city" id="customerAddressCity"/>
						<s:hidden name="requestDetails.amendment.transactionParties.customer.addressDtls.stateProvinceCd" id="customerAddressStateCd"/>
						<s:hidden name="requestDetails.amendment.transactionParties.customer.addressDtls.stateProvince" id="customerAddressState" />
						<s:hidden name="requestDetails.amendment.transactionParties.customer.addressDtls.ZIPPostalCode" id="customerAddressZip"/>
						<s:hidden name="requestDetails.amendment.transactionParties.customer.addressDtls.countryCd" id="customerAddressCountryCd"/>
						<s:hidden name="requestDetails.amendment.transactionParties.customer.addressDtls.country" id="customerAddressCountry" />
					</div>
				</div>
			</div>
			<c:if test="${param.subsectionId eq 'amendment.treasuryAnalyst.review.section'}">
			<jsp:include page="/jsp/common/request/amendment/amendmentCustBenRefDetails.jsp">
			<jsp:param value="TreasuryAnalyst" name="pageType"/>
			</jsp:include>
		</c:if>
		</c:if>
		<c:if test="${param.pageSection == 'Previous'}">
			<div class="row">
				<div class="span2a">
					<div class="form-row">
						<label>Customer/Beneficiary name/address:</label>
					</div>
				</div>
				<div class="span2 left">
					<div class="form-row">
						<p><s:property value="requestDetails.previousAmendment.transactionParties.customer.addressDtls.name" /></p>
						<s:iterator value="requestDetails.previousAmendment.transactionParties.customer.addressDtls.address">
							<p><s:property /></p>
						</s:iterator>
						<p><s:property value="requestDetails.previousAmendment.transactionParties.customer.addressDtls.city" />
						<s:property value="requestDetails.previousAmendment.transactionParties.customer.addressDtls.stateProvince" />
						<s:property	value="requestDetails.previousAmendment.transactionParties.customer.addressDtls.ZIPPostalCode" /></p>
						<p><s:property value="requestDetails.previousAmendment.transactionParties.customer.addressDtls.country" /></p>
					</div>
				</div>
			</div>
		</c:if>
		
	</s:elseif>
	