<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>
<div class="form-mod">
	<h2 class="span12 collapsible">Transaction Classification Level</h2>
	<div class="row highlighted">
		<div class="span5">
			<div class="form-row">
				<p>
					<b>Default Transaction Classification Level</b><br />
					<c:choose>
						<c:when test="${empty sessionScope.deal.dealTcl}">
									--
								</c:when>
						<c:otherwise>
								${sessionScope.deal.dealTcl}
								</c:otherwise>
					</c:choose>
				</p>
			</div>
		</div>
		<!-- end of block -->
	</div>
	<div class="row ">
		<div class="span5">
			<div class="form-row">
				<p>
					<b>Risk Review override needed</b><br />
					${deal:getRiskOverride(pageContext.request)}
				</p>
			</div>
		</div>
		<!-- end of block -->
	</div>
	<div class="row highlighted">
		<div class="span5">
			<div class="form-row">
				<p>
					<b>Transaction Classification Level</b><br />
					<c:choose>
						<c:when test="${empty sessionScope.deal.ruAmendedTcl}">
							<c:if
								test="${deal:getRiskOverride(pageContext.request) eq 'Yes'}">
									0
								</c:if>
							<c:if test="${deal:getRiskOverride(pageContext.request) eq 'No'}">
									${sessionScope.deal.dealTcl}
								</c:if>
						</c:when>
						<c:otherwise>
							${sessionScope.deal.ruAmendedTcl}
							</c:otherwise>
					</c:choose>
				</p>
			</div>
		</div>
		<!-- end of block -->
		<div class="span5 right">
			<div class="form-row">
				<p>
					<b>Revised Transaction Classification Level Comments</b><br />
					<c:choose>
						<c:when test="${empty sessionScope.deal.revisedTclComments}">
								--
							</c:when>
						<c:otherwise>
								${sessionScope.deal.revisedTclComments}
							</c:otherwise>
					</c:choose>
			</div>
		</div>
	</div>
</div>