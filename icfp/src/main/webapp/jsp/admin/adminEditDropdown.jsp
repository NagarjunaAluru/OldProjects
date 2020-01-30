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
    <title>ICF | Administration - Edit Dropdown</title>
    <meta name="description" content="">
    <meta name="author" content="">
	<%@include file="../common/includeCssScripts.jsp" %>
	<script type="text/javascript">
	//Defining the global variable, so this variable can be used by other javascript library included in this JSP 
 	var contextURL = '<%=servletContextUrl%>';	
	</script>
	
	<script type="text/javascript" src="${context}/js/admin/adminEditDropdown.js"></script>
  </head>

  <body>
	<div class="container main">
		<%@include file="../common/headerSection.jsp" %>
		<div class="alert fade in alert-danger hide" id="genericErrorComment">
            <a href="#" data-dismiss="alert" class="close">X</a>
            <strong>An error has occured, see below.</strong> 
        </div>
	    <div class="alert fade in alert-danger hide" style="display: ${empty requestScope.failureMsg ? 'none' : 'block'}">
            <a href="#" data-dismiss="alert" class="close">X</a>
            <strong>${requestScope.failureMsg}</strong> 
        </div>
		<ul class="breadcrumb">
			<li><a href="${context}/homePage.do">Home</a> <span class="divider">/</span></li>
			<li><a href="${context}/admin/admin.do?command=loadStaticData">Administration - Data Maintenance</a> <span class="divider">/</span></li>
			<li class="active">Administration</li>
		</ul>
		<h1 class="page-title span12">Administration</h1>
		<p class="span12 left clear dashdesc">
			<span class="required-fields"><span>*</span> = Required</span>
		</p>

		<html:form action="admin/admin.do" styleId="adminform" method="post">
        
		<div class="form-mod">

			<div class="row">
				<div class="span12">
                <h2>Editable Data Elements - ${adminform.sourceName}</h2>
                <h3>${adminform.sourceName} Values</h3>
                
                <div class="clear"></div>
				 <table border="0" width="100%" class="admin-validation" cellpadding="6" cellspacing="0" id="additionalTable">
					<tbody>
					<c:forEach var="dropDownValue" items="${adminform.dropDownList}" varStatus="id">
					  <tr>
						<td width="5%">
						 <c:choose>
						 <c:when test="${dropDownValue.value eq 'S&P FCCM' or dropDownValue.value eq 'Fair Value' or dropDownValue.value eq 'Cash Flow'}">
						 </c:when>
						 <c:otherwise>
						  <a href="#" class="delete-tr"><img src="img/delete.gif"></a>
						 </c:otherwise>
						 </c:choose>
						</td>
						<td><input type="hidden" name="inputName" value="${dropDownValue.ID}">
						<c:choose>
						 <c:when test="${dropDownValue.value eq 'S&P FCCM' or dropDownValue.value eq 'Fair Value' or dropDownValue.value eq 'Cash Flow'}">
							<input type="text" name="inputValue" class="request-admin" readonly="readonly" value="${dropDownValue.value}" maxlength="20">
						 </c:when>
						 <c:otherwise>
						  <input type="text" name="inputValue" class="request-admin" value="${dropDownValue.value}" maxlength="20">
						 </c:otherwise>
						 </c:choose>
						</td>
					  </tr>
					  </c:forEach>
					</tbody>
				  </table>
                  <br>
                  <a href="#" class="add-exception" id="addAdditional">Add Additional Value</a>
                  
				</div>
         
		<div class="span12">
			<a href="#" id="submitAction" class="btn right btn-success">Save</a>
			<a href="#confirm" class="btn-link right cancel modal-confirm" data-toggle="modal" >Cancel</a>
        </div>         

         </div>       
        
        <p>&nbsp;</p>
        
		<div class="form-mod">
        <h2 class="span12 collapsible">Change Log <a href="javascript:;">View full change log</a></h2>
		<div class="row">
				<div class="span12">        
					<table class="table table-striped table-bordered sortable no-bottom table-nested">
					<thead>
					  <tr>
						<th>Field</th>
						<th>Former Value</th>
                        <th>New Value</th>
						<th>Changed by</th>
						<th>Changed date</th>
					  </tr>
					</thead>
					<c:forEach var="auditLog" items="${adminform.changeLog}">
					<tbody>
					  <tr>
					  	<td>${auditLog.fieldName}</td>
     					<td>${auditLog.oldValue}</td>
     					<td>${auditLog.newValue}</td>
     					<td>${auditLog.auditCreator}</td>
     					<td>${auditLog.auditCreatedDt}</td>
					  </tr>
					  </c:forEach>                                                                           
					</tbody>
				  </table>
       		 </div>
        </div>
        </div>
        <div class="modal hide fade" id="confirm">
		<div class="modal-header">
			<a class="close" data-dismiss="modal">X</a>
			<h3>Cancel Change</h3>
		</div>
		<div class="modal-body">
			<div class="row">
				<p><b>Are you sure you want to cancel?</b><br>
			Any changes you have made will be lost
			</p>
			</div>
		</div>
		<div class="modal-footer">
			<a href="<%=servletContextUrl%>/admin/admin.do?command=loadStaticData" class="btn right btn-success">Yes, cancel the change</a>
			<a href="#" class="btn-link right cancel" data-dismiss="modal">No, take me back to the change</a>
		</div>
   	 	</div>
		</div>
		</html:form>
   <hr>
    </div>
	<%@include  file="../common/footerSection.jsp" %>
</body>
</html>