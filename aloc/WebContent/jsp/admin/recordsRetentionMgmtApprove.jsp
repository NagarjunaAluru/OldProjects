<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
 <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><s:text name="label.recordsretntionmgmt.approve.pageTitle" /></title>
<%@include file="../common/includeCommonScripts.jsp" %> 
<script src="${pageContext.request.contextPath}/js/toggle/toggle.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/admin/treasuryAdminManagement.js" type="text/javascript"></script>
</head>
<s:url action="treasuryAdminPortal.action" namespace="/int/admin" var="cancelBtnlURL"/>
<s:url action="retentionfullAuditLog.action" namespace="/int/admin" var="openfullAuditLogURL" >
  <s:param name="viewLog" value="1"/>
</s:url>
<body>
<div class="container main">
	<jsp:include page="../common/headerSection.jsp">
		<jsp:param name="createReqPopup" value="Yes"></jsp:param>
	</jsp:include>
	<h1 class="page-title span12"><s:text name="label.recordsretntionmgmt.approve.pageTitle" /></h1>
	<p class="span12 left clear dashdesc"><s:text name="label.recordsretntionmgmtApprover.pageSubTitle" /></p>
	<hr class="page-title-hr">
	<div class="clear"></div>
	<span class="required-fields-para2" style="margin-top: -35px!important;"><s:text name="label.standardFormatMgmt.allFieldsRequiredUnlessSpecified" /></span>
	<s:form action="submitRecordRetention" id="formId">
	<s:hidden name="recordRetention.retentionManagementId" id="retentionID"></s:hidden>
	<s:hidden name="recordRetention.yearsAfterExpiry" id="yearsAfterExpiryID"></s:hidden>
	<s:hidden name="recordRetention.scheduleFrequencyFlag" id="scheduleFrequencyFlagID"></s:hidden>
	<s:hidden name="recordRetention.scheduleFrequencyID" id="schFrequencyID"></s:hidden>
	<s:hidden name="recordRetention.oneTimeRunDate" id="oneTimeRunDateID"></s:hidden>
	<s:hidden name="recordRetention.nextRunDate" id="nextRunDateID"></s:hidden>
	<s:hidden name="recordRetention.minExpDt" id="minExpDtID"></s:hidden>
	<s:hidden name="recordRetention.approximateNumberOfRecords" id="appxrecID"></s:hidden>
	<s:hidden name="recordRetention.dateRangeOfRecordsPurged" id="dateRangeOfRecordsPurgedID"></s:hidden>
	<s:if test="hasActionErrors()">
		<div class="row">
				<label style="color: red; width: 100%;"><s:actionerror/></label>
		</div>
	</s:if>
	
	<div class="row">
		<div class="span5">
			<div class="form-row">
				<label><s:text name="label.recordsretntionmgmt.numberOfYearsPurge"/></label>
			</div>
		</div>
		<div class="span5 left">
			<div class="form-row">
				<p><s:property value="recordRetention.yearsAfterExpiry"/></p>
			</div>
		</div>
	</div>
	
	<div class="row">
		<div class="span5">
			<div class="form-row">
				<label><s:text name="label.recordsretntionmgmt.scheduleFrequency"/></label>
			</div>
		</div>
		<div class="span5 left">
			<div class="form-row">
				<p>
					<s:if test="recordRetention.scheduleFrequencyFlag == true"><s:text name="label.recordsretntionmgmtApprover.Yes"/></s:if>
					<s:if test="recordRetention.scheduleFrequencyFlag == false"><s:text name="label.recordsretntionmgmtApprover.No"/></s:if>
				</p>
			</div>
		</div>
	</div>
	
	<s:if test="recordRetention.scheduleFrequencyFlag == true">
		<div class="row">
			<div class="span5">
				<div class="form-row">
					<label><s:text name="label.recordsretntionmgmt.recurringScheduleFrequency"/></label>
				</div>
			</div>
			<div class="span5 left">
				<div class="form-row">
					<p><s:property value="recordRetention.scheduleFrequencyID"/></p>
				</div>
			</div>
		</div>
	</s:if>
	
	<s:if test="recordRetention.scheduleFrequencyFlag == false">
		<div class="row">
			<div class="span5">
				<div class="form-row">
					<label><s:text name="label.recordsretntionmgmt.oneTimeRunDate"/></label>
				</div>
			</div>
			<div class="span5 left">
				<div class="form-row">
					<p><s:property value="recordRetention.oneTimeRunDate"/></p>
				</div>
			</div>
		</div>
	</s:if>
	
	<div class="row">
		<div class="span5">
			<div class="form-row">
				<label><s:text name="label.recordsretntionmgmt.nextRunDate"/></label>
			</div>
		</div>
		<div class="span5 left">
			<div class="form-row">
				<p><s:property value="recordRetention.nextRunDate"/></p>
			</div>
		</div>
	</div>
	
	<div class="row">
		<div class="span5">
			<div class="form-row">
				<label><s:text name="label.recordsretntionmgmt.approximateNumberOfRecordsPurged"/></label>
			</div>
		</div>
		<div class="span5 left">
			<div class="form-row">
				<p><s:property value="recordRetention.approximateNumberOfRecords"/></p>
			</div>
		</div>
	</div>
	
	<div class="row">
		<div class="span5">
			<div class="form-row">
				<label><s:text name="label.recordsretntionmgmt.dateRangeOfRecordsPurged"/></label>
			</div>
		</div>
		<div class="span5 left">
			<div class="form-row">
				<p><s:property value="recordRetention.minExpDt"/>
				<s:if test="%{recordRetention.minExpDt !=null && recordRetention.dateRangeOfRecordsPurged !=null}">
				&nbsp;&nbsp;to&nbsp;&nbsp;</s:if>
				<s:property value="recordRetention.dateRangeOfRecordsPurged"/>
				
				</p>
			</div>
		</div>
	</div>

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
					<span class="right"><a href="<s:property value="#openfullAuditLogURL" />" class="right" style="font-size: 12px;"><s:text name="label.standardFormatMgmt.auditFullLog" /></a></span>
					<table class="table table-striped table-bordered sortable paginate" id="auditLogId">
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
    
    <div class="row">
    	<div class="span5">  
    		<label class="radio">
                <s:radio theme="aloc" name="recordRetention.status" list="#{'Approve':'Approve'}" id="delSave"/>
             </label>
            
            <label class="radio">
                <s:radio theme="aloc" name="recordRetention.status" list="#{'Reject':'Reject'}" id="bdelegate" />
            </label>
        </div>
    </div>
    
         
        <div class="float-container" id="deleg">
	        <div class="span12">      
				<div class="row">
				    <label><s:text name="label.recordsretntionmgmt.approve.rejectionReason"/></label>
				    
				    <s:textarea id="rejectReasonId" cssClass="autosize1 messageinput" theme="aloc" name="recordRetention.rejectReason" col="50" rows="2" onkeypress="return imposeMaxLength(this, 99);"></s:textarea>
						    <div class="clear"></div>
			                        <div class="counter">100</div> <!-- fix positions -->
			                        <div class="counterTxt"><p class="guidance"><s:text name="label.reimbursementAgreementManagement.charleft" /></p></div>
							<div class="clear"></div>
							
				</div>
			</div>
        </div><!-- float-container end shere --->
		<div class="clear"></div>
		 <div class="highlighted">
                <s:submit key="label.request.Submit" cssClass="btn-primary" />
                <a href="#" class="btn-tertiary cancel clearEntries" data-toggle="modal" ><s:text name="label.request.common.cancel"></s:text></a> 
            </div>
		
				
	</s:form>
</div>
<%@include file="../common/footerSection.jsp"%>
<jsp:include page="../admin/treasuryAdminExitPopup.jsp" />
</body>
</html>