<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    
    
	<%@include file="../includeRequestCommonScripts.jsp" %>
	<title><s:property value="requestDetails.instrumentType"/> - Create new Request</title>
	<link href="${pageContext.request.contextPath}/css/common/pagenavi.css" type="text/css" rel="stylesheet" />
	<script src="${pageContext.request.contextPath}/js/requestor/requestor.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/requestor/bgRequestor.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/requestor/addReference.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/common/toWord.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/requestor/fieldCounter.js" type="text/javascript"></script>
</head>

<body>
	
	<div class="container main">
		<jsp:include page="../headerSection.jsp">
			<jsp:param name="createReqPopup" value="Yes"></jsp:param>
		</jsp:include>
		<s:form id="transactionPartiesForm" name="bankGuaranteeForm">
		<s:hidden name="approver" value="wants" id="approver"/>
		<input type="hidden" name= "actionType" id="actionTypeId" />
		<div id="mainPage" style="width: 100%;">
		<h1 class="page-title span12">
		<s:text name="label.request.pageTitle"></s:text> <s:property value="requestDetails.instrumentType"/> </h1>
		<p class="span12 left clear dashdesc"><s:text name="label.request.pageDesc.1" /> <s:property value="requestDetails.instrumentType"/> <s:text name="label.request.pageDesc.2"/>
		</p>
		<hr class="page-title-hr">
		<div class="clear"></div>
		<jsp:include page="/jsp/common/request/bgRequestSummary.jsp"/>
		<s:hidden name="requestDetails.instrumentTypeId" value="%{requestDetails.instrumentTypeId}" id="instrumentTypeId"/>
		
   <s:set name="isEditMode" value="editMode"/>
   <div class="form-mod">
		<h2 id="transactionParties" class="section_flip section_blue">
			<a href="javascript:;"><s:text name="label.request.bglocSectionName.1"/></a>
		</h2>
		<hr class="h2-hr">
		<div id="transactionPartiesPanel" class="section_panel fieldcount_panel">
		  <div id="transactionPartiesSection">
			
				<jsp:include page="/jsp/common/request/transactionParties.jsp" />
				<input type="hidden" name= "sectionId" value="${param.sectionId}" />
		  </div>
		</div>
		
		<div class="highlighted span12" >
			<s:submit action="createDraftRequest" 
				key="label.request.saveAndContinue"
				cssClass="btn-secondary" 			
				indicator="transactionPartiesProcess1"
				onclick="javascript:submitAction(0);"	
				/>
			
			<s:submit action="createDraftRequest"
				key="label.request.saveAsDraft"
				cssClass="btn-secondary" 
				indicator="transactionPartiesProcess2"
				onclick="javascript:submitAction(1);"
				/>
			<s:url action="cancel.action" namespace="/int/requestor" var="cancelBtnlURL"/>
			<a href="#clearEntries" class="btn-tertiary cancel" data-toggle="modal"><s:text name="label.request.common.cancel"/></a> 
			<img alt="Loading..." id="transactionPartiesProcess1" src="${pageContext.request.contextPath}/img/loading.gif" class="indicator">
			<img alt="Loading..." id="transactionPartiesProcess2" src="${pageContext.request.contextPath}/img/loading.gif" class="indicator">
		</div>
		
    </div>	
  </div>
  
   <div id="lookupDiv" style="width: 100%;">		
	</div>
   <div class="clear"></div>
  </s:form>
</div>
<%@include  file="../footerSection.jsp" %>
<!-- EXIT REQUEST POPUP WINDOW -->
<div class="modal hide fade" id="clearEntries">
		<div class="modal-header">
			<a class="close" data-dismiss="modal">X</a>
			<h3><s:text name="label.request.clearEntries"/> <span></span></h3>
		</div>
		<div class="modal-body">
		<form>
		<p><b><s:text name="label.request.popUpMsg"/></b><br>
		<s:text name="label.request.popUpsubMsg"/>
		</p>
		</form>
		</div>
		<div class="modal-footer">
		    <a href="<s:property value="#cancelBtnlURL" />" class="btn left"><s:text name="label.request.popUpCancelYes"/></a>
			<a href="javascript:;" class="btn-tertiary left cancel" data-dismiss="modal"><s:text name="label.request.popUpCancelNo"/></a>
		</div>
</div> 

</body>
</html>