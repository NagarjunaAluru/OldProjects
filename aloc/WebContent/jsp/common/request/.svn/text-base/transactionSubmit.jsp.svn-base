<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
		
		<c:if test="${requestDetails.instrumentTypeId eq '1' || requestDetails.instrumentTypeId eq '2' || requestDetails.instrumentTypeId eq '3'}">
		<div class="row">
			<div class="span12">
				<div>
					<s:radio cssClass="radio" name="actionType" id="completeTransactionId"
						list="#{'20':'Complete transaction','21':'Decline transaction'}"
						theme="aloc" />
						  
				</div>
			</div>
		</div>
		</c:if>
		<c:if test="${requestDetails.instrumentTypeId eq '4'}">
		<div class="row">
			<div class="span12">
				<div>
					<s:radio cssClass="radio" name="actionType" id="bankagreeId"
						list="#{'22':'Bank agrees to confirmation','23':'Bank declines confirmation'}"
						theme="aloc" />  
				</div>
			</div>
		</div>
		</c:if>
		<c:if test="${requestDetails.instrumentTypeId eq '5'}">
		<div class="row">
			<div class="span12">
				<div>
					<s:radio cssClass="radio" name="actionType" id="completeAmendmentId"
						list="#{'24':'Complete Amendment','25':'Reject Amendment'}"
						theme="aloc" />  
				</div>
			</div>
		</div>
		</c:if>
		<c:if test="${requestDetails.instrumentTypeId eq '6'}">
		<div class="row">
			<div class="span12">
				<div>
					<s:radio cssClass="radio" name="actionType" id="completeRiderId"
						list="#{'26':'Complete Rider','27':'Reject Rider'}"
						theme="aloc" />  
				</div>
			</div>
		</div>
		</c:if>
		<div class="clear"></div>
		<div class="row hide" id="decline">
			<div class="span8">
			<p class="required-fields" style="margin-left:380px!important;"><s:text name="label.request.common.allFieldsRequiredUnlessSpecified"/></p>
			<div class="clear"></div>
			<c:if test="${requestDetails.instrumentTypeId eq '1' || requestDetails.instrumentTypeId eq '2' || requestDetails.instrumentTypeId eq '3' || requestDetails.instrumentTypeId eq '4'}">
				<div class="row highlighted">
					<div class="span7">
						<p style="padding:10px;"><b><s:text name="label.request.note"/>:</b> <s:text name="label.request.transactionSubmitLine"/></p>
					</div>
				</div>
			</c:if>
				<div class="row">
					<div class="span12">
						<label><span id="rejectReasonSpan"><s:text name="label.request.reasonForDecline"/></span></label>
						<s:textarea	name="requestDetails.actionDetails.reasonForRejection" onkeypress="return imposeMaxLength(this, 399);"
						 theme="aloc" id="declineReason" cssClass="autosize messageinput" />
						<div class="clear"></div>
						<div class="counter">400</div> <!-- fix positions -->
						<div class="counterTxt"><p class="guidance"><s:text name="label.request.textSize"/></p></div>
					</div>
					<div class="span2 left">
						<p><br /></p>
						<!--<p>Error message</p>-->
					</div>
				</div>
			</div>
		</div>
		<div class="clear"></div>
		<div class="row highlighted">
            <div class="span12">
			    <div class="form-row" style="margin-left:0px;">
                   <s:submit key="label.request.submitDecline" action="issuerSubmit" cssClass="btn-primary" />
					<a href="#" class="btn-tertiary cancel"><s:text name="label.request.common.cancel"/></a>   
                </div>
            </div> <!-- end of block -->
		</div><!-- end of form form-mod -->
