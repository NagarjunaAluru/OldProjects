<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    
    
	<%@include file="../../common/includeCommonScripts.jsp" %>
	<title><s:text name="label.request.bgTreasuryBidAwardTitle" /></title>
	<script src="${pageContext.request.contextPath}/js/requestor/bidAward.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/requestor/lookup.js" type="text/javascript"></script>

	<script src="${pageContext.request.contextPath}/js/common/toWord.js" type="text/javascript"></script>

</head>

<body>	
	<div class="container main">
		<jsp:include page="../../common/headerSection.jsp">
			<jsp:param name="createReqPopup" value="Yes"></jsp:param>
		</jsp:include>
		<div id="mainPage">
		<h1 class="page-title span12"><s:text name="label.request.bgTreasuryBidAwardLine1" /><c:if test="${requestDetails.instrumentTypeId eq '1'}"><s:text name="label.request.bankGurantee" /></c:if>
		<c:if test="${requestDetails.instrumentTypeId eq '2'}"><s:text name="label.request.standbyLetterOfCredit" /></c:if>
		</h1>
		<p class="span12 left clear dashdesc"><s:text name="label.request.bgTreasuryBidAwardLine2" /></p>
		<hr class="page-title-hr">
		<div class="clear"></div>
			<c:if test="${not empty errorMsg}">
		 		<div class="row" id="errorMsg">
						<div class="span12">
							<div class="errorbox">
								<div class="errorHead">
									<p class="erroricon">Error</p>
								</div>
								<div class="errorContent">
									<p>
										<s:property value="errorMsg" />
									</p>
									<p>&nbsp;</p>
								</div>
							</div>
						</div>
					</div>	
			</c:if>
			  <s:hidden name="errorShow" id="errorShowId"/>
			   <div class="row hide" id="awardPageLevelErrorDivId">
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
		<div id="requestSummary">
	    	<div class="leftColRS">
	        	<p><strong><s:text name="label.request.replyDetails" /></strong> - <s:text name="label.request.auditLog.tableHeader.3" />&nbsp;<strong><s:property value="requestDetails.alocRecordId"/></strong></p>
	        </div>
		    <div class="clear"></div>
	        <div class="leftBoxRS1">
	            <div class="row smallrow">
	                <div class="span2"><label><s:text name="label.request.bankReplying" /></label></div>
	                <div class="span3 marginZero"><s:property value="requestDetails.winningBankDetails.winnerDetails.winningBankName"/></div>            
	            </div>
	            <div class="row smallrow">
	                <div class="span2"><label><s:text name="label.request.bankPerson" /></label></div>
	                <div class="span3 marginZero"><s:property value="requestDetails.bankContactLname"/>,<s:property value="requestDetails.bankContactFname"/></div>            
	            </div>  
	            <s:if test="%{requestDetails.actionDetails.reasonForOptingOut != null && requestDetails.actionDetails.reasonForOptingOut!=''}">       
		            <div class="row smallrow">
		                <div class="span2"><label><s:text name="label.request.ReasonForOptingOut" />:</label></div>
		                <div class="span3 marginZero"><s:property value="requestDetails.actionDetails.reasonForOptingOut"/></div>            
		            </div>
	           </s:if>                
			</div>
	        <div class="midBoxRS">
	            <div class="row smallrow">
	                <div class="span2"><label><s:text name="label.request.validityDate" /></label></div>
	                <div class="span2 marginZero right"><s:property value="requestDetails.bidReplyDetails.bidExpirationDate"/></div>            
	            </div>
			    <div class="row smallrow">
			           <div class="span2"><label><s:text name="label.request.validitytime" /></label></div>
			            <div class="span2 marginZero right"><s:property value="hours"/>:<s:property value="minutes"/>&nbsp;<s:property value="period"/>&nbsp; EST </div>            
			   </div>                       
		  </div>
          <div class="clear"></div>
    </div>
	
	<!-- Including  preAgreedPricingDetails -->
			<div class="form-mod">
				<h2 id="preAgreedPricingDetails" class="section_flip section_blue">
					<a href="javascript:;">
					<s:if test="%{!requestDetails.additionalInstrumentDetails.requestForProposal}">
						<s:text name="label.request.pricingDetails"></s:text>
					</s:if>
					<s:if test="%{requestDetails.additionalInstrumentDetails.requestForProposal}">
						<s:text name="label.request.preAgreedPricingDetails"></s:text>
					</s:if>
					 </a>
				</h2><hr class="h2-hr">

				<div id="preAgreedPricingDetailsPanel" class="section_panel">
					<jsp:include page="bgAndLocBidAwardIssuanceSection.jsp">
						<jsp:param name="sectionId"	value="request.section.preAgreedPricingDetails" />
						<jsp:param name="includeScripts" value="false" />
					</jsp:include>
				</div>
			</div>
      
   <!-- Including Transaction Parties  -->
  
   <div class="form-mod">
		<h2 id="transactionParties" class="section_flip section_blue">
			<a href="javascript:;"><s:text name="label.request.bglocSectionName.1"/></a>
		</h2><hr class="h2-hr">
		<div id="transactionPartiesPanel" class="section_panel">
		  
			<jsp:include page="bgAndLocBidAwardIssuanceSection.jsp">
				<jsp:param name="sectionId"  value="request.section.transactionParties" />
				<jsp:param name="includeScripts" value="false" />
			</jsp:include>					
    	 
		</div>
	</div>
   
   <div class="clear"></div>
   
   <!-- Including Project Description  -->
   <div class="form-mod" id="projectDescDiv">
   		<h2 id="projectDescription" class="section_flip">
			<a href="javascript:;"><s:text name="label.request.bglocSectionName.2"/></a>
		</h2><hr class="h2-hr">
		<div id="projectDescriptionPanel" class="section_panel">
		     <jsp:include page="bgAndLocBidAwardIssuanceSection.jsp">
				<jsp:param name="sectionId"  value="request.section.projectDescription" />
				<jsp:param name="includeScripts" value="false" />
			</jsp:include>
		 
		</div>
   </div>
   
   
   <!-- Including Instrument Details  -->
   <div class="form-mod" >
   		<h2 id="instrumentDetails" class="section_flip">
			<a href="javascript:;"><s:text name="label.request.bglocSectionName.3"/></a>
		</h2><hr class="h2-hr">
		<div id="instrumentDetailsPanel" class="section_panel">
			  <jsp:include page="bgAndLocBidAwardIssuanceSection.jsp">
					<jsp:param name="sectionId"  value="request.section.instrumentDetails" />
					<jsp:param name="includeScripts" value="false" />
				</jsp:include>
		</div>
   </div>
 
   <!-- Including Standby Letter of Credit Conditions  -->
   <c:if test="${requestDetails.instrumentType eq 'Standby Letter Of Credit'}">
   <div class="form-mod" >
   		<h2 id="locConditions" class="section_flip">
			<a href="javascript:;"><s:text name="label.request.bglocSectionName.5"/></a>
		</h2><hr class="h2-hr">
		<div id="locConditionsPanel" class="section_panel">
		      <jsp:include page="bgAndLocBidAwardIssuanceSection.jsp">
				<jsp:param name="sectionId"  value="request.section.standbyLetterofCredit" />
				<jsp:param name="includeScripts" value="false" />
			  </jsp:include>
			
		</div>
   </div>
   </c:if>
   
   <c:if test="${requestDetails.issuingBankSelectionFlag eq 'Y'}">
		    <jsp:include page="/jsp/common/request/issuingBankSelection.jsp"/>   
		   <div class="clear"></div>
   </c:if>	  
   
   <!-- Delivery Instructions -->
   <div class="form-mod">
   		<h2 id="deliveryInstructions" class="section_flip">
			<a href="javascript:;"><s:text name="label.request.bglocSectionName.8"/></a>
		</h2><hr class="h2-hr">
		<div id="deliveryInstructionsPanel" class="section_panel">
		      <jsp:include page="bgAndLocBidAwardIssuanceSection.jsp">
				<jsp:param name="sectionId"  value="request.section.deliveryInstructions" />
				<jsp:param name="includeScripts" value="false" />
			  </jsp:include>
			
		</div>
   </div>
   
   <div class="form-mod">	
   		<h2 id="issuingBankBranch" class="section_flip">
			<a href="javascript:;"> <s:text name="label.request.issuingBankBranch"></s:text></a>
		</h2><hr class="h2-hr">
		<div id="issuingBankBranchPanel" class="section_panel">
			<jsp:include page="bgAndLocBidAwardIssuanceSection.jsp">
				<jsp:param name="sectionId" value="request.section.issuingBankBranch" />
				<jsp:param name="includeScripts" value="false" />
			</jsp:include>
		</div>
   </div>
   
   <!-- Include Submit Section -->	
   <s:form id="awardSubmitForm" action="awardSubmit">
   	  <div class="row smallrow">
       <div class="span12">
  		   <h3 class="dashdesc"><s:text name="label.request.comments" /></h3>
  		   <hr class="page-title-hr">
           <label><s:text name="label.request.commentsOptional" /></label>
				<s:textarea name="requestDetails.comments" theme="aloc" onkeypress="return imposeMaxLength(this, 399);"
					cssClass="autosize messageinput" id="tdcomments" required="false"/>
           <div class="clear"></div>
           <div class="counter"><s:text name="label.request.fourHundred"/></div> <!-- fix positions -->
           <div class="counterTxt"><p class="guidance"><s:text name="label.request.textSize"/> <!--left (Limit is 400 characters) --></p></div>
       </div>
   </div>      
     <input type="hidden" name= "actionType" id="actionTypeId" value="${actionType}" />
      <div id="submitDiv">
				<jsp:include page="/jsp/common/request/awardSubmit.jsp" />
		</div>
		
		 <!-- WINNER POPUP WINDOW -->
		<div class="modal hide fade" id="selectWinner">
				<div class="modal-header">
					<a class="close" data-dismiss="modal">X</a>
					<h3><s:text name="label.dashboard.modal.header.selectedWinner"/> <span></span></h3>
				</div>
				<div class="modal-body">
				<jsp:include page="/jsp/common/requestsForBidProcessModal.jsp" />
				</div>
				<div class="modal-footer">
				    <s:submit key="label.dashboard.modal.body.selectAsWin" onclick="return submitAction(13)" cssClass="left btn-primary"/>    
					<a href="#" class="btn-tertiary left cancel" data-dismiss="modal"><s:text name="label.dashboard.bundle.cancel"/></a>
				</div>
		</div>
		<s:hidden name="requestId" value="%{requestId}"> </s:hidden>
		<s:hidden name="bidReplyId" value="%{bidReplyId}"> </s:hidden>
		<s:hidden name="stageName" value="%{requestDetails.WFDetails.WFStage}"> </s:hidden>
		<s:hidden name="wfid" value="%{requestDetails.WFDetails.WFID}"> </s:hidden>
		<s:hidden name="queueName" value="%{requestDetails.WFDetails.queueName}"> </s:hidden>
		<s:hidden name="procedureName" value="%{requestDetails.WFDetails.procedureName}"> </s:hidden>
		<s:hidden name="workFlowstageId" value="%{requestDetails.WFDetails.WFStageID}"> </s:hidden>
		<s:hidden name="selBidWinnerType" value="fromRequest"> </s:hidden>
		<s:hidden name="instrumentTypeId" value="%{requestDetails.instrumentTypeId}" id="instrumentId"> </s:hidden>
		
</s:form>
	</div>
	<div id="lookupDiv" style="width: 100%;"></div>
	
</div>	
<%@include  file="../../common/footerSection.jsp" %>
<!-- EXIT REQUEST POPUP WINDOW -->

<div class="modal hide fade" id="clearEntries">
		<div class="modal-header">
			<a class="close" data-dismiss="modal">X</a>
			<h3><s:text name="label.request.clearEntries"/> <span></span></h3>
		</div>
		<div class="modal-body">
		<form>
		<p><b><s:text name="label.request.popUpMsg"/></b><br>
		<s:text name="label.request.popUpsubMsg"/>
		</p>
		</form>
		</div>
		<div class="modal-footer">
			 <s:url id="readysystemCancel" action="cancel" />
			<s:a href="%{readysystemCancel}" key="label.request.continue" cssClass="btn left">
						<s:text name="label.request.popUpCancelYes"/>
			</s:a>
			<a href="javascript:;" class="btn-tertiary left cancel" data-dismiss="modal"><s:text name="label.request.popUpCancelNo"/></a>
		    
		</div>
</div> 

</body>
</html>