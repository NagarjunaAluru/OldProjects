<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>
<t:common />


<%@ include file="CPAParticipantPoolLeaderRO.jsp"%>


<c:if test="${param.transactionEventTypeId eq 1}">
</c:if>

<c:if test="${param.transactionEventTypeId ne 10}">  
		<jsp:include page="CPAOtherConsiderationsRO.jsp">
			<jsp:param name="legNumber" value="${legNumber}" />
		</jsp:include>
</c:if>


			<!-- starts uploads-->
	<jsp:include page="/jsp/common/attachments/cpaLegPageAttachments.jsp">
	<jsp:param name="mode" value="edit" />
	</jsp:include> 
	<!-- end uploads -->
	
