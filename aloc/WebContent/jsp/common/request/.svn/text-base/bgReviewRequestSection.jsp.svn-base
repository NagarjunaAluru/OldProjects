<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<!DOCTYPE html>
<c:if test="${param.includeScripts != false}">
<html>
  <head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<%@include file="../../common/ncludeRequestSectionCommonScripts.jsp" %>
	
</head>
<body>
</c:if>

<s:url id="applySectionURL" action="applySection" />
<s:url id="editSectionURL" action="editSection" />
<s:url id="cancelSectionURL" action="cancelSection" />
<s:set name="isEditMode" value="editMode"/>
<s:hidden name="currentSectionId" id="currentSectionId"/>
<c:choose>
	<c:when test="${param.sectionId eq 'request.section.transactionParties'}">
		<div id="transactionPartiesSection">
			<s:form id="transactionPartiesForm">
			<s:hidden name="requestId" value="%{requestDetails.requestId}"/>
			  <s:if test="%{#isEditMode==false}">
				<p class="editButton">
				<sj:submit 
					key="label.request.Edit"
					cssClass="btn-secondary right" cssStyle="margin-left: 20px;"
					replaceTarget="true"
					targets="transactionPartiesSection"
					href="%{editSectionURL}" 
					onErrorTopics="multipleTabsProblem"
				/>
				</p>
			  </s:if>
				<jsp:include page="/jsp/common/request/transactionParties.jsp" />
				<input type="hidden" name= "sectionId" value="${param.sectionId}" />
				<s:if test="%{#isEditMode==true}">
					<div class="highlighted span12">
					<sj:submit key="label.request.Apply" cssClass="btn-primary"
					replaceTarget="true" onBeforeTopics="/fieldCounter/hideCount" 
						targets="transactionPartiesSection" onCompleteTopics="dynamicFormatValueChange"
						href="%{applySectionURL}" 
						onErrorTopics="multipleTabsProblem"
					/>
					<sj:a 
						replaceTarget="true" onBeforeTopics="/fieldCounter/hideCount"
						cssClass="btn-tertiary cancel" onCompleteTopics="dynamicFormatValueChange"
						formIds="transactionPartiesForm"
						targets="transactionPartiesSection" 
						href="%{cancelSectionURL}" 
						onErrorTopics="multipleTabsProblem">
						<s:text name="label.request.common.undochanges"/>
					</sj:a>
					</div>
				</s:if>	
			</s:form>
		</div>
	</c:when>
	
	<c:when test="${param.sectionId eq 'request.section.projectDescription'}">
		<div id="projectDescriptionSection">
			<s:form id="projectDescriptionForm" >
			<s:hidden name="requestId" value="%{requestDetails.requestId}"/>
			   <s:if test="%{#isEditMode==false}">
			   <p class="editButton">
				<sj:submit 
					key="label.request.Edit"
					cssClass="btn-secondary right" cssStyle="margin-left: 20px;" 
					replaceTarget="true"
					targets="projectDescriptionSection"
					href="%{editSectionURL}" 
					onErrorTopics="multipleTabsProblem"
				/>
				</p>
			  </s:if>
				<jsp:include page="/jsp/common/request/projectDescription.jsp" />
				<input type="hidden" name= "sectionId" value="${param.sectionId}" />
				<s:if test="%{#isEditMode==true}">
					<div class="highlighted span12">
					<sj:submit key="label.request.Apply" cssClass="btn-primary"
					replaceTarget="true" onBeforeTopics="/fieldCounter/hideCount" 
						targets="projectDescriptionSection"
						href="%{applySectionURL}"
						onErrorTopics="multipleTabsProblem" 
					/>
					<sj:a 
						replaceTarget="true" onBeforeTopics="/fieldCounter/hideCount"
						cssClass="btn-tertiary cancel" 
						formIds="projectDescriptionForm"
						targets="projectDescriptionSection" 
						href="%{cancelSectionURL}" 
						onErrorTopics="multipleTabsProblem">
						<s:text name="label.request.common.undochanges"/>
					</sj:a>
					</div>
				</s:if>
			</s:form>
		</div>
	</c:when>
	<c:when test="${param.sectionId eq 'request.section.instrumentDetails'}">
		
		<div id="instrumentDetailsSection">
			<s:form id="instrumentDetailsForm">
			<s:hidden name="requestId" value="%{requestDetails.requestId}"/>
			   <s:if test="%{#isEditMode==false}">
			   	<p class="editButton">
				<sj:submit 
					key="label.request.Edit"
					cssClass="btn-secondary right" cssStyle="margin-left: 20px;" 
					replaceTarget="true"
					targets="instrumentDetailsSection"
					href="%{editSectionURL}" 
					onErrorTopics="multipleTabsProblem"
				/>
				</p>
			   </s:if>
				<jsp:include page="/jsp/common/request/instrumentDetails.jsp" />
				<input type="hidden" name= "sectionId" value="${param.sectionId}" />
				<s:if test="%{#isEditMode==true}">
				<div class="highlighted span12">
				<sj:submit key="label.request.Apply" cssClass="btn-primary"
					replaceTarget="true" onBeforeTopics="/fieldCounter/hideCount" 
						targets="instrumentDetailsSection"
						href="%{applySectionURL}" 
						onErrorTopics="multipleTabsProblem"
					/>
					<sj:a 
						replaceTarget="true" onBeforeTopics="/fieldCounter/hideCount"
						cssClass="btn-tertiary cancel" 
						formIds="instrumentDetailsForm"
						targets="instrumentDetailsSection" 
						href="%{cancelSectionURL}"
						onErrorTopics="multipleTabsProblem" >
						<s:text name="label.request.common.undochanges"/>
					</sj:a>
				</div>
				</s:if>
			</s:form>
		</div>
	</c:when>
	
	<c:when test="${param.sectionId eq 'request.section.instrumentRisk'}">
		
		<div id="instrumentRiskSection">
			<s:form id="instrumentRiskForm">
			<s:hidden name="requestId" value="%{requestDetails.requestId}"/>
			   <s:if test="%{#isEditMode==false}">
			   	<p class="editButton">
				<sj:submit 
					key="label.request.Edit"
					cssClass="btn-secondary right" cssStyle="margin-left: 20px;" 
					replaceTarget="true"
					targets="instrumentRiskSection"
					href="%{editSectionURL}" 
					onErrorTopics="multipleTabsProblem"
				/>
				</p>
			  </s:if>
				<jsp:include page="/jsp/common/request/instrumentRisk.jsp" />
				<input type="hidden" name= "sectionId" value="${param.sectionId}" />
				<s:if test="%{#isEditMode==true}">
					<div class="highlighted span12">
					<sj:submit key="label.request.Apply" cssClass="btn-primary"
					replaceTarget="true" onBeforeTopics="/fieldCounter/hideCount" 
						targets="instrumentRiskSection"
						href="%{applySectionURL}" 
						onErrorTopics="multipleTabsProblem"
					/>
					<sj:a 
						replaceTarget="true" onBeforeTopics="/fieldCounter/hideCount"
						cssClass="btn-tertiary cancel" 
						formIds="instrumentRiskForm"
						targets="instrumentRiskSection" 
						href="%{cancelSectionURL}" 
						onErrorTopics="multipleTabsProblem">
						<s:text name="label.request.common.undochanges"/>
					</sj:a>
					</div>
				</s:if>
			</s:form>
		</div>
	</c:when>
	
	<c:when test="${param.sectionId eq 'request.section.standbyLetterofCredit'}">
		<div id="standbyLetterofCreditSection">
			<s:form id="standbyLetterofCreditForm">
			<s:hidden name="requestId" value="%{requestDetails.requestId}"/>
			   <s:if test="%{#isEditMode==false}">
			   	<p class="editButton">
				<sj:submit 
					key="label.request.Edit"
					cssClass="btn-secondary right" cssStyle="margin-left: 20px;"
					replaceTarget="true"
					targets="standbyLetterofCreditSection"
					href="%{editSectionURL}" 
					onErrorTopics="multipleTabsProblem"
				/>
				</p>
			   </s:if>
				<jsp:include page="/jsp/common/request/standbyLOCConditions.jsp" />
				<input type="hidden" name= "sectionId" value="${param.sectionId}" />
				<s:if test="%{#isEditMode==true}">
					<div class="highlighted span12">
					<sj:submit key="label.request.Apply" cssClass="btn-primary"
					replaceTarget="true" onBeforeTopics="/fieldCounter/hideCount" 
						targets="standbyLetterofCreditSection"
						href="%{applySectionURL}" 
						onErrorTopics="multipleTabsProblem"
					 />
					 <sj:a 
						replaceTarget="true" onBeforeTopics="/fieldCounter/hideCount"
						cssClass="btn-tertiary cancel" 
						formIds="standbyLetterofCreditForm"
						targets="standbyLetterofCreditSection" 
						href="%{cancelSectionURL}" 
						onErrorTopics="multipleTabsProblem">
						<s:text name="label.request.common.undochanges"/>
					</sj:a>
					</div>
				 </s:if>
			</s:form>
		</div>
	</c:when>
	
	<c:when test="${param.sectionId eq 'request.section.instrumentReporting'}">
		
		<div id="instrumentReportingSection">
			<s:form id="instrumentReportingForm">
			<s:hidden name="requestId" value="%{requestDetails.requestId}"/>
			   <s:if test="%{#isEditMode==false}">
			   	<p class="editButton">
				<sj:submit 
					key="label.request.Edit"
					cssClass="btn-secondary right" cssStyle="margin-left: 20px;"
					replaceTarget="true"
					targets="instrumentReportingSection"
					href="%{editSectionURL}"
					onErrorTopics="multipleTabsProblem" 
				/>
				</p>
			   </s:if>
				<jsp:include page="/jsp/common/request/instrumentReportingAttributes.jsp" />
				<input type="hidden" name= "sectionId" value="${param.sectionId}" />
				<s:if test="%{#isEditMode==true}">
					<div class="highlighted span12">
					<sj:submit key="label.request.Apply" cssClass="btn-primary"
					replaceTarget="true" onBeforeTopics="/fieldCounter/hideCount" 
						targets="instrumentReportingSection"
						href="%{applySectionURL}" 
						onErrorTopics="multipleTabsProblem"
					/>
					<sj:a 
						replaceTarget="true" onBeforeTopics="/fieldCounter/hideCount"
						cssClass="btn-tertiary cancel" 
						formIds="instrumentReportingForm"
						targets="instrumentReportingSection" 
						href="%{cancelSectionURL}"
						onErrorTopics="multipleTabsProblem" >
						<s:text name="label.request.common.undochanges"/>
					</sj:a>
					</div>
				</s:if>
			</s:form>
		</div>	
	</c:when>
	<c:when test="${param.sectionId eq 'request.section.deliveryInstructions'}">
		<div id="deliveryInstructionsSection">
			<s:form id="deliveryInstructionsForm">
			<s:hidden name="requestId" value="%{requestDetails.requestId}"/>
			    <s:if test="%{#isEditMode==false}">
			    <p class="editButton">
				<sj:submit 
					key="label.request.Edit"
					cssClass="btn-secondary right" cssStyle="margin-left: 20px;"
					replaceTarget="true"
					targets="deliveryInstructionsSection"
					href="%{editSectionURL}" 
					onErrorTopics="multipleTabsProblem"
				/>
				</p>
			  </s:if>
				<jsp:include page="/jsp/common/request/deliveryInstructions.jsp" />
				<input type="hidden" name= "sectionId" value="${param.sectionId}" />
				<s:if test="%{#isEditMode==true}">
					<div class="highlighted span12">
					<sj:submit key="label.request.Apply" cssClass="btn-primary"
					replaceTarget="true" onBeforeTopics="/fieldCounter/hideCount" 
						targets="deliveryInstructionsSection"
						href="%{applySectionURL}" 
						onErrorTopics="multipleTabsProblem"
					/>
					<sj:a 
						replaceTarget="true" onBeforeTopics="/fieldCounter/hideCount"
						cssClass="btn-tertiary cancel" 
						formIds="deliveryInstructionsForm"
						targets="deliveryInstructionsSection" 
						href="%{cancelSectionURL}"
						onErrorTopics="multipleTabsProblem" >
						<s:text name="label.request.common.undochanges"/>
					</sj:a>
					</div>
				</s:if>
			</s:form>
		</div>		
	</c:when>
    	
	<c:when test="${param.sectionId eq 'request.section.format'}">
		<div id="formatSection">			
			 	<div id="replaceFormat">
					<jsp:include page="/jsp/common/request/requestorFormat.jsp" />
				</div>
				<input type="hidden" name= "sectionId" value="${param.sectionId}" />			
		</div>		
	</c:when>
	<c:when test="${param.sectionId eq 'request.section.attachments'}">
		<div id="attachmentsSection">		
			  	<jsp:include page="/jsp/common/request/requestAttachment.jsp" />
				<input type="hidden" name= "sectionId" value="${param.sectionId}" />			
		</div>		
	</c:when>
	
	
</c:choose>
<c:if test="${param.includeScripts != false}">
	</body>
	</html>
</c:if>