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
	type="text/javascript"></script>

<script src="${pageContext.request.contextPath}/js/common/toWord.js"
	type="text/javascript"></script>
	
<script src="${pageContext.request.contextPath}/js/common/amendment.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/common/pagination.js"></script>
<link href="${pageContext.request.contextPath}/css/common/pagenavi.css" type="text/css" rel="stylesheet" />
</head>

<body>
	<div class="container main">
		<jsp:include page="../../../common/headerSection.jsp">
			<jsp:param name="createReqPopup" value="Yes"></jsp:param>
		</jsp:include>
		<s:hidden name="approver" value="wants" id="approver"/>
		<div id="mainPage" style="width: 100%;">
		<s:form id="submitAmendmentFormID" action="submitAmendment">
			<s:hidden name="requestDetails.instrumentTypeId" id="instrumentTypeId" />
			<s:hidden name="requestDetails.requestId" id="requestId" />
			<s:hidden name="requestDetails.WFDetails.WFStage" id="WFStage" />
			<s:hidden name="requestDetails.siteTypeName" value="%{requestDetails.siteTypeName}" id="siteTypeNameId"></s:hidden>
			<s:hidden name="amendmentOrRiderRequestId" value="%{requestDetails.amendment.amendmentRequestId}" id="AmendmentOrRiderId"/>
			<s:hidden name="requestDetails.transactionParties.triPartyRequestFlag" value="%{requestDetails.transactionParties.triPartyRequestFlag}" id="triPartyRequestFlag"></s:hidden>
			<input type="hidden" value="${requestDetails.amendment.transactionParties.tpApplicantDetails.addressDtls.stateProvinceCd}" id="amdApplicantAddStateCd">
			<input type="hidden" value="${requestDetails.amendment.transactionParties.tpApplicantDetails.addressDtls.countryCd}" id="amdApplicantAddCountryCd">
			<input type="hidden" value="${requestDetails.amendment.transactionParties.customer.addressDtls.stateProvinceCd}" id="amdCustomerAddStateCd">
			<input type="hidden" value="${requestDetails.amendment.transactionParties.customer.addressDtls.countryCd}" id="amdCustomerAddCountryCd">
			
			<c:set var="workFlowStage" value="${requestDetails.WFDetails.WFStage}"></c:set>
			<c:if test="${workFlowStage eq 'BUSAPROV'  or (workFlowStage ne 'REQEST' and workFlowStage ne 'REQUEST')}">
				<h1 class="page-title span12">
				   <c:choose>
				   	<c:when test="${requestDetails.amendment.oldInstrumentTypeId eq 1}">
				   		<s:text name="label.amendment.bgPageTitleHeader" />
				   	</c:when>
				   	<c:when test="${requestDetails.amendment.oldInstrumentTypeId eq 2}">
				   		<s:text name="label.amendment.sblcPageTitleHeader" />
				   	</c:when>
				   	<c:otherwise><s:text name="label.amendment.pageTitleHeader" >
						<s:param><s:property value="requestDetails.amendment.oldInstrumentTypeId"/></s:param>
					</s:text></c:otherwise>
				   </c:choose>
				</h1>
				<p class="span12 left clear dashdesc">
					<s:text name="label.amendment.subTitle"/>
				</p>
				<hr class="page-title-hr">
			</c:if>
			<c:if test="${workFlowStage eq 'REQEST' or workFlowStage eq 'REQUEST'}">
				<h1 class="page-title span12">
					<c:if test="${requestDetails.amendment.oldInstrumentTypeId eq 1}">
					<s:text name="label.returnedAmendment.bgPageTitleHeader" /></c:if>
					<c:if test="${requestDetails.amendment.oldInstrumentTypeId eq 2}">
					<s:text name="label.returnedAmendment.sblcPageTitleHeader" /></c:if>
				</h1>
				<p class="span12 left clear dashdesc">
					<s:text name="label.amendment.trAnalyst.subTitle"/>
				</p>
				<hr class="page-title-hr">
			</c:if>
			<s:hidden name="validationSuccess" id="amendmentvalidationId"/>
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
			<s:set name="isEditMode" value="editMode" />
			<!-- REQUEST SUMMARY -->
			
			<c:if test="${workFlowStage eq 'BUSAPROV'  or (workFlowStage ne 'REQEST' and workFlowStage ne 'REQUEST')}">
				 <jsp:include page="/jsp/common/request/amendment/amendmentRequestSummary.jsp">
					<jsp:param value="CreateNewAmendment" name="pageType"/>
				 </jsp:include>
				  <h1 style="visibility: visible;">Original Request Details</h1>
			</c:if>
			<c:if test="${workFlowStage eq 'REQEST' or workFlowStage eq 'REQUEST'}">
			  	<jsp:include page="/jsp/common/request/amendment/amendmentRequestSummary.jsp">
					<jsp:param value="ReSubmitAmendment" name="pageType"/>
				 </jsp:include>
				
			 </c:if>
			<!-- Including Expiration Dates -->
			<div class="form-mod">
				<h2 id="expirationDates" class="section_flip section_blue">
					<a href="javascript:;">
						<s:text	name="label.request.bglocSectionName.14" />
					</a>
				</h2><hr class="h2-hr">
				<div id="expirationDatesPanel" class="section_panel">
					<jsp:include page="amendmentRequestSection.jsp">
						<jsp:param name="sectionId"	value="request.section.expirationDates" />
						<jsp:param name="includeScripts" value="false" />
					</jsp:include>
				</div>
			</div>
			<div class="clear"></div>
			<!-- Including Instrument Amount/Currency -->
			<div class="form-mod">
				<h2 id="instrumentAmountCurrency" class="section_flip section_blue">
					<a href="javascript:;">
						<s:text	name="label.request.bglocSectionName.13" />
					</a>
				</h2><hr class="h2-hr">
				<div id="instrumentAmountCurrencyPanel" class="section_panel">
					<jsp:include page="amendmentRequestSection.jsp">
						<jsp:param name="sectionId"	value="request.section.instrumentAmountCurrency" />
						<jsp:param name="includeScripts" value="false" />
					</jsp:include>
				</div>
			</div>
			<div class="clear"></div>
			<!-- Including Transaction Parties -->
			<div class="form-mod">
				<h2 id="transactionParties" class="section_flip section_blue">
					<a href="javascript:;">
						<s:text	name="label.request.bglocSectionName.1" />
					</a>
				</h2><hr class="h2-hr">
				<div id="transactionPartiesPanel" class="section_panel">
				
					<jsp:include page="amendmentRequestSection.jsp">
						<jsp:param name="sectionId"  value="request.section.amendmentTransactionParties" />
						<jsp:param name="includeScripts" value="false" />
					</jsp:include>
				</div>
			</div>
			<div class="clear"></div>
			
			<!-- Including Other Changes -->
			<div class="form-mod">
				<h2 id="otherChanges" class="section_flip section_blue">
					<a href="javascript:;">
						<s:text	name="label.request.bglocSectionName.18" />
					</a>
				</h2><hr class="h2-hr">
				<div id="otherChangesPanel" class="section_panel">
					<jsp:include page="amendmentRequestSection.jsp">
						<jsp:param name="sectionId"	value="request.section.otherChanges" />
						<jsp:param name="includeScripts" value="false" />
					</jsp:include>
				</div>
			</div>
			<div class="clear"></div>
			
			<!-- Including Delivery Instructions -->
			<div class="form-mod">
		   		<h2 id="deliveryInstructions" class="section_flip">
					<a href="javascript:;"><s:text name="label.request.bglocSectionName.8"/></a>
				</h2><hr class="h2-hr">
				<div id="deliveryInstructionsPanel" class="section_panel">
					<jsp:include page="amendmentRequestSection.jsp">
						<jsp:param name="sectionId"  value="request.section.deliveryInstructions" />
						<jsp:param name="includeScripts" value="false" />
					</jsp:include>
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
					<jsp:include page="amendmentRequestSection.jsp">
						<jsp:param name="sectionId"	value="request.section.attachments" />
						<jsp:param name="includeScripts" value="false" />
					</jsp:include>
				</div>
			</div>
			
			<!-- Including Audit Log and Tranaction History   -->
			<c:if test="${workFlowStage eq 'REQEST' or workFlowStage eq 'REQUEST'}">
				<div class="form-mod">
		    		<jsp:include page="/jsp/common/request/auditAndTransactionHistoryLog.jsp"/>	            
	   			</div>
   			</c:if>		
   			<div class="clear"></div>
   			
   			<c:if test="${workFlowStage eq 'REQEST' or workFlowStage eq 'BUSAPROV' or workFlowStage eq 'REQUEST'}">
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
        	</c:if>  
   			<div>
				<jsp:include page="/jsp/common/request/suretyRider/saveAndSubmitRider.jsp" />
			</div>
   			
		</s:form>	
		</div>
		<div id="lookupDiv" style="width: 100%;"></div>
		<div id="fullHistoryDiv" style="width: 100%;"></div>
	</div>
	
	<%@include file="../../../common/footerSection.jsp"%>
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
	<script src="${pageContext.request.contextPath}/js/common/amdStateAndCountry.js"
	type="text/javascript"></script>
</body>
</html>