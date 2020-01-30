<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${param.verify eq 'bidAward'}">
 <s:if test="%{requestDetails.preAgreedPricingDetails.oneTimeFeesDetails.acceptPricingDetailsFlag != null && requestDetails.preAgreedPricingDetails.oneTimeFeesDetails.acceptPricingDetailsFlag!=''}">
	 <div class="row">
					<div class="span2d">
						<div class="form-row">
							<label><s:text name="label.request.pricingDetailsAcceptedRejected" /></label>
						</div>
					</div>
					<div class="span5">
						<div class="form-row">
						  
							    <c:if test="${requestDetails.preAgreedPricingDetails.oneTimeFeesDetails.acceptPricingDetailsFlag eq 'Y'}">
							           <p class="padding40"><s:text name="label.request.accepted" /></p>
							    </c:if>
							    <c:if test="${requestDetails.preAgreedPricingDetails.oneTimeFeesDetails.acceptPricingDetailsFlag eq 'N'}">
							         <s:text name="label.request.rejected" />
							    </c:if>
							
						</div>
					</div>
	</div>
 </s:if>
</c:if>
<c:if test="${param.verify ne 'bidAward'}">
<p class="required-fields">
	<s:text name="label.request.common.allFieldsRequiredUnlessSpecified" />
</p>
</c:if>
<div class="row">
	<div class="span6">

		<h3>
			<s:text name="label.request.allInCommissions" />
		</h3>
		<div class="row">
			<div class="span3">
				<div class="form-row">
					<label><s:property
							value="requestDetails.preAgreedPricingDetails.allInCommissionsName" /></label>
				</div>
			</div>
			<div class="span3 left">
				<div class="form-row">
					<p>
						<s:property
							value="allInCommissionsValue" />
					</p>
				</div>
			</div>
			<!-- end of block -->
		</div>
	  <s:if test="%{requestDetails.preAgreedPricingDetails.allInAmmendmentTransactionFee != null && requestDetails.preAgreedPricingDetails.allInAmmendmentTransactionFee!=''}">
		<div class="row">
			<div class="span3">
				<div class="form-row">
					<label><s:text name="label.request.amendmentTransactionFee" /></label>
					<p>
						<s:text name="label.request.feesForAmendment" />
					</p>

				</div>
			</div>
			<div class="span3 left">
				<div class="form-row">
					<p>
						<s:property
							value="requestDetails.preAgreedPricingDetails.allInAmmendmentTransactionFee" />
					</p>
				</div>
			</div>
			<!-- end of block -->
		</div>
    </s:if>
	</div>

	<div class="span6 right">
		<h3>
			<s:text name="label.request.localCommissions" />
		</h3>
		<div class="row">
			<div class="span3">
				<div class="form-row">
					<label>
					<s:property
							value="requestDetails.preAgreedPricingDetails.localCommissionsName" />
					</label>
				</div>
			</div>
			<div class="span3 left">
				<div class="form-row">
					<p>
						<s:property
							value="localCommissionsValue" />
					</p>
				</div>
			</div>
			<!-- end of block -->
		</div>
	 <s:if test="%{requestDetails.preAgreedPricingDetails.localAmmendmentTransactionFee != null && requestDetails.preAgreedPricingDetails.localAmmendmentTransactionFee!=''}">
		<div class="row">
			<div class="span3">
				<div class="form-row">
					<label><s:text name="label.request.amendmentTransactionFee" /></label>
					<p>
						<s:text name="label.request.feesForAmendment" />
					</p>

				</div>
			</div>     
			<div class="span3 left">
				<div class="form-row">
					<p>
						<s:property
							value="requestDetails.preAgreedPricingDetails.localAmmendmentTransactionFee" />
					</p>
				</div>
			</div>
			<!-- end of block -->
		</div>
	</s:if>
	</div>
</div>
 <s:if test="%{(requestDetails.preAgreedPricingDetails.oneTimeFeesDetails.VATTaxes != null && requestDetails.preAgreedPricingDetails.oneTimeFeesDetails.VATTaxes!='') || (requestDetails.preAgreedPricingDetails.oneTimeFeesDetails.stampTaxes != null && requestDetails.preAgreedPricingDetails.oneTimeFeesDetails.stampTaxes!='') || 
 (requestDetails.preAgreedPricingDetails.oneTimeFeesDetails.incidentalAdminFee != null && requestDetails.preAgreedPricingDetails.oneTimeFeesDetails.incidentalAdminFee!='')|| (requestDetails.preAgreedPricingDetails.localAmmendmentTransactionFee != null && requestDetails.preAgreedPricingDetails.localAmmendmentTransactionFee!='')}">
<h3>
	<s:text name="label.request.oneTimeFees" />
</h3>
</s:if>
 <s:if test="%{requestDetails.preAgreedPricingDetails.oneTimeFeesDetails.VATTaxes != null && requestDetails.preAgreedPricingDetails.oneTimeFeesDetails.VATTaxes!=''}">
<div class="row">
	<div class="span3">
		<div class="form-row">
			<label><s:text name="label.request.vatTaxes" /></label>
		</div>
	</div>
	<div class="span3 left">
		<div class="form-row">
			<p>
				<s:property value="requestDetails.preAgreedPricingDetails.oneTimeFeesDetails.VATTaxes" />
			</p>
		</div>
	</div>
	<!-- end of block -->
</div>
</s:if>
 <s:if test="%{requestDetails.preAgreedPricingDetails.oneTimeFeesDetails.stampTaxes != null && requestDetails.preAgreedPricingDetails.oneTimeFeesDetails.stampTaxes!=''}">
<div class="row">
	<div class="span3">
		<div class="form-row">
			<label><s:text name="label.request.stampTaxes" /></label>
		</div>
	</div>
	<div class="span3 left">
		<div class="form-row">
			<p>
				<s:property value="requestDetails.preAgreedPricingDetails.oneTimeFeesDetails.stampTaxes" />
			</p>
		</div>
	</div>
	<!-- end of block -->
</div>
</s:if>
 <s:if test="%{requestDetails.preAgreedPricingDetails.oneTimeFeesDetails.incidentalAdminFee != null && requestDetails.preAgreedPricingDetails.oneTimeFeesDetails.incidentalAdminFee!=''}">
<div class="row">
	<div class="span3">
		<div class="form-row">
			<label><s:text name="label.request.incidentAdminFee" /></label>
		</div>
	</div>
	<div class="span3 left">
		<div class="form-row">
			<p>
				<s:property
					value="requestDetails.preAgreedPricingDetails.oneTimeFeesDetails.incidentalAdminFee" />
			</p>
		</div>
	</div>
	<!-- end of block -->
</div>
</s:if>
 <s:if test="%{requestDetails.preAgreedPricingDetails.oneTimeFeesDetails.other != null && requestDetails.preAgreedPricingDetails.oneTimeFeesDetails.other !=''}">
<div class="row">
	<div class="span3">
		<div class="form-row">
			<label><s:text name="label.request.otherC" /></label>
		</div>
	</div>
	<div class="span3 left">
		<div class="form-row">
			<p>
				<s:property value="requestDetails.preAgreedPricingDetails.oneTimeFeesDetails.other" />
			</p>
		</div>
	</div>
	<!-- end of block -->
</div>
</s:if>
<c:if test="${param.verify ne 'bidAward'}">
<s:if test="%{requestDetails.preAgreedPricingDetails!=null}">
<div class="row lastrow">
	<div class="span12">
		<div class="radio-container" id="ins">

			<s:radio theme="aloc" cssClass="radio"
				name="requestDetails.preAgreedPricingDetails.oneTimeFeesDetails.acceptPricingDetailsFlag"
				key="label.request.doYouAcceptThesePricingDetails"
				list="#{'Accept':'Accept','Reject':'Reject'}" id="priceDetailsFlag" />
		</div>
	</div>
</div>
<div class="row lastrow hide" id="rejection">
	<div class="span5">
		<div class="form-row">
			<s:textarea name="requestDetails.preAgreedPricingDetails.oneTimeFeesDetails.reasonForRejection"
				id="bidMemoComments" cssClass="autosize messageinput"
				key="label.request.rejectcomments" theme="aloc" onkeypress="return imposeMaxLength(this, 399);" />

			<div class="clear"></div>
			<div class="counter"><s:text name="label.request.fourHundred" /></div>
			<div class="counterTxt">
				<p class="guidance">
					<s:text name="label.request.textSize" />
				</p>
			</div>
		</div>
	</div>
	<div class="span5 left">
		<p>
			<br />
		</p>
	</div>
</div>
</s:if>
</c:if>
