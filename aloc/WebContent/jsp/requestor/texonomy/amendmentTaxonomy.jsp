<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<%@include file="../../common/includeCommonScripts.jsp"%>
	<title><s:text name="label.amendment.pageTitle"/> - <s:text name="label.request.readOnlyView" /> </title>
	<link href="${pageContext.request.contextPath}/css/common/pagenavi.css" type="text/css" rel="stylesheet" />
	<link href="${pageContext.request.contextPath}/css/common/amendment.css" type="text/css" rel="stylesheet" />
	<script src="${pageContext.request.contextPath}/js/requestor/requestor.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/common/toWord.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/common/amendment.js"	type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/common/pagination.js"></script>
	<link href="${pageContext.request.contextPath}/css/common/pagenavi.css" type="text/css" rel="stylesheet" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/attachments/attachmentOperations.js"></script>  
</head>

<body>
	<div class="container main">
		<jsp:include page="../../common/headerSection.jsp">
			<jsp:param name="createReqPopup" value="Yes"></jsp:param>
		</jsp:include>
		
		<h1 class="page-title span12">
				<s:text name="label.request.requestBGOrSLoc" /> <s:property value="requestDetails.instrumentType"/> 
			</h1>
			<hr class="page-title-hr">
			<div class="form-mod">		
				<div class="row">
					<div class="span12 request-summary">
						<p class="heading"><s:text name="label.request.requestSummary" />
						<c:if test="${not empty requestDetails.alocRecordId}">
		        		 - <span><s:text name="label.request.alocRecNo"/> </span><s:property value="requestDetails.alocRecordId" />
		        		</c:if>
						</p>
						<div class="row lastrow">
							<div class="span2d"><div class="right"><label><s:text name="label.request.requestorName"/></label></div></div>
							<div class="span3 left"><s:property value="requestDetails.requestSummary.requestor.lastName"/>,<s:property value="requestDetails.requestSummary.requestor.firstName"/></div>
							<div class="span2a"><div class="right"><label><s:text name="label.request.instrumentPurpose"/></label></div></div>
							<div class="span3 left"><s:property value="requestDetails.transactionParties.instrumentPurpose"/></div>
						</div>
						<div class="row">
							<div class="span2d"><div class="right"><label><s:text name="label.request.requestorSSO"/></label></div></div>
							<div class="span3 left"><s:property value="requestDetails.requestSummary.requestor.ssoId"/></div>
							<div class="span2a"><div class="right"><label><s:text name="label.amendment.seqNo"/></label></div></div>
							<div class="span3 left"><s:property value="requestDetails.amendment.amendmentRequestId" /></div>
						</div>				
					</div>
				</div>
			</div>
		
		<div class="form-mod">
        	<c:choose>
        		<c:when test="${taxonomyViewType eq 'OPENREQUEST'}">
        			<c:set var="myReqClass" value="active"></c:set>
        			<c:set var="myReqTab" value="active in"></c:set>
        		</c:when>
        		<c:when test="${taxonomyViewType eq 'issuer'}">
        			<c:set var="myIssuerClass" value="active"></c:set>
        			<c:set var="myIssuerTab" value="active in"></c:set>
        		</c:when>
        	</c:choose>
		
			<s:url action="RequestorAtmtTaxonomy.action" namespace="/int" escapeAmp="false" var="requestURL" />
			
			<s:url action="IssuerTaxonomy.action" namespace="/int" escapeAmp="false" var="issuerURL" >
				<s:param name="returnToPage">${returnToPage}</s:param>
				<s:param name="requestId"><s:property value="requestDetails.requestId"/></s:param>
			</s:url>
			
			<s:url action="cancelTaxonomy.action" namespace="/int" var="cancelLinkURL"/>

			<ul class="nav nav-tabs nav-tabsapm tabs">
				<li class="${myReqClass}"><a href="<s:property value="requestURL" />"><s:text name="label.request.requestDetails"/></a></li>		
				<c:if test="${requestDetails.WFDetails.WFStageID eq 10 || requestDetails.WFDetails.WFStageID eq 14 || requestDetails.WFDetails.WFStageID eq 15}">
					<li class="${myIssuerClass}"><a href="<s:property value="issuerURL"/>"><s:text name="label.request.issuance"/></a></li>
				</c:if>
			</ul>
			
			<div class="tab-content" id="myTabContent">
			
				<div id="1" class="tab-pane fade ${myReqTab}">
						<jsp:include page="/jsp/common/request/taxonomy/taxonomyAmendmentRequest.jsp">
							<jsp:param name="includeScripts" value="false" />
						</jsp:include>
						<input type="hidden" name="returnToPage" value="${returnToPage}">
				</div><!-- Fist Tab End -->
				
				<div id="2" class="tab-pane fade ${myIssuerTab}">
				<c:if test="${not empty sessionScope.historicalTab}" >	
				<jsp:include page="/jsp/common/request/taxonomy/historicalTransactionissuer.jsp">
						<jsp:param name="includeScripts" value="false" />
       				</jsp:include>
				</c:if>
				<c:if test="${empty sessionScope.historicalTab}" >	
					<jsp:include page="/jsp/common/request/taxonomy/issuerReadOnly.jsp">
						<jsp:param name="includeScripts" value="false" />
       				</jsp:include>
       				<a href="<s:property value="#cancelLinkURL" />" class="btn-tertiary cancel"><s:text name="label.request.common.cancel"></s:text></a>
       			</c:if>
				</div>
			</div><!--  Main form-mod End  -->
		  </div>
	</div>

	<%@include file="../../common/footerSection.jsp"%>
	
	<div class="modal hide fade" id="clearEntries">
		<div class="modal-header">
			<a class="close" data-dismiss="modal">X</a>
			<h3><s:text name="label.request.clearEntries"/> <span></span></h3>
		</div>
		<div class="modal-body">
		<p><s:text name="label.request.popUpMsg"/></p>
		</div>
		<div class="modal-footer">
		    <a href="<s:property value="#cancelLinkURL" />" class="btn left"><s:text name="label.request.continue"/></a>
			<a href="javascript:;" class="btn-tertiary left cancel" data-dismiss="modal"><s:text name="label.request.closeWindow"/></a>
		</div>
	</div>
</body>
</html>