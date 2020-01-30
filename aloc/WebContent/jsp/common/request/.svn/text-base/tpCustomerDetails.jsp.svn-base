<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<s:set name="isEditMode" value="editMode"/>
<s:if test="%{#isEditMode==true || ((requestDetails.WFDetails.WFStage == 'REQEST' || requestDetails.WFDetails.WFStage == 'REQUEST' && #attr.isTaxonomy != true) && requestDetails.transactionParties.customer.addressDtls.requiresEdits == true)}">
<c:if test="${param.includeScripts != false}">
<script	type="text/javascript">
$(document).ready(function() {
	showHideTPCustomerAddress();
	sendbackOnloadShow();
});
</script>
</c:if>
       <s:if test="%{(requestDetails.WFDetails.WFStage == 'REQEST' || requestDetails.WFDetails.WFStage == 'REQUEST') && requestDetails.transactionParties.customer.addressDtls.requiresEdits}">
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
								<c:out value="${requestDetails.transactionParties.customer.addressDtls.sendBackNotes}" />
							</p>
						</div>
					</div>
				</div>
			</div>
		</s:if>
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
			
			<div class="span12">
				<div class="form-row">
					
					<s:label key="label.request.customerNameAddress" />
					<s:textfield name="nameForAddressTPCustomer" cssClass="span3 lookup-filterValue" id="customerNameAddressId" 
					theme="aloc" maxlength="100"/>
					<s:hidden name="tpCustomerNameAddressValue" value="yes" cssClass="nameAddressClass"></s:hidden>
					<s:url action="NameAddressLookup" namespace="/int" var="getCustomerNameAddressURL" escapeAmp="false" encode="true">
						<s:param name="addressTypeId">3</s:param>
					</s:url> 
					<a class="btn-secondary lookup" href="<s:property value="#getCustomerNameAddressURL"/>" ><s:text name="label.request.common.lookup"/></a>
					
					<img alt="Loading..." id="customerAddressIndicator" class="indicator" 
						src="${pageContext.request.contextPath}/img/loading.gif" style="height: 20px; display:none">
					<%-- <a class="btn-tertiary right clear-conditional-results"	id="CustomerBeneficiaryClear" href="javascript:;" type="submit" style="${CustomerBeneficiaryShowClearStyle}"><s:text name="label.request.common.clearResults" /></a> --%>
					<p class="guidance"><s:text name="label.request.nameAddressGuidance" /></p>
					<span class="lookup-error hide" style="color: #AE2C2C;"></span>
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
							theme="aloc" maxlength="100" cssClass="mandatory"
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
							theme="aloc" maxlength="100" cssClass="mandatory"
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
							theme="aloc" maxlength="50" cssClass="mandatory"
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
			
		
			    <div class="form-mod">
				<h2 class="acc_triggerD"><a href="javascript:;">View Customer/Beneficiary references information</a></h2><hr class="h2-hr">
					<div class="acc_containerD">
			
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
									key="label.request.customerReference" 
									tooltip="%{getText('label.request.tooltip.obligeeRef')}" maxlength="30">
								</s:textfield>
                            </td>
						</tr>
                        <c:if test="${not empty requestDetails.transactionParties.customer.refDetails and custRefIndex >= 1}">
                        <c:forEach items="${requestDetails.transactionParties.customer.refDetails}" begin="1" varStatus="statIndex">
                            <tr class="optional">
                            	<td height="1" style="padding:10px 0px 5px 0px;">
                            	<c:if test="${statIndex.count eq 1}">
                            	<s:textfield name="requestDetails.transactionParties.customer.refDetails[1].refValue"
									theme="aloc" cssClass="referenceTextValue"
									key="label.request.customerReference2" maxlength="30" >
								</s:textfield>
								</c:if>
								<c:if test="${statIndex.count eq 2}">
                            	<s:textfield name="requestDetails.transactionParties.customer.refDetails[2].refValue"
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
                    <a href="javascript:;" class="add-exception" id="addAdditionalCustRef"
                    	style="display: ${custRefIndex < 2 ? 'block' : 'none'}">Add additional Customer/Beneficiary reference</a>
				</div>
			</div><!-- end of block -->
		</div>
		</div>
		</div>
		

		<div class="row">
			<div class="span12 btn-container">
				
			</div>
		</div>
		<script type="text/javascript">
			refreshSectionCount('tpCustomerbeneficiarySection');
		</script>
		</s:if>
		
		<s:elseif test="%{#isEditMode==false}" >
			
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
						<c:out
							value="${requestDetails.transactionParties.customer.addressDtls.name}" />
						<br />
						<s:iterator
							value="requestDetails.transactionParties.customer.addressDtls.address">
							<s:property />
							<br />
						</s:iterator>
						<c:out
							value="${requestDetails.transactionParties.customer.addressDtls.city}" />
						<c:out
							value="${requestDetails.transactionParties.customer.addressDtls.stateProvince}" />
						<c:out
							value="${requestDetails.transactionParties.customer.addressDtls.ZIPPostalCode}" />
						<br />
						<c:out
							value="${requestDetails.transactionParties.customer.addressDtls.country}" />
						<s:hidden name="requestDetails.transactionParties.customer.addressDtls.address[0]" id="customerAddress1"/>
						<s:hidden name="requestDetails.transactionParties.customer.addressDtls.address[1]" id="customerAddress2"/>
						<s:hidden name="requestDetails.transactionParties.customer.addressDtls.city" id="customerAddressCity"/>
						<s:hidden name="requestDetails.transactionParties.customer.addressDtls.stateProvinceCd" id="customerAddressStateCd"/>
						<s:hidden name="requestDetails.transactionParties.customer.addressDtls.stateProvince" id="customerAddressState"/>
						<s:hidden name="requestDetails.transactionParties.customer.addressDtls.ZIPPostalCode" id="customerAddressZip"/>
						<s:hidden name="requestDetails.transactionParties.customer.addressDtls.countryCd" id="customerAddressCountryCd"/>
						<s:hidden name="requestDetails.transactionParties.customer.addressDtls.country" id="customerAddressCountry"/>	
					</p>
				</div>
			</div>
		</div>
	
			    <div class="form-mod">
				<h2 class="acc_triggerD"><a href="javascript:;">View Customer/Beneficiary references information</a></h2><hr class="h2-hr">
					<div class="acc_containerD">
		
		<div class="row">
			<div class="span33">
				<div class="form-row">
					<label><s:text name="label.request.customerReference" />:</label>
				</div>
			</div>
			<div class="span5 left">
				<div class="form-row">
					<p class="padding40">
						<c:out
							value="${requestDetails.transactionParties.customer.refDetails[0].refValue}" />
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
											<c:out value="refValue" />
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
		
	</s:elseif>
