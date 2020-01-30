<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="hwfs"  uri="/hwf-security-tags" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title><s:text name="label.request.treasuryLandingPage" /></title>
    <meta name="description" content="">
    <meta name="author" content="">
	<%@include file="../common/includeCommonScripts.jsp" %>
	<script src="${pageContext.request.contextPath}/js/common/landingPage.js" type="text/javascript"></script>
    <!-- JS FOR FONT -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/font/typeface-0.15.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/font/ge_inspira_regular.typeface.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/font/helvetica_lt_std_light.typeface.js"></script>

</head>

<body>
	<div class="container main">
	<jsp:include page="../common/headerSection.jsp">
		<jsp:param name="createReqPopup" value="Yes"></jsp:param>
	</jsp:include>	
	<h1 class="page-title span12"><s:text name="label.request.welcomeTo" /><s:text name="label.request.alocLabel" /></h1>
	<hr class="page-title-hr">
	<!-- MAIN CONTENTS OF BODY STARTS HERE --> 
			<div class="clear"></div>
			<!--USER ANNOUNCEMENTS COMES HERE-->
			 <s:if test="%{landingpageDetails.userAnnouncements != null && landingpageDetails.userAnnouncements.size> 0}">	
	              <div id="infoMsg">
		        	<div class="inMsg">
		        	<a href="#" class="right infoclose">X</a>
		        	<img src='${pageContext.request.contextPath}/img/info1.png' align="absmiddle" style="margin-left:-30px;" /><span style="padding-left:5px;">
		        	<s:text name="label.userannouncementmgmt.success"/></span></div>
		            <div class="inContent">	             					 	  			 
						 	<s:iterator value="landingpageDetails.userAnnouncements">											
						 		<s:property value="message" escape="false"/>							
									<p>																								
										<s:if test="%{geFileId !=0}">																																	
											<s:url id="fileDownload" action="downloadAttachment.action" namespace="/int/admin" encode="true" escapeAmp="false">
												<s:param name="geLibFileId"><s:property value="geFileId"/></s:param>
							   					<s:param name="announcementType">userAnnouncement</s:param>	
							   					<s:param name="userAnnouncementId"><s:property value="userAnnouncementId"/></s:param>													
											</s:url>																									
												<s:a href="%{fileDownload}"><s:property value="attachmentName" /></s:a>		
										</s:if>																																		
									</p>
								<br>									
								</s:iterator>						  
				       </div>
			        </div>
			        <div class="clear"></div>
			 </s:if>	
        <c:set var="isEligible" value="false"></c:set>
		<hwfs:checkComponentPermission name="CreateRequestAmendmentRiderView" domainName="BusinessAccess">
			<c:set var="isEligible" value="true"></c:set>
		</hwfs:checkComponentPermission>    
		<div class="left">
			<div class="row">
				<div class="span4">
					<div class="box">
						<div class="boxHead"><s:text name="label.request.createNewRequest" /></div>
						<div class="boxContent">
                            <div class="createNew">
                            	<h3 class="leftCN"><s:text name="label.request.startRequest" /></h3>
                                <%-- <h3 class="rightCN"><s:text name="label.request.downloadChecklist" /></h3> --%>
                                <div class="clear"></div>
                            </div>
							<s:url action="createNewRequest.action" namespace="/int/requestor" var="bankGuarentyURL" escapeAmp="false" encode="true">
								<s:param name="instrumentTypeId">1</s:param>	
							</s:url>
							<s:url action="createNewRequest.action" namespace="/int/requestor" var="sblcURL" escapeAmp="false" encode="true">
								<s:param name="instrumentTypeId">2</s:param>
							</s:url>
							<s:url action="createNewRequest.action" namespace="/int/requestor" var="suretyBondURL" escapeAmp="false" encode="true">
								<s:param name="instrumentTypeId">3</s:param>
							</s:url>
							<s:url action="createNewRequest.action" namespace="/int/requestor" var="dlocURL" escapeAmp="false" encode="true">
								<s:param name="instrumentTypeId">4</s:param>
							</s:url>
							<s:url action="requestCheckListPDF.action" namespace="/int" var="bankGuaranteeCheckListURL" escapeAmp="false" encode="true">
								<s:param name="InstrumentTypeId">1</s:param>	
							</s:url>	
							<s:url action="requestCheckListPDF.action" namespace="/int" var="sblcCheckListURL" escapeAmp="false" encode="true">
								<s:param name="InstrumentTypeId">2</s:param>	
							</s:url>
							<s:url action="requestCheckListPDF.action" namespace="/int" var="sbCheckListURL" escapeAmp="false" encode="true">
								<s:param name="InstrumentTypeId">3</s:param>	
							</s:url>
							<s:url action="requestCheckListPDF.action" namespace="/int" var="dlocCheckListURL" escapeAmp="false" encode="true">
								<s:param name="InstrumentTypeId">4</s:param>	
							</s:url>							
							<ul class="box1">
							<c:if test="${isEligible}">
								<div class="stline"></div>
								<li><a href="<s:property value="#sblcURL" />"><s:text name="label.request.standbyLetterOfCredit" /></a><span class="right"><a href="<s:property value="#sblcCheckListURL" />"><img src='${pageContext.request.contextPath}/img/check.png' align="absmiddle" class="imgcheck" alt="StandBy Letter Of Credit" /></a></span></li>								
								<li><a href="<s:property value="#bankGuarentyURL" />"><s:text name="label.request.bankGurantee" /></a><span class="right"><a href="<s:property value="#bankGuaranteeCheckListURL" />"><img src='${pageContext.request.contextPath}/img/check.png' align="absmiddle" class="imgcheck" alt="Bank Guarantee"/></a></span></li>
								<li><a href="<s:property value="#suretyBondURL" />"><s:text name="label.request.suretyBond" /></a><span class="right"><a href="<s:property value="#sbCheckListURL" />"><img src='${pageContext.request.contextPath}/img/check.png' align="absmiddle" class="imgcheck" alt="Surety Bond"/></a></span></li>
								<li><a href="<s:property value="#dlocURL" />"><s:text name="label.request.documentaryLetterOfCreditConfirmation" /></a><span class="right"><a href="<s:property value="#dlocCheckListURL" />"><img src='${pageContext.request.contextPath}/img/check.png' align="absmiddle" class="imgcheck" alt="Documentary Letter of Credit Confirmation"/></a></span></li>								
								<li class="dropdown active nobg">
									<a data-toggle="dropdown" class="dropdown-toggle" id="req1" href="#"><s:text name="label.request.notSure" /></a>
								</li>
							</c:if>
							<c:if test="${not isEligible}">
								<div class="stline"></div>
								<li><s:text name="label.request.standbyLetterOfCredit" /><span class="right"><img src='${pageContext.request.contextPath}/img/check.png' align="absmiddle" class="imgcheck" alt="StandBy Letter Of Credit"/></span></li>								
								<li><s:text name="label.request.bankGurantee" /><span class="right"><img src='${pageContext.request.contextPath}/img/check.png' align="absmiddle" class="imgcheck" alt="Bank Guarantee"/></span></li>
								<li><s:text name="label.request.suretyBond" /><span class="right"><img src='${pageContext.request.contextPath}/img/check.png' align="absmiddle" class="imgcheck" alt="Surety Bond"/></span></li>
								<li><s:text name="label.request.documentaryLetterOfCreditConfirmation" /><span class="right"><img src='${pageContext.request.contextPath}/img/check.png' align="absmiddle" class="imgcheck" alt="Documentary Letter of Credit Confirmation"/></span></li>								
								<li class="dropdown active nobg"><s:text name="label.request.notSure" /></li>	
							</c:if>		
							</ul>
						</div>
					</div>
				</div>
				<div class="span4 left">
					<div class="box">
						<div class="boxHead"><s:text name="label.request.manageExistingRequests" /></div>
						<div class="boxContent">
							<h3><s:text name="label.request.trackAndManageRequests" /></h3>
							<ul>
								<li>
									<s:url action="displayMyTransactionDashboard.action" namespace="/int/dashboard" var="myTransactionDashboardURL" />
									<c:if test="${landingpageDetails.pendingMyApprovalNum gt 0}">
										<a href="<s:property value="#myTransactionDashboardURL" />"><s:text name="label.request.pendingMyApprovals" />
										<fmt:formatNumber type="NUMBER" value="${landingpageDetails.pendingMyApprovalNum}" maxFractionDigits="0"/></a>
									</c:if>
									<c:if test="${empty landingpageDetails.pendingMyApprovalNum or
									landingpageDetails.pendingMyApprovalNum eq 0}">
										<s:text name="label.request.pendingMyApprovals" />
										<fmt:formatNumber type="NUMBER" value="${landingpageDetails.pendingMyApprovalNum}" maxFractionDigits="0"/>
									</c:if>
								</li>
								<li>
									<s:url action="displayAllRequestDashboard.action" namespace="/int/dashboard" var="allRequestDashboardURL" />
									<c:if test="${landingpageDetails.trackInFlightRequestsNum gt 0}">
										<a href="<s:property value="#allRequestDashboardURL" />"><s:text name="label.request.trackInFlightRequests" />
										<fmt:formatNumber type="NUMBER" value="${landingpageDetails.trackInFlightRequestsNum}" maxFractionDigits="0"/></a>
									</c:if>
									<c:if test="${empty landingpageDetails.trackInFlightRequestsNum or 
									landingpageDetails.trackInFlightRequestsNum eq 0}">
										<s:text name="label.request.trackInFlightRequests" />
										<fmt:formatNumber type="NUMBER" value="${landingpageDetails.trackInFlightRequestsNum}" maxFractionDigits="0"/>
									</c:if>
									
								</li>
							</ul>
                            <hr>
                            <div id="createAmendmentRiderDiv">
								<div>
									<h3><s:text name="label.request.createAmendmentOrRider" /></h3>
									<div class="radio-container">
										<label class="radio">
											<input type="radio" value="issuerReferenceNumber" name="createAmendmentRider" class="createAmendmentRider">
											<s:text name="label.request.issuerReferenceNumber" />
										</label>
										<label class="radio">
											<input type="radio" value="alocRecNo" name="createAmendmentRider" class="createAmendmentRider">
											<s:text name="label.request.alocRecNo" />
										</label> 
									</div>
								</div>
								<p class="hide span3a valAmdRidError" ></p>
								<input type="text" class="span160" />
								<c:if test="${isEligible}">
								<input type="submit" class="btn-secondary" value="Create" />
								</c:if>
								<c:if test="${not isEligible}">
								<input type="submit" class="btn-secondary" value="Create" disabled="disabled"/>
								</c:if>
								<p class="guidance">Enter the exact value in order to create the Amendment/Rider request</p>
								<s:form action="openAmendmentRequest.action" namespace="/int/requestor" id="openAmendmentRequestForm" cssStyle="margin: 0px 0px 10px">
									<s:hidden name="requestId" id="requestId1" />
									<s:hidden name="instrumentId" id="instrumentId1" />
								</s:form>
								<s:form action="openRiderRequest.action" namespace="/int/requestor" id="openRiderRequestForm" cssStyle="margin: 0px 0px 10px">
									<s:hidden name="requestId" id="requestId2" />
									<s:hidden name="instrumentId" id="instrumentId2" />
								</s:form>
							</div>
						</div>
					</div>
				</div>
			</div>
            
            <c:if test="${not empty sessionScope.reportsAccessFlag && sessionScope.reportsAccessFlag eq 'Y'}">          
			<div class="row">
				<div class="span8 left">
					<div class="box">
						<div class="boxHead"><s:text name="label.request.reporting" /></div>
							<div class="boxContent">
								<div class="span3 left" style="margin:0px;">
									<h3><s:text name="label.request.standardReports" /></h3>
									<ul>
										<s:url action="agingReport.action" namespace="/int/reports" var="agingReport" />
										<li><a href="<s:property value="agingReport"/>"><s:text name="label.request.aging" /></a></li>
										<s:url action="averageFeePaid.action" namespace="/int/reports" var="averageFeePaid" />
										<li><a href="<s:property value="averageFeePaid"/>"><s:text name="label.request.averageFeesPaid" /></a></li>
										<s:url action="bidSuccessReports.action" namespace="/int/reports" var="bidSuccessReport" />
										<li><a href="<s:property value="bidSuccessReport"/>"><s:text name="label.request.bidSuccess" /></a></li>
										<s:url action="loadContingentReport.action" namespace="/int/reports" var="contigunentReport" />
										<li><a href="<s:property value="contigunentReport"/>"><s:text name="label.request.contingentLiability"/></a></li>
										<s:url action="loadCycleTimeReports.action" namespace="/int/reports" var="loadCycleTimeReport" />
										<li><a href="<s:property value="loadCycleTimeReport"/>"><s:text name="label.request.cycleTime" /></a></li>
										<s:url action="ecsoReport.action" namespace="/int/reports" var="ecsoReport"/>
										<li><a href="<s:property value="ecsoReport"/>"><s:text name="label.request.electronicCreditSupportObligation" /></a></li>
										<s:url action="feesPaidReports.action" namespace="/int/reports" var="feesPaidReport" />
										<li><a href="<s:property value="feesPaidReport"/>"><s:text name="label.request.feesPaid" /></a></li>
										<s:url action="feeprojectionReport.action" namespace="/int/reports" var="feeprojectionReport" />
										<li><a href="<s:property value="feeprojectionReport"/>"><s:text name="label.request.feeProjection" /></a></li>
										<s:url action="feeQuotationReport.action" namespace="/int/reports" var="feeQuotationReport" />
										<li><a href="<s:property value="feeQuotationReport"/>"><s:text name="label.request.feeQuotation" /></a></li>
										<s:url action="gcfoReport.action" namespace="/int/reports" var="gcfoReport"/>
										<li><a href="<s:property value="gcfoReport"/>"><s:text name="label.request.globalCreditFacilityOnline" /></a></li>
                                        <s:url action="assignInsuanceValuesReports.action" namespace="/int/reports" var="assignInsuanceValues" />
										<li><a href="<s:property value="assignInsuanceValues"/>"><s:text name="label.request.issuanceAndExpiration" /></a></li>
										<s:url action="userReport.action" namespace="/int/reports" var="userReport" />
										<li><a href="<s:property value="userReport"/>"><s:text name="label.request.userReport" /></a></li>
									</ul>
								</div>	
								
								<div class="span4 right">
									<h3><s:text name="label.request.customReports" /></h3>
									<p class="customContent"><label><s:text name="label.request.allowsForTheCreationOfUpToTen" /></label></p>
									<ul>
										<s:url action="customReport.action" namespace="/int/reports" var="customReport" />
										<li><a href="<s:property value="customReport"/>"><s:text name="label.request.custom" /></a></li>
									</ul>
								</div>		
<div class="clear"></div>								
							</div>	
					</div>
				</div>
			</div>
			</c:if>
		</div>
		<div class="right">
			<div class="row">
				<div class="span4 left">
					<div class="box">
						<div class="boxHead"><s:text name="label.request.closeTransaction" /></div>
						<div class="boxContent" >
							<div id="closeTransactionDiv">
							<div class="radio-container">
								<label class="radio">
									<input type="radio" value="issuerReferenceNumber" name="closeTransaction" class="closeTransaction">
									<s:text name="label.request.issuerReferenceNumber" />
								</label>
								<label class="radio">
									<input type="radio" value="alocRecNo" name="closeTransaction" class="closeTransaction">
									<s:text name="label.request.alocRecNo" />
								</label> 
							</div>
							<p class="hide closeTransError"></p>
							<input type="text" class="span160" />
							<input type="button" class="btn-secondary" value="Search" />
							<p class="guidance">Enter the exact value in order to close transaction</p>								
							</div>
						</div>
						<s:form action="openRequest.action" namespace="/int" id="openCloseTransactionForm" cssStyle="margin: 0px 0px 10px">
							<s:hidden name="requestId" id="requestId" />
							<s:hidden name="wfid" id="wfid" />
							<s:hidden name="queueName" id="queueName" />
							<s:hidden name="procedureName" id="procedureName" />
							<s:hidden name="stageName" id="stageName" />
							<s:hidden name="instrumentId" id="instrumentId" />
						</s:form>
					</div>
                    
					<div class="box">
						<div class="box">
						<div class="boxHead"><s:text name="label.request.resources" /></div>
						<div class="boxContent box3">
						<s:url action="downloadResourcePDF.action" namespace="/int" var="glossaryURL" escapeAmp="false" encode="true">
								<s:param name="resourceType">glossary</s:param>	
						</s:url>
						<div class="glossary"></div> <div class="resourceTxt"><a href="<s:property value="#glossaryURL"/>"><s:text name="label.request.glossary" /></a></div>
                        <hr>
                        <s:url action="downloadResourcePDF.action" namespace="/int" var="userManualURL" escapeAmp="false" encode="true">
								<s:param name="resourceType">userManual</s:param>	
						</s:url>
						<div class="userManual"></div> <div class="resourceTxt"><a href="<s:property value="#userManualURL" />" ><s:text name="label.request.userManual" /></a></div>
                        <hr>
                        <s:url action="help.action" namespace="/int" encode="true" var="helpURL"/>
						<div class="help"></div> <div class="resourceTxt"><a href="<s:property value="#helpURL"/>" ><s:text name="label.request.help" /></a></div>
                        <div class="clear"></div>
						</div>	
						</div>
					</div>
                    
                    <div class="box">
						<div class="boxHead"><s:text name="label.request.feeResearch" /></div>
						<div class="boxContent">
							<label><s:text name="label.request.obtainFeeDetails"/></label>
							<ul>
								<s:url action="searchFeeHistory.action" namespace="/int/admin" var="feeHistoryURL" />
								<li> <a href="<s:property value="#feeHistoryURL" />" ><s:text name="label.request.feeResearch" /></a></li>
							</ul>
						</div>
					</div>
					
				</div>
			</div>
		</div>
			
		
	</div> 

		<!-- BODY CONTENT ENDS HERE -->

   <%@include  file="../common/footerSection.jsp" %>

</body>
</html>