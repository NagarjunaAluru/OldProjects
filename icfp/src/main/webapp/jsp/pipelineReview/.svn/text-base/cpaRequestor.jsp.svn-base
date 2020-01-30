<%@page import="org.apache.struts.action.DynaActionForm"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>

<c:set var="legNumber" value="${requestScope.legNumber}" />
<c:if test="${param.actionId eq 1}">
<html:form action="/CPALegRequest.do" styleId="cpaLegRequestForm" method="post" enctype="multipart/form-data">

	
	<input type="hidden" name="legNumber" id="legNumber" value="<bean:write name="cpaLegRequestForm" property="legNumber" />" />
	<html:hidden name="cpaLegRequestForm" property="cpaSummary.legTypeId" value="3" />

<!-- Edit  Mode Start -->	
	<c:if test="${param.actionId eq 1}">

		
		
		
		<c:choose>
			<c:when test="${param.transactionEventTypeId eq 10}">
				<%-- <%@ include file="../../common/inc/day2/day2CPACorrections.jsp"%> --%>
			</c:when>
			<c:when test="${(param.transactionEventTypeId eq 1 || param.transactionEventTypeId eq 2 )}">
				
				<c:if test="${param.transactionEventTypeId eq 1}">
					<!-- Cash Pool Termination -->
					<%-- <%@ include file="CashPoolTerminationDetails.jsp"%> --%>
				</c:if>

				<!-- Other Considerations -->
				<%-- <%@ include file="CPAOtherConsiderations.jsp"%> --%>
				<!-- Exceptions -->
			<%-- 	<%@ include file="CPAExceptions.jsp"%> --%>
				<!-- Settlement/Other Details-->
				<%-- <jsp:include page="../../common/inc/day2/day2CPASettlementsOROtherDetails.jsp">
					<jsp:param name="actionId" value="${param.actionId}" />
					<jsp:param name="transactionEventTypeId" value="${param.transactionEventTypeId}" />
				</jsp:include> --%>
			</c:when>
		</c:choose>

				<!-- starts uploads-->
		<jsp:include page="/jsp/common/attachments/cpaDealPageAttachments.jsp">
			<jsp:param name="mode" value="edit" />
		</jsp:include> 
		<!-- end uploads -->
		<div class="span12 right btn-container" style="margin-left: -20px;">
			<input type="button" value="Save and return to Request"
				class="btn right btn-success" onclick="javascript:validateLegCashPool('?command=saveAndReturnToDeal&productType=CPA',${param.transactionEventTypeId});">
			<input type="button" value="Save" class="btn right" onclick="javascript:saveAsDraft('?command=saveAsDraft');">
			<a href="#" class="btn-link right cancel">Cancel</a>
		</div>
	</c:if>
<!-- Edit  Mode End -->
</html:form>
</c:if>

<!-- Read Only Mode Start -->
	<c:if test="${param.actionId ne 1}">
		<%@ include file="CPAOriginalTranscationDetailsRO.jsp"%>
		<jsp:include page="CPARequestDetailInput.jsp">
			<jsp:param name="transactionEventTypeId" value="${param.transactionEventTypeId}" />
		</jsp:include>
		
	</c:if>
<!-- Read Only Mode End -->


