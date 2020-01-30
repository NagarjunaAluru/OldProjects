<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en-US"/>
<div class="form-mod">
			<h2 class="span12 collapsible"><bean:message key = "heading.auditLog" /> 
				<a href="#">View full audit log</a>
			</h2>
			<div class="row">
				<div class="span12">
				 <table class="table table-striped table-bordered sortable">
					<thead>
					  <tr>
						<th><bean:message key = "heading.auditLog.action" /></th>
						<th><bean:message key = "heading.auditLog.author" /></th>
						<th><bean:message key = "heading.auditLog.date" /></th>
						<th><bean:message key = "heading.auditLog.tableComments" /></th>
					  </tr>
					</thead>
					<tbody>
						<logic:notEmpty name="fourBlockerForm" property="deal.auditLogs" >
						<logic:iterate name="fourBlockerForm" property="deal.auditLogs" id="auditSection" indexId="itemNo">
								<tr>
									<td>${auditSection.comments}</td>
									<td>${auditSection.completedByName}</td>
									<td>${auditSection.date}</td>
									<td>${auditSection.comments}</td>
								</tr>
						</logic:iterate>
						</logic:notEmpty>
					</tbody>
			</table>
		</div>
	</div> 
</div><!-- end of form form-mod -->

