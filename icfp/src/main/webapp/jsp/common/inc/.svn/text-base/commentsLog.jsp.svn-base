<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:common/> 
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>
<h2 class="span12 collapsible collapsed"><bean:message key = "heading.commentsLog" />

<c:if test="${param.isReadOnly}">
	<c:set var="isReadOnlyParam" value="isReadOnly=true"/>
</c:if>
<c:choose>
	<c:when test="${param.pageType eq 'deal'}">
		<c:if test="${not empty param.sourcePage}">
		<a href="${context}/${param.path}.do?command=commentsLogFull&DealRequestID=${sessionScope.deal.dealSeqId}&source=${param.path}&method=${param.method}&name=${param.name}&section=${param.section}&sourcePage=${param.sourcePage}&pType=${param.pType}" style="margin-right: 10px;">Show all comments</a>
		</c:if>
		<c:if test="${empty param.sourcePage}">
		<a href="${context}/${param.path}.do?command=commentsLogFull&DealRequestID=${sessionScope.deal.dealSeqId}&source=${param.path}&method=${param.method}&name=${param.name}&section=${param.section}&pType=${param.pType}" style="margin-right: 10px;">Show all comments</a>
		</c:if>
	</c:when>
	<c:otherwise>
		<c:if test="${not empty param.sourcePage}">
		
		<a href="${context}/${param.path}.do?command=commentsLogFull&DealRequestID=${sessionScope.deal.dealSeqId}&source=${param.path}&origin=${param.origin}&method=${param.method}&legNumber=${param.legNumber}&id=${param.legNumber}&name=${param.name}&sourcePage=${param.sourcePage}&pType=${param.pType}&${isReadOnlyParam}" style="margin-right: 10px;">Show all comments</a>
		</c:if>
		<c:if test="${empty param.sourcePage}">
		
		<a href="${context}/${param.path}.do?command=commentsLogFull&DealRequestID=${sessionScope.deal.dealSeqId}&source=${param.path}&origin=${param.origin}&method=${param.method}&legNumber=${param.legNumber}&id=${param.legNumber}&name=${param.name}&pType=${param.pType}&${isReadOnlyParam}" style="margin-right: 10px;">Show all comments</a>
		</c:if>
	</c:otherwise>
</c:choose>


<bean:size id="size" name="deal" scope="session" property="commentsLogs" />
${size}
</h2>
<div class="clear"></div>
<div class="row">
	<div class="span12">
		<table class="table table-striped table-bordered sortable"
			id="CommentTable">
			<thead>
				<tr>
					<th><bean:message key="heading.commentsLog.date" /></th>
					<th><bean:message key="heading.commentsLog.actionType" /></th>
					<th><bean:message key="heading.commentsLog.group"/></th>
					<th><bean:message key="heading.commentsLog.author" /></th>
					<th><bean:message key="heading.commentsLog.tableComments" /></th>
				</tr>
			</thead>
				<tbody>
				<c:forEach var="commentsSection" items="${sessionScope.deal.commentsLogs}" begin="0" end="4" step="1">
     				<tr>
     					<td style="word-wrap:break-word"><div style="width:80px;overflow:auto">${commentsSection.actionDt}</div></td>
     					<td style="word-wrap:break-word"><div style="width:50px;overflow:auto">${commentsSection.commentType}</div></td>
     					<c:choose>
     					<c:when test="${!empty commentsSection.wfStage}">
     					<td style="word-wrap:break-word"><div style="width:100px;overflow:auto">${commentsSection.wfStage}</div></td>
     					</c:when>
     					<c:otherwise>
     					<td style="word-wrap:break-word"><div style="width:100px;overflow:auto">-</div></td>
     					</c:otherwise>
     					</c:choose>
     					<td style="word-wrap:break-word"><div style="width:140px;overflow:auto">${commentsSection.author}</div></td>
     					<td style="word-wrap:break-word">
     					<div style="width:450px;overflow:auto">
     					<c:choose>
     					<c:when test="${!empty commentsSection.comments}">
     					${commentsSection.comments}
     					</c:when>
     					<c:otherwise>
     					-
     					</c:otherwise>
     					</c:choose>
     					</div>
     					</td>
					 </tr>
				</c:forEach>
				</tbody>
			
		</table>
	</div>
</div>
