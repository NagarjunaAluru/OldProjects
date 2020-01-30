<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="../common/error.jsp" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en-US"/>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:common/>
<%
	String servletContextUrl = request.getContextPath();
%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="/WEB-INF/config/tld/attachment" prefix="attachment"%>
<%@taglib uri="http://ge.com/icfp/taglibs/staticdata" prefix="staticdata" %>
<%@ taglib uri="/WEB-INF/config/tld/hwf-desktoptag.tld"
	prefix="wfdesktop"%>

<%@ taglib prefix="security"  uri="hwf-securitytag" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>ICF | Contact Us</title>
<meta name="description" content="">
<meta name="author" content="">
<%@include file="../common/includeCssScripts.jsp" %>

<script type="text/javascript">
//Defining the global variable, so this variable can be used by other javascript library included in this JSP 
 var contextURL = '<%=servletContextUrl%>';
</script>
<script src="<%=servletContextUrl%>/js/pagination.js"></script>
<%String legLenforJS ="0";%>
					
<script type="text/javascript">
var legLen = '<%=legLenforJS%>';
</script>
</head>
<body>
	<div class="container main">
		<%@include file="../common/headerSection.jsp" %>
		<ul class="breadcrumb">
			<li><a href="${context}/homePage.do">Home</a> <span class="divider">/</span></li>
			<li class="active">Contact Us</li>
		</ul>
		<h1 class="page-title span12">Contact ICF</h1>
		<p class="span12 left clear dashdesc">
		</p>

		<form>
        
		<div class="form-mod">
			<div class="row">
				<div class="span12">
				 <table class="table active table-striped table-bordered sortable">
					<thead>
				      <tr>
					   <th><bean:message key="heading.contactUs.ssoId"/></th>
					   <th><bean:message key="heading.contactUs.name"/></th>
					   <th><bean:message key="heading.contactUs.phoneNumber"/></th>
					   <th><bean:message key="heading.contactUs.email"/></th>
				      </tr>
			       </thead>
					<tbody>
					<c:forEach var="contactUsList" items="${staticdata:getContactUsList(pageContext)}">
					<tr>
					<td>
						 <c:choose>
						<c:when test="${not empty contactUsList}">
						  ${contactUsList.SSOID}
						 </c:when>
						 </c:choose>
					</td>
					<td>
						<c:choose>
						<c:when test="${not empty contactUsList}">
						  ${contactUsList.name}
						 </c:when>
						 </c:choose> 
					</td>
					<td>
						<c:choose>
						<c:when test="${not empty contactUsList}">
						  ${contactUsList.phoneNumber}
						 </c:when>
						 </c:choose> 
					</td>
					<td>
						<c:choose>
						<c:when test="${not empty contactUsList}">
						  ${contactUsList.email}
						 </c:when>
						 </c:choose> 
					</td>
					</tr>
					</c:forEach>
				   </tbody>
				    </table>
				</div>
			</div> 
            		
        </div><!-- end of form form-mod -->
      	</form>
    </div>
	<%@include  file="../common/footerSection.jsp" %>

			
  </body>
</html>