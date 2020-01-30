<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<!DOCTYPE html>
<html>
<head>
 <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><s:text name="label.recordsPurgeReport.pageTitle" /></title>
<%@include file="../common/includeCommonScripts.jsp" %> 
<link href="${pageContext.request.contextPath}/css/common/pagenavi.css" type="text/css" rel="stylesheet" />
<script src="${pageContext.request.contextPath}/js/requestor/requestor.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/admin/treasuryAdminManagement.js" type="text/javascript"></script> 
</head>
<s:url action="treasuryAdminPortal.action" namespace="/int/admin" var="cancelBtnlURL"/>
<s:url action="retentionfullAuditLog" namespace="/int/admin" var="openfullAuditLogURL" >
  <s:param name="viewLog" value="2"/>
</s:url>
<body>
<div class="container main">
	<jsp:include page="../common/headerSection.jsp">
		<jsp:param name="createReqPopup" value="Yes"></jsp:param>
	</jsp:include>
	<div id="mainPage" style=" width: 100%;">
	<h1 class="page-title span12"><s:text name="label.recordsPurgeReport.pageTitle"/></h1>
	<p class="span12 left clear dashdesc"><s:text name="label.recordsPurgeReport.pageSubTitle"/></p>
	<hr class="page-title-hr">
	<div class="clear"></div>

	<s:form action="sendRectention" id="formId" cssStyle=" width: 100%;">
	
	<!-- REQUEST SUMMARY -->
	<div id="requestSummary">
    	<div class="leftColRS">
        	<p><strong><s:text name="label.recordsPurgeReport.purgeSummary"/></strong></p>
        </div>
		<div class="clear"></div>
        
        <div class="leftBoxRS">
            <div class="row smallrow">
                <div class="span5">
                    <label><s:text name="label.recordsPurgeReport.dateAndTimePurge"/></label>
                    <s:property value="recordRetention.dateRangeOfRecordsPurged"/> <br>
                </div>          
            </div>
		</div><!-- leftBox ends here -->
        
        
        <div class="midBoxRS">
            <div class="row smallrow">
                <div class="span5">
                    <label><s:text name="label.recordsPurgeReport.numberOfYearsInPurge"/></label>
                                <s:property value="recordRetention.yearsAfterExpiry"/>
                </div>          
            </div>
        </div><!-- midBox ends here -->
                
        <div class="rightBoxRS">
            <div class="row smallrow">
                <div class="span5">
                    <label><s:text name="label.recordsPurgeReport.numberOfRecordsPurged"/></label>
                                <s:property value="recordRetention.approximateNumberOfRecords"/>
                </div>        
            </div>
        </div><!-- rightBox ends here -->

        <div class="clear"></div>
    </div><!-- requestSummary ends here -->
            
	<div class="form-mod">
			<h2 class="acc_triggerExtra"><s:text name="label.recordsPurgeReport.sendRecordRetentionManagement"/></h2><hr class="h2-hr">
			<div class="acc_containerExtra">

			<c:if test="${empty recordRetention.retentionRecipient.recipientSsoId}">
				<c:set var="RecipientShowClass" value="display: none;"/>
				<c:set var="RecipientClearStyle" value="display: none;"/>
			</c:if>
			<c:if test="${not empty recordRetention.retentionRecipient.recipientSsoId}">
				<c:set var="RecipientShowClass" value="display: block;"/>
				<s:set var="recipientidSelected" value="%{'Selected'}"></s:set>
				<c:set var="RecipientShowClearStyle" value="display: inline;"/>
			</c:if>
			<div class="row">
				<div class="form-row">
					<div class="span3">
						<s:textfield name="geRecipient" 
						id="recipient" 
						key="label.request.geRecipient" 
						theme="aloc"
						cssClass="span3 lookup-filterValue"
						/>
						<s:hidden name="businessContactName" value="BUC" cssClass="businessContactClass"></s:hidden>
						<span class="lookup-error hide" style="color: #AE2C2C;"></span>
					</div>
					<div class="span1">	
						<label>&nbsp;</label>
						<s:url action="GEReferenceLookup" namespace="/int" var="getRecipientURL" escapeAmp="false">
						</s:url>
						<a class="btn-secondary lookup" href="<s:property value="#getRecipientURL"/>" ><s:text name="label.request.common.lookup"/></a>
					</div>
					<div class="span5">	
						<label>&nbsp;</label>
						<img alt="Loading..." id="recipientIndicator" class="indicator" src="${pageContext.request.contextPath}/img/loading.gif" style="height: 20px; display:none">
					</div>
				</div>
			</div>
			
			
			<div class="conditional-row" id="recipientShow" style="${RecipientShowClass}">
				<s:hidden name="recipientSelection" id="recipientSelectionId" value="%{#recipientidSelected}"></s:hidden>
                    <div class="row">
                         <div class="span2">
                            <div class="form-row">
                                <label><s:text  name="label.request.recipient" /></label>
                            </div> 
                        </div>
                        <div class="span10 right">	
                            <div class="form-row">
                                <p><s:property value="recordRetention.retentionRecipient.recipientLastName"/>, <s:property value="recordRetention.retentionRecipient.recipientFirstName"/> - <s:property value="recordRetention.retentionRecipient.recipientSsoId"/></p>
                                <s:hidden name="recordRetention.retentionRecipient.recipientLastName" id="recipientLastName"></s:hidden>
                                <s:hidden name="recordRetention.retentionRecipient.recipientFirstName" id="recipientFirstName"></s:hidden>
                                <s:hidden name="recordRetention.retentionRecipient.recipientSsoId" id="recipientSsoId"></s:hidden>
                            </div>
                        </div><!-- end of block -->
                    </div>
                    <div class="row">
                        <div class="span2">
                            <div class="form-row">
                                <label><s:text  name="label.request.geRecipientEmail"/></label>
                            </div>
                        </div><!-- end of block -->
                        <div class="span10 right">
                            <div class="form-row">
                                <p><s:property value="recordRetention.retentionRecipient.recipientEmail"/></p>
                                
                                <s:hidden name="recordRetention.retentionRecipient.recipientEmail" id="recipientEmail"></s:hidden>
                            </div>
                        </div>
                    </div>
            	</div>
			<div class="clear">&nbsp;</div>
			<div class="row">
				<div class="span12">
					<div class="form-row highlighted">
						<s:submit key="label.recordsPurgeReport.sendFile" cssClass="btn-primary" />
					</div>
				</div>
			</div>	

			</div>
		</div>
			
			
			<table class="table table-striped table-bordered sortable no-bottom paginate" id="retentionAuditLogTable">
                <colgroup width="90px"></colgroup>
                <colgroup width="100px"></colgroup>
                <colgroup width="120px"></colgroup>
                <colgroup width="120px"></colgroup>
                <colgroup width="120px"></colgroup>
                <colgroup width="150px"></colgroup>
                <colgroup width="90px"></colgroup>
	                <thead>
	                    <tr>
		                    <th colspan="1" class="headerSortUp"><s:text name="label.recordsPurgeReport.alocRecordNo"/></th>
		                    <th><s:text name="label.request.requestor"/></th>
		                    <th><s:text name="label.request.expirationDate"/></th>
							<th><s:text name="label.recordsPurgeReport.totalNumberOfPayments"/></th>
		                    <th><s:text name="label.recordsPurgeReport.totalNumberOfAmendments"/></th>
		                    <th><s:text name="label.recordsPurgeReport.dateAndTimeStamp"/></th>
							<th><s:text name="label.recordsPurgeReport.siteName"/></th>
		                    <th><s:text name="label.amendment.trAnalyst.applicantName"/></th>
		                    <th><s:text name="label.recordsPurgeReport.beneficiaryName"/></th>
		                </tr>
	                </thead>
	                <tbody>
	                	<s:if test="%{recordRetention == null || recordRetention.recordRetentionLists.isEmpty()}">
			        		<tr class="shown noRecord">
			       	 			<td colspan="9" style="text-align:center;color:blue; size:40px;"><s:text name="label.dashboard.bundle.display"/></td>
			    			</tr>
			        	</s:if>	
			        	<s:else>
		                	<s:iterator value="recordRetention.recordRetentionLists" status="status">
				                <tr class="shown">
					                <td><s:property value="ALOCRecordNo"/><s:property value="sitePrefix"/></td>
									<td><s:property value="requestor"/></td>
									<td><s:property value="expirationDate"/></td>
									<td><s:property value="totalNumberOfPayments"/></td>
									<td><s:property value="totalNumberOfAmmendments"/></td>
									<td><s:date name="dateTimeStamp"  format="MMM dd, yyyy HH:mm aa zzz"/></td>
									<td><s:property value="siteName"/></td>
									<td><s:property value="applicantName"/></td>
									<td><s:property value="beneficiaryName"/></td>
								</tr> 
							</s:iterator>
						</s:else>
					</tbody>
				</table>
				<p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p>
        
		<!-- PAGE NAVIGATION STARTS HERE -->
        <div class="row">
            <div class="span right">
            	<div class="pagenavi left">
            	
                </div>
                <div class="span3 jump-page">
                 Jump to
					<input type="text" class="span1 manual">
					<a class="btn btn-success-blue" type="submit">Go</a>
                </div>
            </div>
        </div>
        <input type='hidden' id='current_page' />
        	<script src="${pageContext.request.contextPath}/js/common/pagination.js"></script>
		<!-- PAGE NAVIGATION ENDS HERE -->
	
	<!-- Audit Log -->
	<div class="form-mod">
		<h2 id="auditLog" class=" acc_trigger1 acc_blue section_flip">
			<a href="javascript:;"><s:text name="label.standardFormatMgmt.auditLog" /> - 
				<s:if test="%{recordRetention.RecordRetentionAuditLogs.size > 0}">
				  <s:property value="recordRetention.RecordRetentionAuditLogs.size"/>
				</s:if>
			    <s:else>
			    <s:property value="0"/>
			    </s:else>
			</a>
		</h2><hr class="h2-hr">
		<div class="acc_container1" id="auditLogPanel">
			<div class="row">
				<div class="span12">
					<span class="right"><a href="<s:property value="#openfullAuditLogURL" />" onclick="setHrefval(2)" class="right" style="font-size: 12px;"><s:text name="label.standardFormatMgmt.auditFullLog" /></a></span>
					<table class="table table-striped table-bordered sortable" id="auditLogId">
					<thead>
					    <tr class="spantr1">
					        <th colspan="1" class="headerSortUp"><s:text name="label.recordsretntionmgmt.updatedDate"/></th>
							<th colspan="1"><s:text name="label.recordsretntionmgmt.numberOfYears"/></th>
						    <th colspan="1"><s:text name="label.recordsretntionmgmt.scheduleFreq"/></th>
						    <th colspan="1"><s:text name="label.recordsretntionmgmt.frequencyInMonths"/></th>
						    <th colspan="1"><s:text name="label.recordsretntionmgmt.oneTimeDate"/></th>
						    <th colspan="1"><s:text name="label.recordsretntionmgmt.approverAction"/></th>
						    <th colspan="1"><s:text name="label.recordsretntionmgmt.reasonForReturn"/></th>
						    <th colspan="1"><s:text name="label.recordsretntionmgmt.submittedBy"/></th>
						    <th colspan="1"><s:text name="label.recordsretntionmgmt.approverName"/></th>
					    </tr>
					</thead>
					<tbody>
						<s:if test="%{recordRetention.RecordRetentionAuditLogs.size < 5}">
						    <s:set var="auditloglist" value="(recordRetention.RecordRetentionAuditLogs.size)-1"/>
						</s:if>		
					    <s:else>
					     <s:set var="auditloglist" value="4"/>
					    </s:else>
						<s:if test="%{recordRetention.RecordRetentionAuditLogs.size>0}">
						  <s:iterator value="recordRetention.RecordRetentionAuditLogs"  begin="0" end="%{auditloglist}">
						    <tr class="shown">
							    <td><s:date name="updatedDt" format="MMM dd, yyyy  HH:mm aa zzz"/></td>
							    <td><s:property value="numberofYears"/></td>
							    <td><s:property value="scheduleFrequency"/></td>
								<td><s:property value="frequencyMonths"/></td>
								<td><s:property value="onetimeRundate"/></td>
								<td><s:property value="approverAction"/></td>
								<td style="word-wrap: break-word;"><div style="width: 155px; overflow: auto;"><s:property value="reasonReturn"/></div></td>
								<td>
									<s:property value="auditModifierLastname"/>,&nbsp;&nbsp;
									<s:property value="auditModifierFirstname"/>
								</td>
								<td>
									<s:property value="approverLastname"/>,&nbsp;&nbsp;
									<s:property value="approverFirstname"/>
								</td>
						    </tr> 
						  </s:iterator>
						</s:if>
						<s:else>
						<tr class="spantr2">
						<td colspan="9" style="text-align: center;"><s:text name="label.recordsretntionmgmt.AuditLog"/></td>
						</tr>
						</s:else>
					</tbody>
				</table>
			</div>
		</div>
		</div>
	</div>
 	<div class="clear"></div> 

	
	<div class="clear"></div> 
            <div class="highlighted">
               <a href="#" class="btn-tertiary cancel clearEntries" data-toggle="modal" ><s:text name="label.request.common.cancel"></s:text></a> 
            </div>
	</s:form>
	</div>
	<div id="lookupDiv" style="width: 100%;"></div>
</div>
<%@include file="../common/footerSection.jsp"%>
<jsp:include page="../admin/treasuryAdminExitPopup.jsp" />
</body>
</html>