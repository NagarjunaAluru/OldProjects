<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<s:set name="isEditMode" value="editMode"/>
<s:if test="%{#isEditMode==true}">
	  
<c:if test="${param.includeScripts != false}">
<script	type="text/javascript">
$(document).ready(function() {
	loadSiteSpecificfields();
	instrumentPurposeClick();
	hideInsPurposeOther();
	loadTrypartyFlag();
	showHideTPApplicantAddress();
	showHideTPTriPartyAddress();
	showHideTPCustomerAddress();
	showHideIbsMessage();
	sendbackOnloadShow();
	showHideCSOValidation();
	
});

</script>

</c:if>
		 <c:choose>
	     	<c:when test="${empty param.modelSection or (not empty param.modelSection and param.modelSection eq '')}" >
	     		<c:if test="${empty requestDetails.siteName}">
				<div class="row">
					<div class="span12">
						<div class="form-row">
							<c:if test="${empty requestDetails.siteSelection.selectedSites}">
							<s:select headerKey="" key="label.request.site"  headerValue="Select..." list="%{#attr['com.ge.aloc.StaticDataFactory'].userSpecificSitesList}" 
								listKey="ID" listValue="name" name="siteId" id="selectedSiteId" theme="aloc" cssClass="mandatory"/>
							</c:if>	
							<c:if test="${not empty requestDetails.siteSelection.selectedSites}">
							<s:select headerKey="" key="label.request.site"  headerValue="Select..." list="requestDetails.siteSelection.selectedSites" 
								listKey="siteId" listValue="siteName" name="siteId" id="selectedSiteId" theme="aloc" cssClass="mandatory"/>
							</c:if>
								<s:hidden name="requestDetails.siteTypeName" value="%{requestDetails.siteTypeName}" id="siteTypeNameId"></s:hidden>
								<s:hidden name="requestDetails.siteId" value="%{requestDetails.siteId}" id="reqsiteID"></s:hidden>
								<s:hidden name="selectedSite" value="%{siteId}" id="selectedSite"></s:hidden>
								<img alt="Loading..." id="siteTypeIndicator" class="indicator" 	src="${pageContext.request.contextPath}/img/loading.gif" >
								
						</div>
					</div>
				</div>
				</c:if>
				<c:if test="${not empty requestDetails.siteName}">
	     		<div class="row">
				<div class="span12">
				<div class="form-row">
					<p style="padding: 2px 0;" class="defaultFontSize">
						<b><s:text name="label.request.selectedSite"/></b> 
						<span style="padding-left: 40px;"><s:property value="requestDetails.siteName"/></span>
						<s:hidden name="requestDetails.transactionParties.siteName" value="%{requestDetails.siteName}"></s:hidden>
						<s:hidden name="requestDetails.siteId" value="%{requestDetails.siteId}" id="reqsiteID"></s:hidden>
						<s:hidden name="requestDetails.siteTypeName" value="%{requestDetails.siteTypeName}" id="siteTypeNameId"></s:hidden>
						<s:hidden name="siteId" value="%{requestDetails.siteId}"></s:hidden>
					</p>
				</div>
			</div>
			</div>
			</c:if>
	     	</c:when>
	     	<c:otherwise>
	     		<s:hidden name="requestDetails.transactionParties.siteName" value="%{requestDetails.siteName}"></s:hidden>
				<s:hidden name="requestDetails.siteId" value="%{requestDetails.siteId}" id="reqsiteID"></s:hidden>
				<s:hidden name="requestDetails.siteTypeName" value="%{requestDetails.siteTypeName}" id="siteTypeNameId"></s:hidden>
				<s:hidden name="siteId" value="%{requestDetails.siteId}"></s:hidden>
				<jsp:include page="/jsp/common/request/siteSelection.jsp" />
	     	</c:otherwise>
	     </c:choose>
	<div class="row">
	
		<div class="span12">
			<div class="form-row">
				<s:select theme="aloc" 
					name="requestDetails.transactionParties.instrumentPurposeId"
					list="%{#attr['com.ge.aloc.StaticDataFactory'].instrumentPurpose}"
					headerKey="" headerValue="Select..." listKey="ID" listValue="name"
					id="instrumentPurposeId" key="label.request.Instrumentpurpose"
					tooltip="%{getText('label.request.tooltip.Instrumentpurpose')}" 
					cssClass="mandatory"/>
				<s:hidden name="requestDetails.transactionParties.instrumentPurpose"
					id="instrumentPurpose"
					value="%{requestDetails.transactionParties.instrumentPurpose}"/>
			</div>
			<div class="hide" id="instumrntDeatilsOtherDiv">
				<div class="row lastrow" style="margin-top: 20px !important;">
					<div class="span12">
						<div class="form-row">
							<s:textfield theme="aloc" id="instumrntDeatilsOther" maxlength="100"
								name="requestDetails.transactionParties.instrumentPurposeOther" key="label.request.other" />
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- end of block -->
	</div>
	
		<div class="row hide" style="margin-bottom: 15px !important;" id="triPartyRequest">
	
			<div class="span12">
				
				<div class="form-row countTriparty">
					<s:radio cssClass="radio" id="triparty"
					key="label.request.isTriPartyRequest"
					name="requestDetails.transactionParties.triPartyRequestFlag" 
					theme="aloc" 
					tooltip="%{getText('label.request.tooltip.triparty')}"
					list="#{'true':'Yes','false':'No'}" />
				</div>
			</div>
		</div>
		
		<div class="row hide" id="private">
			<div class="span12">
				
				<div class="form-row countPrivate">
					<s:radio cssClass="radio" id="privateLabel"
					key="label.request.privateLabel"
					name="requestDetails.transactionParties.privateLabelFlag" 
					theme="aloc"
					tooltip="%{getText('label.request.tooltip.private')}"
					list="#{'true':'Yes','false':'No'}" />
				</div>
			</div>
		</div>
			<s:if test="%{requestDetails.transactionParties.triPartyRequestFlag == null}">
				<c:set var="showHideTriParty" value="display: none;"></c:set>
			</s:if>
			<s:else>
				<s:if test="%{requestDetails.transactionParties.triPartyRequestFlag}">
					<c:set var="showHideTriParty" value="display: block;"></c:set>
				</s:if>
				<s:else>
					<c:set var="showHideTriParty" value="display: none;"></c:set>
				</s:else>
			</s:else>
		
		
		<div class="hide" id="TriPartyApplicant" style="${showHideTriParty}">
			<h3 id="triPartyHeader">
				<s:text name="label.request.triPartyApplicant" /> <span class="ttip info"
					data-original-title="<s:text name="label.request.tooltip.triPartyApplicant"/>"></span>
			</h3>
			<hr class="hr3">
			<div class="row">
				<s:if test="%{triPartyAddressSelection == null}">
					<s:if test="%{requestDetails.transactionParties == null || requestDetails.transactionParties.triPartyApplicant == null
					 || (requestDetails.transactionParties.triPartyApplicant.name == null && 
						requestDetails.transactionParties.triPartyApplicant.city == null &&
						requestDetails.transactionParties.triPartyApplicant.stateProvince == null &&
						requestDetails.transactionParties.triPartyApplicant.ZIPPostalCode == null &&
						requestDetails.transactionParties.triPartyApplicant.country == null)}">
						<s:set var="triPartyAddressSelected" value="%{triPartyAddressSelection}" />
					</s:if>
					<s:else>
						<s:set var="triPartyAddressSelected" value="%{'Selected'}"></s:set>
					</s:else>
				</s:if>
				<s:else>
					<s:set var="triPartyAddressSelected" value="%{triPartyAddressSelection}" />
				</s:else>
			
				<s:if test="%{#triPartyAddressSelected == 'Selected'}">
					<c:set var="TriPartyShowClass" value="display: block;"/>
					<%-- <c:set var="TriPartyShowClearStyle" value="display: inline;"/> --%>
				</s:if>
				<s:else>
					<c:set var="TriPartyShowClass" value="display: none;"/>
					<%-- <c:set var="TriPartyShowClearStyle" value="display: none;"/> --%>
				</s:else>
				
				<div class="form-row">
			
					<div class="span3">
						<s:textfield name="nameForAddressTriparty" cssClass="span3 lookup-filterValue" 
						id="triPartyApplicantNameAddressId" theme="aloc" maxlength="100" key="label.request.triPartyApplicantNameAddress"/>
						<p class="guidance"><s:text name="label.request.nameAddressGuidance" /></p>
						<s:hidden name="triPartyNameAddressValue" value="yes" cssClass="nameAddressClass"></s:hidden>
						<span class="lookup-error hide" style="color: #AE2C2C;"></span>
					</div>
					<div class="span6" style="margin-left: 0px;">
						<label>&nbsp;</label>
						<s:url action="NameAddressLookup" namespace="/int" var="getTriApplicantNameAddressURL" escapeAmp="false" encode="true">
							<s:param name="addressTypeId">2</s:param>
						</s:url> 
						<a class="btn-secondary lookup" href="<s:property value="#getTriApplicantNameAddressURL"/>" ><s:text name="label.request.common.lookup"/></a>
					
						<img alt="Loading..." id="triPartyApplicantAddressIndicator" class="indicator" 
						src="${pageContext.request.contextPath}/img/loading.gif" >
					</div>
				</div>
			</div>
			
			<div class="conditional-row" id="TriPartyShow" style="${TriPartyShowClass}">
				<s:hidden name="triPartyAddressSelection" id="triPartyAddressSelectionId" value="%{#triPartyAddressSelected}" />
				<div class="row">
					<div class="span7">
						<div class="row">
	                        <div class="span2">
	                            <div class="form-row">
	                                <s:label key="label.request.triPartyApplicantName"/>
	                            </div>
	                        </div>
	                        <div class="span4 right">	
	                            <div class="form-row" id="tripartyName">
	                                <p><s:property value="requestDetails.transactionParties.triPartyApplicant.name"/></p>
	                            </div>
	                        </div><!-- end of block -->
	                    </div>
	                    <div class="row">
	                        <div class="span2">
	                            <div class="form-row">
	                                <s:label key="label.request.triPartyApplicantAddress"/>
	                            </div>
	                        </div><!-- end of block -->
	                        <div class="span4 right">
	                            <div class="form-row" id="tripartyAddress">
	                                <s:iterator value="requestDetails.transactionParties.triPartyApplicant.address">
										<p><s:property/> </p>
									</s:iterator>
									
									<p><s:property value="requestDetails.transactionParties.triPartyApplicant.city"/>
									 <s:property value="requestDetails.transactionParties.triPartyApplicant.stateProvince"/> 
									 <s:property value="requestDetails.transactionParties.triPartyApplicant.ZIPPostalCode"/>
									 </p>
									<p><s:property value="requestDetails.transactionParties.triPartyApplicant.country"/></p>
	                            </div>
	                        </div>
	                    </div>
					</div>
					<!-- end of block -->
				</div>
			</div>
			<div class="conditional-row-manually" id="TriPartyShowManually">
				<div class="row">
				<div class="span12">
					<div class="form-row">
						<s:textfield name="requestDetails.transactionParties.triPartyApplicant.name" 
							id="triPartyAddressName" 
							key="label.request.common.name" 
							theme="aloc" maxlength="100"
						/>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="span12">
					<div class="form-row">
						<s:textfield name="requestDetails.transactionParties.triPartyApplicant.address[0]" 
							id="triPartyAddress1" 
							key="label.request.common.address1" 
							theme="aloc" maxlength="100"
						/>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="span12">
					<div class="form-row">
						<s:textfield name="requestDetails.transactionParties.triPartyApplicant.address[1]" 
							id="triPartyAddress2" 
							key="label.request.common.address2opt" 
							required="false"
							theme="aloc" maxlength="100"
						/>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="span12">
					<div class="form-row">
						<s:textfield name="requestDetails.transactionParties.triPartyApplicant.city" 
							id="triPartyAddressCity" 
							key="label.request.common.city" 
							theme="aloc" maxlength="50"
						/>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="span12">
					<div class="form-row">
						 <label class="optional"><s:text name="label.request.common.stateProvince"/> <s:text name="label.request.optional"/></label>
							<s:combobox listKey="stateName" listValue="stateName" headerKey="-1" headerValue="Select..." list="%{#attr['com.ge.aloc.StaticDataFactory'].stateList}"
								name="requestDetails.transactionParties.triPartyApplicant.stateProvince" id="triPartyAddressState" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="span12">
					<div class="form-row">
						<s:textfield name="requestDetails.transactionParties.triPartyApplicant.ZIPPostalCode" 
							id="triPartyAddressZip" 
							key="label.request.common.zipPostalCode" 
							theme="aloc" maxlength="12"	/>
						<p class="guidance"><s:text name="label.request.zipCodeGuidance" /></p>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="span12">
					<div class="form-row">
						<s:label key="label.request.common.country"
						theme="aloc"></s:label>
						<sj:autocompleter id="triPartyAddressCountryCd" list="%{#attr['com.ge.aloc.MasterDataFactory'].countries}" 
							name="requestDetails.transactionParties.triPartyApplicant.countryCd" maxlength="100" 
							cssClass="span3" listKey="countryCode" listValue="countryName" parentTheme="aloc" onChangeTopics="getAutocompleterName"/>
						<s:hidden name="requestDetails.transactionParties.triPartyApplicant.country" 
							id="triPartyAddressCountry" cssClass="autoCompleterName"></s:hidden>
					</div>
				</div>
			</div>
				<div class="row">
					<div class="span12">
						<div class="form-row ckeckBoxLabel">
							<label class="checkbox">
								<s:checkbox name="requestDetails.transactionParties.triPartyApplicant.futureUseFlag" fieldValue="true"></s:checkbox>
							</label><s:text name="label.request.common.saveforFutureuse"></s:text> 
								<span class="ttip info"	data-original-title="<s:text name="label.request.tooltip.saveForFutureUse"/>"></span>
						</div>
					</div>
					<!-- end of block -->
				</div>
			</div>
		</div>
		
		<h3 id="applicantHeader"><s:text name="label.request.applicant"></s:text>
			<span class="ttip info"
				data-original-title="<s:text name="label.request.tooltip.applicant" />" ></span>
		</h3>
		<hr class="hr3">
		<!-- Legal Entity Gold ID -->
		
		<div class="row">
			<c:if test="${empty requestDetails.transactionParties.tpApplicantDetails.leGoldId}">
				<c:set var="goldidClass" value="display: none;"/>
				<%-- <c:set var="goldidClearStyle" value="display: none;"/> --%>
			</c:if>
			<c:if test="${not empty requestDetails.transactionParties.tpApplicantDetails.leGoldId}">
				<s:set var="goldidSelected" value="%{'Yes'}"></s:set>
				<c:set var="goldidClass" value="display: block;"/>
				<%-- <c:set var="goldidClearStyle" value="display: inline;"/> --%>
			</c:if>
			
			<div class="form-row">
				<div class="span3">
					<s:textfield name="goldId" cssClass="span3 lookup-filterValue selectedGoldId" tooltip="%{getText('label.request.tooltip.legalEntity')}"
						id="leGoldId" theme="aloc" maxlength="200" key="label.request.LegalEntity"/>
					<span class="lookup-error hide" style="color: #AE2C2C;"></span>
					<p class="guidance"><s:text name="label.request.partialEntity" /> </p>
				</div>
				<div class="span6" style="margin-left: 0px;">
					<label>&nbsp;</label>
					<s:url action="LegalEntityLookup" namespace="/int" var="getLegalEntityURL" escapeAmp="false" encode="true">
						<s:param name="pageNumber">1</s:param>
					</s:url>
					<a class="btn-secondary lookup" href="<s:property value="#getLegalEntityURL"/>" ><s:text name="label.request.common.lookup"/></a>
					<img alt="Loading..." id="leIndicator" class="indicator" src="${pageContext.request.contextPath}/img/loading.gif" >
				</div>
			</div>
		</div>

		<div class="conditional-row" id="goldidShow" style="${goldidClass}">
		<s:hidden name="goldIdSelection" id="goldIdSelectionId" value="%{#goldidSelected}"/>
			<div class="row">
				<div class="span7">
					<div class="row">
						<div class="span2">
							<div class="form-row">
								<s:label  key="label.request.common.legalEntityNameC"/>
							</div>
						</div>
						<!-- end of block -->
						<div class="span4 right">
							<div class="form-row">
								<p><s:property value="requestDetails.transactionParties.tpApplicantDetails.leName"/></p>
								<s:hidden name="requestDetails.transactionParties.tpApplicantDetails.leName" id="tpApplicantLEName" 
								cssClass="LEName mandatory"></s:hidden>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="span2">
							<div class="form-row">
								<s:label  key="label.request.common.legalEntityGOLDIdC"/>
							</div>
						</div>
						<div class="span4 right">
							<div class="form-row">
								<p><s:property value="requestDetails.transactionParties.tpApplicantDetails.leGoldId"/></p>
								<s:hidden name="requestDetails.transactionParties.tpApplicantDetails.leGoldId" id="tpApplicantLEGoldID" cssClass="LEGoldID mandatory"></s:hidden>
							</div>
						</div>
						<!-- end of block -->
					</div>
				</div>
			</div>
		</div>
		
		<!-- Business Contact Person  -->
		
		<div class="row">
			<c:if test="${empty requestDetails.transactionParties.tpApplicantDetails.tpBuContactPerson.ssoId}">
				<c:set var="BusinessShowClass" value="display: none;"/>
				<%-- <c:set var="BusinessShowClearStyle" value="display: none;"/> --%>
			</c:if>
			<c:if test="${not empty requestDetails.transactionParties.tpApplicantDetails.tpBuContactPerson.ssoId}">
				<s:set var="personNameSelected" value="%{'Yes'}"></s:set>
				<c:set var="BusinessShowClass" value="display: block;"/>
				<%-- <c:set var="BusinessShowClearStyle" value="display: inline;"/> --%>
			</c:if>
			<div class="form-row">
				<div class="span3">
					<s:textfield name="personName" required="false" cssClass="span3 lookup-filterValue personName" maxlength="50"
					id="businessContactPersonId" theme="aloc" key="label.request.businessContactPerson" />
					<s:hidden name="businessContactName" value="BUC" cssClass="businessContactClass"></s:hidden>
					<p class="guidance">partial last name, first name or SSO </p>
					<span class="lookup-error hide" style="color: #AE2C2C;"></span>
				</div>
				<div class="span6" style="margin-left: 0px;">
					<label>&nbsp;</label>
					<s:url action="BusinessContactPersonLookup" namespace="/int" var="getBusinessContactPersonURL" escapeAmp="false" encode="true">
					</s:url> 
					<a class="btn-secondary lookup" href="<s:property value="#getBusinessContactPersonURL"/>"><s:text name="label.request.common.lookup"/></a>
					<img alt="Loading..." id="bcpIndicator" class="indicator" src="${pageContext.request.contextPath}/img/loading.gif" >
				</div>
			</div>
		</div>
		
		<div class="conditional-row" id="BusinessShow" style="${BusinessShowClass}">
			<s:hidden name="personNameSelection" id="personNameSelectionId" value="%{#personNameSelected}"/>
			<div class="row">
				<div class="span7">
						<div class="row">
							<div class="span2">
								<div class="form-row">
									<s:label key="label.request.businessContactPersonName"/>
								</div>
							</div>
							<div class="span4 right">	
								<div class="form-row">
									<p><s:property value="requestDetails.transactionParties.tpApplicantDetails.tpBuContactPerson.lastName"/>, <s:property value="requestDetails.transactionParties.tpApplicantDetails.tpBuContactPerson.firstName"/></p>
									<s:hidden name="requestDetails.transactionParties.tpApplicantDetails.tpBuContactPerson.lastName" id="tpApplicantBCPLName" ></s:hidden>
									<s:hidden name="requestDetails.transactionParties.tpApplicantDetails.tpBuContactPerson.firstName" id="tpApplicantBCPFName"></s:hidden>
								</div>
							</div><!-- end of block -->
						</div>
						<div class="row">
							<div class="span2">
								<div class="form-row">
									<s:label key="label.request.businessContactPersonSSO"/>
								</div>
							</div><!-- end of block -->
							<div class="span4 right">
								<div class="form-row">
									<p><s:property value="requestDetails.transactionParties.tpApplicantDetails.tpBuContactPerson.ssoId"/></p>
									<s:hidden name="requestDetails.transactionParties.tpApplicantDetails.tpBuContactPerson.ssoId" id="tpApplicantBCPSSO" ></s:hidden>
								</div>
							</div>
						</div>
					</div>
			</div>
		</div>
		
		<!-- Applicant Name -->
		<div id="tpApplicantDetailsDiv">
		<div class="row">
			<s:if test="%{tpApplicantAddressSelection == null}">
				<s:if test="%{requestDetails.transactionParties == null || requestDetails.transactionParties.tpApplicantDetails == null
				 || requestDetails.transactionParties.tpApplicantDetails.addressDtls == null || 
				 (requestDetails.transactionParties.tpApplicantDetails.addressDtls.name == null && 
					requestDetails.transactionParties.tpApplicantDetails.addressDtls.city == null &&
					requestDetails.transactionParties.tpApplicantDetails.addressDtls.stateProvince == null &&
					requestDetails.transactionParties.tpApplicantDetails.addressDtls.ZIPPostalCode == null &&
					requestDetails.transactionParties.tpApplicantDetails.addressDtls.country == null)}">
					<s:set var="tpApplicantAddressSelected" value="%{tpApplicantAddressSelection}" />
				</s:if>
				<s:else>
					<s:set var="tpApplicantAddressSelected" value="%{'Selected'}"></s:set>
				</s:else>
			</s:if>
			<s:else>
				<s:set var="tpApplicantAddressSelected" value="%{tpApplicantAddressSelection}" />
			</s:else>
			<s:if test="%{#tpApplicantAddressSelected == 'Selected'}">
				<c:set var="ApplicantShowClass" value="display: block;"/>
				<%-- <c:set var="ApplicantShowClearStyle" value="display: inline;"/> --%>
			</s:if>
			<s:else>
				<c:set var="ApplicantShowClass" value="display: none;"/>
				<%-- <c:set var="ApplicantShowClearStyle" value="display: none;"/> --%>
			</s:else>
			
			<div class="form-row">
				<div class="span3">
					<s:textfield name="nameForAddressTPApplicant" cssClass="span3 lookup-filterValue" id="nameAddressId" theme="aloc"
					maxlength="100" key="label.request.applicantNameAddress"/>
					<p class="guidance"><s:text name="label.request.nameAddressGuidance" /></p>
					<s:hidden name="tpapplicantNameAddressValue" value="yes" cssClass="nameAddressClass"></s:hidden>
					<span class="lookup-error hide" style="color: #AE2C2C;"></span>
				</div>
				<div class="span6" style="margin-left: 0px;">
					<label>&nbsp;</label>
					<s:url action="NameAddressLookup" namespace="/int" var="getApplicantNameAddressURL" escapeAmp="false" encode="true">
						<s:param name="addressTypeId">1</s:param>
					</s:url> 
					<a class="btn-secondary lookup" href="<s:property value="#getApplicantNameAddressURL"/>" ><s:text name="label.request.common.lookup"/></a>
					<img alt="Loading..." id="applicantAddressIndicator" class="indicator" src="${pageContext.request.contextPath}/img/loading.gif" >
				</div>	
					
			</div>
		</div>
		
		<div class="conditional-row" id="ApplicantShow" style="${ApplicantShowClass}">
			<s:hidden name="tpApplicantAddressSelection" id="tpApplicantAddressSelectionId" value="%{#tpApplicantAddressSelected}"/>
			<div class="row">
				<div class="span7">
					<div class="row">
						<div class="span2">
							<div class="form-row">
								<s:label key="label.request.applicantName"/>
							</div>
						</div>
						<div class="span4 right">	
							<div class="form-row" id="applicantName">
								<p><s:property value="requestDetails.transactionParties.tpApplicantDetails.addressDtls.name"/></p>
							</div>
						</div><!-- end of block -->
					</div>
					<div class="row">
						<div class="span2">
							<div class="form-row">
								<s:label key="label.request.applicantAddress"/>
							</div>
						</div><!-- end of block -->
						<div class="span4 right">
							<div class="form-row" id="applicantAddress">
								<s:iterator value="requestDetails.transactionParties.tpApplicantDetails.addressDtls.address">
									<p><s:property/> </p>
								</s:iterator>
								<p><s:property value="requestDetails.transactionParties.tpApplicantDetails.addressDtls.city"/>
								 <s:property value="requestDetails.transactionParties.tpApplicantDetails.addressDtls.stateProvince"/> 
								 <s:property value="requestDetails.transactionParties.tpApplicantDetails.addressDtls.ZIPPostalCode"/>
								 </p>
								<p><s:property value="requestDetails.transactionParties.tpApplicantDetails.addressDtls.country"/></p>
							</div>
						</div>
					</div>
				</div>
				<!-- end of block -->
			</div>
		</div>
		<div class="conditional-row-manually" id="ApplicantShowManually">
			<div class="row">
				<div class="span12">
					<div class="form-row">
						<s:textfield name="requestDetails.transactionParties.tpApplicantDetails.addressDtls.name" 
							id="applicantAddressName"
							key="label.request.common.name" 
							theme="aloc" maxlength="100"
							cssClass="mandatory"
						/>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="span12">
					<div class="form-row">
						<s:textfield name="requestDetails.transactionParties.tpApplicantDetails.addressDtls.address[0]" 
							id="applicantAddress1" 
							key="label.request.common.address1" 
							theme="aloc" maxlength="100"
							cssClass="mandatory"
						/>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="span12">
					<div class="form-row">
						<s:textfield name="requestDetails.transactionParties.tpApplicantDetails.addressDtls.address[1]" 
							id="applicantAddress2" 
							key="label.request.common.address2opt" 
							required="false"
							theme="aloc" maxlength="100"
						/>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="span12">
					<div class="form-row">
						<s:textfield name="requestDetails.transactionParties.tpApplicantDetails.addressDtls.city" 
							id="applicantAddressCity" 
							key="label.request.common.city" 
							theme="aloc" maxlength="50"
							cssClass="mandatory"
						/>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="span12">
					<div class="form-row">
						 <label class="optional"><s:text name="label.request.common.stateProvince"/> <s:text name="label.request.optional"/></label>
							<s:combobox listKey="stateName" listValue="stateName" headerKey="-1" headerValue="Select..." list="%{#attr['com.ge.aloc.StaticDataFactory'].stateList}"
								name="requestDetails.transactionParties.tpApplicantDetails.addressDtls.stateProvince" id="applicantAddressState" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="span12">
					<div class="form-row">
						<s:textfield name="requestDetails.transactionParties.tpApplicantDetails.addressDtls.ZIPPostalCode" 
							id="applicantAddressZip" 
							key="label.request.common.zipPostalCode" 
							theme="aloc" maxlength="12"
							cssClass="mandatory"/>
						<p class="guidance"><s:text name="label.request.zipCodeGuidance" /></p>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="span12">
					<div class="form-row">
						<s:label key="label.request.common.country"
						theme="aloc"></s:label>
						<sj:autocompleter id="applicantAddressCountryCd" list="%{#attr['com.ge.aloc.MasterDataFactory'].countries}" 
							name="requestDetails.transactionParties.tpApplicantDetails.addressDtls.countryCd" maxlength="100" 
							cssClass="span3" listKey="countryCode" listValue="countryName" parentTheme="aloc" onChangeTopics="getAutocompleterName"/>
						<s:hidden name="requestDetails.transactionParties.tpApplicantDetails.addressDtls.country" 
							id="applicantAddressCountry" cssClass="autoCompleterName mandatory"></s:hidden>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="span12">
					<div class="form-row ckeckBoxLabel">
						<label class="checkbox">
						<s:checkbox name="requestDetails.transactionParties.tpApplicantDetails.addressDtls.futureUseFlag" fieldValue="true"></s:checkbox>
						</label><s:text name="label.request.common.saveforFutureuse"></s:text> 
						<span class="ttip info"	data-original-title="<s:text name="label.request.tooltip.saveForFutureUse"/>"></span>
					</div>
				</div>
			</div>
		</div>
		</div>
		<div class="row">
			<div class="span12">
				<div class="form-row" style="padding-top:5px;">
					<c:if test="${empty requestDetails.transactionParties or empty requestDetails.transactionParties.tpApplicantDetails or empty requestDetails.transactionParties.tpApplicantDetails.refDetails}">
						<c:set var="geRefIndex" value="0"></c:set>
					</c:if>
					<c:if test="${not empty requestDetails.transactionParties.tpApplicantDetails.refDetails}">
						<c:set var="geRefIndex" value="${fn:length(requestDetails.transactionParties.tpApplicantDetails.refDetails)}"/>
						<c:if test="${geRefIndex gt 0}">
							<c:set var="geRefIndex" value="${geRefIndex - 1}"></c:set>
						</c:if>
					</c:if>
					<input type="hidden" id="bgGeReferenceFieldAddIndexId" name="bgGeReferenceFieldAddIndex" 
					class="referenceIndex" value="${geRefIndex}">
					<input type="hidden" name="sectionName" class="sectionName" value="tpApplicantDetails">
                   	<table style="border: 0; width: 100%;" id="additionalGERef" class="additionalTable">
                   		<tbody>
                       	<tr>
                       		<td height="1" class="noPadding">
                             	<s:textfield name="requestDetails.transactionParties.tpApplicantDetails.refDetails[0].refValue"
									theme="aloc" cssClass="mandatory"
									key="label.request.geApplicantReference" maxlength="30"
									tooltip="%{getText('label.request.tooltip.geAppRef')}">
								</s:textfield>
                            </td>
						</tr>
                        <c:if test="${not empty requestDetails.transactionParties.tpApplicantDetails.refDetails and geRefIndex >= 1}">
                        <c:forEach items="${requestDetails.transactionParties.tpApplicantDetails.refDetails}" begin="1" varStatus="statIndex">
                        <tr class="optional">
                           	<td height="1" style="padding:10px 0px 5px 0px;">
                           	<c:if test="${statIndex.count eq 1}">
                           	<s:textfield name="requestDetails.transactionParties.tpApplicantDetails.refDetails[1].refValue"
								theme="aloc" cssClass="referenceTextValue" maxlength="30" required="false"
								key="label.request.geApplicantReference2" >
							</s:textfield>
							</c:if>
							<c:if test="${statIndex.count eq 2}">
                           	<s:textfield name="requestDetails.transactionParties.tpApplicantDetails.refDetails[2].refValue"
								theme="aloc" cssClass="referenceTextValue" maxlength="30" required="false"
								key="label.request.geApplicantReference3" >
							</s:textfield>
							</c:if>
							&nbsp;<a href="javascript:;" class="delete-ce" >Remove reference</a>
                           	</td>
                        </tr>
                        </c:forEach>
                        </c:if>
						</tbody>
					</table>
                       <a href="javascript:;" class="add-exception" id="addAdditionalGERef" 
                       style="display: ${geRefIndex < 2 ? 'block' : 'none'}">Add additional GE reference</a>
					
				</div>
			</div><!-- end of block -->
		</div>
	
		<div class="row">
			<div class="span12">
				<div class="form-row">
					<s:textfield name="requestDetails.transactionParties.tpApplicantDetails.buUnit"
						theme="aloc" cssClass="span1 mandatory"
						key="label.request.buc" 
						id="bussUnitCodeId" maxlength="10"
						tooltip="%{getText('label.request.tooltip.buc')}">
					</s:textfield>
					
				</div>
			</div>
			<!-- end of block -->
		</div>
		
		<div class="row">
			<div class="span12">
				<div class="form-row">
					<s:textfield name="requestDetails.transactionParties.tpApplicantDetails.accDist"
						theme="aloc" cssClass="mandatory"
						key="label.request.adn" maxlength="30"
						tooltip="%{getText('label.request.tooltip.adn')}"
						id="accDistNoId">
					</s:textfield>
					<img src="${pageContext.request.contextPath}/img/loading.gif" class="indicator"
						id="bucadnLoading" align="middle"/>
					<img src="${pageContext.request.contextPath}/img/yes.png" title="Model Enabled" id="matched"
						style="vertical-align: middle; margin-left: 10px;display:none;" /> 
					<img src="${pageContext.request.contextPath}/img/no.png" title="Model Disabled" id="unMatched"
						style="vertical-align: middle; margin-left: 10px;display:none;" />
				</div>
			</div>
			<!-- end of block -->
		</div>
		<div class="row ibsClass" style="display: none;">
			<div class="span12">
				<div class="form-row">
					<p style="padding: 6px 0;" class="defaultFontSize"><s:property value="requestDetails.transactionParties.tpApplicantDetails.buUnit"/>
						<s:property value="requestDetails.transactionParties.tpApplicantDetails.accDist"/> </p>
				</div>
			</div>
		</div>
		
		<div class="row ibsClassNotification bucAdnTimeOut" style="display: none;">
            <div class="span12">
            <div class="errorbox">
				<div class="noteHead"><p class="noteicon"><s:text name="label.common.alert"/></p></div>
				<div class="noteContent">
					<p><s:text name="label.request.bucadNotification"/></p>
				</div>
				</div>
            </div>
        </div>
		<div class="row bucBlocked bucAdnTimeOut" style="display: none;">
            <div class="span12">
                <div class="errorbox">
                <div class="errorHead"><p class="erroricon"><s:text name="label.common.error"/></p></div>
				<div class="errorContent">
	                <p><s:text name="label.request.bucBlocked"/></p>
	                <p id="blockedBUCContact"><s:text name="label.request.ibsContact" /> </p>
                </div>
                </div>
            </div>
        </div>
		<div class="row ibsClassWarning bucAdnTimeOut" style="display: none;">
            <div class="span12">
                <div class="errorbox">
                <div class="errorHead"><p class="erroricon"><s:text name="label.common.error"/></p></div>
				<div class="errorContent">
                <p id="ibsMessage"><s:property value="requestDetails.transactionParties.tpApplicantDetails.IBSSystMsg"/></p>
                <p id="ibsContact"><s:text name="label.request.ibsContact" /> <s:property value="requestDetails.transactionParties.tpApplicantDetails.IBSLastName"/>, <s:property value="requestDetails.transactionParties.tpApplicantDetails.IBSFirstName"/> </p>
                <s:hidden name="requestDetails.transactionParties.tpApplicantDetails.IBSSystMsg" id="ibsSystemMsg"/>
				<s:hidden name="requestDetails.transactionParties.tpApplicantDetails.IBSMsgId" id="ibsSystemMsgId"/>
				<s:hidden name="requestDetails.transactionParties.tpApplicantDetails.IBSLastName" id="ibsLNameId"/>
				<s:hidden name="requestDetails.transactionParties.tpApplicantDetails.IBSFirstName" id="ibsFNameId"/>
				<s:hidden name="requestDetails.transactionParties.tpApplicantDetails.IBSPhoneNo" id="ibsPhoneId"/>
                </div>
                </div>
            </div>
        </div>

		<c:if test="${empty requestDetails.siteTypeName or (not empty requestDetails.siteTypeName and requestDetails.siteTypeName eq 'Financial Business')}">
		<div class="row hide" id="csoNoDiv">
			<div class="span12">
				<div class="form-row">
					<s:textfield name="requestDetails.transactionParties.tpApplicantDetails.csoNo"
					theme="aloc" key="label.request.csoNo" id="csoID" maxlength="20"
					tooltip="%{getText('label.request.tooltip.csoId')}"></s:textfield>
					<img src="${pageContext.request.contextPath}/img/loading.gif" class="indicator"
						id="csoleGoldLoading"/>
					<img src="${pageContext.request.contextPath}/img/yes.png" title="Model Enabled" id="csoMatched"
						style="vertical-align: middle; margin-left: 10px;display:none;" /> 
					<img src="${pageContext.request.contextPath}/img/no.png" title="Model Disabled" id="csoUnMatched"
						style="vertical-align: middle; margin-left: 10px;display:none;" />
					<span class="csoLEClass" style="padding: 6px 10px;"></span>
					<s:hidden name="validCSO" id="validCSOId"/>
				</div>
			</div>
			<!-- end of block -->
		</div>
		<div class="row hide" id="csoApprovalDtDiv">
			<div class="span12">
				<div class="form-row">
					<s:textfield name="requestDetails.transactionParties.tpApplicantDetails.csoApprovalDt"
					theme="aloc" key="label.request.csoDate" id="csoDateId"
					tooltip="%{getText('label.request.tooltip.csoDate')}"
					cssClass="date"></s:textfield>
				</div>
			</div>
			<!-- end of block -->
		</div>

		<div class="row hide" id="certifyDiv">
			<div class="span12">
				<div class="form-row">
					<s:checkbox name="requestDetails.transactionParties.tpApplicantDetails.certifyFlag" fieldValue="true" title="%{getText('label.request.csoCertify')}"
					theme="aloc-TransactionParties" cssClass="checkbox" id="certifyFlagID"></s:checkbox>
					<span class="ckeckBoxLabel"><s:text name="label.request.csoCertifyAgree"></s:text></span>
				</div>
			</div>
		</div>
		</c:if>

		
		
		<h3 id="customerHeader">
			<s:text name="label.request.customer" /> <span class="ttip info"
				data-original-title="<s:text name="label.request.tooltip.custBenfici"/>"></span>
		</h3>
		<hr class="hr3">
		<div class="row">
			<s:if test="%{tpCustomerAddressSelection == null}">
				<s:if test="%{requestDetails.transactionParties == null || requestDetails.transactionParties.customer == null
				 || requestDetails.transactionParties.customer.addressDtls == null || 
				 (requestDetails.transactionParties.customer.addressDtls.name == null && 
					requestDetails.transactionParties.customer.addressDtls.city == null &&
					requestDetails.transactionParties.customer.addressDtls.stateProvince == null &&
					requestDetails.transactionParties.customer.addressDtls.ZIPPostalCode == null &&
					requestDetails.transactionParties.customer.addressDtls.country == null)}">
					<s:set var="tpCustomerAddressSelected" value="%{tpCustomerAddressSelection}" />
				</s:if>
				<s:else>
					<s:set var="tpCustomerAddressSelected" value="%{'Selected'}"></s:set>
				</s:else>
			</s:if>
			<s:else>
				<s:set var="tpCustomerAddressSelected" value="%{tpCustomerAddressSelection}" />
			</s:else>
			
			<s:if test="%{#tpCustomerAddressSelected == 'Selected'}">
				<c:set var="CustomerBeneficiaryShowClass" value="display: block;"/>
				<%-- <c:set var="CustomerBeneficiaryShowClearStyle" value="display: inline;"/> --%>
			</s:if>
			<s:else>
				<c:set var="CustomerBeneficiaryShowClass" value="display: none;"/>
				<%-- <c:set var="CustomerBeneficiaryShowClearStyle" value="display: none;"/> --%>
			</s:else>
			
			<div class="form-row">
				<div class="span3">		
					<s:textfield name="nameForAddressTPCustomer" cssClass="span3 lookup-filterValue" id="customerNameAddressId" 
					theme="aloc" maxlength="100" key="label.request.customerNameAddress" />
					<p class="guidance"><s:text name="label.request.nameAddressGuidance" /></p>
					<s:hidden name="tpCustomerNameAddressValue" value="yes" cssClass="nameAddressClass"></s:hidden>
					<span class="lookup-error hide" style="color: #AE2C2C;"></span>
				</div>
				<div class="span6" style="margin-left: 0px;">
					<label>&nbsp;</label>
					<s:url action="NameAddressLookup" namespace="/int" var="getCustomerNameAddressURL" escapeAmp="false" encode="true">
						<s:param name="addressTypeId">3</s:param>
					</s:url> 
					<a class="btn-secondary lookup" href="<s:property value="#getCustomerNameAddressURL"/>" ><s:text name="label.request.common.lookup"/></a>
					<img alt="Loading..." id="customerAddressIndicator" class="indicator" src="${pageContext.request.contextPath}/img/loading.gif" >
				</div>
			</div>
		</div>
		
		
		
		<div class="conditional-row" id="CustomerBeneficiaryShow" style="${CustomerBeneficiaryShowClass}">
			<s:hidden name="tpCustomerAddressSelection" id="tpCustomerAddressSelectionId" value="%{#tpCustomerAddressSelected}"/>
			<div class="row">
				<div class="span12">
					<div class="form-row">
						
						
					</div>
				</div>
				<div class="span7">
						<div class="row">
							<div class="span2">
								<div class="form-row">
									<s:label key="label.request.customerName" />
								</div>
							</div>
							<div class="span4 right">	
								<div class="form-row" id="customerBeneficiaryName">
									<p><s:property value="requestDetails.transactionParties.customer.addressDtls.name"/></p>
								</div>
							</div><!-- end of block -->
						</div>
						<div class="row">
							<div class="span2">
								<div class="form-row">
									<s:label key="label.request.customerAddress" />
								</div>
							</div><!-- end of block -->
							<div class="span4 right">
								<div class="form-row" id="customerBeneficiaryAddress">
									<s:iterator value="requestDetails.transactionParties.customer.addressDtls.address">
										<p><s:property/> </p>
									</s:iterator>
									
									<p><s:property value="requestDetails.transactionParties.customer.addressDtls.city"/>
									 <s:property value="requestDetails.transactionParties.customer.addressDtls.stateProvince"/> 
									 <s:property value="requestDetails.transactionParties.customer.addressDtls.ZIPPostalCode"/>
									 </p>
									<p><s:property value="requestDetails.transactionParties.customer.addressDtls.country"/></p>
								</div>
							</div>
						</div>
					</div>
				<!-- end of block -->
			</div>
		</div>
		<div class="conditional-row-manually" id="CustomerBeneficiaryShowManually">
			<div class="row">
				<div class="span12">
					<div class="form-row">
						<s:textfield name="requestDetails.transactionParties.customer.addressDtls.name" 
							id="customerAddressName" 
							key="label.request.common.name" 
							theme="aloc" maxlength="100"
							cssClass="mandatory"
						/>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="span12">
					<div class="form-row">
						<s:textfield name="requestDetails.transactionParties.customer.addressDtls.address[0]" 
							id="customerAddress1" 
							key="label.request.common.address1" 
							theme="aloc" maxlength="100"
							cssClass="mandatory"
						/>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="span12">
					<div class="form-row">
						<s:textfield name="requestDetails.transactionParties.customer.addressDtls.address[1]" 
							id="customerAddress2" 
							key="label.request.common.address2opt" 
							required="false"
							theme="aloc" maxlength="100"
						/>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="span12">
					<div class="form-row">
						<s:textfield name="requestDetails.transactionParties.customer.addressDtls.city" 
							id="customerAddressCity" 
							key="label.request.common.city" 
							theme="aloc" maxlength="50"
							cssClass="mandatory"
						/>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="span12">
					<div class="form-row">
						 <label class="optional"><s:text name="label.request.common.stateProvince"/> <s:text name="label.request.optional"/></label>
							<s:combobox listKey="stateName" listValue="stateName" headerKey="-1" headerValue="Select..." list="%{#attr['com.ge.aloc.StaticDataFactory'].stateList}"
								name="requestDetails.transactionParties.customer.addressDtls.stateProvince" id="customerAddressState" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="span12">
					<div class="form-row">
						<s:textfield name="requestDetails.transactionParties.customer.addressDtls.ZIPPostalCode" 
							id="customerAddressZip" 
							key="label.request.common.zipPostalCode" 
							theme="aloc" maxlength="12"
							cssClass="mandatory"/>
						<p class="guidance"><s:text name="label.request.zipCodeGuidance" /></p>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="span12">
					<div class="form-row">
						<s:label key="label.request.common.country"
						theme="aloc"></s:label>
						<sj:autocompleter id="customerAddressCountryCd" list="%{#attr['com.ge.aloc.MasterDataFactory'].countries}" 
							name="requestDetails.transactionParties.customer.addressDtls.countryCd" 
							cssClass="span3" listKey="countryCode" listValue="countryName" parentTheme="aloc" onChangeTopics="getAutocompleterName"
							maxlength="100"/>
						<s:hidden name="requestDetails.transactionParties.customer.addressDtls.country" 
							id="customerAddressCountry" cssClass="autoCompleterName mandatory"></s:hidden>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="span12">
					<div class="form-row ckeckBoxLabel">
						<%-- <label class="checkbox"> <input type="checkbox"
							name="checkbox">Save for future use<span
							class="ttip info"
							data-original-title="This is an tooltip with more information"></span>
						</label> --%>
						<label class="checkbox">
						<s:checkbox name="requestDetails.transactionParties.customer.addressDtls.futureUseFlag" fieldValue="true"></s:checkbox>
						</label><s:text name="label.request.common.saveforFutureuse"></s:text> 
						<span class="ttip info"	data-original-title="<s:text name="label.request.tooltip.saveForFutureUse"/>"></span>
					</div>
				</div>
				<!-- end of block -->
			</div>
		</div>

		<div class="row">
			<div class="span12">
				<div class="form-row" style="padding-top:5px;">
					<c:if test="${empty requestDetails.transactionParties or empty requestDetails.transactionParties.customer or empty requestDetails.transactionParties.customer.refDetails}">
						<c:set var="custRefIndex" value="0"></c:set>
					</c:if>
					<c:if test="${not empty requestDetails.transactionParties.customer.refDetails}">
						<c:set var="custRefIndex" value="${fn:length(requestDetails.transactionParties.customer.refDetails)}"></c:set>
						<c:if test="${custRefIndex gt 0}">
							<c:set var="custRefIndex" value="${custRefIndex - 1}"></c:set>
						</c:if>
					</c:if>
					<input type="hidden" id="customerFieldAddIndexId" name="customerFieldAddIndex" 
						class="referenceIndex" value="${custRefIndex}">
					<input type="hidden" name="sectionName2" class="sectionName" value="customer">
                    <table style="border: 0; width: 100%;" id="additionalCustRef" class="additionalTable">
                    	<tr>
                        	<td height="1" class="noPadding">
                           		<s:textfield name="requestDetails.transactionParties.customer.refDetails[0].refValue"
									theme="aloc" cssClass="mandatory"
									key="label.request.customerReference" maxlength="30"
									tooltip="%{getText('label.request.tooltip.obligeeRef')}">
								</s:textfield>
                            </td>
						</tr>
                        <c:if test="${not empty requestDetails.transactionParties.customer.refDetails and custRefIndex >= 1}">
                        <c:forEach items="${requestDetails.transactionParties.customer.refDetails}" begin="1" varStatus="statIndex">
                            <tr class="optional">
                            	<td height="1" style="padding:10px 0px 5px 0px;">
                            	<c:if test="${statIndex.count eq 1}">
                            	<s:textfield name="requestDetails.transactionParties.customer.refDetails[1].refValue"
									theme="aloc" cssClass="referenceTextValue" maxlength="30" required="false"
									key="label.request.customerReference2" >
								</s:textfield>
								</c:if>
								<c:if test="${statIndex.count eq 2}">
                            	<s:textfield name="requestDetails.transactionParties.customer.refDetails[2].refValue"
									theme="aloc" cssClass="referenceTextValue" maxlength="30" required="false"
									key="label.request.customerReference3" >
								</s:textfield>
								</c:if>
								&nbsp;<a href="javascript:;" class="delete-ce" >Remove reference</a>
                            	</td>
                            </tr>
                           </c:forEach>
                         </c:if>
					</table>
                    <a href="javascript:;" class="add-exception" id="addAdditionalCustRef"
                    	style="display: ${custRefIndex < 2 ? 'block' : 'none'}">Add additional Customer/Beneficiary reference</a>
				</div>
			</div><!-- end of block -->
		</div>
			<script type="text/javascript">
				refreshSectionCount('transactionPartiesPanel');
			</script>
		</s:if>
		<s:elseif test="%{#isEditMode==false}" >
		<c:if test="${empty param.modelId or (not empty param.modelId and param.modelId eq '')}">
		<div class="row">
			<div class="span12">
				<div class="row lastrow">
					<div class="span33">
						<div class="form-row">
							<label><s:text name="label.request.selectedSite" /></label>
						</div>
					</div>
					<div class="span5 left">
						<div class="form-row">
							<p class="padding40">
								<s:property value="requestDetails.siteName" />
							</p>
						</div>
					</div>
				</div>
			</div>
			<!-- end of block -->
		</div>
		</c:if>
		<s:hidden name="requestDetails.transactionParties.instrumentPurposeId"
					id="instrumentPurposeId"
					value="%{requestDetails.transactionParties.instrumentPurposeId}" />
		<div class="row">
			<div class="span12">
				<div class="row lastrow">
					<div class="span33">
						<div class="form-row">
							<label><s:text name="label.request.instrumentPurpose" /></label>
						</div>
					</div>
					<div class="span5 left">
						<div class="form-row">
							<p class="padding40">
								<s:property value="requestDetails.transactionParties.instrumentPurpose" />
							</p>
						</div>
					</div>
				</div>
			</div>
			<!-- end of block -->
		</div>
		<c:if test="${requestDetails.transactionParties.instrumentPurposeId eq 16}">
		<div class="row">
			<div class="span12">
				<div class="row lastrow">
					<div class="span33">
						<div class="form-row">
							<label><s:text name="label.request.otherFees.other" /></label>
						</div>
					</div>
					<div class="span5 left">
						<div class="form-row">
							<p class="padding40">
								<s:property value="requestDetails.transactionParties.instrumentPurposeOther" />
							</p>
						</div>
					</div>
				</div>
			</div>
			<!-- end of block -->
		</div>
		</c:if>
		
		<c:if test="${requestDetails.siteTypeName eq 'Financial Business'}">
			<div class="row">
				<div class="span33">
					<div class="form-row">
						<label><s:text name="label.request.isTriPartyRequest" />:</label>
					</div>
				</div>
				<div class="span5 left">
					<div class="form-row">
						<p class="padding40">
							<s:if test="%{requestDetails.transactionParties.triPartyRequestFlag}">
								<s:text name="label.request.common.yes" />
							</s:if>
							<s:else>
								<s:text name="label.request.common.no" />
							</s:else>
						</p>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="span33">
					<div class="form-row">
						<label><s:text name="label.request.privateLabel" />:</label>
					</div>
				</div>
				<div class="span5 left">
					<div class="form-row">
						<p class="padding40">
							<s:if test="%{requestDetails.transactionParties.privateLabelFlag}">
								<s:text name="label.request.common.yes" />
							</s:if>
							<s:else>
								<s:text name="label.request.common.no" />
							</s:else>
						</p>
					</div>
				</div>
			</div>
		</c:if>
		
		<c:if test="${requestDetails.siteTypeName eq 'Financial Business'}">
		<s:if test="%{requestDetails.transactionParties.triPartyRequestFlag != null && requestDetails.transactionParties.triPartyRequestFlag}">
				
		<h3>
			<s:text name="label.request.triPartyApplicant" />
		</h3>
		<hr class="hr3">
		<div class="row">
			<div class="span12">
				<div class="row" style="margin-bottom: 0px;">
					<div class="span33">
						<div class="form-row">
							<label><s:text name="label.request.nameAndAddress" /></label>
						</div>
					</div>
					<div class="span5 left">
						<div class="form-row">
							<p class="padding40">
								<s:property
									value="requestDetails.transactionParties.triPartyApplicant.name" />
								<br />
								<s:iterator
									value="requestDetails.transactionParties.triPartyApplicant.address">
									<s:property />
									<br />
								</s:iterator>
	
								<s:property
									value="requestDetails.transactionParties.triPartyApplicant.city" />
								<s:property
									value="requestDetails.transactionParties.triPartyApplicant.stateProvince" />
								<s:property
									value="requestDetails.transactionParties.triPartyApplicant.ZIPPostalCode" />
								<br />
								<s:property
									value="requestDetails.transactionParties.triPartyApplicant.country" />
									
						<s:hidden name="requestDetails.transactionParties.triPartyApplicant.address[0]" id="triPartyAddress1" />
						<s:hidden name="requestDetails.transactionParties.triPartyApplicant.address[1]" id="triPartyAddress2" />
						<s:hidden name="requestDetails.transactionParties.triPartyApplicant.city" id="triPartyAddressCity"/>
						<s:hidden name="requestDetails.transactionParties.triPartyApplicant.stateProvinceCd" id="triPartyAddressStateCd"/>
						<s:hidden name="requestDetails.transactionParties.triPartyApplicant.stateProvince" id="triPartyAddressState" />
						<s:hidden name="requestDetails.transactionParties.triPartyApplicant.ZIPPostalCode" id="triPartyAddressZip"/>
						<s:hidden name="requestDetails.transactionParties.triPartyApplicant.countryCd" id="triPartyAddressCountryCd"/>
						<s:hidden name="requestDetails.transactionParties.triPartyApplicant.country" id="triPartyAddressCountry" />
							</p>
						</div>
					</div>
				</div>
	
			</div>
		</div>
		</s:if>
		</c:if>
		<h3>
			<s:text name="label.request.applicant" />
		</h3>
		<hr class="hr3">
		<div class="row">
			<div class="span33">
				<div class="form-row">
					<label><s:text name="label.request.common.legalEntityNameC" /></label>
				</div>
			</div>
			<div class="span5 left">
				<div class="form-row">
					<p class="padding40">
						<s:property
							value="requestDetails.transactionParties.tpApplicantDetails.leName" />
					</p>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="span33">
				<div class="form-row">
					<label><s:text
							name="label.request.common.legalEntityGOLDIdC" /></label>
				</div>
			</div>
			<div class="span5 left">
				<div class="form-row">
					<p class="padding40">
						<s:property
							value="requestDetails.transactionParties.tpApplicantDetails.leGoldId" />
					</p>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="span33">
				<div class="form-row">
					<label><s:text name="label.request.businessContactPerson" />:</label>
				</div>
			</div>
			<div class="span5 left">
				<div class="form-row">
					<p class="padding40">
					<s:if test="%{requestDetails.transactionParties.tpApplicantDetails.tpBuContactPerson.ssoId != null && requestDetails.transactionParties.tpApplicantDetails.tpBuContactPerson.ssoId !=''}">
					<s:property	value="requestDetails.transactionParties.tpApplicantDetails.tpBuContactPerson.lastName" />
						, <s:property value="requestDetails.transactionParties.tpApplicantDetails.tpBuContactPerson.firstName" />
						<s:property	value="requestDetails.transactionParties.tpApplicantDetails.tpBuContactPerson.ssoId" />
					</s:if>
					</p>
				</div>
			</div>
		</div>
		<s:if test="%{requestDetails.transactionParties.triPartyRequestFlag == null || requestDetails.transactionParties.triPartyRequestFlag == false}">
		<div class="row">
			<div class="span33">
				<div class="form-row">
					<label><s:text name="label.request.nameAndAddress" /></label>
				</div>
			</div>
			<div class="span5 left">
				<div class="form-row">
					<p class="padding40">
						<s:property
							value="requestDetails.transactionParties.tpApplicantDetails.addressDtls.name" />
						<br />
						<s:iterator
							value="requestDetails.transactionParties.tpApplicantDetails.addressDtls.address">
							<s:property />
							<br />
						</s:iterator>
	
						<s:property
							value="requestDetails.transactionParties.tpApplicantDetails.addressDtls.city" />
						<s:property
							value="requestDetails.transactionParties.tpApplicantDetails.addressDtls.stateProvince" />
						<s:property
							value="requestDetails.transactionParties.tpApplicantDetails.addressDtls.ZIPPostalCode" />
						<br />
						<s:property
							value="requestDetails.transactionParties.tpApplicantDetails.addressDtls.country" />
						
						<s:hidden name="requestDetails.transactionParties.tpApplicantDetails.addressDtls.address[0]" id="applicantAddress1" />
						<s:hidden name="requestDetails.transactionParties.tpApplicantDetails.addressDtls.address[1]" id="applicantAddress2" />
						<s:hidden name="requestDetails.transactionParties.tpApplicantDetails.addressDtls.city" id="applicantAddressCity"/>
						<s:hidden name="requestDetails.transactionParties.tpApplicantDetails.addressDtls.stateProvinceCd" id="applicantAddressStateCd"/>
						<s:hidden name="requestDetails.transactionParties.tpApplicantDetails.addressDtls.stateProvince" id="applicantAddressState" />
						<s:hidden name="requestDetails.transactionParties.tpApplicantDetails.addressDtls.ZIPPostalCode" id="applicantAddressZip"/>
						<s:hidden name="requestDetails.transactionParties.tpApplicantDetails.addressDtls.countryCd" id="applicantAddressCountryCd"/>
						<s:hidden name="requestDetails.transactionParties.tpApplicantDetails.addressDtls.country" id="applicantAddressCountry" />
					</p>
				</div>
			</div>
		</div>
		</s:if>
		<div class="row">
			<div class="span33">
				<div class="form-row">
					<label><s:text name="label.request.geApplicantReference" />:</label>
				</div>
			</div>
			<div class="span5 left">
				<div class="form-row">
					<p class="padding40">
						<s:property
							value="requestDetails.transactionParties.tpApplicantDetails.refDetails[0].refValue" />
					</p>
				</div>
			</div>
		</div>
		<s:set name="geRefSize"
			value="requestDetails.transactionParties.tpApplicantDetails.refDetails.size" />
		<s:if test="#geRefSize > 1">
			<div class="row" style="margin-bottom: 0px !important;">
				<div class="span12">
					<s:iterator value="requestDetails.transactionParties.tpApplicantDetails.refDetails" status="stat">
						<s:if test="#stat.index != 0">
							<div class="row">
								<div class="span33">
									<div class="form-row">
										<label><s:text
												name="label.request.geApplicantReference" />
											<s:property value="#stat.count" />:</label>
									</div>
								</div>
								<div class="span5 left">
									<div class="form-row">
										<p class="padding40">
											<s:property value="refValue" />
										</p>
									</div>
								</div>
							</div>
						</s:if>
					</s:iterator>
				</div>
			</div>
		</s:if>
		<div class="row">
			<div class="span33">
				<div class="form-row">
					<label><s:text name="label.request.buc" />:</label>
				</div>
			</div>
			<div class="span5 left">
				<div class="form-row">
					<p class="padding40">
						<s:property
							value="requestDetails.transactionParties.tpApplicantDetails.buUnit"/>
					</p>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="span33">
				<div class="form-row">
					<label><s:text name="label.request.adn" />:</label>
				</div>
			</div>
			<div class="span5 left">
				<div class="form-row">
					<p class="padding40">
						<s:property
							value="requestDetails.transactionParties.tpApplicantDetails.accDist" />
					</p>
				</div>
			</div>
		</div>
		<c:if test="${requestDetails.siteTypeName eq 'Financial Business'}">
			<div class="row">
				<div class="span12">
					<div class="row">
						<div class="span33">
							<div class="form-row">
								<label><s:text name="label.request.csoNo" />:</label>
							</div>
						</div>
						<div class="span5 left">
							<div class="form-row">
								<p class="padding40">
									<s:property
										value="requestDetails.transactionParties.tpApplicantDetails.csoNo" />
								</p>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="span33">
							<div class="form-row">
								<label><s:text name="label.request.csoDate" />:</label>
							</div>
						</div>
						<div class="span5 left">
							<div class="form-row">
								<p class="padding40">
									<s:property
										value="requestDetails.transactionParties.tpApplicantDetails.csoApprovalDt" />
								</p>
							</div>
						</div>
					</div>
					<div class="row" style="margin-bottom: 0px;">
						<div class="span33">
							<div class="form-row">
								<label><s:text name="label.request.csoCretified" />:</label>
							</div>
						</div>
						<div class="span5 left">
							<div class="form-row">
								<p class="padding40">Yes</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:if>
		<h3>
			<s:text name="label.request.customer" />
		</h3>
		<hr class="hr3">
		<div class="row">
			<div class="span33">
				<div class="form-row">
					<label><s:text name="label.request.nameAndAddress" />
					</label>
				</div>
			</div>
			<div class="span5 left">
				<div class="form-row">
					<p class="padding40">
						<s:property
							value="requestDetails.transactionParties.customer.addressDtls.name" />
						<br />
						<s:iterator
							value="requestDetails.transactionParties.customer.addressDtls.address">
							<s:property />
							<br />
						</s:iterator>
						<s:property
							value="requestDetails.transactionParties.customer.addressDtls.city" />
						<s:property
							value="requestDetails.transactionParties.customer.addressDtls.stateProvince" />
						<s:property
							value="requestDetails.transactionParties.customer.addressDtls.ZIPPostalCode" />
						<br />
						<s:property
							value="requestDetails.transactionParties.customer.addressDtls.country" />
						
						<s:hidden name="requestDetails.transactionParties.customer.addressDtls.address[0]" id="customerAddress1" />
						<s:hidden name="requestDetails.transactionParties.customer.addressDtls.address[1]" id="customerAddress2" />
						<s:hidden name="requestDetails.transactionParties.customer.addressDtls.city" id="customerAddressCity"/>
						<s:hidden name="requestDetails.transactionParties.customer.addressDtls.stateProvinceCd" id="customerAddressStateCd"/>
						<s:hidden name="requestDetails.transactionParties.customer.addressDtls.stateProvince" id="customerAddressState" />
						<s:hidden name="requestDetails.transactionParties.customer.addressDtls.ZIPPostalCode" id="customerAddressZip"/>
						<s:hidden name="requestDetails.transactionParties.customer.addressDtls.countryCd" id="customerAddressCountryCd"/>
						<s:hidden name="requestDetails.transactionParties.customer.addressDtls.country" id="customerAddressCountry" />
					</p>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="span33">
				<div class="form-row">
					<label><s:text name="label.request.customerReference" />:</label>
				</div>
			</div>
			<div class="span5 left">
				<div class="form-row">
					<p class="padding40">
						<s:property
							value="requestDetails.transactionParties.customer.refDetails[0].refValue" />
					</p>
				</div>
			</div>
		</div>
		<s:set name="customerRefSize"
			value="requestDetails.transactionParties.customer.refDetails.size" />
		<s:if test="#customerRefSize > 1">
			<div class="row">
				<div class="span12">
					<s:iterator value="requestDetails.transactionParties.customer.refDetails" status="stat">
						<s:if test="#stat.index != 0">
							<div class="row">
								<div class="span33">
									<div class="form-row">
										<label><s:text name="label.request.customerReference" />
											<s:property value="#stat.count" /></label>
									</div>
								</div>
								<div class="span5 left">
									<div class="form-row">
										<p class="padding40">
											<s:property value="refValue" />
										</p>
									</div>
								</div>
							</div>
						</s:if>
					</s:iterator>
				</div>
			</div>
		</s:if>
	</s:elseif>
