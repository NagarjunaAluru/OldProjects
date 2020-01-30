<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
 <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><s:text name="label.request.suretyRiderCreation"/></title>

<%@include file="../../../common/includeCommonScripts.jsp"%>
<script src="${pageContext.request.contextPath}/js/requestor/requestor.js" type="text/javascript"></script>
 <script src="${pageContext.request.contextPath}/js/requestor/lookup.js" type="text/javascript"></script> 
<script src="${pageContext.request.contextPath}/js/common/toWord.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/common/rider.js" type="text/javascript"></script>
</head>

<body>
	<div class="container main">
		<%@include file="../../../common/headerSection.jsp"%>
		<div id="mainPage">
		<h1 class="page-title span12"><s:text name="label.request.createSuretyRider"/></h1>
		<hr class="page-title-hr">
			<div class="form-mod">				
				<div class="row graybg lastrow" style="margin-left: -10px;">
					<div class="span12">
						<h2 class="summary span12"><s:text name="label.request.requestSummary"/></h2><hr class="h2-hr">
						<div class="clear"></div>
						<div class="row">
							<div class="span12 whitebg">
								<div class="span4" style="margin-left: 10px!important;">
									<div class="marginT">
										<label><s:text name="label.request.requestor"/></label>
										<p>Cooper, Bradely</p>
										<p>999999999</p>
									</div>
								</div> 
								<div class="span2">
									<div class="marginT">
										<label><s:text name="label.request.alocRecNo"/></label>
										<p><s:property value="requestDetails.requestId"/><s:property value="requestDetails.sitePrefix"/></p>
									</div>
								</div> 
								<div class="span2">
									<div class="marginT">
										<label><s:text name="label.request.riderSequenceNumber"/></label>
										<p><s:property value="requestDetails.rider.riderRequestId"/> </p>
									</div>
								</div> 
								<div class="span3 right">
								<div class="form-row">
								<div class="req-error" style="color:#000; text-indent:9px;">
									<label><s:text name="label.request.bondTypeSubType"/></label>
									<p><s:property value="requestDetails.bondDetails.bondType"/>-</p>
									<p><s:property value="requestDetails.bondDetails.bondSubType"/></p>
								</div>
								</div>
							</div>
							</div>
						</div>
					</div>
				</div>
			</div>
	   

			<s:set name="isEdit" value="editMode"/>
			
			<div class="form-mod">
				<h2 id="principal" class="section_flip">
				<a href="javascript:;"><s:text name="label.request.sbSectionPrincipal"/>
			<span class="ttip info" data-original-title="This is an tooltip with more information"></span>
			</a></h2><hr class="h2-hr">
				<div id="principalPanel" class="section_panel">
				
						<jsp:include page="suretyRiderReviewRequestSection.jsp">
							<jsp:param name="sectionId"  value="request.section.riderPrincipal" />
							<jsp:param name="saveAndNextSectionButtonKey" value="key" />
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
					
						<jsp:include page="suretyRiderReviewRequestSection.jsp">
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
					<jsp:include page="suretyRiderReviewRequestSection.jsp">
						<jsp:param name="sectionId"	value="request.section.riderExpirationDates" />
						<jsp:param name="includeScripts" value="false" />
					</jsp:include>
				</div>
			</div>
			
			<div class="form-mod">
				<h2 id="bondInformation" class="section_flip">
				<a href="javascript:;"><s:text	name="label.request.sbSectionBondInformation" /></a></h2><hr class="h2-hr">
				<div id="bondInformationPanel" class="section_panel">
					
						<jsp:include page="suretyRiderReviewRequestSection.jsp">
							<jsp:param name="sectionId"  value="request.section.riderBondInformation" />
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
					
						<jsp:include page="suretyRiderReviewRequestSection.jsp">
							<jsp:param name="sectionId"  value="request.section.attachments" />
							<jsp:param name="saveAndNextSectionButtonKey" value="key" />
							<jsp:param name="includeScripts" value="false" />
						</jsp:include>
								
				</div>
		   </div>
		   
			<div class="clear"></div>
			<div class="form-mod">
				<h2 id="deliveryInstructions" class="section_flip">
				<a href="javascript:;"><s:text name="label.request.sbSectionDeliveryInstructions"/></a></h2><hr class="h2-hr">
				<div id="deliveryInstructionsPanel" class="section_panel">
					
						<jsp:include page="suretyRiderReviewRequestSection.jsp">
							<jsp:param name="sectionId"  value="request.section.riderDeliveryInstructions" />
							<jsp:param name="saveAndNextSectionButtonKey" value="key" />
							<jsp:param name="includeScripts" value="false" />
						</jsp:include>					
												
				</div>
			</div>
			<div class="form-mod" id="businessDelegationDiv">
		   		<h2 id="businessDelegation" class="section_flip">
					<a href="javascript:;"><s:text name="label.request.bglocSectionName.15"/></a>
				</h2><hr class="h2-hr">
				<div id="businessDelegationPanel" class="section_panel">
						<jsp:include page="suretyRiderReviewRequestSection.jsp">
							<jsp:param name="sectionId"  value="request.section.businessDelegation" />
							<jsp:param name="saveAndNextSectionButtonKey" value="key" />
							<jsp:param name="includeScripts" value="false" />
						</jsp:include>
				</div>
			</div>

			<div class="row highlighted">
				<div class="span12">
					<div class="row" id="tracksectionDiv">
						<div class="span12">
							<p>
								<s:text name="label.request.editSections" />
								:
							</p>
							<p>
								<br />
							</p>
							<s:iterator value="editSectionList">
								<s:if test="%{name=='request.section.riderPrincipal'}">
									<p id="principal" class="tracking_section_flip">
										<a href="javascript:;"><s:text
												name="label.request.sbSectionPrincipal" /></a>
									</p>
								</s:if>
								<s:if test="%{name=='label.request.sbSectionObligee'}">
									<p id="obligee" class="tracking_section_flip">
										<a href="javascript:;"><s:text
												name="label.request.sbSectionObligee" /></a>
									</p>
								</s:if>
								<s:if test="%{name=='request.section.riderExpirationDates'}">
									<p id="expirationDates" class="tracking_section_flip">
										<a href="javascript:;"><s:text
												name="label.request.bglocSectionName.14" /></a>
									</p>
								</s:if>
								<s:if test="%{name=='request.section.riderBondInformation'}">
									<p id="bondInformation" class="tracking_section_flip">
										<a href="javascript:;"><s:text
												name="label.request.sbSectionBondInformation" /></a>
									</p>
								</s:if>
								<s:if test="%{name=='request.section.attachments'}">
									<p id="attachments" class="tracking_section_flip">
										<a href="javascript:;"><s:text
												name="label.request.sbSectionAttachments" /></a>
									</p>
								</s:if>
								<s:if
									test="%{name=='request.section.riderDeliveryInstructions'}">
									<p id="deliveryInstructions" class="tracking_section_flip">
										<a href="javascript:;"><s:text
												name="label.request.sbSectionDeliveryInstructions" /></a>
									</p>
								</s:if>

							</s:iterator>

						</div>
					</div>
					<br /> <br />
					<div class="row">
						<div class="span12">
							<s:url id="cancelAllURL" action="cancelAll" />
							<s:a href="%{cancelAllURL}" cssClass="btn-tertiary cancel">
								<s:text name="label.request.cancelAllChanges" />
							</s:a>
						</div>
					</div>
				</div>
			</div>
			
			<div class="form-mod" id="submitRiderDiv">
				<div>
					<s:form id="saveAndSubmitForm" namespace="/int/requestor/review" action="submitRider">
						<input type="hidden" name="actionType" id="actionTypeId">
						<br/>
						<s:submit 
							key="label.amendment.submitRequest"
							cssClass="btn btn-success" cssStyle="margin-left: 20px;" onclick="javascript:submitAction(2);"/>		
						
						<s:submit 
							key="label.request.saveAsDraft"
							cssClass="btn" cssStyle="margin-left: 20px;" onclick="javascript:submitAction(1);"/>
							
						<s:url id="homePageURL" action="cancel" namespace="/int/requestor" />
						<s:a href="%{homePageURL}" cssClass="btn-tertiary cancel" >
							<s:text name="label.request.common.cancel"/>
						</s:a>
					</s:form>
				</div>
			</div>
			
		</div>	
		<div id="lookup">
		</div>
		<%@include file="../../../common/footerSection.jsp"%>

	</div>
</body>
</html>