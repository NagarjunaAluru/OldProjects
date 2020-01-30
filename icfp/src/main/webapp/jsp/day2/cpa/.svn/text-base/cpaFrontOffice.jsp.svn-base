<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta name="description" content="">
	<meta name="author" content="">

<% String servletContextUrl = request.getContextPath(); %>

<script> var servletContextUrl = '<%=servletContextUrl%>';</script>

</head>
<c:set var="legNumber" value="${requestScope.legNumber}" />
<c:set var="legSummaryVO" value="${deal:fetchLegSummary(requestScope.legNumber, pageContext.request)}" scope="page"/>
	<!-- Leg Reference Id Details Start -->
	<jsp:include page="../../common/inc/day2/day2CPARequestDetails.jsp">
			<jsp:param value="cpafrontOffice" name="path" />
			<jsp:param value="${legNumber}" name="legNumber" />
	</jsp:include>
	<!-- Leg Reference Id Details End -->
	
	

<c:choose>
	<c:when test="${param.actionId eq 2}">
	
	<script src="<%=servletContextUrl%>/js/cpaRequest.js" type="text/javascript"></script>
	<script src="<%=servletContextUrl%>/js/day2/day2CashPool.js" type="text/javascript"></script>
	<script src="<%=servletContextUrl%>/js/bootstrap-typeahead.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/pagination.js"></script>	
	
	<html:form action="/frontoffice/CPALegRequest.do" styleId="cpaLegRequestForm" method="post" enctype="multipart/form-data">
		<input type="hidden" name="legNumber" id="legNumber" value="<bean:write name="cpaLegRequestForm" property="legNumber" />" />
		<input type="hidden" name="legNumber" value="${legNumber}">
		<input type="hidden" id="actionId" value="${requestScope.actionId}">
		<input type="hidden" name="legSeqId" value="${legSummaryVO.legSeqId}" />
	
	<html:hidden name="cpaLegRequestForm" property="cpaSummary.legTypeId" value="3" />
		<!-- Original Transaction Details & Participant Start -->
		<jsp:include page="../../common/inc/day2/day2CPAOriginalTranscationDetails.jsp">
			<jsp:param name="day" value="day2" />
			<jsp:param name="tab" value="FO" />
		</jsp:include>
		<!-- Original Transaction Details & Participant End -->
		<!-- Pool Leader Start-->
		<%@ include file="../../common/inc/day2/day2CPAPoolLeader.jsp"%>
		<!-- Pool Leader End-->
		<c:choose>
			<c:when test="${param.transactionEventTypeId eq 10}">
				<%@ include file="../../common/inc/day2/day2CPACorrections.jsp"%>
			</c:when>
			<c:when test="${(param.transactionEventTypeId eq 1 || param.transactionEventTypeId eq 2 )}">

				<c:if test="${param.transactionEventTypeId eq 1}">
					<!-- Cash Pool Termination -->
					<%@ include file="../../common/inc/day2/day2CashPoolTerminationDetails.jsp"%>
				</c:if>

				<!-- Other Considerations -->
				<%@ include file="../../common/inc/day2/day2CPAOtherConsiderations.jsp"%>
				<!-- Exceptions -->
				 <%@ include file="../../common/inc/day2/day2CPAFOExceptions.jsp"%>
				<!-- Settlement/Other Details-->
				<jsp:include page="../../common/inc/day2/day2CPASettlementsOROtherDetails.jsp">
					<jsp:param name="actionId" value="${param.actionId}" />
					<jsp:param name="transactionEventTypeId" value="${param.transactionEventTypeId}" />
				</jsp:include>
			</c:when>
		</c:choose>

		
		<!-- Qualitative Assessment log Start -->
		<jsp:include page="../../frontOffice/cpaQualitativeAssessment.jsp">
			<jsp:param name="factors" value="Regulatory Risk,Finance Risk,Legal Governance Risk,Reputational Risk,Sovereign Risk" />
		</jsp:include>
		<!-- Qualitative Assessment log End -->

		<!-- Comments log Start -->
		
		<div class="form-mod">
			<jsp:include page="../../common/inc/commentsLog.jsp">
				<jsp:param name="formName" value="cpaLegRequestForm" />
				<jsp:param value="${param.path}" name="path"/>
				<jsp:param value="${param.origin}" name="origin"/>
				<jsp:param value="${param.source}" name="source"/>
				<jsp:param value="${param.name}" name="name"/>
				<jsp:param value="${param.id}" name="legNumber"/>
				<jsp:param value="${param.sourcePage}" name="sourcePage"/>
			</jsp:include>
			<div class="row comment-container">
				<div class="span5">
					<div class="form-row autosize-container">
						<label>Comments</label>
						<div class="char-count">500</div>
						<textarea class="xlarge autosize messageinput" name="textarea2"
							rows="1" onblur="scriptInjection(this);"></textarea>
					</div>
				</div>
				<!-- end of block -->
			</div>
		</div>
		<!-- Comments log End -->
		
		
		<!-- starts uploads-->
					<jsp:include page="/jsp/common/attachments/cpaLegPageAttachments.jsp">
						<jsp:param name="mode" value="edit" />
					</jsp:include> 
					<!-- end uploads -->

		<!-- Audit log Start -->
		<jsp:include page="../../common/inc/auditLog.jsp">
			<jsp:param name="formName" value="cpaLegRequestForm" />
			<jsp:param value="${param.path}" name="path"/>
			<jsp:param value="${param.origin}" name="origin"/>
			<jsp:param value="${param.source}" name="source"/>
			<jsp:param value="${param.name}" name="name"/>
			<jsp:param value="${param.id}" name="legNumber"/>
			<jsp:param value="${param.sourcePage}" name="sourcePage"/>
		</jsp:include>
		<!-- Audit log End -->
		<div class="span12 right btn-container" style="margin-left: -20px;">
			<input type="button" value="Save and return to Request"
				class="btn right btn-success"
				onclick="javascript:validateLegCashPool('?command=saveAndReturnToDeal&productType=CPA',${param.transactionEventTypeId},${param.actionId});">
				 <input	type="button" value="Save" class="btn right"
				onclick="javascript:saveAsDraftD2CPA(this);">
			<a onclick="history.back();" class="right cancel single" style="margin-top:10px">
			Cancel
			</a>				
		</div>
		</html:form>
	</c:when>
<c:otherwise>
	<!-- Original Transaction Details -->
		<%@ include
			file="../../common/inc/day2/day2CPAOriginalTranscationDetailsRO.jsp"%>
		<%-- <%@ include file="../../common/inc/day2/day2CPAParticipantRO.jsp"%> --%>
		<jsp:include page="../../common/inc/day2/day2CPARequestDetailInput.jsp">
			<jsp:param value="requestorRO" name="page" />
			<jsp:param name="transactionEventTypeId"
				value="${param.transactionEventTypeId}" />
		</jsp:include>
		
		<%-- <jsp:include page="../../common/inc/cashPoolDetails.jsp" /> --%>
</c:otherwise>
</c:choose>

</html>	
