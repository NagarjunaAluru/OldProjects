<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


	<div class="form-mod lastrow">
		<c:if test="${param.pageType eq 'TreasuryApprover'}">
		<h3 id="geRefDetails" class="acc_triggerC">
			<a href="javascript:;">View Customer/Beneficiary reference information</a>
		</h3><hr class="h2-hr">
		</c:if>
		<c:if test="${param.pageType eq 'TreasuryAnalyst'}">
		<h3 id="geRefDetails" class="acc_triggerC noborder" >
			<a href="javascript:;">View Customer/Beneficiary reference information</a>
		</h3><hr class="h2-hr">
		</c:if>
		<div id="geRefDetailsPanel" class="acc_containerC">
			<!--<h3 class="span12 collapsible collapsed">View GE Applicant reference information</h3>-->
			<div class="row smallrow">
				<div class="span2">
					<div class="form-row">
						<label><s:text name="label.request.customerReference" />:</label>
					</div>
				</div>
				<div class="span5 left">
					<div class="form-row">
						<p class="padding40">
							<s:property	value="requestDetails.amendment.transactionParties.customer.refDetails[0].refValue" />
						</p>
					</div>
				</div>
				<!-- end of block -->
			</div>
			
			<s:set name="geRefSize"	value="requestDetails.amendment.transactionParties.customer.refDetails.size" />
			<s:if test="#geRefSize > 1">
				<s:iterator value="requestDetails.amendment.transactionParties.customer.refDetails" status="stat">
					<s:if test="#stat.index != 0">
						<div class="row smallrow">
							<div class="span2">
								<div class="form-row">
									<label><s:text name="label.request.customerReference" /><s:property value="#stat.count" />:</label>
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
