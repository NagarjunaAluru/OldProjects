<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<%-- Treasury Delegation section --%>

<div class="form-mod" id="treasuryDelegationDiv">
	<h2 id="treasuryDelegation" class="section_flip">
		<a href="javascript:;"><s:text name="label.request.treasuryDelegation"/></a>
	</h2><hr class="h2-hr">
	<div id="treasuryDelegationPanel" class="section_panel">
		<p class="required-fields">
			<s:text name="label.request.common.allFieldsRequiredUnlessSpecified" />
		</p>
		<div class="row">
			<div class="span2">
				<div class="form-row">
					<label><s:text name="label.request.approveLevelsRequired"/></label>
				</div>
			</div>
			<div class="span4 left">
				<p class="padding40">
					<s:property
						value="requestDetails.delegationApprovers.approvalLevelRequired" />
				</p>
			</div>
		</div>

		<div class="row">
			<div class="span12">
				<div class="form-row">
					<label><s:text name="label.request.treasuryApproverLevel"/></label>

					<s:select
						list="%{requestDetails.delegationApprovers.delegationGroups[0].groupApprovers}"
						listKey="sssoId" listValue="appFirstName" id="selectTDApprovers"
						name="requestDetails.tresuryDelegation.approverSso" headerKey=""
						headerValue="Select..." theme="aloc"/>
				</div>
			</div>
		</div>
	</div>
</div>