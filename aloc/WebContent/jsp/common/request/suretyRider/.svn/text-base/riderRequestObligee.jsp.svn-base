<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<s:set name="isEditMode" value="editMode" />
	<div class="row">
		<s:if test="%{obligeeAddressSelection == null}">
			<s:if
				test="%{requestDetails.rider.obligee == null || 
					          requestDetails.rider.obligee.addressDtls == null || 
					 			((requestDetails.rider.obligee.addressDtls.name == null || requestDetails.rider.obligee.addressDtls.name == '' ) &&
								(requestDetails.rider.obligee.addressDtls.city == null || requestDetails.rider.obligee.addressDtls.city == '') &&
								(requestDetails.rider.obligee.addressDtls.stateProvince == null || requestDetails.rider.obligee.addressDtls.stateProvince == '' ) &&
								(requestDetails.rider.obligee.addressDtls.ZIPPostalCode == null || requestDetails.rider.obligee.addressDtls.ZIPPostalCode == '' ) &&
								(requestDetails.rider.obligee.addressDtls.country == null || requestDetails.rider.obligee.addressDtls.country == ''))}">

				<s:set var="ObligeeNameSelected" value="%{obligeeAddressSelection}" />
			</s:if>
			<s:else>
				<s:set var="ObligeeNameSelected" value="%{'Selected'}"></s:set>
			</s:else>
		</s:if>
		<s:else>
			<s:set var="ObligeeNameSelected" value="%{obligeeAddressSelection}" />
		</s:else>

		<s:if test="%{#ObligeeNameSelected == 'Selected'}">
			<c:set var="ObligeeDetailsClass" value="display: block;" />
		</s:if>
		<s:else>
			<c:set var="ObligeeDetailsClass" value="display: none;" />
		</s:else>
		<div class="span12">
			<div class="form-row">
				<s:label key="label.request.common.nameAddress" />
				<s:textfield name="nameForAddress"
					cssClass="span3 lookup-filterValue" id="obligeeNameAddressId" />
					<p class="guidance"><s:text name="label.request.nameAddressGuidance" /></p>
					<s:hidden name="obligeeNameAddressValue" value="yes" cssClass="nameAddressClass"></s:hidden>
				<s:url action="NameAddressLookup" namespace="/int"
					var="getObligeeNameAddressURL" escapeAmp="false" encode="true">
					<s:param name="addressTypeId">5</s:param>
					<s:param name="addressIndex">0</s:param>
				</s:url>
				<a class="btn-secondary lookup"
					href="<s:property value="#getObligeeNameAddressURL"/>"><s:text
						name="label.request.common.lookup" /></a> <img alt="Loading..."
					id="obligeeAddressIndicator" class="indicator"
					src="${pageContext.request.contextPath}/img/loading.gif"
					style="height: 20px; display: none"><br /> <span class="lookup-error hide"
					style="color: #AE2C2C;"></span>
			</div>
		</div>
		<!-- end of block -->
	</div>
	<div class="lastrow" id="ObligeeShow" style="${ObligeeDetailsClass}">
		<s:hidden name="obligeeAddressSelection"
			id="obligeeAddressSelectionId" value="%{#ObligeeNameSelected}"></s:hidden>
		<div class="row">
			<div class="span7">
				<div class="row">
					<div class="span2">
						<div class="form-row">
							<s:label key="label.request.common.name" />
						</div>
					</div>
					<div class="span4 left">
						<div class="form-row" id="obligeeName">
							<p>
								<s:property
									value="requestDetails.rider.obligee.addressDtls.name" />
							</p>
						</div>
					</div>
					<!-- end of block -->
				</div>
				<div class="row">
					<div class="span2">
						<div class="form-row">
							<s:label key="label.request.address" />
						</div>
					</div>
					<!-- end of block -->
					<div class="span4 left">
						<div class="form-row" id="obligeeAddress">
							<s:iterator
								value="requestDetails.rider.obligee.addressDtls.address">
								<p>
									<s:property />
								</p>
							</s:iterator>
							<p>
								<s:property
									value="requestDetails.rider.obligee.addressDtls.city" />
								<s:property
									value="requestDetails.rider.obligee.addressDtls.stateProvince" />
								<s:property
									value="requestDetails.rider.obligee.addressDtls.ZIPPostalCode" />
							</p>
							<p>
								<s:property
									value="requestDetails.rider.obligee.addressDtls.country" />
							</p>
						</div>
					</div>
				</div>
			</div>
			<!-- end of block -->
		</div>
	</div>
	<div class="conditional-row-manually" id="ObligeeShowManually">
		<div class="row">
			<div class="span12">
				<div class="form-row">
					<s:textfield name="requestDetails.rider.obligee.addressDtls.name"
						key="label.request.common.name" id="obligeeAddressName"
						theme="aloc" />
				</div>
			</div>
		</div>
		<div class="row">
			<div class="span12">
				<div class="form-row">
					<s:textfield
						name="requestDetails.rider.obligee.addressDtls.address[0]"
						key="label.request.common.address1" id="obligeeAddress1"
						theme="aloc" maxlength="100"/>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="span12">
				<div class="form-row">
					<s:label key="label.request.common.address2opt" cssClass="optional" />
					<s:textfield
						name="requestDetails.rider.obligee.addressDtls.address[1]"
						id="obligeeAddress2" theme="aloc" maxlength="100"/>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="span12">
				<div class="form-row">
					<s:textfield name="requestDetails.rider.obligee.addressDtls.city"
						key="label.request.common.city" id="obligeeAddressCity"
						theme="aloc" maxlength="50"/>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="span12">
				<div class="form-row">
					<label class="optional"><s:text name="label.request.common.stateProvince"/> <s:text name="label.request.optional"/></label>
							<s:combobox listKey="stateName" listValue="stateName" headerKey="-1" headerValue="Select..." list="%{#attr['com.ge.aloc.StaticDataFactory'].stateList}"
								name="requestDetails.rider.obligee.addressDtls.stateProvince" id="obligeeAddressState" />
				</div>
			</div>
		</div>
		<div class="row">
			<div class="span12">
				<div class="form-row">
					<s:textfield key="label.request.common.zipPostalCode"
						name="requestDetails.rider.obligee.addressDtls.ZIPPostalCode"
						id="obligeeAddressZip" theme="aloc" maxlength="12"/>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="span12">
				<div class="form-row">
					<sj:autocompleter id="obligeeAddressCountryCd"
						list="%{#attr['com.ge.aloc.MasterDataFactory'].countries}"
						name="requestDetails.rider.obligee.addressDtls.countryCd"
						key="label.request.common.country" cssClass="span3"
						listKey="countryCode" listValue="countryName" parentTheme="aloc"
						onChangeTopics="getAutocompleterName" />
					<s:hidden name="requestDetails.rider.obligee.addressDtls.country"
						id="obligeeAddressCountry"></s:hidden>
				</div>
			</div>
		</div>
	</div>