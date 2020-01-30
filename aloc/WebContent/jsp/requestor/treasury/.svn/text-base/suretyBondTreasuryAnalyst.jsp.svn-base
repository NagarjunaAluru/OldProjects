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
<title><s:text name="label.request.suretyBondTreasureyTitle"/></title>

<%@include file="../../common/includeCommonScripts.jsp"%>
<script	src="${pageContext.request.contextPath}/js/requestor/requestor.js"
	type="text/javascript"></script>
<script	src="${pageContext.request.contextPath}/js/requestor/suretyRequestor.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/requestor/lookup.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/common/toWord.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/requestor/addReference.js" 
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/common/pagination.js"></script>
<link href="${pageContext.request.contextPath}/css/common/pagenavi.css" type="text/css" rel="stylesheet" />
<script src="${pageContext.request.contextPath}/js/requestor/fieldCounter.js" type="text/javascript"></script>
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
				<s:text name="label.request.suretyBondTreasureySubTitle" />
			</p>
			<hr class="page-title-hr">
			<div class="clear"></div>
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
			<s:hidden id="analystErrorShowId" value="%{errorShow}" />
			<div class="row hide" id="analystPageErrorDivId">
				<div class="span12">
					<div class="errorbox">
						<div class="errorHead">
							<p class="erroricon">Error</p>
						</div>
						<div class="errorContent">
							<p>
								<s:fielderror />
							</p>
							<p>&nbsp;</p>
						</div>
					</div>
				</div>
			</div>
			<div class="form-mod">
						<jsp:include page="../../common/request/sbRequestSummary.jsp"/>
							<div class="clear"></div>
						</div>
					<div class="clear"></div>
				<div class="highlighted">
					<div class="row smallrow">
						<div class="span2">
							<div class="form-row">
								<label><s:text name="label.request.selectedSite" /></label>
							</div>
						</div>
						<div class="span5 left">
							<div class="form-row">
								<c:out value="${requestDetails.siteName}" />
							</div>
						</div>
					</div>
				</div>
				<!-- requestSummary ends here -->
			
					<!-- end of form form-mod -->
			<s:set name="isEdit" value="editMode" />
			<div class="form-mod" id="bondDetailsSectionId">
				<h2 id="bondDetails" class="section_flip section_blue">
					<a href="javascript:;"><s:text	name="label.request.bondType"/><span class="ttip info" data-original-title="<s:text name="label.request.tooltip.bondDetails"/>"></span></a>
				</h2><hr class="h2-hr">
				<div id="bondDetailsPanel" class="section_panel fieldcount_panel">

					<jsp:include page="suretyBondTreasuryAnalystSection.jsp">
						<jsp:param name="sectionId" value="request.section.bondDetails" />
						<jsp:param name="saveAndNextSectionButtonKey" value="key" />
						<jsp:param name="includeScripts" value="false" />
					</jsp:include>

				</div>
			</div>

			<div class="clear"></div>

			<div class="form-mod">
				<h2 id="requestorMailingAddress" class="section_flip">
					<a href="javascript:;"><s:text name="label.request.sbSectionRequestorMailingAddress"/>
				<span class="ttip info" data-original-title="<s:text name="label.request.tooltip.requestorMailingAddress"/>"></span>
				</a>
				</h2><hr class="h2-hr">
				<div id="requestorMailingAddressPanel" class="section_panel fieldcount_panel">


					<jsp:include page="suretyBondTreasuryAnalystSection.jsp">
						<jsp:param name="sectionId"
							value="request.section.requestorMailingAddress" />
						<jsp:param name="saveAndNextSectionButtonKey" value="key" />
						<jsp:param name="includeScripts" value="false" />
					</jsp:include>

				</div>
			</div>
			<div class="clear"></div>

			<div class="form-mod">
				<h2 id="deliveryInstructions" class="section_flip">
					<a href="javascript:;"><s:text
							name="label.request.sbSectionDeliveryInstructions" /></a>
				</h2><hr class="h2-hr">
				<div id="deliveryInstructionsPanel" class="section_panel fieldcount_panel">

					<jsp:include page="suretyBondTreasuryAnalystSection.jsp">
						<jsp:param name="sectionId"
							value="request.section.deliveryInstructions" />
						<jsp:param name="saveAndNextSectionButtonKey" value="key" />
						<jsp:param name="includeScripts" value="false" />
					</jsp:include>

				</div>
			</div>
			<div class="clear"></div>

			<div class="form-mod">
				<h2 id="bondInformation" class="section_flip">
					<a href="javascript:;"><c:if test="${requestDetails.bondDetails.bondTypeId eq '4'}">
				<s:text name="label.request.sbSectionCourtBondDetails" />
				</c:if>
				<c:if test="${requestDetails.bondDetails.bondTypeId ne '4'}">
				<s:text name="label.request.sbSectionBondInformation"/>
				</c:if></a>
				</h2><hr class="h2-hr">
				<div id="bondInformationPanel" class="section_panel fieldcount_panel">

					<jsp:include page="suretyBondTreasuryAnalystSection.jsp">
						<jsp:param name="sectionId"
							value="request.section.bondInformation" />
						<jsp:param name="saveAndNextSectionButtonKey" value="key" />
						<jsp:param name="includeScripts" value="false" />
					</jsp:include>

				</div>
			</div>
			<div class="clear"></div>
			<c:if test="${requestDetails.bondDetails.bondTypeId eq '4'}">
				<div class="form-mod">
				<h2 id="attorneyBondInformation" class="section_flip">
				<a href="javascript:;"><s:text name="label.request.sbSectionAttorneyInformation" /></a></h2><hr class="h2-hr">
				<div id="attorneyBondInformationPanel" class="section_panel fieldcount_panel">					
						<jsp:include page="suretyBondTreasuryAnalystSection.jsp">
							<jsp:param name="sectionId"  value="request.section.attorneyBondInformation" />
							<jsp:param name="saveAndNextSectionButtonKey" value="key" />
							<jsp:param name="includeScripts" value="false" />
						</jsp:include>												
				</div>
			</div>
			</c:if>

			<!-- Including Format   -->
			<div class="form-mod" id="formatDiv">
				<h2 id="format" class="section_flip">
					<a href="javascript:;"><s:text name="label.request.sbSectionFormat" /> 
						<span id="formatSelectionH2"></span>
					</a>
				</h2><hr class="h2-hr">
				<div id="formatPanel" class="section_panel">

					<jsp:include page="suretyBondTreasuryAnalystSection.jsp">
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
							name="label.request.sbSectionAttachments" /></a>
				</h2><hr class="h2-hr">
				<div id="attachmentsPanel" class="section_panel">

					<jsp:include page="suretyBondTreasuryAnalystSection.jsp">
						<jsp:param name="sectionId" value="request.section.attachments" />
						<jsp:param name="saveAndNextSectionButtonKey" value="key" />
						<jsp:param name="includeScripts" value="false" />
					</jsp:include>

				</div>
			</div>
			 <!-- Audit Log and Transaction History  -->
		   <div class="form-mod" id="auditAndTransactionHistoryLog">
			        <jsp:include page="/jsp/common/request/auditAndTransactionHistoryLog.jsp"/>	            
		   </div>
		   
			<div class="row" id="readySystemCheckSection">
				<div class="span12 btn-container">
					<div class="form-row">
						<s:form id="readysystemSubmitForm">
							<s:hidden name="requestId" value="%{requestDetails.requestId}"/>
							<s:url id="readySystemCheckURL" action="readySystemCheck" >
								<s:param name="include">Yes</s:param>
							</s:url>
							<sj:submit key="label.request.readysystemChecks"
								cssClass="btn-primary" cssStyle="margin-left: 20px;"
								replaceTarget="true" targets="auditAndTransactionHistoryLog"
								href="%{readySystemCheckURL}"
								onCompleteTopics="showSBTreasuryAnalystBtns" 
								indicator="readySystemCheck"
								onErrorTopics="multipleTabsProblem"/>
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
				<jsp:include page="/jsp/common/request/suretyTrackSection.jsp"/>
				</div>
			<!-- Include Submit Section -->
			<s:form id="tranalystSubmitForm" action="trAnalystSubmit">
				
				<s:hidden name="requestDetails.instrumentTypeId" id="instrumentTypeId" />
				<s:hidden name="requestDetails.WFDetails.WFStage" id="WFStage" />
				<s:hidden name="requestId" value="%{requestDetails.requestId}" id="requestId"/>
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
					<div>
						<jsp:include page="/jsp/common/request/saveAndApprove.jsp" />
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