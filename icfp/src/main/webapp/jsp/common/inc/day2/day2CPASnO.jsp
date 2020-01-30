<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>
<t:common />
<c:set var="legSummaryVO" value="${deal:fetchLegSummary(param.id, pageContext.request)}" scope="page" />
<!-- Original Transaction Details  -->

	     <%@ include file="day2CPAOriginalTranscationDetailsRO.jsp"%>
	
     
<!-- Participant And PoolLeader  -->
<jsp:include page="day2CPAParticipantPoolLeaderRO.jsp">
	<jsp:param value="${param.page}" name="page"/>
</jsp:include>

<!-- Cash Pool Termination Details  -->
<c:if test="${param.transactionEventTypeId eq 1}">
<%@ include file="day2CashPoolTerminationDetailsRO.jsp"%>
</c:if>

<c:if test="${param.transactionEventTypeId ne 10}">
<!-- Other Considerations  -->
<jsp:include page="day2CPAOtherConsiderationsRO.jsp">
			<jsp:param name="legNumber" value="${param.legNumber}" />
</jsp:include>
<!-- Settlement/Other Details Start -->
<jsp:include page="day2CPASettlementsOROtherDetailsRO.jsp">
	<jsp:param name="actionId" value="${param.actionId}" />
	<jsp:param name="transactionEventTypeId" value="${param.transactionEventTypeId}" />
</jsp:include>
</c:if>


	<c:choose>
		<c:when test="${param.actionId eq param.activeId}"> <!-- Edit Mode -->
			<!-- Qualitative Assessment  -->
			<jsp:include page="/jsp/common/inc/qualitativeAssessment_LegSummary.jsp">
				<jsp:param name="factors" value="${param.factors}" />
				<jsp:param value="${param.legType}" name="legType" />
			</jsp:include>
		</c:when>
		<c:otherwise>
			<%-- <jsp:include page="/jsp/common/inc/legQualitativeAssessment.jsp"> 
				<jsp:param name="factor" value="${param.factors}" />
			</jsp:include> --%>
			<c:if test="${param.page eq 'cashManagement'}">
				<jsp:include page="/jsp/common/inc/legQualitativeAssessment.jsp">
					<jsp:param name="factor" value="Operational Risk - Initial" />
				</jsp:include>
			</c:if>
			<c:if test="${param.page eq 'treasuryLegal'}">
				<jsp:include page="/jsp/common/inc/legQualitativeAssessment.jsp">
					<jsp:param name="factor" value="Legal Risk" />
				</jsp:include>
			</c:if>
			<c:if test="${param.page eq 'treasuryTax'}">
				<jsp:include page="/jsp/common/inc/legQualitativeAssessment.jsp">
					<jsp:param name="factor" value="Tax Risk" />
				</jsp:include>
			</c:if>
			<c:if test="${param.page eq 'middleOffice'}">
				<jsp:include page="/jsp/common/inc/legQualitativeAssessment.jsp">
					<jsp:param name="factor" value="Operational Risk - Ongoing" />
				</jsp:include>
			</c:if>
			<c:if test="${param.page eq 'countryTax'}">
				<jsp:include page="/jsp/common/inc/legQualitativeAssessment.jsp">
					<jsp:param name="factor" value="Regulatory/Jurisdictional Reviews Risk" />
				</jsp:include>
			</c:if>

		</c:otherwise>
	</c:choose>

<!-- Transaction Capture MO Start -->
<c:if test="${param.wfStageId eq 25}"> 

<div class="form-mod">
			<h2 class="span12">${legSummaryVO.legSeqId}</h2>
			<div class="row">
				<div class="span5">
					<div class="form-row">
					<span class="required">*</span>
					<label><bean:message key="label.leg1.transactionCapturedIn" /></label>
		            <html:select styleId="selectedTransactionCapturedIn" property="selectedTransactionCapturedIn" styleClass="check" value="${legSummaryVO.transactionCapturedInId}">
					<html:option value="">Select...</html:option>
  						<html:optionsCollection name="com.ge.icfp.StaticData" property="transactionCapturedIn" value="ID" label="name"/>						   
					</html:select>
					<span id="transactionCapturedInBar" class="req-error" style="display:none;">error</span>
					</div>
				</div> <!-- end of block -->
			</div>
								
				<div class="row">
				<div class="span5">
					<div class="form-row">
						<span class="required">*</span>
						<label><bean:message key="label.leg1.inhouseloanmodelid" />
					    </label>
						<html:text property="transactionId" maxlength="50" tabindex="1" styleClass="span3" styleId="inhouseloanmodelId" value="${legSummaryVO.subLedgerTransactionId}" style="text-transform:uppercase"/>
						 <span id="inhouseloanmodelIdBar" class="req-error" style="display:none;">error</span>
					</div>
				</div>
			</div>
		</div>
<script type="text/javascript" src="${context}/js/day2/day2CPASANDO.js">
	
</script>		
		
</c:if>
 <!-- Transaction Capture MO End -->

<c:if test="${param.transactionEventTypeId eq 10}">
<%@ include file="day2CPACorrectionsRO.jsp"%>
</c:if>
<!-- Comments log  -->
<c:choose>
		<c:when test="${param.wfStageId eq 25}">
		     <div class="form-mod">
				<jsp:include page="/jsp/common/inc/commentsLog.jsp">
					<jsp:param name="formName" value="fourBlockerForm"/>
					<jsp:param value="transactionCapture/transactionCaptureMOFourBlocker" name="path"/>
				    <jsp:param value="Leg ${legSummaryVO.legSeqId}: Summary" name="name"/>
				    <jsp:param value="legDetails" name="method"/>
				    <jsp:param value="Transaction Capture & Closure" name="origin"/>
				    <jsp:param value="${legSummaryVO.legNumber}" name="legNumber"/>			
				</jsp:include>
				<div class="row comment-container">
					<div class="span5">
						<div class="form-row autosize-container">
							<label>Comments</label>
							<div class="char-count">500</div>
							<textarea class="xlarge autosize messageinput" name="lComments"	rows="4" onblur="scriptInjection(this);">${legSummaryVO.comments}</textarea>
						</div>
					</div>
				</div>
			</div>
			
						
				<!-- starts uploads-->
				<jsp:include page="/jsp/common/attachments/cpaLegPageAttachments.jsp">
					<jsp:param name="mode" value="edit" />
				</jsp:include> 
				<!-- end uploads -->
				<jsp:include page="/jsp/common/inc/auditLog.jsp">
					<jsp:param name="formName" value="fourBlockerForm"/>
					<jsp:param value="transactionCapture/transactionCaptureMOFourBlocker" name="path"/>
				    <jsp:param value="Leg ${legSummaryVO.legSeqId}: Summary" name="name"/>
				    <jsp:param value="legDetails" name="method"/>
				    <jsp:param value="Transaction Capture & Closure" name="origin"/>
				    <jsp:param value="${legSummaryVO.legNumber}" name="legNumber"/>			
				</jsp:include>
		</c:when>
		<c:otherwise>
			<div class="form-mod">
					<jsp:include page="/jsp/common/inc/commentsLog.jsp">
						<jsp:param name="formName" value="fourBlockerForm" />
						<jsp:param value="${param.path}" name="path" />
						<jsp:param value="Leg ${legSummaryVO.legSeqId}: Summary" name="name" />
						<jsp:param value="${param.method}" name="method" />
						<jsp:param value="${param.origin}" name="origin" />
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
			<!-- Attachments  -->
				<c:choose>
					<c:when test="${param.actionId eq param.activeId}">
								
					<!-- starts uploads-->
					<jsp:include page="/jsp/common/attachments/cpaLegPageAttachments.jsp">
						<jsp:param name="mode" value="edit" />
					</jsp:include> 
					<!-- end uploads -->
						</c:when>
						<c:otherwise>
								
						<!-- starts uploads-->
						<jsp:include page="/jsp/common/attachments/cpaLegPageAttachments.jsp">
						<jsp:param name="mode" value="edit" />
						</jsp:include> 
						<!-- end uploads -->
			
					</c:otherwise>
				</c:choose>
			
			<!-- Audit log  -->
				<jsp:include page="/jsp/common/inc/auditLog.jsp">
					<jsp:param name="formName" value="fourBlockerForm" />
					<jsp:param value="${param.path}" name="path" />
					<jsp:param value="Leg ${legSummaryVO.legSeqId}: Summary" name="name" />
					<jsp:param value="${param.method}" name="method" />
					<jsp:param value="${param.origin}" name="origin" />
				</jsp:include>
	
	</c:otherwise>
</c:choose>