<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<s:set name="isEditMode" value="editMode" />
<s:if test="%{#isEditMode==true || ((requestDetails.WFDetails.WFStage == 'REQEST' || requestDetails.WFDetails.WFStage == 'REQUEST'  && #attr.isTaxonomy != true) && requestDetails.instrumentDetails.requiresEdits == true)}">
<c:if test="${param.includeScripts != false}">
<script	type="text/javascript">
$(document).ready(function() {
	//getAutocompleterName();
	//getInstrumentUSDConversion();
	//loadBeforeTracking();
	//loadRequireEditTracking();
	instrumentPurposeClick();
	//instrumentDet();
	showHideEconomicExpiry();
	approximateUSDShow();
	amountTowords();
	onclickAutoExtendFlag();
	hideotherTimeFrameDiv();
	loadAutoIncDecCheck();
	sendbackOnloadShow();
	decCounter("specialInst", 400);
});

</script>
</c:if>
	<s:if test="%{(requestDetails.WFDetails.WFStage == 'REQEST' || requestDetails.WFDetails.WFStage == 'REQUEST') && requestDetails.instrumentDetails.requiresEdits}">
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
							<s:property value="requestDetails.instrumentDetails.sendBackNotes" />
						</p>
					</div>
				</div>
			</div>
		</div>
	</s:if>
	<div class="row">
		<div class="span12">
			<div class="form-row">
				<sj:autocompleter 
					key="label.request.CountryOfIssuance"
					tooltip="%{getText('label.request.tooltip.CountryOfIssuance')}"
					id="issuanceCountry" parentTheme="aloc"
					list="%{#attr['com.ge.aloc.MasterDataFactory'].countries}"
					name="requestDetails.instrumentDetails.issuanceCountryId"
					cssClass="span3 mandatory" listKey="countryCode" listValue="countryName"
					onChangeTopics="showSBLCRadioBtns,getDefaultPole" maxlength="100" />
					
					<s:hidden name="requestDetails.instrumentDetails.issuanceCountry" 
							id="issuanceCountryName" cssClass="autoCompleterName"></s:hidden>
			</div>
		</div>
	</div>
	
	<div class="row">
		<div class="span12">
			<div class="form-row">
				<sj:autocompleter key="label.request.CurrencyOfInstrument"
					id="currencies"
					list="%{#attr['com.ge.aloc.MasterDataFactory'].currencies}"
					name="requestDetails.instrumentDetails.instrumentCurrencyId"
					cssClass="span3 mandatory" listKey="currencyCode" listValue="currencyName"
					parentTheme="aloc" onChangeTopics="getCurrencyAutocompleterName,getInstrumentUSDConversion" maxlength="100"/>
				<p class="guidance">
					Search for currency
				</p>
				<s:hidden name="requestDetails.instrumentDetails.instrumentCurrency" 
							id="instrumentCurrency" cssClass="autoCompleterName"></s:hidden>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="span12">
			<div class="form-row">
				<s:textfield name="requestDetails.instrumentDetails.instrumentAmt" key="label.request.AmountOfInstrument"
					id="instrumentAmt" theme="aloc" cssClass="instrumentAmt mandatory bigDecimal" maxlength="21"/>
			</div>
		</div>

	</div>
    <div class="row">
		<div class="span5">
			<div class="form-row">
				<p style="" id="amountinWords"></p>
			</div>
		</div>
	</div>
	<div class="row" id="approximateUSDDiv" style="display: none">
		<div class="span5">
			<div class="form-row">
				<p id="instrumentUsdEquivalent" class="defaultFontSize">
					<b>Approximate USD instrument amount: </b><span
						style="padding-left: 10px"><s:property
							value="requestDetails.instrumentDetails.USDEquivalent" /></span>
							<img alt="Loading..." id="instUsdProcess" 
					src="${pageContext.request.contextPath}/img/loading.gif" style="display: none; height: 20px; width: 20px;">
				</p>
				<s:hidden id="instrumentUSDAmt"
					name="requestDetails.instrumentDetails.USDEquivalent"
					value="%{requestDetails.instrumentDetails.USDEquivalent}"></s:hidden>
					
			</div>
		</div>
		<span style="color: red"><s:fielderror fieldName="requestDetails.instrumentDetails.USDEquivalent"/></span>
		<!-- end of block -->
	</div>
	<div class="row ">
		<div class="span12">
			<div class="form-row">
				<p id="PercentageofvalueBid" style="padding: 7px 0;" class="defaultFontSize">
					<b><s:text name="label.request.PercentageofvalueBid"></s:text></b>
					<span class="ttip info" data-original-title="<s:text name="label.request.tooltip.PercentageofvalueBid"/>"></span>
					<span style="padding-left: 10px" id="percent"><s:property
							value="requestDetails.instrumentDetails.percentValueOfBid" /></span>
				</p>
				<s:hidden id="percentValueOfBid"
					name="requestDetails.instrumentDetails.percentValueOfBid"
					value="%{requestDetails.instrumentDetails.percentValueOfBid}"></s:hidden>
			</div>
		</div>
	</div>
	<div class="row instUsdEquivalentErrorDiv" style="display: none;">
		<div class="span12">
			<div class="errorbox">
				<div class="errorHead">
					<p class="erroricon">
						<s:text name="label.common.error" />
					</p>
				</div>
				<div class="errorContent">
					<p id="usdEquivalentError"></p>
				</div>
			</div>
		</div>
	</div>
	<div class="row hide" id="maxPossibleExpoDiv">
		<div class="span12">
			<div class="form-row">
				<s:textfield name="requestDetails.instrumentDetails.maxPossibleExpo"
					id="maxPossibleExpo" key="label.request.MaximumpossibleExposure"
					theme="aloc" tooltip="%{getText('label.request.tooltip.maxPossibleExpo')}" maxlength="20"/>
			</div>
		</div>
		<!-- end of block -->
	</div> 

	<div class="row">
		<div class="span12">
			<div class="form-row">
				<s:textfield name="requestDetails.instrumentDetails.issueDt"
					cssClass="dateFutureOnly mandatory" id="issueDt" key="label.request.Issuedate"
					theme="aloc" />
			   <p class="guidance"><s:text name="label.request.dateFormat" /></p>
			</div>
		</div>
		<!-- end of block -->
	</div>
	<div class="row">
		<div class="span12">
			<div class="form-row">
				<s:textfield name="requestDetails.instrumentDetails.expiryDt"
					cssClass="dateExpiry mandatory" id="expiryDt" key="label.request.ExpirationDate"
					theme="aloc" tooltip="%{getText('label.request.tooltip.ExpirationDate')}" />
				 <p class="guidance"><s:text name="label.request.dateFormat" /></p>
				<p class="guidance"> Economic expiration date required when the expiry year equals 2050</p>
			</div>
		</div>
		<!-- end of block -->
	</div>
	<div class="hide row" id="econoExpiryDtDiv">
		<div class="span12">
			<div class="form-row">
				<s:textfield name="requestDetails.instrumentDetails.econoExpiryDt"
					cssClass="date" id="econoExpiryDt"
					key="label.request.EconomicexpirationDate" theme="aloc"
					tooltip="%{getText('label.request.tooltip.EconomicexpirationDate')}" />
                 <p class="guidance"><s:text name="label.request.dateFormat" /></p>

			</div>
		</div>
	</div>
	<div class="row">
			<div class="span12">
				<div class="form-row">
					<s:textarea cssClass="autosize messageinput" cols="50" rows="1" required="false"
					 name="requestDetails.deliveryInstructions.specialInstructions" onkeypress="return imposeMaxLength(this, 399);"
					 key="label.request.specialInstructions" theme="aloc" id="specialInst"> </s:textarea>
					<div class="clear"></div>
                    <div class="counter"><s:text  name="label.common.siteAdmin.fourHundred"/></div> <!-- fix positions -->
                    <div class="counterTxt"><p class="guidance"><s:text  name="label.common.siteAdmin.limit400Characters"/></p></div>
				</div>
				<!-- end of block -->
			</div>
		</div>
	<div class="row">
		<div class="span12">
			<div class="form-row">
				<div class="radio-container derivativesConditional mandatory">
					<s:radio theme="aloc" cssClass="radio" 
						key="label.request.autoExtendclause"
						tooltip="%{getText('label.request.tooltip.autoExtendClause')}"
						id="autoExtendFlag"
						name="requestDetails.instrumentDetails.autoExtendClause.AutoExtendFlag"
						list="#{'true':'Yes','false':'No'}"
						value="%{requestDetails.instrumentDetails.autoExtendClause.AutoExtendFlag}" />
				</div>
				
			</div>
		</div>
	</div>
	
	<div class="clear"></div>
	<div class="row hide noticePeriodDiv">
		<div class="span12">
			<div class="form-row">
				<s:radio theme="aloc" id="noticePeriodFlag"
					key="label.request.noticeperiod" cssClass="radio noticePeriodCls"
					name="requestDetails.instrumentDetails.autoExtendClause.nonRenewalPeriod"
					list="#{'30':'30 days','60':'60 days','90':'90 days','other':'Other'}"
					value="%{requestDetails.instrumentDetails.autoExtendClause.nonRenewalPeriod}" />
			</div>
		</div>
	</div>
	<div class="clear"></div>
	<div class="row hide" id="otherTimeFrameDiv">
		<div class="span12">
			<div class="form-row">
				 <s:textfield name="requestDetails.instrumentDetails.autoExtendClause.otherTimeFrame" 
				 id="nonRenewalPeriod" key="label.request.otherTimeFrame" theme="aloc" maxlength="10" />
			</div>
		</div>
	</div>	
				
	<div class="clear"></div>
	<div class="row hide initialExpiryDtDiv">
		<div class="span12">
			<div class="form-row">
				<s:textfield name="requestDetails.instrumentDetails.initialExpiryDt"
					cssClass="date" id="initialExpiryDt"
					key="label.request.Initialexpirationdate" theme="aloc"
					tooltip="%{getText('label.request.Initialexpirationmsg')}" />
					<p class="guidance"><s:text name="label.request.dateFormat" /></p>
			</div>
		</div>
	</div>
	
		<div class="row" id="autoincId">
			<div class="span12">
				<div class="radio-container mandatory" id="gov">
					<s:radio theme="aloc" cssClass="radio"
						id="autoIncDecFlag" key="label.request.autoIncDec"
						name="requestDetails.instrumentDetails.autoIncDecFlag"
						list="#{'true':'Yes','false':'No'}"
						tooltip="%{getText('label.request.tooltip.autoIncreaseDecrease')}"  />
				</div>
			</div>
		</div>
		<span style="color:red"><s:fielderror fieldName="requestDetails.instrumentDetails.autoIncDecs"/></span>
		<div class="row hide" id="autoIncDecShow">
						<div class="span12">
							<table class="table table-striped table-bordered sortable auto" id="autoIncDecTable">
								<thead>
									<tr>
										<th colspan="1"><s:text
												name="label.request.action" /></th>
										<th colspan="1"><s:text
												name="label.request.autoIncDecIndicator" /></th>
										<th colspan="1"><s:text
												name="label.request.autoIncDecAmount" /></th>
										<th colspan="1"><s:text name="label.request.autoIncDecDate" /></th>
										
		
									</tr>
								</thead>
								<tbody>
									<tr id="additionalAutoIncDec">
										<td>
											<s:if test="%{requestDetails.instrumentDetails.autoIncDecs[0].autoIncDecId != null && requestDetails.instrumentDetails.autoIncDecs[0].autoIncDecId!=''}">										
												<s:hidden cssClass="autoIncDecOpcode" name="requestDetails.instrumentDetails.autoIncDecs[0].opCode" value="UPDATE"/> 
											</s:if>
											<s:else>
												<s:hidden cssClass="autoIncDecOpcode" name="requestDetails.instrumentDetails.autoIncDecs[0].opCode" value="INSERT"/> 
											</s:else>
										</td>	
										<td>
											<div class="form-row countAuto">
												 <s:radio theme="aloc"
														id="noticePeriodFlag1" cssClass="radio"
														name="requestDetails.instrumentDetails.autoIncDecs[0].autoIncIndicator"
														list="#{'increase':'Increase','decrease':'Decrease'}" />
												
											</div>
										</td>
										<td>
											<div class="form-row">
												<s:textfield
													name="requestDetails.instrumentDetails.autoIncDecs[0].autoIncAmt"
													id="autoIncAmt1" theme="aloc" cssClass="bigDecimal" />
											</div>
										</td>
										<td>
											<div class="form-row">
												<s:textfield
													name="requestDetails.instrumentDetails.autoIncDecs[0].autoIncDt"
													cssClass="date" id="autoIncDt1" theme="aloc" />
												<p class="guidance"><s:text name="label.request.dateFormat" /></p>
											</div>
										</td>	
										
									</tr>
													 	
               					<s:iterator value="requestDetails.instrumentDetails.autoIncDecs" var="additionalrow" status="additionalrowStat">
      								
      								 <s:if test="%{requestDetails.instrumentDetails.autoIncDecs[#additionalrowStat.index+1].opCode != 'DELETE'}">	
									<tr>
										<td>
 											<a href="javascript:void(0);" class="delete-autoIncDec delete-tr-hide" title="Delete this Auto Increase/Decrease Row">Delete Auto Inc/Dec Row</a> 	
										</td>
										<td>
											<div class="form-row">
												<s:radio theme="aloc"
														id="noticePeriodFlag1" cssClass="radio"
														name="requestDetails.instrumentDetails.autoIncDecs[%{#additionalrowStat.index+1}].autoIncIndicator"
														list="#{'increase':'Increase','decrease':'Decrease'}" />
											</div>
										</td>
										<td>
											<div class="form-row">
												<s:textfield
													name="requestDetails.instrumentDetails.autoIncDecs[%{#additionalrowStat.index+1}].autoIncAmt"
													id="autoIncAmt1" theme="aloc" cssClass="bigDecimal" />
											</div>
										</td>
										<td>
											<div class="form-row">
												<s:textfield
													name="requestDetails.instrumentDetails.autoIncDecs[%{#additionalrowStat.index+1}].autoIncDt"
													cssClass="date" id="autoIncDt1" theme="aloc" />
													<p><s:text name="label.request.dateFormat" /></p>
													
											<s:if test="%{requestDetails.instrumentDetails.autoIncDecs[#additionalrowStat.index+1].autoIncDecId != null && requestDetails.instrumentDetails.autoIncDecs[#additionalrowStat.index+1].autoIncDecId !=''}">										
												<s:hidden cssClass="autoIncDecOpcode" name="requestDetails.instrumentDetails.autoIncDecs[%{#additionalrowStat.index+1}].opCode" value="UPDATE"/> 
												<s:hidden name="requestDetails.instrumentDetails.autoIncDecs[%{#additionalrowStat.index+1}].autoIncDecId"/> 
											</s:if>
											<s:else>
												<s:hidden cssClass="autoIncDecOpcode" name="requestDetails.instrumentDetails.autoIncDecs[%{#additionalrowStat.index+1}].opCode" value="INSERT"/> 
											</s:else>													
											</div>
										</td>									
									</tr>
									</s:if>							
									</s:iterator>
								</tbody>
							</table>
						</div>
					</div>
				<s:if test="%{requestDetails.instrumentDetails.autoIncDecs != null && requestDetails.instrumentDetails.autoIncDecs.size > 0}">
					<s:hidden id="newIncrementIndex" name="newIncrementIndex"
						value="%{requestDetails.instrumentDetails.autoIncDecs.size}" />
					<s:hidden id="showIndex" name="showIndex"
						value="%{requestDetails.instrumentDetails.autoIncDecs.size}" />
				</s:if>
				<s:else>
					<s:hidden id="newIncrementIndex" name="newIncrementIndex" value="1" />
					<s:hidden id="showIndex" name="showIndex" value="1" />
				</s:else>
			
				<div class="row hide" id="autoaddLinkDiv">
				<div class="span12">
					<a href="javascript:;" class="left auto-addincdec add" id="append"><s:text
							name="label.request.addAdditionalAutoIncreaseDecrease" /></a>
				</div>
			</div>	
	<script type="text/javascript">
		refreshSectionCount('instrumentDetailsPanel');
	</script>	
</s:if>
<s:elseif test="%{#isEditMode==false}">

	<div class="row">
		<div class="span44">
			<div class="form-row">
					<label><s:text name="label.request.CountryOfIssuance" />:</label>
			</div>
		</div>
		<div class="span5 left">
			<div class="form-row">
				<p class="padding40">
					<c:out
						value="${requestDetails.instrumentDetails.issuanceCountry}" />
				</p>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="span44">
			<div class="form-row">
				<label><s:text name="label.request.currencyOfInstrument" /></label>
			</div>
		</div>
		<div class="span5 left">
			<div class="form-row">
				<p class="padding40">
					<c:out
						value="${requestDetails.instrumentDetails.instrumentCurrency}" />
				</p>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="span44">
			<div class="form-row">
				<label><s:text name="label.request.AmountOfInstrument" />:</label>
			</div>
		</div>
		<div class="span5 left">
			<div class="form-row">
				<p class="padding40">
					<s:property value="requestDetails.instrumentDetails.instrumentAmt" />
				</p>
			</div>
		</div>
	</div>
	<s:hidden name="requestDetails.instrumentDetails.instrumentCurrencyId" id="currencies"></s:hidden>
	<s:hidden name="requestDetails.instrumentDetails.instrumentAmt" id="instrumentAmt"></s:hidden>
	<div class="row">
		<div class="span5">

			<div class="form-row">
				<p style="" id="amountinWords"></p>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="span44">
			<div class="form-row">
				<label><s:text name="label.request.approximateUSDinstrumentAmount" /></label>
			</div>
		</div>
		<div class="span5 left">
			<div class="form-row">
				<p class="padding40">
					<s:property value="requestDetails.instrumentDetails.USDEquivalent" />
					<s:hidden name="requestDetails.instrumentDetails.USDEquivalent" id="instrumentUSDAmt"/>
				</p>
			</div>
		</div>
	</div>

<c:if test="${param.page ne 'BGBidReply'}">
	<div class="row">
		<div class="span44">
			<div class="form-row">
				<label><s:text name="label.request.percentageOfvalueoftotalbidorContractAmount" /></label>
			</div>
		</div>
		<div class="span5 left">
			<div class="form-row">
				<p class="padding40">
					<c:out
						value="${requestDetails.instrumentDetails.percentValueOfBid}" />
				</p>
			</div>
		</div>
	</div>
</c:if>

<c:if test="${requestDetails.transactionParties.instrumentPurposeId eq '12' || requestDetails.transactionParties.instrumentPurposeId eq '14'}">
		 <div class="row">
			<div class="span44">
				<div class="form-row">
					<label><s:text name="label.request.maximumPossibleExposure" /></label>
				</div>
			</div>
			<div class="span5 left">
				<div class="form-row">
					<p class="padding40">
						<c:out
							value="${requestDetails.instrumentDetails.maxPossibleExpo}" />
					</p>
				</div>
			</div>
		</div> 
	
	</c:if>

	<div class="row">
		<div class="span44">
			<div class="form-row">
				<label><s:text name="label.request.issueDateC" /></label>
			</div>
		</div>
		<div class="span5 left">
			<div class="form-row">
				<p class="padding40">
					<s:property value="requestDetails.instrumentDetails.issueDt" />
				</p>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="span44">
			<div class="form-row">
				<label><s:text name="label.request.ExpirationDate" />:</label>
			</div>
		</div>
		<div class="span5 left">
			<div class="form-row">
				<p class="padding40">
					<s:property value="requestDetails.instrumentDetails.expiryDt" />
				</p>
			</div>
		</div>
	</div>

	<c:if test="${not empty requestDetails.instrumentDetails.econoExpiryDt}">
	<div class="row">
		<div class="span44">
			<div class="form-row">
				<label><s:text name="label.request.economicExpirationDate" /></label>
			</div>
		</div>
		<div class="span5 left">
			<div class="form-row">
				<p class="padding40">
					<s:property value="requestDetails.instrumentDetails.econoExpiryDt" />
				</p>
			</div>
		</div>
	</div>
	</c:if>
	<div class="row">
		<div class="span44">
			<div class="form-row">
				<label><s:text	name="label.request.SpecialInstructionsOptional" />:</label>
			</div>
		</div>
		<div class="span5 left">
			<div class="form-row">
				<p class="padding40" style="word-wrap: break-word;">
					<c:out	value="${requestDetails.deliveryInstructions.specialInstructions}" />
				</p>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="span44">
			<div class="form-row">
				<label><s:text name="label.request.autoExtClausePresent" /></label>
			</div>
		</div>
		<div class="span5 left">
			<div class="form-row">
				<p class="padding40">
					<s:if test="%{requestDetails.instrumentDetails.autoExtendClause.AutoExtendFlag}">
						<s:text name="label.request.common.yes" />
					</s:if>
					<s:else>
						<s:text name="label.request.common.no" />
					</s:else>
				</p>
			</div>
		</div>
	</div>
<s:if test="%{requestDetails.instrumentDetails.autoExtendClause.AutoExtendFlag}">
    <s:if test="%{requestDetails.instrumentDetails.autoExtendClause.nonRenewalPeriod!='' && requestDetails.instrumentDetails.autoExtendClause.nonRenewalPeriod!=null}">
	<div class="row">
		<div class="span44">
			<div class="form-row">
				<label><s:text name="label.request.renewalNoticeperiod" />:</label>
			</div>
		</div>
		<div class="span5 left">
			<div class="form-row">
				<p class="padding40">
					  <c:out value="${requestDetails.instrumentDetails.autoExtendClause.nonRenewalPeriod}" />
				</p>
			</div>
		</div>
	</div>
	</s:if>
	<s:if test="%{requestDetails.instrumentDetails.autoExtendClause.otherTimeFrame!='' && requestDetails.instrumentDetails.autoExtendClause.otherTimeFrame!=null}">
		<div class="row">
			<div class="span44">
				<div class="form-row">
					<label><s:text name="label.request.otherTimeFrame" />:</label>
				</div>
			</div>
			<div class="span5 left">
				<div class="form-row">
					<p class="padding40">
						  <c:out value="${requestDetails.instrumentDetails.autoExtendClause.otherTimeFrame}" />
					</p>
				</div>
			</div>
		</div>
	</s:if>
    <c:if test="${param.page ne 'bidAward'}">
		<div class="row">
			<div class="span44">
				<div class="form-row">
					<label><s:text name="label.request.Initialexpirationdate" />:</label>
				</div>
			</div>
			<div class="span5 left">
				<div class="form-row">
					<p class="padding40">
						<s:property value="requestDetails.instrumentDetails.initialExpiryDt" />
					</p>
				</div>
			</div>
		</div>
  </c:if>
</s:if>
<div class="row">
			<div class="span44">
				<div class="form-row">
					<label><s:text name="label.request.autoIncDec" /> :</label>
				</div>
			</div>
			<div class="span5 left">
				<div class="form-row">
					<p class="padding40">
						<s:if test="%{requestDetails.instrumentDetails.autoIncDecFlag}">
								<s:text name="label.request.common.yes" />
							</s:if>
							<s:else>
								<s:text name="label.request.common.no" />
							</s:else>
					</p>
				</div>
			</div>
		</div>

<s:if test="%{requestDetails.instrumentDetails.autoIncDecFlag == 'true'}"> 	
	<div class="row">
		<div class="span12">
			<table class="table table-striped table-bordered auto">
				<thead>
					<tr class="spantr1">
						<th><s:text name="label.request.autoIncDecIndicator" /></th>
						<th><s:text name="label.request.autoIncDecAmount" /></th>
						<th><s:text name="label.request.autoIncDecDate" /></th>						
					</tr>
				</thead>
				<tbody>
				<s:iterator value="requestDetails.instrumentDetails.autoIncDecs" >
				 <s:if test="%{opCode != 'DELETE'}">	
					<tr class="spantr2">
						<td><s:property value="autoIncIndicator"/></td>
						<td><s:property value="autoIncAmt"/></td>
						<td><s:property value="autoIncDt"/></td>
				</tr>
				</s:if>
				</s:iterator>
				</tbody>
			</table>

		</div>
	</div>
	<!-- end of block -->

</s:if>
</s:elseif>


