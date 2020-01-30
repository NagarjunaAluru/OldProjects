<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page import="java.io.InputStream" %>
<%@page import="java.util.Properties" %>

<!DOCTYPE html>
		
<html>
  <head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    
	<link href="${pageContext.request.contextPath}/ext/public/css/bootstrap/bootstrap.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/ext/public/css/common/site.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/ext/public/css/common/section.css" rel="stylesheet">
	<title><s:text name="label.login.Login" /></title>
	
	<script type="text/javascript">
	  function fnfocus(){
			document.login.USER.value = "";
			document.login.PASSWORD.value = "";
			document.login.elements["USER"].focus();
	    }	
		
	    function fnsubmit(){		
		if (document.login.USER.value != "" && document.login.PASSWORD.value != "" ) {
			document.login.USER.value = 'ALOC:' + document.login.USER.value;
			document.login.submit();
		}
		else {
			alert("Enter both SSO User ID and Password");
			fnfocus();
			return false;
		}
	    }
	</script>
</head>


<body onload="javascript:fnfocus()">
<%
	ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
	Properties props = new Properties();
	props.load(classLoader.getResourceAsStream("aloc.properties"));
    String actionName=props.getProperty("aloc.login.action");   
%>
	<div class="container main">
		<div class="form-mod">
			<div class="row lastrow">
				<div class="span12">
				<div class="mar20">
					<div id="logobar">
						<div class="left" id="logo"></div>
						<p class="logotext left"><s:text name="label.login.imaginationAtWork" /></p>
					</div>
				</div>
				</div>
			</div>
		</div>
		
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
		
		<div class="form-mod mar20">
			<div class="clear"></div>
            <h1 class="login"><s:text name="label.login.welcomeToGESignOn" /></h1>
			<br />
			
			<div class="row">
				<div class="span7a">
					<img src="${pageContext.request.contextPath}/ext/public/img/bg1.jpg" />
				</div>
				
				<div class="span4a left">
					<div id="logindiv">
					<div class="clear"></div>
						<div class="row lastrow">
							<div class="span3">
								<label><s:text name="label.login.ssoLogin" /></label>
							</div>
						</div>
						
						<form name="login" action="<%=actionName%>" method="post" onSubmit="javascript:fnsubmit();return false;">
							<s:hidden  name="target" />
							<s:hidden name="smagentname" />
							<s:hidden name="orgId" id="orgId" />
						
							<div class="row smallrow">
								<div class="span1aa left"><label><s:text name="label.login.userId" /></label></div>
								<div class="span2bb left">
									<input id="USER" class="span2bb" type="text" name="USER" value="" autocomplete=OFF>	
								</div>
							</div>
							
							<div class="row smallrow">
								<div class="span1aa left"><label><s:text name="label.login.password" /></label></div>
								<div class="span2bb left">
									<input id="PASSWORD" class="span2bb" type="password" name="PASSWORD" autocomplete=OFF>
								</div>
							</div>
							
							<div class="row smallrow">
								<div class="span1aa left">&nbsp;</div>
								<div class="span3c left">
									<s:url action="forgotUserIdOrPasswordPage.action" namespace="/ext/public" var="forgorPasswordURL" />
									<a href="<s:property value="forgorPasswordURL" />"><s:text name="label.login.forgotYourPassword" /></a>
								</div>
							</div>
							
							<div class="row smallrow">
								<div class="span1aa left">&nbsp;</div>
								<div class="span3c left">
									<s:url action="resetPasswordPage.action" namespace="/ext/public" var="resetPasswordURL" />
									<a href="<s:property value="resetPasswordURL" />"><s:text name="label.login.resetPassword" /></a>
								</div>
							</div>
							
							<div class="row smallrow">
								<div class="span1aa left">&nbsp;</div>
								<div class="span2bb left">
									<input type=submit value="Log In" id=submit1 name=submit1 class="btn btn-login">
								</div>
							</div>
							
						</form>
						
						<hr />
						<div class="row smallrow">
							<div class="span3">
								<label><s:text name="label.login.newHelp" /></label>
								<s:url action="public/signupPage.action" namespace="/ext" var="signUpURL" />
								<a href="<s:property value="signUpURL" />"><s:text name="label.login.signUpNow" /></a><br />
							</div>
						</div>
					</div>
				</div>
			</div>
		
			
			<div class="clear"></div>
			<hr />
			&copy; <s:text name="label.login.generalElectricCompany" />
			<br /><br />
		</div>
	</div>
</body>
</html>