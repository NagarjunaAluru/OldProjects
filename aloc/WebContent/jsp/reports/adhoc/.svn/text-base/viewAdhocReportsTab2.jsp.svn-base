<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="userInfo"  uri="hwf-userInformation" %>
<s:if test="%{adhocReports == null || adhocReports.publishedReports.isEmpty()}">
<div class="row highlighted">
	<div class="span12">
		<p style="padding: 10px;"><s:text name="label.report.noSharedReportFound"/></p>
	</div>
</div>
</s:if>
<s:else>
	<div class="row">
		<c:set var="userId" value="${userInfo:userSSOId('-')}" />
		<div class="span12">
			<div id="searchSort">
				<div class="leftColSort">
					<p id="itemsPerPage">
						<span id="start"></span> - <span id="end"></span> of <span
							id="total"></span> items
					</p>
					<p id="noItemsFound">0 items found</p>
				</div>
				<div class="rightColSort">
					Show&nbsp;&nbsp; <select class="pagination-rows">
						<option>10</option>
						<option>20</option>
						<option>30</option>
						<option>40</option>
						<option>50</option>
					</select>&nbsp;&nbsp;results
				</div>
				<div class="clear"></div>
			</div>
			<table
				class="table table-striped table-bordered sortable attachment paginate">
				<thead>
					<tr class="spantr1">
						<th colspan="1"><s:text name="label.report.publishReport.action"/></th>
						<th colspan="1"><s:text name="label.report.publishReport.reportName"/></th>
						<th colspan="1"><s:text name="label.report.publishReport.description"/></th>
						<th colspan="1"><s:text name="label.report.publishReport.createdBy"/></th>
						<th colspan="1"><s:text name="label.report.publishReport.created"/></th>
						<th colspan="1"><s:text name="label.report.publishReport.lastSavedBy"/></th>
						<th colspan="1"><s:text name="label.report.publishReport.lastSaved"/></th>
						<th colspan="1"><s:text name="label.report.publishReport.lastRun"/></th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="adhocReports.publishedReports" >
						<tr class="shown">
							<td>
								<c:if test="${userId eq createdBy}">
								<s:form action="deleteTemplate.action" namespace="/int/reports" name="deleteTemplateForm" 
									id="deleteTemplateFormId" cssClass="deleteTemplateForm" cssStyle="text-align: center;margin: 0px!important;">
									<s:hidden name="templateId" value="%{reportID}"></s:hidden>
									<s:hidden name="adhocReportTabType" value="MYREPORTS"></s:hidden>
									<s:hidden name="templateName" value="%{reportName}"></s:hidden>
									<a class="delete-tr ttip" title="Delete this exception"
									href="javascript:;" >X</a>
								</s:form>
								</c:if>
								<c:if test="${userId ne createdBy}">
								-
								</c:if>
							</td>
							<td>
								<s:form action="openTemplate.action" namespace="/int/reports" name="publishedReportsOpenTemplate"
								cssClass="openTemplateForm" cssStyle="margin: 0px!important;">
									<s:hidden name="templateId" value="%{reportID}"></s:hidden>
									<c:if test="${userId ne createdBy}">
									<s:hidden name="ownReport" value="No"></s:hidden>
									</c:if>
									<a class="openTemplate" href="javascript:;" >
										<s:property value="reportName"/>
									</a>
								</s:form>
							</td>
							<td><s:property value="description"/></td>
							<td><s:property value="createdBy"/></td>
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

			<div class="row" id="hideLessthan10">
				<!-- pagination pagination-right -->
				<div class="span right">
					<div class="pagenavi left"></div>
					<div class="span3 jump-page">
						Jump to <input type="text" class="span1 manual"> <a
							class="btn btn-success-blue" type="submit">Go</a> <a
							class="btn-goto-FirstPage hide"></a>
					</div>
				</div>
			</div>
			<input type='hidden' id='current_page' />
			<script type="text/javascript"
				src="${pageContext.request.contextPath}/js/common/pagination.js"></script>

		</div>
	</div>
</s:else>
