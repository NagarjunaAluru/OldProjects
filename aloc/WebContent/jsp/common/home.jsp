<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<%@include file="../common/includeCommonScripts.jsp" %>
<s:head/>
</head>
<body>
<div class="container main">
	<jsp:include page="../common/headerSection.jsp">
		<jsp:param name="createReqPopup" value="Yes"></jsp:param>
	</jsp:include>
		
	<s:url action="createBGRequest.action" namespace="/requestor" var="createRequestURL" />
	<a href="<s:property value="#createRequestURL" />" >Create Bank Guarantee Request</a>
	<br />
	<s:url action="createLOCRequest.action" namespace="/requestor" var="createRequestURL" />
	<a href="<s:property value="#createRequestURL" />" >Create Standby LOC Request</a>
	<br />
	<s:url action="createSBRequest.action" namespace="/requestor" var="createRequestURL" />
	<a href="<s:property value="#createRequestURL" />" >Create Surity Bond Request</a>
	<br />
	<s:url action="createDLOCCRequest.action" namespace="/requestor" var="createRequestURL" />
	<a href="<s:property value="#createRequestURL" />" >Create Doc. LOC Confirmation Request</a>
	<br />
	<br />
	<s:url action="open.action" namespace="/int/treasuryadmin" var="createaccessControlURL" />
	<a href="<s:property value="#createaccessControlURL" />" >External User Management</a>
	<br />
	<s:url action="loadLinkTransactions.action" namespace="/int/linkto" var="linkTransactionURL" />
	<a href="<s:property value="#linkTransactionURL" />" >Link to</a>
	<br />
	<s:url action="getLegalEntity.action" namespace="/lookup" var="getLegalEntity"/>
	<a href="<s:property value="#getLegalEntity" />" >Get Legal Entity</a>
	<br />
	<s:url action="openRequest.action" namespace="/" var="openRequestURL" escapeAmp="false" encode="true">
		<s:param name="requestId">4791</s:param>
		<s:param name="stage">2</s:param>
		<s:param name="dashboardViewType"></s:param>
	</s:url>
	<a href="<s:property value="#openRequestURL" />" >SuretyBond Request</a>
	<br />
	<s:url action="openRequest.action" namespace="/" var="openBankRequestURL" escapeAmp="false" encode="true">
		<s:param name="requestId">4794</s:param>
		<s:param name="stage">5</s:param>
		<s:param name="dashboardViewType"></s:param>
	</s:url>
	<a href="<s:property value="#openBankRequestURL" />" >BankGaurantee Request</a><br><br>
	
	<s:url action="openPole.action" namespace="/int/admin" var="poleNameURL" />
	<a href="<s:property value="#poleNameURL" />" >Pole Name Management</a><br><br>
	
	<s:url action="editBlockBUC.action" namespace="/int/admin" var="blockBUCURL" />
	<a href="<s:property value="#blockBUCURL" />" >Block BUC</a><br><br>
		
	<s:url action="openAmendmentRequest.action" namespace="/int/requestor" var="amendmentRequestURL" escapeAmp="false" encode="true">
		<s:param name="requestId">6935</s:param>
		<s:param name="instrumentId">5</s:param>
		<s:param name="dashboardViewType"></s:param>
	</s:url>
	<a href="<s:property value="#amendmentRequestURL" />" >Amendment Request</a><br>
	
	<s:url action="openRiderRequest.action" namespace="/int/requestor" var="riderRequestURL" escapeAmp="false" encode="true">
		<s:param name="requestId">7155</s:param>
		<s:param name="instrumentId">6</s:param>
		<s:param name="dashboardViewType"></s:param>
	</s:url>
	<a href="<s:property value="#riderRequestURL" />" >Surety Rider Request</a><br><br>
	
	<s:url action="openRequest.action" namespace="/" var="bgTreasuaryAmendmentReviewURL" escapeAmp="false" encode="true">
		<s:param name="requestId">4794</s:param>
		<s:param name="amendmentId">4794-1</s:param>
		<s:param name="instrumentId">5</s:param>
		<s:param name="stage">5</s:param>
		<s:param name="dashboardViewType"></s:param>
	</s:url>
	<a href="<s:property value="#bgTreasuaryAmendmentReviewURL" />" >Amendment Request Review</a><br><br>
	
	<s:url action="openRequest.action" namespace="/" var="bgTreasuaryRiderReviewURL" escapeAmp="false" encode="true">
		<s:param name="requestId">5989</s:param>
		<s:param name="amendmentId">5989-2</s:param>
		<s:param name="instrumentId">6</s:param>
		<s:param name="stage">5</s:param>
		<s:param name="dashboardViewType"></s:param>
	</s:url>
	<a href="<s:property value="#bgTreasuaryRiderReviewURL" />" >TRAnalyst Rider Review</a><br><br>
	
	<s:url action="openRequest.action" namespace="/" var="issuerUrlL" escapeAmp="false" encode="true">
		<s:param name="requestId">5722</s:param>
		<s:param name="stageName">BIDISSUE</s:param>
	</s:url>
	<a href="<s:property value="issuerUrlL" />" >Issuer</a><br>
	
	
	<s:url action="asssignDefaultValuesReports.action" namespace="/int/reports" var="contigunentReport" escapeAmp="false" encode="true">
	</s:url>
	<a href="<s:property value="contigunentReport"/>">Contigunent Liability Report</a><br>
	
	<s:url action="assignInsuanceValuesReports.action" namespace="/int/reports" var="assignInsuanceValues" escapeAmp="false" encode="true">
	</s:url>
	<a href="<s:property value="assignInsuanceValues"/>">Issuance/Expiration Report</a><br>
	
	<s:url action="loadCycleTimeReports.action" namespace="/int/reports" var="loadCycleTimeReport" escapeAmp="false" encode="true">
	</s:url>
	<a href="<s:property value="loadCycleTimeReport"/>">Cycle Time Report</a><br>
	
	<s:url action="bidSuccessReports.action" namespace="/int/reports" var="bidSuccessReport" escapeAmp="false" encode="true">
	</s:url>
	<a href="<s:property value="bidSuccessReport"/>">Bid Success Report</a><br>
	
	<s:url action="feesPaidReports.action" namespace="/int/reports" var="feesPaidReport" escapeAmp="false" encode="true">
	</s:url>
	<a href="<s:property value="feesPaidReport"/>">Fees Paid Report</a><br>
	
	<!--  APM Realated Dummay Links -->
	<br>
		
	<s:url action="getFeeSummary.action" namespace="/int/apm" var="getFeeSummary" escapeAmp="false" encode="true">
	 <s:param name="ALOCRecordNumber">4794</s:param>
    </s:url>
	<a href="<s:property value="getFeeSummary"/>">APM Fee Summary Detail</a><br>
	
	<s:url action="searchFeeHistory.action" namespace="/int/admin" var="feeHistoryURL" />
	<a href="<s:property value="#feeHistoryURL" />" >Fee History</a><br><br>
	<hr />
	<%@include  file="../common/footerSection.jsp" %>
</div>
</body>
</html>