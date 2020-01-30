<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    
	<%@include file="/jsp/ext/common/includeCommonScripts.jsp" %>
	<title><s:property value="requestDetails.instrumentType"/> - <s:text name="label.request.requestFullView" /></title>
	<link href="${pageContext.request.contextPath}/ext/public/css/common/pagenavi.css" type="text/css" rel="stylesheet" />
	<script src="${pageContext.request.contextPath}/ext/public/js/requestor/requestor.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/ext/public/js/common/toWord.js" type="text/javascript"></script>

</head>

<body>
	
	<div class="container main">
		<%@include  file="/jsp/ext/common/headerSection.jsp" %>
		<div id="mainPage">
		
			<jsp:include page="requestsFullViewHeader.jsp" />
        
			<div class="form-mod" id="bondDetailsSectionId">
				<h2 id="bondDetails" class="section_flip section_blue">
					<a href="javascript:;"><s:text name="label.request.sbSectionBondDetails"/>
					</a>
				</h2><hr class="h2-hr">
			<div id="bondDetailsPanel" class="section_panel">
				<jsp:include page="/jsp/common/request/bondDetails.jsp" />
			</div>
			</div>
			
			<div class="clear"></div>
			
			<div class="form-mod">
				<h2 id="principal" class="section_flip">
				<a href="javascript:;"><s:text name="label.request.sbSectionPrincipal"/>
			</a></h2><hr class="h2-hr">
				<div id="principalPanel" class="section_panel">
					<jsp:include page="/jsp/common/request/principalDetails.jsp" />
				</div>
			</div>
				
			<div class="clear"></div>
			
			<div class="form-mod">
				<h2 id="obligee" class="section_flip">
					<a href="javascript:;"><s:text name="label.request.sbSectionObligee"/></a>
				</h2><hr class="h2-hr">
				<div id="obligeePanel" class="section_panel">
					<jsp:include page="/jsp/common/request/obligeeDetails.jsp" />			
				</div>
			</div>			
			<div class="clear"></div>
			
			<div class="form-mod">
				<h2 id="requestorMailingAddress" class="section_flip">
				<a href="javascript:;"><s:text name="label.request.sbSectionRequestorMailingAddress"/>
				</a></h2><hr class="h2-hr">
				<div id="requestorMailingAddressPanel" class="section_panel">
					<jsp:include page="/jsp/common/request/mailingAddress.jsp" />
				</div>
			</div>			
			<div class="clear"></div>

			<div class="form-mod">
				<h2 id="deliveryInstructions" class="section_flip">
				<a href="javascript:;"><s:text name="label.request.sbSectionDeliveryInstructions"/></a></h2><hr class="h2-hr">
				<div id="deliveryInstructionsPanel" class="section_panel">
					<jsp:include page="/jsp/common/request/sbDeliveryInstructions.jsp" />		
				</div>
			</div>
			<div class="clear"></div>

			<div class="form-mod">
				<h2 id="bondInformation" class="section_flip">
				<a href="javascript:;"><s:text name="label.request.sbSectionBondInformation"/></a></h2><hr class="h2-hr">
				<div id="bondInformationPanel" class="section_panel">
					<jsp:include page="/jsp/common/request/bondInformation.jsp" />
				</div>
			</div>
			
		   <!-- Including Format   -->
		   <div class="form-mod" id="formatDiv">
		   		<h2 id="format" class="section_flip">
					<a href="javascript:;"><s:text name="label.request.sbSectionFormat"/> 
						<span id="formatSelectionH2"></span>
					</a>
				</h2><hr class="h2-hr">
				<div id="formatPanel" class="section_panel">
					<jsp:include page="/jsp/common/request/format.jsp" />
				</div>
		   </div>
		   <!-- Including Attachments   -->
		   <div class="form-mod" id="attachmentsDiv">
		   		<h2 id="attachments" class="section_flip">
					<a href="javascript:;"><s:text name="label.request.sbSectionAttachments"/></a>
				</h2><hr class="h2-hr">
				<div id="attachmentsPanel" class="section_panel">
					<jsp:include page="/jsp/common/request/attachments.jsp" />
				</div>
		   </div>
		   <div class="clear"></div>
			<div class="form-mod" id="businessDelegationDiv">
		   		<h2 id="businessDelegation" class="section_flip">
					<a href="javascript:;"><s:text name="label.request.businessDelegation"/></a>
				</h2><hr class="h2-hr">
				<div id="businessDelegationPanel" class="section_panel">
					<jsp:include page="/jsp/common/request/businessDelegation.jsp" />
				</div>
			</div>

	<div class="row">
	<div class="span12">
		<s:url action="searchFeeHistory.action" namespace="/ext/admin" var="returnToFeeHistoryURL" />
		<a href="<s:property value="#returnToFeeHistoryURL" />" class="left"> <s:text name="label.request.returntoFeeHistory" /></a>
	</div>
	</div>	
				
	<%@include file="/jsp/ext/common/footerSection.jsp" %>
</div>	
</div>
</body>
</html>