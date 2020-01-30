<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en-US"/>
<t:common/>
<c:if test="${isTCCMStage}">

	<form method="post" id="legSummary" 
			  action="${context}/transactionCapture/transactionCaptureLeg.do" 
			  enctype="multipart/form-data">
</c:if>

<div class="alert fade in alert-danger hide" id="genericErrorComment">
	<a href="#" data-dismiss="alert" class="close">X</a> <strong>An
		error has occurred, see below.</strong>
</div>
<% String servletContextUrl = request.getContextPath();%>

<c:set var="legNumber" value="${requestScope.legNumber}" />
<c:set var="legSummary" value="${deal:fetchLegSummaryObject(legNumber, pageContext.request)}" />
<c:set var="productType" value="${legSummary.legTypeId}" />
<c:set var="eventType" value="${legSummary.transactionEventTypeId}" />
<c:set var="legSummaryVO" value="${deal:fetchLegSummary(requestScope.legNumber, pageContext.request)}" scope="page"/>

		<c:if test="${isTCCMStage}">			
			<jsp:include page="../common/inc/fromToEntity.jsp"></jsp:include>			
		</c:if>
		
<c:choose>
	<c:when test="${(productType eq 1 || productType eq 5 || productType eq 6 ) && (eventType eq 3 || eventType eq 4 || eventType eq 6 || eventType eq 9 || eventType eq 11)
	|| (productType eq 2 && eventType eq 11)}">
		<jsp:include page="cashMgmt/rcaCashMgmtEventsView.jsp">
			<jsp:param name="eventType" value="${eventType}"/>
			<jsp:param name="productType" value="${productType}"/>
			<jsp:param name="source" value="${param.source}"/>
			<jsp:param name="name" value="${param.name}"/>
		</jsp:include>
	</c:when>
	
	<c:when test="${(productType eq 1) && (eventType eq 5)}">
		<jsp:include page="cashMgmt/rcaCashMgmtEventsView.jsp">
			<jsp:param name="eventType" value="${eventType}"/>
			<jsp:param name="source" value="${param.source}"/>
		</jsp:include>
	</c:when>
	
	<c:when test="${productType eq 3}">
		<jsp:include page="cpa/cpaCashManagement.jsp" >
			<jsp:param name="actionId" value="${param.actionId}"/>	
			<jsp:param name="source" value="${param.source}"/>
			<jsp:param name="page" value="cashManagement"/>
			<jsp:param name="transactionEventTypeId" value="${eventType}"/>
		</jsp:include>
	</c:when>

	<c:when test="${productType eq 2}">
		<jsp:include page="equity/equityCashManagement.jsp">
			<jsp:param name="actionId" value="${param.actionId}"/>	
			<jsp:param name="source" value="${param.source}"/>
			<jsp:param name="page" value="cashManagement"/>
			<jsp:param name="name" value="${param.name}"/>
		</jsp:include>
	</c:when>
</c:choose>


<div class="span8 right btn-container">

			<c:if test="${isTCCMStage and showSave}">
				<c:set var="showNextLeg"
				 value="${requestScope.proceedtoNextLeg ne 'yes'}" />
				<div class="span3 right submit-box">
				<div class="form-row" style="margin-bottom:15px;">
					<div class="radio-container conditional-required">

						<c:if test="${showNextLeg}">
							<label class="radio">
								<input type="radio" name="command" value="saveNextLeg" class="condition">
								Save and go to next Leg
							</label>
						</c:if>
							
						<label class="radio">
							<input type="radio" name="command" value="saveLeg" class="condition">
							Save and return to deal
						</label>									
					</div>
				</div>

				<button id="saveLegInput" type="submit" class="btn btn-success btn-large">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Submit&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</button>	
				
				</div>

				<c:choose>
					<c:when test="${showNextLeg}">
						<c:set var="margin" value="85px"/>
					</c:when>
					<c:otherwise>
						<c:set var="margin" value="60px" />
					</c:otherwise>
				</c:choose>

				<a class="btn right save-btn single" 
				style="margin-top: ${margin};">Save</a>

				<input type="hidden" name="forward" value="sucessCMFO"/>
			
			<a href="#confirm" class="right cancel single modal-confirm" data-toggle="modal" style="margin-top:95px">Cancel</a>
			</c:if>
		</div>
<c:if test="${isTCCMStage}">
<input type="hidden" name="pType" value="${legSummaryVO.productType}">
<input type="hidden" name="actionId" value="${actionId}"/>
<input type="hidden" name="source" value="${param.source}"/>
</form>
<div class="modal hide fade" id="confirm">
	<div class="modal-header">
		<a class="close" data-dismiss="modal">X</a>
		<h3>Cancel Leg</h3>
	</div>
	<div class="modal-body" style="margin-top:-16px;">
		<div class="row">
			<p><b>Are you sure you want to cancel?</b><br>
		Any changes you have made will be lost
		</p>
		</div>
	</div>
	<div class="modal-footer">
		<a onclick="history.back();" class="btn right btn-success">Yes, cancel the Leg</a>
		<a class="btn-link right cancel" data-dismiss="modal">No, take me back to the leg</a>
	</div>
</div>
</c:if>
<c:if test="${!isTCCMStage || !(isTCCMStage and showSave)}">
<div class="span8 right btn-container">
	<a onclick="history.back();" class="right cancel single" style="margin-top:95px">Cancel</a>
</div>
</c:if>	





