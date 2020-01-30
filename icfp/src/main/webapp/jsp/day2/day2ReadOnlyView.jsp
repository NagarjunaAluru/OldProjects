<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>
<c:set var="nonStandardDocsFlag" value="${deal:getNonStandardDocsFlag(pageContext.request)}" />

<c:if test="${param.page eq 'cashManagement'}">
	<jsp:include page="../common/inc/legQualitativeAssessment.jsp">
		<jsp:param name="factor" value="Operational Risk - Initial" />
	</jsp:include>
</c:if>
<c:if test="${param.page eq 'treasuryLegal'}">
	<jsp:include page="../common/inc/legQualitativeAssessment.jsp">
		<jsp:param name="factor" value="Legal Risk" />
	</jsp:include>
</c:if>
<c:if test="${param.page eq 'treasuryTax'}">
	<jsp:include page="../common/inc/legQualitativeAssessment.jsp">
		<jsp:param name="factor" value="Tax Risk" />
	</jsp:include>
</c:if>
<c:if test="${param.page eq 'middleOffice'}">
	<jsp:include page="../common/inc/legQualitativeAssessment.jsp">
		<jsp:param name="factor" value="Operational Risk - Ongoing" />
	</jsp:include>
</c:if>
<c:if test="${param.page eq 'frontOffice'}">
	<jsp:include page="../common/inc/legQualitativeAssessment.jsp">
		<jsp:param name="factor" value="Regulatory Risk,Finance Risk,Legal Governance Risk,Reputational Risk,Sovereign Risk" />
	</jsp:include>
</c:if>

<div class="form-mod">
	<jsp:include page="../common/inc/commentsLog.jsp">
		<jsp:param name="formName" value="fourBlockerForm" />
		<jsp:param value="${param.path}" name="path"/>
		<jsp:param value="${param.origin}" name="origin"/>
		<jsp:param value="${param.source}" name="source"/>
		<jsp:param value="${param.name}" name="name"/>
		<jsp:param value="${param.legNumber}" name="legNumber"/>
		<jsp:param value="${true}" name="isReadOnly"/>
	</jsp:include>
</div>

		  <jsp:include page="/jsp/common/attachments/legPageAttachments.jsp">
        	<jsp:param name="legIndex" value="${legNumber}" />
        	<jsp:param name="mode" value="edit" />
        </jsp:include>  
	
<jsp:include page="../common/inc/auditLog.jsp">
	<jsp:param name="formName" value="fourBlockerForm" />
	<jsp:param value="${param.path}" name="path"/>
	<jsp:param value="${param.origin}" name="origin"/>
	<jsp:param value="${param.source}" name="source"/>
	<jsp:param value="${param.name}" name="name"/>
	<jsp:param value="${param.legNumber}" name="legNumber"/>
	<jsp:param value="${true}" name="isReadOnly"/>
</jsp:include>
