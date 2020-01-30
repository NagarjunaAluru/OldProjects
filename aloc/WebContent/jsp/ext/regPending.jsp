<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="userInfo"  uri="hwf-userInformation" %>
<script type="text/javascript">
var contextURL = "${pageContext.request.contextPath}";
</script>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<%@include file="/jsp/ext/common/includeCommonScripts.jsp" %>
	<title><s:text name="label.user.status.pending"/></title>
</head>

<body>
	<div class="container main">
		
		<div class="top-container">
		<s:url action="logout.action" namespace="/ext/public" var="logoutURL" />
		<div class="welcomebar">
			<a class="left" ><img src="${pageContext.request.contextPath}/ext/public/img/top_treasury.gif"></a>
			<c:set var="userName" value="${userInfo:fullName(' ','-')}" />
			<p class="left"><c:out value="${userName}"></c:out>  	
			</p>
			<p class="right">
				<a href="<s:property value="#logoutURL" />" ><span style="cursor: pointer;"><s:text name="label.header.logout"/></span></a>
			</p>
		</div>
		<div class="header">
			<div class="logo"><s:text name="label.header.aloc"/></div>
			<div class="logo2">
				<span><s:text name="label.header.alocDesc"/></span>
			</div>
		</div>
       </div>
		
		<h1 class="page-title span12"><s:text name="label.login.progress"/></h1>
		<hr class="page-title-hr">
		<div style="width:100%; height:400px;">&nbsp;</div>
	</div>
   <%@include  file="/jsp/ext/common/footerSection.jsp" %>
</body>
</html>