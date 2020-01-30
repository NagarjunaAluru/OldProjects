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
<%@include file="../../common/includeSectionCommonScripts.jsp"%>

</head>
<body>
</c:if>

<s:url id="applySectionURL" action="applySection" />
<s:url id="editSectionURL" action="editSection" />
<s:url id="cancelSectionURL" action="cancelSection" />
<s:set name="isEditMode" value="editMode" />
<s:hidden name="currentSectionId" id="currentSectionId" />
<c:choose>
	<c:when test="${param.sectionId eq 'request.section.tripartyFlag'}">

		<div id="tripartyFlagSection" class="fieldcount_panel">
			<s:form id="tripartyFlagForm">
			<s:hidden name="requestId" value="%{requestDetails.requestId}"/>
				<s:if test="%{#isEditMode==false}">
					<p class="editButton">
					<sj:submit key="label.request.Edit" cssClass="btn-secondary right"
						cssStyle="margin-left: 20px;" replaceTarget="true"
						targets="tripartyFlagSection" href="%{editSectionURL}"
						onBeforeTopics="beforeTracking" 
						onErrorTopics="multipleTabsProblem"/>
					</p>
				</s:if>
				<jsp:include page="/jsp/common/request/tripartyFlagdetails.jsp" >
					<jsp:param name="page" value="TreasuryAnalyst" />
				</jsp:include>
				

				<input type="hidden" name="sectionId" value="${param.sectionId}" />
				<s:if test="%{#isEditMode==false}">
					<s:if test="%{requestDetails.transactionParties.requiresEdits}">
					<div class="row">
						<div class="span44">
							<div class="form-row">
								<label><s:text name="label.request.requiresEdits" />:</label>
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
							<div class="span44">
								<div class="form-row">
									<label> <s:text name="label.request.Sendbacknotes" /> :
									</label>
								</div>
							</div>
							<div class="span5 left">
								<div class="form-row">
									<p class="padding40">
										<c:out
											value="${requestDetails.transactionParties.sendBackNotes}" />
									</p>
								</div>
							</div>
	
						</div>
					</s:if>
					
				</s:if>
				<s:if test="%{#isEditMode==true}">
				<div class="clear"></div>
					<div class="row highlighted">
						<div class="span12">
							<div class="row">
								<div class="form-row">
									<div class="span5 ckeckBoxLabel">
										<label class="checkbox"> <s:checkbox
												name="requestDetails.transactionParties.requiresEdits"
												id="trans" />
										</label><s:text	name="label.request.requiresEdits" />
									</div>
								</div>
							</div>
							<div class="row hide" id="transnote">
								<div class="form-row">
									<div class="span5">
										<div class="textareaCounter"></div>
										<s:textarea onkeypress="return imposeMaxLength(this, 399);"
											name="requestDetails.transactionParties.sendBackNotes"
											theme="aloc" key="label.request.Sendbacknotes"
											cssClass="autosize messageinput" id="transId"/>
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
					<div class="highlighted span12">
				<sj:submit key="label.request.Apply" cssClass="btn-primary"
					replaceTarget="true"
						targets="tripartyFlagSection" href="%{applySectionURL}"
						onCompleteTopics="requireEditTracking" onBeforeTopics="/fieldCounter/hideCount"
						indicator="transactionPartiesTAProcess" onErrorTopics="multipleTabsProblem"/>
					<sj:a replaceTarget="true" cssClass="btn-tertiary cancel"
						formIds="tripartyFlagForm" targets="tripartyFlagSection"
						href="%{cancelSectionURL}" onBeforeTopics="/fieldCounter/hideCount" onCompleteTopics="requireEditTracking" onErrorTopics="multipleTabsProblem">
						<s:text name="label.request.common.cancel" />
					</sj:a>
					<img alt="Loading..." id="transactionPartiesTAProcess" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px;">
				</div>
				</s:if>
			</s:form>
		</div>
	</c:when>

	<c:when test="${param.sectionId eq 'request.section.tpapplicant'}">

		<div id="tpApplicantSection" class="fieldcount_panel">
			<s:form id="tpApplicantForm">
			<s:hidden name="requestId" value="%{requestDetails.requestId}"/>
				<s:if test="%{#isEditMode==false}">
				<p class="editButtonHR3">
					<sj:submit key="label.request.Edit" cssClass="btn-secondary right"
						cssStyle="margin-left: 20px;" replaceTarget="true"
						targets="tpApplicantSection" href="%{editSectionURL}"
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
				<jsp:include page="/jsp/common/request/tpApplicantDetails.jsp" />

				<input type="hidden" name="sectionId" value="${param.sectionId}" />
				<s:if test="%{#isEditMode==false}">
					<s:if test="%{requestDetails.transactionParties.tpApplicantDetails.requiresEdits}">
					<div class="row">
						<div class="span44">
							<div class="form-row">
								<label><s:text name="label.request.requiresEdits" />:</label>
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
							<div class="span44">
								<div class="form-row">
									<label> <s:text name="label.request.Sendbacknotes" /> :
									</label>
								</div>
							</div>
							<div class="span5 left">
								<div class="form-row">
									<p class="padding40">
										<c:out
											value="${requestDetails.transactionParties.tpApplicantDetails.sendBackNotes}" />
									</p>
								</div>
							</div>
	
						</div>
					</s:if>
				</s:if>
				<s:if test="%{#isEditMode==true}">
					<div class="clear"></div>
					<div class="row highlighted">
						<div class="span12  pad10">
							<div class="row">
								<div class="form-row">
									<div class="span5 ckeckBoxLabel">
										<label class="checkbox"> <s:checkbox
												name="requestDetails.transactionParties.tpApplicantDetails.requiresEdits"
												id="applic" />
										</label><s:text name="label.request.requiresEdits" />
									</div>
								</div>
							</div>
							<div class="row hide" id="applicnote">
								<div class="form-row">
									<div class="span5">
										<div class="textareaCounter"></div>
										<s:textarea onkeypress="return imposeMaxLength(this, 399);"
											name="requestDetails.transactionParties.tpApplicantDetails.sendBackNotes"
											theme="aloc" key="label.request.Sendbacknotes"
											cssClass="autosize messageinput" id="applicId"/>
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
					<div class="highlighted span12">
				<sj:submit key="label.request.Apply" cssClass="btn-primary"
					replaceTarget="true"
						targets="tpApplicantSection" href="%{applySectionURL}"
						onCompleteTopics="requireEditTracking" onBeforeTopics="/fieldCounter/hideCount"
						indicator="tpapplicantTAProcess" onErrorTopics="multipleTabsProblem" />
					<sj:a replaceTarget="true" cssClass="btn-tertiary cancel"
						formIds="tpApplicantForm" targets="tpApplicantSection"
						href="%{cancelSectionURL}" onBeforeTopics="/fieldCounter/hideCount" onCompleteTopics="requireEditTracking" onErrorTopics="multipleTabsProblem">
						<s:text name="label.request.common.cancel" />
					</sj:a>
					<img alt="Loading..." id="tpapplicantTAProcess" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px;">
				</div>
				</s:if>
			</s:form>
		</div>
	</c:when>
	<c:when test="${param.sectionId eq 'request.section.tripartyAddress'}">

		<div id="tripartyAddressSection" class="fieldcount_panel">
			<s:form id="tripartyAddressForm">
			<s:hidden name="requestId" value="%{requestDetails.requestId}"/>
				<s:if test="%{#isEditMode==false}">
					<p class="editButtonHR3">
					<sj:submit key="label.request.Edit" cssClass="btn-secondary right"
						cssStyle="margin-left: 20px;" replaceTarget="true"
						targets="tripartyAddressSection" href="%{editSectionURL}"
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
				<jsp:include page="/jsp/common/request/tripartyApplicant.jsp" />

				<input type="hidden" name="sectionId" value="${param.sectionId}" />
				<s:if test="%{#isEditMode==false}">
					<s:if test="%{requestDetails.transactionParties.triPartyApplicant.requiresEdits}">
					<div class="row">
						<div class="span44">
							<div class="form-row">
								<label><s:text name="label.request.requiresEdits" />:</label>
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
							<div class="span44">
								<div class="form-row">
									<label> <s:text name="label.request.Sendbacknotes" /> :
									</label>
								</div>
							</div>
							<div class="span5 left">
								<div class="form-row">
									<p class="padding40">
										<c:out
											value="${requestDetails.transactionParties.triPartyApplicant.sendBackNotes}" />
									</p>
								</div>
							</div>
	
						</div>
					</s:if>
				</s:if>
				<s:if test="%{#isEditMode==true}">

					<div class="row highlighted lastrow">
						<div class="span12 pad10">
							<div class="row">
								<div class="form-row">
									<div class="span5 ckeckBoxLabel">
										<label class="checkbox"> <s:checkbox
												name="requestDetails.transactionParties.triPartyApplicant.requiresEdits"
												id="tpadd" />
										</label><s:text name="label.request.requiresEdits" />
									</div>
								</div>
							</div>
							<div class="row hide" id="tpaddnote">
								<div class="form-row">
									<div class="span5">
										<div class="textareaCounter"></div>
										<s:textarea onkeypress="return imposeMaxLength(this, 399);"
											name="requestDetails.transactionParties.triPartyApplicant.sendBackNotes"
											theme="aloc" key="label.request.Sendbacknotes"
											cssClass="autosize messageinput" id="tpaddId"/>
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
						targets="tripartyAddressSection" href="%{applySectionURL}"
						onCompleteTopics="requireEditTracking" onBeforeTopics="/fieldCounter/hideCount"
						indicator="tripartyAddressTAProcess" onErrorTopics="multipleTabsProblem"/>
					<sj:a replaceTarget="true" cssClass="btn-tertiary cancel"
						formIds="tripartyAddressForm" targets="tripartyAddressSection"
						href="%{cancelSectionURL}" onBeforeTopics="/fieldCounter/hideCount" onCompleteTopics="requireEditTracking" onErrorTopics="multipleTabsProblem">
						<s:text name="label.request.common.cancel" />
					</sj:a>
					<img alt="Loading..." id="tripartyAddressTAProcess" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px;">
				</div>
				</s:if>
			</s:form>
		</div>
	</c:when>

	<c:when
		test="${param.sectionId eq 'request.section.tpCustomerbeneficiary'}">

		<div id="tpCustomerbeneficiarySection" class="fieldcount_panel">
			<s:form id="tpCustomerbeneficiaryForm">
			<s:hidden name="requestId" value="%{requestDetails.requestId}"/>
				<s:if test="%{#isEditMode==false}">
				<p class="editButtonHR3">
					<sj:submit key="label.request.Edit" cssClass="btn-secondary right"
						cssStyle="margin-left: 20px;" replaceTarget="true"
						targets="tpCustomerbeneficiarySection" href="%{editSectionURL}"
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
				<jsp:include page="/jsp/common/request/tpCustomerDetails.jsp" />

				<input type="hidden" name="sectionId" value="${param.sectionId}" />
				<s:if test="%{#isEditMode==false}">
				 <s:if test="%{requestDetails.transactionParties.customer.addressDtls.requiresEdits}">
					<div class="row">
						<div class="span44">
							<div class="form-row">
								<label><s:text name="label.request.requiresEdits" />:</label>
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
							<div class="span44">
								<div class="form-row">
									<label> <s:text name="label.request.Sendbacknotes" /> :
									</label>
								</div>
							</div>
							<div class="span5 left">
								<div class="form-row">
									<p class="padding40">
										<s:property
											value="requestDetails.transactionParties.customer.addressDtls.sendBackNotes" />
									</p>
								</div>
							</div>
						</div>
					</s:if>
				</s:if>

				<s:if test="%{#isEditMode==true}">
					<div class="row highlighted lastrow">
						<div class="span12 pad10">
							<div class="row">
								<div class="form-row">
									<div class="span5 ckeckBoxLabel">
										<label class="checkbox"> <s:checkbox
												name="requestDetails.transactionParties.customer.addressDtls.requiresEdits"
												id="tpcus" />
										</label><s:text name="label.request.requiresEdits" />
									</div>
								</div>
							</div>
							<div class="row hide" id="tpcusnote">
								<div class="form-row">
									<div class="span5">
										<div class="textareaCounter"></div>
										<s:textarea onkeypress="return imposeMaxLength(this, 399);"
											name="requestDetails.transactionParties.customer.addressDtls.sendBackNotes"
											theme="aloc" key="label.request.Sendbacknotes"
											cssClass="autosize messageinput" id="tpcusId"/>
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
						targets="tpCustomerbeneficiarySection" href="%{applySectionURL}"
						onCompleteTopics="requireEditTracking" onBeforeTopics="/fieldCounter/hideCount"
						indicator="tpCustomerbeneficiaryTAProcess" onErrorTopics="multipleTabsProblem"/>
					<sj:a replaceTarget="true" cssClass="btn-tertiary cancel"
						formIds="tpCustomerbeneficiaryForm" onBeforeTopics="/fieldCounter/hideCount"
						targets="tpCustomerbeneficiarySection" href="%{cancelSectionURL}" onCompleteTopics="requireEditTracking" onErrorTopics="multipleTabsProblem">
						<s:text name="label.request.common.cancel" />
					</sj:a>
					<img alt="Loading..." id="tpCustomerbeneficiaryTAProcess" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px;">
				</div>
				</s:if>
			</s:form>
		</div>
	</c:when>

	<c:when
		test="${param.sectionId eq 'request.section.projectDescription'}">
		<div id="projectDescriptionSection">
			<s:form id="projectDescriptionForm">
			<s:hidden name="requestId" value="%{requestDetails.requestId}"/>
				<s:if test="%{#isEditMode==false}">
				<p class="editButton">
					<sj:submit key="label.request.Edit" cssClass="btn-secondary right"
						cssStyle="margin-left: 20px;" replaceTarget="true"
						targets="projectDescriptionSection" href="%{editSectionURL}"
						onBeforeTopics="beforeTracking" onErrorTopics="multipleTabsProblem"/>
				</p>
				</s:if>
				<jsp:include page="/jsp/common/request/projectDescription.jsp" />
				<input type="hidden" name="sectionId" value="${param.sectionId}" />

				<s:if test="%{#isEditMode==false}">
				<s:if test="%{requestDetails.projDescription.requiresEdits}">
					<div class="row">
						<div class="span44">
							<div class="form-row">
								<label><s:text name="label.request.requiresEdits" />:</label>
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
							<div class="span44">
								<div class="form-row">
									<label> <s:text name="label.request.Sendbacknotes" /> :
									</label>
								</div>
							</div>
							<div class="span5 left">
								<div class="form-row">
									<p class="padding40">
										<c:out
											value="${requestDetails.projDescription.sendBackNotes}" />
									</p>
								</div>
							</div>
	
						</div>
					</s:if>
				</s:if>
				<s:if test="%{#isEditMode==true}">
					<div class="row highlighted lastrow">
						<div class="span12 pad10">
							<div class="row">
								<div class="form-row">
									<div class="span5 ckeckBoxLabel">
										<label class="checkbox"> <s:checkbox
												name="requestDetails.projDescription.requiresEdits"
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
											name="requestDetails.projDescription.sendBackNotes"
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
						targets="projectDescriptionSection" href="%{applySectionURL}"
						onCompleteTopics="requireEditTracking" onBeforeTopics="/fieldCounter/hideCount"
						indicator="projectDescriptionTAProcess" onErrorTopics="multipleTabsProblem"/>
					<sj:a replaceTarget="true" cssClass="btn-tertiary cancel"
						formIds="projectDescriptionForm" onBeforeTopics="/fieldCounter/hideCount"
						targets="projectDescriptionSection" href="%{cancelSectionURL}" onCompleteTopics="requireEditTracking" onErrorTopics="multipleTabsProblem">
						<s:text name="label.request.common.cancel" />
					</sj:a>
					<img alt="Loading..." id="projectDescriptionTAProcess" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px;">
				</div>
				</s:if>
				<br />

			</s:form>
		</div>
	</c:when>
	<c:when
		test="${param.sectionId eq 'request.section.instrumentDetails'}">

		<div id="instrumentDetailsSection">
			<s:form id="instrumentDetailsForm">
			<s:hidden name="requestId" value="%{requestDetails.requestId}"/>
				<s:if test="%{#isEditMode==false}">
				<p class="editButton">
					<sj:submit key="label.request.Edit" cssClass="btn-secondary right"
						cssStyle="margin-left: 20px;" replaceTarget="true"
						targets="instrumentDetailsSection" href="%{editSectionURL}"
						onBeforeTopics="beforeTracking" onErrorTopics="multipleTabsProblem"/>
				</p>
				</s:if>
				<jsp:include page="/jsp/common/request/instrumentDetails.jsp" />
				<input type="hidden" name="sectionId" value="${param.sectionId}" />
				<s:if test="%{#isEditMode==false}">
				<s:if test="%{requestDetails.instrumentDetails.requiresEdits}">
					<div class="row">
						<div class="span44">
							<div class="form-row">
								<label><s:text name="label.request.requiresEdits" />:</label>
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
							<div class="span44">
								<div class="form-row">
									<label> <s:text name="label.request.Sendbacknotes" /> :
									</label>
								</div>
							</div>
							<div class="span5 left">
								<div class="form-row">
									<p class="padding40">
										<c:out
											value="${requestDetails.instrumentDetails.sendBackNotes}" />
									</p>
								</div>
							</div>
	
						</div>
					</s:if>
				</s:if>

				<s:if test="%{#isEditMode==true}">

					<div class="row highlighted lastrow">
						<div class="span12 pad10">
							<div class="row">
								<div class="form-row">
									<div class="span5 ckeckBoxLabel">
										<label class="checkbox"> <s:checkbox
												name="requestDetails.instrumentDetails.requiresEdits"
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
											name="requestDetails.instrumentDetails.sendBackNotes"
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
						targets="instrumentDetailsSection" href="%{applySectionURL}"
						onCompleteTopics="requireEditTracking" onBeforeTopics="/fieldCounter/hideCount"
						indicator="instrumentDetailsBGTAProcess" onErrorTopics="multipleTabsProblem"/>
					<sj:a replaceTarget="true" cssClass="btn-tertiary cancel"
						formIds="instrumentDetailsForm" targets="instrumentDetailsSection"
						href="%{cancelSectionURL}" onBeforeTopics="/fieldCounter/hideCount" onCompleteTopics="requireEditTracking" onErrorTopics="multipleTabsProblem">
						<s:text name="label.request.common.cancel" />
					</sj:a>
					<img alt="Loading..." id="instrumentDetailsBGTAProcess" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px;">
				</div>
				</s:if>
				<br />

			</s:form>
		</div>
	</c:when>

	<c:when test="${param.sectionId eq 'request.section.instrumentRisk'}">

		<div id="instrumentRiskSection">
			<s:form id="instrumentRiskForm">
			<s:hidden name="requestId" value="%{requestDetails.requestId}"/>
				<s:if test="%{#isEditMode==false}">
				<p class="editButton">
					<sj:submit key="label.request.Edit" cssClass="btn-secondary right"
						cssStyle="margin-left: 20px;" replaceTarget="true"
						targets="instrumentRiskSection" href="%{editSectionURL}"
						onBeforeTopics="beforeTracking" onErrorTopics="multipleTabsProblem"/>
				</p>
				</s:if>
				<jsp:include page="/jsp/common/request/instrumentRisk.jsp" />
				<input type="hidden" name="sectionId" value="${param.sectionId}" />
				<s:if test="%{#isEditMode==false}">
					<s:if test="%{requestDetails.instrumentRisk.requiresEdits}">
					<div class="row">
						<div class="span44">
							<div class="form-row">
								<label><s:text name="label.request.requiresEdits" />:</label>
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
							<div class="span44">
								<div class="form-row">
									<label> <s:text name="label.request.Sendbacknotes" /> :
									</label>
								</div>
							</div>
							<div class="span5 left">
								<div class="form-row">
									<p class="padding40">
										<c:out value="${requestDetails.instrumentRisk.sendBackNotes}" />
									</p>
								</div>
							</div>
	
						</div>
					</s:if>
				</s:if>
				<s:if test="%{#isEditMode==true}">

					<div class="row highlighted lastrow">
						<div class="span12 pad10">
							<div class="row">
								<div class="form-row">
									<div class="span5 ckeckBoxLabel">
										<label class="checkbox"> <s:checkbox
												name="requestDetails.instrumentRisk.requiresEdits"
												id="insrisk" />
										</label><s:text name="label.request.requiresEdits" />
									</div>
								</div>
							</div>
							<div class="row hide" id="insrisknote">
								<div class="span12">
									<div class="form-row">
										<div class="textareaCounter"></div>
										<s:textarea name="requestDetails.instrumentRisk.sendBackNotes"
											theme="aloc" key="label.request.Sendbacknotes" onkeypress="return imposeMaxLength(this, 399);"
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
						targets="instrumentRiskSection" href="%{applySectionURL}"
						onCompleteTopics="requireEditTracking" onBeforeTopics="/fieldCounter/hideCount"
						indicator="instrumentRiskTAProcess" onErrorTopics="multipleTabsProblem"/>
					<sj:a replaceTarget="true" cssClass="btn-tertiary cancel"
						formIds="instrumentRiskForm" targets="instrumentRiskSection"
						href="%{cancelSectionURL}" onBeforeTopics="/fieldCounter/hideCount" onCompleteTopics="requireEditTracking" onErrorTopics="multipleTabsProblem">
						<s:text name="label.request.common.cancel" />
					</sj:a>
					<img alt="Loading..." id="instrumentRiskTAProcess" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px;">
				</div>
				</s:if>
			</s:form>
		</div>
	</c:when>

	<c:when
		test="${param.sectionId eq 'request.section.standbyLetterofCredit'}">
		<div id="standbyLetterofCreditSection">
			<s:form id="standbyLetterofCreditForm">
			<s:hidden name="requestId" value="%{requestDetails.requestId}"/>
				<s:if test="%{#isEditMode==false}">
				<p class="editButton">
					<sj:submit key="label.request.Edit" cssClass="btn-secondary right"
						cssStyle="margin-left: 20px;" replaceTarget="true"
						targets="standbyLetterofCreditSection" href="%{editSectionURL}"
						onBeforeTopics="beforeTracking" onErrorTopics="multipleTabsProblem"/>
				</p>
				</s:if>
				<jsp:include page="/jsp/common/request/standbyLOCConditions.jsp" />
				<input type="hidden" name="sectionId" value="${param.sectionId}" />
				<s:if test="%{#isEditMode==false}">
				<s:if test="%{requestDetails.SBLC.requiresEdits}">
					<div class="row">
						<div class="span44">
							<div class="form-row">
								<label><s:text name="label.request.requiresEdits" />:</label>
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
							<div class="span44">
								<div class="form-row">
									<label> <s:text name="label.request.Sendbacknotes" /> :
									</label>
								</div>
							</div>
							<div class="span5 left">
								<div class="form-row">
									<p class="padding40">
										<c:out value="${requestDetails.SBLC.sendBackNotes}" />
									</p>
								</div>
							</div>
	
						</div>
					</s:if>
				</s:if>
				<s:if test="%{#isEditMode==true}">

					<div class="row highlighted lastrow">
						<div class="span12 pad10">
							<div class="row">
								<div class="form-row">
									<div class="span5 ckeckBoxLabel">
										<label class="checkbox"> <s:checkbox
												name="requestDetails.SBLC.requiresEdits" id="standbylet" />
										</label><s:text name="label.request.requiresEdits" />
									</div>
								</div>
							</div>
							<div class="row hide" id="standbyletnote">
								<div class="span12">
									<div class="form-row">
										<div class="textareaCounter"></div>
										<s:textarea name="requestDetails.SBLC.sendBackNotes"
											theme="aloc" key="label.request.Sendbacknotes" onkeypress="return imposeMaxLength(this, 399);"
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
					replaceTarget="true"
						targets="standbyLetterofCreditSection" href="%{applySectionURL}"
						onCompleteTopics="requireEditTracking" onBeforeTopics="/fieldCounter/hideCount"
						indicator="standbyLetterofCreditTAProcess" onErrorTopics="multipleTabsProblem" />
					<sj:a replaceTarget="true" cssClass="btn-tertiary cancel"
						formIds="standbyLetterofCreditForm" onBeforeTopics="/fieldCounter/hideCount"
						targets="standbyLetterofCreditSection" href="%{cancelSectionURL}" onCompleteTopics="requireEditTracking" onErrorTopics="multipleTabsProblem">
						<s:text name="label.request.common.cancel" />
					</sj:a>
					<img alt="Loading..." id="standbyLetterofCreditTAProcess" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px;">
				</div>
				</s:if>
			</s:form>
		</div>
	</c:when>

	<c:when
		test="${param.sectionId eq 'request.section.instrumentReporting'}">

		<div id="instrumentReportingSection">
			<s:form id="instrumentReportingForm">
			<s:hidden name="requestId" value="%{requestDetails.requestId}"/>
				<s:if test="%{#isEditMode==false}">
				<p class="editButton">
					<sj:submit key="label.request.Edit" cssClass="btn-secondary right"
						cssStyle="margin-left: 20px;" replaceTarget="true"
						targets="instrumentReportingSection" href="%{editSectionURL}"
						onBeforeTopics="beforeTracking" onErrorTopics="multipleTabsProblem"/>
				</p>
				</s:if>
				<jsp:include
					page="/jsp/common/request/instrumentReportingAttributes.jsp" />
				<input type="hidden" name="sectionId" value="${param.sectionId}" />
				<s:if test="%{#isEditMode==false}">
				<s:if test="%{requestDetails.instrReporting.requiresEdits}">
					<div class="row">
						<div class="span44">
							<div class="form-row">
								<label><s:text name="label.request.requiresEdits" />:</label>
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
							<div class="span44">
								<div class="form-row">
									<label> <s:text name="label.request.Sendbacknotes" /> :
									</label>
								</div>
							</div>
							<div class="span5 left">
								<div class="form-row">
									<p class="padding40">
										<c:out value="${requestDetails.instrReporting.sendBackNotes}" />
									</p>
								</div>
							</div>
	
						</div>
					</s:if>
				</s:if>

				<s:if test="%{#isEditMode==true}">

					<div class="row highlighted lastrow">
						<div class="span12 pad10">
							<div class="row">
								<div class="form-row">
									<div class="span5 ckeckBoxLabel">
										<label class="checkbox"> <s:checkbox
												name="requestDetails.instrReporting.requiresEdits"
												id="insrep" />
										</label><s:text name="label.request.requiresEdits" />
									</div>
								</div>
							</div>
							<div class="row hide" id="insrepnote">
								<div class="span12">
									<div class="form-row">
										<div class="textareaCounter"></div>
										<s:textarea name="requestDetails.instrReporting.sendBackNotes"
											theme="aloc" key="label.request.Sendbacknotes" onkeypress="return imposeMaxLength(this, 399);"
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
					replaceTarget="true"
						targets="instrumentReportingSection" href="%{applySectionURL}"
						onCompleteTopics="requireEditTracking" onBeforeTopics="/fieldCounter/hideCount"
						indicator="instrumentReportingTAProcess" onErrorTopics="multipleTabsProblem" />
					<sj:a replaceTarget="true" cssClass="btn-tertiary cancel"
						formIds="instrumentReportingForm" onBeforeTopics="/fieldCounter/hideCount"
						targets="instrumentReportingSection" href="%{cancelSectionURL}" onCompleteTopics="requireEditTracking" onErrorTopics="multipleTabsProblem">
						<s:text name="label.request.common.cancel" />
					</sj:a>
					<img alt="Loading..." id="instrumentReportingTAProcess" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px;">
				</div>
				</s:if>
			</s:form>
		</div>
	</c:when>

	<c:when test="${param.sectionId eq 'request.section.format'}">
		<div id="formatSection">
			<s:form id="formatForm">
			<s:hidden name="requestId" value="%{requestDetails.requestId}"/>
				<s:if test="%{#isEditMode==false}">
					<p class="editButton">
						<sj:submit key="label.request.Edit" cssClass="btn-secondary right"
							cssStyle="margin-left: 20px;" replaceTarget="true"
							targets="formatSection" href="%{editSectionURL}"
							onBeforeTopics="beforeTracking" onErrorTopics="multipleTabsProblem"/>
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
				<s:if test="%{#isEditMode==true}">
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

	<c:when
		test="${param.sectionId eq 'request.section.deliveryInstructions'}">
		<div id="deliveryInstructionsSection">
			<s:form id="deliveryInstructionsForm">
			<s:hidden name="requestId" value="%{requestDetails.requestId}"/>
				<s:if test="%{#isEditMode==false}">
				<p class="editButton">
					<sj:submit key="label.request.Edit" cssClass="btn-secondary right"
						cssStyle="margin-left: 20px;" replaceTarget="true"
						targets="deliveryInstructionsSection" href="%{editSectionURL}"
						onBeforeTopics="beforeTracking" onErrorTopics="multipleTabsProblem"/>
				</p>
				</s:if>
				<jsp:include page="/jsp/common/request/deliveryInstructions.jsp" />
				<input type="hidden" name="sectionId" value="${param.sectionId}" />
				<s:if test="%{#isEditMode==false}">
				<s:if test="%{requestDetails.deliveryInstructions.requiresEdits}">
					<div class="row">
						<div class="span44">
							<div class="form-row">
								<label><s:text name="label.request.requiresEdits" />:</label>
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
							<div class="span44">
								<div class="form-row">
									<label> <s:text name="label.request.Sendbacknotes" /> :
									</label>
								</div>
							</div>
							<div class="span5 left">
								<div class="form-row">
									<p class="padding40">
										<c:out
											value="${requestDetails.deliveryInstructions.sendBackNotes}" />
									</p>
								</div>
							</div>
	
						</div>
					</s:if>
				</s:if>
				<s:if test="%{#isEditMode==true}">
					<div class="row highlighted lastrow">
						<div class="span12 pad10">
							<div class="row">
								<div class="form-row">
									<div class="span5 ckeckBoxLabel">
										<label class="checkbox"> <s:checkbox
												name="requestDetails.deliveryInstructions.requiresEdits"
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
											name="requestDetails.deliveryInstructions.sendBackNotes"
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
						targets="deliveryInstructionsSection" href="%{applySectionURL}"
						onCompleteTopics="requireEditTracking" onBeforeTopics="/fieldCounter/hideCount"
						indicator="deliveryInstructionsBGTAProcess" onErrorTopics="multipleTabsProblem"/>
					<sj:a replaceTarget="true" cssClass="btn-tertiary cancel"
						formIds="deliveryInstructionsForm" onBeforeTopics="/fieldCounter/hideCount"
						targets="deliveryInstructionsSection" href="%{cancelSectionURL}" onCompleteTopics="requireEditTracking" onErrorTopics="multipleTabsProblem">
						<s:text name="label.request.common.cancel" />
					</sj:a>
					<img alt="Loading..." id="deliveryInstructionsBGTAProcess" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px;">
				</div>
				</s:if>
			</s:form>
		</div>
	</c:when>

	<c:when test="${param.sectionId eq 'request.section.attachments'}">
		<div id="attachmentsSection">
			<s:form id="attachmentsForm">
			<s:hidden name="requestId" value="%{requestDetails.requestId}"/>
				<s:if test="%{#isEditMode==false}">
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
				<s:if test="%{#isEditMode==true}">
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