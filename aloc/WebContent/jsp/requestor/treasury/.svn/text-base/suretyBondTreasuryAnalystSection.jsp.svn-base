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
	
<script type="text/javascript">
$(document).ready(function() {
	sendbackOnloadShow();
	});
</script>
</head>
<body>
</c:if>

<s:url id="applySectionURL" action="applySection" />
<s:url id="editSectionURL" action="editSection" />
<s:url id="cancelSectionURL" action="cancelSection" />
<s:set name="isEdit" value="editMode" />
<s:hidden name="currentSectionId" id="currentSectionId" />
<c:choose>
	<c:when test="${param.sectionId eq 'request.section.bondDetails'}">
		
		<div id="bondDetailsSection">
			<s:form id="bondDetailsForm">
			<s:hidden name="requestId" value="%{requestDetails.requestId}"/>
				<s:if test="%{#isEdit==false}">
					<p class="editButton">
						<sj:submit key="label.request.Edit" cssClass="btn-secondary right"
							cssStyle="margin-left: 20px;" replaceTarget="true"
							targets="bondDetailsSection" href="%{editSectionURL}"
							onBeforeTopics="beforeTracking" onErrorTopics="multipleTabsProblem"/>
					</p>
				</s:if>
				<jsp:include page="/jsp/common/request/bondDetailsReadonly.jsp" />
				<input type="hidden" name="sectionId" value="${param.sectionId}" />
				<s:if test="%{#isEditMode==false}">
					<s:if test="%{requestDetails.principal.requiresEdits}">
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
									<s:property value="requestDetails.principal.sendBackNotes" />
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
												name="requestDetails.principal.requiresEdits" id="insdet" />
										</label><s:text name="label.request.requiresEdits" />

									</div>
								</div>
							</div>
							<div class="row hide" id="insdetnote">
								<div class="span12">
									<div class="form-row">
										<div class="textareaCounter"></div>
										<s:textarea name="requestDetails.principal.sendBackNotes"
											theme="aloc" key="label.request.Sendbacknotes" onkeypress="return imposeMaxLength(this, 399);"
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
						targets="bondDetailsSection" href="%{applySectionURL}"
						onCompleteTopics="requireEditTracking"
						indicator="bondDetailsTAProcess" 
						onBeforeTopics="/fieldCounter/hideCount" onErrorTopics="multipleTabsProblem"/>

					<sj:a replaceTarget="true" cssClass="btn-tertiary cancel"
						formIds="bondDetailsForm" targets="bondDetailsSection"
						href="%{cancelSectionURL}" onBeforeTopics="/fieldCounter/hideCount" onCompleteTopics="requireEditTracking" onErrorTopics="multipleTabsProblem">
						<s:text name="label.request.common.cancel" />
					</sj:a>
					<img alt="Loading..." id="bondDetailsTAProcess" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px;">
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
						<sj:submit key="label.request.Edit" cssClass="btn-secondary right"
							cssStyle="margin-left: 20px;" replaceTarget="true"
							targets="principalSection" href="%{editSectionURL}"
							onBeforeTopics="beforeTracking" onErrorTopics="multipleTabsProblem"/>
					</p>
				</s:if>
				<jsp:include page="/jsp/common/request/principalDetails.jsp" />
				<input type="hidden" name="sectionId" value="${param.sectionId}" />
				<s:if test="%{#isEditMode==false}">
					<s:if test="%{requestDetails.principal.requiresEdits}">
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
									<s:property value="requestDetails.principal.sendBackNotes" />
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
												name="requestDetails.principal.requiresEdits" id="insdet" />
										</label><s:text name="label.request.requiresEdits" />

									</div>
								</div>
							</div>
							<div class="row hide" id="insdetnote">
								<div class="span12">
									<div class="form-row">
										<div class="textareaCounter"></div>
										<s:textarea name="requestDetails.principal.sendBackNotes"
											theme="aloc" key="label.request.Sendbacknotes" onkeypress="return imposeMaxLength(this, 399);"
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
						targets="principalSection" href="%{applySectionURL}"
						onCompleteTopics="requireEditTracking"
						indicator="principalTAProcess" 
						onBeforeTopics="/fieldCounter/hideCount"
						onErrorTopics="multipleTabsProblem"/>

					<sj:a replaceTarget="true" cssClass="btn-tertiary cancel"
						formIds="principalForm" targets="principalSection"
						href="%{cancelSectionURL}" onBeforeTopics="/fieldCounter/hideCount"
						onErrorTopics="multipleTabsProblem">
						<s:text name="label.request.common.cancel" />
					</sj:a>
					<img alt="Loading..." id="principalTAProcess" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px;">
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
					<sj:submit key="label.request.Edit" cssClass="btn-secondary right"
						cssStyle="margin-left: 20px;" replaceTarget="true"
						targets="obligeeSection" href="%{editSectionURL}"
						onBeforeTopics="beforeTracking" onErrorTopics="multipleTabsProblem"/>
					</p>
				</s:if>
				<jsp:include page="/jsp/common/request/obligeeDetails.jsp" />
				<input type="hidden" name="sectionId" value="${param.sectionId}" />
				<s:if test="%{#isEditMode==false}">
					<s:if test="%{requestDetails.obligee.requiresEdits}">
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
									<c:out value="${requestDetails.obligee.sendBackNotes}" />
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
												name="requestDetails.obligee.requiresEdits" id="insrisk" />
											</label><s:text	name="label.request.requiresEdits" />
									</div>
								</div>
							</div>
							<div class="row hide" id="insrisknote">
								<div class="span12">
									<div class="form-row">
										<div class="textareaCounter"></div>
										<s:textarea name="requestDetails.obligee.sendBackNotes"
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
						targets="obligeeSection" href="%{applySectionURL}"
						onCompleteTopics="requireEditTracking" 
						indicator="obligeeTAProcess"
						onBeforeTopics="/fieldCounter/hideCount" onErrorTopics="multipleTabsProblem"/>

					<sj:a replaceTarget="true" cssClass="btn-tertiary cancel"
						formIds="obligeeForm" targets="obligeeSection"
						href="%{cancelSectionURL}" onBeforeTopics="/fieldCounter/hideCount" onErrorTopics="multipleTabsProblem">
						<s:text name="label.request.common.cancel" />
					</sj:a>
					<img alt="Loading..." id="obligeeTAProcess" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px;">
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
					<sj:submit key="label.request.Edit" cssClass="btn-secondary right"
						cssStyle="margin-left: 20px;" replaceTarget="true"
						targets="bondRequestorSection" href="%{editSectionURL}"
						onBeforeTopics="beforeTracking" onErrorTopics="multipleTabsProblem"/>
					</p>
				</s:if>
				<jsp:include page="/jsp/common/request/bondRequestor.jsp" />
				<input type="hidden" name="sectionId" value="${param.sectionId}" />
				<s:if test="%{#isEditMode==false}">
					<s:if test="%{requestDetails.bondReqDtls.requiresEdits}">
					<div class="row">
						<div class="span2a">
							<div class="form-row">
								<label>
									<s:text	name="label.request.requiresEdits" />:
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
									<c:out value="${requestDetails.bondReqDtls.sendBackNotes}" />
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
												name="requestDetails.bondReqDtls.requiresEdits"
												id="standbylet" /> 
											</label><s:text	name="label.request.requiresEdits" />
									</div>
								</div>
							</div>
							<div class="row hide" id="standbyletnote">
								<div class="span12">
									<div class="form-row">
										<div class="textareaCounter"></div>
										<s:textarea name="requestDetails.bondReqDtls.sendBackNotes"
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
						targets="bondRequestorSection" href="%{applySectionURL}"
						onCompleteTopics="requireEditTracking" 
						indicator="bondRequestorTAProcess"
						onBeforeTopics="/fieldCounter/hideCount"
						onErrorTopics="multipleTabsProblem"/>
					<sj:a replaceTarget="true" cssClass="btn-tertiary cancel"
						formIds="bondRequestorForm" targets="bondRequestorSection"
						href="%{cancelSectionURL}" onBeforeTopics="/fieldCounter/hideCount"
						onErrorTopics="multipleTabsProblem">
						<s:text name="label.request.common.cancel" />
					</sj:a>
					<img alt="Loading..." id="bondRequestorTAProcess" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px;">
				</div>
				</s:if>

			</s:form>
		</div>
	</c:when>

	<c:when
		test="${param.sectionId eq 'request.section.requestorMailingAddress'}">
		<div id="requestorMailingAddressSection">
			<s:form id="requestorMailingAddressForm">
			<s:hidden name="requestId" value="%{requestDetails.requestId}"/>
				<s:if test="%{#isEdit==false}">
				<p class="editButton">
					<sj:submit key="label.request.Edit" cssClass="btn-secondary right"
						cssStyle="margin-left: 20px;" replaceTarget="true"
						targets="requestorMailingAddressSection" href="%{editSectionURL}"
						onBeforeTopics="beforeTracking" onErrorTopics="multipleTabsProblem"/>
				</p>
				</s:if>
				<jsp:include page="/jsp/common/request/mailingAddress.jsp" />
				<input type="hidden" name="sectionId" value="${param.sectionId}" />
				<s:if test="%{#isEditMode==false}">
					<s:if test="%{requestDetails.addressDtls.requiresEdits}">
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
									<c:out value="${requestDetails.addressDtls.sendBackNotes}" />
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
												name="requestDetails.addressDtls.requiresEdits" id="insrep" />
										</label><s:text name="label.request.requiresEdits" />
									</div>
								</div>
							</div>
							<div class="row hide" id="insrepnote">
								<div class="span12">
									<div class="form-row">
										<div class="textareaCounter"></div>
										<s:textarea name="requestDetails.addressDtls.sendBackNotes"
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
						targets="requestorMailingAddressSection" href="%{applySectionURL}"
						onCompleteTopics="requireEditTracking"
						indicator="requestorMailingAddressTAProcess" 
						onBeforeTopics="/fieldCounter/hideCount" onErrorTopics="multipleTabsProblem"/>
					<sj:a replaceTarget="true" cssClass="btn-tertiary cancel"
						formIds="requestorMailingAddressForm"
						targets="requestorMailingAddressSection"
						href="%{cancelSectionURL}" onBeforeTopics="/fieldCounter/hideCount" onCompleteTopics="requireEditTracking" onErrorTopics="multipleTabsProblem">
						<s:text name="label.request.common.cancel" />
					</sj:a>
					<img alt="Loading..." id="requestorMailingAddressTAProcess" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px;">
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
				<s:if test="%{#isEdit==false}">
				<p class="editButton">
					<sj:submit key="label.request.Edit" cssClass="btn-secondary right"
						cssStyle="margin-left: 20px;" replaceTarget="true"
						targets="deliveryInstructionsSection" href="%{editSectionURL}"
						onBeforeTopics="beforeTracking" onErrorTopics="multipleTabsProblem"/>
				</p>
				</s:if>
				<jsp:include page="/jsp/common/request/sbDeliveryInstructions.jsp" />
				<input type="hidden" name="sectionId" value="${param.sectionId}" />
				<s:if test="%{#isEditMode==false}">
					<s:if test="%{requestDetails.deliveryInstructions.requiresEdits}">
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
										value="${requestDetails.deliveryInstructions.sendBackNotes}" />
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
												name="requestDetails.deliveryInstructions.requiresEdits"
												id="delinst" /> 
										</label><s:text	name="label.request.requiresEdits" />
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
						onCompleteTopics="requireEditTracking"
						indicator="deliveryInstructionsTAProcess" 
						onBeforeTopics="/fieldCounter/hideCount" onErrorTopics="multipleTabsProblem"/>

					<sj:a replaceTarget="true" cssClass="btn-tertiary cancel"
						formIds="deliveryInstructionsForm" onBeforeTopics="/fieldCounter/hideCount"
						targets="deliveryInstructionsSection" href="%{cancelSectionURL}" onCompleteTopics="requireEditTracking" onErrorTopics="multipleTabsProblem">
						<s:text name="label.request.common.cancel" />
					</sj:a>
					<img alt="Loading..." id="deliveryInstructionsTAProcess" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px;">
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
					<sj:submit key="label.request.Edit" cssClass="btn-secondary right"
						cssStyle="margin-left: 20px;" replaceTarget="true"
						targets="bondInformationSection" href="%{editSectionURL}"
						onBeforeTopics="beforeTracking" onErrorTopics="multipleTabsProblem"/>
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
				<input type="hidden" name="sectionId" value="${param.sectionId}" />
				<s:if test="%{#isEditMode==false}">
					<s:if test="%{requestDetails.bondInfo.requiresEdits}">
					<div class="row">
						<div class="span2a">
							<div class="form-row">
								<label><s:text
										name="label.request.requiresEdits" />:
								</label>
							</div>
						</div>
						<div class="span7 left">
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
						<div class="span7 left">
							<div class="form-row">
								<p class="padding40">
									<c:out value="${requestDetails.bondInfo.sendBackNotes}" />
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
												name="requestDetails.bondInfo.requiresEdits" id="trans" />
											</label><s:text	name="label.request.requiresEdits" />
									</div>
								</div>
							</div>
							<div class="row hide" id="transnote">
								<div class="span12">
									<div class="form-row">
										<div class="textareaCounter"></div>
										<s:textarea name="requestDetails.bondInfo.sendBackNotes"
											theme="aloc" key="label.request.Sendbacknotes" onkeypress="return imposeMaxLength(this, 399);"
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
					<br />
					<div class="highlighted span12">
					<sj:submit key="label.request.Apply" cssClass="btn-primary"
					replaceTarget="true"
						targets="bondInformationSection" href="%{applySectionURL}"
						onCompleteTopics="requireEditTracking" 
						indicator="bondInformationTAProcess"
						onBeforeTopics="/fieldCounter/hideCount" onErrorTopics="multipleTabsProblem"/>
					<sj:a replaceTarget="true" cssClass="btn-tertiary cancel"
						formIds="bondInformationForm" targets="bondInformationSection"
						href="%{cancelSectionURL}" onBeforeTopics="/fieldCounter/hideCount" onCompleteTopics="requireEditTracking" onErrorTopics="multipleTabsProblem">
						<s:text name="label.request.common.cancel" />
					</sj:a>
					<img alt="Loading..." id="bondInformationTAProcess" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px;">
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
					<sj:submit key="label.request.Edit" cssClass="btn-secondary right"
						cssStyle="margin-left: 20px;" replaceTarget="true"
						targets="attorneyBondInformationSection" href="%{editSectionURL}"
						onBeforeTopics="beforeTracking" onErrorTopics="multipleTabsProblem"/>
					</p>
				</s:if>
				<jsp:include page="../../common/request/attorneyInformation.jsp" />
				<input type="hidden" name="sectionId" value="${param.sectionId}" />
				<s:if test="%{#isEditMode==false}">
					<s:if test="%{requestDetails.bondInfo.attorneyRequiresEdits}">
					<div class="row">
						<div class="span2a">
							<div class="form-row">
								<label>
								 <s:text name="label.request.requiresEdits" />:
								</label>
							</div>
						</div>
						<div class="span7 left">
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
						<div class="span7 left">
							<div class="form-row">
								<p class="padding40">
									<c:out value="${requestDetails.bondInfo.attorneySendBackNotes}" />
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
												name="requestDetails.bondInfo.attorneyRequiresEdits" id="attBond" />
										</label><s:text	name="label.request.requiresEdits" />
										
									</div>
								</div>
							</div>
							<div class="row hide" id="attBondNote">
								<div class="span12">
									<div class="form-row">
										<div class="textareaCounter"></div>
										<s:textarea name="requestDetails.bondInfo.attorneySendBackNotes"
											theme="aloc" key="label.request.Sendbacknotes" onkeypress="return imposeMaxLength(this, 399);"
											cssClass="autosize messageinput" id="attBondId"/>
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
						targets="attorneyBondInformationSection" href="%{applySectionURL}"
						onCompleteTopics="requireEditTracking" 
						indicator="bondInformationTAProcess1"
						onBeforeTopics="/fieldCounter/hideCount"
						onErrorTopics="multipleTabsProblem"/>
					<sj:a replaceTarget="true" cssClass="btn-tertiary cancel"
						formIds="attorneyBondInformationForm" targets="attorneyBondInformationSection"
						href="%{cancelSectionURL}" onBeforeTopics="/fieldCounter/hideCount" onCompleteTopics="requireEditTracking"
						onErrorTopics="multipleTabsProblem">
						<s:text name="label.request.common.cancel" />
					</sj:a>
					<img alt="Loading..." id="bondInformationTAProcess1" src="${pageContext.request.contextPath}/img/loading.gif" style="display:none;height: 20px;width: 20px;">
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
			<s:form id="attachmentsForm">
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