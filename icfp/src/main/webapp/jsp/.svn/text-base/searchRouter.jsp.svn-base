<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en-US"/>
<t:common/>

<c:set var="stageURL">
<t:getActionPath stage="${requestScope.workItem.currentStage}"></t:getActionPath>
</c:set>	
<c:set var="taskAssign">
	<c:choose>
	  <c:when test="${requestScope.taskAssigner}">
		&section=myAssignedTasks
	  </c:when>
	  <c:otherwise>
	  	&section=myTasks
	  </c:otherwise>
	</c:choose>
</c:set>

<c:set var="URL">
<c:choose>
<c:when test="${requestScope.workItem.currentStage eq 'PLERIVEW'}">
${stageURL}.do?command=getPipelineReviewDealDetail&DealRequestID=${requestScope.workItem.dealSeqID}${taskAssign}&source=dashboard
</c:when>
<c:otherwise>
${stageURL}.do?command=load&DealRequestID=${requestScope.workItem.dealSeqID}${taskAssign}
</c:otherwise>
</c:choose>
</c:set>
<c:redirect url="${URL}" />