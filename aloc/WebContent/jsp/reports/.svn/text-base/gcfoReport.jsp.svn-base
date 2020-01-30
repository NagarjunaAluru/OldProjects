<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	    <title>Global Credit Facility Online (GCFO) Report</title>
	    <%@include file="../common/includeCommonScripts.jsp"%>
	    <script type="text/javascript" src="${pageContext.request.contextPath}/js/reports/gcfoReport.js"></script>
	    <script src="${pageContext.request.contextPath}/js/admin/util.js"></script>
		<script src="${pageContext.request.contextPath}/js/admin/Api.js"></script>
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
			<h1 class="page-title span12"><s:text name="label.report.gcfoReport"></s:text></h1>
			<p class="span12 left clear dashdesc"><s:text name="label.report.gcfoReportDesc"></s:text></p>
			<hr class="page-title-hr"/>
			<form id="gcfoForm" method="post">
				<s:hidden id="GCFOPathId" value="%{getText('ALOC_GCFO_URL')}"></s:hidden>
				<s:hidden id="spotfireWebplayerURLId" value="%{getText('ALOC_SpotfireURL_SERVER')}"></s:hidden>
		  		<div class="form-mod">
					<h2 class="acc_triggerA zeroborder"><a href="javascript:;"><s:text name="label.report.filterBy"/></a></h2>
					<hr class="h2-hr"/>
					<div class="acc_containerA">
			            <a name="first"></a>
						<p class="required-fields"><s:text name="label.report.requiredFields"/></p>
						<div class="row" id="divBorderId" style="margin-left: 0px;">
							<table>
								<tr>
									<td>
										<div class="span3" style="margin-left: 0px;">
											<s:label key="label.report.asOfDate" theme="aloc" tooltip="%{getText('label.report.tooltip.asOfDate')}"></s:label>
											<s:textfield cssClass="dateReports span1" cssStyle="width:80px" id="asOfDate"/>
											<p><i><s:text name="label.report.creditFacilityDate"/></i></p>
											<s:hidden name="reportsDetails.GCFODetails[0].INASOFDATE" id="asOfDateID"></s:hidden>
										</div>
									</td>
									<td>
										<div class="hide span12" id="asOfDateDivID">
											<span class="optOutval-error hide" style="color:red"></span>
										</div>
									</td>
								</tr>
							</table>
						</div>
						<div class="row highlighted lastrow"> 
		                    <div class="span12 btn-container" style="margin-left: 0px;">
						        <div class="form-row">
		                           <a href="javascript:;" class="btn btn-success-blue" id="generateReport">
		                           <s:label key="label.report.generateReport" id="generateButtonId"/></a>
		                           <a href="javascript:;" class="btn-tertiary cancel" id="resetClick"><s:text name="label.report.resetFilters"/></a>   
		                        </div>
		                    </div> 
					    </div>
					</div>
			</div>
			<div id="reportGridId">
				<div class="row lastrow">
					<div class="span12">
						<p style="padding:8px;"><s:label key="label.report.gcfoReportGen" id="reportDescId" style="display: block;"/></p>
					</div>
				</div>
				<div class="span12">
					<div align="center">
						<p style="padding:8px;"><s:label key="label.report.noIssuancesFound" id="blankMessage" style="display: none;" /></p>
					</div>
			   	</div>
				<h3 class="zeroborder"><span class="dashdesc span12"><s:label id="headerText" cssStyle="display: none;"/></span></h3>
				<!-- VIDEO CONTAINER -->
				<div class="clear" style="margin-bottom:20px!important;"></div>
				<div id="playerContainer">
					<div id="webPlayer" style="width: 940px!important; height: 600px!important; position:relative!important;"></div>
				</div>
				<div class="row highlighted lastrow" id="exportId">
		              <div class="span12 btn-container" style="margin-left: 0px;">
						    <div class="form-row">
		                         <a href="javascript:void()" class="btn-primary" id="exportResult">
		                         <s:text name="label.report.exportResults"/></a>
		                    </div>
		              </div> 
			    </div>
			</div>
			</form>
			</div>
		<%@include file="../common/footerSection.jsp"%>
	</body>
</html>