<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp"%>
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
<script	src="${pageContext.request.contextPath}/js/requestor/postAward.js" type="text/javascript"></script>
</head>

<body>
	<div class="container main">
		<%@include file="../../common/headerSection.jsp"%>
		<div id="mainPage" style="width: 100%;">
		
			<h1 class="page-title span12">
				Surety rider Issuance/Rejection
			</h1>
			<p class="span12 left clear dashdesc">
				<s:text name="label.request.treasuryBidAwardLine" /></p>
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
	<!-- EXIT REQUEST POPUP WINDOW -->
	<s:url action="cancel.action" namespace="/int/approver" var="cancelBtnlURL"/>
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