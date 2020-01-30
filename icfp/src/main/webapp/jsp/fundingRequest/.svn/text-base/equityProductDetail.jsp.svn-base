<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<div class="row">
	<div class="span5">
		<div class="form-row">
			<span class="required">*</span>
			<label><bean:message key="label.addLeg.productType" /></label>
			<bean:write name="ICFPLegRequestForm" property="legSummary.productType" />
			<html:hidden name="ICFPLegRequestForm" property="legSummary.legTypeId" styleId="productType" />
		</div>
	</div> 
	<div id="formOfEquityDiv" class="span5 right">
		<div class="form-row">
			<span class="required">*</span>
			<label>Form of Equity</label>
			<html:select name="ICFPLegRequestForm" property="equityFormId" styleClass="span2 form-of-equity" styleId="equityFormId">
				<html:option value="">Select..</html:option>
				<html:optionsCollection name="com.ge.icfp.StaticData" property="formOfEquity" value="ID" label="name"/>
			</html:select>
			<span id="equityFormValidate" class="req-error" style="display:none;">error</span>
		</div>
	</div>
</div>

<div id="allProductTypeDiv" class="product-type-all"  style="display:none;">
	<h3 class="span12">Equity Details</h3>
	<div class="row">
	<div class="span12">
				
	 <table class="table table-striped table-bordered equity-validation">
		<thead>
		  <tr>
			<th class="header" style="width:35px;">Action</th>
			<th class="header">Share type</th>
			<th class="header">Number of shares</th>
			<th class="header">Par value per share</th>
		  </tr>
		</thead>
		<tbody>
		<c:choose>
			<c:when test="${not empty sessionScope.ICFPLegRequestForm.map['shareInfos']}">
			 <logic:iterate name="ICFPLegRequestForm" property="shareInfos" id="equityDetails" indexId="i">
	
			  <tr>
				<td><a href="#" title="Delete this equity" class="delete-tr">X</a></td>
				<td>
					<div class="form-row">
						<span class="required">*</span>
						<html:select name="equityDetails" property="shareTypeId" styleClass="span2 request-equity" styleId="shareTypeId">
							<html:option value="">Select..</html:option>
							<html:optionsCollection name="com.ge.icfp.StaticData" property="shareTypes" value="ID" label="name"/>
						</html:select>
					</div>
				</td>
				<td>
					<div class="form-row">
						<span class="required">*</span>
						<html:text name="equityDetails" property="numberOfShares" styleClass="span2 request-noOfShares" styleId="numberOfShares" maxlength="9"/>
					</div>
				</td><td>
					<div class="form-row">
						<span class="required">*</span>
						<html:text name="equityDetails" property="shareValue" styleClass="span2 request-sharevalue" styleId="shareValue" maxlength="9"/>
						 <html:hidden name="equityDetails" property="sharePrfId"/>
					</div>
				</td>

			  </tr>
			 	</logic:iterate>
			</c:when>
			
			<c:otherwise>
			  <tr>
			  <td><a href="#" title="Delete this equity" class="delete-tr">X</a></td>
				<td>
					<div class="form-row">
						<span class="required">*</span>
						<select name="shareTypeId" class="span2 request-equity">
							<option value="">Select..</option>
							<c:forEach items="${applicationScope['com.ge.icfp.StaticData'].shareTypes}" var="option">
								<option value="${option.ID}">${option.name}</option>
							</c:forEach>
						</select>
					</div>
				</td>
				<td>
					<div class="form-row">
						<span class="required">*</span>
						<input name="numberOfShares" type="text" class="span2 request-noOfShares" maxlength="9">
					</div>
				</td><td>
					<div class="form-row">
						<span class="required">*</span>
						<input name="shareValue" type="text" class="span2 request-sharevalue" maxlength="9">
						<input name="sharePrfId" type="hidden" value="">
					</div>
				</td>
			  </tr>
			</c:otherwise>
		</c:choose>
		</tbody>
	  </table>
	  <a class="left add" href="#">Add additional share type</a>
	</div>
	</div>
</div>	

<div id="debtProductTypeDiv" class="product-type-debtfields" style="display:none;">
	<h3 class="span12">Equity Details</h3>
	<div class="row">
		<div class="span12">
		 <table class="table table-striped table-bordered equityDebt-validation">
			<thead>
			  <tr>
				<th class="header" style="width:35px;">Action</th>
				<th class="header">Debt terms</th>
				<th class="header">Share type</th>
				<th class="header">Number of shares</th>
				<th class="header">Par value per share</th>
			  </tr>
			</thead>
			<tbody>
			<c:choose>
			<c:when test="${not empty sessionScope.ICFPLegRequestForm.map['shareInfos']}">
				
			<logic:iterate name="ICFPLegRequestForm" property="shareInfos" id="equityDetails" indexId="i">
	
			  <tr id="debTr1">
				<td><a href="#" title="Delete this equity" class="delete-tr">X</a></td>
				<td>
					<div class="form-row">
						
						<html:text name="equityDetails" property="debtTerms" styleClass="span2 requestDebt-equity" styleId="numberOfShares" maxlength="20"/>
					</div>
				</td>
				<td>
					<div class="form-row">
						
						<html:select name="equityDetails" property="shareTypeId" styleClass="span2 requestDebt-equity" styleId="shareTypeId">
							<html:option value="">Select..</html:option>
							<html:optionsCollection name="com.ge.icfp.StaticData" property="shareTypes" value="ID" label="name"/>
						</html:select>
					</div>
				</td>
				<td>
					<div class="form-row">
						
						<html:text name="equityDetails" property="numberOfShares" styleClass="span2 requestDebt-noOfShares" styleId="numberOfShares" maxlength="9"/>
					</div>
				</td><td>
					<div class="form-row">
						
						<html:text name="equityDetails" property="shareValue" styleClass="span2 requestDebt-sharevalue" styleId="shareValue" maxlength="9"/>
						 <html:hidden name="equityDetails" property="sharePrfId" />
					</div>
				</td>

			  </tr>
			  	</logic:iterate>
			</c:when>
			
			<c:otherwise>
			<tr class="debTr2" id="debTr2">
			<td><a href="#" title="Delete this equity" class="delete-tr">X</a></td>
				<td>
					<div class="form-row">
						
						<input name="debtTerms" type="text" class="span2 requestDebt-equity" maxlength="20">
					</div>
				</td>
				<td>
					<div class="form-row">
						
						<select name="shareTypeId" class="span2 requestDebt-equity">
							<option value="">Select..</option>
							<c:forEach items="${applicationScope['com.ge.icfp.StaticData'].shareTypes}" var="option">
								<option value="${option.ID}">${option.name}</option>
							</c:forEach>
						</select>
					</div>
				</td>
				<td>
					<div class="form-row">
						
						<input name="numberOfShares" type="text" class="span2 requestDebt-noOfShares" maxlength="9">
					</div>
				</td><td>
					<div class="form-row">
						
						<input name="shareValue" type="text" class="span2 requestDebt-sharevalue" maxlength="9">
						<input name="sharePrfId" type="hidden">
					</div>
				</td>
				</tr>
			</c:otherwise>
			</c:choose>
			</tbody>
		  </table>
		  <a class="left add" href="#">Add additional share type</a>
		</div>
	</div> 
</div> 

<div id="termDiv" class="row">
	<div class="span5">
		<div class="form-row">
			<div id="termMandatoryDiv"><span class="required">*</span></div>
			<label><bean:message key="label.addLeg.term" /> <span class="small"><bean:message key="label.addLeg.inMonths" /></span>
			<span data-original-title="<bean:message key="tooltip.addLeg.termInMonths" />" class="ttip info"></span>
			</label>
			<span  class="help-block error" id="termValidate" style="display:none;">Please enter Term</span>
			<span  class="help-block error" id="termValidateNumber" style="display:none;">Invalid value </span>
			<html:text name="ICFPLegRequestForm" property="legSummary.termInMonths" maxlength="20" styleClass="span1" styleId="termInMonths" />
			<span id="termValidateBar" class="req-error" style="display:none;">error</span>
		</div>
	</div> <!-- end of block -->
</div>
			
<div id="commenstDiv">
<h3 class="span12">Description</h3>
<div class="row"> 
					<div class="span5">
						<div class="form-row">
							<span class="required">*</span>
							<div class="autosize-container1">
                           		<label>&nbsp;</label>
                            	<div class="char-count otherEquityChar" style="margin-left:-10px;">1000</div>
                            	<html:textarea  name="ICFPLegRequestForm"  styleClass="xlarge autosize1 messageinput"  property="otherEquityComments"  styleId="equityDescriptionID" tabindex="3" rows="1"  onblur="scriptInjection(this);"></html:textarea>
                            	<span id="equityDescBar" class="req-error" style="display:none;">error</span>
                        	</div>
						</div>
					</div> <!-- end of block -->
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

 <div  class="span5">	
 <div class="form-row">
	<span class="required">*</span>
	<label>Double Leverage</label>
	<div id="doubleLeverage" class="radio-container">
		<label class="radio">
			<html:radio name="ICFPLegRequestForm" property="doubleLeverageFlag" styleId="doubleLeverageFlag" value="true"/>
			Yes
		</label>
		<label class="radio">
			<html:radio name="ICFPLegRequestForm" property="doubleLeverageFlag" styleId="doubleLeverageFlag" value="false"/>
			No
		</label>
	</div>
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
	
	<input type="text" name="legSummary.originalCCYAmount"
		class="span2 currency" data-for="amount" id="originalCCYAmount" maxlength="30"
		value="<fmt:formatNumber  value="${sessionScope.ICFPLegRequestForm.map.legSummary.map.originalCCYAmount}" />"> 
	
	<span class="req-error" style="display:none;">error</span>
	<span id="originalCCYAmountValidateBar" class="req-error" style="display:none;">error</span>
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
 <div id="eBoardEligibleDiv" class="span5 right" style="display:none;">
						<div class="form-row">
							<p><b>eBoardroom eligible</b></p>
							<c:if test="${requestScope.eBoardARFlagValue == null}"> 
								<p>-</p>
							</c:if>
							<c:if test="${requestScope.eBoardARFlagValue != null && requestScope.eBoardARFlagValue eq 'No'}">
								<p>${requestScope.eBoardARFlagValue}</p>
							</c:if>
							<c:if test="${requestScope.eBoardARFlagValue != null && requestScope.eBoardARFlagValue eq 'Yes'}"> 
								<p>${requestScope.eBoardARFlagValue}</p>
							</c:if>
						</div>
					</div><!-- end of block -->
 
</div>					


