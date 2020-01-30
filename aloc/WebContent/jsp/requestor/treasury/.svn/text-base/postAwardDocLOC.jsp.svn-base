<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
 <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><s:property value="requestDetails.instrumentType" /> - <s:text
		name="label.treasuryAnalyst.pageTitle" /></title>

<%@include file="../../common/includeCommonScripts.jsp"%>
<script	src="${pageContext.request.contextPath}/js/requestor/requestor.js"	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/requestor/dlocRequestor.js" type="text/javascript"></script>
<script	src="${pageContext.request.contextPath}/js/requestor/postAward.js"	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/requestor/lookup.js"	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/requestor/fieldCounter.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/requestor/addBcpReference.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/common/pagination.js"></script>
<link href="${pageContext.request.contextPath}/css/common/pagenavi.css" type="text/css" rel="stylesheet" />
<script src="${pageContext.request.contextPath}/js/requestor/addReference.js" type="text/javascript"></script>
</head>

<body>
	<div class="container main">
		<%@include file="../../common/headerSection.jsp"%>
		<div id="mainPage" style="width: 100%;">
			<h1 class="page-title span12">
				<s:text name="label.request.DLOCAwardConfirm"></s:text>
			</h1>
			<p class="span12 left clear dashdesc">
				<s:text name="label.request.belowBidResponseTreasuryReview" />
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
					</div>
					<div class="row lastrow">
						<div class="span2"><div class="right"><label><s:text name="label.request.bankPerson"/>:</label></div></div>
						<div class="span3 left"><s:property value="requestDetails.bankContactLname"/>,<s:property value="requestDetails.bankContactFname"/></div>
					</div>
					<div class="row lastrow">
						<div class="span2"><div class="right"><label><s:text name="label.request.reasonForOptingout"/>:</label></div></div>
						<div class="span3 left"><s:property value="requestDetails.actionDetails.reasonForOptingOut" /></div>
					</div>	
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
			<label><s:text name="label.request.wantAward" /></label>
			<s:radio theme="aloc" cssClass="radio"
						name="wantAward" 
						list="#{'true':'Review details and edit','false':'Restart bid process'}"
						id="awardRadioOpt"/>
		</div>
		</div>
	</div>
  
 
     <div  class="hide" id="awardReviewEdit">
	    <div class="clear"></div>
		 <s:set name="isEdit" value="editMode" />
			<s:hidden name="showtrDelegation" id="showtrDelegation" value="%{errorShow}"/>
			<div class="form-mod" id="businessContactPersonSectionId">
				<h2 id="businessContactPerson" class="section_flip section_blue">
					<a href="javascript:;"><s:text
							name="label.request.dlocbusinessContactPerson" /></a>
				</h2><hr class="h2-hr">
				<div id="businessContactPersonPanel" class="section_panel fieldcount_panel">
					<jsp:include page="docLOCTreasuryAnalystSection.jsp">
						<jsp:param name="sectionId"
							value="request.section.businessContactPerson" />
						<jsp:param name="saveAndNextSectionButtonKey" value="key" />
						<jsp:param name="includeScripts" value="false" />
					</jsp:include>

				</div>
			</div>
	<div class="clear"></div>
    <div class="form-mod">
				<h2 id="issuingBank" class="section_flip">
					<a name="second" href="javascript:;"><s:text
							name="label.request.issuingBank" /></a>
				</h2><hr class="h2-hr">
				<div id="issuingBankPanel" class="section_panel fieldcount_panel">
					<jsp:include page="docLOCTreasuryAnalystSection.jsp">
						<jsp:param name="sectionId" value="request.section.issuingBank" />
						<jsp:param name="saveAndNextSectionButtonKey" value="key" />
						<jsp:param name="includeScripts" value="false" />
					</jsp:include>

				</div>
	</div>
	<div class="clear"></div>
			
			<div class="form-mod">
				<h2 id="applicant" class="section_flip">
					<a href="javascript:;"><s:text name="label.request.applicant" />
						<span class="ttip info"
						data-original-title="This is an tooltip with more information"></span></a>
				</h2><hr class="h2-hr">
				<div id="applicantPanel" class="section_panel fieldcount_panel">
					<jsp:include page="docLOCTreasuryAnalystSection.jsp">
						<jsp:param name="sectionId" value="request.section.applicant" />
						<jsp:param name="saveAndNextSectionButtonKey" value="key" />
						<jsp:param name="includeScripts" value="false" />
					</jsp:include>

				</div>
	</div>		
    
    <div class="clear"></div>

			<div class="form-mod">
				<h2 id="beneficiary" class="section_flip">
					<a href="javascript:;"><s:text name="label.request.beneficiary" />
						<span class="ttip info"
						data-original-title="This is an tooltip with more information"></span></a>
				</h2><hr class="h2-hr">
				<div id="beneficiaryPanel" class="section_panel fieldcount_panel">
					<jsp:include page="docLOCTreasuryAnalystSection.jsp">
						<jsp:param name="sectionId" value="request.section.beneficiary" />
						<jsp:param name="saveAndNextSectionButtonKey" value="key" />
						<jsp:param name="includeScripts" value="false" />
					</jsp:include>
				</div>
	</div>
	<div class="clear"></div>

			<div class="form-mod">
				<h2 id="instrumentTransactionDetails" class="section_flip">
					<a href="javascript:;"><s:text
							name="label.request.instrumentTransactionDetails" /></a>
				</h2><hr class="h2-hr">
				<div id="instrumentTransactionDetailsPanel" class="section_panel fieldcount_panel">
					<jsp:include page="docLOCTreasuryAnalystSection.jsp">
						<jsp:param name="sectionId"
							value="request.section.instrumentTransactionDetails" />
						<jsp:param name="saveAndNextSectionButtonKey" value="key" />
						<jsp:param name="includeScripts" value="false" />
					</jsp:include>

				</div>
	</div>		
    
    <div class="clear"></div>
			<div class="form-mod">
				<h2 id="paymentSchedule" class="section_flip">
					<a href="javascript:;"><s:text
							name="label.request.paymentSchedule" /></a>
				</h2><hr class="h2-hr">
				<div id="paymentSchedulePanel" class="section_panel fieldcount_panel">
					<jsp:include page="docLOCTreasuryAnalystSection.jsp">
						<jsp:param name="sectionId"
							value="request.section.paymentSchedule" />
						<jsp:param name="saveAndNextSectionButtonKey" value="key" />
						<jsp:param name="includeScripts" value="false" />
					</jsp:include>

				</div>
	</div>
	<div class="clear"></div>
	<!-- Including Format   -->
	<div class="form-mod" id="formatDiv">
				<h2 id="format" class="section_flip">
					<a href="javascript:;"><s:text name="label.request.bglocSectionName.7" /> 
						<span id="formatSelectionH2"></span>
					</a>
				</h2><hr class="h2-hr">
				<div id="formatPanel" class="section_panel fieldcount_panel">
					<jsp:include page="docLOCTreasuryAnalystSection.jsp">
						<jsp:param name="sectionId" value="request.section.format" />
						<jsp:param name="saveAndNextSectionButtonKey" value="key" />
						<jsp:param name="includeScripts" value="false" />
					</jsp:include>

				</div>
	</div>				
    <div class="clear"></div>
	<!-- Including Attachments   -->
	<div class="form-mod" id="attachmentsDiv">
				<h2 id="attachments" class="section_flip">
					<a href="javascript:;"><s:text
							name="label.request.bglocSectionName.9" /></a>
				</h2><hr class="h2-hr">
				<div id="attachmentsPanel" class="section_panel">
					<jsp:include page="docLOCTreasuryAnalystSection.jsp">
						<jsp:param name="sectionId" value="request.section.attachments" />
						<jsp:param name="saveAndNextSectionButtonKey" value="key" />
						<jsp:param name="includeScripts" value="false" />
					</jsp:include>
				</div>
	</div>				
		
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
								onCompleteTopics="showSubmitButtons"
								indicator="readySystemCheck"/>
							<input type="hidden" name="actionType" value="8" />
							<s:url id="readysystemCancel" action="cancel" />
							<%-- <s:a href="%{readysystemCancel}"
								key="label.request.common.cancel" cssClass="btn-tertiary cancel">
								<s:text name="label.request.common.cancel"></s:text>
							</s:a> --%>
							<img alt="Loading..." id="readySystemCheck" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px;">
						</s:form>
					</div>
				</div>
				<!-- end of block -->
			</div>
			<div class="clear"></div>				
				<div id="tracksectionDiv">
					<jsp:include page="/jsp/common/request/dlocTrackSection.jsp" />
				</div>
 	 </div>
	
	<s:form id="postawardSubmitForm" action="postAwardSubmit">
	<div class="row smallrow hide" id="postAwardComments">
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
<!-- Complete REQUEST POPUP WINDOW -->
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
 
	<%@include file="../../common/footerSection.jsp"%>

</body>
</html>
