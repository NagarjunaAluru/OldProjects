<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<s:set name="isEditMode" value="editMode"/>
<s:if test="%{#isEditMode==true || ((requestDetails.WFDetails.WFStage == 'REQEST' || requestDetails.WFDetails.WFStage == 'REQUEST' && #attr.isTaxonomy != true) && requestDetails.transactionParties.tpApplicantDetails.requiresEdits == true)}">
<c:if test="${param.includeScripts != false}">
<script	type="text/javascript">
$(document).ready(function() {
	loadSiteSpecificfields();
	showHideTPApplicantAddress();
	showHideIbsMessage();
	sendbackOnloadShow();
	showHideCSOValidation();
});

</script>
</c:if>
       <s:if test="%{(requestDetails.WFDetails.WFStage == 'REQEST' || requestDetails.WFDetails.WFStage == 'REQUEST') && requestDetails.transactionParties.tpApplicantDetails.requiresEdits}">
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
								<c:out value="${requestDetails.transactionParties.tpApplicantDetails.sendBackNotes}" />
							</p>
						</div>
					</div>
				</div>
			</div>
		</s:if>
	    <div id="tpApplicantForm1">		
		<div class="row">
			<c:if test="${empty requestDetails.transactionParties.tpApplicantDetails.leGoldId}">
				<c:set var="goldidClass" value="display: none;"/>
			</c:if>
			<c:if test="${not empty requestDetails.transactionParties.tpApplicantDetails.leGoldId}">
				<s:set var="goldidSelected" value="%{'Yes'}"></s:set>
					<c:set var="goldidClass" value="display: block;"/>
			</c:if>
			<div class="span12">
				<div class="form-row">
					<s:textfield name="goldId" cssClass="span3 lookup-filterValue" id="leGoldId" theme="aloc" ket="label.request.LegalEntityGoldID"
					tooltip="%{getText('label.request.tooltip.legalEntity')}"/>
					<s:url action="LegalEntityLookup" namespace="/int" var="getLegalEntityURL" escapeAmp="false" encode="true">
						<s:param name="pageNumber">1</s:param>
					</s:url>
					<a class="btn-secondary lookup" href="<s:property value="#getLegalEntityURL"/>" ><s:text name="label.request.common.lookup"/></a>
					
					<img alt="Loading..." id="leIndicator" class="indicator" src="${pageContext.request.contextPath}/img/loading.gif" 
						style="height: 20px; display:none">
					<%-- <a class="btn-tertiary right clear-conditional-results"	id="goldidClear" href="javascript:;" type="submit">
						<s:text name="label.request.common.clearResults" />
					</a> --%>
					<br />
					<span class="lookup-error hide" style="color: #AE2C2C;"></span>
				</div>
			</div>
		</div>
		
		<div class="conditional-row" id="goldidShow" style="${goldidClass}">
		<s:hidden name="goldIdSelection" id="goldIdSelectionId" value="%{#goldidSelected}" />
		<s:hidden id="goldIdReqCount" value="%{#goldidSelected}"></s:hidden>
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
								<s:hidden name="requestDetails.transactionParties.tpApplicantDetails.leName" id="tpApplicantLEName" cssClass="LEName mandatory"></s:hidden>
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
		
		<div class="row" id="">
			<c:if test="${empty requestDetails.transactionParties.tpApplicantDetails.tpBuContactPerson.ssoId}">
			<c:set var="BusinessShowClass" value="display: none;"/>
			</c:if>
			<c:if test="${not empty requestDetails.transactionParties.tpApplicantDetails.tpBuContactPerson.ssoId}">
				<s:set var="personNameSelected" value="%{'Yes'}"></s:set>
			<c:set var="BusinessShowClass" value="display: block;"/>
			</c:if>
			<div class="span12">
				<div class="form-row">
					<s:textfield name="personName" required="false" cssClass="span3 lookup-filterValue" id="businessContactPersonId"
					key="label.request.businessContactPerson" theme="aloc"/>
					<s:hidden name="businessContactName" value="BUC" cssClass="businessContactClass"></s:hidden>
					<s:url action="BusinessContactPersonLookup" namespace="/int" var="getBusinessContactPersonURL" escapeAmp="false" encode="true">
					</s:url> 
					<a class="btn-secondary lookup" href="<s:property value="#getBusinessContactPersonURL"/>" ><s:text name="label.request.common.lookup"/></a>
					
					<img alt="Loading..." id="bcpIndicator" class="indicator" src="${pageContext.request.contextPath}/img/loading.gif" 
						style="height: 20px; display:none">
					<%-- <a class="btn-tertiary right clear-conditional-results"	id="BusinessClear" href="javascript:;" type="submit">
					<s:text name="label.request.common.clearResults" /></a> --%>
					<br />
					<p class="guidance"><s:text name="label.request.partialLastName" /></p>
					<span class="lookup-error hide" style="color: #AE2C2C;"></span>
				</div>
			</div>
		</div>
		
		<div class="conditional-row" id="BusinessShow" style="${BusinessShowClass}">
			<s:hidden name="personNameSelection" id="personNameSelectionId" value="%{#personNameSelected}" />
			<s:hidden id="personNameReqCount" value="%{#personNameSelected}"/>
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
									<s:hidden name="requestDetails.transactionParties.tpApplicantDetails.tpBuContactPerson.lastName" id="tpApplicantBCPLName"></s:hidden>
									<s:hidden name="requestDetails.transactionParties.tpApplicantDetails.tpBuContactPerson.firstName" id="tpApplicantBCPFName" ></s:hidden>
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
			<s:if test="%{requestDetails.transactionParties.triPartyRequestFlag == null || requestDetails.transactionParties.triPartyRequestFlag == false}">
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
			</s:if>
			<s:else>
				<c:set var="ApplicantShowClass" value="display: none;"/>
			</s:else>
			
			<div class="span12">
				<div class="form-row">
					<s:label key="label.request.nameAndAddress" />
					<s:textfield name="nameForAddress" cssClass="span3 lookup-filterValue" id="nameAddressId" />
					<s:hidden name="tpApplicantNameAddressValue" value="yes" cssClass="nameAddressClass"></s:hidden>
					<s:url action="NameAddressLookup" namespace="/int" var="getApplicantNameAddressURL" escapeAmp="false" encode="true">
						<s:param name="addressTypeId">1</s:param>
					</s:url> 
					<a class="btn-secondary lookup" href="<s:property value="#getApplicantNameAddressURL"/>" ><s:text name="label.request.common.lookup"/></a>
					
					<img alt="Loading..." id="applicantAddressIndicator" class="indicator" src="${pageContext.request.contextPath}/img/loading.gif" 
						style="height: 20px; display:none">
					<!-- <a class="btn-tertiary right clear-conditional-results"	id="ApplicantClear" href="javascript:;" type="submit">Clear results</a> -->
					<br />
					<p class="guidance"><s:text name="label.request.nameAddressGuidance" /></p>
					<span class="lookup-error hide" style="color: #AE2C2C;"></span>
				</div>
			</div>
		</div>
		
		<div class="conditional-row" id="ApplicantShow" style="${ApplicantShowClass}">
			<s:hidden name="tpApplicantAddressSelection" id="tpApplicantAddressSelectionId" value="%{#tpApplicantAddressSelected}" cssClass="mandatory"/>
			<s:hidden id="applicantReqCount" value="%{#tpApplicantAddressSelected}"/>
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
		<div class="conditional-row" id="ApplicantShowManually">
			<div class="row">
				<div class="span12">
					<div class="form-row">
						<s:textfield name="requestDetails.transactionParties.tpApplicantDetails.addressDtls.name" 
							id="applicantAddressName" 
							key="label.request.common.name" 
							theme="aloc"
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
							theme="aloc"
							cssClass="mandatory" maxlength="100"
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
							theme="aloc"
							cssClass="mandatory" maxlength="50"
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
							theme="aloc" maxlength="12" cssClass="mandatory"/>
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
							name="requestDetails.transactionParties.tpApplicantDetails.addressDtls.countryCd" 
							cssClass="span3" listKey="countryCode" listValue="countryName" parentTheme="aloc" onChangeTopics="getAutocompleterName"/>
						<s:hidden name="requestDetails.transactionParties.tpApplicantDetails.addressDtls.country" 
							id="applicantAddressCountry" cssClass="autoCompleterName mandatory"></s:hidden>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="span12">
					<div class="form-row ckeckBoxLabel">
						<%--  <input type="checkbox"
							name="checkbox">Save for future use<span
							class="ttip info"
							data-original-title="This is an tooltip with more information"></span>
						</label> --%>
						<label class="checkbox">
						<s:checkbox name="requestDetails.transactionParties.tpApplicantDetails.addressDtls.futureUseFlag" fieldValue="true">
						</s:checkbox>
						</label><s:text name="label.request.common.saveforFutureuse"></s:text> 
					</div>
				</div>
			</div>
		</div>
		</s:if>
		
			    <div class="form-mod">
				<h2 class="acc_triggerA"><a href="javascript:;">View GE Applicant reference information</a></h2><hr class="h2-hr">
		<div class="acc_containerA">
		
		<div class="row">
			<div class="span12">
				<div class="form-row" style="padding-top:5px;">
					<c:if test="${empty requestDetails.transactionParties or empty requestDetails.transactionParties.tpApplicantDetails or empty requestDetails.transactionParties.tpApplicantDetails.refDetails}">
						<c:set var="geRefIndex" value="0"></c:set>
					</c:if>
					<c:if test="${not empty requestDetails.transactionParties.tpApplicantDetails.refDetails}">
						<c:set var="geRefIndex" value="${fn:length(requestDetails.transactionParties.tpApplicantDetails.refDetails)}"></c:set>
						<c:if test="${geRefIndex gt 0}">
							<c:set var="geRefIndex" value="${geRefIndex - 1}"></c:set>
						</c:if>
					</c:if>
					<input type="hidden" id="bgGeReferenceFieldAddIndexId" name="bgGeReferenceFieldAddIndex" 
					class="referenceIndex" value="${geRefIndex}">
                   	<table style="border: 0; width: 100%;" id="additionalGERef" class="additionalTable">
                   		<tbody>
                       	<tr>
                       		<td height="1" class="noPadding">
                             	<s:textfield name="requestDetails.transactionParties.tpApplicantDetails.refDetails[0].refValue"
									theme="aloc" cssClass="mandatory"
									key="label.request.geApplicantReference" 
									tooltip="%{getText('label.request.tooltip.geAppRef')}" maxlength="30">
								</s:textfield>
                            </td>
						</tr>
                        <c:if test="${not empty requestDetails.transactionParties.tpApplicantDetails.refDetails and geRefIndex >= 1}">
                        <c:forEach items="${requestDetails.transactionParties.tpApplicantDetails.refDetails}" begin="1" varStatus="statIndex">
                        <tr class="optional">
                           	<td height="1" style="padding:10px 0px 5px 0px;">
                           	<c:if test="${statIndex.count eq 1}">
                           	<s:textfield name="requestDetails.transactionParties.tpApplicantDetails.refDetails[1].refValue"
								theme="aloc" cssClass="referenceTextValue"
								key="label.request.geApplicantReference2" maxlength="30">
							</s:textfield>
							</c:if>
							<c:if test="${statIndex.count eq 2}">
                           	<s:textfield name="requestDetails.transactionParties.tpApplicantDetails.refDetails[2].refValue"
								theme="aloc" cssClass="referenceTextValue"
								key="label.request.geApplicantReference3" maxlength="30" >
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
		</div>
		</div>
		
		
		
			    <div class="form-mod">
					<h2 class="acc_triggerB"><a href="javascript:;">View charge code information</a></h2><hr class="h2-hr">
					<div class="acc_containerB">
		
		<div class="row">
			<div class="span12">
				<div class="form-row">
					<s:textfield name="requestDetails.transactionParties.tpApplicantDetails.buUnit"
						theme="aloc" cssClass="mandatory"
						key="label.request.buc" 
						id="bussUnitCodeId"
						tooltip="%{getText('label.request.tooltip.applicant')}">
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
						key="label.request.adn" 
						tooltip="%{getText('label.request.tooltip.applicant')}"
						id="accDistNoId">
					</s:textfield>
					<img src="${pageContext.request.contextPath}/img/loading.gif" style="padding:10px 0 0 10px; height: 20px; display:none;" 
						id="bucadnLoading"/>
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
					<p style="padding: 6px 0;"><s:property value="requestDetails.transactionParties.tpApplicantDetails.buUnit"/>
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
		
		
		</div>
		</div>
		
		
		<c:if test="${requestDetails.siteTypeName eq 'Financial Business'}">
			    <div class="form-mod">
					<h2 class="acc_triggerC"><a href="javascript:;">View credit support obligation information</a></h2><hr class="h2-hr">
					<div class="acc_containerC">
		<div class="row">
			<div class="span12">
				<div class="form-row">
					<s:textfield name="requestDetails.transactionParties.tpApplicantDetails.csoNo"
					theme="aloc" key="label.request.csoNo" cssClass="mandatory" id="csoID" maxlength="20"
					tooltip="%{getText('label.request.tooltip.applicant')}"></s:textfield>
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
		<div class="row">
			<div class="span12">
				<div class="form-row">
					<s:textfield name="requestDetails.transactionParties.tpApplicantDetails.csoApprovalDt"
					theme="aloc" key="label.request.csoDate"
					tooltip="%{getText('label.request.tooltip.applicant')}"
					cssClass="date mandatory"></s:textfield>
				</div>
			</div>
			<!-- end of block -->
		</div>

		<div class="row">
			<div class="span12">
				<div class="form-row">
					<p><s:text name="label.request.csoCertify"/> </p>
                    <p>&nbsp;</p>
					<s:checkbox name="requestDetails.transactionParties.tpApplicantDetails.certifyFlag" fieldValue="true" 
					theme="aloc-TransactionParties" cssClass="checkbox" id="certifyFlagID" key="label.request.csoCertifyAgree"></s:checkbox>
					
				</div>
			</div>
		</div>
		</div>
		</div>
	</c:if>
		</div><!-- end of required count block -->
		<script type="text/javascript">
			refreshSectionCount('tpApplicantSection');
		</script>
		</s:if>
		<s:elseif test="%{#isEditMode==false}" >
			
		<div class="row">
			<div class="span33">
				<div class="form-row">
					<label><s:text name="label.request.common.legalEntityNameC" /></label>
				</div>
			</div>
			<div class="span5 left">
				<div class="form-row">
					<p class="padding40">
						<c:out
							value="${requestDetails.transactionParties.tpApplicantDetails.leName}" />
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
						<c:out
							value="${requestDetails.transactionParties.tpApplicantDetails.leGoldId}" />
					</p>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="span33">
				<div class="form-row">
					<label><s:text name="label.request.businessContactPerson" /></label>
				</div>
			</div>
			<div class="span5 left">
				<div class="form-row">
					<p class="padding40">
					<s:if test="%{requestDetails.transactionParties.tpApplicantDetails.tpBuContactPerson.ssoId != null && requestDetails.transactionParties.tpApplicantDetails.tpBuContactPerson.ssoId != ''}">
						<c:out value="${requestDetails.transactionParties.tpApplicantDetails.tpBuContactPerson.lastName}" />
						, <c:out value="${requestDetails.transactionParties.tpApplicantDetails.tpBuContactPerson.firstName}" />
						<c:out value="${requestDetails.transactionParties.tpApplicantDetails.tpBuContactPerson.ssoId}" />
					</s:if>
					</p>
				</div>
			</div>
		</div>
		<s:if test="%{requestDetails.transactionParties.triPartyRequestFlag == null || requestDetails.transactionParties.triPartyRequestFlag == false}">
		<div class="row">
			<div class="span33">
				<div class="form-row">
					<label>Name/address:</label>
				</div>
			</div>
			<div class="span5 left">
				<div class="form-row">
					<p class="padding40">
						<c:out
							value="${requestDetails.transactionParties.tpApplicantDetails.addressDtls.name}" />
						<br />
						<s:iterator
							value="requestDetails.transactionParties.tpApplicantDetails.addressDtls.address">
							<s:property />
							<br />
						</s:iterator>
	
						<c:out
							value="${requestDetails.transactionParties.tpApplicantDetails.addressDtls.city}" />
						<c:out
							value="${requestDetails.transactionParties.tpApplicantDetails.addressDtls.stateProvince}" />
						<c:out
							value="${requestDetails.transactionParties.tpApplicantDetails.addressDtls.ZIPPostalCode}" />
						<br />
						<c:out
							value="${requestDetails.transactionParties.tpApplicantDetails.addressDtls.country}" />
						
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
			    <div class="form-mod">
				<h2 class="acc_triggerA"><a href="javascript:;">View GE Applicant reference information</a></h2><hr class="h2-hr">
		<div class="acc_containerA">
		
		<div class="row">
			<div class="span33">
				<div class="form-row">
					<label><s:text name="label.request.geApplicantReference" /></label>
				</div>
			</div>
			<div class="span5 left">
				<div class="form-row">
					<p class="padding40">
						<c:out
							value="${requestDetails.transactionParties.tpApplicantDetails.refDetails[0].refValue}" />
					</p>
				</div>
			</div>
		</div>
		<s:set name="geRefSize"
			value="requestDetails.transactionParties.tpApplicantDetails.refDetails.size" />
		<s:if test="#geRefSize > 1">
			<div class="row">
				<div class="span12">
					<s:iterator value="requestDetails.transactionParties.tpApplicantDetails.refDetails" status="stat">
						<s:if test="#stat.index != 0">
							<div class="row">
								<div class="span33">
									<div class="form-row">
										<label><s:text
												name="label.request.geApplicantReference" />
											<s:property value="#stat.count" /></label>
									</div>
								</div>
								<div class="span5 left">
									<div class="form-row">
										<p class="padding40">
											<c:out value="${refValue}" />
										</p>
									</div>
								</div>
							</div>
						</s:if>
					</s:iterator>
				</div>
			</div>
		</s:if>
		</div>
		</div>
		
		
			    <div class="form-mod">
					<h2 class="acc_triggerB"><a href="javascript:;">View charge code information</a></h2><hr class="h2-hr">
					<div class="acc_containerB">
		
		
		<div class="row">
			<div class="span33">
				<div class="form-row">
					<label><s:text name="label.request.buc" /></label>
				</div>
			</div>
			<div class="span5 left">
				<div class="form-row">
					<p class="padding40" id="pBUC">
						<c:out
							value="${requestDetails.transactionParties.tpApplicantDetails.buUnit}" />
					</p>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="span33">
				<div class="form-row">
					<label><s:text name="label.request.adn" /></label>
				</div>
			</div>
			<div class="span5 left">
				<div class="form-row">
					<p class="padding40" id="pADN">
						<c:out
							value="${requestDetails.transactionParties.tpApplicantDetails.accDist}" />
					</p>
				</div>
			</div>
		</div>
		</div>
		</div>
		<c:if test="${requestDetails.siteTypeName eq 'Financial Business'}">
			    <div class="form-mod">
					<h2 class="acc_triggerC "><a href="javascript:;">View credit support obligation information</a></h2><hr class="h2-hr">
					<div class="acc_containerC">
			<div class="row">
				<div class="span12">
					<div class="row">
						<div class="span33">
							<div class="form-row">
								<label><s:text name="label.request.csoNo" /></label>
							</div>
						</div>
						<div class="span5 left">
							<div class="form-row">
								<p class="padding40">
									<c:out
										value="${requestDetails.transactionParties.tpApplicantDetails.csoNo}" />
								</p>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="span33">
							<div class="form-row">
								<label><s:text name="label.request.csoDate" /></label>
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
								<label><s:text name="label.request.csoCretified" /></label>
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
			</div>
			</div>
		</c:if>
	</s:elseif>
	
				
	
	
	
	
