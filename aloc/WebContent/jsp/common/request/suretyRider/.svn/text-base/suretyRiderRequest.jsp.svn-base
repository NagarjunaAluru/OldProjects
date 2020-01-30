<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
 <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><c:if test="${requestDetails.WFDetails.WFStage ne 'REQEST'}">
		<s:text name="label.request.createSuretyRider" />
	</c:if>
	<c:if test="${requestDetails.WFDetails.WFStage eq 'REQEST'}">
		<s:text name="label.returnedRider.pageTitleHeader" />
	</c:if></title>
<%@include file="../../../common/includeCommonScripts.jsp"%>
<link href="${pageContext.request.contextPath}/css/common/pagenavi.css" type="text/css" rel="stylesheet" />
<script src="${pageContext.request.contextPath}/js/requestor/requestor.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/requestor/lookup.js" type="text/javascript"></script> 
<script src="${pageContext.request.contextPath}/js/common/toWord.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/common/rider.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/common/pagination.js"></script>
</head>

<body>

	<div class="container main">
		<%@include file="../../../common/headerSection.jsp"%>
		<s:form id="suretyRiderFormId" name="suretyRiderForm" action="submitSuretyRider">
		<s:hidden name="requestDetails.bondDetails.bondTypeId" id="bondTypeId" value="%{requestDetails.bondDetails.bondTypeId}"/>
		<%-- <s:hidden name="validationSuccess" id="validationSuccessId"/> --%>
		<s:hidden name="requestDetails.instrumentTypeId" id="instrumentTypeId" />
		<s:hidden name="requestDetails.requestId" id="requestId" />
		<s:hidden name="requestDetails.WFDetails.WFStage" id="WFStage" />
		<s:hidden name="amendmentOrRiderRequestId" value="%{requestDetails.rider.riderRequestId}" id="AmendmentOrRiderId"/>
		<c:set var="workFlowStage" value="${requestDetails.WFDetails.WFStage}"></c:set>
		<div id="mainPage" style="width: 100%;">
		<c:if test="${workFlowStage ne 'REQEST'}">
			<h1 class="page-title span12">
				<s:text name="label.request.createSuretyRider"/>
			</h1>
			<p class="span12 left clear dashdesc">
				<s:text name="label.request.riderTitleDesc" />
			</p>
			<hr class="page-title-hr">
		</c:if>
		<c:if test="${workFlowStage eq 'REQEST'}">
		<h1 class="page-title span12">
				<s:text name="label.returnedRider.pageTitleHeader"/>
			</h1>
			<p class="span12 left clear dashdesc">
				<s:text name="label.request.line1"/><s:text name="label.request.line2"/><s:text name="label.request.line3"/>
			</p>
			<hr class="page-title-hr">
		</c:if>
				<div class="clear"></div>
				<s:hidden name="validationSuccess" id="validationRiderId" />
				<div class="row hide" id="pageLevelErrorDivId">
					<div class="span12">
						<div class="errorbox">
							<div class="errorHead">
								<p class="erroricon">Error</p>
							</div>
							<div class="errorContent">
								<p>
									<s:fielderror />
								</p>
								<p>&nbsp;</p>
							</div>
						</div>
					</div>
				</div>
				<s:hidden name="showRider" value="%{actionType}" id="showRider"/>
				<c:if test="${workFlowStage ne 'REQEST'}">
				<div class="form-mod">				
					<jsp:include page="../../../common/request/sbRequestSummary.jsp"/>
				</div>
				</c:if>
				<c:if test="${workFlowStage eq 'REQEST'}">
				<div class="form-mod">		
					<div class="row">
						<div class="span12 request-summary">
						<div class="row lastrow">
							<div class="span8"><p class="heading"><b><s:text name="label.request.requestSummary" /></b> - <span><s:text name="label.request.AlocRecordNo"/></span>
							<b><c:out value="${requestDetails.alocRecordId}"/></b></p></div>
				        	<s:if test="%{requestDetails.modelId !=null}">
								<div class="span2a"><div class="right"><label><s:text name="label.request.modelCode" />:</label></div></div>
								<div class="span1 left"><s:property value="requestDetails.modelId" /></div>
							</s:if>
						</div>
							<div class="row lastrow">
								<div class="span22"><div class="right"><s:label key="label.request.requestorName"/></div></div>
								<div class="span3 left"><s:property value="requestDetails.requestSummary.requestor.lastName" />, <s:property value="requestDetails.requestSummary.requestor.firstName" /></div>
								<div class="span3a"><div class="right"><label><s:text name="label.request.riderSequenceNumber"/> :</label></div></div>
								<div class="span2 left"><s:property value="requestDetails.rider.riderRequestId" /></div>
							</div>
							<div class="row lastrow">
								<div class="span22"><div class="right"><s:label key="label.request.requestorSSO"/></div></div>
								<div class="span3 left"><s:property value="requestDetails.requestSummary.requestor.ssoId" /></div>
							</div>
							<div class="row">
								<div class="span22"><div class="right"><label><s:text name="label.request.returnedBy"/>:</label></div></div>
								<div class="span4 left"><s:property value="requestDetails.actionLogs[0].approverLastName" />, <s:property value="requestDetails.actionLogs[0].approverFirstName" /></div>
								<div class="span2a"><div class="right"><label><s:text name="label.request.reasonForReturn"/>:</label></div></div>
								<div class="span3 left" style="word-wrap:break-word;"><s:property value="requestDetails.actionLogs[0].reasonForRejection" /></div>
							</div>				
						</div>
					</div>
				</div>
				</c:if>			
			<s:set name="isEdit" value="editMode"/>			
			<div class="form-mod">
				<h2 id="principal" class="section_flip">
				<a href="javascript:;"><s:text name="label.request.sbSectionPrincipal"/></a></h2><hr class="h2-hr">
				<div id="principalPanel" class="section_panel">
						<jsp:include page="suretyRiderRequestSection.jsp">
							<jsp:param name="sectionId"  value="request.section.riderPrincipal" />
							<jsp:param name="includeScripts" value="false" />
						</jsp:include>					
				</div>
			</div>	
			<div class="clear"></div>			
			<div class="form-mod">
				<h2 id="obligee" class="section_flip">
					<a href="javascript:;"><s:text name="label.request.sbSectionObligee"/> </a>
				</h2><hr class="h2-hr">
				<div id="obligeePanel" class="section_panel">
					
						<jsp:include page="suretyRiderRequestSection.jsp">
							<jsp:param name="sectionId"  value="request.section.riderObligee" />
							<jsp:param name="includeScripts" value="false" />
						</jsp:include>					
											
				</div>
			</div>			
						
			<div class="clear"></div>
			
			<!-- Including Expiration Dates -->
			<div class="form-mod">
				<h2 id="expirationDates" class="section_flip section_blue">
					<a href="javascript:;">
						<s:text	name="label.request.bglocSectionName.14" />
					</a>
				</h2><hr class="h2-hr">
				<div id="expirationDatesPanel" class="section_panel">
					<jsp:include page="suretyRiderRequestSection.jsp">
						<jsp:param name="sectionId"	value="request.section.riderExpirationDates" />
						<jsp:param name="includeScripts" value="false" />
					</jsp:include>
				</div>
			</div>
			
			<div class="form-mod">
				<h2 id="bondInformation" class="section_flip">
				<a href="javascript:;"><s:text	name="label.request.sbSectionBondInformation" /></a></h2><hr class="h2-hr">
				<div id="bondInformationPanel" class="section_panel">
					
						<jsp:include page="suretyRiderRequestSection.jsp">
							<jsp:param name="sectionId"  value="request.section.riderBondInformation" />
							<jsp:param name="saveAndNextSectionButtonKey" value="key" />
							<jsp:param name="includeScripts" value="false" />
						</jsp:include>
									
				</div>
			</div>			
			<div class="clear"></div>
			<!-- Including Delivery Instructions   -->
			<div class="form-mod">
				<h2 id="deliveryInstructions" class="section_flip">
				<a href="javascript:;"><s:text name="label.request.sbSectionDeliveryInstructions"/></a></h2><hr class="h2-hr">
				<div id="deliveryInstructionsPanel" class="section_panel">
					
						<jsp:include page="suretyRiderRequestSection.jsp">
							<jsp:param name="sectionId"  value="request.section.riderDeliveryInstructions" />
							<jsp:param name="saveAndNextSectionButtonKey" value="key" />
							<jsp:param name="includeScripts" value="false" />
						</jsp:include>					
												
				</div>
			</div>
			
			 <!-- Including Attachments   -->
		   <div class="form-mod" id="attachmentsDiv">
		   		<h2 id="attachments" class="section_flip">
					<a href="javascript:;"><s:text	name="label.request.sbSectionAttachments"/></a>
				</h2><hr class="h2-hr">
				<div id="attachmentsPanel" class="section_panel">
					
						<jsp:include page="suretyRiderRequestSection.jsp">
							<jsp:param name="sectionId"  value="request.section.attachments" />
							<jsp:param name="saveAndNextSectionButtonKey" value="key" />
							<jsp:param name="includeScripts" value="false" />
						</jsp:include>
								
				</div>
		   </div>
			<div class="clear"></div>
			<s:if test="%{requestDetails.WFDetails.WFStage == 'REQEST' || requestDetails.WFDetails.WFStage == 'REQUEST'}"> 
				<div class="form-mod">
						<jsp:include page="/jsp/common/request/auditAndTransactionHistoryLog.jsp" />
					</div>
			</s:if>
			
			<c:if test="${workFlowStage eq 'REQEST' or workFlowStage eq 'BUSAPROV' or workFlowStage eq 'REQUEST'}">
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
        	</c:if> 
				<div>
					<jsp:include page="/jsp/common/request/suretyRider/saveAndSubmitRider.jsp" />
				</div>
			</div>					
		</s:form>
		<div id="lookupDiv" style="width: 100%;"></div>
		<div id="fullHistoryDiv" style="width: 100%;"></div>
	</div>
	<%@include file="../../../common/footerSection.jsp"%>
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