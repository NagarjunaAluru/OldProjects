<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@attribute name="source" required="true" rtexprvalue="true" %>

<c:choose>
	<c:when test="${source eq 'riskUnderwriting/riskUnderwriting'}">Risk Review</c:when>
	<c:when test="${source eq 'idagEag/idagEag'}">IDAG Approvals</c:when>
	<c:when test="${source eq 'tesg/tesg'}">TESG Approvals</c:when>
	<c:when test="${source eq 'equityBusinessCFO'}">Business CFO Approval</c:when>
	<c:when test="${source eq 'equityBusinessApprover'}">Business Approver Approval</c:when>
	<c:when test="${source eq 'transactionCapture/transactionCaptureFOCMFourBlocker'}">Transaction Capture</c:when>
	<c:when test="${source eq 'transactionCapture/transactionCaptureARFourBlocker'}">Transaction Approvals</c:when>
	<c:when test="${source eq 'transactionCapture/transactionCaptureManagerFourBlocker'}">Transaction Capture</c:when>
	<c:when test="${source eq 'transactionCapture/transactionCaptureMOFourBlocker'}">Transaction Capture</c:when>
	<c:when test="${source eq 'searchResults'}">Search Details</c:when>
	<c:when test="${source eq 'search/searchResults'}">Search Details</c:when>
	<c:when test="${source eq 'pipelineReview/pipelineReviewDeal'}">Pipeline Review</c:when>
	<c:when test="${source eq 'pipelineReview'}">Front Office Pipeline Management</c:when>
	<c:when test="${source eq 'pipelineReview/pipelineReviewCPALeg'}">Pipeline Review</c:when>
	<c:when test="${source eq 'frontoffice/CPALegRequest'}">Front Office</c:when>
	<c:when test="${source eq 'frontoffice/RCALegRequest'}">Front Office</c:when>
	<c:when test="${source eq 'frontoffice/fourBlocker'}">Front Office</c:when>
</c:choose>