<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>

<s:set name="isEditMode" value="editMode"/>
	  <s:if test="%{#isEditMode==true}">
		<div class="row">
			<div class="span2ab">
				<div class="form-row">
					<p style="padding: 2px 0;">
						<b><s:text name="label.request.selectedSite"/></b> 
					</p>
				</div>
			</div>
			<div class="span8 left">	
				<div class="form-row">
					<p class="padding40"><s:property value="requestDetails.siteName"/></p>
					<s:hidden name="requestDetails.amendment.transactionParties.siteName" value="%{requestDetails.siteName}" />
				</div>
			</div>
			<!-- end of block -->
		</div>
		
		<c:if test="${requestDetails.siteTypeName eq 'Financial Business'}">
		<div class="row" style="margin-bottom: 15px !important;">
			<div class="span2ab">
				<div class="form-row">
					<s:label key="label.request.isTriPartyRequest" theme="aloc" tooltip="%{getText('label.request.tooltip.applicant')}"/>
				</div>
			</div>
			<div class="span8 left">	
				<div class="form-row">
					<p class="padding40">
					<s:if test="%{requestDetails.amendment.transactionParties.triPartyRequestFlag}">Yes</s:if>
					<s:else>No</s:else>
					</p>
				</div>
			</div>		
		</div>
		
		<s:if test="%{requestDetails.amendment.transactionParties.triPartyRequestFlag}">
		<div class="row hide" id="private">
			<div class="span2ab">
				<div class="form-row">
					<s:label key="label.request.privateLabel" theme="aloc" tooltip="%{getText('label.request.tooltip.applicant')}"/>
				</div>
			</div>
			<div class="span8 left">	
				<div class="form-row">
					<p class="padding40">
					<s:if test="%{requestDetails.amendment.transactionParties.privateLabelFlag}">Yes</s:if>
					<s:else >No</s:else>
					</p>
				</div>
			</div>		
		</div>
		</s:if>
		</c:if>
		<h3 id="applicantHeader"><s:text name="label.request.applicant"></s:text></h3>
		
		<div class="row">
			<div class="span2ab">
				<div class="form-row">
					<s:label key="label.request.common.legalEntityNameC"/>
				</div>
			</div>
			<!-- end of block -->
			<div class="span8 left">
				<div class="form-row">
					<p class="padding40"><s:property value="requestDetails.transactionParties.tpApplicantDetails.leName"/></p>
					<s:hidden name="requestDetails.amendment.transactionParties.tpApplicantDetails.leName" id="tpApplicantLEName" cssClass="LEName"></s:hidden>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="span2ab">
				<div class="form-row">
					<s:label key="label.request.common.legalEntityGOLDIdC"/>
				</div>
			</div>
			<div class="span8 left">
				<div class="form-row">
					<p class="padding40"><s:property value="requestDetails.transactionParties.tpApplicantDetails.leGoldId"/></p>
					<s:hidden name="requestDetails.amendment.transactionParties.tpApplicantDetails.leGoldId" id="tpApplicantLEGoldID" cssClass="LEGoldID"></s:hidden>
				</div>
			</div>
			<!-- end of block -->
		</div>
		<div class="row">
			<div class="span2ab">
				<div class="form-row">
					<s:label key="label.request.businessContactPerson"/>
				</div>
			</div>
			<div class="span8 left">
				<div class="form-row">
					<p class="padding40"><s:property value="requestDetails.transactionParties.tpApplicantDetails.tpBuContactPerson.lastName"/>, 
					<s:property value="requestDetails.transactionParties.tpApplicantDetails.tpBuContactPerson.firstName"/> 
					<s:property value="requestDetails.transactionParties.tpApplicantDetails.tpBuContactPerson.ssoId"/></p>
					<s:hidden name="requestDetails.amendment.transactionParties.tpApplicantDetails.tpBuContactPerson.lastName" id="tpApplicantBCPLName"></s:hidden>
					<s:hidden name="requestDetails.amendment.transactionParties.tpApplicantDetails.tpBuContactPerson.firstName" id="tpApplicantBCPFName"></s:hidden>
					<s:hidden name="requestDetails.amendment.transactionParties.tpApplicantDetails.tpBuContactPerson.ssoId" id="tpApplicantBCPSSO"></s:hidden>
				</div>
			</div>
			<!-- end of block -->
		</div>
		
			
		<div class="row">
			<div class="span12">
				<div class="form-row">
					<s:label key="label.request.nameAndAddress" />
					<s:textfield name="nameForAddress" cssClass="span3 lookup-filterValue" id="nameAddressId" />
					<s:hidden name="tpApplicantNameAddressValue" value="yes" cssClass="nameAddressClass"></s:hidden>
					<s:url action="NameAddressLookup" namespace="/int" var="getApplicantNameAddressURL" escapeAmp="false" encode="true">
						<s:param name="addressTypeId">1</s:param>
					</s:url> 
					<a class="btn-secondary lookup" href="<s:property value="#getApplicantNameAddressURL"/>" ><s:text name="label.request.common.lookup"/></a>
					
					<img alt="Loading..." id="applicantAddressIndicator" class="indicator" src="${pageContext.request.contextPath}/img/loading.gif" 
						style="height: 20px; display:none">
					<a class="btn-tertiary right clear-conditional-results"	id="ApplicantClear" href="javascript:;" type="submit"><s:text name="label.request.common.clearResults" /></a>
					<br />
					<span class="lookup-error hide" style="color: #AE2C2C;"></span>
				</div>
			</div>
		</div>
		
		<div id="ApplicantShow">
			<div class="row">
				<div class="span12">
					<div class="form-row">
						<p><s:property value="requestDetails.amendment.transactionParties.tpApplicantDetails.addressDtls.name"/></p>
						<s:iterator value="requestDetails.amendment.transactionParties.tpApplicantDetails.addressDtls.address" >
							<p><s:property/> </p>
						</s:iterator>
						
						<p><s:property value="requestDetails.amendment.transactionParties.tpApplicantDetails.addressDtls.city"/>
						 <s:property value="requestDetails.amendment.transactionParties.tpApplicantDetails.addressDtls.stateProvince"/> 
						 <s:property value="requestDetails.amendment.transactionParties.tpApplicantDetails.addressDtls.ZIPPostalCode"/>
						 </p>
						<p><s:property value="requestDetails.amendment.transactionParties.tpApplicantDetails.addressDtls.country"/></p>
					</div>
				</div>
				<!-- end of block -->
			</div>
		</div>
		<div class="conditional-row" id="ApplicantShowManually">
			<div class="row">
				<div class="span12">
					<div class="form-row">
						<s:textfield name="requestDetails.amendment.transactionParties.tpApplicantDetails.addressDtls.name" 
							id="applicantAddressName" 
							key="label.request.common.name" 
							theme="aloc"
						/>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="span12">
					<div class="form-row">
						<s:textfield name="requestDetails.amendment.transactionParties.tpApplicantDetails.addressDtls.address[0]" 
							id="applicantAddress1" 
							key="label.request.common.address1" 
							theme="aloc" maxlength="100"
						/>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="span12">
					<div class="form-row">
						<s:textfield name="requestDetails.amendment.transactionParties.tpApplicantDetails.addressDtls.address[1]" 
							id="applicantAddress2" 
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
						<s:textfield name="requestDetails.amendment.transactionParties.tpApplicantDetails.addressDtls.city" 
							id="applicantAddressCity" 
							key="label.request.common.city" 
							theme="aloc" maxlength="50"
						/>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="span12">
					<div class="form-row">
						<label class="optional"><s:text name="label.request.common.stateProvince"/> <s:text name="label.request.optional"/></label>
							<s:combobox listKey="stateName" listValue="stateName" headerKey="-1" headerValue="Select..." list="%{#attr['com.ge.aloc.StaticDataFactory'].stateList}"
								name="requestDetails.amendment.transactionParties.tpApplicantDetails.addressDtls.stateProvince" id="applicantAddressState" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="span12">
					<div class="form-row">
						<s:textfield name="requestDetails.amendment.transactionParties.tpApplicantDetails.addressDtls.ZIPPostalCode" 
							id="applicantAddressZip" 
							key="label.request.common.zipPostalCode" 
							theme="aloc" maxlength="12"/>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="span12">
					<div class="form-row">
						<sj:autocompleter id="applicantAddressCountryCd" list="%{#attr['com.ge.aloc.MasterDataFactory'].countries}" key="label.request.common.country" 
						name="requestDetails.amendment.transactionParties.tpApplicantDetails.addressDtls.countryCd" cssClass="span3" listKey="countryCode" listValue="countryName" theme="aloc"/>
						<s:hidden name="requestDetails.amendment.transactionParties.tpApplicantDetails.addressDtls.country" id="applicantAddressCountry"></s:hidden>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="span12">
					<div class="form-row ckeckBoxLabel">
						<%--  <input type="checkbox"
							name="checkbox">Save for future use<span
							class="ttip info"
							data-original-title="This is an tooltip with more information"></span>
						</label> --%>
						<label class="checkbox">
						<s:checkbox name="requestDetails.amendment.transactionParties.tpApplicantDetails.addressDtls.futureUseFlag" fieldValue="true">
						</s:checkbox>
						</label>
						<s:text name="label.request.common.saveforFutureuse"></s:text> 
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="span2ab">
				<div class="form-row">
					<label><s:text name="label.request.geApplicantReference" /></label>
				</div>
			</div>
			<div class="span8 left">
				<div class="form-row">
					<p class="padding40">
						<s:property value="requestDetails.transactionParties.tpApplicantDetails.refDetails[0].refValue" />
						<s:hidden name="requestDetails.amendment.transactionParties.tpApplicantDetails.refDetails[0].refValue"/>
					</p>
				</div>
			</div>
		</div>
		<s:set name="geRefSize"
			value="requestDetails.amendment.transactionParties.tpApplicantDetails.refDetails.size" />
		<s:if test="#geRefSize > 1">
			
			<s:iterator value="requestDetails.amendment.transactionParties.tpApplicantDetails.refDetails" status="stat">
				<s:if test="#stat.index != 0">
					<div class="row">
						<div class="span2ab">
							<div class="form-row">
								<label><s:text
										name="label.request.geApplicantReference" />
									<s:property value="#stat.count" /></label>
							</div>
						</div>
						<div class="span8 left">
							<div class="form-row">
								<p class="padding40">
									<s:property value="refValue" />
									<s:hidden name="requestDetails.transactionParties.tpApplicantDetails.refDetails[%{#stat.index}].refValue"/>
								</p>
							</div>
						</div>
					</div>
				</s:if>
			</s:iterator>
		</s:if>
	<%-- 	
		<div class="row">
			<div class="span2ab">
				<div class="form-row">
					<s:label key="label.request.buc"/>
				</div>
			</div>
			<div class="span8 left">
				<div class="form-row">
					<p class="padding40"><s:property value="requestDetails.amendment.transactionParties.tpApplicantDetails.buUnit"/></p>
				</div>
			</div>
			<!-- end of block -->
		</div>
		<div class="row">
			<div class="span2ab">
				<div class="form-row">
					<s:label key="label.request.adn"/>
				</div>
			</div>
			<div class="span8 left">
				<div class="form-row">
					<p class="padding40"><s:property value="requestDetails.amendment.transactionParties.tpApplicantDetails.accDist"/></p>
				</div>
			</div>
			<!-- end of block -->
		</div>
		 --%>
		<div class="row ibsClass" style="display: none;">
			<div class="span12">
				<div class="form-row">
					<label><s:property value="requestDetails.amendment.transactionParties.tpApplicantDetails.IBSSystMsg"/></label>
					<s:hidden name="requestDetails.amendment.transactionParties.tpApplicantDetails.IBSSystMsg" id="ibsSystemMsg"/>
					<s:hidden name="requestDetails.amendment.transactionParties.tpApplicantDetails.IBSMsgId" id="ibsSystemMsgId"/>
				</div>
			</div>
		</div>
		<div class="row ibsClass" style="display: none;">
			<div class="span2ab">
				<div class="left">
					<div class="form-row">
						<s:label key="label.request.ibsContact"/>
					</div>
				</div>
			</div>
			<div class="span8 left">
				<span style="padding-left: 40px">
				<c:if test="${not empty requestDetails.amendment.transactionParties.tpApplicantDetails.IBSLastName and not empty requestDetails.amendment.transactionParties.tpApplicantDetails.IBSFirstName }">
					<s:property value="requestDetails.amendment.transactionParties.tpApplicantDetails.IBSLastName"/>, <s:property value="requestDetails.transactionParties.tpApplicantDetails.IBSFirstName"/>
				</c:if>
				
				</span>
				<s:hidden name="requestDetails.amendment.transactionParties.tpApplicantDetails.IBSLastName" id="ibsLNameId"/>
				<s:hidden name="requestDetails.amendment.transactionParties.tpApplicantDetails.IBSFirstName" id="ibsFNameId"/>
			</div>
			
		</div>
		<div class="row ibsClass" style="display: none;">
			<div class="span2ab">
				<div class="left">
					<div class="form-row">
						<s:label key="label.request.ibsPhone"/>
					</div>
				</div>
			</div>	
				<div class="span8 left">
					<span style="padding-left: 40px"><s:property value="requestDetails.amendment.transactionParties.tpApplicantDetails.IBSPhoneNo"/></span>
				</div>
				<s:hidden name="requestDetails.amendment.transactionParties.tpApplicantDetails.IBSPhoneNo" id="ibsPhoneId"/>
		</div>

		<c:if test="${requestDetails.siteTypeName eq 'Financial Business'}">
		<s:if test="%{requestDetails.amendment.transactionParties.triPartyRequestFlag}">
		<div class="hide" id="TriPartyApplicant">
			<h3 id="triPartyHeader"> <s:text name="label.request.triPartyApplicant" /> </h3>
			<div class="row">
				<div class="span12">
					<div class="form-row">
						<s:label key="label.request.nameAndAddress" />
						<s:textfield name="nameForAddress" cssClass="span3 lookup-filterValue" id="triPartyApplicantNameAddressId" />
						<s:hidden name="triPartyNameAddressValue" value="yes" cssClass="nameAddressClass"></s:hidden>
						<s:url action="NameAddressLookup" namespace="/int" var="getTriApplicantNameAddressURL" escapeAmp="false" encode="true">
							<s:param name="addressTypeId">2</s:param>
						</s:url> 
						<a class="btn-secondary lookup" href="<s:property value="#getTriApplicantNameAddressURL"/>" ><s:text name="label.request.common.lookup"/></a>
						
						<img alt="Loading..." id="triPartyApplicantAddressIndicator" class="indicator" 
							src="${pageContext.request.contextPath}/img/loading.gif" style="height: 20px; display:none">
					
						<a class="btn-tertiary right clear-conditional-results"	id="TriPartyClear" href="javascript:;" type="submit"><s:text name="label.request.common.clearResults" /></a>
						<br />
						<span class="lookup-error hide" style="color: #AE2C2C;"></span>
					</div>
				</div>
			</div>
			
			<div id="TriPartyShow">
				<div class="row">
					<div class="span12">
						<div class="form-row">
							<p><s:property value="requestDetails.amendment.transactionParties.triPartyApplicant.name"/></p>
							<s:iterator value="requestDetails.amendment.transactionParties.triPartyApplicant.address" >
								<p><s:property/> </p>
							</s:iterator>
							
							<p><s:property value="requestDetails.amendment.transactionParties.triPartyApplicant.city"/>
							 <s:property value="requestDetails.amendment.transactionParties.triPartyApplicant.stateProvince"/> 
							 <s:property value="requestDetails.amendment.transactionParties.triPartyApplicant.ZIPPostalCode"/>
							 </p>
							<p><s:property value="requestDetails.amendment.transactionParties.triPartyApplicant.country"/></p>
						</div>
					</div>
					<!-- end of block -->
				</div>
			</div>
			<div class="conditional-row" id="TriPartyShowManually">
				<div class="row">
				<div class="span12">
					<div class="form-row">
						<s:textfield name="requestDetails.amendment.transactionParties.triPartyApplicant.name" 
							id="triPartyAddressName" 
							key="label.request.common.name" 
							theme="aloc"
						/>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="span12">
					<div class="form-row">
						<s:textfield name="requestDetails.amendment.transactionParties.triPartyApplicant.address[0]" 
							id="triPartyAddress1" 
							key="label.request.common.address1" 
							theme="aloc" maxlength="100"
						/>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="span12">
					<div class="form-row">
						<s:textfield name="requestDetails.amendment.transactionParties.triPartyApplicant.address[1]" 
							id="triPartyAddress2" 
							key="label.request.common.address2opt" 
							required="false"
							theme="aloc"
						/>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="span12">
					<div class="form-row">
						<s:textfield name="requestDetails.amendment.transactionParties.triPartyApplicant.city" 
							id="triPartyAddressCity" 
							key="label.request.common.city" 
							theme="aloc"
						/>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="span12">
					<div class="form-row">
						<label class="optional"><s:text name="label.request.common.stateProvince"/> <s:text name="label.request.optional"/></label>
							<s:combobox listKey="stateName" listValue="stateName" headerKey="-1" headerValue="Select..." list="%{#attr['com.ge.aloc.StaticDataFactory'].stateList}"
								name="requestDetails.amendment.transactionParties.triPartyApplicant.stateProvince" id="triPartyAddressState" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="span12">
					<div class="form-row">
						<s:textfield name="requestDetails.amendment.transactionParties.triPartyApplicant.ZIPPostalCode" 
							id="triPartyAddressZip" 
							key="label.request.common.zipPostalCode" 
							theme="aloc" maxlength="12"/>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="span12">
					<div class="form-row">
						<sj:autocompleter id="triPartyAddressCountryCd" list="%{#attr['com.ge.aloc.MasterDataFactory'].countries}" key="label.request.common.country" 
						name="requestDetails.amendment.transactionParties.triPartyApplicant.countryCd" cssClass="span3" listKey="countryCode" listValue="countryName" theme="aloc"/>
						<s:hidden name="requestDetails.amendment.transactionParties.triPartyApplicant.country" id="triPartyAddressCountry"></s:hidden>
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
								<s:checkbox name="requestDetails.amendment.transactionParties.triPartyApplicant.futureUseFlag" fieldValue="true">
								 </s:checkbox>
							</label>
							<s:text name="label.request.common.saveforFutureuse"></s:text>
						</div>
					</div>
					<!-- end of block -->
				</div>
			</div>
		</div>
		</s:if>
		</c:if>

		<h3 id="customerHeader"><s:text name="label.request.customer" /> </h3>
		<div class="row">
			<div class="span12">
				<div class="form-row">
					
					<s:label key="label.request.nameAndAddress" />
					<s:textfield name="nameForAddress" cssClass="span3 lookup-filterValue" id="customerNameAddressId" />
					<s:hidden name="customerNameAddressValue" value="yes" cssClass="nameAddressClass"></s:hidden>
					<s:url action="NameAddressLookup" namespace="/int" var="getCustomerNameAddressURL" escapeAmp="false" encode="true">
						<s:param name="addressTypeId">3</s:param>
					</s:url> 
					<a class="btn-secondary lookup" href="<s:property value="#getCustomerNameAddressURL"/>" ><s:text name="label.request.common.lookup"/></a>
					
					<img alt="Loading..." id="customerAddressIndicator" class="indicator" 
						src="${pageContext.request.contextPath}/img/loading.gif" style="height: 20px; display:none">
					<a class="btn-tertiary right clear-conditional-results"	id="CustomerBeneficiaryClear" href="javascript:;" type="submit"><s:text name="label.request.common.clearResults" /></a>
					<br />
					<span class="lookup-error hide" style="color: #AE2C2C;"></span>
				</div>
			</div>
		</div>
		
		<div id="CustomerBeneficiaryShow">
			<div class="row">
				<div class="span12">
					<div class="form-row">
						<p><s:property value="requestDetails.amendment.transactionParties.customer.addressDtls.name"/></p>
						<s:iterator value="requestDetails.amendment.transactionParties.customer.addressDtls.address">
							<p><s:property/> </p>
						</s:iterator>
						
						<p><s:property value="requestDetails.amendment.transactionParties.customer.addressDtls.city"/>
						 <s:property value="requestDetails.amendment.transactionParties.customer.addressDtls.stateProvince"/> 
						 <s:property value="requestDetails.amendment.transactionParties.customer.addressDtls.ZIPPostalCode"/>
						 </p>
						<p><s:property value="requestDetails.amendment.transactionParties.customer.addressDtls.country"/></p>
					</div>
				</div>
				<!-- end of block -->
			</div>
		</div>
		<div class="conditional-row" id="CustomerBeneficiaryShowManually">
			<div class="row">
				<div class="span12">
					<div class="form-row">
						<s:textfield name="requestDetails.amendment.transactionParties.customer.addressDtls.name" 
							id="customerAddressName" 
							key="label.request.common.name" 
							theme="aloc"
						/>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="span12">
					<div class="form-row">
						<s:textfield name="requestDetails.amendment.transactionParties.customer.addressDtls.address[0]" 
							id="customerAddress1" 
							key="label.request.common.address1" 
							theme="aloc" maxlength="100"
						/>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="span12">
					<div class="form-row">
						<s:textfield name="requestDetails.amendment.transactionParties.customer.addressDtls.address[1]" 
							id="customerAddress2" 
							key="label.request.common.address2opt" 
							required="false"
							theme="aloc"
						/>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="span12">
					<div class="form-row">
						<s:textfield name="requestDetails.amendment.transactionParties.customer.addressDtls.city" 
							id="customerAddressCity" 
							key="label.request.common.city" 
							theme="aloc"
						/>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="span12">
					<div class="form-row">
						<label class="optional"><s:text name="label.request.common.stateProvince"/> <s:text name="label.request.optional"/></label>
							<s:combobox listKey="stateName" listValue="stateName" headerKey="-1" headerValue="Select..." list="%{#attr['com.ge.aloc.StaticDataFactory'].stateList}"
								name="requestDetails.amendment.transactionParties.customer.addressDtls.stateProvince" id="customerAddressState" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="span12">
					<div class="form-row">
						<s:textfield name="requestDetails.amendment.transactionParties.customer.addressDtls.ZIPPostalCode" 
							id="customerAddressZip" 
							key="label.request.common.zipPostalCode" 
							theme="aloc" maxlength="12"/>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="span12">
					<div class="form-row">
						<sj:autocompleter id="customerAddressCountryCd" list="%{#attr['com.ge.aloc.MasterDataFactory'].countries}" key="label.request.common.country" 
						name="requestDetails.amendment.transactionParties.customer.addressDtls.countryCd" cssClass="span3" listKey="countryCode" listValue="countryName" theme="aloc"/>
						<s:hidden name="requestDetails.amendment.transactionParties.customer.addressDtls.country" id="customerAddressCountry"></s:hidden>
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
						<s:checkbox name="requestDetails.amendment.transactionParties.customer.addressDtls.futureUseFlag" fieldValue="true">
						 </s:checkbox>
						</label>
						<s:text name="label.request.common.saveforFutureuse"></s:text>
					</div>
				</div>
				<!-- end of block -->
			</div>
		</div>

		<div class="row">
			<div class="span2a">
				<div class="form-row">
					<label><s:text name="label.request.customerReference" /></label>
				</div>
			</div>
			<div class="span7 left">
				<div class="form-row">
					<p class="padding40">
						<s:property
							value="requestDetails.transactionParties.customer.refDetails[0].refValue" />
					</p>
				</div>
			</div>
		</div>
		<s:set name="customerRefSize"
			value="requestDetails.amendment.transactionParties.customer.refDetails.size" />
		<s:if test="#customerRefSize > 1">
			<s:iterator value="requestDetails.amendment.transactionParties.customer.refDetails" status="stat">
				<s:if test="#stat.index != 0">
					<div class="row">
						<div class="span2a">
							<div class="form-row">
								<label><s:text name="label.request.customerReference" />
									<s:property value="#stat.count" /></label>
							</div>
						</div>
						<div class="span7 left">
							<div class="form-row">
								<p class="padding40">
									<s:property value="refValue" />
									<s:hidden name="requestDetails.amendment.transactionParties.customer.refDetails[%{#stat.index}].refValue"/>
								</p>
							</div>
						</div>
					</div>
				</s:if>
			</s:iterator>
		</s:if>

		<div class="row">
			<div class="span12 btn-container">
				
			</div>
		</div>
		</s:if>
