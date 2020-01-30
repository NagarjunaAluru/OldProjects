<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>

<% String servletContextUrl = request.getContextPath();%>

<script type="text/javascript">
//Defining the global variable, so this variable can be used by other javascript library included in this JSP 
	servletContextUrl = '<%=servletContextUrl%>';
</script>
<script type="text/javascript">
//Show next leg navigation based on lastLeg value
//it needs the JSP variable so placed in JSP file
$(document).ready(function() {
    var lastLegVar = '<%=request.getAttribute("proceedtoNextLeg")%>';
	   if(lastLegVar=='yes')
		   {
		   $('#reviewNextLegID1').show();
		   }else {
			   $('#reviewNextLegID1').hide();
		   } 
	});	
</script>

<script src="<%=servletContextUrl%>/js/day2/day2Equity.js" type="text/javascript"></script>

<%-- <div class="row">
	<div class="span12">
		<h2>Leg ${param.id}</h2>
		<jsp:include page="../rca/currentLegdetails.jsp">
			<jsp:param name="id" value="${param.id}" />
		</jsp:include>
	</div>
</div>
 --%>
<c:choose>
	<c:when test="${param.actionId eq 2}">
		<html:form action="/RCALegRequest.do" styleId="ICFPLegRequestForm" method="post" enctype="multipart/form-data">
		<c:set var="legNumber" value="${sessionScope.ICFPLegRequestForm.map['legNumber']}" />
		<c:set var="legSummaryVO" value="${deal:fetchLegSummary(requestScope.legNumber, pageContext.request)}" scope="page"/>

		<jsp:include page="../rca/currentLegdetails.jsp">
			<jsp:param name="id" value="${legNumber }"/>
		</jsp:include>

		<input type="hidden" name="legNumber" value="${ requestScope.legNumber }"/>
		<input type="hidden" name="legSeqId" value="${legSummaryVO.legSeqId}" />

		<%@ include file="../../common/inc/day2/day2PayerReceiver.jsp"%>
		<%@ include file="../../common/inc/day2/day2DividendPaymentDetails.jsp"%>	
 		<%@ include file="../../common/inc/day2/day2SettlementDetails.jsp"%>
 		<%@ include file="../../common/inc/day2/day2OtherConsiderations.jsp"%>
 		
 	
 		<jsp:include page="/jsp/frontOffice/qualitativeAssessment.jsp">
			<jsp:param name="factors" value="Regulatory Risk,Finance Risk,Legal Governance Risk,Reputational Risk,Sovereign Risk"/>			
		</jsp:include>

		<div class="form-mod"> 		
	 		<jsp:include page="../../common/inc/commentsLog.jsp">
				<jsp:param name="formName" value="ICFPLegRequestForm"/>			
			</jsp:include>
			<div class="row comment-container">
				<div class="span5">
					<div class="form-row autosize-container">
						<label>Comments</label>
						<div class="char-count">500</div>
							<html:textarea name="ICFPLegRequestForm" styleId="requestException" property="legSummary.comments" styleClass="xlarge autosize messageinput" rows="1" onblur="scriptInjection(this);"/>
					</div>
				</div>
				<!-- end of block -->
			</div>
		</div> 		
		
					<!-- starts uploads-->
			<jsp:include page="/jsp/common/attachments/legPageAttachments.jsp">
			<jsp:param name="mode" value="edit" />
				<jsp:param name="legIndex" value="${legNumber}" />
			</jsp:include>  
			<!-- end uploads -->
		<jsp:include page="../../common/inc/auditLog.jsp">
			<jsp:param name="formName" value="ICFPLegRequestForm"/>
		</jsp:include>

	<%-- 	<div class="span12 right btn-container">
			<input type="button" value="Save and return to Deal"
				class="btn right btn-success"
				onclick="javascript:validateLegDividends('frontOffice');">
			<input type="button" value="Save" class="btn right"
				onclick="javascript:saveFOLeg();"> <a
				href="#confirm" class="btn-link right cancel modal-confirm"
				data-toggle="modal">Cancel</a>
		</div> --%>
		
		<!-- ------------- -->
			<div class="span12 btn-container" style="margin-left:-10px!important;">
				<c:if test="${sessionScope.section eq 'myTasks'}">
				<div class="span3 right" style="background-color: #D9EDF7;   border:1px solid #A6C2D6;padding:5px;">
					<div class="form-row" style="margin-bottom:15px;">
						<div id="saveRadioDiv" class="radio-container conditional-required">
							<label class="radio" style="color:#3A87AD;margin-bottom: 10px;" onmouseover="this.style.color='#348433'" onmouseout="this.style.color='#3A87AD'" id="reviewNextLegID1">
								<input type="radio" name="saveAction" value="saveNextLeg" class="condition">
								Save and go to next Leg
							</label>
							<label class="radio" style="color:#3A87AD;margin-bottom: 10px;" onmouseover="this.style.color='#348433'" onmouseout="this.style.color='#3A87AD'">
								<input type="radio" name="saveAction" value="saveReturnDeal" class="condition">
								Save and return to deal
							</label>
						</div>
					</div>
					
					<input type="button" class="btn btn-success btn-large" onclick="javascript:validateLegDividends('frontOffice');"
					value="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Submit&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" />
					
				</div>
				
				<c:choose>
					<c:when test="${requestScope.nextLeg ne 'false'}">
						<input type="button" value="Save" class="btn right" style="margin-top: 85px;" onclick="javascript:saveFOLeg();">
						<a href="#confirm" class="btn-link right cancel modal-confirm" data-toggle="modal" style="margin-top:95px">Cancel</a>
					</c:when>
					<c:otherwise>
						<input type="button" value="Save" style="margin-top: 60px;" class="btn right" onclick="javascript:saveFOLeg();">
						<a href="#confirm" class="btn-link right cancel modal-confirm" data-toggle="modal" style="margin-top:70px">Cancel</a>
					</c:otherwise>
				</c:choose>
				</c:if>
				<c:if test="${sessionScope.section eq 'myAssignedTasks'}">
				<a href="#confirm" class="btn-link right cancel modal-confirm" data-toggle="modal" style="margin-top:95px">Cancel</a>
				</c:if>				
			</div>
		<!-- --------------- -->	

		<div class="modal hide fade" id="confirm">
			<div class="modal-header">
				<a class="close" data-dismiss="modal">X</a>
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
				<a
					href="javascript:cancel();"
					class="btn right btn-success">Yes, cancel the leg</a> <a href="#"
					class="btn-link right cancel" data-dismiss="modal">No, take me
					back to the leg</a>
			</div>
		</div>

		</html:form> 
	</c:when>
	<c:otherwise>

		<jsp:include page="/jsp/day2/common/originalTPLenderBorrower.jsp">
		 	<jsp:param value="${param.id}" name="id" />
		</jsp:include>

		<jsp:include page="../../common/inc/day2/day2DividendPaymentDetailsRO.jsp">
		 	<jsp:param value="${param.id}" name="legNumber" />
		</jsp:include>

		<jsp:include page="../../common/inc/day2/day2SettlementDetailsRO.jsp">
		 	<jsp:param value="${param.id}" name="legNumber" />
		</jsp:include>

		<jsp:include page="../../common/inc/day2/day2OtherConsiderationsRO.jsp">
		 	<jsp:param value="${param.id}" name="legNumber" />
		</jsp:include>
		
		<jsp:include page="/jsp/common/inc/legQualitativeAssessment.jsp">
			<jsp:param name="factor" value="Regulatory Risk,Finance Risk,Legal Governance Risk,Reputational Risk,Sovereign Risk" />
			<jsp:param name="id" value="${legNumber }"/>
		</jsp:include>
		<!-- attachments rca start of block -->
	    <jsp:include page="/jsp/common/attachments/legPageAttachments.jsp">
        	<jsp:param name="legIndex" value="${legNumber}" />
        	<jsp:param name="mode" value="edit" />
        </jsp:include>  
		    <!-- need to add param for the form to differentiate -->
		
	</c:otherwise>
</c:choose>




<input type="hidden" id="actionId" value="${actionId}">
