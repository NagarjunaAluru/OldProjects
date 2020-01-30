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
	<script src="${pageContext.request.contextPath}/js/common/amendment.js" type="text/javascript"></script>
</head>
<body>
</c:if>

<s:url id="applySectionURL" action="applySection" />
<s:url id="editSectionURL" action="editSection" />
<s:url id="cancelSectionURL" action="cancelSection" />
<s:set name="isEditMode" value="editMode"/>
<s:hidden name="currentSectionId" id="currentSectionId"/>
<c:choose>
	
	<c:when test="${param.sectionId eq 'request.section.tpapplicant'}">
		<div id="tpApplicantSection">
			<s:form id="tpApplicantForm">
			<s:if test="%{#isEditMode==false}">
				<sj:submit key="label.request.Edit" cssClass="btn right"
					cssStyle="margin-left: 20px;" replaceTarget="true"
					targets="tpApplicantSection" href="%{editSectionURL}"
					onBeforeTopics="beforeTracking"
				/>
			</s:if>
			<jsp:include page="/jsp/common/request/amendment/tpApplicantDetails.jsp" />
			<input type="hidden" name="sectionId" value="${param.sectionId}" />
			<s:if test="%{#isEditMode==true}">
			<div class="highlighted span12">
				<sj:submit key="label.request.Apply" cssClass="btn-primary"
					replaceTarget="true"
					targets="tpApplicantSection" href="%{applySectionURL}"
					onCompleteTopics="completeTracking"
				/>
				<sj:a replaceTarget="true" cssClass="btn-tertiary cancel"
					formIds="tpApplicantForm"
					targets="tpApplicantSection" href="%{cancelSectionURL}">
					<s:text name="label.request.common.undochanges" />
				</sj:a>
				</div>
			</s:if>
			</s:form>
		</div>
	</c:when>
	
	<c:when	test="${param.sectionId eq 'request.section.tripartyAddress'}">
		<div id="tripartyAddressSection">
			<s:form id="tripartyAddressForm">
			<s:if test="%{#isEditMode==false}">
				<sj:submit key="label.request.Edit" cssClass="btn right"
					cssStyle="margin-left: 20px;" replaceTarget="true"
					targets="tripartyAddressSection" href="%{editSectionURL}"
					onBeforeTopics="beforeTracking"
				/>
			</s:if>
			<jsp:include page="/jsp/common/request/amendment/tripartyApplicant.jsp" />
			<input type="hidden" name="sectionId" value="${param.sectionId}" />
			<s:if test="%{#isEditMode==true}">
			<div class="highlighted span12">
				<sj:submit key="label.request.Apply" cssClass="btn-primary"
					replaceTarget="true"
					targets="tripartyAddressSection" href="%{applySectionURL}"
					onCompleteTopics="completeTracking"
				/>
				<sj:a replaceTarget="true" cssClass="btn-tertiary cancel"
					formIds="tripartyAddressForm"
					targets="tripartyAddressSection" href="%{cancelSectionURL}">
					<s:text name="label.request.common.undochanges" />
				</sj:a>
			</div>
			</s:if>
			</s:form>
		</div>
	</c:when>
	
	<c:when	test="${param.sectionId eq 'request.section.tpCustomerbeneficiary'}">
		<div id="tpCustomerbeneficiarySection">
			<s:form id="tpCustomerbeneficiaryForm">
			<s:if test="%{#isEditMode==false}">
				<sj:submit key="label.request.Edit" cssClass="btn right"
					cssStyle="margin-left: 20px;" replaceTarget="true"
					targets="tpCustomerbeneficiarySection" href="%{editSectionURL}"
					onBeforeTopics="beforeTracking"
				/>
			</s:if>
			<jsp:include page="/jsp/common/request/amendment/tpCustomerDetails.jsp" />
			<input type="hidden" name="sectionId" value="${param.sectionId}" />
			<s:if test="%{#isEditMode==true}">
				<div class="highlighted span12">
				<sj:submit key="label.request.Apply" cssClass="btn-primary"
					replaceTarget="true"
					targets="tpCustomerbeneficiarySection" href="%{applySectionURL}"
					onCompleteTopics="completeTracking"
				/>
				<sj:a replaceTarget="true" cssClass="btn-tertiary cancel"
					formIds="tpCustomerbeneficiaryForm"
					targets="tpCustomerbeneficiarySection" href="%{cancelSectionURL}">
					<s:text name="label.request.common.undochanges" />
				</sj:a>
				</div>
			</s:if>
			</s:form>
		</div>
	</c:when>

	<c:when	test="${param.sectionId eq 'request.section.instrumentAmountCurrency'}">
		<div id="instrumentAmountCurrencySection">
			<s:form id="instrumentAmountCurrencyForm">
			<s:if test="%{#isEditMode==false}">
				<sj:submit key="label.request.Edit" cssClass="btn right"
					cssStyle="margin-left: 20px;" replaceTarget="true"
					targets="instrumentAmountCurrencySection" href="%{editSectionURL}"
					onBeforeTopics="beforeTracking"
				/>
			</s:if>
			<jsp:include page="/jsp/common/request/amendment/instrumentAmountCurrency.jsp" />
			<input type="hidden" name="sectionId" value="${param.sectionId}" />
			<s:if test="%{#isEditMode==true}">
				<div class="highlighted span12">
				<sj:submit key="label.request.Apply" cssClass="btn-primary"
					replaceTarget="true"
					targets="instrumentAmountCurrencySection" href="%{applySectionURL}"
					onCompleteTopics="completeTracking"
				/>
				<sj:a replaceTarget="true" cssClass="btn-tertiary cancel"
					formIds="instrumentAmountCurrencyForm"
					targets="instrumentAmountCurrencySection" href="%{cancelSectionURL}">
					<s:text name="label.request.common.undochanges" />
				</sj:a>
				</div>
			</s:if>
			</s:form>
		</div>
	</c:when>
	
	<c:when	test="${param.sectionId eq 'request.section.expirationDates'}">
		<div id="expirationDatesSection">
			<s:form id="expirationDatesForm">
			<s:if test="%{#isEditMode==false}">
				<sj:submit key="label.request.Edit" cssClass="btn right"
					cssStyle="margin-left: 20px;" replaceTarget="true"
					targets="expirationDatesSection" href="%{editSectionURL}"
					onBeforeTopics="beforeTracking"
				/>
			</s:if>
			<jsp:include page="/jsp/common/request/amendment/expirationDates.jsp" />
			<input type="hidden" name="sectionId" value="${param.sectionId}" />
			<s:if test="%{#isEditMode==true}">
				<div class="highlighted span12">
				<sj:submit key="label.request.Apply" cssClass="btn-primary"
					replaceTarget="true"
					targets="expirationDatesSection" href="%{applySectionURL}"
					onCompleteTopics="completeTracking"
				/>
				<sj:a replaceTarget="true" cssClass="btn-tertiary cancel"
					formIds="expirationDatesForm"
					targets="expirationDatesSection" href="%{cancelSectionURL}">
					<s:text name="label.request.common.undochanges" />
				</sj:a>
				</div>
			</s:if>
			</s:form>
		</div>
	</c:when>
	
	<c:when	test="${param.sectionId eq 'request.section.otherChanges'}">
		<div id="otherChangesSection">
			<s:form id="otherChangesForm">
			<s:if test="%{#isEditMode==false}">
				<sj:submit key="label.request.Edit" cssClass="btn right"
					cssStyle="margin-left: 20px;" replaceTarget="true"
					targets="otherChangesSection" href="%{editSectionURL}"
					onBeforeTopics="beforeTracking"
				/>
			</s:if>
			<jsp:include page="/jsp/common/request/amendment/otherChanges.jsp" />
			<input type="hidden" name="sectionId" value="${param.sectionId}" />
			<s:if test="%{#isEditMode==true}">
				<div class="highlighted span12">
				<sj:submit key="label.request.Apply" cssClass="btn-primary"
					replaceTarget="true"
					targets="otherChangesSection" href="%{applySectionURL}"
					onCompleteTopics="completeTracking"
				/>
				<sj:a replaceTarget="true" cssClass="btn-tertiary cancel"
					formIds="otherChangesForm"
					targets="otherChangesSection" href="%{cancelSectionURL}">
					<s:text name="label.request.common.undochanges" />
				</sj:a>
				</div>
			</s:if>
			</s:form>
		</div>
	</c:when>
	
	<c:when test="${param.sectionId eq 'request.section.attachments'}">
		<div id="attachmentsSection">
			<s:form id="attachmentsForm" >
			<s:if test="%{#isEditMode==false}">
				<sj:submit key="label.request.Edit" cssClass="btn right"
					cssStyle="margin-left: 20px;" replaceTarget="true"
					targets="attachmentsSection" href="%{editSectionURL}"
					onBeforeTopics="beforeTracking"
				/>
			</s:if>	
			<jsp:include page="/jsp/common/request/attachments.jsp" />
			<input type="hidden" name="sectionId" value="${param.sectionId}" />
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
	
	<c:when test="${param.sectionId eq 'request.section.businessDelegation'}">
		<div id="businessDelegationSection">
			<s:form id="businessDelegationForm">
				<sj:submit 
					key="label.request.Edit"
					cssClass="btn right" cssStyle="margin-left: 20px;"
					replaceTarget="true"
					targets="businessDelegationSection"
					href="%{editSectionURL}" 
					onBeforeTopics="beforeTracking" 
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
<%-- </s:form> --%>
<c:if test="${param.includeScripts != false}">
	</body>
	</html>
</c:if>