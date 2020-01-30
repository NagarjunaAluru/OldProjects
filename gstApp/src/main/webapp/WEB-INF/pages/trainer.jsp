<html ng-app="app">
	<head>
		<title> Trainer </title>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
		<!-- Use Bootstrap -->
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
		<link href="<c:url value="/resources/include/styles.css" />" rel="stylesheet">
		
		<script type="text/javascript" src="<c:url value="/resources/include/angular.min_1.3.15.js" />" ></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
		<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="<c:url value="/resources/include/trainerTrainee.js" />" ></script>
		
		<meta name="viewport" content="width=device-width, initial-scale=1">
	</head>
	
	<body ng-controller="HttpCtrl as app">
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
		<div class="MainBody">

		  <!-- <ul class="nav nav-tabs">
			<li ng-class="{'active' : activeTab == 1}"><a href="" ng-click="setActiveTab(1)">Upload Documents</a></li>
			<li ng-class="{'active' : activeTab == 2}"><a href="" ng-click="setActiveTab(2)">Training Details</a></li>
		  </ul> -->
		  
		  <div class="tab-content">
			<!-- <div ng-class="{'tab-pane active': activeTab === 1, 'tab-pane' : activeTab !== 1}"> -->
			
			<br>
			<form method="post" action="#" enctype="multipart/form-data"> 
              <h2 align="center">Create/Upload Training Document</h2><br/>
	            <table align="center">
                    <tr>
                        <td>Training name</td>
                        <td><input type="text" ng-model="training.trainingName" size="30" required/></td>
                    </tr>
                    <tr>
                    <td>Category</td>
                    <td>
                    
                    <select name="repeatCategories" id="repeatCategories" ng-model="training.testCategory.categoryName" ng-change="onCategoryChange(training.testCategory.categoryName)" >
				      <option ng-repeat="category in categoriesList" value="{{category.categoryId}}">{{category.categoryName}}</option>
				    </select>
                    </td>
                </tr>
                <tr>
                    <td>Sub Category  </td>
                    <td>
                    
                    <select name="repeatSubCategories" id="repeatSubCategories" ng-model="training.testSubCategory.subCategoryId">
				      <option ng-repeat="subCategory in subCategoriesList" value="{{subCategory.subCategoryId}}">{{subCategory.subCategory}}</option>
				    </select>
                    </td>
                </tr>
                    <tr>
                        <td>Training Duration</td>
                        <td><input type="text" ng-model="training.trainingDuration" size="30" required/></td>
                    </tr>
           	 <tr>
                        <td>Upload File</td> 
                        <td><input type="file" id="file" ng-model ="uploadedDoc"  required />
                        
                        </td>
                    </tr> 
                  <tr>
                        <td><input type="button" ng-click="createTraining(uploadedDoc)" value="Upload" class="btn btn-success btn-sm"/>
                         <input type="file" on-read-file="showContent($fileContent)" />
                        </td>
                    </tr> 
	            </table>
	            
	            {{ content }}
	      </form>
			<!-- </div> -->
			
			
			
			<div ng-class="{'tab-pane active': activeTab === 2, 'tab-pane' : activeTab !== 2}">
			
			<br>
        	
            <h2 align="center">Questionaries'</h2></br>
            <table cellpadding="15" cellspacing="15" align="center" style="width:100%;float: left;">
                <tr>
                    <td>Category</td>
                    <td>
                    
                    <select name="repeatCategories" id="repeatCategories" ng-model="training.testCategory" ng-change="onCategoryChange(training.testCategory)" >
				      <option ng-repeat="category in categoriesList" value="{{category.categoryId}}">{{category.categoryName}}</option>
				    </select>
                    </td>
                </tr>
                <tr>
                    <td>Sub Category  </td>
                    <td>
                    
                    <select name="repeatSubCategories" id="repeatSubCategories" ng-model="questionary.testSubCategory">
				      <option ng-repeat="subCategory in subCategoriesList" value="{{subCategory.subCategoryId}}">{{subCategory.subCategory}}</option>
				    </select>
                    </td>
                </tr>
               
               
                <tr>
                    <td colspan="2" align="center"><input type="button" value="Submit" /></td>
                </tr>
            </table>
			</div>
			
			
			
	
		  </div>
	
		</div>

		<div class="footer"> Copyright © galaxe.com </div>
	</div>
	
	</body>
</html>


