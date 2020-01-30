<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
 <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><s:text name="label.request.suretyBond"/> - <s:text name="label.request.create"/> <s:property value="requestDetails.bondDetails.bondType"/></title>

<%@include file="../common/includeRequestCommonScripts.jsp" %>
<link href="${pageContext.request.contextPath}/css/common/pagenavi.css" type="text/css" rel="stylesheet" />
<script src="${pageContext.request.contextPath}/js/requestor/suretyRequestor.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/requestor/requestor.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/common/toWord.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/requestor/addReference.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/requestor/fieldCounter.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/common/pagination.js"></script>

</head>

<body>     
	<div class="container main" id="mainDiv">
		<jsp:include page="../common/headerSection.jsp">
			<jsp:param name="createReqPopup" value="Yes"></jsp:param>
		</jsp:include>
		<s:hidden name="approver" value="wants" id="approver"/>
		<div id="mainPage" style="width: 100%;">		
				<s:form id="suretyBondForm">
				<jsp:include page="/jsp/common/request/saveAndContinue.jsp"/>
				<s:hidden name="requestDetails.instrumentTypeId" value="%{requestDetails.instrumentTypeId}" id="instrumentTypeId"/>
				<s:hidden name="validationSuccess" id="validationSuccessId"/>
				<h1 class="page-title span12">
					<s:text name="label.request.requestSuretyBond" />
				</h1>
				<p class="span12 left clear dashdesc">
					<s:text name="label.optionalSentence.requestSuretyBond" />
				</p>
				<hr class="page-title-hr">
				
				<div class="row hide" id="pageLevelErrorDivId">
						<div class="span12">
							<div class="errorbox">
								<div class="errorHead">
									<p class="erroricon">Error</p>
								</div>
								<div class="errorContent">
									<p>
										<s:fielderror/>
									</p>
									<p>&nbsp;</p>
								</div>
							</div>
						</div>
					</div>					
					<div class="clear"></div>								
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
									<s:if test="%{requestDetails.requestSummary.requestor.ssoId != null}">
									<s:property
										value="requestDetails.requestSummary.requestor.lastName" />
									,
									<s:property
										value="requestDetails.requestSummary.requestor.firstName" />
									<br>
									<s:property
										value="requestDetails.requestSummary.requestor.ssoId" />
									<br>
								</s:if>
								<s:else><span style="margin-left :25px;"></span>--</s:else>
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
						<s:if
							test="%{requestDetails.requestSummary.linkedTransactionId != null}">
							<div class="singleBoxRS">
								<div class="row smallrow">
									<div class="span2">
										<label><s:text
												name="label.request.linkedTransactionID" /></label>

										<s:property
											value="requestDetails.requestSummary.linkedTransactionId" />

									</div>
								</div>
							</div>
							<!-- rightBox ends here -->
						</s:if>
						<s:if test="%{requestDetails.requestSummary.modelCode != null}">
							<div class="singleBoxRS">
								<div class="row smallrow">
									<div class="span2">
										<label><s:text name="label.request.modelCode" /></label>
										<s:property value="requestDetails.requestSummary.modelCode" />
									</div>
								</div>
							</div>
							<!-- rightBox ends here -->
						</s:if>

						<div class="clear"></div>
					</div>
					<s:hidden name="openSection" id="openSection" value="suretyBond"/>
					<!-- requestSummary ends here -->						
			<div class="form-mod" id="bondDetailsSectionId">
				<h2 id="bondDetails" class="section_flip section_blue">
					<a href="javascript:;"><s:text	name="label.request.bondType"/><span class="ttip info" data-original-title="<s:text name="label.request.tooltip.bondDetails"/>"></span>
					</a>
				</h2><hr class="h2-hr">
				<div id="bondDetailsPanel" class="section_panel fieldcount_panel">
				
					
						<jsp:include page="suretyBondRequestorSection.jsp">
							<jsp:param name="sectionId"  value="request.section.bondDetails" />
							<jsp:param name="saveAndNextSectionButtonKey" value="key" />
							<jsp:param name="resubmit" value="false"/>
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
						 <s:if test="%{requestDetails.WFDetails.WFStage == 'REQEST' && requestDetails.addressDtls.requiresEdits}">
						<div class="row">
							<div class="span12">
								<div class="errorbox">
									<div class="noteHead">
										<p class="noteicon">
											<s:text name="label.common.alert" />
										</p>
									</div>
									<div class="noteContent">
										<p>
											<s:property value="requestDetails.addressDtls.sendBackNotes" />
										</p>
									</div>
								</div>
							</div>
						</div>
						</s:if>
						<jsp:include page="suretyBondRequestorSection.jsp">
							<jsp:param name="sectionId"  value="request.section.requestorMailingAddress" />
							<jsp:param name="saveAndNextSectionButtonKey" value="key" />
							<jsp:param name="includeScripts" value="false" />
						</jsp:include>
										
				</div>
			</div>			
		<div class="clear"></div>

			<div class="form-mod">
				<h2 id="deliveryInstructions" class="section_flip">
				<a href="javascript:;"> <s:text name="label.request.sbSectionDeliveryInstructions"/></a></h2><hr class="h2-hr">
				<div id="deliveryInstructionsPanel" class="section_panel fieldcount_panel">
						 
						 <s:if test="%{requestDetails.WFDetails.WFStage == 'REQEST' && requestDetails.deliveryInstructions.requiresEdits}">				
						<div class="row">
							<div class="span12">
								<div class="errorbox">
									<div class="noteHead">
										<p class="noteicon">
											<s:text name="label.common.alert" />
										</p>
									</div>
									<div class="noteContent">
										<p>
											<s:property value="requestDetails.deliveryInstructions.sendBackNotes" />
										</p>
									</div>
								</div>
							</div>
						</div>
						</s:if>
						<jsp:include page="suretyBondRequestorSection.jsp">
							<jsp:param name="sectionId"  value="request.section.deliveryInstructions" />
							<jsp:param name="saveAndNextSectionButtonKey" value="key" />
							<jsp:param name="includeScripts" value="false" />
						</jsp:include>
											
				</div>
			</div>
			<div class="clear"></div>
					<div id="bondInfoDiv1">
					<jsp:include page="suretyBondRequestorSection.jsp">
							<jsp:param name="sectionId"  value="request.section.bondInformation" />
							<jsp:param name="saveAndNextSectionButtonKey" value="key" />
							<jsp:param name="includeScripts" value="false" />
					</jsp:include>
					</div>
			 <s:if test="%{requestDetails.WFDetails.WFStage == 'REQEST'}">	
			<div class="clear"></div>
			<!-- Audit Log and Transaction History  -->
		   <div class="form-mod">
			        <jsp:include page="/jsp/common/request/auditAndTransactionHistoryLog.jsp"/>	            
		   </div>
		   </s:if>
				</s:form>
		</div>
		
		<div id="lookupDiv" style="width: 100%;">
		</div>
		<div id="fullHistoryDiv" style="width: 100%;"></div>
	</div>
	<%@include file="../common/footerSection.jsp"%>
</body>
</html>