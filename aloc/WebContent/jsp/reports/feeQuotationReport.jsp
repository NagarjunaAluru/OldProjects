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
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
   "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	    <title><s:text name="label.report.feeQuotationReport" /></title>
	    <%@include file="../common/includeCommonScripts.jsp"%>
	    <script type="text/javascript" src="${pageContext.request.contextPath}/js/reports/feeQuotation.js"></script>
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
		<div id="mainPage">
		<h1 class="page-title span12"><s:text name="label.report.feeQuotationReport"/></h1>
		<p class="span12 left clear dashdesc"><s:text name="label.report.feeQuotationReportDesc"/></p>
	    <hr class="page-title-hr"/>
     	<form id="feeQuotationForm" method="post">
    		<s:hidden id="bankSelectionId" name="reportsDetails.feeQuotationDetails[0].inIssuers"/>
        	<s:hidden id="feeQuotationPathId" value="%{getText('ALOC_FEEQUOTE_URL')}"></s:hidden>
			<s:hidden id="spotfireWebplayerURLId" value="%{getText('ALOC_SpotfireURL_SERVER')}"></s:hidden>
			<div class="form-mod">
				<h2 class="acc_triggerA zeroborder"><a href="javascript:;"><s:text name="label.report.filterBy"/></a></h2>
				<hr class="h2-hr"/>
				<div class="acc_containerA">
		            <a name="first"></a>
					<p class="required-fields"><s:text name="label.report.requiredFields"/></p>
					<h5><s:label key="label.report.bankSelection" cssClass="bankLabel"> </s:label></h5>
					<div class="row">
						<div class="span2ab">
							<div class="form-row" style="width: 200px !important" id="bankSelection">
								<jsp:include page="/jsp/reports/bankSelectionReports.jsp" />
							</div>
						</div>
					</div>
					<%-- <span class="optOutval-error1 hide" style="color:red"></span> --%>
					<div class="row">
						<div class="span5" id="divBorderId">
						  <div class="form-row">
									<s:label key="label.report.quotationDateRange" theme="aloc" tooltip="%{getText('label.report.tooltip.analysisDates')}"></s:label>
							<table>
							  <tr>
						         <td width=40%>
						         	<label><s:text name="lable.report.start"/></label>
									<s:textfield cssClass="dateReports span1" cssStyle="width:80px" id="quotationDatefromId" name="reportsDetails.feeQuotationDetails[0].inFeeMinDt"/>
									<s:text name="label.report.to"/>
								 </td>
								 <td width=50%>
									 <label><s:text name="label.report.end"/></label>
									<s:textfield cssClass="dateReports span1" cssStyle="width:80px" id="quotationDatetoId" name="reportsDetails.feeQuotationDetails[0].inFeeMaxDt"/>
							      </td>
							     </tr>
							     <tr>
							      <td colspan="2">
							        <div class="hide" id="quotationDateDivId">
									    <span class="optOutval-error hide" style="color:red"></span>
								    </div>
							      </td>
							  </tr>
						  </table>
						  </div>
						</div>
					
						<div class="span5" id="divBorderId1">
						  <div class="form-row">
									<s:label key="label.report.feeForecastDate" theme="aloc" tooltip="%{getText('label.report.tooltip.analysisDates')}"></s:label>
							<table>
							  <tr>
						         <td width=40%>
						         	<label><s:text name="lable.report.start"/></label>
									<s:textfield cssClass="dateReports span1" cssStyle="width:80px" id="feeForecastDatefromId" name="reportsDetails.feeQuotationDetails[0].inFeeForecastMinDt"/>
									<s:text name="label.report.to"/>
								</td>
								<td width=50%>
									 <label><s:text name="label.report.end"/></label>
									<s:textfield cssClass="dateReports span1"  cssStyle="width:80px" id="feeForecastDatetoId" name="reportsDetails.feeQuotationDetails[0].inFeeForecastMaxDt"/>
							      </td>
							   </tr>
							   <tr>
							      <td colspan="2">
							        <div class="hide" id="feeForecastDateDivId">
									    <span class="optOutval-error1 hide" style="color:red"></span>
								    </div>
							      </td>
							  </tr>
						  </table>
						  </div>
						</div>
					</div>
					<div class="row">
						<div class="span5">
									<div class="form-row">
										<s:label key="label.report.countryOfIssuance"
											tooltip="%{getText('label.report.tooltip.countryOfIssuance')}"
											theme="aloc"></s:label>
										<sj:autocompleter id="issuanceCountry"
											list="%{#attr['com.ge.aloc.MasterDataFactory'].countries}"
											cssClass="span3" listKey="countryCode" listValue="countryName"
											theme="aloc" onChangeTopics="getReportAutocompleterName" name="reportsDetails.feeQuotationDetails[0].inCountryIssuance"/>
									</div>
						</div>
						<div class="span5">
							<div class="form-row">
								<s:label key="label.report.siteId" theme="aloc"/>
								<sj:autocompleter id="siteId" list="%{availableSitesList}" cssClass="span3" parentTheme="aloc"
									    listKey="siteId" listValue="siteName" name="reportsDetails.feeQuotationDetails[0].inSiteId"/>
							</div>
					   </div>
					</div>
					<div class="row">
						<div class="clear" style="width: 100%;margin-bottom:10px;"></div>
					</div>
					
					<div class="row highlighted lastrow"> 
	                    <div class="span12 btn-container" style="margin-left: 0px;">
					        <div class="form-row">
	                           <a href="javascript:;" class="btn btn-success-blue" id="generateReport"><s:label key="label.report.generateReport" id="generateButtonId"/></a>
	                            <a href="javascript:ResetClick();" class="btn-tertiary cancel" id="resetClick"><s:text name="label.report.resetFilters"/></a>   
	                        </div>
	                    </div> 
				    </div>
				</div>
			</div>
			<div id="reportGridId">
				<div class="row lastrow">
					<div class="span12">
						<p style="padding:8px;"><s:label key="label.report.feeQuoteReportGen" id="reportDescId" style="display: none;"/></p>
					</div>
				</div>
				<div class="span12">
					<div align="center">
						<p style="padding:8px;"><s:label key="label.report.noIssuancesFound" id="blankMessage" style="display: none;" /></p>
					</div>
			   	</div>
				<h3 class="span12" style="border-bottom: #00437e 1px solid;margin-left: 0px;"><s:label id="headerText" cssStyle="display: none;"></s:label>
				<p><s:label id="headerText1" key="label.report.reportDesc1" cssStyle="display: none;"/></p><br/>
				<p><s:label id="headerText2" key="label.report.reportDesc2" cssStyle="display: none;"/></p>
	    		</h3>
				<!-- VIDEO CONTAINER -->
				<div class="clear" style="margin-bottom:20px!important;"></div>
				<div id="playerContainer">
					<div id="webPlayer" style="width: 940px!important; height: 600px!important; position:relative!important;"></div>
				</div>
			   <div class="row highlighted lastrow" id="exportId">
                    <div class="span12 btn-container">
				       <div class="form-row">
                           <a href="javascript:void()" class="btn-primary" id="exportResult"><s:text name="label.report.exportResults"/></a>
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