<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
 <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><s:text name="label.request.treasuryBidAcceptanceTitle" /></title>

<%@include file="../../common/includeCommonScripts.jsp"%>
<script src="${pageContext.request.contextPath}/js/requestor/bidAward.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/requestor/lookup.js" type="text/javascript"></script>
</head>

<body>
	<div class="container main">
	<%@include file="../../common/headerSection.jsp"%>
    <div id="mainPage">
	<h1 class="page-title span12">
		<s:text name="label.request.DLOCConfirm" />
	</h1>
	<p class="span12 left clear dashdesc">
		<s:text name="label.request.belowBidResponseTreasuryReview" />
	</p>
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
		<div class="form-mod">
			<div class="row graybg lastrow" style="margin-left: -10px;">
				<div class="span12">
					<h2 class="summary span12">
						<s:text name="label.request.replyDetails" />
					</h2><hr class="h2-hr">
					<div class="clear"></div>
					<div class="row lastrow">
						<div class="span12 whitebg">
							<div class="span4" style="margin-left: 10px !important;">
								<div class="marginT">
									<label><s:text name="label.request.bankReplying" /></label>
									<p><s:property value="requestDetails.winningBankDetails.winnerDetails.winningBankName"/></p>
									<p><s:property value="requestDetails.bankContactLname"/>,<s:property value="requestDetails.bankContactFname"/></p>
								</div>
							</div>
							<div class="span4">
								<div class="marginT">
									<label><s:text name="label.request.ALOCReferenceNumber" /></label>
									<p><s:property value="requestDetails.alocRecordId"/></p>
								</div>
							</div>
							<div class="span3 right">
								<div class="marginT">
									<div class="row">
										<div class="span3">
											<label><s:text name="label.request.pricingDateAndTime" /></label>
											<p><s:property value="requestDetails.indicativePricingCompletedDetails.pricingExpirationDateTime"/></p>
											<p><s:property value="hours"/>:<s:property value="minutes"/>&nbsp;<s:property value="period"/>&nbsp; EST </p>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			 <s:if test="%{requestDetails.confirmationFees.additionalComments != null && requestDetails.confirmationFees.additionalComments!=''}">  
			<div class="row graybg lastrow" style="margin-left: -10px;">
				<div class="span12">
					<h2 class="summary span12"></h2><hr class="h2-hr">
					<div class="clear"></div>
					<div class="row">
						<div class="span12 whitebg">
							<div class="span3" style="margin-left: 10px !important;">
								<div class="marginT">
									<label><s:text name="label.request.additionalComments" /></label>
									<p><s:property value="requestDetails.confirmationFees.additionalComments"/></p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</s:if>
		</div>
		<!-- end of form form-mod -->
		<div class="form-mod" id="confirmationFeesId">
			<h2 id="confirmationFees" class="section_flip section_blue">
				<a href="javascript:;"><s:text
						name="label.request.confirmationFees" /></a>
			</h2><hr class="h2-hr">
			<div id="confirmationFeesPanel" class="section_panel">
				<jsp:include page="/jsp/common/request/dLocConfirmationFeesReadonly.jsp">
				<jsp:param name="verify" value="bidAward"></jsp:param>
				</jsp:include>

			</div>
		</div>

		<div class="clear"></div>

		<div class="form-mod">
			<h2 id="proposedBankBranch" class="section_flip">
				<a href="javascript:;"><s:text
						name="label.request.proposedBankBranch" /></a>
			</h2><hr class="h2-hr">
			<div id="proposedBankBranchPanel" class="section_panel">
				<jsp:include page="/jsp/common/request/dLocPraposedBankBranchReadonly.jsp" />
			</div>
		</div>
		<div class="clear"></div>
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
		<!-- Include Submit Section -->
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
				    <s:submit key="label.dashboard.modal.body.selectAsWin" onclick="submitAction(13)"cssClass="left btn-primary"/>    
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
      </s:form>
     </div>
	</div>
		<%@include file="../../common/footerSection.jsp"%>
<!-- EXIT REQUEST POPUP WINDOW -->
<div class="modal hide fade" id="clearEntries">
		<div class="modal-header">
			<a class="close" data-dismiss="modal">X</a>
			<h3><s:text name="label.request.clearEntries"/> <span></span></h3>
		</div>
		<div class="modal-body">
		<form>
		<p><s:text name="label.request.popUpMsg"/></p>
		</form>
		</div>
		<div class="modal-footer">
		     <s:url id="readysystemCancel" action="cancel" />
			<s:a href="%{readysystemCancel}" key="label.request.continue" cssClass="btn left">
						<s:text name="label.request.continue"></s:text>
			</s:a>
			<a href="javascript:;" class="btn-tertiary left cancel" data-dismiss="modal"><s:text name="label.request.closeWindow"/></a>
		</div>
</div> 

</body>
</html>
