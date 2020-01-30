<html ng-app="app">
	<head>
		<title> Access Denied </title>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
		<!-- Use Bootstrap -->
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
		<link href="<c:url value="/resources/include/styles.css" />" rel="stylesheet">
		
		<!-- <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.16/angular.min.js"></script> -->
		<script type="text/javascript" src="<c:url value="/resources/include/angular.min_1.2.16.js" />" ></script>
		<%-- <script type="text/javascript" src="<c:url value="/resources/include/angular-resource.min.js" />" ></script> --%>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
		<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="<c:url value="/resources/include/app.js" />" ></script>
		
		<meta name="viewport" content="width=device-width, initial-scale=1">
	</head>
	
	<body>
  	<div class="container">
	  		<div align="right" style="overflow: ">
				<c:url var="logoutUrl" value="j_spring_security_logout" />
				<form action="${logoutUrl}" method="post">
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					<input type="submit" class="btn btn-success btn-sm" value="Log out" /> 
				</form>
			</div>
		<div class="MainBody">
		    
			
		</div>

		<div class="footer"> Copyright © galaxe.com </div>
	</div>
	</body>
</html>