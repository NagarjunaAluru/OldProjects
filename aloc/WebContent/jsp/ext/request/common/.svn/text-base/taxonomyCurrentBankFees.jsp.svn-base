<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${param.includeScripts != false}">
	<%@include file="/jsp/ext/common/includeCommonScripts.jsp" %>
</c:if>
<script src="${pageContext.request.contextPath}/ext/public/js/common/taxonomyCurrentBankFee.js" type="text/javascript"></script>

<s:if test="hasFieldErrors()">
	<div class="row">
		<div class="span12">
			<div class="errorbox">
				<div class="errorHead"><p class="erroricon"><s:text name="label.eas.common.error" /></p></div>
				<div class="errorContent"><p><s:fielderror/></p></div>
			</div>
		</div>
	</div>
</s:if>
<s:if test="hasActionMessages()">
	<div class="row">
		<div class="span12">
			<div class="errorbox">
				<div class="errorHead"><p class="erroricon"><s:text name="label.eas.common.error" /></p></div>
				<div class="errorContent"><p><s:actionmessage/></p></div>
			</div>
		</div>
	</div>
</s:if>

	<div class="form-mod">
		
		<div class="clear"></div>
	                    
		<!-- REQUEST SUMMARY -->
		<div id="requestSummary">
			<div class="leftColRS">
				<p><s:property value="comBidReplies.currentWinningBank.winningBankName" /></p>
				<s:hidden name="comBidReplies.currentWinningBank.winningBankName"/>
			</div>
			
			<div class="clear"></div>
	                        
			<div class="leftBoxRSBig">
				<div class="row smallrow">
					<div class="span2">
						<label><s:text name="label.request.issuingBankBranch" />:</label>
					</div>
					<div class="left" style="width: 350px;">
						<s:if test="%{comBidReplies.currentWinningBank.issuingBankBranch != '' && comBidReplies.currentWinningBank.issuingBankBranch != null}">
							<p><s:property value="comBidReplies.currentWinningBank.issuingBankBranch" /><br />
                                <s:iterator value="comBidReplies.currentWinningBank.addressDtls.address">
                                	<s:property /><br />
                                </s:iterator>
                                <s:property value="comBidReplies.currentWinningBank.addressDtls.city"/>&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="comBidReplies.currentWinningBank.addressDtls.stateProvince"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <s:property value="comBidReplies.currentWinningBank.addressDtls.ZIPPostalCode"/><br />
                                <s:property value="comBidReplies.currentWinningBank.addressDtls.country"/></p>
							<s:hidden name="comBidReplies.currentWinningBank.issuingBankBranch"/>
						</s:if>
						<s:else>
							<s:text name="label.request.hypen"/>
						</s:else>
					</div>
	                                
					<div class="span2">
						<label><s:text name="label.amendment.bankRefNo" /></label>
					</div>  
					<div class="span3 left">
						<s:if test="%{comBidReplies.currentWinningBank.bankReferenceNumber != '' && comBidReplies.currentWinningBank.bankReferenceNumber != null}">
							<s:property value="comBidReplies.currentWinningBank.bankReferenceNumber" />
							<s:hidden name="comBidReplies.currentWinningBank.bankReferenceNumber"/>
						</s:if>
						<s:else>
							<s:text name="label.request.hypen"/>
						</s:else>
					</div>  
				</div>
			</div><!-- leftBox ends here -->
		</div>
	                    
		<div class="row">
			<div class="span5a left">
				<h4 style="padding-top: -10px;"><s:text name="label.request.allInCommissions" /></h4>
				<a class="btn editBtnSmall" id="buttonSub"><s:text name="label.request.Edit" /></a>
	   						
				<div class="row smallrow">
					<div class="span2aa">
						<div class="form-row">
							<label><s:label key="label.request.allInCommissionsOpt"  theme="aloc"/></label>
						</div>
					</div>
					<div class="span2 left">
						<s:select headerKey="" headerValue="Select..." list="%{#attr['com.ge.aloc.StaticDataFactory'].pricingDetails}" 
								listKey="ID" listValue="name" name="comBidReplies.currentWinningBank.allinComissions.allinCommissionId" id="allInPricing"
								readonly="true"/>
					</div>
				</div>
				<div id="allInCommissionsValueDiv" style="display:none;">
					<div class="row smallrow">
						<div class="span2aa">
							<div class="form-row">
	                                <label>&nbsp;</label>
	                           </div>
						</div><!-- end of block -->
	                          <div class="span2 left">
							<s:textfield name="comBidReplies.currentWinningBank.allinComissions.allinCommissionValue" 
								id="allinCommValue" 
								readonly="true"
								maxlength="20"
							/>
						</div>
					</div> 
				</div>       
				<div class="row smallrow">
					<div class="span2aa">
						<div class="form-row">
							<label><s:label key="label.request.amendmentTransactionFee"/>
	                              <s:label key="label.request.feesForAmendment" theme="aloc"/> </label>
						</div>
					</div>
					<div class="span2 left">
						<div class="form-row">
							<s:textfield name="comBidReplies.currentWinningBank.allinComissions.amendmentTransactionFee" 
								id="amendmentTransactionFee1" 
								readonly="true"
								maxlength="20"
							/>
						</div>
					</div>
				</div>                                                                              
			</div>
	                    
			<div class="right" style="width: 410px;">
				<div class="row smallrow">
					<h4><s:text name="label.request.localCommissions" /></h4>
					<a class="btn editBtnSmall" id="buttonSub2"><s:text name="label.request.Edit" /></a>
									
		            <div class="row smallrow">
						<div class="span2aa">
							<div class="form-row">
								<label><s:label key="label.request.allInCommissionsOpt"  theme="aloc"/></label>
							</div>
						</div>
						<div class="span2 left">
							<s:select headerKey="" headerValue="Select..." list="%{#attr['com.ge.aloc.StaticDataFactory'].pricingDetails}" 
								listKey="ID" listValue="name" name="comBidReplies.currentWinningBank.localComissions.localCommissionId" id="localPricing"
								readonly="true"	/>
						</div>
					</div>
					<div id="localCommissionsValueDiv" style="display:none;">
						<div class="row smallrow">
							<div class="span2aa">
								<div class="form-row">
					        		<label>&nbsp;</label>
					    		</div>
							</div>
					        <div class="span2 left">
								<s:textfield name="comBidReplies.currentWinningBank.localComissions.localCommissionValue" 
									id="localCommValue" 
									readonly="true"
									maxlength="20"
								/>
							</div>
						</div> 
					</div> 
					<div class="row smallrow">
						<div class="span2aa">
							<div class="form-row">
							    <label><s:label key="label.request.amendmentTransactionFee" theme="aloc"/>
							   <s:label key="label.request.feesForAmendment" theme="aloc"/> </label>
							</div>
						</div>
						<div class="span2 left">
						    <div class="form-row">
						    	<s:textfield name="comBidReplies.currentWinningBank.localComissions.localAmendmentTransactionFee" 
									id="amendmentTransactionFee2" 
									readonly="true"
									maxlength="20"
								/>
						    </div>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<div class="clear"></div>
	                    
		<div class="span5a">
			<div class="row smallrow">
				<h4><s:text name="label.request.oneTimeFees" /></h4>
				<table class="table table-striped table-bordered sortable">
					<thead>
						<tr>
							<th><s:text name="label.request.feeType" /></th>
							<th><s:text name="label.request.cumulative" /></th>
							<th><s:text name="label.request.additionalAmount" /></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><s:text name="label.request.vatTaxesOptional" /></td>
							<td><s:if test="%{comBidReplies.cumulativeFeeAdjustments.VATCumulative == '' || comBidReplies.cumulativeFeeAdjustments.VATCumulative == null}">-</s:if>
								<s:else><s:property value="comBidReplies.cumulativeFeeAdjustments.VATCumulative" /></s:else>
								<input type="hidden" name="comBidReplies.cumulativeFeeAdjustments.VATCumulative" value="${comBidReplies.cumulativeFeeAdjustments.VATCumulative}" />
							</td>
							<td><s:textfield name="comBidReplies.cumulativeFeeAdjustments.VATAdditionalAmt" 
								id="vatAdditionalAmt"
								maxlength="20"
								cssClass="span2" />
							</td>
						</tr> 
						<tr>
							<td><s:text name="label.request.stampTaxesOptional" /></td>
							<td><s:if test="%{comBidReplies.cumulativeFeeAdjustments.stampCumulative == '' || comBidReplies.cumulativeFeeAdjustments.stampCumulative == null}">-</s:if>
	                            <s:else><s:property value="comBidReplies.cumulativeFeeAdjustments.stampCumulative" /></s:else>
								<input type="hidden" name="comBidReplies.cumulativeFeeAdjustments.stampCumulative" value="${comBidReplies.cumulativeFeeAdjustments.stampCumulative}" />
							</td>
							<td><s:textfield name="comBidReplies.cumulativeFeeAdjustments.stampAdditionalAmt" 
								id="stampAdditionalAmt"
								maxlength="20"
								cssClass="span2" />
							</td>
						</tr> 
						<tr>
							<td><s:text name="label.request.incidentAdminFeeOptional" /></td>
							<td><s:if test="%{comBidReplies.cumulativeFeeAdjustments.incidentalCumulative == '' || comBidReplies.cumulativeFeeAdjustments.incidentalCumulative == null}">-</s:if>
								<s:else><s:property value="comBidReplies.cumulativeFeeAdjustments.incidentalCumulative" /></s:else>
								<input type="hidden" name="comBidReplies.cumulativeFeeAdjustments.incidentalCumulative" value="${comBidReplies.cumulativeFeeAdjustments.incidentalCumulative}" />
							</td>
							<td><s:textfield name="comBidReplies.cumulativeFeeAdjustments.incidentalAdditionalAmt" 
								id="incidentalAdditionalAmt"
								maxlength="20"
								cssClass="span2" />
							</td>
						</tr> 
						<tr>
							<td><s:text name="label.request.otherFeesCharges" /></td>
							<td><s:if test="%{comBidReplies.cumulativeFeeAdjustments.otherCumulative == '' || comBidReplies.cumulativeFeeAdjustments.otherCumulative == null}">-</s:if>
	                            <s:else><s:property value="comBidReplies.cumulativeFeeAdjustments.otherCumulative" /></s:else>
	                            <input type="hidden" name="comBidReplies.cumulativeFeeAdjustments.otherCumulative" value="${comBidReplies.cumulativeFeeAdjustments.otherCumulative}" />
							</td>
							<td><s:textfield name="comBidReplies.cumulativeFeeAdjustments.otherAdditionalAmt" 
								id="otherAdditionalAmt"
								maxlength="20"
								cssClass="span2" />
							</td>
						</tr> 
					</tbody>
				</table>
			</div>
		</div>
		
	    <div class="right" style="width: 410px;">
			<div class="row smallrow">
				<h4><s:text name="label.request.postBidReplyFeeAdjustment" /></h4>
				<table class="table table-striped table-bordered sortable">
					<thead>
						<tr>
							<th><s:text name="label.request.feeType" /></th>
							<th><s:text name="label.request.cumulative" /></th>
	                       <th><s:text name="label.request.additionalAmount" /></th>
	                   </tr>
					</thead>
					<tbody>
	                   <tr>
	                      <td><s:text name="label.request.adjustments" /></td>
	                      <td><s:if test="%{comBidReplies.cumulativeFeeAdjustments.cumulativeAdjustmentAmt == '' || comBidReplies.cumulativeFeeAdjustments.cumulativeAdjustmentAmt == null}">-</s:if>
							  <s:else><s:property value="comBidReplies.cumulativeFeeAdjustments.cumulativeAdjustmentAmt" /></s:else>
							  <input type="hidden" name="comBidReplies.cumulativeFeeAdjustments.cumulativeAdjustmentAmt" value="${comBidReplies.cumulativeFeeAdjustments.cumulativeAdjustmentAmt}" />
	                      </td>
	                      <td><s:textfield name="comBidReplies.cumulativeFeeAdjustments.adjustmentAmt" 
								id="adjustmentAmt"
								maxlength="20"
								cssClass="span2" />
	                      </td>
	                   </tr> 
	               </tbody>
				</table>
			</div>
		</div>                    
		
		<div class="clear"></div>
	
		<div class="row">
			<div class="span12">
				<div class="form-row">
					<label><s:text name="label.request.comments" /></label>
					<s:textarea name="comBidReplies.currentWinningBank.winningBankComments" 
						id="winningBankComments" 
						rows="2" cols="50"
						cssClass="autosize messageinput"
						onkeypress="return imposeMaxLength(this, 399);"
					/>
					<div class="clear"></div>
					<div class="counter"><s:text  name="label.common.siteAdmin.fourHundred"/></div>
					<div class="counterTxt"><p class="guidance"><s:text  name="label.request.transferFeesCommentsSize"/></p></div>
				</div>
			</div>
		</div>
		
		 <h2 id="auditlog" class="section_flip section_blue acc_trigger3">
					<a href="javascript:;"><s:text name="label.request.bglocSectionName.16"/></a>
		</h2><hr class="h2-hr">
		<div id="auditlogPanel" class="section_panel acc_container3">
			<jsp:include page="/jsp/ext/request/common/taxonomyAuditLog.jsp" />
		</div>
	                    
		<div class="clear"></div>
	</div>
