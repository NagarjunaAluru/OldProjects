<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page import="org.apache.commons.lang.StringUtils" %>
<!DOCTYPE html>
<html>
<head>
 <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><s:text name="label.request.create" />&nbsp;<s:text name="label.request.bidMemo" /></title>

<%@include file="../../common/includeCommonScripts.jsp"%>

<script src="${pageContext.request.contextPath}/js/common/pagination.js"></script>
<link href="${pageContext.request.contextPath}/css/common/pagenavi.css" type="text/css" rel="stylesheet" />

<script src="${pageContext.request.contextPath}/js/requestor/bidMemo.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/common/toWord.js" type="text/javascript"></script>
<link type="text/css" href="${pageContext.request.contextPath}/css/others/jquery-ui-1.7.1.custom.css" rel="stylesheet" />
<link type="text/css" href="${pageContext.request.contextPath}/css/others/ui.multiselect.css" rel="stylesheet" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/jquery-ui-1.8.custom.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/jquery.tmpl.1.1.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/jquery.blockUI.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/ui.bank.multiselect.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/others/bankSel.js"></script>
</head>

<body>
	<div class="container main" id="mainDiv">
		<%@include file="../../common/headerSection.jsp"%>
		<div id="mainPage" style="width: 100%;">
		
		<h1 class="page-title span12"><s:text name="label.request.create" />&nbsp;<s:property value="requestDetails.instrumentType" />&nbsp;<s:text name="label.request.bidMemo" /></h1>
		<p class="span12 left clear dashdesc"><s:text name="label.request.enablesTreasuryuserTransc" /></p>
		<hr class="page-title-hr">
		<div class="clear"></div>
		<c:if test="${not empty errorMsg}">
			<div class="row" id="errorMsg">
				<div class="span12">
					<div class="errorbox">
						<div class="errorHead">
							<p class="erroricon">Error</p>
						</div>
						<div class="errorContent">
							<p>
								<s:property value="errorMsg" />
							</p>
							<p>&nbsp;</p>
						</div>
					</div>
				</div>
			</div>	
		</c:if>
		<s:hidden name="errorShow" id="errorShowId"/>
		<div class="row hide" id="pageLevelErrorDivId">
			<div class="span12">
				<div class="errorbox">
					<div class="errorHead"><p class="erroricon">Error</p></div>
					<div class="errorContent">
							<p><s:fielderror>
								<s:param>requestDetails.bidmemoDetails.expirationDateTime</s:param>
								<s:param>hours</s:param>
								<s:param>minutes</s:param>
								<s:param>requestDetails.additionalInstrumentDetails.governingRulesId</s:param>
								<s:param>requestDetails.additionalInstrumentDetails.governingRulesOtherDescription</s:param>
								<s:param>requestDetails.additionalInstrumentDetails.requestForProposal</s:param>
								<s:param>requestDetails.pricingDetails.allInCommissionsId</s:param>
								<s:param>allInCommissionsValue</s:param>
								<s:param>localCommissionsValue</s:param>
								<s:param>rightBankRecords</s:param>
								<s:param>requestDetails.actionDetails.reasonForRejection</s:param>
								<s:param>requestDetails.retainBidReply</s:param>
							</s:fielderror>
							</p>
							<p>&nbsp;</p>
					</div>
				</div>
			</div>
		</div>
		
		<s:if test="hasActionErrors()">
			<div class="row">
				<div class="span12">
					<div class="errorbox">
						<div class="errorHead"><p class="erroricon"><s:text name="label.eas.common.error" /></p></div>
							<div class="errorContent">
							<p><s:actionerror/></p>
							</div>
					</div>
				</div>
			</div>
		</s:if>
		
		<div class="clear"></div>
		<jsp:include page="bgAndLocBidRequestSummary.jsp"/>	
		<div class="clear"></div>
		
	   <s:set name="isEditMode" value="editMode"/>
	   <div class="form-mod">
			<h2 id="transactionParties" class="section_flip">
				<a href="javascript:;"><s:text name="label.request.bglocSectionName.1"/></a>
			</h2><hr class="h2-hr">
			<div id="transactionPartiesPanel" class="section_panel">
				<jsp:include page="bgAndLocBidMemoSection.jsp">
					<jsp:param name="sectionId"  value="request.section.transactionParties" />
					<jsp:param name="includeScripts" value="false" />
				</jsp:include>
			</div>
		</div>
   
	    <div class="clear"></div>
	   <!-- Including Instrument Details  -->
	   <div class="form-mod" >
	   		<h2 id="instrumentDetails" class="section_flip">
				<a href="javascript:;"><s:text name="label.request.bglocSectionName.3"/></a>
			</h2><hr class="h2-hr">
			<div id="instrumentDetailsPanel" class="section_panel">
				  <jsp:include page="bgAndLocBidMemoSection.jsp">
						<jsp:param name="sectionId"  value="request.section.instrumentDetails" />
						<jsp:param name="includeScripts" value="false" />
						<jsp:param name="page" value="BGBidReply" />
					</jsp:include>
			</div>
	   </div>
	   
	    <div class="clear"></div>
	   <!-- Including Standby Letter of Credit Conditions  -->
	   <c:if test="${requestDetails.instrumentTypeId == 2 }">
		   <div class="form-mod" >
		   		<h2 id="locConditions" class="section_flip">
					<a href="javascript:;"><s:text name="label.request.bglocSectionName.5"/></a>
				</h2><hr class="h2-hr">
				<div id="locConditionsPanel" class="section_panel">
					<jsp:include page="bgAndLocBidMemoSection.jsp">
						<jsp:param name="sectionId"  value="request.section.standbyLetterofCredit" />
						<jsp:param name="includeScripts" value="false" />
				 	 </jsp:include>
				</div>
		   </div>
	   </c:if>
	   
	    <div class="clear"></div>
	   <!-- Including Format   -->
	   <div class="form-mod" id="formatDiv">
	   		<h2 id="formatSectionFlip" class="section_flip">
				<a href="javascript:;"><s:text name="label.request.bglocSectionName.7"/> 
					<span id="formatSelectionH2"></span>
				</a>
			</h2><hr class="h2-hr">
			<div id="formatSectionFlipPanel" class="section_panel">
			      <jsp:include page="bgAndLocBidMemoSection.jsp">
					<jsp:param name="sectionId"  value="request.section.format" />
					<jsp:param name="includeScripts" value="false" />
				  </jsp:include>
			</div>
	   </div>
	   
	   <div class="clear"></div>
		<!-- Audit Log and Transaction History  -->
		<jsp:include page="/jsp/common/request/auditAndTransactionHistoryLog.jsp"/>	            
	   
	    <div class="clear"></div>
	    
	    <c:if test="${requestDetails.issuingBankSelectionFlag eq 'Y'}">
		    <jsp:include page="/jsp/common/request/issuingBankSelection.jsp"/>   
		   <div class="clear"></div>
	   </c:if>	    
	   
	   <!-- Delivery Instructions -->
	   <div class="form-mod">
	   		<h2 id="deliveryInstructions" class="section_flip">
				<a href="javascript:;"><s:text name="label.request.bglocSectionName.8"/></a>
			</h2><hr class="h2-hr">
			<div id="deliveryInstructionsPanel" class="section_panel">
			      <jsp:include page="bgAndLocBidMemoSection.jsp">
					<jsp:param name="sectionId"  value="request.section.deliveryInstructions" />
					<jsp:param name="includeScripts" value="false" />
				  </jsp:include>
			</div>
	   </div>
	   
	   <div class="clear"></div>
	   
	 <s:form id="treasuryBidSubmitForm" >
	 
	 	   <div class="row smallrow">
       			<div class="span12">
  		   			<h3 class="dashdesc"><s:text name="label.request.comments" /></h3>
  		   			<hr class="page-title-hr">
           			<label><s:text name="label.request.commentsOptional" /></label>
					<s:textarea name="requestDetails.comments" theme="aloc" onkeypress="return imposeMaxLength(this, 399);"
					cssClass="autosize messageinput" id="tdcomments" required="false"/>
           			<div class="clear"></div>
           			<div class="counter"><s:text name="label.request.fourHundred"/></div> <!-- fix positions -->
           			<div class="counterTxt"><p class="guidance"><s:text name="label.request.textSize"/> <!--left (Limit is 400 characters) --></p></div>
       			</div>
   			</div> 
   				    
		   <jsp:include page="/jsp/common/request/bidAndIntumentDetails.jsp" >
		   	 	<jsp:param name="includeScripts" value="false" />
		   	 	<jsp:param name="suretyBond" value="true" />
		   </jsp:include>
		   
		   
		    <div class="clear"></div>
		    <jsp:include page="/jsp/common/request/bankSelectionDetails.jsp" >
		   	 	<jsp:param name="includeScripts" value="false" />
		   </jsp:include>
		   
		   <s:hidden name="requestId" id="requestId" value="%{requestDetails.requestId}"/>
	 </s:form>
	 </div>
	 <div id="fullHistoryDiv" style="width: 100%;"></div>
	</div>
	<%@include file="../../common/footerSection.jsp"%>
</body>
</html>
