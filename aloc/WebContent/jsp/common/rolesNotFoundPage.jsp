<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- JS FOR FONT -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/font/typeface-0.15.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/font/ge_inspira_regular.typeface.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/font/helvetica_lt_std_light.typeface.js"></script>
	<!-- Including Stylesheets -->
	<link href="${pageContext.request.contextPath}/css/bootstrap/bootstrap.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/common/site.css" rel="stylesheet">
</head>

<body>
	<div class="container main">
	<%@include  file="../common/headerSection.jsp" %>
	<!-- MAIN CONTENTS OF BODY STARTS HERE -->
	<div class="clear"></div>
	
	<h3>You currently do not have access to ALOC.<br>
	To request access to this application you are required to go to <a href="http://idm.treasury.ge.com" target="_blank" style="font-size: 16px;">Treasury IdM </a>
	</h3>
	</div>  
 <%@include  file="../common/footerSection.jsp" %>

</body>
</html>