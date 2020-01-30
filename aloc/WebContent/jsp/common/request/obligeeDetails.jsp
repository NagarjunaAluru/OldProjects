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
			showHideObligeeAddress();
			});
		</script>
		</c:if>
	  	<div id="obligeeForm">	
                <div class="row">
                <s:if test="%{obligeeAddressSelection == null}">
	                <s:if test="%{requestDetails.obligee == null || 
					  requestDetails.obligee.addressDtls == null || 
					 ((requestDetails.obligee.addressDtls.name == null || requestDetails.obligee.addressDtls.name == '' ) &&
						(requestDetails.obligee.addressDtls.city == null || requestDetails.obligee.addressDtls.city == '') &&
						(requestDetails.obligee.addressDtls.stateProvince == null || requestDetails.obligee.addressDtls.stateProvince == '' ) &&
						(requestDetails.obligee.addressDtls.ZIPPostalCode == null || requestDetails.obligee.addressDtls.ZIPPostalCode == '' ) &&
						(requestDetails.obligee.addressDtls.country == null || requestDetails.obligee.addressDtls.country == ''))}">
						<s:set var="ObligeeNameSelected" value="%{obligeeAddressSelection}" />
					</s:if>
					<s:else>
						<s:set var="ObligeeNameSelected" value="%{'Selected'}"></s:set>
					</s:else>
				</s:if>
				<s:else>
					<s:set var="ObligeeNameSelected" value="%{obligeeAddressSelection}" />
				</s:else>

				<s:if test="%{#ObligeeNameSelected == 'Selected'}">
					<c:set var="ObligeeDetailsClass" value="display: block;"/>
				</s:if>
				<s:else>
					<c:set var="ObligeeDetailsClass" value="display: none;"/>
				</s:else>
				
					<div class="form-row">
					    	<div class="span3">
								<s:textfield name="nameForObligeeAddress" key="label.request.common.nameAddress" cssClass="span3 lookup-filterValue" id="obligeeNameAddressId" theme="aloc"/>
								<p class="guidance"><s:text name="label.request.nameAddressGuidance" /></p>
								<s:hidden name="ObligeeNameAddressValue" value="yes" cssClass="nameAddressClass"></s:hidden>
								<span class="lookup-error hide" style="color: #AE2C2C;"></span>
							</div>
							<div class="span1">
								<label>&nbsp;</label>
								<s:url action="NameAddressLookup" namespace="/int" var="getObligeeNameAddressURL" escapeAmp="false" encode="true">
									<s:param name="addressTypeId">5</s:param>
									<s:param name="addressIndex">0</s:param>
								</s:url> 
								<a class="btn-secondary lookup" href="<s:property value="#getObligeeNameAddressURL"/>" ><s:text name="label.request.common.lookup"/></a>
							</div>
							<div class="span5">
					        	<label>&nbsp;</label>
					            <img alt="Loading..." id="obligeeAddressIndicator" class="indicator" src="${pageContext.request.contextPath}/img/loading.gif" style="height: 20px; display:none">
							</div>
					</div>
			    </div>
				<div class="conditional-row" id="ObligeeShow" style="${ObligeeDetailsClass}"> 
				<s:hidden name="obligeeAddressSelection" id="obligeeAddressSelectionId" value="%{#ObligeeNameSelected}"></s:hidden>
					<div class="row">
					<div class="span7">
						<div class="row">
	                        <div class="span2">
	                            <div class="form-row">
	                                <s:label key="label.request.common.name"/>
	                            </div>
	                        </div>
	                        <div class="span4 right">	
	                            <div class="form-row" id="obligeeName">
	                                <p><s:property value="requestDetails.obligee.addressDtls.name"/></p>
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
	                            <div class="form-row" id="obligeeAddress">
	                             <s:iterator value="requestDetails.obligee.addressDtls.address">
										<p><s:property/></p>
								</s:iterator>
									<p><s:property value="requestDetails.obligee.addressDtls.city"/>
									<s:property value="requestDetails.obligee.addressDtls.stateProvince"/>
									<s:property value="requestDetails.obligee.addressDtls.ZIPPostalCode"/></p>
									<p><s:property value="requestDetails.obligee.addressDtls.country"/>
								</p>
	                            </div>
	                        </div>
	                    </div>
					</div>
					<!-- end of block -->
				</div>
				</div>
				<div class="conditional-row-manually" id="ObligeeShowManually">
					<div class="row">
						<div class="span12">
							<div class="form-row">
							<s:textfield key="label.request.common.name" name="requestDetails.obligee.addressDtls.name" id="obligeeAddressName" cssClass="mandatory" theme="aloc" maxlength="100"/>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="span12">
							<div class="form-row">
							<s:textfield key="label.request.common.address1" name="requestDetails.obligee.addressDtls.address[0]" id="obligeeAddress1" cssClass="mandatory" theme="aloc" maxlength="100"/>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="span12">
							<div class="form-row">
							<s:label  key="label.request.address2Opti" cssClass="optional"/>
							<s:textfield name="requestDetails.obligee.addressDtls.address[1]" id="obligeeAddress2" maxlength="100"/>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="span12">
							<div class="form-row">
							<s:textfield key="label.request.common.city" name="requestDetails.obligee.addressDtls.city" id="obligeeAddressCity" cssClass="mandatory" theme="aloc" maxlength="50"/>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="span12">
							<div class="form-row">
								 <label class="optional"><s:text name="label.request.common.stateProvince"/> <s:text name="label.request.optional"/></label>
									<s:combobox listKey="stateName" listValue="stateName" headerKey="-1" headerValue="Select..." list="%{#attr['com.ge.aloc.StaticDataFactory'].stateList}"
										name="requestDetails.obligee.addressDtls.stateProvince" id="obligeeAddressState" />
							</div>
						</div>
					</div>
					<div class="row">
						<div class="span12">
							<div class="form-row">
							<s:textfield key="label.request.common.zipPostalCode" name="requestDetails.obligee.addressDtls.ZIPPostalCode" id="obligeeAddressZip" theme="aloc" cssClass="mandatory" maxlength="12"/>
							<p class="guidance"><s:text name="label.request.zipCodeGuidance" /></p>
							</div>
						</div>
					</div>			
					<div class="row">
						<div class="span12">
							<div class="form-row">
							<sj:autocompleter id="obligeeAddressCountryCd" list="%{#attr['com.ge.aloc.MasterDataFactory'].countries}" name="requestDetails.obligee.addressDtls.countryCd" 
								key="label.request.common.country" cssClass="span3" listKey="countryCode" listValue="countryName" parentTheme="aloc" onChangeTopics="getAutocompleterName"/>
								<s:hidden name="requestDetails.obligee.addressDtls.country" id="obligeeAddressCountry" cssClass="autoCompleterName mandatory"></s:hidden>
							</div> 
						</div>
					</div>
					<div class="row">
						<div class="span12">
							<div class="form-row ckeckBoxLabel">
						<label class="checkbox">
						<s:checkbox name="requestDetails.obligee.addressDtls.futureUseFlag" fieldValue="true">
						 </s:checkbox>
						</label><s:text name="label.request.common.saveforFutureuse"></s:text><span class="ttip info"	data-original-title="<s:text name="label.request.tooltip.saveForFutureUse"/>"></span>
					</div>
				</div>
			</div>
				</div>
				
		<div class="row">
			<div class="span12">
				<div class="form-row" style="padding-top:5px;">
					<c:if test="${empty requestDetails.obligee  or empty requestDetails.obligee.obligeeReves}">
						<c:set var="oblRefIndex" value="0"></c:set>
					</c:if>
					<c:if test="${not empty requestDetails.obligee.obligeeReves}">
						<c:set var="oblRefIndex" value="${fn:length(requestDetails.obligee.obligeeReves)}"></c:set>
						<c:if test="${oblRefIndex gt 0}">
							<c:set var="oblRefIndex" value="${oblRefIndex - 1}"></c:set>
						</c:if>
					</c:if>
					<input type="hidden" id="oblreferenceFieldAddIndexId" name="oblreferenceFieldAddIndex" class="referenceIndex" value="${oblRefIndex}">
					<input type="hidden" name="sectionName" class="sectionName" value="Obligee">
                   	<table style="border: 0; width: 100%;" id="additionalOblRef" class="additionalTable">
                   		<tbody>
                       	<tr>
                       		<td height="1" class="noPadding">
                        	<s:textfield name="requestDetails.obligee.obligeeReves[0].refValue"
									theme="aloc" cssClass="mandatory"
									key="label.request.obligeeReference" 
									tooltip="%{getText('label.request.tooltip.obligeeRef')}" maxlength="30">
								</s:textfield>
                            </td>
						</tr>
                        <c:if test="${not empty requestDetails.obligee.obligeeReves and oblRefIndex >= 1}">
                        <c:forEach items="${requestDetails.obligee.obligeeReves}" begin="1" varStatus="statIndex">
                        <tr class="optional">
                           	<td height="1" style="padding:10px 0px 5px 0px;">
                           	<c:if test="${statIndex.count eq 1}">
                           	<s:textfield name="requestDetails.obligee.obligeeReves[1].refValue"
								theme="aloc" cssClass="referenceTextValue"
								key="label.request.obligeeReference2" maxlength="30">
							</s:textfield>
							</c:if>
							<c:if test="${statIndex.count eq 2}">
                           	<s:textfield name="requestDetails.obligee.obligeeReves[2].refValue"
								theme="aloc" cssClass="referenceTextValue"
								key="label.request.obligeeReference3" maxlength="30">
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
                       <a href="javascript:;" class="add-exception" id="addAdditionalOblRef" 
                       style="display: ${oblRefIndex < 2 ? 'block' : 'none'}"><s:text name="label.request.addAnAdditionalObligeeReference" /></a>
					
				</div>
			</div><!-- end of block -->
		</div>
	</div><!-- end of required count block -->			
</s:if>	
		<s:elseif test="%{#isEditMode==false}">
										
					<div class="row">
				    <div class="span2">
			            <div class="form-row">
							<label><s:text name="label.request.common.nameAddress" />:</label>
							</div>
						</div>
						<div class="span5 left ">
							<div class="form-row">
								<p class="padding40"><c:out value="${requestDetails.obligee.addressDtls.name}" /></p>
								<p class="padding40"><c:out value="${requestDetails.obligee.addressDtls.address[0]}" /></p>
								<p class="padding40"><c:out value="${requestDetails.obligee.addressDtls.address[1]}" /></p>
								<p class="padding40"><c:out value="${requestDetails.obligee.addressDtls.address[2]}" /></p>
								<p class="padding40"><c:out value="${requestDetails.obligee.addressDtls.city}" />
								   <c:out value="${requestDetails.obligee.addressDtls.stateProvince}" />
								   <c:out value="${requestDetails.obligee.addressDtls.ZIPPostalCode}" /></p>
								<p class="padding40"><c:out value="${requestDetails.obligee.addressDtls.country}" /></p>
								
								<s:hidden name="requestDetails.obligee.addressDtls.address[0]" id="obligeeAddress1" />
								<s:hidden name="requestDetails.obligee.addressDtls.address[1]" id="obligeeAddress2" />
								<s:hidden name="requestDetails.obligee.addressDtls.city" id="obligeeAddressCity"/>
								<s:hidden name="requestDetails.obligee.addressDtls.stateProvinceCd" id="obligeeAddressStateCd"/>
								<s:hidden name="requestDetails.obligee.addressDtls.stateProvince" id="obligeeAddressState" />
								<s:hidden name="requestDetails.obligee.addressDtls.ZIPPostalCode" id="obligeeAddressZip"/>
								<s:hidden name="requestDetails.obligee.addressDtls.countryCd" id="obligeeAddressCountryCd"/>
								<s:hidden name="requestDetails.obligee.addressDtls.country" id="obligeeAddressCountry" />
							</div>
						</div>
						<!-- end of block -->
					</div>
			     <c:if test="${param.verify ne 'suretybidAward'}">
					<s:iterator value="requestDetails.obligee.obligeeReves" status="stat">
						<div class="row">
							<div class="span2">
								<div class="form-row">
									<label><s:text name="label.request.obligeeReference" />&nbsp;<s:if test="%{#stat.count > 1}"><s:property value="%{#stat.count}"/> </s:if>:</label>
								</div>
							</div>
							<div class="span5 left">
								<div class="form-row">
									<p class="padding40">
										<c:out value="${refValue}" />
									</p>
								</div>
							</div>
							<!-- end of block -->
						</div>
					</s:iterator>
				</c:if>
</s:elseif>
