<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sjr" uri="/struts-jquery-richtext-tags"%>
<!DOCTYPE html>
<html>
<head>
 <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><s:text name="label.recordsretntionmgmt.pageTitle" /></title>
<%@include file="../common/includeCommonScripts.jsp" %>
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
	<h1 class="page-title span12"><s:text name="label.recordsretntionmgmt.pageTitle" /></h1>
	<p class="span12 left clear dashdesc"><s:text name="label.recordsretntionmgmt.pageSubTitle" /></p>
	 <hr class="page-title-hr">
	<div class="clear"></div>
	<span class="required-fields-para2"><s:text name="label.standardFormatMgmt.allFieldsRequiredUnlessSpecified" /></span>
	<s:form action="saveRecordRetention" id="formId">
	<s:hidden name="recordRetention.retentionManagementId" id="retentionId"/>
	<s:hidden name="recordRetention.status" id="status" value="Pending"/>
	<s:hidden name="viewRetention" id="viewRetentionID"></s:hidden>
	<s:hidden name="recordRetention.nextRunDate" id="nextRunDateID"></s:hidden>
	<s:hidden name="recordRetention.minExpDt" id="minExpDtID"></s:hidden>
	<s:hidden name="recordRetention.approximateNumberOfRecords" id="appxrecID"></s:hidden>
	<s:hidden name="recordRetention.dateRangeOfRecordsPurged" id="dateRangeOfRecordsPurgedID"></s:hidden>
	<div class="row">
		<div class="span12">
			<div class="form-row">				 	
				<label><s:text name="label.recordsretntionmgmt.numberOfYearsPurge"/>
				<span class="ttip info" data-original-title="<s:text name="label.recordsretntionmgmt.tooltip.expirationDatePurge"/>"></span>
				</label>
				<s:textfield name="recordRetention.yearsAfterExpiry" cssClass="span1" id="expiryDateId" maxlength="3" theme="aloc"/>
			</div>
		</div>
	</div>
	
	<div class="row">
    	<div class="span12">
			<div class="form-row">
				<label><s:text name="label.recordsretntionmgmt.scheduleFrequency"/></label>
					<div class="radio-container intrest-type-condition1">
						<label class="radio">
							<s:radio theme="aloc" cssClass="fixed-condition"
							id="scheduleFrequencyFlagId" onclick="setValueFlag()"
							name="recordRetention.scheduleFrequencyFlag"
							list="#{'true':'Schedule frequency'}"
							value="%{recordRetention.scheduleFrequencyFlag}" />
						</label>
                        <div class="fixed-container" id="scheduleSelectionId" style="margin-left: 22px;">
                            <div class="row">
                                <div class="span12">
                                <div class="form-row">
                                    <label><s:text name="label.recordsretntionmgmt.recurringScheduleFrequency"/></label>
					 				<s:select headerKey=""  list="#{'1':'1','2':'2','3':'3','4':'4','5':'5','6':'6','7':'7','8':'8','9':'9','10':'10','11':'11','12':'12'}" headerValue="Select..."
										id="scheduleFrequencyID" name="recordRetention.scheduleFrequencyID" theme="aloc" >
					 				</s:select> 
                                </div>
                                </div>
                            </div>
						</div>
                                 
						<label class="radio">
							<s:radio theme="aloc" cssClass="float-condition"
							id="scheduleFrequencyFlagId" onclick="setValueFlag()"
							name="recordRetention.scheduleFrequencyFlag"
							list="#{'false':'One time run'}"
							value="%{recordRetention.scheduleFrequencyFlag}" />
						</label>

                        <div class="float-container" id="oneTimeID" style="margin-left: 22px;">
                            <div class="row">
                                <div class="span12">
                                <div class="form-row">
                                    <label><s:text name="label.recordsretntionmgmt.oneTimeRunDate"/></label>
                                    <s:textfield name="recordRetention.oneTimeRunDate" cssClass="date" id="runDateId" theme="aloc"/>
                                </div>
                                </div>
                            </div>
						</div>
                                                                                         
					</div>
			</div>
		</div>
	</div>
	
	<div class="row">
       <div class="span5">
			<div class="form-row">
				<s:submit key="label.recordsretntionmgmt.viewRetentionSchedule" cssClass="btn-secondary" onclick="setViewRetention('yes')" />
			</div>
       </div>
	</div>
	<div class="clear"></div>
	
   <div id="viewRentensionDet">	
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
					 <s:property value="recordRetention.dateRangeOfRecordsPurged"/></p>
				</div>
	        </div>
		</div>
    </div>
    
	<!-- Audit Log -->
	<div class="form-mod">
		<h2 id="auditLog" class="section_flip">
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
					<span class="right"><a href="<s:property value="#openfullAuditLogURL" />" onclick="setHrefval(1)" class="right" style="font-size: 12px;"><s:text name="label.standardFormatMgmt.auditFullLog" /></a></span>
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
            <div class="highlighted">
                <div id="submitDiv" style="padding-bottom:10px;">
                	<s:submit key="label.recordsretntionmgmt.submitForApproval" cssClass="btn-secondary left" onclick="setViewRetention('')"/>
                </div>
                <a href="#" class="btn-tertiary cancel clearEntries" data-toggle="modal" ><s:text name="label.request.common.cancel"></s:text></a> 
            </div>
	</s:form>
</div>
<%@include file="../common/footerSection.jsp"%>
<jsp:include page="../admin/treasuryAdminExitPopup.jsp" />
</body>
</html>