<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
 <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><s:text name="label.request.suretyBondCreateContractBond"/></title>

<%@include file="../includeRequestCommonScripts.jsp" %>
<script src="${pageContext.request.contextPath}/js/requestor/requestor.js" type="text/javascript"></script>
<script	src="${pageContext.request.contextPath}/js/requestor/suretyRequestor.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/requestor/fieldCounter.js" type="text/javascript"></script>
</head>
<body>
	<div class="container main" id="mainDiv">
		<jsp:include page="../../common/headerSection.jsp">
			<jsp:param name="createReqPopup" value="Yes"></jsp:param>
		</jsp:include>
		<div id="mainPage">
		<s:form name="suretyBondDetailsForm" id="bondDetailsForm" >
			<s:hidden name="requestId" value="%{requestDetails.requestId}"/>
			<input type="hidden" name="actionType" id="actionTypeId" />			
				<h1 class="page-title span12">
					<s:text name="label.request.requestSuretyBond" />
				</h1>
				<p class="span12 left clear dashdesc">
					<s:text name="label.optionalSentence.requestSuretyBond" />
				</p>
				<hr class="page-title-hr">
				<div class="clear"></div>
				<div class="form-mod">
					<!-- REQUEST SUMMARY -->
					<div id="requestSummary">
						<div class="leftColRS">
							<p>
								<strong><s:text name="label.request.requestSummary" /></strong>
								-
								<s:text name="label.request.alocRecNo" />
								<strong> <s:property value="requestDetails.alocRecordId" /></strong>
							</p>
						</div>
						<div class="clear"></div>

						<div class="singleBoxRS">
							<div class="row smallrow">
								<div class="span2">
									<label><s:text name="label.request.requestor" /></label>
									<s:property
										value="requestDetails.requestSummary.requestor.lastName" />
									,
									<s:property
										value="requestDetails.requestSummary.requestor.firstName" />
									<br>
									<s:property
										value="requestDetails.requestSummary.requestor.ssoId" />
									<br>
								</div>
							</div>
						</div>
						<!-- leftBox ends here -->

						<s:if test="%{requestDetails.requestId != null}">
							<div class="singleBoxRS">
								<div class="row smallrow">
									<div class="span2">
										<label><s:text name="label.request.alocRecNo" /></label>
										<s:property value="requestDetails.alocRecordId" />
									</div>
								</div>
							</div>
							<!-- midBox ends here -->
						</s:if>
						<div class="clear"></div>
					</div>
					<!-- requestSummary ends here -->
				</div>
				<!-- end of form form-mod -->

				<div class="form-mod " id="bondDetailsSectionId">
					<h2 id="bondDetails" class="section_flip section_blue">
						<a href="javascript:;"><s:text	name="label.request.bondType" />
						<span class="ttip info"
							data-original-title="<s:text name="label.request.tooltip.bondDetails"/>"></span>
						</a>
					</h2>
					<hr class="h2-hr">
					<div id="bondDetailsPanel" class="section_panel fieldcount_panel">
						<jsp:include page="/jsp/common/request/bondDetails.jsp" />
						<br>
					</div>	
					<div class="highlighted span12">
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
				
				<!-- <div class="highlighted" style="padding-top: 20px; height:40px;"> -->
					</div>
						
				
				</div>
		</s:form>
		</div>
		
		<div id="lookupDiv" style="width: 100%;">
		</div>
	</div>		
		<%@include file="../../common/footerSection.jsp"%>
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