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
    <title>ICF | Administration - Manage Delegation</title>
    <meta name="description" content="">
    <meta name="author" content="">
	<%@include file="../common/includeCssScripts.jsp" %>
	<script type="text/javascript">
	//Defining the global variable, so this variable can be used by other javascript library included in this JSP 
 	var contextURL = '<%=servletContextUrl%>';	
	</script>
	<script type="text/javascript" src="${context}/js/admin/adminSearchDelegation.js"></script>
  </head>

  <body>
	<div class="container main">
		<%@include file="../common/headerSection.jsp" %>
	    <div class="alert fade in alert-danger hide" style="display: ${empty requestScope.failureMsg ? 'none' : 'block'}">
            <a href="#" data-dismiss="alert" class="close">X</a>
            <strong>${requestScope.failureMsg}</strong> 
        </div>
		<ul class="breadcrumb">
			<li><a href="${context}/homePage.do">Home</a> <span class="divider">/</span></li>
			<li class="active">Administration - Manage Delegation</li>
		</ul>
		<h1 class="page-title span12">Administration - Manage Delegation</h1>
		 <p>&nbsp;</p>
		<html:form action="admin/admin.do" styleId="adminId" method="post">
        
		<div class="form-mod">

			<div class="row admin-validation">
				<div class="span12">
				 SSO ID <input class="request-admin" id="delegateSSOID" name="inputValue" type="text" value="${adminform.ssoID}" maxlength="20">
				 <a href="#" id="submitAction" class="btn btn-success">Search</a>
				</div>
         </div>       
        
        <p>&nbsp;</p>
        
	
		</div>
		</html:form>
   <hr>
    </div>
	<%@include  file="../common/footerSection.jsp" %>
	
</body>
</html>