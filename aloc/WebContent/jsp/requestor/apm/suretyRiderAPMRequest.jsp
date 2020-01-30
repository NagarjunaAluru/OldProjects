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
        
			<div class="form-mod">
				<h2 id="principal" class="section_flip">
				<a href="javascript:;"><s:text name="label.request.sbSectionPrincipal"/>
			<span class="ttip info" data-original-title="This is an tooltip with more information"></span>
			</a></h2><hr class="h2-hr">
				<div id="principalPanel" class="section_panel">
					<jsp:include page="/jsp/common/request/suretyRider/riderPrincipal.jsp" />
				</div>
			</div>					
				
			<div class="clear"></div>
			
			<div class="form-mod">
				<h2 id="obligee" class="section_flip">
					<a href="javascript:;"><s:text name="label.request.sbSectionObligee"/> </a>
				</h2><hr class="h2-hr">
				<div id="obligeePanel" class="section_panel">
					<jsp:include page="/jsp/common/request/suretyRider/riderObligee.jsp" />
				</div>
			</div>			
						
			<div class="clear"></div>
			
			<!-- Including Expiration Dates -->
			<div class="form-mod">
				<h2 id="expirationDates" class="section_flip section_blue">
					<a href="javascript:;">
						<s:text	name="label.request.bglocSectionName.14" />
					</a>
				</h2><hr class="h2-hr">
				<div id="expirationDatesPanel" class="section_panel">
					<jsp:include page="/jsp/common/request/suretyRider/riderExpiratinDate.jsp" />
				</div>
			</div>
			
			<div class="form-mod">
				<h2 id="bondInformation" class="section_flip">
				<a href="javascript:;"><s:text	name="label.request.sbSectionBondInformation" /></a></h2><hr class="h2-hr">
				<div id="bondInformationPanel" class="section_panel">
					<jsp:include page="/jsp/common/request/suretyRider/riderBondInformation.jsp" />
				</div>
			</div>
			
			 <!-- Including Attachments   -->
		   <div class="form-mod" id="attachmentsDiv">
		   		<h2 id="attachments" class="section_flip">
					<a href="javascript:;"><s:text	name="label.request.sbSectionAttachments"/></a>
				</h2><hr class="h2-hr">
				<div id="attachmentsPanel" class="section_panel">
					<jsp:include page="/jsp/common/request/attachments.jsp" />
				</div>
		   </div>
		   
			<div class="clear"></div>
			<div class="form-mod">
				<h2 id="deliveryInstructions" class="section_flip">
				<a href="javascript:;"><s:text name="label.request.sbSectionDeliveryInstructions"/></a></h2><hr class="h2-hr">
				<div id="deliveryInstructionsPanel" class="section_panel">
					<jsp:include page="/jsp/common/request/amendment/amendmentDeliveryInstructions.jsp" />
				</div>
			</div>
			
		<div class="row">
			<div class="span12">
				<s:url action="searchFeeHistory.action" namespace="/int/admin" var="returnToFeeHistoryURL" />
				<a href="<s:property value="#returnToFeeHistoryURL" />" class="left"> <s:text name="label.request.returntoFeeHistory" /></a>
			</div>
		</div>	
				
	<%@include  file="/jsp/common/footerSection.jsp" %>
	
</div>	
</div>
</body>
</html>