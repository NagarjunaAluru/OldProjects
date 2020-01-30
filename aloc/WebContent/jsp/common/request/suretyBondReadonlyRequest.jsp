<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
 <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<c:if test="${requestDetails.WFDetails.WFStage eq 'BUSAPROV'}">
	<title><s:text name="label.request.suretyBondBusinessApproval"/></title>
</c:if>
<c:if test="${requestDetails.WFDetails.WFStage eq 'TREAPROV'}">
	<title><s:text name="label.request.suretyBondTreasuryApproval"/></title>
</c:if>
<%@include file="../../common/includeCommonScripts.jsp"%>
<script src="${pageContext.request.contextPath}/js/requestor/requestor.js" type="text/javascript"></script>
 <script src="${pageContext.request.contextPath}/js/requestor/lookup.js" type="text/javascript"></script> 
 <script src="${pageContext.request.contextPath}/js/common/pagination.js"></script>
<link href="${pageContext.request.contextPath}/css/common/pagenavi.css" type="text/css" rel="stylesheet" />
</head>

<body>
	
	<c:set var="workFlowStage" value="${requestDetails.WFDetails.WFStage}"></c:set>
		<div class="container main">
		<s:form id="approverSubmitForm" action="approverSubmit">
			<s:hidden name="requestDetails.instrumentTypeId" id="instrumentTypeId" />
			<s:hidden name="requestDetails.WFDetails.WFStage" id="WFStage" />
			<s:hidden name="requestId" value="%{requestDetails.requestId}" id="requestId" />
		  <input type="hidden" name="actionType" id="actionTypeId" value="${actionType}"/>
		<%@include file="../../common/headerSection.jsp"%>
		<div id="mainPage" style="width: 100%;">
		<c:if test="${workFlowStage eq 'BUSAPROV'}">
		<h1 class="page-title span12">
			<s:label key="">
			<s:text name="label.request.suretyBondBusinessApproval"/>
			</s:label>
		</h1>
		<p class="span12 left clear dashdesc"> 			
			<s:text name="label.request.sbBusinessApprovalDescription"/>
		</p>
		<hr class="page-title-hr">
		</c:if>
		<c:if test="${workFlowStage eq 'TREAPROV'}">
		<h1 class="page-title span12">	
			<s:text name="label.request.suretyBondTreasuryApproval"/>
		</h1>
		<p class="span12 left clear dashdesc"> 
			
			<s:text name="label.request.treasuryApprovalTransaction"/>
		</p>
		<hr class="page-title-hr">
		</c:if>
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
		<s:hidden id="errorMsgShowId" value="%{errorShow}"/>
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
				<div class="clear"></div>
		<jsp:include page="../../common/request/sbRequestSummary.jsp"/>
		 <div class="clear"></div>
        <div class="highlighted">

            <div class="row smallrow">
                <div class="span2">
                    <div class="form-row">
                        <label><s:text name="label.request.selectedSite"/></label>
                    </div>
                </div>
                <div class="span5 left">
                    <div class="form-row">
                        <s:property value="requestDetails.siteName"/>
                    </div>
                </div>
            </div>
        </div>
			<s:set name="isEdit" value="editMode"/>
			<div class="form-mod" id="bondDetailsSectionId">
				<h2 id="bondDetails" class="section_flip section_blue">
				<a href="javascript:;"><s:text	name="label.request.bondType"/><span class="ttip info" data-original-title="<s:text name="label.request.tooltip.bondDetails"/>"></span>
				</a>
				</h2><hr class="h2-hr">
				<div id="bondDetailsPanel" class="section_panel">

						<jsp:include page="suretyBondReadonlyRequestSection.jsp">
							<jsp:param name="sectionId"  value="request.section.bondDetails" />
							<jsp:param name="includeScripts" value="false" />
						</jsp:include>					
					
				</div>
			</div>
			
			<div class="clear"></div>
			
			<div class="form-mod">
				<h2 id="requestorMailingAddress" class="section_flip">
				<a href="javascript:;"><s:text name="label.request.sbSectionRequestorMailingAddress"/>
				<span class="ttip info" data-original-title="<s:text name="label.request.tooltip.requestorMailingAddress"/>"></span>
				</a></h2><hr class="h2-hr">
				<div id="requestorMailingAddressPanel" class="section_panel">
					
					
						<jsp:include page="suretyBondReadonlyRequestSection.jsp">
							<jsp:param name="sectionId"  value="request.section.requestorMailingAddress" />
							<jsp:param name="includeScripts" value="false" />
						</jsp:include>					
													
				</div>
			</div>			
			<div class="clear"></div>

			<div class="form-mod">
				<h2 id="deliveryInstructions" class="section_flip">
				<a href="javascript:;"><s:text name="label.request.sbSectionDeliveryInstructions"/></a></h2><hr class="h2-hr">
				<div id="deliveryInstructionsPanel" class="section_panel">
					
						<jsp:include page="suretyBondReadonlyRequestSection.jsp">
							<jsp:param name="sectionId"  value="request.section.deliveryInstructions" />
							<jsp:param name="includeScripts" value="false" />
						</jsp:include>					
												
				</div>
			</div>
			<div class="clear"></div>
				<jsp:include page="suretyBondReadonlyRequestSection.jsp">
					<jsp:param name="sectionId" value="request.section.bondInformation" />
					<jsp:param name="includeScripts" value="false" />
				</jsp:include>
				<div class="clear"></div>
				<!-- Including Format   -->
		   <div class="form-mod" id="formatDiv">
		   		<h2 id="format" class="section_flip">
					<a href="javascript:;"><s:text name="label.request.sbSectionFormat"/>
						<span id="formatSelectionH2"></span>
					</a>
				</h2><hr class="h2-hr">
				<div id="formatPanel" class="section_panel">
					
						<jsp:include page="suretyBondReadonlyRequestSection.jsp">
							<jsp:param name="sectionId"  value="request.section.format" />
							<jsp:param name="includeScripts" value="false" />
						</jsp:include>					
											
				</div>
		   </div>
		   <!-- Including Attachments   -->
		   <div class="form-mod" id="attachmentsDiv">
		   		<h2 id="attachments" class="section_flip">
					<a href="javascript:;"><s:text name="label.request.sbSectionAttachments"/></a>
				</h2><hr class="h2-hr">
				<div id="attachmentsPanel" class="section_panel">
					
						<jsp:include page="suretyBondReadonlyRequestSection.jsp">
							<jsp:param name="sectionId"  value="request.section.attachments" />
							<jsp:param name="includeScripts" value="false" />
						</jsp:include>					
									
				</div>
		   </div>
		   <!--  Comments field -->
				<div class="row smallrow">
					<div class="span12">
						<h3 class="dashdesc">
							<s:text name="label.request.comments" />
						</h3>
						<label><s:text name="label.request.commentsOptional" /></label>
						<hr class="page-title-hr">
						<s:textarea name="requestDetails.comments" theme="aloc" onkeypress="return imposeMaxLength(this, 399);"
							cssClass="autosize messageinput" id="tdcomments" required="false" />
						<div class="clear"></div>
						<div class="counter">400</div>
						<!-- fix positions -->
						<div class="counterTxt"><p class="guidance">characters left <!--left (Limit is 400 characters) --></p>
						</div>
					</div>
				</div>
				<!-- Audit Log and Transaction History  -->
		   <div class="form-mod">
			        <jsp:include page="/jsp/common/request/auditAndTransactionHistoryLog.jsp"/>	            
		   </div>
		
  		<!-- Include Submit Section -->	
  		<div class="form-mod" id="submitDiv">
				<div>
					<jsp:include page="/jsp/requestor/approveOrReject.jsp"/>		
				</div>
		   </div>
		</div>
		</s:form>	
	<div id="fullHistoryDiv" style="width: 100%;"></div>
	</div>
	<%@include file="../../common/footerSection.jsp"%>
	<!-- EXIT REQUEST POPUP WINDOW -->
	  <s:url action="cancel.action" namespace="/int/approver" var="cancelBtnlURL"/>
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