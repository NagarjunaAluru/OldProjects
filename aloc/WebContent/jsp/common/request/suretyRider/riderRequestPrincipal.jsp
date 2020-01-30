<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<s:set name="isEditMode" value="editMode" />
<c:if test="${empty requestDetails.rider.principal.leGoldId}">
	<c:set var="goldidClass" value="display: none;" />
	<%-- <c:set var="goldidClearStyle" value="display: none;"/> --%>
</c:if>
<c:if test="${not empty requestDetails.rider.principal.leGoldId}">
	<c:set var="goldidClass" value="display: block;" />
	<s:set var="goldidSelected" value="%{'Yes'}"></s:set>
	<%-- <c:set var="goldidClearStyle" value="display: inline;"/> --%>
</c:if>
<div class="row">
	<div class="span12">
		<div class="form-row autosize-container">
			<s:textfield name="principalGoldId" tooltip="%{getText('label.request.tooltip.legalEntity')}"
				cssClass="span3 lookup-filterValue " id="leGoldId" theme="aloc" key="label.request.common.legalEntityGOLDID"/>
			<s:url action="LegalEntityLookup" namespace="/int"
				var="getLegalEntityURL" escapeAmp="false" encode="true">
			</s:url>
			<a class="btn-secondary lookup"
				href="<s:property value="#getLegalEntityURL" />"><s:text
					name="label.request.common.lookup" /></a> <img alt="Loading..."
				id="leIndicator" class="indicator"
				src="${pageContext.request.contextPath}/img/loading.gif"
				style="height: 20px; display: none"> <br /> <span class="lookup-error hide"
				style="color: #AE2C2C;"></span>
		</div>
	</div>
</div>
<div class="conditional-row" id="goldidShow" style="${goldidClass}">
	<s:hidden name="principalGoldIdSelection"
		id="principalGoldIdSelectionID" value="%{#goldidSelected}"></s:hidden>
	<div class="row">
		<div class="span7">
			<div class="row">
				<div class="span2">
					<div class="form-row">
						<s:label key="label.request.common.legalEntityNameC" />
					</div>
				</div>
				<div class="span4 left">
					<div class="form-row">
						<p>
							<s:property value="requestDetails.rider.principal.leName" />
						</p>
						<s:hidden name="requestDetails.rider.principal.leName"
							id="tpApplicantLEName" cssClass="LEName"></s:hidden>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="span2">
					<div class="form-row">
						<s:label key="label.request.common.legalEntityGOLDIdC" />
					</div>
				</div>
				<div class="span4 left">
					<div class="form-row">
						<p>
							<s:property value="requestDetails.rider.principal.leGoldId" />
						</p>
						<s:hidden name="requestDetails.rider.principal.leGoldId"
							id="tpApplicantLEGoldID" cssClass="LEGoldID"></s:hidden>
					</div>
				</div>
			</div>
			<div class="row lastrow">
				<div class="span12">
					<div class="form-row ckeckBoxLabel">
						<label class="checkbox"> <s:checkbox
								name="requestDetails.rider.principal.principleInfoFlag"
								fieldValue="true" id="principleInfoFlag"></s:checkbox> 
						</label><s:label key="label.request.useforPrincipalInformationbelow" />
					</div>
				</div>
			</div>
			<s:hidden name="name" id="lename" />
			<s:hidden name="Address1" id="Address1" />
			<s:hidden name="Address2" id="Address2" />
			<s:hidden name="AddressCity" id="AddressCity" />
			<s:hidden name="stateCode" id="stateCode" />
			<s:hidden name="stateName" id="AddressState" />
			<s:hidden name="AddressZip" id="AddressZip" />
			<s:hidden name="countryCode" id="countryCode" />
			<s:hidden name="countryName" id="AddressCountry" />
		</div>
	</div>
</div>
<div class="row">
	<div class="span12">
		<div class="form-row">
			<s:select headerKey="" key="label.request.geDivisionName"
				list="%{#attr['com.ge.aloc.StaticDataFactory'].geDivisionsList}"
				headerValue="Select..." listKey="ID" listValue="name"
				id="riderGEDivisionID"
				name="requestDetails.rider.principal.geDivisionId" theme="aloc">
			</s:select>
			<s:hidden name="requestDetails.rider.principal.geDivisionName"
				id="riderGEDivisionName"
				value="%{requestDetails.rider.principal.geDivisionName}" />
		</div>
	</div>
	<!-- end of block -->
</div>
<div class="row">
	<s:if test="%{principlaAddressSelection == null}">
		<s:if
			test="%{requestDetails.rider.principal == null 
						 || requestDetails.rider.principal.addressDtls == null || 
						 (requestDetails.rider.principal.addressDtls.name == null && 
							requestDetails.rider.principal.addressDtls.city == null &&
							requestDetails.rider.principal.addressDtls.stateProvince == null &&
							requestDetails.rider.principal.addressDtls.ZIPPostalCode == null &&
							requestDetails.rider.principal.addressDtls.country == null)}">
			<s:set var="PrincipalNameSelected"
				value="%{principlaAddressSelection}" />
		</s:if>
		<s:else>
			<s:set var="PrincipalNameSelected" value="%{'Selected'}"></s:set>
		</s:else>
	</s:if>
	<s:else>
		<s:set var="PrincipalNameSelected"
			value="%{principlaAddressSelection}" />
	</s:else>

	<s:if test="%{#PrincipalNameSelected == 'Selected'}">
		<c:set var="PrincipalDetailsClass" value="display: block;" />
	</s:if>
	<s:else>
		<c:set var="PrincipalDetailsClass" value="display: none;" />
	</s:else>
	<div class="span12">
		<div class="form-row">
			<s:label key="label.request.sbNameAndAddress" />
			<s:textfield name="nameForAddress"
				cssClass="span3 lookup-filterValue" id="principalNameAddressId" />
				<p class="guidance"><s:text name="label.request.nameAddressGuidance" /></p>
				<s:hidden name="principalNameAddressValue" value="yes" cssClass="nameAddressClass"></s:hidden>
			<s:url action="NameAddressLookup" namespace="/int"
				var="getPrincipalNameAddressURL" escapeAmp="false" encode="true">
				<s:param name="addressTypeId">4</s:param>
			</s:url>
			<a class="btn-secondary lookup"
				href="<s:property value="#getPrincipalNameAddressURL"/>"><s:text
					name="label.request.common.lookup" /></a> <img alt="Loading..."
				id="principalAddressIndicator" class="indicator"
				src="${pageContext.request.contextPath}/img/loading.gif"
				style="height: 20px; display: none">
		</div>
	</div>
	<!-- end of block -->
</div>

<div class="lastrow" id="PrincipalShow" style="${PrincipalDetailsClass}">
	<s:hidden name="principlaAddressSelection"
		id="principlaAddressSelectionId" value="%{#PrincipalNameSelected}"></s:hidden>
	<div class="row">
		<div class="span7">
			<div class="row">
				<div class="span2">
					<div class="form-row">
						<s:label key="label.request.common.name" />
					</div>
				</div>
				<div class="span4 left">
					<div class="form-row" id="principalName">
						<p>
							<s:property
								value="requestDetails.rider.principal.addressDtls.name" />
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
					<div class="form-row" id="principalAddress">
						<s:iterator
							value="requestDetails.rider.principal.addressDtls.address">
							<p>
								<s:property />
							</p>
						</s:iterator>
						<p>
							<s:property
								value="requestDetails.rider.principal.addressDtls.city" />
							<s:property
								value="requestDetails.rider.principal.addressDtls.stateProvince" />
							<s:property
								value="requestDetails.rider.principal.addressDtls.ZIPPostalCode" />
						</p>
						<p>
							<s:property
								value="requestDetails.rider.principal.addressDtls.country" />
						</p>
					</div>
				</div>
			</div>
		</div>
		<!-- end of block -->
	</div>
</div>
<div class="conditional-row-manually" id="PrincipalShowManually">
	<div class="row">
		<div class="span12">
			<div class="form-row">
				<s:textfield name="requestDetails.rider.principal.addressDtls.name"
					key="label.request.common.name" id="principalAddressName"
					theme="aloc" />
			</div>
		</div>
	</div>
	<div class="row">
		<div class="span12">
			<div class="form-row">
				<s:textfield
					name="requestDetails.rider.principal.addressDtls.address[0]"
					key="label.request.common.address1" id="principalAddress1"
					theme="aloc" maxlength="100"/>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="span12">
			<div class="form-row">
				<s:label key="label.request.common.address2opt" cssClass="optional" />
				<s:textfield
					name="requestDetails.rider.principal.addressDtls.address[1]"
					id="principalAddress2" theme="aloc" maxlength="100"/>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="span12">
			<div class="form-row">
				<s:textfield name="requestDetails.rider.principal.addressDtls.city"
					key="label.request.common.city" id="principalAddressCity"
					theme="aloc" maxlength="50"/>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="span12">
			<div class="form-row">
				 <label class="optional"><s:text name="label.request.common.stateProvince"/> <s:text name="label.request.optional"/></label>
							<s:combobox listKey="stateName" listValue="stateName" headerKey="-1" headerValue="Select..." list="%{#attr['com.ge.aloc.StaticDataFactory'].stateList}"
								name="requestDetails.rider.principal.addressDtls.stateProvince" id="principalAddressState" />
			</div>
		</div>
	</div>
	<div class="row">
		<div class="span12">
			<div class="form-row">
				<s:textfield key="label.request.common.zipPostalCode"
					name="requestDetails.rider.principal.addressDtls.ZIPPostalCode"
					id="principalAddressZip" theme="aloc" maxlength="12"/>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="span12">
			<div class="form-row">
				<sj:autocompleter id="principalCountryCd"
					list="%{#attr['com.ge.aloc.MasterDataFactory'].countries}"
					name="requestDetails.rider.principal.addressDtls.countryCd"
					cssClass="span3" listKey="countryCode" listValue="countryName"
					parentTheme="aloc" onChangeTopics="showPrincipalState"
					key="label.request.common.country" />
				<s:hidden name="requestDetails.rider.principal.addressDtls.country"
					id="principalAddressCountry"></s:hidden>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="span12">
			<div class="form-row ckeckBoxLabel">
				<label class="checkbox"> <s:checkbox
						name="requestDetails.rider.principal.addressDtls.futureUseFlag"
						fieldValue="true"></s:checkbox> 
				</label><s:label key="label.request.common.saveforFutureuse" />
			</div>
		</div>
	</div>
	<div class="row hide" id="principalStateDivId">
		<div class="span12">
			<div class="form-row">
				 <label class="optional"><s:text name="label.request.stateProvinceofIncorporation"/> <s:text name="label.request.optional"/></label>
							<s:combobox listKey="stateName" listValue="stateName" headerKey="-1" headerValue="Select..." list="%{#attr['com.ge.aloc.StaticDataFactory'].stateList}"
								name="requestDetails.rider.principal.addressDtls.stateOfInc" id="principalStateOfInc" />
			</div>
		</div>
	</div>
</div>

