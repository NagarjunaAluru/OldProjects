<%@page import="com.ge.icfp.model.DealRequest"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page errorPage="/jsp/common/error.jsp" %>
<t:common/>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/WEB-INF/config/tld/attachment" prefix="attachment"%>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<%@ taglib uri="/WEB-INF/config/tld/hwf-desktoptag.tld"
	prefix="wfdesktop"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>
<!DOCTYPE html>
<html lang="en">
  <head>
  	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title><bean:message key="label.transactionCapture.title"/></title>
    <meta name="description" content="">
    <meta name="author" content="">
 <%@include file="/jsp/common/includeCssScripts.jsp" %>

<% String servletContextUrl = request.getContextPath();%>
<script>//Defining the global variable, so this variable can be used by other javascript library included in this JSP 
 var contextURL = '<%=servletContextUrl%>';</script>	
<script src="<%= servletContextUrl%>/js/downloadAttachmentFile.js" type="text/javascript"></script>
<script src="<%=servletContextUrl%>/js/day2/cpaTCMiddleOffice.js" type="text/javascript"></script>
  </head>
  <c:set var="legNumber" value="${requestScope.legNumber}" />
  <body>
	<div class="container main">
		<%@include file="/jsp/common/headerSection.jsp" %>
		<c:set var="day2legSummaryVO" value="${deal:fetchDay2LegSummary(legNumber, pageContext.request)}" scope="page"/>
		<c:set var="legSummaryVO" value="${deal:fetchLegSummaryObject(legNumber, pageContext.request)}" scope="page"/>
		<ul class="breadcrumb">
			<li><a href="${context}/homePage.do">Home</a> <span class="divider">/</span></li>
			<li><a href="${context}/transactionCapture/transactionCaptureMOFourBlocker.do?command=load&DealRequestID=${sessionScope.deal.dealSeqId}">Transaction Capture & Closure</a> <span class="divider">/</span></li>
			<li class="active">Leg ${legSummaryVO.legSeqId}: Summary</li>
		</ul>
		<div class="alert fade in alert-danger hide" style="display:<t:isError/>; ">
            <a href="#" data-dismiss="alert" class="close">X</a>
            <strong>Please fix the following fields highlighted in red.</strong> 
        </div>
        <div class="alert fade in alert-success hide" style="display: ${not empty requestScope.UpdateMessage ? 'block' : 'none'}">
            <a href="#" data-dismiss="alert" class="close">X</a>
            <strong>${requestScope.UpdateMessage}</strong>
        </div>
        
		<h1 class="page-title span12">${legSummaryVO.transactionEventType}</h1>
		<p class="span12 left clear dashdesc">
			${legSummaryVO.transactionEventType} details below. <span class="required-fields"><span>*</span>= Required</span>
		</p>
		
		<c:set var="action" value="/transactionCapture/transactionCaptureLeg.do" />
        
		<html:form styleId="legSummary" method="post" action="/transactionCapture/transactionCaptureLeg.do" enctype="multipart/form-data">
		<input type="hidden" name="legNumber" id="legNumberID" value="${legNumber }">
		<input type="hidden" name="legSeqId" value="${legSummaryVO.legSeqId}" />
		<%-- <input type="hidden" name="legNumber"  id="legNumberID" value="${ param.id }"> --%>		
		
	<c:set var="factors" value="Operational Risk - Ongoing" />
	<c:set var="origin" value="Middle Office" />
	<c:set var="path" value="middleOffice" />
	
		<jsp:include page="/jsp/common/inc/day2/day2CPASnO.jsp">
				<jsp:param name="actionId" value="${param.actionId}"/>
				<jsp:param name="transactionEventTypeId" value="${param.transactionEventTypeId}"/>
			    <jsp:param value="transactionCapture" name="page"/>
			    <jsp:param name="legNumber" value="${legNumber}"/>
			    <jsp:param name="factors" value="${factors}"/>
				<jsp:param name="legType" value="CPA"/>
				<jsp:param name="factor" value="${factors}"/>
				<jsp:param name="formName" value="fourBlockerForm"/>
				<jsp:param name="path" value="${path}"/>
				<jsp:param name="method" value="legDetails"/>
				<jsp:param name="origin" value="${origin}"/>
				<jsp:param name="wfStageId" value="${param.wfStageId}"/>
   		</jsp:include>
		
		<!-- end of form form-mod -->
			<div class="span12 right btn-container" style="margin-left: -20px;">
					<input type="button" value="Save and return to Request"
						class="btn right btn-success"
						onclick="javascript:saveAndReturnToDeal(this, '${action}');"><!-- ,${param.transactionEventTypeId} -->
					<input type="button" value="Save" class="btn right"
						onclick="javascript:saveAsDraft(this, '${action}');">
						<a href="#confirm" class="btn-link right cancel modal-confirm"
						data-toggle="modal">Cancel</a>

			</div>
			<input type="hidden" name="pType" value="${legSummaryVO.productType}">


		</html:form>
    <hr>
    </div>
	<%@include  file="/jsp/common/footerSection.jsp" %>
	<!-- Modals start -->
	<div class="modal hide fade" id="confirm">
		<div class="modal-header">
			<a class="close" data-dismiss="modal">X</a>
			<h3>Cancel Leg</h3>
		</div>
		<div class="modal-body">
			<div class="row">
				<p><b>Are you sure you want to cancel?</b><br>
			Any changes you have made will be lost
			</p>
			</div>
		</div>
		<div class="modal-footer">
			<a href="${context}/transactionCapture/transactionCaptureMOFourBlocker.do?command=load&DealRequestID=${sessionScope.deal.dealSeqId}" class="btn right btn-success">Yes, cancel the Leg</a>
			<a href="#" class="btn-link right cancel" data-dismiss="modal">No, take me back to the Leg</a>
		</div>
    </div>
  </body>
</html>
 

