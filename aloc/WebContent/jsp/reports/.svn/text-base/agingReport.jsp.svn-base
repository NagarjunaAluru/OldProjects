<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="hwfs"  uri="/hwf-security-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	    <title>Aging Report</title>
	    <%@include file="../common/includeCommonScripts.jsp"%>
	    <script type="text/javascript" src="${pageContext.request.contextPath}/js/reports/agingReport.js"></script>
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
			<h1 class="page-title span12"><s:text name="label.report.agingReport"/></h1>
			<p class="span12 left clear dashdesc"><s:text name="label.report.agingReportDesc"/></p>
			<hr class="page-title-hr"/>
			<form id="agingReportForm" method="post">
				<s:hidden id="insPurpseValue" name="reportsDetails.agingDetails[0].instrumentPurpose"></s:hidden>
				<s:hidden id="loginUserId" name="reportsDetails.agingDetails[0].agingUserSSO"></s:hidden>
				<s:hidden id="instPurposeId" name="reportsDetails.agingDetails[0].instrumentType"></s:hidden>
				<s:hidden id="availableSitesId" name="reportsDetails.agingDetails[0].siteIDs"></s:hidden>
				<s:hidden id="availableBankId" name="reportsDetails.agingDetails[0].issuer"></s:hidden>
				<s:hidden id="defaultNoOfMonths" name="recordCount"/>
				<div class="form-mod">
					<h2 class="acc_triggerA zeroborder"><a href="javascript:;"><s:text name="label.report.filterBy"/></a></h2>
					<hr class="h2-hr"/>
					<div class="acc_containerA">
			  			<s:label key="label.report.siteSelection" cssClass="bankLabel"> </s:label>
					    <div class="row">
							<div class="span2ab">
								<div class="form-row" style="width: 200px !important" id="siteSelection">
									<jsp:include page="/jsp/reports/siteSelectionReports.jsp" />
								</div>
							</div>
						</div>
						
						<s:label key="label.report.bankSelection" cssClass="bankLabel"> </s:label>
						<div class="row">
							<div class="span2ab">
								<div class="form-row" style="width: 200px !important" id="bankSelection">
									<jsp:include page="/jsp/reports/bankSelectionReports.jsp" />
								</div>
							</div>
						</div>
						
						<div class="row">
					       <s:hidden id="agingReportPathId" value="%{getText('ALOC_AGING_URL')}"></s:hidden>
						   <s:hidden id="spotfireWebplayerURLId" value="%{getText('ALOC_SpotfireURL_SERVER')}"></s:hidden>
						   <s:hidden id="userSSOId" name="ssoId"> </s:hidden>
						   <div class="span6">
								<div class="row" id="applicant">
									<div class="span6">
										<div class="form-row">
											<s:label key="label.report.applicantOrPrinicipal"
												theme="aloc"></s:label>
											<sj:autocompleter id="applicantName" onChangeTopics="getReportAutocompleterName"
												list="%{applicantAddressDtl}" cssClass="span3" listKey="name" listValue="name"
												parentTheme="aloc" name="reportsDetails.agingDetails[0].applicantPrincipalName"/>
										</div>
									</div>
								</div>
							</div>
							<div class="span6">
								<div class="row" id="Beneficiary">
									<div class="span6">
										<div class="form-row">
											<s:label key="label.report.beneficiaryOrObligee"
													theme="aloc"></s:label>
											<sj:autocompleter id="benficiaryName" onChangeTopics="getReportAutocompleterName"
												list="%{benficiaryAddressDtl}" cssClass="span3" listKey="name" listValue="name"
												parentTheme="aloc" name="reportsDetails.agingDetails[0].beneficiaryObligee" />
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="span6">
								<div class="row" id="BeneficiaryCountry">
									<div class="span6">
										<div class="form-row">
											<s:label key="label.report.beneficiaryOrObligeeCountry" theme="aloc"></s:label>
											<sj:autocompleter id="beneficiaryCountryId" list="%{#attr['com.ge.aloc.MasterDataFactory'].countries}"
												cssClass="span3" listKey="countryCode" onChangeTopics="getReportAutocompleterName"
												listValue="countryName" theme="aloc" name="reportsDetails.agingDetails[0].beneficiaryObligeeCountry" />
										</div>
									</div>
								</div>
							</div>
							<div class="span6">
								<div class="row" id="Gold">
									<div class="span6">
										<div class="form-row">
											<s:label key="label.report.legalEntityGoldID" theme="aloc"></s:label>
											<s:textfield name="reportsDetails.agingDetails[0].goldID" id="legalGoldId"></s:textfield>
										</div>
									</div>
								</div>
							</div>
						</div>
						
						<div class="row">
							<div class="span6">
								<div class="row" id="GEApplicant">
									<div class="span6">
										<div class="form-row">
											<s:label key="label.report.geApplicantReference" theme="aloc"></s:label>
											<s:textfield name="reportsDetails.agingDetails[0].geApplicantReference1" id="geApplicantReferenceId"></s:textfield>
										</div>
									</div>
								</div>
							</div>
							<div class="span6">
								<div class="row" id="BeneficiaryRef">
									<div class="span6">
										<div class="form-row">
											<s:label key="label.report.beneficiaryReference" theme="aloc"></s:label>
											<s:textfield name="reportsDetails.agingDetails[0].beneficiaryReference1" id="beneficiaryReferenceId"></s:textfield>
										</div>
									</div>
								</div>
							</div>
						</div>
						
						<div class="row">
							<div class="span6">
								<div class="row">
									<div class="span6">
										<div class="form-row">
											<s:label key="label.report.countryOfIssuance" theme="aloc"></s:label>
											<sj:autocompleter id="issuanceCountry" onChangeTopics="getReportAutocompleterName"
												list="%{#attr['com.ge.aloc.MasterDataFactory'].countries}"
												cssClass="span3" listKey="countryCode" listValue="countryName" theme="aloc" 
												name="reportsDetails.agingDetails[0].countryofIssuance"/>
										</div>
									</div>
								</div>
							</div>
							<div class="span6">
								<div class="row" id="Bundle">
									<div class="span6">
										<div class="form-row">
											<s:label key="label.report.bundleID" theme="aloc"></s:label>
											<s:textfield name="reportsDetails.agingDetails[0].inBundleId" id="bundleId"></s:textfield>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="span12">
								<div class="form-row">
									<table class="table table-striped table-bordered sortable">
										<thead>
											<tr>
												<th colspan="5"><s:label key="label.report.instrumentType" theme="aloc" cssStyle="color:white"></s:label></th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td colspan="1" width="100px">
												    <s:checkbox name="allCheckId" id="allCheckId" cssClass="checkallinsType"/>
												    <span><s:text name="label.report.all"/></span>
												</td>
												<td colspan="1" width="230px">
												     <s:checkbox name="bankGuaranteeCheck" id="bankGuaranteeCheck" cssClass="instrTypes" />
												     <span><s:text name="label.report.bankGuarantee"/></span>
												</td>
												<td colspan="1" width="230px">
												     <s:checkbox name="standbyLetterCheck" id="standbyLetterCheck" cssClass="instrTypes" />
												     <span><s:text name="label.report.standByLetterOfCredit"/></span>
												</td>
												<hwfs:checkComponentPermission name="IssuanceGEUserAccess" domainName="BusinessAccess">
													<td colspan="1" width="150px">
													    <s:checkbox name="suretyBondCheck" id="suretyBondCheck" cssClass="instrTypes"  />
													    <span><s:text name="label.report.suretyBond"/></span>
													</td>
												</hwfs:checkComponentPermission>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					
						<div class="row">
							<div class="span12">
								<div class="form-row">
									<table class="table table-striped table-bordered sortable">
										<thead>
											<tr>
												<th colspan="8"><s:label key="label.report.instrumentPurpose" theme="aloc" cssStyle="color:white"/></th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<s:set name="instrPurposeSize" value="%{#attr['com.ge.aloc.StaticDataFactory'].instrumentPurpose.size}"></s:set>
												<td width="12%">
												  <s:checkbox name="reportsDetails.agingDetails[0].alocRecord" value="all" fieldValue="true" cssClass="checkall"/> <s:text name="label.advanceSearch.checkbox.all"/> 
												</td>
												<s:iterator value="%{#attr['com.ge.aloc.StaticDataFactory'].instrumentPurpose}" status="stat">
												      <td>
														<s:checkbox name="reportsDetails.agingDetails[0].alocRecord" value="%{name}" fieldValue="%{ID}" cssClass="instrPurpose"/>
														<s:property value="name"/>
												     </td>
												</s:iterator>
											</tr>
										</tbody>
									 </table>
								</div>
							</div>
						</div>
						
						<div class="row" id="groupByDivId">
							<div class="span12 hide" id="errorDivId">
								<div class="form-row">
									<span class="optOutval-error hide" style="color:red"></span>
								</div>
							</div>
							<div class="span12">
								<div class="form-row">
									<table class="table table-striped table-bordered sortable">
										<thead>
											<tr>
												<th colspan="6"><s:label key="label.report.searchAndGroupBy" theme="aloc" cssStyle="color:white"/></th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td colspan="1" rowspan="3" width="70px">
												   <s:checkbox name="selectall" cssClass="groupByClass" id="selectallId"/><span><s:text name="label.report.all"/></span>
												</td>
												<td colspan="1" width="120px">
												    <s:checkbox name="reportsDetails.agingDetails[0].inGBAppPrincName" id="applicantPrincipalId" cssClass="groupByClass"/>
												    <span class="case"><s:text name="label.report.applicantOrPrinicipal"/></span>
												 </td>
												<td colspan="1" width="100px">
												    <s:checkbox name="reportsDetails.agingDetails[0].inGBBenObligName" id="beneficiaryId" cssClass="groupByClass"/>
												    <span class="case"><s:text name="label.report.beneficiaryOrObligee"/></span>
												</td>
												<td colspan="1" width="125px">
												    <s:checkbox name="reportsDetails.agingDetails[0].inGBBenRef1" id="beneficiaryRefId" cssClass="groupByClass"/>
												    <span class="case"><s:text name="label.report.beneficiaryReference"/></span>
												</td>
												<td colspan="1" width="100px">
												    <s:checkbox name="reportsDetails.agingDetails[0].inGBCountryOfIssue" id="countryofIssuanceId" cssClass="groupByClass"/>
												    <span class="case"><s:text name="label.report.countryOfIssuance"/></span>
												 </td>
												<td colspan="1" width="135px">
												    <s:checkbox name="reportsDetails.agingDetails[0].inGBBenObligCountry" id="obligeeCountryId" cssClass="groupByClass"/>
												    <span class="case"><s:text name="label.report.beneficiaryOrObligeeCountry"/></span>
												</td>
											</tr>
											<tr>
											    <td colspan="1" width="135px">
											        <s:checkbox name="reportsDetails.agingDetails[0].inGBGEAppRef1" id="geApplicantRefId" cssClass="groupByClass"/>
											        <span class="case"><s:text name="label.report.geApplicantReference"/></span>
											    </td>
												<td colspan="1" width="100px">
												    <s:checkbox name="reportsDetails.agingDetails[0].inGBGoldId" id="leGoldId" cssClass="groupByClass"/>
												    <span class="case"><s:text name="label.report.legalEntityGoldID"/></span>
												</td>
												<td colspan="1" width="100px">
												    <s:checkbox name="reportsDetails.agingDetails[0].inGBInstPurp" id="instrPurposeId" cssClass="groupByClass"/>
												    <span class="case"><s:text name="label.report.instrumentPurpose"/></span>
												</td>
												<td colspan="1" width="100px">
												    <s:checkbox name="reportsDetails.agingDetails[0].inGBInstType" id="instrTypeId" cssClass="groupByClass"/>
												    <span class="case"><s:text name="label.report.instrumentType"/></span>
												</td>
												<td colspan="1" width="100px">
												    <s:checkbox name="reportsDetails.agingDetails[0].inGBSiteCode" id="siteCodeId" cssClass="groupByClass"/>
												    <span class="case"><s:text name="label.report.siteCode"/></span>
												</td>
											</tr>
											<tr>
											     <td colspan="5" width="100px" >
											         <s:checkbox name="reportsDetails.agingDetails[0].inGBBundleId" id="gbBundleId" cssClass="groupByClass"/>
											         <span class="case"><s:text name="label.report.bundleID"/></span>
											     </td>
											</tr>
										</tbody>
									 </table>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="span12">
								<table>
									<tr>
										<td><s:label key="label.report.minimumMonths"
												theme="aloc" tooltip="%{getText('label.report.tooltip.agingMonths')}"/>
										</td>
									</tr>
									<tr>
										<td><s:select list="%{agingMonthList}" id="agingMonthsId" required="false"
												 name="reportsDetails.agingDetails[0].inAgingMonths" cssStyle="width:50px"/>
										</td>
									</tr>
								</table>
							</div>
						</div>
						<div class="row">
							<div class="span12">
								<table>
									<tr>
										<td><s:label key="label.report.groupingMonths"
												theme="aloc" tooltip="%{getText('label.report.tooltip.incrementalMonths')}"/>
										</td>
									</tr>
									<tr>
										<td><s:select list="%{agingMonthList}" id="incrementalMonths" required="false"
												 cssStyle="width:50px" name="reportsDetails.agingDetails[0].incrementalNumOfMonths"/>
										</td>
									</tr>
								</table>
							</div>
						</div>
						<!-- New Filters end here -->
						<div class="highlighted">
							<div class="row lastrow">
								<div class="span12 btn-container">
									<div class="form-row">
										<a href="javascript:;" class="btn btn-success-blue" id="generateReport"><s:label id="generateReportId"  key="label.report.generateReport"/></a>
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
							<p style="padding:8px;"><s:label key="label.report.agingReportDescGen" id="reportDescId" style="display: block;"/></p>
						</div>
					</div>
					<div class="span12">
						<div align="center">
							<p style="padding:8px;"><s:label key="label.report.noIssuancesFound" id="blankMessage" style="display: none;" /></p>
						</div>
				   	</div>
			    	<!-- webplayer Container -->
					<div class="clear" style="margin-bottom:20px!important;"></div>
					<div id="playerContainer">
						<div id="webPlayer" style="width: 940px!important; height: 600px!important; position:relative!important;"></div>
					</div>
					<div class="highlighted">
						  <div class="row lastrow">
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
		<%@include file="../common/footerSection.jsp"%>
	</body>
</html>