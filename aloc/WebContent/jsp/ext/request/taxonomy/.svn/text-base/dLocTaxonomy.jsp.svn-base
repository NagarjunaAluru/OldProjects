<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="hwfs"  uri="/hwf-security-tags" %>
<!DOCTYPE html>
<html>
<head>
	 <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title><s:property value="requestDetails.instrumentType" /> - <s:text name="label.request.readOnlyView" /> - <s:text name="label.request.requestDetails" /></title>
	<%@include file="/jsp/ext/common/includeCommonScripts.jsp" %>
	<script src="${pageContext.request.contextPath}/ext/public/js/requestor/addBcpReference.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/ext/public/js/requestor/lookup.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/ext/public/js/common/toWord.js" type="text/javascript"></script>
	
	<script src="${pageContext.request.contextPath}/ext/public/js/common/taxonomy.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/ext/public/js/requestor/requestor.js" type="text/javascript"></script>
	<%-- <script src="${pageContext.request.contextPath}/ext/public/js/requestor/bgRequiredCount.js" type="text/javascript"></script> --%>
	<script type="text/javascript" src="${pageContext.request.contextPath}/ext/public/js/ext/attachmentOperations.js"></script>
	<script src="${pageContext.request.contextPath}/ext/public/js/common/pagination.js"></script>
	<link href="${pageContext.request.contextPath}/ext/public/css/common/pagenavi.css" type="text/css" rel="stylesheet" />
</head>

<body>
	<div class="container main">
		<%@include  file="/jsp/ext/common/headerSection.jsp" %>
		
		<div id="mainPage" style="width: 100%;">
		<h1 class="page-title span12"><s:text name="label.request.requestBGOrSLoc" />&nbsp;<s:text name="label.request.docLetterOfCredit" /></h1>
		<p class="span12 left clear dashdesc"><s:text name="label.request.dLocTaxonomyDesc" /></p>
		<hr class="page-title-hr">
		<div class="download">
                   	 <s:url action="taxonomyPDFReport.action" namespace="/ext" var="taxonomyPDFURL" >
                   		<s:param name="downloadDocs">Taxonomy</s:param>
                  		 </s:url>
                   	 <a href="<s:property value="#taxonomyPDFURL"/>"><img src="${pageContext.request.contextPath}/ext/public/img/pdf.png" width="50px" height="59px"/></a>
      		 </div>
		<div class="clear"></div>
		 <div id="requestSummary">
    	<div class="leftColRS">
        	<p><strong><s:text name="label.request.requestSummary"/></strong> - <s:text name="label.request.alocRecNo"/> <strong><s:property value="requestDetails.alocRecordId"/></strong></p>
        </div>
		<div class="clear"></div>
        
        <div class="singleBoxRS">
            <div class="row smallrow">
                <div class="span2">
                    <label><s:label key="label.request.requestor"/></label>
							<p><s:property value="requestDetails.requestSummary.requestor.lastName"/>, <s:property value="requestDetails.requestSummary.requestor.firstName"/></p>
							<p><s:property value="requestDetails.requestSummary.requestor.ssoId"/></p>
                </div>          
            </div>
		</div><!-- leftBox ends here -->
        <div class="singleBoxRS">
            <div class="row smallrow">
                <div class="span2">
                    <label><s:label key="label.request.alocRecNo"/></label>
							<p><s:property value="requestDetails.alocRecordId"/></p>
                </div>          
            </div>
        </div><!-- midBox ends here -->
                
        <div class="singleBoxRS">
            <div class="row smallrow">
                <div class="span2">
                   <label><s:label key="label.request.linkedTransactionID"/></label>
					<p><s:if test="%{requestDetails.requestSummary.linkedTransactionId==null}">-</s:if><s:else><s:property value="requestDetails.requestSummary.linkedTransactionId"/></s:else></p>
                </div>        
            </div>
        </div><!-- rightBox ends here -->

        <div class="singleBoxRS">
            <div class="row smallrow">
                <div class="span2">
                    <label><s:label key="label.request.modelCode"/></label>
					<p><s:if test="%{requestDetails.requestSummary.modelCode==null}">-</s:if><s:else><s:property value="requestDetails.requestSummary.modelCode"/></s:else></p>
                </div>        
            </div>
        </div><!-- rightBox ends here -->
                
        <div class="clear"></div>
    </div>
		
		<div class="form-mod">
		
			<c:choose>
				<c:when test="${taxonomyViewType eq 'OPENREQUEST'}">
        			<c:set var="myReqClass" value="active"></c:set>
        			<c:set var="myReqTab" value="active in"></c:set>
        		</c:when>
        		<c:when test="${taxonomyViewType eq 'LINKTRANSACTIONS'}">
        			<c:set var="myLinkTansacClass" value="active"></c:set>
        			<c:set var="myLinkTansacTab" value="active in"></c:set>
        		</c:when>
        		<c:when test="${taxonomyViewType eq 'BUNDLETRANSACTIONS'}">
        			<c:set var="myBundleTansacClass" value="active"></c:set>
        			<c:set var="myBundleTansacTab" value="active in"></c:set>
        		</c:when>
        		<c:when test="${taxonomyViewType eq 'COMBIDREPLIES'}">
        			<c:set var="myComBidClass" value="active"></c:set>
        			<c:set var="myComBidTab" value="active in"></c:set>
        		</c:when>
        		<c:when test="${taxonomyViewType eq 'AUDITLOG'}">
        			<c:set var="myAuditLogClass" value="active"></c:set>
        			<c:set var="myAuditLogTab" value="active in"></c:set>
        		</c:when>
        		<c:when test="${taxonomyViewType eq 'issuer'}">
        			<c:set var="myIssuerClass" value="active"></c:set>
        			<c:set var="myIssuerTab" value="active in"></c:set>
        		</c:when>
        	</c:choose>
        	
        	<s:url action="RequestorAtmtTaxonomy.action" namespace="/ext" escapeAmp="false" var="requestURL" />
        	
        	<s:url action="LinkTansactionsTaxonomy.action" namespace="/ext" var="linkURL">
				<s:param name="requestId"><s:property value="requestDetails.requestId"/></s:param>
			</s:url>
			
			<s:url action="BundleTansactionsTaxonomy.action" namespace="/ext" var="bundleURL">
				<s:param name="requestId"><s:property value="requestDetails.requestId"/></s:param>
			</s:url>
			
			<s:url action="CompBidRepliesTaxonomy.action" namespace="/ext" escapeAmp="false" var="compBidRepliesURL">
				<s:param name="requestId"><s:property value="requestDetails.requestId"/></s:param>
			</s:url>
			
			<s:url action="CurrBankFeesTaxonomy.action" namespace="/ext" escapeAmp="false" var="currBankFeesURL">
				<s:param name="returnToPage">${returnToPage}</s:param>
				<s:param name="requestId"><s:property value="requestDetails.requestId"/></s:param>
			</s:url>
			
			<s:url action="AuditLogTaxonomy.action" namespace="/ext" escapeAmp="false" var="auditLogURL" >
				<s:param name="returnToPage">${returnToPage}</s:param>
				<s:param name="requestId"><s:property value="requestDetails.requestId"/></s:param>
			</s:url>
			
			<s:url action="IssuerTaxonomy.action" namespace="/ext" escapeAmp="false" var="issuerURL" >
				<s:param name="returnToPage">${returnToPage}</s:param>
				<s:param name="requestId"><s:property value="requestDetails.requestId"/></s:param>
			</s:url>
			
			<s:url action="cancelTaxonomy.action" namespace="/ext" var="cancelLinkURL"/>
			
			<s:url action="getFullAuditAndActionLog.action" namespace="/ext/approver" var="showFullAuditLog" escapeAmp="false">
			       <s:param name="requestId"><s:property value="requestDetails.requestId"/></s:param>
			       <s:param name="logType">audit</s:param>
			       <s:param name="stageName"><s:property value="requestDetails.WFDetails.WFStage"/></s:param>
			       <s:param name="taxonomyViewType"><s:property value="taxonomyViewType"/></s:param>
			</s:url>
		
			<ul class="nav nav-tabs nav-tabsapm tabs">
				<li class="${myReqClass}"><a href="<s:property value="requestURL" />"><s:text name="label.request.requestDetails"/></a></li>		
                <li class="${myLinkTansacClass}"><a href="<s:property value="linkURL" />"><s:text name="label.request.linkedTransactions"/></a></li>
                <li class="${myBundleTansacClass}"><a href="<s:property value="bundleURL" />"><s:text name="label.request.bundledTransactions"/></a></li>
	          	<li class="${myAuditLogClass}"><a href="<s:property value="auditLogURL" />"><s:text name="label.request.auditLog"/></a></li>
			
				<c:if test="${requestDetails.WFDetails.WFStageID eq 10 || requestDetails.WFDetails.WFStageID eq 14 || requestDetails.WFDetails.WFStageID eq 15}">
					<li class="${myIssuerClass}"><a href="<s:property value="issuerURL"/>"><s:text name="label.request.issuance"/></a></li>
				</c:if>
			</ul>
			
			<div class="tab-content" id="myTabContent">
				
				<div id="1" class="tab-pane fade ${myReqTab}">
					<s:form id="dlocRequestForm" action="updateTaxonomyRequest" namespace="/ext" >
						<jsp:include page="taxonomydLocRequestDetails.jsp" />
					
						<a href="<s:property value="#cancelLinkURL" />" class="btn-tertiary cancel"><s:text name="label.request.common.cancel"></s:text></a>
					</s:form>
				</div><!-- Fist Tab End -->
			
				<div id="4" class="tab-pane fade ${myLinkTansacTab}">
					<jsp:include page="/jsp/common/request/taxonomy/taxonomyLinkedTransaction.jsp" />
					<input type="hidden" name="returnToPage" value="${returnToPage}">
					<a href="<s:property value="#cancelLinkURL" />" class="btn-tertiary cancel"><s:text name="label.request.common.cancel"></s:text></a>
				</div><!-- 4 Tab End -->	
				
				<div id="5" class="tab-pane fade ${myBundleTansacTab}">
					<jsp:include page="/jsp/common/request/taxonomy/taxonomyBundledTransactions.jsp" />
					<a href="<s:property value="#cancelLinkURL" />" class="btn-tertiary cancel"><s:text name="label.request.common.cancel"></s:text></a>
				</div><!-- 5 Tab End -->
				
				<div id="6" class="tab-pane fade ${myAuditLogTab}">
						<s:if test="%{requestDetails.auditLogs.size>5}">
							<p class="right">
			                   		&nbsp;&nbsp;<img alt="Loading..." id="showFullAuditProcess" src="${pageContext.request.contextPath}/ext/public/img/loading.gif" style="display:none;height: 20px;">
			            	</p>
						    <p class="right"><a class="fullScreen" href="<s:property value="#showFullAuditLog"/>" onclick="javascript:showAuditProcess();"><s:text name="label.request.auditLog.fullAuditLog"/></a></p>
						</s:if>
						<h3><s:text name="label.request.auditLog" />
			                 <p><s:text name="label.request.auditLog.sectionDescription"/></p>
			            </h3>
				 		<jsp:include page="/jsp/ext/request/common/AuditLog.jsp" />
				 		<a href="<s:property value="#cancelLinkURL" />" class="btn-tertiary cancel"><s:text name="label.request.common.cancel"></s:text></a>
				</div><!-- 6 Tab End -->
				
				<div id="10" class="tab-pane fade ${myIssuerTab}">
					<jsp:include page="/jsp/ext/request/taxonomy/issuerReadOnly.jsp">
						<jsp:param name="includeScripts" value="false" />
       				</jsp:include>
				</div>
				
			</div><!--  Main form-mod End  -->
		</div>
		</div>
		
	<div id="lookupDiv" style="width: 100%;"></div>
	<div id="fullHistoryDiv" style="width: 100%;"></div>
	</div>
	<%@include file="/jsp/ext/common/footerSection.jsp" %>
</body>
</html>
