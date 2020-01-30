<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
 <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%@include file="../../common/includeCommonScripts.jsp"%>
<title><s:text name="label.amendment.pageTitle" /></title>
<link href="${pageContext.request.contextPath}/css/common/amendment.css" type="text/css" rel="stylesheet" />
<script src="${pageContext.request.contextPath}/js/requestor/requestor.js" type="text/javascript"></script>
<script	src="${pageContext.request.contextPath}/js/requestor/postAward.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/requestor/lookup.js"	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/common/toWord.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/common/amendment.js"	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/common/pagination.js"></script>
<link href="${pageContext.request.contextPath}/css/common/pagenavi.css" type="text/css" rel="stylesheet" />
</head>

<body>
	<div class="container main">
		<%@include file="../../common/headerSection.jsp"%>
		<div id="mainPage" style="width: 100%;">
		
			<h1 class="page-title span12">
				Post award
				-
				<s:property value="requestDetails.instrumentType" />
			</h1>
			<p class="span12 left clear dashdesc">
				<s:text name="label.amendment.trAnalyst.subTitle" /></p>
				 <hr class="page-title-hr">
			<div class="clear"></div>
			
			<s:hidden name="requestDetails.instrumentTypeId" id="instrumentTypeId" />
			<s:hidden name="requestDetails.requestId" id="requestId" />
			<s:hidden name="requestDetails.WFDetails.WFStage" id="WFStage" />
			<c:set var="workFlowStage" value="${requestDetails.WFDetails.WFStage}"></c:set>
			
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
		    
	    <s:hidden id="errorMsgShowPost" value="%{errorShow}"/>
		<div class="row hide" id="postAwardErrorDiv">
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
				<div class="row">
					<div class="span12 request-summary">
						
						<div class="row lastrow">
							<div class="span8"><p class="heading"><s:text name="label.request.requestSummary" /> - 
							<span><s:text name="label.request.alocRecNo"/></span> 
							<c:out value="${requestDetails.alocRecordId}"/></p>
							</div>
							<!-- <div class="span2a"><div class="right"><label>Model name:</label></div></div>
							<div class="span1 left">&#60;Value&#62;</div> -->
						</div>
						<div class="row lastrow">
							<div class="span22"><div class="right"><s:label key="label.request.requestorName"/> </div></div>
							<div class="span2 left"><s:property value="requestDetails.requestSummary.requestor.lastName"/>,<s:property value="requestDetails.requestSummary.requestor.firstName"/></div>
							<div class="span2a"><div class="right"><s:label key="label.request.instrumentPurpose"/> </div></div>
							<div class="span1 left"><s:property value="requestDetails.transactionParties.instrumentPurpose"/></div>
							<div class="span2a"><div class="right"> <s:label key="label.amendment.seqNo"/> </div></div>
							<div class="span1a left"><s:property value="requestDetails.amendment.amendmentRequestId" /></div>
						</div>
						<div class="row">
							<div class="span22"><div class="right"><s:label key="label.request.requestorSSO"/> </div></div>
							<div class="span3 left"><s:property value="requestDetails.requestSummary.requestor.ssoId"/></div>
							
						</div>				
					</div>
				</div>
			</div>

   	
			<div class="clear"></div>
			
			<s:set name="isEditMode" value="editMode" />
			
			<!-- Including Expiration Dates -->
			<div class="form-mod">
				<jsp:include page="amendmentTreasuryAnalystSection.jsp">
					<jsp:param name="sectionId"	value="request.section.expirationDates" />
					<jsp:param name="includeScripts" value="false" />
				</jsp:include>
			</div>
			
			<div class="clear"></div>
			
			<!-- Including Instrument Details  -->
			<div class="form-mod">
				<jsp:include page="amendmentTreasuryAnalystSection.jsp">
					<jsp:param name="sectionId"	value="request.section.instrumentAmountCurrency" />
					<jsp:param name="includeScripts" value="false" />
				</jsp:include>
			</div>
			<div class="clear"></div>
			
			<!-- Including tri party  -->
			<div class="form-mod">
				<div class="acc_container">
				<h2 id="transactionParties" class="acc acc_active">
					<a href="javascript:;">
						<s:text	name="label.request.bglocSectionName.1" />
					</a>
				</h2><hr class="h2-hr">
				<c:if test="${requestDetails.siteTypeName eq 'Financial Business'}">
					<s:if test="%{requestDetails.transactionParties.triPartyRequestFlag}">
						<jsp:include page="amendmentTreasuryAnalystSection.jsp">
							<jsp:param name="sectionId"	value="request.section.tripartyAddress" />
							<jsp:param name="includeScripts" value="false" />
						</jsp:include>
					</s:if>
				</c:if>
				<s:if test="%{requestDetails.transactionParties.triPartyRequestFlag == null || requestDetails.transactionParties.triPartyRequestFlag == false}">
				<jsp:include page="amendmentTreasuryAnalystSection.jsp">
					<jsp:param name="sectionId" value="request.section.tpapplicant" />
					<jsp:param name="includeScripts" value="false" />
				</jsp:include>
				</s:if>
				<jsp:include page="amendmentTreasuryAnalystSection.jsp">
					<jsp:param name="sectionId"	value="request.section.tpCustomerbeneficiary" />
					<jsp:param name="includeScripts" value="false" />
				</jsp:include>
				</div>
			</div>
			<div class="clear"></div>
			
			<!-- Including Other Changes  -->
			<div class="form-mod">
				<jsp:include page="amendmentTreasuryAnalystSection.jsp">
					<jsp:param name="sectionId"	value="request.section.otherChanges" />
					<jsp:param name="includeScripts" value="false" />
				</jsp:include>
			</div>
			<div class="clear"></div>
			
			<!-- Including Delivery instrctions   -->
			<div class="form-mod">
		   		<jsp:include page="amendmentTreasuryAnalystSection.jsp">
					<jsp:param name="sectionId"  value="request.section.deliveryInstructions" />
					<jsp:param name="includeScripts" value="false" />
				</jsp:include>
		   </div>
		   <!-- Including Attachments   -->
			<div class="form-mod" id="attachmentsDiv">
				<jsp:include page="amendmentTreasuryAnalystSection.jsp">
					<jsp:param name="sectionId" value="request.section.attachments" />
					<jsp:param name="includeScripts" value="false" />
				</jsp:include>
			</div>
			
			<!-- Including Audit Log and Tranaction History   -->
			<div class="form-mod">
	    		<jsp:include page="/jsp/common/request/auditAndTransactionHistoryLog.jsp"/>	            
   			</div>		
   			<div class="clear"></div>
   	
	
			<s:form id="postawardSubmitForm" action="postAwardSubmit">
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
			<input type="hidden" name="actionType" id="actionTypeId" value="${actionType}">
			<div class="form-mod">
				 <jsp:include page="/jsp/requestor/saveAndSendBack.jsp" />
			</div>
			<div class="clear"></div>
			</s:form>
		</div>
		<div id="lookupDiv" style="width: 100%;"></div>
		<div id="fullHistoryDiv" style="width: 100%;"></div>
</div>
	<%@include file="../../common/footerSection.jsp"%>
	<!-- Exit Request Modal -->
	<s:url action="cancel.action" namespace="/int/approver" var="cancelBtnlURL"/>
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
		    <a href="<s:property value="#cancelBtnlURL" />" class="btn-secondary"><s:text name="label.request.popUpCancelYes"/></a>
			<a href="javascript:;" class="btn-tertiary cancel" data-dismiss="modal"><s:text name="label.request.popUpCancelNo"/></a>
		</div>
</div>
</body>
</html>