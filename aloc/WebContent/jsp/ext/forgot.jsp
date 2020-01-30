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
		<title><s:text name="label.forgot.forgotYourUserIdPassword" /></title>
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

		<s:form id="easSubmitForm" namespace="/ext/public" action="forgotUserIdOrPassword.action">
			<div class="form-mod">
				<h1 class="loginpage"><s:text name="label.forgot.forgotYourUserIdPassword" /></h1>
				
				<div class="clear"></div>
	            
				<div class="row">
					<div class="span12">
						<div class="span1">
							<label class="right"><s:text name="label.forgot.emailC" /></label>
						</div>
						<div class="span4 left">
							<s:textfield name="email"
								id="emailAddress" 
								theme="aloc"
								maxlength="100"
							/>	
						</div>
					</div>
				</div>
			<div style="height:400px;">
				<div class="row">
					<div class="span12">
						<div class="span1">
						&nbsp;
						</div>
						<div class="span4">
							<s:submit key="label.signup.submit" cssClass="btn btn-login"></s:submit>
							<s:url action="login.action" namespace="/ext/public" var="cancelBtnlURL"/>
							<a href="<s:property value="cancelBtnlURL" />" class="btn-tertiary cancel">
								<s:text name="label.reset.cancel"></s:text>
							</a>
						</div>
					</div>
				</div>
				</div>	
			</div>	
		</s:form>
		
	</div>
	
	<%@include  file="/jsp/ext/common/footerSection.jsp" %>
		
	</body>
</html>