<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="hwfs"  uri="/hwf-security-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<c:if test="${param.includeScripts != false}">
	<%@include file="../../common/includeCommonScripts.jsp" %>
</c:if>

<hwfs:checkComponentPermission name="TaxonomyUpdateAccess" domainName="BusinessAccess">
	<s:set name="pageName" value="%{'Taxonomy'}" />
</hwfs:checkComponentPermission>
<c:choose>
	
	<c:when test="${param.sectionId eq 'request.section.transactionParties'}">
		<div id="transactionPartiesSection">
				<jsp:include page="/jsp/common/request/taxonomy/taxonomyTransactionParties.jsp" >
					<jsp:param name="page" value="${pageName}" />
				</jsp:include>
				<input type="hidden" name= "sectionId" value="${param.sectionId}" />
		</div>
	</c:when>
	
	<c:when test="${param.sectionId eq 'request.section.projectDescription'}">
		<div id="projectDescriptionSection">
				<jsp:include page="/jsp/common/request/projectDescription.jsp" >
					<jsp:param value="true" name="isTaxonomy"/>
				</jsp:include>
		</div>
	</c:when>
	
	<c:when test="${param.sectionId eq 'request.section.instrumentDetails'}">
		<div id="instrumentDetailsSection">
				<jsp:include page="/jsp/common/request/instrumentDetails.jsp" >
					<jsp:param value="true" name="isTaxonomy"/>
				</jsp:include>
		</div>
	</c:when>
	
	<c:when test="${param.sectionId eq 'request.section.instrumentRisk'}">
		<div id="instrumentRiskSection">
				<jsp:include page="/jsp/common/request/instrumentRisk.jsp" >
					<jsp:param value="true" name="isTaxonomy"/>
				</jsp:include>
		</div>
	</c:when>
	
	<c:when test="${param.sectionId eq 'request.section.standbyLetterofCredit'}">
		<div id="standbyLetterofCreditSection">
				<jsp:include page="/jsp/common/request/standbyLOCConditions.jsp" >
					<jsp:param value="true" name="isTaxonomy"/>
				</jsp:include>
		</div>
	</c:when>
	
	<c:when test="${param.sectionId eq 'request.section.instrumentReporting'}">
		<div id="instrumentReportingSection">
				<jsp:include page="/jsp/common/request/instrumentReportingAttributes.jsp" >
					<jsp:param value="true" name="isTaxonomy"/>
				</jsp:include>
		</div>
	</c:when>
	
	<c:when test="${param.sectionId eq 'request.section.format'}">
		<div id="formatSection">
				<jsp:include page="/jsp/common/request/format.jsp">
					<jsp:param value="true" name="isTaxonomyView"/>
					<jsp:param value="true" name="isTaxonomy"/>
				</jsp:include>
		</div>		
	</c:when>
	
	<c:when test="${param.sectionId eq 'request.section.deliveryInstructions'}">
		<div id="deliveryInstructionsSection">
				<jsp:include page="/jsp/common/request/deliveryInstructions.jsp" >
					<jsp:param value="true" name="isTaxonomy"/>
				</jsp:include>
		</div>		
	</c:when>
	
	<c:when test="${param.sectionId eq 'request.section.attachments'}">
		<div id="attachmentsSection">
				<jsp:include page="/jsp/common/request/attachments.jsp" >
					<jsp:param value="true" name="isTaxonomy"/>
				</jsp:include>
		</div>		
	</c:when>
	
</c:choose>
