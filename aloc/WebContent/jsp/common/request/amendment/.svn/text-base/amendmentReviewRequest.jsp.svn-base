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
<script
	src="${pageContext.request.contextPath}/js/requestor/requestor.js"
	type="text/javascript"></script>

<script src="${pageContext.request.contextPath}/js/requestor/lookup.js"
	type="text/javascript"></script>

<script src="${pageContext.request.contextPath}/js/common/toWord.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/common/amendment.js" type="text/javascript"></script>
</head>

<body>
	<div class="container main">
		<jsp:include page="../../../common/headerSection.jsp">
			<jsp:param name="createReqPopup" value="Yes"></jsp:param>
		</jsp:include>
		<div id="mainPage">
			<div class="form-row">
				<p class="dashdesc"><s:text name="label.amendment.alert"/> &#60;N&#62;</p>
			</div>
			<h1 class="page-title span12">
				<s:text name="label.amendment.pageTitleHeader"/>
			</h1>
			<p class="span12 left clear dashdesc">
				<s:text name="label.amendment.subTitle"/>
			</p>
			<hr class="page-title-hr">
			<div class="form-mod">
				<div class="row graybg lastrow" style="margin-left: -10px;">
					<div class="span12">
						<h2 class="summary span12">
							<s:text name="label.request.requestSummary" />
						</h2><hr class="h2-hr">
						<div class="clear"></div>
						<div class="row">
							<div class="span12 whitebg">
								<div class="span3" style="margin-left: 10px !important;">
									<div class="marginT">
										<s:label key="label.request.requestor" />
										<p><s:property value="requestDetails.requestSummary.requestor.lastName"/>, <s:property value="requestDetails.requestSummary.requestor.firstName"/></p>
										<p><s:property value="requestDetails.requestSummary.requestor.ssoId"/></p>
									</div>
								</div>
								<div class="span3">
									<div class="marginT">
										<s:label key="label.request.alocRecNo" />
										<p>
											<s:property value="requestDetails.requestId" />
											<s:property value="requestDetails.sitePrefix" />
										</p>
									</div>
								</div>
								<div class="span3">
									<div class="marginT">
										<s:label key="label.amendment.seqNo"></s:label>
										<p><s:property value="requestDetails.amendment.amendmentRequestId" /></p>
									</div>
								</div>
								<div class="span2 right">
									<div class="marginT">
										<div class="row">
											<div class="span2">
												<s:label key="label.amendment.bankRefNo"></s:label>
												<p>&#60;Value&#62;</p>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			
			<s:set name="isEditMode" value="editMode" />
			
			<!-- Including Transaction Parties -->
			<div class="form-mod">
				<h2 id="transactionParties" class="section_flip section_blue">
					<a href="javascript:;">
						<s:text	name="label.request.bglocSectionName.1" />
					</a>
				</h2><hr class="h2-hr">
				<div id="transactionPartiesPanel" class="section_panel">
				
					<h3 id="applicantHeader"><s:text name="label.request.applicant"/></h3>
					<jsp:include page="amendmentRequestReviewSection.jsp">
						<jsp:param name="sectionId"	value="request.section.tpapplicant" />
						<jsp:param name="includeScripts" value="false" />
					</jsp:include>
					 <c:if test="${requestDetails.siteTypeName eq 'Financial Business' }">
					 <s:if test="%{requestDetails.amendment.transactionParties.triPartyRequestFlag}">
					<h3 id="triPartyHeader"><s:text name="label.request.triPartyApplicant" /></h3>
					<jsp:include page="amendmentRequestReviewSection.jsp">
						<jsp:param name="sectionId"	value="request.section.tripartyAddress" />
						<jsp:param name="includeScripts" value="false" />
					</jsp:include>
					</s:if>
					</c:if>
					<h3 id="customerHeader"><s:text name="label.request.customer" /></h3>
					<jsp:include page="amendmentRequestReviewSection.jsp">
						<jsp:param name="sectionId"	value="request.section.tpCustomerbeneficiary" />
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
					<jsp:include page="amendmentRequestReviewSection.jsp">
						<jsp:param name="sectionId"	value="request.section.instrumentAmountCurrency" />
						<jsp:param name="includeScripts" value="false" />
					</jsp:include>
				</div>
			</div>
			
			<!-- Including Expiration Dates -->
			<div class="form-mod">
				<h2 id="expirationDates" class="section_flip section_blue">
					<a href="javascript:;">
						<s:text	name="label.request.bglocSectionName.14" />
					</a>
				</h2><hr class="h2-hr">
				<div id="expirationDatesPanel" class="section_panel">
					<jsp:include page="amendmentRequestReviewSection.jsp">
						<jsp:param name="sectionId"	value="request.section.expirationDates" />
						<jsp:param name="includeScripts" value="false" />
					</jsp:include>
				</div>
			</div>
			
			<!-- Including Other Changes -->
			<div class="form-mod">
				<h2 id="otherChanges" class="section_flip section_blue">
					<a href="javascript:;">
						<s:text	name="label.request.bglocSectionName.18" />
					</a>
				</h2><hr class="h2-hr">
				<div id="otherChangesPanel" class="section_panel">
					<jsp:include page="amendmentRequestReviewSection.jsp">
						<jsp:param name="sectionId"	value="request.section.otherChanges" />
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
					<jsp:include page="amendmentRequestReviewSection.jsp">
						<jsp:param name="sectionId"	value="request.section.attachments" />
						<jsp:param name="includeScripts" value="false" />
					</jsp:include>
				</div>
			</div>
			<div class="form-mod" id="businessDelegationDiv">
		   		<h2 id="businessDelegation" class="section_flip">
					<a href="javascript:;"><s:text name="label.request.bglocSectionName.15"/></a>
				</h2><hr class="h2-hr">
				<div id="businessDelegationPanel" class="section_panel">
						<jsp:include page="amendmentRequestReviewSection.jsp">
							<jsp:param name="sectionId"  value="request.section.businessDelegation" />
							<jsp:param name="saveAndNextSectionButtonKey" value="key" />
							<jsp:param name="includeScripts" value="false" />
						</jsp:include>
				</div>
			</div>
			
			
			<!-- Including Audit Log -->
			<jsp:include page="/jsp/common/request/AuditLog.jsp" />
			
			<div class="row highlighted" style="margin-top:10px;" id="tracksectionDiv">
				<div class="span12">
					<div class="row">
						<div class="span12">
							<label>Apply or cancel edits to the following sections: </label>
							<s:iterator value="editSectionList">
								<s:if test="%{name=='request.section.tpapplicant'}"> 
									<p id="transactionParties" class="tracking_section_flip">
										<a href="javascript:;"><s:text name="label.request.bglocSectionName.1"/> - <s:text name="label.request.applicant"/></a>
									</p>
								</s:if>
								<s:if test="%{name=='request.section.tripartyAddress'}"> 
									<p id="transactionParties" class="tracking_section_flip">
										<a href="javascript:;"><s:text name="label.request.bglocSectionName.1"/> - <s:text name="label.request.triPartyApplicant" /></a>
									</p>
								</s:if>
								<s:if test="%{name=='request.section.tpCustomerbeneficiary'}"> 
									<p id="transactionParties" class="tracking_section_flip">
										<a href="javascript:;"><s:text name="label.request.bglocSectionName.1"/> - <s:text name="label.request.customer" /></a>
									</p>
								</s:if>
							    <s:if test="%{name=='request.section.instrumentAmountCurrency'}"> 
									<p id="instrumentAmountCurrency" class="tracking_section_flip">
										<a href="javascript:;"><s:text name="label.request.bglocSectionName.13"/></a>
									</p>
								</s:if>
								<s:if test="%{name=='request.section.expirationDates'}"> 
									<p id="expirationDates" class="tracking_section_flip">
										<a href="javascript:;"><s:text name="label.request.bglocSectionName.14"/></a>
									</p>
								</s:if>
								<s:if test="%{name=='request.section.attachments'}"> 
									<p id="attachmentsFlip" class="tracking_section_flip">
										<a href="javascript:;"><s:text name="label.request.bglocSectionName.9"/></a>
									</p>
								</s:if>  
	  						</s:iterator>
						</div>
					</div>
				
					<div class="row lastrow">
						<div class="span12">
							<div class="form-row">
								<s:url id="cancelAllURL" action="cancelAll"/>
								<s:a href="%{cancelAllURL}"	cssClass="btn-tertiary cancel" >Cancel all changes</s:a>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="form-mod" id="submitAmendmentDiv">
				<div>
					<s:form id="saveAndSubmitForm" namespace="/int/requestor/review" action="submitAmendment">
						<input type="hidden" name="actionType" id="actionTypeId">
						<br/>
						<s:submit 
							key="label.amendment.submitRequest"
							cssClass="btn btn-success" cssStyle="margin-left: 20px;"
							name="submitRequest" value="Submit Request" onclick="javascript:submitAction(2);"/>		
						
						<s:submit 
							key="label.request.saveAsDraft"
							cssClass="btn" cssStyle="margin-left: 20px;"
							name="saveAsDraft" value="Save As Draft" onclick="javascript:submitAction(1);"/>
							
						<s:url id="homePageURL" action="cancel" namespace="/int/requestor" />
						<s:a href="%{homePageURL}" cssClass="btn-tertiary cancel" >
							<s:text name="label.request.common.cancel"/>
						</s:a>
					</s:form>
				</div>
			</div>
		</div>
		<div id="lookupDiv" style="width: 100%;"></div>
</div>
	<%@include file="../../../common/footerSection.jsp"%>
	
</body>
</html>