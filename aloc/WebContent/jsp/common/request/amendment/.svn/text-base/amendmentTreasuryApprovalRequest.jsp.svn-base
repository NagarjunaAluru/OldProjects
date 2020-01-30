<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
 <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%@include file="../../../common/includeCommonScripts.jsp"%>
<title><s:text name="label.amendment.pageTitle"/> </title>
<link href="${pageContext.request.contextPath}/css/common/pagenavi.css" type="text/css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/common/amendment.css" type="text/css" rel="stylesheet" />
<script
	src="${pageContext.request.contextPath}/js/requestor/requestor.js"
	type="text/javascript"></script>

<script src="${pageContext.request.contextPath}/js/requestor/lookup.js"
	type="text/javascript"> </script>

<script src="${pageContext.request.contextPath}/js/common/toWord.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/common/amendment.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/common/pagination.js"></script>
<link href="${pageContext.request.contextPath}/css/common/pagenavi.css" type="text/css" rel="stylesheet" />
</head>

<body>
	
	<c:set var="workFlowStage" value="${requestDetails.WFDetails.WFStage}"></c:set>
	
	<div class="container main">
		<jsp:include page="../../../common/headerSection.jsp">
			<jsp:param name="createReqPopup" value="Yes"></jsp:param>
		</jsp:include>
		<div id="mainPage" style="width: 100%;">
			<c:if test="${workFlowStage eq 'TREAPROV'}">
			<h1 class="page-title span12">
				<c:if test="${requestDetails.amendment.oldInstrumentTypeId eq 1}">
					<s:text name="label.amendment.bgtreasuryApprover" /></c:if>
					<c:if test="${requestDetails.amendment.oldInstrumentTypeId eq 2}">
					<s:text name="label.amendment.sblctreasuryApprover" /></c:if>
			</h1>
			<hr class="page-title-hr">
			</c:if>
			<c:if test="${workFlowStage eq 'BUSAPROV'}">
				<h1 class="page-title span12">
				<c:if test="${requestDetails.amendment.oldInstrumentTypeId eq 1}">
					<s:text name="label.amendment.bgBusinessApprover" /></c:if>
					<c:if test="${requestDetails.amendment.oldInstrumentTypeId eq 2}">
					<s:text name="label.amendment.sblcBusinessApprover" /></c:if>
			 	 </h1>
				<p class="span12 left clear dashdesc"><s:text name="label.request.pageDesc.1" /> <s:property value="requestDetails.instrumentType"/> <s:text name="label.request.pageDesc.2"/>
				</p>
				<hr class="page-title-hr">
			</c:if>
			<s:hidden id="amdErrorMsgShowId" value="%{errorShow}"/>
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
			<div class="form-mod">		
				<div class="row">
					<div class="span12 request-summary">
						<p class="heading"><s:text name="label.request.requestSummary" />
						<c:if test="${not empty requestDetails.alocRecordId}">
		        		 - <span><s:text name="label.request.alocRecNo"/> </span><c:out value="${requestDetails.alocRecordId}"/>
		        		</c:if>
						</p>
						<div class="row lastrow">
							<div class="span2d"><div class="right"><label><s:text name="label.request.requestorName"/></label></div></div>
							<div class="span3 left"><s:property value="requestDetails.requestSummary.requestor.lastName"/>,<s:property value="requestDetails.requestSummary.requestor.firstName"/></div>
							<div class="span2a"><div class="right"><label><s:text name="label.request.instrumentPurpose"/></label></div></div>
							<div class="span3 left"><s:property value="requestDetails.transactionParties.instrumentPurpose"/></div>
						</div>
						<div class="row">
							<div class="span2d"><div class="right"><label><s:text name="label.request.requestorSSO"/></label></div></div>
							<div class="span3 left"><s:property value="requestDetails.requestSummary.requestor.ssoId"/></div>
							<div class="span2a"><div class="right"><label><s:text name="label.amendment.seqNo"/></label></div></div>
							<div class="span3 left"><s:property value="requestDetails.amendment.amendmentRequestId" /></div>
						</div>				
					</div>
				</div>
			</div>
			<s:set name="isEditMode" value="editMode" />
			
			<!-- Including Expiration Dates -->
			<div class="form-mod">
				<div class="acc_container">
				<div class="row">
                    <div class="span6">
                    	<div class="form-row">
						<h2 id="expirationDates" class="acc acc_active">
							<a href="javascript:;">
								<s:text	name="label.request.bglocSectionName.14" />
							</a>
						</h2><hr class="h2-hr">
						</div>
						<jsp:include page="amendmentTreasuryApprovalRequestSection.jsp">
							<jsp:param name="sectionId"	value="request.section.expirationDates" />
							<jsp:param name="includeScripts" value="false" />
							<jsp:param name="pageSection" value="Current" />
						</jsp:include>
					</div>
					<div class="span5 left">
						<jsp:include page="amendmentTreasuryApprovalRequestSection.jsp">
							<jsp:param name="sectionId"	value="request.section.expirationDates" />
							<jsp:param name="includeScripts" value="false" />
							<jsp:param name="pageSection" value="Previous" />
						</jsp:include>
					</div>
				</div>
				</div>
			</div>
			
			<div class="clear"></div>
			
			<!-- Including Instrument Amount/Currency -->
			<div class="form-mod">
				<div class="acc_container">
				<div class="row">
                    <div class="span6">
                    	<div class="form-row">
						<h2 id="instrumentAmountCurrency" class="acc acc_active">
							<a href="javascript:;">
								Instrument Details
							</a>
						</h2><hr class="h2-hr">
						</div>
						<jsp:include page="amendmentTreasuryApprovalRequestSection.jsp">
							<jsp:param name="sectionId"	value="request.section.instrumentAmountCurrency" />
							<jsp:param name="includeScripts" value="false" />
							<jsp:param name="pageSection" value="Current" />
						</jsp:include>
					</div>
					<%-- <div class="span5 left">
						<jsp:include page="amendmentTreasuryApprovalRequestSection.jsp">
							<jsp:param name="sectionId"	value="request.section.instrumentAmountCurrency" />
							<jsp:param name="includeScripts" value="false" />
							<jsp:param name="pageSection" value="Previous" />
						</jsp:include>
					</div> --%>
				</div>
				</div>
			</div>
			
			<div class="clear"></div>
			
			<!-- Including Transaction Parties -->
			<div class="form-mod">
				<div class="acc_container">
				<h2 id="transactionParties" class="acc acc_active">
					<a href="javascript:;">
						<s:text	name="label.request.bglocSectionName.1" />
					</a>
				</h2><hr class="h2-hr">
				<c:if test="${requestDetails.siteTypeName eq 'Financial Business'}">
					<s:if test="%{requestDetails.transactionParties.triPartyRequestFlag}">
					<div class="row">
	                    <div class="span6">	
	                    <div class="row smallrow">
							<div class="span2a">
								<h3 id="triPartyHeader"><s:text name="label.request.triPartyApplicant" /></h3>
								<hr class="hr3">
							</div>
						</div>
						<jsp:include page="amendmentTreasuryApprovalRequestSection.jsp">
							<jsp:param name="sectionId"	value="request.section.tripartyAddress" />
							<jsp:param name="includeScripts" value="false" />
							<jsp:param name="pageSection" value="Current" />
						</jsp:include>
						</div>
						<div class="span5 left">
							<jsp:include page="amendmentTreasuryApprovalRequestSection.jsp">
								<jsp:param name="sectionId"	value="request.section.tripartyAddress" />
								<jsp:param name="includeScripts" value="false" />
								<jsp:param name="pageSection" value="Previous" />
							</jsp:include>
						</div>
					</div>
					</s:if>
				</c:if>
				<s:if test="%{requestDetails.transactionParties.triPartyRequestFlag == null || requestDetails.transactionParties.triPartyRequestFlag == false}">
				<div class="row">
                    <div class="span6">	
                    	<div class="row smallrow">
							<div class="span2a">
							<h3 id="applicantHeader" ><s:text name="label.request.applicant"/></h3>
							<hr class="hr3">
							</div>
						</div>
						<jsp:include page="amendmentTreasuryApprovalRequestSection.jsp">
							<jsp:param name="sectionId"	value="request.section.tpapplicant" />
							<jsp:param name="includeScripts" value="false" />
							<jsp:param name="pageSection" value="Current" />
						</jsp:include>
					</div>
					<div class="span5 left">
						<jsp:include page="amendmentTreasuryApprovalRequestSection.jsp">
							<jsp:param name="sectionId"	value="request.section.tpapplicant" />
							<jsp:param name="includeScripts" value="false" />
							<jsp:param name="pageSection" value="Previous" />
						</jsp:include>
					</div>
				</div>
				</s:if>
				<jsp:include page="/jsp/common/request/amendment/amendmentLEDetails.jsp">
					<jsp:param value="TreasuryApprover" name="pageType"/>
				</jsp:include>
				<jsp:include page="/jsp/common/request/amendment/amendmentGERefDetails.jsp">
					<jsp:param value="TreasuryApprover" name="pageType"/>
				</jsp:include>
				<div class="row">
                    <div class="span6">	
                    	<div class="row smallrow">
							<div class="span2a">
							<h3 id="customerHeader"><s:text name="label.request.customer" /></h3>
							<hr class="hr3">
							</div>
						</div>
						<jsp:include page="amendmentTreasuryApprovalRequestSection.jsp">
							<jsp:param name="sectionId"	value="request.section.tpCustomerbeneficiary" />
							<jsp:param name="includeScripts" value="false" />
							<jsp:param name="pageSection" value="Current" />
						</jsp:include>
					</div>
					<div class="span5 left">
						<jsp:include page="amendmentTreasuryApprovalRequestSection.jsp">
							<jsp:param name="sectionId"	value="request.section.tpCustomerbeneficiary" />
							<jsp:param name="includeScripts" value="false" />
							<jsp:param name="pageSection" value="Previous" />
						</jsp:include>
					</div>
				</div>
				<jsp:include page="/jsp/common/request/amendment/amendmentCustBenRefDetails.jsp">
					<jsp:param value="TreasuryApprover" name="pageType"/>
				</jsp:include>
				</div>
			</div>
			<div class="clear"></div>
			
			<!-- Including Other Changes -->
			<div class="form-mod">
				<h2 id="otherChanges" class="section_flip">
					<a href="javascript:;">
						<s:text	name="label.request.bglocSectionName.18" />
					</a>
				</h2><hr class="h2-hr">
				<div id="otherChangesPanel" class="section_panel">
					<jsp:include page="amendmentTreasuryApprovalRequestSection.jsp">
						<jsp:param name="sectionId"	value="request.section.otherChanges" />
						<jsp:param name="includeScripts" value="false" />
						<jsp:param name="pageSection" value="Current" />
					</jsp:include>
				</div>
			</div>
			<div class="clear"></div>
			
			<!-- Including Delivery Instruction -->
			<div class="form-mod">
			<div class="acc_container">
			<div class="row">
                    <div class="span6">
                    <div class="form-row">
		   		<h2 id="deliveryInstructions" class="acc acc_active">
					<a href="javascript:;"><s:text name="label.request.bglocSectionName.8"/></a>
				</h2><hr class="h2-hr">
				</div>
					<jsp:include page="amendmentTreasuryApprovalRequestSection.jsp">
						<jsp:param name="sectionId"  value="request.section.deliveryInstructions" />
						<jsp:param name="includeScripts" value="false" />
						<jsp:param name="pageSection" value="Current" />
					</jsp:include>
		   	</div>
		   		<div class="span6 left">
						<jsp:include page="amendmentTreasuryApprovalRequestSection.jsp">
							<jsp:param name="sectionId"  value="request.section.deliveryInstructions" />
							<jsp:param name="includeScripts" value="false" />
							<jsp:param name="pageSection" value="Previous" />
						</jsp:include>
					</div>
		   	</div>
		   	</div>
		   	</div>
			<div class="clear"></div>
			
			<!-- Including Attachments   -->
			<div class="form-mod" id="attachmentsDiv">
				<h2 id="attachmentsFlip" class="section_flip">
					<a href="javascript:;"><s:text
							name="label.request.bglocSectionName.9" /></a>
				</h2><hr class="h2-hr">
				<div id="attachmentsFlipPanel" class="section_panel">
					<jsp:include page="amendmentTreasuryApprovalRequestSection.jsp">
						<jsp:param name="sectionId"	value="request.section.attachments" />
						<jsp:param name="includeScripts" value="false" />
					</jsp:include>
				</div>
			</div>
			<div class="clear"></div>
			
			
			<!-- Including Audit Log and Tranaction History   -->
			<div class="form-mod">
	    		<jsp:include page="/jsp/common/request/auditAndTransactionHistoryLog.jsp"/>	            
   			</div>		
   			<div class="clear"></div>
   			<s:form id="approverSubmitForm" action="approverSubmit">
   				<s:hidden name="amendmentOrRiderRequestId" value="%{requestDetails.amendment.amendmentRequestId}" id="AmendmentOrRiderId"/>
   				<div class="row smallrow" id="postAwardComments">
       			<div class="span12">
	  		   		<h3 class="dashdesc"><s:text name="label.request.comments" /></h3>
	  		   		<hr class="page-title-hr">
	           		<label><s:text name="label.request.commentsOptional" /></label>
					<s:textarea name="requestDetails.comments" theme="aloc" onkeypress="return imposeMaxLength(this, 399);"
						cssClass="autosize messageinput" id="tdcomments" required="false"/>
	           		<div class="clear"></div>
	           		<div class="counter" id="postAwardCounter"><s:text name="label.request.fourHundred"/></div> <!-- fix positions -->
	           		<div class="counterTxt"><p class="guidance"><s:text name="label.request.textSize"/> <!--left (Limit is 400 characters) --></p></div>
                </div>
                </div>   
   				<s:hidden name="requestDetails.instrumentTypeId" id="instrumentTypeId" />
				<s:hidden name="requestDetails.requestId" id="requestId" />
				<s:hidden name="requestDetails.WFDetails.WFStage" id="WFStage" />
				 <input type="hidden" name="actionType" id="actionTypeId" value="${actionType}"/>
				<s:url action="cancel.action" namespace="/int/approver" var="cancelBtnlURL"/>
			 <div id="submitDiv">
				<div>
				<jsp:include page="/jsp/requestor/approveOrReject.jsp"/>		
				</div>
   			</div> 
   			</s:form>
		   
		</div>
		<div id="fullHistoryDiv" style="width: 100%;"></div>
</div>

	<%@include file="../../../common/footerSection.jsp"%>
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