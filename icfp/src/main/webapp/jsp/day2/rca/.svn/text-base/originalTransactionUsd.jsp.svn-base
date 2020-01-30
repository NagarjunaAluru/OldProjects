<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>

<fmt:setLocale value="en-US"/>

	<div>
			<h2 class="span12">Original Transaction Details</h2>
            <div class="clear"></div>
			<div class="row">
					<div class="span5">
						<div class="form-row">
							<span class="required">*</span>
							<label>Product Type</label>
							<div class="radio-container">
								<html:text name="ICFPLegRequestForm" property="legSummary.productType" styleId="productType" readonly="true"/>
								<html:hidden name="ICFPLegRequestForm" property="legSummary.legTypeId" styleId="legTypeId" />
							</div>
						</div>
					</div> <!-- end of block -->
					<div class="span5 right ">
						<div class="form-row">
							<c:if test="${param.productType ne '2'}">
								<span class="required">*</span>
							</c:if>
							<label>Trade ID / Loan Model ID<span class="ttip info" data-original-title="<bean:message key="label.tooltip.tradeLoanmodelIDs" />"></span></label>
							<html:text name="ICFPLegRequestForm" property="legSummary.transactionId" styleId="transactionId" maxlength="50"/>
							<span id="transactionIdBar" class="req-error" style="display:none;">error</span>
						</div>
					</div> <!-- end of block -->
				</div>
				<c:if test="${param.productType ne '2'}">
					<div class="row">
						<div class="span5">
							<div class="form-row">
								<span class="required">*</span>
								<label>Terms (in months)
									<span data-original-title="<bean:message key="tooltip.addLeg.termInMonths" />" class="ttip info"></span>
								</label>
								<html:text name="ICFPLegRequestForm" property="legSummary.termInMonths" maxlength="9" styleClass="span1" styleId="termInMonths" />
								<span id="terminMonthsBar" class="req-error" style="display:none;">error</span>
							</div>
						</div> <!-- end of block -->	
						<div class="span5 right">
							<div class="form-row">
	                        	<span class="required">*</span>
								<label>Is Transaction Hedged</label>
	                            <div id="transHedgedDiv" class="radio-container">
									<label class="radio">
										<html:radio name="ICFPLegRequestForm" styleClass="condition" property="legSummary.isHedgedFlag" styleId="isHedgedFlag"  value="1"/>
										<bean:message key="label.addLeg.yes" />
									</label>
									<label class="radio">
										<html:radio name="ICFPLegRequestForm" property="legSummary.isHedgedFlag" styleId="isHedgedFlag" value="0"/>
										<bean:message key="label.addLeg.no" />
									</label>
								</div>        
							</div>
						</div> <!-- end of block -->
					</div>
				</c:if>
				<div class="row">
					<div class="span5">
						<div class="form-row">
							<span class="required">*</span>
							<label>Non Standard Legal Agreement(s)</label>
                            <div id="originalLegalAgreementDiv" class="radio-container">
							<label class="radio">
								<html:radio name="ICFPLegRequestForm" styleClass="condition" property="legSummary.originalLegalAgreementsFlag" styleId="originalLegalAgreementsFlag"  value="1"/>
								<bean:message key="label.addLeg.yes" />
							</label>
							<label class="radio">
								<html:radio name="ICFPLegRequestForm" property="legSummary.originalLegalAgreementsFlag" styleId="originalLegalAgreementsFlag" value="0"/>
								<bean:message key="label.addLeg.no" />
							</label>
						</div>                               
						</div>
					</div><!-- end of block -->
					<div class="span5 right">
						<div class="form-row">
							<span class="required">*</span>
							<label>Currency</label>
							<span  class="help-block error" id="originalCCYValidate" style="display:none;">Please select currency </span>
							<span  class="help-block error" id="originalCCYInvalid" style="display:none;">Invalid currency </span>
							<input type="text" id="originalCCY" name="legSummary.originalCCY" value="<bean:write name="ICFPLegRequestForm" property="legSummary.originalCCY"/>"
							class="span2 amount" data-provide="typeahead" 
							data-source="<c:out value="${applicationScope['com.ge.icfp.MasterData'].allCurrencies}"/>" >
							
	 						<span id="originalCCYValidateBar" class="req-error" style="display:none;">error</span>
						</div>
					</div> <!-- end of block -->
				</div>
				
					<div class="row">
						<div class="span5 right">
							<div class="form-row">
								<span class="required">*</span>
								<label>Principal / Facility Amount</label>
								 <span  class="help-block error" id="originalCCYAmountValidate" style="display:none;">Please enter Prinicipal Amount</span>
								<span  class="help-block invalid error" style="display:none;">Invalid value </span>
								
								<input type="text"  name="legSummary.originalCCYAmount" maxlength="30" class="span2 currency" id="originalCCYAmount" 
									data-for="amount" value="<fmt:formatNumber  value="${sessionScope.ICFPLegRequestForm.map.legSummary.map.originalCCYAmount}" />"/>
									
								<span class="req-error" style="display:none;">error</span> 
								<span id="originalCCYAmountValidateBar" class="req-error" style="display:none;">error</span> 
							</div>
						</div><!-- end of block -->
					
					</div> 
					
				<div class="row" id="usdEquiDiv">
					<div class="span5 right">
							<div class="form-row">
								<label>USD Equivalent</label>
								<html:hidden  name="ICFPLegRequestForm" property="legSummary.USDEquivalent" styleId="USDEquivalent"/>
								<span id="usdValidateBar" class="req-error" style="display:none;">error</span>
								<c:if test="${sessionScope.ICFPLegRequestForm.map.legSummary.map.USDEquivalent eq '0.00'}">
								   <p>-</p>
								</c:if>
								<c:if test="${sessionScope.ICFPLegRequestForm.map.legSummary.map.USDEquivalent != '0.00'}">
									<p>${sessionScope.ICFPLegRequestForm.map.legSummary.map.USDEquivalent}</p>
								</c:if>
							</div>
						</div> <!-- end of block -->
				</div>
								
				
		</div><!-- end of form form-mod -->