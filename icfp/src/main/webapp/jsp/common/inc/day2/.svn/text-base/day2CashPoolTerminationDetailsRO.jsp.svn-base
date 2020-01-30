<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en-US"/>
<!-- Cash Pool Termination Details Start -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>
<c:set var="day2legSummaryVO" value="${deal:fetchDay2LegSummary(1, pageContext.request)}" 	scope="page" />

<div class="display-row">

	<h2 class="span12">Cash Pool Termination Details</h2>
	<div class="clear"></div>


	<div class="row highlighted">
		<div class="span5">
			<div class="form-row">
				<p>
					<b>Current Cash Pool Agreement Attached</b>
				</p>
					<c:if test="${not empty day2legSummaryVO.currentCPAAttachedFlag}">${day2legSummaryVO.currentCPAAttachedFlag}</c:if>
			</div>
		</div>
		<!-- end of block -->
		<div class="span5 right">
			<div class="form-row">
				<p>
					<b>Termination Notice Attached</b>
				</p>
				<p><c:if test="${not empty day2legSummaryVO.terminationNoticeAttachedFlag}">${day2legSummaryVO.terminationNoticeAttachedFlag}</c:if></p>
			</div>
		</div>
		<!-- end of block -->
	</div>


</div>
<!-- display row ends here -->



