<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<%@ taglib prefix="security"  uri="hwf-securitytag" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<fmt:setLocale value="en-US"/>
<t:common/>
<%	String servletContextUrl = request.getContextPath();%>

<script> var servletContextUrl = '<%=servletContextUrl%>';</script>
<script src="<%=servletContextUrl%>/js/bootstrap-typeahead.js" type="text/javascript"></script>
<%String lastLeg = (String) request.getAttribute("proceedtoNextLeg");%>
<script src="<%=servletContextUrl%>/js/day2/rcaTreasuryTaxEvents.js" type="text/javascript"></script>

<script type="text/javascript">
//show next leg navigation if it's not last leg
//it needs the JSP variable so placed in JSP file
$(document).ready(function() {

	var lastLegVar = '<%=lastLeg%>';
	   if(lastLegVar=='yes')
		   {
		   $('#reviewNextLegID').hide();
		   }else {
			   $('#reviewNextLegID').show();
		   }

});
</script>


	<div id="validateFlag" class="alert fade in alert-danger hide">
	    <a href="#" class="close" onclick="javascript:closeMessage();">X</a>
	    <strong><bean:message key="label.addLeg.pleaseFixErrors" /></strong> 
	</div>
        
    <div class="alert fade in alert-success hide" style="display: ${requestScope.save eq 'success' ? 'block' : 'none'}">
         <a href="#" data-dismiss="alert" class="close">X</a>
         <strong>You have successfully updated the leg for this transaction.</strong> 
    </div>
            
	<form id="legSummary"  action="${context}/treasuryTax/treasuryTaxLeg.do" method="post"   enctype="multipart/form-data">
		<input type="hidden" name="legNumber" value="${requestScope.legNumber}">
		
		<c:set var="legSummaryVO" value="${deal:fetchLegSummary(requestScope.legNumber, pageContext.request)}" scope="page"/>
		<input type="hidden" name="legSeqId" value="${legSummaryVO.legSeqId}" />
		
		<jsp:include page="../common/transactionLegDetails.jsp">
			<jsp:param name="derDisplayValue" value="6"/>
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
			 

			<jsp:include page="../../common/inc/qualitativeAssessment_LegSummary.jsp">
				<jsp:param name="factors" value="Tax Risk"/>
				<jsp:param value="RCA" name="legType"/>
			</jsp:include>
			
			<div class="form-mod">
			<jsp:include page="../../common/inc/commentsLog.jsp">
					<jsp:param name="formName" value="fourBlockerForm"/>
					<jsp:param value="treasuryTax/treasuryTax" name="path"/>
			        <jsp:param value="Leg ${legSummaryVO.legSeqId}: Summary" name="name"/>
			        <jsp:param value="legDetails" name="method"/>
			        <jsp:param value="Treasury Tax" name="origin"/>	
			        <jsp:param value="${legSummaryVO.legNumber}" name="legNumber"/>		
			</jsp:include>
			<div class="row comment-container">
				<div class="span5">
					<div class="form-row autosize-container">
						<label>Comments</label>
						<div class="char-count">500</div>
						<textarea class="xlarge autosize messageinput" name="lComments"	rows="4" onblur="scriptInjection(this);">${legSummaryVO.comments}</textarea>
					</div>
				</div> <!-- end of block -->
			</div>
      	  </div>
      	  
		      	  	 <!-- starts uploads-->
		<jsp:include page="/jsp/common/attachments/legPageAttachments.jsp">
		<jsp:param name="mode" value="edit" />
			<jsp:param name="legIndex" value="${legNumber}" />
		</jsp:include>  
		<!-- end uploads -->

			<jsp:include page="../../common/inc/auditLog.jsp">
			<jsp:param name="formName" value="fourBlockerForm"/>
			<jsp:param value="treasuryTax/treasuryTax" name="path"/>
			<jsp:param value="Leg ${legSummaryVO.legSeqId}: Summary" name="name"/>
			<jsp:param value="legDetails" name="method"/>
			<jsp:param value="Treasury Tax" name="origin"/>
			<jsp:param value="${legSummaryVO.legNumber}" name="legNumber"/>			
		</jsp:include>

			<div class="span12 btn-container" style="margin-left:-10px!important;">
				<c:if test="${sessionScope.section eq 'myTasks'}">
					<div class="span3 right" style="background-color: #D9EDF7;   border:1px solid #A6C2D6;padding:5px;">
						<div class="form-row" style="margin-bottom:15px;">
							<div id="saveRadioDiv" class="radio-container conditional-required">
								<label class="radio" style="color:#3A87AD;margin-bottom: 10px;" onmouseover="this.style.color='#348433'" onmouseout="this.style.color='#3A87AD'" id="reviewNextLegID">
									<input type="radio" name="saveAction" value="saveNextLeg"  class="condition">
									Save and go to next Leg
								</label>
								<label class="radio" style="color:#3A87AD;margin-bottom: 10px;" onmouseover="this.style.color='#348433'" onmouseout="this.style.color='#3A87AD'">
									<input type="radio" name="saveAction" value="saveReturnDeal"  class="condition">
									Save and return to deal
								</label>
							</div>
						</div>
						
						<input type="button" value="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Submit&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" class="btn btn-success btn-large" onclick="javascript:saveTreasurytax(this);">
					</div>
					<c:choose>
						<c:when test="${requestScope.proceedtoNextLeg ne 'yes'}">
							<a id="saveLeg1" class="btn right save-btn single" onclick="javascript:saveBut(this);" style="margin-top: 85px;">Save</a>
							<a href="#confirm" class="btn-link right cancel modal-confirm" data-toggle="modal" style="margin-top:95px">Cancel</a>
						</c:when>
						<c:otherwise>
							<a id="saveLeg1" class="btn right save-btn single" onclick="javascript:saveBut(this);" style="margin-top: 60px;">Save</a>
							<a href="#confirm" class="btn-link right cancel modal-confirm" data-toggle="modal" style="margin-top:70px">Cancel</a>
						</c:otherwise>
					</c:choose>
				</c:if>
				<c:if test="${sessionScope.section eq 'myAssignedTasks'}">
					<a href="#confirm" class="btn-link right cancel modal-confirm" data-toggle="modal" style="margin-top:95px">Cancel</a>
				</c:if>
			</div>
					<input type="hidden" name="pType" value="${legSummaryVO.productType}">
	
      <div class="modal hide fade" id="confirm">
		<div class="modal-header">
			<a class="close" href="javascript:closeConfirmModal()">X</a>
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
			<a href="${context}/treasuryTax/treasuryTax.do?command=load&DealRequestID=${sessionScope.deal.dealSeqId}" class="btn right btn-success">Yes, cancel the Leg</a>
			<a class="btn-link right cancel" href="javascript:closeConfirmModal()">No, take me back to the Leg</a>
		</div>
      </div>
</form>
