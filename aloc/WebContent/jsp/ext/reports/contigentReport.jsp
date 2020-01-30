<%@page import="com.ge.aloc.constants.ALOCConstants"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="hwfs"  uri="/hwf-security-tags" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%-- <%@ taglib prefix="hwfRole"  uri="/hwf-securitytag.tld" %> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	    <title>ContingentLiability Report</title>
	    <%@include file="/jsp/ext/common/includeCommonScripts.jsp"%>
	    <link href="${pageContext.request.contextPath}/ext/public/css/common/reports.css" rel="stylesheet"/>
	    <script type="text/javascript" src="${pageContext.request.contextPath}/ext/public/js/ext/reports/contingent.js"></script>
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
			<h1 class="page-title span12"><s:text name="label.report.contigentLiabilityReport"/></h1>
			<p class="span12 left clear dashdesc"><s:text name="label.report.contigentLiabilityReportDesc"/></p>  
			<div class="clear" style="width: 100%;"></div> 
			<hr class="page-title-hr"/>
	    	<form id="contingentForm"  method="post">
	    		<s:hidden id="selectedSiteIds" name="reportsDetails.contingentliabilityDetails[0].siteIDs"></s:hidden>
 	    		<s:hidden id="morBloomberg" name="reportsDetails.contingentliabilityDetails[0].MORBloombergRate"></s:hidden>
 	    		<s:hidden id="userSSO" name="reportsDetails.contingentliabilityDetails[0].contingentUserSSO"></s:hidden>
 	    		<s:hidden id="spotfireWebplayerURLId" value="%{getText('ALOC_SpotfireURL_SERVER.external')}"></s:hidden>
 	    		<s:hidden id="availableBankId" name="reportsDetails.contingentliabilityDetails[0].issuer"></s:hidden>
 	    		<s:hidden id="bloombergId" value="%{#attr['com.ge.aloc.MasterDataFactory'].bloombergRates}"></s:hidden>
				<s:hidden id="contigentBUCId" value="%{getText('ALOC_Contigent_BUC_URL')}" ></s:hidden>
				<s:hidden id="userSSOId" name="ssoId"> </s:hidden>
				<s:hidden id="morBloombergRateFlag" name="reportsDetails.contingentliabilityDetails[0].INMORBLOOMBERGFLAG"></s:hidden>
				<div class="form-mod">
					<h2 class="acc_triggerA zeroborder"><a href="javascript:;"><s:text name="label.report.filterBy"/></a></h2>
					<hr class="h2-hr"/>
	     			<div class="acc_containerA">
           				<div class="row" id="divBorderId" style="margin-left: 1px; margin-bottom:1px;">
							<div class="span4" style="margin-left: 1px; margin-bottom:1px;">
								<div class="form-row">
									<s:label key="label.report.asOfDate" theme="aloc" tooltip="%{getText('label.report.tooltip.asOfDate')}"></s:label>
									<s:textfield cssClass="dateReports span1" id="asOfDate" name="reportsDetails.contingentliabilityDetails[0].USExpDate" cssStyle="width:80px;"/>
									<p><s:label key="label.report.dateFormat"/></p>
								</div>
							</div>
							<div class="row span3 hide" id="asOfDateDivId" style="padding-top:10px">
								<span class="optOutval-error hide" style="color:red"></span>
							</div>
						</div>
						<hwfs:checkComponentPermission name="IssuanceGEUserAccess" domainName="BusinessAccess">
							<div class="row">
								<div class="span12">
									<div class="form-row">
										<table class="table table-striped table-bordered sortable">
											<thead>
												<tr>
													<th colspan="2"><s:text name="label.report.siteType"></s:text></th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td colspan="1" width="200px">
												   		<s:checkbox name="reportsDetails.contingentliabilityDetails[0].siteTypes" id="financialCheck" cssClass="checkbox" theme="aloc-TransactionParties"/>
												   		<span><s:text name="label.report.financial"></s:text></span>
													</td>
													<td>
												   		<s:checkbox name="reportsDetails.contingentliabilityDetails[0].siteTypes" id="industrialCheck" cssClass="checkbox" theme="aloc-TransactionParties"/>
												   		<span><s:text name="label.report.industrial"></s:text></span>
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
								<div class="form-row" style="width:200px!important" id="siteSelection">
									<jsp:include page="/jsp/ext/reports/siteSelectionReports.jsp" />
								</div>
							</div>							
						</div>
						<s:label key="label.report.bankSelection" cssClass="bankLabel"> </s:label>
						<div class="row">
							<div class="span2ab">
								<div class="form-row" style="width: 200px !important" id="bankSelection">
									<jsp:include page="/jsp/ext/reports/bankSelectionReports.jsp" />
								</div>
							</div>
						</div>
						<hwfs:checkComponentPermission name="IssuanceGEUserAccess" domainName="BusinessAccess">
							<div class="row">
								<div class="span2ab">
									 <div class="form-row">
									    <table>
									      <tr>
									       <td style="width:20px">
										      <s:checkbox id="exportByBank" name="exportByBank"/>
										   </td>
									       <td style="width:1000px" colspan=4> 
									          <s:label key="label.report.exportResultsByBank" tooltip="%{getText('label.report.tooltip.exportResultsByBank')}" theme="aloc" cssStyle="width:700px;margin-top:20px"></s:label>
									        </td>
									      </tr>
									    </table>
									 </div>
								</div>
							</div>
						</hwfs:checkComponentPermission>
						
					   <div class="highlighted">
						   <div class="row lastrow">
								<div class="span12 btn-container">
									 <div class="form-row">
										  <a href="javascript:;" class="btn btn-success-blue" id="generateReport"><s:label key="label.report.generateReport" id="generateButtonId" /></a>
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
							<p style="padding:10px;">
								<s:label key="label.report.contingentReportDesc" id="reportDescId" cssClass="hide"></s:label>
							</p>
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
					<div>
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
		<%@include file="/jsp/ext/common/footerSection.jsp"%>
	</body>
</html>