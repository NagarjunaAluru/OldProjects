<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<s:set name="test" value="true"/>
<!DOCTYPE html>
<html>
<head>
 <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">


<%@include file="../../common/includeCommonScripts.jsp"%>
<title><s:text name="label.bidaward.bgAndSlocTitle" /> - <s:property value="requestDetails.instrumentType" /></title>

<script	src="${pageContext.request.contextPath}/js/requestor/requestor.js" type="text/javascript"></script>
<script	src="${pageContext.request.contextPath}/js/requestor/bgRequestor.js" type="text/javascript"></script>
<script	src="${pageContext.request.contextPath}/js/requestor/postAward.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/requestor/lookup.js"	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/common/toWord.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/requestor/fieldCounter.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/requestor/addReference.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/common/pagination.js"></script>
<link href="${pageContext.request.contextPath}/css/common/pagenavi.css" type="text/css" rel="stylesheet" />
</head>

<body>

	<div class="container main">
		<jsp:include page="../../common/headerSection.jsp">
			<jsp:param name="createReqPopup" value="Yes"></jsp:param>
		</jsp:include>
		<div id="mainPage" style="width: 100%;">
			<h1 class="page-title span12">
				<s:text name="label.bidaward.bgAndSlocTitle"></s:text>
				-
				<s:property value="requestDetails.instrumentType" />
				
			</h1>
			<p class="span12 left clear dashdesc">
				<s:text name="label.bidaward.bgAndSlocSubTitle" />
			</p>
			<hr class="page-title-hr">
	<div class="clear"></div>		
			 <!-- REQUEST SUMMARY -->
	<div id="requestSummary" >
    	<div class="row lastrow">
    		<div class="span10">
        	<p><strong><s:text name="label.request.requestDetails"/></strong>
        	<c:if test="${not empty requestDetails.requestId}">
        	 - <s:text name="label.request.alocRecNo"/> <strong><s:property value="requestDetails.alocRecordId"/></strong>
        	</c:if>
        	</p>
        	</div>
        </div>
        	<div class="row lastrow">
					<div class="span2"><div class="right"><label><s:text name="label.request.bankReplying"/>:</label></div></div>
					<div class="span3 left"><s:if test="%{requestDetails.winningBankDetails.winnerDetails.winningBankName==null}">-</s:if>
					<s:else><s:property value="requestDetails.winningBankDetails.winnerDetails.winningBankName"/></s:else>
					</div>
					<div class="span2b"><div class="right"><label><s:text name="label.request.validityDate"/>:</label></div></div>
					<div class="span3 left"><s:property value="requestDetails.bidReplyDetails.bidExpirationDate"/></div>
				</div>
				<div class="row lastrow">
					<div class="span2"><div class="right"><label><s:text name="label.request.bankPerson"/>:</label></div></div>
					<div class="span3 left"><s:property value="requestDetails.bankContactLname"/>,<s:property value="requestDetails.bankContactFname"/></div>
					<div class="span2b"><div class="right"><label><s:text name="label.request.validitytime"/>:</label></div></div>
					<div class="span3 left"><s:date name="requestDetails.bidReplyDetails.bidExpirationDate" format="HH:mm aa zzz"/></div>
				</div>
				<s:if test="%{requestDetails.actionDetails.reasonForOptingOut != null && requestDetails.actionDetails.reasonForOptingOut!=''}">
				<div class="row lastrow">
					<div class="span2"><div class="right"><label><s:text name="label.request.reasonForOptingout"/>:</label></div></div>
					<div class="span3 left"><s:property value="requestDetails.actionDetails.reasonForOptingOut"/></div>
				</div>	
				</s:if>
        </div><!-- leftColRS ends here -->
        
   <div class="clear"></div>
    <!-- requestSummary ends here -->
    
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
		<div class="row">
		<div class="span12">
			<label><s:text  name="label.request.notification.wantTo"/> :</label>
				<s:radio theme="aloc" cssClass="radio"
						name="wantAward" id="awardRadioOpt"
						list="#{'true':'Review details and edit','false':'Restart bid process'}"/>
		</div>
		</div>
	</div>
	<div id="awardReviewEdit" class="hide">
		<!-- Including Transaction Parties  -->
			<s:set name="isEditMode" value="editMode" />
			<s:hidden name="showReimbursement" id="showReimbursement" value="%{errorShow}"/>

			<div class="form-mod">
				<h2 id="transactionParties" class="section_flip section_blue">
					<a href="javascript:;"><s:text
							name="label.request.bglocSectionName.1" /></a>
				</h2><hr class="h2-hr">
				<div id="transactionPartiesPanel" class="section_panel fieldcount_panel">

					<jsp:include page="bgtreasuryAnalystSection.jsp">
						<jsp:param name="sectionId" value="request.section.tripartyFlag" />
						<jsp:param name="saveAndNextSectionButtonKey" value="key" />
						<jsp:param name="includeScripts" value="false" />
					</jsp:include>
					
					<c:if test="${requestDetails.siteTypeName eq 'Financial Business'}">
					<s:if test="%{requestDetails.transactionParties.triPartyRequestFlag != null && requestDetails.transactionParties.triPartyRequestFlag}">
		
						<h3 id="triPartyHeader">
							<s:text name="label.request.triPartyApplicant" />
						</h3>
						<hr class="hr3">
						<jsp:include page="bgtreasuryAnalystSection.jsp">
							<jsp:param name="sectionId"
								value="request.section.tripartyAddress" />
							<jsp:param name="saveAndNextSectionButtonKey" value="key" />
							<jsp:param name="includeScripts" value="false" />
						</jsp:include>
					</s:if>
					</c:if>
					<h3 id="applicantHeader">
						<s:text name="label.request.applicant" />
					</h3>
					<hr class="hr3">
					<jsp:include page="bgtreasuryAnalystSection.jsp">
						<jsp:param name="sectionId" value="request.section.tpapplicant" />
						<jsp:param name="saveAndNextSectionButtonKey" value="key" />
						<jsp:param name="includeScripts" value="false" />
					</jsp:include>

					<h3 id="customerHeader">
						<s:text name="label.request.customer" />
					</h3>
					<hr class="hr3">
					<jsp:include page="bgtreasuryAnalystSection.jsp">
						<jsp:param name="sectionId"
							value="request.section.tpCustomerbeneficiary" />
						<jsp:param name="saveAndNextSectionButtonKey" value="key" />
						<jsp:param name="includeScripts" value="false" />
					</jsp:include>

				</div>
			</div>

			<div class="clear"></div>

			<!-- Including Project Description  -->
			<div class="form-mod">
				<h2 id="projectDescription" class="section_flip">
					<a href="javascript:;"><s:text
							name="label.request.bglocSectionName.2" /></a>
				</h2><hr class="h2-hr">
				<div id="projectDescriptionPanel" class="section_panel fieldcount_panel">
					<jsp:include page="bgtreasuryAnalystSection.jsp">
						<jsp:param name="sectionId"
							value="request.section.projectDescription" />
						<jsp:param name="saveAndNextSectionButtonKey" value="key" />
						<jsp:param name="includeScripts" value="false" />
					</jsp:include>

				</div>
			</div>
			<!-- Including Instrument Details  -->
			<div class="form-mod">
				<h2 id="instrumentDetails" class="section_flip">
					<a href="javascript:;"><s:text
							name="label.request.bglocSectionName.3" /></a>
				</h2><hr class="h2-hr">
				<div id="instrumentDetailsPanel" class="section_panel fieldcount_panel">
					<jsp:include page="bgtreasuryAnalystSection.jsp">
						<jsp:param name="sectionId"
							value="request.section.instrumentDetails" />
						<jsp:param name="saveAndNextSectionButtonKey" value="key" />
						<jsp:param name="includeScripts" value="false" />
					</jsp:include>

				</div>
			</div>

			<!-- Including Instrument Risk  -->
			<div class="form-mod">
				<h2 id="instrumentRisk" class="section_flip">
					<a href="javascript:;"><s:text
							name="label.request.bglocSectionName.4" /></a>
				</h2><hr class="h2-hr">
				<div id="instrumentRiskPanel" class="section_panel fieldcount_panel">
					<jsp:include page="bgtreasuryAnalystSection.jsp">
						<jsp:param name="sectionId" value="request.section.instrumentRisk" />
						<jsp:param name="saveAndNextSectionButtonKey" value="key" />
						<jsp:param name="includeScripts" value="false" />
					</jsp:include>

				</div>
			</div>

			<!-- Including Standby Letter of Credit Conditions  -->
			<c:if
				test="${requestDetails.instrumentType eq 'Standby Letter Of Credit'}">
				<div class="form-mod">
					<h2 id="locConditions" class="section_flip">
						<a href="javascript:;"><s:text
								name="label.request.bglocSectionName.5" /></a>
					</h2><hr class="h2-hr">
					<div id="locConditionsPanel" class="section_panel fieldcount_panel">
						<jsp:include page="bgtreasuryAnalystSection.jsp">
							<jsp:param name="sectionId"
								value="request.section.standbyLetterofCredit" />
							<jsp:param name="saveAndNextSectionButtonKey" value="key" />
							<jsp:param name="includeScripts" value="false" />
						</jsp:include>
					</div>
				</div>
			</c:if>
			<!-- Including Instrument Reporting Attributes  -->
			<div class="form-mod">
				<h2 id="instrumentReporting" class="section_flip">
					<a href="javascript:;"><s:text
							name="label.request.bglocSectionName.6" /></a>
				</h2><hr class="h2-hr">
				<div id="instrumentReportingPanel" class="section_panel fieldcount_panel">
					<jsp:include page="bgtreasuryAnalystSection.jsp">
						<jsp:param name="sectionId"
							value="request.section.instrumentReporting" />
						<jsp:param name="saveAndNextSectionButtonKey" value="key" />
						<jsp:param name="includeScripts" value="false" />
					</jsp:include>
				</div>
			</div>
			<!-- Including Format   -->
			<div class="form-mod" id="formatDiv">
				<h2 id="formatSectionFlip" class="section_flip">
					<a href="javascript:;"><s:text name="label.request.bglocSectionName.7" /> 
						<span id="formatSelectionH2"></span>
					</a>
				</h2><hr class="h2-hr">
				<div id="formatSectionFlipPanel" class="section_panel">
					<jsp:include page="bgtreasuryAnalystSection.jsp">
						<jsp:param name="sectionId" value="request.section.format" />
						<jsp:param name="saveAndNextSectionButtonKey" value="key" />
						<jsp:param name="includeScripts" value="false" />
					</jsp:include>
				</div>
			</div>

			<!-- Delivery Instructions -->
			<div class="form-mod">
				<h2 id="deliveryInstructions" class="section_flip">
					<a href="javascript:;"><s:text
							name="label.request.bglocSectionName.8" /></a>
				</h2><hr class="h2-hr">
				<div id="deliveryInstructionsPanel" class="section_panel fieldcount_panel">
					<jsp:include page="bgtreasuryAnalystSection.jsp">
						<jsp:param name="sectionId"
							value="request.section.deliveryInstructions" />
						<jsp:param name="saveAndNextSectionButtonKey" value="key" />
						<jsp:param name="includeScripts" value="false" />
					</jsp:include>

				</div>

			</div>
			<!-- Including Attachments   -->
			<div class="form-mod" id="attachmentsDiv">
				<h2 id="attachmentsFlip" class="section_flip">
					<a href="javascript:;"><s:text
							name="label.request.bglocSectionName.9" /></a>
				</h2><hr class="h2-hr">
				<div id="attachmentsFlipPanel" class="section_panel">
					<jsp:include page="bgtreasuryAnalystSection.jsp">
						<jsp:param name="sectionId" value="request.section.attachments" />
						<jsp:param name="saveAndNextSectionButtonKey" value="key" />
						<jsp:param name="includeScripts" value="false" />
					</jsp:include>
					<br />
				</div>
			</div>
			
			<!-- Audit and Transaction History Log -->
			 <div class="form-mod" id="auditAndTransactionHistoryLog">
   				<jsp:include page="/jsp/common/request/auditAndTransactionHistoryLog.jsp" />
   			</div>
			<div class="row" id="readySystemCheckSection">
				<div class="span12 btn-container">
					<div class="form-row">
						<s:form id="readysystemSubmitForm">
							<s:url id="readySystemCheckURL" action="readySystemCheck" >
								<s:param name="include">Yes</s:param>
							</s:url>
							<sj:submit key="label.request.readysystemChecks"
								cssClass="btn-primary" cssStyle="margin-left: 20px;"
								replaceTarget="true" targets="auditAndTransactionHistoryLog"
								href="%{readySystemCheckURL}"
								onCompleteTopics="showReimbursement" 
								indicator="readySystemCheck"
								/>
							<input type="hidden" name="actionType" value="8" />
							<s:url id="readysystemCancel" action="cancel" />
							<s:a href="%{readysystemCancel}"
								key="label.request.common.cancel" cssClass="btn-tertiary cancel">
								<s:text name="label.request.common.cancel"></s:text>
							</s:a>
							<img alt="Loading..." id="readySystemCheck" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px;">
						</s:form>
					</div>
				</div>
				<!-- end of block -->
			</div>
			<div class="row ibsClassWarningTA" style="display: none;">
				<div class="span12">
	                <div class="errorbox">
	                	<div class="errorHead"><p class="erroricon"><s:text name="label.common.error"/></p></div>
						<div class="errorContent">
			                <p id="ibsMessageinTA"></p>
		                </div>
	                </div>
            	</div>
			</div>
			<div class="row ibsClassWarningTA" style="display: none;">
				<div class="span12">
	                <div class="errorbox">
	                	<div class="errorHead"><p class="erroricon"><s:text name="label.common.error"/></p></div>
						<div class="errorContent">
			                <p><s:text name="label.request.bucDisabledByTreasury"/></p>
			                <p><s:text name="label.request.VisitHelpAreaFurtherInformation"/></p>
		                </div>
	                </div>
            	</div>
			</div>
			
			<div class="clear"></div>		
			<div id="tracksectionDiv">
				<jsp:include page="/jsp/common/request/bgTrackSection.jsp" />	
			</div>	
		</div>
		
		<s:form id="postawardSubmitForm" action="postAwardSubmit">
		<div class="row smallrow hide" id="postAwardComments">
       			<div class="span12">
	  		   		<h3 class="dashdesc"><s:text name="label.request.comments" /></h3>
	  		   		<hr class="page-title-hr">
	           		<label><s:text name="label.request.commentsOptional" /></label>
					<s:textarea name="requestDetails.comments" theme="aloc"
						cssClass="autosize messageinput" id="tdcomments" required="false"/>
	           		<div class="clear"></div>
	           		<div class="counter" id="postAwardCounter"><s:text name="label.request.fourHundred"/></div> <!-- fix positions -->
	           		<div class="counterTxt"><p class="guidance"><s:text name="label.request.textSize"/> <!--left (Limit is 400 characters) --></p></div>
                </div>
        </div>   
		
		<input type="hidden" name="actionType" id="actionTypeId" value="${actionType}">
		<div class="hide form-mod" id="submitDiv">
			 <jsp:include page="/jsp/requestor/saveAndSendBack.jsp" />
		</div>
		<div class="clear"></div>
		<div class="hide highlighted" id="restartBidProcess" style="height:30px;">
			<div class="row">
				<div class="span12">
				      <s:submit key="label.request.createBidMemo" onclick="submitAction(34)" cssClass="btn-primary left"/>
					  <a href="#" class="btn-tertiary cancel clearEntries" data-toggle="modal" ><s:text name="label.request.exitRequest" /></a>
				</div>
			</div>
		</div>
		<div class="clear"></div>
		</s:form>
	</div>
	
	<div id="lookupDiv" style="width: 100%;"></div>	
	<div id="fullHistoryDiv" style="width: 100%;"></div>
</div>
	<%@include file="../../common/footerSection.jsp"%>
	<s:url action="cancel.action" namespace="/int/approver" var="cancelBtnlURL"/>
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
		    <a href="<s:property value="#cancelBtnlURL" />" class="btn-secondary"><s:text name="label.request.popUpCancelYes"/></a>
			<a href="javascript:;" class="btn-tertiary cancel" data-dismiss="modal"><s:text name="label.request.popUpCancelNo"/></a>
		</div>
</div>
	

</body>
</html>