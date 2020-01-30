(function() {
	
	var app = angular.module("app", []);
	var appContext = "/gstApp/rest";
	
	app.controller("HttpCtrl", function($scope, $http) {
		
		/*Admin Start*/
		$scope.activeTab = 1;
		
		$scope.setActiveTab = function(tabToSet) {
			if(tabToSet == 2 || tabToSet == 5 || tabToSet == 3){
				$scope.getCategories();
			}
			$scope.activeTab = tabToSet;
		}
		
		
		var response = $http.get(appContext+"/restCtrl/getRoles");
		response.success(function (data){
			$scope.rolesList = data;
		});
		
		response.error(function(data, status, headers, config) {
			alert("AJAX failed to get data, status=" + status);
		});
		
		$scope.user={firstName : "", lastName : "",email : "",userRole: ""};
		
		$scope.createUser = function(user){
			if($scope.user.firstName != undefined && $scope.user.firstName != "" 
				&& $scope.user.lastName != undefined && $scope.user.lastName != ""
					&& $scope.user.email != undefined && $scope.user.email != ""
						&& $scope.user.userRole != undefined && $scope.user.userRole != "")	{
			
				$scope.roleid = $scope.user.userRole.roleId;
				$scope.roleName = $scope.user.userRole.role;
				$scope.roleData = [{
				            	      "roleId": $scope.roleid,
				            	      "role": $scope.roleName
				            	    }];
				$scope.user.userRole = $scope.roleData;
				
				$scope.userObj = angular.toJson($scope.user, true);
				var response = $http.post(appContext+"/restCtrl/createUser",$scope.userObj);
					response.success(function (data){
						window.location.reload();
				});
				
				response.error(function(data, status, headers, config) {
					alert("AJAX failed to get data, status=" + status);
				});
			
			}else{
					$("#checkVal4").text("All fields are mandatory");
				}
		}
		
		$scope.statusOptions = [{categoryStatus : "Active"}, {categoryStatus : "In-Active"}];
		
		
		$scope.categories = [{categoryName : "", categoryDescription : "", categoryStatus : ""},
		                     {categoryName : "", categoryDescription : "", categoryStatus : ""},
		                     {categoryName : "", categoryDescription : "", categoryStatus : ""}];
		
		$scope.availableLevels = [{questionLevel : "Simple"},
				            	  {questionLevel : "Medium"},
				            	  {questionLevel : "Hard"}];
		
		$scope.addCategory = function(){
	        var category = {categoryName : "", categoryDescription : "", categoryStatus : ""};
	        $scope.categories.push(category);
	      };
	      
	    $scope. submitCategory = function(){
	    	var flag=false;
	    	for (var i = 0; i < $scope.subcategories.length; i++) {
	    	  if($scope.categories[i].categoryName != undefined && $scope.categories[i].categoryName != ""
	    		  && $scope.categories[i].categoryStatus != undefined && $scope.categories[i].categoryStatus != "") {
	    		  	flag=true;
				 }else {
						flag=false;
						break;
				 	}
	    	  }
	    	
	    	 if(flag) {
		    	$scope.catJsonObj = angular.toJson($scope.categories, true);
		    	var response = $http.post(appContext+"/restCtrl/saveCategories",$scope.catJsonObj);
				response.success(function (data){
					alert(data);
				});
				
				response.error(function(data, status, headers, config) {
					alert("AJAX failed to get data, status=" + status);
				});
	    	 } else {
		    		$("#checkVal2").text("Category Name and Status are mandatory");
		    	} 
	    	
	    };
	    
	    $scope.getCategories = function(){
	    	var response = $http.get(appContext+"/restCtrl/getCategories");
			response.success(function (data){
				$scope.categoriesList = data;
			});
			
			response.error(function(data, status, headers, config) {
				alert("AJAX failed to get data, status=" + status);
			});
	    	
	    };
		    
	    $scope.onCategoryChange = function(id){
	    	$scope.testForm.testSubCategory.subCategoryId = "";
	    	$scope.question.testQuestion.testSubCategory.subCategoryId = "";
	    	$scope.subCategoriesList = "";
	    	if(id !=undefined && id !=""){
		    	var response = $http.get(appContext+"/restCtrl/getSubCategories/"+id);
				response.success(function (data){
					$scope.subCategoriesList = data;
				});
				
				response.error(function(data, status, headers, config) {
					alert("AJAX failed to get data, status=" + status);
				});
	    	}
	    };

	    $scope.choices = [{testQAnswer : "", testAnwerFlag : false},
	                      {testQAnswer : "", testAnwerFlag : false},
	                      {testQAnswer : "", testAnwerFlag : false},
	                      {testQAnswer : "", testAnwerFlag : false}];
	    
	    $scope.addChoice = function(){
            var newChoice = {testQAnswer : "", testAnwerFlag : false};
            $scope.choices.push(newChoice);
          };
          
	     $scope.removeChoice = function(){
	    	 var newList=[];
	    	 var flag=true;
		     angular.forEach($scope.choices,function(choice){
		        if(!choice.isDelete){
		            newList.push(choice);
		            
		        } else {
		        		flag=false;
			        }
		        });  $scope.choices=newList;
		        
		      if(flag){
		    	  	$("#checkVal6").text("Please select checkbox to delete");
		    	  } else {
		    		$("#checkVal6").text("");
		    	  }
	        };
	        
	        $scope.question={testQuestion :{testSubCategory:{subCategoryId :""},questionLevel:"",testQuestion:""}};
	        
	        $scope.addQuestion = function(){
	        	var flag=true;
	        	var newflag=false;
	        	if($scope.question.testQuestion.testSubCategory.subCategoryId !=undefined
	        			&& $scope.question.testQuestion.testSubCategory.subCategoryId !=""
	        				&& $scope.question.testQuestion.questionLevel !=undefined
	        				&& $scope.question.testQuestion.questionLevel !=""
	        					&& $scope.question.testQuestion.testQuestion !=undefined
	        					&& $scope.question.testQuestion.testQuestion !=""
	        						&& $scope.selectedCategory !=undefined) {
	        	
		        	for (var i = 0; i < $scope.choices.length; i++) {
			        	if($scope.choices[i].testQAnswer == "" || $scope.choices[i].testQAnswer == undefined) {
			        		flag=false;	
		        		}
		        	}
		        	if(flag) {
			        	for (var i = 0; i < $scope.choices.length; i++) {
			        		if($scope.choices[i].testAnwerFlag== true) {
			        			newflag=true;
		        			}
			        	}
	        		}
        		}
	        	if(newflag) {
	        		 $scope.question.choices = $scope.choices;
	                 $scope.questJsonObj = angular.toJson($scope.question, true);
	                 
	                 
	                 var response = $http.post(appContext+"/restCtrl/addQuestion/",$scope.questJsonObj);
	                 response.success(function (data){
	                 	//$scope.setActiveTab(2);
	                 	window.location.reload();
	                 	//$scope.setActiveTab(2);
	                 });
	                 
	                 response.error(function(data, status, headers, config) {
	                     alert("AJAX failed to get data, status=" + status);
	                 });
	        		
	        	} else {
	        			$("#checkVal5").text("All fields are mandatory");
	        		}
              };
		    
		    /*Prasad Changes Start*/
		    
		    $scope.subcategories = [{testCategory : "", subCategory : ""},
                                    {testCategory : "", subCategory : ""},
                                    {testCategory : "", subCategory : ""}];
		    
		    $scope.addSubCategory = function(){
                var subcategory = {testCategory : "", subCategory : ""};
                $scope.subcategories.push(subcategory);
              };
              
              $scope.removeSubCat = function(){
            	  var flag=true;
            	  var newList=[];
  		          angular.forEach($scope.subcategories,function(sc){
  			        if(!sc.isDelete){
  			            newList.push(sc);
  			        } else {
  			        		flag=false;
  			        	}
  		          });  $scope.subcategories=newList;
	  		        
	  		      if(flag){
	  		    	  $("#checkVal").text("Please select checkbox to delete");
  		    	  }else {
  		    		  $("#checkVal").text("");
  		    	  }
		        };
              

	        $scope.submitSubCategory = function(){
	        	var flag=false;
          	    for (var i = 0; i < $scope.subcategories.length; i++) {
          	    	if($scope.subcategories[i].testCategory.categoryId != undefined
          	    			&& $scope.subcategories[i].subCategory != undefined
          	    			&& $scope.subcategories[i].subCategory != "") {
          	    		flag=true;
          	    	} else {
          	    		flag=false;
          	    		break;
					 }
                }
          	    
          	    if(flag){
          	    	$scope.catJsonObj = angular.toJson($scope.subcategories, true);
                    var response = $http.post(appContext+"/restCtrl/saveSubCategories",$scope.catJsonObj);
                    response.success(function (data){
                        alert(data);
                    });
                    
                    response.error(function(data, status, headers, config) {
                        alert("AJAX failed to get data, status=" + status);
                    });
          	    } else {
 		    		$("#checkVal1").text("All fields are mandatory");
 		    	} 
              };
            
            
		    /*Prasad Changes End*/
            
            /*Ram Changes Start*/
              $scope.createTest = function(){
              	var flag=false;
              	var total=0;
              	var selectedQuestions = [];
  		        angular.forEach($scope.questionsList,function(q){
  			        if(q.isSelected) {
  			        	selectedQuestions.push(q);
  			        	flag=true;
  			        	if(q.questionLevel=="Simple"){
  			        		total=total+2;
  			        		} else if(q.questionLevel=="Medium") {
  			        			total=total+4;
  			        		} else if(q.questionLevel=="Hard") {
  			        			total=total+10;
  			        		}
  			        }
  		        });
  		        
  		        if(flag) {
  		        		if(total<=$scope.testForm.testTime) {
  		        			$scope.testForm.testQuestion = selectedQuestions;
  		        			$scope.tsJsonObj = angular.toJson($scope.testForm, true);
                  
  		        			var response = $http.post(appContext+"/restCtrl/createTest",$scope.tsJsonObj);
  		        			response.success(function (data){
	                          alert(data);
  		        			});
	                      
  		        			response.error(function(data, status, headers, config) {
	                          alert("AJAX failed to get data, status=" + status);
  		        			});
  		        		} else {
  		        			$("#checkVal8").text("Your selection exceeds the time limit please select less");
  		        		}
  		        	} else {
  		        		$("#checkVal7").text("Please select atleast one");
  		        	}
              };
            
            $scope.onSubCategoryChange = function(id){
            	if(id !=undefined && id !=""){
            		var response = $http.get(appContext+"/restCtrl/getQuestions/"+id);
    		    	
    				response.success(function (data){
    					$scope.questionsList = data;
    				});
    				
    				response.error(function(data, status, headers, config) {
    					alert("AJAX failed to get data, status=" + status);
    				});
            	}
		    };
            
		    $scope.testDiv =false ;
            $scope.questDiv = true;
            $scope.testForm={testName : "", testSubCategory : { subCategoryId:""},testTime : "" };
            
            $scope.showQuestDiv = function() {
            	if($scope.testForm.testName != "" && $scope.testForm.testName != undefined
            			&& $scope.selectedCategory3 != undefined && $scope.testForm.testSubCategory.subCategoryId != undefined
            			&& $scope.testForm.testSubCategory.subCategoryId != "" && $scope.testForm.testTime != ""
            				&& $scope.testForm.testTime != undefined) {
	            	 $scope.testDiv =!$scope.testDiv ;
	                 $scope.questDiv = ! $scope.questDiv;
            	} else {
    	    		$("#checkVal3").text("All fields are mandatory");
    	    	}
        	};
            
            /*Ram Changes End*/
		   
		/*Admin End*/
		
		/*Applicant Start*/
		
		 $scope.saveApplicant = function() {
             $scope.jsonObj = angular.toJson($scope.applicant, false);
             console.log("[save] data: " + $scope.jsonObj);
             
             var applicant = $scope.jsonObj;
                    
            var response = $http.post(appContext+'/restCtrl/saveApplicant',$scope.jsonObj);
                
            response.success(function(data, status, headers, config) {
                       $location.absUrl() == 'pages/test.jsp';
             });
                
            response.error(function(data, status, headers, config) {
                   alert("AJAX failed to get data, status=" + status);
            })     
                 
          };

		/*Applicant End*/
          
        /*Export to Excel Start*/
          
          $scope.exportToExcel = function(sDate,eDate,selectedCategory,selectedSubCategory){
  			
  			var response = null;
  			if($scope.criteria == "testName") {
  					response = $window.open(appContext+"/restCtrl/exportToExcel/" + sDate + "/" + eDate + "/" + $scope.criteria);
  				}else if($scope.criteria == "category")	{
  						response = $window.open(appContext + "/restCtrl/exportToExcel/" + selectedCategory + "/" + selectedSubCategory + "/" + $scope.criteria);
  						}
  				};
  		
	      $scope.criteriaSet = function(criteria){
				
	  		if(criteria == "testName")	{
	  				$scope.valid1 = true;
	  				$scope.valid2 = false;
	  			}else if(criteria == "category") {
	  					$scope.valid1 = false;
	  					$scope.valid2= true;
	  					$scope.fetchCategory();
	  				}
		  		};
          
	      $scope.fetchCategory = function(){
	      	
	        	var response = $http.get(appContext+"/restCtrl/getCategories");
			
	        	response.success(function(data)
	        	{
	        		$scope.category = data;
	        	});
	        	
	        	response.error(function(data, status, headers, config) {
	        		alert("AJAX failed to get data, status=" + status);
			});
	      };
        
         
	      $scope.fetchSubCategory = function(category){
	      	var response = $http.get(appContext+"/restCtrl/fetchSubCategory/"+category);
			response.success(function (data){
	  				$scope.subCateg = data;
	  			});
	  			
	  			response.error(function(data, status, headers, config) {
	  				alert("AJAX failed to get data, status=" + status);
	  			});
	      };

        /*Export to Excel End*/
		
	});	
})();