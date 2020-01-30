<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en-US"/>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<%@ taglib prefix="security"  uri="hwf-securitytag" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:common/>
<!DOCTYPE html>
<html lang="en">
  <head>
  	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title><bean:message key="label.transactionCapture.title"/></title>
    <meta name="description" content="">
    <meta name="author" content="">

<%	String servletContextUrl = request.getContextPath();%>
<script> var servletContextUrl = '<%=servletContextUrl%>';</script>
<script src="<%=servletContextUrl%>/js/bootstrap-typeahead.js" type="text/javascript"></script>
<script src="<%=servletContextUrl%>/js/day2/cpaCashManagement.js" type="text/javascript"></script>
</head>

<!-- Settings for S&O  -->
<c:if test="${param.actionId eq 4}"> <!-- Cash Management - 4 -->
	<c:set var="action" value="/cashManagement/cashManagementLeg.do" />
	<c:set var="factors" value="Operational Risk - Initial" />
	<c:set var="origin" value="Cash Management" />
	<c:set var="path" value="cashManagement/cashManagement" />
</c:if>
<c:if test="${param.actionId eq 5}"> <!-- Treasury Legal  - 5 -->
	<c:set var="action" value="/treasuryLegal/treasuryLegalLeg.do" />
	<c:set var="factors" value="Legal Risk" />
	<c:set var="origin" value="Treasury Legal" />
	<c:set var="path" value="treasuryLegal/treasuryLegal" />
</c:if>
<c:if test="${param.actionId eq 6}"> <!-- Treasury Tax - 6 -->
	<c:set var="action" value="/treasuryTax/treasuryTaxLeg.do" />
	<c:set var="factors" value="Tax Risk" />
	<c:set var="origin" value="Treasury Tax" />
	<c:set var="path" value="treasuryTax/treasuryTax" />
</c:if>
<c:if test="${param.actionId eq 7}"> <!-- Middle Office - 7 -->
	<c:set var="action" value="/middleOffice/middleOfficeInputLeg.do" />
	<c:set var="factors" value="Operational Risk - Ongoing" />
	<c:set var="origin" value="Middle Office" />
	<c:set var="path" value="middleOffice/middleOffice" />
</c:if>
<c:if test="${param.actionId eq 8}"> <!-- Country Tax - 8 -->
	<c:set var="action" value="/countryTax/countryTaxLeg.do" />
	<c:set var="factors" value="Regulatory/Jurisdictional Reviews Risk" />
	<c:set var="origin" value="Regulatory/Jurisdictional Reviews" />
	<c:set var="path" value="countryTax/countryTax" />
</c:if>


<%-- actionId              ------->> ${param.actionId }
transactionEventTypeId------->> ${param.transactionEventTypeId } --%>
<!-- Leg Reference Id Details  -->
<jsp:include page="../../common/inc/day2/day2CPARequestDetails.jsp">
	<jsp:param value="${legNumber}" name="legNumber" />
</jsp:include>
<c:choose>
	<c:when test="${param.actionId eq param.activeId}">
<%-- <form action="${context}${action}" id="legSummary" method="post" enctype="multipart/form-data">
</form> --%>
<form action="${context}${action}"  id="legSummary" method="post" enctype="multipart/form-data">

	
	 <c:set var="legNumber" value="1" /> 
	<%-- <c:set var="legNumber" value="${sessionScope.cpaLegRequestForm.map['legNumber']}" />  --%>
	<c:set var="nonStandardDocsFlag" value="${deal:getNonStandardDocsFlag(pageContext.request)}" />
	<c:set var="legSummaryVO" value="${deal:fetchLegSummary(param.id, pageContext.request)}" scope="page" />
	<input type="hidden" name="legNumber" value="${requestScope.legNumber}">
	<input type="hidden" name="legSeqId" value="${legSummaryVO.legSeqId}" />

	
	<jsp:include page="/jsp/common/inc/day2/day2CPASnO.jsp">
				<jsp:param name="actionId" value="${param.actionId}"/>
				<jsp:param name="transactionEventTypeId" value="${param.transactionEventTypeId}"/>
			    <jsp:param name="activeId" value="${param.activeId}"/>
			    <jsp:param name="legNumber" value="${legNumber}"/>
			    <jsp:param name="factors" value="${factors}"/>
				<jsp:param name="legType" value="CPA"/>
				<jsp:param name="factor" value="${factors}"/>
				<jsp:param name="formName" value="fourBlockerForm"/>
				<jsp:param name="path" value="${path}"/>
				<jsp:param name="method" value="legDetails"/>
				<jsp:param name="origin" value="${origin}"/>
   </jsp:include>

	<input type="hidden" name="pType" value="${legSummaryVO.product}">
	<c:if test="${param.actionId eq 4 || param.actionId eq 5 || param.actionId eq 6 || param.actionId eq 7  || param.actionId eq 8}">
		<c:if test="${param.actionId eq param.activeId}">
			<div class="span12 right btn-container" style="margin-left: -20px;">
				<c:if test="${sessionScope.section eq 'myTasks'}">
					<input type="button" value="Save and return to Request"
						class="btn right btn-success"
						onclick="javascript:saveAndReturnToDeal(this, '${action}');"><!-- ,${param.transactionEventTypeId} -->
					<input type="button" value="Save" class="btn right"
						onclick="javascript:saveAsDraft(this, '${action}');">
						<a href="#cancelpopup" class="btn-link right cancel modal-confirm" data-toggle="modal" style="margin-top: 10px;">Cancel</a>
				</c:if>

				<c:if test="${sessionScope.section eq 'myAssignedTasks'}">
					<a href="#cancelpopup" class="btn-link right cancel modal-confirm"
						data-toggle="modal" style="margin-top: 10px">Cancel</a>
				</c:if>
			</div>
		</c:if>
	</c:if>

	<input type="hidden" name="pType" value="${legSummaryVO.productType}">

	<div class="modal hide fade" id="cancelpopup">
		<div class="modal-header">
			<a class="close" href="javascript:closeConfirmModal()">X</a>
			<h3>Cancel Leg</h3>
		</div>
		<div class="modal-body" style="margin-top:-16px;">
			<div class="row">
				<p>
					<b>Are you sure you want to cancel?</b><br> Any changes you
					have made will be lost
				</p>
			</div>
		</div>
		<div class="modal-footer">
			<a href="${context}/${path}.do?command=load&DealRequestID=${sessionScope.deal.dealSeqId}" class="btn right btn-success">Yes, cancel the Leg</a>
			<a class="btn-link right cancel" href="javascript:closeConfirmModal()">No, take me back to the Leg</a>
		</div>
	</div>
</form>
		
	</c:when>
<c:otherwise>

<jsp:include page="/jsp/common/inc/day2/day2CPASnO.jsp">
				<jsp:param name="actionId" value="${param.actionId}"/>
				<jsp:param name="transactionEventTypeId" value="${param.transactionEventTypeId}"/>
			    <jsp:param name="activeId" value="${param.activeId}"/>
			    <jsp:param name="legNumber" value="${legNumber}"/>
			    <jsp:param name="factors" value="${factors}"/>
				<jsp:param name="legType" value="CPA"/>
				<jsp:param name="factor" value="${factors}"/>
				<jsp:param name="formName" value="fourBlockerForm"/>
				<jsp:param name="path" value="${path}"/>
				<jsp:param name="method" value="legDetails"/>
				<jsp:param name="origin" value="${origin}"/>

   </jsp:include>
</c:otherwise>
</c:choose>

</html>

