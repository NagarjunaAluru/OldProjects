<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    
    
	<%@include file="/jsp/common/includeCommonScripts.jsp" %>
	<title><s:property value="requestDetails.instrumentType"/> - <s:text name="label.request.requestFullView" /></title>
	<link href="${pageContext.request.contextPath}/css/common/pagenavi.css" type="text/css" rel="stylesheet" />
	<script src="${pageContext.request.contextPath}/js/requestor/requestor.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/common/toWord.js" type="text/javascript"></script>

</head>

<body>
	
	<div class="container main">
		<jsp:include page="/jsp/common/headerSection.jsp">
			<jsp:param name="createReqPopup" value="Yes"></jsp:param>
		</jsp:include>
		<div id="mainPage">
		
	<jsp:include page="/jsp/common/request/apm/requestsFullViewHeader.jsp" />
        
				<!-- Including Transaction Parties  -->
   <div class="form-mod">
		<h2 id="transactionParties" class="section_flip section_blue">
			<a href="javascript:;"><s:text name="label.request.bglocSectionName.1"/></a>
		</h2><hr class="h2-hr">
		<div id="transactionPartiesPanel" class="section_panel">
			<jsp:include page="/jsp/common/request/transactionParties.jsp" />					
		</div>
	</div>
   
   <div class="clear"></div>
   
   <!-- Including Project Description  -->
   <div class="form-mod" id="projectDescDiv">
   		<h2 id="projectDescription" class="section_flip">
			<a href="javascript:;"><s:text name="label.request.bglocSectionName.2"/></a>
		</h2><hr class="h2-hr">
		<div id="projectDescriptionPanel" class="section_panel">
		     <jsp:include page="/jsp/common/request/projectDescription.jsp" />
		</div>
   </div>
   
   
   <!-- Including Instrument Details  -->
   <div class="form-mod" >
   		<h2 id="instrumentDetails" class="section_flip">
			<a href="javascript:;"><s:text name="label.request.bglocSectionName.3"/></a>
		</h2><hr class="h2-hr">
		<div id="instrumentDetailsPanel" class="section_panel">
			  <jsp:include page="/jsp/common/request/instrumentDetails.jsp" />
		</div>
   </div>
   
   <!-- Including Instrument Risk  -->
   <div class="form-mod" >
   		<h2 id="instrumentRisk" class="section_flip">
			<a href="javascript:;"><s:text name="label.request.bglocSectionName.4"/></a>
		</h2><hr class="h2-hr">
		<div id="instrumentRiskPanel" class="section_panel">
		     <jsp:include page="/jsp/common/request/instrumentRisk.jsp" />
		</div>
   </div>
   
   <!-- Including Standby Letter of Credit Conditions  -->
   <c:if test="${requestDetails.instrumentType eq 'Standby Letter Of Credit'}">
   <div class="form-mod" >
   		<h2 id="locConditions" class="section_flip">
			<a href="javascript:;"><s:text name="label.request.bglocSectionName.5"/></a>
		</h2><hr class="h2-hr">
		<div id="locConditionsPanel" class="section_panel">
		     <jsp:include page="/jsp/common/request/standbyLOCConditions.jsp" />
		</div>
   </div>
   </c:if>
    <!-- Including Instrument Reporting Attributes  -->
   <div class="form-mod" >
   		<h2 id="instrumentReporting" class="section_flip">
			<a href="javascript:;"><s:text name="label.request.bglocSectionName.6"/></a>
		</h2><hr class="h2-hr">
		<div id="instrumentReportingPanel" class="section_panel">
		     <jsp:include page="/jsp/common/request/instrumentReportingAttributes.jsp" />
		</div>
   </div>		
   <!-- Including Format   -->
   <div class="form-mod" id="formatDiv">
   		<h2 id="formatSectionFlip" class="section_flip">
			<a href="javascript:;"><s:text name="label.request.bglocSectionName.7"/> 
				<span id="formatSelectionH2"></span>
			</a>
		</h2><hr class="h2-hr">
		<div id="formatSectionFlipPanel" class="section_panel">
		     <jsp:include page="/jsp/common/request/format.jsp" />
		</div>
   </div>
   
   <!-- Delivery Instructions -->
   <div class="form-mod">
   		<h2 id="deliveryInstructions" class="section_flip">
			<a href="javascript:;"><s:text name="label.request.bglocSectionName.8"/></a>
		</h2><hr class="h2-hr">
		<div id="deliveryInstructionsPanel" class="section_panel">
		      <jsp:include page="/jsp/common/request/deliveryInstructions.jsp" />
		</div>
   </div>
   <!-- Including Attachments   -->
   <div class="form-mod" id="attachmentsDiv">
   		<h2 id="attachmentsFlip" class="section_flip">
			<a href="javascript:;"><s:text name="label.request.bglocSectionName.9"/></a>
		</h2><hr class="h2-hr">
		<div id="attachmentsFlipPanel" class="section_panel">
			    <jsp:include page="/jsp/common/request/attachments.jsp" />
		</div>
   </div>	
   
	<div class="row">
		<div class="span12">
			<c:choose>
			<c:when test="${returnToPage eq 'FeeHistory'}">
	       	<a href="<s:property value="#returnToFeeHistoryURL" />" ><s:text name="label.request.returnFeeHistory"/></a>
	   		</c:when>
	   		<c:otherwise>
	   		<a href="<s:property value="#feePaymentRunURL" />" ><s:text name="label.request.returnToFeePaymentRun" /> </a>
	   		</c:otherwise>
	   		</c:choose>
		</div>
	</div>	
				
</div>	
</div>
<%@include  file="/jsp/common/footerSection.jsp" %>
</body>
</html>