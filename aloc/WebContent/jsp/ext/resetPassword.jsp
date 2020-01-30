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
		<title><s:text name="label.reset.resetYourPassword" /></title>
	</head>

	<body>
	<div class="container main">
		<%@include  file="/jsp/ext/common/headerSectionEmpty.jsp" %>
		
		<s:if test="hasActionErrors()">
			<div class="row">
				<div class="span12">
					<div class="errorbox">
						<div class="errorHead"><p class="erroricon"><s:text name="label.eas.common.error" /></p></div>
							<div class="errorContent">
							<p><s:actionerror/></p>
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
		
		<s:form id="easSubmitForm" action="/ext/public/resetPassword">
		
			<div class="form-mod">
			<h1 class="loginpage"><s:text name="label.reset.resetYourPassword" /></h1>
				<div class="clear"></div>
		    <div class="row">
				<div class="span6">
					<div class="row">
						<div class="span2">
							<label class="right"><s:text name="label.reset.userId"/></label>
						</div>
						<div class="span4 left">
							<s:textfield theme="aloc" name="userId" />
						</div>
					</div>
					<div class="row">
						<div class="span2">
							<label class="right"><s:text name="label.reset.otp"/></label>
						</div>
						<div class="span4 left">
							<s:password theme="aloc" name="otp" autocomplete="OFF" />
						</div>
					</div>
					<div class="row">
						<div class="span2">
							<label class="right"><s:text name="label.reset.passwordC"/></label>
						</div>
						<div class="span4 left">
							<s:password name="password"
								id="password" 
								theme="aloc"
								maxlength="15"
								autocomplete="OFF"
							/>	
						</div>
					</div>
					<div class="row">
						<div class="span2">
							<label class="right"><s:text name="label.reset.confirmPasswordC"/></label>
						</div>
						<div class="span4 left">
							<s:password name="confirmPassword"
								id="confirmPassword" 
								theme="aloc"
								maxlength="15"
								autocomplete="OFF"
							/>	
						</div>
					</div>
				<div style="height:400px;">
					<div class="row">
						<div class="span2">
							&nbsp;
						</div>
						<div class="span4">
						
							<s:submit key="label.reset.field.password" cssClass="btn-primary"></s:submit>
							
							<s:url action="login.action" namespace="/ext/public" var="cancelBtnlURL"/>
							<a href="<s:property value="cancelBtnlURL" />" class="btn-tertiary cancel"><s:text name="label.reset.cancel"></s:text></a>&nbsp;&nbsp;&nbsp;
							
						</div>
					</div>
				</div>	
				</div>	
				<div class="span6" style="margin-top:20px;">
					<div class="row" style="height:55px;"></div>
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
				<div class="clear"></div>
			</div>
			</div><!-- end of form form-mod -->
		</s:form>
		
	</div>
	
	<%@include  file="/jsp/ext/common/footerSection.jsp" %>
		
	</body>
</html>