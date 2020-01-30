<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
&nbsp;
<c:if test="${param.includeScripts != false}">
<script	type="text/javascript">
$(document).ready(function() {
	setRevisedInsAmt();
	onLoadInstrumentOperation();
	onLoadAmountInWords();
	
});
</script>
</c:if>	
<s:set name="isEditMode" value="editMode"/>
	<s:if test="%{#isEditMode==true}">
	<c:if test="${param.pageSection == 'Current'}">
		<div class="row">
			<div class="span2a">
				<div class="form-row">
					<s:label key="label.amendment.origInstAmt"/>
				</div>
			</div>
			<div class="span2 left">
				<div class="form-row">
					<p class="padding40"><s:property value="requestDetails.amendment.amendmentInstrumentAmountCurr.currentInstrumentAmt"/></p>
					<s:hidden value="%{requestDetails.amendment.amendmentInstrumentAmountCurr.currentInstrumentAmt}" id="currentInstrumentAmt"/>
					
				</div>
			</div>
		</div>
		<div class="row">
			<div class="span5">
				<div class="form-row">
					<p id="currentInsAmountinWords"></p>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="span6">
				<div class="form-row">
				<label><s:text name="label.amendment.amountIncreaseDecrease" /></label>
				<div class="radio-container">
					<s:radio theme="aloc" cssClass="radio amtIncDecRadio"
						id="instrumentOperationId"
						name="requestDetails.amendment.amendmentInstrumentAmountCurr.operation"
						list="#{'INCREASE':'Increase','DECREASE':'Decrease'}"
						value="%{requestDetails.amendment.amendmentInstrumentAmountCurr.operation}"
						/>
				</div>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="span2a">
				<div class="form-row">
				<label>Amount of <span class="IncOrDec"></span>:</label>
				</div>
			</div>
			<div class="span3 left">
				<div class="form-row">
					<s:textfield name="requestDetails.amendment.amendmentInstrumentAmountCurr.amtOfIncreaseOrDecrease" id="amountIncDec" theme="aloc"></s:textfield>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="span2a">
				<div class="form-row">
					<s:label key="label.amendment.revisedAmt"/>
				</div>
			</div>
			<div class="span2 left">
				<div class="form-row">
					<p><s:property value="requestDetails.amendment.amendmentInstrumentAmountCurr.revisedInstrumentAmt"/></p>
					<s:hidden name="requestDetails.amendment.amendmentInstrumentAmountCurr.revisedInstrumentAmt" id="revisedInstrumentAmt"/>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="span5">
				<div class="form-row">
					<p id="revisedInsAmountinWords"></p>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="span2a">
				<div class="form-row">
					<s:label key="label.amendment.revisedUsdAmt"/>
				</div>
			</div>
			<div class="span2 left">
				<div class="form-row">
					<p><s:property value="requestDetails.amendment.amendmentInstrumentAmountCurr.revisedUSDEquiAmt"/></p>
					<s:hidden name="requestDetails.amendment.amendmentInstrumentAmountCurr.revisedUSDEquiAmt" id="revisedUSDEquiAmt"/>
					<s:hidden name="requestDetails.amendment.AMDWorkflowAmt" id="amdWorkflowAmt"/>
				</div>
			</div>
		<span style="color:red"><s:fielderror fieldName="requestDetails.amendment.amendmentInstrumentAmountCurr.revisedUSDEquiAmt"></s:fielderror></span>
		</div>
		<div class="row lastrow">
			<div class="span2a">
				<div class="form-row">
					<s:label key="label.amendment.newInstAmt"/>
			 		<s:select list="%{#attr['com.ge.aloc.MasterDataFactory'].currencies}" theme="aloc"
					listKey="currencyCode" listValue="currencyName"
					 name="requestDetails.amendment.amendmentInstrumentAmountCurr.newInstrumentCurrCode"
					headerKey="" headerValue="Select..." id="newInstCurrId"></s:select>
					<s:hidden name="requestDetails.amendment.amendmentInstrumentAmountCurr.newInstrumentCurr" id="newInstCurr"></s:hidden>
				</div>
			</div>
		</div><br>
		<div class="row usdEquivalentErrorDiv" style="display: none;">
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
	</c:if>
	<c:if test="${param.pageSection == 'Previous'}">
		<div class="row">
			<div class="span2a">
				<div class="form-row">
					<s:label key="label.request.increaseDecrease"/>
				</div>
			</div>
			<div class="span2 left">
				<div class="form-row">
					<p><s:property value="requestDetails.previousAmendment.amendmentInstrumentAmountCurr.operation"/></p>
				</div>
			</div>
		</div>
		<div class="row">
				<div class="clear"></div>
				<div class="span2a">
					<div class="form-row">
						<label>Amount of <c:if test="${requestDetails.previousAmendment.amendmentInstrumentAmountCurr.operation eq 'INCREASE' }">Increase</c:if><c:if test="${requestDetails.previousAmendment.amendmentInstrumentAmountCurr.operation eq 'DECREASE' }">Decrease</c:if> :</label>
					</div>
				</div>
				<div class="span2 left">
					<div class="form-row">
						<p><s:property value="requestDetails.previousAmendment.amendmentInstrumentAmountCurr.amtOfIncreaseOrDecrease"/></p>
					</div>
				</div>
			</div>
		
		<div class="row">
			<div class="span2a">
				<div class="form-row">
					<s:label key="label.amendment.revisedAmt"/>
				</div>
			</div>
			<div class="span2 left">
				<div class="form-row">
					<p><s:property value="requestDetails.previousAmendment.amendmentInstrumentAmountCurr.revisedInstrumentAmt"/></p>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="span2a">
				<div class="form-row">
					<s:label key="label.amendment.revisedUsdAmt"/>
				</div>
			</div>
			<div class="span2 left">
				<div class="form-row">
					<p><s:property value="requestDetails.previousAmendment.amendmentInstrumentAmountCurr.revisedUSDEquiAmt"/></p>
				</div>
			</div>
		</div>
		
	</c:if>
	</s:if>
	<s:elseif test="%{#isEditMode==false}" >
		<c:if test="${param.pageSection == 'Current'}">
			<div class="row">
				<div class="clear"></div>
				<div class="span2a">
					<div class="form-row">
						<s:label key="label.amendment.origInstrumentAmt"/>
					</div>
				</div>
				<div class="span2 left">
					<div class="form-row">
						<p><s:property value="requestDetails.amendment.amendmentInstrumentAmountCurr.originalInstrumentAmt"/></p>
						<s:hidden value="%{requestDetails.amendment.amendmentInstrumentAmountCurr.originalInstrumentAmt}" id="currentInstrumentAmt"/>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="clear"></div>
				<div class="span2a">
					<div class="form-row">
						<p id="currentInsAmountinWords"></p>
					</div>
				</div>
			
			</div>
			<div class="row">
				<div class="clear"></div>
				<div class="span2a">
					<div class="form-row">
						<s:label key="label.amendment.trAnalyst.currentInstrumentAmount"/>
					</div>
				</div>
				<div class="span2 left">
					<div class="form-row">
						<p><s:property value="requestDetails.amendment.amendmentInstrumentAmountCurr.currentInstrumentAmt"/></p>
					</div>
				</div>
			</div>
			<s:hidden name="requestDetails.amendment.amendmentInstrumentAmountCurr.operation" 
						value="%{requestDetails.amendment.amendmentInstrumentAmountCurr.operation}" id="instrumentOperationId"/>
			<div class="row">
				<div class="clear"></div>
				<div class="span2a">
					<div class="form-row">
						<label>Amount of <c:if test="${requestDetails.amendment.amendmentInstrumentAmountCurr.operation eq 'INCREASE' }">Increase</c:if><c:if test="${requestDetails.amendment.amendmentInstrumentAmountCurr.operation eq 'DECREASE' }">Decrease</c:if> :</label>
					</div>
				</div>
				<div class="span2 left">
					<div class="form-row">
						<p><s:property value="requestDetails.amendment.amendmentInstrumentAmountCurr.amtOfIncreaseOrDecrease"/></p>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="clear"></div>
				<div class="span2a">
					<div class="form-row">
						<s:label key="label.amendment.revisedAmt"/>
					</div>
				</div>
				<div class="span2 left">
					<div class="form-row">
						<p><s:property value="requestDetails.amendment.amendmentInstrumentAmountCurr.revisedInstrumentAmt"/></p>
						<s:hidden name="requestDetails.amendment.amendmentInstrumentAmountCurr.revisedInstrumentAmt" id="revisedInstrumentAmt"/>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="clear"></div>
				<div class="span5">
					<div class="form-row">
						<p id="revisedInsAmountinWords"></p>
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="clear"></div>
				<div class="span2a">
					<div class="form-row">
						<s:label key="label.amendment.revisedUsdAmt"/>
					</div>
				</div>
				<div class="span2 left">
					<div class="form-row">
						<p><s:property value="requestDetails.amendment.amendmentInstrumentAmountCurr.revisedUSDEquiAmt"/></p>
						<s:hidden name="requestDetails.amendment.amendmentInstrumentAmountCurr.revisedUSDEquiAmt" id="revisedUSDEquiAmt"/>
						<s:hidden name="requestDetails.amendment.AMDWorkflowAmt" id="amdWorkflowAmt"/>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="clear"></div>
				<div class="span2a">
					<div class="form-row">
						<s:label key="label.amendment.newInstAmt"/>
					</div>
				</div>
				<div class="span2 left">
					<div class="form-row">
						<p><s:property value="requestDetails.amendment.amendmentInstrumentAmountCurr.newInstrumentCurr"/></p>
						<s:hidden name="requestDetails.amendment.amendmentInstrumentAmountCurr.newInstrumentCurrCode" id="newInstCurrId"></s:hidden>
						
					</div>
				</div>
			</div>
		</c:if>
		<c:if test="${param.pageSection == 'Previous'}">
			<div class="row">
				<div class="span2a">
					<div class="form-row">
						<s:label key="label.request.increaseDecrease"/>
					</div>
				</div>
				<div class="span2 left">
					<div class="form-row">
						<p><s:property value="requestDetails.previousAmendment.amendmentInstrumentAmountCurr.operation"/></p>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="clear"></div>
				<div class="span2a">
					<div class="form-row">
						<label>Amount of <c:if test="${requestDetails.previousAmendment.amendmentInstrumentAmountCurr.operation eq 'INCREASE' }">Increase</c:if><c:if test="${requestDetails.previousAmendment.amendmentInstrumentAmountCurr.operation eq 'DECREASE' }">Decrease</c:if> :</label>
					</div>
				</div>
				<div class="span2 left">
					<div class="form-row">
						<p><s:property value="requestDetails.previousAmendment.amendmentInstrumentAmountCurr.amtOfIncreaseOrDecrease"/></p>
					</div>
				</div>
			</div>
			
			
			<div class="row">
				<div class="span2a">
					<div class="form-row">
						<s:label key="label.amendment.revisedAmt"/>
					</div>
				</div>
				<div class="span2 left">
					<div class="form-row">
						<p><s:property value="requestDetails.previousAmendment.amendmentInstrumentAmountCurr.revisedInstrumentAmt"/></p>
					</div>
				</div>
			</div>
			<div class="row">
			<div class="span2a">
				<div class="form-row">
					<s:label key="label.amendment.revisedUsdAmt"/>
				</div>
			</div>
			<div class="span2 left">
				<div class="form-row">
					<p><s:property value="requestDetails.previousAmendment.amendmentInstrumentAmountCurr.revisedUSDEquiAmt"/></p>
				</div>
			</div>
		</div>
		</c:if>
		
	</s:elseif>