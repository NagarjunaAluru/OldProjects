<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib prefix="hwfs"  uri="/hwf-security-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<title>Issuance/Expiration Report</title>
		<%@include file="../common/includeCommonScripts.jsp"%>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/reports/issuanceExpiration.js"></script>
	    <script src="${pageContext.request.contextPath}/js/admin/util.js"></script>
		<script src="${pageContext.request.contextPath}/js/admin/Api.js"></script>
		<link href="${pageContext.request.contextPath}/css/common/reports.css" rel="stylesheet"/>
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
				<h1 class="page-title span12"><s:text name="label.report.issuanceAndExpiration"/></h1>
				<p class="span12 left clear dashdesc"><s:text name="label.report.issuanceAndExpirationDesc"/></p>
				<div class="clear" style="width: 100%;"></div>
				<hr class="page-title-hr"/>
				<form id="issuanceExpirationform" method="post">
					<s:hidden id="selectedSitesId" name="reportsDetails.issuanceExpirationDetails[0].siteIDs" />
					<s:hidden id="siteType" name="reportsDetails.issuanceExpirationDetails[0].siteTypes"></s:hidden>
					<s:hidden id="instrumentType" name="reportsDetails.issuanceExpirationDetails[0].instrumentTypes"></s:hidden>
					<s:hidden id="userssoId" name="reportsDetails.issuanceExpirationDetails[0].INUserSSO"></s:hidden>
					<s:hidden id="morBloombergRate" name="reportsDetails.issuanceExpirationDetails[0].INMORBloombergRate"/>
					<s:hidden id="issuanceExpirationPathId" value="%{getText('ALOC_ISSUANCE_EXPIRATION_URL')}"></s:hidden>
					<s:hidden id="spotfireWebplayerURLId" value="%{getText('ALOC_SpotfireURL_SERVER')}"></s:hidden>
					<s:hidden id="bloombergId" value="%{#attr['com.ge.aloc.MasterDataFactory'].bloombergRates}"></s:hidden>
					<s:hidden id="morRateId" value="%{#attr['com.ge.aloc.MasterDataFactory'].morRates}"></s:hidden>
					<s:hidden id="userSSOId" name="ssoId"> </s:hidden>
					<s:hidden id="morBloombergRateFlag" name="reportsDetails.issuanceExpirationDetails[0].INMORBLOOMBERGFLAG"></s:hidden>
					<div class="form-mod">
						<h2 class="acc_triggerA zeroborder"><a href="javascript:;"><s:text name="label.report.filterBy"/></a></h2>
						<hr class="h2-hr"/>
						<div class="acc_containerA">
								<h3 class="zerobormar"><s:text name="label.report.dates"/></h3>
								<p class="dashdesc"><s:text name="label.report.issuanceOrExpiryRange"/></p>
								<hr class="hr3"/>
								<!-- New Filters Start here -->
								<div class="row span11" id="checkBorderDivId" style="margin-left: 0px; margin-top:2px;margin-right:-2px">
									<div class="form-row">
										<table>
											<tr>
												<td class="form-row" id="checkExpDivId">
													<span class="optOutval-error hide" style="color:red"></span>
												</td>
											</tr>
											<tr>
												<td class="span4">
											    	<div>
														<s:checkbox name="reportsDetails.issuanceExpirationDetails[0].USExpirationDate" id="expirationDateCheck" cssClass="checkbox" theme="aloc-TransactionParties"/>
														<s:label key="label.report.expiartionDate" theme="aloc" tooltip="%{getText('label.report.tooltip.expirationDates')}"></s:label>
													</div>
												</td>
										 		<td class="span4">
													<div>
														<s:checkbox name="reportsDetails.issuanceExpirationDetails[0].issuanceDate" id="issuanceDateCheck" cssClass="checkbox" theme="aloc-TransactionParties"/>
														<s:label key="label.report.issuanceDate" theme="aloc" tooltip="%{getText('label.report.tooltip.issuanceDates')}"></s:label>
													</div>
												</td>
											</tr>
											<tr class="row" style="margin-left: 1px; margin-top:2px;" id="dateBorderDivId">
												<td class="span4">
													<div class="hide" id="divExpId" style= "display: none;"> 
														<s:textfield cssClass="dateReports span1" id="expirationDateFrom" cssStyle="width:80px" name="reportsDetails.issuanceExpirationDetails[0].INExpStartDt"/>&nbsp;
														<s:text name="label.report.to"/> &nbsp;
														<s:textfield cssClass="dateReports span1" id="expirationDateTo" cssStyle="width:80px" name="reportsDetails.issuanceExpirationDetails[0].INExpEndDt"/>
													
														<div class="span4 hide" id="expDivId">
															<div class="form-row">
																<span class="optOutval-error1 hide" style="color:red"></span>
															</div>
														</div>
													</div>
												</td>
										 		<td class="span4">
													<div class="hide" id="divIssId" style="display: none;"> 
														<s:textfield cssClass="dateReports span1" id="issuanceDateFrom" cssStyle="width:80px" name="reportsDetails.issuanceExpirationDetails[0].INIssuanceStartDt"/>&nbsp;
														<s:text name="label.report.to"/> &nbsp;
														<s:textfield cssClass="dateReports span1" id="issuanceDateTo" cssStyle="width:80px" name="reportsDetails.issuanceExpirationDetails[0].INIssuanceEndDt"/>
													
														<div class="span4 hide" id="issDivId">
															<div class="form-row">
																<span class="optOutval-error2 hide" style="color:red"></span>
															</div>
														</div>
													</div>
												</td>
											</tr>
										</table>
									</div>
								</div>
								
								<hwfs:checkComponentPermission name="TreasuryDashboardAccess" domainName="BusinessAccess">
									<div class="row">
										<div class="span12">
											<div class="form-row">
												<table class="table table-striped table-bordered sortable">
													<thead>
														<tr>
															<th colspan="2"><s:label key="label.report.siteType" cssStyle="color:white"></s:label></th>
														</tr>
													</thead>
													<tbody>
														<tr>
															<td colspan="1" width="200px">
																<s:checkbox name="" id="financialCheck" cssClass="checkbox" theme="aloc-TransactionParties" />
																<span><s:text name="label.report.financial"/></span>
															</td>
															<td>
																<s:checkbox name="" id="industrialCheck" cssClass="checkbox" theme="aloc-TransactionParties"/>
																<span><s:text name="label.report.industrial"/></span>
															</td>			
														</tr>
													</tbody>
												</table>
											</div>
										</div>
								  	</div>
								</hwfs:checkComponentPermission>
								<s:label key="label.report.siteSelection" cssClass="bankLabel"> </s:label>
								<div class="row">
									<div class="span2ab">
										<div class="form-row" style="width: 200px !important" id="siteSelection">
											<jsp:include page="/jsp/reports/siteSelectionReports.jsp" />
										</div>
									</div>
								</div>
			
								<div class="row">
									<div class="span12">
										<div class="form-row">
											<table class="table table-striped table-bordered sortable">
												<thead>
													<tr>
														<th colspan="5"><s:label key="label.report.instrumentType" cssStyle="color:white"></s:label></th>
													</tr>
												</thead>
												<tbody>
													<tr>
														<td colspan="1" width="160px">
														    <s:checkbox name="" id="allCheckId" cssClass="checkbox"/>
														    <span><s:text name="label.report.all"/></span>
														</td>
														<td colspan="1" width="230px">
														    <s:checkbox name="" id="bankGuaranteeCheck" cssClass="checkbox"/>
														    <span><s:text name="label.report.bankGuarantee"/></span>
														 </td>
														<td colspan="1" width="230px">
														    <s:checkbox name="" id="standbyLetterCheck" cssClass="checkbox"/>
														    <span><s:text name="label.report.standByLetterOfCredit"/></span>
														</td>
														<hwfs:checkComponentPermission name="IssuanceGEUserAccess" domainName="BusinessAccess">
															<td colspan="1" width="230px">
															    <s:checkbox name="" id="suretyBondCheck" cssClass="checkbox"/><span>
															    <s:text name="label.report.suretyBond"/></span>
															</td>
														</hwfs:checkComponentPermission>
													</tr>
												</tbody>
											</table>
										</div>
									</div>
								</div>
								
								<div class="row">
									<div class="span6" id="instrAmtBorderId">
										<div class="form-row">
											<s:label key="label.report.instrumentAmountGreaterOrLessThan" theme="aloc" tooltip="%{getText('label.report.tooltip.instrumentAmount')}" >
											</s:label>
										</div>
										<s:textfield cssClass="span2" id="instrumentAmtFrom" name="reportsDetails.issuanceExpirationDetails[0].INInstrAmtFrom" cssStyle="margin-left:0px;align:left;" theme="aloc"/>&nbsp;
										<s:text name="label.report.to"/> &nbsp;
										<s:textfield cssClass="span2" id="instrumentAmtTo" name="reportsDetails.issuanceExpirationDetails[0].INInstrAmtTo" theme="aloc"/>
										<div class="span4 hide" id="instrAmtDivId" style="margin-left: 1px; margin-top:2px;">
											<div class="form-row">
												<span class="optOutval-error3 hide" style="color:red"></span>
											</div>
										</div>
									</div>
									<div class="span4">
										<div class="form-row">
										    <s:label key="label.report.instrumentCurrency" theme="aloc"/>
											<sj:autocompleter id="instrCurrencyId" onChangeTopics="getReportAutocompleterName"
												list="%{#attr['com.ge.aloc.MasterDataFactory'].currencies}"
												name="reportsDetails.issuanceExpirationDetails[0].instrumentCurrency"
												cssClass="span3" listKey="currencyCode" listValue="currencyName" parentTheme="aloc"/>
								   		</div>
								   </div>
								</div>
								
								<div class="row">
									<div class="span12">
										<div class="form-row">
											<s:label key="label.report.requestor" theme="aloc"></s:label>
										    <s:textfield name="personName" cssClass="span3 lookup-filterValue" id="businessContactPersonId" theme="aloc"/>
										    <s:url action="BusinessContactPersonLookup" namespace="/int" var="getBusinessContactPersonURL" escapeAmp="false" encode="true">
												<s:hidden name="businessContactName" value="BUC" cssClass="businessContactClass"></s:hidden>
												<s:param name="pageOrigin">Report</s:param>
												<s:param name="requestorType">currentRequestor</s:param>
											</s:url> 
											<a class="btn-secondary lookup" href="<s:property value="#getBusinessContactPersonURL"/>" ><s:text name="label.request.common.lookup"/></a>
											<img alt="Loading..." id="bcpIndicator" class="indicator" src="${pageContext.request.contextPath}/img/loading.gif" 
												style="height: 20px; display:none"/>
											<p><s:text name="label.report.ssoLookupDesc"/></p>
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
														<p><s:property value="reportsDetails.issuanceExpirationDetails[0].currentContact"/></p>
														<s:hidden name="reportsDetails.issuanceExpirationDetails[0].currentContact" id="tpApplicantBCPLName"></s:hidden>
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
														<p><s:property value="reportsDetails.issuanceExpirationDetails[0].requestor"/></p>
														<s:hidden name="reportsDetails.issuanceExpirationDetails[0].requestor" id="tpApplicantBCPSSO"></s:hidden>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
								
								<div class="row">
									<div class="span12">
										<div class="form-row">
											<s:label key="label.report.contactPerson" theme="aloc"></s:label>
										    <s:textfield name="personName" cssClass="span3 lookup-filterValue" id="businessContactPersonId" theme="aloc"/>
										    <s:url action="BusinessContactPersonLookup" namespace="/int" var="getBusinessContactPersonURL" escapeAmp="false" encode="true">
												<s:hidden name="businessContactName" value="BUC" cssClass="businessContactClass"></s:hidden>
												<s:param name="pageOrigin">Report</s:param>
												<s:param name="requestorType">currentContact</s:param> 
											</s:url> 
											<a class="btn-secondary lookup" href="<s:property value="#getBusinessContactPersonURL"/>" ><s:text name="label.request.common.lookup"/></a>
											<img alt="Loading..." id="bcpIndicator" class="indicator" src="${pageContext.request.contextPath}/img/loading.gif" 
												style="height: 20px; display:none"/>
											<p><s:text name="label.report.ssoLookupDesc"/></p>
											<br />
											<span class="lookup-error hide" style="color: #AE2C2C;"></span>
										</div>
									</div>
								</div>
					
								<div class="conditional-row" id="BusinessContactShow1" style="display: none;">
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
														<p><s:property value="reportsDetails.issuanceExpirationDetails[0].currentContact"/></p>
														<s:hidden name="reportsDetails.issuanceExpirationDetails[0].currentContact" id="contactBCPLName"></s:hidden>
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
														<p><s:property value="reportsDetails.issuanceExpirationDetails[0].currentContactNameSSO"/></p>
														<s:hidden name="reportsDetails.issuanceExpirationDetails[0].currentContactNameSSO" id="contactBCPSSO"></s:hidden>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
								
								<div class="row">
									<div class="span6">
										<div class="row" id="Obligee">
											<div class="span6">
												<div class="form-row">
													<s:label key="label.report.beneficiaryOrObligee" theme="aloc"></s:label>
													<sj:autocompleter id="benficiaryName" onChangeTopics="getReportAutocompleterName"
														list="%{benficiaryAddressDtl}" cssClass="span3" listKey="name" listValue="name"
														parentTheme="aloc" name="reportsDetails.issuanceExpirationDetails[0].beneficiaryObligeeNames" />
												</div>
											</div>
										</div>
									</div>
									<div class="span6">
										<div class="row">
											<div class="span6">
												<div class="form-row">
													<s:label key="label.report.obligeeCountry" theme="aloc"></s:label>
													<sj:autocompleter id="obligeeCountry" cssClass="span3"
														list="%{#attr['com.ge.aloc.MasterDataFactory'].countries}" parentTheme="aloc"
														listKey="countryName" onChangeTopics="getReportAutocompleterName" listValue="countryName"
														name="reportsDetails.issuanceExpirationDetails[0].beneficiaryObligeeCountry" />
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
													<sj:autocompleter id="issuanceCountry" list="%{#attr['com.ge.aloc.MasterDataFactory'].countries}"
														cssClass="span3" listKey="countryCode" listValue="countryName" onChangeTopics="getReportAutocompleterName"
														parentTheme="aloc" name="reportsDetails.issuanceExpirationDetails[0].countryOfIssuance"/>
												</div>
											</div>
										</div>
									</div>
									<div class="span6">
										<div class="row" id="AppName">
											<div class="span6">
												<div class="form-row">
													<s:label key="label.report.applicantOrPrinicipal" theme="aloc"></s:label>
													<sj:autocompleter id="applicantName" onChangeTopics="getReportAutocompleterName"
														list="%{applicantAddressDtl}" cssClass="span3" listKey="name" listValue="name"
														parentTheme="aloc" name="reportsDetails.issuanceExpirationDetails[0].applicantPrincipals"/>
												</div>
											</div>
										</div>
									</div>
			
								</div>
								<div class="row">
										<div class="span6">
											<div class="row" id="TriName">
												<div class="span6">
													<div class="form-row">
														<s:label key="label.report.thirdPartyApplicant" theme="aloc"></s:label>
														<sj:autocompleter id="tripartyApplicantId" onChangeTopics="getReportAutocompleterName"
															list="%{thirdPartyAddressDtl}" cssClass="span3" listKey="name" listValue="name"
															parentTheme="aloc" name="reportsDetails.issuanceExpirationDetails[0].thirdpartyApplicants"/>
													</div>
												</div>
											</div>
										</div>
										<hwfs:checkComponentPermission name="IssuanceGEUserAccess" domainName="BusinessAccess">
											<div class="span6">
												   <div class="row">
												   		<div class="span5" id="divFxRateBorderId">
															<div class="form-row">
																<div class="form-row">
																	<s:label key="label.report.fxRateSelection" theme="aloc"></s:label>
																</div>
																<div class="form-row">
										                            <s:radio name="reportsDetails.issuanceExpirationDetails[0].FXRateMonthMOR" cssClass="radio" id="fxRateSelection" list="#{'MOR':'MOR','Bloomberg':'Bloomberg'}" theme="aloc" labelposition="right"/>								
															    </div>
															</div>
															<div class="span3 hide" id="fxRateDivId" style="padding-top:10px">
																<div class="form-row">
																	<span class="optOutval-error4 hide" style="color:red"></span>
																</div>
											       			</div>
											       		</div>
											       	</div>
											</div>
										</hwfs:checkComponentPermission>
								</div>
								<div class="row">
									<div class="span6">
										<div class="form-row">
											<s:label key="label.report.issuer" theme="aloc"></s:label>
											<sj:autocompleter id="issuerId" list="%{bankDetailsList}" cssClass="span3" onChangeTopics="getReportAutocompleterName"
											     listKey="bankName" listValue="siteName" name="reportsDetails.issuanceExpirationDetails[0].issuer"/>
										</div>
									</div>
									<div class="span6">
										<s:label key="label.report.issuingBankBranch" theme="aloc"></s:label>
										<sj:autocompleter id="issuingBankBranchId" list="%{bankDetailsList}" cssClass="span3" onChangeTopics="getReportAutocompleterName"
											    listKey="siteId" listValue="bankCode" name="reportsDetails.issuanceExpirationDetails[0].issuingBankBranch"/>
									</div>
								</div>
								<div class="row">
									<div class="span6">
										<s:label key="label.report.issuerReference" theme="aloc"></s:label>
										<s:textfield cssClass="span3" id="issuerReferenceId" name="reportsDetails.issuanceExpirationDetails[0].issuerReference" theme="aloc"/>
									</div>
									<div class="span6">
										<s:label key="label.report.customerReference" theme="aloc"></s:label>
										<s:textfield cssClass="span3" id="customerReferenceId" name="reportsDetails.issuanceExpirationDetails[0].inCustRef" theme="aloc"/>
									</div>
								</div>
								<hwfs:checkComponentPermission name="IssuanceGEUserAccess" domainName="BusinessAccess">
									<div id="divBUCADNBorderId">
										<div class="row hide" id="bucAdnDivId" style="padding-top:10px">
											<div class="span12">
												<div class="row">
													<div class="span12">
														<div class="form-row">
															<span class="optOutval-error5 hide" style="color:red"></span>
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
															<s:label key="label.report.businessUnitCode" theme="aloc"></s:label>
															<s:textfield cssClass="span3" id="businessUnitCodeId" name="reportsDetails.issuanceExpirationDetails[0].BUC" theme="aloc"/>
														</div>
													</div>
												</div>
											</div>
											<div class="span5">
												<div class="row">
													<div class="span5">
														<div class="form-row">
															<s:label key="label.report.accountingDistributionNumber" theme="aloc"></s:label>
															<s:textfield cssClass="span3" id="accDistributionNumberId" name="reportsDetails.issuanceExpirationDetails[0].ADN" theme="aloc"/>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</hwfs:checkComponentPermission>
								<div style="height: 15px;"></div>
								<!-- New Filters end here -->
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
									<p style="padding:10px;"><s:label key="label.report.issuanceReportDesc" id="reportDescId" style="display: none;"/></p>
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
									<div id="webPlayer"
										style="width: 940px !important; height: 600px !important; position: relative !important;">
									</div>
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
			 	<div id="lookupDiv" style="width: 100%;"></div>
				<%@include file="../common/footerSection.jsp"%>
	    	</div>
		</body>
</html>