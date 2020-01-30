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
<%	String servletContextUrl = request.getContextPath();%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:common/>

<script> var servletContextUrl = '<%=servletContextUrl%>';</script>
<script src="<%=servletContextUrl%>/js/bootstrap-typeahead.js" type="text/javascript"></script>

	<div id="validateFlag" class="alert fade in alert-danger hide">
	    <a href="#" class="close" onclick="javascript:closeMessage();">X</a>
	    <strong><bean:message key="label.addLeg.pleaseFixErrors" /></strong> 
	</div>
        
    <div class="alert fade in alert-success hide" style="display: ${requestScope.save eq 'success' ? 'block' : 'none'}">
         <a href="#" data-dismiss="alert" class="close">X</a>
         <strong>You have successfully updated the leg for this transaction.</strong> 
    </div>
    <div class="alert fade in alert-success hide" style="display: ${not empty requestScope.UpdateMessage ? 'block' : 'none'}">
         <a href="#" data-dismiss="alert" class="close">X</a>
         <strong>${requestScope.UpdateMessage}</strong>
    </div>
    <div class="alert fade in alert-danger hide" style="display: ${not empty requestScope.atmtError ? 'block' : 'none'}">
         <a href="#" data-dismiss="alert" class="close">X</a>
         <strong>${requestScope.atmtError}</strong> 
     </div>
	
		<input type="hidden" name="legNumber" value="${requestScope.legNumber}">
		
		<c:set var="legSummaryVO" value="${deal:fetchLegSummary(requestScope.legNumber, pageContext.request)}" scope="page"/>
		<input type="hidden" name="legSeqId" value="${legSummaryVO.legSeqId}" />
		
		<jsp:include page="../common/transactionLegDetails.jsp">
			<jsp:param name="derDisplayValue" value="4"/>
		</jsp:include>
		
		<c:if test="${param.eventType eq 3}">
			<jsp:include page="../common/rcaAssignmentReadOnly.jsp" />
		</c:if>
		
		<c:if test="${param.eventType eq 4}">
			<jsp:include page="../common/rcaAgreementExtensionReadOnly.jsp" />
		</c:if>
		
		<c:if test="${param.eventType eq 5}">
			<jsp:include page="../common/rcaAmendIncreaseDecreaseReadOnly.jsp" />
		</c:if>
		
		<c:if test="${param.eventType eq 6}">
			<jsp:include page="../common/rcaGenAmendmentReadOnly.jsp" />
		</c:if>
		
		<c:if test="${param.eventType eq 9}">
			<jsp:include page="../common/rcaEarlyTerminationReadOnly.jsp" />
		</c:if>
		
		<c:if test="${param.eventType eq 11}">
			<jsp:include page="../common/rcaDebtEquityOtherReadOnly.jsp">
				<jsp:param name="productType" value="${param.productType}"/>
			</jsp:include>
		</c:if>
			 

		<jsp:include page="../day2ReadOnlyView.jsp" >
			<jsp:param value="cashManagement" name="page"/>
			<jsp:param value="${param.source}" name="path"/>
			<jsp:param value="Leg ${legSummaryVO.legSeqId}: Summary" name="origin"/>
			<jsp:param value="viewInputScreens" name="method"/>
			<jsp:param value="${name}" name="name"/>
			<jsp:param value="${source}" name="source"/>
		</jsp:include>
		

		<div class="span8 right btn-container">
			<c:if test="${!isTCCMStage}">
				<a href="#confirm" class="right cancel single modal-confirm" data-toggle="modal" style="margin-top:95px">Cancel</a>
			</c:if>
		</div>
