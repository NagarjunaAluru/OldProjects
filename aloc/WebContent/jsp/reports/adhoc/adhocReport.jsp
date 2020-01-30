<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="hwfs"  uri="/hwf-security-tags" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="userInfo"  uri="hwf-userInformation" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Custom Report</title>
    
    <%@include file="/jsp/common/includeCommonScripts.jsp"%>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/jquery-ui-1.9.2.custom.js"></script>
    
    
    <!-- JTree Component CSS and JS -->
    <script src="${pageContext.request.contextPath}/js/admin/util.js"></script>
	<script src="${pageContext.request.contextPath}/js/admin/Api.js"></script>
	<script src="${pageContext.request.contextPath}/js/reports/adhocReports.js"></script>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/font/typeface-0.15.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/font/ge_inspira_regular.typeface.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/font/helvetica_lt_std_light.typeface.js"></script>
    
    <!-- Tree Structure -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/others/jquery.treeview.css" />
	<script src="${pageContext.request.contextPath}/js/others/jquery.cookie.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/others/jquery.treeview.js" type="text/javascript"></script>
	<link href="${pageContext.request.contextPath}/css/common/reports.css" rel="stylesheet"/>
	
	<script type="text/javascript">
	  document.domain="<s:text name='ALOC_Domain_URL'/>";
	</script>
</head>  
<body>
	<div class="container main">
		<jsp:include page="/jsp/common/headerSection.jsp">
			<jsp:param name="createReqPopup" value="Yes"></jsp:param>
		</jsp:include>
	<div id="siteMsg" class="hide">
       	<div class="sucessMsg" style="width: 904px;">
           	<a href="#" class="right successclose" style="font-size: 20px; margin-right:-470px;">X</a>
           	<s:text name="label.treasuryAdminPortal.success" />
        </div>
        <div class="sucessContent" style="width: 923px;"><s:text name="label.report.templateSaveSuccess"/></div>
    </div>
    <div class="row curDelErrorDiv hide">
				<div class="span12">
					<div class="errorbox">
						<div class="errorHead">
							<p class="erroricon">
								<s:text name="label.eas.common.error" />
							</p>
						</div>
						<div class="errorContent">
							<p>
								<span class="curDelError"></span>
							</p>
						</div>
					</div>
				</div>
	</div>
		
	<div id="mainPage" style="width: 100%;">
		<div class="form-mod">
			<h1 class="page-title span12"><s:text name="label.report.createCustomReport"></s:text></h1>
			<hr class="page-title-hr">
		</div>
	<s:form id="adhocReportForm">
	<s:hidden id="adhocPathId" value="%{getText('ALOC_ADHOC_URL')}"></s:hidden>
	<s:hidden id="spotfireWebplayerURLId" value="%{getText('ALOC_SpotfireURL_SERVER')}"></s:hidden>
	<s:hidden id="domainNameURLId" value="%{getText('ALOC_Domain_URL')}"></s:hidden>
	<s:hidden name="template.templateId" id="templateId"></s:hidden>
	<s:hidden name="reportId" id="reportId"></s:hidden>
	<div class="form-mod">
		<div class="highlighted">
			<div class="row lastrow">
			<div class="span12">
				<div class="row lastrow">
					<div class="span6a">
						<p style="line-height:50px;"><span class="circle2">1</span><s:text name="label.report.instruct1"/></p>
						<p style="line-height:50px;"><span class="circle2"><b class="txtBids">2</b></span><s:text name="label.report.instruct2"/></p>
					</div>
					<div class="span6b left">
						<p style="line-height:50px;"><span class="circle2">3</span><s:text name="label.report.instruct3"/></p>
						<p style="line-height:50px;"><span class="circle2">4</span><s:text name="label.report.instruct4"/></p>
					</div>
				</div>
			</div>
		</div>
		</div>
	</div>
	<div class="form-mod">
		<h2 class="acc_triggerA acc_active"><a href="javascript:;"><s:text name="label.report.customFilter"/></a></h2>
		<hr class="h2-hr">
		<div class="acc_containerA">
			<h3 id="reportName">
				<s:if test="%{template.templateName != null}">
					<s:property value="template.templateName"/> 
				</s:if>
			</h3>
				<div class="row graybg lastrow">
					<div class="row lastrow">
						<div class="span12">
							<div class="span3" style="border:Solid 1px #bbb; padding:0 10px;">
								<p style="line-height:50px;"><span class="circle1">1</span><b><s:text name="label.report.instruments"/></b></p>
								<div class="row review lastrow">
									<div class="form-mod">
										<h3><s:text name="label.report.fieldsDesc"/></h3>
										<div class="acc_container">
											<div class="row lastrow">
												<div class="span3">
													<label class="checkbox">
														<input type="checkbox" name="checkbox"  id="selectall"/><span><s:text name="label.report.all"/></span>
													</label>
													<s:iterator value="%{#attr['com.ge.aloc.StaticDataFactory'].instrumentType}" status="stat">
														<label class="checkbox">
															<s:checkbox name="template.instrumentTypes" value="%{template.isInstrumentSelected(ID)}" fieldValue="%{ID}" cssClass="instrumentTypes case"/><s:property value="name"/>
														</label>
													</s:iterator>
													<img alt="Loading..." class="indicator" id="instrIndicator"
													src="${pageContext.request.contextPath}/img/loading.gif" 
													style="height: 20px; display:none"/>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="row review lastrow">
									<div class="form-mod">
										<div class="row">
											<div class="span3">
											<p style="line-height:50px;"><span class="circle1">2</span><b><s:text name="label.report.fields"/></b></p>
											<label><s:text name="label.report.fieldName"/>
											<span class="ttip info" data-original-title="This is an tooltip with more information"></span>
											</label>
											<s:textfield id="search-term" name="fieldName"style="width:120px;"></s:textfield>
											<a class="btn-secondary" id="fieldSearch" style="margin-left: 10px !important;"><s:text name="label.report.search"/></a>
											<img alt="Loading..." class="indicator" 
											src="${pageContext.request.contextPath}/img/loading.gif" style="height: 20px; display:none; margin-left: -5px;"/>
											<p class="guidance"><s:text name="label.report.fieldNameDesc"/></p>
											<span class="optOutval-error1 hide" style="color:red"></span>
											</div>
										</div>
										<div class="row">
											<div class="span3">
											<ul id="browser" style="height: 300px;overflow: scroll;" class="filetree">
											</ul>
								       		</div>
						       			 </div>
										
									</div>
								</div>
								
							</div>
							
							<div class="span6c">
								<p style="line-height:50px;"><span class="circle1">3</span><s:text name="label.report.filters"/></p>
								<input type="hidden" id="availableSortPriority">
								<div class="row">
									<div class="span1ab">
										<select style="width:100px!important;" name="template.dateFilter">
											<option value="createdDate"><s:text name="label.report.createdDate"/></option>
										</select>
									</div>
									<div class="span2 left"><s:text name="label.report.range"/>
										<select style="width:100px!important; margin-left: 5px!important;">
											<option><s:text name="label.report.custom"/></option>
										</select>
									</div>
									<div class="span4" id="dateDescId">
										<s:textfield cssClass="dateReports span1" cssStyle="width:80px" id="fromDate" name="template.fromDate"/>
										<s:text name="label.report.to"/>
										<s:textfield cssClass="dateReports span1" cssStyle="width:80px; margin-left: 10px!important;" id="toDate" name="template.toDate"/>
										<span class="optOutval-error hide span3"><s:text name="label.report.dateFilterMandatory"/></span>
									</div>
								</div>
								<div class="row" style="background-color:#fff!important;">
									<div class="span6c">
										<div class="row">
											<div class="span6c">
												<c:if test="${fn:length(template.filters) > 0 }">
													<div id="filterDropbox" class="verticalscroll">
														<s:iterator value="template.filters" status="filter">
															<div class="droppable home divcd" id="<s:property value="key"/>">
															<s:include value="/jsp/reports/adhoc/filtersController.jsp">
																<s:param name="fieldId" ><s:property value="key"/></s:param>
															</s:include>
															</div>
														</s:iterator>
													</div>
												</c:if>
												<c:if test="${fn:length(template.filters) eq 0 }">
													<div id="filterDropbox" class="verticalscroll">
													</div>
												</c:if>
											</div>
										</div>
										<div class="row">
										<div class="span6c">
											<p style="line-height:50px;"><span class="circle1">4</span><b><s:text name="label.report.columnOrder"/></b></p>
											<p class="left clear dashdesc"><s:text name="label.report.columnOrderDesc"/></p>
											<div class="clear">&nbsp;</div>
											<div style="overflow: auto;" id="orderPriorityDropBox">
												<table class="table table-striped table-bordered sortable auto" id="orderNPriority">
													<thead>
														<tr>
															<th style="width: 80px;">
																<div style="height: 75px;">
																	<s:text name="lable.report.alocRecordNo"/>
																	<input type="hidden" name="template.columnIds" value="alocRecordNo">
																	<s:hidden cssClass="columnFieldId" 
																		name="template.columns[\'alocRecordNo\'].fieldId" 
																		value="alocRecordNo"></s:hidden>
																</div>
																<div style="width: 80px;">
																	<a class="settings up right" id="alocRecordNo">
																	<img alt="setting" src="${pageContext.request.contextPath}/img/setting-ico.png" style="margin-left: 0px;">
																	</a>
																</div>
																<div class="hide columnOrderPriority">
																	<a href="javascript:;" class="right orderPriorityClose">X</a>
																	<div class="left">
																		<s:select key="label.report.sortOrder" 
																		name="template.columns[\'alocRecordNo\'].sortOrder"
																	 	list="#{'asc':'Ascending' , 'desc':'Descending'}" 
																	 	theme="aloc" cssClass="sortOrder"></s:select>
																	</div>
																	<div class="left" style="padding-left: 10px;">
																		<s:select key="label.report.sortPriority" 
																		list="#{}" 
																		theme="aloc" headerKey="0" headerValue="Select..."
																		cssClass="sortPriority"></s:select>
																		<s:hidden name="template.columns[\'alocRecordNo\'].sortPriority"
																		cssClass="sortPriorityValue"></s:hidden>
																	</div>
																</div>
															</th>
															<c:if test="${fn:length(template.columns) > 0 }">
																<s:iterator value="template.columns" status="column">
																	<s:if test="%{key != 'alocRecordNo'}">
																	<s:include value="/jsp/reports/adhoc/columnsController.jsp">
																		<s:param name="fieldId" ><s:property value="key"/></s:param>
																	</s:include>
																	</s:if>
																</s:iterator>
															</c:if>
														</tr>
													</thead>
												</table>
												<br /><br />
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<br/>
			<div class="row highlighted lastrow"> 
                    <div class="span12 btn-container" style="margin-left: 0px;">
				        <div class="form-row">
                           <a href="javascript:;" class="btn-primary" id="generateReport">
                           <s:text name="label.report.runReport" /></a>
                           <img alt="Loading..." class="indicator" 
							src="${pageContext.request.contextPath}/img/loading.gif" style="height: 20px; display:none"/>
                        </div>
                    </div> 
			</div>
		</div>
</div>
<div id="reportGridId">
		<div class="row lastrow">
			<div class="span12 hide">
				<p style="padding:8px;"><s:label key="label.report.customReportGen" id="reportDescId" style="display: block;"/></p>
			</div>
		</div>
		<h3 class="zeroborder"><span class="dashdesc span12"><s:text name="label.report.customReport"/></span></h3>
		<!-- VIDEO CONTAINER -->
		<div class="clear" style="margin-bottom:20px!important;"></div>
		<div id="playerContainer">
			<div id="webPlayer" style="width: 940px!important; height: 600px!important; position:relative!important;"></div>
		</div>
</div>
		<div>
			<jsp:include page="/jsp/reports/adhoc/downLoadAndSaveTemplate.jsp"/>
		</div>
	</s:form>	
</div>
	
</div>
	<%@include file="/jsp/common/footerSection.jsp"%>
</body>
</html>