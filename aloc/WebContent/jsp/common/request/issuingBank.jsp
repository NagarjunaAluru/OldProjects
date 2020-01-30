<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${param.includeScripts != false}">
<script type="text/javascript">
$(document).ready(function() {
	showHideBank();
	showHideIssuingBankAddress();
	sendbackOnloadShow();
});
</script>
</c:if>
<s:set name="isEditMode" value="editMode"/>
	<s:if test="%{#isEditMode==true || ((requestDetails.WFDetails.WFStage == 'REQEST' || requestDetails.WFDetails.WFStage == 'REQUEST' && #attr.isTaxonomy != true) && requestDetails.issuingBankDetails.requiresEdits)}">
	<s:if test="%{(requestDetails.WFDetails.WFStage == 'REQEST' || requestDetails.WFDetails.WFStage == 'REQUEST') && requestDetails.issuingBankDetails.requiresEdits}">
						 <div class="row">
							<div class="span12">
								<div class="errorbox">
									<div class="noteHead">
										<p class="noteicon">
											<s:text name="label.common.alert" />
										</p>
									</div>
									<div class="noteContent">
										<p>
											<s:property value="requestDetails.issuingBankDetails.sendBackNotes" />
										</p>
									</div>
								</div>
							</div>
						</div>
					 </s:if>
		
	<div class="row">
		<s:if test="%{issuingBankSelection == null}">
			<s:if
				test="%{requestDetails.issuingBankDetails == null || 
				  requestDetails.issuingBankDetails.addressDtls == null || 
				 (requestDetails.issuingBankDetails.bankName == null && 
					requestDetails.issuingBankDetails.addressDtls.city == null &&
					requestDetails.issuingBankDetails.addressDtls.country == null)}">
				<s:set var="bankNameSelected" value="%{issuingBankSelection}" />
			</s:if>
			<s:else>
				<s:set var="bankNameSelected" value="%{'Selected'}"></s:set>
			</s:else>
		</s:if>
		<s:else>
			<s:set var="bankNameSelected" value="%{issuingBankSelection}" />
		</s:else>
		<s:if test="%{#bankNameSelected == 'Selected'}">
			<c:set var="bankDetailsClass" value="display: block;" />
			<c:set var="bankDetailsClearStyle" value="display: inline;" />
		</s:if>
		<s:else>
			<c:set var="bankDetailsClass" value="display: none;" />
			<c:set var="bankDetailsClearStyle" value="display: none;" />
		</s:else>
			<div class="form-row autosize-container">
				<div class="span3">
					<s:textfield name="issuingBankName" id="issuingBankNameId" key="label.request.bankName"
						cssClass="span3 lookup-filterValue bankLookUp" theme="aloc" />
					<span class="lookup-error hide" style="color: #AE2C2C;"></span>
				</div>
				<div class="span3">
					<!-- <label>Country</label> -->
					<sj:autocompleter id="bankCountryCodeId" list="%{#attr['com.ge.aloc.MasterDataFactory'].countries}" 
						name="bankCountryCd" cssClass="span2 bankCountryCode" listKey="countryCode" listValue="countryName" 
						parentTheme="aloc" onChangeTopics="getAutocompleterName" key="label.request.common.country"/>
					<s:hidden name="bankCountry" id="bankCountryNameId" cssClass="autoCompleterName"></s:hidden>
				</div>
				<div class="span2">
					<!-- <label>Bank city</label> -->
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
		<div class="conditional-row" id="bankDetails" style="${bankDetailsClass}">
		<s:hidden name="issuingBankSelection" id="issuingBankSelectionId" value="%{#bankNameSelected}"></s:hidden>
		<div class="row">
			<div class="span7">
				<div class="row firstrow">
					<div class="form-row span4">
						<p>
							<s:property value="requestDetails.issuingBankDetails.bankName" />
						</p>
						<s:iterator
							value="requestDetails.issuingBankDetails.addressDtls.address">
							<p>
								<s:property />
							</p>
						</s:iterator>
						<p>
							<s:property
								value="requestDetails.issuingBankDetails.addressDtls.city" />
							<s:property
								value="requestDetails.issuingBankDetails.addressDtls.stateProvince" />
							<s:property
								value="requestDetails.issuingBankDetails.addressDtls.ZIPPostalCode" />
						</p>
						<p>
							<s:property
								value="requestDetails.issuingBankDetails.addressDtls.country" />
						</p>
					</div>
				</div>
				<div class="row lastrow">
					<div class="span2c">
						<div class="form-row">
							<s:label key="label.request.bankIdentifierCode" />
						</div>
					</div>
					<div class="span4">
						<div class="form-row">
							<p>
								<s:property value="requestDetails.issuingBankDetails.BIC" />
							</p>
							<s:hidden name="requestDetails.issuingBankDetails.BIC"
								id="bankBicCode" cssClass="name mandatory"></s:hidden>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
		<div class="conditional-row-manually" id="BankDetailsShowManually">
			<div class="row">
				<div class="span12">
					<div class="form-row">
						<s:hidden name="requestDetails.issuingBankDetails.bankName" id="bankName" cssClass="mandatory"></s:hidden>
						<s:hidden name="requestDetails.issuingBankDetails.addressDtls.address[0]" id="bankAddress1" cssClass="mandatory"></s:hidden>
						<s:hidden name="requestDetails.issuingBankDetails.addressDtls.address[1]" id="bankAddress2"></s:hidden>
						<s:hidden name="requestDetails.issuingBankDetails.addressDtls.city" id="bankAddressCity" cssClass="mandatory"></s:hidden>
						<s:hidden name="requestDetails.issuingBankDetails.addressDtls.stateProvince" id="bankAddressState" cssClass="mandatory"></s:hidden>
						<s:hidden name="requestDetails.issuingBankDetails.addressDtls.ZIPPostalCode" id="bankAddressZip"></s:hidden>
						<s:hidden name="requestDetails.issuingBankDetails.addressDtls.country" id="bankAddressCountry" cssClass="mandatory"></s:hidden>
				</div>
			</div>
		</div>
		</div>
		<div class="row">
			<div class="span12">
				<div class="form-row">
					<s:textfield name="requestDetails.issuingBankDetails.creditLetterNo" key="label.request.letterOfCreditNumber" required="false" cssClass="span3" maxlength="20" theme="aloc"/>
				</div>
			</div>
		</div>
		<script type="text/javascript">
			refreshSectionCount('issuingBankPanel');
		</script>
		</s:if>
		<s:elseif test="%{#isEditMode==false}">	
		    <div class="row">
			    <div class="span2a">
				    <div class="form-row">
					    <label><s:text name="label.request.issuingBank" />:</label>
				    </div>
			    </div>
				<div class="span5 left">
				    <div class="form-row">
							<p class="padding40"><c:out value="${requestDetails.issuingBankDetails.bankName}"/></p>
							<p class="padding40"><c:out value="${requestDetails.issuingBankDetails.addressDtls.address[0]}"/></p>
							<p class="padding40"><c:out value="${requestDetails.issuingBankDetails.addressDtls.address[1]}"/></p>
							<p class="padding40"><c:out value="${requestDetails.issuingBankDetails.addressDtls.city}"/> <c:out value="${requestDetails.issuingBankDetails.addressDtls.stateProvince}"/> <c:out value="${requestDetails.issuingBankDetails.addressDtls.ZIPPostalCode}"/></p>
							<p class="padding40"><c:out value="${requestDetails.issuingBankDetails.addressDtls.country}"/></p>
				    </div>
			    </div>
		    </div> <!-- end of block -->
               <div class="row">
                   <div class="span2a">
					<div class="form-row">
						<label>
						<c:choose>
						<c:when test="${param.page eq 'BidReply'}">
						<s:text name="label.request.bankIdentifierCodeC" /> 
						</c:when>
						<c:otherwise>
						<s:text name="label.request.issuingBankIdentifierCode" />: 
						</c:otherwise>
						</c:choose>
						</label>
					</div>
		        </div>
				<div class="span5 left">
					<div class="form-row">
						<p class="padding40"><c:out value="${requestDetails.issuingBankDetails.BIC}"/></p>
					</div>
		        </div>
		    </div>
		    <div class="row">
                   <div class="span2a">
					<div class="form-row">
						<label>
							<s:text name="label.request.letterOfCreditNo"/>
						</label>
					</div>
		        </div>
				<div class="span5 left">
					<div class="form-row">
						<p class="padding40"><c:out value="${requestDetails.issuingBankDetails.creditLetterNo}"/></p>
					</div>
		        </div>
		    </div>
		</s:elseif>
