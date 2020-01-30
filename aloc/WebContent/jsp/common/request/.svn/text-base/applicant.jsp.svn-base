<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:if test="${param.includeScripts != false}">
<script type="text/javascript">
$(document).ready(function() {
	showHideApplicantAddress();
	sendbackOnloadShow();
});
</script>
</c:if>
<s:set name="isEditMode" value="editMode"/>
	<s:if test="%{#isEditMode==true || ((requestDetails.WFDetails.WFStage == 'REQEST' || requestDetails.WFDetails.WFStage == 'REQUEST' && #attr.isTaxonomy != true) && requestDetails.applicantDetails.requiresEdits)}">
	<s:if test="%{(requestDetails.WFDetails.WFStage == 'REQEST' || requestDetails.WFDetails.WFStage == 'REQUEST') && requestDetails.applicantDetails.requiresEdits}">
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
											<s:property value="requestDetails.applicantDetails.sendBackNotes" />
										</p>
									</div>
							</div>
					  </div>
				</div>
		</s:if>
		
		<a name="third"></a>
		<div class="row">
			<s:if test="%{applicantSelection == null}">
				<s:if test="%{requestDetails.applicantDetails == null || requestDetails.applicantDetails.addressDtls == null 
				|| (requestDetails.applicantDetails.addressDtls.name == null && 
					requestDetails.applicantDetails.addressDtls.city == null &&
					requestDetails.applicantDetails.addressDtls.stateProvinceCd == null &&
					requestDetails.applicantDetails.addressDtls.ZIPPostalCode == null &&
					requestDetails.applicantDetails.addressDtls.country == null)}">
					<s:set var="applicantNameSelected" value="%{applicantSelection}" />
				</s:if>
				<s:else>
					<s:set var="applicantNameSelected" value="%{'Selected'}"></s:set>
				</s:else>
			</s:if>
			<s:else>
				<s:set var="applicantNameSelected" value="%{applicantSelection}" />
			</s:else>
			<s:if test="%{#applicantNameSelected == 'Selected'}">
				<c:set var="applicantDetailsClass" value="display: block;"/>
				<c:set var="applicantDetailsClearStyle" value="display: inline;"/>
			</s:if>
			<s:else>
				<c:set var="applicantDetailsClass" value="display: none;"/>
				<c:set var="applicantDetailsClearStyle" value="display: none;"/>
			</s:else>
			
			<div class="form-row autosize-container">
				<div class="span3">
					 <s:textfield name="nameForApplicantAddress" cssClass="span3 lookup-filterValue"
					  	id="nameAddressId" theme="aloc" key="label.request.applicantNameAddress"/>
					  	<p class="guidance"><s:text name="label.request.nameAddressGuidance" /></p>
					  	<s:hidden name="applicantNameAddressValue" value="yes" cssClass="nameAddressClass"></s:hidden>
					 <span class="lookup-error hide" style="color: #AE2C2C;"></span>
				</div>
				<div class="span1">
					<label>&nbsp;</label>
					<s:url action="NameAddressLookup" namespace="/int" var="getApplicantNameAddressURL" escapeAmp="false" encode="true">
						<s:param name="addressTypeId">1</s:param>
						<s:param name="addressIndex">0</s:param>
						<s:param name="dlocAddressType">applicant</s:param>
					</s:url> 
					<a class="btn-secondary lookup" href="<s:property value="#getApplicantNameAddressURL"/>" ><s:text name="label.request.common.lookup"/></a>
				</div>
				<div class="span5">
					<label>&nbsp;</label>
					<img alt="Loading..." id="applicantAddressIndicator" class="indicator" src="${pageContext.request.contextPath}/img/loading.gif" style="height: 20px;display:none">
				</div>
			</div>
		</div>
		<!-- end of block -->
		<div class="conditional-row" id="ApplicantShow" style="${applicantDetailsClass}">
		<s:hidden name="applicantSelection" id="applicantSelectionId" value="%{#applicantNameSelected}"></s:hidden>
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
								<p><s:property value="requestDetails.applicantDetails.addressDtls.name" /></p>
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
								<s:iterator value="requestDetails.applicantDetails.addressDtls.address">
									<p><s:property/></p>
								</s:iterator>
								<p><s:property value="requestDetails.applicantDetails.addressDtls.city" /> 
								<s:property value="requestDetails.applicantDetails.addressDtls.stateProvince" /> 
								<s:property value="requestDetails.applicantDetails.addressDtls.ZIPPostalCode"/></p>
							    <p><s:property value="requestDetails.applicantDetails.addressDtls.country" /></p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="conditional-row-manually" id="ApplicantShowManually">
			<div class="row">
				<div class="span12">
					<div class="form-row">
						<s:textfield name="requestDetails.applicantDetails.addressDtls.name" cssClass="span3 mandatory"
						 id="applicantAddressName" theme="aloc" key="label.request.common.name" maxlength="100"/>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="span12">
					<div class="form-row">
						<s:textfield name="requestDetails.applicantDetails.addressDtls.address[0]" theme="aloc" 
						cssClass="span3 mandatory" id="applicantAddress1" key="label.request.common.address1" maxlength="100"/>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="span12">
					<div class="form-row">
						<label class="optional"><s:text name="label.request.address2Optional"/> - optional</label> 
						<s:textfield name="requestDetails.applicantDetails.addressDtls.address[1]" theme="aloc" 
						id="applicantAddress2" cssClass="span3" maxlength="100"/>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="span12">
					<div class="form-row">
						<s:textfield name="requestDetails.applicantDetails.addressDtls.city"
						 theme="aloc" id="applicantAddressCity" cssClass="span3 mandatory" key="label.request.city" maxlength="50"/>
					</div>
				</div>
			</div>
		<div class="row">
			<div class="span12">
				<div class="form-row">
					 <label class="optional"><s:text name="label.request.stateOrProvince"/> <s:text name="label.request.optional"/></label>
							<s:combobox listKey="stateName" listValue="stateName" headerKey="-1" headerValue="Select..." list="%{#attr['com.ge.aloc.StaticDataFactory'].stateList}"
								name="requestDetails.applicantDetails.addressDtls.stateProvince" id="applicantAddressState" />
				</div>
			</div>
		</div>
			<div class="row">
				<div class="span12">
					<div class="form-row">
						<s:textfield name="requestDetails.applicantDetails.addressDtls.ZIPPostalCode"
						 theme="aloc" id="applicantAddressZip" cssClass="span3 mandatory" key="label.request.zipOrPostalCode" maxlength="12"/>
						 <p class="guidance"><s:text name="label.request.zipCodeGuidance" /></p>
					</div>
				</div>
			</div>
			<div class="row">
						<div class="span12">
							<div class="form-row">
								<sj:autocompleter id="applicantCountryCd" list="%{#attr['com.ge.aloc.MasterDataFactory'].countries}" 
									name="requestDetails.applicantDetails.addressDtls.countryCd" key="label.request.country"
									cssClass="span3" listKey="countryCode" listValue="countryName" parentTheme="aloc" onChangeTopics="getAutocompleterName"/>
								<s:hidden name="requestDetails.applicantDetails.addressDtls.country" id="applicantAddressCountry" cssClass="autoCompleterName mandatory"></s:hidden>
							</div>
						</div>
						
					</div>
			<div class="row">
				<div class="span12">
					<div class="form-row ckeckBoxLabel">
						<label class="checkbox"> <s:checkbox name="requestDetails.applicantDetails.addressDtls.futureUseFlag" fieldValue="true"/>
						</label><s:text name="label.request.common.saveforFutureuse"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="span12">
				<div class="form-row" style="padding-top:5px;">
					<c:if test="${empty requestDetails.applicantDetails  or empty requestDetails.applicantDetails.refDetails}">
						<c:set var="appRefIndex" value="0"></c:set>
					</c:if>
					<c:if test="${not empty requestDetails.applicantDetails.refDetails}">
						<c:set var="appRefIndex" value="${fn:length(requestDetails.applicantDetails.refDetails)}"></c:set>
						<c:if test="${appRefIndex gt 0}">
							<c:set var="appRefIndex" value="${appRefIndex - 1}"></c:set>
						</c:if>
					</c:if>
					<input type="hidden" id="geregferenceFieldAddIndexId" name="geregferenceFieldAddIndex" 
					class="referenceIndex" value="${appRefIndex}">
					<input type="hidden" name="sectionName" class="sectionName" value="Applicant">
                   	<table style="border: 0; width: 100%;" id="additionalAppRef" class="additionalTable">
                   		<tbody>
                       	<tr>
                       		<td height="1" class="noPadding">
                             	<s:textfield name="requestDetails.applicantDetails.refDetails[0].refValue"
									theme="aloc" cssClass="requiredField mandatory"
									key="label.request.geApplicantReference" 
									tooltip="%{getText('label.request.tooltip.geAppRef')}" maxlength="30">
								</s:textfield>
                            </td>
						</tr>
                        <c:if test="${not empty requestDetails.applicantDetails.refDetails and appRefIndex >= 1}">
                        <c:forEach items="${requestDetails.applicantDetails.refDetails}" begin="1" varStatus="statIndex">
                        <tr class="optional">
                           	<td height="1" style="padding:10px 0px 5px 0px;">
                           	<c:if test="${statIndex.count eq 1}">
                           	<s:textfield name="requestDetails.applicantDetails.refDetails[1].refValue"
								theme="aloc" cssClass="referenceTextValue"
								key="label.request.geApplicantReference2" maxlength="30" >
							</s:textfield>
							</c:if>
							<c:if test="${statIndex.count eq 2}">
                           	<s:textfield name="requestDetails.applicantDetails.refDetails[2].refValue"
								theme="aloc" cssClass="referenceTextValue"
								key="label.request.geApplicantReference3" maxlength="30">
							</s:textfield>
							</c:if>
							&nbsp;<a href="javascript:;" class="delete-ce" >Remove reference</a>
                           	</td>
                        </tr>
                        </c:forEach>
                        </c:if>
						</tbody>
					</table>
                       <a href="javascript:;" class="add-exception" id="addAdditionalAppRef" 
                       style="display: ${appRefIndex < 2 ? 'block' : 'none'}">Add additional GE reference</a>
					
				</div>
			</div><!-- end of block -->
		</div>
		<script type="text/javascript">
			refreshSectionCount('applicantPanel');
		</script>
		</s:if>
		<s:elseif test="%{#isEditMode==false}">
			    <div class="row">
				    <div class="span2">
					    <div class="form-row">
					    <c:choose>
					    	<c:when test="${param.page eq 'BidReply'}">
					    		<label><s:text name="label.request.applicant"/>:</label>
					    	</c:when>
					    	<c:otherwise>
					    		<label><s:text name="label.request.common.nameAddress"/>:</label>
					    	</c:otherwise>
					    </c:choose>
					    </div>
				    </div>
					<div class="span5 left">
					    <div class="form-row">
							<p class="padding40"><c:out value="${requestDetails.applicantDetails.addressDtls.name}"/></p>
							<p class="padding40"><c:out value="${requestDetails.applicantDetails.addressDtls.address[0]}"/></p>
							<p class="padding40"><c:out value="${requestDetails.applicantDetails.addressDtls.address[1]}"/></p>
							<p class="padding40"><c:out value="${requestDetails.applicantDetails.addressDtls.city}"/> <c:out value="${requestDetails.applicantDetails.addressDtls.stateProvince}"/> <c:out value="${requestDetails.applicantDetails.addressDtls.ZIPPostalCode}"/></p>
							<p class="padding40"><c:out value="${requestDetails.applicantDetails.addressDtls.country}"/></p>
					    </div>
				    </div>
			    </div> <!-- end of block -->
			    <c:if test="${param.page ne 'BidReply'}">
				<s:iterator value="requestDetails.applicantDetails.refDetails" status="stat">
					<div class="row">
						<div class="span2">
							<div class="form-row">
								<label><s:text name="label.request.geApplicantReference"/>&nbsp;<s:property value="#stat.count" />:</label>
							</div>
						</div>
						<div class="span5 left">
							<div class="form-row">
								<p class="padding40"><c:out value="${refValue}"/></p>
							</div>
						</div><!-- end of block -->
					</div>
				</s:iterator>
				</c:if>
		</s:elseif>