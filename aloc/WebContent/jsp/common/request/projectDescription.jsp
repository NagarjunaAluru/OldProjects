<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<s:set name="isEditMode" value="editMode"/>
<s:if test="%{#isEditMode==true || ((requestDetails.WFDetails.WFStage == 'REQEST' || requestDetails.WFDetails.WFStage == 'REQUEST'  && #attr.isTaxonomy != true) && requestDetails.projDescription.requiresEdits == true)}">
<c:if test="${param.includeScripts != false}">
<script	type="text/javascript">
$(document).ready(function() {
	decCounter("projDesc", 400);
	 bidUsdEquivalent();
	 sendbackOnloadShow();
});

</script>
</c:if>	
        <s:if test="%{(requestDetails.WFDetails.WFStage == 'REQEST' || requestDetails.WFDetails.WFStage == 'REQUEST') && requestDetails.projDescription.requiresEdits}">
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
								<c:out value="${requestDetails.projDescription.sendBackNotes}" />
							</p>
						</div>
					</div>
				</div>
			</div>
		</s:if>
						
		<div class="row">
			<div class="span12">
				<div class="form-row">
					<div class="textareaCounter"></div>
					<s:textarea name="requestDetails.projDescription.projDesc" 
						theme="aloc" onkeypress="return imposeMaxLength(this, 399);"
						key="label.request.ProjectDescription" 
						tooltip="%{getText('label.request.tooltip.projectDescription')}" 
						cssClass="autosize messageinput mandatory" id="projDesc"/>
					 <div class="clear"></div>
                     <div class="counter">400</div> <!-- fix positions -->
                     <div class="counterTxt"><p class="guidance"><s:text name="label.request.textSize" /></p></div>
					
				</div>
			</div>
		</div>
		<div class="row">
			<div class="span12">
				<div class="form-row">
						<s:textfield name="requestDetails.projDescription.bidDt" 
							cssClass="date" 
							id="bidDt" 
							key="label.request.Biddate" 
							required="false"
							theme="aloc"
						/>
					   <p class="guidance"><s:text name="label.request.dateFormat" /></p>
				</div>
			</div>
		</div>
		<!-- end of block -->
		<div class="row">
			<div class="span12">
				<div class="form-row">
					<s:textfield name="requestDetails.projDescription.bidProposalNo" 
							id="bidProposalNo" 
							key="label.request.Bidnumber" 
							required="false"
							theme="aloc" 
							maxlength="50" 
						/>	
				</div>
			</div>
		</div>
		<div class="row">
			<div class="span12">
				<div class="form-row">
					<s:textfield name="requestDetails.projDescription.contractNo" 
							id="contractNo"
							key="label.request.Contractnumber" 
							required="false"
							theme="aloc" 
							maxlength="50"
						/>
				</div>
			</div>
			<!-- end of block -->
		</div>
		<div class="row">
			<div class="span12">
				<div class="form-row">
						<s:textfield name="requestDetails.projDescription.contractDt" 
							id="contractDt" 
							cssClass="date"
							key="label.request.Contractdate" 
							required="false"
							theme="aloc"
						/>
					  <p class="guidance"><s:text name="label.request.dateFormat" /></p>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="span12">
				<div class="form-row">
					<sj:autocompleter key="label.request.BidContractCurrency" id="bidCurrId" parentTheme="aloc" 
					list="%{#attr['com.ge.aloc.MasterDataFactory'].currencies}" 
					name="requestDetails.projDescription.bidCurrCd" cssClass="span3 mandatory" 
					listKey="currencyCode" listValue="currencyName" onChangeTopics="getCurrencyAutocompleterName,getUSDConversion" maxlength="100"/>
					<p class="guidance">
						Search for currency
					</p>
					<s:hidden name="requestDetails.projDescription.bidCurrName" 
							id="bidCurrName" cssClass="autoCompleterName"></s:hidden>
				</div>
			</div>
		</div>
		<!-- end of block -->
		<div class="row">
			<div class="span12">
				<div class="form-row">
					<s:textfield name="requestDetails.projDescription.bidContractAmt" 
							id="bidContractAmt" 
							key="label.request.BidContractAmount" 
							cssClass="currencyAmt mandatory bigDecimal" 
							theme="aloc" maxlength="21"/>
				</div>
				
			</div>
			
			
		</div>
		
			<div class="row " id="usdEquivalentDiv" style="display: none">
				
				<div class="targetUsd form-row span5">
					<p style="padding: 5px; margin-top: 3px;" id="bidUSDEquivalent" class="defaultFontSize">
						<b><s:text name="label.request.USDbidContractAmount"/></b>
						<span ><s:property value="requestDetails.projDescription.bidUSDEquivalent"/></span>
					<img alt="Loading..." id="bidUSDProcess" 
					src="${pageContext.request.contextPath}/img/loading.gif" class="indicator">
					</p>
					<s:hidden id="bidUSDEquivalentAmount" name="requestDetails.projDescription.bidUSDEquivalent" value="%{requestDetails.projDescription.bidUSDEquivalent}"></s:hidden>
				</div>
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
		<!-- end of block -->
	  	<script type="text/javascript">
			refreshSectionCount('projectDescriptionPanel');
		</script>
	  
	</s:if>
	<s:elseif test="%{#isEditMode==false}">
	
	<c:if test="${param.page ne 'BGBidReply'}">
		<div class="row">
				<div class="span44">
					<div class="form-row">
						<label><s:text name="label.request.ProjectDescription"/>:</label>
					</div>
				</div>
				<div class="span5 left">
					<div class="form-row">
						<p class="padding40" style="word-wrap:break-word;"><c:out value="${requestDetails.projDescription.projDesc}"/></p>
					</div>
				</div>
			</div> 
	</c:if>
			<div class="row">
				<div class="span44">
					<div class="form-row">
						<label><s:text name="label.request.Biddate"/>:</label>
					</div>
				</div>
				<div class="span5 left">
					<div class="form-row">
						<p class="padding40"><s:property value="requestDetails.projDescription.bidDt"/></p>
					</div>
				</div>
			</div>
	
            
            
			<div class="row">
				<div class="span44">
					<div class="form-row">
						<label><s:text name="label.request.Bidnumber"/>:</label>
					</div>
				</div>
				<div class="span5 left">
					<div class="form-row">
						<p class="padding40"><c:out value="${requestDetails.projDescription.bidProposalNo}"/></p>
					</div>
				</div>
			</div> 
			<div class="row">
				<div class="span44">
					<div class="form-row">
						<label><s:text name="label.request.Contractnumber"/>:</label>
					</div>
				</div>
				<div class="span5 left">
					<div class="form-row">
						<p class="padding40"><c:out value="${requestDetails.projDescription.contractNo}"/></p>
					</div>
				</div>
			</div> 
            
            
			<div class="row">
				<div class="span44">
					<div class="form-row">
						<label><s:text name="label.request.Contractdate"/>:</label>
					</div>
				</div>
				<div class="span5 left">
					<div class="form-row">
						<p class="padding40"><s:property value="requestDetails.projDescription.contractDt"/></p>
					</div>
				</div>
			</div> 
            
            
			<div class="row">
				<div class="span44">
					<div class="form-row">
						<label><s:text name="label.request.BidContractCurrency"/>:</label>
					</div>
				</div>
				<div class="span5 left">
					<div class="form-row">
						<p class="padding40"><c:out value="${requestDetails.projDescription.bidCurrName}"/></p>
					</div>
				</div>
			</div> 
            
            
			<div class="row">
				<div class="span44">
					<div class="form-row">
						<label><s:text name="label.request.BidContractAmount"/>:</label>
					</div>
				</div>
				<div class="span5 left">
					<div class="form-row">
						<p class="padding40"><s:property value="requestDetails.projDescription.bidContractAmt"/></p>
					</div>
				</div>
			</div> 

			<div class="row">
				<div class="span44">
					<div class="form-row">
						<label><s:text name="label.request.USDbidContractAmount"/></label>
					</div>
				</div>
				<div class="span5 left">
					<div class="form-row">
						<p class="padding40"><s:property value="requestDetails.projDescription.bidUSDEquivalent"/></p>
					</div>
				</div>
			</div>
			<s:hidden id="bidUSDEquivalentAmount" name="requestDetails.projDescription.bidUSDEquivalent" value="%{requestDetails.projDescription.bidUSDEquivalent}"></s:hidden>
	</s:elseif>
