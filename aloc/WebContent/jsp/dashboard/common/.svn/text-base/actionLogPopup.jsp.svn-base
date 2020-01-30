<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table class="table table-striped table-bordered actionLogTable">
	<thead>
	    <tr id="column_head" style="display: table-row;">
	        <th class="bgtr"><s:text name="label.actionLog.tableHeader.1" /></th>
	        <th class="bgtr"><s:text name="label.actionLog.tableHeader.2" /></th>
	        <th class="bgtr"><s:text name="label.actionLog.tableHeader.3" /></th>
	        <th class="bgtr"><s:text name="label.request.reasonForReturn"/></th>
	        <th class="bgtr"><s:text name="label.actionLog.tableHeader.4" /></th>
	    </tr>
	</thead>
	<tbody>
		<s:set name="noOfActionLog" value="actionLogDetails.size"/>
		<s:if test="%{#noOfActionLog == 0}">
		<tr>
	        <td>-</td>
	        <td>-</td>
	        <td>-</td>
	        <td>-</td>
	    </tr>
		</s:if>
		<s:if test="%{#noOfActionLog > 0}">
		<s:iterator value="actionLogDetails">
	    <tr>
	        <td><s:date name="auditCreatedDt" format="MMM dd, yyyy - HH:mm aa zzz"/></td>
	        <td><c:out value="${stageName}"/></td>
	        <td><c:if test="${not empty approverLastName or not empty approverFirstName}">
		        	<c:if test="${not empty approverLastName}"><c:out value="${approverLastName}"/></c:if>
		        	<c:if test="${empty approverLastName}"> - </c:if> ,
		        	<c:if test="${not empty approverFirstName}"><c:out value="${approverFirstName}"/></c:if>
		        	<c:if test="${empty approverFirstName}"> - </c:if>
	        	</c:if>
	        	<c:if test="${empty approverLastName and empty approverFirstName}"> - </c:if>
	        </td>
	        <td style="word-wrap: break-word;"><div style="width: 100px; overflow: auto;">
	            <c:choose>
	            	<c:when test="${not empty reasonForRejection}">
	            		<c:out value="${reasonForRejection}"/>
	            	</c:when>
	            	<c:otherwise> -
	            	</c:otherwise>
	            </c:choose>	        	
	        	</div>
	        </td>
	        <td style="word-wrap: break-word;"><div style="width: 100px; overflow: auto;">
	            <c:choose>
	            	<c:when test="${not empty comments}">
	            		<c:out value="${comments}"/>
	            	</c:when>
	            	<c:otherwise> -
	            	</c:otherwise>  
	            </c:choose>     	
	        	</div>
	        </td>
	    </tr>
	    </s:iterator>
	    </s:if>
	</tbody>
</table>
<script type="text/javascript">
$(document).ready(function(){
	$(".actionLogTable tr:odd").addClass("odd");
	$(".actionLogTable tr:even").addClass("even");
});
</script>