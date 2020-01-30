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

<s:url id="applySectionURL" action="applySection" namespace="/int/requestor/review"/>
<s:url id="editSectionURL" action="editSection" namespace="/int/requestor/review" />
<s:url id="cancelSectionURL" action="cancelSection" namespace="/int/requestor/review"/>
<s:set name="isEdit" value="editMode"/>
<s:hidden name="currentSectionId" id="currentSectionId"/>
<c:choose>
	<c:when test="${param.sectionId eq 'request.section.bondDetails'}">
		<div id="bondDetailsSection">
			<s:form id="bondDetailsForm">
			<s:hidden name="requestId" value="%{requestDetails.requestId}"/>
			<s:if test="%{#isEdit==false}">
				<p class="editButton">
				<sj:submit 
					key="label.request.Edit"
					cssClass="btn-secondary right" cssStyle="margin-left: 20px;"
					replaceTarget="true"
					targets="bondDetailsSection"
					href="%{editSectionURL}"
					onErrorTopics="multipleTabsProblem"
					/>
				</p>
			</s:if>	
				<jsp:include page="/jsp/common/request/bondDetailsReadonly.jsp" />
				<input type="hidden" name="sectionId" value="${param.sectionId}" />
				<s:if test="%{#isEdit==true}">
				<div class="highlighted span12">
				<sj:submit key="label.request.Apply" cssClass="btn-primary"
					replaceTarget="true"
					targets="bondDetailsSection"
					href="%{applySectionURL}"
					indicator="bondDetailsReviewProcess"
					onBeforeTopics="/fieldCounter/hideCount"
					onErrorTopics="multipleTabsProblem"
					/>
					
				<sj:a 
						replaceTarget="true" 
						cssClass="btn-tertiary cancel" 
						formIds="bondDetailsForm"
						targets="bondDetailsSection" 
						onBeforeTopics="/fieldCounter/hideCount"
						href="%{cancelSectionURL}"
						onErrorTopics="multipleTabsProblem" >
						<s:text name="label.request.common.cancel"/>
					</sj:a>
					<img alt="Loading..." id="bondDetailsReviewProcess" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px;">
				</div>
				</s:if>	
				
			</s:form>
		</div>		
	</c:when>
	
	<c:when test="${param.sectionId eq 'request.section.principal'}">
		<div id="principalSection">
			<s:form id="principalForm">
			<s:hidden name="requestId" value="%{requestDetails.requestId}"/>
			<s:if test="%{#isEdit==false}">
				<p class="editButton">
				<sj:submit 
					key="label.request.Edit"
					cssClass="btn-secondary right" cssStyle="margin-left: 20px;"
					replaceTarget="true"
					targets="principalSection"
					href="%{editSectionURL}"
					onErrorTopics="multipleTabsProblem"
					/>
				</p>
			</s:if>	
				<jsp:include page="/jsp/common/request/principalDetails.jsp" />
				<input type="hidden" name="sectionId" value="${param.sectionId}" />
				<s:if test="%{#isEdit==true}">
				<div class="highlighted span12">
				<sj:submit key="label.request.Apply" cssClass="btn-primary"
					replaceTarget="true"
					targets="principalSection"
					href="%{applySectionURL}"
					indicator="principalReviewProcess"
					onBeforeTopics="/fieldCounter/hideCount"
					onErrorTopics="multipleTabsProblem"
					/>
					
				<sj:a 
						replaceTarget="true" 
						cssClass="btn-tertiary cancel" 
						formIds="principalForm"
						targets="principalSection" 
						onBeforeTopics="/fieldCounter/hideCount"
						href="%{cancelSectionURL}" 
						onErrorTopics="multipleTabsProblem">
						<s:text name="label.request.common.cancel"/>
					</sj:a>
					<img alt="Loading..." id="principalReviewProcess" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px;">
				</div>
				</s:if>	
				
			</s:form>
		</div>
	</c:when>
	
	<c:when test="${param.sectionId eq 'request.section.obligee'}">
		<div id="obligeeSection">
			<s:form id="obligeeForm">
			<s:hidden name="requestId" value="%{requestDetails.requestId}"/>
			<s:if test="%{#isEdit==false}">
				<p class="editButton">
				<sj:submit 
					key="label.request.Edit"
					cssClass="btn-secondary right" cssStyle="margin-left: 20px;"
					replaceTarget="true"
					targets="obligeeSection"
					href="%{editSectionURL}" 
					onErrorTopics="multipleTabsProblem"
					/>
				</p>
			</s:if>	
				<jsp:include page="/jsp/common/request/obligeeDetails.jsp" />
				<input type="hidden" name="sectionId" value="${param.sectionId}" />
				<s:if test="%{#isEdit==true}">
				<div class="highlighted span12">
				<sj:submit key="label.request.Apply" cssClass="btn-primary"
					replaceTarget="true"
					targets="obligeeSection"
					href="%{applySectionURL}" 
					indicator="obligeeReviewProcess"
					onBeforeTopics="/fieldCounter/hideCount"
					onErrorTopics="multipleTabsProblem"
					/>
					
				<sj:a 
						replaceTarget="true" 
						cssClass="btn-tertiary cancel" 
						formIds="obligeeForm"
						targets="obligeeSection" 
						onBeforeTopics="/fieldCounter/hideCount"
						href="%{cancelSectionURL}"
						onErrorTopics="multipleTabsProblem" >
						<s:text name="label.request.common.cancel"/>
					</sj:a>
					<img alt="Loading..." id="obligeeReviewProcess" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px;">
				</div>
				</s:if>	
				
			</s:form>
		</div>
	</c:when>
	
 	<c:when test="${param.sectionId eq 'request.section.bondRequestor'}">
		<div id="bondRequestorSection">
			<s:form id="bondRequestorForm">
			<s:hidden name="requestId" value="%{requestDetails.requestId}"/>
			<s:if test="%{#isEdit==false}">
				<p class="editButton">
				<sj:submit 
					key="label.request.Edit"
					cssClass="btn-secondary right" cssStyle="margin-left: 20px;"
					replaceTarget="true"
					targets="bondRequestorSection"
					href="%{editSectionURL}" 
					onErrorTopics="multipleTabsProblem"
					/>
				</p>
			</s:if>	
				<jsp:include page="/jsp/common/request/bondRequestor.jsp" />
				<input type="hidden" name= "sectionId" value="${param.sectionId}" />
				<s:if test="%{#isEdit==true}">
				<div class="highlighted span12">
				<sj:submit key="label.request.Apply" cssClass="btn-primary"
					replaceTarget="true"
					targets="bondRequestorSection"
					href="%{applySectionURL}" 
					indicator="bondRequestorReviewProcess"
					onBeforeTopics="/fieldCounter/hideCount"
					onErrorTopics="multipleTabsProblem"
					/>
				<sj:a 
						replaceTarget="true" 
						cssClass="btn-tertiary cancel" 
						formIds="bondRequestorForm"
						targets="bondRequestorSection" 
						onBeforeTopics="/fieldCounter/hideCount"
						href="%{cancelSectionURL}"
						onErrorTopics="multipleTabsProblem" >
						<s:text name="label.request.common.cancel"/>
					</sj:a>
					<img alt="Loading..." id="bondRequestorReviewProcess" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px;">
				</div>
				</s:if>	
				
			</s:form>
		</div>
	</c:when>	
	
	<c:when test="${param.sectionId eq 'request.section.requestorMailingAddress'}">
		<div id="requestorMailingAddressSection">
			<s:form id="requestorMailingAddressForm">
			<s:hidden name="requestId" value="%{requestDetails.requestId}"/>
			<s:if test="%{#isEdit==false}">
				<p class="editButton">
				<sj:submit 
					key="label.request.Edit"
					cssClass="btn-secondary right" cssStyle="margin-left: 20px;"
					replaceTarget="true"
					targets="requestorMailingAddressSection"
					href="%{editSectionURL}" 
					onErrorTopics="multipleTabsProblem"
					/>
				</p>		
			</s:if>		
				<jsp:include page="/jsp/common/request/mailingAddress.jsp" />
				<input type="hidden" name= "sectionId" value="${param.sectionId}" />
				<s:if test="%{#isEdit==true}">
				<div class="highlighted span12">
				<sj:submit key="label.request.Apply" cssClass="btn-primary"
					replaceTarget="true"
					targets="requestorMailingAddressSection"
					href="%{applySectionURL}" 
					indicator="requestorMailReviewProcess"
					onBeforeTopics="/fieldCounter/hideCount"
					onErrorTopics="multipleTabsProblem"
					/>
				<sj:a 
						replaceTarget="true" 
						cssClass="btn-tertiary cancel" 
						formIds="requestorMailingAddressForm"
						targets="requestorMailingAddressSection" 
						onBeforeTopics="/fieldCounter/hideCount"
						href="%{cancelSectionURL}" 
						onErrorTopics="multipleTabsProblem">
						<s:text name="label.request.common.cancel"/>
					</sj:a>
				<img alt="Loading..." id="requestorMailReviewProcess" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px;">
				</div>
				</s:if>
			</s:form>
			
		</div>
	</c:when>
		
	<c:when test="${param.sectionId eq 'request.section.deliveryInstructions'}">
		<div id="deliveryInstructionsSection">
			<s:form id="deliveryInstructionsForm">
			<s:hidden name="requestId" value="%{requestDetails.requestId}"/>
			<s:if test="%{#isEdit==false}">
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
				<jsp:include page="/jsp/common/request/sbDeliveryInstructions.jsp" />
				<input type="hidden" name= "sectionId" value="${param.sectionId}" />
				<s:if test="%{#isEdit==true}">
				<div class="highlighted span12">
				<sj:submit key="label.request.Apply" cssClass="btn-primary"
					replaceTarget="true"
					targets="deliveryInstructionsSection"
					href="%{applySectionURL}" 
					indicator="sbDeliveryInstReviewProcess"
					onBeforeTopics="/fieldCounter/hideCount"
					onErrorTopics="multipleTabsProblem"
					/>
					
				<sj:a 
						replaceTarget="true" 
						cssClass="btn-tertiary cancel" 
						formIds="deliveryInstructionsForm"
						targets="deliveryInstructionsSection" 
						onBeforeTopics="/fieldCounter/hideCount"
						href="%{cancelSectionURL}"
						onErrorTopics="multipleTabsProblem" >
						<s:text name="label.request.common.cancel"/>
					</sj:a>
				<img alt="Loading..." id="sbDeliveryInstReviewProcess" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px;">
					</div>
					</s:if>
			</s:form>
			
		</div>
	</c:when>
	
	<c:when test="${param.sectionId eq 'request.section.bondInformation'}">
		<div id="bondInformationSection">
			<s:form id="bondInformationForm">
			<s:hidden name="requestId" value="%{requestDetails.requestId}"/>
			<s:if test="%{#isEdit==false}">
				<p class="editButton">
			 	<sj:submit 
					key="label.request.Edit"
					cssClass="btn-secondary right" cssStyle="margin-left: 20px;"
					replaceTarget="true"
					targets="bondInformationSection"
					href="%{editSectionURL}"
					onErrorTopics="multipleTabsProblem"
					/>
				</p>	
 			</s:if>
				<c:choose>
					<c:when test="${requestDetails.bondDetails.bondTypeId eq '1'}">
						<jsp:include page="/jsp/common/request/bidBondInfo.jsp"></jsp:include>
					</c:when>

					<c:when test="${requestDetails.bondDetails.bondTypeId eq '2'}">
						<jsp:include page="/jsp/common/request/contractBondInfo.jsp"></jsp:include>
					</c:when>

					<c:when test="${requestDetails.bondDetails.bondTypeId eq '3'}">
						<jsp:include page="/jsp/common/request/licensePermitBondInfo.jsp"></jsp:include>
					</c:when>

					<c:when test="${requestDetails.bondDetails.bondTypeId eq '4'}">
						<jsp:include page="../../common/request/courtBondDetails.jsp" />
					</c:when>

					<c:when test="${requestDetails.bondDetails.bondTypeId eq '5'}">
						<jsp:include page="/jsp/common/request/customsBondInfo.jsp"></jsp:include>
					</c:when>
				</c:choose>
				<input type="hidden" name= "sectionId" value="${param.sectionId}" />
				<s:if test="%{#isEdit==true}">
				<div class="highlighted span12">
				<sj:submit key="label.request.Apply" cssClass="btn-primary"
					replaceTarget="true"
					targets="bondInformationSection"
					href="%{applySectionURL}" 
					indicator="bondInformationReviewProcess"
					onBeforeTopics="/fieldCounter/hideCount"
					onErrorTopics="multipleTabsProblem"
					/>
					<sj:a 
						replaceTarget="true" 
						cssClass="btn-tertiary cancel" 
						formIds="bondInformationForm"
						targets="bondInformationSection" 
						onBeforeTopics="/fieldCounter/hideCount"
						href="%{cancelSectionURL}" 
						onErrorTopics="multipleTabsProblem">
						<s:text name="label.request.common.cancel"/>
					</sj:a>
					<img alt="Loading..." id="bondInformationReviewProcess" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px;">
				</div>
				</s:if>	
			</s:form>			
		</div>
	</c:when>
	<c:when test="${param.sectionId eq 'request.section.attorneyBondInformation'}">
		<div id="attorneyBondInformationSection">
			<s:form id="attorneyBondInformationForm">
			<s:hidden name="requestId" value="%{requestDetails.requestId}"/>
			<s:if test="%{#isEdit==false}">
				<p class="editButton">
			 	<sj:submit 
					key="label.request.Edit"
					cssClass="btn-secondary right" cssStyle="margin-left: 20px;"
					replaceTarget="true"
					targets="attorneyBondInformationSection"
					href="%{editSectionURL}"
					onErrorTopics="multipleTabsProblem"
					/>	
				</p>
 			</s:if>	
					<jsp:include page="../../common/request/attorneyInformation.jsp" />
				<input type="hidden" name= "sectionId" value="${param.sectionId}" />
				<s:if test="%{#isEdit==true}">
				<div class="highlighted span12">
				<sj:submit key="label.request.Apply" cssClass="btn-primary"
					replaceTarget="true"
					targets="attorneyBondInformationSection"
					href="%{applySectionURL}" 
					indicator="bondInformationReviewProcess1"
					onBeforeTopics="/fieldCounter/hideCount"
					onErrorTopics="multipleTabsProblem"
					/>
					<sj:a 
						replaceTarget="true" 
						cssClass="btn-tertiary cancel" 
						formIds="attorneyBondInformationForm"
						targets="attorneyBondInformationSection" 
						onBeforeTopics="/fieldCounter/hideCount"
						href="%{cancelSectionURL}" 
						onErrorTopics="multipleTabsProblem">
						<s:text name="label.request.common.cancel"/>
					</sj:a>
					<img alt="Loading..." id="bondInformationReviewProcess1" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px;">
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