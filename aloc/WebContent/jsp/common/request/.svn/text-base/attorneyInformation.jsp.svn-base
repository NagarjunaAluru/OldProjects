<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<s:set name="isEditMode" value="editMode"/>
	   <s:if test="%{#isEditMode==true || ((requestDetails.WFDetails.WFStage == 'REQEST' || requestDetails.WFDetails.WFStage == 'REQUEST'  && #attr.isTaxonomy != true) && requestDetails.bondInfo.attorneyRequiresEdits == true)}">
	   <s:if test="%{(requestDetails.WFDetails.WFStage == 'REQEST' || requestDetails.WFDetails.WFStage == 'REQUEST') && requestDetails.bondInfo.attorneyRequiresEdits}">
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
								<s:property value="requestDetails.bondInfo.attorneySendBackNotes" />
							</p>
						</div>
					</div>
				</div>
			</div>
		</s:if>
	   	<div id="suretyBondDetailsForm">
					<a name="seventh"></a>
				<div class="row">
					<div class="span12">
						<div class="form-row">
						 	<s:textfield key="label.request.lawFirmName" name="requestDetails.bondInfo.lawFirmName"
						 	 theme="aloc" cssClass="mandatory" maxlength="100"/>
						</div>
					</div>
				</div>
					<div class="row">
                    	<div class="span12">
							<div class="form-row">
								<s:textfield key="label.request.attorneyName" name="requestDetails.bondInfo.attorneyName" 
								 id="attorneyName" theme="aloc" cssClass="mandatory" maxlength="100"/>
							</div>
						</div>
					</div>
					<div class="row">
					<div class="span12">
						<div class="form-row">
							<s:textfield key="label.request.attorneyAddress1" name="requestDetails.bondInfo.attorneyAddress1" 
							id="attorneyAddress1" theme="aloc" cssClass="mandatory" maxlength="100"/>
						</div>
					</div>
			    </div> 
					<div class="row">
						<div class="span12">
						<div class="form-row">
							<label class="optional"><s:text name="label.request.attorneyAddress2"/></label>
							<s:textfield name="requestDetails.bondInfo.attorneyAddress2" id="attorneyAddress2" theme="aloc" maxlength="100"/>
						</div>
						</div>
					</div>
					
					
				<div class="row">
						<div class="span12">
							<div class="form-row">
								<s:textfield key="label.request.attorneyCity" name="requestDetails.bondInfo.attorneyCity" 
								id="attorneyCity" theme="aloc" cssClass="mandatory" maxlength="50"/>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="span12">
							<div class="form-row">
								 <label class="optional"><s:text name="label.request.attorneyStateProvince"/> <s:text name="label.request.optional"/></label>
									<s:combobox listKey="stateName" listValue="stateName" headerKey="-1" headerValue="Select..." list="%{#attr['com.ge.aloc.StaticDataFactory'].stateList}"
										name="requestDetails.bondInfo.attorneyState" id="attorneyState" />
							</div>
						</div>
					</div>
					
					 <div class="row">
						<div class="span12">
							<div class="form-row">
								<sj:autocompleter id="attorneyCountryCode" list="%{#attr['com.ge.aloc.MasterDataFactory'].countries}" name="requestDetails.bondInfo.attorneyCountryCode" 
									key="label.request.attorneyCountry" cssClass="span3 mandatory" listKey="countryCode" listValue="countryName" parentTheme="aloc" onChangeTopics="getAutocompleterName"/>
								<s:hidden name="requestDetails.bondInfo.attorneyCountry" id="attorneyCountry" cssClass="autoCompleterName"></s:hidden>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="span12">
							<div class="form-row">
								<s:textfield key="label.request.attorneyZipPostalCode" name="requestDetails.bondInfo.attorneyZIPCode" 
								id="attorneyZIPCode" theme="aloc" cssClass="mandatory" maxlength="12"/>
								<p class="guidance"><s:text name="label.request.zipCodeGuidance" /></p>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="span12">
							<div class="form-row">
								<s:textfield key="label.request.attorneyPhoneNumber" name="requestDetails.bondInfo.attorneyPhoneNum" 
								id="attorneyPhoneNum" theme="aloc" cssClass="mandatory" maxlength="20"/>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="span12">
							<div class="form-row">
								<s:textfield key="label.request.attorneyFaxNumber" name="requestDetails.bondInfo.attorneyFaxNum" 
								id="attorneyFaxNum" theme="aloc" cssClass="mandatory" maxlength="20" required="false"/>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="span12">
							<div class="form-row">
								<s:textfield key="label.request.attorneyEmail" name="requestDetails.bondInfo.attorneyEmail"
								 id="attorneyEmail" theme="aloc" cssClass="mandatory" maxlength="100"/>
							</div>
						</div>
					</div>
			</div><!-- end of required count block -->		
			
			<script type="text/javascript">
				refreshSectionCount("attorneyBondInformationPanel");
			</script>	
		</s:if>
		<s:elseif test="%{#isEditMode==false}">
						<div class="row">
							<div class="span2a">
								<div class="form-row">
									<label><s:text name="label.request.lawFirmName" />:</label>
								</div>
							</div>
							<div class="span7 left">
								<div class="form-row">
									<p class="padding40"><c:out value="${requestDetails.bondInfo.lawFirmName}"/></p>
								</div>
							</div>
							<!-- end of block -->
						</div>
						<div class="row">
							<div class="span2a">
								<div class="form-row">
									<label><s:text name="label.request.attorneyName"/>:</label>
								</div>
							</div>
							<div class="span5 left">
								<div class="form-row">
									<p class="padding40"><c:out value="${requestDetails.bondInfo.attorneyName}"/></p>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="span2a">
								<div class="form-row">
									<label><s:text name="label.request.attorneyAddress1"/>:</label>
								</div>
							</div>
							<div class="span5 left">
								<div class="form-row">
									<p class="padding40"><c:out value="${requestDetails.bondInfo.attorneyAddress1}"/></p>
								</div>
							</div>
							<!-- end of block -->
						</div>
						<div class="row">
							<div class="span2a">
								<div class="form-row">
									<label><s:text name="label.request.readOnlyAddress2"/>:</label>
								</div>
							</div>
							<div class="span5 left">
								<div class="form-row">
									<p class="padding40"><c:out value="${requestDetails.bondInfo.attorneyAddress2}"/></p>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="span2a">
								<div class="form-row">
									<label><s:text name="label.request.attorneyCity"/>:</label>
								</div>
							</div>
							<div class="span5 left">
								<div class="form-row">
									<p class="padding40"><c:out value="${requestDetails.bondInfo.attorneyCity}"/></p>
								</div>
							</div>
							<!-- end of block -->
						</div>
						<div class="row">
							<div class="span2a">
								<div class="form-row">
									<label><s:text name="label.request.attorneyStateProvince"/>:</label>
								</div>
							</div>
							<div class="span5 left">
								<div class="form-row">
									<p class="padding40"><c:out value="${requestDetails.bondInfo.attorneyState}"/></p>
								</div>
							</div>
						</div>
						
						<div class="row">
							<div class="span2a">
								<div class="form-row">
									<label><s:text name="label.request.attorneyCountry"/>:</label>
								</div>
							</div>
							<div class="span5 left">
								<div class="form-row">
									<p class="padding40"><c:out value="${requestDetails.bondInfo.attorneyCountry}"/></p>
								</div>
							</div>
						</div>
						<div class="row ">
							<div class="span2a">
								<div class="form-row">
									<label><s:text name="label.request.attorneyZipPostalCode"/>:</label>
								</div>
							</div>
							<div class="span5 left">
								<div class="form-row">
									<p class="padding40"><c:out value="${requestDetails.bondInfo.attorneyZIPCode}"/></p>
								</div>
							</div>
							<!-- end of block -->
						</div>
						<div class="row ">
							<div class="span2a">
								<div class="form-row">
									<label><s:text name="label.request.attorneyPhoneNumber"/>:</label>
								</div>
							</div>
							<div class="span5 left">
								<div class="form-row">
									<p class="padding40"><c:out value="${requestDetails.bondInfo.attorneyPhoneNum}"/></p>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="span2a">
								<div class="form-row">
									<label><s:text name="label.request.attorneyFaxNumber"/>:</label>
								</div>
							</div>
							<div class="span5 left">
								<div class="form-row">
									<p class="padding40"><c:out value="${requestDetails.bondInfo.attorneyFaxNum}"/></p>
								</div>
							</div>
						</div>
				
						<div class="row">
							<div class="span2a">
								<div class="form-row">
									<label><s:text name="label.request.attorneyEmail"/>:</label>
								</div>
							</div>
							<div class="span5 left">
								<div class="form-row">
									<p class="padding40"><c:out value="${requestDetails.bondInfo.attorneyEmail}"/></p>
								</div>
							</div>
						</div>
						
</s:elseif>