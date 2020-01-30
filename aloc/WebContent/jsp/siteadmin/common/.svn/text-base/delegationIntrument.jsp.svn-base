<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<td>
	<s:hidden cssClass="delegationIndex" name="delegationIndex"
		value="%{#parameters['newDelegationIndex']}" /> <s:hidden
		cssClass="deleteConfig"
		name="siteDetailsBO.delegationConfigurationBO.delegationConfigBOList[%{#parameters['newDelegationIndex']}].deleted" />
	<a href="javascript:void(0);"
	class="delete-delegationconfig delete-tr-hide" id="deleteDelegation"
	title="Delete this Delegation">X</a>
</td>

<td class="insChktd">
	<label class="checkbox"><input type="checkbox" class="instrCheckBox"> </label>All
	<div class="checkboxSelectionDiv"> <s:checkboxlist
				name="siteDetailsBO.delegationConfigurationBO.delegationConfigBOList[%{#parameters['newDelegationIndex']}].instrumentIds"
				list="%{#attr['com.ge.aloc.StaticDataFactory'].instrumentTypeDeleg}"
				listValue="Name" listKey="ID" cssClass="instr checkBoxAlign" />
	</div>
</td>

<td id="iA">
	<s:textfield name="siteDetailsBO.delegationConfigurationBO.delegationConfigBOList[%{#parameters['newDelegationIndex']}].model.instrBaseAmt"
		 maxlength="21"	id="instrBaseAmt" cssStyle="width:80px;" /><br>
		<s:text	name="label.common.siteAdmin.to" /> <br>
		<s:textfield name="siteDetailsBO.delegationConfigurationBO.delegationConfigBOList[%{#parameters['newDelegationIndex']}].model.instrEndAmt" maxlength="21"
		id="instrEndAmt" cssStyle="width:80px;" /></td>

<td><s:radio theme="aloc" cssClass="radio notificationCaluseFlag"
		name="siteDetailsBO.delegationConfigurationBO.delegationConfigBOList[%{#parameters['newDelegationIndex']}].model.notificationCaluseFlag"
		list="#{'Yes':'Yes','No':'No','N/A':'N/A'}" value="%{notificationCaluseFlag}" /></td>

<td><s:radio theme="aloc" cssClass="radio curePeriodIndicatorFlag"
		name="siteDetailsBO.delegationConfigurationBO.delegationConfigBOList[%{#parameters['newDelegationIndex']}].model.curePeriodIndicatorFlag"
		list="#{'Yes':'Yes','No':'No','N/A':'N/A'}" value="%{curePeriodIndicatorFlag}" /></td>

<td><s:radio theme="aloc" cssClass="radio geAppDrawFlag"
		name="siteDetailsBO.delegationConfigurationBO.delegationConfigBOList[%{#parameters['newDelegationIndex']}].model.GEAppDrawFlag"
		list="#{'Yes':'Yes','No':'No','N/A':'N/A'}" value="%{geAppDrawFlag}" /></td>

<td>
	<table border="0" width="100%" cellpadding="6" cellspacing="0">
	 <colgroup width="50px"></colgroup>
     <colgroup width="170px"></colgroup>
		<s:hidden cssClass="newGroupLevel" name="newGroupLevel" value="1" />
		<tr class="groupAssignment">
			<td height="1" class="noPadding"><s:text
					name="label.siteAdmin.level" />&nbsp;<span
				class="groupLevelDisplayHolder">1</span> <s:hidden
					cssClass="groupOpcode"
					name="siteAdmin.delegationConfiguration.delegationConfigs[%{#parameters['newDelegationIndex']}].groupAssignments[0].opCode"
					value="INSERT" /> <s:hidden cssClass="groupLevel"
					name="siteAdmin.delegationConfiguration.delegationConfigs[%{#parameters['newDelegationIndex']}].groupAssignments[0].groupLevel" />
			</td>

			<td><s:select list="%{siteAdmin.delegationConfiguration.approvalGroupConfiguration.groups}" listKey="groupName"
					listValue="groupName" id="apprGroupName"
					name="siteAdmin.delegationConfiguration.delegationConfigs[%{#parameters['newDelegationIndex']}].groupAssignments[0].groupName"
					headerKey="" headerValue="Select..." cssStyle="width:200px!important;"/></td>
			<td>&nbsp;</td>
		</tr>

	</table> <a href="javascript:;" class="add add-delegationGroup"
	id="addApprovalLevel"><s:text
			name="label.siteAdmin.addApprovalLevel" /></a>

</td>

<script type="text/javascript">
	$(document).ready(function() {
		$('.checkboxSelectionDiv label').after('<div class="clear"></div>');
	});
</script>
		