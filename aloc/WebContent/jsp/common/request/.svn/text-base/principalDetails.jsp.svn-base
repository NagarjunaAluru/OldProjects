<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<s:set name="isEditMode" value="editMode"/>
	<s:if test="%{#isEditMode==true || ((requestDetails.WFDetails.WFStage == 'REQEST' || requestDetails.WFDetails.WFStage == 'REQUEST'  && #attr.isTaxonomy != true) && requestDetails.principal.requiresEdits == true)}">
		<c:if test="${param.includeScripts != false}">
		<script type="text/javascript">
		$(document).ready(function() {
			showHideIbsMessage();
			showHidePrincipalAddress();
			});
		</script>
		

		
		
		
		
		</c:if>
		<div id="principalDetForm" >
			<a name="second"></a>
			<c:if test="${empty requestDetails.principal.leGoldId}">
					<c:set var="goldidClass" value="display: none;" />
					<%-- <c:set var="goldidClearStyle" value="display: none;"/> --%>
				</c:if>
				<c:if test="${not empty requestDetails.principal.leGoldId}">
					<c:set var="goldidClass" value="display: block;" />
					<s:set var="goldidSelected" value="%{'Yes'}"></s:set>
					<%-- <c:set var="goldidClearStyle" value="display: inline;"/> --%>
				</c:if>
				
			<div class="row">
				<div class="form-row">
			    	<div class="span3">
						<s:textfield name="principalGoldId" key="label.request.common.legalEntityGOLDID" cssClass="span3 lookup-filterValue selectedGoldId" id="leGoldId" theme="aloc"
						tooltip="%{getText('label.request.tooltip.legalEntity')}"/>
						<span class="lookup-error hide" style="color: #AE2C2C;"></span>	
					</div>
					<div class="span1">
						<label>&nbsp;</label>
						<s:url action="LegalEntityLookup" namespace="/int" var="getLegalEntityURL" escapeAmp="false" encode="true"></s:url>
						<a class="btn-secondary lookup" href="<s:property value="#getLegalEntityURL" />" ><s:text name="label.request.common.lookup"/></a>
					</div>
					<div class="span5">
			        	<label>&nbsp;</label>
			            <img alt="Loading..." id="leIndicator" class="indicator" src="${pageContext.request.contextPath}/img/loading.gif" style="height: 20px;display:none">
					</div>
				</div>
			</div>
		
				<div class="conditional-row" id="goldidShow" style="${goldidClass}">
				<s:hidden name="principalGoldIdSelection" id="principalGoldIdSelectionID" value="%{#goldidSelected}"></s:hidden>
					<div class="row">
						<div class="span7">
							<div class="row">
								<div class="span2">
									<div class="form-row">
										<s:label key="label.request.common.legalEntityNameC" />
									</div>
								</div>
								<div class="span4 left">
									<div class="form-row">
										<p>
											<s:property value="requestDetails.principal.leName" />
										</p>
										<s:hidden name="requestDetails.principal.leName"
											id="tpApplicantLEName" cssClass="LEName mandatory"></s:hidden>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="span2">
									<div class="form-row">
										<s:label key="label.request.common.legalEntityGOLDIdC" />
									</div>
								</div>
								<div class="span4 left">
									<div class="form-row">
										<p>
											<s:property value="requestDetails.principal.leGoldId" />
										</p>
										<s:hidden name="requestDetails.principal.leGoldId"
											id="tpApplicantLEGoldID" cssClass="LEGoldID mandatory"></s:hidden>
									</div>
								</div>
							</div>
							<s:hidden name="name" id="lename"/><s:hidden name="Address1" id="Address1"/><s:hidden name="Address2" id="Address2"/><s:hidden name="AddressCity" id="AddressCity"/>
							<s:hidden name="stateCode" id="stateCode"/><s:hidden name="stateName" id="AddressState"/><s:hidden name="AddressZip" id="AddressZip"/><s:hidden name="countryCode" id="countryCode"/>
							<s:hidden name="countryName" id="AddressCountry"/>
						</div>
					</div>
				</div>
					
				<div class="row">
				    <s:if test="%{principlaAddressSelection == null}">
						<s:if test="%{requestDetails.principal == null 
						 || requestDetails.principal.addressDtls == null || 
						 (requestDetails.principal.addressDtls.name == null && 
							requestDetails.principal.addressDtls.city == null &&
							requestDetails.principal.addressDtls.stateProvince == null &&
							requestDetails.principal.addressDtls.ZIPPostalCode == null &&
							requestDetails.principal.addressDtls.country == null)}">
							<s:set var="PrincipalNameSelected" value="%{principlaAddressSelection}" />
						</s:if>
						<s:else>
							<s:set var="PrincipalNameSelected" value="%{'Selected'}"></s:set>
						</s:else>
					</s:if>
					<s:else>
						<s:set var="PrincipalNameSelected" value="%{principlaAddressSelection}" />
					</s:else>
					
					<s:if test="%{#PrincipalNameSelected == 'Selected'}">
						<c:set var="PrincipalDetailsClass" value="display: block;"/>
					</s:if>
					<s:else>
						<c:set var="PrincipalDetailsClass" value="display: none;"/>
					</s:else>
					
						<div class="form-row">
					    	<div class="span3">
				            	<%-- <s:label key="label.request.common.nameAddress" /> --%>
                            	<s:textfield name="nameForAddressPrincipal" key="label.request.sbNameAndAddress" cssClass="span3 lookup-filterValue" id="principalNameAddressId" theme="aloc"/>
								<p class="guidance"><s:text name="label.request.nameAddressGuidance" /></p>
								<s:hidden name="principalNameAddressValue" value="yes" cssClass="nameAddressClass"></s:hidden>
								<span class="lookup-error hide" style="color: #AE2C2C;"></span>
							</div>
							<div class="span1">
								<label>&nbsp;</label>
									<s:url action="NameAddressLookup" namespace="/int" var="getPrincipalNameAddressURL" escapeAmp="false" encode="true">
									<s:param name="addressTypeId">4</s:param>
									<s:param name="addressIndex">0</s:param>
								</s:url> 
								<a class="btn-secondary lookup" href="<s:property value="#getPrincipalNameAddressURL"/>" ><s:text name="label.request.common.lookup"/></a>
							</div>
							<div class="span5">
					        	<label>&nbsp;</label>
					            <img alt="Loading..." id="principalAddressIndicator" class="indicator" src="${pageContext.request.contextPath}/img/loading.gif" style="height: 20px; display:none">
					            <%-- <a class="btn-tertiary right clear-conditional-results"	id="PrincipalClear" href="javascript:;" type="submit" style="${PrincipalDetailsClearStyle}">Clear results</a> --%>
							</div>
						</div>
					</div>
		
				<div class="conditional-row" id="PrincipalShow" style="${PrincipalDetailsClass}"> 
					<s:hidden name="principlaAddressSelection" id="principlaAddressSelectionId" value="%{#PrincipalNameSelected}"></s:hidden>
					<div class="row">
					<div class="span7">
						<div class="row">
	                        <div class="span2">
	                            <div class="form-row">
	                                <s:label key="label.request.common.name"/>
	                            </div>
	                        </div>
	                        <div class="span4 right">	
	                            <div class="form-row" id="principalName">
	                                <p><s:property value="requestDetails.principal.addressDtls.name"/></p>
	                            </div>
	                        </div><!-- end of block -->
	                    </div>
	                    <div class="row">
	                        <div class="span2">
	                            <div class="form-row">
	                                <s:label key="label.request.address"/>
	                            </div>
	                        </div><!-- end of block -->
	                        <div class="span4 right">
	                            <div class="form-row" id="principalAddress">
	                              <s:iterator value="requestDetails.principal.addressDtls.address">
										<p><s:property/></p>
								</s:iterator>
									<p><s:property value="requestDetails.principal.addressDtls.city"/>
									<s:property value="requestDetails.principal.addressDtls.stateProvince"/>
									<s:property value="requestDetails.principal.addressDtls.ZIPPostalCode"/></p>
									<p><s:property value="requestDetails.principal.addressDtls.country"/>
									<s:property value="requestDetails.principal.addressDtls.stateOfInc"/>
								</p>
	                            </div>
	                        </div>
	                    </div>
					</div>
					<!-- end of block -->
				</div>
				</div>
				<div class="conditional-row-manually" id="PrincipalShowManually">
					<div class="row">
						<div class="span12">
							<div class="form-row">
								<s:textfield name="requestDetails.principal.addressDtls.name" key="label.request.common.name" id="principalAddressName" cssClass="mandatory" theme="aloc" maxlength="100"/>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="span12">
							<div class="form-row">
                                <s:textfield  key="label.request.common.address1" name="requestDetails.principal.addressDtls.address[0]" cssClass="mandatory" id="principalAddress1" theme="aloc" maxlength="100"/>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="span12">
							<div class="form-row">
								<s:label  key="label.request.address2Opti" cssClass="optional"/>
                                <s:textfield name="requestDetails.principal.addressDtls.address[1]" id="principalAddress2" maxlength="100"/>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="span12">
							<div class="form-row">
                                <s:textfield key="label.request.common.city" name="requestDetails.principal.addressDtls.city" id="principalAddressCity" cssClass="mandatory" theme="aloc" maxlength="50"/>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="span12">
							<div class="form-row">
								 <label class="optional"><s:text name="label.request.common.stateProvince"/> <s:text name="label.request.optional"/></label>
									<s:combobox listKey="stateName" listValue="stateName" headerKey="-1" headerValue="Select..." list="%{#attr['com.ge.aloc.StaticDataFactory'].stateList}"
										name="requestDetails.principal.addressDtls.stateProvince" id="principalAddressState" />
							</div>
						</div>
					</div>
					<div class="row">
						<div class="span12">
							<div class="form-row">
                                <s:textfield key="label.request.common.zipPostalCode" name="requestDetails.principal.addressDtls.ZIPPostalCode" id="principalAddressZip" cssClass="mandatory" theme="aloc" maxlength="12"/>
								<p class="guidance"><s:text name="label.request.zipCodeGuidance" /></p>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="span12">
							<div class="form-row">
								<sj:autocompleter key="label.request.country" id="principalCountryCd" list="%{#attr['com.ge.aloc.MasterDataFactory'].countries}" name="requestDetails.principal.addressDtls.countryCd" 
									cssClass="span3" listKey="countryCode" listValue="countryName" parentTheme="aloc" onChangeTopics="showPrincipalState"/>
								<s:hidden name="requestDetails.principal.addressDtls.country" id="principalAddressCountry" cssClass="mandatory autoCompleterName"></s:hidden>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="span12">
							<div class="form-row ckeckBoxLabel">
                                <label class="checkbox">
                                <s:checkbox name="requestDetails.principal.addressDtls.futureUseFlag" fieldValue="true" id="principleInfoFlag"></s:checkbox>
                                </label> <s:label key="label.request.common.saveforFutureuse" />
							</div>
						</div>
					</div>
					<div class="row hide" id="principalStateDivId">
						<div class="span12">
							<div class="form-row">
								 <label class="optional"><s:text name="label.request.stateProvinceofIncorporation"/> <s:text name="label.request.optional"/></label>
									<s:combobox listKey="stateName" listValue="stateName" headerKey="-1" headerValue="Select..." list="%{#attr['com.ge.aloc.StaticDataFactory'].stateList}"
										name="requestDetails.principal.addressDtls.stateOfInc" id="principalStateOfInc" />
							</div>
						</div>
					</div>
			    </div>
			 <div class="row">
			<div class="span12">
				<div class="form-row" style="padding-top:5px;">
					<c:if test="${empty requestDetails.principal  or empty requestDetails.principal.refDetails}">
						<c:set var="principalRefIndex" value="0"></c:set>
					</c:if>
					<c:if test="${not empty requestDetails.principal.refDetails}">
						<c:set var="principalRefIndex" value="${fn:length(requestDetails.principal.refDetails)}"></c:set>
						<c:if test="${principalRefIndex gt 0}">
							<c:set var="principalRefIndex" value="${principalRefIndex - 1}"></c:set>
						</c:if>
					</c:if>
					<input type="hidden" id="gereferenceFieldAddIndexId" name="gereferenceFieldAddIndex" class="referenceIndex" value="${principalRefIndex}">
					<input type="hidden" name="sectionName" class="sectionName" value="Principal">
                   	<table style="border: 0; width: 100%;" id="additionalPrincipalRef" class="additionalTable">
                   		<tbody>
                       	<tr>
                       		<td height="1" class="noPadding">
                        	<s:textfield name="requestDetails.principal.refDetails[0].refValue"
									theme="aloc" cssClass="mandatory"
									key="label.request.gePrincipalReference" 
									tooltip="%{getText('label.request.tooltip.geAppRef')}" maxlength="30"> 
								</s:textfield>
                            </td>
						</tr>
                        <c:if test="${not empty requestDetails.principal.refDetails and principalRefIndex >= 1}">
                        <c:forEach items="${requestDetails.principal.refDetails}" begin="1" varStatus="statIndex">
                        <tr class="optional">
                           	<td height="1" style="padding:10px 0px 5px 0px;">
                           	<c:if test="${statIndex.count eq 1}">
                           	<s:textfield name="requestDetails.principal.refDetails[1].refValue"
								theme="aloc" cssClass="referenceTextValue"
								key="label.request.gePrincipalReference2" maxlength="30">
							</s:textfield>
							</c:if>
							<c:if test="${statIndex.count eq 2}">
                           	<s:textfield name="requestDetails.principal.refDetails[2].refValue"
								theme="aloc" cssClass="referenceTextValue"
								key="label.request.gePrincipalReference3" maxlength="30">
							</s:textfield>
							</c:if>
							&nbsp;<a href="javascript:;" class="delete-ce" ><s:text name="label.request.removeReference"/></a>
                           	</td>
                        </tr>
                        </c:forEach>
                        </c:if>
						</tbody>
					</table>
					<div style="height: 8px;"></div>					
                       <a href="javascript:;" class="add-exception" id="addAdditionalPrincipalRef" 
                       style="display: ${principalRefIndex < 2 ? 'block' : 'none'}"><s:text name="label.request.AddAdditionalPrincipalGEReference" /></a>
					
				</div>
			</div><!-- end of block -->
		</div>
		 
				<div class="row">
					<div class="span12">
						<div class="form-row">
							<s:textfield name="requestDetails.principal.principalBuUniteCd"
								theme="aloc" cssClass="span1 mandatory"
								key="label.request.principalBusinessUniteCode" id="bussUnitCodeId"  maxlength="10"
								tooltip="%{getText('label.request.tooltip.principalBUC')}">
							</s:textfield>
			
						</div>
					</div>
					<!-- end of block -->
				</div>				
				<div class="row">
					<div class="span12">
						<div class="form-row">
							<s:textfield name="requestDetails.principal.principalAccDistNo"
								theme="aloc" cssClass="mandatory"
								key="label.request.principalAccountingDistributionNumber"
								tooltip="%{getText('label.request.tooltip.principalADN')}"
								id="accDistNoId" maxlength="30">
							</s:textfield>
							<img src="${pageContext.request.contextPath}/img/loading.gif"
								style="padding: 10px 0 0 10px; height: 20px; display: none;"
								id="bucadnLoading" align="middle" /> <img
								src="${pageContext.request.contextPath}/img/yes.png"
								title="Model Enabled" id="matched"
								style="vertical-align: middle; margin-left: 10px; display: none;" />
							<img src="${pageContext.request.contextPath}/img/no.png"
								title="Model Disabled" id="unMatched"
								style="vertical-align: middle; margin-left: 10px; display: none;" />
						</div>
					</div>
					<!-- end of block -->
				</div>			
				<div class="row ibsClass" style="display: none;">
					<div class="span12">
						<div class="form-row">
							<p style="padding: 6px 0;">
								<s:property value="requestDetails.principal.principalBuUniteCd" />
								<s:property value="requestDetails.principal.principalAccDistNo" />
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
                <p id="ibsMessage"><s:property value="requestDetails.principal.IBSSystMsg"/></p>
                <p id="ibsContact"><s:text name="label.request.ibsContact" /> <s:property value="requestDetails.principal.IBSLastName"/>, <s:property value="requestDetails.principal.IBSFirstName"/> </p>
                <s:hidden name="requestDetails.principal.IBSSystMsg" id="ibsSystemMsg"/>
				<s:hidden name="requestDetails.principal.IBSMsgId" id="ibsSystemMsgId"/>
				<s:hidden name="requestDetails.principal.IBSLastName" id="ibsLNameId"/>
				<s:hidden name="requestDetails.principal.IBSFirstName" id="ibsFNameId"/>
				<s:hidden name="requestDetails.principal.IBSPhoneNo" id="ibsPhoneId"/>
                </div>
                </div>
            </div>
        </div>	
		</div><!-- end of required count block -->	
		</s:if>
		  <s:elseif test="%{#isEditMode==false}">
              <c:if test="${param.verify ne 'suretybidAward'}">
				<div class="row">
					<div class="span2">
						<div class="form-row">
							<s:label key="label.request.common.legalEntityNameC" />
						</div>
					</div>
					<div class="span5 left">
						<div class="form-row">
							<p class="padding40">
								<c:out value="${requestDetails.principal.leName}" />
							</p>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="span2">
						<div class="form-row">
							<label><s:text name="label.request.common.legalEntityGOLDID" />: </label>
						</div>
					</div>
					<div class="span5 left">
						<div class="form-row">
							<p class="padding40">
								<c:out value="${requestDetails.principal.leGoldId}" />
							</p>
						</div>
					</div>
				</div>
	 </c:if>
		<div class="row">
			<div class="span2">
				<div class="form-row">
					<label><s:text name="label.request.sbNameAndAddress" /> : </label>
				</div>
			</div>
			<div class="span5 left">
				<div class="form-row">
					<p class="padding40">
						<c:out value="${requestDetails.principal.addressDtls.name}" />
					</p>
					<p class="padding40">
						<c:out
							value="${requestDetails.principal.addressDtls.address[0]}" />
					</p>
					<p class="padding40">
						<c:out
							value="${requestDetails.principal.addressDtls.address[1]}" />
					</p>
					<p class="padding40">
						<c:out value="${requestDetails.principal.addressDtls.city}" />
						<c:out value="${requestDetails.principal.addressDtls.stateProvince}" />
						<c:out
							value="${requestDetails.principal.addressDtls.ZIPPostalCode}" />
					</p>
					<p class="padding40">
						<c:out value="${requestDetails.principal.addressDtls.country}" />
					</p>
					<p class="padding40">
						<c:out
							value="${requestDetails.principal.addressDtls.countryOfInc}" />
					</p>
					<p class="padding40">
						<c:out
							value="${requestDetails.principal.addressDtls.stateOfInc}" />
					</p>
					<s:hidden name="requestDetails.principal.addressDtls.address[0]" id="principalAddress1" />
					<s:hidden name="requestDetails.principal.addressDtls.address[1]" id="principalAddress2" />
					<s:hidden name="requestDetails.principal.addressDtls.city" id="principalAddressCity"/>
					<s:hidden name="requestDetails.principal.addressDtls.stateProvinceCd" id="principalAddressStatecode"/>
					<s:hidden name="requestDetails.principal.addressDtls.stateProvince" id="principalAddressState" />
					<s:hidden name="requestDetails.principal.addressDtls.ZIPPostalCode" id="principalAddressZip"/>
					<s:hidden name="requestDetails.principal.addressDtls.countryCd" id="principalCountryCd"/>
					<s:hidden name="requestDetails.principal.addressDtls.country" id="principalAddressCountry" />					
				</div>
			</div>
			<!-- end of block -->
		</div>
        <c:if test="${param.verify ne 'suretybidAward'}">
				<s:iterator value="requestDetails.principal.refDetails" status="status">
					<div class="row">
						<div class="span2">
							<div class="form-row">
								<label><s:text name="label.request.gePrincipalReference" />&nbsp;<s:if test="%{#status.count > 1}"> <s:property value="%{#status.count}"/> </s:if>:</label>
							</div>
						</div>
						<div class="span5 left">
							<div class="form-row">
								<p class="padding40">
									<c:out value="${refValue}"/>
								</p>
							</div>
						</div>
						<!-- end of block -->
					</div>
				</s:iterator>
				<div class="row">
							<div class="span2">
								<div class="form-row">
									<label><s:text name="label.request.principalBUC"/> :</label>
								</div>
							</div>
							<div class="span5 left">
								<div class="form-row">
									<p class="padding40"  id="pBUC"><c:out value="${requestDetails.principal.principalBuUniteCd}"/></p>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="span2">
								<div class="form-row">
									<label><s:text name="label.request.principalADN"/> :</label>
								</div>
							</div>
							<div class="span5 left">
								<div class="form-row">
									<p class="padding40"  id="pADN"><c:out value="${requestDetails.principal.principalAccDistNo}"/></p>
								</div>
							</div>
							<!-- end of block -->
						</div>
				</c:if>
				<s:set name="refDetailsList" value="requestDetails.principal.refDetails" />
			
				<!-- </div> -->
</s:elseif>
