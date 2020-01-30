<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
 <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><s:text name="label.request.suretyBond"/> - <s:property value="requestDetails.bondDetails.bondType"/> - <s:text name="label.request.reviewAndSubmit"/></title>

<%@include file="../../common/includeRequestCommonScripts.jsp" %>
<link href="${pageContext.request.contextPath}/css/common/pagenavi.css" type="text/css" rel="stylesheet" />
<script src="${pageContext.request.contextPath}/js/requestor/requestor.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/requestor/suretyRequestor.js" type="text/javascript"></script>
 <script src="${pageContext.request.contextPath}/js/requestor/lookup.js" type="text/javascript"></script> 
<script src="${pageContext.request.contextPath}/js/common/toWord.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/requestor/addReference.js" type="text/javascript"></script>
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
			<s:label>
			<s:text name="label.request.requestSuretyBond"/></s:label>
		</h1>
		<p class="span12 left clear dashdesc">
			<s:label  key="label.optionalSentence.requestSuretyBond"/>
		</p>
		<hr class="page-title-hr">
		<div class="clear"></div>
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
        <s:hidden name="formatOpen" value="yes" id="formatOpen"/>
			<s:set name="isEdit" value="editMode"/>
			<div class="form-mod" id="bondDetailsSectionId">
				<h2 id="bondDetails" class="section_flip section_blue">
					<a href="javascript:;"><s:text	name="label.request.bondType" /><span class="ttip info" data-original-title="<s:text name="label.request.tooltip.bondDetails"/>"></span>
					</a>
				</h2><hr class="h2-hr">
				<div id="bondDetailsPanel" class="section_panel fieldcount_panel">

						<jsp:include page="suretyBondReviewRequestSection.jsp">
							<jsp:param name="sectionId"  value="request.section.bondDetails" />
							<jsp:param name="saveAndNextSectionButtonKey" value="key" />
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
				<div id="requestorMailingAddressPanel" class="section_panel fieldcount_panel">
					
					
						<jsp:include page="suretyBondReviewRequestSection.jsp">
							<jsp:param name="sectionId"  value="request.section.requestorMailingAddress" />
							<jsp:param name="saveAndNextSectionButtonKey" value="key" />
							<jsp:param name="includeScripts" value="false" />
						</jsp:include>					
													
				</div>
			</div>			
			<div class="clear"></div>

			<div class="form-mod">
				<h2 id="deliveryInstructions" class="section_flip">
				<a href="javascript:;"><s:text name="label.request.sbSectionDeliveryInstructions"/></a></h2><hr class="h2-hr">
				<div id="deliveryInstructionsPanel" class="section_panel fieldcount_panel">
					
						<jsp:include page="suretyBondReviewRequestSection.jsp">
							<jsp:param name="sectionId"  value="request.section.deliveryInstructions" />
							<jsp:param name="saveAndNextSectionButtonKey" value="key" />
							<jsp:param name="includeScripts" value="false" />
						</jsp:include>					
												
				</div>
			</div>
			<div class="clear"></div>
				<div class="form-mod">
				<h2 id="bondInformation" class="section_flip">
				<a href="javascript:;">
				<c:if test="${requestDetails.bondDetails.bondTypeId eq '4'}">
				<s:text name="label.request.sbSectionCourtBondDetails" />
				</c:if>
				<c:if test="${requestDetails.bondDetails.bondTypeId ne '4'}">
				<s:text name="label.request.sbSectionBondInformation"/>
				</c:if>
				</a></h2><hr class="h2-hr">
				<div id="bondInformationPanel" class="section_panel fieldcount_panel">
					
						<jsp:include page="suretyBondReviewRequestSection.jsp">
							<jsp:param name="sectionId"  value="request.section.bondInformation" />
							<jsp:param name="saveAndNextSectionButtonKey" value="key" />
							<jsp:param name="includeScripts" value="false" />
						</jsp:include>					
											
				</div>
			</div>
			<div class="clear"></div>
			<c:if test="${requestDetails.bondDetails.bondTypeId eq '4'}">
				<div class="form-mod">
				<h2 id="attorneyBondInformation" class="section_flip">
				<a href="javascript:;"><s:text
									name="label.request.sbSectionAttorneyInformation" /></a></h2><hr class="h2-hr">
				<div id="attorneyBondInformationPanel" class="section_panel fieldcount_panel">
					
						<jsp:include page="suretyBondReviewRequestSection.jsp">
							<jsp:param name="sectionId"  value="request.section.attorneyBondInformation" />
							<jsp:param name="saveAndNextSectionButtonKey" value="key" />
							<jsp:param name="includeScripts" value="false" />
						</jsp:include>					
											
				</div>
			</div>
			</c:if>
			
		   <!-- Including Format   -->
		 <s:form id="reviewAndSubmitFormID" action="submit.action" namespace="/int/requestor/review">
		 	<s:hidden name="requestDetails.instrumentTypeId" id="instrumentTypeId" />
			<s:hidden name="requestDetails.WFDetails.WFStage" id="WFStage" />
			<s:hidden name="requestId" value="%{requestDetails.requestId}" id="requestId"/>
		   <div class="form-mod" id="formatDiv">
		   		<h2 id="format" class="section_flip">
					<a href="javascript:;"><s:text name="label.request.sbSectionFormat"/>
						<span id="formatSelectionH2"></span>
					</a>
				</h2><hr class="h2-hr">
				<div id="formatPanel" class="section_panel fieldcount_panel">
					
						<jsp:include page="suretyBondReviewRequestSection.jsp">
							<jsp:param name="sectionId"  value="request.section.format" />
							<jsp:param name="saveAndNextSectionButtonKey" value="key" />
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
						
							<jsp:include page="suretyBondReviewRequestSection.jsp">
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