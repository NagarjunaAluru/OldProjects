<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<s:set name="isEditMode" value="editMode"/>
<s:if test="%{#isEditMode==true}">
<c:if test="${param.includeScripts != false}">
<script	type="text/javascript">
$(document).ready(function() {
	decCounter("specialInst", 400);
	deliveryTypeOnloadShow();
	
});

</script>
</c:if>	



<p class="required-fields"><s:text name="label.request.common.requiredFieldsUnlessSpecified"/></p>
<c:if test="${param.pageSection == 'Current'}">
<div class="row" id="deliveryDesignationDiv">
	<div class="span12">
		<div class="form-row">
			<s:label key="label.request.deliveryDesignationSWIFT"></s:label>
			<s:radio theme="aloc" cssClass="radio"
				name="requestDetails.amendment.deliveryInstructions.deliveryDesignationFlag"
				list="#{'Applicant':'Applicant','Beneficiary':'Beneficiary', 'OtherParty':'Other party'}"
				value="%{requestDetails.amendment.deliveryInstructions.deliveryDesignationFlag}"
				id="deliveryDesignationFlag" />
		</div>

	</div>

</div>
<div class="row">
	<div class="span12">
		<div class="span12" style="margin-left : 1px;">
			<s:label key="label.request.deliverType" />
			<s:radio theme="aloc" cssClass="radio"
				name="requestDetails.amendment.deliveryInstructions.deliveryType"
				list="#{'true':'In-person pick-up','false':'Physical delivery (via courier or certified post)'}"
				value="%{requestDetails.amendment.deliveryInstructions.deliveryType}"
				id="deliveryType" />

		</div>
		<br/><label class="right"><span style="margin-left: -820px; margin-top: 2px;" class="ttip info" data-original-title="<s:text name="label.request.tooltip.inpersonPickup"/>"></span></label><br/>
		<label class="right"><span style="margin-left: -680px; margin-top: 2px;" class="ttip info" data-original-title="<s:text name="label.request.tooltip.physicalDelivery"/>"></span></label>
	</div>
	<!-- end of block -->
</div>

<div id="pDelivery" class="row hide">
	<div class="span12">
		<div class="row">
			<div class="span12">
				<div class="form-row">
					<s:textfield name="requestDetails.amendment.deliveryInstructions.address1"
						key="label.request.address1" id="address1" required="true"
						theme="aloc" />
				</div>
			</div>
		</div>
		<div class="row">
			<div class="span12">
				<div class="form-row">
					<s:textfield name="requestDetails.amendment.deliveryInstructions.address2"
						id="address2" key="label.request.common.address2opt"
						required="false" theme="aloc" />
				</div>
			</div>
		</div>
		<div class="row">
			<div class="span12">
				<div class="form-row">
					<s:textfield name="requestDetails.amendment.deliveryInstructions.city"
						key="label.request.city" id="city" required="true" theme="aloc" />
				</div>
			</div>
		</div>
		<div class="row">
			<div class="span12">
				<div class="form-row">
					 <label class="optional"><s:text name="label.request.stateOrProvince"/> <s:text name="label.request.optional"/></label>
							<s:combobox listKey="stateName" listValue="stateName"
								headerKey="-1" headerValue="Select..."
								list="%{#attr['com.ge.aloc.StaticDataFactory'].stateList}"
								name="requestDetails.amendment.deliveryInstructions.stateProvince"
								id="deliveryAddressState" cssClass="comboDeliveryState"/>
						</div>
			</div>
		</div>
		<div class="row">
			<div class="span12">
				<div class="form-row">
					<s:textfield
						name="requestDetails.amendment.deliveryInstructions.ZIPPostalcode"
						key="label.request.zipOrPostalCode" id="zipPostalcode"
						required="true" theme="aloc" maxlength="12"/>
					<p class="guidance"><s:text name="label.request.zipCodeGuidance" /></p>
				</div>
			</div>
		</div>
		<div class="row smallrow">
			<div class="span12">
				<div class="form-row">
					<s:label key="label.request.country" />
					<sj:autocompleter
						list="%{#attr['com.ge.aloc.MasterDataFactory'].countries}"
						onChangeTopics="getAutocompleterName" id="countryCode"
						name="requestDetails.amendment.deliveryInstructions.countryCd"
						cssClass="span3" listKey="countryCode" listValue="countryName"
						parentTheme="aloc" />
					<s:hidden name="requestDetails.amendment.deliveryInstructions.country"
						id="deliveryAddresscountry" cssClass="autoCompleterName"></s:hidden>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="row">
	<div class="span12">
		<div class="form-row">
			<s:label key="label.request.companyName" />
			<s:textfield name="requestDetails.amendment.deliveryInstructions.companyName"
				id="companyName" />
		</div>
	</div>
</div>
<div class="row">
	<div class="span12">
		<div class="form-row">
			<label>Recipient's first name</label>
			<s:textfield name="requestDetails.amendment.deliveryInstructions.firstName"
				id="firstName" />
			<p class="guidance">
				Given name
			</p>
		</div>
	</div>
</div>
<div class="row">
	<div class="span12">
		<div class="form-row">
			<label>Recipient's last name</label>
			<s:textfield name="requestDetails.amendment.deliveryInstructions.lastName"
				id="lastName" />
			<p class="guidance">
				Surname
			</p>
		</div>
	</div>
</div>
<div class="row">
	<div class="span12">
		<div class="form-row">
			<s:textfield name="requestDetails.amendment.deliveryInstructions.title"
				id="title" key="label.request.titleOptional" required="false"
				theme="aloc" />
		</div>
	</div>
	<!-- end of block -->
</div>

<div class="row">
	<div class="span12">
		<div class="form-row">
			<s:textfield name="requestDetails.amendment.deliveryInstructions.phoneNo"
				id="phoneNumber" key="label.request.phoneNumber" theme="aloc" maxlength="20"/>
			<p class="guidance">
				Include country and area code
			</p>
		</div>
	</div>
</div>
<div class="row">
	<div class="span12">
		<div class="form-row">
			<s:textarea cssClass="autosize messageinput" cols="50" rows="1"
				name="requestDetails.amendment.deliveryInstructions.specialInstructions"
				key="label.request.specialInstructions" theme="aloc"
				id="specialInst" required="false" onkeypress="return imposeMaxLength(this, 399);">
			</s:textarea>
			<div class="clear"></div>
			<div class="counter">
				<s:text name="label.common.siteAdmin.fourHundred" />
			</div>
			<!-- fix positions -->
			<div class="counterTxt">
				<p class="guidance">
					<s:text name="label.common.siteAdmin.limit400Characters" />
				</p>
			</div>
		</div>
		<!-- end of block -->
	</div>
</div>

<div class="row">
	<div class="span12">
		<div class="form-row ckeckBoxLabel">
			<label><s:text name="label.request.additionalDelivery" />:</label> <label
				class="checkbox"> <s:checkbox
					name="requestDetails.amendment.deliveryInstructions.ecopyMyself"></s:checkbox>
			</label> 
			<s:text name="label.request.sendElectronicCopyToMyself" />
			<label class="checkbox"> <s:checkbox
					name="requestDetails.amendment.deliveryInstructions.ecopyOtherGEPerson"
					id="sendElectronic"></s:checkbox>
			</label>
			<s:text name="label.request.sendElectronicCopyToOtherGERecipient" />
		</div>
	</div>
</div>

<div class="row hide" id="Recipient">
	<c:if
		test="${not requestDetails.amendment.deliveryInstructions.ecopyOtherGEPerson and empty requestDetails.amendment.deliveryInstructions.recipient.recipientSsoId}">
		<c:set var="RecipientShowClass" value="display: none;" />
		<c:set var="RecipientClearStyle" value="display: none;" />
	</c:if>
	<c:if
		test="${requestDetails.amendment.deliveryInstructions.ecopyOtherGEPerson and not empty requestDetails.amendment.deliveryInstructions.recipient.recipientSsoId}">
		<c:set var="RecipientShowClass" value="display: block;" />
		<c:set var="RecipientShowClearStyle" value="display: inline;" />
		<s:set var="recipientidSelected" value="%{'Selected'}"></s:set>
	</c:if>
	<div class="form-row">
		<div class="span3">
			<s:textfield name="geRecipient" id="geRecipient" required="false"
				key="label.request.geRecipient" theme="aloc" cssClass="span3 lookup-filterValue" />
				<s:hidden name="businessContactName" value="BUC" cssClass="businessContactClass"></s:hidden>
				<p class="guidance"><s:text name="label.request.partialLastName" /></p>
				<span class="lookup-error hide" style="color: #AE2C2C;"></span>
		</div>
		<div class="span3">	
			<label>&nbsp;</label>
			<s:url action="GEReferenceLookup" namespace="/int" var="getRecipientURL" escapeAmp="false">
			</s:url>
			<a class="btn-secondary lookup" href="<s:property value="#getRecipientURL"/>"><s:text name="label.request.common.lookup" /></a> 
			<img alt="Loading..." id="recipientIndicator" class="indicator" 
			src="${pageContext.request.contextPath}/img/loading.gif" style="height: 20px; display: none">
		</div>
	</div>
</div>

<div class="conditional-row hide" id="recipientShow" style="${RecipientShowClass}">
<s:hidden name="recipientSelection" id="recipientSelectionId" value="%{#recipientidSelected}"></s:hidden>
	<div class="row">
		<div class="span7">
			<div class="row">
				<div class="span2">
					<div class="form-row">
						<label><s:text name="label.request.recipient" /></label>
					</div>
				</div>
				<div class="span4 right">
					<div class="form-row">
					<s:if test="%{requestDetails.amendment.deliveryInstructions.recipient.recipientSsoId != null && requestDetails.amendment.deliveryInstructions.recipient.recipientSsoId != ''}">
						<p>
							<s:property	value="requestDetails.amendment.deliveryInstructions.recipient.recipientLastName" />
							, <s:property value="requestDetails.amendment.deliveryInstructions.recipient.recipientFirstName" />
							- <s:property value="requestDetails.amendment.deliveryInstructions.recipient.recipientSsoId" />
						</p>
					</s:if>
						
						<s:hidden
							name="requestDetails.amendment.deliveryInstructions.recipient.recipientLastName"
							id="recipientLastName"></s:hidden>
						<s:hidden
							name="requestDetails.amendment.deliveryInstructions.recipient.recipientFirstName"
							id="recipientFirstName"></s:hidden>
						<s:hidden
							name="requestDetails.amendment.deliveryInstructions.recipient.recipientSsoId"
							id="recipientSsoId"></s:hidden>
					</div>
				</div>
				<!-- end of block -->
			</div>
			<div class="row">
				<div class="span2">
					<div class="form-row">
						<label><s:text name="label.request.geRecipientEmail" /></label>
					</div>
				</div>
				<!-- end of block -->
				<div class="span4 right">
					<div class="form-row">
						<p>
							<s:property
								value="requestDetails.amendment.deliveryInstructions.recipient.recipientEmail" />
						</p>

						<s:hidden
							name="requestDetails.amendment.deliveryInstructions.recipient.recipientEmail"
							id="recipientEmail"></s:hidden>
					</div>
				</div>
			</div>
		</div>

	</div>
</div>
</c:if>
<c:if test="${param.pageSection == 'Previous'}">
	<jsp:include page="/jsp/common/request/amendment/amendmentDeliveryInstructions.jsp" >
		<jsp:param name="pageSection" value="Previous" />
	</jsp:include>
</c:if>
</s:if>
<s:elseif test="%{#isEditMode==false}" >
<c:if test="${param.pageSection == 'Current'}">
	<jsp:include page="/jsp/common/request/amendment/amendmentDeliveryInstructions.jsp" >
		<jsp:param name="pageSection" value="Current" />
	</jsp:include>
</c:if>
<c:if test="${param.pageSection == 'Previous'}">
	<jsp:include page="/jsp/common/request/amendment/amendmentDeliveryInstructions.jsp" >
		<jsp:param name="pageSection" value="Previous" />
	</jsp:include>
</c:if>
</s:elseif>