<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="hwfs" uri="/hwf-security-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	    <title>Average Fees Paid Report</title>
		<%@include file="../common/includeCommonScripts.jsp"%>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/reports/averagefeesPaid.js"></script>
		<script src="${pageContext.request.contextPath}/js/admin/util.js"></script>
		<script src="${pageContext.request.contextPath}/js/admin/Api.js"></script>
		<link href="${pageContext.request.contextPath}/css/common/reports.css" rel="stylesheet"/>
		<script type="text/javascript" src="${pageContext.request.contextPath}/font/typeface-0.15.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/font/ge_inspira_regular.typeface.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/font/helvetica_lt_std_light.typeface.js"></script>
		<script type="text/javascript">
			document.domain="<s:text name='ALOC_Domain_URL'/>";
	    </script>
	</head>
    <body>
		<div class="container main">
			<jsp:include page="../common/headerSection.jsp">
				<jsp:param name="createReqPopup" value="Yes"></jsp:param>
			</jsp:include>
			<h1 class="page-title span12"><s:text name="label.report.averageFeePaid" /></h1>
			<p class="span12 left clear dashdesc"><s:text name="label.report.averageFeePaidDesc" /></p>
			<hr class="page-title-hr"/>
			<form id="averageFeesPaidForm" method="post">
				<s:hidden id="spotfireWebplayerURLId" value="%{getText('ALOC_SpotfireURL_SERVER')}"></s:hidden>
				<s:hidden id="averageFeePaidId" value="%{getText('ALOC_AVERAGEFEEPAID_URL')}"></s:hidden>
			 	<s:hidden name="reportsDetails.averageFeesPaidDetails[0].INFBVALUE" id="inFBValue"></s:hidden>
			 	<div class="form-mod">
					<h2 class="acc_triggerA zeroborder"><a href="javascript:;"><s:text name="label.report.filterBy"/></a></h2>
					<hr class="h2-hr"/>
					<div class="acc_containerA">
						<div id="filterBorderId">
							<div class="row">
								<div class="span5">
									<s:label key="label.report.filterBy" theme="aloc"/>
									<s:select headerKey="" headerValue="Select..."
										list="#{'2':'Applicant','4':'Bank' ,'3':'Beneficiary' ,'1':'Country' , '5': 'Site ID'}"
										name="reportsDetails.averageFeesPaidDetails[0].INFBNUMBER" id="selectProjTypeId" theme="aloc"
										onChange="filterSelection();" />
								</div>
								<div class="span4 hide" id="filterDivId">
									<div class="form-row">
										<span class="optOutval-error1 hide" style="color:red"></span>
									</div>
								 </div>
							</div>
						</div>
						<!-- Filter by different rows -->
						<div id="selectedFilterBorderId">
								<div class="hide" id="bankId" style="margin-left: 0px;">
									<div class="row">
										<div class="span5">
											<sj:autocompleter key="label.report.bank" id="bankNameId" list="%{bankDetailsList}" cssClass="span3"
												listKey="siteId" listValue="bankCode" onChangeTopics="getReportAutocompleterName"
												parentTheme="aloc" name="" />
											<s:hidden cssClass="autoCompleterName" id="bankName"/>
										</div>
										<div class="hide span4" id="bankDivId">
											<div class="form-row">
												<span class="optOutval-error2 hide" style="color:red"></span>
											</div>
										</div>
									</div>
								</div>
								<div class="hide" id="countryId" style="margin-left: 0px;">
									<div class="row">
										<div class="span5">
											<sj:autocompleter key="label.report.country" id="issuanceCountry" list="%{#attr['com.ge.aloc.MasterDataFactory'].countries}"
												listKey="countryCode" listValue="countryName" onChangeTopics="getReportAutocompleterName"
												parentTheme="aloc" name="" cssClass="span3"/>
											<s:hidden cssClass="autoCompleterName" id="countryName"/>
										</div>
										<div class="hide span4" id="countryDivId">
											<div class="form-row">
												<span class="optOutval-error2 hide" style="color:red"></span>
											</div>
										</div>
									</div>
								</div>
								<div class="hide" id="applicantId" style="margin-left: 0px;">
									<div class="row">
										<div class="span5">
											<sj:autocompleter id="applicantName" list="%{applicantDtls}"
												cssClass="span3" listKey="name" listValue="name" key="label.report.applicant"
												parentTheme="aloc" name="" onChangeTopics="getReportAutocompleterName"/>
										</div>
										<div class="hide span4" id="applicantDivId">
											<div class="form-row">
												<span class="optOutval-error2 hide" style="color:red"></span>
											</div>
										</div>
									</div>
								</div>
				
								<div class="hide" id="benificiaryId" style="margin-left: 0px;">
									<div class="row">
										<div class="span5">
											<sj:autocompleter key="label.report.beneficiary" id="benficiaryName" onChangeTopics="getReportAutocompleterName"
												list="%{benficiaryDtls}" cssClass="span3" listKey="name"
												listValue="name" parentTheme="aloc" name="" />
										</div>
										<div class="hide span4" id="benificiaryDivId">
											<div class="form-row">
												<span class="optOutval-error2 hide" style="color:red"></span>
											</div>
										</div>
									</div>
								</div>
				
								<div class="hide" id="siteNameId" style="margin-left: 0px;">
									<div class="row">
										<div class="span5">
											<sj:autocompleter key="label.report.siteId" id="siteId" list="%{availableSitesList}"
												cssClass="span3" listKey="siteId" listValue="siteName"
												parentTheme="aloc" name="" onChangeTopics="getReportAutocompleterName" />
											<s:hidden cssClass="autoCompleterName" id="siteName"/>
										</div>
										<div class="hide span4" id="siteDivId">
											<div class="form-row">
												<span class="optOutval-error2 hide" style="color:red"></span>
											</div>
										</div>
									</div>
								</div>
						</div>
						<div id="borderDateId">
							<div class="row">
								<div class="span2">
									<s:label key="label.report.dateFrom" theme="aloc"/>
									<s:textfield cssClass="dateReports span1" id="dateFromId"
											name="reportsDetails.averageFeesPaidDetails[0].INMINDATE" cssStyle="width:80px;" />
								</div>
								<div class="span1">
									&nbsp;<s:label key="label.report.to"  theme="aloc"/>
								</div>
								<div class="span2">
									<s:label key="label.report.Dateto" theme="aloc"/>
									<s:textfield cssClass="dateReports span1" id="dateToId"
										name="reportsDetails.averageFeesPaidDetails[0].INMAXDATE" cssStyle="width:80px;" />
								</div>
								<div class="span4 hide" id="dateDivId">
									<div class="form-row">
										<span class="optOutval-error hide" style="color:red"></span>
									</div>
							   </div>
							</div>
					    </div>
					   
					    <div id="borderAmountId" style="margin-bottom:10px;" >
							<div class="row">
								<s:label key="label.report.amountRanage" cssStyle="padding-left:22px;"></s:label>
								<div class="span3">
									<s:textfield cssClass="span3" id="amountRangeId"
										name="reportsDetails.averageFeesPaidDetails[0].INAMTRANGEMIN" theme="aloc" />
								</div>
								<div class="span1">
									<s:label key="label.report.to"  theme="aloc" cssStyle="padding-left:20px"/>
								</div>
								<div class="span3">
									<s:textfield cssClass="span3" id="amountRangeToId"
										name="reportsDetails.averageFeesPaidDetails[0].INAMTRANGEMAX" theme="aloc" />
								</div>
								<div class="span4 hide" id="rangeDivId">
									<div class="form-row">
										<span class="optOutval-error3 hide" style="color:red"></span>
									</div>
							   </div>
							</div>
							<div class="clear" style="width: 100%;margin-bottom:10px;"></div>
						</div>
						
						<!-- New Filters end here -->
						<div class="highlighted">
							<div class="row lastrow">
								<div class="span12 btn-container">
									<div class="form-row">
										<a href="javascript:;" class="btn btn-success-blue" id="generateReport">
										<s:label id="generateReportId" key="label.report.generateReport" /></a> 
										<a href="javascript:;" class="btn-tertiary cancel" id="resetClick"><s:text name="label.report.resetFilters"/></a> 
										<br />
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div id="reportGridId">
					<div class="span12" id="divDescId">
						<p style="padding: 10px;">
							<s:label key="label.report.avgFeesPaidReportGen" id="reportDescId" style="display: none;" />
						</p>
					</div>
					<div class="span12">
						<div align="center">
							<p style="padding:8px;"><s:label key="label.report.noIssuancesFound" id="blankMessage" style="display: none;" /></p>
						</div>
				   	</div>
					<s:label id="headerText" style="display: none;"></s:label>
					<!-- webplayer Container -->
					<div class="clear" style="margin-bottom: 20px !important;"></div>
					<div id="playerContainer">
						<div id="webPlayer"
							style="width: 940px !important; height: 600px !important; position: relative !important;">
						</div>
					</div>
					<div class="highlighted">
						<div class="row lastrow">
							<div class="span12 btn-container">
								<div class="form-row">
									<a href="javascript:void()" class="btn-primary"
										id="exportResult"><s:text name="label.report.exportResults" /></a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>
	<%@include file="../common/footerSection.jsp"%>
    </body>
</html>