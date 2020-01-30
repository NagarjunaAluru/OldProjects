<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>
<t:common />

<!-- Participant & Pool Leader  -->
<%@ include file="day2CPAParticipantPoolLeaderRO.jsp"%>


<c:if test="${param.transactionEventTypeId eq 1}">
<%@ include file="day2CashPoolTerminationDetailsRO.jsp"%>
</c:if>

<c:if test="${param.transactionEventTypeId ne 10}">  
		<jsp:include page="day2CPAOtherConsiderationsRO.jsp">
			<jsp:param name="legNumber" value="${legNumber}" />
		</jsp:include>
		<jsp:include page="day2CPASettlementsOROtherDetailsRO.jsp">
			<jsp:param name="transactionEventTypeId" value="${param.transactionEventTypeId}" />
		</jsp:include>
</c:if>


<c:if test="${param.transactionEventTypeId eq 10}">
<%@ include file="day2CPACorrectionsRO.jsp"%>
</c:if>

<%-- <%@ include file="../legexceptionDetails.jsp"%> --%>
		       
		<jsp:include page="../../../common/inc/legQualitativeAssessment.jsp"> 
			<jsp:param name="factor" value="Regulatory Risk,Finance Risk,Legal Governance Risk,Reputational Risk,Sovereign Risk" />
		</jsp:include>
		<jsp:include page="/jsp/common/inc/commentsLog.jsp">
			<jsp:param name="formName" value="fourBlockerForm" />
			<jsp:param value="${param.path}" name="path" />
			<jsp:param value="Leg ${legSummaryVO.legSeqId}: Summary" name="name" />
			<jsp:param value="${param.method}" name="method" />
			<jsp:param value="${param.origin}" name="origin" />
		</jsp:include>
		
			
		<!-- starts uploads-->
		<jsp:include page="/jsp/common/attachments/cpaLegPageAttachments.jsp">
			<jsp:param name="mode" value="edit" />
		</jsp:include> 
		<!-- end uploads -->
		
		<jsp:include page="/jsp/common/inc/auditLog.jsp">
			<jsp:param name="formName" value="fourBlockerForm" />
			<jsp:param value="${param.path}" name="path" />
			<jsp:param value="Leg ${legSummaryVO.legSeqId}: Summary" name="name" />
			<jsp:param value="${param.method}" name="method" />
			<jsp:param value="${param.origin}" name="origin" />
		</jsp:include>

