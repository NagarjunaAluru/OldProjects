<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>

<s:set name="isEditMode" value="editMode"/>
<s:if test="%{#isEditMode==true || ((requestDetails.WFDetails.WFStage == 'REQEST' || requestDetails.WFDetails.WFStage == 'REQUEST' && #attr.isTaxonomy != true) && requestDetails.transactionParties.triPartyApplicant.requiresEdits == true)}">
<c:if test="${param.includeScripts != false}">
<script	type="text/javascript">
$(document).ready(function() {
	showHideTPTriPartyAddress();
	sendbackOnloadShow();
});
</script>
</c:if>
	   	<s:if test="%{(requestDetails.WFDetails.WFStage == 'REQEST' || requestDetails.WFDetails.WFStage == 'REQUEST') && requestDetails.transactionParties.triPartyApplicant.requiresEdits}">
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
								<s:property value="requestDetails.transactionParties.triPartyApplicant.sendBackNotes" />
							</p>
						</div>
					</div>
				</div>
			</div>
		</s:if>
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
				
				<div class="span12">
					<div class="form-row">
						<s:label key="label.request.triPartyApplicantNameAddress" />
						<s:textfield name="nameForAddressTriparty" cssClass="span3 lookup-filterValue" 
						id="triPartyApplicantNameAddressId" theme="aloc" maxlength="100"/>
						<s:hidden name="triPartyNameAddressValue" value="yes" cssClass="nameAddressClass"></s:hidden>
						<s:url action="NameAddressLookup" namespace="/int" var="getTriApplicantNameAddressURL" escapeAmp="false" encode="true">
							<s:param name="addressTypeId">2</s:param>
						</s:url> 
						<a class="btn-secondary lookup" href="<s:property value="#getTriApplicantNameAddressURL"/>" ><s:text name="label.request.common.lookup"/></a>
						
						<img alt="Loading..." id="triPartyApplicantAddressIndicator" class="indicator" 
							src="${pageContext.request.contextPath}/img/loading.gif" style="height: 20px; display:none">
					
						<%-- <a class="btn-tertiary right clear-conditional-results"	id="TriPartyClear" href="javascript:;" type="submit" style="${TriPartyShowClearStyle}"><s:text name="label.request.common.clearResults" /></a> --%>
						<p class="guidance"><s:text name="label.request.nameAddressGuidance" /></p>
						<span class="lookup-error hide" style="color: #AE2C2C;"></span>
					</div>
				</div>
			</div>
			
			<div class="conditional-row" id="TriPartyShow" style="${TriPartyShowClass}">
				<s:hidden name="triPartyAddressSelection" id="triPartyAddressSelectionId" value="%{#triPartyAddressSelected}"/>
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
							cssClass="mandatory"
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
							cssClass="mandatory"
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
						<sj:autocompleter id="triPartyAddressCountryCd" list="%{#attr['com.ge.aloc.MasterDataFactory'].countries}" 
							name="requestDetails.transactionParties.triPartyApplicant.countryCd" maxlength="100" 
							cssClass="span3" listKey="countryCode" listValue="countryName" parentTheme="aloc" onChangeTopics="getAutocompleterName"/>
						<s:hidden name="requestDetails.transactionParties.triPartyApplicant.country" 
							id="triPartyAddressCountry" cssClass="autoCompleterName mandatory"></s:hidden>
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
		<script type="text/javascript">
			refreshSectionCount('tripartyAddressSection');
		</script>
		</s:if>
		<s:elseif test="%{#isEditMode==false}" >
			
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
								<c:out
									value="${requestDetails.transactionParties.triPartyApplicant.name}" />
								<br />
								<s:iterator
									value="requestDetails.transactionParties.triPartyApplicant.address">
									<s:property />
									<br />
								</s:iterator>
	
								<c:out
									value="${requestDetails.transactionParties.triPartyApplicant.city}" />
								<c:out
									value="${requestDetails.transactionParties.triPartyApplicant.stateProvince}" />
								<c:out
									value="${requestDetails.transactionParties.triPartyApplicant.ZIPPostalCode}" />
								<br />
								<c:out
									value="${requestDetails.transactionParties.triPartyApplicant.country}" />
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
		<c:if test="${requestDetails.WFDetails.WFStage eq 'REQEST'}">
		<s:if test="%{requestDetails.transactionParties.triPartyApplicant.requiresEdits}">
						<div class="row">
							<div class="span44">
								<div class="form-row">
									<label> <s:text name="label.request.Sendbacknotes" /> :
									</label>
								</div>
							</div>
							<div class="span5 left">
								<div class="form-row">
									<p class="padding40">
										<c:out
											value="${requestDetails.transactionParties.triPartyApplicant.sendBackNotes}" />
									</p>
								</div>
							</div>
	
						</div>
					</s:if>
				</c:if>
	
		
	</s:elseif>
