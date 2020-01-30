<html>
	<head>
		<title> HR </title>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
		<!-- Use Bootstrap -->
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
		<link href="<c:url value="/resources/include/styles.css" />" rel="stylesheet">
		
		<%-- <script type="text/javascript" src="<c:url value="/resources/include/angular.min_1.2.16.js" />" ></script> --%>
		<script type="text/javascript" src="<c:url value="/resources/include/angular.min_1.3.15.js" />" ></script>
		<script type="text/javascript" src="<c:url value="/resources/include/hr.js" />" ></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
		<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
		
		<meta name="viewport" content="width=device-width, initial-scale=1">
	</head>
	
	<body>
  	<div class="container">
		  	<span style="color:green;"> Welcome : <sec:authentication property="principal.username" /> </span>
		  	&nbsp;&nbsp;&nbsp;<span style="color:blue;">Roles : <sec:authentication property="principal.authorities"/></span>
		  	
	  		<div align="right" style="overflow: ">
				<c:url var="logoutUrl" value="j_spring_security_logout" />
				<form action="${logoutUrl}" method="post">
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					<input type="submit" class="btn btn-success btn-sm" value="Log out" /> 
				</form>
			</div>
			
		<div class="MainBody" data-ng-app="app" data-ng-controller="HttpCtrl">	
		
		<div data-ng-show="showMe1">
		    <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-ng-click="getTestList()">Add Applicant</button>		
		</div>	
	
		<form>
		<div class="modal hide" id="popupId" role="dialog" >
		    <div class="modal-dialog">
		      <div class="modal-content">
		        <div class="modal-header">
		          <button type="button" data-ng-click="close()" class="close" data-dismiss="modal">&times;</button>
		          <h4 class="modal-title">Select any test</h4>
		        </div>
		        <div class="modal-body">
				
				Test Name
				<select name="myInput" id="mySelect" 
				      data-ng-options="test.testName for test in testList track by test.testId"
				      data-ng-model="userselectedOpt">
				      <option  value="">Select</option></select>
				<span style="color:red;" id="checkVal1"></span>
				
				
		        </div>
		
		        <div class="modal-footer">
		        
		          <button type="button" class="btn btn-primary" data-ng-click="myNextFunc()">Next</button>
		          
		        </div>
		      </div>
		      
		    </div>
		  </div>
		   </form>
		 <form name="myForm">
		<div  data-ng-show="showMe2">
		<div id="header">
			<h1>{{userselectedOpt.testName}}</h1>
			</div>
			<h4><span style="color:red;" id="checkVal2"></span></h4>
			<h4><span style="color:red;" id="checkVal3"></span></h4>
			
			<table class="zui-table zui-table-rounded" style="width: 100%">
			
			<thead>
			<tr>
				<th>SELECT</th><th>FIRST NAME</th><th>LAST NAME</th><th>EMAIL</th>
			</tr>	
			</thead>
			<tbody>
			    <tr data-ng-repeat="x in applicants">
			    
				    <td><input type="checkbox" data-ng-model="x.isDelete"> </td>
				
				    <td><input type="text" class="form-control" data-ng-init="fname = 'applicantFirstName'" name="{{fname+$index}}" data-ng-model="applicants[$index].firstName" data-ng-minlength="3" data-ng-required="true">
				    <span style="color:red" data-ng-show="myForm[fname+$index].$dirty && myForm[fname+$index].$invalid">
				    <span  data-ng-show="myForm[fname+$index].$error.required">FirstName is required.</span>
				    <span data-ng-show="myForm[fname+$index].$error.minlength">FirstName should be minimum 3 character.</span></span></td>
				    
				    <td><input type="text" class="form-control" data-ng-init="lname = 'applicantLastName'" name="{{lname+$index}}" data-ng-model="applicants[$index].lastName" data-ng-minlength="4" data-ng-required="true">
				    <span style="color:red" data-ng-show="myForm[lname+$index].$dirty && myForm[lname+$index].$invalid">
				    <span data-ng-show="myForm[lname+$index].$error.required">LastName is required.</span>
				    <span data-ng-show="myForm[lname+$index].$error.minlength">LastName should be minimum 4 character.</span></span></td>
				    
				    <td><input type="email" class="form-control" data-ng-init="email = 'applicantEmail'" name="{{email+$index}}" data-ng-model="applicants[$index].email" data-ng-required="true">
				    <span style="color:red" data-ng-show="myForm[email+$index].$dirty && myForm[email+$index].$invalid">
		  				<span data-ng-show="myForm[email+$index].$error.required">Email is required.</span>
		  				<span data-ng-show="myForm[email+$index].$error.email">Invalid email address.</span></span></td>
			    </tr>
			   </tbody>
			</table>
			  
			 <button type="button"  class="btn btn-primary" data-ng-click="remove()" style="float: right;">Remove</button>
			<button type="button" class="btn btn-primary" data-ng-click="addPerson()" style="float: right;">Add Person</button><br/><br/>
			<button type="button" class="btn btn-primary"  data-ng-click="submitUsers()" style="float: right;">Submit</button>
			
			</div>
     </form>
		</div>
	
		<div class="footer"> Copyright © galaxe.com </div>
	</div>
	</body>
</html>