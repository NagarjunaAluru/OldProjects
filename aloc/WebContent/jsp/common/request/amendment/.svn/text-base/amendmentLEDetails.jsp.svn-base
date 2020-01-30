<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


	<div class="form-mod lastrow">
		<c:if test="${param.pageType eq 'TreasuryApprover'}">
			<h3 id="legalEntityDetails" class="acc_triggerA">
				<a href="javascript:;">View Legal Entity details</a>
			</h3><hr class="h2-hr">
		</c:if>
		<c:if test="${param.pageType eq 'TreasuryAnalyst'}">
			<h3 id="legalEntityDetails" class="acc_triggerA noborder">
				<a href="javascript:;">View Legal Entity details</a>
			</h3><hr class="h2-hr">
		</c:if>
		<div id="legalEntityDetailsPanel" class="acc_containerA">
			<div class="row smallrow">
				<div class="span22a">
					<div class="form-row">
						<s:label key="label.request.common.legalEntityNameC"/>
					</div>
				</div>
				<div class="span3a left">
					<div class="form-row">
						<p style="word-wrap: break-word;">
							<s:property value="requestDetails.transactionParties.tpApplicantDetails.leName" />
						</p>
					</div>
				</div>
				<!-- end of block -->
			</div>
			<div class="row smallrow">
				<div class="span22a">
					<div class="form-row">
						<s:label key="label.request.common.legalEntityGOLDIdC"/>
					</div>
				</div>
				<div class="span3a left">
					<div class="form-row">
						<p style="word-wrap: break-word;">
							<s:property	value="requestDetails.transactionParties.tpApplicantDetails.leGoldId" />
						</p>
					</div>
				</div>
				<!-- end of block -->
			</div>
			<div class="row lastrow">
				<div class="span22a">
					<div class="form-row">
						<s:label key="label.request.businessContactPerson"/>
					</div>
				</div>
				<div class="span3a left">
					<div class="form-row">
						<p style="word-wrap: break-word;">
							<s:if test="%{requestDetails.transactionParties.tpApplicantDetails.tpBuContactPerson.ssoId != null && requestDetails.transactionParties.tpApplicantDetails.tpBuContactPerson.ssoId !=''}">
								<s:property	value="requestDetails.transactionParties.tpApplicantDetails.tpBuContactPerson.lastName" />,
								<s:property	value="requestDetails.transactionParties.tpApplicantDetails.tpBuContactPerson.firstName" />
								<s:property	value="requestDetails.transactionParties.tpApplicantDetails.tpBuContactPerson.ssoId" />
							</s:if>
						</p>
					</div>
				</div>
				<!-- end of block -->
			</div>
		</div>
	</div>
