<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>

<s:set name="isEditMode" value="editMode" />
<s:if test="%{#isEditMode==true}">
	<c:if test="${param.pageSection == 'Current'}">
		<div class="row">
			<div class="span2a">
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
			<div class="span2a">
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
			<div class="span3">
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
			<div class="span2a">
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
			<div class="span3">
				<div class="form-row">
					<label class="optional"><s:text name="label.amendment.triPartyApplicantState"/> <s:text name="label.request.optional"/></label>
							<s:combobox listKey="stateName" listValue="stateName" headerKey="-1" headerValue="Select..." list="%{#attr['com.ge.aloc.StaticDataFactory'].stateList}"
								name="requestDetails.amendment.transactionParties.triPartyApplicant.stateProvince" id="triPartyAddressState" />
				</div>
			</div>
		</div>
		<div class="row">
			<div class="span3">
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
			<div class="span2a">
				<div class="form-row">
					<s:label key="label.amendment.triPartyApplicantCountry"/>
					<sj:autocompleter id="triPartyAddressCountryCd" list="%{#attr['com.ge.aloc.MasterDataFactory'].countries}" 
					name="requestDetails.amendment.transactionParties.triPartyApplicant.countryCd" 
					cssClass="span3" listKey="countryCode" listValue="countryName" theme="aloc" onChangeTopics="getAutocompleterName"/>
					<s:hidden name="requestDetails.amendment.transactionParties.triPartyApplicant.country" 
					id="triPartyAddressCountry" cssClass="autoCompleterName"></s:hidden>
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
					<label><s:text name="label.request.triPartyname" /></label>
				</div>
			</div>
			<div class="span2 left">
				<div class="form-row">
					<s:property
						value="requestDetails.previousAmendment.transactionParties.triPartyApplicant.name" />
					<br />
					<s:iterator
						value="requestDetails.previousAmendment.transactionParties.triPartyApplicant.address">
						<s:property />
						<br />
					</s:iterator>

					<s:property
						value="requestDetails.previousAmendment.transactionParties.triPartyApplicant.city" />
					<s:property
						value="requestDetails.previousAmendment.transactionParties.triPartyApplicant.stateProvince" />
					<s:property
						value="requestDetails.previousAmendment.transactionParties.triPartyApplicant.ZIPPostalCode" />
					<br />
					<s:property
						value="requestDetails.previousAmendment.transactionParties.triPartyApplicant.country" />

				</div>
			</div>
		</div>
	</c:if>
</s:if>
<s:elseif test="%{#isEditMode==false}">
	<c:if test="${param.pageSection == 'Current'}">
		<div class="row">
			<div class="span2a ">
				<div class="form-row">
					<label><s:text name="label.request.triPartyname" /></label>
				</div>
			</div>
			<div class="span2 left">
				<div class="form-row">
					<s:property
						value="requestDetails.amendment.transactionParties.triPartyApplicant.name" />
					<br />
					<s:iterator
						value="requestDetails.amendment.transactionParties.triPartyApplicant.address">
						<s:property />
						<br />
					</s:iterator>

					<s:property
						value="requestDetails.amendment.transactionParties.triPartyApplicant.city" />
					<s:property
						value="requestDetails.amendment.transactionParties.triPartyApplicant.stateProvince" />
					<s:property
						value="requestDetails.amendment.transactionParties.triPartyApplicant.ZIPPostalCode" />
					<br />
					<s:property
						value="requestDetails.amendment.transactionParties.triPartyApplicant.country" />
						
						<s:hidden name="requestDetails.amendment.transactionParties.triPartyApplicant.address[0]" id="triPartyAddress1" />
						<s:hidden name="requestDetails.amendment.transactionParties.triPartyApplicant.address[1]" id="triPartyAddress2" />
						<s:hidden name="requestDetails.amendment.transactionParties.triPartyApplicant.city" id="triPartyAddressCity"/>
						<s:hidden name="requestDetails.amendment.transactionParties.triPartyApplicant.stateProvinceCd" id="triPartyAddressStateCd"/>
						<s:hidden name="requestDetails.amendment.transactionParties.triPartyApplicant.stateProvince" id="triPartyAddressState" />
						<s:hidden name="requestDetails.amendment.transactionParties.triPartyApplicant.ZIPPostalCode" id="triPartyAddressZip"/>
						<s:hidden name="requestDetails.amendment.transactionParties.triPartyApplicant.countryCd" id="triPartyAddressCountryCd"/>
						<s:hidden name="requestDetails.amendment.transactionParties.triPartyApplicant.country" id="triPartyAddressCountry" />
				</div>
			</div>
		</div>
		<jsp:include page="/jsp/common/request/amendment/amendmentLEDetails.jsp">
				<jsp:param value="TreasuryAnalyst" name="pageType"/>
			</jsp:include>
			<jsp:include page="/jsp/common/request/amendment/amendmentGERefDetails.jsp">
				<jsp:param value="TreasuryAnalyst" name="pageType"/>
			</jsp:include>
		<!-- row ends here -->
	</c:if>
	<c:if test="${param.pageSection == 'Previous'}">
		<div class="row">
			<div class="span2a">
				<div class="form-row">
					<label><s:text name="label.request.triPartyname" /></label>
				</div>
			</div>
			<div class="span2 left">
				<div class="form-row">
					<s:property
						value="requestDetails.previousAmendment.transactionParties.triPartyApplicant.name" />
					<br />
					<s:iterator
						value="requestDetails.previousAmendment.transactionParties.triPartyApplicant.address">
						<s:property />
						<br />
					</s:iterator>

					<s:property
						value="requestDetails.previousAmendment.transactionParties.triPartyApplicant.city" />
					<s:property
						value="requestDetails.previousAmendment.transactionParties.triPartyApplicant.stateProvince" />
					<s:property
						value="requestDetails.previousAmendment.transactionParties.triPartyApplicant.ZIPPostalCode" />
					<br />
					<s:property
						value="requestDetails.previousAmendment.transactionParties.triPartyApplicant.country" />

				</div>
			</div>
		</div>
	</c:if>
</s:elseif>
