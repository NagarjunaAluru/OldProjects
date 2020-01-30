<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

	<c:if test="${param.bidMemo != true}">
		<p class="required-fields">
			<s:text name="label.request.common.allFieldsRequiredUnlessSpecified"></s:text>
		</p>
	</c:if>
	
	<div class="row">
		<div class="span6">
			<div class="row">
				<div class="span6">
					<div class="form-row">
						<s:select headerKey="" headerValue="Select..." list="%{#attr['com.ge.aloc.StaticDataFactory'].pricingDetails}" 
							listKey="ID" listValue="name" name="requestDetails.pricingDetails.allInCommissionsId" id="allinPricing" key="label.request.allInCommissions" 
							theme="aloc"/>
					</div>
					
					<c:if test="${empty requestDetails.pricingDetails.allInCommissionsId}">
			        <c:set var="allInCommissionsValueDiv" value="hide"/>
		    		</c:if>
					<c:if test="${not empty requestDetails.pricingDetails.allInCommissionsId}">
					<c:set var="allInCommissionsValueDiv" value=""/>
					</c:if>
					
					<div class="${allInCommissionsValueDiv} allInCommissionsValueDiv" id="allInCommissionsValueDiv">
						<div class="row lastrow" style="margin-top: 20px !important;">
							<div class="span6">
								<div class="form-row">
									<label><span class="AllinVal"></span></label>
									<s:textfield name="allInCommissionsValue" 
										id="allinCommValue" 
										theme="aloc" cssClass="bigDecimal"
										maxlength="21"
									/>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="span6">
					<label class="optional"><s:text name="label.request.amendmentTransactionFee"></s:text> <br /> 
					</label>
					<s:text name="label.request.feesForAmendment"></s:text> <br/>
					<s:textfield name="requestDetails.pricingDetails.allInAmmendmentTransactionFee" 
							id="allinTransFee" 
							cssClass="span1a bigDecimal"
							theme="aloc"
							maxlength="21"
						/>
				</div>
			</div>
		</div>
		<div class="span6">
			<div class="row">
				<div class="span6">
					<div class="form-row">
						<s:select headerKey="" headerValue="Select..." list="%{#attr['com.ge.aloc.StaticDataFactory'].pricingDetails}" 
							listKey="ID" listValue="name" name="requestDetails.pricingDetails.localCommissionsId" id="localPricing" key="label.request.localCommissions"
							theme="aloc" />
						
					</div>
					
					<c:if test="${empty requestDetails.pricingDetails.localCommissionsId}">
			        <c:set var="localCommissionDiv" value="hide"/>
		    		</c:if>
					<c:if test="${not empty requestDetails.pricingDetails.localCommissionsId}">
					<c:set var="localCommissionDiv" value=""/>
					</c:if>
					
					<div class="${localCommissionDiv} localCommissionDiv" id="localCommissionDiv">
						<div class="row lastrow" style="margin-top: 20px !important;">
							<div class="span6">
								<div class="form-row">
									<label><span class="localVal"></span></label>
									<s:textfield name="localCommissionsValue" 
										id="localCommValue"
										theme="aloc" cssClass="bigDecimal"
										maxlength="21"
									/>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="span6">
					<label class="optional"><s:text name="label.request.amendmentTransactionFee"></s:text> <br /> 
					</label> 
					<s:text name="label.request.feesForAmendment"></s:text><br/>
					<s:textfield name="requestDetails.pricingDetails.localAmmendmentTransactionFee" 
							id="localTransFee" 
							cssClass="span1a bigDecimal"
							theme="aloc"
							maxlength="21"
						/>
						
				</div>
			</div>

		</div>
	</div>
	<!-- end of block -->
	<h3><s:text name="label.request.oneTimeFees"></s:text> </h3>
	<div class="row">
		<div class="span3">
			<div class="form-row">
				<s:textfield name="requestDetails.pricingDetails.oneTimeFeesDetails.VATTaxes" 
							key="label.request.vatTaxesOptional" 
							cssClass="span1a bigDecimal"
							required="false"
							theme="aloc"
							id="VATTaxes"
							maxlength="21"
						/>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="span3">
			<div class="form-row">
				<s:textfield name="requestDetails.pricingDetails.oneTimeFeesDetails.stampTaxes" 
							id="stampTax" 
							key="label.request.stampTaxesOptional"
							cssClass="span1a bigDecimal" 
							required="false"
							theme="aloc"
							maxlength="21"
						/>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="span3">
			<div class="form-row">
				<s:textfield name="requestDetails.pricingDetails.oneTimeFeesDetails.incidentalAdminFee" 
							id="incAdminFee" 
							key="label.request.incidentAdminFeeOptional"
							cssClass="span1a bigDecimal" 
							required="false"
							theme="aloc"
							maxlength="21"
						/>
			</div>
		</div>
	</div>
	<div class="row lastrow">
		<div class="span3">
			<div class="form-row">
				<s:textfield name="requestDetails.pricingDetails.oneTimeFeesDetails.other" 
							id="otherOneTime"
							cssClass="span1a bigDecimal" 
							key="label.request.otherOneTimeFees" 
							required="false"
							theme="aloc"
							maxlength="21"
						/>
			</div>
		</div>
	</div>
