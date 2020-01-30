<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    
    
	<%@include file="../../common/includeRequestCommonScripts.jsp" %>
	<title><s:property value="requestDetails.instrumentType"/> - Review Request</title>
	<link href="${pageContext.request.contextPath}/css/common/pagenavi.css" type="text/css" rel="stylesheet" />
	<script src="${pageContext.request.contextPath}/js/requestor/requestor.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/requestor/bgRequestor.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/requestor/lookup.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/requestor/addReference.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/common/toWord.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/requestor/fieldCounter.js" type="text/javascript"></script>
	
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/others/jquery.dropdown.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/others/jquery.dropdown.js"></script>
</head>

<body>
	
	<div class="container main">
		<jsp:include page="../../common/headerSection.jsp">
			<jsp:param name="createReqPopup" value="Yes"></jsp:param>
		</jsp:include>
		<div id="mainPage" style="width: 100%;">
		<h1 class="page-title span12">
		<s:text name="label.request.pageTitle"></s:text> <s:property value="requestDetails.instrumentType"/> </h1>
		<p class="span12 left clear dashdesc"><s:text name="label.request.pageDesc.1" /> <s:property value="requestDetails.instrumentType"/> <s:text name="label.request.pageDesc.2"/>
		</p>
		<hr class="page-title-hr">
		<s:hidden name="validationSuccess" id="validationSuccessId"/>
		<s:hidden name="errorMsg" id="serviceErrorMsgId"/>
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
			<s:if test="fieldErrors.size == 0">
			<div class="row">
				<div class="span12">
					<div class="errorbox">
						<div class="noteHead">
							<p class="noteicon">
								<s:text name="label.common.alert" />
							</p>
						</div>
						<div class="noteContent">
							<p><s:text name="label.request.formatAndattachmentAlert"/></p><br>							
						</div>
					</div>
				</div>
			</div>
			</s:if>
		
	 <!-- REQUEST SUMMARY -->
		<jsp:include page="/jsp/common/request/bgRequestSummary.jsp"/>
   
   <s:hidden name="formatOpen" value="yes" id="formatOpen"/>
   <!-- Including Transaction Parties  -->
   <s:set name="isEditMode" value="editMode"/>
   <div class="form-mod">
		<h2 id="transactionParties" class="section_flip section_blue">
			<a href="javascript:;"><s:text name="label.request.bglocSectionName.1"/></a>
		</h2>
		<hr class="h2-hr">
		<div id="transactionPartiesPanel" class="section_panel fieldcount_panel">
		  
			<jsp:include page="bgReviewRequestSection.jsp">
				<jsp:param name="sectionId"  value="request.section.transactionParties" />
				<jsp:param name="saveAndNextSectionButtonKey" value="key" />
				<jsp:param name="includeScripts" value="false" />
			</jsp:include>					
    	 
		</div>
	</div>
   
   <div class="clear"></div>
   
   <!-- Including Project Description  -->
   <div class="form-mod" id="projectDescDiv">
   		<h2 id="projectDescription" class="section_flip">
			<a href="javascript:;"><s:text name="label.request.bglocSectionName.2"/></a>
		</h2>
		<hr class="h2-hr">
		<div id="projectDescriptionPanel" class="section_panel fieldcount_panel">
		     <jsp:include page="bgReviewRequestSection.jsp">
				<jsp:param name="sectionId"  value="request.section.projectDescription" />
				<jsp:param name="saveAndNextSectionButtonKey" value="key" />
				<jsp:param name="includeScripts" value="false" />
			</jsp:include>
		 
		</div>
   </div>
   
   
   <!-- Including Instrument Details  -->
   <div class="form-mod" >
   		<h2 id="instrumentDetails" class="section_flip">
			<a href="javascript:;"><s:text name="label.request.bglocSectionName.3"/></a>
		</h2>
		<hr class="h2-hr">
		<div id="instrumentDetailsPanel" class="section_panel fieldcount_panel">
			  <jsp:include page="bgReviewRequestSection.jsp">
					<jsp:param name="sectionId"  value="request.section.instrumentDetails" />
					<jsp:param name="saveAndNextSectionButtonKey" value="key" />
					<jsp:param name="includeScripts" value="false" />
				</jsp:include>
		</div>
   </div>
   
   <!-- Including Instrument Risk  -->
   <div class="form-mod" >
   		<h2 id="instrumentRisk" class="section_flip">
			<a href="javascript:;"><s:text name="label.request.bglocSectionName.4"/></a>
		</h2>
		<hr class="h2-hr">
		<div id="instrumentRiskPanel" class="section_panel fieldcount_panel">
		     <jsp:include page="bgReviewRequestSection.jsp">
				<jsp:param name="sectionId"  value="request.section.instrumentRisk" />
				<jsp:param name="saveAndNextSectionButtonKey" value="key" />
				<jsp:param name="includeScripts" value="false" />
			</jsp:include>
			
		</div>
   </div>
   
   <!-- Including Standby Letter of Credit Conditions  -->
   <c:if test="${requestDetails.instrumentType eq 'Standby Letter Of Credit'}">
   <div class="form-mod" >
   		<h2 id="locConditions" class="section_flip">
			<a href="javascript:;"><s:text name="label.request.bglocSectionName.5"/></a>
		</h2>
		<hr class="h2-hr">
		<div id="locConditionsPanel" class="section_panel fieldcount_panel">
		      <jsp:include page="bgReviewRequestSection.jsp">
				<jsp:param name="sectionId"  value="request.section.standbyLetterofCredit" />
				<jsp:param name="saveAndNextSectionButtonKey" value="key" />
				<jsp:param name="includeScripts" value="false" />
			  </jsp:include>
			
		</div>
   </div>
   </c:if>
    <!-- Including Instrument Reporting Attributes  -->
   <div class="form-mod" >
   		<h2 id="instrumentReporting" class="section_flip">
			<a href="javascript:;"><s:text name="label.request.bglocSectionName.6"/></a>
		</h2>
		<hr class="h2-hr">
		<div id="instrumentReportingPanel" class="section_panel fieldcount_panel">
		      <jsp:include page="bgReviewRequestSection.jsp">
				<jsp:param name="sectionId"  value="request.section.instrumentReporting" />
				<jsp:param name="saveAndNextSectionButtonKey" value="key" />
				<jsp:param name="includeScripts" value="false" />
			  </jsp:include>
			
		</div>
   </div>		
      <!-- Delivery Instructions -->
   <div class="form-mod">
   		<h2 id="deliveryInstructions" class="section_flip">
			<a href="javascript:;"><s:text name="label.request.bglocSectionName.8"/></a>
		</h2>
		<hr class="h2-hr">
		<div id="deliveryInstructionsPanel" class="section_panel fieldcount_panel">
		      <jsp:include page="bgReviewRequestSection.jsp">
				<jsp:param name="sectionId"  value="request.section.deliveryInstructions" />
				<jsp:param name="saveAndNextSectionButtonKey" value="key" />
				<jsp:param name="includeScripts" value="false" />
			  </jsp:include>
		</div>
   </div>
   
  <!-- Including Format   -->
   <s:form id="reviewAndSubmitFormID" action="submit.action" namespace="/int/requestor/review">
   			<s:hidden name="requestDetails.instrumentTypeId" id="instrumentTypeId" />
			<s:hidden name="requestDetails.WFDetails.WFStage" id="WFStage" />
			<s:hidden name="requestId" value="%{requestDetails.requestId}" id="requestId"/>
   <div class="form-mod" id="formatDiv">
   		<h2 id="format" class="section_flip">
			<a href="javascript:;"><s:text name="label.request.bglocSectionName.7"/>
				<span id="formatSelectionH2"></span>
			</a>
		</h2>
		<hr class="h2-hr">
		<div id="formatPanel" class="section_panel">
		      <jsp:include page="bgReviewRequestSection.jsp">
				<jsp:param name="sectionId"  value="request.section.format" />
				<jsp:param name="saveAndNextSectionButtonKey" value="key" />
				<jsp:param name="includeScripts" value="false" />
			  </jsp:include>
			
		</div>
   </div>

  <!--  Including Attachments   -->
 
   <div class="form-mod" id="attachmentsDiv">
   		<h2 id="attachments" class="section_flip">
			<a href="javascript:;"><s:text name="label.request.bglocSectionName.9"/></a>
		</h2>
		<hr class="h2-hr">
		<div id="attachmentsPanel" class="section_panel">
			    <jsp:include page="bgReviewRequestSection.jsp">
					<jsp:param name="sectionId"  value="request.section.attachments" />
					<jsp:param name="saveAndNextSectionButtonKey" value="key" />
					<jsp:param name="includeScripts" value="false" />
				</jsp:include>
		</div>
   </div>	
   <div class="clear"></div>		
   <!-- Include Submit Section -->		
		   <div class="highlighted">
				<jsp:include page="/jsp/requestor/saveAndSubmit.jsp">
					<jsp:param value="${actionType}" name="actionType"/>
				</jsp:include>		
		   </div>				
   		</s:form>
		</div>
	<div id="lookupDiv" style="width: 100%;">
		
	</div>
	
</div>	
<%@include  file="../../common/footerSection.jsp" %>


</body>
</html>