<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:if test="${param.includeScripts != false}">
<script type="text/javascript">
$(document).ready(function() {
	showHideBeneficaryAddress();
	sendbackOnloadShow();
});
</script>
</c:if>
<s:set name="isEditMode" value="editMode"/>
		<s:if test="%{#isEditMode==true || ((requestDetails.WFDetails.WFStage == 'REQEST' || requestDetails.WFDetails.WFStage == 'REQUEST' && #attr.isTaxonomy != true) && requestDetails.beneficiaryDetails.requiresEdits)}">
		<s:if test="%{(requestDetails.WFDetails.WFStage == 'REQEST' || requestDetails.WFDetails.WFStage == 'REQUEST') && requestDetails.beneficiaryDetails.requiresEdits}">
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
											<s:property value="requestDetails.beneficiaryDetails.sendBackNotes" />
										</p>
									</div>
								</div>
							</div>
						</div>
					   </s:if>
		
		<a name="fourth"></a>
		<!-- end of block -->
		<c:if test="${empty requestDetails.beneficiaryDetails.leGoldId}">
			<c:set var="goldidClass" value="display: none;" />
			<c:set var="goldidClearStyle" value="display: none;"/>
		</c:if>
		<c:if test="${not empty requestDetails.beneficiaryDetails.leGoldId}">
			<c:set var="goldidClass" value="display: block;"/>
			<s:set var="beneficiaryGoldidSelected" value="%{'Yes'}"></s:set>
			<c:set var="goldidClearStyle" value="display: inline;"/>
		</c:if>
		<div class="row">
			<div class="form-row autosize-container">
				<div class="span3">
					<s:textfield key="label.request.legalEntity" name="beneficiaryGoldId" cssClass="span3 lookup-filterValue selectedGoldId" id="leGoldId" theme="aloc"
					tooltip="%{getText('label.request.tooltip.legalEntity')}"/>
					<span class="lookup-error hide" style="color: #AE2C2C;"></span>
					<div><p class="guidance"><s:text name="label.request.fullEntityName" /></p></div>
				</div>
				<div class="span1">
					<label>&nbsp;</label>
					<s:url action="LegalEntityLookup" namespace="/int" var="getLegalEntityURL" escapeAmp="false" encode="true">
					</s:url>
					<a class="btn-secondary lookup" href="<s:property value="#getLegalEntityURL"/>" ><s:text name="label.request.common.lookup"/></a>
				</div>
				<div class="span5">
			        <label>&nbsp;</label>	
					<img alt="Loading..." id="leIndicator" class="indicator" src="${pageContext.request.contextPath}/img/loading.gif" style="height:20px; display:none">
				</div>
			</div>
		</div>
		<div class="conditional-row" id="goldidShow" style="${goldidClass}">
		<s:hidden name="beneficiaryGoldIdSelection" id="beneficiaryGoldIdSelectionID" value="%{#beneficiaryGoldidSelected}"/>
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
								<p><s:property value="requestDetails.beneficiaryDetails.leName"/></p>
								<s:hidden name="requestDetails.beneficiaryDetails.leName" id="tpApplicantLEName" cssClass="LEName mandatory"></s:hidden>
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
								<p><s:property value="requestDetails.beneficiaryDetails.leGoldId"/></p>
								<s:hidden name="requestDetails.beneficiaryDetails.leGoldId" id="tpApplicantLEGoldID" cssClass="LEGoldID mandatory"></s:hidden>
							</div>
						</div>
						<!-- end of block -->
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<s:if test="%{beneficiaryAddressSelection == null}">
				<s:if test="%{requestDetails.beneficiaryDetails == null || 
				  requestDetails.beneficiaryDetails.addressDtls == null || 
				 (requestDetails.beneficiaryDetails.addressDtls.name == null && 
					requestDetails.beneficiaryDetails.addressDtls.city == null &&
					requestDetails.beneficiaryDetails.addressDtls.stateProvince == null &&
					requestDetails.beneficiaryDetails.addressDtls.ZIPPostalCode == null &&
					requestDetails.beneficiaryDetails.addressDtls.country == null)}">
					<s:set var="BeneficiaryNameSelected" value="%{beneficiaryAddressSelection}" />
				</s:if>
				<s:else>
					<s:set var="BeneficiaryNameSelected" value="%{'Selected'}"></s:set>
				</s:else>
			</s:if>
			<s:else>
				<s:set var="BeneficiaryNameSelected" value="%{beneficiaryAddressSelection}" />
			</s:else>
			<s:if test="%{#BeneficiaryNameSelected == 'Selected'}">
				<c:set var="BeneficiaryDetailsClass" value="display: block;"/>
				<c:set var="BeneficiaryDetailsClearStyle" value="display: inline;"/>
			</s:if>
			<s:else>
				<c:set var="BeneficiaryDetailsClass" value="display: none;"/>
				<c:set var="BeneficiaryDetailsClearStyle" value="display: none;"/>
			</s:else>
			<div class="form-row autosize-container">
				<div class="span3">
					<s:textfield name="nameForBeneficiaryAddress" cssClass="span3 lookup-filterValue nameForBeneficiaryAddress" 
						id="beneficiaryNameAddressId" theme="aloc" key="label.request.customerNameAddress"/>
						<p class="guidance"><s:text name="label.request.nameAddressGuidance" /></p>
						<s:hidden name="beneficiaryNameAddressValue" value="yes" cssClass="nameAddressClass"></s:hidden>
					<span class="lookup-error hide" style="color: #AE2C2C;"></span>
				</div>
				<div class="span1">
					<label>&nbsp;</label>
					<s:url action="NameAddressLookup" namespace="/int" var="getBeneficiaryNameAddressURL" escapeAmp="false" encode="true">
						<s:param name="addressTypeId">7</s:param>
						<s:param name="addressIndex">0</s:param>
						<s:param name="dlocAddressType">beneficiary</s:param>
					</s:url> 
					<a class="btn-secondary lookup" href="<s:property value="#getBeneficiaryNameAddressURL"/>" ><s:text name="label.request.common.lookup"/></a>
				</div>
				<div class="span5">
					<label>&nbsp;</label>			
					<img alt="Loading..." id="beneficiaryAddressIndicator" class="indicator" src="${pageContext.request.contextPath}/img/loading.gif" style="height:20px; display:none">
				</div>
			</div>
		</div>
		<!-- end of block -->
		<div class="conditional-row" id="BeneficiaryShow" style="${BeneficiaryDetailsClass}">
		<s:hidden name="beneficiaryAddressSelection" id="beneficiaryAddressSelectionID" value="%{#BeneficiaryNameSelected}"></s:hidden>
			<div class="row">
				<div class="span7">
					<div class="row">
						<div class="span2">
							<div class="form-row">
								<s:label key="label.request.custbenName"/>
							</div>
						</div>
						<div class="span4 right">	
							<div class="form-row" id="beneficiaryName">
								<p><s:property value="requestDetails.beneficiaryDetails.addressDtls.name"/></p>
							</div>
						</div><!-- end of block -->
					</div>
					<div class="row">
						<div class="span2">
							<div class="form-row">
								<s:label key="label.request.custbenAddr"/>
							</div>
						</div><!-- end of block -->
						<div class="span4 right">
							<div class="form-row" id="beneficiaryAddress">
							   <s:iterator value="requestDetails.beneficiaryDetails.addressDtls.address">
							      <p><s:property/> </p>
						       </s:iterator>
						       <p><s:property value="requestDetails.beneficiaryDetails.addressDtls.city"/> 
						       <s:property value="requestDetails.beneficiaryDetails.addressDtls.stateProvince"/> 
						       <s:property value="requestDetails.beneficiaryDetails.addressDtls.ZIPPostalCode"/></p> 
					           <p><s:property value="requestDetails.beneficiaryDetails.addressDtls.country"/></p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="conditional-row-manually" id="BeneficiaryShowManually">
			<div class="row">
				<div class="span12">
					<div class="form-row">
						<s:textfield name="requestDetails.beneficiaryDetails.addressDtls.name" 
						cssClass="span3 mandatory" id="beneficiaryAddressName" theme="aloc" key="label.request.common.name" maxlength="100"/>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="span12">
					<div class="form-row">
						<s:textfield name="requestDetails.beneficiaryDetails.addressDtls.address[0]"
						 cssClass="span3 mandatory" id="beneficiaryAddress1" theme="aloc" key="label.request.common.address1" maxlength="100"/>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="span12">
					<div class="form-row">
						<s:label  key="label.request.common.address2opt" cssClass="optional"/> 
						<s:textfield name="requestDetails.beneficiaryDetails.addressDtls.address[1]" cssClass="span3" id="beneficiaryAddress2" maxlength="100"/>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="span12">
					<div class="form-row">
						 <s:textfield name="requestDetails.beneficiaryDetails.addressDtls.city" 
						 cssClass="span3 mandatory" id="beneficiaryAddressCity" theme="aloc" key="label.request.common.city" maxlength="50"/>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="span12">
					<div class="form-row">
						 <label class="optional"><s:text name="label.request.common.stateProvince"/> <s:text name="label.request.optional"/></label>
							<s:combobox listKey="stateName" listValue="stateName" headerKey="-1" headerValue="Select..." list="%{#attr['com.ge.aloc.StaticDataFactory'].stateList}"
								name="requestDetails.beneficiaryDetails.addressDtls.stateProvince" id="beneficiaryAddressState" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="span12">
					<div class="form-row">
						<s:textfield name="requestDetails.beneficiaryDetails.addressDtls.ZIPPostalCode" 
						cssClass="span3 mandatory" id="beneficiaryAddressZip" theme="aloc" key="label.request.common.zipPostalCode" maxlength="12"/>
						<p class="guidance"><s:text name="label.request.zipCodeGuidance" /></p>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="span12">
					<div class="form-row">
						<sj:autocompleter id="beneficiaryCountryCd" list="%{#attr['com.ge.aloc.MasterDataFactory'].countries}"
							name="requestDetails.beneficiaryDetails.addressDtls.countryCd"  key="label.request.common.country" 
							cssClass="span3" listKey="countryCode" listValue="countryName" parentTheme="aloc" onChangeTopics="getAutocompleterName"/>
						<s:hidden name="requestDetails.beneficiaryDetails.addressDtls.country" id="beneficiaryAddressCountry" cssClass="autoCompleterName mandatory"></s:hidden>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="span12">
					<div class="form-row ckeckBoxLabel">
                          <label class="checkbox">
                            <s:checkbox name="requestDetails.beneficiaryDetails.addressDtls.futureUseFlag" fieldValue="true"></s:checkbox>
                           </label> <s:label key="label.request.common.saveforFutureuse" />
					</div>
				</div>
			</div>
		</div>

		
       <div class="row">
			<div class="span12">
				<div class="form-row" style="padding-top:5px;">
					<c:if test="${empty requestDetails.beneficiaryDetails or empty requestDetails.beneficiaryDetails.refDetails}">
						<c:set var="benRefIndex" value="0"></c:set>
					</c:if>
					<c:if test="${not empty requestDetails.beneficiaryDetails.refDetails}">
						<c:set var="benRefIndex" value="${fn:length(requestDetails.beneficiaryDetails.refDetails)}"></c:set>
						<c:if test="${benRefIndex gt 0}">
							<c:set var="benRefIndex" value="${benRefIndex - 1}"></c:set>
						</c:if>
					</c:if>
					<input type="hidden" id="geBenificiaryFieldAddIndexId" name="geBenificiaryFieldAddIndex" 
						class="referenceIndex" value="${benRefIndex}">
					<input type="hidden" name="sectionName" class="sectionName" value="CustBenficiary">
                    <table style="border: 0; width: 100%;" id="additionalBenRef" class="additionalTable">
                    	<tr>
                        	<td height="1" class="noPadding">
                           		<s:textfield name="requestDetails.beneficiaryDetails.refDetails[0].refValue"
									theme="aloc" cssClass="requiredField mandatory"
									key="label.request.customerReference" 
									tooltip="%{getText('label.request.tooltip.applicant')}" maxlength="30">
								</s:textfield>
                            </td>
						</tr>
                        <c:if test="${not empty requestDetails.beneficiaryDetails.refDetails and benRefIndex >= 1}">
                        <c:forEach items="${requestDetails.beneficiaryDetails.refDetails}" begin="1" varStatus="statIndex">
                            <tr class="optional">
                            	<td height="1" style="padding:10px 0px 5px 0px;">
                            	<c:if test="${statIndex.count eq 1}">
                            	<s:textfield name="requestDetails.beneficiaryDetails.refDetails[1].refValue"
									theme="aloc" cssClass="referenceTextValue"
									key="label.request.customerReference2" maxlength="30">
								</s:textfield>
								</c:if>
								<c:if test="${statIndex.count eq 2}">
                            	<s:textfield name="requestDetails.beneficiaryDetails.refDetails[2].refValue"
									theme="aloc" cssClass="referenceTextValue"
									key="label.request.customerReference3" maxlength="30">
								</s:textfield>
								</c:if>
								&nbsp;<a href="javascript:;" class="delete-ce" >Remove reference</a>
                            	</td>
                            </tr>
                           </c:forEach>
                         </c:if>
					</table>
                    <a href="javascript:;" class="add-exception" id="addAdditionalBenRef"
                    	style="display: ${benRefIndex < 2 ? 'block' : 'none'}">Add additional Customer/Beneficiary reference</a>
				</div>
			</div><!-- end of block -->
		</div>
		<script type="text/javascript">
			refreshSectionCount('beneficiaryPanel');
		</script>
		</s:if>
		<s:elseif test="%{#isEditMode==false}">
					<div class="row">
						<div class="span2">
							<div class="form-row">
								<s:label key="label.request.common.legalEntityNameC" />
							</div>
						</div>
						<div class="span5 left">
							<div class="form-row">
								<p class="padding40"><c:out value="${requestDetails.beneficiaryDetails.leName}"/></p>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="span2">
							<div class="form-row">
								<s:label key="label.request.common.legalEntityGOLDIdC" />
							</div>
						</div>
						<div class="span5 left">
							<div class="form-row">
								<p class="padding40"><c:out value="${requestDetails.beneficiaryDetails.leGoldId}"/></p>
							</div>
						</div>
					</div>
				
				<div class="row">
					
				    <div class="span2">
					    <div class="form-row">
						  <label><s:text name="label.request.common.nameAddress" /> :</label> 
					    </div>
				    </div>
					<div class="span5 left">
					    <div class="form-row">
					    	<p class="padding40"><c:out value="${requestDetails.beneficiaryDetails.addressDtls.name}"/></p>
							<p class="padding40"><c:out value="${requestDetails.beneficiaryDetails.addressDtls.address[0]}"/></p>
							<p class="padding40"><c:out value="${requestDetails.beneficiaryDetails.addressDtls.address[1]}"/></p>
							<p class="padding40"><c:out value="${requestDetails.beneficiaryDetails.addressDtls.city}"/> <c:out value="${requestDetails.beneficiaryDetails.addressDtls.stateProvince}"/> <c:out value="${requestDetails.beneficiaryDetails.addressDtls.ZIPPostalCode}"/></p>
							<p class="padding40"><c:out value="${requestDetails.beneficiaryDetails.addressDtls.country}"/></p>
					    </div>
				    </div>
			    </div> <!-- end of block -->
				
				<s:iterator value="requestDetails.beneficiaryDetails.refDetails" status="stat">
                <div class="row">
					<div class="span2">
						<div class="form-row">
							<label><s:text name="label.request.beneficiaryReference" />&nbsp;<s:property value="#stat.count" />:</label>
						</div>
					</div>
					<div class="span5 left">
						<div class="form-row">
							<p class="padding40"><c:out value="${refValue}"/></p>
						</div>
					</div><!-- end of block -->
				</div>
				</s:iterator>
				<c:if test="${requestDetails.WFDetails.WFStage eq 'REQEST'}">
				<s:if test="%{requestDetails.beneficiaryDetails.requiresEdits}">
					<div class="row">
						<div class="span2">
							<div class="form-row">
								<label> <s:text name="label.request.Sendbacknotes" /> :
								</label>
							</div>
						</div>
						<div class="span5 left">
							<div class="form-row">
								<p class="padding40">
									<c:out
										value="${requestDetails.beneficiaryDetails.sendBackNotes}" />
								</p>
							</div>
						</div>

					</div>
					</s:if>
				</c:if>
		</s:elseif>
