<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>

<fmt:setLocale value="en-US"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common/progressBar.js"> 
</script> 

<c:set var="stageName" value="${deal:getCurrentWorkflowStage(pageContext.request)}"/>
<c:if test="${empty stageName}">
	<c:set var="stageName" value="${sessionScope.deal.WFStage}"/>
</c:if>
<c:set var="requestDt" value="${deal:formatXMLGregorianCalendar(sessionScope.deal.chevrons[0].reqDts[0], 'MMM dd, yyyy')}"/>

<c:choose>
	<c:when test="${stageName eq 'REREQUST' or empty stageName}">
		<c:set var="requestClass" value="active"/>
		<c:set var="pipelineClass" value="disbaled"/>
		<c:set var="soClass" value="disabled"/>
		<c:set var="riskClass" value="disabled"/>
		<c:set var="idagClass" value="disabled"/>
		<c:set var="tcClass" value="disabled"/>
	</c:when>
	<c:when test="${stageName eq 'PLERIVEW'}">
		<c:set var="pipelineClass" value="active"/>
		<c:set var="soClass" value="disabled"/>
		<c:set var="riskClass" value="disabled"/>
		<c:set var="idagClass" value="disabled"/>
		<c:set var="tcClass" value="disabled"/>
		<c:set var="pipeLinetDt" value="id='todayDate'"/>
	</c:when>
	<c:when test="${f:startsWith(stageName, 'SO') or stageName eq 'FOOFFICE'}">
		<c:set var="soClass" value="active"/>
		<c:set var="riskClass" value="disabled"/>
		<c:set var="idagClass" value="disabled"/>
		<c:set var="tcClass" value="disabled"/>		
		<c:set var="pipeLineDt" 
		value="${deal:formatXMLGregorianCalendar(sessionScope.deal.chevrons[0].pipelineDts[0], 'MMM dd, yyyy')}"/>
		<c:set var="sotDt" value="id='todayDate'"/>
	</c:when>
	<c:when test="${stageName eq 'RISKREVW'}">
		<c:set var="riskClass" value="active"/>
		<c:set var="idagClass" value="disabled"/>
		<c:set var="tcClass" value="disabled"/>
		<c:set var="pipeLineDt" 
		value="${deal:formatXMLGregorianCalendar(sessionScope.deal.chevrons[0].pipelineDts[0], 'MMM dd, yyyy')}"/>
		<c:set var="soDt" 
		value="${deal:formatXMLGregorianCalendar(sessionScope.deal.chevrons[0].sandODts[0], 'MMM dd, yyyy')}"/>
		<c:set var="risktDt" value="id='todayDate'"/>
	</c:when>
	<c:when test="${f:startsWith(stageName, 'BU') or f:startsWith(stageName, 'BA')}">
		<c:set var="pipeLineDt" 
		value="${deal:formatXMLGregorianCalendar(sessionScope.deal.chevrons[0].pipelineDts[0], 'MMM dd, yyyy')}"/>
		<c:set var="soDt" 
		value="${deal:formatXMLGregorianCalendar(sessionScope.deal.chevrons[0].sandODts[0], 'MMM dd, yyyy')}"/>
		<c:set var="riskDt" 
		value="${deal:formatXMLGregorianCalendar(sessionScope.deal.chevrons[0].riskDts[0], 'MMM dd, yyyy')}"/>		
	</c:when>
	<c:when test="${f:startsWith(stageName, 'IDAG') or stageName eq 'TESGREVW'}">
		<c:set var="idagClass" value="active"/>
		<c:set var="tcClass" value="disabled"/>
		<c:set var="pipeLineDt" 
		value="${deal:formatXMLGregorianCalendar(sessionScope.deal.chevrons[0].pipelineDts[0], 'MMM dd, yyyy')}"/>
		<c:set var="soDt" 
		value="${deal:formatXMLGregorianCalendar(sessionScope.deal.chevrons[0].sandODts[0], 'MMM dd, yyyy')}"/>
		<c:set var="riskDt" 
		value="${deal:formatXMLGregorianCalendar(sessionScope.deal.chevrons[0].riskDts[0], 'MMM dd, yyyy')}"/>	
		<c:set var="idagtDt" value="id='todayDate'"/>
	</c:when>
	<c:when test="${f:startsWith(stageName, 'CERTFY') or f:startsWith(stageName, 'APPOVE') or stageName eq 'ADDAPPRV' or stageName eq 'CLOSEREQ'}">
		<c:set var="tcClass" value="active"/>
		<c:set var="pipeLineDt" 
		value="${deal:formatXMLGregorianCalendar(sessionScope.deal.chevrons[0].pipelineDts[0], 'MMM dd, yyyy')}"/>
		<c:set var="soDt" 
		value="${deal:formatXMLGregorianCalendar(sessionScope.deal.chevrons[0].sandODts[0], 'MMM dd, yyyy')}"/>
		<c:set var="riskDt" 
		value="${deal:formatXMLGregorianCalendar(sessionScope.deal.chevrons[0].riskDts[0], 'MMM dd, yyyy')}"/>
		<c:set var="idagDt" 
		value="${deal:formatXMLGregorianCalendar(sessionScope.deal.chevrons[0].idagTesgDts[0], 'MMM dd, yyyy')}"/>	
		<c:set var="tctDt" value="id='todayDate'"/>
		<c:if test="${sessionScope.deal.dealStatus eq '3'}">
			<c:set var="tctDt" value="${deal:formatXMLGregorianCalendar(sessionScope.deal.chevrons[0].TCDts[0], 'MMM dd, yyyy')}"/>
		</c:if>
	</c:when>
	
</c:choose>

<ul class="progressbar linebreak">
	<li class="list-1 ${requestClass}">
		<a href="#"> 
			<bean:message key = "label.progressBar.projectSummary" /> 
			<span class="push">	${requestDt}</span>
		</a>
	</li>
	<li class="list-2 ${pipelineClass}">
		<a href="#">
			<bean:message key = "label.progressBar.pipelineReview" /> 
			<span class="push" ${pipeLinetDt}>	${pipeLineDt}</span>
		</a>
	</li>
	<li class="list-3 ${soClass}">
		<a href="#">
			<bean:message key = "label.progressBar.structingUnderwriting" /> 
			<span ${sotDt}>	${soDt}	</span>
		</a>
	</li>
	<li class="list-4 ${riskClass}">
		<a href="#">
			<bean:message key = "label.progressBar.riskReviewAffirmation" /> 
			<span class="push" ${risktDt}>	${riskDt} </span>
		</a>
	</li>
	<li class="list-5 ${idagClass}">
		<a href="#">
			<bean:message key = "label.progressBar.idagTesgEagApprovals" /> 
			<span class="push" ${idagtDt}>	${idagDt} </span>
		</a>
	</li>
	<li class="list-6 ${tcClass}">
		<a href="#">
			<bean:message key = "label.progressBar.transactionCapture" /> 
			<span ${tctDt}>${tcDt}</span>
		</a>
	</li>
</ul>
