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
	<%@include file="../../../common/includeCommonScripts.jsp" %>
	<script src="${pageContext.request.contextPath}/js/requestor/requestor.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/common/rider.js" type="text/javascript"></script>
</head>
<body>
</c:if>

<s:url id="applySectionURL" action="applySection" namespace="/int/requestor/review"/>
<s:url id="editSectionURL" action="editSection" namespace="/int/requestor/review" />
<s:url id="cancelSectionURL" action="cancelSection" namespace="/int/requestor/review"/>
<s:set name="isEdit" value="editMode"/>
<s:hidden name="currentSectionId" id="currentSectionId"/>
<c:choose>
	
	
	<c:when test="${param.sectionId eq 'request.section.riderPrincipal'}">
		<div id="principalSection">
			<s:form id="principalForm">
			<s:if test="%{#isEdit==false}">
				<sj:submit 
					key="label.request.Edit"
					cssClass="btn right" cssStyle="margin-left: 20px;"
					replaceTarget="true"
					targets="principalSection"
					href="%{editSectionURL}"
					/>
			</s:if>	
				<jsp:include page="/jsp/common/request/suretyRider/riderPrincipal.jsp" />
				<input type="hidden" name= "sectionId" value="${param.sectionId}" />
				<s:if test="%{#isEdit==true}">
				<div class="highlighted span12">
				<sj:submit key="label.request.Apply" cssClass="btn-primary"
					replaceTarget="true"
					targets="principalSection"
					href="%{applySectionURL}"
					/>
					
				<sj:a 
						replaceTarget="true" 
						cssClass="btn-tertiary cancel" 
						formIds="principalForm"
						targets="principalSection" 
						href="%{cancelSectionURL}" >
						<s:text name="label.request.common.cancel"/>
					</sj:a>
					</div>
				</s:if>	
				
			</s:form>
		</div>
	</c:when>
	
	<c:when test="${param.sectionId eq 'request.section.riderObligee'}">
		<div id="obligeeSection">
			<s:form id="obligeeForm">
			<s:if test="%{#isEdit==false}">
				<sj:submit 
					key="label.request.Edit"
					cssClass="btn right" cssStyle="margin-left: 20px;"
					replaceTarget="true"
					targets="obligeeSection"
					href="%{editSectionURL}" 
					/>
			</s:if>	
				<jsp:include page="/jsp/common/request/suretyRider/riderObligee.jsp" />
				<input type="hidden" name= "sectionId" value="${param.sectionId}" />
				<s:if test="%{#isEdit==true}">
				<div class="highlighted span12">
				<sj:submit key="label.request.Apply" cssClass="btn-primary"
					replaceTarget="true"
					targets="obligeeSection"
					href="%{applySectionURL}" 
					/>
					
				<sj:a 
						replaceTarget="true" 
						cssClass="btn-tertiary cancel" 
						formIds="obligeeForm"
						targets="obligeeSection" 
						href="%{cancelSectionURL}" >
						<s:text name="label.request.common.cancel"/>
					</sj:a>
					</div>
				</s:if>	
				
			</s:form>
		</div>
	</c:when>
	
 	<c:when test="${param.sectionId eq 'request.section.riderExpirationDates'}">
		<div id="expirationDatesSection">
			<s:form id="expirationDatesForm">
			<s:if test="%{#isEdit==false}">
				<sj:submit 
					key="label.request.Edit"
					cssClass="btn right" cssStyle="margin-left: 20px;"
					replaceTarget="true"
					targets="expirationDatesSection"
					href="%{editSectionURL}" 
					/>
			</s:if>	
				<jsp:include page="/jsp/common/request/suretyRider/riderExpiratinDate.jsp" />
				<input type="hidden" name= "sectionId" value="${param.sectionId}" />
				<s:if test="%{#isEdit==true}">
				<div class="highlighted span12">
				<sj:submit key="label.request.Apply" cssClass="btn-primary"
					replaceTarget="true"
					targets="expirationDatesSection"
					href="%{applySectionURL}" 
					/>
				<sj:a 
						replaceTarget="true" 
						cssClass="btn-tertiary cancel" 
						formIds="expirationDatesForm"
						targets="expirationDatesSection" 
						href="%{cancelSectionURL}" >
						<s:text name="label.request.common.cancel"/>
					</sj:a>
					</div>
				</s:if>	
				
			</s:form>
		</div>
	</c:when>	
	<c:when test="${param.sectionId eq 'request.section.riderBondInformation'}">
		<div id="bondInformationSection">
			<s:form id="bondInformationForm">
			<s:if test="%{#isEdit==false}">
				<sj:submit 
					key="label.request.Edit"
					cssClass="btn right" cssStyle="margin-left: 20px;"
					replaceTarget="true"
					targets="bondInformationSection"
					href="%{editSectionURL}"
					/>	
			</s:if>			
				<jsp:include page="/jsp/common/request/suretyRider/riderBondInformation.jsp" />
				<input type="hidden" name= "sectionId" value="${param.sectionId}" />
				<s:if test="%{#isEdit==true}">
				<div class="highlighted span12">
				<sj:submit key="label.request.Apply" cssClass="btn-primary"
					replaceTarget="true"
					targets="bondInformationSection"
					href="%{applySectionURL}" 
					/>
					<sj:a 
						replaceTarget="true" 
						cssClass="btn-tertiary cancel" 
						formIds="bondInformationForm"
						targets="bondInformationSection" 
						href="%{cancelSectionURL}" >
						<s:text name="label.request.common.cancel"/>
					</sj:a>
					</div>
				</s:if>	
			</s:form>
			
		</div>
	</c:when>
	
	
	<c:when test="${param.sectionId eq 'request.section.attachments'}">
		<div id="attachmentsSection">
			<s:form id="attachmentsForm" namespace="/int/requestor" action="validateDocLOCRequestForm">
			<s:if test="%{#isEdit==false}">
				<sj:submit 
					key="label.request.Edit"
					cssClass="btn right" cssStyle="margin-left: 20px;"
					replaceTarget="true"
					targets="attachmentsSection"
					href="%{editSectionURL}" 
					/>	
			</s:if>			
				<jsp:include page="/jsp/common/request/attachments.jsp" />
				<input type="hidden" name= "sectionId" value="${param.sectionId}" />
				<s:if test="%{#isEdit==true}">	
				<div class="highlighted span12">
				<sj:submit key="label.request.Apply" cssClass="btn-primary"
					replaceTarget="true"
					targets="attachmentsSection"
					href="%{applySectionURL}" 
					/>
					<sj:a 
						replaceTarget="true" 
						cssClass="btn-tertiary cancel" 
						formIds="attachmentsForm"
						targets="attachmentsSection" 
						href="%{cancelSectionURL}" >
						<s:text name="label.request.common.cancel"/>
					</sj:a>
					</div>
				</s:if>	
			</s:form> 
		</div>		
	</c:when>
	
	<c:when test="${param.sectionId eq 'request.section.riderDeliveryInstructions'}">
		<div id="deliveryInstructionsSection">
			<s:form id="deliveryInstructionsForm">
			<s:if test="%{#isEdit==false}">
				<sj:submit 
					key="label.request.Edit"
					cssClass="btn right" cssStyle="margin-left: 20px;"
					replaceTarget="true"
					targets="deliveryInstructionsSection"
					href="%{editSectionURL}" 
					/>	
			</s:if>			
				<jsp:include page="/jsp/common/request/suretyRider/riderDeliveryInstructions.jsp" />
				<input type="hidden" name= "sectionId" value="${param.sectionId}" />
				<s:if test="%{#isEdit==true}">
				<div class="highlighted span12">
				<sj:submit key="label.request.Apply" cssClass="btn-primary"
					replaceTarget="true"
					targets="deliveryInstructionsSection"
					href="%{applySectionURL}" 
					/>
					
				<sj:a 
						replaceTarget="true" 
						cssClass="btn-tertiary cancel" 
						formIds="deliveryInstructionsForm"
						targets="deliveryInstructionsSection" 
						href="%{cancelSectionURL}" >
						<s:text name="label.request.common.cancel"/>
					</sj:a>
				</div>
					</s:if>
			</s:form>
			
		</div>
	</c:when>
	<c:when test="${param.sectionId eq 'request.section.businessDelegation'}">
		<div id="businessDelegationSection">
			<s:form id="businessDelegationForm">
				<sj:submit 
					key="label.request.Edit"
					cssClass="btn right" cssStyle="margin-left: 20px;"
					replaceTarget="true"
					targets="businessDelegationSection"
					href="%{editSectionURL}" 
					onCompleteTopics="getBusinessApprovers" 
					/>	
							
				<jsp:include page="/jsp/common/request/businessDelegation.jsp" />
				<input type="hidden" name= "sectionId" value="${param.sectionId}" />
			<s:if test="%{#isEditMode==true}">	
				<div class="highlighted span12">
				<sj:submit key="label.request.Apply" cssClass="btn-primary"
					replaceTarget="true"
					targets="businessDelegationSection"
					href="%{applySectionURL}" 
					onCompleteTopics="completeTracking" 
					/>
					
					<sj:a 
						replaceTarget="true" 
						cssClass="btn-tertiary cancel" 
						formIds="businessDelegationForm"
						targets="businessDelegationSection" 
						href="%{cancelSectionURL}" >
						<s:text name="label.request.common.undochanges"/>
					</sj:a>
					</div>
					</s:if>	
			</s:form>
		
		</div>
	</c:when> 
	
	
</c:choose>
<c:if test="${param.includeScripts != false}">
	</body>
	</html>
</c:if>