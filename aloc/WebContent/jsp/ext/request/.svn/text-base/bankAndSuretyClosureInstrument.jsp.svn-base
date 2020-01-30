<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp"%>
<%@ taglib prefix="hwfs"  uri="/hwf-security-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
 <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%@include file="/jsp/ext/common/includeCommonScripts.jsp" %>
<title><c:if test="${requestDetails.instrumentTypeId eq '1'}">	
					<s:text name="label.request.closureInstrument.pageTitleBank"></s:text>
				</c:if>
				<c:if test="${requestDetails.instrumentTypeId eq '2' }">	
					<s:text name="label.request.closureInstrument.pageTitleSBLC"></s:text>
				</c:if>
				<c:if test="${requestDetails.instrumentTypeId eq '3'}">	
					<s:text name="label.request.closureInstrument.pageTitleSurety"></s:text>
				</c:if>
				<c:if test="${requestDetails.instrumentTypeId eq '5'}">	
					<s:text name="label.request.closureInstrument.pageTitleAmendment"/>
				</c:if>
				<c:if test="${requestDetails.instrumentTypeId eq '6'}">	
					<s:text name="label.request.closureInstrument.pageTitleSuretyRider"/>
				</c:if>
</title> 
<link href="${pageContext.request.contextPath}/ext/public/css/others/closure.css" type="text/css" rel="stylesheet" />  
<script type="text/javascript" src="${pageContext.request.contextPath}/ext/public/js/requestor/requestor.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/ext/public/js/ext/attachmentOperations.js"></script>
<script type="text/javascript">
$(document).ready(function() {
  jQuery('#closureSubmitForm').preventDoubleSubmit();
});
</script>  
</head>
<body>
	<div class="container main">
		<%@include  file="/jsp/ext/common/headerSection.jsp" %>
		<s:form id="closureSubmitForm"  namespace="/ext/approver">
		<div id="mainPage">
			<h1 class="page-title span12">
				<c:if test="${requestDetails.instrumentTypeId eq '1'}">	
					<s:text name="label.request.closureInstrument.pageTitleBank"></s:text>
				</c:if>
				<c:if test="${requestDetails.instrumentTypeId eq '2' }">	
					<s:text name="label.request.closureInstrument.pageTitleSBLC"></s:text>
				</c:if>
				<c:if test="${requestDetails.instrumentTypeId eq '3'}">	
					<s:text name="label.request.closureInstrument.pageTitleSurety"></s:text>
				</c:if>
				<c:if test="${requestDetails.instrumentTypeId eq '5'}">	
					<s:text name="label.request.closureInstrument.pageTitleAmendment"/>
				</c:if>
				<c:if test="${requestDetails.instrumentTypeId eq '6'}">	
					<s:text name="label.request.closureInstrument.pageTitleSuretyRider"/>
				</c:if>
				
			</h1>
			<p class="span12 left clear dashdesc">
				<s:text name="label.request.closureInstrument.subTitle" />
			</p>
			<hr class="page-title-hr">			
			<div class="form-mod">		
				<div class="closure-request-summary">
				<div class="row">
					<div class="span12">
						<p class="heading"><s:text name="label.request.requestSummary" /> -<span><s:text name="label.request.alocRecNo" /></span>&nbsp;<c:if test="${requestDetails.instrumentTypeId eq '1' || requestDetails.instrumentTypeId eq '2' || requestDetails.instrumentTypeId eq '3'}">	
						<s:property value="requestDetails.alocRecordId"/></c:if><c:if test="${requestDetails.instrumentTypeId eq '5'}"><s:property value="requestDetails.amendment.amendmentRequestId"/></c:if>
						<c:if test="${requestDetails.instrumentTypeId eq '6'}"><s:property value="requestDetails.rider.riderRequestId"/></c:if></p>
						<div class="row lastrow">
							<div class="span22"><div class="right"><label><s:text name="label.request.requestorName" /></label></div></div>
							<div class="span3a left"><s:property value="requestDetails.requestSummary.requestor.lastName"/>, <s:property value="requestDetails.requestSummary.requestor.firstName"/></div>
												
							<div class="span22"><div class="right">								  
								<c:if test="${requestDetails.instrumentTypeId eq '1' || requestDetails.instrumentTypeId eq '2' || requestDetails.instrumentTypeId eq '5'}">	
								        <label><s:text name="label.request.Instrumentpurpose" />:</label>
								 </c:if>
								  <c:if test="${requestDetails.instrumentTypeId eq '3' || requestDetails.instrumentTypeId eq '6'}"> 								   
								        <label><s:text name="label.request.bondType" />:</label>
								 </c:if></div></div>
							<div class="span2b left">							     
								 <c:if test="${requestDetails.instrumentTypeId eq '1' || requestDetails.instrumentTypeId eq '2' || requestDetails.instrumentTypeId eq '5'}">	
							            <s:property value="requestDetails.transactionParties.instrumentPurpose"/>
							     </c:if>
							     <c:if test="${requestDetails.instrumentTypeId eq '3'|| requestDetails.instrumentTypeId eq '6'}"> 
							        <s:property value="requestDetails.bondDetails.bondType"/>
							    </c:if></div>			
							
							<div class="span2d"><div class="right"> 
							 <c:if test="${requestDetails.instrumentTypeId eq '3' || requestDetails.instrumentTypeId eq '6'}"> 
							        <label> <s:text name="label.request.bondsurety" /></label>
							 </c:if>
							  <c:if test="${requestDetails.instrumentTypeId eq '1' || requestDetails.instrumentTypeId eq '2' || requestDetails.instrumentTypeId eq '5'}">	
							           <label>   <s:text name="label.request.bankReference" /></label>
							 </c:if></div></div>
							<div class="span22 left"> 
							<c:if test="${requestDetails.instrumentTypeId eq '3' || requestDetails.instrumentTypeId eq '6'}"> 
								    <div style="word-wrap: break-word;"><s:property value="requestDetails.feesDetails.surityName"/></div>
							 </c:if>
							 <c:if test="${requestDetails.instrumentTypeId eq '1' || requestDetails.instrumentTypeId eq '2' || requestDetails.instrumentTypeId eq '5'}">	
								       <div style="word-wrap: break-word;"> <s:property value="requestDetails.winningBankDetails.winnerDetails.bankReferenceNumber"/> </div>  
							 </c:if></div>
						</div>		
						<div class="row lastrow">
							<div class="span22"><div class="right"><label><s:text name="label.request.requestorSSO" /></label></div></div>
							<div class="span3 left">&nbsp;<s:property value="requestDetails.requestSummary.requestor.ssoId"/></div>
							<c:if test="${requestDetails.instrumentTypeId eq '3' || requestDetails.instrumentTypeId eq '6'}"> 
								<div class="span2bc"><div class="right"><label><s:text name="label.request.bondsubType" />:</label></div></div>
								<div class="span2 left"><s:property value="requestDetails.bondDetails.bondSubType"/></div>
				   		   </c:if>
						</div>
						
					</div>
				</div>
			</div>
		</div>
		<s:hidden name="errorShow" id="closureErrorShowId"/>
		<div class="row hide" id="closurePageLevelErrorDivId">
			<div class="span12">
				<div class="errorbox">
					<div class="errorHead">
						<p class="erroricon">Error</p>
					</div>
					<div class="errorContent">
						<p>
							<s:fielderror/>
						</p>
						<p>&nbsp;</p>
					</div>
				</div>
			</div>
		</div>					 
		<!-- Including applicant/principal details -->
		<div class="form-mod">
				<jsp:include page="/jsp/requestor/treasury/applicantAddress.jsp" />
		</div>
	    <div class="clear"></div>
	    
    	<!-- Including obligee/beneficiary Details -->
		<div class="form-mod">
				<jsp:include page="/jsp/requestor/treasury/beneficiaryAddress.jsp" />
		</div>
	    <div class="clear"></div>
	    
	   <div class="form-mod"> 
	   <br/>
	     <!-- Including expiration dates   -->
			<h2 class="acc_triggerExtra"><s:text name="label.request.closureDate" /></h2><hr class="h2-hr">
			<div class="acc_containerExtra">
	            <div class="row">
	                <div class="span3b">
	                <div class="form-row">
	                    <label><s:text name="label.request.currentExpirationDate"/>:</label>
	                </div>
	                </div>
	                <div class="span5 left">
	                <div class="form-row">
	                      <c:if test="${requestDetails.instrumentTypeId eq '1' || requestDetails.instrumentTypeId eq '2' || requestDetails.instrumentTypeId eq '5'}">	
							      <s:if test="%{requestDetails.issuingBankDetails.USExpirationDate != null}">
								     	<s:property value="requestDetails.issuingBankDetails.USExpirationDate"/>
								     </s:if>
								     <s:elseif test="%{requestDetails.instrumentDetails.econoExpiryDt != null}">
								     	<s:property value="requestDetails.instrumentDetails.econoExpiryDt"/>
								     </s:elseif>
								     <s:else>
								     	<s:property value="requestDetails.instrumentDetails.expiryDt"/>
								     </s:else>  
						 </c:if>
	                     <c:if test="${requestDetails.instrumentTypeId eq '3' || requestDetails.instrumentTypeId eq '6'}"> 
							   <s:property value="requestDetails.bondInfo.expirationDt"/>  
						 </c:if>
					</div>
	                </div>
	            </div><!-- row ends here -->
	            
	            <div class="row">
					<div class="span3b">
						<div class="form-row">
							<label><s:text name="label.request.issuanceDate" />:</label>
						</div>
					</div>
					<div class="span5 left">
						<div class="form-row">
							    <s:property value="requestDetails.issuanceDate"/>
						</div>
					</div>
          		</div>
	
	            <div class="row" style="margin:0px 0px 20px 0px;">
	                <label><s:text name="label.request.closureFielddate"/> 
	                <span class="ttip info" data-original-title="<s:text name="label.request.tooltip.newExpirationDate"/>"></span></label>
	                 <s:textfield name="requestDetails.newExpDate" cssClass="date" theme="aloc"/>	
	                 <p><s:text name="label.request.dateFormat"/></p>           
	            </div><!-- row ends here -->
			</div>
	
	    </div>	 
		<!-- Including Attachments   -->
		<div class="form-mod">	
                 	<div id="attachmnetRefresh">
                     <jsp:include page="/jsp/ext/request/common/closureAttachments.jsp"/>
				</div>
	</div>
		<div class="clear"></div>
	<div class="form-mod"> 
		<!-- Including comments -->
		<h2 class="acc_triggerExtra"><s:text name="label.request.comments" /></h2><hr class="h2-hr">
		 <br/>
			<div class="acc_containerExtra">
				<div class="row">
				<div class="form-mod">
					<div class="span5">
		               <s:textarea name="requestDetails.closerNotes" id="closureComments" 
								cssClass="autosize500 messageinput"
								key="label.request.notes" theme="aloc"
								onkeypress="return imposeMaxLength(this, 499);"	/>  		                
		               <div class="clear"></div>
		               <div class="counter">500</div>
		               <div class="counterTxt"><p style="padding-left: 5px;" class="guidance"><s:text name="label.request.limitis500Characters"/></p></div>
		             </div>  
				</div>
			</div>	
		</div>
   </div>
   <div class="clear"></div>
			<div class="row highlighted">
            <div class="span12">
			    <div class="form-row" style="margin-left:0px;">
			    	<s:hidden name="actionType" value="20"></s:hidden>
			    	<c:choose>
   						<c:when  test="${requestDetails.instrumentTypeId == '5'}">
   							<s:hidden name="amendmentOrRiderRequestId" id="requestId" value="%{requestDetails.amendment.amendmentRequestId}"/> 
   						</c:when>
   						<c:when  test="${requestDetails.instrumentTypeId == '6'}">
   							<s:hidden name="amendmentOrRiderRequestId" id="requestId" value="%{requestDetails.rider.riderRequestId}"/> 
   						</c:when>
   						<c:otherwise>
   							<s:hidden name="requestId" id="requestId" value="%{requestDetails.requestId}"/> 
   						</c:otherwise>
   					</c:choose>
			    	<hwfs:checkComponentPermission name="NotBankBrokerReadOnly" domainName="BusinessAccess">
                   		  <c:if test="${requestDetails.instrumentTypeId eq '5' || requestDetails.instrumentTypeId eq '6' || requestDetails.instrumentTypeId eq '4'}"> 
			    	         <s:submit key="label.request.completeTransactionClosure" action="closureSubmit" cssClass="btn-primary" />
			    	  </c:if>
			    	  <c:if test="${requestDetails.instrumentTypeId eq '1' || requestDetails.instrumentTypeId eq '2' || requestDetails.instrumentTypeId eq '3'}"> 
			    	            <c:choose>
			    	             <c:when test="${requestDetails.checkAmdmenRidert eq 'Y'}">
			    	                <a href="#" class="btn-primary alertPopUp" data-toggle="modal" ><s:text name="label.request.completeTransactionClosure"/></a>
			    	             </c:when>
								 <c:otherwise>
								        <s:submit key="label.request.completeTransactionClosure" action="closureSubmit" cssClass="btn-primary" />
								 </c:otherwise>
							  </c:choose>
			    	  </c:if>
                   </hwfs:checkComponentPermission>
                   <a href="#" class="btn-tertiary cancel clearEntries" data-toggle="modal" ><s:text name="label.request.common.cancel"/></a>	
                </div>
            </div> <!-- end of block -->
		</div><!-- end of form form-mod -->
		</div><!-- end of form mainPage -->	
		
		<div class="modal hide fade" id="alertPopUp">
				<div class="modal-header">
					<a class="close" data-dismiss="modal">X</a>
					<h3><s:text name="label.request.closeEntries"/> <span></span></h3>
				</div>
				<div class="modal-body">
					<c:if test="${requestDetails.instrumentTypeId eq '1' || requestDetails.instrumentTypeId eq '2'}"> 
						<p><b><s:text name="label.request.closurePopUpMsg"/></b><br> 
						<b><s:text name="label.request.closurepopUpsubMsg"/></b> </p>
					</c:if>
			        <c:if test="${requestDetails.instrumentTypeId eq '3'}"> 
			            <p><b><s:text name="label.request.closureRiderPopUpMsg"/></b><br> 
						<b><s:text name="label.request.closurepopUpsubMsg"/></b> </p>
			        </c:if>
				</div>
				<div class="modal-footer">
				    <s:submit key="label.request.popUpCloseYes" action="closureSubmit" cssClass="left btn-primary"/>    
					<a href="#" class="btn-tertiary left cancel" data-dismiss="modal"><s:text name="label.request.popUpCancelNo"/></a>
				</div>
		</div>	 	
	</s:form>
		<div id="lookupDiv" style="width: 100%;"></div>
	</div>
		<%@include file="/jsp/ext/common/footerSection.jsp" %>
  
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
		
</body>
</html>