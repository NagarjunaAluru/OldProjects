<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
	    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	    
		<%@include file="/jsp/ext/common/includeCommonScripts.jsp" %>
		<script src="${pageContext.request.contextPath}/ext/public/js/ext/easOperations.js" type="text/javascript"></script>
		<title><s:text name="label.signup.alocRegApplication" /></title>
	</head>

	<body>
	
	<div class="container main">
		<%@include  file="/jsp/ext/common/headerSectionEmpty.jsp" %>
				
		<s:if test="hasFieldErrors()">
			<div class="row">
				<div class="span12">
					<div class="errorbox">
						<div class="errorHead"><p class="erroricon"><s:text name="label.eas.common.error" /></p></div>
							<div class="errorContent">
							<p><s:fielderror/></p>
							</div>
					</div>
				</div>
			</div>
		</s:if>
		
		<s:if test="hasActionMessages()">
			<div class="row">
				<div class="span12">
					<div id="siteMsg">
			            <div class="sucessMsg"><s:text name="label.eas.common.success" /></div>
			            <div class="sucessContent"><s:actionmessage/></div>
			        </div>
			    </div>
			</div>
		</s:if>
		
	<s:form id="easSubmitForm" action="/ext/public/signup.action">
		<div class="form-mod">
			<h1 class="loginpage"><s:text name="label.signup.alocRegApplication" /></h1>
		
		<h2 class="regpage"><s:text name="label.signup.contactDetails" /></h2><hr class="h2-hr">
				<div class="row">
					<div class="span2">
						<label class="right"><s:text name="label.signup.firstNameC" /></label>
					</div>
					<div class="span4 left">
						<s:textfield name="easDetails.EASContactDetails.firstName"
							id="firstName" 
							theme="aloc"
							maxlength="50"
						/>	
					</div>
				</div>
				<div class="row">
					<div class="span2">
						<label class="right"><s:text name="label.signup.lastNameC" /></label>
					</div>
					<div class="span4 left">
						<s:textfield name="easDetails.EASContactDetails.lastName"
							id="lastName" 
							theme="aloc"
							maxlength="50"
						/>	
					</div>
				</div>
				<div class="row">
					<div class="span2">
						<label class="right"><s:text name="label.signup.emailAddressC" /></label>
					</div>
					<div class="span4 left">
						<s:textfield name="easDetails.EASContactDetails.emailAddress"
							id="emailAddress" 
							theme="aloc"
							maxlength="100"
						/>	
					</div>
				</div>
				<div class="row">
					<div class="span2">
						<label class="right"><s:text name="label.signup.confirmEmailAddressC" /></label>
					</div>
					<div class="span4 left">
						<s:textfield name="confirmEmail"
							id="confirmEmailAddress" 
							theme="aloc"
							maxlength="100"
						/>	
					</div>
				</div>
		<h2 class="regpage"><s:text name="label.signup.bankDetails" /></h2><hr class="h2-hr">
				<div class="row">
					<div class="span2">
						<label class="right"><s:text name="label.signup.bankNameC" /></label>
					</div>
					<div class="span4 left">
						<s:textfield name="easDetails.EASBankDetails.bankName"
							id="bankName" 
							theme="aloc"
							maxlength="200"
						/>	
					</div>
				</div>
				<div class="row">
					<div class="span2">
						<label class="right"><s:text name="label.signup.roleC" /></label>
					</div>
					<div class="span4 left">
						<div class="radio-container">
							<s:radio theme="aloc" cssClass="radio"
								name="easDetails.EASBankDetails.roleName" 
								list="#{'BankOperations':'Bank Operations','BankReadOnly':'Bank Read-only','SuretyBrokerOperations':'Broker Operations','SuretyBrokerReadOnly':'Broker Read-only'}"
								value="%{easDetails.EASBankDetails.roleName}"
								id="bankRoleName"
								/>
                          </div>
					</div>
				</div>
			<div class="clear"></div>
			
		<h2 class="regpage"><s:text name="label.signup.chooseAUserIdAndPassword" /></h2><hr class="h2-hr">
        <div class="row">
		<div class="span8">
			<div class="row">
					<div class="span2">
						<label class="right"><s:text name="label.signup.userIdC" /></label>
					</div>
					<div class="span5 left">
						<s:textfield name="easDetails.EASCredentials.userId"
							id="userId" 
							theme="aloc"
							maxlength="12"
						/>	
						<br />
						<i style="padding-top:5px; color:#999;"><s:text name="label.signup.uouCanUserYourEmail" /></i>
					</div>
			</div>
			<div class="row">
					<div class="span2">
						<label class="right"><s:text name="label.reset.passwordC" /></label>
					</div>
					<div class="span4 left">
						<s:password name="password"
							id="password" 
							theme="aloc"
							maxlength="15"
						/>	
					</div>
			</div>
			<div class="row">
					<div class="span2">
						<label class="right"><s:text name="label.reset.confirmPasswordC" /></label>
					</div>
					<div class="span4 left">
						<s:password name="confirmPassword"
							id="confirmPassword" 
							theme="aloc"
							maxlength="15"
						/>	
					</div>
			</div>
			
		</div>	
		<div class="span4">
		<div class="span4 right" id="pswdiv">
		    <ul>
				<li class="first"><s:text name="label.signup.passwordDescFollowC" /></li>
				<li><s:text name="label.signup.mustBeginWithALetter" /></li>
				<li><s:text name="label.signup.eightToFifteenChar" /></li>
				<li><s:text name="label.signup.mustContainTwoLowerCase" /></li>
				<li><s:text name="label.signup.atleastTwoNumbers" /></li>
				<li><s:text name="label.signup.specialCharPermitted" /></li>
				<li><s:text name="label.signup.mustEndWithALetter" /></li>
			</ul>
		</div>
		</div>
		</div>
		<div class="row">
					<div class="span2">
					&nbsp;
					</div>
					<div class="span2c">
						<s:checkbox name="termsAccepted" cssClass="checkbox" key="label.signup.readAndAccept" theme="aloc-TransactionParties"></s:checkbox>
					</div>
					<div class="span4 left">
						&nbsp;&nbsp;&nbsp;<a href="javascript:;" id="termslink"><s:text name="label.signup.termsAndConditions" /></a>
					</div>
			</div>
		<div id="termsncond" class="hide">
			<div class="row">
			<div class="span12">
				<p><s:text name="label.signup.singleSignOnDesc" />
				</p>
			</div>
			</div>
		</div>
		<br />
		<div class="clear"></div>
			<div class="row right">
					<div class="span3 ">
						<s:url action="login.action" namespace="/ext/public" var="cancelBtnlURL"/>
						<a href="<s:property value="cancelBtnlURL" />" class="btn-tertiary cancel"><s:text name="label.reset.cancel"></s:text></a>&nbsp;&nbsp;&nbsp;
						<s:submit key="label.signup.submit" cssClass="btn-primary"  id="subButton"></s:submit>
								
					</div>
			</div>
		<div class="clear"></div>

	</div><!-- end of form form-mod -->
	</s:form>
		
	</div>
	
	<%@include  file="/jsp/ext/common/footerSection.jsp" %>
		
	</body>
</html>