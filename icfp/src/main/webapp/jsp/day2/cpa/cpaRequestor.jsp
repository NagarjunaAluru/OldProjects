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
<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta name="description" content="">
	<meta name="author" content="">

<% String servletContextUrl = request.getContextPath(); %>

<script> var servletContextUrl = '<%=servletContextUrl%>';</script>
 
<script>

var servletContextUrl = '<%=servletContextUrl%>';

</script>
<script src="<%=servletContextUrl%>/js/day2/cpaRequestor.js" type="text/javascript"></script>
</head>


<c:set var="legNumber" value="${requestScope.legNumber}" />

<c:choose>
	<c:when test="${param.actionId eq 1}">
		<script src="<%=servletContextUrl%>/js/cpaRequest.js" type="text/javascript"></script>
		<script src="<%=servletContextUrl%>/js/day2/day2CashPool.js" type="text/javascript"></script>
		<script src="<%=servletContextUrl%>/js/bootstrap-typeahead.js" type="text/javascript"></script>

		<html:form action="/CPALegRequest.do" styleId="cpaLegRequestForm" method="post" enctype="multipart/form-data">


			<input type="hidden" name="legNumber" id="legNumber" value="<bean:write name="cpaLegRequestForm" property="legNumber" />" />
			<html:hidden name="cpaLegRequestForm" property="cpaSummary.legTypeId" value="3" />

			<!-- Edit  Mode Start -->
			<c:if test="${param.actionId eq 1}">
				<!-- Original Transcation Details & Participant -->
				<jsp:include
					page="../../common/inc/day2/day2CPAOriginalTranscationDetails.jsp">
					<jsp:param name="day" value="day2" />
					<jsp:param name="tab" value="REQ" />
				</jsp:include>

				<!-- Pool Leader -->
				<%@ include file="../../common/inc/day2/day2CPAPoolLeader.jsp"%>



				<c:choose>
					<c:when test="${param.transactionEventTypeId eq 10}">
					  <input type="hidden" id="actionId" value="${param.actionId}"/>
						<%@ include file="../../common/inc/day2/day2CPACorrections.jsp"%>
					</c:when>
					<c:when
						test="${(param.transactionEventTypeId eq 1 || param.transactionEventTypeId eq 2 )}">
						<input type="hidden" id="actionId" value="${param.actionId}"/>
						<c:if test="${param.transactionEventTypeId eq 1}">
						  
							<!-- Cash Pool Termination -->
							<%@ include file="../../common/inc/day2/day2CashPoolTerminationDetails.jsp"%>
						</c:if>

						<!-- Other Considerations -->
						<%@ include
							file="../../common/inc/day2/day2CPAOtherConsiderations.jsp"%>
						<!-- Exceptions -->
						<%@ include file="../../common/inc/day2/day2CPAExceptions.jsp"%>
						<!-- Settlement/Other Details-->
						<jsp:include page="../../common/inc/day2/day2CPASettlementsOROtherDetails.jsp">
							<jsp:param name="actionId" value="${param.actionId}" />
							<jsp:param name="transactionEventTypeId" value="${param.transactionEventTypeId}" />
						</jsp:include>
					</c:when>
				</c:choose>

					<!-- starts uploads-->
					<jsp:include page="/jsp/common/attachments/cpaLegPageAttachments.jsp">
						<jsp:param name="mode" value="edit" />
					</jsp:include> 
					<!-- end uploads -->
				<div class="span12 right btn-container" style="margin-left: -20px;">
					<input type="hidden" name="productType" value="CPA" />
					<c:if test="${sessionScope.section eq 'myTasks'}">
						<input type="button" value="Save and return to Request" class="btn right btn-success"
							onclick="javascript:validateLegCashPool('?command=saveAndReturnToDeal&productType=CPA',${param.transactionEventTypeId},${param.actionId});">
						<input type="button" value="Save" class="btn right" onclick="javascript:saveAsDraftD2CPA(this);">
					</c:if>
					<c:if test="${sessionScope.section eq 'myRequests'}">
						<c:choose>
							<c:when test="${empty deal.WFStage}">
								<c:if test="${deal.action eq 'Draft' || deal.action eq 'DRAFT'}">
									<input type="button" value="Save and return to Request"
										class="btn right btn-success"
										onclick="javascript:validateLegCashPool('?command=saveAndReturnToDeal&productType=CPA',${param.transactionEventTypeId},${param.actionId});">
									<input type="button" value="Save" class="btn right"
										onclick="javascript:saveAsDraftD2CPA(this);">
								</c:if>
								<c:if test="${empty deal.action}">
									<input type="button" value="Save and return to Request"
										class="btn right btn-success"
										onclick="javascript:validateLegCashPool('?command=saveAndReturnToDeal&productType=CPA',${param.transactionEventTypeId},${param.actionId});">
									<input type="button" value="Save" class="btn right"
										onclick="javascript:saveAsDraftD2CPA(this);">
								</c:if>
							</c:when>
						</c:choose>
					</c:if>
					
					<a href="#confirm" class="btn-link right cancel modal-confirm" data-toggle="modal" >Cancel</a>

					
				</div>
			</c:if>	
	<div class="modal hide fade" id="confirm">
		<div class="modal-header">
			<a class="close" href="javascript:closing()">X</a>
			<h3>Cancel Financing Request</h3>
		</div>
		<div class="modal-body" style="margin-top:-16px;">
			<div class="row">
				<p><b>Are you sure you want to cancel?</b><br>
			Any changes you have made will be lost
			</p>
			</div>
		</div>
		<div class="modal-footer">
			<a href="javascript:redirectFundingRequest('?command=redirectFundingRequest');" class="btn right btn-success">Yes, cancel the request</a>
			<a class="btn-link right cancel" href="javascript:closing()">No, take me back to the request</a>
		</div>
	</div>
			
			<!-- Edit  Mode End -->
		</html:form>


	</c:when>
	<c:otherwise>
		<!-- Read Only Mode Start -->
		<c:if test="${param.actionId ne 1}">
			<%@ include file="../../common/inc/day2/day2CPAOriginalTranscationDetailsRO.jsp"%>
			<jsp:include page="../../common/inc/day2/day2CPARequestDetailInput.jsp">
				<jsp:param name="transactionEventTypeId" value="${param.transactionEventTypeId}" />
			</jsp:include>
		</c:if>
		<!-- Read Only Mode End -->
		<a class="btn-link right cancel"  onclick="history.back();">Cancel</a>
	</c:otherwise>
</c:choose>

</html>