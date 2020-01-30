<html data-ng-app="app">
	<head>
		<title> Admin </title>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
		<!-- Use Bootstrap -->
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
		<link href="<c:url value="/resources/include/styles.css" />" rel="stylesheet">
		
		<script type="text/javascript" src="<c:url value="/resources/include/angular.min_1.3.15.js" />" ></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
		<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="<c:url value="/resources/include/app.js" />" ></script>
		
		<meta name="viewport" content="width=device-width, initial-scale=1">
	</head>
	
	<body data-ng-controller="HttpCtrl as app">
  	<div class="container">
		  	<span style="color:green;"> Welcome : <sec:authentication property="principal.username" /> </span>
		  	&nbsp;&nbsp;&nbsp;<span style="color:blue;">Roles : <sec:authentication property="principal.authorities"/></span>
		  	
	  		<div align="right" style="overflow: ">
	  			
	  		<button type="button" class="btn btn-success btn-sm" data-toggle="modal" data-target="#myModal">Generate Report</button>

			<!-- Modal -->
			<div id="myModal" class="modal fade" role="dialog">
			  <div class="modal-dialog">
			
			    <!-- Modal content-->
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal">&times;</button>
			        <h4 class="modal-title">Generate Report</h4>
			      </div>
			      <form name="Criteria" data-ng-submit = "exportToExcel(sDate,eDate,selectedCategory,selectedSubCateg)">
			      <div class="modal-body" align="left">
			       	 <p>Criteria:</p>
			      	 
				      	 <select data-ng-model="criteria" data-ng-change="criteriaSet(criteria)">
				      	 	<option value ="testName">Test Name</option>
				      	 	<option value ="category">Category</option>
				      	 </select>
				     
			      	 <div id="TestName" data-ng-show="valid1">
				      	 <p>From Date:</p>
				      	 <input type="text" data-ng-model="sDate" name ="sDate" pattern="[0-9]{2}-[0-9]{2}-[0-9]{4}" >
				      	  
				      	 <span data-ng-show ="Criteria.sDate.$touched && Criteria.sDate.$invalid" style="color:red">Enter a valid date</span>
				      	<p>End Date:</p>
				      	  <input type="text" data-ng-model="eDate" name ="eDate" pattern="[0-9]{2}-[0-9]{2}-[0-9]{4}" >
				      	  
				      	 <span data-ng-show ="Criteria.eDate.$touched && Criteria.sDate.$invalid" style="color:red">Enter a valid date</span>
				     </div>
				     
				     
			      	 <div id="category" data-ng-show="valid2">
			      	 	<p>Category</p>
			      	 	
			      	 	<select data-ng-model="selectedCategory"  data-ng-change="fetchSubCategory(selectedCategory)"  required>
			      	 		<option data-ng-repeat="c in category" value="{{c}}">{{c}}</option>
			      	 	</select>
			      	 	<p>Sub-Category</p>	
			      	 	<select data-ng-model="selectedSubCateg" >
			      	 		<option data-ng-repeat="sc in subCateg" value="{{sc}}">{{sc}}</option>
			      	 	</select> 
			      	 </div>
			      	 
			      	 </div>
			      
			      <div class="modal-footer">
			      	<button type="submit" class="btn btn-default" >Export</button>
			        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			      </div>
			      </form>
			    </div>
			
			  </div>
			</div>
	  			
	  		
			<c:url var="logoutUrl" value="j_spring_security_logout" />
			<form action="${logoutUrl}" method="post">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				<input type="submit" class="btn btn-success btn-sm" value="Log out" /> 
			</form>
			</div>
		<div class="MainBody">

		  <ul class="nav nav-tabs">
			<li data-ng-class="{'active' : activeTab == 1}"><a href="" data-ng-click="setActiveTab(1)">Create User</a></li>
			<li data-ng-class="{'active' : activeTab == 2}"><a href="" data-ng-click="setActiveTab(2)">Add Questionnaires</a></li>
			<li data-ng-class="{'active' : activeTab == 3}"><a href="" data-ng-click="setActiveTab(3)">Create Test</a></li>
			<li data-ng-class="{'active' : activeTab == 4}"><a href="" data-ng-click="setActiveTab(4)">Category Master</a></li>
			<li data-ng-class="{'active' : activeTab == 5}"><a href="" data-ng-click="setActiveTab(5)">Sub Category Master</a></li>
		  </ul>
		  
		  <div class="tab-content">
			<div data-ng-class="{'tab-pane active': activeTab === 1, 'tab-pane' : activeTab !== 1}">
			<br/>
	              <h2 align="center">User Creation</h2><br/>
	             <form name="createUserForm">
	             <h5 style="margin-left:160px;"><span style="color:red;" id="checkVal4"></span></h5>
	            <table align="center">
                    <tr>
                        <td>First Name</td>
                        <td><input type="text" name="fname" data-ng-model="user.firstName" size="30" data-ng-minlength="3" data-ng-required="true"/>
							<span style="color:red" data-ng-show="createUserForm.fname.$dirty && createUserForm.fname.$invalid">
						    <span  data-ng-show="createUserForm.fname.$error.required">FirstName is required.</span>
						    <span data-ng-show="createUserForm.fname.$error.minlength">FirstName should be minimum 3 character.</span></span></td>
                    </tr>
                    <tr>
                        <td>Last Name</td>
                       <td><input type="text" name="lname" data-ng-model="user.lastName" size="30" data-ng-minlength="4" data-ng-required="true"/>
	                        <span style="color:red" data-ng-show="createUserForm.lname.$dirty && createUserForm.lname.$invalid">
						    <span data-ng-show="createUserForm.lname.$error.required">LastName is required.</span>
						    <span data-ng-show="createUserForm.lname.$error.minlength">LastName should be minimum 4 character.</span></span></td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td><input type="email" name="email" data-ng-model="user.email" size="30" data-ng-required="true"/>
	                        <span  style="color:red" data-ng-show="createUserForm.email.$dirty && createUserForm.email.$invalid">
			  				<span  data-ng-show="createUserForm.email.$error.required">Email is required.</span>
			  				<span  data-ng-show="createUserForm.email.$error.email">Invalid email address.</span></span></td>
                    </tr>
                    <tr>
                        <td>Role</td>
                        <td>
	                        <select name="mySelect" id="mySelect"
						      data-ng-options="roles.role for roles in rolesList track by roles.roleId"
						      data-ng-model="user.userRole" required>
						      <option value="">Select</option>
						      </select>
                        </td>
                    </tr>
                   
                    <tr>
                        <td></td>
                         <td align="right"><button type="button" class="btn btn-success btn-sm" data-ng-click="createUser(user)">
								  Submit </button></td>
                    </tr>
	            </table>
	            </form>
			</div>
			
			
			
			<div data-ng-class="{'tab-pane active': activeTab === 2, 'tab-pane' : activeTab !== 2}">
			
			<br>
        	
            <h2 align="center">Questionnaires</h2><br/>
            <form name="questionForm">
            <h5 style="margin-left:20px;"><span style="color:red;" id="checkVal6"></span></h5>
            <h5 style="margin-left:20px;"><span style="color:red;" id="checkVal5"></span></h5>
            <table cellpadding="15" cellspacing="15" align="center" style="width:100%;float: left;">
                <tr>
                    <td>Category</td>
                    <td>
                   	<select name="repeatCategories" id="repeatCategories" data-ng-model="selectedCategory" data-ng-change="onCategoryChange(selectedCategory)" required>
                    	<option value="">Select</option>
			      		<option data-ng-repeat="category in categoriesList" value="{{category.categoryId}}">{{category.categoryName}}</option>
				    </select>
                    </td>
                </tr>
                <tr>
                    <td>Sub Category  </td>
                    <td>
			     	<select name="repeatSubCategories" id="repeatSubCategories" data-ng-model="question.testQuestion.testSubCategory.subCategoryId" required>
				     	<option value="">Select</option>
				      	<option data-ng-repeat="subCategory in subCategoriesList" value="{{subCategory.subCategoryId}}">{{subCategory.subCategory}}</option>
				    </select>
                    </td>
                </tr>
                <tr>
                    <td>Level</td>
                    <td>
					    <select name="repeatLevels" id="repeatLevels" data-ng-model="question.testQuestion.questionLevel" required>
						    <option value="">Select</option>
					      	<option data-ng-repeat="level in availableLevels" value="{{level.questionLevel}}">{{level.questionLevel}}</option>
					    </select>
                    </td>
                </tr>
               
               <tr>
               <td>Question</td>
               
               <td>
               <textarea name="testQuestion" data-ng-model="question.testQuestion.testQuestion" rows="5" cols="60" required="required"></textarea>
               </td>
               </tr>
               <tr>
               <td colspan="2" align="left">
               <table width="100%" border="2px">
	              <tr><th>Select</th><th></th><th></th><th>Answers</th></tr>
	              <tr data-ng-repeat="choice in choices"><td><input type="checkbox" data-ng-model="choice.isDelete"></td><td> Choice{{$index+1}}:</td>
	              	<td><input data-ng-init="QAnswer = 'testQAnswer'" name="{{QAnswer+$index}}" data-ng-model="choice.testQAnswer" type="text" required>
	              	<span style="color:red" data-ng-show="questionForm[QAnswer+$index].$dirty && questionForm[QAnswer+$index].$invalid">
				    <span  data-ng-show="questionForm[QAnswer+$index].$error.required">it is required.</span></span></td>
	              	<td><input type="checkbox" data-ng-model="choice.testAnwerFlag"></td>
	              	</tr>
              </table>
               </td>
               
               </tr>
               <tr>
               <td align="right" colspan="2">
               <button data-ng-click="addChoice()" class="btn btn-success glyphicon-plus btn-sm"> Add </button>
               <button data-ng-click="removeChoice()" class="btn btn-warning glyphicon-minus btn-sm"> Delete </button>
               </td>
               </tr>
               
                <tr>
                    <td colspan="2" align="right"><input type="button" data-ng-click="addQuestion()" class="btn btn-success btn-md" value="Submit"/> 
                </tr>
            </table>
            </form>
			</div>
			
		<div data-ng-class="{'tab-pane active': activeTab === 3, 'tab-pane' : activeTab !== 3}">
		<br/>
			<div data-ng-hide="testDiv">
            <h2 align="center">Create Test</h2><br/>
            <form name="createTestForm">
            <h5 style="margin-left:180px;"><span style="color:red;" id="checkVal3"></span></h5>
            <table align="center">
                <tr>
                    <td>Test Name</td>
                    <td>
                    <input type="text" name="testName" data-ng-model="testForm.testName" required/> 
	                    <span style="color:red" data-ng-show="createTestForm.testName.$dirty && createTestForm.testName.$invalid">
				    	<span data-ng-show="createTestForm.testName.$error.required">TestName is required.</span></span>
                    </td>
                </tr>
                 <tr>
                    <td>Category</td>
                    <td>
                    <select name="repeatCategories3" id="repeatCategories3" data-ng-model="selectedCategory3" data-ng-change="onCategoryChange(selectedCategory3)" required>
	                    <option value="">Select</option>
				      	<option data-ng-repeat="category in categoriesList" value="{{category.categoryId}}">{{category.categoryName}}</option>
				    </select>
                    </td>
                </tr>
                <tr>
                    <td>Sub Category  </td>
                    <td>
                    <select name="repeatSubCategories3" id="repeatSubCategories3" data-ng-model="testForm.testSubCategory.subCategoryId" data-ng-change="onSubCategoryChange(testForm.testSubCategory.subCategoryId)" required>
	                    <option value="">Select</option>
				      	<option data-ng-repeat="subCategory in subCategoriesList" value="{{subCategory.subCategoryId}}">{{subCategory.subCategory}}</option>
				    </select>
                    </td>
                </tr>
                <tr>
                    <td>Time Out</td>
                    <td><input type="number" name="testTime" data-ng-model="testForm.testTime" required/>
	                 	<span style="color:red" data-ng-show="createTestForm.testTime.$dirty && createTestForm.testTime.$invalid">
					    <span  data-ng-show="createTestForm.testTime.$error.required">TestTime is required.</span>
					    <span  data-ng-show="createTestForm.testTime.$error.number">plese enter valid time.</span></span>
					</td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><button type="button" data-ng-click="showQuestDiv()" class="btn btn-success btn-sm">Next</button></td>
                </tr>
            </table>
            </form>
            </div>
            
            <div data-ng-hide="questDiv"> 
            	<h2>{{testForm.testName}}</h2>
            	<span style="color:red;" id="checkVal7"></span><br/>
            	<span style="color:red;" id="checkVal8"></span>
	             <table align="center" style="width:100%" border="2px">
	             <tr><th>Select</th><th colspan="3">Questions</th><th>Level</th></tr>
	             <tr data-ng-repeat=" question in questionsList">
	             	<td><input type="checkbox" data-ng-model="question.isSelected"></td> 
	             	<td colspan="3"> {{question.testQuestion}} </td>
	             	<td> {{question.questionLevel}}</td>
	             </tr>
	             </table>
	             <button data-ng-click="showQuestDiv()" class="btn btn-success btn-sm">Back</button>
	             <br/>
	             <div> <button type="button" style="align:right;" data-ng-click="createTest()" class="btn btn-success btn-md"> Submit</button> </div>
            
            </div>
            
			</div>
			
			
			
			<div data-ng-class="{'tab-pane active': activeTab === 4, 'tab-pane' : activeTab !== 4}">
			<h2 align="center">Category Master</h2><br/>
			<form name="CategoryMasterForm">
			<h5 style="margin-left:80px;"><span style="color:red;" id="checkVal2"></span></h5>
			<table align="center">
				<tr><td>Category Name</td><td>Description</td><td>Status</td></tr>
			    <tr data-ng-repeat="c in categories">
			    <td><input type="text" data-ng-init="cname = 'categoryName'" name="{{cname+$index}}" data-ng-model="categories[$index].categoryName" required/>
					    <span style="color:red" data-ng-show="CategoryMasterForm[cname+$index].$dirty && CategoryMasterForm[cname+$index].$invalid">
					    <span  data-ng-show="CategoryMasterForm[cname+$index].$error.required">CategoryName is required.</span></span>
			    </td>
			    <td><input type="text" data-ng-model="categories[$index].categoryDescription" /></td>
			    <td>
			    	<select name="repeatSelect" id="repeatSelect" data-ng-model="categories[$index].categoryStatus" required>
				    	<option value="">Select</option>
				      	<option data-ng-repeat="option in statusOptions" value="{{option.categoryStatus}}">{{option.categoryStatus}}</option>
				    </select>
			    </td>
			    </tr>
			</table>
			</form>
			
			<div align="right"><br/>
			<button type="button" data-ng-click="addCategory()" class="btn btn-success glyphicon-plus btn-sm"> Add </button>
             &nbsp;<br/><br/>
            <button type="button" data-ng-click="submitCategory()" class="btn btn-success btn-md"> Save </button>
            </div>
			</div>
			
			
			
			<div data-ng-class="{'tab-pane active': activeTab === 5, 'tab-pane' : activeTab !== 5}">
				<h2 align="center">Sub Category Master</h2><br/>
				
				<form name="subCategoryMasterForm">
				<h5 style="margin-left:140px;"><span style="color:red;" id="checkVal1"></span></h5>
				<h5 style="margin-left:140px;"><span style="color:red;" id="checkVal"></span></h5>
				<table align="center">
		              <tr><td>Select</td><td>Category Name</td><td>Sub Category Name</td></tr>
		              <tr data-ng-repeat="sc in subcategories">
		              <td><input type="checkbox" data-ng-model="sc.isDelete"> </td>
		              <td>
	                    <select name="repeatSubCategories" id="repeatsubCategories" data-ng-model="subcategories[$index].testCategory.categoryId" required="required">
		                    <option value="">Select</option>
				      		<option data-ng-repeat="testCategory in categoriesList" value="{{testCategory.categoryId}}">{{testCategory.categoryName}}</option>
					    </select>
		              </td>
		              <td>
	            	  	<input type="text" data-ng-init="scname = 'subCategoryName'" name="{{scname+$index}}" data-ng-model="subcategories[$index].subCategory" required>
		              		<span style="color:red" data-ng-show="subCategoryMasterForm[scname+$index].$dirty && subCategoryMasterForm[scname+$index].$invalid">
					    	<span  data-ng-show="subCategoryMasterForm[scname+$index].$error.required">SubCategoryName is required.</span></span>
		    		  </td>
		              </tr>
         		</table>
         		</form>
             	<div align="right">
		             <button type="button" data-ng-click="addSubCategory()" class="btn btn-success btn-sm glyphicon-plus"> Add </button>
		             <button type="button" data-ng-click="removeSubCat()" class="btn btn-warning btn-sm glyphicon-minus"> Delete </button>
		             <br/><br/>
		             <button type="button" data-ng-click="submitSubCategory()" class="btn btn-success btn-md"> Save </button>
             	</div>
			</div>
		  </div>
		</div>
		<div class="footer"> Copyright © galaxe.com </div>
	</div>
	</body>
</html>