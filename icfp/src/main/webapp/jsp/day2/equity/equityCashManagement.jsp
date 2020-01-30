<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>
<t:common/>
<%String lastLeg = (String) request.getAttribute("proceedtoNextLeg");%>

<% String servletContextUrl = request.getContextPath();%>


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

<script type="text/javascript">
//Show next leg navigation based on lastLeg value
//it needs the JSP variable so placed in JSP file
$(document).ready(function() {
	var lastLegVar = '<%=lastLeg%>';
	if(lastLegVar=='yes'){
		$('#reviewNextLegID').hide();
	}else {
		$('#reviewNextLegID').show();
	}
});

</script>
<script type="text/javascript" src="${context}/js/day2/equityCashManagement.js"></script>
<c:set var="legSummaryVO" value="${deal:fetchLegSummary(requestScope.legNumber, pageContext.request)}" scope="page"/>
<div class="row">
	<div class="span12">
		<h2>Leg ${legSummaryVO.legSeqId}</h2>
		<jsp:include page="currentLegdetails.jsp">
			<jsp:param name="id" value="${param.id}" />
		</jsp:include>
	</div>
</div>

<c:choose>
	<c:when test="${param.actionId eq param.activeId}">
	
		
	
		<form action="${context}${action}" id="legSummary" method="post" enctype="multipart/form-data">

			<input type="hidden" name="legNumber" value="${ requestScope.legNumber }"/>
			<input type="hidden" name="legSeqId" value="${legSummaryVO.legSeqId}" />

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
			
			<jsp:include page="../../common/inc/qualitativeAssessment_LegSummary.jsp">
				<jsp:param name="factors" value="${factors}"/>
				<jsp:param value="Equity" name="legType"/>			
			</jsp:include>

			<div class="form-mod">
				
				<jsp:include page="../../common/inc/commentsLog.jsp">
					<jsp:param name="formName" value="fourBlockerForm" />
					<jsp:param value="${param.source}" name="path"/>
					<jsp:param value="${param.origin}" name="origin"/>
					<jsp:param value="${param.source}" name="source"/>
					<jsp:param value="${param.name}" name="name"/>
				</jsp:include>
				
				<div class="row comment-container">
					<div class="span5">
						<div class="form-row autosize-container">
							<label>Comments</label>
							<div class="char-count">500</div>
								<textarea class="xlarge autosize messageinput" name="lComments"	rows="4" onblur="scriptInjection(this);">${legSummaryVO.comments}</textarea>
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
				<jsp:param name="formName" value="fourBlockerForm"/>
				<jsp:param value="${param.source}" name="path"/>
				<jsp:param value="${param.origin}" name="origin"/>
				<jsp:param value="${param.source}" name="source"/>
				<jsp:param value="${param.name}" name="name"/>
			</jsp:include>

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
				
				<input type="button" value="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Submit&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" class="btn btn-success btn-large" onclick="javascript:save(this,'${action}');">
			</div>
			<input type="hidden" name="pType" value="${legSummaryVO.productType}">

			<c:choose>
				<c:when test="${requestScope.proceedtoNextLeg ne 'yes'}">
					<a id="saveLeg1" class="btn right save-btn single" onclick="javascript:saveBut(this,'${action}');" style="margin-top: 85px;">Save</a>
					<a href="#confirm" class="btn-link right cancel modal-confirm" data-toggle="modal" style="margin-top:95px">Cancel</a>
				</c:when>
				<c:otherwise>
					<a id="saveLeg1" class="btn right save-btn single" onclick="javascript:saveBut(this,'${action}');" style="margin-top: 60px;">Save</a>
					<a href="#confirm" class="btn-link right cancel modal-confirm" data-toggle="modal" style="margin-top:70px">Cancel</a>
				</c:otherwise>
			</c:choose>
			
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
			<a onclick="history.back();" class="btn right btn-success">Yes, cancel the Leg</a>
			<a class="btn-link right cancel" href="javascript:closeConfirmModal()">No, take me back to the Leg</a>
		</div>
      </div>
      
		</form>
		
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
		
		<h3 class="span12">Description</h3>
			<div class="row comment-container">
				<div class="span5">
					<div class="form-row autosize-container">
						<label>Comments</label>
						<div class="char-count">1000</div>
							<textarea readonly="readonly" class="xlarge autosize messageinput" name="otherEquityComments"	rows="4" id="dealCommentsId" data-max="1000">${deal:getOtherEquityComments(requestScope.legNumber, pageContext.request)}</textarea>
						</div>
				</div> <!-- end of block -->
			</div>
			
		<c:if test="${param.page eq 'cashManagement'}">
			<jsp:include page="../../common/inc/legQualitativeAssessment.jsp">
				<jsp:param name="factor" value="Operational Risk - Initial" />
			</jsp:include>
		</c:if>
		<c:if test="${param.page eq 'treasuryLegal'}">
			<jsp:include page="../../common/inc/legQualitativeAssessment.jsp">
				<jsp:param name="factor" value="Legal Risk" />
			</jsp:include>
		</c:if>
		<c:if test="${param.page eq 'treasuryTax'}">
			<jsp:include page="../../common/inc/legQualitativeAssessment.jsp">
				<jsp:param name="factor" value="Tax Risk" />
			</jsp:include>
		</c:if>
		<c:if test="${param.page eq 'middleOffice'}">
			<jsp:include page="../../common/inc/legQualitativeAssessment.jsp">
				<jsp:param name="factor" value="Operational Risk - Ongoing" />
			</jsp:include>
		</c:if>

<%-- 		<jsp:include page="../../common/inc/commentsLog.jsp">
			<jsp:param name="formName" value="fourBlockerForm"/>			
		</jsp:include>
 --%>
			<!-- starts uploads-->
			<jsp:include page="/jsp/common/attachments/legPageAttachments.jsp">
			<jsp:param name="mode" value="edit" />
				<jsp:param name="legIndex" value="${legNumber}" />
			</jsp:include>  
			<!-- end uploads -->
		    
		<jsp:include page="../../common/inc/auditLog.jsp">
			<jsp:param name="formName" value="ICFPLegRequestForm" />
			<jsp:param value="${param.source}" name="path"/>
			<jsp:param value="${param.origin}" name="origin"/>
			<jsp:param value="${param.source}" name="source"/>
			<jsp:param value="${param.name}" name="name"/>
		</jsp:include>
		
		<a onclick="history.back();" class="right cancel single" style="margin-top:95px">Cancel</a>

	</c:otherwise>
</c:choose>