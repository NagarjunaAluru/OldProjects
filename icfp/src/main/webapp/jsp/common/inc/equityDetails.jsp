<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en-US"/>
<t:common/>
	<script type='text/javascript' src="${context}/js/common/equityDetails.js">

</script>
<c:if test="${not empty deal:getEquityFormId(requestScope.legNumber, pageContext.request)}">
				<div>
				<h3 class="span12">Equity Details</h3>
				<div class="row">
				<div class="span12">
				 <table class="table table-striped table-bordered equity-validation">
					<thead>
					  <tr>
						<th class="header" style="width:35px;">Action</th>
						<c:if test="${deal:getEquityFormId(requestScope.legNumber, pageContext.request) eq 'Debt To Equity'}">
							<th class="header">Debt terms</th>
						</c:if>
						<th class="header">Share type</th>
						<th class="header">Number of shares</th>
						<th class="header">Par value per share</th>
					  </tr>
					</thead>
					<tbody>	
					<c:forEach var="shareInfo" items="${deal:getShareInfoList((requestScope.legNumber), pageContext.request)}" varStatus="itemNo">
						<tr>
							  <td>-</td>
							  <c:if test="${deal:getEquityFormId(requestScope.legNumber, pageContext.request) eq 'Debt To Equity'}">
							  	<td>${shareInfo.debtTerms}</td>
							  </c:if>
							  <td>${shareInfo.shareType}</td>
							   <td><fmt:formatNumber value="${shareInfo.numberOfShares}" /></td>
							  <td><fmt:formatNumber value="${shareInfo.shareValue}" /></td>
					    </tr>
					</c:forEach>
					</tbody>
					</table>
					</div>
					</div>
					</div>
			</c:if>
			
			<c:if test="${deal:getEquityFormId(requestScope.legNumber, pageContext.request) eq 'Other'}">	
			<div class="row">
				<div class="span5">
						<h3 class="span12">Description</h3>
                             ${deal:getOtherEquityComments(requestScope.legNumber, pageContext.request)}
				</div> <!-- end of block -->
			</div>
			</c:if>
		