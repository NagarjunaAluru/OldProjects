<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="hwfs"  uri="/hwf-security-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	 <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title><s:text name="label.request.requestBGOrSLoc" /> <s:text name="label.request.suretyRider" /></title>
	<%@include file="/jsp/ext/common/includeCommonScripts.jsp" %>
	<script src="${pageContext.request.contextPath}/ext/public/js/requestor/requestor.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/ext/public/js/requestor/lookup.js"	type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/ext/public/js/common/toWord.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/ext/public/js/common/pagination.js"></script>
	<link href="${pageContext.request.contextPath}/ext/public/css/common/pagenavi.css" type="text/css" rel="stylesheet" /> 
	<script type="text/javascript" src="${pageContext.request.contextPath}/ext/public/js/ext/attachmentOperations.js"></script>
</head>

<body>
	<div class="container main">
		<%@include  file="/jsp/ext/common/headerSection.jsp" %>
		
	<div id="mainPage" style="width: 100%;">
		<h1 class="page-title span12">
					<s:text name="label.request.requestBGOrSLoc" /> <s:text name="label.request.suretyRider" />
		</h1>
		<hr class="page-title-hr">
		<div class="clear"></div>
		 <div id="requestSummary">
    		<jsp:include page="/jsp/common/request/sbRequestSummary.jsp" />
        	<div class="clear"></div>
   		 </div>
		
		<div class="form-mod">
			<c:choose>
        		<c:when test="${taxonomyViewType eq 'OPENREQUEST'}">
        			<c:set var="myRiderClass" value="active"></c:set>
        			<c:set var="myRiderTab" value="active in"></c:set>
        		</c:when>
        		<c:when test="${taxonomyViewType eq 'issuer'}">
        			<c:set var="myIssuerClass" value="active"></c:set>
        			<c:set var="myIssuerTab" value="active in"></c:set>
        		</c:when>
        	</c:choose>
			<s:url action="RequestorAtmtTaxonomy.action" namespace="/ext" escapeAmp="false" var="requestURL" />
			<s:url action="IssuerTaxonomy.action" namespace="/ext" escapeAmp="false" var="issuerURL">
				<s:param name="returnToPage">${returnToPage}</s:param>
				<s:param name="requestId"><s:property value="requestDetails.requestId"/></s:param>
			</s:url>
			
			<s:url action="cancelTaxonomy.action" namespace="/ext" var="cancelLinkURL"/>
			
			<ul class="nav nav-tabs nav-tabsapm tabs">
				<li class="${myRiderClass}"><a href="<s:property value="requestURL" />">Rider Details</a></li>
			<c:if test="${requestDetails.WFDetails.WFStageID eq 10 || requestDetails.WFDetails.WFStageID eq 14 || requestDetails.WFDetails.WFStageID eq 15}"> 
					<li class="${myIssuerClass}"><a href="<s:property value="issuerURL"/>"><s:text name="label.request.issuance"/></a></li>
				</c:if>
			</ul>
			
			
			<div class="tab-content" id="myTabContent">
				<div id="1" class="tab-pane fade ${myRiderTab}">
					<jsp:include page="/jsp/ext/request/taxonomy/riderTaxonomyDetails.jsp">	
						<jsp:param name="includeScripts" value="false" />
					</jsp:include>
					<a href="<s:property value="#cancelLinkURL" />" class="btn-tertiary cancel"><s:text name="label.request.common.cancel"></s:text></a>					
				</div><!-- 2 Tab End -->	
				
				<div id="2" class="tab-pane fade ${myIssuerTab}">
					<jsp:include page="/jsp/ext/request/taxonomy/issuerReadOnly.jsp">
						<jsp:param name="includeScripts" value="false" />
       				</jsp:include>
				</div>
			</div><!--  Main form-mod End  -->
		</div>
	</div>
	<div id="fullHistoryDiv" style="width: 100%;"></div>
	</div>
	<%@include file="/jsp/common/footerSection.jsp"%>
</body>
</html>
