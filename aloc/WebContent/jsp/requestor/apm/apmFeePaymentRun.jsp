<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    
	<%@include file="/jsp/common/includeCommonScripts.jsp" %>
	<title><s:text name="label.request.feePaymentRun" /></title>
	<script src="${pageContext.request.contextPath}/js/common/toWord.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/requestor/apm.js" type="text/javascript"></script>
	<style type="text/css">
		h1 { color:#666!important; font-size:26px!important; font-weight:bold!important;}
		.table thead tr th{background:#819EB6!important;border: 1px solid #A6C2D6;line-height: 18px;padding: 8px;text-align: left;vertical-align: top; font-weight: normal;}
	</style>
</head>

<body>
	
	<div class="container main">
		<jsp:include page="/jsp/common/headerSection.jsp">
			<jsp:param name="createReqPopup" value="Yes"></jsp:param>
		</jsp:include>
		<div id="mainPage">
		
		<h1 class="page-title span12"><s:text name="label.request.feePaymentRun" /></h1>
		<p class="span12 left clear dashdesc"><s:text name="label.optionalSentence.apmFeePaymentRun" /></p>
        <hr class="page-title-hr">
   <div class="clear"></div>
   <div class="form-mod">
		<div class="row">
			<div class="span12 bluebg">
				<h2 class="apmSummary"><s:text name="label.request.feesCalculatedForPeriodC" /></h2><hr class="h2-hr">
					<div class="row">
					<div class="span2">
						<label class="right"><s:text name="label.request.startDate" />:</label>
					</div>
					<div class="span2"><p><s:property value="apmDetails.feePaymentRunDetails.feePeriodDetails.periodStartDate"/></p></div>
					<div class="span2">
						<label class="right"><s:text name="label.request.endDate" />:</label>
					</div>
					<div class="span2"><p><s:property value="apmDetails.feePaymentRunDetails.feePeriodDetails.periodEndDate"/></p></div>
					</div>			
			</div>
		</div>
		
	</div><!-- end of form form-mod -->
	<s:url id="getCalculateFeesURL" action="getCalculateFeesDetails" namespace="/int/apm" />
	<s:url id="downloadURL" action="downloadCSVResultExport" namespace="/int/apm" />
	<s:url id="creditAndCarryOversURL" action="creditAndCarryOversExport" namespace="/int/apm" />
	<s:url id="sendInvoicesURL" action="sendInvoices" namespace="/int/apm" />
	<s:url id="webCashURL" action="sendWebCashFiles" namespace="/int/apm" />
	<s:url id="completePaymentURL" action="completePayment" namespace="/int/apm" />
	
	<s:hidden name="apmDetails.feePaymentRunDetails.tabCount" id="tabCount" />
	<div class="form-mod" id="calculateFeeDiv">
		<h2 id="calculateFee">
			<s:text name="label.request.calculateFees" />
		</h2><hr class="h2-hr">
       	<div class="row">
				<div class="span12">
				</div>
		</div>
		<div class="row">
			<div class="span12">
				<sj:submit 
						cssClass="btn-secondary"
						replaceTarget="true"
						targets="calculateFeeForm"
						href="%{getCalculateFeesURL}" 
						indicator="getFeeProcess"
						id="CalculateFees"
						value="Calculate Fees and BUC/ADN 
  validation"
						onCompleteTopics="CalculateFees"
					/>
				<s:a href="%{downloadURL}" cssClass="btn-secondary dwn downloadToCSV"><s:text name="label.request.downloadtoCSV"/><br/><br/></s:a>
				
				<s:a href="%{creditAndCarryOversURL}" cssClass="dwn btn-secondary creditsAndCarryOvers"><s:text name="label.request.creditsAndCarryOvers" /><br /></s:a>
				
				<sj:submit cssClass="btn-secondary invoice" onCompleteTopics="sendInvoice" replaceTarget="false" disabled="true" targets="msgDiv" href="%{sendInvoicesURL}" value="Generate Invoices file for
 IBS" indicator="getFeeProcess"/>
				<sj:submit cssClass="btn-secondary webCash" onCompleteTopics="webCash" replaceTarget="true" disabled="true" targets="msgDiv" href="%{webCashURL}" value="Generate Payment file for
 Web Cash" indicator="getFeeProcess"/>
				<sj:submit cssClass="btn-secondary paymentPeriod" onCompleteTopics="paymentPeriod" replaceTarget="true" disabled="true" targets="msgDiv" href="%{completePaymentURL}" value="Complete payment
period" indicator="getFeeProcess"/>
			</div>
		</div>
		&nbsp;&nbsp;&nbsp;&nbsp;<img alt="Loading..." id="getFeeProcess" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 30px;width: 30px;">
				
				<div id="msgDiv">
					<jsp:include page="/jsp/common/request/apm/apmThirdPartyStatusMsg.jsp"/>
				</div>
				
				<s:form id="calculateFeeForm">
					<jsp:include page="/jsp/common/request/apm/apmCalculateFeeTable.jsp">
						<jsp:param name="includeScripts" value="false" />
					</jsp:include>		
				</s:form>
		
		&nbsp;&nbsp;&nbsp;&nbsp;<img alt="Loading..." id="getFeeProcess1" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 30px;width: 30px;"><br/>
		<div class="row highlighted">
			<div class="span12" style="margin-left: 0px;">
				<sj:submit 
						cssClass="btn-secondary"
						replaceTarget="true"
						targets="calculateFeeForm"
						href="%{getCalculateFeesURL}" 
						indicator="getFeeProcess1"
						id="CalculateFees2"
						value="Calculate Fees and BUC/ADN 
  validation"
						onCompleteTopics="CalculateFees"
					/>
				
				<s:a href="%{downloadURL}" cssClass="btn-secondary dwn downloadToCSV"><s:text name="label.request.downloadtoCSV"/><br/><br/></s:a>
				<s:a href="%{creditAndCarryOversURL}" cssClass="dwn btn-secondary creditsAndCarryOvers"><s:text name="label.request.creditsAndCarryOvers" /><br /></s:a>
				<sj:submit cssClass="btn-secondary invoice" onCompleteTopics="sendInvoice" replaceTarget="true" disabled="true" targets="msgDiv" href="%{sendInvoicesURL}" value="Generate Invoices file for
  IBS" indicator="getFeeProcess"/>
				<sj:submit cssClass="btn-secondary webCash" onCompleteTopics="webCash" replaceTarget="true" disabled="true" targets="msgDiv" href="%{webCashURL}" value="Generate Payment file for
 Web Cash" indicator="getFeeProcess"/>
				<sj:submit cssClass="btn-secondary paymentPeriod" onCompleteTopics="paymentPeriod" replaceTarget="true" disabled="true" targets="msgDiv" href="%{completePaymentURL}" value="Complete payment
period" indicator="getFeeProcess"/>
			</div>
		</div>
	</div>
	</div>
</div>
	<%@include  file="/jsp/common/footerSection.jsp" %>
</body>
</html>