<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<s:set name="isEditMode" value="editMode" />
<div class="form-mod">
				<div class="row">
					<div class="span12">
						<div class="form-row">
							<s:radio theme="aloc" cssClass="radio"
								key="label.request.deliverType"
								name="requestDetails.rider.deliveryInstructions.deliveryType"
								list="#{'true':'In-person pick-up','false':'Physical delivery (via courier or certified post)'}"
								value="%{requestDetails.rider.deliveryInstructions.deliveryType}"
								id="deliveryType" />
						</div>
					</div>
					<!-- end of block -->
				</div>
				<div class="row hide" id="pDelivery1">
					<div class="span12">
						<div class="form-row">
							<label class="optional"><s:text
									name="label.request.usepreviouslyEnteredAddressOptional" /></label>
							<s:select
								name="requestDetails.deliveryInstructions.usePreviousAddress"
								id="addressSelection" headerValue="Select..." headerKey=""
								key=""
								list="#{'PrincipalDetails':'Principal Details','ObligeeDetails':'Obligee Details'}">
							</s:select>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="span12">
						<div class="form-row">
							<s:textfield key="label.request.companyName"
								name="requestDetails.rider.deliveryInstructions.companyName"
								id="companyName" theme="aloc" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="span12">
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
					<div class="span12">
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
					<div class="span12">
						<div class="form-row">
							<s:textfield
								name="requestDetails.rider.deliveryInstructions.title"
								id="title" key="label.request.titleOptional" required="false"
								theme="aloc" />
						</div>
					</div>
					<!-- end of block -->
				</div>
				<div id="pDelivery" class="row hide">
					<div class="span12">
						<div class="row">
							<div class="span12">
								<div class="form-row">
									<s:textfield
										name="requestDetails.rider.deliveryInstructions.address1"
										key="label.request.address1" id="sbAddress1" theme="aloc" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="span12">
								<div class="form-row">
									<s:textfield
										name="requestDetails.rider.deliveryInstructions.address2"
										id="sbAddress2" key="label.request.address2Optional"
										required="false" theme="aloc" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="span12">
								<div class="form-row">
									<s:textfield
										name="requestDetails.rider.deliveryInstructions.city"
										key="label.request.city" id="sbCity" theme="aloc" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="span12">
								<div class="form-row">
									<label class="optional"><s:text name="label.request.stateOrProvince"/> <s:text name="label.request.optional"/></label>
										<s:combobox listKey="stateName" listValue="stateName" headerKey="-1" headerValue="Select..." list="%{#attr['com.ge.aloc.StaticDataFactory'].stateList}"
											name="requestDetails.rider.deliveryInstructions.stateProvince" id="deliveryAddressState" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="span12">
								<div class="form-row">
									<s:textfield
										name="requestDetails.rider.deliveryInstructions.ZIPPostalcode"
										key="label.request.zipOrPostalCode" id="zipPostalcode"
										theme="aloc" maxlength="12"/>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="span12">
								<div class="form-row">
									<sj:autocompleter
										list="%{#attr['com.ge.aloc.MasterDataFactory'].countries}"
										onChangeTopics="getAutocompleterName" id="sbCountryCode"
										name="requestDetails.rider.deliveryInstructions.countryCd"
										cssClass="span3" listKey="countryCode" listValue="countryName"
										parentTheme="aloc" key="label.request.country"/>
									<s:hidden
										name="requestDetails.rider.deliveryInstructions.country"
										id="deliveryAddresscountry"></s:hidden>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="span12">
						<div class="form-row">
							<s:textfield
								name="requestDetails.rider.deliveryInstructions.phoneNo"
								id="phoneNumber" key="label.request.phoneNumber" theme="aloc" maxlength="20"/>
							<p class="guidance">
								<s:text name="label.request.includeCountryAndAreaCode" />
							</p>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="span12">
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
					<div class="span12">
						<div class="form-row ckeckBoxLabel">
							<label><s:text name="label.request.additionalDelivery" />:</label>
							<label class="checkbox"> <s:checkbox
									name="requestDetails.rider.deliveryInstructions.ecopyMyself"></s:checkbox>
							</label> 
							<s:text name="label.request.sendElectronicCopyToMyself" />
							<label class="checkbox"> <s:checkbox
									name="requestDetails.rider.deliveryInstructions.ecopyOtherGEPerson"
									id="sendElectronic"></s:checkbox> 
							</label><s:text name="label.request.sendElectronicCopyToOtherGERecipient" />
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
									cssClass="span3 lookup-filterValue" />
								<s:hidden name="businessContactName" value="BUC" cssClass="businessContactClass"></s:hidden>
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
							<div class="span5">	
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
			</div>
