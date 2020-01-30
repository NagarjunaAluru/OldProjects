<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
 <%@ taglib prefix="s" uri="/struts-tags"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
    <td height="1" class="noPadding"><s:text name="label.siteAdmin.level" />&nbsp;<span class="groupLevelDisplayHolder"><s:property value="%{#parameters['levelIndex']}"/></span></td>
                                	
    <td>
	  	<s:select list="%{siteAdmin.delegationConfiguration.approvalGroupConfiguration.groups}"
		listKey="groupName" 
		listValue="groupName" 
		id="apprGroupName" 
		name="siteAdmin.delegationConfiguration.delegationConfigs[%{#parameters['delegationIndex']}].groupAssignments[%{#parameters['newGroupLevel']}].groupName"
		headerKey=""
		headerValue="Select..."
		cssStyle="width:200px!important;"
	/> 
    </td>
    <s:hidden cssClass="groupOpcode" name="siteAdmin.delegationConfiguration.delegationConfigs[%{#parameters['delegationIndex']}].groupAssignments[%{#parameters['newGroupLevel']}].opCode" value="INSERT"/>
    <s:hidden cssClass="groupLevel" name="siteAdmin.delegationConfiguration.delegationConfigs[%{#parameters['delegationIndex']}].groupAssignments[%{#parameters['newGroupLevel']}].groupLevel" value="%{#parameters['levelIndex']}" />
    <td><a href="javascript:;" class="remove-delegGroup" >remove</a></td>
    
