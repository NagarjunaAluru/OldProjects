<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="hwfs"  uri="/hwf-security-tags" %>
<s:url action="cancel.action" namespace="/int/approver" var="cancelBtnlURL"/>   
<div class="fixed-container" style="padding-right: 40px;">
 <c:if test="${requestDetails.instrumentTypeId eq '1' || requestDetails.instrumentTypeId eq '2'||requestDetails.instrumentTypeId eq '3' || requestDetails.instrumentTypeId eq '5'|| requestDetails.instrumentTypeId eq '6'}">
   <h2><s:text name="label.request.uploadOfInstrumentDocumentation" /></h2><hr class="h2-hr">
</c:if>
<c:if test="${requestDetails.instrumentTypeId eq '4'}">
   <h2><s:text name="label.request.docUpload" /></h2><hr class="h2-hr">
</c:if>
	<div class="row">
		<div class="span12">
		 <p>&nbsp;</p>		
		 <div id="issuanceAttachmentRefresh">		  			                  						
		 <jsp:include page="/jsp/common/issuanceAttachmentRefresh.jsp" />
		 </div>	      			  
	     <c:if test="${(requestDetails.instrumentTypeId eq '3') || (requestDetails.instrumentTypeId eq '6') }">
	            <h2><s:text name="label.request.fees" /></h2><hr class="h2-hr">
						<div class="row">
							<div class="span12">
								<label><s:text name="label.request.Premiumfees-optional" /></label>
								<s:textfield name="requestDetails.feesDetails.premiumFees" cssClass="bigDecimal" theme="aloc" maxlength="21"/> 
							</div>
					 </div>
					 
					 <c:if test="${(requestDetails.instrumentTypeId eq '6')}">
						   <div class="row">
								<div class="span12">
									<label><s:text name="label.request.additionalFeesSurchargesOptional" /></label>
									<s:textfield name="requestDetails.additionalFees" cssClass="bigDecimal" theme="aloc" maxlength="21"/>
								</div>
						   </div>
					</c:if> 
						<div class="row">
							<div class="span12">
								<label><s:text name="label.request.ChargeforRider-optional" /></label>
								<s:textfield name="requestDetails.feesDetails.chargeForRider" cssClass="bigDecimal" theme="aloc" maxlength="21"/>
							</div>
						</div>
						<div class="row">
						  <c:if test="${(requestDetails.instrumentTypeId eq '3') || (requestDetails.instrumentTypeId eq '6') }">
								<div class="span12">
									<label><s:text name="label.request.totalPremium" /> <s:text name="label.request.optional"/></label>
									<s:textfield name="requestDetails.feesDetails.totoalPremium" cssClass="bigDecimal" theme="aloc" maxlength="21"/>
								</div>
						  </c:if> 
						</div>	
	     </c:if>
	    </div>  
	</div> 
	
	<div class="row">
            <div class="span12 request-summary">
            <hwfs:checkComponentPermission name="NotBankBrokerReadOnly" domainName="BusinessAccess">
			       <c:if test="${requestDetails.instrumentTypeId eq '1' || requestDetails.instrumentTypeId eq '2'}">
			       		  <s:submit key="label.request.completeIssuance" cssClass="btn-primary" onclick="submitAction(22)"></s:submit>
			              <%-- <a href="#completeRequest" data-toggle="modal" class="btn-primary"><s:text name="label.request.completeIssuance"/></a> --%>
                    </c:if>
                   <c:if test="${requestDetails.instrumentTypeId eq '3'}">
                   		   <s:submit key="label.request.completesurety" cssClass="btn-primary" onclick="submitAction(22)"></s:submit>
                           <%-- <a href="#completeRequest" data-toggle="modal" class="btn-primary"><s:text name="label.request.completesurety" /></a> --%>
                    </c:if>
                    <c:if test="${requestDetails.instrumentTypeId eq '4'}">
                    	<s:submit key="label.request.Complete" cssClass="btn-primary" onclick="submitAction(22)"></s:submit>                        
                    </c:if>
                     <c:if test="${requestDetails.instrumentTypeId eq '5'}">
                           <%-- <a href="#completeRequest" data-toggle="modal" class="btn-primary"><s:text name="label.request.Completeamendment" /></a> --%>
                           <s:submit key="label.request.Completeamendment" cssClass="btn-primary" onclick="submitAction(22)"></s:submit>
                      </c:if>
                     <c:if test="${requestDetails.instrumentTypeId eq '6'}">
                           <%-- <a href="#completeRequest" data-toggle="modal" class="btn-primary"><s:text name="label.request.Completeamendment" /></a> --%>
                           <s:submit key="label.request.Completerider" cssClass="btn-primary" onclick="submitAction(22)"></s:submit>
                    </c:if>	
             </hwfs:checkComponentPermission>	
					<a href="#" class="btn-tertiary cancel clearEntries" data-toggle="modal" ><s:text name="label.request.common.cancel"/></a>					   
           </div>
   </div> <!-- end of block -->
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
	
    <div class="clear"></div>
			<div class="row">
                <div class="span12 request-summary">
				    <div class="form-row">
				    <hwfs:checkComponentPermission name="NotBankBrokerReadOnly" domainName="BusinessAccess">
				        <s:submit key="label.request.optOut" cssClass="btn-primary" onclick="submitAction(10)">
			            </s:submit>
			        </hwfs:checkComponentPermission>
				         <s:url id="homePageURL" action="cancel" namespace="/int/approver"/>
						<s:a href="%{homePageURL}" key="label.request.common.cancel" cssClass="btn-tertiary cancel" ><s:text name="label.request.common.cancel"></s:text></s:a>  
                    </div>
                </div> 
	</div>
</div>

<div class="exit-container">
     <div class="row">
                <div class="span12 request-summary">
				    <div class="form-row">
				        <s:url id="homePageURL" action="cancel" namespace="/int/approver"/>
				        <s:a href="%{homePageURL}" key="label.request.Exit" cssClass="btn-primary cancel" ><s:text name="label.request.Exit"></s:text></s:a>  
                        <s:a href="%{homePageURL}" key="label.request.common.cancel" cssClass="btn-tertiary cancel" ><s:text name="label.request.common.cancel"></s:text></s:a>  
                    </div>
                </div> 
	</div>
</div>
	
<!-- Complete REQUEST ISSUANCE POPUP WINDOW -->
<div class="modal hide fade" id="completeIssuanceRequest">
<s:hidden id="completeIssuanceTextAreaId" name="completeIssuanceTextAreaId" value=""/>
<s:hidden id="issuanceGeLibFileId" name="issuanceGeLibFileId" value="" />
<s:hidden id="issuanceTypeId" name="issuanceTypeId" value="" />
<s:hidden id="issuanceIndexId" name="issuanceIndexId" value="" />
		<div class="modal-header"> 
			<a class="close" data-dismiss="modal">X</a>
			<h3><span><s:text name="label.request.thisActionCannotbeUndone"/> </span></h3>
		</div>
		<div class="modal-body">		
		<p><s:text name="label.request.issuanceTextAreaConfirm"/></p>
           
           <h3><s:text name="label.request.thisActionCannotbeUndone"/></h3>
		</div>
		<div class="modal-footer">
		<a data-dismiss="modal" href="javascript:void(0);" onclick="openTextareaSection()" class="left btn-primary">
			  <s:text name="label.request.continue"/>
	    </a>			    
	    <a href="javascript:;" class="btn-tertiary left cancel" data-dismiss="modal"><s:text name="label.request.closeWindow"/></a>					  		
		</div>
</div>

<!-- Attachment Delete Confirmation Modal -->
<div class="modal hide fade" id="atmtConfirmModal">
<s:hidden id="modelGeLibFileId" name="modelGeLibFileId" value="" />
<s:hidden id="modelTypeId" name="modelTypeId" value="" />
<s:hidden id="modalIndexId" name="modalIndexId" value="" />
		<div class="modal-header">
			<a class="close" data-dismiss="modal">X</a>
			<h3><span><s:text name="label.attachment.attachmentConfirm"/></span></h3>
		</div>
		<div class="modal-body">
			<p><s:text name="label.attachment.attachmentDataClear"/></p>
		</div>
		<div class="modal-footer">
			<a data-dismiss="modal" href="javascript:void(0);" onclick="issuanceAtmtdeleteConfirm();" class="left btn-primary" id="saveSelectionlb">
				 <s:text name="label.attachment.attachmentDeleteMessage"/>
				</a>		
			<a href="#" class="btn-tertiary left cancel" data-dismiss="modal"><s:text name="label.request.common.cancel" /></a>				
		</div>			
</div> 		
  
<!-- EXIT REQUEST POPUP WINDOW -->         
<div class="modal hide fade" id="clearEntries">
		<div class="modal-header">
			<a class="close" data-dismiss="modal">X</a>
			<h3><s:text name="label.request.clearEntries"/> <span></span></h3>
		</div>
		<div class="modal-body">
		<p><b><s:text name="label.request.popUpMsg"/></b><br> 
				<s:text name="label.request.popUpsubMsg"/>
		</p>
		</div>
		<div class="modal-footer">
		    <a href="<s:property value="#cancelBtnlURL" />" class="btn left"><s:text name="label.request.popUpCancelYes"/></a>
			<a href="#" class="btn-tertiary left cancel" data-dismiss="modal"><s:text name="label.request.popUpCancelNo"/></a>
		</div>
</div>  

<!-- Attachment Error Modal -->
	<div class="modal hide fade" id="attachmentErrorModal"  style="top:200px;">
			<div class="modal-header">
				<a class="close" data-dismiss="modal">X</a>
				<h3><span><s:text name="label.attachment.attachmentError"/></span></h3>
			</div>
			<div class="modal-body">
				<p></p>
			</div>
			<div class="modal-footer">
				<a href="#" class="btn-tertiary left cancel" data-dismiss="modal"><s:text name="label.request.common.cancel" /></a>				
			</div>			
	</div> 	