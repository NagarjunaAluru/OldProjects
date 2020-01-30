<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="../../common/error.jsp" %>
<%
	String servletContextUrl = request.getContextPath();
%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib uri="http://ge.com/icfp/taglibs/staticdata" prefix="staticdata" %>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script>
var servletContextUrl = '<%=servletContextUrl%>';
</script>
<script type="text/javascript">
       var contextURL = '<%=servletContextUrl%>	';
</script>
<script>	
			$(document).ready(function(){
				$('#validateErrorFlag').hide();
				showAssessmentComment();
				onLoadSolvencyCalc();
				covertDataToCurrencyFormat();
				$('#mDriversAlert').hide();
				
				 $("#smradioS6").click(function() {
					  $('#commentsReq6').hide();
					  $('#solvencyMetrics6TdID').removeClass("solvencyYellowClass");
					  $('#solvencyMetrics6TdID').removeClass("solvencyRedClass");
					  $('#solvencyMetrics6TdID').removeClass("solvencyGreenClass"); 
					  $('#solvencyMetrics6TdID').addClass("solvencyRedClass"); 
					});
				  $("#smradioH6").click(function() {
					  $('#commentsReq6').show();
					  $('#solvencyMetrics6TdID').removeClass("solvencyYellowClass");
					  $('#solvencyMetrics6TdID').removeClass("solvencyRedClass");
					  $('#solvencyMetrics6TdID').removeClass("solvencyGreenClass"); 
					  $('#solvencyMetrics6TdID').addClass("solvencyGreenClass"); 
					});
				
				
				$('.autosize1').keyup(function() {
					var len = this.value.length;
					if (len >= 1000) {
						this.value = this.value.substring(0, 1000);
					}

				});
				
				$("#qualitativeFactor1").click(function(){
					  $("#commentsQualFacID").show();
				});
				$("#qualitativeFactor2").click(function(){
					  $("#commentsQualFacID").show();
				});
				$("#qualitativeFactor3").click(function(){
					  $("#commentsQualFacID").hide();
				});
			});
</script>			
<script>
//param.id used here, so this code cannot be moved to seperate js file.
function saveTP(obj,transactionEventTypeId){
	
	var validateFlag = false;
	validateFlag = validateTPQualitativeAssesment();
	// tpSummary Validation -  only if transactionEventTypeId == 1 (CPA Termination)
	if(transactionEventTypeId == 1){
		var tpSummary = $("#tpSummary").val();
		if(tpSummary == ""){
			validateFlag = true;
			$("#tpSummaryBar").show();
		}else {
			$("#tpSummaryBar").hide();
		}
	}
   if (validateFlag == false) {
	           removeAmountShortcuts();
				$("#pageId").val(4); // 4 means validate
				obj.form.action = contextURL + '/transferPricing/day2CPATransferPricingLeg.do?command=cpaSaveAndReturnToDeal&id=' + ${param.id}+'&DealRequestID='+${sessionScope.deal.dealSeqId};
				obj.form.submit();
			} else {
				$(window).scrollTop(100);
				$('#validateErrorFlag').show();
			} 
}
function cpaSaveAsDraft(obj,secObj){
	removeAmountShortcuts();
	obj.form.action = contextURL + '/transferPricing/day2CPATransferPricingLeg.do?command=saveCPA&id=' + ${param.id}+'&actionValue=save';
	obj.form.submit();
}


</script>
</head>
<div id="validateErrorFlag" class="alert fade in alert-danger hide">
           <a href="#" data-dismiss="alert" class="close">X</a>
           <strong>Please fix the following fields highlighted in red.</strong> 
        </div>

<c:set var="CPALegSummary" value="${deal:fetchLegSummary(requestScope.legNumber, pageContext.request)}" scope="page"/>
<!-- requestScope.legNumber -->
<c:set var="legNumber" value="${requestScope.legNumber}" />

<!-- Leg Reference Id Details Start -->
<jsp:include page="../../common/inc/day2/day2CPARequestDetails.jsp">
	<jsp:param value="cpafrontOffice" name="path"/>
	<jsp:param value="1" name="legNumber" />
	<jsp:param value="${CPALegSummary.legSeqId}" name="legSeqId"/>
</jsp:include>
<!-- Leg Reference Id Details End -->

<c:choose>
	<c:when test="${param.actionId eq 3}"> 
	<%-- <script src="<%=servletContextUrl%>/js/rcaTransferPricingInput.js" type="text/javascript"></script> present in d2IPScreens--%>
	<script src="<%=servletContextUrl%>/js/tablesorter.min.js" type="text/javascript"></script>
	<script src="<%=servletContextUrl%>/js/jshashtable-2.1_src.js" type="text/javascript"></script>
	<script src="<%=servletContextUrl%>/js/jquery.numberformatter-1.2.3.js" type="text/javascript"></script>
	<script src="<%=servletContextUrl%>/js/jquery.formatCurrency-1.0.0.min.js" type="text/javascript"></script>
	<script src="<%=servletContextUrl%>/js/cpaAssessmentValidation.js" type="text/javascript"></script>
	
	<html:form action="/transferPricing/day2CPATransferPricingLeg.do"  styleId="cpaLegRequestForm" method="post"  enctype="multipart/form-data">
	 <html:hidden property="page" value="2" styleId="pageId"/>
	 <input type="hidden" name="legNumber" id="legNumberID" value="${ requestScope.legNumber }">
	 <html:hidden name="cpaLegRequestForm" property="cpaSummary.legTypeId" value="3" />
	
	 <!-- Original Transaction Details Start -->
	 <%@ include file="../../common/inc/day2/day2CPAOriginalTranscationDetailsRO.jsp"%>     
	<!-- Original Transaction Details End -->  
	<!-- Participant And PoolLeader  -->
	<jsp:include page="../../common/inc/day2/day2ParticipantPoolLeaderRO.jsp" />
	<!-- Cash Pool Details  -->
	<jsp:include page="/jsp/common/inc/cashPoolDetails.jsp" />
	<!-- Cash Pool Termination Details  -->
	<c:if test="${param.transactionEventTypeId eq 1}">
		<%@ include file="../../common/inc/day2/day2CashPoolTerminationDetailsRO.jsp"%>
	</c:if> 
	  <!-- Terms & Conditions Start -->
	<%@ include file="../../common/inc/day2/day2CPATPRateInformation.jsp"%> 
	  <!-- Terms & Conditions End -->   
	  
	<!-- Transfer pricing summary Start -->      
	  <jsp:include page="../../common/inc/day2/day2CPATPSummary.jsp">
		<jsp:param name="actionId" value="${param.actionId}" />
		<jsp:param name="transactionEventTypeId" value="${param.transactionEventTypeId}" />
	</jsp:include>
	<!-- Transfer pricing summary End -->  
	
	<c:if test="${param.transactionEventTypeId ne 10}">
	<!-- Other Considerations  -->
	<jsp:include page="../../common/inc/day2/day2CPAOtherConsiderationsRO.jsp">
	      <jsp:param name="actionId" value="${param.actionId}" />
				<jsp:param name="legNumber" value="${legNumber}" />
	</jsp:include>
	<!-- Settlement/Other Details Start -->
	<jsp:include page="../../common/inc/day2/day2CPASettlementsOROtherDetailsRO.jsp">
		<jsp:param name="actionId" value="${param.actionId}" />
		<jsp:param name="transactionEventTypeId" value="${param.transactionEventTypeId}" />
	</jsp:include>
	</c:if> 
	
	<!-- Model Type , Model Drivers , Scores .... Solven Start-->
	<%@ include file="../../common/inc/day2/day2CPATPModelScoresNSolvency.jsp"%>
	<!-- Model Type , Model Drivers , Scores .... Solven End-->
	     
	<!-- Qualitative Assessment Start -->	
		<jsp:include page="/jsp/common/inc/cpaQualitativeAssessment.jsp">
					<jsp:param name="factors" value="Transfer Pricing Risk"/>			
			</jsp:include>
	<!-- Qualitative Assessment End --> 
	<c:if test="${param.transactionEventTypeId eq 10}">
	<%@ include file="../../common/inc/day2/day2CPACorrectionsRO.jsp"%>
	</c:if>
	<!-- Comments Start --> 
	<div class="form-mod">
				<jsp:include page="/jsp/common/inc/commentsLog.jsp">
					<jsp:param name="formName" value="dealRequestForm"/>
					<jsp:param value="transferPricing/transferPricing" name="path"/>
				    <jsp:param value="Leg ${CPALegSummary.legSeqId}: Summary" name="name"/>
				    <jsp:param value="legDetails" name="method"/>
				    <jsp:param value="Transfer Pricing" name="origin"/>
				    <jsp:param value="${legNumber}" name="legNumber"/>			
				</jsp:include>
				<div class="row comment-container">
					<div class="span5">
						<div class="form-row autosize-container">
							<span class="required"></span>
							<b><bean:message key="label.pipelineReviewDeal.comments" />
							</b>
							<div class="char-count">500</div>
							<textarea class="xlarge autosize messageinput" name="lComments"	rows="4" onblur="scriptInjection(this);">${CPALegSummary.comments}</textarea>
						</div>
					</div> <!-- end of block -->
				</div>
	        </div><!-- end of form form-mod -->                         
	<!-- Comments End -->         
	<!-- Attachments & Audit log Start -->          
	
		
					<!-- starts uploads-->
					<jsp:include page="/jsp/common/attachments/cpaLegPageAttachments.jsp">
						<jsp:param name="mode" value="edit" />
					</jsp:include> 
					<!-- end uploads -->
					
					<jsp:include page="/jsp/common/inc/auditLog.jsp">
						<jsp:param name="formName" value="dealRequestForm"/>
						<jsp:param value="transferPricing/transferPricing" name="path"/>
						<jsp:param value="Leg ${CPALegSummary.legSeqId}: Summary" name="name"/>
						<jsp:param value="legDetails" name="method"/>
						<jsp:param value="Transfer Pricing" name="origin"/>
						<jsp:param value="${legNumber}" name="legNumber"/>			
					</jsp:include>
	<!-- Attachments & Audit log End -->  
	
	<div class="span12 right btn-container" style="margin-left: -20px;">
	    <c:if test="${sessionScope.section eq 'myTasks'}">
			<input type="button" value="Save and return to Request"  	class="btn right btn-success" id="saveAndReturnToDealId" onclick="javascript:saveTP(this,${param.transactionEventTypeId});">  
		    <input type="button" value="Save"  	class="btn right" id="save" onclick="javascript:cpaSaveAsDraft(this,${param.transactionEventTypeId});">  
		 </c:if>    
			<a href="#confirm" class="btn-link right cancel modal-confirm" data-toggle="modal" >Cancel</a>
		</div>
		<div class="modal hide fade" id="confirm">
		<div class="modal-header">
			<a class="close" href="javascript:closeCancelpopup()">X</a>
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
			<a href="<%=servletContextUrl%>/transferPricing/transferPricing.do?command=load&DealRequestID=${sessionScope.deal.dealSeqId}" class="btn right btn-success">Yes, cancel the Leg</a>
			<a class="btn-link right cancel" href="javascript:closeCancelpopup()">No, take me back to the Leg</a>
		</div>
      </div>
	
	 <input type="hidden" id="actionId" value="${requestScope.actionId}">
	</html:form>
</c:when>
	<c:otherwise>
	<!-- Read Only Mode Start -->
		 
	 <!-- Original Transaction Details Start -->
	 <%@ include file="../../common/inc/day2/day2CPAOriginalTranscationDetailsRO.jsp"%>     
	<!-- Original Transaction Details End -->  
	
	<!-- Participant And PoolLeader  -->
	<jsp:include page="../../common/inc/day2/day2ParticipantPoolLeaderRO.jsp" />
	
	<!-- Transfer pricing summary Start -->      
	<jsp:include page="/jsp/day2/transferPricingView/day2CPATPSummaryRO.jsp">
	   <jsp:param name="id" value="${param.id}"/>
	</jsp:include>
		
	<!-- Cash Pool Details  -->
	<jsp:include page="/jsp/common/inc/cashPoolDetails.jsp" />
	
	<!-- Cash Pool Termination Details  -->
	<c:if test="${param.transactionEventTypeId eq 1}">
	<%@ include file="../../common/inc/day2/day2CashPoolTerminationDetailsRO.jsp"%>
	</c:if> 
	  <!-- Terms & Conditions Start --> 
	<%-- <%@ include file="../../common/inc/day2/day2CPATPRateInformationRO.jsp"%>  --%>
	  <!-- Terms & Conditions End -->   
	  
	<!-- Transfer pricing summary Start -->      
	<%-- <%@ include file="../../common/inc/day2/day2CPATPSummaryRO.jsp"%>  --%>
	      
	<!-- Transfer pricing summary End -->  
	
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
	<jsp:include page="/jsp/day2/transferPricingView/cpaDay2TPView.jsp">
		<jsp:param name="id" value="${param.id}"/>
	</jsp:include> 
	
	 <input type="hidden"  id="fundHoldOperationId" value='${deal:getTPFundHoldOperationId(requestScope.legNumber, pageContext.request)}' />
	 <%@ include file="/jsp/common/inc/solvencyMetricsView.jsp"%>
	<jsp:include page="/jsp/common/inc/legQualitativeAssessment.jsp"> 
		<jsp:param name="factor" value="Transfer Pricing Risk"/>	
	</jsp:include>
	<!-- Comments log Start -->  
	<div class="form-mod">
	<jsp:include page="../../common/inc/commentsLog.jsp">
		<jsp:param name="formName" value="fourBlockerForm" />
		<jsp:param value="${param.source}" name="path"/>
		<jsp:param value="${param.origin}" name="origin"/>
		<jsp:param value="${param.source}" name="source"/>
		<jsp:param value="${param.name}" name="name"/>
	</jsp:include>
	</div>
	<!-- Comments log End -->
	<!-- Audit log Start -->          
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
	
					
<jsp:include page="../../common/inc/auditLog.jsp">
	<jsp:param name="formName" value="ICFPLegRequestForm" />
	<jsp:param value="${param.path}" name="path"/>
	<jsp:param value="${param.origin}" name="origin"/>
	<jsp:param value="${param.source}" name="source"/>
	<jsp:param value="${param.name}" name="name"/>
</jsp:include>
	<!-- Audit log End -->  
	
	<!-- Read Only Mode End -->
	</c:otherwise>
</c:choose>

</html>  