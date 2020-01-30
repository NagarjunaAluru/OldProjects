<div class="row">
 
 <div class="span5">
	<div class="form-row">
 	<span class="required">*</span>
	<label><bean:message key="label.addLeg.productType" /></label>
	<bean:write name="ICFPLegRequestForm" property="legSummary.productType" />
	<html:hidden name="ICFPLegRequestForm" property="legSummary.legTypeId" styleId="productType" />
	</div>
 </div>

  <div  class="span5 right">
	<div id="dealcurrencyDiv" class="form-row">
	<span class="required">*</span>
	<label><bean:message key="label.addLeg.dealCurrency" /></label>
	<span  class="help-block error" id="originalCCYValidate" style="display:none;">Please select Deal currency </span>
	
	<input type="text" id="originalCCY" name="legSummary.originalCCY"
		 value="<bean:write name="ICFPLegRequestForm" property="legSummary.originalCCY"/>"
		 class="span2 amount" data-provide="typeahead" 
		 data-source="<c:out value="${applicationScope['com.ge.icfp.MasterData'].allCurrencies}"/>" >
							
	<span id="originalCCYValidateBar" class="req-error" style="display:none;">error</span>
   </div>
  </div> 
  
</div>  

<div class="row">

 <div id="termDiv" class="span5">
	<div class="form-row">
		<div id="termMandatoryDiv"><span class="required">*</span></div>
		<label>
			<bean:message key="label.addLeg.term" /> 
			<span class="small"><bean:message key="label.addLeg.inMonths" /></span>
			<span data-original-title="<bean:message key="tooltip.addLeg.termInMonths" />" class="ttip info"></span>
		</label>
		<span  class="help-block error" id="termValidate" style="display:none;">Please enter Term</span>
		<span  class="help-block error" id="termValidateNumber" style="display:none;">Invalid value </span>
		<html:text name="ICFPLegRequestForm" property="legSummary.termInMonths" maxlength="9" styleClass="span1" styleId="termInMonths" />
		<span id="termValidateBar" class="req-error" style="display:none;">error</span>
	</div>
 </div>
 
 <div id="amountDiv" class="span5 right">
	<div class="form-row">
	<span class="required">*</span>
	<label>
	  <bean:message key="label.addLeg.amount" />
	  <span data-original-title="<bean:message key="label.fundingRequestaddLegTooltip.amount" />" class="ttip info"></span>
	</label>
	<span  class="help-block error" id="originalCCYAmountValidate" style="display:none;">Please enter Amount</span>
	<span  class="help-block invalid error" style="display:none;">Invalid value </span>
	
	 <input type="text"  name="legSummary.originalCCYAmount" id="originalCCYAmount"
		maxlength="30" class="span2 currency" data-for="amount"
		value="<fmt:formatNumber  value="${sessionScope.ICFPLegRequestForm.map.legSummary.map.originalCCYAmount}" />"/>
	<span  class="req-error" style="display:none;">error</span>
	<span id="originalCCYAmountValidateBar" class="req-error" style="display:none;">error</span>    
   </div>
 </div>
  
</div>

<div class="row">
 
 <div class="span5">
 <div class="form-row">
	<span class="required">*</span>
	<label>Subordinated Debt</label>
	<span  class="help-block error" id="subordinatedfailed" style="display:none;">Please select Subordinated Debt</span>
	<div id ="subordinatedDiv" class="radio-container">
	 <span id="subordinatedfailed"></span>
	 <label class="radio">
	  <html:radio name="ICFPLegRequestForm" property="legSummary.subordinatedDebt" styleId="subordinatedDebt" value="true"/>
	  <bean:message key="label.addLeg.yes" />
	 </label>
	 <label class="radio">
	  <html:radio name="ICFPLegRequestForm" property="legSummary.subordinatedDebt" styleId="subordinatedDebt" value="false"/>
   	  <bean:message key="label.addLeg.no" />
	 </label>
	</div>
 </div>
 </div>
 
 <div class="span5 right" id="usdEquiDiv">
  <div class="form-row">
	<p><b>USD equivalent</b></p>
	<html:hidden  name="ICFPLegRequestForm" property="legSummary.USDEquivalent" styleId="USDEquivalent"/>
	<span id="usdValidateBar" class="req-error" style="display:none;">error</span>
	<c:if test="${sessionScope.ICFPLegRequestForm.map.legSummary.map.USDEquivalent eq '0.00'}">
		<p>-</p>
	</c:if>
	<c:if test="${sessionScope.ICFPLegRequestForm.map.legSummary.map.USDEquivalent != '0.00'}">
		<p>${sessionScope.ICFPLegRequestForm.map.legSummary.map.USDEquivalent}</p>
	</c:if>
   </div>
 </div>
						
</div>

<div class="row">

 <div class="span5">
  <div class="form-row">
	<div id="crossMandatoryDiv"><span class="required">*</span></div>
	<label>Cross Border<span class="ttip info" data-original-title="<bean:message key="label.tooltip.crossBoarder" />"></span></label>
	<div id="crossborderDiv" class="radio-container">
	<label class="radio">
	<html:radio name="ICFPLegRequestForm" styleClass="condition" styleId="crossBorderFlag" property="crossBorderFlag" value="true"/>
	<bean:message key="label.addLeg.yes" />
	</label>
	<label class="radio">
	<html:radio name="ICFPLegRequestForm" property="crossBorderFlag" styleId="crossBorderFlag" value="false"/>
	<bean:message key="label.addLeg.no" />
	</label>
	</div>
   </div>
 </div>
	<c:if test="${sessionScope.ICFPLegRequestForm.map.legSummary.map.legTypeId eq 6}" >
		<div class="row">
			<div  class="span5 right">
				<div class="form-row">
					<label>Issue Price %</label>
					<html:text name="ICFPLegRequestForm" maxlength="6" styleId="issuePriceID"  property="legSummary.issuePrice"  styleClass="span1" />
					<span id="issuePricefailedBar" class="req-error" style="display:none;">error</span>
				</div>
			</div>
		</div>
	</c:if>
</div>

<div class="row">

 <div id="derDivEquity" class="span5">
	<div class="form-row">
	<div id="derMandatoryDiv"><span class="required">*</span></div>
	<label>Are there Derivatives?</label>
	<span  class="help-block error" id="derivativesfailed" style="display:none;">Please select Are there Derivatives?</span>
	<div id="derivativDiv" class="radio-container derivativesConditional">
	<span id="derivativeFailedBar" class="req-error" style="display:none;">error</span>
	<label class="radio">
	<html:radio name="ICFPLegRequestForm" property="legSummary.derivativesFlag" styleId="derivativesFlag" value="true" styleClass="condition"/>
	<bean:message key="label.addLeg.yes" />
	</label>
	<label class="radio">
	<html:radio name="ICFPLegRequestForm" property="legSummary.derivativesFlag" styleId="derivativesFlag" value="false"/>
	<bean:message key="label.addLeg.no" />
	</label>
	</div>
   </div>
 </div>
	 <c:if test="${sessionScope.ICFPLegRequestForm.map.legSummary.map.legTypeId eq 6}" >	
		<div  class="span5 right">
			<div class="form-row">
				<label>Agent/Dealer Commission %</label>
				<html:text name="ICFPLegRequestForm" maxlength="6" styleId="agentDealerCommissionID"  property="legSummary.agentDealerCommission"  styleClass="span1" />
				<span id="agentDealerCommissionfailedBar" class="req-error" style="display:none;">error</span>
			</div>
		</div>
	</c:if>	
</div>

<div class="row" id="derivatives-table" style="display:none;">

  <div class="span12">
 
  <div class="row">
  <div class="span9">
	  <div class="table-btn">
	  <span class="required">*</span>
	  <span id="derFlagValidatee" class="req-error" style="display:none;">error</span>
	  <input type="button" value="Add a Derivative" tabindex="18" class="btn" onclick="javascript:addDerivatives('?command=addDerivatives');">
	  </div>
  </div>
  </div>
   <%int count = 0; %>
  <c:set var="DerExistsFlag" value="0" />
  <table class="table table-striped table-bordered sortable no-bottom">
  <thead>
	<tr>
		<th rowspan="2" colspan="2">Action</th>
		<th rowspan="2">Item No.</th>
		<th rowspan="2">Derivatives</th>
		<th rowspan="2">Derivative Type</th>
		<th colspan="3" class="nosort">Currency 1</th>
		<th colspan="3" class="nosort">Currency 2</th>
		<th rowspan="2">Hedge Designation</th>
		<th rowspan="2">Tax Designation</th>
	</tr>
	<tr>
		<th>Currency</th>
		<th>Amount</th>
		<th>Fixed/Float</th>
		<th>Currency</th>
		<th>Amount</th>
		<th>Fixed/Float</th>
	</tr>
  </thead>
  <tbody>
	<c:set var="derivativeDetailsVOList" value="${deal:fetchDerivatives(legNumber, pageContext)}" />
	<c:choose>
	<c:when test="${not empty derivativeDetailsVOList}">
	  <c:forEach var="derivative" items="${derivativeDetailsVOList}">
	  <c:set var="DerExistsFlag" value="${derivative.derivativeNumber}" />
	  <%count++; %>
	  <tr id='dealDeriv'${derivative.derivativeNumber}>
		<td>
		  <a href="#derDeleteConfirm${derivative.derivativeNumber}" class="delete-leg modal-confirm" 
		  		title="Delete this Derivative" data-toggle="modal">Delete</a> 
		</td>
		<td>
		   <a href="javascript:void(0);" id="edit-derivative" 
		   		class="edit-leg ttip" data-original-title="Edit this derivative" 
		   		onclick="javascript:modifyDerivative(this);"></a>
		</td>
		<td id="itemNoId">${derivative.derivativeNumber}</td>
		
		<td>${derivative.internalOrExternal}</td>
		<td>${derivative.derivativeType}</td>
		<td>${derivative.currency1}</td>
		<td>${derivative.derivativeAmount1}</td>
		<td>${derivative.fixedOrFloat1}</td>
		<td>${derivative.currency2}</td>
		<td>${derivative.derivativeAmount2}</td>
		<td>${derivative.fixedOrFloat2}</td>
		<td>${derivative.hedgeDesigation}</td>
		<td>${derivative.taxDesigation}</td>
	 </tr>
	
	<div class="modal hide fade deleteConfirm" id="derDeleteConfirm${derivative.derivativeNumber}">
	 <div class="modal-header" >
		<a class="close" href="javascript:closeDerConfirm('derDeleteConfirm${derivative.derivativeNumber}')">X</a>
		<h3>Delete this Derivative</h3>
	 </div>
	 <div class="modal-body" style="margin-top:-15px;">
		<div class="row">
			<p><b>Are you sure you want to Delete?</b><br></p>
		</div>
	</div>
	<div class="modal-footer">
	  <a href="#" class="btn right btn-success" data-dismiss="modal" 
	  		id="delete-legBtn" onclick="javascript:deleteDerivative(${derivative.derivativeNumber});">
	  		Yes, Delete this Derivative
	  </a>
	  <a href="javascript:closeDerConfirm('derDeleteConfirm${derivative.derivativeNumber}')" class="btn-link right cancel">No, take me back to the Leg</a>
	</div>
   </div>
  </c:forEach>
  </c:when>
  <c:otherwise>
	<td>-</td>
	<td>-</td>
	<td>-</td>
	<td>-</td>
	<td>-</td>
	<td>-</td>
	<td>-</td>
	<td>-</td>
	<td>-</td>
	<td>-</td>
	<td>-</td>
	<td>-</td>
	<td>-</td>	
   </c:otherwise>
   </c:choose>

   </tbody>
   </table>
   <input type="hidden" name="derivativeCount" id="derivativeCountID" value="<%=count%>"/>
  
 </div>

</div>

	<div class="row" id="immediateDrawDownID">
				<div class="span5">
					<div class="form-row">
						<span class="required">*</span>
						<label>Immediate drawdown applicable</label>
						<span  class="help-block error" id="immediateDrawdownFailed" style="display:none;">Please select Immediate drawdown applicable</span>
						<div id="immediateDrawdownDiv" class="radio-container immediate-Drawdown-condition">
							<span id="immediateDrawdownFailed"></span>
							<label class="radio">
								<html:radio name="ICFPLegRequestForm" styleClass="immediate-Drawdown-yes-condition" styleId="isImmediateDrawDown" property="immdtDrdownApplicableFlag" value="true"/>
								Yes
							</label>
							<div id="immdtDrdownAmtDiv" class="form-row immdtDrdownAmt-container" style="display:block;">
								<div class="form-row">
									<span class="required">*</span>
									<label>Immediate drawdown amount</label>
									<span  class="help-block invalid error" style="display:none;">Invalid value </span>
									<input type="text"  name="immdtDrdownAmt" maxlength="30" class="span2 currencynoconversion" id="immediateDrawDownAmt" value="<fmt:formatNumber  value="${sessionScope.ICFPLegRequestForm.map.immdtDrdownAmt}" />" />
									<span class="req-error" style="display:none;">error</span>
									<span id="immdtDrdownAmtfailedBar" class="req-error" style="display:none;">error</span>
								</div>
								<div class="form-row">
									<span class="required">*</span>
									<label>Immediate Drawdown Value Date</label>
									<span id="drawdownvalueDtErrorID" class="help-block error" style="display:none;"><bean:message key="immDrawDownDateValidation" /></span>
							        <span id="drawdownvalueDtTodayID" class="help-block error" style="display:none;"><bean:message key="immDrawDownDateValidationForTodayDate" /></span>
									<html:text name="ICFPLegRequestForm"  styleId="immediateDrawdownValueDateID"  property="drdownValueDt"  readonly="true"  styleClass="span3 datepicker-field" maxlength="10"   />
									<span id="drdownValueDtfailedBar" class="req-error" style="display:none;">error</span>
									<span class="help-block clear"><bean:message key="label.fundingRequest.dateFormat" /></span>
								</div>
							</div>
							<label class="radio">
								<html:radio name="ICFPLegRequestForm" styleClass="immediateDrawdown-condition" styleId="isImmediateDrawDown" property="immdtDrdownApplicableFlag" value="false"/>
								 No
							</label>
						</div>
					</div>
				</div> <!-- end of block -->
			</div>	 

<div class="row">
	
	<div class="span5">
	<div class="form-row">
		<div id="excepMandatoryDiv"><span class="required">*</span></div>
		<label>Non-standard Legal Agreement(s)<span class="ttip info" data-original-title="<bean:message key="label.tooltip.nonStaLegAgr" />"></span></label>
		<span  class="help-block error" id="legalAgreementfailed" style="display:none;">
			Please select Non-standard Legal Agreement(s)
		</span>
		<div id="legalAgreementDiv" class="radio-container exceptionsConditional">
			<label class="radio">
				<html:radio name="ICFPLegRequestForm" styleClass="condition" 
					styleId="isNonStandardLegalAgreement" property="legSummary.nonStandardAgreementsFlag" value="true"/>
				<bean:message key="label.addLeg.yes" />
			</label>
			<label class="radio">
				<html:radio name="ICFPLegRequestForm" property="legSummary.nonStandardAgreementsFlag"
					 styleId="isNonStandardLegalAgreement" value="false"/>
				<bean:message key="label.addLeg.no" />
			</label>
		</div>
		</div>
	</div>		
	<c:if test="${sessionScope.ICFPLegRequestForm.map.legSummary.map.legTypeId eq 6}" >	
		<div  class="span5 right">
			<div class="form-row">
				<label>Net Proceeds</label>
				<span  class="help-block invalid error" style="display:none;">Invalid value </span>
				<html:text name="ICFPLegRequestForm" maxlength="25" styleId="netProceedsID"  property="legSummary.netProceedsAmt"  styleClass="span2 currencynegnoconversion" />
				<span id="netProceedsIfailedBar" class="req-error" style="display:none;">error</span>
			</div>
		</div>
	</c:if>	
</div>
			
			
