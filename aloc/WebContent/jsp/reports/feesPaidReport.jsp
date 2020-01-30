<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="hwfs"  uri="/hwf-security-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	    <title>Fees Paid Report</title>
	    <%@include file="../common/includeCommonScripts.jsp"%>
	    <script type="text/javascript" src="${pageContext.request.contextPath}/js/reports/feesPaid.js"></script>
	    <link href="${pageContext.request.contextPath}/css/common/reports.css" rel="stylesheet"/>
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
			<h1 class="page-title span12"><s:text name="label.report.feesPaidReport"/></h1>
			<p class="span12 left clear dashdesc"><s:text name="label.report.feesPaidReportDesc"/></p>
			<hr class="page-title-hr"/>
			<form id="feesPaidReportForm" method="post">
				<s:hidden id="selectedBanksId" name="reportsDetails.feesPaidDetails[0].issuer" />
				<s:hidden id="selectedSitesId" name="reportsDetails.feesPaidDetails[0].businessSites" />
				<s:hidden id="UserSSO" name="reportsDetails.feesPaidDetails[0].feesPaidUserSSO" />
				<s:hidden id="gbIssuer" name="reportsDetails.feesPaidDetails[0].gbIssuer"/>
				<s:hidden id="gbBusinessSite" name="reportsDetails.feesPaidDetails[0].gbBusinessSite"/>
				<s:hidden id="gbCountryIssuance" name="reportsDetails.feesPaidDetails[0].gbCntryIssue"/>
				<s:hidden id="gbGeref1" name="reportsDetails.feesPaidDetails[0].gbGeref1"/>
				<s:hidden id="gbApplicant" name="reportsDetails.feesPaidDetails[0].gbApplicant" />
				<s:hidden id="gbBankRef" name="reportsDetails.feesPaidDetails[0].gbBankRef"/>
				<s:hidden id="morBloombergRate" name="reportsDetails.feesPaidDetails[0].morRate"/>
				<s:hidden id="feesPaidPathId" value="%{getText('ALOC_FEESPAID_SP_URL')}"></s:hidden>
		    	<s:hidden id="spotfireWebplayerURLId" value="%{getText('ALOC_SpotfireURL_SERVER')}"></s:hidden>
		    	<s:hidden id="userSSOId" name="ssoId"> </s:hidden>
		    	<s:hidden id="bloombergId" value="%{#attr['com.ge.aloc.MasterDataFactory'].bloombergRates}"></s:hidden>
		    	
		    	<div class="form-mod">
					<h2 class="acc_triggerA zeroborder"><a href="javascript:;"><s:text name="label.report.filterBy"/></a></h2>
					<hr class="h2-hr"/>
	     			<div class="acc_containerA">
						<p class="required-fields"><s:text name="label.report.requiredFields"/></p>
				
					<hwfs:checkComponentPermission name="IssuanceGEUserAccess" domainName="BusinessAccess">
					    <h5><s:label key="label.report.bankSelection" cssClass="bankLabel"> </s:label></h5>
						<div class="row">
							<div class="span2ab">
								<div class="form-row" style="width: 200px !important" id="bankSelection">
									<jsp:include page="/jsp/reports/bankSelectionReports.jsp" />
								</div>
							</div>
						</div>
					</hwfs:checkComponentPermission>
					<h5><s:label key="label.report.siteSelection" cssClass="bankLabel"> </s:label></h5>
					  <div class="row">
							<div class="span2ab">
								<div class="form-row" style="width: 200px !important" id="siteSelection">
									<jsp:include page="/jsp/reports/siteSelectionReports.jsp" />
								</div>
							</div>
						</div>
					  <div class="row" id="paymentBorderDivId" style="margin-left: 1px; margin-bottom:1px;">
					  	<div class="span5" style="margin-left: 1px; margin-bottom:1px;">
							<s:label key="label.report.paymentDate" theme="aloc" tooltip="%{getText('label.report.tooltip.paymentDate')}"/>
							<s:textfield cssClass="dateReports span1" id="paymentDateFromId" theme="aloc"
								name="reportsDetails.feesPaidDetails[0].paymentStartDt" cssStyle="width:75px"/>
							<s:text name="label.report.to" />
							<s:textfield cssClass="dateReports span1" id="paymentDateToId" theme="aloc"
								name="reportsDetails.feesPaidDetails[0].paymentEndDt" cssStyle="width:75px"/>
						</div>
						<div class="row span5 hide" id="paymentDivId" style="padding-top:8px">
						     <span class="optOutval-error hide" style="color:red"></span>
						 </div>
					   </div>
					   <div class="row" id="issuanceBorderDivId" style="margin-left: 1px; margin-bottom:1px;">
							<div class="span5" style="margin-left: 1px; margin-bottom:1px;">
								<s:label key="label.report.issuanceDate" theme="aloc"/>
								<s:textfield cssClass="dateReports span1" id="issuanceDateFromId" theme="aloc"
									name="reportsDetails.feesPaidDetails[0].issuanceStartDt" cssStyle="width:75px"/>
								<s:text name="label.report.to" />
								<s:textfield cssClass="dateReports span1" id="issuanceDateToId" theme="aloc"
									name="reportsDetails.feesPaidDetails[0].issuanceEndDt" cssStyle="width:75px"/>
							</div>
							<div class="row span5 hide" id="issuanceDivId" style="padding-top:8px">
						      	<span class="optOutval-error1 hide" style="color:red"></span>
						    </div>
						</div>
						<div class="row">
							<div class="span4">
								<div class="row" id="AppName">
									<div class="span4">
										<div class="form-row">
											<s:label key="label.report.applicantOrPrinicipal" theme="aloc"></s:label>
												<sj:autocompleter id="applicantName" onChangeTopics="getReportAutocompleterName"
													list="%{applicantAddressDtl}" cssClass="span3" listKey="name" listValue="name"
													parentTheme="aloc" name="reportsDetails.feesPaidDetails[0].appPrincplName"/>
										</div>
									</div>
								</div>
							</div>
							<div class="span4">
								<div class="row" id="geRef">
									<div class="span4">
										<div class="form-row">
										    <s:label key="label.report.geReference1" theme="aloc"/>
											<s:textfield id="geRefId" name="reportsDetails.feesPaidDetails[0].geref1" theme="aloc"/>
										</div>
									</div>
								</div>
							</div>
							<div class="span4">
								<div class="form-row">
									<s:label key="label.request.CountryOfIssuance" tooltip="%{getText('label.request.tooltip.CountryOfIssuance')}" theme="aloc"></s:label>
									<sj:autocompleter id="issuanceCountry" list="%{#attr['com.ge.aloc.MasterDataFactory'].countries}" onChangeTopics="getReportAutocompleterName"
										cssClass="span3" listKey="countryCode" listValue="countryName" theme="aloc" name="reportsDetails.feesPaidDetails[0].cntryIssue"/>
								</div>
							</div>
						</div>
		                
						<div class="row" id="groupByGridId" style="margin-left: 0px; margin-right: 0px;">
							<div class="row span12 hide" id="groupByDivId" style="padding-top:8px">
						      	<span class="optOutval-error2 hide" style="color:red"></span>
						    </div>
							<div class="span12" style="margin-left: 0px; margin-right: 0px;">
								<div class="form-row">
									<table class="table table-striped table-bordered sortable">
										<thead>
											<tr><th colspan="6"><s:text name="label.report.groupResultsBy"/></th></tr>
										</thead>
										<tbody>
											<tr>
											    <hwfs:checkComponentPermission name="IssuanceGEUserAccess" domainName="BusinessAccess">
													<td colspan="1"><s:checkbox name="Issuer" id="issuerId" cssClass="groupByFilter"/><span><s:text name="label.report.issuer"/></span></td>
												</hwfs:checkComponentPermission>
												<td colspan="1"><s:checkbox name="Business Site" id="businessSiteId" cssClass="groupByFilter"/><span><s:text name="label.report.businessSite"/></span></td>
												<td colspan="1"><s:checkbox name="Country of Issuance" id="countryofIssuanceId" cssClass="groupByFilter"/><span><s:text name="label.report.countryOfIssuance"/></span></td>
												<td colspan="1"><s:checkbox name="GE Reference 1" id="geRefGroupById" cssClass="groupByFilter"/><span><s:text name="label.report.geReference1"/></span></td>
												<td colspan="1"><s:checkbox name="Applicant" id="applicantId" cssClass="groupByFilter"/><span> <s:text name="label.report.applicant"/></span></td>
												<td colspan="1"><s:checkbox name="Bank Reference #" id="bankReferenceId" cssClass="groupByFilter"/><span><s:text name="label.report.bankReference"/></span></td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
						</div>
						<div class="clear"/>
						<div class="highlighted">
							 <div class="row lastrow">
								<div class="span12 btn-container">
									<div class="form-row">
										<a href="javascript:;" class="btn btn-success-blue" id="generateReport"><s:label key="label.report.generateReport" id="generateButtonId"/></a>
			                            <a href="javascript:;" class="btn-tertiary cancel" id="resetClick"><s:text name="label.report.resetFilters"/></a>   
										<br /> 
								    </div>
							    </div>
							</div>
						</div>
				   </div>
			   </div>
		       <div id="reportGridId">
					<div class="row lastrow">
						<div class="span12">
							<p style="padding:8px;"><s:label key="label.report.feesGenerateReportDesc" id="reportDescId" style="display: none;"/></p>
						</div>
					</div>
					<div class="span12">
						<div align="center">
							<p style="padding:8px;"><s:label key="label.report.noIssuancesFound" id="blankMessage" style="display: none;" /></p>
						</div>
					</div>
					<!-- VIDEO CONTAINER -->
					<s:label id="headerText" style="display: none;"></s:label>
					<div class="clear" style="margin-bottom: 20px !important;"></div>
					<div id="playerContainer">
						<div id="webPlayer" style="width: 940px!important; height: 600px!important; position:relative!important;"></div>
					</div>
					<div class="highlighted">
						<div class="row lastrow" id="exportId">
			                 <div class="span12 btn-container">
							     <div class="form-row">
			                          <a href="javascript:void()" class="btn-primary" id="exportResult"><s:text name="label.report.exportResults"/></a>
			                     </div>
			                 </div> 
				        </div>
			        </div>
		  		</div>
		 </form>
	</div>
	</div>
	<%@include file="../common/footerSection.jsp"%>
</body>
</html>