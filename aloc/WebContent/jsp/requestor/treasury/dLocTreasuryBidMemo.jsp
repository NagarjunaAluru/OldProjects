<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page import="org.apache.commons.lang.StringUtils" %>
<!DOCTYPE html>
<html>
<head>
 <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><s:text name="label.request.docLetterOfCreditBidMemo" /></title>

<%@include file="../../common/includeCommonScripts.jsp"%>

<script src="${pageContext.request.contextPath}/js/common/pagination.js"></script>
<link href="${pageContext.request.contextPath}/css/common/pagenavi.css" type="text/css" rel="stylesheet" />

<script src="${pageContext.request.contextPath}/js/requestor/bidMemo.js" type="text/javascript"></script>
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
		
		<h1 class="page-title span12"><s:text name="label.request.docLetterOfCreditBidMemo" /></h1>
		<p class="span12 left clear dashdesc"><s:text name="label.request.docLetterOfCreditDesc" /></p>
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
							<p><s:fielderror/></p>
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
		
		<div class="form-mod">
				<div class="row">
					<div class="span12 request-summary">
						<p class="heading"><strong><s:text name="label.request.requestSummary"/></strong> - <s:text name="label.request.alocRecNo"/>&nbsp;&nbsp;<strong><s:property value="requestDetails.alocRecordId"/></strong></p>
						
						<div class="row lastrow">
							<div class="span1ab"><div class="right"><label><s:text name="label.request.dlocCurrency" /></label></div></div>
							<div class="span5 left"><s:property value="requestDetails.transactionDetails.docLCCur"/></div>
						</div>
						
						<div class="row lastrow">
							<div class="span1ab"><div class="right"><label><s:text name="label.request.dlocAmount" /></label></div></div>
							<div class="span5 left"><s:property value="requestDetails.transactionDetails.docLCAmt"/></div>
						</div>	
						
						<div class="row">
							<div class="span1ab"><div class="right"><label><s:text name="label.request.bundleID"/>:</label></div></div>
							<div class="span5 left"><s:property value="requestDetails.bundleDetails.bundleId"/></div>
						</div>				
					</div>
				</div>
			</div><!-- end of form form-mod -->
	
	
	<s:set name="isEdit" value="editMode"/>
	<div class="form-mod" id="businessContactPersonSectionId">
		<h2 id="businessContactPerson" class="section_flip">
			<a href="javascript:;"><s:text name="label.request.dlocbusinessContactPerson"/></a>
		</h2><hr class="h2-hr">
		<div id="businessContactPersonPanel" class="section_panel">
			<jsp:include page="dLocBidMemoSection.jsp">
				<jsp:param name="sectionId"  value="request.section.businessContactPerson" />
				<jsp:param name="includeScripts" value="false" />
			</jsp:include>					
		</div>
	</div>
   
    <div class="clear"></div>
	   
	<div class="form-mod">
		<h2 id="issuingBank" class="section_flip">
			<a name="second" href="javascript:;"><s:text name="label.request.issuingBank"/></a>
		</h2><hr class="h2-hr">
		<div id="issuingBankPanel" class="section_panel">
			<jsp:include page="dLocBidMemoSection.jsp">
				<jsp:param name="sectionId"  value="request.section.issuingBank" />
				<jsp:param name="includeScripts" value="false" />
			</jsp:include>	
		</div>
	</div>
	   
	<div class="clear"></div>
		
	<div class="form-mod">
		<h2 id="applicant" class="section_flip">
			<a href="javascript:;"><s:text name="label.request.applicant"/></a>
		</h2><hr class="h2-hr">
		<div id="applicantPanel" class="section_panel">
			<jsp:include page="dLocBidMemoSection.jsp">
				<jsp:param name="sectionId"  value="request.section.applicant" />
				<jsp:param name="includeScripts" value="false" />
				<jsp:param name="page" value="BidReply" />
			</jsp:include>					
		</div>
	</div>			
						
	<div class="clear"></div>
			
	<div class="form-mod">
		<h2 id="beneficiary" class="section_flip">
			<a href="javascript:;"><s:text name="label.request.beneficiary"/></a>
		</h2><hr class="h2-hr">
		<div id="beneficiaryPanel" class="section_panel">			
			<jsp:include page="dLocBidMemoSection.jsp">
				<jsp:param name="sectionId"  value="request.section.beneficiary" />
				<jsp:param name="includeScripts" value="false" />
			</jsp:include>					
		</div>
	</div>	
								
	<div class="clear"></div>
			
	<div class="form-mod">
		<h2 id="instrumentTransactionDetails" class="section_flip">
			<a href="javascript:;"><s:text name="label.request.instrumentTransactionDetails"/></a>
		</h2><hr class="h2-hr">
		<div id="instrumentTransactionDetailsPanel" class="section_panel">
			<jsp:include page="dLocBidMemoSection.jsp">
				<jsp:param name="sectionId"  value="request.section.instrumentTransactionDetails" />
				<jsp:param name="includeScripts" value="false" />
			</jsp:include>					
		</div>
	</div>			
	
	<div class="clear"></div>

	<div class="form-mod">
		<h2 id="paymentSchedule" class="section_flip">
			<a href="javascript:;"><s:text name="label.request.paymentSchedule"/></a>
		</h2><hr class="h2-hr">
		<div id="paymentSchedulePanel" class="section_panel">
			<jsp:include page="dLocBidMemoSection.jsp">
				<jsp:param name="sectionId"  value="request.section.paymentSchedule" />
				<jsp:param name="includeScripts" value="false" />
			</jsp:include>					
		</div>
	</div>
	
	<div class="clear"></div>
	
	<!-- Including Format   -->
	<div class="form-mod" id="formatDiv">
		<h2 id="format" class="section_flip">
			<a href="javascript:;"><s:text name="label.request.bglocSectionName.7"/> 
				<span id="formatSelectionH2"></span>
			</a>
		</h2><hr class="h2-hr">
		<div id="formatPanel" class="section_panel">
			<jsp:include page="dLocBidMemoSection.jsp">
				<jsp:param name="sectionId"  value="request.section.format" />
				<jsp:param name="includeScripts" value="false" />
			</jsp:include>					
		</div>
	</div>
	
	<div class="clear"></div>
	
	<!-- Including Attachments   -->
	<div class="form-mod" id="attachmentsDiv">
		<h2 id="attachments" class="section_flip">
			<a href="javascript:;"><s:text name="label.request.bglocSectionName.9"/></a>
		</h2><hr class="h2-hr">
		<div id="attachmentsPanel" class="section_panel">
			<jsp:include page="dLocBidMemoSection.jsp">
				<jsp:param name="sectionId"  value="request.section.attachments" />
				<jsp:param name="includeScripts" value="false" />
			</jsp:include>					
		</div>
	</div>
	   
	<div class="clear"></div>
	<!-- Audit Log and Transaction History  -->
	<jsp:include page="/jsp/common/request/auditAndTransactionHistoryLog.jsp"/>	            
	
	<div class="clear"></div>
	
	<s:form id="dLocSubmitForm" namespace="/int/approver" >
		<s:hidden name="requestId" id="requestId" value="%{requestDetails.requestId}"/>
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
   			
		<!-- Bid Memo Details -->
		<div class="form-mod">
			<jsp:include page="/jsp/common/request/dLocBidMemoDetails.jsp" >
				<jsp:param name="includeScripts" value="false" />
			</jsp:include>
		 </div>
		
		<div class="clear"></div>
		<jsp:include page="/jsp/common/request/bankSelectionDetails.jsp" >
			<jsp:param name="includeScripts" value="false" />
		</jsp:include>
	</s:form>
	 
	 <div class="clear"></div>
	
	</div>
	 <div id="fullHistoryDiv" style="width: 100%;"></div>
	</div>
	<%@include file="../../common/footerSection.jsp"%>
</body>
</html>
