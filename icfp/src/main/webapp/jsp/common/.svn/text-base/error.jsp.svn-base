<!DOCTYPE html>
<%@page isErrorPage="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.hydus.wff.core.exception.HWFServiceException" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<fmt:setLocale value="en-US"/>
<t:common/>
<html lang="en">
 <head>
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>ICF | Error Details</title>
    <meta name="description" content="">
    <meta name="author" content="">

   <%@include file="../common/includeCssScripts.jsp" %>
  </head>
  
  <body>
	<div class="container main">
		<%@include file="headerSection.jsp" %>
		<ul class="breadcrumb">
			<li><a href="${context}/homePage.do">Home</a> <span class="divider">/</span></li>
			<li><a href="javascript: history.go(-1)">Back</a></li>
		</ul>
		
		<c:choose>
			<c:when test="${not empty requestScope['icfp.exception']}">
				<c:set var="exception" value="${requestScope['icfp.exception']}" />
			</c:when>
			<c:otherwise>
				<c:set var="exception" value="${pageContext.exception}" />
			</c:otherwise>
		</c:choose>
		
		<h1 class="page-title span12">Error...</h1>
		<p class="span12 left clear dashdesc">An error occurred while processing the request .</p>
		<div class="form-mod">
			<h2 class="span12 collapsible collapsed">Error Details</h2>
			<div class="row">
				<div class="span12">
				 <table class="table table-striped table-bordered sortable">
				 <tbody>
						<tr>
							<td><b>Reason</b></td>
							<td>
								<c:if test="${not empty exception}">
									<c:choose>
										<c:when test="${exception['class'].simpleName  == 'HWFServiceException' or exception['class'].simpleName == 'HWFStubException'}">
											<c:if test="${not empty exception.errorMessage}">
												<c:out value="${exception.errorMessage}" />
											</c:if>
										</c:when>
										<c:when test="${exception['class'].simpleName  == 'HWFException' }">
											<c:if test="${not empty exception.errorMessage}">
												<c:out value="${exception.errorMessage}" />
											</c:if>
										</c:when>
										<c:when test="${exception['class'].simpleName  == 'ICFPException' }">
											<c:choose>
												<c:when test="${not empty exception.reason}">
													<c:out value="${exception.reason}" />
												</c:when>
												<c:when test="${not empty exception.message }">
													<c:out value="${exception.message}" />
												</c:when>
											</c:choose>
										</c:when>
										<c:otherwise>
											<c:if test="${not empty exception.message}">
												<c:out value="${exception.message}" />
											</c:if>
										</c:otherwise>
									</c:choose>
								</c:if>
							</td>
						</tr>
						<tr>
							<td><b>Log</b></td>
							<td>
								<c:if test="${not empty exception}">
									<c:choose>
										<c:when test="${exception['class'].simpleName  == 'HWFServiceException' or exception['class'].simpleName == 'HWFStubException'}">
											<c:if test="${not empty exception.detail}">
												<c:out value="${exception.detail}" />
											</c:if>
										</c:when>
										
										<%--  Commented for security fix. As per GE security standards StackTrace should not be display to user --%>
										<%-- <c:when test="${exception.class.simpleName  == 'HWFException' }">
											<c:choose>
												<c:when test="${not empty exception.detail}">
													<c:out value="${exception.detail}" />
												</c:when>
												<c:otherwise>
													<c:if test="${not empty exception.stackTrace}">
														<c:forEach var="i" items="${exception.stackTrace}">
															${i}<br/>
														</c:forEach>
													</c:if>
												</c:otherwise>
											</c:choose>
										</c:when>
										<c:otherwise>
											<c:if test="${not empty exception.stackTrace}">
												<c:forEach var="i" items="${exception.stackTrace}">
													${i}<br/>
												</c:forEach>
											</c:if>
										</c:otherwise> --%>
										
										<c:when test="${exception['class'].simpleName  == 'HWFException' }">
											<c:if test="${not empty exception.detail}">
												<c:out value="${exception.detail}" />
											</c:if>
										</c:when>
									</c:choose>
								</c:if>
							</td>
						</tr>
				 </tbody>					
				 </table>
				</div>
			</div>	
		</div>	
		<%@include  file="footerSection.jsp" %>
	</div>
 </body>
</html>	