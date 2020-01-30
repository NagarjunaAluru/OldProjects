<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="../common/error.jsp" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
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
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>

<%@ taglib prefix="security"  uri="hwf-securitytag" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>ICF | Audit Log Full</title>
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
			<a href="${context}/${param.source}.do?command=getPipelineReviewDealDetail&DealRequestID=${sessionScope.deal.dealSeqId}&section=${sessionScope.section}&source=${param.sourcePage}&pType=${param.pType}">${param.origin}</a><span class="divider">/</span>
			</c:when>
			<c:when test="${param.source eq 'frontoffice/RCALegRequest' or param.source eq 'frontoffice/CPALegRequest'}">
			<a href="${context}/frontoffice/fourBlocker.do?command=load&DealRequestID=${sessionScope.deal.dealSeqId}&section=${sessionScope.section}&source=${param.sourcePage}&pType=${param.pType}">${param.origin}</a><span class="divider">/</span>
			</c:when>
			<c:otherwise>
			<a href="${context}/${param.source}.do?command=load&DealRequestID=${sessionScope.deal.dealSeqId}&section=${sessionScope.section}&source=${param.sourcePage}&pType=${param.pType}">${param.origin}</a><span class="divider">/</span>
			<c:set var="url" value="${context}/${param.source}.do?command=${param.method}&DealRequestID=${sessionScope.deal.dealSeqId}&section=${sessionScope.section}&source=${param.sourcePage}&pType=${param.pType}"></c:set>
			</c:otherwise>
			</c:choose>
			</li>
			</c:if>
			<c:if test="${not empty param.name}">
			<c:if test="${empty param.origin}">
			<li><a href="${context}/${param.source}.do?command=${param.method}&DealRequestID=${sessionScope.deal.dealSeqId}&section=${sessionScope.section}&source=${param.sourcePage}&pType=${param.pType}">${param.name}</a><span class="divider">/</span></li>
			<c:set var="url" value="${context}/${param.source}.do?command=${param.method}&DealRequestID=${sessionScope.deal.dealSeqId}&section=${sessionScope.section}&source=${param.sourcePage}&pType=${param.pType}"></c:set>
			</c:if>
			<c:if test="${not empty param.origin}">
			<li><a href="${context}/${param.source}.do?command=${param.method}&DealRequestID=${sessionScope.deal.dealSeqId}&legNumber=${param.legNumber}&id=${param.legNumber}&pType=${param.pType}&name=${param.name}&source=${param.source}&sourcePage=${param.sourcePage}&pType=${param.pType}">${param.name}</a><span class="divider">/</span></li>
			<c:set var="url" value="${context}/${param.source}.do?command=${param.method}&DealRequestID=${sessionScope.deal.dealSeqId}&legNumber=${param.legNumber}&id=${param.legNumber}&pType=${param.pType}&name=${param.name}&source=${param.source}&sourcePage=${param.sourcePage}&pType=${param.pType}"></c:set>
			</c:if>
			</c:if>
			
			<li class="active">Full Audit Log</li>
		</ul>
		</c:if>

		<h1 class="page-title span12">Audit Log</h1>
		

		<form>
        
		<div class="form-mod">
			
			<div class="tab-content" id="myTabContent">
				<div id="1" class="tab-pane fade active in">
		
		<div class="form-mod">
			<div class="row">
				<div class="span12">
				 <table class="table table-striped table-bordered sortable paginate">
					<thead>
					<tr>
				    	<th><bean:message key = "heading.auditLog.leg" /></th>
						<th><bean:message key = "heading.auditLog.fieldName" /></th>
						<th><bean:message key = "heading.auditLog.oldValue" /></th>
						<th><bean:message key = "heading.auditLog.newValue" /></th>
						<th><bean:message key = "heading.auditLog.author" /></th>
						<th><bean:message key = "heading.auditLog.date" /></th>
					  </tr>
					</thead>
					<tbody>
					<logic:iterate name="deal" scope="session" property="auditLogs" id="auditSection" indexId="i">
     				<tr>
 						<td>
     				    <c:if test="${empty auditSection.legSeqId}">-</c:if>
     				    <c:if test="${not empty auditSection.legSeqId}">${auditSection.legSeqId}</c:if>
     				    </td>
     					<td>
     					<c:if test="${empty auditSection.fieldName}">-</c:if>
     				    <c:if test="${not empty auditSection.fieldName}">${auditSection.fieldName}</c:if>
     					</td>
     					<td>
     					<c:if test="${empty  auditSection.oldValue}">-</c:if>
     					<c:if test="${not empty auditSection.oldValue}">${auditSection.oldValue}</c:if>
     					</td>
     					<td>
     					<c:if test="${empty auditSection.newValue}">-</c:if>
     					<c:if test="${not empty auditSection.newValue}">${auditSection.newValue}</c:if>
     					</td>
     					<td>
     					<c:if test="${empty auditSection.author}">-</c:if>
     					<c:if test="${not empty auditSection.author}">${auditSection.author}</c:if>
     					</td>
     					<td>
     					<c:if test="${empty auditSection.auditCreatedDt}">-</c:if>
     					<c:if test="${not empty auditSection.auditCreatedDt}">${auditSection.auditCreatedDt}</c:if>
     					</td>
					 </tr>
					 </logic:iterate>
					</tbody>
				  </table>
				</div>
			</div> 
        </div><!-- end of form form-mod -->
        
        


				</div><!-- END OF TAB 1 -->
                
                
                <div id="2" class="tab-pane fade">
					Second Tab Content Comes Here
                </div> <!-- end of TAB 2 -->
                        
	        </div>	
        <div class="row">
			<div class="span5 left">
            	<a class="btn-link"  onclick="history.back();">&lt;&lt; Previous</a>
            </div>
            
            <div class="span8 pagination pagination-right">
			<ul>
			</ul>
			</div>
			<div class="span2 jump-page">
			   Jump to <input type="text" class="span1 manual"> <a
				class="btn jumpto" type="submit">Go</a>
			</div>
            
        </div>
        
		</div>
        
        
		</form>
   <hr>
    </div>
	<%@include  file="../footerSection.jsp" %>
	<!-- Modals start -->

  </body>
</html>