<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>

<s:set name="isEditMode" value="editMode"/>
<s:if test="%{#isEditMode==true || ((requestDetails.WFDetails.WFStage == 'REQEST' || requestDetails.WFDetails.WFStage == 'REQUEST'  && #attr.isTaxonomy != true) && requestDetails.deliveryInstructions.requiresEdits == true)}">
<c:if test="${param.includeScripts != false}">
<script	type="text/javascript">
$(document).ready(function() {
	deliveryTypeOnloadShow();
	sendbackOnloadShow();
});

</script>
</c:if>	
	     <s:if test="%{(requestDetails.WFDetails.WFStage == 'REQEST' || requestDetails.WFDetails.WFStage == 'REQUEST') && requestDetails.deliveryInstructions.requiresEdits}">
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
								<s:property value="requestDetails.deliveryInstructions.sendBackNotes" />
							</p>
						</div>
					</div>
				</div>
			</div>
		</s:if>
		<div class="row" id="deliveryDesignationDiv">
			<div class="span12">
				<div class="form-row mandatory">
					<s:label key="label.request.deliveryDesignationSWIFT"></s:label> 
					<s:radio theme="aloc" cssClass="radio"
							name="requestDetails.deliveryInstructions.deliveryDesignationFlag" 
							list="#{'Applicant':'Applicant','Beneficiary':'Beneficiary', 'OtherParty':'Other party'}"
							value="%{requestDetails.deliveryInstructions.deliveryDesignationFlag}"
							id="deliveryDesignationFlag" 
						/>
				</div>
			</div>			
		</div>
	<div class="row">
			<div class="span12">
				<div class="span12 mandatory" style="margin-left : 1px;">
                        <s:radio theme="aloc" cssClass="radio"
                            key="label.request.deliverType"
							name="requestDetails.deliveryInstructions.deliveryType" 
							list="#{'true':'In-person pick-up','false':'Physical delivery (via courier or certified post)'}"
							value="%{requestDetails.deliveryInstructions.deliveryType}"
							id="deliveryType" 
						/>
				</div>
				<br/><label class="right"><span style="margin-left: -810px; margin-top: 2px;" class="ttip info" data-original-title="<s:text name="label.request.tooltip.inpersonPickup"/>"></span></label><br/>
				<label class="right"><span style="margin-left: -660px; margin-top: 2px;" class="ttip info" data-original-title="<s:text name="label.request.tooltip.physicalDelivery"/>"></span></label>
			</div>
			<!-- end of block -->
		</div>
		
		<div id="pDelivery" class="row hide">
			<div class="span12">
				<div class="row">
					<div class="span12">
						<div class="form-row">
							<s:textfield name="requestDetails.deliveryInstructions.address1" 
								key="label.request.address1" id="address1"
								required="true" theme="aloc"/>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="span12">
						<div class="form-row">
							<s:textfield name="requestDetails.deliveryInstructions.address2" 
								id="address2" key="label.request.common.address2opt"
								required="false" theme="aloc"/>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="span12">
						<div class="form-row">
							<s:textfield name="requestDetails.deliveryInstructions.city" 
							key="label.request.city" id="city" required="true" 
							theme="aloc"/>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="span12">
						<div class="form-row">
							 <label class="optional"><s:text name="label.request.stateOrProvince"/> <s:text name="label.request.optional"/></label>
								<s:combobox listKey="stateName" listValue="stateName" headerKey="-1" headerValue="Select..." list="%{#attr['com.ge.aloc.StaticDataFactory'].stateList}"
									name="requestDetails.deliveryInstructions.stateProvince" id="deliveryAddressState" cssClass="comboDeliveryState"/>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="span12">
						<div class="form-row">
							<s:textfield name="requestDetails.deliveryInstructions.ZIPPostalcode"
							key="label.request.zipOrPostalCode" id="zipPostalcode"
							required="true" theme="aloc" maxlength="12"/>
							<p class="guidance"><s:text name="label.request.zipCodeGuidance" /></p>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="span12">
						<div class="form-row">
							<sj:autocompleter key="label.request.country" list="%{#attr['com.ge.aloc.MasterDataFactory'].countries}" onChangeTopics="getAutocompleterName" id="countryCode"
										name="requestDetails.deliveryInstructions.countryCd" cssClass="span3" listKey="countryCode" listValue="countryName" parentTheme="aloc"/>
							<s:hidden name="requestDetails.deliveryInstructions.country" id="deliveryAddresscountry" cssClass="autoCompleterName"></s:hidden>
						</div>
					</div>
				</div>
			</div>
		</div>
			
		<div class="row">
			<div class="span12">
				<div class="form-row">
					<s:textfield key="label.request.companyName" name="requestDetails.deliveryInstructions.companyName"
					 id="companyName" theme="aloc" cssClass="mandatory" maxlength="100"/>		
				</div>
			</div>
		</div>
		<div class="row">
			<div class="span12">
				<div class="form-row">
					<s:textfield name="requestDetails.deliveryInstructions.firstName" label="Recipient's first name"
					 id="firstName" theme="aloc" cssClass="mandatory" maxlength="50"/>
					<p class="guidance">
						<s:text name="label.request.givenName"/>
					</p>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="span12">
				<div class="form-row">
					<s:textfield name="requestDetails.deliveryInstructions.lastName" label="Recipient's last name"
					 id="lastName" theme="aloc" cssClass="mandatory" maxlength="50"/>
					<p class="guidance">
						<s:text name="label.request.surName"/>
					</p>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="span12">
				<div class="form-row">
					<s:textfield name="requestDetails.deliveryInstructions.title" id="title" key="label.request.titleOptional" required="false" theme="aloc" maxlength="50"/>
				</div>
			</div>
			<!-- end of block -->
		</div>
		
		<div class="row">
			<div class="span12">
				<div class="form-row">
					<s:textfield name="requestDetails.deliveryInstructions.phoneNo" id="phoneNumber"
					 key="label.request.phoneNumber" theme="aloc" cssClass="mandatory" maxlength="20"/>
					<p class="guidance">
						Include country and area code
					</p>
				</div>
			</div>
		</div>
		
		<div class="row">
                <div class="span12">
                    <div class="form-row ckeckBoxLabel">
                    	<label ><s:text  name="label.request.additionalDelivery"/>:</label>
                        <label class="checkbox">
                        	<s:checkbox name="requestDetails.deliveryInstructions.ecopyMyself"></s:checkbox>
                        </label><s:text  name="label.request.sendElectronicCopyToMyself"/>
						
                        <label class="checkbox">
                            <s:checkbox name="requestDetails.deliveryInstructions.ecopyOtherGEPerson" id="sendElectronic"></s:checkbox>
                        </label><s:text  name="label.request.sendElectronicCopyToOtherGERecipient"/>            
                    </div>
                </div>
            </div>         
		
		<div class="row hide" id="Recipient">
			<c:if test="${not requestDetails.deliveryInstructions.ecopyOtherGEPerson and empty requestDetails.deliveryInstructions.recipient.recipientSsoId}">
				<c:set var="RecipientShowClass" value="display: none;"/>
				<c:set var="RecipientClearStyle" value="display: none;"/>
			</c:if>
			<c:if test="${requestDetails.deliveryInstructions.ecopyOtherGEPerson and not empty requestDetails.deliveryInstructions.recipient.recipientSsoId}">
				<c:set var="RecipientShowClass" value="display: block;"/>
				<s:set var="recipientidSelected" value="%{'Selected'}"></s:set>
				<c:set var="RecipientShowClearStyle" value="display: inline;"/>
			</c:if>
              <div class="form-row">
                    <div class="span3">
                    	<s:textfield name="geRecipient" 
							id="geRecipient" required="false"
							key="label.request.geRecipient" 
							theme="aloc"
							cssClass="span3 lookup-filterValue"	/>
						<s:hidden name="businessContactName" value="BUC" cssClass="businessContactClass"></s:hidden>
						<p class="guidance"><s:text name="label.request.partialLastName" /></p>
						<span class="lookup-error hide" style="color: #AE2C2C;"></span>
					</div>
					<div class="span6" style="margin-left: 0px;">	
							<label>&nbsp;</label>
							<s:url action="GEReferenceLookup" namespace="/int" var="getRecipientURL" escapeAmp="false">
							</s:url>
							<a class="btn-secondary lookup" href="<s:property value="#getRecipientURL"/>" ><s:text name="label.request.common.lookup"/></a>
							
							<img alt="Loading..." id="recipientIndicator" class="indicator" 
								src="${pageContext.request.contextPath}/img/loading.gif">
					</div>
              </div>
            </div>        
		
		<div class="conditional-row hide" id="recipientShow" style="${RecipientShowClass}">
		<s:hidden name="recipientSelection" id="recipientSelectionId" value="%{#recipientidSelected}"></s:hidden>
            <div class="row">
            
                <div class="span7">
                    <div class="row">
                        <div class="span2">
                            <div class="form-row">
                                <label><s:text  name="label.request.recipient" /></label>
                            </div>
                        </div>
                        <div class="span4 right">	
                            <div class="form-row">
                                <p><s:property value="requestDetails.deliveryInstructions.recipient.recipientLastName"/>, <s:property value="requestDetails.deliveryInstructions.recipient.recipientFirstName"/> - <s:property value="requestDetails.deliveryInstructions.recipient.recipientSsoId"/></p>
                                <s:hidden name="requestDetails.deliveryInstructions.recipient.recipientLastName" id="recipientLastName"></s:hidden>
                                <s:hidden name="requestDetails.deliveryInstructions.recipient.recipientFirstName" id="recipientFirstName"></s:hidden>
                                <s:hidden name="requestDetails.deliveryInstructions.recipient.recipientSsoId" id="recipientSsoId"></s:hidden>
                            </div>
                        </div><!-- end of block -->
                    </div>
                    <div class="row">
                        <div class="span2">
                            <div class="form-row">
                                <label><s:text  name="label.request.geRecipientEmail"/></label>
                            </div>
                        </div><!-- end of block -->
                        <div class="span4 right">
                            <div class="form-row">
                                <p><s:property value="requestDetails.deliveryInstructions.recipient.recipientEmail"/></p>
                                
                                <s:hidden name="requestDetails.deliveryInstructions.recipient.recipientEmail" id="recipientEmail"></s:hidden>
                            </div>
                        </div>
                    </div>
            	</div>
                
			</div>
            </div>         
			<script type="text/javascript">
				refreshSectionCount('deliveryInstructionsPanel');
			</script>
		</s:if>
		<s:elseif test="%{#isEditMode==false}">
			<div class="row lastrow">
				<div class="span12">
				<div class="row">
					<div class="span3b">
						<div class="form-row">
						<label><s:text name="label.request.deliveryDesignationSWIFT" />:</label>
						</div>
					</div>
					<div class="span5 left">
						<div class="form-row">
							<p class="padding40"><c:out value="${requestDetails.deliveryInstructions.deliveryDesignationFlag}"/></p>
						</div>
					</div>
				</div>
				</div>
				</div>
			 <div class="row">
                    <div class="span3b">
						<div class="form-row">
							<label><s:text  name="label.request.deliverType"/></label>
						</div>
					</div>
					<div class="span5 left">
						<div class="form-row">
							<p class="padding40">
								<s:if test="%{requestDetails.deliveryInstructions.deliveryType}">
									<s:text name="label.request.inPersonPickUp" />
								</s:if>
								<s:else>
									<s:text name="label.request.physicalDelivery" />
								</s:else>
								
							</p>
						</div>
					</div>
				</div>
			
				<div class="row">
					<div class="span3b">
						<div class="form-row">
							<label><s:text  name="label.request.sendElectronicCopyToMyself"/>:</label>
						</div>
					</div>
					<div class="span5 left">
						<div class="form-row">
							<p class="padding40">
								<s:if test="%{requestDetails.deliveryInstructions.ecopyMyself}">
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
					<div class="span3b">
						<div class="form-row">
							<label>Send electronic copy to other GE recipient:</label>
						</div>
					</div>
					<div class="span5 left">
						<div class="form-row">
							<p class="padding40">
								<s:if test="%{requestDetails.deliveryInstructions.ecopyOtherGEPerson}">
									<s:text name="label.request.common.yes" />
								</s:if>
								<s:else>
									<s:text name="label.request.common.no" />
								</s:else>
							</p>
						</div>
					</div>
				</div>
				<s:if test="%{requestDetails.deliveryInstructions.ecopyOtherGEPerson}">
				<div class="row">
					<div class="span3b">
						<div class="form-row">
							<label><s:text  name="label.request.geRecipient"/>:</label>
						</div>
					</div>
					<div class="span5 left">
						<div class="form-row">
							<p class="padding40">
							<s:if test="%{requestDetails.deliveryInstructions.recipient.recipientSsoId != null && requestDetails.deliveryInstructions.recipient.recipientSsoId !=''}">
								<c:out value="${requestDetails.deliveryInstructions.recipient.recipientLastName}"/>, <c:out value="${requestDetails.deliveryInstructions.recipient.recipientFirstName}"/> - <c:out value="${requestDetails.deliveryInstructions.recipient.recipientSsoId}"/>
							</s:if></p>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="span3b">
						<div class="form-row">
							<label><s:text  name="label.request.geRecipientEmail"/></label>
						</div>
					</div>
					<div class="span5 left">
						<div class="form-row">
							<p class="padding40"><c:out value="${requestDetails.deliveryInstructions.recipient.recipientEmail}"/></p>
						</div>
					</div>
				</div>
				</s:if>
				
				<s:if test="%{requestDetails.deliveryInstructions.deliveryType == 'false' && requestDetails.deliveryInstructions.usePreviousAddress !=null && requestDetails.deliveryInstructions.usePreviousAddress !=''}"> 
				<div class="row">
					<div class="span3b">
						<div class="form-row">
							<label><s:text name="label.request.usepreviouslyEnteredAddressOptionalReview" />:</label> 
						</div>	
					</div>
					<div class="span5 left">
						<div class="form-row">
							<p class="padding40">
								<s:if test="%{requestDetails.deliveryInstructions.usePreviousAddress == 'TransactionParties'}">
									<s:text name="label.request.transactionParties"/>
								</s:if>
								<s:if test="%{requestDetails.deliveryInstructions.usePreviousAddress == 'CustomerBeneficiary'}">
									<s:text name="label.request.customerBeneficiary"/>
								</s:if>
							</p>
						</div>
					</div>
				</div>
				</s:if>
				
				<div class="row">
					<div class="span3b">
						<div class="form-row">
							<label><s:text name="label.request.companyName" />:</label> 
						</div>	
					</div>
					<div class="span5 left">
						<div class="form-row">
							<p class="padding40"><c:out value="${requestDetails.deliveryInstructions.companyName}"/></p>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="span3b">
						<div class="form-row">
							<label>Recipient's first name:</label>
						</div>
					</div>
					<div class="span5 left">
						<div class="form-row">
							<p class="padding40"><c:out value="${requestDetails.deliveryInstructions.firstName}"/></p>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="span3b">
						<div class="form-row">
							<label>Recipient's last name:</label>
						</div>	
					</div>
					<div class="span5 left">
						<div class="form-row">
							<p class="padding40"><c:out value="${requestDetails.deliveryInstructions.lastName}"/></p>
						</div>
					</div>
				</div>
				
				<div class="row">
					<div class="span3b">
						<div class="form-row">
							<label><s:text name="label.request.titleOptional" />:</label>
						</div>
					</div>
					<div class="span5 left">
						<div class="form-row">
							<p class="padding40"><c:out value="${requestDetails.deliveryInstructions.title}"/></p>
						</div>
					</div>
				</div>
				<s:if test="%{requestDetails.deliveryInstructions.deliveryType == 'false' }"> 
				<div class="row lastrow">
					<div class="span3b">
						<div class="form-row">
							<label><s:text name="label.request.address" />:</label>
						</div>
					</div> 
					<div class="span5 left">
						<div class="form-row">
							<p class="padding40">
							<c:out value="${requestDetails.deliveryInstructions.companyName}"/><br />
							<c:out value="${requestDetails.deliveryInstructions.address1}"/><br />
							<c:out value="${requestDetails.deliveryInstructions.address2}"/><br />
							<c:out value="${requestDetails.deliveryInstructions.city}"/> <c:out value="${requestDetails.deliveryInstructions.stateProvince}"/> <c:out value="${requestDetails.deliveryInstructions.ZIPPostalcode}"/><br />
							<c:out value="${requestDetails.deliveryInstructions.country}"/></p>
						</div>
					</div> 
				</div>
				</s:if>
				
				<div class="row">
					<div class="span3b">
						<div class="form-row">
						<label><s:text name="label.request.phoneName" />:</label>
						</div>
					</div>
					<div class="span5 left">
						<div class="form-row">
							<p class="padding40"><c:out value="${requestDetails.deliveryInstructions.phoneNo}"/></p>
						</div>
					</div>
				</div>
		</s:elseif>