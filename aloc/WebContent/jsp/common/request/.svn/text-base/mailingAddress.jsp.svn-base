<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<s:set name="isEditMode" value="editMode"/>
	 <s:if test="%{#isEditMode==true || ((requestDetails.WFDetails.WFStage == 'REQEST' || requestDetails.WFDetails.WFStage == 'REQUEST'  && #attr.isTaxonomy != true) && requestDetails.addressDtls.requiresEdits == true)}">
	 	<c:if test="${param.includeScripts != false}">
		<script type="text/javascript">
		$(document).ready(function() {
			showMailingStateOnload();
			contactPersonMakeMandatory();
			});
		</script>
		</c:if>
	 	<s:if test="%{(requestDetails.WFDetails.WFStage == 'REQEST' || requestDetails.WFDetails.WFStage == 'REQUEST') && requestDetails.addressDtls.requiresEdits}">
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
								<s:property value="requestDetails.addressDtls.sendBackNotes" />
							</p>
						</div>
					</div>
				</div>
			</div>
		</s:if>
	 	<div id="mailingAddressForm">
				<a name="fifth"></a>
                <div class="row">
                    <div class="span12">
						<div class="form-row">
							<s:textfield key="label.request.companyName" name="requestDetails.addressDtls.name" 
								id="companyName" theme="aloc" cssClass="mandatory" maxlength="100"/>
			            </div>
			        </div> <!-- end of block -->
			    </div> 
			     <div class="row">
                    <div class="span12">
						<div class="form-row">
							<s:textfield key="label.request.contactFirstName" name="requestDetails.addressDtls.contactFName"
								 id="contactFName" theme="aloc" cssClass="mandatory" maxlength="50"/>
			            </div>
			        </div> <!-- end of block -->
			    </div> 
			     <div class="row">
                    <div class="span12">
						<div class="form-row">
							<s:textfield key="label.request.contactLastName" name="requestDetails.addressDtls.contactLName"
								 id="contactLName" theme="aloc" cssClass="mandatory" maxlength="50"/>
			            </div>
			        </div> <!-- end of block -->
			    </div> 
					<div class="row">
						<div class="span12">
							<div class="form-row">
								<s:textfield key="label.request.address1" name="requestDetails.addressDtls.address[0]"
									 id="mailingAddress1" theme="aloc" cssClass="mandatory" maxlength="100"/>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="span12">
							<div class="form-row">
								<label class="optional"><s:text name="label.request.address2Opti" /></label>
							<s:textfield name="requestDetails.addressDtls.address[1]" id="mailingAddress2" maxlength="100"/>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="span12">
							<div class="form-row">
								<s:textfield key="label.request.city" name="requestDetails.addressDtls.city"
									 id="mailingCity" theme="aloc" cssClass="mandatory" maxlength="50"/>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="span12">
							<div class="form-row">
								 <label class="optional"><s:text name="label.request.stateOrProvince"/> <s:text name="label.request.optional"/></label>
									<s:combobox listKey="stateName" listValue="stateName" headerKey="-1" headerValue="Select..." list="%{#attr['com.ge.aloc.StaticDataFactory'].stateList}"
										name="requestDetails.addressDtls.stateProvince" id="mailingState" cssClass="comboMailingState"/>
							</div>
						</div>
						
					</div>
					<div class="row">
						<div class="span12">
							<div class="form-row">
								<s:textfield key="label.request.zipOrPostalCode" name="requestDetails.addressDtls.ZIPPostalCode" 
									id="mailingzipPostalCode" theme="aloc" cssClass="mandatory" maxlength="12"/>
								<p class="guidance"><s:text name="label.request.zipCodeGuidance" /></p>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="span12">
							<div class="form-row">
								<sj:autocompleter id="mailingcountryCd" list="%{#attr['com.ge.aloc.MasterDataFactory'].countries}" name="requestDetails.addressDtls.countryCd" 
									key="label.request.country" cssClass="span3" listKey="countryCode" listValue="countryName" parentTheme="aloc"
									onChangeTopics="getAutocompleterName"/>
								<s:hidden name="requestDetails.addressDtls.country" id="mailingCountry" cssClass="autoCompleterName mandatory"></s:hidden>
							</div>
						</div>
						
					</div>
					<div class="row">
						<div class="span12">
							<div class="form-row">
								<s:textfield name="requestDetails.addressDtls.phoneNumber" cssClass="mandatory"
									id="addressphoneNumber" key="label.request.phoneNumber" theme="aloc" maxlength="20"/>
								<p class="guidance">
									<s:text name="label.request.includeCountryAndAreaCode" />
								</p>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="span12">
							<div class="form-row">
							<sj:autocompleter id="mailingCountryOfIncId" list="%{#attr['com.ge.aloc.MasterDataFactory'].countries}" onChangeTopics="getNameAndShowState"
								key="label.request.countryOfIncorporation" name="requestDetails.addressDtls.countryOfIncCd" cssClass="span3 mandatory"
								listKey="countryCode" listValue="countryName" parentTheme="aloc"/>
							<s:hidden name="requestDetails.addressDtls.countryOfInc" id="mailingCountryOfInc" cssClass="autoCompleterName"></s:hidden>
							</div>
						</div>
					</div>
					<div class="row hide" id="mailingStateDivId">
						<div class="span12">
							<div class="form-row">
							 <label class="optional"><s:text name="label.request.stateOfIncorporation"/> <s:text name="label.request.optional"/></label>
								<s:combobox listKey="stateName" listValue="stateName" headerKey="-1" headerValue="Select..." list="%{#attr['com.ge.aloc.StaticDataFactory'].stateList}"
									name="requestDetails.addressDtls.stateOfInc" id="mailingStateOfInc" />
							</div>
						</div>
					</div>
			   <c:if test="${empty requestDetails.addressDtls.bondReqName}">
					<c:set var="BondRequestorClass" value="display: none;" />
					<c:set var="BondRequestorClearStyle" value="display: none;"/>
				</c:if>
				<c:if test="${not empty requestDetails.addressDtls.bondReqName}">
					<c:set var="BondRequestorClass" value="display: block;" />
					<s:set var="BondRequestorNameSelected" value="%{'Selected'}"></s:set>
					<c:set var="BondRequestorClearStyle" value="display: inline;"/>
				</c:if>
                <div class="row">
                	<div class="form-row">
				    	<div class="span3">
							<s:textfield name="bondReqName"  key="label.request.contactPerson" cssClass="span3 lookup-filterValue" id="businessContactPersonId" theme="aloc" required="false"/>
							<s:hidden name="businessContactName" value="BUC" cssClass="businessContactClass"></s:hidden>
							<p class="guidance"><s:text name="label.request.partialLastName" /></p>
							<span class="lookup-error hide" style="color: #AE2C2C;"></span>
						</div>
						<div class="span1">
							<label>&nbsp;</label>
							<s:url action="BusinessContactPersonLookup" namespace="/int"	id="getContactPersonURL">
								<s:param name="lookUpNumber" value="1"></s:param>
							</s:url>
							<a class="btn-secondary lookup" href="<s:property value="#getContactPersonURL"/>" ><s:text name="label.request.common.lookup"/></a>
						</div>
						<div class="span5">
				        	<label>&nbsp;</label>
				            <img alt="Loading..." id="bcpIndicator"	class="indicator" src="${pageContext.request.contextPath}/img/loading.gif" style="height: 20px; display: none"> 
							<%-- <a class="btn-tertiary right clear-conditional-results"	id="BusinessClear" href="javascript:;" type="submit"  style="${BondRequestorClearStyle}">Clear results</a> --%>
						</div>
					</div>
			    </div> 
		
				<div class="conditional-row" id="BondRequestorShow" style="${BondRequestorClass}"> 
					<s:hidden name="bondReqNameSelection" id="BondReqNameSelectionID" value="%{#BondRequestorNameSelected}"></s:hidden>
					<div class="row">
						<div class="span12">
					<div class="row">
						<div class="span12">
							<div class="form-row">
							<s:textfield name="requestDetails.addressDtls.bondReqName" id="bondReqName" key="label.request.name" 
							 readonly="true" theme="aloc" maxlength="100"></s:textfield>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="span12">
							<div class="form-row">
							<s:textfield name="requestDetails.addressDtls.bondReqEmailAddress" id="emailAddr" key="label.request.emailAddress" 
							readonly="true" theme="aloc" maxlength="100"></s:textfield>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="span12">
							<div class="form-row">
							<s:textfield name="requestDetails.addressDtls.bondReqPhoneNo" id="bondReqPhoneNumber"  key="label.request.phoneNumber"
							 theme="aloc" maxlength="20"></s:textfield>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="span12">
							<div class="form-row">
							<s:textfield name="requestDetails.addressDtls.bondReqFaxNo" id="faxNumber" key="label.request.faxNumber"
							 theme="aloc" maxlength="20" required="false"></s:textfield>
							</div>
						</div>
					</div>
					<div class="row hide">						
							<s:textfield name="requestDetails.addressDtls.bondReqContactPerson" id="tpApplicantBCPSSO"></s:textfield>
					</div>
				</div>
			</div>
		</div>
		</div><!-- end of required count block -->
		<script type="text/javascript">
			refreshSectionCount("requestorMailingAddressPanel");
		</script>
	</s:if>
	<s:elseif test="%{#isEditMode==false}">
					<div class="row">
							<div class="span2a">
								<div class="form-row">
									<label><s:text name="label.request.common.nameAddress"/>:</label>
								</div>
							</div>
							<div class="span5 left">
								<div class="form-row">
									<p class="padding40"><c:out value="${requestDetails.addressDtls.name}"/></p><br>
									<p class="padding40"><c:out value="${requestDetails.addressDtls.contactFName}"/></p>
									<p class="padding40"><c:out value="${requestDetails.addressDtls.contactLName}"/></p><br>
									<p class="padding40"><c:out value="${requestDetails.addressDtls.address[0]}"/></p>
									<p class="padding40"><c:out value="${requestDetails.addressDtls.address[1]}"/></p><br>
									<p class="padding40"><c:out value="${requestDetails.addressDtls.city}"/> <c:out value="${requestDetails.addressDtls.stateProvince}"/>
									<c:out value="${requestDetails.addressDtls.ZIPPostalCode}"/> </p>
									<p class="padding40"><c:out value="${requestDetails.addressDtls.country}"/></p><br>
									<p class="padding40"><c:out value="${requestDetails.addressDtls.countryOfInc}"/></p>
									<p class="padding40"><c:out value="${requestDetails.addressDtls.stateOfInc}"/></p>
									<p class="padding40"><c:out value="${requestDetails.addressDtls.phoneNumber}"/></p>
				
								</div>
							</div>
							<!-- end of block -->
						</div>
						<div class="row">
						<div class="span2a">
							<div class="form-row">
								<label><s:text name="label.request.contactPerson" />:</label>
							</div>
						</div>
						<div class="span5 left">
							<div class="form-row">
								<p class="padding40"><c:out value="${requestDetails.addressDtls.bondReqName}"/></p>
								<p class="padding40"><c:out value="${requestDetails.addressDtls.bondReqEmailAddress}"/></p>
								<p class="padding40"><c:out value="${requestDetails.addressDtls.bondReqPhoneNo}"/></p>
								<p class="padding40"><c:out value="${requestDetails.addressDtls.bondReqFaxNo}"/></p>
							</div>
						</div>
						<!-- end of block -->
					</div>
						
</s:elseif>