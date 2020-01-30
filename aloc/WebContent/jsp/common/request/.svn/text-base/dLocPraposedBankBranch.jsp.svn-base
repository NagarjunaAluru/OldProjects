<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

		<p class="required-fields"> <s:text name="label.request.common.allFieldsRequiredUnlessSpecified"/> </p>
		
		<c:if test="${empty requestDetails.proposedBankBranchConfirmDetails.bankDetails.name or (empty bankSelection or (not empty bankSelection and bankSelection eq 'New'))}">
		      <c:set var="bankNameClass" value="display: none;"/>
		      <c:set var="bankNameClearStyle" value="display: none;"/>
		</c:if>
		<c:if test="${not empty requestDetails.proposedBankBranchConfirmDetails.bankDetails.name or (not empty bankSelection and bankSelection eq 'Selected')}">
		      <c:set var="bankNameClass" value="display: block;"/>
			  <c:set var="bankNameClearStyle" value="display: inline;"/>
		</c:if> 
		<div class="row">
			<div class="form-row">
				<div class="span3">
					<s:textfield name="bankLookupName" 
						id="issuingBankNameId" 
						key="label.common.siteAdmin.bankName" 
						theme="aloc"
						cssClass="span3 lookup-filterValue"
					/>	
					<span class="lookup-error hide" style="color: #AE2C2C;"></span>
				</div>
				<div class="span3">
					<sj:autocompleter id="bankCountryCodeId" list="%{#attr['com.ge.aloc.MasterDataFactory'].countries}" 
							name="bankCountryCd" cssClass="span2 bankCountryCode" listKey="countryCode" listValue="countryName" 
							parentTheme="aloc" onChangeTopics="getAutocompleterName" key="label.request.common.country"/>
					<s:hidden name="bankCountry" id="bankCountryNameId" cssClass="autoCompleterName"></s:hidden>	
				</div>
				<div class="span2">
					<s:textfield name="bankCity" cssStyle="width: 132px;" id="bankCity" key="label.request.common.city" cssClass="bankCityName" theme="aloc" />
				</div>
				<div class="span1">
					<label>&nbsp;</label>
					<s:url action="BankDetailsLookup" namespace="/int" var="getBankNameURL" escapeAmp="false">
					</s:url>
					<a class="btn-secondary lookup" href="<s:property value="#getBankNameURL"/>" ><s:text name="label.request.common.lookup"/></a>&nbsp;
	            </div>
                <div class="span1">
                   	<label>&nbsp;</label>
                   	<img alt="Loading..." id="bankIndicator" class="indicator" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px">
                </div>
	         </div>
		</div>
		<!-- end of block -->
		
		 <div id="bankDetails" class="conditional-row hide" style="${bankNameClass}">
                	<s:hidden name="bankSelection" id="bankSelectionId"></s:hidden>
                	<s:hidden name="requestDetails.proposedBankBranchConfirmDetails.bankDetails.bankMDMId" id="bMDMId"></s:hidden>
                	<s:hidden name="requestDetails.proposedBankBranchConfirmDetails.bankDetails.name" id="bankName"></s:hidden>
                	<s:hidden name="requestDetails.proposedBankBranchConfirmDetails.bankDetails.address[0]" id="bankAddress1"></s:hidden>
                	<s:hidden name="requestDetails.proposedBankBranchConfirmDetails.bankDetails.address[1]" id="bankAddress2"></s:hidden>
                	<s:hidden name="requestDetails.proposedBankBranchConfirmDetails.bankDetails.city" id="bankAddressCity"></s:hidden>
                	<s:hidden name="requestDetails.proposedBankBranchConfirmDetails.bankDetails.stateProvince" id="bankAddressState"></s:hidden>
                	<s:hidden name="requestDetails.proposedBankBranchConfirmDetails.bankDetails.zipPostalCode" id="bankAddressZip"></s:hidden>
                	<s:hidden name="requestDetails.proposedBankBranchConfirmDetails.bankDetails.country" id="bankAddressCountry"></s:hidden>
                	<s:hidden name="requestDetails.proposedBankBranchConfirmDetails.bankIdentifierCode" id="bankBicCode"></s:hidden>
                    <div class="row">
                        <div class="span7">
                        	<div class="row firstrow">
                            <div class="form-row span4">
                                <p><s:property value="requestDetails.proposedBankBranchConfirmDetails.bankDetails.name"/><br />
                                <s:iterator value="requestDetails.proposedBankBranchConfirmDetails.bankDetails.address">
                                	<s:property /><br />
                                </s:iterator>
                                <s:property value="requestDetails.proposedBankBranchConfirmDetails.bankDetails.city"/>&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="requestDetails.proposedBankBranchConfirmDetails.bankDetails.stateProvince"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <s:property value="requestDetails.proposedBankBranchConfirmDetails.bankDetails.zipPostalCode"/><br />
                                <s:property value="requestDetails.proposedBankBranchConfirmDetails.bankDetails.country"/></p>

                            </div>
                            </div>
                            <div class="row lastrow">
			                    <div class="span2c">
			                        <label><s:label key="label.common.siteAdmin.bankIdentifierCodeC" /></label>
			                    </div>
			                    <div class="span4">
			                        <p><s:property value="requestDetails.proposedBankBranchConfirmDetails.bankIdentifierCode"/></p>
			                    </div>
			                </div> 
                    	</div>
                    </div>
                </div>