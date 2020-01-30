<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
 <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><s:text name="label.request.DocLoCConfirmationCreateNew" /></title>

<%@include file="../includeRequestCommonScripts.jsp" %>
<link href="${pageContext.request.contextPath}/css/common/pagenavi.css" type="text/css" rel="stylesheet" />
<script	src="${pageContext.request.contextPath}/js/requestor/requestor.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/requestor/dlocRequestor.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/requestor/fieldCounter.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/requestor/addBcpReference.js" type="text/javascript"></script>
</head>

<body>
	<div class="container main">
		<jsp:include page="../headerSection.jsp">
			<jsp:param name="createReqPopup" value="Yes"></jsp:param>
		</jsp:include>
        <s:form id="businessContactPersonForm" name="businessContactPersonForm">
        <input type="hidden" name="actionType" id="actionTypeId" />	
		<s:hidden name="approver" value="wants" />
		<div id="mainPage" style="width: 100%;">
			<h1 class="page-title span12">
				<s:label key=""></s:label>
				<s:text name="label.request.requestConfirmationDLOC" />
			</h1>
			<p class="span12 left clear dashdesc">
				<s:label key=""></s:label>
				<s:text name="label.request.useThisFormToRequestConfirmationDLOC" />
				<s:text name="label.request.creditIssuedInFavorOfGEBusiness" />
			</p>
			<hr class="page-title-hr">
			<jsp:include page="/jsp/common/request/dlocRequestSummary.jsp" />
			<s:set name="isEdit" value="editMode" />
			
			<div class="form-mod" id="businessContactPersonSectionId">
				<h2 id="businessContactPerson" class="section_flip section_blue">
					<a href="javascript:;"><s:text
							name="label.request.dlocbusinessContactPerson" /></a>
				</h2>
				<hr class="h2-hr">
				<div id="businessContactPersonPanel" class="section_panel fieldcount_panel">
					<div id="businessContactPersonSection">
						<jsp:include page="/jsp/common/request/businessContactPerson.jsp" />
					</div>
				</div>
				<div class="highlighted span12" >
					<s:submit action="createDraftRequest" 
					key="label.request.saveAndContinue"
					cssClass="btn-secondary" 			
					indicator="bondDetailsProcess1"
					onclick="javascript:submitAction(0);"	
					/>
				
				    <s:submit action="createDraftRequest"
					key="label.request.saveAsDraft"
					cssClass="btn-secondary" 
					indicator="bondDetailsProcess2"
					onclick="javascript:submitAction(1);"
					/>
					<s:url action="cancel.action" namespace="/int/requestor" var="cancelBtnlURL"/>
					<a href="#clearEntries" class="btn-tertiary cancel" data-toggle="modal"><s:text name="label.request.common.cancel"/></a> 
					<img alt="Loading..." id="bondDetailsProcess1" src="${pageContext.request.contextPath}/img/loading.gif" class="indicator">
					<img alt="Loading..." id="bondDetailsProcess2" src="${pageContext.request.contextPath}/img/loading.gif" class="indicator"> 
				</div>
			</div>
		</div>
		<div id="lookupDiv" style="width: 100%;"></div>
		</s:form>
	</div>
		<%@include file="../footerSection.jsp"%>
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