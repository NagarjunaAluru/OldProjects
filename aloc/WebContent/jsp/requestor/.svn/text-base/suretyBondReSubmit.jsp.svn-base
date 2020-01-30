<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
 <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><s:text name="label.request.suretyBond" /> - <s:text
		name="label.request.create" /> <s:property
		value="requestDetails.bondDetails.bondType" /></title>

<%@include file="../common/includeRequestCommonScripts.jsp" %>
<script
	src="${pageContext.request.contextPath}/js/requestor/requestor.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/common/toWord.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/requestor/addReference.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/common/pagination.js"></script>
<link href="${pageContext.request.contextPath}/css/common/pagenavi.css" type="text/css" rel="stylesheet" />
<script	src="${pageContext.request.contextPath}/js/requestor/suretyRequestor.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/requestor/fieldCounter.js" type="text/javascript"></script>
</head>

<body>
	<div class="container main" id="mainDiv">
		<jsp:include page="../common/headerSection.jsp">
			<jsp:param name="createReqPopup" value="Yes"></jsp:param>
		</jsp:include>

		<s:hidden name="approver" value="wants" id="approver" />

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
							<s:if test="%{requestDetails.principal.requiresEdits}">
								<li><p>
								<s:text	name="label.request.bondType" />
								</p></li>
							</s:if>
							<s:if test="%{requestDetails.obligee.requiresEdits}">
								<li><p>
									<s:text name="label.request.sbSectionObligee" />
								</p></li>
							</s:if>
							<s:if test="%{requestDetails.addressDtls.requiresEdits}">
								<li><p>
									<s:text name="label.request.sbSectionRequestorMailingAddress" />
								</p></li>
							</s:if>
							<s:if test="%{requestDetails.deliveryInstructions.requiresEdits}">
								<li><p>
									<s:text name="label.request.sbSectionDeliveryInstructions" />
								</p></li>
							</s:if>
							<s:if test="%{requestDetails.bondInfo.requiresEdits}">
								<li><p>
									<c:if test="${requestDetails.bondDetails.bondTypeId eq '4'}">
										<s:text name="label.request.sbSectionCourtBondDetails" />
									</c:if>
									<c:if test="${requestDetails.bondDetails.bondTypeId ne '4'}">
										<s:text name="label.request.sbSectionBondInformation" />
									</c:if>									
								</p></li>
							</s:if>
							<s:if test="%{requestDetails.bondInfo.attorneyRequiresEdits}">
								<li><p>
									<s:text name="label.request.sbSectionAttorneyInformation" />
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
				<s:hidden name="requestDetails.instrumentTypeId" id="instrumentTypeId" />
				<s:hidden name="requestDetails.WFDetails.WFStage" id="WFStage" />
				<s:hidden name="validationSuccess" id="validationReSubmitId" />
				<s:hidden name="requestId" value="%{requestDetails.requestId}" id="requestId"/>
				<h1 class="page-title span12">
					<s:text name="label.request.requestSuretyBond" />
				</h1>
				<p class="span12 left clear dashdesc">
					<s:text name="label.optionalSentence.requestSuretyBond" />
				</p>
				<hr class="page-title-hr">
				<div class="row hide" id="pageLevelErrorDivId">
					<div class="span12">
						<div class="errorbox">
							<div class="errorHead">
								<p class="erroricon"><s:text name="label.request.error"/></p>
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
				<div class="clear"></div>
				<jsp:include page="../common/request/sbRequestSummary.jsp" />
				 <div class="clear"></div>
		        <div class="highlighted">
		            <div class="row smallrow">
		                <div class="span2">
		                    <div class="form-row">
		                        <label><s:text name="label.request.selectedSite"/></label>
		                    </div>
		                </div>
		                <div class="span5 left">
		                    <div class="form-row">
		                        <s:property value="requestDetails.siteName"/>
		                    </div>
		                </div>
		            </div>
		        </div>
				<div class="form-mod" id="bondDetailsSectionId">
					<h2 id="bondDetails" class="section_flip section_blue">
						<a href="javascript:;"><s:text	name="label.request.bondType" />
								<span class="ttip info"
							data-original-title="<s:text name="label.request.tooltip.bondDetails"/>"></span>
						</a>
					</h2><hr class="h2-hr">
					<div id="bondDetailsPanel" class="section_panel fieldcount_panel">
						<jsp:include page="suretyBondRequestorSection.jsp">
							<jsp:param name="sectionId" value="request.section.bondDetails" />
							<jsp:param name="saveAndNextSectionButtonKey" value="key" />
							<jsp:param name="includeScripts" value="false" />
							<jsp:param name="resubmit" value="true"/>
						</jsp:include>

					</div>
				</div>
				<div class="clear"></div>
				
				<div class="form-mod">
					<h2 id="requestorMailingAddress" class="section_flip">
						<a href="javascript:;"><s:text
								name="label.request.sbSectionRequestorMailingAddress" /> <span
							class="ttip info"
							data-original-title="<s:text name="label.request.tooltip.requestorMailingAddress"/>"></span>
						</a>
					</h2><hr class="h2-hr">
					<div id="requestorMailingAddressPanel" class="section_panel fieldcount_panel">
						
						<jsp:include page="suretyBondRequestorSection.jsp">
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
						<a href="javascript:;"> <s:text
								name="label.request.sbSectionDeliveryInstructions" /></a>
					</h2><hr class="h2-hr">
					<div id="deliveryInstructionsPanel" class="section_panel fieldcount_panel">
						
						<jsp:include page="suretyBondRequestorSection.jsp">
							<jsp:param name="sectionId"
								value="request.section.deliveryInstructions" />
							<jsp:param name="saveAndNextSectionButtonKey" value="key" />
							<jsp:param name="includeScripts" value="false" />
						</jsp:include>

					</div>
				</div>
				<div class="clear"></div>
				<div id="bondInfoDiv1">
					<jsp:include page="suretyBondRequestorSection.jsp">
						<jsp:param name="sectionId"
							value="request.section.bondInformation" />
						<jsp:param name="saveAndNextSectionButtonKey" value="key" />
						<jsp:param name="includeScripts" value="false" />
					</jsp:include>
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
						<jsp:include page="/jsp/common/request/requestorFormat.jsp">
						<jsp:param name="includeScripts" value="false" />
						</jsp:include>
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
		<div id="lookupDiv" style="width: 100%;"></div>
		<div id="fullHistoryDiv" style="width: 100%;"></div>
	</div>
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
	<%@include file="../common/footerSection.jsp"%>
</body>
</html>