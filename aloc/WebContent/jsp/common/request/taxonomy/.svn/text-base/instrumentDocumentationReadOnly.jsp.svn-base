<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="hwfs"  uri="/hwf-security-tags" %>
<s:url action="cancel.action" namespace="/int/approver" var="cancelBtnlURL"/>   
<div style="padding-right: 40px;">
 <c:if test="${requestDetails.instrumentTypeId eq '1' || requestDetails.instrumentTypeId eq '2'||requestDetails.instrumentTypeId eq '3' || requestDetails.instrumentTypeId eq '5'|| requestDetails.instrumentTypeId eq '6'}">
   <h2><s:text name="label.request.uploadOfInstrumentDocumentation" /></h2><hr class="h2-hr">
</c:if>
<c:if test="${requestDetails.instrumentTypeId eq '4'}">
   <h2><s:text name="label.request.docUpload" /></h2><hr class="h2-hr">
</c:if>
	<div class="row">
		<div class="span12">
		 <p>&nbsp;</p>		
		 <c:if test="${not empty sessionScope.historicalTab}" >	
		 <div id="issuanceAttachmentRefresh">
		 <jsp:include page="/jsp/common/request/taxonomy/transactionHistoryIssuanceAttachments.jsp"/> 
		 </div>
		 <c:if test="${(requestDetails.instrumentTypeId eq '3') || (requestDetails.instrumentTypeId eq '6') }">
	            <h2><s:text name="label.request.fees" /></h2><hr class="h2-hr">
						<div class="row">
							<div class="span12">
								<label><s:text name="label.request.Premiumfees-optional" /></label>
								<s:textfield name="requestDetails.feesDetails.premiumFees" theme="aloc" cssClass="bigDecimal" maxlength="21"/> 
							</div>
					 </div>
					 
					 <c:if test="${(requestDetails.instrumentTypeId eq '6')}">
						   <div class="row">
								<div class="span12">
									<label><s:text name="label.request.additionalFeesSurchargesOptional" /></label>
									<s:textfield name="requestDetails.additionalFees" theme="aloc" cssClass="bigDecimal" maxlength="21"/>
								</div>
						   </div>
					</c:if> 
						<div class="row">
							<div class="span12">
								<label><s:text name="label.request.ChargeforRider-optional" /></label>
								<s:textfield name="requestDetails.feesDetails.chargeForRider" theme="aloc" cssClass="bigDecimal" maxlength="21"/>
							</div>
						</div>
						<div class="row">
						  <c:if test="${(requestDetails.instrumentTypeId eq '3') || (requestDetails.instrumentTypeId eq '6') }">
								<div class="span12">
									<label><s:text name="label.request.totalPremium" /> <s:text name="label.request.optional"/> </label>
									<s:textfield name="requestDetails.feesDetails.totoalPremium" theme="aloc" cssClass="bigDecimal" maxlength="21"/>
								</div>
						  </c:if> 
						</div>	
	     </c:if>
		 </c:if>
		 <c:if test="${empty sessionScope.historicalTab}" >
		 <div id="issuanceAttachmentRefresh">
		   <jsp:include page="/jsp/common/request/taxonomy/issuanceAttachmentsReadOnly.jsp"/>  			                  								
		 </div>	   
		 </c:if>   			 
	    </div>  
	</div> 
</div>
<div class="float-container">
		<div class="row">
		<div class="span12"> 
		    <h3><s:text name="label.request.outputmment"/></h3>	
			<div class="row">
				<div class="span5">
				    <label><s:text name="label.request.reasonForOptingout"/></label>
					<s:textarea cssClass="autosize messageinput" name="requestDetails.actionDetails.reasonForOptingOut" onkeypress="return imposeMaxLength(this, 399);" theme="aloc"/>							
					<div class="clear"></div>
	                <div class="counter">400</div> <!-- fix positions -->
	                <div class="counterTxt"><p class="guidance"><s:text  name="label.request.characters"/></p></div>
				</div>
			</div>
		</div>
	</div>
</div>