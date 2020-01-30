<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    
    
	<%@include file="../common/includeRequestCommonScripts.jsp" %>
	<title><s:property value="requestDetails.instrumentType"/> - Request</title>
	<link href="${pageContext.request.contextPath}/css/common/pagenavi.css" type="text/css" rel="stylesheet" />
	<script src="${pageContext.request.contextPath}/js/requestor/requestor.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/requestor/bgRequestor.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/requestor/addReference.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/common/toWord.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/requestor/fieldCounter.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/common/pagination.js"></script>
<link href="${pageContext.request.contextPath}/css/common/pagenavi.css" type="text/css" rel="stylesheet" />
</head>

<body>
	<c:set var="workFlowStage" value="${requestDetails.WFDetails.WFStage}"></c:set>
	<div class="container main">
		<jsp:include page="../common/headerSection.jsp">
			<jsp:param name="createReqPopup" value="Yes"></jsp:param>
		</jsp:include>
		<div id="mainPage" style="width: 100%;">
		<!-- For Alert -->
		<c:if test="${not empty requestDetails.businessReApprovalFlag}">
			<div class="row">
				<div class="span12">
					<div class="errorbox">
						<div class="noteHead">
							<p class="noteicon">
								<s:text name="label.common.alert" />
							</p>
						</div>
						<div class="noteContent">
							<p><s:text name="label.request.TheFollowingEditsNeedtobeMadetoThisRequest"/></p><br>
							<ol>
							<s:if test="%{requestDetails.transactionParties.requiresEdits}">
							<li><p>
									<s:text name="label.request.bglocSectionName.1" />
								</p></li>
							</s:if>
							<s:if test="%{requestDetails.transactionParties.tpApplicantDetails.requiresEdits}">
								<li><p>
									<s:text name="label.request.applicant" />
								</p></li>
							</s:if>
							<s:if test="%{requestDetails.transactionParties.triPartyApplicant.requiresEdits}">
								<li><p>
									<s:text name="label.request.triPartyApplicant" />
								</p></li>
							</s:if>
							<s:if test="%{requestDetails.transactionParties.customer.addressDtls.requiresEdits}">
								<li><p>
									<s:text name="label.request.customer" />
								</p></li>
							</s:if>
							<s:if test="%{requestDetails.projDescription.requiresEdits}">
								<li><p>
									<s:text name="label.request.bglocSectionName.2" />
								</p></li>
							</s:if>
							<s:if test="%{requestDetails.instrumentDetails.requiresEdits}">
								<li><p>
									<s:text name="label.request.bglocSectionName.3" />
								</p></li>
							</s:if>
							<s:if test="%{requestDetails.instrumentRisk.requiresEdits}">
								<li><p>
									<s:text name="label.request.bglocSectionName.4" />
								</p></li>
							</s:if>
							<s:if test="%{requestDetails.SBLC.requiresEdits}">
								<li><p>
									<s:text name="label.request.bglocSectionName.5" />
								</p></li>
							</s:if>
							<s:if test="%{requestDetails.instrReporting.requiresEdits}">
								<li><p>
									<s:text name="label.request.bglocSectionName.6" />
								</p></li>
							</s:if>
							<s:if test="%{requestDetails.deliveryInstructions.requiresEdits}">
								<li><p>
									<s:text name="label.request.bglocSectionName.8" />
								</p></li>
							</s:if>
							<s:if test="%{requestDetails.format.requiresEdits}">
								<li><p><s:text	name="label.request.sbSectionFormat" /></p></li>
							</s:if>
							<s:if test="%{requestDetails.attachments[0].requiresEdits}">
								<li><p><s:text	name="label.request.sbSectionAttachments" /></p></li>
							</s:if>
							</ol>
							<br>
							<c:if test="${requestDetails.businessReApprovalFlag eq 'Y'}">							
								<s:text name="label.request.businessReApproval" />
							</c:if>
							<c:if test="${requestDetails.businessReApprovalFlag ne 'Y'}">
								<s:text name="label.request.treasuryReviewApproval" />
							</c:if>
						</div>
					</div>
				</div>
			</div>	
		</c:if>		
		<s:form id="reRequestFormId" action="reSubmit">
			<s:hidden name="approver" value="wants" id="approver"/>
			<s:hidden name="validationSuccess" id="validationReSubmitId" />
			<s:hidden name="requestDetails.instrumentTypeId" value="%{requestDetails.instrumentTypeId}" id="instrumentTypeId"/>
			<s:hidden name="requestDetails.WFDetails.WFStage" id="WFStage" />
			<s:hidden value="true" id="isResubmitPage"/>
			<s:hidden name="requestId" value="%{requestDetails.requestId}" id="requestId"/>
		<h1 class="page-title span12">
		<s:text name="label.request.pageTitle"></s:text> <s:property value="requestDetails.instrumentType"/> </h1>
		<p class="span12 left clear dashdesc"><s:text name="label.request.pageDesc.1" /> <s:property value="requestDetails.instrumentType"/> <s:text name="label.request.pageDesc.2"/>
		</p>	
		<hr class="page-title-hr">
		<div class="row hide" id="pageLevelErrorDivId">
			<div class="span12">
				<div class="errorbox">
					<div class="errorHead"><p class="erroricon"><s:text name="label.request.error"/></p></div>
					<div class="errorContent">
							<p><s:fielderror/></p>
							<p>&nbsp;</p>
					</div>
				</div>
			</div>
		</div>
		 <!-- REQUEST SUMMARY -->
		<jsp:include page="/jsp/common/request/bgRequestSummary.jsp"/>
		
   <!-- Including Transaction Parties  -->
   <s:set name="isEditMode" value="editMode"/>
   <c:choose>
   <c:when test="${workFlowStage eq 'BUSAPROV' or not empty requestDetails.sendbackbyBuApprover and requestDetails.sendbackbyBuApprover eq 'Y'}">
	   <div class="form-mod">
			<h2 id="transactionParties" class="section_flip section_blue">
				<a href="javascript:;"><s:text name="label.request.bglocSectionName.1"/></a>
			</h2><hr class="h2-hr">
			<div id="transactionPartiesPanel" class="section_panel fieldcount_panel">
			  
				<jsp:include page="requestorSection.jsp">
					<jsp:param name="sectionId"  value="request.section.transactionParties" />
					<jsp:param name="saveAndNextSectionButtonKey" value="key" />
					<jsp:param name="includeScripts" value="false" />
				</jsp:include>
			  
			</div>
		</div>
	
	</c:when>
	
	<c:when test="${not empty requestDetails.sendbackbyBuApprover and requestDetails.sendbackbyBuApprover eq 'N'}">
			<div class="form-mod">
				<h2 id="transactionParties" class="section_flip section_blue">
					<a href="javascript:;"><s:text
							name="label.request.bglocSectionName.1" /></a>
				</h2><hr class="h2-hr">
				<div id="transactionPartiesPanel" class="section_panel fieldcount_panel">
					<jsp:include page="/jsp/common/request/tripartyFlagdetails.jsp" />
					<c:if test="${requestDetails.siteTypeName eq 'Financial Business'}">
						<s:if test="%{requestDetails.transactionParties.triPartyRequestFlag != null && requestDetails.transactionParties.triPartyRequestFlag}">
							<h3 id="triPartyHeader">
								<s:text name="label.request.triPartyApplicant" />
							</h3>
							<jsp:include page="/jsp/common/request/tripartyApplicant.jsp" />
						</s:if>
					</c:if>
					<h3 id="applicantHeader">
						<s:text name="label.request.applicant" />
					</h3>
					<jsp:include page="/jsp/common/request/tpApplicantDetails.jsp" />
					<h3 id="customerHeader">
						<s:text name="label.request.customer" />
					</h3>
					<jsp:include page="/jsp/common/request/tpCustomerDetails.jsp" />
				</div>
			</div>
	
	</c:when>
	</c:choose>

   
   <div class="clear"></div>
   
   <!-- Including Project Description  -->
   <div class="form-mod" id="projectDescDiv">
   		<h2 id="projectDescription" class="section_flip">
			<a href="javascript:;"><s:text name="label.request.bglocSectionName.2"/></a>
		</h2><hr class="h2-hr">
		<div id="projectDescriptionPanel" class="section_panel fieldcount_panel">
		
			<jsp:include page="requestorSection.jsp">
				<jsp:param name="sectionId"  value="request.section.projectDescription" />
				<jsp:param name="saveAndNextSectionButtonKey" value="key" />
				<jsp:param name="includeScripts" value="false" />
			</jsp:include>
		 
		</div>
   </div>
   
   
   <!-- Including Instrument Details  -->
   <div class="form-mod" >
   		<h2 id="instrumentDetails" class="section_flip">
			<a href="javascript:;"><s:text name="label.request.bglocSectionName.3"/></a>
		</h2><hr class="h2-hr">
		<div id="instrumentDetailsPanel" class="section_panel fieldcount_panel">
		
			<jsp:include page="requestorSection.jsp">
				<jsp:param name="sectionId"  value="request.section.instrumentDetails" />
				<jsp:param name="saveAndNextSectionButtonKey" value="key" />
				<jsp:param name="includeScripts" value="false" />
			</jsp:include>
		 
		</div>
   </div>
   
   <!-- Including Instrument Risk  -->
   <div class="form-mod" >
   		<h2 id="instrumentRisk" class="section_flip">
			<a href="javascript:;"><s:text name="label.request.bglocSectionName.4"/></a>
		</h2><hr class="h2-hr">
		<div id="instrumentRiskPanel" class="section_panel fieldcount_panel">
			
			<jsp:include page="requestorSection.jsp">
				<jsp:param name="sectionId"  value="request.section.instrumentRisk" />
				<jsp:param name="saveAndNextSectionButtonKey" value="key" />
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
		<div id="locConditionsPanel" class="section_panel fieldcount_panel">

			<jsp:include page="requestorSection.jsp">
				<jsp:param name="sectionId"  value="request.section.standbyLetterofCredit" />
				<jsp:param name="saveAndNextSectionButtonKey" value="key" />
				<jsp:param name="includeScripts" value="false" />
			</jsp:include>
			
		</div>
   </div>
   </c:if>
    <!-- Including Instrument Reporting Attributes  -->
   <div class="form-mod" >
   		<h2 id="instrumentReporting" class="section_flip">
			<a href="javascript:;"><s:text name="label.request.bglocSectionName.6"/></a>
		</h2><hr class="h2-hr">
		<div id="instrumentReportingPanel" class="section_panel fieldcount_panel">
			
			<jsp:include page="requestorSection.jsp">
				<jsp:param name="sectionId"  value="request.section.instrumentReporting" />
				<jsp:param name="saveAndNextSectionButtonKey" value="key" />
				<jsp:param name="includeScripts" value="false" />
			</jsp:include>
			
		</div>
   </div>		
  
   
   <!-- Delivery Instructions -->
   <div class="form-mod">
   		<h2 id="deliveryInstructions" class="section_flip">
			<a href="javascript:;"><s:text name="label.request.bglocSectionName.8"/></a>
		</h2><hr class="h2-hr">
		<div id="deliveryInstructionsPanel" class="section_panel fieldcount_panel">
			<jsp:include page="requestorSection.jsp">
				<jsp:param name="sectionId"  value="request.section.deliveryInstructions" />
				<jsp:param name="saveAndNextSectionButtonKey" value="key" />
				<jsp:param name="includeScripts" value="false" />
			</jsp:include>
		   
			
		</div>
	</div>
		<div class="clear"></div>
				   <!-- Including Format   -->
		   <div class="form-mod" id="formatDiv">
		   		<h2 id="format" class="section_flip">
					<a href="javascript:;"><s:text name="label.request.sbSectionFormat"/> 
						<span id="formatSelectionH2"></span>
					</a>
				</h2><hr class="h2-hr">
				<div id="formatPanel" class="section_panel">
					<div id="replaceFormat">
						<jsp:include page="/jsp/common/request/requestorFormat.jsp">
							<jsp:param name="includeScripts" value="false" />
						</jsp:include>
					</div>					
				</div>
		   </div>
		   <!-- Including Attachments   -->
		   <div class="form-mod" id="attachmentsDiv">
		   		<h2 id="attachments" class="section_flip">
					<a href="javascript:;"><s:text name="label.request.sbSectionAttachments"/></a>
				</h2><hr class="h2-hr">
				<div id="attachmentsPanel" class="section_panel">
						<jsp:include page="/jsp/common/request/requestAttachment.jsp" />				
				</div>
		   </div>
		<div class="clear"></div>
					<!-- Audit Log and Transaction History  -->
					<div class="form-mod">
						<jsp:include
							page="/jsp/common/request/auditAndTransactionHistoryLog.jsp" />
					</div>
					
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
        		
				<c:if test="${not empty requestDetails.businessReApprovalFlag}">
				<div class="row">
					<div class="span12">
						<div class="errorbox">
							<div class="noteHead">
								<p class="noteicon">
									<s:text name="label.common.alert" />
								</p>
							</div>
							<div class="noteContent">
								<p>
							<c:if test="${requestDetails.businessReApprovalFlag eq 'Y'}">							
								<s:text name="label.request.businessReApproval" />
							</c:if>
							<c:if test="${requestDetails.businessReApprovalFlag ne 'Y'}">
								<s:text name="label.request.treasuryReviewApproval" />
							</c:if>
								</p>
							</div>
						</div>
					</div>
				</div>
				</c:if>
				<!-- Include Submit Section -->
				<div id="submitDiv">
					<div>
						<jsp:include page="/jsp/requestor/saveAndReSubmit.jsp" />
					</div>
				</div>
  
  </s:form>			
	</div>
	
	<div id="lookupDiv" style="width: 100%;">
	<div id="fullHistoryDiv" style="width: 100%;"></div>	
	</div>
	
</div>	
<%@include  file="../common/footerSection.jsp" %>
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
</body>
</html>