<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<c:set var="isrequireEditSecDiv" value="false" />
	<s:if test="%{requestDetails.buContactPerson.requiresEdits && requestDetails.buContactPerson.sendBackNotes != null && requestDetails.buContactPerson.sendBackNotes !=''}">
		<c:set var="isrequireEditSecDiv" value="true" />
	</s:if>
	<s:if test="%{requestDetails.issuingBankDetails.requiresEdits && requestDetails.issuingBankDetails.sendBackNotes != null && requestDetails.issuingBankDetails.sendBackNotes !=''}">
		<c:set var="isrequireEditSecDiv" value="true" />
	</s:if>
	<s:if test="%{requestDetails.applicantDetails.requiresEdits && requestDetails.applicantDetails.sendBackNotes != null && requestDetails.applicantDetails.sendBackNotes !=''}">
		<c:set var="isrequireEditSecDiv" value="true" />
	</s:if>
	<s:if test="%{requestDetails.beneficiaryDetails.requiresEdits && requestDetails.beneficiaryDetails.sendBackNotes != null && requestDetails.beneficiaryDetails.sendBackNotes !=''}">
		<c:set var="isrequireEditSecDiv" value="true" />
	</s:if>
	<s:if test="%{requestDetails.transactionDetails.requiresEdits && requestDetails.transactionDetails.sendBackNotes != null && requestDetails.transactionDetails.sendBackNotes !=''}">
		<c:set var="isrequireEditSecDiv" value="true" />
	</s:if>
	<s:if test="%{requestDetails.paymentScheduleDetails.requiresEdits && requestDetails.paymentScheduleDetails.sendBackNotes != null && requestDetails.paymentScheduleDetails.sendBackNotes !=''}">
		<c:set var="isrequireEditSecDiv" value="true" />
	</s:if>
	<s:if test="%{requestDetails.format.requiresEdits && requestDetails.format.sendBackNotes != null && requestDetails.format.sendBackNotes != ''}">
		<c:set var="isrequireEditSecDiv" value="true" />
	</s:if>
	<s:if test="%{requestDetails.attachments[0].requiresEdits && requestDetails.attachments[0].sendBackNotes != null && requestDetails.attachments[0].sendBackNotes != ''}">
		<c:set var="isrequireEditSecDiv" value="true" />
	</s:if>
	<c:if test="${fn:length(editSectionList) gt 0 or isrequireEditSecDiv eq 'true'}">
		<div class="row highlighted">
			<div class="span12">
				<s:if test="%{editSectionList.size > 0}">
				<div class="row">
					<div class="span5 wbg">
						<div class="form-row">
							<label><s:text name="label.request.editSections" />:
							</label>

							<s:iterator value="editSectionList">
								<s:if
									test="%{name=='request.section.businessContactPerson'}">
									<p id="businessContactPerson" class="tracking_section_flip">
										<a href="javascript:;"><s:text
												name="label.request.dlocbusinessContactPerson" /></a>
									</p>
								</s:if>
								<s:if test="%{name=='request.section.issuingBank'}">
									<p id="issuingBank" class="tracking_section_flip">
										<a href="javascript:;"><s:text
												name="label.request.issuingBank" /></a>
									</p>
								</s:if>
								<s:if test="%{name=='request.section.applicant'}">
									<p id="applicant" class="tracking_section_flip">
										<a href="javascript:;"><s:text
												name="label.request.applicant" /></a>
									</p>
								</s:if>
								<s:if test="%{name=='request.section.beneficiary'}">
									<p id="beneficiary" class="tracking_section_flip">
										<a href="javascript:;"><s:text
												name="label.request.beneficiary" /></a>
									</p>
								</s:if>
								<s:if
									test="%{name=='request.section.instrumentTransactionDetails'}">
									<p id="instrumentTransactionDetails"
										class="tracking_section_flip">
										<a href="javascript:;"><s:text
												name="label.request.instrumentTransactionDetails" /></a>
									</p>
								</s:if>
								<s:if test="%{name=='request.section.paymentSchedule'}">
									<p id="paymentSchedule" class="tracking_section_flip">
										<a href="javascript:;"><s:text
												name="label.request.paymentSchedule" /> </a>
									</p>
								</s:if>
								<s:if test="%{name=='request.section.format'}">
									<p id="format" class="tracking_section_flip">
										<a href="javascript:;"><s:text
												name="label.request.bglocSectionName.7" /></a>
									</p>
								</s:if>
								<s:if test="%{name=='request.section.attachments'}">
									<p id="attachments" class="tracking_section_flip">
										<a href="javascript:;"><s:text
												name="label.request.bglocSectionName.9" /></a>
									</p>
								</s:if>
							</s:iterator>
							<br />
							<br /> <br />
							<br />
							<div class="form-row" style="">
								<s:url id="cancelAllURL" action="cancelAll" />
								<s:a href="%{cancelAllURL}" cssClass="btn-tertiary cancel">
									<s:text name="label.request.cancelAllChanges" />
								</s:a>
							</div>
						</div>
					</div>
				</div>
				</s:if>
				<div class="row" id="requireEditSecDiv">
					<c:if test="${isrequireEditSecDiv eq 'true'}">
						<div class="span5 wbg">
							<div class="form-row">
								<label><s:text
										name="label.request.requireEditsDetails" />: </label>
								<s:if test="%{requestDetails.buContactPerson.requiresEdits}">
									<p class="requiresEdits">
										<s:text name="label.request.dlocbusinessContactPerson" />
									</p>
								</s:if>
								<s:if
									test="%{requestDetails.issuingBankDetails.requiresEdits}">
									<p class="requiresEdits">
										<s:text name="label.request.issuingBank" />
									</p>
								</s:if>
								<s:if
									test="%{requestDetails.applicantDetails.requiresEdits}">
									<p class="requiresEdits">
										<s:text name="label.request.applicant" />
									</p>
								</s:if>
								<s:if
									test="%{requestDetails.beneficiaryDetails.requiresEdits}">
									<p class="requiresEdits">
										<s:text name="label.request.beneficiary" />
									</p>
								</s:if>
								<s:if
									test="%{requestDetails.transactionDetails.requiresEdits}">
									<p class="requiresEdits">
										<s:text name="label.request.instrumentTransactionDetails" />
									</p>
								</s:if>
								<s:if
									test="%{requestDetails.paymentScheduleDetails.requiresEdits}">
									<p class="requiresEdits">
										<s:text name="label.request.paymentSchedule" />
									</p>
								</s:if>
								<s:if test="%{requestDetails.format.requiresEdits}">
									<p class="requiresEdits">
										<s:text	name="label.request.sbSectionFormat" />
									</p>
								</s:if>
								<s:if test="%{requestDetails.attachments[0].requiresEdits}">
									<p class="requiresEdits">
										<s:text	name="label.request.sbSectionAttachments" />
									</p>
								</s:if>
							</div>
						</div>
					</c:if>
				</div>
			</div>
		</div>
	</c:if>
