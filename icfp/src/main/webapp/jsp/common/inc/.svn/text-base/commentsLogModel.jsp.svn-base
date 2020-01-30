<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en-US"/>
		<div class="form-mod">
			<h2 class="span12 collapsible collapsed">Comments:
				<bean:size id="size" name="fourBlockerForm" property="deal.commentsLogs" />
 				<c:out value="${size}"></c:out>
			</h2>
			<div class="row">
				<div class="span12">
				 <table class="table table-striped table-bordered sortable">
					<thead>
					  <tr>
						<th><bean:message key = "heading.commentsLog.date" /></th>
						<th><bean:message key = "heading.commentsLog.author" /></th>
						<th><bean:message key = "heading.commentsLog.tableComments" /></th>
					  </tr>
					</thead>
					<tbody>
					<logic:notEmpty name="fourBlockerForm" property="deal.commentsLogs" >
					<logic:iterate name="fourBlockerForm" property="deal.commentsLogs" id="commnetLog" indexId="itemNo">
							<tr>
								<td>${commnetLog.actionDt}</td>
								<td>${commnetLog.author}</td>
								<td>${commnetLog.comments}</td>
							</tr>
					</logic:iterate>
					</logic:notEmpty>
					</tbody>
				  </table>
				</div>
			</div> 
			<div class="row comment-container">
				<div class="span5">
					<div class="form-row autosize-container">
						<span class="required">*</span>
						<label>Comments</label>
						<div class="char-count">500</div>
						<html:textarea styleClass="xlarge autosize messageinput" name="fourBlockerForm" styleId="affirmCommentsId" property="lComments" onblur="scriptInjection(this);"></html:textarea>
					</div>
				</div> <!-- end of block -->
			</div>
        </div><!-- end of form form-mod -->
			 