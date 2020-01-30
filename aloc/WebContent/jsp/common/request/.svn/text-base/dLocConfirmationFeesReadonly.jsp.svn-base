<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${param.verify ne 'bidAward'}">
		<div class="row">
			<div class="span3">
				<div class="form-row">
					<label><s:text name="label.request.anumArrears" /></label>
				</div>
			</div>
			<div class="span3 left">
				<div class="form-row">
					<p><s:property value="requestDetails.preAgreedPricingDetails.allInPreAgreedPricingDetails.allInRatePAArrears" /></p>
				</div>
			</div>
			<!-- end of block -->
		</div>
		<div class="row">
			<div class="span3">
				<div class="form-row">
					<label><s:text name="label.request.anumAdvance" /></label>
				</div>
			</div>
			<div class="span3 left">
				<div class="form-row">
					<p><s:property value="requestDetails.preAgreedPricingDetails.allInPreAgreedPricingDetails.allInRatePAAdvance" /></p>
				</div>
			</div>
			<!-- end of block -->
		</div>
		<div class="row">
			<div class="span3">
				<div class="form-row">
					<label><s:text name="label.request.quarterArrears" /></label>
				</div>
			</div>
			<div class="span3 left">
				<div class="form-row">
					<p><s:property value="requestDetails.preAgreedPricingDetails.allInPreAgreedPricingDetails.allInRatePAAdvance" /></p>
				</div>
			</div>
			<!-- end of block -->
		</div>
		<div class="row">
			<div class="span3">
				<div class="form-row">
					<label><s:text name="label.request.quarterAdvance" /></label>
				</div>
			</div>
			<div class="span3 left">
				<div class="form-row">
					<p><s:property value="requestDetails.preAgreedPricingDetails.allInPreAgreedPricingDetails.allInRatePAAdvance" /></p>
				</div>
			</div>
			<!-- end of block -->
		</div>
		<div class="row">
	<div class="span3">
		<div class="form-row">
			<label><s:text name="label.request.otherC" /></label>
		</div>
	</div>
	<div class="span3 left">
		<div class="form-row">
			<p>
				<s:property value="requestDetails.oneTimeFeesDetails.other" />
			</p>
		</div>
	</div>
	<!-- end of block -->
</div>
</c:if>
<c:if test="${param.verify eq 'bidAward'}">
	<div class="row">
		<div class="span2">
			<label><s:text name="label.request.Instructions"/> :</label>
		</div>
		<div class="span8">
			<p><s:text name="label.request.otherinfo.instructions"/><br />
			   <s:text name="label.request.otherinfo.instructions1"/> <br />
			   <s:text name="label.request.NegotiationFee" />  <br />
			   <s:text name="label.request.DiscrepancyFee"/></p>
		</div>
	</div>
     <div class="row">
		<div class="span3">
			<div class="form-row">
				<label><s:property value="requestDetails.confirmationFees.feeStructureName" /> :</label>
			</div>
		</div>
		<div class="span3 left">
			<div class="form-row">
				<p> <c:out value="${requestDetails.confirmationFees.feeStructureValue}"/> </p>
			</div>
		</div>
		<!-- end of block -->
		
		<div class="span2">
			<div class="form-row">
				<label><s:text name="label.apm.otherFees" /> :</label>
			</div>
		</div>
		<div class="span3">
			<div class="form-row">
				<p>
					<s:property value="requestDetails.confirmationFees.otherFees" />
				</p>
			</div>
		</div>
	</div>
	<!-- end of block -->
</c:if>
		
		