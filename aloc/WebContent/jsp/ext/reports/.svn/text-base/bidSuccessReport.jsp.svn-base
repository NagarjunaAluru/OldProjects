<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib prefix="hwfs"  uri="/hwf-security-tags" %>

<!DOCTYPE html>

<html>
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	    <title>Bid Success Report</title>
	    <%@include file="/jsp/ext/common/includeCommonScripts.jsp"%>
	    <link href="${pageContext.request.contextPath}/ext/public/css/common/reports.css" rel="stylesheet"/>
	    <script type="text/javascript" src="${pageContext.request.contextPath}/ext/public/js/ext/reports/bidSuccess.js"></script>
	    <script src="${pageContext.request.contextPath}/ext/public/js/admin/util.js"></script>
		<script src="${pageContext.request.contextPath}/ext/public/js/admin/Api.js"></script>
		
		<script type="text/javascript" src="${pageContext.request.contextPath}/ext/public/font/typeface-0.15.js"></script>
	    <script type="text/javascript" src="${pageContext.request.contextPath}/ext/public/font/ge_inspira_regular.typeface.js"></script>
	    <script type="text/javascript" src="${pageContext.request.contextPath}/ext/public/font/helvetica_lt_std_light.typeface.js"></script>
	    
	    <link type="text/css" href="${pageContext.request.contextPath}/ext/public/css/others/jquery-ui-1.7.1.custom.css" rel="stylesheet" />
		<link type="text/css" href="${pageContext.request.contextPath}/ext/public/css/others/ui.multiselect.css" rel="stylesheet" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/ext/public/js/plugins/jquery-ui-1.8.custom.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/ext/public/js/plugins/jquery.localisation-min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/ext/public/js/plugins/jquery.tmpl.1.1.1.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/ext/public/js/plugins/jquery.blockUI.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/ext/public/js/plugins/ui.multiselect.js"></script>
		<script type="text/javascript">
			document.domain="<s:text name='ALOC_Domain_URL.external'/>";
	    </script> 
	</head> 	
	<body>	
		<div class="container main">
		<jsp:include page="/jsp/ext/common/headerSection.jsp">
			<jsp:param name="createReqPopup" value="Yes"></jsp:param>
		</jsp:include>
		<h1 class="page-title span12"><s:text name="label.report.bidSuccessReport"/></h1>
		<p class="span12 left clear dashdesc">
			<hwfs:checkComponentPermission name="BankDashBoardAccess" domainName="BusinessAccess">
				<s:text name="label.report.bankUsersbidSuccessReportDesc"/>
			</hwfs:checkComponentPermission>
			
			<hwfs:checkComponentPermission name="TreasuryDashboardAccess" domainName="BusinessAccess">
				<s:text name="label.report.treasuryUsersbidSuccessReportDesc"/>
			</hwfs:checkComponentPermission>
		  </p>
		  <hr class="page-title-hr"/>
	<form id="bidSuccessForm" method="post">
		<s:hidden id="selectedsites" name="reportsDetails.bidSuccessDetails[0].SITEIDS"></s:hidden>
		<s:hidden id="selectedBanks" name="reportsDetails.bidSuccessDetails[0].BANKNAME"></s:hidden>
		<s:hidden id="loginUser" name="reportsDetails.bidSuccessDetails[0].BIDSUCCESSUSERSSO"></s:hidden>
		<div class="form-mod">
			<h2 class="acc_triggerA zeroborder"><a href="javascript:;"><s:text name="label.report.filterBy"/></a></h2>
			<hr class="h2-hr"/>
			<div class="acc_containerA">
				
				<div class="row" id="validationDivId" style="margin-left: 0px;border-right: 0px;">
					<span class="optOutval-error hide" style="color:red"></span>
					<s:label key="label.report.bankSelection" cssClass="bankLabel"> </s:label>
				</div>
				<div class="row">
					<div class="span2ab">
						<div class="form-row" style="width: 200px !important" id="bankSelection">
							<jsp:include page="/jsp/ext/reports/bankSelectionReports.jsp" />
						</div>
					</div>
				</div>
				
				<s:label key="label.report.siteSelection" cssClass="bankLabel"> </s:label>
				<div class="row">
					<div class="span2ab">
						<div class="form-row" style="width: 200px !important" id="siteSelection">
							<jsp:include page="/jsp/ext/reports/siteSelectionReports.jsp" />
						</div>
					</div>
				</div>
				<div class="row" id="divBorderId" style="margin-left: 0px;line-height:40px; ">
					<div class="span12" style="margin-left: 0px;">
					  	<div class="form-row">
							<s:label key="label.report.analysisDates" theme="aloc" tooltip="%{getText('label.report.tooltip.analysisDates')}"></s:label>
						</div>
					</div>		
					<div class="span12" style="margin-left: 0px;line-height:40px;">
						<div class="form-row">
						  	<table>
							  <tr>
						         <td width=60%>
									<s:textfield cssClass="dateReports span2" id="analysisDatefromId" name="reportsDetails.bidSuccessDetails[0].ANALYSPERIODSTDT"/> 
									<s:text name="label.report.to"/> 
									<s:textfield cssClass="dateReports span2" id="analysisDatetoId" name="reportsDetails.bidSuccessDetails[0].ANALYSPERIODENDDT"/>
									<s:hidden id="bidSuccessGraphPathId" value="%{getText('ALOC_BIDSUCCESS_GRAPH_URL')}"></s:hidden>
									<s:hidden id="spotfireWebplayerURLId" value="%{getText('ALOC_SpotfireURL_SERVER.external')}"></s:hidden>
									<s:hidden id="userSSOId" name="ssoId"> </s:hidden>
							     </td>
							     <td>
							        <div class="hide" id="analysisDateDivId">
									    <span class="optOutval-error1 hide" style="color:red"></span>
								    </div>
							    </td>
							  </tr>
						   </table>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="span4">
						<div class="form-row">
							<s:label key="label.report.countryOfIssuance" theme="aloc"
								tooltip="%{getText('label.report.tooltip.countryOfIssuance')}"></s:label>
							<sj:autocompleter id="issuanceCountry" cssClass="span3" theme="aloc" 
								list="%{#attr['com.ge.aloc.MasterDataFactory'].countries}" listKey="countryCode" listValue="countryName"
								onChangeTopics="getReportAutocompleterName" name="reportsDetails.bidSuccessDetails[0].COUNTRYISSUE"/>
						</div>
					</div>
					<div class="span4">
						<div class="form-row">
							<s:label key="label.report.currencyOfIssuance" theme="aloc"></s:label>
							<sj:autocompleter id="instrCurrencyId"
								list="%{#attr['com.ge.aloc.MasterDataFactory'].currencies}" cssClass="span3"
								name="reportsDetails.bidSuccessDetails[0].CURRENCYISSUE" listKey="currencyCode"
								listValue="currencyName" theme="aloc" onChangeTopics="getReportAutocompleterName"/>
						</div>
					</div>
				</div>
				<div class="row" id="groupByGridId" style="margin-left: 0px; margin-right: 0px;">
					<div class="row span12 hide" id="groupByDivId" style="padding-top:8px">
				      	<span class="optOutval-error2 hide" style="color:red"></span>
				    </div>
					<div class="span12" style="margin-left: 0px;">
						<div class="form-row">
							<table class="table table-striped table-bordered sortable">
								<thead>
									<tr>
									<th colspan="5"><s:text name="label.report.groupResultsBy"/></th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td colspan="1" width="150px"><s:checkbox name="reportsDetails.bidSuccessDetails[0].GBBANK" id="bankId" cssClass="checkbox"/><span><s:text name="label.report.bank"/></span></td>
										<td colspan="1" width="150px"><s:checkbox name="reportsDetails.bidSuccessDetails[0].GBCOUNTRYISSUE" id="countryofIssuance" cssClass="checkbox"/><span><s:text name="label.report.countryOfIssuance"/></span></td>
										<td colspan="1" width="150px"><s:checkbox name="reportsDetails.bidSuccessDetails[0].GBCURRENCYISSUE" id="currencyofIssuance" cssClass="checkbox"/><span><s:text name="label.report.currencyOfIssuance"/></span></td>
										<td colspan="1" width="150px"><s:checkbox name="reportsDetails.bidSuccessDetails[0].GBSITEID" id="siteCheckId" cssClass="checkbox"/><span><s:text name="label.report.siteId"/></span></td>
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
		                            <a href="javascript:;" class="btn-tertiary cancel" id="resetClick"><s:text name="label.report.resetFilters"/></a>   
		                        </div>
		                    </div> 
					 </div>
				</div>
				<a href="javascript:void()" class="exportToExcel"  id="exportResultIcon"><img src="${pageContext.request.contextPath}/img/excel.gif" border="0" class="right" /></a>
			</div>
		</div>	
		<div id="reportGridId">
			<div class="row lastrow">
				<div class="span12">
					<p style="padding:8px;"><s:label key="label.report.reportDesc" id="reportDescId" style="display: none;"/></p>
				</div>
			</div>
			<div class="span12">
				<div align="center">
					<p style="padding:8px;"><s:label key="label.report.noIssuancesFound" id="blankMessage" style="display: none;" /></p>
				</div>
		   	</div>
			<!-- VIDEO CONTAINER -->
			<div class="clear" style="margin-bottom:20px!important;"></div>
			<div id="playerContainer">
				<div id="webPlayer" style="width: 940px!important; height: 600px!important; position:relative!important;"></div>
			</div>
			<div class="highlighted">
			   <div class="row lastrow" id="exportId">
	                   <div class="span12 btn-container">
				       <div class="form-row">
	                          <a href="javascript:void()" class="btn-primary" id="exportResult"><span id="exportLabel"><s:text name="label.report.exportResults"/></span></a>
	                       </div>
	                  </div> 
	            </div>
	           </div>
		 </div>
  	</form>	
</div>
<%@include file="/jsp/ext/common/footerSection.jsp"%>
</body>
</html>