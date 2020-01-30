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
				<div class="span3">
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
				<div class="span3">
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
				<div class="span3">
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
				<div class="span3">
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
				<div class="span3">
					<div class="form-row">
						<label class="optional"><s:text name="label.amendment.applicantState"/> <s:text name="label.request.optional"/></label>
							<s:combobox listKey="stateName" listValue="stateName" headerKey="-1" headerValue="Select..." list="%{#attr['com.ge.aloc.StaticDataFactory'].stateList}"
								name="requestDetails.amendment.transactionParties.tpApplicantDetails.addressDtls.stateProvince" id="applicantAddressState" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="span3">
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
				<div class="span3">
					<div class="form-row">
						<s:label key="label.amendment.applicantCountry"/>
						<sj:autocompleter id="applicantAddressCountryCd" list="%{#attr['com.ge.aloc.MasterDataFactory'].countries}" 
						name="requestDetails.amendment.transactionParties.tpApplicantDetails.addressDtls.countryCd" 
						cssClass="span3" listKey="countryCode" listValue="countryName" parentTheme="aloc" onChangeTopics="getAutocompleterName"/>
						<s:hidden name="requestDetails.amendment.transactionParties.tpApplicantDetails.addressDtls.country" 
						id="applicantAddressCountry" cssClass="autoCompleterName"></s:hidden>
					</div>
				</div>
			</div>
			<jsp:include page="/jsp/common/request/amendment/amendmentLEDetails.jsp">
				<jsp:param value="TreasuryAnalyst" name="pageType"/>
			</jsp:include>
			<jsp:include page="/jsp/common/request/amendment/amendmentGERefDetails.jsp">
				<jsp:param value="TreasuryAnalyst" name="pageType"/>
			</jsp:include>
		</c:if>
		<c:if test="${param.pageSection == 'Previous'}">
			<div class="row">
				<div class="span2a">
					<div class="form-row">
						<label>Applicant name/address:</label>
					</div>
				</div>
				<div class="span2 left">
					<div class="form-row">
						<p><s:property value="requestDetails.previousAmendment.transactionParties.tpApplicantDetails.addressDtls.name" /></p>
						<s:iterator value="requestDetails.previousAmendment.transactionParties.tpApplicantDetails.addressDtls.address">
							<p><s:property /></p>
						</s:iterator>
						<p><s:property value="requestDetails.previousAmendment.transactionParties.tpApplicantDetails.addressDtls.city" />
						<s:property value="requestDetails.previousAmendment.transactionParties.tpApplicantDetails.addressDtls.stateProvince" />
						<s:property	value="requestDetails.previousAmendment.transactionParties.tpApplicantDetails.addressDtls.ZIPPostalCode" /></p>
						<p><s:property value="requestDetails.previousAmendment.transactionParties.tpApplicantDetails.addressDtls.country" /></p>
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
						<label>Applicant name/address:</label>
					</div>
				</div>
				<div class="span2 left">
					<div class="form-row">
						<p><s:property value="requestDetails.amendment.transactionParties.tpApplicantDetails.addressDtls.name" /></p>
						<s:iterator value="requestDetails.amendment.transactionParties.tpApplicantDetails.addressDtls.address">
							<p><s:property /></p>
						</s:iterator>
						<p><s:property value="requestDetails.amendment.transactionParties.tpApplicantDetails.addressDtls.city" />
						<s:property value="requestDetails.amendment.transactionParties.tpApplicantDetails.addressDtls.stateProvince" />
						<s:property	value="requestDetails.amendment.transactionParties.tpApplicantDetails.addressDtls.ZIPPostalCode" /></p>
						<p><s:property value="requestDetails.amendment.transactionParties.tpApplicantDetails.addressDtls.country" /></p>
						
						<s:hidden name="requestDetails.amendment.transactionParties.tpApplicantDetails.addressDtls.address[0]" id="applicantAddress1" />
						<s:hidden name="requestDetails.amendment.transactionParties.tpApplicantDetails.addressDtls.address[1]" id="applicantAddress2" />
						<s:hidden name="requestDetails.amendment.transactionParties.tpApplicantDetails.addressDtls.city" id="applicantAddressCity"/>
						<s:hidden name="requestDetails.amendment.transactionParties.tpApplicantDetails.addressDtls.stateProvinceCd" id="applicantAddressStateCd"/>
						<s:hidden name="requestDetails.amendment.transactionParties.tpApplicantDetails.addressDtls.stateProvince" id="applicantAddressState" />
						<s:hidden name="requestDetails.amendment.transactionParties.tpApplicantDetails.addressDtls.ZIPPostalCode" id="applicantAddressZip"/>
						<s:hidden name="requestDetails.amendment.transactionParties.tpApplicantDetails.addressDtls.countryCd" id="applicantAddressCountryCd"/>
						<s:hidden name="requestDetails.amendment.transactionParties.tpApplicantDetails.addressDtls.country" id="applicantAddressCountry" />
					</div>
				</div>
			</div>
			<jsp:include page="/jsp/common/request/amendment/amendmentLEDetails.jsp">
				<jsp:param value="TreasuryAnalyst" name="pageType"/>
			</jsp:include>
			<jsp:include page="/jsp/common/request/amendment/amendmentGERefDetails.jsp">
				<jsp:param value="TreasuryAnalyst" name="pageType"/>
			</jsp:include>
		</c:if>
		<c:if test="${param.pageSection == 'Previous'}">
			<div class="row">
				<div class="span2a">
					<div class="form-row">
						<label>Applicant name/address:</label>
					</div>
				</div>
				<div class="span2 left">
					<div class="form-row">
						<p><s:property value="requestDetails.previousAmendment.transactionParties.tpApplicantDetails.addressDtls.name" /></p>
						<s:iterator value="requestDetails.previousAmendment.transactionParties.tpApplicantDetails.addressDtls.address">
							<p><s:property /></p>
						</s:iterator>
						<p><s:property value="requestDetails.previousAmendment.transactionParties.tpApplicantDetails.addressDtls.city" />
						<s:property value="requestDetails.previousAmendment.transactionParties.tpApplicantDetails.addressDtls.stateProvince" />
						<s:property	value="requestDetails.previousAmendment.transactionParties.tpApplicantDetails.addressDtls.ZIPPostalCode" /></p>
						<p><s:property value="requestDetails.previousAmendment.transactionParties.tpApplicantDetails.addressDtls.country" /></p>
					</div>
				</div>
			</div>
		</c:if>	
	</s:elseif>	
