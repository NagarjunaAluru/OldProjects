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
	<%@include file="/jsp/ext/common/includeCommonScripts.jsp" %>
	<script src="${pageContext.request.contextPath}/ext/public/js/requestor/requestor.js" type="text/javascript"></script>
</head>
<body>
</c:if>

<s:hidden name="currentSectionId" id="currentSectionId"/>
<c:choose>
	
	
	<c:when test="${param.sectionId eq 'request.section.riderPrincipal'}">
		<div id="principalSection">
			<div class="row">
				<div class="span6">
				<jsp:include page="/jsp/common/request/suretyRider/riderPrincipal.jsp" >
					<jsp:param name="pageSection" value="Current" />
				</jsp:include>
				</div>
				<c:if test="${requestDetails.rider.principal.changeFlag eq 'Y'}">
				<div class="span5 left">
						<p class="previous_del"><s:text name="label.request.previous" /></p>
						<jsp:include page="/jsp/common/request/suretyRider/riderPrincipal.jsp" >
							<jsp:param name="pageSection" value="Previous" />
						</jsp:include>
				</div>
				</c:if>
			</div>
			
		</div>
	</c:when>
	
	<c:when test="${param.sectionId eq 'request.section.riderObligee'}">
		<div id="obligeeSection">
		<div class="row">
			<div class="span6">
				<jsp:include page="/jsp/common/request/suretyRider/riderObligee.jsp" >
					<jsp:param name="pageSection" value="Current" />
				</jsp:include>
			</div>
			<c:if test="${requestDetails.rider.obligee.addressDtls.changeFlag eq 'Y'}">
			<div class="span5 left">
						<p class="previous_del"><s:text name="label.request.previous" /></p>
						<jsp:include page="/jsp/common/request/suretyRider/riderObligee.jsp" >
							<jsp:param name="pageSection" value="Previous" />
						</jsp:include>
			</div>	
			</c:if>
		</div>
		</div>
	</c:when>
	
 	<c:when test="${param.sectionId eq 'request.section.riderExpirationDates'}">
		<div id="expirationDatesSection">
			<div class="row">
				<div class="span6">
				<jsp:include page="/jsp/common/request/suretyRider/riderExpiratinDate.jsp" >
					<jsp:param name="pageSection" value="Current" />
				</jsp:include>
				</div>
				<div class="span5 left">
					<c:if test="${requestDetails.rider.expiryDate.changeFlag eq 'Y'}">
					<p class="previous_del"><s:text name="label.request.previous" /></p>
					</c:if>
					<jsp:include page="/jsp/common/request/suretyRider/riderExpiratinDate.jsp" >
							<jsp:param name="pageSection" value="Previous" />
						</jsp:include>
					</div>
			</div>	
		</div>
	</c:when>	
	<c:when test="${param.sectionId eq 'request.section.riderBondInformation'}">
		<div id="bondInformationSection">
			<div class="row">
				<div class="span6">
				<jsp:include page="/jsp/common/request/suretyRider/riderBondInformation.jsp" />
				<input type="hidden" name= "sectionId" value="${param.sectionId}" />
				</div>
			</div>							
		</div>
	</c:when>
	
	
	<c:when test="${param.sectionId eq 'request.section.attachments'}">
		<div id="attachmentsSection">
			
				<jsp:include page="/jsp/ext/request/common/attachments.jsp" />
				<input type="hidden" name= "sectionId" value="${param.sectionId}" />
				
		</div>		
	</c:when>
	
	<c:when test="${param.sectionId eq 'request.section.riderDeliveryInstructions'}">
		<div id="deliveryInstructionsSection">
			<div class="row">
				<div class="span6">	
				<jsp:include page="/jsp/common/request/suretyRider/riderDeliveryInstructions.jsp">	
					<jsp:param name="pageSection" value="Current" />
				</jsp:include>
				</div>
				<c:if test="${requestDetails.rider.deliveryInstructions.changeFlag eq 'Y'}">
				<div class="span5 left">
						<p class="previous_del"><s:text name="label.request.previous" /></p>
						<jsp:include page="/jsp/common/request/suretyRider/riderDeliveryInstructions.jsp">	
							<jsp:param name="pageSection" value="Previous" />
						</jsp:include>
					</div>
				</c:if>
		</div>
		</div>
	</c:when>
	
</c:choose>
<c:if test="${param.includeScripts != false}">
	</body>
	</html>
</c:if>