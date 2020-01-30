<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:common/> 
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>
<c:if test="${param.isReadOnly}">
	<c:set var="isReadOnlyParam" value="isReadOnly=true" />
</c:if>

<div class="form-mod">
			<h2 class="span12 collapsible collapsed"><bean:message key = "heading.auditLog" />
			<c:choose>
				<c:when test="${param.pageType eq 'deal'}">
					<c:if test="${not empty param.sourcePage}">
					<a href="${context}/${param.path}.do?command=auditLogFull&DealRequestID=${sessionScope.deal.dealSeqId}&source=${param.path}&method=${param.method}&name=${param.name}&section=${param.section}&sourcePage=${param.sourcePage}" style="margin-right: 10px;">View full audit log</a>
					</c:if>
					<c:if test="${empty param.sourcePage}">
					<a href="${context}/${param.path}.do?command=auditLogFull&DealRequestID=${sessionScope.deal.dealSeqId}&source=${param.path}&method=${param.method}&name=${param.name}&section=${param.section}" style="margin-right: 10px;">View full audit log</a>
					</c:if>
				</c:when>
				<c:otherwise>
					<c:if test="${not empty param.sourcePage}">
					<a href="${context}/${param.path}.do?command=auditLogFull&DealRequestID=${sessionScope.deal.dealSeqId}&source=${param.path}&origin=${param.origin}&method=${param.method}&legNumber=${param.legNumber}&name=${param.name}&sourcePage=${param.sourcePage}&pType=${param.pType}&${isReadOnlyParam}" style="margin-right: 10px;">View full audit log</a>
					</c:if>
					<c:if test="${empty param.sourcePage}">
					<a href="${context}/${param.path}.do?command=auditLogFull&DealRequestID=${sessionScope.deal.dealSeqId}&source=${param.path}&origin=${param.origin}&method=${param.method}&legNumber=${param.legNumber}&name=${param.name}&pType=${param.pType}&${isReadOnlyParam}" style="margin-right: 10px;">View full audit log</a>
					</c:if>
				</c:otherwise>
			</c:choose>
			
			</h2>
			<div class="row">
				<div class="span12">
				 <table class="table table-striped table-bordered sortable">
					<thead>
					<tr>
					    <th><bean:message key = "heading.auditLog.leg" /></th>
						<th><bean:message key = "heading.auditLog.fieldName" /></th>
						<th><bean:message key = "heading.auditLog.oldValue" /></th>
						<th><bean:message key = "heading.auditLog.newValue" /></th>
						<th><bean:message key = "heading.auditLog.author" /></th>
						<th><bean:message key = "heading.auditLog.date" /></th>
					  </tr>
					</thead>
					<tbody>
					<c:forEach var="auditSection" items="${sessionScope.deal.auditLogs}"  begin="0" end="4" step="1">
     				<tr>
     				    <td style="word-wrap:break-word"><div style="width:50px;overflow:auto">
     				    <c:if test="${empty auditSection.legSeqId}">-</c:if>
     				    <c:if test="${not empty auditSection.legSeqId}">${auditSection.legSeqId}</c:if>
     				    </div></td>
     					<td style="word-wrap:break-word"><div style="width:100px;overflow:auto">
     					<c:if test="${empty auditSection.fieldName}">-</c:if>
     				    <c:if test="${not empty auditSection.fieldName}">${auditSection.fieldName}</c:if>
     					</div></td>
     					<td style="word-wrap:break-word"><div style="width:200px;overflow:auto">
     					<c:if test="${empty  auditSection.oldValue}">-</c:if>
     					<c:if test="${not empty auditSection.oldValue}">${auditSection.oldValue}</c:if>
     					</div></td>
     					<td style="word-wrap:break-word"><div style="width:200px;overflow:auto">
     					<c:if test="${empty auditSection.newValue}">-</c:if>
     					<c:if test="${not empty auditSection.newValue}">${auditSection.newValue}</c:if>
     					</div></td>
     					<td style="word-wrap:break-word"><div style="width:140px;overflow:auto">
     					<c:if test="${empty auditSection.author}">-</c:if>
     					<c:if test="${not empty auditSection.author}">${auditSection.author}</c:if>
     					</div></td>
     					<td style="word-wrap:break-word"><div style="width:80px;overflow:auto">
     					<c:if test="${empty auditSection.auditCreatedDt}">-</c:if>
     					<c:if test="${not empty auditSection.auditCreatedDt}">${auditSection.auditCreatedDt}</c:if>
     					</div></td>
					 </tr>
					 </c:forEach>
				</tbody>
			
			</table>
		</div>
	</div> 
</div><!-- end of form form-mod -->