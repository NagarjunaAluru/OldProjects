(function() {
	
	var app = angular.module("app", []);
	var appContext = "/gstApp/rest";
	
	app.controller("HttpCtrl", function($scope, $http) {
		
		$scope.activeTab = 1;
		
		$scope.setActiveTab = function(tabToSet) {
			$scope.getCategories();
			$scope.activeTab = tabToSet;
		};
		
		
    	var response = $http.get(appContext+"/restCtrl/getCategories");
		response.success(function (data){
			$scope.categoriesList = data;
		});
		
		response.error(function(data, status, headers, config) {
			alert("AJAX failed to get data, status=" + status);
		});
		
		
		$scope.onCategoryChange = function(id){
			if(id != ""){
				var response = $http.get(appContext+"/restCtrl/getSubCategories/"+id);
				response.success(function (data){
					$scope.subCategoriesList = data;
				});
				
				response.error(function(data, status, headers, config) {
					alert("AJAX failed to get data, status=" + status);
				});
			}
	    };
	    
		 $scope.createTraining=function(file) {
			 
		 $scope.data = 'none'; 
	      var f = document.getElementById('file').files[0],
	          r = new FileReader();
	      r.onloadend = function(e){        
	        var binary = "";
			var bytes = new Uint8Array(e.target.result);
			var length = bytes.byteLength;
	
			for (var i = 0; i < length; i++) {
			    binary += String.fromCharCode(bytes[i]);
			}
	
			$scope.data = (binary).toString();

	      }
	      r.readAsArrayBuffer(f);
	      setTimeout(function(){  
       	 //$scope.training.trainingFile=$scope.data;
       	 $scope.training.fileUpload= $scope.content;
       	 $scope.training.trainingFileName=f.name;
     	 $scope.tsJsonObjt = angular.toJson($scope.training, true);
     	 //alert($scope.tsJsonObjt);
     	 var response = $http.post(appContext+"/restCtrl/createTraining/",$scope.tsJsonObjt);
     	 response.success(function (data){
               alert("Uploaded Successfully");
           });
           
           response.error(function(data, status, headers, config) {
                   alert("AJAX failed to get data, status=" + status);
           });
	      }, 1000);
         };
         
         $scope.showContent = function($fileContent){
             $scope.content = $fileContent;
         };
		 
		 
	});	
	
	
	app.directive('onReadFile', function ($parse) {
		return {
			restrict: 'A',
			scope: false,
			link: function(scope, element, attrs) {
	            var fn = $parse(attrs.onReadFile);
	            
				element.on('change', function(onChangeEvent) {
					var reader = new FileReader();
	                
					reader.onload = function(onLoadEvent) {
						scope.$apply(function() {
							fn(scope, {$fileContent:onLoadEvent.target.result});
						});
					};

					reader.readAsText((onChangeEvent.srcElement || onChangeEvent.target).files[0]);
				});
			}
		};
	});
	
	
})();