<html ng-app="app">
<head>
<title>Applicant</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>

<!-- Use Bootstrap -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link rel="stylesheet" href="<c:url value="/resources/include/styles.css" />" >
<link rel="stylesheet" href="http://code.jquery.com/ui/1.9.1/themes/smoothness/jquery-ui.css">

<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-messages.min.js"></script>
<script src="<c:url value="/resources/include/angular.min_1.2.16.js" />"></script>
<script	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="<c:url value="/resources/include/applicant.js"/>" type="text/javascript" ></script>
<script src="http://code.jquery.com/ui/1.9.1/jquery-ui.js"></script>

<meta name="viewport" content="width=device-width, initial-scale=1">
</head>

<body ng-controller="HttpCtrl">

	<div class="container">
		<span style="color: green;" id="activeUser"> Welcome : <sec:authentication
				property="principal.username" />
		</span>

		<div align="right" style="overflow:">
			<c:url var="logoutUrl" value="j_spring_security_logout" />
			<form action="${logoutUrl}" method="post">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" /> <input type="submit"
					class="btn btn-success btn-sm" value="Log out" />
			</form>
		</div>
		<div class="MainBody" ng-hide="showme">
			<h2 align="center">Applicant Details</h2>
			<br />
			<form name="myform" novalidate>
				<div>
					<table width="100%">

						<tr></tr>
						<tr>
							<td class="display_bold"><label for="firstName">First
									Name:</label></td>
							<td class="display"><input type="text"
								ng-model="applicant.firstName" disabled="true" id="valid"
								 /></td>
						</tr>
						<tr>
							<td class="display_bold"><label for="middleName">Middle
									Name:</label></td>
							<td class="display"><input type="text" ng-maxlength="20" 
								name="middleName" ng-model="applicant.middleName"/>
							</td>
						</tr>
						<tr>
							<td class="display_bold"><label for="lastName">Last
									Name:</label></td>
							<td class="display"><input type="text" disabled="true" id="valid"
								ng-model="applicant.lastName" size="30" /></td>
						</tr>
						<tr>
							<td class="display_bold"><label for="email">Email:</label></td>
							<td class="display"><input type="email" name='email'
								id='email' ng-model="applicant.email"  id="valid" ng-required="true" />
								<span class="error-message" ng-show="myform.email.$error.email">
									Not valid email!</span>
									</td>
						</tr>
						<tr>
							<td class="display_bold"><label for="phoneNo">Phone
									No:</label></td>
							<td class="display"><input type="text" name="phoneNo" 
								ng-maxlength="10" ng-minlength="10" ng-pattern="/^\d{10}$/" id='phoneNo'
								ng-model="applicant.phoneNo" ng-required="true" />
								<span class="error-message" ng-show="myform.phoneNo.$dirty 
								">The phone number field should be 
								of 10 digits</span>
								 </td>
						</tr>

						<tr>
							<td class="display_bold"><label for="dob">Birth
									Date:</label></td>
									<td><input id="dp" type="text" ng-model="applicant.dob"  my-datepicker ng-required="true"/></td>
						</tr>

						<tr>
							<td>&nbsp;</td>
						</tr>
					</table>

					<div align="center">
						<button   class="btn btn-success btn-sm" ng-click="submitForm()" id="valid"
							title="Save Applicant's details...">Start Test</button>
					</div>
					</div>
					</form>

				</div>
		</div>

				<div id="quiz" ng-show="showme">
					<div class="row">
				<div class="col-md-12">
					
					<div align="left">
					
					<span><strong> {{ currentIndex + 1 }} ).  {{applicant.testForm.testQuestions[currentIndex].testQuestion}}</strong></span>
					<br/><br/>
					<div ng-repeat = "chs in applicant.testForm.testQuestions[currentIndex].testQAnswer">
						&nbsp;&nbsp;&nbsp;<span> <input type="checkbox" ng-model="chs.testAnwerFlag"  ng-init="chs.testAnwerFlag=false">  {{chs.testQAnswer}}</span><br/>
					</div>
					</div>
					<br/>
					<div align="left">
						<button ng-show="showNextSubmit" ng-click="getNextQuestion(currentIndex)" class="btn btn-warning btn-sm"> Next </button>
						<button ng-hide="showNextSubmit" ng-click="submitTest()" class="btn btn-success btn-sm"> Submit </button>
					</div> 
					
				</div>
			</div>
				</div><br/><br/><br/>
			<div class="footer">Copyright © galaxe.com</div>
</body>
</html>
