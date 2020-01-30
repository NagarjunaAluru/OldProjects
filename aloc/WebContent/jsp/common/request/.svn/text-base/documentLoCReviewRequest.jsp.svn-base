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

<%@include file="../../common/includeRequestCommonScripts.jsp" %>
 <script src="${pageContext.request.contextPath}/js/requestor/requestor.js" type="text/javascript"></script>
 <script src="${pageContext.request.contextPath}/js/requestor/lookup.js" type="text/javascript"></script> 
 <script src="${pageContext.request.contextPath}/js/requestor/addReference.js" type="text/javascript"></script>
 <script src="${pageContext.request.contextPath}/js/requestor/addBcpReference.js" type="text/javascript"></script>
 <link href="${pageContext.request.contextPath}/css/common/pagenavi.css" type="text/css" rel="stylesheet" />
 <script src="${pageContext.request.contextPath}/js/common/toWord.js" type="text/javascript"></script>
 <script src="${pageContext.request.contextPath}/js/requestor/fieldCounter.js" type="text/javascript"></script>
 <script src="${pageContext.request.contextPath}/js/requestor/dlocRequestor.js" type="text/javascript"></script>
 
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
			<s:label key=""><s:text name="label.request.requestConfirmationDLOC"/></s:label>
		</h1>
		<p class="span12 left clear dashdesc">
			<s:label key=""></s:label>
			<s:text name="label.request.useThisFormToRequestConfirmationDLOC"/>
			<s:text name="label.request.creditIssuedInFavorOfGEBusiness"/>
		</p>
		<hr class="page-title-hr">
				<div class="clear"></div>
		<s:hidden name="validationSuccess" id="validationSuccessId" value="%{validationSuccess}"/>
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
			<div class="form-mod">
                <jsp:include page="/jsp/common/request/dlocRequestSummary.jsp" />
				<div class="row lastrow">
					<div class="span12">
						<div class="form-row">
							<p style="padding: 2px 0;" class="defaultFontSize">
						<b><s:text name="label.request.selectedSite"/></b> 
						<span style="padding-left: 40px;"><s:property value="requestDetails.siteName"/></span>
						<s:hidden name="requestDetails.transactionParties.siteName" value="%{requestDetails.siteName}"></s:hidden>
					</p>
						</div>
					</div>
				</div>

			</div>
			<s:hidden name="formatOpen" value="yes" id="formatOpen"/>
			<s:set name="isEdit" value="editMode"/>
			<div class="form-mod" id="businessContactPersonSectionId">
				<h2 id="businessContactPerson" class="section_flip section_blue">
					<a href="javascript:;"><s:text name="label.request.dlocbusinessContactPerson"/></a>
				</h2><hr class="h2-hr">
				<div id="businessContactPersonPanel" class="section_panel fieldcount_panel">
						<jsp:include page="docLOCReviewRequestSection.jsp">
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
						<jsp:include page="docLOCReviewRequestSection.jsp">
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
						<jsp:include page="docLOCReviewRequestSection.jsp">
							<jsp:param name="sectionId"  value="request.section.applicant" />
							<jsp:param name="saveAndNextSectionButtonKey" value="key" />
							<jsp:param name="includeScripts" value="false" />
						</jsp:include>					
									
				</div>
			</div>			
						
			<div class="clear"></div>
			
			<div class="form-mod">
				<h2 id="beneficiary" class="section_flip">
					<a href="javascript:;"><s:text name="label.request.beneficiary"/> <span class="ttip info"
						data-original-title="<s:text name="label.request.tooltip.dloc.beneficiary"/>"></span></a>
				</h2><hr class="h2-hr">
				<div id="beneficiaryPanel" class="section_panel fieldcount_panel">			
						<jsp:include page="docLOCReviewRequestSection.jsp">
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
						<jsp:include page="docLOCReviewRequestSection.jsp">
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
						<jsp:include page="docLOCReviewRequestSection.jsp">
							<jsp:param name="sectionId"  value="request.section.paymentSchedule" />
							<jsp:param name="saveAndNextSectionButtonKey" value="key" />
							<jsp:param name="includeScripts" value="false" />
						</jsp:include>					
										
				</div>
			</div>
		   <!-- Including Format   -->
		<s:form id="dlocReviewAndSubmitForm" action="submit.action" namespace="/int/requestor/review">	
		<s:hidden name="requestId" value="%{requestDetails.requestId}"/>		   
		   <div class="form-mod" id="formatDiv">
		   		<h2 id="format" class="section_flip">
					<a href="javascript:;"><s:text name="label.request.bglocSectionName.7"/>
						<span id="formatSelectionH2"></span>
					</a>
				</h2><hr class="h2-hr">
				<div id="formatPanel" class="section_panel">
						<jsp:include page="docLOCReviewRequestSection.jsp">
							<jsp:param name="sectionId"  value="request.section.format" />
							<jsp:param name="saveAndNextSectionButtonKey" value="key" />
							<jsp:param name="includeScripts" value="false" />
						</jsp:include>					
								
				</div>
		   </div>
		   <!-- Including Attachments   -->
		   <div class="form-mod" id="attachmentsDiv">
		   		<h2 id="attachments" class="section_flip">
					<a href="javascript:;"><s:text name="label.request.bglocSectionName.9"/></a>
				</h2><hr class="h2-hr">
				<div id="attachmentsPanel" class="section_panel">
						<jsp:include page="docLOCReviewRequestSection.jsp">
							<jsp:param name="sectionId"  value="request.section.attachments" />
							<jsp:param name="saveAndNextSectionButtonKey" value="key" />
							<jsp:param name="includeScripts" value="false" />
						</jsp:include>					
				</div>
		   </div>
		   <div class="clear"></div>
		   <div class="highlighted">
			 <jsp:include page="/jsp/common/request/dlocSaveAndSubmit.jsp" />
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
		    <a href="<s:property value="#cancelBtnlURL" />" class="btn-secondary left"><s:text name="label.request.popUpCancelYes"/></a>
			<a href="javascript:;" class="btn-tertiary left cancel" data-dismiss="modal"><s:text name="label.request.popUpCancelNo"/></a>
		</div>
</div> 
</body>
</html>
