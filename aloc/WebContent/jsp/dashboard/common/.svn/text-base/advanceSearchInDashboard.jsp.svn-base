<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="hide filterMsg" >
<s:form name="advanceSearchForm" id="advanceSearchFormID" action="advanceSearch.action" namespace="/int/dashboard">
<c:set var="dashboardType" value=""></c:set>

<c:choose>
	<c:when test="${param.dashboardType eq 'MyTransaction'}">
		<c:set var="dashboardType" value="MYTRANSACTIONS"></c:set>
	</c:when>
	<c:when test="${param.dashboardType eq 'AllRequest'}">
		<c:set var="dashboardType" value="ALLREQUESTS"></c:set>
	</c:when>
	<c:when test="${param.dashboardType eq 'Draft'}">
		<c:set var="dashboardType" value="DRAFTS"></c:set>
	</c:when>
	<c:when test="${param.dashboardType eq 'Model'}">
		<c:set var="dashboardType" value="MODEL"></c:set>
	</c:when>
	<c:when test="${param.dashboardType eq 'Bundle'}">
		<c:set var="dashboardType" value="BUNDLES"></c:set>
	</c:when>
	<c:when test="${param.dashboardType eq 'BidProcessTreasury'}">
		<c:set var="dashboardType" value="TREASURYBIDPROCESS"></c:set>
	</c:when>
	<c:when test="${param.dashboardType eq 'BidProcessBank'}">
		<c:set var="dashboardType" value="BANKBIDPROCESS"></c:set>
	</c:when>
	<c:when test="${param.dashboardType eq 'BankPendingInce'}">
		<c:set var="dashboardType" value="TREASURYBANKPENDINGINCE"></c:set>
	</c:when>
	<c:when test="${param.dashboardType eq 'BankHistoricTrans'}">
		<c:set var="dashboardType" value="TREASURYBANKHIST"></c:set>
	</c:when>
	<c:when test="${param.dashboardType eq 'BidProcessBroker'}">
		<c:set var="dashboardType" value="TREASURYBROKERBIDPROCESS"></c:set>
	</c:when>
	<c:when test="${param.dashboardType eq 'BrokerPendingInce'}">
		<c:set var="dashboardType" value="TREASURYBROKERPENDINGINCE"></c:set>
	</c:when>
	<c:when test="${param.dashboardType eq 'BrokerHistoricTrans'}">
		<c:set var="dashboardType" value="TREASURYBROKERHIST"></c:set>
	</c:when>
</c:choose>
<input type="hidden" name="dashboardViewType" value="${dashboardType}" id="dashboardViewTypeId"/>
<br/>
<div class="row advanceSearchNotification">
	<div class="span11as">
		<div class="errorbox">
			<div class="noteHead"><p class="noteicon"><s:text name="label.common.alert"/></p></div>
			<div class="noteContent">
				<p><s:text name="label.advanceSearch.message.search"/></p>
			</div>
		</div>
	</div>
</div>

<span style="font-size : 14pt"><s:text name="label.advanceSearch.header.filter"/></span>
<br/>
<h2 id="requestDetails" class="section_flip section_blue section_noToggle">
	<a href="javascript:;"><s:text name="label.advanceSearch.header.requestDetails" /> </a>
</h2><hr class="h2-hr">
<div id="requestDetailsPanel" class="section_panel">

	<table id="tableModel" class="table table-striped table-bordered" style="width: 98%;">
		<thead>
			<tr>
				<td colspan="7"><s:text name="label.advanceSearch.header.instrumentType" /></td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<s:set name="instrTypeSize" value="%{#attr['com.ge.aloc.StaticDataFactory'].instrumentType.size}"></s:set>
				<s:set name="instrBundleTypeSize" value="%{#attr['com.ge.aloc.StaticDataFactory'].instrumentTypeBundle.size}"></s:set>
				<s:set name="instrModelTypeSize" value="%{#attr['com.ge.aloc.StaticDataFactory'].instrumentTypeModel.size}"></s:set>
				<td><s:checkbox name="allInstrumentTypes" value="%{allInstrumentTypes}" fieldValue="true" cssClass="checkall"/> <s:text name="label.advanceSearch.checkbox.all"/> </td>
				<c:choose>
					<c:when test="${dashboardType eq 'BUNDLES'}">
						<s:iterator value="%{#attr['com.ge.aloc.StaticDataFactory'].instrumentTypeBundle}" status="stat">
							<td>
								<s:if test="%{ID == 1}">
									<s:checkbox name="instrumentTypes" value="%{isInstrumentType1}" fieldValue="%{ID}" cssClass="instrTypes"/><s:property value="name"/>
								</s:if>
								<s:elseif test="%{ID == 2}">
									<s:checkbox name="instrumentTypes" value="%{isInstrumentType2}" fieldValue="%{ID}" cssClass="instrTypes"/><s:property value="name"/>
								</s:elseif>
								<s:elseif test="%{ID == 4}">
									<s:checkbox name="instrumentTypes" value="%{isInstrumentType4}" fieldValue="%{ID}" cssClass="instrTypes"/><s:property value="name"/>
									<span class="ttip info"	data-original-title="This is to request the confirmation on a documentary letter of credit issued in favor of a GE entity"></span>
								</s:elseif>
								<s:elseif test="%{ID == 5}">
									<s:checkbox name="instrumentTypes" value="%{isInstrumentType5}" fieldValue="%{ID}" cssClass="instrTypes"/><s:property value="name"/>
								</s:elseif>								
							</td>
						</s:iterator>
					</c:when>
					<c:when test="${dashboardType eq 'MODEL'}">
						<s:iterator value="%{#attr['com.ge.aloc.StaticDataFactory'].instrumentTypeModel}" status="stat">
							<td>
								<s:if test="%{ID == 1}">
									<s:checkbox name="instrumentTypes" value="%{isInstrumentType1}" fieldValue="%{ID}" cssClass="instrTypes"/><s:property value="name"/>
								</s:if>
								<s:elseif test="%{ID == 2}">
									<s:checkbox name="instrumentTypes" value="%{isInstrumentType2}" fieldValue="%{ID}" cssClass="instrTypes"/><s:property value="name"/>
								</s:elseif>
								<s:elseif test="%{ID == 3}">
									<s:checkbox name="instrumentTypes" value="%{isInstrumentType3}" fieldValue="%{ID}" cssClass="instrTypes"/><s:property value="name"/>
								</s:elseif>
							</td>
						</s:iterator>
					</c:when>
					<c:when test="${dashboardType eq 'BANKBIDPROCESS' or dashboardType eq 'TREASURYBANKPENDINGINCE' or dashboardType eq 'TREASURYBANKHIST'}">
						<s:iterator value="%{#attr['com.ge.aloc.StaticDataFactory'].instrumentTypeBundle}" status="stat">
							<td>
								<s:if test="%{ID == 1}">
									<s:checkbox name="instrumentTypes" value="%{isInstrumentType1}" fieldValue="%{ID}" cssClass="instrTypes"/><s:property value="name"/>
								</s:if>
								<s:elseif test="%{ID == 2}">
									<s:checkbox name="instrumentTypes" value="%{isInstrumentType2}" fieldValue="%{ID}" cssClass="instrTypes"/><s:property value="name"/>
								</s:elseif>
								<s:elseif test="%{ID == 4}">
									<s:checkbox name="instrumentTypes" value="%{isInstrumentType4}" fieldValue="%{ID}" cssClass="instrTypes"/><s:property value="name"/>
									<span class="ttip info"	data-original-title="This is to request the confirmation on a documentary letter of credit issued in favor of a GE entity"></span>
								</s:elseif>
								<s:elseif test="%{ID == 5}">
									<s:checkbox name="instrumentTypes" value="%{isInstrumentType5}" fieldValue="%{ID}" cssClass="instrTypes"/><s:property value="name"/>
								</s:elseif>
							</td>
						</s:iterator>
					</c:when>
					<c:when test="${dashboardType eq 'TREASURYBROKERBIDPROCESS' or dashboardType eq 'TREASURYBROKERPENDINGINCE' or dashboardType eq 'TREASURYBROKERHIST'}">
						<s:iterator value="%{#attr['com.ge.aloc.StaticDataFactory'].brokerInstrumentTypes}" status="stat">
							<td>
								<s:if test="%{ID == 3}">
									<s:checkbox name="instrumentTypes" value="%{isInstrumentType3}" fieldValue="%{ID}" cssClass="instrTypes"/><s:property value="name"/>
								</s:if>
								<s:elseif test="%{ID == 6}">
									<s:checkbox name="instrumentTypes" value="%{isInstrumentType6}" fieldValue="%{ID}" cssClass="instrTypes"/><s:property value="name"/>
								</s:elseif>
							</td>
						</s:iterator>
					</c:when>
					<c:otherwise>
						<s:iterator value="%{#attr['com.ge.aloc.StaticDataFactory'].instrumentType}" status="stat">
							<td>
								<s:if test="%{ID == 1}">
									<s:checkbox name="instrumentTypes" value="%{isInstrumentType1}" fieldValue="%{ID}" cssClass="instrTypes"/><s:property value="name"/>
								</s:if>
								<s:elseif test="%{ID == 2}">
									<s:checkbox name="instrumentTypes" value="%{isInstrumentType2}" fieldValue="%{ID}" cssClass="instrTypes"/><s:property value="name"/>
								</s:elseif>
								<s:elseif test="%{ID == 3}">
									<s:checkbox name="instrumentTypes" value="%{isInstrumentType3}" fieldValue="%{ID}" cssClass="instrTypes"/><s:property value="name"/>
								</s:elseif>
								<s:elseif test="%{ID == 4}">
									<s:checkbox name="instrumentTypes" value="%{isInstrumentType4}" fieldValue="%{ID}" cssClass="instrTypes"/><s:property value="name"/>
									<span class="ttip info"	data-original-title="This is to request the confirmation on a documentary letter of credit issued in favor of a GE entity"></span>
								</s:elseif>
								<s:elseif test="%{ID == 5}">
									<s:checkbox name="instrumentTypes" value="%{isInstrumentType5}" fieldValue="%{ID}" cssClass="instrTypes"/><s:property value="name"/>
								</s:elseif>
								<s:elseif test="%{ID == 6}">
									<s:checkbox name="instrumentTypes" value="%{isInstrumentType6}" fieldValue="%{ID}" cssClass="instrTypes"/><s:property value="name"/>
								</s:elseif>
							</td>
						</s:iterator>
					</c:otherwise>
				</c:choose>
			</tr>
		</tbody>
	</table>

	<div class="row">
		
		<div class="span2 hide mtard bidProcess bundles">
			<s:label key="label.advanceSearch.field.ALOCrecordnumber"/>
			<s:textfield name="searchCriteria.searchReqDetails.ALOCRecordId" cssClass="span2"></s:textfield>
		</div>

		<div class="span2 hide mtard model bundles bidProcess">
			<s:label key="label.advanceSearch.field.name"/>
			<s:textfield name="advanceSearchCriteriaText" cssClass="span2"></s:textfield>
		</div>

		<div class="span2 hide mtard bidProcess">
			<s:label key="label.advanceSearch.field.linkID"/>
			<s:textfield name="searchCriteria.searchReqDetails.linkId" cssClass="span2"></s:textfield>
		</div>

		<div class="span2 hide" id="bundleIdDiv">
			<s:label key="label.advanceSearch.field.bundleID"/>
			<s:textfield name="searchCriteria.searchReqDetails.bundleId" cssClass="span2"></s:textfield>
		</div>

		<div class="span2 hide model bidProcess">
        	<s:label key="label.advanceSearch.field.modelName"/>
            <s:textfield name="searchCriteria.searchReqDetails.modelName" cssClass="span2"></s:textfield>
        </div>

	</div>

	<div class="row">
		<div class="span3 hide" id="instrPurposeDiv">
			<s:if test="newInstrumentPurpose == null">
				<s:hidden id="newInstrumentPurpose" name="newInstrumentPurpose" value="0"/>
			</s:if>
			<s:else>
				<s:hidden id="newInstrumentPurpose" name="newInstrumentPurpose" value="%{newInstrumentPurpose}"/>
			</s:else>
			<s:label key="label.advanceSearch.field.instrumentPurpose"/>
			<table id="instrumentST" style="width: 100%;">
				<tr>
					<td height="1" class="noPadding">
						<s:select list="%{#attr['com.ge.aloc.StaticDataFactory'].instrumentPurpose}"
							listKey="ID" listValue="name" name="searchCriteria.searchReqDetails.instrPurposeTypes[0]"
							headerKey="" headerValue="Select..."/>
					</td>
				</tr>
				<s:if test="%{newInstrumentPurpose > 0}">
					<s:iterator begin="1" end="%{newInstrumentPurpose}" status="stat">
						<tr>
							<td height="1" class="noPadding">
								<div class="span2c left">
								 <s:select list="%{#attr['com.ge.aloc.StaticDataFactory'].instrumentPurpose}"
									listKey="ID" listValue="name" name="searchCriteria.searchReqDetails.instrPurposeTypes[%{#stat.count}]"
									headerKey="" headerValue="Select..."/>
					            </div>
							</td>
						</tr>
					</s:iterator>
				</s:if>
			</table>
			<a href="javascript:;" class="add-exception" id="addInstrumentST"> 
				<s:text name="label.advanceSearch.addElement.instrumentPurpose"/> 
			</a>
		</div>
		
		<div class="span4 hide" id="bondSubBondDiv">
			
			<s:if test="newSubBond == null">
				<s:hidden id="newSubBond" name="newSubBond" value="0"/>
			</s:if>
			<s:else>
				<s:hidden id="newSubBond" name="newSubBond" value="%{newSubBond}"/>
			</s:else>
			<table id="bondSubBondTable" style="width: 100%;">
				<tr>
					<td height="1" class="noPadding">
						<div class="span2c left"><s:property value="%{#bondType}"/>
						<s:select headerKey="" list="%{#attr['com.ge.aloc.StaticDataFactory'].bondTypes}" headerValue="Select..."
							key="label.advanceSearch.field.bondType" name="bondSubBondList[0].typeBond" theme="aloc"
							listKey="ID" listValue="name" cssClass="span2 selectBondType">
						</s:select>
						<img alt="Loading..." class="indicator" src="${pageContext.request.contextPath}/img/loading.gif" 
						style="height: 20px; display:none">
						</div>
		
						<div class="span2 left">  	
						<s:select list="#{}" key="label.advanceSearch.field.bondSubType" cssClass="span2 selectSubBondType"
							listKey="ID" listValue="name" theme="aloc">
						</s:select>
						<s:hidden name="bondSubBondList[0].typeSubBond" cssClass="selectedSubBondType"></s:hidden>
						</div>
					</td>
				</tr>
				<s:if test="%{newSubBond > 0}">
					<s:iterator begin="1" end="%{newSubBond}" status="stat">
						<tr>
							<td height="1" class="noPadding">
								<div class="span2c left">
								<s:select headerKey="" list="%{#attr['com.ge.aloc.StaticDataFactory'].bondTypes}" headerValue="Select..."
									key="label.advanceSearch.field.bondType" name="bondSubBondList[%{#stat.count}].typeBond" theme="aloc"
									listKey="ID" listValue="name" cssClass="span2 selectBondType">
								</s:select>
								<img alt="Loading..." class="indicator" src="${pageContext.request.contextPath}/img/loading.gif" 
								style="height: 20px; display:none">
								</div>
				
								<div class="span2 left">  	
								<s:select list="#{}" key="label.advanceSearch.field.bondSubType" cssClass="span2 selectSubBondType"
									listKey="ID" listValue="name" theme="aloc">
								</s:select>
								<s:hidden name="bondSubBondList[%{#stat.count}].typeSubBond" cssClass="selectedSubBondType"></s:hidden>
								</div>
							</td>
						</tr>
					</s:iterator>
				</s:if>
			</table>
			<a href="javascript:;" class="add-exception" id="addBondSub-Bond" > 
				<s:text name="label.advanceSearch.addElement.bondSubType"/> 
			</a>
		</div>

		<div class="span2 hide mtard bidProcess bundles">
			<s:label key="label.dashboard.tableHeader.state"/>
			<s:select list="%{#attr['com.ge.aloc.StaticDataFactory'].RequestStatuses}" cssClass="RequestStatusCls"
				listKey="name" listValue="name" name="searchCriteria.status"
				headerKey="" headerValue="Select..." cssStyle="width:130px!important;"/>
		</div>
        
        <div class="span2 hide" id="triP_PL_Flag">
        	<s:label key="label.advanceSearch.field.looking"/>
        	<s:checkbox name="searchCriteria.triPartyApplicantFlag"   value="%{istripartyApplicant}" fieldValue="true" label="Tri-Party applicant" theme="aloc" cssClass="triParty"/><br />
        	<s:checkbox name="searchCriteria.privateLabelApplicantFlag" value="%{isPrivateApplicant}" fieldValue="true" label="Private label" theme="aloc" cssClass="triParty"/>
        </div>
        <div class="span6 hide" id="conatct_Person">
        	<s:label key="label.advanceSearch.field.contactPerson"/>
        	<s:textfield name="businessContactPersonName" cssClass="span2"></s:textfield>
        </div>
    </div>
    <div class="row">
		<div class="span2">
	      	<s:label key="label.advanceSearch.field.businessSiteType"></s:label>
	       	<s:checkbox name="financial" value="%{isFinancialCheck}" fieldValue="true" id="financial" label="Financial" theme="aloc" cssClass="businessSite" />
	       	<s:checkbox name="industrial" value="%{isIndustrialCheck}" fieldValue="true" id="industrial" label="Industrial" theme="aloc" cssClass="businessSite" />
	    </div>
	</div>
	<s:hidden id="rightSelSitesId" name="rightSelSites" value="%{rightSelSites}"/>
    <div class="row" id="siteSelection" style="margin-left: 10px;">
    </div>
</div>
<!-- trigger 1 ends here -->

<h2 id="nameDetails" class="section_flip section_blue section_noToggle">
	<a href="javascript:;"><s:text name="label.advanceSearch.header.appDetails" /></a>
</h2><hr class="h2-hr">
<div id="nameDetailsPanel" class="section_panel">

	<div class="row">
		<div class="span2 hide mtard model bidProcess bundles">
			<s:label key="label.advanceSearch.field.applicantPrincipalName"/>
			<s:textfield name="searchCriteria.applicantOrPrincipalName" cssClass="span2"></s:textfield>
		</div>

		<div class="span2 hide mtard model bidProcess bundles">
			<s:label key="label.advanceSearch.field.beneficiaryObligeeName"/>
			<s:textfield name="searchCriteria.beneficiaryOrObligeeName" cssClass="span2"></s:textfield>
		</div>

		<div class="span2 hide" id="triP_Name">
        	<s:label key="label.advanceSearch.field.triPartyApplicant"/>
            <s:textfield name="searchCriteria.triPartyApplicantName" cssClass="span2"></s:textfield>
        </div>  
       
	</div>

	<div class="row">
		<div class="span2 hide model">
        	<s:label key="label.advanceSearch.field.applicantCountry"/>
            <sj:autocompleter id="applicantCountryCd" list="%{#attr['com.ge.aloc.MasterDataFactory'].countries}" 
				name="searchCriteria.applicantCountryCd" onChangeTopics="getAutocompleterName"
				cssClass="span2" listKey="countryCode" listValue="countryName"/>
        </div>
                    
		<div class="span2 hide model">
        	<s:label key="label.advanceSearch.field.beneficiaryCountry"/>
            <sj:autocompleter id="beneficiaryCountryCd" list="%{#attr['com.ge.aloc.MasterDataFactory'].countries}" 
				name="searchCriteria.beneficiaryCountryCd" onChangeTopics="getAutocompleterName"
				cssClass="span2" listKey="countryCode" listValue="countryName"/>
        </div> 
        
        <div class="span2">
            <s:if test="newPole == null">
				<s:hidden id="newPole" name="newPole" value="0"/>
			</s:if>
			<s:else>
				<s:hidden id="newPole" name="newPole" value="%{newPole}"/>
			</s:else>
        	<s:label key="label.advanceSearch.field.pole"/>
            <table id="pole" style="width: 100%;">
            	<tr>
            		<td height="1" class="noPadding">
            			<s:select list="%{#attr['com.ge.aloc.StaticDataFactory'].polesDetails}"
							listKey="ID" listValue="name" name="searchCriteria.poles[0]" cssClass="poleSelectCls"
							headerKey="" headerValue="Select..."/>
            		</td>
            	</tr>
            	<s:if test="%{newPole > 0}">
					<s:iterator begin="1" end="%{newPole}" status="stat">
						<tr>
						    <td height="1" class="noPadding">
		            			<s:select list="%{#attr['com.ge.aloc.StaticDataFactory'].polesDetails}"
									listKey="ID" listValue="name" name="searchCriteria.poles[%{#stat.count}]" cssClass="poleSelectCls"
									headerKey="" headerValue="Select..."/>
		            		</td>
						</tr>
					</s:iterator>
				</s:if>
            </table>
            <a href="javascript:;" class="add-exception" id="addPole"><s:text name="label.advanceSearch.addElement.pole"/></a>
        </div>
	</div>
</div>
<!-- trigger 2 ends here -->

<h2 id="bankDetails" class="section_flip section_blue section_noToggle hide">
	<a href="javascript:;"> <s:text name="label.advanceSearch.header.bankDetails"/> </a>
</h2><hr class="h2-hr">
<div id="bankDetailsPanel" class="section_panel hide">

	<div class="row">
	<div id="issuingBankPanel">
		<div class="span2c">
			<s:label key="label.advanceSearch.field.issuingBankBranchName"/>
            <sj:autocompleter id="issuingBanksCd" list="%{issuingBanks.bankNames}" 
				name="searchCriteria.searchBankDetails.issuingBankBranchName" onChangeTopics="getAutocompleterName"
				cssClass="span2" />
		</div>

		<div class="span2">
			<s:label key="label.advanceSearch.field.relationshipBankName"/>
            <sj:autocompleter id="relationShipBanksCd" list="%{issuingBanks.bankNames}" 
				name="searchCriteria.searchBankDetails.relationshipBankName" onChangeTopics="getAutocompleterName"
				cssClass="span2" />
		</div>
	</div>

		<div class="span2">
			<s:label key="label.advanceSearch.field.bankReferenceNumber"/>
			<s:textfield name="searchCriteria.searchBankDetails.bankRefNo" cssClass="span2"></s:textfield>
		</div>

		<div class="span2">
			<s:label key="label.advanceSearch.field.bidState"/>
			<s:select list="%{#attr['com.ge.aloc.StaticDataFactory'].bidStatusesList}"
				listKey="name" listValue="name" name="searchCriteria.searchBankDetails.bidState"
				headerKey="" headerValue="Select..." cssStyle="width:130px!important;"/>
        </div>

	</div>

</div>

<h2 id="brokerDetails" class="section_flip section_blue section_noToggle hide">
	<a href="javascript:;"> <s:text name="label.advanceSearch.header.suretyDetails"/> </a>
</h2><hr class="h2-hr">
<div id="brokerDetailsPanel" class="section_panel hide">

	<div class="row">
		<div id="suretyFeeNamesDiv">
			<div class="span3">
					<s:label key="label.request.suretyFeeName"/>
		            <sj:autocompleter id="issuingSuretyCd" list="%{suretyMasterCollection.suretyMasters}" listKey="suretyName"
		                listValue="suretyName"	name="searchCriteria.searchBankDetails.suretyName" onChangeTopics="getAutocompleterName"
						cssClass="span2" />
			</div>
		</div>
		<div class="span2c">
			<s:label key="label.advanceSearch.field.suretyReferenceNumber"/>
			<s:textfield name="searchCriteria.searchBankDetails.suretyRefNo" cssClass="span2"></s:textfield>
		</div>
		<div class="span2">
				<s:label key="label.advanceSearch.field.bidState"/>
				<s:select list="%{#attr['com.ge.aloc.StaticDataFactory'].bidStatusesList}"
					listKey="name" listValue="name" name="searchCriteria.searchBankDetails.suretyBidState"
					headerKey="" headerValue="Select..." cssStyle="width:130px!important;"/>
	    </div>		
	</div>

</div>

<!-- trigger 3 ends here -->
<c:if test="${dashboardType ne 'MODEL'}">
<h2 id="instrumentDetails" class="section_flip section_blue section_noToggle">
	<a href="javascript:;"> <s:text name="label.advanceSearch.header.instrumentDetails"/> </a>
</h2><hr class="h2-hr">
<div id="instrumentDetailsPanel" class="section_panel">

	<div class="row">

		<div class="span4 hide mtard bidProcess bundles">
			<s:label key="label.advanceSearch.field.instrumentAmount"/>
			<s:textfield name="searchCriteria.searchInstrDetails.instrFromAmt" cssClass="span2 bigDecimal"></s:textfield> 
			<s:text name="label.advanceSearch.to"/> 
			<s:textfield name="searchCriteria.searchInstrDetails.instrToAmt" cssClass="span2 bigDecimal"></s:textfield>
		</div>
		
		<div class="span3 left hide mtard bidProcess bundles" id="instrumentC">
		  <s:if test="newInstrumentCurrency == null">
				<s:hidden id="newInstrumentCurrency" name="newInstrumentCurrency" value="0"/>
			</s:if>
			<s:else>
				<s:hidden id="newInstrumentCurrency" name="newInstrumentCurrency" value="%{newInstrumentCurrency}"/>
			</s:else>
			<s:label key="label.advanceSearch.field.instrumentCurrency"/>
			<div class="form-row">
				<div>
					<sj:autocompleter list="%{#attr['com.ge.aloc.MasterDataFactory'].currencies}"
						name="searchCriteria.searchInstrDetails.instrCurrencyCds[0]" id="instrCurrencyCd"
						cssClass="span2" listKey="currencyCode" listValue="currencyName" onChangeTopics="getAutocompleterName"/>
							
					<br>
					<em> <s:text name="label.advanceSearch.em.currency"/> </em>
				</div>
				<s:if test="%{newInstrumentCurrency > 0}">
					<s:iterator begin="1" end="%{newInstrumentCurrency}" status="stat">
					    <div>
							<sj:autocompleter list="%{#attr['com.ge.aloc.MasterDataFactory'].currencies}"
								name="searchCriteria.searchInstrDetails.instrCurrencyCds[%{#stat.count}]" 
								cssClass="span2" listKey="currencyCode" listValue="currencyName" onChangeTopics="getAutocompleterName"/>
									
							<br>
							<em> <s:text name="label.advanceSearch.em.currency"/> </em>
						</div>
					</s:iterator>
				</s:if>
			</div>
			<a href="javascript:;" class="add-exception" id="addInstrumentC"> <s:text name="label.advanceSearch.addElement.country"/> </a>
		</div>
		
		<div class="span2 hide" id="applicantReferenceId">
			<s:label key="label.advanceSearch.field.applicantReference"/>
			<s:textfield name="searchCriteria.searchInstrDetails.applicantReferenceValue" cssClass="span2"></s:textfield> 
		</div>
		
		<div class="span2 hide" id="customerReferenceId">
			<s:label key="label.advanceSearch.field.customerReference"/>
			<s:textfield name="searchCriteria.searchInstrDetails.customerReferenceValue"  cssClass="span2"></s:textfield>
		</div>
		
		<div class="clear"></div>
		<p>&nbsp;</p>

		<div class="span4 hide mtard bidProcess" id="countryI">
		    <s:if test="newIssuanceCountry == null">
				<s:hidden id="newIssuanceCountry" name="newIssuanceCountry" value="0"/>
			</s:if>
			<s:else>
				<s:hidden id="newIssuanceCountry" name="newIssuanceCountry" value="%{newIssuanceCountry}"/>
			</s:else>
			<s:label key="label.advanceSearch.field.countryOfIssuance"/>
			<div class="form-row">
			<div>
				    <sj:autocompleter list="%{#attr['com.ge.aloc.MasterDataFactory'].countries}"
					name="searchCriteria.searchInstrDetails.issuanceCountries[0]" id="instrCountryCd"
					cssClass="span2" listKey="countryCode" listValue="countryName" onChangeTopics="getAutocompleterName"/>
					<br>
					<em> <s:text name="label.advanceSearch.em.country"/> </em>
			</div>
					<s:if test="%{newIssuanceCountry > 0}">
					<s:iterator begin="1" end="%{newIssuanceCountry}" status="stat">
					<div>
					         <sj:autocompleter list="%{#attr['com.ge.aloc.MasterDataFactory'].countries}"
								name="searchCriteria.searchInstrDetails.issuanceCountries[%{#stat.count}]"
								cssClass="span2" listKey="countryCode" listValue="countryName" onChangeTopics="getAutocompleterName"/>	
							<br>
							<em> <s:text name="label.advanceSearch.em.country"/> </em>
					</div>
					</s:iterator>
				</s:if>
			</div>
			<a href="javascript:;" class="add-exception" id="addCountryI"> <s:text name="label.advanceSearch.field.countryOfIssuance"/> </a>
		</div>

	</div>

</div>
</c:if>
<!-- trigger 4 ends here -->
<h2 id="paymentDetails" class="section_flip section_blue section_noToggle hide">
	<a href="javascript:;"> <s:text name="label.advanceSearch.header.paymentDetails"></s:text> </a>
</h2><hr class="h2-hr">
<div id="paymentDetailsPanel" class="section_panel hide">
	<div class="row">
		<div class="span4">
       		<s:label key="label.advanceSearch.field.paymentDate"></s:label>
            <s:textfield name="searchCriteria.searchPaymentDetails.paymentFromDate" cssClass="date"></s:textfield> 
			<s:text name="label.advanceSearch.to"/> 
			<s:textfield name="searchCriteria.searchPaymentDetails.paymentToDate" cssClass="date"></s:textfield>
        </div>                    
		<div class="clear"></div>
	</div>
</div>

<c:if test="${dashboardType ne 'MODEL'}">
<h2 id="dates" class="section_flip section_blue section_noToggle">
	<a href="javascript:;"> <s:text name="label.advanceSearch.header.dates"/> </a>
</h2><hr class="h2-hr">
<div id="datesPanel" class="section_panel">

	<div class="row">

		<div class="span4 left hide bidProcess">
			<s:label key="label.advanceSearch.field.issueDate"/>
			<s:textfield name="searchCriteria.searchDates.issueFromDt" cssClass="date"/> 
			<s:text name="label.advanceSearch.to"/> 
			<s:textfield name="searchCriteria.searchDates.issueToDt" cssClass="date"/> 
		</div>
		
		<div class="span4 left hide mtard bidProcess bundles">
			<s:label key="label.advanceSearch.field.expirationDate"/>
			<s:textfield name="searchCriteria.searchDates.expiryFromDt" cssClass="date"/> 
			<s:text name="label.advanceSearch.to"/> 
			<s:textfield name="searchCriteria.searchDates.expiryToDt" cssClass="date"/> 
		</div>
		
		<div class="clear"></div>
        <p>&nbsp;</p>
        
        <div class="span4 left hide mtard bidProcess bundles">
			<s:label key="label.advanceSearch.field.creationDate"/>
			<s:textfield name="searchCriteria.searchDates.creationFromDt" cssClass="date"/> 
			<s:text name="label.advanceSearch.to"/> 
			<s:textfield name="searchCriteria.searchDates.creationToDt" cssClass="date"/> 
		</div>
		
		<div class="span4 left hide" id="econominExpDateDiv">
			<s:label key="label.advanceSearch.field.econominExpirationDate"/>
			<s:textfield name="searchCriteria.searchDates.econoExpiryFromDt" cssClass="date"/> 
			<s:text name="label.advanceSearch.to"/> 
			<s:textfield name="searchCriteria.searchDates.econoExpiryToDt" cssClass="date"/> 
		</div>

	</div>

</div>
</c:if>
<!-- trigger 6 ends here -->

<p>&nbsp;</p>
<c:if test="${param.forPage eq 'Dashboard'}">
	<s:url action="advanceSearch.action" var="advanceSearchDashboardURL" namespace="/int/dashboard" encode="true" escapeAmp="false"/>
</c:if>
<c:if test="${param.forPage eq 'FeeHistory'}">
	<s:url action="advanceFHSearch.action" var="advanceSearchDashboardURL" namespace="/int/admin" encode="true" escapeAmp="false"/>
</c:if>

<a href="<s:property value="#advanceSearchDashboardURL" />" class="btn-primary advanceSearchBtn">
<s:text name="label.dashboard.search"/>
</a>
<a href="javascript:;" class="btn-tertiary collapse" > <s:text name="label.advanceSearch.link.collapseFilters"/> </a>
<a href="javascript:;" class="btn-tertiary clearFilters" > <s:text name="label.advanceSearch.link.clearFilters"/> </a>
<img alt="Loading..." id="advSearchIndicator" class="indicator" src="${pageContext.request.contextPath}/img/loading.gif" 
	style="height: 20px; display:none">
</s:form>
</div>
