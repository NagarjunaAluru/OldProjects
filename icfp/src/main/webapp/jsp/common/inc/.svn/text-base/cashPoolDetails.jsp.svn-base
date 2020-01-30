<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="/WEB-INF/config/tld/attachment" prefix="attachment" %>
<%@ taglib uri="/WEB-INF/config/tld/hwf-desktoptag.tld" prefix="wfdesktop" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<%@taglib uri="http://ge.com/icfp/taglibs/staticdata" prefix="staticdata" %>
<%@taglib uri="http://ge.com/icfp/taglibs/masterdata" prefix="masterdata" %>
<%@taglib uri="http://ge.com/icfp/taglibs/userInformation" prefix="userDetails" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>

<c:set var="legList" value="${deal:fetchLegs(pageContext.request)}" />

<c:if test="${legList != null}"> 
	<c:forEach var="legDetailsId" items="${legList}" >
	<div class="form-mod">
			<h2 class="span12">Cash Pool Details</h2>
			<div class="row highlighted">
				<div class="span5">
					<div class="form-row">
						<p><b>Cash Pool Name</b></p>
						<p>
						<c:if test="${!empty legDetailsId.cashPoolName}"> 
							<td>${legDetailsId.cashPoolName}</td>
						</c:if>
						</p>
					</div>
				</div><!-- end of block -->
				<div class="span5 right">
					<div class="form-row">
						<p><b>Cash Pool Country</b></p>
						<p>
						<c:if test="${!empty legDetailsId.cashPoolCountry}"> 
							<td>${legDetailsId.cashPoolCountry}</td>
						</c:if>
						</p>
					</div>
				</div><!-- end of block -->
			</div>
			<div class="row">
				<div class="span5">
					<div class="form-row">
						<p><b>Cash Pool Region</b></p>
						<p>
						<c:choose>
						<c:when test="${!empty legDetailsId.cashPoolRegion}"> 
							<td>${legDetailsId.cashPoolRegion}</td>
						</c:when>
						<c:otherwise>
						<bean:message key="label.newRequests.data" />
						</c:otherwise>
						</c:choose>
						</p>
					</div>
				</div><!-- end of block -->
				<div class="span5 right">
					<div class="form-row">
						<p><b>Cash Pool Currency</b></p>
						<p>
						<c:choose>
						<c:when test="${!empty legDetailsId.cashPoolCurrency}"> 
							<td>${legDetailsId.cashPoolCurrency}</td>
						</c:when>
						<c:otherwise>
						<bean:message key="label.newRequests.data" />
						</c:otherwise>
						</c:choose>
						
						
						</p>
					</div>
				</div><!-- end of block -->
			</div>
		</div>
		</c:forEach>
		</c:if>