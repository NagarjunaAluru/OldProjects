<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib prefix="hwfs"  uri="/hwf-security-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
   "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	    <title><s:text name="label.report.feeProjectionReport"/></title>
	    
	    <%@include file="../common/includeCommonScripts.jsp"%>
	    <script type="text/javascript" src="${pageContext.request.contextPath}/js/reports/feeProjection.js"></script>
	    <script src="${pageContext.request.contextPath}/js/admin/util.js"></script>
		<script src="${pageContext.request.contextPath}/js/admin/Api.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/font/typeface-0.15.js"></script>
	    <script type="text/javascript" src="${pageContext.request.contextPath}/font/ge_inspira_regular.typeface.js"></script>
	    <script type="text/javascript" src="${pageContext.request.contextPath}/font/helvetica_lt_std_light.typeface.js"></script>
	    <link href="${pageContext.request.contextPath}/css/common/reports.css" rel="stylesheet"/>
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
			<h1 class="page-title span12"><s:text name="label.report.feeProjectionReport"/></h1>
			<p class="span12 left clear dashdesc"><s:text name="label.report.feeProjectionReportDesc"/></p>
			<hr class="page-title-hr"/>
			<form id="feeProjectionForm" method="post">
				<div class="acc_container1">
					<s:hidden id="morRateId" name="morRate"></s:hidden>
					<s:hidden id="feeProjectionPathId" value="%{getText('ALOC_FEEPROJECTION_URL')}"></s:hidden>
					<s:hidden id="spotfireWebplayerURLId" value="%{getText('ALOC_SpotfireURL_SERVER')}"></s:hidden>
					<s:hidden id="morBloombergRate" name="reportsDetails.feeProjectionDetails[0].INMORRATE"/>
					<s:hidden id="selectedSiteIds" name="reportsDetails.feeProjectionDetails[0].INSITEID"></s:hidden>
					<div class="form-mod">
						<h2 class="acc_triggerA zeroborder"><a href="javascript:;"><s:text name="label.report.filterBy"/></a></h2>
						<hr class="h2-hr"/>
						<div class="acc_containerA">
							<div id="filterBorderId" style="margin-bottom: 20px; margin-top: 10px">
								<div class="row">
									<div class="span5">
										<s:label key="label.report.filterBy" theme="aloc"/>
										<s:select headerKey="" headerValue="Select..."
											list="#{'Applicant':'Applicant','Bank':'Bank' ,'Beneficiary':'Beneficiary' ,'Country':'Country' ,'BundleID':'Bundle ID'}"
											name="reportsDetails.feeProjectionDetails[0].infbnumber" id="selectProjTypeId" theme="aloc" />
									</div>
									<div class="span4 hide" id="filterDivId">
										<div class="form-row">
											<span class="optOutval-error1 hide" style="color:red"></span>
										</div>
									</div>
								</div>
							</div>
				
		                    <!-- Filter by different rows -->
							<div id="selectedFilterBorderId" class="row">
								<div class="hide" id="bankId" style="margin-left: 0px; margin-bottom: 10px;">
									<div class="span5">
										<sj:autocompleter key="label.report.bank" id="bankNameId" list="%{bankDetailsList}" cssClass="span3"
											listKey="siteId" listValue="bankCode" onChangeTopics="getReportAutocompleterName"
											parentTheme="aloc" name="reportsDetails.feeProjectionDetails[0].INISSUERID" />
										<s:hidden cssClass="autoCompleterName" id="bankName"/>
									</div>
									<div class="hide span4" id="bankDivId">
										<div class="form-row">
											<span class="optOutval-error2 hide" style="color:red"></span>
										</div>
									</div>
								</div>
								<div class="hide" id="countryId" style="margin-left: 0px; margin-bottom: 10px;">
									<div class="span5">
										<sj:autocompleter key="label.report.country" id="issuanceCountry" list="%{#attr['com.ge.aloc.MasterDataFactory'].countries}"
											listKey="countryCode" listValue="countryName" onChangeTopics="getReportAutocompleterName"
											parentTheme="aloc" name="reportsDetails.feeProjectionDetails[0].INCUNTRYISSUANCE" cssClass="span3"/>
										<s:hidden cssClass="autoCompleterName" id="countryName"/>
									</div>
									<div class="hide span4" id="countryDivId">
										<div class="form-row">
											<span class="optOutval-error2 hide" style="color:red"></span>
										</div>
									</div>
								</div>
								<div class="hide" id="applicantId" style="margin-left: 0px; margin-bottom: 10px;">
									<div class="span5">
										<sj:autocompleter id="applicantName" list="%{applicantDtls}"
											cssClass="span3" listKey="name" listValue="name" key="label.report.applicant"
											parentTheme="aloc" name="reportsDetails.feeProjectionDetails[0].INAPPLNAME" onChangeTopics="getReportAutocompleterName"/>
									</div>
									<div class="hide span4" id="applicantDivId">
										<div class="form-row">
											<span class="optOutval-error2 hide" style="color:red"></span>
										</div>
									</div>
								</div>
								<div class="hide" id="benificiaryId" style="margin-left: 0px; margin-bottom: 10px;">
									<div class="span5">
										<sj:autocompleter key="label.report.beneficiary" id="benficiaryName" onChangeTopics="getReportAutocompleterName"
											list="%{benficiaryDtls}" cssClass="span3" listKey="name"
											listValue="name" parentTheme="aloc" name="reportsDetails.feeProjectionDetails[0].INBENENAME" />
									</div>
									<div class="hide span4" id="benificiaryDivId">
										<div class="form-row">
											<span class="optOutval-error2 hide" style="color:red"></span>
										</div>
									</div>
								</div>
								
								<div class="hide" id="bundleBorderId" style="margin-left: 0px; margin-bottom: 10px;">
									<div class="span5">
										<s:label key="label.report.bundleID" theme="aloc"/>
										<s:textfield  id="bundleId" parentTheme="aloc" name="reportsDetails.feeProjectionDetails[0].INBUNDLEID" cssClass="span3"></s:textfield>
									</div>
									<div class="hide span4" id="bundleDivId">
										<div class="form-row">
											<span class="optOutval-error2 hide" style="color:red"></span>
										</div>
									</div>
								</div>
							</div>
							
							<s:label key="label.report.siteSelection" cssClass="bankLabel"> </s:label>
							<div class="row">
								<div class="span2ab">
									<div class="form-row" style="width:200px!important" id="siteSelection">
										<jsp:include page="/jsp/reports/siteSelectionReports.jsp" />
									</div>
								</div>							
							</div>
						
							<div class="row" style="margin-bottom: 20px; margin-top: 30px" >
								<div class="highlighted pad10">
									<div class="row lastrow" style="margin-left: 0px;">
										<div class="span12" id="divBorderId1" style="border-right:-">
											<div class="row lastrow" style="margin-left: -14px;">
												<div class="span4">
													<s:label key="label.report.noOfMonths"  theme="aloc"/>
													<s:select headerKey="" headerValue="Select..." 
														list="#{'4':'4','8':'8','12':'12','16':'16','20':'20','24':'24','28':'28','32':'32','36':'36','40':'40',
																	'44':'44','48':'48','52':'52','56':'56','60':'60'}"
														name="reportsDetails.feeProjectionDetails[0].INNUMMONTHS" id="selectMonthId" theme="aloc" cssClass="span1a"/>
													<p><s:text name="label.report.noOfMonthsDesc"/></p>
												</div>
												<div class="hide span4" id="monthsDivId">
													<div class="form-row">
														<span class="optOutval-error3 hide" style="color:red"></span>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
				
							<div class="row" id="divBorderId2" style="margin-left: 1px; margin-bottom: 10px">
								<div id="morCurErr" class="hide" style="color: red;"></div>
								<table>
									<tr>
										<td width="76%">
											<s:label key="label.report.currency" theme="aloc"/>
											<s:select headerKey="USD" headerValue="US Dollar" id="instrumentCurrency" 
												list="%{#attr['com.ge.aloc.MasterDataFactory'].currencies}"
												name="reportsDetails.feeProjectionDetails[0].CURRENCYOFINSTRUMENT"	cssClass="span3" listKey="currencyCode" listValue="currencyName"
												theme="aloc" />
										</td>
										<td><img alt="Loading..." id="feeProjectionIndicator" class="indicatorReports" src="${pageContext.request.contextPath}/img/loading.gif" /></td>
									</tr>
								</table>
							</div>
				
							<div class="row highlighted lastrow" style="margin-top: 10px"> 
			                    <div class="span12 btn-container" style="margin-left: 0px;">
							        <div class="form-row">
			                           <a href="javascript:;" class="btn btn-success-blue" id="generateReport"><s:label key="label.report.generateReport" id="generateReportId"/></a>
			                           <a href="javascript:;" class="btn-tertiary cancel" id="resetClick"><s:text name="label.report.resetFilters"/></a>   
			                        </div>
			                    </div> 
							</div>
						</div>
					</div>
				</div>	
			</form>
			<div id="reportGridId">
				<div class="row lastrow">
					<div class="span12">
						<p style="padding:8px;"><s:label key="label.report.feeProjReportGen" id="reportDescId" style="display: none;"/></p>
					</div>
				</div>
				<div class="span12">
					<div align="center">
						<p style="padding:8px;"><s:label key="label.report.noIssuancesFound" id="blankMessage" style="display: none;" /></p>
					</div>
			   	</div>
				<s:label id="headerText" style="display: none;"></s:label>
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
			<div id="lookupDiv" style="width: 100%;"/>	
		</div>
		<%@include file="../common/footerSection.jsp"%>
	</body>
</html>