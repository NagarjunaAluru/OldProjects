<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="hwfs"  uri="/hwf-security-tags" %>
<!DOCTYPE html>
<html>
<head>
 <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><s:text name="label.treasuryAdminPortal.title" /></title>
<%@include file="../common/includeCommonScripts.jsp" %>
<%-- <link href="${pageContext.request.contextPath}/css/others/exnav.css" type="text/css" rel="stylesheet" media="screen"/> --%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/treasuryAdmin/treasuryAdminPortal.js"></script>
</head>
	<s:url action="openAmendmentWorkflowMgmt.action" namespace="/int/admin" var="openAmendmentWorkflowMgmtURL" />
	<s:url action="openStdFormatUrlManagement.action" namespace="/int/admin" var="treasuryAdminStdFormatURL" />			
	<s:url action="openReimbursementAgreement.action" namespace="/int/admin" var="reimbursementAgreementURL" />
	<s:url action="createUserAnnouncement.action" namespace="/int/admin" var="announcementMgmtURL" />
	<s:url action="loadActiveAnnouncement.action" namespace="/int/admin" var="activeAnnouncementsURL" />
	<s:url action="openRecordsRetentionManagement.action" namespace="/int/admin" var="retentionMgmtURL" />
	<s:url action="openSurety.action" namespace="/int/admin" var="openSuretyMgmtURL" />	
	<s:url action="openPole.action" namespace="/int/admin" var="poleNameURL" />
	<s:url action="openBUC.action" namespace="/int/admin" var="blockBUCURL" />
	<s:url action="openPurgeReport.action" namespace="/int/admin" var="PurgeReportURL" />
	<s:url action="openChangeRequestOwnership.action" namespace="/int/admin" var="changeRequestOwnershipURL" />
	
	<!-- APM Related URLS -->   
	<s:url action="getYearlist.action" namespace="/int/apm" var="apmFXRateHistoryURL" escapeAmp="false" encode="true"/>
	<s:url action="getCurrencySetUpDetails.action" namespace="/int/apm"	var="currencySetupURL" escapeAmp="false" encode="true"/>
	<s:url action="openFeePaymentRun.action" namespace="/int/apm" var="apmFeePaymentRunURL" escapeAmp="false" encode="true"/>
	<s:url action="openPaymentPeriod.action" namespace="/int/apm" var="apmPaymentPeriodURL" escapeAmp="false" encode="true"/>
	<s:url action="searchFeeHistory.action" namespace="/int/admin" var="feeHistoryURL" escapeAmp="false" encode="true"/>
	
	<!-- SiteAdmin Related URLS --> 
	<s:url action="openSiteAdminPage.action" namespace="/int/siteadmin" var="siteadminURL" escapeAmp="false" encode="true"/>
	<s:url action="openBusinessAdmin.action" namespace="/int/siteadmin" var="businessAdminURL" escapeAmp="false" encode="true"/>
	
	<!-- Swift Related URLS --> 
	<s:url action="openSwiftMessageMonitoring.action" namespace="/int/admin" var="swiftMessageMonitoringURL" escapeAmp="false" encode="true"/>
  <body>
	<div class="container main">
		<jsp:include page="../common/headerSection.jsp">
			<jsp:param name="createReqPopup" value="Yes"></jsp:param>
		</jsp:include>	    
        
        <s:if test="hasActionMessages()">
	        <div id="siteMsg">
	        	<div class="sucessMsg">
	            	<a href="#" class="right successclose" style="font-size: 20px; margin-right:5px;">X</a><s:text name="label.treasuryAdminPortal.success" />
	            </div>
	            <div class="sucessContent"><s:actionmessage/></div>
	        </div>
        </s:if>
        
		<h1 class="page-title span12"><s:text name="label.treasuryAdminPortal.title" /></h1>
		<hr class="page-title-hr">
		<c:set var="activeBSA" value=""></c:set>
		<c:set var="inBSA" value=""></c:set>
		<hwfs:checkComponentPermission name="BusinessSiteAdminAccess" domainName="BusinessAccess">
			<c:set var="activeBSA" value="active"></c:set>	
			<c:set var="inBSA" value="in"></c:set>
		</hwfs:checkComponentPermission> 		
		<div class="form-mod">
			<ul class="nav nav-tabs tabs" id="exnav">
				<hwfs:checkComponentPermission name="SiteAdminAccess" domainName="BusinessAccess">
					<li class="active"><a data-toggle="tab" class="tt" href="#11"><s:text name="label.treasuryAdminPortal.treasuryAdminManagement" /></a>				
					</li>
					<li><a data-toggle="tab" class="tt" href="#22"><s:text name="label.treasuryAdminPortal.feePayment" /></a>
					</li>
				</hwfs:checkComponentPermission>
               
                <li class="${activeBSA}"><a data-toggle="tab" class="tt" href="#33"><s:text name="label.treasuryAdminPortal.siteCreation" /></a>
				</li>
				
				<li><a data-toggle="tab" class="tt" href="#44"><s:text name="label.treasuryAdminPortal.swiftMessageMonitoring" /></a>
				</li>
				
				<hwfs:checkComponentPermission name="ChangeOwnerAccess" domainName="BusinessAccess">
	                <li><a data-toggle="tab" class="tt" href="#55"><s:text name="label.treasuryAdminPortal.other" /></a>
					</li>
				</hwfs:checkComponentPermission>
				
				<hwfs:checkComponentPermission name="BusinessSiteAdminAccess" domainName="BusinessAccess">
	                <li><a data-toggle="tab" class="tt" href="#66"><s:text name="label.treasuryAdminPortal.delegationMaintenance" /></a>
					</li>
				</hwfs:checkComponentPermission>
			</ul>
	
	<div class="tab-content" id="myTabContent">
	
		<hwfs:checkComponentPermission name="SiteAdminAccess" domainName="BusinessAccess">
			<div id="11" class="tab-pane fade active in">
				<div class="form-mod">
					<h3><s:text name="label.treasuryAdminPortal.tabcontent.treasuryAdminManagement" />
					</h3>			
					<p class="descriptivetext"><s:text name="label.treasuryAdminPortal.treasuryUsers" /></p>
					<hr class="hr3">
					<div class="row">
						<div class="span12">
						<div class="boxTAP">
							<ul class="boxTAP1">
								<li><a href="<s:property value="#treasuryAdminStdFormatURL"/>" ><s:text name="label.treasuryAdminPortal.standardFormatManagement" /></a><span class="ttip info" data-original-title="<s:text name="label.treasuryAdminPortal.tooltip.standardFormatManagement"/>"></span></li>
								<li><a href="<s:property value="#reimbursementAgreementURL" />"><s:text name="label.treasuryAdminPortal.reimbursementAgreementManagement" /></a><span class="ttip info" data-original-title="<s:text name="label.treasuryAdminPortal.tooltip.reimbursementAgreement"/>"></span></li>
								<li><a href="<s:property value="#announcementMgmtURL" />"><s:text name="label.treasuryAdminPortal.announcementManagement" /></a><span class="ttip info" data-original-title="<s:text name="label.treasuryAdminPortal.tooltip.userannouncementManagement"/>"></span></li>
								<li><a href="<s:property value="#activeAnnouncementsURL" />"><s:text name="label.activeAnnouncements.activeAnnouncements"/></a></li>
								<li><a href="<s:property value="#openSuretyMgmtURL" />"><s:text name="label.treasuryAdminPortal.suretyNameManagement" /></a><span class="ttip info" data-original-title="<s:text name="label.treasuryAdminPortal.tooltip.suretyNameManagement"/>"></span></li>
								<li><a href="<s:property value="#poleNameURL" />"><s:text name="label.treasuryAdminPortal.poleManagement" /></a><span class="ttip info" data-original-title="<s:text name="label.treasuryAdminPortal.tooltip.poleNameManagement"/>"></span></li>
								<li><a href="<s:property value="#blockBUCURL" />"><s:text name="label.treasuryAdminPortal.blockedBusinessUnitCodeManagement" /></a><span class="ttip info" data-original-title="<s:text name="label.treasuryAdminPortal.tooltip.businessUnitCodeManagement"/>"></span></li> 
								<li><a href="<s:property value="#retentionMgmtURL" />"><s:text name="label.treasuryAdminPortal.recordRetentionManagement" /></a><span class="ttip info" data-original-title="<s:text name="label.treasuryAdminPortal.tooltip.recordRetentionManagement"/>"></span></li>
								<li><a href="<s:property value="#PurgeReportURL" />"><s:text name="label.recordsPurgeReport.pageTitle"/></a></li>
								<li><a href="<s:property value="#openAmendmentWorkflowMgmtURL" />"><s:text name="label.amendment.amendmentWorkflowManagement"/></a></li>
							</ul>
						</div>
						</div>
					</div>
				</div>
			</div><!-- END OF TAB 1 -->
    
			<div id="22" class="tab-pane fade">
				<h3><s:text name="label.treasuryAdminPortal.feePaymentsRun" /></h3>
					<div class="row">
						<div class="span12">
						<div class="boxTAP">
							<ul class="boxTAP1">
								<li><a href="<s:property value="apmPaymentPeriodURL"/>"><s:text name="label.treasuryAdminPortal.paymentPeriodSetup" /></a><span class="ttip info" data-original-title="<s:text name="label.treasuryAdminPortal.tooltip.paymentPeriod"/>"></span></li>
								<li><a href="<s:property value="apmFXRateHistoryURL"/>"><s:text name="label.treasuryAdminPortal.fXRateHistory" /></a><span class="ttip info" data-original-title="<s:text name="label.treasuryAdminPortal.tooltip.fxRateHistory"/>"></span></li>
								<li><a href="<s:property value="currencySetupURL"/>"><s:text name="label.treasuryAdminPortal.currencySetup" /></a></li>
								<li><a href="<s:property value="apmFeePaymentRunURL"/>"><s:text name="label.treasuryAdminPortal.feeRunAdmin" /></a><span class="ttip info" data-original-title="<s:text name="label.treasuryAdminPortal.tooltip.feeRunAdmin"/>"></span></li>
							</ul>
						</div>
						</div>
					</div>
			</div> <!-- end of TAB 2 -->
		</hwfs:checkComponentPermission>

	    <div id="33" class="tab-pane fade ${activeBSA} ${inBSA}">
			<h3><s:text name="label.treasuryAdminPortal.siteCreationHeader" /></h3>
				<div class="row">
					<div class="span12">
					<div class="boxTAP">
						<ul class="boxTAP1">
						<hwfs:checkComponentPermission name="SiteAdminAccess" domainName="BusinessAccess">
							<li><a href="<s:property value="#siteadminURL" />"><s:text name="label.treasuryAdminPortal.siteAdministration" /></a><span class="ttip info" data-original-title="<s:text name="label.treasuryAdminPortal.tooltip.siteAdmin"/>"></span></li>
						</hwfs:checkComponentPermission>
						<hwfs:checkComponentPermission name="BusinessSiteAdminAccess" domainName="BusinessAccess">
							<li><a href="<s:property value="#businessAdminURL" />"><s:text name="label.treasuryAdminPortal.tabcontent.delegationMaintenance" /></a><span class="ttip info" data-original-title="<s:text name="label.treasuryAdminPortal.tooltip.businessAdmin"/>"></span></li>
						</hwfs:checkComponentPermission>
						</ul>
					</div>
					</div>
				</div>
	    </div> <!-- END OF TAB 3 -->
	
		<div id="44" class="tab-pane fade">
			<h3><s:text name="label.treasuryAdminPortal.tabcontent.swiftMessageMonitoring" /></h3>
				<div class="row">
					<div class="span12">
					<div class="boxTAP">
						<ul class="boxTAP1">
							<li><a href="<s:property value="#swiftMessageMonitoringURL" />"><s:text name="label.treasuryAdminPortal.tabcontent.swiftMessageMonitoring" /></a><span class="ttip info" data-original-title="<s:text name="label.treasuryAdminPortal.tooltip.feeAdministration"/>"></span></li>
						</ul>
					</div>
					</div>
				</div>
		</div>
	
		<hwfs:checkComponentPermission name="ChangeOwnerAccess" domainName="BusinessAccess">                
		    <div id="55" class="tab-pane fade">
				<h3><s:text name="label.treasuryAdminPortal.tabcontent.other" /></h3>
					<div class="row">
						<div class="span12">
						<div class="boxTAP">
							<ul class="boxTAP1">
								<hwfs:checkComponentPermission name="SiteAdminAccess" domainName="BusinessAccess">     
								<li><a href="<s:property value="currencySetupURL"/>"><s:text name="label.treasuryAdminPortal.currencySetup" /></a><span class="ttip info" data-original-title="<s:text name="label.treasuryAdminPortal.tooltip.currencySetup"/>"></span></li>
								<li><a href="<s:property value="#feeHistoryURL"/>"><s:text name="label.treasuryAdminPortal.feeAdministration" /></a><span class="ttip info" data-original-title="<s:text name="label.treasuryAdminPortal.tooltip.feeAdministration"/>"></span></li>
								<li><a href="<s:property value="apmFXRateHistoryURL"/>"><s:text name="label.treasuryAdminPortal.fXRateHistory" /></a><span class="ttip info" data-original-title="<s:text name="label.treasuryAdminPortal.tooltip.fxRateHistoryOther"/>"></span></li>
								</hwfs:checkComponentPermission>
								<li><a href="<s:property value="#changeRequestOwnershipURL" />"><s:text name="label.treasuryAdminPortal.changeRequestOwnership"/></a></li>
							</ul>
						</div>
						</div>
					</div>
			</div> <!-- END OF TAB 4 -->
		</hwfs:checkComponentPermission>
	
		<hwfs:checkComponentPermission name="BusinessSiteAdminAccess" domainName="BusinessAccess">
			<div id="66" class="tab-pane fade">
				<h3><s:text name="label.treasuryAdminPortal.tabcontent.delegationMaintenance" /></h3>
					<div class="row">
						<div class="span12">
						<div class="boxTAP">
							<ul class="boxTAP1">
								<li><a href="<s:property value="#businessAdminURL" />"><s:text name="label.treasuryAdminPortal.tabcontent.delegationMaintenance" /></a><span class="ttip info" data-original-title="This is an tooltip with more information"></span></li>
							</ul>
						</div>
						</div>
					</div>
			</div> <!-- END OF TAB 5 -->   
		</hwfs:checkComponentPermission>            
	</div>	
</div>
	</div>
	<%@include file="../common/footerSection.jsp"%>
</body>
</html>