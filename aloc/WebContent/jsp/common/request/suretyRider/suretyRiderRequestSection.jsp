<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<!DOCTYPE html>
<c:if test="${param.includeScripts != false}">
<html>
  <head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<%@include file="../../../common/includeSectionCommonScripts.jsp" %>
</head>
<body>
</c:if>

<s:url action="cancel.action" namespace="/int/requestor" var="cancelBtnlURL"/>
<c:choose>
	
 	<c:when test="${param.sectionId eq 'request.section.riderPrincipal'}">
		<div id="principalSection">
				<jsp:include page="/jsp/common/request/suretyRider/riderPrincipal.jsp" >
					<jsp:param name="pageSection" value="Current" />
				</jsp:include>
		</div>
	</c:when>	
	
	<c:when test="${param.sectionId eq 'request.section.riderObligee'}">
		<div id="obligeeSection">
				<jsp:include page="/jsp/common/request/suretyRider/riderObligee.jsp" >
					<jsp:param name="pageSection" value="Current" />
				</jsp:include>
		</div>
	</c:when>
		
	<c:when test="${param.sectionId eq 'request.section.riderExpirationDates'}">
		<div id="expirationDatesSection">
				<div class="span6" style="margin-left: 0px;">
				<jsp:include page="/jsp/common/request/suretyRider/riderExpiratinDate.jsp" >
					<jsp:param name="pageSection" value="Current" />
				</jsp:include>
				</div>
				<div class="span5 left">
					<jsp:include page="/jsp/common/request/suretyRider/riderExpiratinDate.jsp" >
						<jsp:param name="pageSection" value="Previous" />
					</jsp:include>
				</div>
		</div>
	</c:when>
	
	<c:when test="${param.sectionId eq 'request.section.riderBondInformation'}">
		<div id="bondInformationSection">
				<jsp:include page="/jsp/common/request/suretyRider/riderBondInformation.jsp" />
				<input type="hidden" name= "sectionId" value="${param.sectionId}" />
		</div>
	</c:when>
	
	<c:when test="${param.sectionId eq 'request.section.attachments'}">
		<div id="attachmentsSection">
				<jsp:include page="/jsp/common/request/attachments.jsp" />
				<input type="hidden" name= "sectionId" value="${param.sectionId}" />
		</div>		
	</c:when>
	<c:when test="${param.sectionId eq 'request.section.riderDeliveryInstructions'}">
		<div id="deliveryInstructionsSection">
				<jsp:include page="/jsp/common/request/suretyRider/riderDeliveryInstructions.jsp">	
					<jsp:param name="pageSection" value="Current" />
				</jsp:include>
		</div>
	</c:when> 
</c:choose>
<c:if test="${param.includeScripts != false}">
	</body>
	</html>
</c:if>