<%@page isErrorPage="true"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="hwfc" uri="/hwf-common-tags" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
	<head>
		 <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>ALOC | Error Details</title>

		<c:choose>
			<c:when test="${not empty requestScope.externalRequest && requestScope.externalRequest eq true}">
				<link href="${pageContext.request.contextPath}/ext/css/bootstrap/bootstrap.css" rel="stylesheet">
				<link href="${pageContext.request.contextPath}/ext/css/common/site.css" rel="stylesheet">
			</c:when>
			
			<c:otherwise>
				<link href="${pageContext.request.contextPath}/css/bootstrap/bootstrap.css" rel="stylesheet">
				<link href="${pageContext.request.contextPath}/css/common/site.css" rel="stylesheet">
			</c:otherwise>
		</c:choose>
		<script src="${pageContext.request.contextPath}/js/common/section.js" type="text/javascript"></script>
	</head>

	<body>
		<div class="container main">
			<%-- Include Header --%>
			<c:choose>
				<c:when test="${not empty requestScope.externalRequest && requestScope.externalRequest eq true}">
					<%-- <jsp:include page="/jsp/ext/common/headerSection.jsp" /> --%>
				</c:when>
				
				<c:otherwise>
					<%-- <jsp:include page="/jsp/common/headerSection.jsp" /> --%>
				</c:otherwise>
			</c:choose>
		
			<c:choose>
				<%-- Forwarded from ExceptionControllerServlet --%>
				<c:when test="${not empty requestScope.errorData}">
					<c:set var="errorData" value="${requestScope.errorData}" />
				</c:when>
				
				<%-- Forwarded from JSP --%>
				<c:when test="${not empty pageContext.exception}">
					<hwfc:errorHandler var="errorData" />
				</c:when>
			</c:choose>
			
			<h1 class="page-title span12">Error...</h1>
			<p class="span12 left clear dashdesc">
				<c:choose>
					<c:when test="${not empty errorData}">
						<c:out value="${errorData.message}" />
					</c:when>
					<c:when test="${empty errorData && not empty requestScope['javax.servlet.error.message']}">
						<c:out value="${requestScope['javax.servlet.error.message']}" />
					</c:when>
				</c:choose>
			</p>
			<hr class="page-title-hr">
			
			<div class="clear"></div>
			
			<div class="form-mod">
	
					<div class="row">
						<div class="span12">
							<h2>Details</h2><hr class="h2-hr">
						</div>
					</div>
					<div class="row">
						<div class="span12">
						<table class="table table-striped table-bordered sortable no-bottom" id="Currency">
								<tbody>
									<c:if test="${not empty errorData}">
										<tr>
											<td><b>ID</b></td>
											<td><c:out value="${errorData.id}" /></td>
										</tr>
										
										<c:if test="${not empty errorData.code}">
											<tr>
												<td><b>Error Code</b></td>
												<td><c:out value="${errorData.code}" /></td>
											</tr>
										</c:if>
										
										<tr>
											<td><b>Reason</b></td>
											<td class="errorReason"><c:out value="${errorData.message}" /></td> 
										</tr>
									</c:if>
									
									<tr>
										<td><b>Status</b></td>
										<td><c:out value="${pageContext.errorData.statusCode}" /></td>
									</tr>
									
									<c:if test="${empty errorData && not empty requestScope['javax.servlet.error.message']}">
										<tr>
											<td><b>Reason</b></td>
											<td><c:out value="${requestScope['javax.servlet.error.message']}" /></td>
										</tr>
									</c:if>
									
									<tr>
										<td><b>URI</b></td>
										<td><c:out value="${pageContext.errorData.requestURI}" /></td>
									</tr>
								</tbody>
						</table>		
						</div>
					</div>
			</div>
		</div>
		
		<%-- Include Footer --%>
		<c:choose>
			<c:when test="${not empty requestScope.externalRequest && requestScope.externalRequest eq true}">
				<%-- <jsp:include page="/jsp/ext/common/footerSection.jsp" /> --%>
			</c:when>
			
			<c:otherwise>
				<%-- <jsp:include page="/jsp/common/footerSection.jsp" /> --%>
			</c:otherwise>
		</c:choose>
	</body>
</html>

