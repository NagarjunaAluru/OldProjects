<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>
<div class="form-mod">
			<h2 class="span12 collapsible"><bean:message key = "heading.actionLog" /></h2>
			<div class="row">
				<div class="span12">
				 <table class="table table-striped table-bordered sortable">
					<thead>
					  <tr>
					    <th><bean:message key = "heading.actionLog.date" /></th>
					    <th><bean:message key = "heading.actionLog.name" /></th>
						<th><bean:message key = "heading.actionLog.group" /></th>
						<th><bean:message key = "heading.actionLog.action" /></th>
						<th><bean:message key = "heading.actionLog.tableComments" /></th>
					  </tr>
					</thead>
					<tbody>
					<c:forEach var="actionSection" items="${sessionScope.deal.actionLogs}">
     				<tr>
     					<td style="word-wrap:break-word"><div style="width:80px;overflow:auto">${actionSection.actionDt}</div></td>
     					<td style="word-wrap:break-word"><div style="width:140px;overflow:auto">${actionSection.SSOID}</div></td>
     					<td style="word-wrap:break-word"><div style="width:75px;overflow:auto">${actionSection.groupName}</div></td>
     					<td style="word-wrap:break-word"><div style="width:75px;overflow:auto">${actionSection.decision}</div></td>
     					<td style="word-wrap:break-word"><div style="width:450px;overflow:auto">
     					${actionSection.comments}
     					</div></td>
					 </tr>
					 </c:forEach>
					</tbody>
				  </table>
				</div>
			</div> 
        </div><!-- end of form form-mod -->