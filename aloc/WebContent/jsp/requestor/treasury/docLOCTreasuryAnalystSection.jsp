<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:if test="${param.includeScripts != false}">
<!DOCTYPE html>
<html>
<head>
 <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%@include file="../../common/includeSectionCommonScripts.jsp" %>

</head>
<body>
</c:if>

<s:url id="applySectionURL" action="applySection" />
<s:url id="editSectionURL" action="editSection" />
<s:url id="cancelSectionURL" action="cancelSection" />

<s:set name="isEdit" value="editMode" />
<s:hidden name="currentSectionId" id="currentSectionId" />
<c:choose>
	<c:when
		test="${param.sectionId eq 'request.section.businessContactPerson'}">
		<div id="businessContactPersonSection">
			<s:form id="businessContactPersonForm">
			<s:hidden name="requestId" value="%{requestDetails.requestId}"/>
				<s:if test="%{#isEdit==false}">
				<p class="editButton">
					<sj:submit key="label.request.Edit" cssClass="btn-secondary right"
						cssStyle="margin-left: 20px;" replaceTarget="true"
						targets="businessContactPersonSection" href="%{editSectionURL}"
						onBeforeTopics="beforeTracking" onErrorTopics="multipleTabsProblem"/>
				</p>
				</s:if>
				<jsp:include page="/jsp/common/request/businessContactPerson.jsp" />
				<input type="hidden" name="sectionId" value="${param.sectionId}" />
				<s:if test="%{#isEditMode==false}">
					<s:if test="%{requestDetails.buContactPerson.requiresEdits}">
					<div class="row">
						<div class="span3b">
							<div class="form-row">
								<label><s:text
										name="label.request.requiresEdits" />:
								</label>
							</div>
						</div>
						<div class="span5 left">
							<div class="form-row">
								<p class="padding40">									
										<s:text name="label.request.common.yes" />									
								</p>
							</div>
						</div>
					</div>					
					<div class="row">
						<div class="span3b">
							<div class="form-row">
								<label> <s:text name="label.request.Sendbacknotes" /> :
								</label>
							</div>
						</div>
						<div class="span5 left">
							<div class="form-row">
								<p class="padding40">
									<c:out
										value="${requestDetails.buContactPerson.sendBackNotes}" />
								</p>
							</div>
						</div>

					</div>
					</s:if>
				</s:if>

				<s:if test="%{#isEdit==true}">
					<div class="row highlighted lastrow">
						<div class="span12 pad10">
							<div class="row">
								<p class="req-fields hide" id="projreq">
									<s:text name="label.common.siteAdmin.allFieldsAreRequired" />
								</p>
								<div class="form-row">
									<div class="span5 ckeckBoxLabel">
										<label class="checkbox"> <s:checkbox
												name="requestDetails.buContactPerson.requiresEdits"
												id="proj" /> 
										</label><s:text name="label.request.requiresEdits" />
									</div>
								</div>
							</div>
							<div class="row hide" id="projnote">
								<div class="span12">
									<div class="form-row">
										<div class="textareaCounter"></div>
										<s:textarea onkeypress="return imposeMaxLength(this, 399);"
											name="requestDetails.buContactPerson.sendBackNotes"
											theme="aloc" key="label.request.Sendbacknotes"
											cssClass="autosize messageinput" id="projId"/>
										<div class="clear"></div>
										<div class="counter">400</div>
										<!-- fix positions -->
										<div class="counterTxt">
											<p class="guidance">
												<s:text name="label.request.textSize" />
											</p>
										</div>
									</div>

								</div>
							</div>
						</div>
					</div>
					<br />

					<div class="highlighted span12">
					<sj:submit key="label.request.Apply" cssClass="btn-primary"
					replaceTarget="true"
						targets="businessContactPersonSection" href="%{applySectionURL}"
						onCompleteTopics="requireEditTracking" onBeforeTopics="/fieldCounter/hideCount" onErrorTopics="multipleTabsProblem"/>
					<sj:a replaceTarget="true" cssClass="btn-tertiary cancel"
						formIds="businessContactPersonForm" onBeforeTopics="/fieldCounter/hideCount"
						targets="businessContactPersonSection" href="%{cancelSectionURL}" onCompleteTopics="requireEditTracking" onErrorTopics="multipleTabsProblem">
						<s:text name="label.request.common.cancel" />
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
					<sj:submit key="label.request.Edit" cssClass="btn-secondary right"
						cssStyle="margin-left: 20px;" replaceTarget="true"
						targets="issuingBankSection" href="%{editSectionURL}"
						onBeforeTopics="beforeTracking" onErrorTopics="multipleTabsProblem"/>
				</p>
				</s:if>
				<jsp:include page="/jsp/common/request/issuingBank.jsp" />
				<input type="hidden" name="sectionId" value="${param.sectionId}" />

				<s:if test="%{#isEditMode==false}">
					<s:if test="%{requestDetails.issuingBankDetails.requiresEdits}">
					<div class="row">
						<div class="span2a">
							<div class="form-row">
								<label><s:text
										name="label.request.requiresEdits" />:
								</label>
							</div>
						</div>
						<div class="span5 left">
							<div class="form-row">
								<p class="padding40">									
										<s:text name="label.request.common.yes" />
								</p>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="span2a">
							<div class="form-row">
								<label> <s:text name="label.request.Sendbacknotes" /> :
								</label>
							</div>
						</div>
						<div class="span5 left">
							<div class="form-row">
								<p class="padding40">
									<c:out
										value="${requestDetails.issuingBankDetails.sendBackNotes}" />
								</p>
							</div>
						</div>

					</div>
					</s:if>
				</s:if>
				<s:if test="%{#isEdit==true}">
					<div class="row highlighted lastrow">
						<div class="span12 pad10">
							<div class="row">
								<p class="req-fields hide" id="insdetreq">
									<s:text name="label.common.siteAdmin.allFieldsAreRequired" />
								</p>
								<div class="form-row">
									<div class="span5 ckeckBoxLabel">
										<label class="checkbox"> <s:checkbox
												name="requestDetails.issuingBankDetails.requiresEdits"
												id="insdet" />
										</label><s:text name="label.request.requiresEdits" />
									</div>
								</div>
							</div>
							<div class="row hide" id="insdetnote">
								<div class="span12">
									<div class="form-row">
										<div class="textareaCounter"></div>
										<s:textarea onkeypress="return imposeMaxLength(this, 399);"
											name="requestDetails.issuingBankDetails.sendBackNotes"
											theme="aloc" key="label.request.Sendbacknotes"
											cssClass="autosize messageinput" id="insdetId"/>
										<div class="clear"></div>
										<div class="counter">400</div>
										<!-- fix positions -->
										<div class="counterTxt">
											<p class="guidance">
												<s:text name="label.request.textSize" />
											</p>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<br />
					<div class="highlighted span12">
					<sj:submit key="label.request.Apply" cssClass="btn-primary"
					replaceTarget="true"
						targets="issuingBankSection" href="%{applySectionURL}"
						onCompleteTopics="requireEditTracking" onBeforeTopics="/fieldCounter/hideCount" onErrorTopics="multipleTabsProblem"/>
					<sj:a replaceTarget="true" cssClass="btn-tertiary cancel"
						formIds="issuingBankForm" targets="issuingBankSection"
						href="%{cancelSectionURL}" onBeforeTopics="/fieldCounter/hideCount" onCompleteTopics="requireEditTracking" onErrorTopics="multipleTabsProblem">
						<s:text name="label.request.common.cancel" />
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
					<sj:submit key="label.request.Edit" cssClass="btn-secondary right"
						cssStyle="margin-left: 20px;" replaceTarget="true"
						targets="applicantSection" href="%{editSectionURL}"
						onBeforeTopics="beforeTracking" onErrorTopics="multipleTabsProblem"/>
				</p>
				</s:if>
				<s:if test="%{#isEditMode==true}">
					<c:if test="${not empty requestDetails.bundleDetails.bundleId }">
						<div class="row">
							<div class="span12">
								<div class="errorbox">
									<div class="noteHead">
										<p class="noteicon">
											<s:text name="label.common.alert" />
										</p>
									</div>
									<div class="noteContent">
											<p><s:text name="warning.bundle.addressChange"/></p>
									</div>
								</div>
							</div>
						</div>
					</c:if>
				</s:if>
				<jsp:include page="/jsp/common/request/applicant.jsp" />
				<input type="hidden" name="sectionId" value="${param.sectionId}" />
				<s:if test="%{#isEditMode==false}">
					<s:if test="%{requestDetails.applicantDetails.requiresEdits}">
					<div class="row">
						<div class="span2">
							<div class="form-row">
								<label><s:text
										name="label.request.requiresEdits" />:
								</label>
							</div>
						</div>
						<div class="span5 left">
							<div class="form-row">
								<p class="padding40">									
										<s:text name="label.request.common.yes" />
								</p>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="span2">
							<div class="form-row">
								<label> <s:text name="label.request.Sendbacknotes" /> :
								</label>
							</div>
						</div>
						<div class="span5 left">
							<div class="form-row">
								<p class="padding40">
									<c:out
										value="${requestDetails.applicantDetails.sendBackNotes}" />
								</p>
							</div>
						</div>

					</div>
					</s:if>
				</s:if>

				<s:if test="%{#isEdit==true}">
					<div class="row highlighted lastrow">
						<div class="span12 pad10">
							<div class="row">
								<p class="req-fields hide" id="insriskreq">
									<s:text name="label.common.siteAdmin.allFieldsAreRequired" />
								</p>
								<div class="form-row">
									<div class="span5 ckeckBoxLabel">
										<label class="checkbox"> <s:checkbox
												name="requestDetails.applicantDetails.requiresEdits"
												id="insrisk" />
										</label><s:text name="label.request.requiresEdits" />
									</div>
								</div>
							</div>
							<div class="row hide" id="insrisknote">
								<div class="span12">
									<div class="form-row">
										<div class="textareaCounter"></div>
										<s:textarea onkeypress="return imposeMaxLength(this, 399);"
											name="requestDetails.applicantDetails.sendBackNotes"
											theme="aloc" key="label.request.Sendbacknotes"
											cssClass="autosize messageinput" id="insriskId"/>
										<div class="clear"></div>
										<div class="counter">400</div>
										<!-- fix positions -->
										<div class="counterTxt">
											<p class="guidance">
												<s:text name="label.request.textSize" />
											</p>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<br />
					<div class="highlighted span12">
					<sj:submit key="label.request.Apply" cssClass="btn-primary"
					replaceTarget="true"
						targets="applicantSection" href="%{applySectionURL}"
						onCompleteTopics="requireEditTracking" onBeforeTopics="/fieldCounter/hideCount" onErrorTopics="multipleTabsProblem"/>
					<sj:a replaceTarget="true" cssClass="btn-tertiary cancel"
						formIds="applicantForm" targets="applicantSection"
						href="%{cancelSectionURL}" onBeforeTopics="/fieldCounter/hideCount" onCompleteTopics="requireEditTracking" onErrorTopics="multipleTabsProblem">
						<s:text name="label.request.common.cancel" />
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
					<sj:submit key="label.request.Edit" cssClass="btn-secondary right"
						cssStyle="margin-left: 20px;" replaceTarget="true"
						targets="beneficiarySection" href="%{editSectionURL}"
						onBeforeTopics="beforeTracking" onErrorTopics="multipleTabsProblem" />
				</p>
				</s:if>
				<s:if test="%{#isEditMode==true}">
					<c:if test="${not empty requestDetails.bundleDetails.bundleId }">
						<div class="row">
							<div class="span12">
								<div class="errorbox">
									<div class="noteHead">
										<p class="noteicon">
											<s:text name="label.common.alert" />
										</p>
									</div>
									<div class="noteContent">
											<p><s:text name="warning.bundle.addressChange"/></p>
									</div>
								</div>
							</div>
						</div>
					</c:if>
				</s:if>
				<jsp:include page="/jsp/common/request/beneficiary.jsp" />
				<input type="hidden" name="sectionId" value="${param.sectionId}" />
				<s:if test="%{#isEditMode==false}">
					<s:if test="%{requestDetails.beneficiaryDetails.requiresEdits}">
					<div class="row">
						<div class="span2">
							<div class="form-row">
								<label><s:text
										name="label.request.requiresEdits" />:
								</label>
							</div>
						</div>
						<div class="span5 left">
							<div class="form-row">
								<p class="padding40">									
										<s:text name="label.request.common.yes" />
								</p>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="span2">
							<div class="form-row">
								<label> <s:text name="label.request.Sendbacknotes" /> :
								</label>
							</div>
						</div>
						<div class="span5 left">
							<div class="form-row">
								<p class="padding40">
									<c:out
										value="${requestDetails.beneficiaryDetails.sendBackNotes}" />
								</p>
							</div>
						</div>

					</div>
					</s:if>
				</s:if>


				<s:if test="%{#isEdit==true}">
					<div class="row highlighted lastrow">
						<div class="span12 pad10">
							<div class="row">
								<p class="req-fields hide" id="standbyletreq">
									<s:text name="label.common.siteAdmin.allFieldsAreRequired" />
								</p>
								<div class="form-row">
									<div class="span5 ckeckBoxLabel">
										<label class="checkbox"> <s:checkbox
												name="requestDetails.beneficiaryDetails.requiresEdits"
												id="standbylet" />
										</label><s:text name="label.request.requiresEdits" />
									</div>
								</div>
							</div>
							<div class="row hide" id="standbyletnote">
								<div class="span12">
									<div class="form-row">
										<div class="textareaCounter"></div>
										<s:textarea onkeypress="return imposeMaxLength(this, 399);"
											name="requestDetails.beneficiaryDetails.sendBackNotes"
											theme="aloc" key="label.request.Sendbacknotes"
											cssClass="autosize messageinput" id="standbyletId"/>
										<div class="clear"></div>
										<div class="counter">400</div>
										<!-- fix positions -->
										<div class="counterTxt">
											<p class="guidance">
												<s:text name="label.request.textSize" />
											</p>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<br />

					<div class="highlighted span12">
					<sj:submit key="label.request.Apply" cssClass="btn-primary"
					replaceTarget="true" onErrorTopics="multipleTabsProblem"
						targets="beneficiarySection" href="%{applySectionURL}"
						onCompleteTopics="requireEditTracking" onBeforeTopics="/fieldCounter/hideCount"/>
					<sj:a replaceTarget="true" cssClass="btn-tertiary cancel"
						formIds="beneficiaryForm" targets="beneficiarySection"
						href="%{cancelSectionURL}" onBeforeTopics="/fieldCounter/hideCount" onCompleteTopics="requireEditTracking" onErrorTopics="multipleTabsProblem">
						<s:text name="label.request.common.cancel" />
					</sj:a>
					</div>
				</s:if>
			</s:form>

		</div>
	</c:when>

	<c:when
		test="${param.sectionId eq 'request.section.instrumentTransactionDetails'}">
		<div id="instrumentTransactionDetailsSection">
			<s:form id="instrumentTransactionDetailsForm">
			<s:hidden name="requestId" value="%{requestDetails.requestId}"/>
				<s:if test="%{#isEdit==false}">
				<p class="editButton">
					<sj:submit key="label.request.Edit" cssClass="btn-secondary right"
						cssStyle="margin-left: 20px;" replaceTarget="true"
						targets="instrumentTransactionDetailsSection"
						href="%{editSectionURL}" onBeforeTopics="beforeTracking" onErrorTopics="multipleTabsProblem"/>
				</p>
				</s:if>
				<jsp:include
					page="/jsp/common/request/instrumentTransactionDetails.jsp" />
				<input type="hidden" name="sectionId" value="${param.sectionId}" />
				<s:if test="%{#isEditMode==false}">
						<s:if test="%{requestDetails.transactionDetails.requiresEdits}">
					<div class="row">
						<div class="span3b">
							<div class="form-row">
								<label><s:text
										name="label.request.requiresEdits" />:
								</label>
							</div>
						</div>
						<div class="span5 left">
							<div class="form-row">
								<p class="padding40">								
										<s:text name="label.request.common.yes" />
								</p>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="span3b">
							<div class="form-row">
								<label> <s:text name="label.request.Sendbacknotes" /> :
								</label>
							</div>
						</div>
						<div class="span5 left">
							<div class="form-row">
								<p class="padding40">
									<c:out
										value="${requestDetails.transactionDetails.sendBackNotes}" />
								</p>
							</div>
						</div>

					</div>
					</s:if>
				</s:if>
				<s:if test="%{#isEdit==true}">
					<div class="row highlighted lastrow">
						<div class="span12 pad10">
							<div class="row">
								<p class="req-fields hide" id="insrepreq">
									<s:text name="label.common.siteAdmin.allFieldsAreRequired" />
								</p>
								<div class="form-row">
									<div class="span5 ckeckBoxLabel">
										<label class="checkbox"> <s:checkbox
												name="requestDetails.transactionDetails.requiresEdits"
												id="insrep" />
										</label><s:text name="label.request.requiresEdits" />
									</div>
								</div>
							</div>
							<div class="row hide" id="insrepnote">
								<div class="span12">
									<div class="form-row">
										<div class="textareaCounter"></div>
										<s:textarea onkeypress="return imposeMaxLength(this, 399);"
											name="requestDetails.transactionDetails.sendBackNotes"
											theme="aloc" key="label.request.Sendbacknotes"
											cssClass="autosize messageinput" id="insrepId"/>
										<div class="clear"></div>
										<div class="counter">400</div>
										<!-- fix positions -->
										<div class="counterTxt">
											<p class="guidance">
												<s:text name="label.request.textSize" />
											</p>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<br />


					<div class="highlighted span12">
					<sj:submit key="label.request.Apply" cssClass="btn-primary"
					replaceTarget="true" onErrorTopics="multipleTabsProblem"
						targets="instrumentTransactionDetailsSection"
						href="%{applySectionURL}" onCompleteTopics="requireEditTracking" onBeforeTopics="/fieldCounter/hideCount"/>

					<sj:a replaceTarget="true" cssClass="btn-tertiary cancel"
						formIds="instrumentTransactionDetailsForm"
						targets="instrumentTransactionDetailsSection" onErrorTopics="multipleTabsProblem"
						href="%{cancelSectionURL}" onBeforeTopics="/fieldCounter/hideCount" onCompleteTopics="requireEditTracking">
						<s:text name="label.request.common.cancel" />
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
					<sj:submit key="label.request.Edit" cssClass="btn-secondary right"
						cssStyle="margin-left: 20px;" replaceTarget="true"
						targets="paymentScheduleSection" href="%{editSectionURL}"
						onBeforeTopics="beforeTracking" onErrorTopics="multipleTabsProblem" />
					</p>
				</s:if>
				<jsp:include page="/jsp/common/request/paymentSchedule.jsp" />
				<input type="hidden" name="sectionId" value="${param.sectionId}" />

				<s:if test="%{#isEditMode==false}">
					<s:if test="%{requestDetails.paymentScheduleDetails.requiresEdits}">
					<div class="row">
						<div class="span33">
							<div class="form-row">
								<label> <s:text name="label.request.paymentSchedule" />
									<s:text name="label.request.requiresEdits" />:
								</label>
							</div>
						</div>
						<div class="span5 left">
							<div class="form-row">
								<p class="padding40">									
										<s:text name="label.request.common.yes" />
								</p>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="span33">
							<div class="form-row">
								<label> <s:text name="label.request.Sendbacknotes" /> :
								</label>
							</div>
						</div>
						<div class="span5 left">
							<div class="form-row">
								<p class="padding40">
									<c:out
										value="${requestDetails.paymentScheduleDetails.sendBackNotes}" />
								</p>
							</div>
						</div>

					</div>
					</s:if>
				</s:if>
				<s:if test="%{#isEdit==true}">
					<div class="row highlighted lastrow">
						<div class="span12 pad10">
							<div class="row">
								<p class="req-fields hide" id="delinstreq">
									<s:text name="label.common.siteAdmin.allFieldsAreRequired" />
								</p>
								<div class="form-row">
									<div class="span5 ckeckBoxLabel">
										<label class="checkbox"> <s:checkbox
												name="requestDetails.paymentScheduleDetails.requiresEdits"
												id="delinst" />
										</label><s:text name="label.request.requiresEdits" />
									</div>
								</div>
							</div>
							<div class="row hide" id="delinstnote">
								<div class="span12">
									<div class="form-row">
										<div class="textareaCounter"></div>
										<s:textarea onkeypress="return imposeMaxLength(this, 399);"
											name="requestDetails.paymentScheduleDetails.sendBackNotes"
											theme="aloc" key="label.request.Sendbacknotes"
											cssClass="autosize messageinput" id="delinstId"/>
										<div class="clear"></div>
										<div class="counter">400</div>
										<!-- fix positions -->
										<div class="counterTxt">
											<p class="guidance">
												<s:text name="label.request.textSize" />
											</p>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<br />

					<div class="highlighted span12">
					<sj:submit key="label.request.Apply" cssClass="btn-primary"
					replaceTarget="true"
						targets="paymentScheduleSection" href="%{applySectionURL}"
						onCompleteTopics="requireEditTracking" onBeforeTopics="/fieldCounter/hideCount" onErrorTopics="multipleTabsProblem"/>
					<sj:a replaceTarget="true" cssClass="btn-tertiary cancel"
						formIds="paymentScheduleForm" targets="paymentScheduleSection" onErrorTopics="multipleTabsProblem"
						href="%{cancelSectionURL}" onBeforeTopics="/fieldCounter/hideCount" onCompleteTopics="requireEditTracking">
						<s:text name="label.request.common.cancel" />
					</sj:a>
					</div>
				</s:if>
			</s:form>

		</div>
	</c:when>
	
	<c:when test="${param.sectionId eq 'request.section.format'}">
		<div id="formatSection">
			<s:form id="formatForm">
			<s:hidden name="requestId" value="%{requestDetails.requestId}"/>
				<s:if test="%{#isEdit==false}">
					<p class="editButton">
						<sj:submit key="label.request.Edit" cssClass="btn-secondary right"
							cssStyle="margin-left: 20px;" replaceTarget="true"
							targets="formatSection" href="%{editSectionURL}"
							onBeforeTopics="beforeTracking" onErrorTopics="multipleTabsProblem" />
					</p>
				</s:if>
				<jsp:include page="/jsp/common/request/format.jsp" />
				<input type="hidden" name="sectionId" value="${param.sectionId}" />
				<br/>
				<s:if test="%{#isEditMode==false}">
					<s:if test="%{requestDetails.format.requiresEdits}">
					<div class="row">
						<div class="span2">
							<div class="form-row">
								<label>
									<s:text name="label.request.requiresEdits" />:
								</label>
							</div>
						</div>
						
						<div class="span5 left">
							<div class="form-row">
								<p class="padding40">							
									<s:text name="label.request.common.yes" />
								</p>
							</div>
						</div>	
					</div>
					<div class="row">
						<div class="span2">
							<div class="form-row">
								<label> <s:text name="label.request.Sendbacknotes" /> :
								</label>
							</div>
						</div>
						<div class="span5 left">
							<div class="form-row">
								<p class="padding40">
									<s:property value="requestDetails.format.sendBackNotes" />
								</p>
							</div>
						</div>

					</div>
					</s:if>
					</s:if>
				<s:if test="%{#isEdit==true}">
					<div class="row highlighted lastrow">
						<div class="span12 pad10">
							<div class="row">
								<div class="form-row">
									<div class="span5 ckeckBoxLabel">
										<label class="checkbox"> <s:checkbox
												name="requestDetails.format.requiresEdits" id="formatTa" />
										</label><s:text name="label.request.requiresEdits" />

									</div>
								</div>
							</div>
							<div class="row hide" id="formatTaNote">
								<div class="span12">
									<div class="form-row">
										<div class="textareaCounter"></div>
										<s:textarea name="requestDetails.format.sendBackNotes"
											theme="aloc" key="label.request.Sendbacknotes" onkeypress="return imposeMaxLength(this, 399);"
											cssClass="autosize messageinput" id="formatTaId"/>
										<div class="clear"></div>
										<div class="counter">400</div>
										<!-- fix positions -->
										<div class="counterTxt">
											<p class="guidance">
												<s:text name="label.request.textSize" />
											</p>
										</div>
									</div>

								</div>
							</div>
						</div>
					</div>
					<br />
					<div class="highlighted span12">
					<sj:submit key="label.request.Apply" cssClass="btn-primary"
					replaceTarget="true"
						targets="formatSection" href="%{applySectionURL}"
						onCompleteTopics="requireEditTracking" 
						indicator="formatTAProcess"
						onclick="synchTinyMce()"	
						onErrorTopics="multipleTabsProblem"				
					/>
					<sj:a replaceTarget="true" cssClass="btn-tertiary cancel"
						formIds="formatForm" targets="formatSection"
						href="%{cancelSectionURL}" onCompleteTopics="requireEditTracking" onErrorTopics="multipleTabsProblem">
						<s:text name="label.request.common.cancel" />
					</sj:a>
					<img alt="Loading..." id="formatTAProcess" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px;">
				</div>
				</s:if>

			</s:form>
		</div>
	</c:when>
	
	<c:when test="${param.sectionId eq 'request.section.attachments'}">
		<div id="attachmentsSection">
			<s:form id="attachmentsForm" namespace="/int/requestor" action="validateDocLOCRequestForm">
			<s:hidden name="requestId" value="%{requestDetails.requestId}"/>
				<s:if test="%{#isEdit==false}">
					<p class="editButton">
						<sj:submit key="label.request.Edit" cssClass="btn-secondary right"
							cssStyle="margin-left: 20px;" replaceTarget="true"
							targets="attachmentsSection" href="%{editSectionURL}"
							onBeforeTopics="beforeTracking" onErrorTopics="multipleTabsProblem"/>
					</p>
				</s:if>
				<jsp:include page="/jsp/common/request/attachments.jsp" />
				<input type="hidden" name="sectionId" value="${param.sectionId}" />
				<s:if test="%{#isEditMode==false}">
					<s:if test="%{requestDetails.attachments[0].requiresEdits}">
					<div class="row">
						<div class="span2">
							<div class="form-row">
								<label>
									<s:text name="label.request.requiresEdits" />:
								</label>
							</div>
						</div>
						
						<div class="span5 left">
							<div class="form-row">
								<p class="padding40">							
									<s:text name="label.request.common.yes" />
								</p>
							</div>
						</div>	
					</div>
					<div class="row">
						<div class="span2">
							<div class="form-row">
								<label> <s:text name="label.request.Sendbacknotes" /> :
								</label>
							</div>
						</div>
						<div class="span5 left">
							<div class="form-row">
								<p class="padding40">
									<s:property value="requestDetails.attachments[0].sendBackNotes" />
								</p>
							</div>
						</div>

					</div>
					</s:if>
					</s:if>
				<s:if test="%{#isEdit==true}">
					<div class="row highlighted lastrow">
						<div class="span12 pad10">
							<div class="row">
								<div class="form-row">
									<div class="span5 ckeckBoxLabel">
										<label class="checkbox"> <s:checkbox
												name="requestDetails.attachments[0].requiresEdits" id="attachm" />
										</label><s:text name="label.request.requiresEdits" />

									</div>
								</div>
							</div>
							<div class="row hide" id="attachmnote">
								<div class="span12">
									<div class="form-row">
										<div class="textareaCounter"></div>
										<s:textarea name="requestDetails.attachments[0].sendBackNotes"
											theme="aloc" key="label.request.Sendbacknotes" onkeypress="return imposeMaxLength(this, 399);"
											cssClass="autosize messageinput" id="attachmId"/>
										<div class="clear"></div>
										<div class="counter">400</div>
										<!-- fix positions -->
										<div class="counterTxt">
											<p class="guidance">
												<s:text name="label.request.textSize" />
											</p>
										</div>
									</div>

								</div>
							</div>
						</div>
					</div>
					<br />
					<div class="highlighted span12">
					
					<sj:submit key="label.request.Apply" cssClass="btn-primary"
					replaceTarget="true"
						targets="attachmentsSection" href="%{applySectionURL}"
						onCompleteTopics="requireEditTracking" onErrorTopics="multipleTabsProblem"/>
					<sj:a replaceTarget="true" cssClass="btn-tertiary cancel"
						formIds="attachmentsForm" targets="attachmentsSection"
						href="%{cancelSectionURL}" onCompleteTopics="requireEditTracking" onErrorTopics="multipleTabsProblem">		
						<s:text name="label.request.common.cancel" />									
					</sj:a>
					<img alt="Loading..." id="attachmentsTAProcess" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px;">
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