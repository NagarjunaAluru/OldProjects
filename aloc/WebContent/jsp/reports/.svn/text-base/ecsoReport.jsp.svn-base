<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="hwfs" uri="/hwf-security-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<title>ECSO Report</title>
		<%@include file="../common/includeCommonScripts.jsp"%>
		<link href="${pageContext.request.contextPath}/css/common/reports.css" rel="stylesheet"/>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/reports/ecsoReport.js"></script>
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
			<div id="mainPage" style="width: 100%;">
			<h1 class="page-title span12"><s:text name="label.report.ecfoReport"/></h1>
			<p class="span12 left clear dashdesc"><s:label key="label.report.ecfoReportDesc" theme="aloc"/></p>
			<div class="clear" style="width: 100%;"></div> 
			<hr class="page-title-hr"/>
		    <form id="escoReportForm" method="post">
				<s:hidden id="selectedSiteIds" name="reportsDetails.eCSODetails[0].INBUSSITEIDS" />
				<s:hidden id="ecsoPathId" value="%{getText('ALOC_ECSO_URL')}"></s:hidden>
			    <s:hidden id="spotfireWebplayerURLId" value="%{getText('ALOC_SpotfireURL_SERVER')}"></s:hidden>
				<div class="form-mod">	
					<h2 class="acc_triggerA zeroborder"><a href="javascript:;"><s:text name="label.report.filterBy"/></a></h2>
					<hr class="h2-hr"/>
					<div class="acc_containerA">
						<a name="first"></a>
						<p class="required-fields"><s:text name="label.report.requiredFields"/></p>
						<h5><s:label key="label.report.siteSelection" cssClass="bankLabel"> </s:label></h5>
						<div class="row">
							<div class="span2ab">
								<div class="form-row" style="width:200px!important" id="siteSelection">
									<jsp:include page="/jsp/reports/siteSelectionReports.jsp" />
								</div>
							</div>							
						</div>
						<div class="row" id="divBorderId" style="margin-left: 0px;">
							<table>
								<tr>
									<td>
										<div class="span3" style="margin-left: 0px;">
											<s:label key="label.report.asOfDate" theme="aloc" tooltip="%{getText('label.report.tooltip.asOfDate')}"></s:label>
											<s:textfield cssClass="dateReports span1" cssStyle="width:80px" id="asofDateId"
												name="reportsDetails.eCSODetails[0].iNEXPIRDATE"/>
											<p>
												<i><s:text name="label.report.dateSelection"/> </i>
											</p>
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
						<div class="row">
							<div class="span12">
						       <div class="form-row">
								<s:hidden id="goldIdCount" name="goldIdCount" value="0"/>
								<s:label key="label.report.goldId" theme="aloc"/>
								<table id="goldIdTable" style="width: 100%;">
									<tr>
										<td height="1" class="noPadding">
					            			<s:textfield cssClass="span3 lookup-filterValue" id="leGoldId" theme="aloc" name="leNameGoldName"/> 
											<s:url action="LegalEntityLookup" namespace="/int" var="getLegalEntityURL" escapeAmp="false" encode="true">
												<s:param name="pageNumber">1</s:param>
												<s:param name="escoListIndex">0</s:param>
											</s:url> 
											<a class="btn-secondary lookup" href="<s:property value="#getLegalEntityURL"/>">
											<s:text name="label.request.common.lookup" /></a> <img alt="Loading..." id="leIndicator" class="indicator"  
											        src="${pageContext.request.contextPath}/img/loading.gif" style="height: 20px; display: none"/>
											<span class="lookup-error hide" style="color: #AE2C2C;"></span>
											<div class="clear"></div>
											<div class="conditional-row" id="goldidShow0" style="display: none;">
											        <div class="span7">
											        <div class="row" style="margin-left: 0px;">
													    <div class="span2 left">
														  <div class="form-row">
															<s:label  key="label.request.common.legalEntityNameC"/>
														  </div>
													    </div>
												 	   <!-- end of block -->
													    <div class="span4 right">
														  <div class="form-row">
															<p><s:property value=""/></p>
															<s:hidden name="leName" id="tpApplicantLEName0" cssClass="LEName"></s:hidden>
														  </div>
													     </div>
													</div>
													<div class="row" style="margin-left: 0px;">
													      <div class="span2 left">
														    <div class="form-row">
															 <s:label  key="label.request.common.legalEntityGOLDIdC"/>
														    </div>
													     </div>
													   <div class="span4 right">
														 <div class="form-row">
															<p><s:property value=""/></p>
															<s:hidden name="reportsDetails.eCSODetails[0].INGOLDIDS" id="tpApplicantLEGoldID0" cssClass="LEGoldID"></s:hidden>
														</div>
													<!-- end of block -->
												 	</div>
												 </div>
											    </div>
									        </div>
									        <s:hidden name="goldHide" id="leGoldTotalId"></s:hidden>
					            		</td>
										
									</tr>
								</table>
								 <a href="javascript:;" class="add-exception" id="goldIdDyId"> 
									  <s:text name="label.report.addAnotherGoldId"/> 
								</a>
								</div>
								</div>
							</div>
							
						
						<div class="row">
								<div class="span12">
								<s:hidden id="csoCountId" name="csoCountName" value="0"/>
						         <div class="form-row">
						                 <table id="csoIdTable" style="width: 100%;">
											<tr>
											   <td height="1" class="noPadding">
													<s:label key="label.report.cso" theme="aloc"/>
													 <div class="clear"></div>
													<s:textfield cssClass="span3 csoIdClass" id="csoId0" name="reportsDetails.eCSODetails[0].INCSOS" />
													<s:hidden name="reportsDetails.eCSODetails[0].sITEID" id="cso"></s:hidden>
													 <div class="clear"></div>
													 
											  </td>
											</tr>
										</table>
										<a href="javascript:;" class="add-exception" id="addCSOId"> 
											<s:text name="label.report.addAnotherCSO"/> 
										</a>
								</div>
							</div>
							<s:hidden name="csoHide" id="csoTotalId"></s:hidden>
						</div>
						
						<div class="row highlighted lastrow"> 
		                    <div class="span12 btn-container" style="margin-left: 0px;">
						        <div class="form-row">
		                           <a href="javascript:;" class="btn btn-success-blue" id="generateReport"><s:label key="label.report.generateReport" id="generateId"/></a>
		                            <a href="javascript:;" class="btn-tertiary cancel" id="resetClick"><s:text name="label.report.resetFilters"/></a>   
		                        </div>
		                    </div> 
					    </div>
					</div>
				</div>	
				<div id="reportGridId">
						<div class="row lastrow">
							<div class="span12">
								<p style="padding:8px;"><s:label key="label.report.ecsoReportGen" id="reportDescId" style="display: block;"/></p>
							</div>
						</div>
						<div class="span12">
							<div align="center">
								<p style="padding:8px;"><s:label key="label.report.noIssuancesFound" id="blankMessage" style="display: none;" /></p>
							</div>
					   	</div>
						<h3 class="zeroborder"><span class="dashdesc span12"><s:label id="headerText" key="label.report.ecfoReport" cssStyle="display: none;"/></span></h3>
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
			</form>
			</div>
		<div id="lookupDiv" style="width: 100%;"></div>
		</div>
		<%@include file="../common/footerSection.jsp"%>
	</body>
</html>