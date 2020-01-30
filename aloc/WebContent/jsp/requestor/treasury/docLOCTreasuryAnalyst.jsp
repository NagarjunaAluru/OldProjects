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
<script
	src="${pageContext.request.contextPath}/js/requestor/requestor.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/requestor/lookup.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/requestor/dlocRequestor.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/requestor/addReference.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/requestor/addBcpReference.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/requestor/fieldCounter.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/common/pagination.js"></script>
<link href="${pageContext.request.contextPath}/css/common/pagenavi.css" type="text/css" rel="stylesheet" />
</head>

<body>
	<div class="container main">
		<%@include file="../../common/headerSection.jsp"%>
		<div id="mainPage" style="width: 100%;">
			<h1 class="page-title span12">
				<s:property value="requestDetails.instrumentType" />
				-
				<s:text name="label.treasuryAnalyst.pageTitle"></s:text>
			</h1>
			<p class="span12 left clear dashdesc">
				<s:text name="label.treasuryAnalyst.subTitle" />
			</p>
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
			<div class="form-mod">				
                <jsp:include page="/jsp/common/request/dlocRequestSummary.jsp" />
				<div class="row lastrow">
					<div class="span12">
						<div class="form-row">
							<p style="padding: 2px 0;">
								<b><s:text name="label.request.selectedSite" /></b> <span
									style="padding-left: 40px;"><s:property
										value="requestDetails.siteName" /></span>
								<s:hidden name="requestDetails.transactionParties.siteName"
									value="%{requestDetails.siteName}"></s:hidden>
							</p>
						</div>
					</div>
				</div>

			</div>
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
						data-original-title="<s:text name="label.request.tooltip.dloc.applicant"/>"></span></a>
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
						data-original-title="<s:text name="label.request.tooltip.dloc.beneficiary"/>"></span></a>
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
							<s:hidden name="requestId" value="%{requestDetails.requestId}"/>
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
							<img alt="Loading..." id="readySystemCheck" src="${pageContext.request.contextPath}/img/loading.gif" class="indicator">
						</s:form>
					</div>
				</div>
				<!-- end of block -->
			</div>
			<div class="clear"></div>				
			<div id="tracksectionDiv">
				<jsp:include page="/jsp/common/request/dlocTrackSection.jsp" />
			</div>
				
				<s:form id="tranalystSubmitForm" action="trAnalystSubmit">
				<s:hidden name="requestId" value="%{requestDetails.requestId}"/>
				<input type="hidden" name="actionType" id="actionTypeId" />
				<div class="hide form-mod" id="submitDiv">
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
					<div class="row">
						<div class="span12">
							<nav>
								<ul>
									<li id="li-bid" class="navLi" style="width: 150px;"><a class="navLink" href="#tab1" style="width: 150px;" id="ready-for-bid"><s:text name="label.request.reviewedAndReadyForBid"/></a></li>
									<li id="li-send-back" class="navLi"><a class="navLink" href="#tab2" id="dloc-send-back"><s:text name="label.request.sendBackToRequestor"/></a></li>
									<li class="last"><a href="#" class="btn-tertiary cancel clearEntries" data-toggle="modal"><s:text name="label.request.common.cancel" /></a></li>
								</ul>
							</nav>
						</div>
					</div>
				</div>
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
