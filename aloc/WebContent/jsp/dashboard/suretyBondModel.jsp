<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
 <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><s:property value="requestDetails.instrumentType"/> - Edit Model</title>

<%@include file="../common/includeCommonScripts.jsp"%>

<link href="${pageContext.request.contextPath}/css/common/pagenavi.css" type="text/css" rel="stylesheet" />
<link type="text/css" href="${pageContext.request.contextPath}/css/others/ui.multiselect.css" rel="stylesheet" />
<script src="${pageContext.request.contextPath}/js/requestor/requestor.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/requestor/suretyRequestor.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/common/toWord.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/requestor/addReference.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/requestor/fieldCounter.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/common/pagination.js"></script>
<script type="text/javascript">
		$(document).ready(function() {
			jQuery('#saveAndSubmitForm').preventDoubleSubmit();
	});
</script> 
</head>

<body>
	<div class="container main">
		<jsp:include page="../common/headerSection.jsp">
			<jsp:param name="createReqPopup" value="Yes"></jsp:param>
		</jsp:include>
		<div id="mainPage">
		<h1 class="page-title span12">
		<s:property value="requestDetails.instrumentType"/> <s:text name="label.model.pageTitle"></s:text></h1>
		<p class="span12 left clear dashdesc">
			<s:label  key="label.model.pageDesc"/>
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
	</div>
	<s:form id="saveAndSubmitForm" namespace="/int/requestor" action="saveModel">	
	<jsp:include page="/jsp/common/request/siteSelection.jsp" />	
			<s:set name="isEdit" value="editMode"/>
			<div class="form-mod" id="bondDetailsSectionId">
				<h2 id="bondDetails" class="section_flip section_blue">
					<a href="javascript:;"><s:text name="label.request.sbSectionBondDetails"/><span class="ttip info" data-original-title="<s:text name="label.request.tooltip.bondDetails"/>"></span>
					</a>
				</h2><hr class="h2-hr">
				<div id="bondDetailsPanel" class="section_panel fieldcount_panel">

						<jsp:include page="suretyBondModelSection.jsp">
							<jsp:param name="sectionId"  value="request.section.bondDetails" />
							<jsp:param name="includeScripts" value="false" />
						</jsp:include>					
				</div>
			</div>				
			<div class="clear"></div>
			
			<div class="form-mod">
				<h2 id="requestorMailingAddress" class="section_flip">
				<a href="javascript:;"><s:text name="label.request.sbSectionRequestorMailingAddress"/><span class="ttip info" data-original-title="<s:text name="label.request.tooltip.requestorMailingAddress"/>"></span>
				</a></h2><hr class="h2-hr">
				<div id="requestorMailingAddressPanel" class="section_panel fieldcount_panel">
						<jsp:include page="suretyBondModelSection.jsp">
							<jsp:param name="sectionId"  value="request.section.requestorMailingAddress" />
							<jsp:param name="includeScripts" value="false" />
						</jsp:include>					
													
				</div>
			</div>			
			<div class="clear"></div>

			<div class="form-mod">
				<h2 id="deliveryInstructions" class="section_flip">
				<a href="javascript:;"><s:text name="label.request.sbSectionDeliveryInstructions"/></a></h2><hr class="h2-hr">
				<div id="deliveryInstructionsPanel" class="section_panel fieldcount_panel">
						<jsp:include page="suretyBondModelSection.jsp">
							<jsp:param name="sectionId"  value="request.section.deliveryInstructions" />
							<jsp:param name="includeScripts" value="false" />
						</jsp:include>					
				</div>
			</div>
			<div class="clear"></div>
			
			<div id="bondInfoDiv1">
					<jsp:include page="suretyBondModelSection.jsp">
							<jsp:param name="sectionId"  value="request.section.bondInformation" />
							<jsp:param name="saveAndNextSectionButtonKey" value="key" />
							<jsp:param name="includeScripts" value="false" />
					</jsp:include>
			</div>			
			
			<div class="clear"></div>
		   
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
		<div class="clear"></div>
		<%@include file="../common/footerSection.jsp"%>
	</div>
</body>

<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/jquery-ui-1.8.custom.min.js"></script> --%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/jquery.tmpl.1.1.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/jquery.blockUI.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/ui.multiselect.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/others/siteSel.js"></script>
</html>