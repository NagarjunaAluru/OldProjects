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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    <title>ICF | Administration - Edit Table</title>
    <meta name="description" content="">
    <meta name="author" content="">
	<%@include file="../common/includeCssScripts.jsp" %>
	<script type="text/javascript">
	//Defining the global variable, so this variable can be used by other javascript library included in this JSP 
 	var contextURL = '<%=servletContextUrl%>';
	</script>
	
	<script type="text/javascript" src="${context}/js/admin/adminEditTable.js"></script>
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

		<html:form action="admin/admin.do" styleId="adminId" method="post">
        
		<div class="form-mod">

			<div class="row">
				<div class="span12">
                <h2>Editable Data Elements - ${adminform.sourceName}</h2>
                <h3>${adminform.sourceName} Values</h3>
                
                <div class="clear"></div>
				<table border="0" width="100%" cellpadding="6" cellspacing="0" id="additionalTable">
					<tbody>
					  <tr>
					  
						<c:forEach var="columnHeader" items="${adminform.columnHeaderNameList}" varStatus="id">
                        <td colspan="1" style="width:10px;"><input type="hidden" name="columnHeaderName" value="${columnHeader}">
                        ${columnHeader}
                        </td>
                        </c:forEach> 
                        <td style="width:10px;">&nbsp;</td> 
					  </tr>
					  <tr>
					  <c:forEach var="rowList" items="${adminform.oldTableList}" begin="0" end="0" step="1">
					 
					  <c:forEach var="columnValue" items="${rowList.columns}" varStatus="id" >
					  <c:set var="filterList">filterList${id.index+1}</c:set>
					  <c:set var="filterListValue">filterListValue${id.index+1}</c:set>
					  <td colspan="1" style="width:10px;">
						
						<html:select property="${filterListValue}"  styleClass="span2">
   							<html:option value="">Select...</html:option>
   							<html:optionsCollection property="${filterList}" label="name" value="name"/>						   
						</html:select>
						
					  </td>
					  </c:forEach>
					 
					  </c:forEach>
					  <td colspan="1" style="width:10px;">
                        <input type="button" value="Search" id="searchAdminTable" style="margin-top:-10px;">
                      </td>
					  </tr>                                                                                                       
					</tbody>
				  </table>
                <div class="clear"></div>
                
                <p>&nbsp;</p>
                
                <div id="displayAdminTable">
                <table class="table table-striped table-bordered sortable no-bottom table-nested admin-validation" id="editTable">
					<thead>
                    	<tr>
                        	<td colspan="1">Action</td>
                        	<c:forEach var="columnHeader" items="${adminform.columnHeaderNameList}" varStatus="id">
	                        <td colspan="1" style="width:10px;"><input type="hidden" name="columnHeaderName" value="${columnHeader}">
	                        ${columnHeader}
	                        </td>
	                        </c:forEach>                             
                        </tr>
                    </thead>
                    <tbody>
					 
					 <c:forEach var="rowList" items="${adminform.tableList}" varStatus="id">
					  <tr>
						<td width="5"><input type="hidden" name="rowId" value="${rowList.ID}">
						<c:if test="${adminform.sourceName eq 'Country Tax/Jurisdiction' or adminform.sourceName eq 'Principal Legal Entity' or
						adminform.sourceName eq 'TCL (Transaction Classification Matrix)'}">
						<a href="#" class="delete-tr"><img src="img/delete.gif"></a>
						</c:if>
						</td>
                        <c:forEach var="columnValue" items="${rowList.columns}" varStatus="id">
                        <td>
                        <c:set var="columnId">columnValue${id.index+1}</c:set>
                        <c:choose>
                        <c:when test="${columnValue.name eq 'LEG_EVENT_ID' or columnValue.name eq 'LEG_TYPE_ID' or columnValue.name eq 'TRANSACTION_EVENT_TYPE_ID'}">
                        <input type="text" class="span2 request-admin" name="${columnId}" value="${columnValue.value}" maxlength="20" readonly="readonly" >
                        </c:when>
                        <c:otherwise>
                        <input type="text" class="span2 request-admin" name="${columnId}" value="${columnValue.value}" maxlength="20">
                        </c:otherwise>
                        </c:choose>
                        </td>
                        </c:forEach>
					  </tr>  
					   </c:forEach> 
					</tbody>
				  </table>
                  <br>
                  <c:if test="${adminform.sourceName eq 'Country Tax/Jurisdiction'}">
                  <a href="#" class="add-exception" id="editAddAdditional">Add Additional Value</a>
                  </c:if>
                  <c:if test="${adminform.sourceName eq 'Principal Legal Entity'}">
                  <a href="#" class="add-exception" id="editAddAdditional1">Add Additional Value</a>
                  </c:if>
                  <c:if test="${adminform.sourceName eq 'TCL (Transaction Classification Matrix)'}">
                  <a href="#" class="add-exception" id="editAddAdditional3">Add Additional Value</a>
                  </c:if>
                </div>
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
						<th colspan="20">Field</th>
						<th colspan="20">Former Value</th>
                        <th colspan="20">New Value</th>
						<th colspan="20">Changed by</th>
						<th colspan="20">Changed date</th>
					  </tr>
					</thead>
					<c:forEach var="auditLog" items="${adminform.changeLog}">
					<tbody>
					  <tr>
					  	
					  	<td colspan="20">${auditLog.fieldName}</td>
     					<td colspan="20">${auditLog.oldValue}</td>
     					<td colspan="20">${auditLog.newValue}</td>
     					<td colspan="20">${auditLog.auditCreator}</td>
     					<td colspan="20">${auditLog.auditCreatedDt}</td>
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
    </div>
	<%@include  file="../common/footerSection.jsp" %>
	
</body>
</html>