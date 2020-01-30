<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
 <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><s:text name="label.request.dLOCTreasuryApproval" /></title>

<%@include file="../../common/includeCommonScripts.jsp"%>
<script src="${pageContext.request.contextPath}/js/requestor/requestor.js" type="text/javascript"></script>
 <script src="${pageContext.request.contextPath}/js/requestor/lookup.js" type="text/javascript"></script> 
</head>

<body>
<s:form id="approverSubmitForm" action="approverSubmit">
	<div class="container main">
		<%@include file="../../common/headerSection.jsp"%>
		<div id="mainPage">
		<h1 class="page-title span12">
			<s:label key=""></s:label>
			<s:text name="label.request.treasuryApproval"/>
		</h1>
		<p class="span12 left clear dashdesc">
			<s:label key=""></s:label>
			<s:text name="label.request.treasuryApprovalTransaction"/>
		</p>
		<hr class="page-title-hr">
			<div class="form-mod">
				<div class="row graybg" style="margin-left: -10px;">
					<div class="span12">
						<h2 class="summary span12">
							<s:text name="label.request.requestSummary" />
						</h2><hr class="h2-hr">
						<div class="clear"></div>
						<div class="row">
							<div class="span12 whitebg">
								<div class="span5" style="margin-left: 10px !important;">
									<div class="marginT">
										<label><s:text name="label.request.requestor"/></label>
										<p><s:property value="requestDetails.requestSummary.requestor.lastName"/>, <s:property value="requestDetails.requestSummary.requestor.firstName"/></p>
										<p><s:property value="requestDetails.requestSummary.requestor.ssoId"/></p>
									</div>
								</div>
								<div class="span3">
									<div class="marginT">
										<label> <s:text name="label.request.alocRecNo"/> </label>
										<p><s:property value="requestDetails.alocRecordId"/></p>
									</div>
								</div>
								<!-- <div class="span3 right">
									<div class="marginT">
										<div class="row">
											<div class="span3">
												<label>Linked ID</label>
												<p>--</p>
											</div>
										</div>
									</div>
								</div> -->
							</div>
						</div>
					</div>
				</div>

				<div class="row lastrow">
					<div class="span12">
						<div class="form-row">
							<p style="padding: 2px 0;">
						<b><s:text name="label.request.selectedSite"/></b> 
						<span style="padding-left: 40px;"><s:property value="requestDetails.siteName"/></span>
						<s:hidden name="requestDetails.transactionParties.siteName" value="%{requestDetails.siteName}"></s:hidden>
					</p>
						</div>
					</div>
				</div>

			</div>
			<s:set name="isEdit" value="editMode"/>
			<div class="form-mod" id="businessContactPersonSectionId">
				<h2 id="businessContactPerson" class="section_flip section_blue">
					<a href="javascript:;"><s:text name="label.request.dlocbusinessContactPerson"/></a>
				</h2><hr class="h2-hr">
				<div id="businessContactPersonPanel" class="section_panel">
						<jsp:include page="docLOCTreasuryApprovalSection.jsp">
							<jsp:param name="sectionId"  value="request.section.businessContactPerson" />
							<jsp:param name="includeScripts" value="false" />
						</jsp:include>					
					
				</div>
			</div>
			
			<div class="clear"></div>
			
			<div class="form-mod">
				<h2 id="issuingBank" class="section_flip">
					<a name="second" href="javascript:;"><s:text name="label.request.issuingBank"/></a>
				</h2><hr class="h2-hr">
				<div id="issuingBankPanel" class="section_panel">
						<jsp:include page="docLOCTreasuryApprovalSection.jsp">
							<jsp:param name="sectionId"  value="request.section.issuingBank" />
							<jsp:param name="includeScripts" value="false" />
						</jsp:include>					
					
				</div>
			</div>
				
			<div class="clear"></div>
			
			<div class="form-mod">
				<h2 id="applicant" class="section_flip">
					<a href="javascript:;"><s:text name="label.request.applicant"/> <span class="ttip info"
						data-original-title="This is an tooltip with more information"></span></a>
				</h2><hr class="h2-hr">
				<div id="applicantPanel" class="section_panel">
						<jsp:include page="docLOCTreasuryApprovalSection.jsp">
							<jsp:param name="sectionId"  value="request.section.applicant" />
							<jsp:param name="includeScripts" value="false" />
						</jsp:include>					
									
				</div>
			</div>			
						
			<div class="clear"></div>
			
			<div class="form-mod">
				<h2 id="beneficiary" class="section_flip">
					<a href="javascript:;"><s:text name="label.request.beneficiary"/> <span class="ttip info"
						data-original-title="This is an tooltip with more information"></span></a>
				</h2><hr class="h2-hr">
				<div id="beneficiaryPanel" class="section_panel">			
						<jsp:include page="docLOCTreasuryApprovalSection.jsp">
							<jsp:param name="sectionId"  value="request.section.beneficiary" />
							<jsp:param name="includeScripts" value="false" />
						</jsp:include>					
				</div>
			</div>	
								
			<div class="clear"></div>
			
			<div class="form-mod">
				<h2 id="instrumentTransactionDetails" class="section_flip">
					<a href="javascript:;"><s:text name="label.request.instrumentTransactionDetails"/></a>
				</h2><hr class="h2-hr">
				<div id="instrumentTransactionDetailsPanel" class="section_panel">
						<jsp:include page="docLOCTreasuryApprovalSection.jsp">
							<jsp:param name="sectionId"  value="request.section.instrumentTransactionDetails" />
							<jsp:param name="includeScripts" value="false" />
						</jsp:include>					
											
				</div>
			</div>			
			<div class="clear"></div>

			<div class="form-mod">
				<h2 id="paymentSchedule" class="section_flip">
					<a href="javascript:;"><s:text name="label.request.paymentSchedule"/></a>
				</h2><hr class="h2-hr">
				<div id="paymentSchedulePanel" class="section_panel">
						<jsp:include page="docLOCTreasuryApprovalSection.jsp">
							<jsp:param name="sectionId"  value="request.section.paymentSchedule" />
							<jsp:param name="includeScripts" value="false" />
						</jsp:include>					
										
				</div>
			</div>
		   <!-- Including Format   -->
		   <div class="form-mod" id="formatDiv">
		   		<h2 id="format" class="section_flip">
					<a href="javascript:;"><s:text name="label.request.bglocSectionName.7"/>
						<span id="formatSelectionH2"></span>
					</a>
				</h2><hr class="h2-hr">
				<div id="formatPanel" class="section_panel">
						<jsp:include page="docLOCTreasuryApprovalSection.jsp">
							<jsp:param name="sectionId"  value="request.section.format" />
							<jsp:param name="includeScripts" value="false" />
						</jsp:include>					
								
				</div>
		   </div>
		   <!-- Including Attachments   -->
		   <div class="form-mod" id="attachmentsDiv">
		   		<h2 id="attachments" class="section_flip">
					<a href="javascript:;"><s:text name="label.request.bglocSectionName.9"/></a>
				</h2><hr class="h2-hr">
				<div id="attachmentsPanel" class="section_panel">
						<jsp:include page="docLOCTreasuryApprovalSection.jsp">
							<jsp:param name="sectionId"  value="request.section.attachments" />
							<jsp:param name="includeScripts" value="false" />
						</jsp:include>					
				</div>
		   </div>
		   <div class="form-mod" id="treasuryDelegationDiv">
		   		<h2 id="treasuryDelegation" class="section_flip">
					<a href="javascript:;"><s:text name="label.request.treasuryDelegation"/></a>
				</h2><hr class="h2-hr">
				<div id="treasuryDelegationPanel" class="section_panel">
						<jsp:include page="docLOCTreasuryApprovalSection.jsp">
							<jsp:param name="sectionId"  value="request.section.treasuryDelegation" />
							<jsp:param name="includeScripts" value="false" />
						</jsp:include>
				</div>
			</div>
		   
		   	<!-- Audit Log -->
			<jsp:include page="/jsp/common/request/AuditLog.jsp" />

			<!-- Transaction History Log -->
			<jsp:include page="/jsp/common/request/TransactionHistoryLog.jsp" />
	
		    <!-- Include Submit Section -->		
		   <div class="form-mod" id="submitDiv">
				<div>
					<jsp:include page="/jsp/requestor/approverSubmit.jsp"/>		
				</div>
		   </div>	
		</div>
		<div id="lookupDiv" style="width: 100%;">
		</div>
		<%@include file="../../common/footerSection.jsp"%>

	</div>
	</s:form>
</body>
</html>
