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

<script src="<%=servletContextUrl%>/js/day2/equityTCMO.js" type="text/javascript"></script>
<%String legLenforJS ="0";%>
					
<script type="text/javascript">
var legLen = '<%=legLenforJS%>';
//param.id used so it can not be moved to separate js file.
function save(obj){
	$("#pageID").val(4);
	var actionType = $('input[name=saveEquityLeg]:radio:checked').val();
	if(actionType == 'saveNextleg'){
		obj.form.action = contextURL + '/transactionCapture/transactionCaptureLeg.do?command=saveNextLeg&id=' + ${param.id};
		obj.form.submit();
	}else if (actionType == 'saveReturnDeal'){
		obj.form.action = contextURL + '/transactionCapture/transactionCaptureLeg.do?command=saveLeg&id=' + ${param.id};
		obj.form.submit();
	}else{
		return ;
	}	
}
</script>
  </head>
  <c:set var="legNumber" value="${requestScope.legNumber}" />
  <body>
	<div class="container main">
		<%@include file="/jsp/common/headerSection.jsp" %>
		<c:set var="day2legSummaryVO" value="${deal:fetchDay2LegSummary(legNumber, pageContext.request)}" scope="page"/>
		<c:set var="legSummaryVO" value="${deal:fetchLegSummary(legNumber, pageContext.request)}" scope="page"/>
		<ul class="breadcrumb">
			<li><a href="${context}/homePage.do">Home</a> <span class="divider">/</span></li>
			<li><a href="${context}/transactionCapture/transactionCaptureMOFourBlocker.do?command=load&DealRequestID=${sessionScope.deal.dealSeqId}">Transaction Capture & Closure</a> <span class="divider">/</span></li>
			<li class="active">${legSummaryVO.transactionEventType}</li>
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
			Complete Extension details below. <span class="required-fields"><span>*</span>= Required</span>
		</p>
		
		
        
		<html:form styleId="legSummary" method="post" action="/transactionCapture/transactionCaptureLeg.do" enctype="multipart/form-data">
		<input type="hidden" name="legNumber" value="${legNumber }">
		<input type="hidden" name="legSeqId" value="${legSummaryVO.legSeqId}" />		
		<c:set var="nonStandardDocsFlag" value="${deal:getNonStandardDocsFlag(pageContext.request)}" />
		
		<jsp:include page="/jsp/common/inc/detailSummary.jsp" >
			<jsp:param value="transactionCapture" name="page"/>
		</jsp:include>
	
		<%@ include file="/jsp/common/inc/equityDetails.jsp"%>
		
		<jsp:include page="/jsp/day2/rca/currentLegdetails.jsp" >
			<jsp:param name="id" value="${legNumber }"/>
		</jsp:include>


		<div class="form-mod">
			<h2 class="span12">${legSummaryVO.legSeqId}</h2>
			<div class="row">
				<div class="span5">
					<div class="form-row">
					<span class="required">*</span>
					<label><bean:message key="label.leg1.transactionCapturedIn" /></label>
		                <html:select styleId="selectedTransactionCapturedIn" property="selectedTransactionCapturedIn" styleClass="check" value="${legSummaryVO.selectedTransactionCapturedInId}">
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
						<label><bean:message key="label.leg1.transactionidloanmodelid" />
						<span class="ttip info" data-original-title="<bean:message key="label.tooltip.tradeLoanmodelIDs" />"></span>
					    </label>
						<html:text property="transactionId" maxlength="50" tabindex="1" styleClass="span3" styleId="transactionId" value="${legSummaryVO.transactionId}" style="text-transform:uppercase"/>
					</div>
				</div>
			</div>
		</div> 
						


<%-- 		<jsp:include page="../../common/inc/commentsLog.jsp">
			<jsp:param name="formName" value="fourBlockerForm"/>			
		</jsp:include>
 --%>
		<jsp:include page="../../common/inc/auditLog.jsp">
				<jsp:param name="formName" value="fourBlockerForm"/>
		</jsp:include>

		  
			<!-- starts uploads-->
			<jsp:include page="/jsp/common/attachments/legPageAttachments.jsp">
			<jsp:param name="mode" value="edit" />
				<jsp:param name="legIndex" value="${legNumber}" />
			</jsp:include>  
			<!-- end uploads -->
		
		<!-- end of form form-mod -->
			<div class="span12 btn-container" style="margin-left:-10px!important;">
				<div class="span3 right" style="background-color: #D9EDF7;   border:1px solid #A6C2D6;padding:5px;">
					<div class="form-row" style="margin-bottom:15px;">
						<div class="radio-container conditional-required">
							<c:choose>
								<c:when test="${requestScope.proceedtoNextLeg ne 'yes'}">
									<label class="radio" style="color:#3A87AD;margin-bottom: 10px;" onmouseover="this.style.color='#348433'" onmouseout="this.style.color='#3A87AD'">
										<input type="radio" name="saveEquityLeg" value="saveNextLeg" class="condition">
										Save and go to next Leg
									</label>
								</c:when>
								<c:otherwise></c:otherwise>
							</c:choose>
							<label class="radio" style="color:#3A87AD;margin-bottom: 10px;" onmouseover="this.style.color='#348433'" onmouseout="this.style.color='#3A87AD'">
								<input type="radio" name="saveEquityLeg" value="saveReturnDeal" class="condition">
								Save and return to deal
							</label>
							
						</div>
					</div>
					<button id="saveLeg" type="submit" name="command" value="saveLeg" class="btn btn-success btn-large" style="display: block;" onclick="javascript:save(this);">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Submit&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					</button>
					<button id="saveNextLeg" type="submit" name="command" value="saveNextLeg" class="btn btn-success btn-large" style="display: none;">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Submit&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					</button>
				</div>
				<c:choose>
					<c:when test="${requestScope.proceedtoNextLeg ne 'yes'}">
						<a id="saveLeg1" class="btn right save-btn single" style="margin-top: 85px;">Save</a>
						<a href="#confirm" class="btn-link right cancel modal-confirm" data-toggle="modal" style="margin-top:70px">Cancel</a>
					</c:when>
					<c:otherwise>
						<a id="saveLeg1" class="btn right save-btn single" style="margin-top: 60px;">Save</a>
						<a href="#confirm" class="btn-link right cancel modal-confirm" data-toggle="modal" style="margin-top:70px">Cancel</a>
					</c:otherwise>
				</c:choose>
				
				
					<input type="hidden" name="pType" value="${legSummaryVO.productType}">
				
			</div>
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
 

