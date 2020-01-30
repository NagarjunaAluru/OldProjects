<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    
    
	<%@include file="/jsp/common/includeCommonScripts.jsp" %>
	<title><s:text name="label.amendment.pageTitle"/> - <s:text name="label.request.requestFullView" /></title>
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
        
<!-- Including Transaction Parties -->
			<div class="form-mod">
				<h2 id="transactionParties" class="section_flip section_blue">
					<a href="javascript:;">
						<s:text	name="label.request.bglocSectionName.1" />
					</a>
				</h2><hr class="h2-hr">
				<div id="transactionPartiesPanel" class="section_panel">
				
					<h3 id="applicantHeader"><s:text name="label.request.applicant"/></h3>
					<jsp:include page="/jsp/common/request/amendment/tpApplicantDetails.jsp" />
					<c:if test="${requestDetails.siteTypeName eq 'Financial Business'}">
					<h3 id="triPartyHeader"><s:text name="label.request.triPartyApplicant" /></h3>
					<jsp:include page="/jsp/common/request/amendment/tripartyApplicant.jsp" />
					</c:if>
					<h3 id="customerHeader"><s:text name="label.request.customer" /></h3>
					<jsp:include page="/jsp/common/request/amendment/tpCustomerDetails.jsp" />
				</div>
			</div>
			
			<div class="clear"></div>
			
			<!-- Including Instrument Amount/Currency -->
			<div class="form-mod">
				<h2 id="instrumentAmountCurrency" class="section_flip section_blue">
					<a href="javascript:;">
						<s:text	name="label.request.bglocSectionName.13" />
					</a>
				</h2><hr class="h2-hr">
				<div id="instrumentAmountCurrencyPanel" class="section_panel">
					<jsp:include page="/jsp/common/request/amendment/instrumentAmountCurrency.jsp" />
				</div>
			</div>
			
			<!-- Including Expiration Dates -->
			<div class="form-mod">
				<h2 id="expirationDates" class="section_flip section_blue">
					<a href="javascript:;">
						<s:text	name="label.request.bglocSectionName.14" />
					</a>
				</h2><hr class="h2-hr">
				<div id="expirationDatesPanel" class="section_panel">
					<jsp:include page="/jsp/common/request/amendment/expirationDates.jsp" />
				</div>
			</div>
			
			<!-- Including Other Changes -->
			<div class="form-mod">
				<h2 id="otherChanges" class="section_flip section_blue">
					<a href="javascript:;">
						<s:text	name="label.request.bglocSectionName.18" />
					</a>
				</h2><hr class="h2-hr">
				<div id="otherChangesPanel" class="section_panel">
					<jsp:include page="/jsp/common/request/amendment/otherChanges.jsp" />
				</div>
			</div>
			
			<!-- Including Attachments   -->
			<div class="form-mod" id="attachmentsDiv">
				<h2 id="attachmentsFlip" class="section_flip">
					<a href="javascript:;"><s:text
							name="label.request.bglocSectionName.9" /></a>
				</h2><hr class="h2-hr">
				<div id="attachmentsFlipPanel" class="section_panel">
					<jsp:include page="/jsp/common/request/attachments.jsp" />
				</div>
			</div>
			<!-- Including Audit Log -->
			<jsp:include page="/jsp/common/request/AuditLog.jsp" />
			

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