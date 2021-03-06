<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<s:url id="editSectionURL" action="editSection"
	namespace="/int/requestor/review" />
<s:set name="isEditMode" value="editMode" />
<s:if
	test="%{#isEditMode==true || ((requestDetails.WFDetails.WFStage == 'REQEST' || requestDetails.WFDetails.WFStage == 'REQUEST'  && #attr.isTaxonomy != true) && requestDetails.bondInfo.requiresEdits == true)}">
	<c:if test="${param.includeScripts != false}">
		<script type="text/javascript">
			$(document).ready(function() {
				suretyUSDShow();
				decCounter("otherInfo", 300);
			});
		</script>
	</c:if>
	<div id="suretyBondDetailsForm">
		<s:if
			test="%{(requestDetails.WFDetails.WFStage == 'REQEST' || requestDetails.WFDetails.WFStage == 'REQUEST') && requestDetails.bondInfo.requiresEdits}">
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
								<s:property value="requestDetails.bondInfo.sendBackNotes" />
							</p>
						</div>
					</div>
				</div>
			</div>
		</s:if>

		<a name="seventh"></a>
		<div class="row">
			<div class="span12">
				<div class="form-row">
					<sj:autocompleter id="issuanceCountryCd"
						list="%{#attr['com.ge.aloc.MasterDataFactory'].countries}"
						name="requestDetails.bondInfo.issuanceCountryCd"
						key="label.request.CountryOfIssuance" cssClass="span3 mandatory"
						listKey="countryCode" listValue="countryName" parentTheme="aloc"
						onChangeTopics="getAutocompleterName" />
					<s:hidden name="requestDetails.bondInfo.issuanceCountryName"
						id="issuanceCountryName" cssClass="autoCompleterName"></s:hidden>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="span12">
				<div class="form-row">
					<s:textfield key="label.request.courtOfJurisdiction"
						name="requestDetails.bondInfo.courtOfJurisdiction"
						id="courtOfJurisdiction" theme="aloc" cssClass="mandatory"
						maxlength="100" />
				</div>
			</div>
		</div>

		<div class="row">
			<div class="span12">
				<div class="form-row">
					<s:textfield key="label.request.courtCounty"
						name="requestDetails.bondInfo.county" id="county" theme="aloc"
						cssClass="mandatory" maxlength="100" />
				</div>
			</div>
		</div>

		<div class="row">
			<div class="span12">
				<div class="form-row">
					 <label class="optional"><s:text name="label.request.state"/> <s:text name="label.request.optional"/></label>
							<s:combobox listKey="stateName" listValue="stateName" headerKey="-1" headerValue="Select..." list="%{#attr['com.ge.aloc.StaticDataFactory'].stateList}"
								name="requestDetails.bondInfo.state" id="courtBondState" />
				</div>
			</div>
		</div>
		<div class="row">
			<div class="span12">
				<div class="form-row">
					<s:textfield key="label.request.caseNumber"
						name="requestDetails.bondInfo.caseNumber" id="caseNumber"
						theme="aloc" required="false" maxlength="9" cssClass="bigInt"/>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="span12">
				<div class="form-row">
					<s:textfield key="label.request.dateFiled"
						name="requestDetails.bondInfo.dateFiled" id="dateFiled"
						cssClass="span2 date" theme="aloc" required="false" />
				</div>
			</div>
		</div>
		<div class="row">
			<div class="span12">
				<div class="form-row">
					<s:textfield key="label.request.judgementAmount"
						name="requestDetails.bondInfo.judgementAmount"
						id="judgementAmount" theme="aloc" maxlength="21" required="false" cssClass="bigDecimal"/>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="span12">
				<div class="form-row">
					<sj:autocompleter
						list="%{#attr['com.ge.aloc.MasterDataFactory'].currencies}"
						name="requestDetails.bondInfo.bondCurrencyCd"
						cssClass="span3 mandatory" key="label.request.bondCurrency"
						listKey="currencyCode" listValue="currencyName" parentTheme="aloc"
						id="currencies"
						onChangeTopics="getCurrencyAutocompleterName,getUSDConversion" />
					<p class="guidance">
						<i><s:text name="label.request.searchForCurrency" /></i>
					</p>
					<s:hidden name="requestDetails.bondInfo.bondCurrency"
						id="bondCurrencyName" cssClass="autoCompleterName"></s:hidden>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="span12">
				<div class="form-row">
					<s:textfield key="label.request.bondAmount"
						name="requestDetails.bondInfo.courtBondAmt" id="bondAmount"
						cssClass="currencyAmt mandatory bigDecimal" theme="aloc" maxlength="21" />
				</div>
			</div>
		</div>
		<div class="row" id="usdEquivalentDiv" style="display: none">
			<div class="span5 left">
				<div class="targetUsd form-row">
					<p style="padding: 5px;" id="intusdEquivalent" class="defaultFontSize">
						<b><s:text name="label.request.usdBondAmount" /> : </b> <span
							style="padding-left: 10px"> <s:property
								value="requestDetails.bondInfo.USDCourtBondAmt" /></span> <img
							alt="Loading..." id="bidUSDProcess"
							src="${pageContext.request.contextPath}/img/loading.gif"
							style="display: none; height: 20px; width: 20px;">
					</p>
					<s:hidden id="bondUsdEquivalentAmount"
						name="requestDetails.bondInfo.USDCourtBondAmt"
						value="%{requestDetails.bondInfo.USDCourtBondAmt}"></s:hidden>
				</div>
			</div>
			<span style="color: red"><s:fielderror fieldName="requestDetails.bondInfo.USDCourtBondAmt"/></span>
			<!-- end of block -->
		</div>
		<div class="row usdEquivalentErrorDiv" style="display: none;">
            		<div class="span12">
                		<div class="errorbox">
                			<div class="errorHead"><p class="erroricon"><s:text name="label.common.error"/></p></div>
								<div class="errorContent">
	                				<p id="usdEquivalentError"></p>
               					 </div>
               				 </div>
           			 </div>
       			 </div>
		<div class="row">
			<div class="span12">
				<div class="form-row">
					<s:textfield key="label.request.effectiveDate"
						name="requestDetails.bondInfo.effectiveDate" id="effectiveDt"
						cssClass="span2 date mandatory" theme="aloc" />
				</div>
			</div>
		</div>
		<div class="row">
			<div class="span12">
				<div class="form-row">
					<s:textfield key="label.request.needByDate"
						name="requestDetails.bondInfo.needByDt" id="needByDt"
						cssClass="span2 date mandatory" theme="aloc"
						tooltip="%{getText('label.request.tooltip.needByDate')}" />
				</div>
			</div>
		</div>
		<div class="row">
			<div class="span12">
				<div class="form-row">
					<s:textfield key="label.request.expirationDate"
						name="requestDetails.bondInfo.expirationDt" id="expirationDt"
						cssClass="span2 date mandatory" theme="aloc" />
				</div>
			</div>
		</div>
		<div class="row">
			<div class="span12">
				<div class="form-row">
					<label class="optional"><s:text
							name="label.request.otherInformationOpt" /></label>
					<div class="txtCnt3"></div>
					<s:textarea name="requestDetails.bondInfo.otherInfo" cols="50"
						rows="1" cssClass="xlarge autosize3 messageinput"
						onkeypress="return imposeMaxLength(this, 299);" id="otherInfo" />
					<div class="clear"></div>
					<div class="counter">300</div>
					<div class="counterTxt">
						<p class="guidance">
							<s:text name="label.request.charactersLimit" />
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- end of required count block -->
	<script type="text/javascript">
			refreshSectionCount("bondInformationPanel");
		</script>
</s:if>
<s:elseif test="%{#isEditMode==false}">
	<div class="row">
		<div class="span2a">
			<div class="form-row">
				<label><s:text name="label.request.CountryOfIssuance" />:</label>
			</div>
		</div>
		<div class="span5 left">
			<div class="form-row">
				<p class="padding40">
					<c:out value="${requestDetails.bondInfo.issuanceCountryName}" />
				</p>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="span2a">
			<div class="form-row">
				<label><s:text name="label.request.courtOfJurisdiction" />:</label>
			</div>
		</div>
		<div class="span5 left">
			<div class="form-row">
				<p class="padding40">
					<c:out value="${requestDetails.bondInfo.courtOfJurisdiction}" />
				</p>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="span2a">
			<div class="form-row">
				<label><s:text name="label.request.courtCounty" />:</label>
			</div>
		</div>
		<div class="span5 left">
			<div class="form-row">
				<p class="padding40">
					<c:out value="${requestDetails.bondInfo.county}" />
				</p>
			</div>
		</div>
		<!-- end of block -->
	</div>
	<div class="row">
		<div class="span2a">
			<div class="form-row">
				<label><s:text name="label.request.state" />:</label>
			</div>
		</div>
		<div class="span5 left">
			<div class="form-row">
				<p class="padding40">
					<c:out value="${requestDetails.bondInfo.state}" />
				</p>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="span2a">
			<div class="form-row">
				<label><s:text name="label.request.caseNumber" />:</label>
			</div>
		</div>
		<div class="span5 left">
			<div class="form-row">
				<p class="padding40">
					<c:out value="${requestDetails.bondInfo.caseNumber}" />
				</p>
			</div>
		</div>
		<!-- end of block -->
	</div>
	<div class="row">
		<div class="span2a">
			<div class="form-row">
				<label><s:text name="label.request.dateFiled" />:</label>
			</div>
		</div>
		<div class="span5 left">
			<div class="form-row">
				<p class="padding40">
					<s:property value="requestDetails.bondInfo.dateFiled" />
				</p>
			</div>
		</div>
	</div>
	<div class="row ">
		<div class="span2a">
			<div class="form-row">
				<label><s:text name="label.request.judgementAmount" />:</label>
			</div>
		</div>
		<div class="span5 left">
			<div class="form-row">
				<p class="padding40">
					<s:property value="requestDetails.bondInfo.judgementAmount" />
				</p>
			</div>
		</div>
		<!-- end of block -->
	</div>

	<div class="row">
		<div class="span2a">
			<div class="form-row">
				<label><s:text name="label.request.bondCurrency" />:</label>
			</div>
		</div>
		<div class="span5 left">
			<div class="form-row">
				<p class="padding40">
					<c:out value="${requestDetails.bondInfo.bondCurrency}" />
				</p>
			</div>
		</div>
	</div>
	<div class="row ">
		<div class="span2a">
			<div class="form-row">
				<label><s:text name="label.request.bondAmount" />:</label>
			</div>
		</div>
		<div class="span5 left">
			<div class="form-row">
				<p class="padding40">
					<s:property value="requestDetails.bondInfo.courtBondAmt" />
				</p>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="span2a">
			<div class="form-row">
				<label><s:text name="label.request.usdBondAmount" />:</label>
			</div>
		</div>
		<div class="span5 left">
			<div class="form-row">
				<p class="padding40">
					<s:property value="requestDetails.bondInfo.USDCourtBondAmt" />
				</p>
				<s:hidden id="bondUsdEquivalentAmount"
					name="requestDetails.bondInfo.USDCourtBondAmt"></s:hidden>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="span2a">
			<div class="form-row">
				<label><s:text name="label.request.effectiveDate" />:</label>
			</div>
		</div>
		<div class="span5 left">
			<div class="form-row">
				<p class="padding40">
					<s:property value="requestDetails.bondInfo.effectiveDate" />
				</p>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="span2a">
			<div class="form-row">
				<label><s:text name="label.request.needByDate" />:</label>
			</div>
		</div>
		<div class="span5 left">
			<div class="form-row">
				<p class="padding40">
					<s:property value="requestDetails.bondInfo.needByDt" />
				</p>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="span2a">
			<div class="form-row">
				<label><s:text name="label.request.expirationDate" />:</label>
			</div>
		</div>
		<div class="span5 left">
			<div class="form-row">
				<p class="padding40">
					<s:property value="requestDetails.bondInfo.expirationDt" />
				</p>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="span2a">
			<div class="form-row">
				<label><s:text name="label.request.otherInformation" />:</label>
			</div>
		</div>
		<div class="span7 left">
			<div class="form-row">
				<p class="padding40">
					<c:out value="${requestDetails.bondInfo.otherInfo}" />
				</p>
			</div>
		</div>
	</div>
</s:elseif>