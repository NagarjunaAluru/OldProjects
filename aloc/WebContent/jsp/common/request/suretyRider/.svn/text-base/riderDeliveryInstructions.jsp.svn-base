<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<s:set name="isEditMode" value="editMode" />
<s:if test="%{#isEditMode==true}">
	<c:if test="${param.pageSection == 'Current'}">
	<c:if test="${param.includeScripts != false}">
		<script type="text/javascript">
		$(document).ready(function() {
			//getAutocompleterName();
			deliveryTypeOnloadShow(); 
			decCounter("specialInstructions", 400);
			});
		</script>
	</c:if>
		<div class="row">
			<div class="span6">
				<div class="span6" style="margin-left : 1px;">
					<s:radio theme="aloc" cssClass="radio"
						key="label.request.deliverType"
						name="requestDetails.rider.deliveryInstructions.deliveryType"
						list="#{'true':'In-person pick-up','false':'Physical delivery (via courier or certified post)'}"
						value="%{requestDetails.rider.deliveryInstructions.deliveryType}"
						id="deliveryType" />
				</div>
				<br/><label class="right"><span style="margin-left: -340px; margin-top: 2px;" class="ttip info" data-original-title="<s:text name="label.request.tooltip.inpersonPickup"/>"></span></label><br/>
				<label class="right"><span style="margin-left: -200px; margin-top: 2px;" class="ttip info" data-original-title="<s:text name="label.request.tooltip.physicalDelivery"/>"></span></label>
			
			</div>
			<!-- end of block -->
		</div>
		<div class="row hide" id="pDelivery1">
			<div class="span6">
				<div class="form-row">
					<label class="optional"><s:text
							name="label.request.usepreviouslyEnteredAddressOptional" /></label>
					<s:select
						name="requestDetails.rider.deliveryInstructions.usePreviousAddress"
						id="addressSelection" headerValue="Select..." headerKey="" key=""
						list="#{'PrincipalDetails':'Principal Details','ObligeeDetails':'Obligee Details'}">
					</s:select>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="span6">
				<div class="form-row">
					<s:textfield key="label.request.companyName"
						name="requestDetails.rider.deliveryInstructions.companyName"
						id="companyName" theme="aloc" />
				</div>
			</div>
		</div>
		<div class="row">
			<div class="span6">
				<div class="form-row">
					<s:textfield key="label.request.recipientsFirstName"
						name="requestDetails.rider.deliveryInstructions.firstName"
						id="firstName" theme="aloc" />
					<p class="guidance">
						<s:text name="label.request.givenName" />
					</p>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="span6">
				<div class="form-row">
					<s:textfield key="label.request.recipientsLastName"
						name="requestDetails.rider.deliveryInstructions.lastName"
						id="lastName" theme="aloc" />
					<p class="guidance">
						<s:text name="label.request.surName" />
					</p>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="span6">
				<div class="form-row">
					<s:textfield
						name="requestDetails.rider.deliveryInstructions.title" id="title"
						key="label.request.titleOptional" required="false" theme="aloc" />
				</div>
			</div>
			<!-- end of block -->
		</div>
		<div id="pDelivery" class="row hide">
			<div class="span6">
				<div class="row">
					<div class="span6">
						<div class="form-row">
							<s:textfield
								name="requestDetails.rider.deliveryInstructions.address1"
								key="label.request.address1" id="sbAddress1" theme="aloc" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="span6">
						<div class="form-row">
							<s:textfield
								name="requestDetails.rider.deliveryInstructions.address2"
								id="sbAddress2" key="label.request.address2Optional"
								required="false" theme="aloc" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="span6">
						<div class="form-row">
							<s:textfield
								name="requestDetails.rider.deliveryInstructions.city"
								key="label.request.city" id="sbCity" theme="aloc" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="span6">
						<div class="form-row">
							<label class="optional"><s:text name="label.request.stateOrProvince"/> <s:text name="label.request.optional"/></label>
							<s:combobox listKey="stateName" listValue="stateName" headerKey="-1" headerValue="Select..." list="%{#attr['com.ge.aloc.StaticDataFactory'].stateList}"
								name="requestDetails.rider.deliveryInstructions.stateProvince" id="deliveryAddressState" cssClass="comboDeliveryState"/>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="span6">
						<div class="form-row">
							<s:textfield
								name="requestDetails.rider.deliveryInstructions.ZIPPostalcode"
								key="label.request.zipOrPostalCode" id="zipPostalcode"
								theme="aloc" maxlength="12"/>
							<p class="guidance"><s:text name="label.request.zipCodeGuidance" /></p>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="span6">
						<div class="form-row">
							<sj:autocompleter
								list="%{#attr['com.ge.aloc.MasterDataFactory'].countries}"
								onChangeTopics="getAutocompleterName" id="sbCountryCode"
								name="requestDetails.rider.deliveryInstructions.countryCd"
								cssClass="span3" listKey="countryCode" listValue="countryName"
								parentTheme="aloc" key="label.request.country" />
							<s:hidden
								name="requestDetails.rider.deliveryInstructions.country"
								id="deliveryAddresscountry" cssClass="autoCompleterName"></s:hidden>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="span6">
				<div class="form-row">
					<s:textfield
						name="requestDetails.rider.deliveryInstructions.phoneNo"
						id="phoneNumber" key="label.request.phoneNumber" theme="aloc" maxlength="20"/>
					<p style="padding-top: 5px;">
						<i><s:text name="label.request.includeCountryAndAreaCode" /></i>
					</p>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="span6">
				<div class="form-row">
					<s:textarea cssClass="autosize messageinput" cols="50" rows="1"
						name="requestDetails.rider.deliveryInstructions.specialInstructions"
						key="label.request.specialInstructions" theme="aloc"
						id="specialInstructions" onkeypress="return imposeMaxLength(this, 399);">
					</s:textarea>
					<div class="clear"></div>
					<div class="counter">
						<s:text name="label.common.siteAdmin.fourHundred" />
					</div>
					<!-- fix positions -->
					<div class="counterTxt">
						<p class="guidance">
							<s:text name="label.common.siteAdmin.limit400Characters" />
						</p>
					</div>
				</div>
				<!-- end of block -->
			</div>
		</div>
		<div class="row">
			<div class="span6">
				<div class="form-row ckeckBoxLabel">
					<label><s:text name="label.request.additionalDelivery" />:</label>
					<label class="checkbox"> <s:checkbox
							name="requestDetails.rider.deliveryInstructions.ecopyMyself"></s:checkbox>
					</label>
					<s:text name="label.request.sendElectronicCopyToMyself" />
					 <label class="checkbox"> <s:checkbox
							name="requestDetails.rider.deliveryInstructions.ecopyOtherGEPerson"
							id="sendElectronic"></s:checkbox> 
					</label>
					<s:text	name="label.request.sendElectronicCopyToOtherGERecipient" />
				</div>
			</div>
		</div>
		<div class="row hide" id="Recipient">
					<c:if
						test="${empty requestDetails.rider.deliveryInstructions.recipient.recipientSsoId}">
						<c:set var="RecipientShowClass" value="display: none;" />
						<c:set var="RecipientClearStyle" value="display: none;"/>
					</c:if>
					<c:if
						test="${not empty requestDetails.rider.deliveryInstructions.recipient.recipientSsoId}">
						<c:set var="RecipientShowClass" value="display: block;" />
						<s:set var="recipientidSelected" value="%{'Selected'}"></s:set>
						<c:set var="RecipientShowClearStyle" value="display: inline;"/>
					</c:if>
					<div class="row" style="margin-left: 5px;">
						<div class="form-row">
							<div class="span3">
								<s:textfield name="geRecipient" id="geRecipient"
									key="label.request.geRecipient" theme="aloc"
									cssClass="span3 lookup-filterValue" required="false"/>
								<s:hidden name="businessContactName" value="BUC" cssClass="businessContactClass"></s:hidden>
								<p class="guidance"><s:text name="label.request.partialLastName" /></p>
								<span class="lookup-error hide" style="color: #AE2C2C;"></span>
							</div>
							<div class="span1">	
								<label>&nbsp;</label>
								<s:url action="GEReferenceLookup" namespace="/int"
									var="getRecipientURL" escapeAmp="false">
								</s:url>
								<a class="btn-secondary lookup"
									href="<s:property value="#getRecipientURL"/>"><s:text
										name="label.request.common.lookup" /></a>
							</div>
							<div class="span1">	
								<label>&nbsp;</label>
									<img alt="Loading..."
									id="recipientIndicator" class="indicator"
									src="${pageContext.request.contextPath}/img/loading.gif"
									style="height: 20px; display: none"> 
							</div>
						</div>
					</div>
					<div class="conditional-row hide" id="recipientShow" style="${RecipientShowClass}; padding-left:20px;">
					<s:hidden name="recipientSelection" id="recipientSelectionId" value="%{#recipientidSelected}"></s:hidden>
						<div class="row">
							<div class="span7">
								<div class="row">
									<div class="span2">
										<div class="form-row">
											<label><s:text
													name="label.request.recipient" /></label>
										</div>
									</div>
									<div class="span4 right">
										<div class="form-row">
											<p>
												<s:property
													value="requestDetails.rider.deliveryInstructions.recipient.recipientLastName" />
												,
												<s:property
													value="requestDetails.rider.deliveryInstructions.recipient.recipientFirstName" />
												-
												<s:property
													value="requestDetails.rider.deliveryInstructions.recipient.recipientSsoId" />
											</p>
											<s:hidden
												name="requestDetails.rider.deliveryInstructions.recipient.recipientLastName"
												id="recipientLastName"></s:hidden>
											<s:hidden
												name="requestDetails.rider.deliveryInstructions.recipient.recipientFirstName"
												id="recipientFirstName"></s:hidden>
											<s:hidden
												name="requestDetails.rider.deliveryInstructions.recipient.recipientSsoId"
												id="recipientSsoId"></s:hidden>
										</div>
									</div>
									<!-- end of block -->
								</div>
								<div class="row">
									<div class="span2">
										<div class="form-row">
											<label><s:text
													name="label.request.geRecipientEmail" /></label>
										</div>
									</div>
									<!-- end of block -->
									<div class="span4 right">
										<div class="form-row">
											<p>
												<s:property
													value="requestDetails.rider.deliveryInstructions.recipient.recipientEmail" />
											</p>
											<s:hidden
												name="requestDetails.rider.deliveryInstructions.recipient.recipientEmail"
												id="recipientEmail"></s:hidden>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			<!--  End of Current -->
	</c:if>
			<!-- Start of Previous -->
	<c:if test="${param.pageSection == 'Previous'}">
		<div class="row">
			<div class="span3">
				<div class="form-row">
					<label><s:text name="label.request.deliverType" /></label>
				</div>
			</div>
			<div class="span2 left">
				<p>
					<s:if test="%{requestDetails.previousRider.deliveryInstructions.deliveryType}">
						<s:text name="label.request.inPersonPickUp" />
					</s:if>
					<s:else>
						<s:text name="label.request.physicalDelivery" />
					</s:else>
				</p>
			</div>
			<!-- end of block -->
		</div>
		<div class="row">
			<div class="span3">
				<div class="form-row">
					<label><s:text
							name="label.request.sendElectronicCopyToMyself" />:</label>
				</div>
			</div>
			<div class="span2 left">
				<p>
					<s:if test="%{requestDetails.previousRider.deliveryInstructions.ecopyMyself}">
						<s:text name="label.request.common.yes" />
					</s:if>
					<s:else>
						<s:text name="label.request.common.no" />
					</s:else>
				</p>
			</div>
			<!-- end of block -->
		</div>
		<div class="row">
			<div class="span3">
				<div class="form-row">
					<label><s:text
							name="label.request.sendElectronicCopyToOtherGERecipient" />:</label>
				</div>
			</div>
			<div class="span2 left">
				<p>
					<s:if
						test="%{requestDetails.previousRider.deliveryInstructions.ecopyOtherGEPerson}">
						<s:text name="label.request.common.yes" />
					</s:if>
					<s:else>
						<s:text name="label.request.common.no" />
					</s:else>
				</p>
			</div>
			<!-- end of block -->
		</div>

		<s:if
			test="%{requestDetails.previousRider.deliveryInstructions.ecopyOtherGEPerson}">
			<div class="row">
				<div class="span3">
					<div class="form-row">
						<label><s:text name="label.request.geRecipient" />:</label>
					</div>
				</div>
				<div class="span2 left">
					<p>
						<s:property	value="requestDetails.previousRider.deliveryInstructions.recipient.recipientLastName" />,
						<s:property	value="requestDetails.previousRider.deliveryInstructions.recipient.recipientFirstName" /> -
						<s:property	value="requestDetails.previousRider.deliveryInstructions.recipient.recipientSsoId" />
					</p>
				</div>
				<!-- end of block -->
			</div>

			<div class="row">
				<div class="span3">
					<div class="form-row">
						<label><s:text name="label.request.geRecipientEmail" /></label>
					</div>
				</div>
				<div class="span2 left">
					<p>
						<s:property
							value="requestDetails.previousRider.deliveryInstructions.recipient.recipientEmail" />
					</p>
				</div>
				<!-- end of block -->
			</div>
		</s:if>
		<s:if test="%{requestDetails.previousRider.deliveryInstructions.deliveryType == 'false' && requestDetails.previousRider.deliveryInstructions.usePreviousAddress !=null && requestDetails.previousRider.deliveryInstructions.usePreviousAddress !='' }">
			<div class="row">
				<div class="span3">
					<div class="form-row">
						<label><s:text name="label.request.usepreviouslyEnteredAddressOptionalReview" />:</label>
					</div>
				</div>
				<div class="span2 left">
					<p>
						<s:if test="%{requestDetails.previousRider.deliveryInstructions.usePreviousAddress == 'PrincipalDetails'}">
								<s:text name="label.request.prinipalDetails"/>
						</s:if>
						<s:if test="%{requestDetails.previousRider.deliveryInstructions.usePreviousAddress == 'ObligeeDetails'}">
							<s:text name="label.request.obligeeDetails"/>
						</s:if>
					</p>
				</div>
			</div>
		</s:if>
		<div class="row">
			<div class="span3">
				<div class="form-row">
					<label><s:text name="label.request.companyName" />:</label>
				</div>
			</div>
			<div class="span2 left">
				<p>
					<s:property
						value="requestDetails.previousRider.deliveryInstructions.companyName" />
				</p>
			</div>
			<!-- end of block -->
		</div>
		<div class="row">
			<div class="span3">
				<div class="form-row">
					<label><s:text name="label.request.recipientsFirstName" />:</label>
				</div>
			</div>
			<div class="span2 left">
				<p>
					<s:property value="requestDetails.previousRider.deliveryInstructions.firstName" />
				</p>
			</div>
			<!-- end of block -->
		</div>
		<div class="row">
			<div class="span3">
				<div class="form-row">
					<label><s:text name="label.request.recipientsLastName" />:</label>
				</div>
			</div>
			<div class="span2 left">
				<p>
					<s:property value="requestDetails.previousRider.deliveryInstructions.lastName" />
				</p>
			</div>
			<!-- end of block -->
		</div>
		<div class="row">
			<div class="span3">
				<div class="form-row">
					<label><s:text name="label.request.titleOptional" />:</label>
				</div>
			</div>
			<div class="span2 left">
				<p>
					<s:property value="requestDetails.previousRider.deliveryInstructions.title" />
				</p>
			</div>
			<!-- end of block -->
		</div>
		<s:if
			test="%{requestDetails.previousRider.deliveryInstructions.deliveryType == 'false' }">
			<div class="row">
				<div class="span3">
					<div class="form-row">
						<label><s:text name="label.request.address" />:</label>
					</div>
				</div>
				<div class="span2 left">
					<p>
						<s:property value="requestDetails.previousRider.deliveryInstructions.address1" />
						<br />
						<s:property value="requestDetails.previousRider.deliveryInstructions.address2" />
						<br />
						<s:property value="requestDetails.previousRider.deliveryInstructions.city" />
						<s:property
							value="requestDetails.previousRider.deliveryInstructions.stateProvince" />
						<s:property
							value="requestDetails.previousRider.deliveryInstructions.ZIPPostalcode" />
						<br />
						<s:property value="requestDetails.previousRider.deliveryInstructions.country" />
					</p>
				</div>
				<!-- end of block -->
			</div>
		</s:if>
		<div class="row">
			<div class="span3">
				<div class="form-row">
					<label><s:text name="label.request.phoneName" />:</label>
				</div>
			</div>
			<div class="span2 left">
				<p>
					<s:property value="requestDetails.previousRider.deliveryInstructions.phoneNo" />
				</p>
			</div>
			<!-- end of block -->
		</div>
		<div class="row">
			<div class="span3">
				<div class="form-row">
					<label><s:text
							name="label.request.SpecialInstructionsOptional" />:</label>
				</div>
			</div>
			<div class="span2 left">
				<p>
					<s:property
						value="requestDetails.previousRider.deliveryInstructions.specialInstructions" />
				</p>
			</div>
			<!-- end of block -->
		</div>
	</c:if>
			<!--  End of Previous Section -->
</s:if>
<!-- End of If  -->

<s:elseif test="%{#isEditMode==false}">
	
		<!-- Delivery Section -->
		<c:if test="${param.pageSection == 'Current'}">
			<div class="row">
				<div class="span3">
					<div class="form-row">
						<label><s:text name="label.request.deliverType" /></label>
					</div>
				</div>
				<div class="span3 left">
					<p>
						<s:if
							test="%{requestDetails.rider.deliveryInstructions.deliveryType}">
							<s:text name="label.request.inPersonPickUp" />
						</s:if>
						<s:else>
							<s:text name="label.request.physicalDelivery" />
						</s:else>
					</p>
				</div>
				<!-- end of block -->
			</div>
			<div class="row">
				<div class="span3">
					<div class="form-row">
						<label><s:text
								name="label.request.sendElectronicCopyToMyself" />:</label>
					</div>
				</div>
				<div class="span3 left">
					<p>
						<s:if
							test="%{requestDetails.rider.deliveryInstructions.ecopyMyself}">
							<s:text name="label.request.common.yes" />
						</s:if>
						<s:else>
							<s:text name="label.request.common.no" />
						</s:else>
					</p>
				</div>
				<!-- end of block -->
			</div>
			<div class="row">
				<div class="span3">
					<div class="form-row">
						<label><s:text
								name="label.request.sendElectronicCopyToOtherGERecipient" />:</label>
					</div>
				</div>
				<div class="span3 left">
					<p>
						<s:if
							test="%{requestDetails.rider.deliveryInstructions.ecopyOtherGEPerson}">
							<s:text name="label.request.common.yes" />
						</s:if>
						<s:else>
							<s:text name="label.request.common.no" />
						</s:else>
					</p>
				</div>
				<!-- end of block -->
			</div>

			<s:if
				test="%{requestDetails.rider.deliveryInstructions.ecopyOtherGEPerson}">
				<div class="row">
					<div class="span3">
						<div class="form-row">
							<label><s:text name="label.request.geRecipient" />:</label>
						</div>
					</div>
					<div class="span3 left">
						<p>
							<s:property	value="requestDetails.rider.deliveryInstructions.recipient.recipientLastName" />,
							<s:property	value="requestDetails.rider.deliveryInstructions.recipient.recipientFirstName" /> - 
							<s:property	value="requestDetails.rider.deliveryInstructions.recipient.recipientSsoId" />
						</p>
					</div>
					<!-- end of block -->
				</div>

				<div class="row">
					<div class="span3">
						<div class="form-row">
							<label><s:text name="label.request.geRecipientEmail" /></label>
						</div>
					</div>
					<div class="span3 left">
						<p>
							<s:property
								value="requestDetails.rider.deliveryInstructions.recipient.recipientEmail" />
						</p>
					</div>
					<!-- end of block -->
				</div>
			</s:if>
			
			<s:if test="%{requestDetails.rider.deliveryInstructions.deliveryType == 'false' && requestDetails.rider.deliveryInstructions.usePreviousAddress !=null && requestDetails.rider.deliveryInstructions.usePreviousAddress !='' }">
			<div class="row">
				<div class="span3">
					<div class="form-row">
						<label><s:text name="label.request.usepreviouslyEnteredAddressOptionalReview" />:</label>
					</div>
				</div>
				<div class="span3 left">
					<p>
						<s:if test="%{requestDetails.rider.deliveryInstructions.usePreviousAddress == 'PrincipalDetails'}">
							<s:text name="label.request.prinipalDetails"/>
						</s:if>
						<s:if test="%{requestDetails.rider.deliveryInstructions.usePreviousAddress == 'ObligeeDetails'}">
							<s:text name="label.request.obligeeDetails"/>
						</s:if>
					</p>
				</div>
			</div>
			</s:if>
			
			<div class="row">
				<div class="span3">
					<div class="form-row">
						<label><s:text name="label.request.companyName" />:</label>
					</div>
				</div>
				<div class="span3 left">
					<p>
						<s:property
							value="requestDetails.rider.deliveryInstructions.companyName" />
					</p>
				</div>
				<!-- end of block -->
			</div>
			<div class="row">
				<div class="span3">
					<div class="form-row">
						<label><s:text name="label.request.recipientsFirstName" />:</label>
					</div>
				</div>
				<div class="span3 left">
					<p>
						<s:property
							value="requestDetails.rider.deliveryInstructions.firstName" />
					</p>
				</div>
				<!-- end of block -->
			</div>
			<div class="row">
				<div class="span3">
					<div class="form-row">
						<label><s:text name="label.request.recipientsLastName" />:</label>
					</div>
				</div>
				<div class="span3 left">
					<p>
						<s:property
							value="requestDetails.rider.deliveryInstructions.lastName" />
					</p>
				</div>
				<!-- end of block -->
			</div>
			<div class="row">
				<div class="span3">
					<div class="form-row">
						<label><s:text name="label.request.titleOptional" />:</label>
					</div>
				</div>
				<div class="span3 left">
					<p>
						<s:property
							value="requestDetails.rider.deliveryInstructions.title" />
					</p>
				</div>
				<!-- end of block -->
			</div>
			<s:if
				test="%{requestDetails.rider.deliveryInstructions.deliveryType == 'false' }">
				<div class="row">
					<div class="span3">
						<div class="form-row">
							<label><s:text name="label.request.address" />:</label>
						</div>
					</div>
					<div class="span3 left">
						<p>
							<s:property
								value="requestDetails.rider.deliveryInstructions.address1" />
							<br />
							<s:property
								value="requestDetails.rider.deliveryInstructions.address2" />
							<br />
							<s:property
								value="requestDetails.rider.deliveryInstructions.city" />
							<s:property
								value="requestDetails.rider.deliveryInstructions.stateProvince" />
							<s:property
								value="requestDetails.rider.deliveryInstructions.ZIPPostalcode" />
							<br />
							<s:property
								value="requestDetails.rider.deliveryInstructions.country" />
						</p>
					</div>
					<!-- end of block -->
				</div>
			</s:if>
			<div class="row">
				<div class="span3">
					<div class="form-row">
						<label><s:text name="label.request.phoneName" />:</label>
					</div>
				</div>
				<div class="span3 left">
					<p>
						<s:property
							value="requestDetails.rider.deliveryInstructions.phoneNo" />
					</p>
				</div>
				<!-- end of block -->
			</div>
			<div class="row">
				<div class="span3">
					<div class="form-row">
						<label><s:text
								name="label.request.SpecialInstructionsOptional" />:</label>
					</div>
				</div>
				<div class="span2 left">
					<p>
						<s:property
							value="requestDetails.rider.deliveryInstructions.specialInstructions" />
					</p>
				</div>
				<!-- end of block -->
			</div>
		</c:if>
		<!-- Previous Section -->
		<c:if test="${param.pageSection == 'Previous'}">
			<div class="row">
				<div class="span3">
					<div class="form-row">
						<label><s:text name="label.request.deliverType" /></label>
					</div>
				</div>
				<div class="span2 left">
					<p>
						<s:if test="%{requestDetails.previousRider.deliveryInstructions.deliveryType}">
							<s:text name="label.request.inPersonPickUp" />
						</s:if>
						<s:else>
							<s:text name="label.request.physicalDelivery" />
						</s:else>
					</p>
				</div>
				<!-- end of block -->
			</div>
			<div class="row">
				<div class="span3">
					<div class="form-row">
						<label><s:text
								name="label.request.sendElectronicCopyToMyself" />:</label>
					</div>
				</div>
				<div class="span2 left">
					<p>
						<s:if test="%{requestDetails.previousRider.deliveryInstructions.ecopyMyself}">
							<s:text name="label.request.common.yes" />
						</s:if>
						<s:else>
							<s:text name="label.request.common.no" />
						</s:else>
					</p>
				</div>
				<!-- end of block -->
			</div>
			<div class="row">
				<div class="span3">
					<div class="form-row">
						<label><s:text
								name="label.request.sendElectronicCopyToOtherGERecipient" />:</label>
					</div>
				</div>
				<div class="span2 left">
					<p>
						<s:if
							test="%{requestDetails.previousRider.deliveryInstructions.ecopyOtherGEPerson}">
							<s:text name="label.request.common.yes" />
						</s:if>
						<s:else>
							<s:text name="label.request.common.no" />
						</s:else>
					</p>
				</div>
				<!-- end of block -->
			</div>

			<s:if
				test="%{requestDetails.previousRider.deliveryInstructions.ecopyOtherGEPerson}">
				<div class="row">
					<div class="span3">
						<div class="form-row">
							<label><s:text name="label.request.geRecipient" />:</label>
						</div>
					</div>
					<div class="span2 left">
						<p>
							<s:property	value="requestDetails.previousRider.deliveryInstructions.recipient.recipientLastName" />,
							<s:property	value="requestDetails.previousRider.deliveryInstructions.recipient.recipientFirstName" /> - 
							<s:property	value="requestDetails.previousRider.deliveryInstructions.recipient.recipientSsoId" />
						</p>
					</div>
					<!-- end of block -->
				</div>

				<div class="row">
					<div class="span3">
						<div class="form-row">
							<label><s:text name="label.request.geRecipientEmail" /></label>
						</div>
					</div>
					<div class="span2 left">
						<p>
							<s:property
								value="requestDetails.previousRider.deliveryInstructions.recipient.recipientEmail" />
						</p>
					</div>
					<!-- end of block -->
				</div>
			</s:if>
			
			<s:if test="%{requestDetails.previousRider.deliveryInstructions.deliveryType == 'false' && requestDetails.previousRider.deliveryInstructions.usePreviousAddress !=null && requestDetails.previousRider.deliveryInstructions.usePreviousAddress !=''}">
			<div class="row">
				<div class="span3">
					<div class="form-row">
						<label><s:text name="label.request.usepreviouslyEnteredAddressOptionalReview" />:</label>
					</div>
				</div>
				<div class="span2 left">
					<p>
						<s:if test="%{requestDetails.previousRider.deliveryInstructions.usePreviousAddress == 'PrincipalDetails'}">
								<s:text name="label.request.prinipalDetails"/>
						</s:if>
						<s:if test="%{requestDetails.previousRider.deliveryInstructions.usePreviousAddress == 'ObligeeDetails'}">
							<s:text name="label.request.obligeeDetails"/>
						</s:if>
					</p>
				</div>
			</div>
			</s:if>
			
			<div class="row">
				<div class="span3">
					<div class="form-row">
						<label><s:text name="label.request.companyName" />:</label>
					</div>
				</div>
				<div class="span2 left">
					<p>
						<s:property
							value="requestDetails.previousRider.deliveryInstructions.companyName" />
					</p>
				</div>
				<!-- end of block -->
			</div>
			<div class="row">
				<div class="span3">
					<div class="form-row">
						<label><s:text name="label.request.recipientsFirstName" />:</label>
					</div>
				</div>
				<div class="span2 left">
					<p>
						<s:property value="requestDetails.previousRider.deliveryInstructions.firstName" />
					</p>
				</div>
				<!-- end of block -->
			</div>
			<div class="row">
				<div class="span3">
					<div class="form-row">
						<label><s:text name="label.request.recipientsLastName" />:</label>
					</div>
				</div>
				<div class="span2 left">
					<p>
						<s:property value="requestDetails.previousRider.deliveryInstructions.lastName" />
					</p>
				</div>
				<!-- end of block -->
			</div>
			<div class="row">
				<div class="span3">
					<div class="form-row">
						<label><s:text name="label.request.titleOptional" />:</label>
					</div>
				</div>
				<div class="span2 left">
					<p>
						<s:property value="requestDetails.previousRider.deliveryInstructions.title" />
					</p>
				</div>
				<!-- end of block -->
			</div>
			<s:if
				test="%{requestDetails.previousRider.deliveryInstructions.deliveryType == 'false' }">
				<div class="row">
					<div class="span3">
						<div class="form-row">
							<label><s:text name="label.request.address" />:</label>
						</div>
					</div>
					<div class="span2 left">
						<p>
							<s:property value="requestDetails.previousRider.deliveryInstructions.address1" />
							<br />
							<s:property value="requestDetails.previousRider.deliveryInstructions.address2" />
							<br />
							<s:property value="requestDetails.previousRider.deliveryInstructions.city" />
							<s:property
								value="requestDetails.previousRider.deliveryInstructions.stateProvince" />
							<s:property
								value="requestDetails.previousRider.deliveryInstructions.ZIPPostalcode" />
							<br />
							<s:property value="requestDetails.previousRider.deliveryInstructions.country" />
						</p>
					</div>
					<!-- end of block -->
				</div>
			</s:if>
			<div class="row">
				<div class="span3">
					<div class="form-row">
						<label><s:text name="label.request.phoneName" />:</label>
					</div>
				</div>
				<div class="span2 left">
					<p>
						<s:property value="requestDetails.previousRider.deliveryInstructions.phoneNo" />
					</p>
				</div>
				<!-- end of block -->
			</div>
			<div class="row">
				<div class="span3">
					<div class="form-row">
						<label><s:text
								name="label.request.SpecialInstructionsOptional" />:</label>
					</div>
				</div>
				<div class="span2 left">
					<p>
						<s:property
							value="requestDetails.previousRider.deliveryInstructions.specialInstructions" />
					</p>
				</div>
				<!-- end of block -->
			</div>
		</c:if>
</s:elseif>
