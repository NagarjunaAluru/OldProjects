<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<s:set name="isEditMode" value="editMode"/>
<s:if test="%{#isEditMode==true || ((requestDetails.WFDetails.WFStage == 'REQEST' || requestDetails.WFDetails.WFStage == 'REQUEST'  && #attr.isTaxonomy != true) && requestDetails.instrumentRisk.requiresEdits == true)}">
<c:if test="${param.includeScripts != false}">
<script	type="text/javascript">
$(document).ready(function() {
	decCounter("complyCtrRqmt", 200);
	showHideNoOfDays();
	showHideComplyCtrRqmt();
	sendbackOnloadShow();
});

</script>
</c:if>
	   <s:if test="%{(requestDetails.WFDetails.WFStage == 'REQEST' || requestDetails.WFDetails.WFStage == 'REQUEST') && requestDetails.instrumentRisk.requiresEdits}">
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
								<c:out value="${requestDetails.instrumentRisk.sendBackNotes}" />
							</p>
						</div>
					</div>
				</div>
			</div>
		</s:if>	
		
		<div class="row">
			<div class="span12 mandatory">
					<s:radio cssClass="radio" 
					name="requestDetails.instrumentRisk.notiClauseFlag" 
					key="label.request.notificationInstrumentFormat" 
					theme="aloc" id="notiClauseFlag"
					tooltip="%{getText('label.request.tooltip.notificationInstrumentFormat')}" 
					list="#{'true':'Yes','false':'No'}"  value="%{requestDetails.instrumentRisk.notiClauseFlag}" />
				
			</div>
		</div>
		<div class="row">
			<div class="span12">
				
				
		<div class="form-row">
			<div class="radio-container derivativesConditional1 mandatory">
				<s:radio theme="aloc" cssClass="radio"
					name="requestDetails.instrumentRisk.curePeriodFlag" 
					key="label.request.periodInstrumentFormat" 
					tooltip="%{getText('label.request.tooltip.periodInstrumentFormat')}" 
					list="#{'true':'Yes'}"
					value="%{requestDetails.instrumentRisk.curePeriodFlag}"
					id="curePeriodFlag" />
				<div id="noOfDaysDiv">
					<div style="margin: 15px;">
						<s:textfield theme="aloc" name="requestDetails.instrumentRisk.curePeriodValue" 
						key="label.request.Numberofdaysincureperiod" 
						cssClass="span1a bigInt" 
						id="noOfDays" maxlength="50"/>
					</div>
				</div>
				<div class="clear"></div>
				<s:radio theme="aloc" cssClass="radio"
					name="requestDetails.instrumentRisk.curePeriodFlag" 
					list="#{'false':'No'}"
					value="%{requestDetails.instrumentRisk.curePeriodFlag}"
					id="curePeriodFlag" />
			</div>

		</div>
	</div>
			<!-- end of block -->
		</div>
		<div class="row">
			<div class="span12 mandatory">
					<s:radio theme="aloc" cssClass="radio" 
					name="requestDetails.instrumentRisk.drDownApprFlag" 
					key="label.request.instrumentformatDrawdown" id="drDownApprFlag"
					tooltip="%{getText('label.request.tooltip.instrumentformatDrawdown')}"
					list="#{'true':'Yes','false':'No'}"  value="%{requestDetails.instrumentRisk.drDownApprFlag}" />
			</div>
		</div>
		<div class="row">
			<div class="span12">
				
				<div class="form-row">
					<div class="radio-container derivativesConditional5 mandatory">
						<s:radio theme="aloc" cssClass="radio" 
						key="label.request.instrumentContractRequirements" 
					name="requestDetails.instrumentRisk.contrReqFlag" 
					list="#{'true':'Yes','false':'No'}"  value="%{requestDetails.instrumentRisk.contrReqFlag}" id="contrReqFlag"/>
					</div>
					<div id="complyCtrRqmtDiv">
						<div style="margin-top: 15px;">
							<s:textarea theme="aloc" name="requestDetails.instrumentRisk.contrReqReason" 
							cssClass="autosize2 messageinput" cols="50" rows="1" 
							key="label.request.complyCtrRqmt"
							id="complyCtrRqmt" onkeypress="return imposeMaxLength(this, 199);"></s:textarea>
							 <div class="clear"></div>
                            <div class="counter">200</div> <!-- fix positions -->
                            <div class="counterTxt"><p class="guidance"><s:text name="label.request.complyCtrRqmtCharcount" /></p></div>
						</div>
					</div>
				</div>
			</div>
			<!-- end of block -->
		</div>
		<script type="text/javascript">
			refreshSectionCount('instrumentRiskPanel');
		</script>
	</s:if>
	<s:elseif test="%{#isEditMode==false}">
	<s:hidden value="true" id="isIRReadonlyPage"/>
	 <div class="row" style="margin-bottom:5px!important;">

			</div>
			<div class="row">
				<div class="span44">
					<div class="form-row">
						<label><s:text name="label.request.notificationclause"/>:</label>
					</div>
				</div>
				<s:if test="%{requestDetails.instrumentRisk.notiClauseFlag}">
					<div class="span5 left">
					<div class="form-row">
						<p class="padding40"><s:text name="label.request.common.yes" /></p>
					</div>
				</div>
				</s:if>
				<s:else>
					<div class="span5 left">
					<div class="form-row">
						<p class="padding40"><s:text name="label.request.common.no" /></p>
					</div>
				</div>
				</s:else>
				
			</div>
			<div class="row">
				<div class="span44">
					<div class="form-row">
						<label><s:text name="label.request.cureperiod"/>:</label>
					</div>
				</div>
				<s:if test="%{requestDetails.instrumentRisk.curePeriodFlag}">
					<div class="span5 left">
					<div class="form-row">
						<p class="padding40"><s:text name="label.request.common.yes" /></p>
					</div>
					</div>
				</s:if>
				<s:else>
					<div class="span5 left">
					<div class="form-row">
						<p class="padding40"><s:text name="label.request.common.no" /></p>
					</div>
				</div>
				</s:else>
			</div>
			<s:if test="%{requestDetails.instrumentRisk.curePeriodFlag}">
				<div class="row">
				<div class="span12">
				<div class="row lastrow">
					<div class="span44">
						<div class="form-row">
							<label><s:text name="label.request.Numberofdaysincureperiod"/>:</label>
						</div>
					</div>
					<div class="span5 left">
						<div class="form-row">
							<p class="padding40"><c:out value="${requestDetails.instrumentRisk.curePeriodValue}"/></p>
						</div>
					</div>
				</div>
				</div>
				</div>
			</s:if>
			<div class="row">
				<div class="span44">
					<div class="form-row">
						<label><s:text name="label.request.geapprovalpriorDrawdown"/>:</label>
					</div>
				</div>
				<s:if test="%{requestDetails.instrumentRisk.drDownApprFlag}">
					<div class="span5 left">
					<div class="form-row">
						<p class="padding40"><s:text name="label.request.common.yes" /></p>
					</div>
					</div>
				</s:if>
				<s:else>
					<div class="span5 left">
					<div class="form-row">
						<p class="padding40"><s:text name="label.request.common.no" /></p>
					</div>
				</div>
				</s:else>
				
			</div>
			<div class="row">
				<div class="span44">
					<div class="form-row">
						<label><s:text name="label.request.contractRequirements"/>:</label>
					</div>
				</div>
				<s:if test="%{requestDetails.instrumentRisk.contrReqFlag}">
					<div class="span5 left">
					<div class="form-row">
						<p class="padding40"><s:text name="label.request.common.yes" /></p>
					</div>
					</div>
				</s:if>
				<s:else>
					<div class="span5 left">
					<div class="form-row">
						<p class="padding40"><s:text name="label.request.common.no" /></p>
					</div>
				</div>
				</s:else>
			</div>
			<s:if test="%{requestDetails.instrumentRisk.contrReqFlag == false}">
			<div class="row">
			<div class="span12">
			<div class="row lastrow">
				<div class="span44">
					<div class="form-row">
						<label><s:text name="label.request.expaninnotcomply"/>:</label>
					</div>
				</div>
				<div class="span7 left">
					<div class="form-row">
						<p class="padding40" style="word-wrap:break-word;">
						<c:out value="${requestDetails.instrumentRisk.contrReqReason}"/></p>
					</div>
				</div>
			</div>
			</div>
			</div>
			</s:if>
	
	</s:elseif>	
		
