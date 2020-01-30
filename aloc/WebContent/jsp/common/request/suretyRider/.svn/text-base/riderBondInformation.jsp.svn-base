<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
&nbsp;
<c:set var="riderWorkFlowStage" value="${requestDetails.WFDetails.WFStage}"></c:set>
<s:set name="isEditMode" value="editMode" />
<s:if test="%{#isEditMode==true}">
	<div class="row">
		<div class="span2c">
			<div class="form-row">
				<label><s:text name="label.request.originalBondAmount" />:</label>
			</div>
		</div>
		<div class="span3 left">
			<div class="form-row">
					<p class="padding40"><s:property value="requestDetails.rider.riderBondInformation.originalBondAmt" /></p>
					<s:hidden name="requestDetails.rider.riderBondInformation.originalBondAmt" id="originalBondAmtId" />				
			</div>
		</div>
	</div>

	<div class="row">
		<div class="span2c">
			<div class="form-row">
				<label><s:text name="label.request.currentBondAmount" />:</label>
			</div>
		</div>
		<div class="span3 left">
			<div class="form-row">			
					<p class="padding40"><s:property value="requestDetails.rider.riderBondInformation.currentBondAmt" /></p>
					<s:hidden name="requestDetails.rider.riderBondInformation.currentBondAmt" id="currentBondAmtId" />				
			</div>
		</div>
	</div>

	<div class="row">
		<div class="span12">
			<div class="radio-container">
				<s:radio theme="aloc" cssClass="radio amtIncDecRadio"
					id="instrumentOperationId" key="label.request.increaseDecrease"
					name="requestDetails.rider.riderBondInformation.operation"
					list="#{'INCREASE':'Increase','DECREASE':'Decrease'}"
					value="%{requestDetails.rider.riderBondInformation.operation}"
					/>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="span12">
			<div class="form-row">
				<s:textfield name="requestDetails.rider.riderBondInformation.amtOfIncreaseOrDecrease" key="label.amendment.amountIncreaseDecrease" id="amountIncDec" theme="aloc" maxlength="21" cssClass="bigDecimal">
				</s:textfield>&nbsp;&nbsp;&nbsp;<span class="hide" id="amountvalidationShow" style="color:red">Decrease amount should be less than current bond amount</span>
			
			</div>
		</div>
	</div>

	<div class="row">
		<div class="span2c">
			<div class="form-row">
				<label><s:text
						name="label.request.expectedRevisedBondAmount" />:</label>
			</div>
		</div>
		<div class="span3 left">
			<div class="form-row">
				<p class="padding40"><s:property value="requestDetails.rider.riderBondInformation.revisedBondAmt" /></p>				
				<s:hidden name="requestDetails.rider.riderBondInformation.revisedBondAmt" id="revisedBondAmt"/>
				<c:if test="${riderWorkFlowStage eq 'ANLAPROV'}">
				<s:hidden name="requestDetails.rider.riderWorkflowAmt" id="riderWorkflowAmt"/>
				</c:if>
			</div>
		</div>
	</div>

	<c:if test="${fn:replace(requestDetails.bondDetails.bondType, ' ', '') eq 'ContractBonds'}">
		<input type="hidden" value="true" id="contractBondID">
		<div class="row">
			<div class="span2c">
				<div class="form-row">
					<label><s:text name="label.request.originalPerformanceBondAmount" />:</label>
				</div>
			</div>
			<div class="span3 left">
				<div class="form-row">
					<p class="padding40"><s:property value="requestDetails.rider.riderBondInformation.originalContractAmt" /></p>
					<s:hidden name="requestDetails.rider.riderBondInformation.originalContractAmt" id="originalContractAmtId"/>
				</div>
			</div>
		</div>
	
		<div class="row">
			<div class="span2c">
				<div class="form-row">
					<label><s:text name="label.request.revisedPerformanceBondAmount" />:</label>
				</div>
			</div>
			<div class="span3 left">
				<div class="form-row">
					<p class="padding40"><s:property value="requestDetails.rider.riderBondInformation.revisedContractAmt" /></p>
					<s:hidden name="requestDetails.rider.riderBondInformation.revisedContractAmt" id="revisedContractAmtId"></s:hidden>
					<input type="hidden" value='<s:property value="requestDetails.bondInfo.performanceBondCurrencyCd" />' id="contractCurId"> 
				</div>
			</div>
		</div>
	
		<div class="row">
			<div class="span2c">
				<div class="form-row">
					<label><s:text name="label.request.revisedUSDPerformanceBondAmount" />:</label>
				</div>
			</div>
			<div class="span3 left">
				<div class="form-row">
					<p class="padding40"><s:property value="requestDetails.rider.riderBondInformation.revisedUSDEquiContractAmt" /></p>
					<s:hidden name="requestDetails.rider.riderBondInformation.revisedUSDEquiContractAmt" id="revisedUSDEquiContractAmtId"/>
				</div>
			</div>
			<span style="color:red"><s:fielderror fieldName="requestDetails.rider.riderBondInformation.revisedUSDEquiContractAmt"></s:fielderror></span>
		</div>
	</c:if>
	<c:if test="${fn:replace(requestDetails.bondDetails.bondType, ' ', '') ne 'ContractBonds'}">
		<input type="hidden" value="false" id="contractBondID">
	</c:if>
</s:if>
<s:elseif test="%{#isEditMode==false}">
	<div class="row">
		<div class="span160">
			<div class="form-row">
				<label><s:text name="label.request.originalBondAmount" />:</label>
			</div>
		</div>
		<div class="span3 left">
			<div class="form-row">
				<p class="padding40"><s:property value="requestDetails.rider.riderBondInformation.originalBondAmt" /></p>	
			</div>
		</div>
	</div>

	<div class="row">
		<div class="span160">
			<div class="form-row">
				<label><s:text name="label.request.currentBondAmount" />:</label>
			</div>
		</div>
		<div class="span3 left">
			<div class="form-row">
				<p class="padding40"><s:property value="requestDetails.rider.riderBondInformation.currentBondAmt" /></p>
				<s:hidden name="requestDetails.rider.riderBondInformation.currentBondAmt" id="currentBondAmtId" />	
			</div>
		</div>
	</div>
	
	<div class="row">
		<div class="span160">
			<div class="form-row">
				<c:if test="${requestDetails.rider.riderBondInformation.operation eq 'INCREASE' }">
				<label><s:text name="label.request.increase" />:</label>
				</c:if>
				<c:if test="${requestDetails.rider.riderBondInformation.operation eq 'DECREASE' }">
				<label><s:text name="label.request.decrease" />:</label>
				</c:if>
			</div>
		</div>
		<div class="span3 left">
			<div class="form-row">
				<p class="padding40"><s:property value="requestDetails.rider.riderBondInformation.amtOfIncreaseOrDecrease" /></p>
			</div>
		</div>
	</div>
	
	<div class="row">
		<div class="span160">
			<div class="form-row">
				<label><s:text
						name="label.request.expectedRevisedBondAmount" />:</label>
			</div>
		</div>
		<div class="span3 left">
			<div class="form-row">
				<p class="padding40"><s:property value="requestDetails.rider.riderBondInformation.revisedBondAmt" /></p>
				<s:hidden name="requestDetails.rider.riderBondInformation.revisedBondAmt" id="revisedBondAmt"/>
				<c:if test="${riderWorkFlowStage eq 'ANLAPROV'}">
				<s:hidden name="requestDetails.rider.riderWorkflowAmt" id="riderWorkflowAmt"/>
				</c:if>
			</div>
		</div>
	</div>

	<c:if test="${fn:replace(requestDetails.bondDetails.bondType, ' ', '') eq 'ContractBonds'}">
	<input type="hidden" value="true" id="contractBondID">
	<div class="row">
		<div class="span160">
			<div class="form-row">
				<label><s:text name="label.request.originalPerformanceBondAmount" />:</label>
			</div>
		</div>
		<div class="span3 left">
			<div class="form-row">
				<p class="padding40"><s:property value="requestDetails.rider.riderBondInformation.originalContractAmt" /></p>
				<s:hidden name="requestDetails.rider.riderBondInformation.originalContractAmt" id="originalContractAmtId"/>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="span160">
			<div class="form-row">
				<label><s:text name="label.request.revisedPerformanceBondAmount" />:</label>
			</div>
		</div>
		<div class="span3 left">
			<div class="form-row">
				<p class="padding40"><s:property value="requestDetails.rider.riderBondInformation.revisedContractAmt" /></p>
				<s:hidden name="requestDetails.rider.riderBondInformation.revisedContractAmt" id="revisedContractAmtId"></s:hidden>
				<input type="hidden" value='<s:property value="requestDetails.bondInfo.performanceBondCurrencyCd" />' id="contractCurId"> 
			</div>
		</div>
	</div>
	<div class="row">
		<div class="span160">
			<div class="form-row">
				<label><s:text name="label.request.revisedUSDPerformanceBondAmount" />:</label>
			</div>
		</div>
		<div class="span3 left">
			<div class="form-row">
				<p class="padding40"><s:property value="requestDetails.rider.riderBondInformation.revisedUSDEquiContractAmt" /></p>
				<s:hidden name="requestDetails.rider.riderBondInformation.revisedUSDEquiContractAmt" id="revisedUSDEquiContractAmtId"/>
			</div>
		</div>
	</div>
	</c:if>
	<c:if test="${fn:replace(requestDetails.bondDetails.bondType, ' ', '') ne 'ContractBonds'}">
		<input type="hidden" value="false" id="contractBondID">
	</c:if>
</s:elseif>