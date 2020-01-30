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
	<%@include file="../../common/includeSectionCommonScripts.jsp" %>
	<link href="${pageContext.request.contextPath}/css/common/amendment.css" type="text/css" rel="stylesheet" />
	<script src="${pageContext.request.contextPath}/js/common/toWord.js" type="text/javascript"></script>
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
		<s:hidden name="amendmentOrRiderRequestId" value="%{requestDetails.amendment.amendmentRequestId}"/>
		<s:if test="%{#isEditMode==false}">
			<p class="editbtn"><sj:submit key="label.request.Edit" cssClass="btn-secondary right"
				replaceTarget="true" onErrorTopics="multipleTabsProblem"
				targets="tpApplicantSection" href="%{editSectionURL}"
				onBeforeTopics="beforeTracking"
			/></p>
		</s:if>
		<div class="clear">&nbsp;</div>
		<div class="row">
			<div class="span6">
				<div class="row smallrow">
					<div class="span6">
						<h3><s:text name="label.request.applicant" /></h3>
						<hr class="hr3">
					</div>
				</div>
				<jsp:include page="/jsp/common/request/amendment/tranalystApplicanttDetails.jsp" >
					<jsp:param value="amendment.treasuryAnalyst.review.section" name="subsectionId"/>
					<jsp:param name="pageSection" value="Current" />
				</jsp:include>
			</div>
			<c:if test="${requestDetails.amendment.transactionParties.tpApplicantDetails.addressDtls.changeFlag eq 'Y'}">
				<div class="span5 left">
					<div class="row smallrow">
						<div class="span5">
							<h3>Previous</h3>
							<hr class="hr3">
						</div>
					</div>
					<jsp:include page="/jsp/common/request/amendment/tranalystApplicanttDetails.jsp" >
						<jsp:param value="amendment.treasuryAnalyst.review.section" name="subsectionId"/>
						<jsp:param name="pageSection" value="Previous" />
					</jsp:include>
				</div>
			</c:if>
		</div>
		<div class="clear"></div>
		<input type="hidden" name="sectionId" value="${param.sectionId}" />
			<s:if test="%{#isEditMode==true}">
			<div class="row highlighted">
				<div class="highlighted span12">
				<sj:submit key="label.request.Apply" cssClass="btn-primary"
					replaceTarget="true" onErrorTopics="multipleTabsProblem"
					targets="tpApplicantSection" href="%{applySectionURL}"
				/>
				<sj:a replaceTarget="true" cssClass="btn-tertiary cancel"
					formIds="tpApplicantForm" onErrorTopics="multipleTabsProblem"
					targets="tpApplicantSection" href="%{cancelSectionURL}">
					<s:text name="label.request.common.undochanges" />
				</sj:a>
				</div>
			</div>	
			</s:if>
		</s:form>
		</div>
	</c:when>
	
	<c:when	test="${param.sectionId eq 'request.section.tripartyAddress'}">
		<div id="tripartyAddressSection">
		<s:form id="tripartyAddressForm">
		<s:hidden name="amendmentOrRiderRequestId" value="%{requestDetails.amendment.amendmentRequestId}"/>
		<s:if test="%{#isEditMode==false}">
			<p class="editbtn"><sj:submit key="label.request.Edit" cssClass="btn-secondary right"
				replaceTarget="true" onErrorTopics="multipleTabsProblem"
				targets="tripartyAddressSection" href="%{editSectionURL}"
				onBeforeTopics="beforeTracking"
			/></p>
		</s:if>	
		<div class="clear">&nbsp;</div>
		<div class="row">
			<div class="span6">
				<div class="row smallrow">
					<div class="span6">
						<h3><s:text name="label.request.triPartyApplicant" /></h3>
						<hr class="hr3">
					</div>
				</div>
				<jsp:include page="/jsp/common/request/amendment/tranalystTriPartyApplicant.jsp" >
					<jsp:param value="amendment.treasuryAnalyst.review.section" name="subsectionId"/>
					<jsp:param name="pageSection" value="Current" />
				</jsp:include>
			</div>
			<c:if test="${requestDetails.amendment.transactionParties.triPartyApplicant.changeFlag eq 'Y'}">
				<div class="span5 left">
					<div class="row smallrow">
						<div class="span5">
							<h3 class="span12">Previous</h3>
							<hr class="hr3">
						</div>
					</div>
					<jsp:include page="/jsp/common/request/amendment/tranalystTriPartyApplicant.jsp" >
						<jsp:param value="amendment.treasuryAnalyst.review.section" name="subsectionId"/>
						<jsp:param name="pageSection" value="Previous" />
					</jsp:include>
				</div>
			</c:if>
		</div>
		<div class="clear"></div>
		<input type="hidden" name="sectionId" value="${param.sectionId}" />
			<s:if test="%{#isEditMode==true}">
			<div class="highlighted span12">
				<sj:submit key="label.request.Apply" cssClass="btn-primary"
					replaceTarget="true" onErrorTopics="multipleTabsProblem"
					targets="tripartyAddressSection" href="%{applySectionURL}"
				/>
				<sj:a replaceTarget="true" cssClass="btn-tertiary cancel"
					formIds="tripartyAddressForm" onErrorTopics="multipleTabsProblem"
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
		<s:hidden name="amendmentOrRiderRequestId" value="%{requestDetails.amendment.amendmentRequestId}"/>
		<s:if test="%{#isEditMode==false}">
			<p class="editbtn"><sj:submit key="label.request.Edit" cssClass="btn-secondary right"
				replaceTarget="true" onErrorTopics="multipleTabsProblem"
				targets="tpCustomerbeneficiarySection" href="%{editSectionURL}"
				onBeforeTopics="beforeTracking"
			/></p>
		</s:if>
		<div class="clear">&nbsp;</div>
		<div class="row">
			<div class="span6">
				<div class="row smallrow">
					<div class="span6">
						<h3><s:text name="label.request.customer" /></h3>
						<hr class="hr3">
					</div>
				</div>
				<jsp:include page="/jsp/common/request/amendment/tpCustomerDetails.jsp" >
					<jsp:param value="amendment.treasuryAnalyst.review.section" name="subsectionId"/>
					<jsp:param name="pageSection" value="Current" />
				</jsp:include>
			</div>
			<c:if test="${requestDetails.amendment.transactionParties.customer.addressDtls.changeFlag eq 'Y'}">
				<div class="span5 left">
					<div class="row smallrow">
						<div class="span5">
							<h3>Previous</h3>
							<hr class="hr3">
						</div>
					</div>
					<jsp:include page="/jsp/common/request/amendment/tpCustomerDetails.jsp" >
						<jsp:param value="amendment.treasuryAnalyst.review.section" name="subsectionId"/>
						<jsp:param name="pageSection" value="Previous" />
					</jsp:include>
				</div>
			</c:if>
		</div>
		<div class="clear"></div>
		<input type="hidden" name="sectionId" value="${param.sectionId}" />
			<s:if test="%{#isEditMode==true}">
			<div class="row highlighted">
				<div class="highlighted span12">
				<sj:submit key="label.request.Apply" cssClass="btn-primary"
					replaceTarget="true" onErrorTopics="multipleTabsProblem"
					targets="tpCustomerbeneficiarySection" href="%{applySectionURL}"
				/>
				<sj:a replaceTarget="true" cssClass="btn-tertiary cancel"
					formIds="tpCustomerbeneficiaryForm" onErrorTopics="multipleTabsProblem"
					targets="tpCustomerbeneficiarySection" href="%{cancelSectionURL}">
					<s:text name="label.request.common.undochanges" />
				</sj:a>
				</div>
			</div>	
			</s:if>
		</s:form>
		</div>
	</c:when>

	<c:when	test="${param.sectionId eq 'request.section.instrumentAmountCurrency'}">
		<div class="acc_container" id="instrumentDetailsSection">
			<s:form id="instrumentDetailsForm">
			<s:hidden name="amendmentOrRiderRequestId" value="%{requestDetails.amendment.amendmentRequestId}"/>
				<s:if test="%{#isEditMode==false}">
					<p class="editbtn">
					<sj:submit key="label.request.Edit" cssClass="btn-secondary right"
						replaceTarget="true" onErrorTopics="multipleTabsProblem"
						targets="instrumentDetailsSection" href="%{editSectionURL}"
						onBeforeTopics="beforeTracking"	/>
					</p>
				</s:if>
				<div class="clear"></div>
				<div class="row">
                    <div class="span12">
                    	<div class="form-row">
						<h2 id="instrumentDetails" class="acc acc_active">
							<a href="javascript:;"><s:text
									name="label.request.bglocSectionName.13" />
							</a>
						</h2><hr class="h2-hr">
						</div>
						<jsp:include page="/jsp/common/request/amendment/tranalystInstrumentDetails.jsp" >
							<jsp:param value="amendment.treasuryAnalyst.review.section" name="subsectionId"/>
							<jsp:param name="pageSection" value="Current" />
						</jsp:include>
					</div>
					<%-- <c:if test="${requestDetails.amendment.amendmentInstrumentAmountCurr.changeFlag eq 'Y'}">
						<div class="span5 left">
							<div class="form-row">
								<h2 class="acc acc_active"><a href="javascript:;">Previous</a></h2><hr class="h2-hr">
							</div>
							<jsp:include page="/jsp/common/request/amendment/tranalystInstrumentDetails.jsp" >
								<jsp:param value="amendment.treasuryAnalyst.review.section" name="subsectionId"/>
								<jsp:param name="pageSection" value="Previous" />
							</jsp:include>
						</div>
					</c:if> --%>
				</div>
				<div class="clear"></div>
				<input type="hidden" name="sectionId" value="${param.sectionId}" />
				<s:if test="%{#isEditMode==true}">
					<div class="highlighted span12">
				<sj:submit key="label.request.Apply" cssClass="btn-primary"
					replaceTarget="true" onErrorTopics="multipleTabsProblem"
							targets="instrumentDetailsSection" href="%{applySectionURL}"
						/>
						<sj:a replaceTarget="true" cssClass="btn-tertiary cancel"
							formIds="instrumentDetailsForm" onErrorTopics="multipleTabsProblem"
							targets="instrumentDetailsSection" href="%{cancelSectionURL}">
							<s:text name="label.request.common.undochanges" />
						</sj:a>
					</div>
				</s:if>
			</s:form>
		</div>
	</c:when>
	
	<c:when	test="${param.sectionId eq 'request.section.expirationDates'}">
		<div class="acc_container" id="expirationDatesSection">
			<s:form id="expirationDatesForm">
			<s:hidden name="amendmentOrRiderRequestId" value="%{requestDetails.amendment.amendmentRequestId}"/>
				<s:if test="%{#isEditMode==false}">
					<p class="editbtn">
					<sj:submit key="label.request.Edit" cssClass="btn-secondary right"
						replaceTarget="true" onErrorTopics="multipleTabsProblem"
						targets="expirationDatesSection" href="%{editSectionURL}"
						onBeforeTopics="beforeTracking"	/>
					</p>
				</s:if>
				<div class="clear"></div>
				<div class="row">
                    <div class="span6">
                    	<div class="form-row">
						<h2 id="expirationDates" class="acc acc_active">
							<a href="javascript:;">
								<s:text	name="label.request.bglocSectionName.14" />
							</a>
						</h2>
						<hr class="h2-hr">
						</div>
						<jsp:include page="/jsp/common/request/amendment/tranalystExpirationDates.jsp" >
							<jsp:param name="pageSection" value="Current" />
						</jsp:include>
					</div>
					<c:if test="${requestDetails.amendment.expiryDate.changeFlag eq 'Y'}">
						<div class="span5 left">
							<div class="form-row">
								<h2 class="acc acc_active"><a href="javascript:;">Previous</a></h2><hr class="h2-hr">
							</div>
							<jsp:include page="/jsp/common/request/amendment/tranalystExpirationDates.jsp" >
								<jsp:param name="pageSection" value="Previous" />
							</jsp:include>
						</div>
					</c:if>
				</div>
				<div class="clear"></div>
				<input type="hidden" name="sectionId" value="${param.sectionId}" />
				<s:if test="%{#isEditMode==true}">
				<div class="row highlighted">
					<div class="highlighted span12">
				<sj:submit key="label.request.Apply" cssClass="btn-primary"
					replaceTarget="true" onErrorTopics="multipleTabsProblem"
						targets="expirationDatesSection" href="%{applySectionURL}"
					/>
					<sj:a replaceTarget="true" cssClass="btn-tertiary cancel"
						formIds="expirationDatesForm" onErrorTopics="multipleTabsProblem"
						targets="expirationDatesSection" href="%{cancelSectionURL}">
						<s:text name="label.request.common.undochanges" />
					</sj:a>
					</div>
				</div>
				</s:if>
			</s:form>
		</div>
	</c:when>
	
	<c:when	test="${param.sectionId eq 'request.section.otherChanges'}">
		<div class="acc_container" id="otherChangesSection">
			<s:form id="otherChangesForm">
			<s:hidden name="amendmentOrRiderRequestId" value="%{requestDetails.amendment.amendmentRequestId}"/>
				<s:if test="%{#isEditMode==false}">
					<p class="editbtn">
					<sj:submit key="label.request.Edit" cssClass="btn-secondary right"
						replaceTarget="true" onErrorTopics="multipleTabsProblem"
						targets="otherChangesSection" href="%{editSectionURL}"
						onBeforeTopics="beforeTracking"	/>
					</p>
				</s:if>
				<div class="clear"></div>
				<div class="row">
                    <div class="span6">
                    	<div class="form-row">
						<h2 id="otherChanges" class="acc acc_active">
							<a href="javascript:;">
								<s:text	name="label.request.bglocSectionName.18" />
							</a>
						</h2><hr class="h2-hr">
						</div>
						<jsp:include page="/jsp/common/request/amendment/otherChanges.jsp" >
							<jsp:param name="pageSection" value="Current" />
						</jsp:include>
					</div>
					
						<%-- <div class="span5 left">
							<div class="form-row">
								<h2 class="acc acc_active"><a href="javascript:;">Previous</a></h2><hr class="h2-hr">
							</div>
							<jsp:include page="/jsp/common/request/amendment/otherChanges.jsp" >
								<jsp:param name="pageSection" value="Previous" />
							</jsp:include>
						</div> --%>
					
				</div>
				<div class="clear"></div>
				<input type="hidden" name="sectionId" value="${param.sectionId}" />
				<s:if test="%{#isEditMode==true}">
				<div class="row highlighted">
					<div class="highlighted span12">
				<sj:submit key="label.request.Apply" cssClass="btn-primary"
					replaceTarget="true" onErrorTopics="multipleTabsProblem"
						targets="otherChangesSection" href="%{applySectionURL}"
					/>
					<sj:a replaceTarget="true" cssClass="btn-tertiary cancel"
						formIds="otherChangesForm" onErrorTopics="multipleTabsProblem"
						targets="otherChangesSection" href="%{cancelSectionURL}">
						<s:text name="label.request.common.undochanges" />
					</sj:a>
					</div>
				</div>
				</s:if>
			</s:form>
		</div>
	</c:when>
	
	<c:when test="${param.sectionId eq 'request.section.attachments'}">
		<div class="acc_container" id="attachmentsSection">
			<s:form id="attachmentsForm">
			<s:hidden name="amendmentOrRiderRequestId" value="%{requestDetails.amendment.amendmentRequestId}"/>
				<s:if test="%{#isEditMode==false}">
					<p class="editbtn">
					<sj:submit key="label.request.Edit" cssClass="btn-secondary right"
						replaceTarget="true" onErrorTopics="multipleTabsProblem"
						targets="attachmentsSection" href="%{editSectionURL}"
						onBeforeTopics="beforeTracking"	/>
					</p>
				</s:if>
				<h2 id="attachmentsFlip" class="section_flip">
					<a href="javascript:;">
						<s:text	name="label.request.bglocSectionName.9" />
					</a>
				</h2><hr class="h2-hr">
				<div id="attachmentsFlipPanel" class="section_panel">
					<jsp:include page="/jsp/common/request/attachments.jsp" />
				</div>
				<input type="hidden" name="sectionId" value="${param.sectionId}" />
				<s:if test="%{#isEditMode==true}">
				<div class="row highlighted">
					<div class="highlighted span12">
				<sj:submit key="label.request.Apply" cssClass="btn-primary"
					replaceTarget="true" onErrorTopics="multipleTabsProblem"
						targets="attachmentsSection" href="%{applySectionURL}"
					/>
					<sj:a replaceTarget="true" cssClass="btn-tertiary cancel"
						formIds="attachmentsForm" onErrorTopics="multipleTabsProblem"
						targets="attachmentsSection" href="%{cancelSectionURL}">
						<s:text name="label.request.common.undochanges" />
					</sj:a>
					</div>
				</div>
				</s:if>
			</s:form>
		</div>
	</c:when>
	
	<c:when test="${param.sectionId eq 'request.section.deliveryInstructions'}">
		<div class="acc_container" id="deliveryInstructionsSection">
			<s:form id="deliveryInstructionsForm">
			<s:hidden name="amendmentOrRiderRequestId" value="%{requestDetails.amendment.amendmentRequestId}"/>
				<s:if test="%{#isEditMode==false}">
					<p class="editbtn">
					<sj:submit key="label.request.Edit" cssClass="btn-secondary right"
						replaceTarget="true" onErrorTopics="multipleTabsProblem"
						targets="deliveryInstructionsSection" href="%{editSectionURL}"
						onBeforeTopics="beforeTracking"	/>
					</p>
				</s:if>
				<div class="clear"></div>
				<div class="row">
                    <div class="span6">
                    	<div class="form-row">
						<h2 id="deliveryInstructions" class="acc acc_active">
							<a href="javascript:;">
								<s:text	name="label.request.bglocSectionName.8" />
							</a>
						</h2><hr class="h2-hr">
						</div>
						<jsp:include page="/jsp/common/request/amendment/deliveryInstructions.jsp" >
							<jsp:param name="pageSection" value="Current" />
						</jsp:include>
					</div>
					<c:if test="${requestDetails.amendment.deliveryInstructions.changeFlag eq 'Y'}">
						<div class="span6 left">
							<div class="form-row">
								<h2 class="acc acc_active"><a href="javascript:;">Previous</a></h2><hr class="h2-hr">
							</div>
							<jsp:include page="/jsp/common/request/amendment/deliveryInstructions.jsp" >
								<jsp:param name="pageSection" value="Previous" />
							</jsp:include>
						</div>
					</c:if>
				</div>
				<div class="clear"></div>
				<input type="hidden" name="sectionId" value="${param.sectionId}" />
				<s:if test="%{#isEditMode==true}">
				<div class="highlighted span12">
				<sj:submit key="label.request.Apply" cssClass="btn-primary"
					replaceTarget="true" onErrorTopics="multipleTabsProblem"
						targets="deliveryInstructionsSection" href="%{applySectionURL}"
					/>
					<sj:a replaceTarget="true" cssClass="btn-tertiary cancel"
						formIds="deliveryInstructionsForm" onErrorTopics="multipleTabsProblem"
						targets="deliveryInstructionsSection" href="%{cancelSectionURL}">
						<s:text name="label.request.common.undochanges" />
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