<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
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
<%	String servletContextUrl = request.getContextPath();%>

<script> var servletContextUrl = '<%=servletContextUrl%>';</script>
<script src="<%=servletContextUrl%>/js/bootstrap-typeahead.js" type="text/javascript"></script>

<script type="text/javascript" src="${context}/js/day2/cpaTransferPricing.js">
</script> 


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

<form action="${context}${action}"  method="post" enctype="multipart/form-data">

	 <c:set var="legNumber" value="1" /> 
	<%-- <c:set var="legNumber" value="${sessionScope.cpaLegRequestForm.map['legNumber']}" />  --%>
	<c:set var="nonStandardDocsFlag" value="${deal:getNonStandardDocsFlag(pageContext.request)}" />
	<c:set var="legSummaryVO" value="${deal:fetchLegSummary(param.id, pageContext.request)}" scope="page" />
	<input type="hidden" name="legNumber" value="${param.id}">
	
<!-- Leg Reference Id Details  -->
<jsp:include page="../../common/inc/day2/day2CPARequestDetails.jsp">
	<jsp:param value="${legNumber}" name="legNumber" />
</jsp:include>


<!-- Original Transaction Details  -->
	     <%@ include file="../../common/inc/day2/day2CPAOriginalTranscationDetailsRO.jsp"%>
	
     
<!-- Participant And PoolLeader  -->
<jsp:include page="../../common/inc/day2/day2ParticipantPoolLeaderRO.jsp" />

	
<!-- Cash Pool Details  -->
<jsp:include page="/jsp/common/inc/cashPoolDetails.jsp" />



<!-- Cash Pool Termination Details  -->
<c:if test="${param.transactionEventTypeId eq 1}">
<%@ include file="../../common/inc/day2/day2CashPoolTerminationDetailsRO.jsp"%>
</c:if>

<c:if test="${param.transactionEventTypeId ne 10}">
<!-- Other Considerations  -->
<jsp:include page="../../common/inc/day2/day2CPAOtherConsiderationsRO.jsp">
			<jsp:param name="legNumber" value="${legNumber}" />
</jsp:include>
<!-- Settlement/Other Details Start -->
<jsp:include page="../../common/inc/day2/day2CPASettlementsOROtherDetailsRO.jsp">
	<jsp:param name="actionId" value="${param.actionId}" />
	<jsp:param name="transactionEventTypeId" value="${param.transactionEventTypeId}" />
</jsp:include>
</c:if>

	<c:choose>
		<c:when test="${param.actionId eq param.activeId}"> <!-- Edit Mode -->
			<!-- Qualitative Assessment  -->
			<jsp:include page="/jsp/common/inc/qualitativeAssessment_LegSummary.jsp">
				<jsp:param name="factors" value="${factors}" />
				<jsp:param value="CPA" name="legType" />
			</jsp:include>
		</c:when>
		<c:otherwise>
			<jsp:include page="/jsp/common/inc/legQualitativeAssessment.jsp"> 
				<jsp:param name="factor" value="${factors}" />
			</jsp:include>

		</c:otherwise>
	</c:choose>

	<%-- <jsp:include page="../../common/inc/cpaQualitativeAssessment.jsp">
	<jsp:param name="factors" value="Tax Risk" />
</jsp:include> --%>

<!-- Transaction Capture MO Start Need to get the wfStageId for this and then uncomment-->
<%-- <c:if test="${param.wfStageId eq wfStageId}">
<div class="form-mod">
			<h2 class="span12">${sessionScope.deal.uniqueId} - ${legSummaryVO.legNumber}</h2>
			<div class="row">
				<div class="span5">
					<div class="form-row">
					<span class="required">*</span>
					<label><bean:message key="label.leg1.transactionCapturedIn" /></label>
		            <html:select styleId="selectedTransactionCapturedIn" property="selectedTransactionCapturedIn" styleClass="check" value="${legSummaryVO.selectedTransactionCapturedIn}">
					<html:option value="">Select...</html:option>
  						<html:optionsCollection name="com.ge.icfp.StaticData" property="transactionCapturedIn" value="ID" label="name"/>						   
					</html:select>
					</div>
				</div> <!-- end of block -->
			</div>
								
			<div class="row">
				<div class="span5">
					<div class="form-row">
						<span class="required">*</span>
						<label><bean:message key="label.leg1.inhouseloanmodelid" />
					    </label>
						<html:text property="transactionId" maxlength="20" tabindex="1" styleClass="span3" styleId="transactionId" value="${legSummaryVO.transactionId}" style="text-transform:uppercase"/>
					</div>
				</div>
			</div>
		</div>
</c:if>
 --%><!-- Transaction Capture MO Start -->

<c:if test="${param.transactionEventTypeId eq 10}">
<%@ include file="../../common/inc/day2/day2CPACorrectionsRO.jsp"%>
</c:if>

<!-- starts uploads-->
<jsp:include page="/jsp/common/attachments/dealPageAttachments.jsp">
	<jsp:param name="mode" value="edit" />
</jsp:include> 
<!-- end uploads -->


<!-- Comments log  -->
<div class="form-mod">
		<jsp:include page="/jsp/common/inc/commentsLog.jsp">
			<jsp:param name="formName" value="fourBlockerForm" />
			<jsp:param value="${path}" name="path" />
			<jsp:param value="Leg ${legSummaryVO.legSeqId}: Summary" name="name" />
			<jsp:param value="legDetails" name="method" />
			<jsp:param value="${origin}" name="origin" />
		</jsp:include>
<c:if test="${param.actionId eq param.activeId}">
		<div class="row comment-container">
					<div class="span5">
						<div class="form-row autosize-container">
							<label>Comments</label>
							<div class="char-count">500</div>
							<textarea class="xlarge autosize messageinput" name="lComments"	rows="4" onblur="scriptInjection(this);">${legSummaryVO.comments}</textarea>
						</div>
					</div>
				</div>
</c:if>
</div>


<!-- Audit log  -->
	<jsp:include page="/jsp/common/inc/auditLog.jsp">
		<jsp:param name="formName" value="fourBlockerForm" />
		<jsp:param value="${path}" name="path" />
		<jsp:param value="Leg ${legSummaryVO.legSeqId}: Summary" name="name" />
		<jsp:param value="legDetails" name="method" />
		<jsp:param value="${origin}" name="origin" />
	</jsp:include>


	<input type="hidden" name="pType" value="${legSummaryVO.product}">
	<c:if test="${param.actionId eq 4 || param.actionId eq 5 || param.actionId eq 6 || param.actionId eq 7  || param.actionId eq 8}">
		<c:if test="${param.actionId eq param.activeId}">
			<div class="span12 right btn-container" style="margin-left: -20px;">
				<security:hasRoles appName="icfp" domainName="ICFP_AUTH_ACTIONS"
					domainType="component" compName="MemberDelegateActions">
					<input type="button" value="Save and return to Request"
						class="btn right btn-success"
						onclick="javascript:saveAndReturnToDeal(this, '${action}');"><!-- ,${param.transactionEventTypeId} -->
					<input type="button" value="Save" class="btn right"
						onclick="javascript:saveAsDraft(this, '${action}');">
				</security:hasRoles>

				<security:hasRoles appName="icfp" domainName="ICFP_AUTH_ACTIONS"
					domainType="component" compName="AssignReviewer">
					<a href="#confirm" class="btn-link right cancel modal-confirm"
						data-toggle="modal" style="margin-top: 95px">Cancel</a>
				</security:hasRoles>
			</div>
		</c:if>
	</c:if>

	<input type="hidden" name="pType" value="${legSummaryVO.productType}">

	<div class="modal hide fade" id="confirm">
		<div class="modal-header">
			<a class="close" href="javascript:closeConfirmModal()">X</a>
			<h3>Cancel Leg</h3>
		</div>
		<div class="modal-body">
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