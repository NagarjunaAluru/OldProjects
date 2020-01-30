<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


	<div class="form-mod lastrow">
		<c:if test="${param.pageType eq 'TreasuryApprover'}">
			<h3 id="geRefDetails" class="acc_triggerB">
				<a href="javascript:;">View GE Applicant reference information</a>
			</h3><hr class="h2-hr">
		</c:if>
		<c:if test="${param.pageType eq 'TreasuryAnalyst'}">
			<h3 id="geRefDetails" class="acc_triggerB noborder">
				<a href="javascript:;">View GE Applicant reference information</a>
			</h3><hr class="h2-hr">
		</c:if>
		<div id="geRefDetailsPanel" class="acc_containerB">
			<!--<h3 class="span12 collapsible collapsed">View GE Applicant reference information</h3>-->
			<div class="row smallrow">
				<div class="span2">
					<div class="form-row">
						<label><s:text name="label.request.geApplicantReference" />:</label>
					</div>
				</div>
				<div class="span5 left">
					<div class="form-row">
						<p class="padding40">
							<s:property	value="requestDetails.transactionParties.tpApplicantDetails.refDetails[0].refValue" />
						</p>
					</div>
				</div>
				<!-- end of block -->
			</div>
			
			<s:set name="geRefSize"	value="requestDetails.amendment.transactionParties.tpApplicantDetails.refDetails.size" />
			<s:if test="#geRefSize > 1">
				<s:iterator value="requestDetails.amendment.transactionParties.tpApplicantDetails.refDetails" status="stat">
					<s:if test="#stat.index != 0">
						<div class="row smallrow">
							<div class="span2">
								<div class="form-row">
									<label><s:text name="label.request.geApplicantReference" /><s:property value="#stat.count" />:</label>
								</div>
							</div>
							<div class="span5 left">
								<div class="form-row">
									<p class="padding40">
										<s:property value="refValue" />
									</p>
								</div>
							</div>
							<!-- end of block -->
						</div>
					</s:if>
				</s:iterator>
			</s:if>
			
			
		</div>
	</div>
