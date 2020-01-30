<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
 <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><s:text name="label.request.DocLoCConfirmationCreateNew"/></title>

<%@include file="../common/includeRequestCommonScripts.jsp" %>
<link href="${pageContext.request.contextPath}/css/common/pagenavi.css" type="text/css" rel="stylesheet" />
<script src="${pageContext.request.contextPath}/js/requestor/requestor.js" type="text/javascript"></script> 
<script src="${pageContext.request.contextPath}/js/requestor/dlocRequestor.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/requestor/fieldCounter.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/requestor/addReference.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/requestor/addBcpReference.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/common/pagination.js"></script>
<link href="${pageContext.request.contextPath}/css/common/pagenavi.css" type="text/css" rel="stylesheet" />
</head>

<body>
	<div class="container main">
		<jsp:include page="../common/headerSection.jsp">
			<jsp:param name="createReqPopup" value="Yes"></jsp:param>
		</jsp:include>
		<s:hidden name="approver" value="wants"/>
		<s:hidden name="validationSuccess" id="validationSuccessId"/>
		<div id="mainPage" style="width: 100%;">
		<s:form id="dlocForm">
		<c:if test="${requestDetails.WFDetails.WFStage ne 'REQEST' && requestDetails.WFDetails.WFStage ne 'REQUEST'}">
		<jsp:include page="/jsp/common/request/saveAndContinue.jsp" />
		</c:if>
		<c:if test="${requestDetails.WFDetails.WFStage eq 'REQEST' || requestDetails.WFDetails.WFStage eq 'REQUEST'}">
			<!-- For Alert -->
			<div class="row">
            <div class="span12">
            <div class="errorbox">
				<div class="noteHead"><p class="noteicon"><s:text name="label.common.alert"/></p></div>
				<div class="noteContent">
					<p><s:text name="label.request.TheFollowingEditsNeedtobeMadetoThisRequest"/></p><br><br>
					<ol>
					<s:if test="%{requestDetails.buContactPerson.requiresEdits}">
					<li><p><s:text name="label.request.dlocbusinessContactPerson"/></p></li>
					</s:if>
					<s:if test="%{requestDetails.issuingBankDetails.requiresEdits}">
					<li><p><s:text name="label.request.issuingBank"/></p></li>
					</s:if>
					<s:if test="%{requestDetails.applicantDetails.requiresEdits}">
					<li><p><s:text name="label.request.applicant"/></p></li>
					</s:if>
					<s:if test="%{requestDetails.beneficiaryDetails.requiresEdits}">
					<li><p><s:text name="label.request.customer"/></p></li>
					</s:if>
					<s:if test="%{requestDetails.transactionDetails.requiresEdits}">
					<li><p><s:text name="label.request.instrumentTransactionDetails"/></p></li>
					</s:if>
					<s:if test="%{requestDetails.paymentScheduleDetails.requiresEdits}">
					<li><p><s:text name="label.request.paymentSchedule"/></p></li>
					</s:if>
					<s:if test="%{requestDetails.format.requiresEdits}">
						<li><p><s:text	name="label.request.sbSectionFormat" /></p></li>
					</s:if>
					<s:if test="%{requestDetails.attachments[0].requiresEdits}">
						<li><p><s:text	name="label.request.sbSectionAttachments" /></p></li>
					</s:if>
					</ol>
				</div>
				</div>
            </div>
        </div>
        </c:if>
		
		<h1 class="page-title span12">
			<s:label key=""></s:label>
			<s:text name="label.request.requestConfirmationDLOC"/>
		</h1>
		<p class="span12 left clear dashdesc">
			<s:label key=""></s:label>
			<s:text name="label.request.useThisFormToRequestConfirmationDLOC"/>
			<s:text name="label.request.creditIssuedInFavorOfGEBusiness"/>
		</p>
		<hr class="page-title-hr">
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
			<div class="form-mod">
			    <jsp:include page="/jsp/common/request/dlocRequestSummary.jsp" />
			</div>
			<s:set name="isEdit" value="editMode"/>
			<c:if test="${requestDetails.WFDetails.WFStage ne 'REQEST' && requestDetails.WFDetails.WFStage ne 'REQUEST'}">
			<s:hidden name="openSection" id="openSection" value="dloc"/>
			</c:if>
			<div class="form-mod" id="businessContactPersonSectionId">
				<h2 id="businessContactPerson" class="section_flip section_blue">
					<a href="javascript:;"><s:text name="label.request.dlocbusinessContactPerson"/></a>
				</h2><hr class="h2-hr">
				<div id="businessContactPersonPanel" class="section_panel fieldcount_panel">
						<jsp:include page="docLOCRequestorSection.jsp">
							<jsp:param name="sectionId"  value="request.section.businessContactPerson" />
							<jsp:param name="saveAndNextSectionButtonKey" value="key" />
							<jsp:param name="includeScripts" value="false" />
						</jsp:include>
				</div>
			</div>
			
			<div class="clear"></div>
			<div class="form-mod">
				<h2 id="issuingBank" class="section_flip">
					<a name="second" href="javascript:;"><s:text name="label.request.issuingBank"/></a>
				</h2><hr class="h2-hr">
				<div id="issuingBankPanel" class="section_panel fieldcount_panel">
						<jsp:include page="docLOCRequestorSection.jsp">
							<jsp:param name="sectionId"  value="request.section.issuingBank" />
							<jsp:param name="saveAndNextSectionButtonKey" value="key" />
							<jsp:param name="includeScripts" value="false" />
						</jsp:include>
					
				</div>
			</div>
				
			<div class="clear"></div>
			
			<div class="form-mod">
				<h2 id="applicant" class="section_flip">
					<a href="javascript:;"><s:text name="label.request.applicant"/> <span class="ttip info"
						data-original-title="<s:text name="label.request.tooltip.dloc.applicant"/>"></span></a>
				</h2><hr class="h2-hr">
				<div id="applicantPanel" class="section_panel fieldcount_panel">
						<jsp:include page="docLOCRequestorSection.jsp">
							<jsp:param name="sectionId"  value="request.section.applicant" />
							<jsp:param name="saveAndNextSectionButtonKey" value="key" />
							<jsp:param name="includeScripts" value="false" />
						</jsp:include>
									
				</div>
			</div>			
						
			<div class="clear"></div>
			
			<div class="form-mod">
				<h2 id="beneficiary" class="section_flip">
					<a href="javascript:;"><s:text name="label.request.customer"/> <span class="ttip info"
						data-original-title="<s:text name="label.request.tooltip.dloc.beneficiary"/>"></span></a>
				</h2><hr class="h2-hr">
				<div id="beneficiaryPanel" class="section_panel fieldcount_panel">			
						<jsp:include page="docLOCRequestorSection.jsp">
							<jsp:param name="sectionId"  value="request.section.beneficiary" />
							<jsp:param name="saveAndNextSectionButtonKey" value="key" />
							<jsp:param name="includeScripts" value="false" />
						</jsp:include>
										
				</div>
			</div>	
								
			<div class="clear"></div>
			
			<div class="form-mod">
				<h2 id="instrumentTransactionDetails" class="section_flip">
					<a href="javascript:;"><s:text name="label.request.instrumentTransactionDetails"/></a>
				</h2><hr class="h2-hr">
				<div id="instrumentTransactionDetailsPanel" class="section_panel fieldcount_panel">
						<jsp:include page="docLOCRequestorSection.jsp">
							<jsp:param name="sectionId"  value="request.section.instrumentTransactionDetails" />
							<jsp:param name="saveAndNextSectionButtonKey" value="key" />
							<jsp:param name="includeScripts" value="false" />
						</jsp:include>
											
				</div>
			</div>			
			<div class="clear"></div>

			<div class="form-mod">
				<h2 id="paymentSchedule" class="section_flip">
					<a href="javascript:;"><s:text name="label.request.paymentSchedule"/></a>
				</h2><hr class="h2-hr">
				<div id="paymentSchedulePanel" class="section_panel fieldcount_panel">
						<jsp:include page="docLOCRequestorSection.jsp">
							<jsp:param name="sectionId"  value="request.section.paymentSchedule" />
							<jsp:param name="saveAndNextSectionButtonKey" value="key" />
							<jsp:param name="includeScripts" value="false" />
						</jsp:include>
											
				</div>
			</div>
		   <c:if test="${requestDetails.WFDetails.WFStage eq 'REQEST' || requestDetails.WFDetails.WFStage eq 'REQUEST'}">
		   <s:hidden name="requestId" value="%{requestDetails.requestId}"/>
		   	<div class="clear"></div>
				   <!-- Including Format   -->
		   <div class="form-mod" id="formatDiv">
		   		<h2 id="format" class="section_flip">
					<a href="javascript:;"><s:text name="label.request.sbSectionFormat"/> 
						<span id="formatSelectionH2"></span>
					</a>
				</h2><hr class="h2-hr">
				<div id="formatPanel" class="section_panel fieldcount_panel">
					
						<jsp:include page="/jsp/common/request/requestorFormat.jsp">
							<jsp:param name="includeScripts" value="false" />
						</jsp:include>						
											
				</div>
		   </div>
		   <!-- Including Attachments   -->
		   <div class="form-mod" id="attachmentsDiv">
		   		<h2 id="attachments" class="section_flip">
					<a href="javascript:;"><s:text name="label.request.sbSectionAttachments"/></a>
				</h2><hr class="h2-hr">
				<div id="attachmentsPanel" class="section_panel fieldcount_panel">
					
						<jsp:include page="/jsp/common/request/requestAttachment.jsp" />					
									
				</div>
		   </div>
		   <input type="hidden" name="actionType" id="actionTypeId" />
		   <div class="form-mod" id="attachmentsDiv">
		        <jsp:include page="/jsp/common/request/auditAndTransactionHistoryLog.jsp" />
		   </div>
		   
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
        	
		   <br/><div class="clear"></div>
					<div class="row smallrow highlighted">
					<div class="span12">
						<div class="form-row" style="margin-left: 0px;">
					<s:submit action="reSubmit" 
					key="label.request.common.save"
					cssClass="btn" cssStyle="margin-left: 20px;"				
					indicator="bondDetailsProcess1"
					onclick="javascript:submitAction(1);"	
					/>
				
				    <s:submit action="reSubmit"
					key="label.request.common.reSubmitRequest"
					cssClass="btn" cssStyle="margin-left: 20px;"
					indicator="bondDetailsProcess2"
					onclick="javascript:submitAction(32);"
					/>
					<s:url action="cancel.action" namespace="/int/requestor" var="cancelBtnlURL"/>
					<a href="#clearEntries" class="btn-tertiary cancel" data-toggle="modal"><s:text name="label.request.common.cancel"/></a> 
					<img alt="Loading..." id="bondDetailsProcess1" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px;">
					<img alt="Loading..." id="bondDetailsProcess2" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px;"> 
				</div>
				</div>
				</div>
		   </c:if>
		   </s:form>
		</div>
		<div id="lookupDiv" style="width: 100%;">
		</div>
		<div id="fullHistoryDiv" style="width: 100%;"></div>
		

	</div>
		<%@include file="../common/footerSection.jsp"%>
      <div class="modal hide fade" id="clearEntries">
		<div class="modal-header">
			<a class="close" data-dismiss="modal">X</a>
			<h3><s:text name="label.request.clearEntries"/> <span></span></h3>
		</div>
		<div class="modal-body">
		<form>
		<p><s:text name="label.request.popUpMsg"/></p>
		</form>
		</div>
		<div class="modal-footer">
		    <a href="<s:property value="#cancelBtnlURL" />" class="btn left"><s:text name="label.request.continue"/></a>
			<a href="javascript:;" class="btn-tertiary left cancel" data-dismiss="modal"><s:text name="label.request.closeWindow"/></a>
		</div>
</div> 	
</body>
</html>