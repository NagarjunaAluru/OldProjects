<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="../common/error.jsp" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:common/>
<%
	String servletContextUrl = request.getContextPath();
%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="/WEB-INF/config/tld/attachment" prefix="attachment"%>
<%@ taglib uri="/WEB-INF/config/tld/hwf-desktoptag.tld"
	prefix="wfdesktop"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>
<!DOCTYPE html>
<html lang="en">
<head>
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>ICF | Administration - Modify Approver</title> 
    <meta name="description" content="">
    <meta name="author" content="">
	<%@include file="../common/includeCssScripts.jsp" %>
	<script type="text/javascript">
	//Defining the global variable, so this variable can be used by other javascript library included in this JSP 
 	var contextURL = '<%=servletContextUrl%>';
	</script>
	<script type="text/javascript" src="${context}/js/admin/adminModifyApprover.js"></script>
  </head>

  <body>
	<div class="container main">
		<%@include file="../common/headerSection.jsp" %>
		<div class="alert fade in alert-success hide" style="display: ${not empty requestScope.successMsg ? 'block' : 'none'}">
	         <a href="#" data-dismiss="alert" class="close">X</a>
	          <strong><font color="green">${requestScope.successMsg}</font></strong> 
	    </div>
		<ul class="breadcrumb">
			<li><a href="${context}/homePage.do">Home</a> <span class="divider">/</span></li>
			<li><a href="${context}/searchResults.do?command=getSearchDealDetail&DealRequestID=${adminform.dealRequestID}">Search Details</a> <span class="divider">/</span></li>
			<li class="active">Administration - Modify Approver</li>
		</ul>
		<h1 class="page-title span12">Administration - Modify Approver</h1>
		<p class="span12 left clear dashdesc">
			<span class="required-fields"><span>*</span> = Required</span>
		</p>

	<html:form action="admin/admin.do" styleId="adminId" method="post">
        
		<div class="form-mod">

			<div class="row">
				<div class="span12">
                <h2>Deal ID: ${adminform.businessID}</h2>
                <div class="clear"></div>
				 <table class="table table-striped table-bordered sortable no-bottom table-nested">
					<thead>
					  <tr>
						<th>Name</th>
						<th>SSO Id</th>
                        <th>Role</th>
						<th>Status</th>
						<th>Reassign</th>
                        <th>Remove</th>
					  </tr>
					</thead>
					<tbody>
					 <c:forEach var="modifyApprover" items="${adminform.modifyApprovers}">
					  <tr>
						<td>${modifyApprover.lastName}, ${modifyApprover.firstName}</td>
						<td>${modifyApprover.SSOID}</td>
						<td>${modifyApprover.roleName}</td>
						<td>In Progress</td>
						<td><input type="hidden" id="cafeId" name="cafeId" value="${modifyApprover.roleId}" />
						<a href="#" class="reassign">Reasign</a></td>
						<td>
						<c:choose>
						<c:when test="${modifyApprover.roleId eq '52' or fn:contains(modifyApprover.queueName, 'ICFP-BUAPP')}">
						<a href="#" class="remove">Remove</a>
						</c:when>
						<c:otherwise>
						</c:otherwise>					
						</c:choose>
                        </td>
					  </tr>
					  </c:forEach>
					                                                                                       
					</tbody>
				  </table>
				</div>
         </div>       
        
		<a href="${context}/searchResults.do?command=getSearchDealDetail&DealRequestID=${adminform.dealRequestID}">&lt;&lt; Previous</a>
		</div>
     
   <hr>
    </div>
     <!-- Assign a Reviewer Popup -->
	<div class="span3" id="adminReasignDiv">
	<%@ include file="../common/inc/adminReassign.jsp"%>
	</div>
	 </html:form>
	<!-- Revoke Popup -->
	<div class="span3" id="adminRevokeDiv">
	<%@ include file="../common/inc/adminRevoke.jsp"%>
	</div>
	<%@include  file="../common/footerSection.jsp" %>
	<!-- Modals start -->
</body>
</html>