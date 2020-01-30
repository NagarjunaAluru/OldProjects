<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:if test="${param.includeScripts != false}">
<!DOCTYPE html>
<html>
<head>
 <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%@include file="/jsp/ext/common/includeCommonScripts.jsp" %>
<script
	src="${pageContext.request.contextPath}/ext/public/js/requestor/requestor.js"
	type="text/javascript"></script>
</head>
<body>
</c:if>

<c:choose>
	<c:when	test="${param.sectionId eq 'request.section.suretyBidDetails'}">

		<div id="bidMemoDetailsSection">
				<jsp:include page="/jsp/common/request/bidReplyResponseDetails.jsp" >
				<jsp:param name="suretyBidMemo" value="true"></jsp:param>
				<jsp:param name="page" value="bidReply"></jsp:param>
				</jsp:include>
				<input type="hidden" name="sectionId" value="${param.sectionId}" />
		</div>
	</c:when>
	
	<c:when	test="${param.sectionId eq 'request.section.suretyCommentsDetails'}">

		<div id="commentsDetailsSection">
				<jsp:include page="/jsp/common/request/suretyBondBidComments.jsp" />
				<input type="hidden" name="sectionId" value="${param.sectionId}" />
		</div>
	</c:when>
	
	<c:when	test="${param.sectionId eq 'request.section.suretyPrincipalDetails'}">
	    <div id="principalDetailsSection">
			<div class="row">
					<div class="span1a">
						<div class="form-row">
							<label><s:text name="label.request.nameAndAddress"/></label>
						</div>
					</div>
					<div class="span5 left">
						<div class="form-row">
							<p class="padding40">
								<s:property value="requestDetails.principal.addressDtls.name"/><br />
								<s:iterator value="requestDetails.principal.addressDtls.address">
								<s:property/><br />
								</s:iterator>
								<s:property value="requestDetails.principal.addressDtls.city"/>&nbsp;&nbsp;<s:property value="requestDetails.principal.addressDtls.stateProvince"/>&nbsp;&nbsp;&nbsp;<s:property value="requestDetails.principal.addressDtls.ZIPPostalCode"/>&nbsp;&nbsp;<br />
								<s:property value="requestDetails.principal.addressDtls.country"/>
							</p>
						</div>
					</div>
				</div>
			</div>
		</c:when>
		
		<c:when	test="${param.sectionId eq 'request.section.suretyObligeeDetails'}">
	    <div id="ObligeeDetailsSection">
			<div class="row">
					<div class="span1a">
						<div class="form-row">
							<label><s:text name="label.request.nameAndAddress"/></label>
						</div>
					</div>
					<div class="span5 left">
						<div class="form-row">
							<p class="padding40">
								<s:property value="requestDetails.obligee.addressDtls.name"/><br />
								<s:iterator value="requestDetails.obligee.addressDtls.address">
								<s:property/><br />
								</s:iterator>
								<s:property value="requestDetails.obligee.addressDtls.city"/>&nbsp;&nbsp;<s:property value="requestDetails.obligee.addressDtls.stateProvince"/>&nbsp;&nbsp;&nbsp;<s:property value="requestDetails.obligee.addressDtls.ZIPPostalCode"/>&nbsp;&nbsp;<br />
								<s:property value="requestDetails.obligee.addressDtls.country"/>
							</p>
						</div>
					</div>
				</div>
			</div>
		</c:when>
	
	<c:when test="${param.sectionId eq 'request.section.bidReplyDetails'}">
		<div id="sbBidReplyDetailsSection">
				<jsp:include page="/jsp/requestor/treasury/suretyBondBidReplyFeeInfo.jsp" />
				<input type="hidden" name="sectionId" value="${param.sectionId}" />
		</div>
	</c:when>
		
	<c:when test="${param.sectionId eq 'request.section.optingOutComments'}">
		<div id="optingOutCommentsSection">
				<jsp:include page="/jsp/common/request/optingOutComments.jsp" >
					<jsp:param name="suretBond" value="true" />
				</jsp:include>
				<input type="hidden" name="sectionId" value="${param.sectionId}" />
		</div>
	</c:when>
	
</c:choose>
<c:if test="${param.includeScripts != false}">
	</body>
	</html>
</c:if>