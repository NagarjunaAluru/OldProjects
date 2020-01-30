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
	<%@include file="../../common/includeCommonScripts.jsp" %>
	<script src="${pageContext.request.contextPath}/js/requestor/requestor.js" type="text/javascript"></script>
</head>
<body>
</c:if>

<c:choose>
	<c:when test="${param.sectionId eq 'request.section.bondDetails'}">
		
		<div id="bondDetailsSection">
		
				<jsp:include page="/jsp/common/request/bondDetails.jsp" >
					<jsp:param value="${param.isTaxonomy}" name="isTaxonomy"/>
				</jsp:include>
				<input type="hidden" name="sectionId" value="${param.sectionId}" />
		
		</div>
	</c:when>
	
	<c:when test="${param.sectionId eq 'request.section.principal'}">
	
		<div id="principalSection">
	
				<jsp:include page="/jsp/common/request/principalDetails.jsp" >
					<jsp:param value="${param.isTaxonomy}" name="isTaxonomy"/>
				</jsp:include>
				<input type="hidden" name="sectionId" value="${param.sectionId}" />
				
		</div>
	</c:when>
	
	<c:when test="${param.sectionId eq 'request.section.obligee'}">
		<div id="obligeeSection">
	
				<jsp:include page="/jsp/common/request/obligeeDetails.jsp" >
					<jsp:param value="${param.isTaxonomy}" name="isTaxonomy"/>
				</jsp:include>
				<input type="hidden" name="sectionId" value="${param.sectionId}" />
				
		</div>
	</c:when>
	
 	<c:when test="${param.sectionId eq 'request.section.bondRequestor'}">
		<div id="bondRequestorSection">
			
				<jsp:include page="/jsp/common/request/bondRequestor.jsp" >
					<jsp:param value="${param.isTaxonomy}" name="isTaxonomy"/>
				</jsp:include>
				<input type="hidden" name= "sectionId" value="${param.sectionId}" />
			
		</div>
	</c:when>	
	
	<c:when test="${param.sectionId eq 'request.section.requestorMailingAddress'}">
		<div id="requestorMailingAddressSection">
		
				<jsp:include page="/jsp/common/request/mailingAddress.jsp" >
					<jsp:param value="${param.isTaxonomy}" name="isTaxonomy"/>
				</jsp:include>
				<input type="hidden" name= "sectionId" value="${param.sectionId}" />
			
		</div>
	</c:when>
		
	<c:when test="${param.sectionId eq 'request.section.deliveryInstructions'}">
		<div id="deliveryInstructionsSection">
		
				<jsp:include page="/jsp/common/request/sbDeliveryInstructions.jsp" >
					<jsp:param value="${param.isTaxonomy}" name="isTaxonomy"/>
				</jsp:include>
				<input type="hidden" name= "sectionId" value="${param.sectionId}" />
							
		</div>
	</c:when>
	
	<c:when test="${param.sectionId eq 'request.section.bondInformation'}">
		<div id="bondInformationSection">
			
				<jsp:include page="../../common/request/bondInformation.jsp">
					<jsp:param name="bondTypeId" value="${requestDetails.bondDetails.bondTypeId}"/>
					<jsp:param value="${param.isTaxonomy}" name="isTaxonomy"/>
				</jsp:include>	
				<input type="hidden" name= "sectionId" value="${param.sectionId}" />
							
		</div>
	</c:when>
	
	<c:when test="${param.sectionId eq 'request.section.format'}">
		<div id="formatSection">
			
				<jsp:include page="/jsp/common/request/format.jsp" >
					<jsp:param value="${param.isTaxonomyView}" name="isTaxonomyView"/>
				</jsp:include>
				<input type="hidden" name= "sectionId" value="${param.sectionId}" />
				
		</div>		
	</c:when>

	<c:when test="${param.sectionId eq 'request.section.attachments'}">
		<div id="attachmentsSection">
			
				<jsp:include page="/jsp/common/request/attachments.jsp" />
				<input type="hidden" name= "sectionId" value="${param.sectionId}" />
				
		</div>		
	</c:when>
	
		<c:when test="${param.sectionId eq 'request.section.businessDelegation'}">
		<div id="businessDelegationSection">
			
				<jsp:include page="/jsp/common/request/buapproveDelegation.jsp" />
				<input type="hidden" name= "sectionId" value="${param.sectionId}" />
			
		
		</div>
	</c:when> 
	<c:when	test="${param.sectionId eq 'request.section.treasuryDelegation'}">
			<div id="treasuryDelegation">
	
				<jsp:include page="/jsp/common/request/treasuryDelegation.jsp" />
				<input type="hidden" name="sectionId" value="${param.sectionId}" />
	
			</div>
		</c:when>
</c:choose>
<c:if test="${param.includeScripts != false}">
	</body>
	</html>
</c:if>