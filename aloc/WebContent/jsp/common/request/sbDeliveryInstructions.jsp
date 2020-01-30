<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<s:set name="isEditMode" value="editMode"/>
	  <s:if test="%{#isEditMode==true || ((requestDetails.WFDetails.WFStage == 'REQEST' || requestDetails.WFDetails.WFStage == 'REQUEST'  && #attr.isTaxonomy != true) && requestDetails.deliveryInstructions.requiresEdits == true)}">
	  	<c:if test="${param.includeScripts != false}">
		<script type="text/javascript">
		$(document).ready(function() {
			deliveryTypeOnloadShow(); 
			decCounter("specialInstructions", 400);
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
								<s:property
									value="requestDetails.deliveryInstructions.sendBackNotes" />
							</p>
						</div>
					</div>
				</div>
			</div>
		</s:if>
						
	  <div id="deliveryInstructions">
		<%-- <c:if test="${empty requestDetails.businessReApprovalFlag}">
			<p class="requiredCounter">
         		<strong><s:text name="label.request.common.requiredFields"/></strong>&nbsp;&nbsp; <span id="pendingReqDelivery"></span> / <span id="totalReqDelivery"></span>
     		</p>
		</c:if> --%>
	<div class="row">
			<div class="span12">
				<div class="span12 mandatory" style="margin-left : 1px;">
				      <s:radio theme="aloc" cssClass="radio" key="label.request.deliverType"
							name="requestDetails.deliveryInstructions.deliveryType" 
							list="#{'true':'In-person pick-up','false':'Physical delivery (via courier or certified post)'}"
							value="%{requestDetails.deliveryInstructions.deliveryType}"
							id="deliveryType" 
						/>
				</div>
				<br/><label class="right"><span style="margin-left: -815px; margin-top: 2px;" class="ttip info" data-original-title="<s:text name="label.request.tooltip.inpersonPickup"/>"></span></label><br/>
				<label class="right"><span style="margin-left: -665px; margin-top: 2px;" class="ttip info" data-original-title="<s:text name="label.request.tooltip.physicalDelivery"/>"></span></label>
			</div>
			<!-- end of block -->
		</div>
	<div id="pDelivery1" class="row hide">
	<div class="span12">
	<div class="row">
		<div class="span12">
			<div class="form-row">
				<label class="optional"><s:text
						name="label.request.usepreviouslyEnteredAddressOptional" /></label>
				<s:select name="requestDetails.deliveryInstructions.usePreviousAddress" id="addressSelection" 
				 	headerValue="Select..." headerKey="" key=""
					list="#{'PrincipalDetails':'Principal Details','ObligeeDetails':'Obligee Details'}">
				</s:select>
			</div>
		</div>
	</div>
	</div>
	</div>
	<div class="row">
			<div class="span12">
				<div class="form-row">
					<s:textfield key="label.request.companyName" cssClass="mandatory"
					  name="requestDetails.deliveryInstructions.companyName" id="companyName" theme="aloc" maxlength="100"/>		
				</div>
			</div>
		</div>
		<div class="row">
			<div class="span12">
				<div class="form-row">
					<s:textfield key="label.request.recipientsFirstName" cssClass="mandatory"
					 name="requestDetails.deliveryInstructions.firstName" id="firstName" theme="aloc" maxlength="50"/>
					<p class="guidance">
						<s:text name="label.request.givenName"/>
					</p>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="span12">
				<div class="form-row">
					<s:textfield key="label.request.recipientsLastName" cssClass="mandatory"
					 name="requestDetails.deliveryInstructions.lastName" id="lastName" theme="aloc" maxlength="50"/>
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
		<div id="pDelivery" class="row hide">
			<div class="span12">
				<div class="row">
					<div class="span12">
						<div class="form-row">
							<s:textfield name="requestDetails.deliveryInstructions.address1" key="label.request.address1" id="sbAddress1" theme="aloc" maxlength="100"/>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="span12">
						<div class="form-row">
							<s:textfield name="requestDetails.deliveryInstructions.address2" id="sbAddress2" key="label.request.address2Optional" required="false" theme="aloc" maxlength="100"/>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="span12">
						<div class="form-row">
							<s:textfield name="requestDetails.deliveryInstructions.city" key="label.request.city" id="sbCity" theme="aloc" maxlength="50"/>
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
							<s:textfield name="requestDetails.deliveryInstructions.ZIPPostalcode" key="label.request.zipOrPostalCode" id="zipPostalcode" theme="aloc" maxlength="12"/>
							<p class="guidance"><s:text name="label.request.zipCodeGuidance" /></p>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="span12">
						<div class="form-row">
							<sj:autocompleter list="%{#attr['com.ge.aloc.MasterDataFactory'].countries}" onChangeTopics="getAutocompleterName" id="sbCountryCode"
								key="label.request.country"	name="requestDetails.deliveryInstructions.countryCd" cssClass="span3" listKey="countryCode" listValue="countryName" parentTheme="aloc"/>
							<s:hidden name="requestDetails.deliveryInstructions.country" id="deliveryAddresscountry" cssClass="autoCompleterName"></s:hidden>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="span12">
				<div class="form-row">
					<s:textfield name="requestDetails.deliveryInstructions.phoneNo" cssClass="mandatory"
					id="phoneNumber" key="label.request.phoneNumber" theme="aloc" maxlength="20"/>
					<p class="guidance">
						<s:text name="label.request.includeCountryAndAreaCode"/>
					</p>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="span12">
				<div class="form-row">
					<s:textarea cssClass="autosize messageinput mandatory" cols="50" rows="1" onkeypress="return imposeMaxLength(this, 399);"
						name="requestDetails.deliveryInstructions.specialInstructions" key="label.request.specialInstructions"
						theme="aloc" id="specialInstructions" > </s:textarea>
					<div class="clear"></div>
                    <div class="counter"><s:text  name="label.common.siteAdmin.fourHundred"/></div> <!-- fix positions -->
                    <div class="counterTxt"><p class="guidance"><s:text  name="label.common.siteAdmin.limit400Characters"/></p></div>
				</div>
				<!-- end of block -->
			</div>
		</div>			
		<div class="row">
                <div class="span12">
                    <div class="form-row ckeckBoxLabel">
                    	<label ><s:text  name="label.request.additionalDelivery"/>:</label>
                        <label class="checkbox">
                        	<s:checkbox name="requestDetails.deliveryInstructions.ecopyMyself" ></s:checkbox>
                        </label><s:text  name="label.request.sendElectronicCopyToMyself"/>
                        <label class="checkbox">
                            <s:checkbox name="requestDetails.deliveryInstructions.ecopyOtherGEPerson" id="sendElectronic"></s:checkbox>
                        </label> <s:text  name="label.request.sendElectronicCopyToOtherGERecipient"/>                
                    </div>
                </div>
            </div>  
		<div class="row hide" id="Recipient">
			<c:if test="${empty requestDetails.deliveryInstructions.recipient.recipientSsoId}">
				<c:set var="RecipientShowClass" value="display: none;"/>
				<c:set var="RecipientClearStyle" value="display: none;"/>
			</c:if>
			<c:if test="${not empty requestDetails.deliveryInstructions.recipient.recipientSsoId}">
				<c:set var="RecipientShowClass" value="display: block;"/>
				<s:set var="recipientidSelected" value="%{'Selected'}"></s:set>
				<c:set var="RecipientShowClearStyle" value="display: inline;"/>
			</c:if>
             <div class="row" style="padding-left:20px;">
                 <div class="form-row">
                 	<div class="span3">
	                  	<s:textfield name="geRecipient" 
						id="geRecipient" 
						key="label.request.geRecipient" 
						theme="aloc" required="false"
						cssClass="span3 lookup-filterValue"
						/>
						<s:hidden name="businessContactName" value="BUC" cssClass="businessContactClass"></s:hidden>
						<p class="guidance"><s:text name="label.request.partialLastName" /></p>
						<span class="lookup-error hide" style="color: #AE2C2C;"></span>
					</div>
					<div class="span1">	
						<label>&nbsp;</label>
						<s:url action="GEReferenceLookup" namespace="/int" var="getRecipientURL" escapeAmp="false">
						</s:url>
						<a class="btn-secondary lookup" href="<s:property value="#getRecipientURL"/>" ><s:text name="label.request.common.lookup"/></a>
					</div>
						<div class="span5">	
						<label>&nbsp;</label>
						<img alt="Loading..." id="recipientIndicator" class="indicator" src="${pageContext.request.contextPath}/img/loading.gif" style="height: 20px; display:none">
                     	<%-- <a class="btn-tertiary right clear-conditional-results" id="recipientClear" href="javascript:;" type="submit" style="${RecipientShowClearStyle}"><s:text  name="label.common.siteAdmin.clearResults"/></a> --%>
                     </div>
                 </div>
            </div>

		<div class="conditional-row hide" id="recipientShow" style="${RecipientShowClass}; padding-left:20px;" >
		<s:hidden name="recipientSelection" id="recipientSelectionId" value="%{#recipientidSelected}"></s:hidden>
			<div class="row">
				<div class="span7">
					<div class="row">
						<div class="span2">
							<div class="form-row">
								<label><s:text name="label.request.recipient" /></label>
							</div>
						</div>
						<div class="span4 right">
							<div class="form-row">
								<p>
									<s:property	value="requestDetails.deliveryInstructions.recipient.recipientLastName" />, <s:property value="requestDetails.deliveryInstructions.recipient.recipientFirstName" /> - <s:property value="requestDetails.deliveryInstructions.recipient.recipientSsoId" />
								</p>
								<s:hidden
									name="requestDetails.deliveryInstructions.recipient.recipientLastName"
									id="recipientLastName"></s:hidden>
								<s:hidden
									name="requestDetails.deliveryInstructions.recipient.recipientFirstName"
									id="recipientFirstName"></s:hidden>
								<s:hidden
									name="requestDetails.deliveryInstructions.recipient.recipientSsoId"
									id="recipientSsoId"></s:hidden>
							</div>
						</div>
						<!-- end of block -->
					</div>
					<div class="row">
						<div class="span2">
							<div class="form-row">
								<label><s:text	name="label.request.geRecipientEmail" /></label>
							</div>
						</div>
						<!-- end of block -->
						<div class="span4 right">
							<div class="form-row">
								<p>
									<s:property	value="requestDetails.deliveryInstructions.recipient.recipientEmail" />
								</p>
								<s:hidden name="requestDetails.deliveryInstructions.recipient.recipientEmail" id="recipientEmail"></s:hidden>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div> 
	</div><!-- end of required count block -->    
	<script type="text/javascript">
			refreshSectionCount("deliveryInstructionsPanel");
		</script>    
		</s:if>
		<s:elseif test="%{#isEditMode==false}">
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
							<label><s:text  name="label.request.sendElectronicCopyToOtherGERecipient"/>:</label>
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
							<p class="padding40"><c:if test="${not empty requestDetails.deliveryInstructions.recipient.recipientSsoId}"><c:out value="${requestDetails.deliveryInstructions.recipient.recipientLastName}"/>, <c:out value="${requestDetails.deliveryInstructions.recipient.recipientFirstName}"/> - <c:out value="${requestDetails.deliveryInstructions.recipient.recipientSsoId}"/></c:if>
							</p>
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
							<s:if test="%{requestDetails.deliveryInstructions.usePreviousAddress == 'PrincipalDetails'}">
								<s:text name="label.request.prinipalDetails"/>
							</s:if>
							<s:if test="%{requestDetails.deliveryInstructions.usePreviousAddress == 'ObligeeDetails'}">
								<s:text name="label.request.obligeeDetails"/>
							</s:if>
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
							<label><s:text name="label.request.recipientsFirstName" />:</label>
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
							<label><s:text name="label.request.recipientsLastName" />:</label>
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
				<div class="row">
					<div class="span3b">
						<div class="form-row">
							<label><s:text name="label.request.address" />:</label>
						</div>
					</div> 
					<div class="span5 left">
						<div class="form-row">
							<p class="padding40">
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
				<div class="row">
					<div class="span3b">
						<div class="form-row">
						<label><s:text name="label.request.SpecialInstructionsOptional" />:</label>
							
						</div>
					</div>
					<div class="span7 left">
						<div class="form-row">
							<p class="padding40">
							<c:out value="${requestDetails.deliveryInstructions.specialInstructions}"/></p> 
						</div>
					</div>
				</div>
		</s:elseif>