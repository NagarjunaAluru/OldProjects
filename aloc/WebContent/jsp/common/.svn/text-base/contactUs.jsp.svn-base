<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
 <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><s:text name="label.contactUs.pageTitle"/></title>
<%@include file="../common/includeCommonScripts.jsp"%>
</head>
<body>
	<div class="container main">
		<jsp:include page="../common/headerSection.jsp">
			<jsp:param name="createReqPopup" value="Yes"></jsp:param>
		</jsp:include>
		<h1 class="page-title span12"><s:text name="label.contactUs.pageTitle"/></h1>
		<hr class="page-title-hr">
		
			
			<div class="row smallrow">
			<h3 class="span12"><s:text name="label.contactUs.header.systemIssues"/></h3>
			<p class="dashdesc normalTxt"><a class="supernote-click-demo3" style="margin-left: 20px!important;"><s:text name="label.contactUs.header.systemIssuesDesc"/></a></p>
			<hr class="hr3" style="margin-left: 20px!important;">
			</div>

			<s:iterator value="contactDetails.systemIssues.contactuses">
			<div class="row">
				<div class="span12 bline">
					<div class="row">
						<div class="span2">
							<p><s:property value="LName"/>, <s:property value="FName"/> </p>
						</div>
						<div class="span3">
							<a href="mailto:<s:property value="email"/>"><s:property value="email"/></a>
						</div>
						<div class="span3">
							<p><s:property value="phoneNo"/></p>
						</div>
					</div>
				</div>
			</div>
			</s:iterator>
			
			<div class="row smallrow">
			<h3 class="span12"><s:text name="label.contactUs.header.tradeFinanceIssue"/></h3>
			<p class="dashdesc normalTxt"><a class="supernote-click-demo3" style="margin-left: 20px!important;"><s:text name="label.contactUs.header.tradeFinanceIssueDesc"/></a></p>
			<hr class="hr3" style="margin-left: 20px!important;">
			</div>
			
			<s:iterator value="contactDetails.tradeFinaceIssues.contactuses">
			<div class="row">
				<div class="span12 bline">
					<div class="row">
						<div class="span2">
							<p><s:property value="LName"/>, <s:property value="FName"/></p>
						</div>
						<div class="span3">
							<a href="mailto:<s:property value="email"/>"><s:property value="email"/></a>
						</div>
						<div class="span3">
							<p><s:property value="phoneNo"/></p>
						</div>
					</div>
				</div>
			</div>
			</s:iterator>
			
			
			<div class="row smallrow">
			<h3 class="span12"><s:text name="label.contactUs.header.suretyBondIssue"/></h3>
			<p class="dashdesc normalTxt"><a class="supernote-click-demo3" style="margin-left: 20px!important;"><s:text name="label.contactUs.header.suretyBondIssueDesc"/></a></p>
			<hr class="hr3" style="margin-left: 20px!important;">
			</div>
			<s:iterator value="contactDetails.surityIssues.contactuses">
			<div class="row">
				<div class="span12 bline">
					<div class="row">
						<div class="span2">
							<p><s:property value="LName"/>, <s:property value="FName"/></p>
						</div>
						<div class="span3">
							<p>
								<a href="mailto:<s:property value="email"/>"><s:property value="email"/></a>
							</p>
						</div>
						<div class="span3">
							<p><s:property value="phoneNo"/></p>
						</div>
					</div>
				</div>
			</div>
			</s:iterator>			
	</div>
	<%@include file="../common/footerSection.jsp"%>
</body>
</html>