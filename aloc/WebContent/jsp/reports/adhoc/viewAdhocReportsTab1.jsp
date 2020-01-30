<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<s:url action="customReport.action"
namespace="/int/reports" var="createTemplateURL"/>
<p class="newReport">
	<s:a href="%{createTemplateURL}" cssClass="btn-secondary right"><s:text name="label.report.createNewReport"/></s:a>
</p>
<div class="clear"></div>
<s:if test="%{adhocReports == null || adhocReports.myReports.isEmpty()}">
	<div class="row highlighted">
		<div class="span12">
			<p style="padding: 10px;"><s:text name="label.report.noReportFound"/></p>
		</div>
	</div>
</s:if>
<s:else>
	<div class="row">
		<div class="span12">
			<table class="table table-striped table-bordered sortable attachment">
				<thead>
					<tr class="spantr1">
						<th colspan="1"><s:text name="label.report.userReport.action"/></th>
						<th colspan="1"><s:text name="label.report.userReport.reportName"/></th>
						<th colspan="1"><s:text name="label.report.userReport.description"/></th>
						<th colspan="1"><s:text name="label.report.userReport.created"/></th>
						<th colspan="1"><s:text name="label.report.userReport.lastSavedBy"/></th>
						<th colspan="1"><s:text name="label.report.userReport.lastSaved"/></th>
						<th colspan="1"><s:text name="label.report.userReport.lastRun"/></th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="adhocReports.myReports" >
						<tr>
							<td>
								<s:form action="deleteTemplate.action" namespace="/int/reports" name="deleteTemplateForm" 
									id="deleteTemplateFormId" cssClass="deleteTemplateForm" cssStyle="margin: 0px!important;">
									<s:hidden name="templateId" value="%{reportID}"></s:hidden>
									<s:hidden name="adhocReportTabType" value="MYREPORTS"></s:hidden>
									<s:hidden name="templateName" value="%{reportName}"></s:hidden>
									<a class="delete-tr ttip" title="Delete this exception"
									href="javascript:;" >X</a>
								</s:form>
							</td>
							<td>
								<s:form action="openTemplate.action" namespace="/int/reports" name="myReportsOpenTemplate"
								cssClass="openTemplateForm" cssStyle="margin: 0px!important;">
									<s:hidden name="templateId" value="%{reportID}"></s:hidden>
									<a class="openTemplate" href="javascript:;" >
										<s:property value="reportName"/>
									</a>
								</s:form>
							</td>
							<td><s:property value="description"/></td>
							<td><s:property value="created"/></td>
							<td><s:property value="lastSavedBy"/></td>
							<td><s:property value="lastSaved"/></td>
							<td>
								<c:if test="${empty lastRun }">-</c:if>
								<c:if test="${not empty lastRun }"><s:property value="lastRun"/></c:if>
							</td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
		</div>
	</div>
</s:else>