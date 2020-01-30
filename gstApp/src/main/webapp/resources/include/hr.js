(function() {
	
	var app = angular.module("app", []);
	var appContext = "/gstApp/rest";
	
	app.controller("HttpCtrl", function($scope, $http) {
		
		
		
		/*HR Start*/
		$scope.showMe1 = true;
	    $scope.showMe2 = false;
		 
		 
		 $scope.applicants = [
           {firstName : "", lastName : "",email: ""},
           {firstName : "", lastName : "",email: ""},
           {firstName : "", lastName : "",email: ""},
           {firstName : "", lastName : "",email: ""},
           {firstName : "", lastName : "",email: ""},
           {firstName : "", lastName : "",email: ""},
           {firstName : "", lastName : "",email: ""},
           {firstName : "", lastName : "",email: ""},
           {firstName : "", lastName : "",email: ""},
           {firstName : "", lastName : "",email: ""}
       ];
		 
		 
	    $scope.addPerson = function(){
	        var person = {
	        		firstName: $scope.firstName,
	        		lastName: $scope.lastName,
	        		email: $scope.email,
	        };
	        $scope.applicants.push(person);
	      }; 
	      
	   
	      
	    $scope.myNextFunc = function() {
	    	if($scope.userselectedOpt != undefined){
	    		
	    		 $scope.showMe1 = !$scope.showMe1;
	    		 $scope.showMe2 = !$scope.showMe2;
	 	        $("#popupId").removeClass("show").addClass("hide");
	    	}
	    	else{
	    		$("#checkVal1").text("Please select any test");
	    	}
	    	
	    }
	    
	    
	    
		$scope.getTestList = function(){
			var response = $http.get(appContext+"/restCtrl/getTestList");
			response.success(function (data){
				$scope.testList = data;
				$("#popupId").removeClass("hide").addClass("show");
			});
			
			response.error(function(data, status, headers, config) {
				alert("AJAX failed to get data, status=" + status);
			});
		}
		
		
		
		 $scope.remove = function(){
			 
	        var newDataList=[];
	        var flag=true;
	        angular.forEach($scope.applicants,function(v){
	        	
		        if(!v.isDelete){
		        
		            newDataList.push(v);
		            
		        }
		        else{
		        	flag=false;
		        }
	        });    
	        $scope.applicants=newDataList;
	        if(flag)
	        	{$("#checkVal3").text("Please select checkbox to delete");}
	        
	    }
		
		 
		 $scope.submitUsers = function(){
			 var flag=false;
				
			 for (var i = 0; i < $scope.applicants.length; i++) {
				 if($scope.applicants[i].firstName != undefined && $scope.applicants[i].firstName != "" &&
					 $scope.applicants[i].lastName != undefined && $scope.applicants[i].lastName != "" &&
					 $scope.applicants[i].email != undefined && $scope.applicants[i].email != ""){
					 flag=true;
				 }
				 else
					 {
					flag=false;
					break;
					 }
			}
			 if(flag)
				 {
			 for (var i = 0; i < $scope.applicants.length; i++) {
				 $scope.applicants[i].testForm=$scope.userselectedOpt;
			 }
			 
			 $scope.jsonObj = angular.toJson($scope.applicants, false);
			var response = $http.post(appContext+"/restCtrl/createApplicants",$scope.jsonObj);
			response.success(function (data){
				window.location.reload(true);
					
			});
			
			response.error(function(data, status, headers, config) {
				alert("AJAX failed to get data, status=" + status);
			});
			 }
		 else{
	    		$("#checkVal2").text("All fields are mandatory");
	    	}
		}
		
		 $scope.close = function(){
			 $("#popupId").removeClass("show").addClass("hide");
			 
		 }

		 /*HR End*/
			 
		
	});	
})();