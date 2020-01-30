<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    
	<%@include file="../common/includeCommonScripts.jsp" %>
	<title><s:property value="requestDetails.instrumentType"/> - Edit Model</title>
	<link href="${pageContext.request.contextPath}/css/common/pagenavi.css" type="text/css" rel="stylesheet" />
	<script src="${pageContext.request.contextPath}/js/requestor/requestor.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/requestor/bgRequestor.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/requestor/addReference.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/common/toWord.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/requestor/fieldCounter.js" type="text/javascript"></script>
	
	<link type="text/css" href="${pageContext.request.contextPath}/css/others/jquery-ui-1.7.1.custom.css" rel="stylesheet" />
	<link type="text/css" href="${pageContext.request.contextPath}/css/others/ui.multiselect.css" rel="stylesheet" />
	<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/jquery-ui-1.8.custom.min.js"></script> --%>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/jquery.localisation-min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/jquery.tmpl.1.1.1.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/jquery.blockUI.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/ui.multiselect.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/others/siteSel.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			jQuery('#saveAndSubmitForm').preventDoubleSubmit();
	});
    </script> 
</head>
<s:url action="cancel.action" namespace="/int/requestor" var="cancelBtnlURL"/>
<s:url action="saveModel" namespace="/int/requestor" var="saveModelURL" />
<body>
	<div class="container main">
		<jsp:include page="../common/headerSection.jsp">
			<jsp:param name="createReqPopup" value="Yes"></jsp:param>
		</jsp:include>
		<div id="mainPage">
		<h1 class="page-title span12">
		<s:property value="requestDetails.instrumentType"/> <s:text name="label.model.pageTitle"></s:text></h1>
		<p class="span12 left clear dashdesc"><s:text name="label.model.pageDesc" /> 
		</p>
		<hr class="page-title-hr">
	<div class="form-mod">
		<div class="row graybg lastrow" style="margin-left: -10px;">
			<div class="span12">
				<h2 class="summary span12"><s:text name="label.model.modelSummary"/> </h2><hr class="h2-hr">
				<div class="clear"></div>
				<div class="row">
					<div class="span12 whitebg">
						<div class="span5" style="margin-left: 10px!important;">
							<div class="marginT">
								<s:label key="label.request.requestor"/>
								<p><s:property value="requestDetails.requestSummary.requestor.lastName"/>, <s:property value="requestDetails.requestSummary.requestor.firstName"/></p>
								<p><s:property value="requestDetails.requestSummary.requestor.ssoId"/></p>
							</div>
						</div> 
						<div class="span3">
							<div class="marginT">
								<s:label key="label.model.modelName"/>
								<p><s:property value="requestDetails.modelName"/></p>
							</div>
						</div> 						
					</div>
				</div>
			</div>
		</div>
	</div><!-- end of form form-mod -->
   
   <!-- Including Transaction Parties  -->
   <s:form id="saveAndSubmitForm" namespace="/int/requestor" action="saveModel">	
   <s:set name="isEditMode" value="editMode"/>
   <div class="form-mod">
		<h2 id="transactionParties" class="section_flip section_blue">
			<a href="javascript:;"><s:text name="label.request.bglocSectionName.1"/></a>
		</h2><hr class="h2-hr">
		<div id="transactionPartiesPanel" class="section_panel fieldcount_panel">
			<jsp:include page="bgAndLocModelSection.jsp">
				<jsp:param name="sectionId"  value="request.section.transactionParties" />
				<jsp:param name="modelSection"  value="model" />
				<jsp:param name="includeScripts" value="false" />
			</jsp:include>					
    	 
		</div>
	</div>
   
   <div class="clear"></div>
   
   <!-- Including Project Description  -->
   <div class="form-mod" id="projectDescDiv">
   		<h2 id="projectDescription" class="section_flip">
			<a href="javascript:;"><s:text name="label.request.bglocSectionName.2"/></a>
		</h2><hr class="h2-hr">
		<div id="projectDescriptionPanel" class="section_panel fieldcount_panel">
		     <jsp:include page="bgAndLocModelSection.jsp">
				<jsp:param name="sectionId"  value="request.section.projectDescription" />
				<jsp:param name="includeScripts" value="false" />
			</jsp:include>
		 
		</div>
   </div>
   
   
   <!-- Including Instrument Details  -->
   <div class="form-mod" >
   		<h2 id="instrumentDetails" class="section_flip">
			<a href="javascript:;"><s:text name="label.request.bglocSectionName.3"/></a>
		</h2><hr class="h2-hr">
		<div id="instrumentDetailsPanel" class="section_panel fieldcount_panel">
			  <jsp:include page="bgAndLocModelSection.jsp">
					<jsp:param name="sectionId"  value="request.section.instrumentDetails" />
					<jsp:param name="includeScripts" value="false" />
				</jsp:include>
		</div>
   </div>
   
   <!-- Including Instrument Risk  -->
   <div class="form-mod" >
   		<h2 id="instrumentRisk" class="section_flip">
			<a href="javascript:;"><s:text name="label.request.bglocSectionName.4"/></a>
		</h2><hr class="h2-hr">
		<div id="instrumentRiskPanel" class="section_panel fieldcount_panel">
		     <jsp:include page="bgAndLocModelSection.jsp">
				<jsp:param name="sectionId"  value="request.section.instrumentRisk" />
				<jsp:param name="includeScripts" value="false" />
			</jsp:include>
			
		</div>
   </div>
   
   <!-- Including Standby Letter of Credit Conditions  -->
   <c:if test="${requestDetails.instrumentType eq 'Standby Letter Of Credit'}">
   <div class="form-mod" >
   		<h2 id="locConditions" class="section_flip">
			<a href="javascript:;"><s:text name="label.request.bglocSectionName.5"/></a>
		</h2><hr class="h2-hr">
		<div id="locConditionsPanel" class="section_panel fieldcount_panel">
		      <jsp:include page="bgAndLocModelSection.jsp">
				<jsp:param name="sectionId"  value="request.section.standbyLetterofCredit" />
				<jsp:param name="includeScripts" value="false" />
			  </jsp:include>
			
		</div>
   </div>
   </c:if>
    <!-- Including Instrument Reporting Attributes  -->
   <div class="form-mod" >
   		<h2 id="instrumentReporting" class="section_flip">
			<a href="javascript:;"><s:text name="label.request.bglocSectionName.6"/></a>
		</h2><hr class="h2-hr">
		<div id="instrumentReportingPanel" class="section_panel fieldcount_panel">
		      <jsp:include page="bgAndLocModelSection.jsp">
				<jsp:param name="sectionId"  value="request.section.instrumentReporting" />
				<jsp:param name="includeScripts" value="false" />
			  </jsp:include>
			
		</div>
   </div>		
   
   <!-- Delivery Instructions -->
   <div class="form-mod">
   		<h2 id="deliveryInstructions" class="section_flip">
			<a href="javascript:;"><s:text name="label.request.bglocSectionName.8"/></a>
		</h2><hr class="h2-hr">
		<div id="deliveryInstructionsPanel" class="section_panel fieldcount_panel">
		      <jsp:include page="bgAndLocModelSection.jsp">
				<jsp:param name="sectionId"  value="request.section.deliveryInstructions" />
				<jsp:param name="includeScripts" value="false" />
			  </jsp:include>
			
		</div>
   </div>

   <!-- Include Submit Section -->	
   <div class="form-mod" id="submitDiv">
		<div class="row">
		<div class="span12">
			<div class="form-row">
				<s:submit 
					key="label.model.saveModel"
					cssClass="btn-primary"
				/>
				<s:url id="homePageURL" action="cancelModel" namespace="/int/requestor" />
				<s:a href="%{homePageURL}"
					cssClass="btn-tertiary cancel" >
				<s:text name="label.request.common.cancel"/>
				</s:a>
			</div>
		</div>
	</div>
   </div>	
   </s:form>			
		</div>
	<div id="lookupDiv" style="width: 100%;">
	</div>
</div>	
<%@include  file="../common/footerSection.jsp" %>
</body>
</html>