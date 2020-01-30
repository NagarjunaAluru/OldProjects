<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="hwfs"  uri="/hwf-security-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
   "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<title>Cycle Time Report</title>
		<%@include file="../common/includeCommonScripts.jsp"%>
		<script src="${pageContext.request.contextPath}/js/admin/util.js"></script>
		<script src="${pageContext.request.contextPath}/js/admin/Api.js"></script>
		<script type="text/javascript" src="../../font/typeface-0.15.js"></script>
		<script type="text/javascript" src="../../font/ge_inspira_regular.typeface.js"></script>
		<script type="text/javascript" src="../../font/helvetica_lt_std_light.typeface.js"></script>
		<link href="${pageContext.request.contextPath}/css/common/reports.css" rel="stylesheet"/>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/reports/cycleTime.js"></script>
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
			<h1 class="page-title span12"><s:text name="label.report.cycleTimeReport"/></h1>
			<p class="span12 left clear dashdesc"><s:text name="label.report.cycleTimeReportDesc"/></p>
			<div class="clear" style="width: 100%;"></div>
			<hr class="page-title-hr"/>
			<form id="cycletimeForm"  method="post">
				<s:hidden id="loginSSOId" name="reportsDetails.cycleTimeDetails[0].cycleTimeUserSSO" />
				<s:hidden id="selectedInstId" name="reportsDetails.cycleTimeDetails[0].instrumentTypes"></s:hidden>
				<s:hidden id="selectedSites" name="reportsDetails.cycleTimeDetails[0].siteIds"/>
	        	<s:hidden id="selectedInsPurpose" name="reportsDetails.cycleTimeDetails[0].instrumentPurposes"/>
				<s:hidden id="showResultsId" name="reportsDetails.cycleTimeDetails[0].showResultsIn" />
	            <s:hidden id="cycleTimePathId" value="%{getText('ALOC_CYCLETIME_URL')}"></s:hidden>
			    <s:hidden id="spotfireWebplayerURLId" value="%{getText('ALOC_SpotfireURL_SERVER')}"></s:hidden>
			    <s:hidden id="userSSOId" name="ssoId"> </s:hidden>
			    <div class="form-mod">
			    	<h2 class="acc_triggerA zeroborder"><a href="javascript:;"><s:text name="label.report.filterBy"/></a></h2>
			    	<hr class="h2-hr"/>
			    	<div class="acc_container1">
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
										<th colspan="5"><s:label key="label.report.instrumentType"
												theme="aloc" cssStyle="color:white"></s:label></th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td colspan="1" width="100px">
											<s:checkbox name="allCheckId" id="allCheckId" cssClass="checkallinsType"/>
											<span><s:text name="label.report.all"/></span>
										</td>
										<td colspan="1" width="150px">
											<s:checkbox name="bankGuaranteeCheck" id="bankGuaranteeCheck" cssClass="instrTypes" />
											<span><s:text name="label.report.bankGuarantee"/></span>
										</td>
										<td colspan="1" width="150px">
											<s:checkbox name="standbyLetterCheck" id="standbyLetterCheck" cssClass="instrTypes" />
											<span><s:text name="label.report.standByLetterOfCredit"/></span>
										</td>
										<hwfs:checkComponentPermission name="IssuanceGEUserAccess" domainName="BusinessAccess">
											<td colspan="1" width="150px">
												<s:checkbox name="suretyBondCheck" id="suretyBondCheck" cssClass="instrTypes"  />
												<span><s:text name="label.report.suretyBond"/></span>
											</td>
										</hwfs:checkComponentPermission>
										<td colspan="1"></td>
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
									<th colspan="8">
									   <s:label key="label.report.instrumentPurpose" theme="aloc" cssStyle="color:white"/>
									</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<s:set name="instrPurposeSize"
											value="%{#attr['com.ge.aloc.StaticDataFactory'].instrumentPurpose.size}"></s:set>
										<td>
										 	<s:checkbox name="reportsDetails.cycleTimeDetails[0].instrumentPurpose" value="all"
												 fieldValue="true" cssClass="checkall" /> 
											<s:text name="label.advanceSearch.checkbox.all" />
										</td>
										<s:iterator value="%{#attr['com.ge.aloc.StaticDataFactory'].instrumentPurpose}" status="stat">
											<td>
											   <s:checkbox name="reportsDetails.cycleTimeDetails[0].instrumentPurpose" value="%{name}"
													fieldValue="%{ID}" cssClass="instrPurpose" />
												<s:property value="name" /> 
											</td>
										</s:iterator>
	
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
	
				<div class="row" style="padding-bottom: 20px">
					<div class="span3">
						<s:label key="label.report.requestDate" />
						<s:textfield cssClass="dateReports span2" id="requestDate"
							name="reportsDetails.cycleTimeDetails[0].requestDate" cssStyle="width:80px"/>
					</div>
					<div class="span3 left">
						<s:label key="label.report.expirationDate" />
						<s:textfield cssClass="dateReports span2" id="expirationDate"
							name="reportsDetails.cycleTimeDetails[0].expirDate" cssStyle="width:80px"/>
					</div>
				</div>
	
				<div class="highlighted" style="height: 150px">
					<div class="row" style="list-style: none;">
						<div class="span12">
							<div class="row lastrow">
								<div class="span12">
									<h3 style="visibility: visible; border-bottom: #00437e 1px solid; line-height: 27px;font-family:Conv_GEInspRg;padding-bottom: 10px;margin: 0px 0px 20px;color:#555;font-size: 16px;">
										<s:text name="label.report.wildCardSearch" />
									</h3>
							   </div>
						    </div>
							<div class="row">
								<div class="span2">
									<s:label key="label.report.alocRecordNumber" />
									<s:textfield cssClass="span2" name="reportsDetails.cycleTimeDetails[0].ALOCRecordNumber"
										id="alocRecordId" style="background-color:#fff;" />
								</div>
								<div class="span3 left">
									<s:label key="label.report.businessUnitCode" />
									<s:textfield cssClass="span3" name="reportsDetails.cycleTimeDetails[0].BUCLike"
										id="businessUnitCodeId" />
								</div>
								<div class="span3 left">
									<s:label key="label.report.accountingDistributionNumber" />
									<s:textfield cssClass="span3" name="reportsDetails.cycleTimeDetails[0].ADNLike"
										id="accDestibutionNumberId" />
								</div>
								<div class="span3 left">
									<s:label key="label.report.thirdPartyApplicantName" />		
									<sj:autocompleter id="tripartyApplicantId" onChangeTopics="getReportAutocompleterName"
										list="%{thirdPartyAddressDtl}" cssClass="span3" listKey="name" listValue="name"
										parentTheme="aloc" name="reportsDetails.cycleTimeDetails[0].tpaNameLike"/>
								</div>
						   </div>
					   </div>
				    </div>
				  </div>
	
				<div class="row" style="padding-top: 20px">
					<div class="span5" id="instrAmtBorderId">
						<s:label key="label.report.instrumentAmountGreaterOrLessThan" theme="aloc" tooltip="%{getText('label.report.tooltip.instrumentAmount')}"/>
						<s:textfield cssClass="span2" id="instrumentAmtFrom" name="reportsDetails.cycleTimeDetails[0].outstandingAmtMin" cssStyle="margin-left:0px;align:left;"/> &nbsp;
						<s:text name="label.report.to" />&nbsp; 
						<s:textfield cssClass="span2" id="instrumentAmtTo" name="reportsDetails.cycleTimeDetails[0].outstandingAmtMax"/>
						<div class="form-row hide" id="instrAmtDivId">
							<span class="optOutval-error1 hide" style="color:red"></span>
						</div>
					</div>
					<div class="span6 left" id="currencyBorderId">
						<div class="form-row">
							<s:label key="label.report.instrumentCurrency" theme="aloc"/>
							<sj:autocompleter key="label.report.currencyOfIssuance" list="%{#attr['com.ge.aloc.MasterDataFactory'].currencies}"
								name="reportsDetails.cycleTimeDetails[0].currencyName" cssClass="span3" listKey="currencyCode" listValue="currencyName" 
								theme="aloc" onChangeTopics="getReportAutocompleterName" id="instruCurrencyId"/>
						</div>
						<div class="form-row hide" id="currencyDivId">
							<span class="optOutval-error2 hide" style="color:red"></span>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="span12">
						<div class="form-row">
							<s:label key="label.report.currentContact" theme="aloc"/>
						    <s:textfield name="personName" cssClass="span3 lookup-filterValue" id="businessContactPersonId" theme="aloc"/>
						    <s:url action="BusinessContactPersonLookup" namespace="/int" var="getBusinessContactPersonURL" escapeAmp="false" encode="true">
								<s:hidden name="businessContactName" value="BUC" cssClass="businessContactClass"></s:hidden>
								<s:param name="pageOrigin">Report</s:param>
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
										<p><s:property value="reportsDetails.cycleTimeDetails[0].business"/></p>
										<s:hidden name="reportsDetails.cycleTimeDetails[0].business" id="tpApplicantBCPLName"></s:hidden>
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
										<p><s:property value="reportsDetails.cycleTimeDetails[0].currentContactSSO"/></p>
										<s:hidden name="reportsDetails.cycleTimeDetails[0].currentContactSSO" id="tpApplicantBCPSSO"></s:hidden>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
							
				<div class="row">
					<div class="span5">
						<div class="row" id="Obligee">
							<div class="span6">
								<div class="form-row">
									<s:label key="label.report.beneficiaryOrObligee" theme="aloc"/>	
									<sj:autocompleter id="benficiaryName" list="%{benficiaryAddressDtl}" cssClass="span3" listKey="name" listValue="name"
								     	parentTheme="aloc" name="reportsDetails.cycleTimeDetails[0].beneficiaryName" onChangeTopics="getReportAutocompleterName"/>
								</div>
							</div>
						</div>
					</div>
					<div class="span6">
						<div class="row">
							<div class="span6">
								<div class="form-row">
									<s:label key="label.report.beneficiaryOrObligeeCountry" theme="aloc"/>
									<sj:autocompleter id="benficiaryCountryId" onChangeTopics="getReportAutocompleterName"
										list="%{#attr['com.ge.aloc.MasterDataFactory'].countries}" cssClass="span3" listKey="countryName"
										listValue="countryName" theme="aloc" name="reportsDetails.cycleTimeDetails[0].beneficiaryCountry" />
								</div>
							</div>
						</div>
					</div>
				</div>
	
				<div class="row" id="AppName">
					<div class="span12">
						<div class="form-row">
							<s:label key="label.report.applicantOrPrinicipal" theme="aloc"/>
							<sj:autocompleter id="applicantPrincipal" list="%{applicantAddressDtl}" cssClass="span3" listKey="name" listValue="name"
								 parentTheme="aloc" name="reportsDetails.cycleTimeDetails[0].applicantName" onChangeTopics="getReportAutocompleterName"/>
						</div>
					</div>
				</div>
	
				<div class="row">
					<div class="span4">
						<div class="form-row">
							<s:label key="label.report.issuer" theme="aloc"/>
							<sj:autocompleter id="issuerNameId" list="%{bankDetailsList}" cssClass="span3" onChangeTopics="getReportAutocompleterName"
								    listKey="siteId" listValue="bankCode" parentTheme="aloc" name="reportsDetails.cycleTimeDetails[0].issuer"/>
						</div>
					</div>
					<div class="span4">
						<s:label key="label.report.issuerReferenceNumber" theme="aloc"/>
						<s:textfield id="issuerReferemceNumberId"
							name="reportsDetails.cycleTimeDetails[0].bankRefNum" cssClass="span3" theme="aloc"/>
					</div>
					<div class="span4">
						<div class="form-row">
							<s:label key="label.report.countryOfIssuance" theme="aloc"/>
	                        <sj:autocompleter id="countryofIssuanceId" onChangeTopics="getReportAutocompleterName" cssClass="span3"
								list="%{#attr['com.ge.aloc.MasterDataFactory'].countries}" listKey="countryCode" listValue="countryName"
								theme="aloc" name="reportsDetails.cycleTimeDetails[0].countryOfIssuance"/>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="span12">	
						<div class="form-row">
							<s:label key="label.report.showResultsIn" theme="aloc"/>
						</div>
						<div class="form-row">
	                        <s:radio name="reportsDetails.cycleTimeDetails[0].dayhourFlag" cssClass="radio" id="dayHourSelection" list="#{'Hours':'Hours','Days':'Days'}" theme="aloc" labelposition="right"/>								
						</div>
					</div>
				</div>
	
				<div class="row" id="groupByDivId">
					<div class="span6 hide" id="errorDivId">
						<div class="form-row">
							<span class="optOutval-error hide" style="color:red"></span>
						</div>
				    </div>
					<div class="span12">
						<div class="form-row">
							<table class="table table-striped table-bordered sortable">
								<thead>
									<tr>
									<th colspan="8"><s:label key="label.report.groupResultsBy" theme="aloc" cssStyle="color:white"/></th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td colspan="1" width="60px">
											<s:checkbox name="reportsDetails.cycleTimeDetails[0].GBSiteId" 
												id="siteId" cssClass="groupByFilter"/>
											<span><s:text name="label.report.site"/></span>
										</td>
										<td colspan="1" width="160px">
											<s:checkbox name="reportsDetails.cycleTimeDetails[0].GBAppname"
												id="applicantId" cssClass="groupByFilter"/>
											<span><s:text name="label.report.applicantOrPrinicipal" /></span>
										</td>
										<td colspan="1" width="70px">
											<s:checkbox name="reportsDetails.cycleTimeDetails[0].GBIssuer" 
												id="issuerId" cssClass="groupByFilter"/>
											<span><s:text name="label.report.issuer" /></span>
										</td>
										<td colspan="1" width="145px">
											<s:checkbox name="reportsDetails.cycleTimeDetails[0].GBBenName" 
												id="benficiaryObligeeId" cssClass="groupByFilter"/>
											<span><s:text name="label.report.beneficiaryOrObligee" /></span>
										</td>
										<td colspan="1" width="145px">
											<s:checkbox name="reportsDetails.cycleTimeDetails[0].GBBenCuntry"
												id="gbBenficiaryCountryId" cssClass="groupByFilter"/>
											<span><s:text name="label.report.beneficiaryCountry" /></span>
										</td>
										<td colspan="1"  width="140px">	
											<s:checkbox name="reportsDetails.cycleTimeDetails[0].GBCountryIssue"
												id="countryIssuanceId" cssClass="groupByFilter"/>
											<span><s:text name="label.report.countryOfIssuance" /></span>
										</td>
										<td colspan="1" width="145px">
											<s:checkbox name="reportsDetails.cycleTimeDetails[0].GBInstTypeId"
												id="instrumentTypeId" cssClass="groupByFilter"/>
											<span><s:text name="label.report.instrumentType" /></span>
										</td>
										<td colspan="1" width="165px">
											<s:checkbox name="reportsDetails.cycleTimeDetails[0].GBInstPurposeId"
												id="instrumentPurposeId" cssClass="groupByFilter"/>
											<span><s:text	name="label.report.instrumentPurpose" /></span>
										</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
	               <div class="highlighted">
					<div class="row lastrow"> 
	                    <div class="span12 btn-container">
					        <div class="form-row">
	                           <a href="javascript:;" class="btn btn-success-blue" id="generateReport"><s:label key="label.report.generateReport" id="generateButtonId"/></a>
	                            <a href="javascript:" id="resetClick" class="btn-tertiary cancel"><s:text name="label.report.resetFilters"/></a>   
	                        </div>
	                    </div> 
				    </div>
			    </div>
			  </div>
		    </div>
			<div id="reportGridId">
			   <div class="span12">
			   		<p style="padding:10px;"><s:label key="label.report.genCycleTimeReportDesc" id="reportDescId" style="display:none;"/></p>
			   </div>
			   <div class="span12">
					<div align="center">
						<p style="padding:8px;"><s:label key="label.report.noIssuancesFound" id="blankMessage" style="display: none;" /></p>
					</div>
			   	</div>
		       <label id="headerText" style="display: none;"></label>
				<!-- VIDEO CONTAINER -->
				<div class="clear" style="margin-bottom:20px!important;"></div>
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
		<div id="lookupDiv" style="width: 100%;"></div>
	</div>
	<%@include file="../common/footerSection.jsp"%>
</body>
</html>