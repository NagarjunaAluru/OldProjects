<%@ page import="com.ge.icfp.util.Utils"%>
<%@ page errorPage="../common/error.jsp" %>
<%@page import="org.apache.struts.action.DynaActionForm"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib uri="http://ge.com/icfp/taglibs/userInformation" prefix="userDetails" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%> 
<fmt:setLocale value="en-US"/>
<t:common/>
<% String servletContextUrl = request.getContextPath();%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>ICF | Deal Report</title>
    <meta name="description" content="">
    <meta name="author" content="">
	<%@include file="../common/includeCssScripts.jsp" %>
	<script>//Defining the global variable, so this variable can be used by other javascript library included in this JSP 
 var contextURL = '<%=servletContextUrl%>';</script>
	<script src="<%=servletContextUrl%>/js/bootstrap-typeahead.js" type="text/javascript"></script>
	<script src="<%=servletContextUrl%>/js/cognosReports.js" type="text/javascript"></script>
	<script>
		$(document).ready(function(){
			var childWindow = null;
			try {
			  var objXHR = new XMLHttpRequest();
			} catch (e) {
			try {
			  var objXHR = new ActiveXObject('Msxml2.XMLHTTP');
			} catch (e) {
			try {
			  var objXHR = new ActiveXObject('Microsoft.XMLHTTP');
			} catch (e) {
			  alert('XMLHttpRequest not supported'); }
			}
			}
			var isIE8 = window.XDomainRequest ? true : false;
			if (isIE8){
			  var objXDR = new window.XDomainRequest();
			}
			doLogon();
		});
	</script>
 </head>
  <body>
	    <%@include file="../common/headerSection.jsp" %>
			<!-- <iframe id="reportFrame" frameborder="0" scrolling="no" height="100%" width="100%"></iframe>-->
			<div id="fragment"></div>
		<%@include  file="../common/footerSection.jsp" %>
  </body>
</html>

