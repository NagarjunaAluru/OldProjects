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

<s:set name="isEdit" value="editMode"/>
<s:hidden name="currentSectionId" id="currentSectionId"/>
<c:choose>
	<c:when test="${param.sectionId eq 'request.section.businessContactPerson'}">
		<div id="businessContactPersonSection">
			<s:form id="businessContactPersonForm">
			<s:hidden name="requestId" value="%{requestDetails.requestId}"/>
				<s:if test="%{#isEdit==false}">
					<p class="editButton">
					<sj:submit 
						key="label.request.Edit"
						cssClass="btn-secondary right" cssStyle="margin-left: 20px;"
						replaceTarget="true"
						targets="businessContactPersonSection"
						href="%{editSectionURL}" 
						onErrorTopics="multipleTabsProblem"
						/>
					</p>
				</s:if>	
				<jsp:include page="/jsp/common/request/businessContactPerson.jsp" />
				<input type="hidden" name="sectionId" value="${param.sectionId}" />
				<s:if test="%{#isEdit==true}">
					<div class="highlighted span12">
					<sj:submit key="label.request.Apply" cssClass="btn-primary"
					replaceTarget="true" onBeforeTopics="/fieldCounter/hideCount"
						targets="businessContactPersonSection"
						href="%{applySectionURL}" 
						onErrorTopics="multipleTabsProblem"
						/>
					<sj:a 
						replaceTarget="true" 
						cssClass="btn-tertiary cancel" 
						formIds="businessContactPersonForm"
						targets="businessContactPersonSection" 
						href="%{cancelSectionURL}" onBeforeTopics="/fieldCounter/hideCount"
						onErrorTopics="multipleTabsProblem">
						<s:text name="label.request.common.cancel"/>
					</sj:a>
					</div>	

				</s:if>	
			</s:form>
		</div>
	</c:when>
	
 	<c:when test="${param.sectionId eq 'request.section.issuingBank'}">
		<div id="issuingBankSection">
			<s:form id="issuingBankForm">
			<s:hidden name="requestId" value="%{requestDetails.requestId}"/>
				<s:if test="%{#isEdit==false}">
					<p class="editButton">
					<sj:submit 
						key="label.request.Edit"
						cssClass="btn-secondary right" cssStyle="margin-left: 20px;"
						replaceTarget="true"
						targets="issuingBankSection"
						href="%{editSectionURL}" 
						onErrorTopics="multipleTabsProblem"
					/>
					</p>
				</s:if>		
				<jsp:include page="/jsp/common/request/issuingBank.jsp" />
				<input type="hidden" name= "sectionId" value="${param.sectionId}" />
				<s:if test="%{#isEdit==true}">
				<div class="highlighted span12">
				<sj:submit key="label.request.Apply" cssClass="btn-primary"
					replaceTarget="true" onBeforeTopics="/fieldCounter/hideCount"
						targets="issuingBankSection"
						href="%{applySectionURL}" 
						onErrorTopics="multipleTabsProblem"
						/>
					<sj:a 
						replaceTarget="true" 
						cssClass="btn-tertiary cancel" 
						formIds="issuingBankForm"
						targets="issuingBankSection" 
						href="%{cancelSectionURL}" onBeforeTopics="/fieldCounter/hideCount"
						onErrorTopics="multipleTabsProblem">
						<s:text name="label.request.common.cancel"/>
					</sj:a>
					</div>
				</s:if>	
			</s:form>
			
		</div>
	</c:when>	
	
	<c:when test="${param.sectionId eq 'request.section.applicant'}">
		<div id="applicantSection">
			<s:form id="applicantForm">
			<s:hidden name="requestId" value="%{requestDetails.requestId}"/>
				<s:if test="%{#isEdit==false}">
					<p class="editButton">
					<sj:submit 
						key="label.request.Edit"
						cssClass="btn-secondary right" cssStyle="margin-left: 20px;"
						replaceTarget="true"
						targets="applicantSection"
						href="%{editSectionURL}" 
						onErrorTopics="multipleTabsProblem"
					/>
					</p>	
						
				</s:if>									
				<jsp:include page="/jsp/common/request/applicant.jsp" />
				<input type="hidden" name= "sectionId" value="${param.sectionId}" />
				<s:if test="%{#isEdit==true}">
					<div class="highlighted span12">
					<sj:submit key="label.request.Apply" cssClass="btn-primary"
					replaceTarget="true" onBeforeTopics="/fieldCounter/hideCount"
						targets="applicantSection"
						href="%{applySectionURL}" 
						onErrorTopics="multipleTabsProblem"
						/>
					<sj:a 
						replaceTarget="true" 
						cssClass="btn-tertiary cancel" 
						formIds="applicantForm"
						targets="applicantSection" 
						href="%{cancelSectionURL}" onBeforeTopics="/fieldCounter/hideCount"
						onErrorTopics="multipleTabsProblem">
						<s:text name="label.request.common.cancel"/>
					</sj:a>
					</div>	
				</s:if>
			</s:form>
			
		</div>
	</c:when>
		
	<c:when test="${param.sectionId eq 'request.section.beneficiary'}">
		<div id="beneficiarySection">
			<s:form id="beneficiaryForm">
			<s:hidden name="requestId" value="%{requestDetails.requestId}"/>
				<s:if test="%{#isEdit==false}">
					<p class="editButton">
					<sj:submit 
					key="label.request.Edit"
					cssClass="btn-secondary right" cssStyle="margin-left: 20px;"
					replaceTarget="true"
					targets="beneficiarySection"
					href="%{editSectionURL}" 
					onErrorTopics="multipleTabsProblem"
					/>
					</p>
				</s:if>					
				<jsp:include page="/jsp/common/request/beneficiary.jsp" />
				<input type="hidden" name= "sectionId" value="${param.sectionId}" />
				<s:if test="%{#isEdit==true}">
					<div class="highlighted span12">
					<sj:submit key="label.request.Apply" cssClass="btn-primary"
					replaceTarget="true" onBeforeTopics="/fieldCounter/hideCount"
						targets="beneficiarySection"
						href="%{applySectionURL}" 
						onErrorTopics="multipleTabsProblem"
						/>
					<sj:a 
						replaceTarget="true" 
						cssClass="btn-tertiary cancel" 
						formIds="beneficiaryForm"
						targets="beneficiarySection" 
						href="%{cancelSectionURL}" onBeforeTopics="/fieldCounter/hideCount"
						onErrorTopics="multipleTabsProblem">
						<s:text name="label.request.common.cancel"/>
					</sj:a>
					</div>
				</s:if>
			</s:form>
			
		</div>
	</c:when>
	
	<c:when test="${param.sectionId eq 'request.section.instrumentTransactionDetails'}">
		<div id="instrumentTransactionDetailsSection">
			<s:form id="instrumentTransactionDetailsForm">
			<s:hidden name="requestId" value="%{requestDetails.requestId}"/>
				<s:if test="%{#isEdit==false}">	
					<p class="editButton">		
					<sj:submit 
						key="label.request.Edit"
						cssClass="btn-secondary right" cssStyle="margin-left: 20px;"
						replaceTarget="true"
						targets="instrumentTransactionDetailsSection"
						href="%{editSectionURL}" 
						onErrorTopics="multipleTabsProblem"
						/>
					</p>
				</s:if>				
				<jsp:include page="/jsp/common/request/instrumentTransactionDetails.jsp" />
				<input type="hidden" name= "sectionId" value="${param.sectionId}" />
				<s:if test="%{#isEdit==true}">
					<div class="highlighted span12">
					<sj:submit key="label.request.Apply" cssClass="btn-primary"
					replaceTarget="true" onBeforeTopics="/fieldCounter/hideCount"
						targets="instrumentTransactionDetailsSection"
						href="%{applySectionURL}" 
						onErrorTopics="multipleTabsProblem"
						/>
					
					<sj:a 
						replaceTarget="true" 
						cssClass="btn-tertiary cancel" 
						formIds="instrumentTransactionDetailsForm"
						targets="instrumentTransactionDetailsSection" 
						href="%{cancelSectionURL}" onBeforeTopics="/fieldCounter/hideCount"
						onErrorTopics="multipleTabsProblem">
						<s:text name="label.request.common.cancel"/>
					</sj:a>
					</div>
				</s:if>					
			</s:form>
			
		</div>
	</c:when>
	
	<c:when test="${param.sectionId eq 'request.section.paymentSchedule'}">
		<div id="paymentScheduleSection">
			<s:form id="paymentScheduleForm">
			<s:hidden name="requestId" value="%{requestDetails.requestId}"/>
				<s:if test="%{#isEdit==false}">
					<p class="editButton">			
					<sj:submit 
						key="label.request.Edit"
						cssClass="btn-secondary right" cssStyle="margin-left: 20px;"
						replaceTarget="true"
						targets="paymentScheduleSection"
						href="%{editSectionURL}" 
						onErrorTopics="multipleTabsProblem"
						/>
					</p>
				</s:if>					
				<jsp:include page="/jsp/common/request/paymentSchedule.jsp" />
				<input type="hidden" name= "sectionId" value="${param.sectionId}" />
				<s:if test="%{#isEdit==true}">	
					<div class="highlighted span12">
					<sj:submit key="label.request.Apply" cssClass="btn-primary"
					replaceTarget="true" onBeforeTopics="/fieldCounter/hideCount"
						targets="paymentScheduleSection"
						href="%{applySectionURL}" 
						onErrorTopics="multipleTabsProblem"
						/>
					<sj:a 
						replaceTarget="true" 
						cssClass="btn-tertiary cancel" 
						formIds="paymentScheduleForm"
						targets="paymentScheduleSection" 
						href="%{cancelSectionURL}" onBeforeTopics="/fieldCounter/hideCount"
						onErrorTopics="multipleTabsProblem">
						<s:text name="label.request.common.cancel"/>
					</sj:a>	
					</div>
				</s:if>	
			</s:form>
		
		</div>
	</c:when> 
	
	<c:when test="${param.sectionId eq 'request.section.format'}">
		<div id="formatSection">			
				<jsp:include page="/jsp/common/request/requestFormat.jsp" />
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