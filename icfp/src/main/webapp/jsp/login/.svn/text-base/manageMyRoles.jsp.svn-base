<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="../common/error.jsp" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:common></t:common>
<% String servletContextUrl = request.getContextPath();  %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<fmt:setLocale value="en-US"/>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>ICFP | Manage My Roles</title>
    <meta name="description" content="">
    <meta name="author" content="">
<%@include file="../common/includeCssScripts.jsp" %>


<script type="text/javascript" >
	//Defining the global variable, so this variable can be used by other javascript library included in this JSP 
 var contextURL = '<%=servletContextUrl%>';
</script>
<script type="text/javascript" src="<%=servletContextUrl%>/js/login/manageMyRoles.js" >
</script>
</head>
<body>
<div class="container main">
<%@include file="../common/headerSection.jsp" %>
<ul class="breadcrumb">
	<li><a href="${context}/homePage.do">Home</a> <span class="divider">/</span></li>
	<li class="active">Manage My Roles</li>
</ul>
<div class="alert fade in alert-danger hide" style="display: ${empty requestScope.failureMsg ? 'none' : 'block'}" >
            <a href="#" data-dismiss="alert" class="close">X</a>
            <strong>${requestScope.failureMsg}</strong> 
        </div>
<div class="alert fade in alert-success hide" style="display: ${empty requestScope.UpdateMessage ? 'none' : 'block'}">
	<a href="#" data-dismiss="alert" class="close">X</a>
    <strong>${requestScope.UpdateMessage}</strong> 
 </div>
 <div class="alert fade in alert-danger hide" style="display: ${not empty requestScope.atmtError ? 'block' : 'none'}">
             <a href="#" data-dismiss="alert" class="close">X</a>
             <strong>${requestScope.atmtError}</strong> 
 </div>
<h1 class="page-title span12">Manage My Roles</h1>
<p class="span12 left clear dashdesc">Select the edit button to assign or revoke a delegate for that role.</p>

<html:form action="/manageDelegation.do" styleId="manageRolesForm">
<c:set var="showSave" value="N"></c:set>
	<table id="taskData" class="table table-striped table-bordered active">
		<thead>
			<tr>
				<th>Edit</th>
				<th>Role</th>
				<th>Current Delegate</th>
				<th>Delegate Time Frame</th>
				<th>Revoke</th>
			</tr>
		</thead>		
		<tbody>
			<html:hidden name="manageDelegationForm" property="noOfRoles" value="${fn:length(sessionScope.userDelegation)}"/>
			<c:forEach items="${sessionScope.userDelegation}" var="eachUserDelegation" varStatus="role">
			<c:set var="showSave" value="Y"></c:set>
			<tr>
				<td><a href="javascript:void(0);" class="edit-leg" id="role${role.count}" onclick="javascript:showEditableFields(${role.count});"></a></td>
				<td>${eachUserDelegation.roleName}
					<html:hidden name="manageDelegationForm" property="roleIds" value="${eachUserDelegation.roleId}"/>
					<html:hidden name="manageDelegationForm" property="roleNames" value="${eachUserDelegation.roleName}"/>
					<html:hidden name="manageDelegationForm" property="insertUpdate" value="${eachUserDelegation.insertUpdate}"/>
					<html:hidden name="manageDelegationForm" property="delegatorSSOID" value="${eachUserDelegation.delegatorSSO}"/>
					<html:hidden name="manageDelegationForm" property="delegatorLastNames" value="${eachUserDelegation.delegatorLastName}" />
					<html:hidden name="manageDelegationForm" property="delegatorFirstNames" value="${eachUserDelegation.delegatorFirstName}" />
					<html:hidden name="manageDelegationForm" property="userDelegateId" value="${eachUserDelegation.userDelegateId}" />
				</td>
				<td>
					<div style="display: block;" id="currentDelegateRO${role.count}">
						<c:if test="${empty eachUserDelegation.delegateSSO}">
							-
						</c:if>
						<c:if test="${not empty eachUserDelegation.delegateSSO}">
							${eachUserDelegation.delegateLastName}, ${eachUserDelegation.delegateFirstName}
						</c:if>
					</div>
					<div style="display: none;" id="currentDelegate${role.count}">
						<html:select name="manageDelegationForm" property="delegateSSOID" value="${eachUserDelegation.delegateSSO}" 
						onchange="javascript:populateDelegateNames(${role.count});" styleId="delegateSSO${role.count}">
						<html:option value="">Select...</html:option>
						<c:forEach var="eachGroup" items="${sessionScope.userGroups}">
							<option value='<c:out value="${eachGroup.key}"></c:out>'>
							${eachGroup.value}
							</option>
						</c:forEach>
						</html:select>
					</div>
					<%-- <html:hidden name="manageDelegationForm" property="delegateSSO" value="${eachUserDelegation.delegateSSO}"/> --%>
					<html:hidden name="manageDelegationForm" property="delegateLastNames" value="${eachUserDelegation.delegateLastName}" styleId="delegateLastName${role.count}"/>
					<html:hidden name="manageDelegationForm" property="delegateFirstNames" value="${eachUserDelegation.delegateFirstName}" styleId="delegateFirstName${role.count}"/>
				</td>
				<td>
					<div style="display: block;" id="delegateTimeFrameRO${role.count}">
						<c:choose>
						<c:when test="${empty eachUserDelegation.delegateFromDate and empty eachUserDelegation.delegateToDate}">
							-
						</c:when>
						<c:otherwise>
							${eachUserDelegation.delegateFromDate} to ${eachUserDelegation.delegateToDate}
						</c:otherwise>
						</c:choose>
					</div>
					<div style="display: none;" id="delegateTimeFrame${role.count}">
						<div class="left">
		                	<html:text name="manageDelegationForm" property="delegateFromDate" styleClass="span2 requestdatepicker-field" maxlength="10" 
		                	value="${eachUserDelegation.delegateFromDate}" />
		                	<span class="help-block clear">MM/DD/YYYY</span>
		                </div> 
		                <div class="left" style="margin-left:15px; margin-right:10px;margin-top:15px;">To</div> 
		                <div class="left">
		                	<html:text name="manageDelegationForm" property="delegateToDate" styleClass="span2 requestdatepicker-field" maxlength="10" 
		                	value="${eachUserDelegation.delegateToDate}" />
		                	<span class="help-block clear">MM/DD/YYYY</span>
		                </div>
					</div>
					
				</td>
				<td>
					<c:if test="${eachUserDelegation.insertUpdate eq 'INSERT'}">
						-
					</c:if>
					<c:if test="${eachUserDelegation.insertUpdate eq 'UPDATE'}">
					<c:choose>
						<c:when test="${not empty sessionScope.canDelegate && sessionScope.canDelegate == 'Y'}">
								<a href="javascript:void(0);" id="revokeRole${role.count}" onclick="javascript:adminRevokeRole(${eachUserDelegation.userDelegateId});">Revoke</a>
						</c:when>
						<c:otherwise>
							<a href="javascript:void(0);" id="revokeRole${role.count}" onclick="javascript:revokeRole(${eachUserDelegation.userDelegateId});">Revoke</a>
						</c:otherwise>
					</c:choose>
					</c:if>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="span8 right btn-container">
	<c:choose>
			<c:when test="${not empty sessionScope.canDelegate && sessionScope.canDelegate == 'Y'}">
				<c:if test="${showSave eq 'Y'}">
				<a class="btn right btn-success" href="javascript:void(0);" id="adminSaveChanges">Save changes</a>
				</c:if>
			</c:when>
			<c:otherwise>
				<a class="btn right btn-success" href="javascript:void(0);" id="saveChanges">Save changes</a>
			</c:otherwise>
	</c:choose>
	<a href="#confirm" class="btn-link right cancel modal-confirm" data-toggle="modal" >Cancel</a>
	</div>
</html:form>
</div>
<%@include file="../common/footerSection.jsp" %>
<div class="modal hide fade" id="confirm">
	<div class="modal-header">
		<a class="close" data-dismiss="modal">X</a>
		<h3>Cancel Request</h3>
	</div>
	<div class="modal-body">
		<div class="row">
			<p>
				<b>Are you sure you want to cancel?</b><br> Any changes you
				have made will be lost
			</p>
		</div>
	</div>
	<div class="modal-footer">
		<a href="<%=servletContextUrl%>/homePage.do"
			class="btn right btn-success">Yes, cancel the request</a> <a
			href="#" class="btn-link right cancel" data-dismiss="modal">No,
			take me back to the request</a>
	</div>
</div>
</body>
</html>