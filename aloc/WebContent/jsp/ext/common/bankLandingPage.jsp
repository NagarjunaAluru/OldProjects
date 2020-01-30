<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
  <head>
 
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title><s:text name="label.request.landigPageBank" /></title>
    <meta name="description" content="">
    <meta name="author" content="">
	<%@include file="/jsp/ext/common/includeCommonScripts.jsp" %>

    <!-- JS FOR FONT -->
    <script src="${pageContext.request.contextPath}/ext/public/js/ext/common/landingPage.js" type="text/javascript"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/ext/public/font/typeface-0.15.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/ext/public/font/ge_inspira_regular.typeface.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/ext/public/font/helvetica_lt_std_light.typeface.js"></script>

</head>

<body>
	<div class="container main">
	<%@include  file="/jsp/ext/common/headerSection.jsp" %>
		
	<h1 class="page-title span12"><s:text name="label.request.welcomeTo" /><s:text name="label.request.alocLabel" /></h1>
	<hr class="page-title-hr">
	<div class="clear"></div>
			<!--USER ANNOUNCEMENTS COMES HERE-->
			 <s:if test="%{landingpageDetails.userAnnouncements != null && landingpageDetails.userAnnouncements.size> 0}">	
	              <div id="infoMsg">
		        	<div class="inMsg">
		        	<a href="#" class="right infoclose">X</a>
		        	<img src='${pageContext.request.contextPath}/ext/public/img/info1.png' align="absmiddle" style="margin-left:-30px;" /><span style="padding-left:5px;">
		        	<s:text name="label.userannouncementmgmt.success"/></span></div>
		            <div class="inContent">	             					 	  			 
						 	<s:iterator value="landingpageDetails.userAnnouncements">											
						 		<s:property value="message" escape="false"/>							
									<p>																								
										<s:if test="%{geFileId !=0}">																																	
											<s:url id="fileDownload" action="downloadAttachment.action" namespace="/ext" encode="true" escapeAmp="false">
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
			 </s:if>	
		<div class="clear"></div>	    
		<div class="left">
			<div class="row">
				<div class="span4">
					<div class="box">
						<div class="boxHead"><s:text name="label.request.manageTransactions" /></div>
						<div class="boxContent">
                            <ul>
								<li>
									<s:url action="displayBankBidProcessDashboard.action" namespace="/ext/dashboard" var="bankBidProcessDashboardURL" />
									<c:if test="${landingpageDetails.pendingBidReplyNum gt 0}">
										<a href="<s:property value="#bankBidProcessDashboardURL" />"><s:text name="label.request.pendingBidReply" />
										<fmt:formatNumber type="NUMBER" value="${landingpageDetails.pendingBidReplyNum}" maxFractionDigits="0"/></a>
									</c:if>
									<c:if test="${empty landingpageDetails.pendingBidReplyNum or 
									landingpageDetails.pendingBidReplyNum eq 0}">
										<s:text name="label.request.pendingBidReply" />
										<fmt:formatNumber type="NUMBER" value="${landingpageDetails.pendingBidReplyNum}" maxFractionDigits="0"/>
									</c:if>
								</li>
                                <li>
                                	<s:url action="displayBankPendingIssDashboard.action" namespace="/ext/dashboard" var="bankPendingIssDashboardURL" />
									<c:if test="${landingpageDetails.pendingIssuanceNum gt 0}">
										<a href="<s:property value="#bankPendingIssDashboardURL" />"><s:text name="label.request.pendingIssuance" />
										<fmt:formatNumber type="NUMBER" value="${landingpageDetails.pendingIssuanceNum}" maxFractionDigits="0"/></a>
									</c:if>
									<c:if test="${empty landingpageDetails.pendingIssuanceNum or
									landingpageDetails.pendingIssuanceNum eq 0}">
										<s:text name="label.request.pendingIssuance" />
										<fmt:formatNumber type="NUMBER" value="${landingpageDetails.pendingIssuanceNum}" maxFractionDigits="0"/>
									</c:if>
                                </li>
								<li>
									<s:url action="displayBankPendingAmendmentDashboard.action" namespace="/ext/dashboard" var="displayBankPendingAmendmentDashboardURL" >
										<s:param name="instrumentTypes">5</s:param>
									</s:url>
									<c:if test="${landingpageDetails.pendingAmendmentNum gt 0}">
										<a href="<s:property value="#displayBankPendingAmendmentDashboardURL" />"><s:text name="label.request.pendingAmendment" />
										<fmt:formatNumber type="NUMBER" value="${landingpageDetails.pendingAmendmentNum}" maxFractionDigits="0"/></a>
									</c:if>
									<c:if test="${empty landingpageDetails.pendingAmendmentNum or
									landingpageDetails.pendingAmendmentNum eq 0}">
										<s:text name="label.request.pendingAmendment" />
										<fmt:formatNumber type="NUMBER" value="${landingpageDetails.pendingAmendmentNum}" maxFractionDigits="0"/>
									</c:if>
								</li>
							</ul>
						</div>
					</div>
				</div>
				
				<div class="span4 left">
					<div class="box">
						<div class="boxHead"><s:text name="label.request.closeTransaction" /></div>
						<div class="boxContent" id="closeTransactionDiv">
							<div class="radio-container">
								<label class="radio">
									<input type="radio" value="bankReferenceNumber" name="closeTransaction" class="closeTransaction">
									<s:text name="label.request.BankRefNo" />
								</label>
								<label class="radio">
									<input type="radio" value="alocRecNo" name="closeTransaction" class="closeTransaction">
									<s:text name="label.request.alocRecNo" />
								</label> 
							</div>
							<input type="text" class="span160" />
							<input type="button" class="btn-secondary" value="Search" />
							<p class="guidance">Enter the exact value in order to close transaction</p>
							<p class="hide closeTransError"></p>
						</div>
						<s:form action="openRequest.action" namespace="/ext" id="openCloseTransactionForm">
							<s:hidden name="requestId" id="requestId" />
							<s:hidden name="wfid" id="wfid" />
							<s:hidden name="queueName" id="queueName" />
							<s:hidden name="procedureName" id="procedureName" />
							<s:hidden name="stageName" id="stageName" />
							<s:hidden name="instrumentId" id="instrumentId" />
						</s:form>
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
									<!-- Temporarily commented which will be available for next release -->
										<s:url action="loadContingentReport.action" namespace="/ext/reports" var="contigunentReport" />
										<li><a href="<s:property value="contigunentReport"/>"><s:text name="label.request.contingentLiability"/></a></li>
										<s:url action="assignInsuanceValuesReports.action" namespace="/ext/reports" var="assignInsuanceValues" />
										<li><a href="<s:property value="assignInsuanceValues"/>"><s:text name="label.request.issuanceAndExpiration" /></a></li>
										<!--<s:url action="loadCycleTimeReports.action" namespace="/ext/reports" var="loadCycleTimeReport" />
										<li><a href="<s:property value="loadCycleTimeReport"/>"><s:text name="label.request.cycleTime" /></a></li>-->
										<s:url action="bidSuccessReports.action" namespace="/ext/reports" var="bidSuccessReport" />
										<li><a href="<s:property value="bidSuccessReport"/>"><s:text name="label.request.bidSuccess" /></a></li>
										
										<s:url action="feesPaidReports.action" namespace="/ext/reports" var="feesPaidReport" />
										<li><a href="<s:property value="feesPaidReport"/>"><s:text name="label.request.feesPaid" /></a></li>
										<s:url action="userReport.action" namespace="/ext/reports" var="userReport" />
										<li><a href="<s:property value="userReport"/>"><s:text name="label.request.userReport" /></a></li>
										<li></li>
									</ul>
								</div>	
								
								<%-- <div class="span4 right">
									<h3><s:text name="label.request.customReports" /></h3>
									<p><label><s:text name="label.request.allowsForTheCreationOfUpToFive" /></label></p>
									<ul>
										<s:url action="customReport.action" namespace="/ext/reports" var="customReport" />
										<li><a href="<s:property value="customReport"/>"><s:text name="label.request.custom" /></a></li>
									</ul>
								</div>		 --%>
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
						<div class="boxHead"><s:text name="label.request.feeResearch" /></div>
						<div class="boxContent">
						<label><s:text name="label.request.obtainFeeDetails" /></label>
						<ul>
							<s:url action="searchFeeHistory.action" namespace="/ext/admin" var="feeHistoryURL" />
							<li> <a href="<s:property value="#feeHistoryURL" />" ><s:text name="label.request.feeResearch" /></a></li>
						</ul>
						</div>
					</div>
					<br />
					<div class="box">
						<div class="boxHead"><s:text name="label.request.resources" /></div>
						<div class="boxContent box3">
						<s:url action="downloadResourcePDF.action" namespace="/ext" var="glossaryURL" escapeAmp="false" encode="true">
								<s:param name="resourceType">glossary</s:param>	
						</s:url>
						<div class="glossary"></div> <div class="resourceTxt"><a href="<s:property value="#glossaryURL"/>"><s:text name="label.request.glossary" /></a></div>
                        <hr>
                        <s:url action="downloadResourcePDF.action" namespace="/ext" var="userManualURL" escapeAmp="false" encode="true">
								<s:param name="resourceType">userManual</s:param>	
						</s:url>
						<div class="userManual"></div> <div class="resourceTxt"><a href="<s:property value="#userManualURL" />" ><s:text name="label.request.userManual" /></a></div>
                        <hr>
                        <s:url action="help.action" namespace="/ext" encode="true" var="helpURL"/>
						<div class="help"></div> <div class="resourceTxt"><a href="<s:property value="#helpURL"/>" ><s:text name="label.request.help" /></a></div>
                        <div class="clear"></div>
						</div>
					</div>
				</div>
			</div>
		</div>    

		<!-- BODY CONTENT ENDS HERE -->
	</div>
   <%@include  file="/jsp/ext/common/footerSection.jsp" %>
</body>
</html>