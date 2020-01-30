<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en-US"/>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<%@ taglib prefix="security"  uri="hwf-securitytag" %>
<%	String servletContextUrl = request.getContextPath();%>

		
		<c:set var="legSummaryVO" value="${deal:fetchLegSummary(requestScope.legNumber, pageContext.request)}" scope="page"/>
		<c:set var="day2legSummaryVO" value="${deal:fetchDay2LegSummary(requestScope.legNumber, pageContext.request)}" scope="page"/>
		
		<jsp:include page="../common/originalTPUsdTransactionDetails.jsp" />
		<jsp:include page="../common/originalTPLenderBorrower.jsp" />
		
		<!-- General Amendments -->
		<jsp:include page="/jsp/common/legPageAmendments.jsp">
			<jsp:param value="view" name="mode"/>
			<jsp:param value="${legNumber}" name="legIndex"/>
		</jsp:include>
		
		<div class="row highlighted">
			<div class="span5">
				<label>Original Legal Agreement Attached</label>
				<c:if test="${legSummaryVO.isEventNoticeAttachedFlag eq true}">Yes</c:if>
				<c:if test="${legSummaryVO.isEventNoticeAttachedFlag eq false}">No</c:if>
			</div>
		</div>
		
		<div class="row">
			<div class="span5">
				<label>Request Derivatives</label>
				<c:if test="${not empty legSummaryVO.derivatives}">${legSummaryVO.derivatives}</c:if>
			</div>                               
		</div> <!-- end of block -->
				
		<jsp:include page="../common/derivativesDetails.jsp" />
		
	    <jsp:include page="../common/tpTermsAndConditions.jsp" />
		<jsp:include page="../common/otherTPConsiderations.jsp" />
			
