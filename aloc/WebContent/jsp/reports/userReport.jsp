<%@page import="com.ge.aloc.constants.ALOCConstants"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="hwfs"  uri="/hwf-security-tags" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	    <title><s:text name="label.report.userReport" /></title>
	    <%@include file="../common/includeCommonScripts.jsp"%>
	    <script type="text/javascript" src="${pageContext.request.contextPath}/js/reports/userReport.js"></script>
	    <link href="${pageContext.request.contextPath}/css/others/toggle.css" rel="stylesheet"/>
	    <link href="${pageContext.request.contextPath}/css/common/reports.css" rel="stylesheet"/>
	    <script src="${pageContext.request.contextPath}/js/toggle/toggle.js"></script>
	    <script src="${pageContext.request.contextPath}/js/admin/util.js"></script>
		<script src="${pageContext.request.contextPath}/js/admin/Api.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/font/typeface-0.15.js"></script>
	    <script type="text/javascript" src="${pageContext.request.contextPath}/font/ge_inspira_regular.typeface.js"></script>
	    <script type="text/javascript" src="${pageContext.request.contextPath}/font/helvetica_lt_std_light.typeface.js"></script>
	    <link type="text/css" href="${pageContext.request.contextPath}/css/others/jquery-ui-1.7.1.custom.css" rel="stylesheet" />
		<link type="text/css" href="${pageContext.request.contextPath}/css/others/ui.multiselect.css" rel="stylesheet" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/jquery-ui-1.8.custom.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/jquery.localisation-min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/jquery.tmpl.1.1.1.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/jquery.blockUI.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/ui.multiselect.js"></script>
		<script type="text/javascript">
			document.domain="<s:text name='ALOC_Domain_URL'/>";
		</script>
	</head>  
	<body>
		<div class="container main">
			<jsp:include page="../common/headerSection.jsp">
				<jsp:param name="createReqPopup" value="Yes"></jsp:param>
			</jsp:include>
			<div id="mainPage" style="width: 100%;">
				<h2 class="page-title span12"><s:text name="label.report.userReport"/></h2>
				<p class="span12 left clear dashdesc"><s:text name="label.report.userReportDesc"/></p>
			    <hr class="page-title-hr"/>
		    	<form id="userForm" method="post">
			    	<s:hidden id="selectedSiteIds" name="reportsDetails.userReportDetails[0].siteIDs" />
			    	<s:hidden id="userReportSSOId" name="reportsDetails.userReportDetails[0].userReportUserSSO"/>
			    	<s:hidden id="availableBankId" name="reportsDetails.userReportDetails[0].issuer"></s:hidden>
			    	<div class="form-mod">
				        <s:hidden id="userPathId" value="%{getText('ALOC_USER_URL')}"></s:hidden>
						<s:hidden id="spotfireWebplayerURLId" value="%{getText('ALOC_SpotfireURL_SERVER')}"></s:hidden>
						<s:hidden id="userSSOId" name="ssoId"> </s:hidden>
					    <div class="acc_container1">
				            <a name="first"></a>
				            <div class="row" id="validationDivId" style="margin-left: 0px;border-right: 0px;">
								<span class="optOutval-error hide" style="color:red"></span>
								<s:label key="label.report.siteSelection" cssClass="bankLabel"> </s:label>
							</div>
							<div class="row">
								<div class="span2ab">
									<div class="form-row" style="width:200px!important" id="siteSelection">
										<jsp:include page="/jsp/reports/siteSelectionReports.jsp" />
									</div>
								</div>							
							</div>
							<hwfs:checkComponentPermission name="DefaultViewTreasuryAccess" domainName="BusinessAccess">
								<s:hidden name="isTreasuryRole" value="true" id="isTreasuryRole" />
								<s:label key="label.report.bankSelection" cssClass="bankLabel"> </s:label>
								<div class="row">
									<div class="span2ab">
										<div class="form-row" style="width: 200px !important" id="bankSelection">
											<jsp:include page="/jsp/reports/bankSelectionReports.jsp" />
										</div>
									</div>
								</div>
							</hwfs:checkComponentPermission>
							<div class="row">
								<div class="span12">
									<div class="form-row">
										<s:label key="label.report.ssoUserName"></s:label>
										<s:textfield name="personName" cssClass="span3 lookup-filterValue" id="businessContactPersonId" theme="aloc"/>
										<s:url action="UserDetailsLookup" namespace="/int" var="getBusinessContactPersonURL" escapeAmp="false" encode="true">
											<s:hidden name="userReportType" value="userReportType" cssClass="userReportClass"></s:hidden>
										</s:url> 
										<a class="btn-secondary lookup" href="<s:property value="#getBusinessContactPersonURL"/>" ><s:text name="label.request.common.lookup"/></a>
										<img alt="Loading..." id="bcpIndicator" class="indicator" src="${pageContext.request.contextPath}/img/loading.gif" 
											style="height: 20px; display:none"/>
										<p><s:text name="label.report.ssoUserLookupDesc"/></p>
										<br />
										<span class="lookup-error hide" style="color: #AE2C2C;"></span>
									</div>
								</div>
							</div>
							<div class="conditional-row" id="BusinessShow" style="display: none;">
								<div class="row">
									<div class="span7">
										<div class="row">
											<div class="span2">
												<div class="form-row">
													<s:label key="label.report.name"/>
												</div>
											</div>
											<div class="span4 right">	
												<div class="form-row">
													<p><s:property value="reportsDetails.userReportDetails[0].name"/></p>
													<s:hidden name="reportsDetails.userReportDetails[0].name" id="tpApplicantBCPLName"></s:hidden>
												</div>
											</div><!-- end of block -->
										</div>
										<div class="row">
											<div class="span2">
												<div class="form-row">
													<s:label key="label.report.sso"/>
												</div>
											</div><!-- end of block -->
											<div class="span4 right">
												<div class="form-row">
													<p><s:property value="reportsDetails.userReportDetails[0].SSOUserID"/></p>
													<s:hidden name="reportsDetails.userReportDetails[0].SSOUserID" id="tpApplicantBCPSSO"></s:hidden>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="span12">
									<div class="form-row">
										<label><s:text name="label.report.statusOpt" /></label>
										<div class="radio-container status-check">
											<s:radio theme="aloc" name="reportsDetails.userReportDetails[0].status" cssClass="radio" list="#{'All':'All'}"
												id="statusAll" checked="checked"/>
											<s:radio theme="aloc" cssClass="radio" list="#{'Enabled':'Enabled'}"
												name="reportsDetails.userReportDetails[0].status" id="statusEnabled" />
											<s:radio theme="aloc" cssClass="radio" list="#{'Disabled':'Disabled'}"
												name="reportsDetails.userReportDetails[0].status" id="statusDisabled"/>
										</div>
									</div>
								</div><!-- end of block -->
							</div>
							<div class="row highlighted lastrow"> 
			                    <div class="span12 btn-container" style="margin-left: 0px;">
							        <div class="form-row">
			                           <a href="javascript:;" class="btn btn-success-blue" id="generateReport"><s:label key="label.report.generateReport" id="generateUserId"/></a>
			                           <a href="javascript:;" class="btn-tertiary cancel" id="resetClick"><s:text name="label.report.resetFilters"/></a>   
			                        </div>
			                    </div> 
						    </div>
						</div>
					</div>
					 <div id="reportGridId">
						<div class="row lastrow">
							<div class="span12">
								<p style="padding:8px;"><s:label key="label.report.userReportGen" id="reportDescId" style="display: none;"/></p>
							</div>
						</div>
						<div class="span12">
							<div align="center">
								<p style="padding:8px;"><s:label key="label.report.noIssuancesFound" id="blankMessage" style="display: none;" /></p>
							</div>
					   	</div>
						<div class="clear" style="margin-bottom:20px!important;"></div>
						<h3 class="zeroborder"><span class="dashdesc span12"><s:label id="headerText" key="label.report.userReport" cssStyle="display: none;"/></span></h3>
						<!-- VIDEO CONTAINER -->
						<div class="clear" style="margin-bottom:20px!important;"></div>
						<div id="playerContainer">
							<div id="webPlayer" style="width: 940px!important; height: 600px!important; position:relative!important;"></div>
						</div>
					    <div class="row highlighted lastrow" id="exportId">
		                    <div class="span12 btn-container" style="margin-left: 0px;">
						       <div class="form-row">
		                           <a href="javascript:void()" class="btn-primary" id="exportResult"><s:text name="label.report.exportResults"/></a>
		                        </div>
		                   </div> 
			            </div>
				    </div>
				</form>
			</div>
			<div id="lookupDiv" style="width: 100%;"></div>	
		</div>
		<%@include file="../common/footerSection.jsp"%>
	</body>
</html>