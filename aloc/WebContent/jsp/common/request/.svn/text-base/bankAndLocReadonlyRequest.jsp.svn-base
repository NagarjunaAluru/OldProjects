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
	<title><s:property value="requestDetails.instrumentType"/> - Approver Request</title>
	
	<script src="${pageContext.request.contextPath}/js/requestor/requestor.js" type="text/javascript"></script>

	<script src="${pageContext.request.contextPath}/js/requestor/lookup.js" type="text/javascript"></script>

	<script src="${pageContext.request.contextPath}/js/common/toWord.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/common/pagination.js"></script>
<link href="${pageContext.request.contextPath}/css/common/pagenavi.css" type="text/css" rel="stylesheet" />

</head>

<body>
	
	<c:set var="workFlowStage" value="${requestDetails.WFDetails.WFStage}"></c:set>
	
	<div class="container main">
		<jsp:include page="../../common/headerSection.jsp">
			<jsp:param name="createReqPopup" value="Yes"></jsp:param>
		</jsp:include>
		<div id="mainPage" style="width: 100%;">
		<c:if test="${workFlowStage eq 'BUSAPROV'}">
		<h1 class="page-title span12">
		 <s:text name="label.request.businessApproval"/> - <s:property value="requestDetails.instrumentType"/> </h1>
		<p class="span12 left clear dashdesc"><s:text name="label.request.pageDesc.1" /> <s:property value="requestDetails.instrumentType"/> <s:text name="label.request.pageDesc.2"/>
		</p>
		<hr class="page-title-hr">
		</c:if>
		<c:if test="${workFlowStage eq 'TREAPROV'}">
		<h1 class="page-title span12">	
			 <s:text name="label.request.treasuryApproval"/> - <s:property value="requestDetails.instrumentType"/>  
		</h1>
		<p class="span12 left clear dashdesc"> 
			<s:text name="label.request.treasuryApprovalTransaction"/>
		</p>
		<hr class="page-title-hr">
		</c:if>
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
		<s:hidden id="errorMsgShowId" value="%{errorShow}"/>
		<div class="row hide" id="pageLevelErrorDivId">
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
	<jsp:include page="/jsp/common/request/bgRequestSummary.jsp"/>
   
   <!-- Including Transaction Parties  -->
   <s:set name="isEditMode" value="editMode"/>
   <c:if test="${workFlowStage eq 'BUSAPROV'}">
   <div class="form-mod">
		<h2 id="transactionParties" class="section_flip section_blue">
			<a href="javascript:;"><s:text name="label.request.bglocSectionName.1"/></a>
		</h2><hr class="h2-hr">
		<div id="transactionPartiesPanel" class="section_panel">
		  
			<jsp:include page="bgReadonlyRequestSection.jsp">
				<jsp:param name="sectionId"  value="request.section.transactionParties" />
				<jsp:param name="includeScripts" value="false" />
			</jsp:include>					
    	 
		</div>
	</div>
   </c:if>
   <c:if test="${workFlowStage eq 'TREAPROV'}">
			<div class="form-mod">
				<h2 id="transactionParties" class="section_flip section_blue">
					<a href="javascript:;"><s:text
							name="label.request.bglocSectionName.1" /></a>
				</h2><hr class="h2-hr">
				<div id="transactionPartiesPanel" class="section_panel">
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
	</c:if>
   <div class="clear"></div>
   
   <!-- Including Project Description  -->
   <div class="form-mod" id="projectDescDiv">
   		<h2 id="projectDescription" class="section_flip">
			<a href="javascript:;"><s:text name="label.request.bglocSectionName.2"/></a>
		</h2><hr class="h2-hr">
		<div id="projectDescriptionPanel" class="section_panel">
		     <jsp:include page="bgReadonlyRequestSection.jsp">
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
			  <jsp:include page="bgReadonlyRequestSection.jsp">
					<jsp:param name="sectionId"  value="request.section.instrumentDetails" />
					<jsp:param name="includeScripts" value="false" />
				</jsp:include>
		</div>
   </div>
   
   <!-- Including Instrument Risk  -->
   <div class="form-mod" >
   		<h2 id="instrumentRisk" class="section_flip">
			<a href="javascript:;"><s:text name="label.request.bglocSectionName.4"/></a>
		</h2><hr class="h2-hr">
		<div id="instrumentRiskPanel" class="section_panel">
		     <jsp:include page="bgReadonlyRequestSection.jsp">
				<jsp:param name="sectionId"  value="request.section.instrumentRisk" />
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
		      <jsp:include page="bgReadonlyRequestSection.jsp">
				<jsp:param name="sectionId"  value="request.section.standbyLetterofCredit" />
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
		<div id="instrumentReportingPanel" class="section_panel">
		      <jsp:include page="bgReadonlyRequestSection.jsp">
				<jsp:param name="sectionId"  value="request.section.instrumentReporting" />
				<jsp:param name="includeScripts" value="false" />
			  </jsp:include>
			
		</div>
   </div>		
   <!-- Including Format   -->
   <div class="form-mod" id="formatDiv">
   		<h2 id="formatSectionFlip" class="section_flip">
			<a href="javascript:;"><s:text name="label.request.bglocSectionName.7"/> 
				<span id="formatSelectionH2"></span>
			</a>
		</h2><hr class="h2-hr">
		<div id="formatSectionFlipPanel" class="section_panel">
		      <jsp:include page="bgReadonlyRequestSection.jsp">
				<jsp:param name="sectionId"  value="request.section.format" />
				<jsp:param name="includeScripts" value="false" />
			  </jsp:include>
		</div>
   </div>
   
   <!-- Delivery Instructions -->
   <div class="form-mod">
   		<h2 id="deliveryInstructions" class="section_flip">
			<a href="javascript:;"><s:text name="label.request.bglocSectionName.8"/></a>
		</h2><hr class="h2-hr">
		<div id="deliveryInstructionsPanel" class="section_panel">
		      <jsp:include page="bgReadonlyRequestSection.jsp">
				<jsp:param name="sectionId"  value="request.section.deliveryInstructions" />
				<jsp:param name="includeScripts" value="false" />
			  </jsp:include>
			
		</div>
   </div>
   <!-- Including Attachments   -->
   <div class="form-mod" id="attachmentsDiv">
   		<h2 id="attachmentsFlip" class="section_flip">
			<a href="javascript:;"><s:text name="label.request.bglocSectionName.9"/></a>
		</h2><hr class="h2-hr">
		<div id="attachmentsFlipPanel" class="section_panel">
			    <jsp:include page="bgReadonlyRequestSection.jsp">
					<jsp:param name="sectionId"  value="request.section.attachments" />
					<jsp:param name="includeScripts" value="false" />
				</jsp:include>
		</div>
   </div>
   
	<!-- Audit Log and Transaction History  -->
   <div class="form-mod">
	    <jsp:include page="/jsp/common/request/auditAndTransactionHistoryLog.jsp"/>	            
   </div>
   
   <c:if test="${workFlowStage eq 'TREAPROV'}">
   		 <c:if test="${requestDetails.issuingBankSelectionFlag eq 'Y'}">
		    <jsp:include page="/jsp/common/request/issuingBankSelection.jsp"/>   
		   <div class="clear"></div>
	   </c:if>	   
   </c:if>
   
   <s:url action="cancel.action" namespace="/int/approver" var="cancelBtnlURL"/>
   <s:form id="approverSubmitForm" action="approverSubmit">
   			<s:hidden name="requestDetails.instrumentTypeId" id="instrumentTypeId" />
			<s:hidden name="requestDetails.WFDetails.WFStage" id="WFStage" />
			<s:hidden name="requestId" value="%{requestDetails.requestId}" id="requestId"/>
  <input type="hidden" name="actionType" id="actionTypeId" value="${actionType}"/>
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
   <!-- Include Submit Section -->		
   <div id="submitDiv">
		<div>
			<jsp:include page="/jsp/requestor/approveOrReject.jsp"/>		
		</div>
   </div> 
 </s:form>  
		</div>
	<div id="fullHistoryDiv" style="width: 100%;"></div>
   
	
	
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
		    <a href="<s:property value="#cancelBtnlURL" />" class="btn left"><s:text name="label.request.popUpCancelYes"/></a>
			<a href="javascript:;" class="btn-tertiary left cancel" data-dismiss="modal"><s:text name="label.request.popUpCancelNo"/></a>
		</div>
</div> 
</body>
</html>