<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
 <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><s:text name="label.request.suretyRiderTreasureyTitle"/> <s:property value="requestDetails.bondDetails.bondType"/></title>

<%@include file="../../common/includeCommonScripts.jsp"%>
<link href="${pageContext.request.contextPath}/css/common/amendment.css" type="text/css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/common/pagenavi.css" type="text/css" rel="stylesheet" />
<script src="${pageContext.request.contextPath}/js/requestor/requestor.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/requestor/lookup.js" type="text/javascript"></script> 
<script src="${pageContext.request.contextPath}/js/common/toWord.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/common/rider.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/common/pagination.js"></script>
</head>
<body>
	<div class="container main">
		<%@include file="../../common/headerSection.jsp"%>
		<div id="mainPage" style="width: 100%;"> 
		<h1 class="page-title span12"><s:text name="label.request.treasuryAnalystReviewSuretyRider"/> <s:property value="requestDetails.bondDetails.bondType"/></h1>
		<p class="span12 left clear dashdesc"><s:text name="label.request.line1"/><s:text name="label.request.line2"/><s:text name="label.request.line3"/></p>
		<hr class="page-title-hr">
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
		<s:hidden id="riderMsgShowId" value="%{errorShow}"/>
		<div class="row hide" id="pageLevelRiderErrorDivId">
			<div class="span12">
				<div class="errorbox">
					<div class="errorHead"><p class="erroricon">Error</p></div>
					<div class="errorContent">
							<p><s:fielderror/></p>
							<p>&nbsp;</p>
					</div>
				</div>
			</div>
		</div>
				<div class="clear"></div>
		<div class="form-mod">
				<jsp:include page="../../common/request/sbRequestSummary.jsp"/>
			</div>
			<s:set name="isEdit" value="editMode"/>			
			<s:hidden name="requestDetails.instrumentTypeId" id="instrumentTypeId" />
			<s:hidden name="requestDetails.requestId" id="requestId" />
			<s:hidden name="requestDetails.WFDetails.WFStage" id="WFStage" />
			<div class="form-mod">
				<jsp:include page="suretyRiderTreasuryAnalystSection.jsp">
					<jsp:param name="sectionId"  value="request.section.riderPrincipal" />
					<jsp:param name="includeScripts" value="false" />
				</jsp:include>					
			</div>					
				
			<div class="clear"></div>
			
			<div class="form-mod">
				<jsp:include page="suretyRiderTreasuryAnalystSection.jsp">
					<jsp:param name="sectionId"  value="request.section.riderObligee" />
					<jsp:param name="includeScripts" value="false" />
				</jsp:include>					
			</div>			
						
			<div class="clear"></div>
			
			<!-- Including Expiration Dates -->
			<div class="form-mod">
				<jsp:include page="suretyRiderTreasuryAnalystSection.jsp">
					<jsp:param name="sectionId"	value="request.section.riderExpirationDates" />
					<jsp:param name="includeScripts" value="false" />
				</jsp:include>
			</div>
			<div class="clear"></div>
			
			<div class="form-mod">
				<jsp:include page="suretyRiderTreasuryAnalystSection.jsp">
					<jsp:param name="sectionId"  value="request.section.riderBondInformation" />
					<jsp:param name="saveAndNextSectionButtonKey" value="key" />
					<jsp:param name="includeScripts" value="false" />
				</jsp:include>
			</div>
			<div class="clear"></div>
			
			<div class="form-mod">
				<jsp:include page="suretyRiderTreasuryAnalystSection.jsp">
					<jsp:param name="sectionId"  value="request.section.riderDeliveryInstructions" />
					<jsp:param name="saveAndNextSectionButtonKey" value="key" />
					<jsp:param name="includeScripts" value="false" />
				</jsp:include>					
			</div>
			<div class="clear"></div>
			 <!-- Including Attachments   -->
		   <div class="form-mod" id="attachmentsDiv">
				<jsp:include page="suretyRiderTreasuryAnalystSection.jsp">
					<jsp:param name="sectionId"  value="request.section.attachments" />
					<jsp:param name="saveAndNextSectionButtonKey" value="key" />
					<jsp:param name="includeScripts" value="false" />
				</jsp:include>								
		   </div>
		   <div class="clear"></div>
		   
			<div class="form-mod">
			        <jsp:include page="/jsp/common/request/auditAndTransactionHistoryLog.jsp"/>	            
			</div>
		   	<div class="clear"></div>
			<s:form id="trAnalystSubmitForm" action="trAnalystRiderSubmit">
				<s:hidden name="amendmentOrRiderRequestId" value="%{requestDetails.rider.riderRequestId}" id="AmendmentOrRiderId"/>
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
				<s:hidden name="requestDetails.rider.riderBondInformation.validationUsdAmount" id="validationUsdAmount"/>
				<s:hidden name="requestDetails.instrumentTypeId" id="instrumentTypeId" />
				<s:hidden name="requestDetails.requestId" id="requestId" />
				<s:hidden name="requestDetails.WFDetails.WFStage" id="WFStage" />
				<input type="hidden" name="actionType" id="actionTypeId" value="${actionType}"/>
				<s:url action="cancel.action" namespace="/int/approver" var="cancelBtnlURL"/>
				<div id="riderSubmitDiv">
					<div>
						<jsp:include page="/jsp/common/request/suretyRider/riderTRAnalystActions.jsp"/>		
					</div>
	   			</div> 
			</s:form>
			
		</div>
		<div id="lookupDiv" style="width: 100%;">
		</div>
		<div id="fullHistoryDiv" style="width: 100%;"></div>
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
		<p><b><s:text name="label.request.popUpMsg"/></b><br>
		<s:text name="label.request.popUpsubMsg"/>
		</p>
		</form>
		</div>
		<div class="modal-footer">
		    <a href="<s:property value="#cancelBtnlURL" />" class="btn left"><s:text name="label.request.popUpCancelYes"/></a>
			<a href="javascript:;" class="btn-tertiary left cancel" data-dismiss="modal"><s:text name="label.request.popUpCancelNo"/></a>
		</div>
</div> 
	
	<!-- Delete Modal Modal -->
	<div class="modal hide fade" id="deleteRider" style="width:400px;">
        <div class="modal-header">
            <a class="close" data-dismiss="modal">X</a>
            <h3>Delete Rider<span></span></h3>
        </div>
        <div class="modal-body" style="min-height: auto;">        
        <p>You are about to delete the following rider:</p>
		<p><b>ALOC Reference Number</b>:  <c:out value="${requestDetails.alocRecordId}"/></p>
			<h3>This action cannot be undone. </h3>
			<div>
			<p class="deleteReasonError hide" style="color: #990000;"><s:text name="error.required.deleteRequest.deleteReason"/></p>
			<label><s:text name="label.dashboard.modal.body.deleteReason" /></label>
				<s:textarea name="requestDetails.actionDetails.comments" theme="aloc" onkeypress="return imposeMaxLength(this, 399);"
					cssClass="autosize messageinput" id="deleteReasonId" required="false"/>
           		<div class="clear"></div>
           		<div class="counter" id="fourHundredCounter"><s:text name="label.request.fourHundred"/></div> <!-- fix positions -->
           		<div class="counterTxt"><p class="guidance"><s:text name="label.request.textSize"/></p></div>
           	</div>
        </div>
        <div class="modal-footer">
            <a href="#" id="deleteRiderId" class="btn left" data-dismiss="modal">Delete</a>
            <a href="javascript:;" class="btn-tertiary left cancel" data-dismiss="modal">Cancel</a>
        </div>
	</div>
</body>
</html>