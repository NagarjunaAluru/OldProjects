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
        
			<div class="form-mod" id="businessContactPersonSectionId">
				<h2 id="businessContactPerson" class="section_flip section_blue">
					<a href="javascript:;"><s:text
							name="label.request.dlocbusinessContactPerson" /></a>
				</h2><hr class="h2-hr">
				<div id="businessContactPersonPanel" class="section_panel">
					<jsp:include page="/jsp/common/request/businessContactPerson.jsp" />
				</div>
			</div>

			<div class="clear"></div>

			<div class="form-mod">
				<h2 id="issuingBank" class="section_flip">
					<a name="second" href="javascript:;"><s:text
							name="label.request.issuingBank" /></a>
				</h2><hr class="h2-hr">
				<div id="issuingBankPanel" class="section_panel">
					<jsp:include page="/jsp/common/request/issuingBank.jsp" />
				</div>
			</div>

			<div class="clear"></div>

			<div class="form-mod">
				<h2 id="applicant" class="section_flip">
					<a href="javascript:;"><s:text name="label.request.applicant" /></a>
				</h2><hr class="h2-hr">
				<div id="applicantPanel" class="section_panel">
					<jsp:include page="/jsp/common/request/applicant.jsp" />
				</div>
			</div>

			<div class="clear"></div>

			<div class="form-mod">
				<h2 id="beneficiary" class="section_flip">
					<a href="javascript:;"><s:text name="label.request.beneficiary" /></a>
				</h2><hr class="h2-hr">
				<div id="beneficiaryPanel" class="section_panel">
					<jsp:include page="/jsp/common/request/beneficiary.jsp" />
				</div>
			</div>

			<div class="clear"></div>

			<div class="form-mod">
				<h2 id="instrumentTransactionDetails" class="section_flip">
					<a href="javascript:;"><s:text
							name="label.request.instrumentTransactionDetails" /></a>
				</h2><hr class="h2-hr">
				<div id="instrumentTransactionDetailsPanel" class="section_panel">
					<jsp:include page="/jsp/common/request/instrumentTransactionDetails.jsp" />
				</div>
			</div>
			<div class="clear"></div>

			<div class="form-mod">
				<h2 id="paymentSchedule" class="section_flip">
					<a href="javascript:;"><s:text
							name="label.request.paymentSchedule" /></a>
				</h2><hr class="h2-hr">
				<div id="paymentSchedulePanel" class="section_panel">
					<jsp:include page="/jsp/common/request/paymentSchedule.jsp" />
				</div>
			</div>
			<!-- Including Format   -->
			<div class="form-mod" id="formatDiv">
				<h2 id="format" class="section_flip">
					<a href="javascript:;"><s:text name="label.request.bglocSectionName.7" /> 
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
					<a href="javascript:;"><s:text
							name="label.request.bglocSectionName.9" /></a>
				</h2><hr class="h2-hr">
				<div id="attachmentsPanel" class="section_panel">
					<jsp:include page="/jsp/common/request/attachments.jsp" />
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