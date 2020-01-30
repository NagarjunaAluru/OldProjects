<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="../common/error.jsp" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en-US"/>
<t:common/>
<%
	String servletContextUrl = request.getContextPath();
%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="/WEB-INF/config/tld/attachment" prefix="attachment"%>
<%@ taglib uri="/WEB-INF/config/tld/hwf-desktoptag.tld"
	prefix="wfdesktop"%>

<%@ taglib prefix="security"  uri="hwf-securitytag" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>ICF | Comments Log Full</title>
<meta name="description" content="">
<meta name="author" content="">
<%@include file="../includeCssScripts.jsp" %>

<script type="text/javascript">
//Defining the global variable, so this variable can be used by other javascript library included in this JSP 
 var contextURL = '<%=servletContextUrl%>';
</script>
<script src="<%=servletContextUrl%>/js/pagination.js"></script>
<%String legLenforJS ="0";%>
					
<script type="text/javascript">
var legLen = '<%=legLenforJS%>';
</script>
</head>
<body>
	<div class="container main">
		<%@include file="../headerSection.jsp" %>
		
	<c:if test="${not requestScope.isReadOnly}">
		<ul class="breadcrumb">
			<li><a href="${context}/homePage.do">Home</a> <span class="divider">/</span></li>
			<c:if test="${not empty param.origin}">
			<li>
			<c:choose>
			<c:when test="${param.source eq 'searchResults'}">
			<a href="${context}/${param.source}.do?command=getSearchDealDetail&DealRequestID=${sessionScope.deal.dealSeqId}">${param.origin}</a><span class="divider">/</span>
			</c:when>
			<c:when test="${param.source eq 'pipelineReview/pipelineReviewDeal' or param.source eq 'pipelineReview/pipelineReviewCPALeg'}">
			<a href="${context}/${param.source}.do?command=getPipelineReviewDealDetail&DealRequestID=${sessionScope.deal.dealSeqId}&section=${sessionScope.section}&source=${param.sourcePage}">${param.origin}</a><span class="divider">/</span>
			</c:when>
			<c:when test="${param.source eq 'frontoffice/RCALegRequest' or param.source eq 'frontoffice/CPALegRequest'}">
			<a href="${context}/frontoffice/fourBlocker.do?command=load&DealRequestID=${sessionScope.deal.dealSeqId}&section=${sessionScope.section}">${param.origin}</a><span class="divider">/</span>
			</c:when>
			<c:otherwise>
			<a href="${context}/${param.source}.do?command=load&DealRequestID=${sessionScope.deal.dealSeqId}&section=${sessionScope.section}">${param.origin}</a><span class="divider">/</span>
			<c:set var="url" value="${context}/${param.source}.do?command=${param.method}&DealRequestID=${sessionScope.deal.dealSeqId}&section=${sessionScope.section}&source=${param.sourcePage}"></c:set>
			</c:otherwise>
			</c:choose>
			</li>
			</c:if>
			<c:if test="${not empty param.name}">
			<c:if test="${empty param.origin}">
			<li><a href="${context}/${param.source}.do?command=${param.method}&DealRequestID=${sessionScope.deal.dealSeqId}&section=${sessionScope.section}&source=${param.sourcePage}&id=${param.legNumber}">${param.name}</a><span class="divider">/</span></li>
			<c:set var="url" value="${context}/${param.source}.do?command=${param.method}&DealRequestID=${sessionScope.deal.dealSeqId}&section=${sessionScope.section}&source=${param.sourcePage}&id=${param.legNumber}"></c:set>
			</c:if>
			<c:if test="${not empty param.origin}">
			<li><a href="${context}/${param.source}.do?command=${param.method}&DealRequestID=${sessionScope.deal.dealSeqId}&legNumber=${param.legNumber}&id=${param.legNumber}&pType=${param.pType}&name=${param.name}&source=${param.source}&sourcePage=${param.sourcePage}">${param.name}</a><span class="divider">/</span></li>
			<c:set var="url" value="${context}/${param.source}.do?command=${param.method}&DealRequestID=${sessionScope.deal.dealSeqId}&legNumber=${param.legNumber}&id=${param.legNumber}&pType=${param.pType}&name=${param.name}&source=${param.source}&sourcePage=${param.sourcePage}"></c:set>
			</c:if>
			</c:if>
			<li class="active">Full Comments</li>
		</ul>
	</c:if>

		<h1 class="page-title span12">Comments</h1>
		<p class="span12 left clear dashdesc"></p>

		<form>
        
		<div class="form-mod">
			<div class="row">
				<div class="span12">
				 <table class="table active table-striped table-bordered sortable paginate">
					<thead>
				      <tr>
					   <th><bean:message key="heading.commentsLog.date" /></th>
					   <th><bean:message key="heading.commentsLog.actionType" /></th>
					   <th><bean:message key="heading.commentsLog.group"/></th>
					   <th><bean:message key="heading.commentsLog.author" /></th>
					   <th><bean:message key="heading.commentsLog.tableComments" /></th>
				      </tr>
			       </thead>
					<tbody>
				 <logic:iterate name="deal" scope="session" property="commentsLogs" id="commentsSection">
					<tr>
						<td><bean:write name='commentsSection' property="actionDt" /></td>
						<td><bean:write name='commentsSection' property="commentType" /></td>
						<c:choose>
     					<c:when test="${!empty commentsSection.wfStage}">
						<td><bean:write name='commentsSection' property="wfStage" /></td>
						</c:when>
						<c:otherwise>
						<td>-</td>
						</c:otherwise>
						</c:choose>
						<td><bean:write name='commentsSection' property="author" /></td>
						<td>
						  <div style="word-wrap:break-word">
						  <c:choose>
     					  <c:when test="${!empty commentsSection.comments}"> 
						  	<bean:write name='commentsSection' property="comments" />
						  	</c:when><c:otherwise>
						  	-
						  	</c:otherwise>
						  	</c:choose>
						  </div>
						</td>
					</tr>
				 </logic:iterate>
				   </tbody>
				    </table>
				</div>
			</div> 
            
        <div class="row">
        <div class="span2 left">
        		<a class="btn-link"  onclick="history.back();">&lt;&lt; Previous</a>
            </div>
						<div class="span8 pagination pagination-right">
						<input type='hidden' id='current_page' />
							<ul>
							</ul>
						</div>
						<div class="span2 jump-page">
							Jump to <input type="text" class="span1 manual"> <a
								class="btn jumpto" type="submit">Go</a>
						</div>
				</div>
        </div><!-- end of form form-mod -->
      	</form>
   <hr>
    </div>
	<%@include  file="../footerSection.jsp" %>
	<!-- Modals start -->

			
  </body>
</html>