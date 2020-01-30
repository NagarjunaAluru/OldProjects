(function() {

	var app = angular.module("app", []);
	var appContext = "/gstApp/rest";

	app.directive('myDatepicker', function ($parse) {
	    return function (scope, element, attrs, controller) {
	        var ngModel = $parse(attrs.ngModel);
	        $(function(){
	            element.datepicker({
	                showOn:"both",
	                changeYear:true,
	                changeMonth:true,
	                dateFormat:'yy-mm-dd',
	                maxDate: new Date(),
	                yearRange: '1920',
	                onSelect:function (dateText, inst) {
	                    scope.$apply(function(scope){
	                        // Change binded variable
	                        ngModel.assign(scope, dateText);
	                    });
	                }
	            });
	        });
	    }
	});
	
	

	app.controller("HttpCtrl", function($scope, $http) {
		
		/*Applicant Start*/
		
		$scope.phoneNumberPattern = (function() {
		    var regexp = /^\(?(\d{3})\)?[ .-]?(\d{3})[ .-]?(\d{4})$/;
		    return {
		        test: function(value) {
		            if( $scope.requireTel === false ) {
		                return true;
		            }
		            return regexp.test(value);
		        }
		    };
		})();
		

		 $scope.submitForm = function () {
			 $scope.submitted = true;
			 saveApplicant();
			/* if ($scope.registration.$valid) {
				 saveApplicant();
			 }
			 else {
			 alert("Please fill all the field!");
			 }*/
			 };

		$scope.applicant = null;
		var user = $("#activeUser").text();
		user = user.replace(" Welcome : ", "").trim();
		var applicantresponse = $http.get(appContext+"/restCtrl/getuser/" + user);
		applicantresponse.success(function (data){
			data.dob=''
			$scope.applicant = data;
			alert(angular.toJson(data,true));
		});
		applicantresponse.error(function(data, status, headers, config) {
		});

		var saveApplicant = function() {
			if($scope.applicant.email != undefined && $scope.applicant.phoneNo != undefined && $scope.applicant.dob != undefined && $scope.applicant.dob != "" ){
			$scope.jsonObj = angular.toJson($scope.applicant, false);
			$scope.showme=false;
			var response = $http.post(appContext+'/restCtrl/saveApplicant/',$scope.jsonObj);
			response.success(function(data, status, headers, config) {
				//$scope.applicant = data;
				$scope.showme= true;
				
			});
			
			response.error(function(data, status, headers, config) {
				alert("AJAX failed to get data, status=" + status);
			});
			}
		};

		
		$scope.currentIndex = 0;
		$scope.showNextSubmit = true;
		$scope.getNextQuestion = function(currentIndex){
			if(currentIndex+1 < $scope.applicant.testForm.testQuestions.length){
				$scope.currentIndex = $scope.currentIndex+1;
				if($scope.currentIndex+1 == $scope.applicant.testForm.testQuestions.length){
					$scope.showNextSubmit = false;
				}
			}
		}
		
		$scope.submitTest = function() {
			
			//$scope.answerObj.user = $scope.applicantJsonObj;
			
			$scope.appJsonObj = angular.toJson($scope.applicant,true);
			
			var response = $http.post(appContext+'/restCtrl/submitTest/'+ "StartTime"+"/"+"TimeTaken",$scope.appJsonObj);
			response.success(function(data, status, headers, config) {
				
			});
			
			response.error(function(data, status, headers, config) {
				alert("AJAX failed to get data, status=" + status);
			});
			
		}
		
		
		
		
		

		/*Applicant End*/

	});	
	
})();

	


