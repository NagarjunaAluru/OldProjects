<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="hwfs" uri="/hwf-security-tags"%>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%@include file="/jsp/ext/common/dashboardIncludeScripts.jsp"%>
<link href="${pageContext.request.contextPath}/ext/public/css/common/reports.css"
	rel="stylesheet" />
<script src="${pageContext.request.contextPath}/ext/public/js/reports/viewAdhocReports.js"></script>
<title><s:text name="label.dashboard.viewAdhocReport" /></title>
</head>
<body>
	<div class="container main">
		<jsp:include page="/jsp/ext/common/headerSection.jsp">
			<jsp:param name="createReqPopup" value="Yes" />
		</jsp:include>
		
		<c:if test="${not empty requestScope.DeletedTemplate}">
		<div id="siteMsg">
	       	<div class="sucessMsg" style="width: 904px;">
	           	<a href="#" class="right successclose" style="font-size: 20px; margin-right:-470px;">X</a>
	           	<s:text name="label.treasuryAdminPortal.success" />
	        </div>
	        <div class="sucessContent" style="width: 923px;">
	        	Template Name <c:out value="${requestScope.DeletedTemplate}"/> Deleted Successfully
	        </div>
	    </div>
	    </c:if>
	    
		<h1 class="page-title span12">
			Custom Reports
		</h1>
		<p class="span12 left clear dashdesc">
			Create and save up to ten (10) individual custom reports within
			ALOC. In addition, you are also able to view published reports from
			other ALOC users.<br /> <b>NOTE:</b> Ensure that you are familiar
			with standard system reports available prior to creating a custom
			report.
		</p>
		<hr class="page-title-hr">

		<div class="form-mod">
			<c:choose>
				<c:when test="${adhocReportTabType eq 'MYREPORTS'}">
					<c:set var="myReportLIClass" value="active"></c:set>
        			<c:set var="myReportTab" value="active in"></c:set>
				</c:when>
				<c:when test="${adhocReportTabType eq 'PUBLISHEDREPORTS'}">
					<c:set var="publishedReportLIClass" value="active"></c:set>
        			<c:set var="publishedReportTab" value="active in"></c:set>
				</c:when>
			</c:choose>
			
			<s:url action="viewUserReports.action" 
				namespace="/ext/reports"
				var="viewUserReportsURL" />
			<s:url action="viewPublishedReports.action" 
				namespace="/ext/reports"
				var="viewPublishedReportsURL" />
			
			<ul class="nav nav-tabs tabs">
				<li class="${myReportLIClass}"><a href="<s:property value="#viewUserReportsURL" />">My Reports</a></li>
				<li class="${publishedReportLIClass}"><a href="<s:property value="#viewPublishedReportsURL" />">Published Reports</a></li>
			</ul>
			<div class="tab-content" id="myTabContent">
				<div id="myReportDiv" class="tab-pane fade ${myReportTab}">
					<c:if test="${adhocReportTabType eq 'MYREPORTS'}">
						<jsp:include page="viewAdhocReportsTab1.jsp" />
					</c:if>
				</div>
				<div id="publishedReportDiv" class="tab-pane fade ${publishedReportTab}">
					<c:if test="${adhocReportTabType eq 'PUBLISHEDREPORTS'}">
						<jsp:include page="viewAdhocReportsTab2.jsp" />
					</c:if>
				</div>
			</div>
		</div>
	</div>
	<%@include file="/jsp/ext/common/footerSection.jsp"%>
</body>
</html>