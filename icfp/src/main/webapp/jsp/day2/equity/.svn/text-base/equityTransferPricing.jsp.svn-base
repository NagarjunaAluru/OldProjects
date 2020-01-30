<%@taglib uri="http://ge.com/icfp/taglibs/deal-functions" prefix="deal"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://ge.com/icfp/taglibs/staticdata" prefix="staticdata" %>
<%@ taglib prefix="security"  uri="hwf-securitytag" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<fmt:setLocale value="en-US"/>
<t:common/>

<%String lastLeg = (String) request.getAttribute("proceedtoNextLeg");%>

<% String servletContextUrl = request.getContextPath();%>
<script type="text/javascript">  var contextURL = '<%=servletContextUrl%>'; </script>
<script src="<%=servletContextUrl%>/js/day2/day2Equity.js" type="text/javascript"></script>
<script src="<%=servletContextUrl%>/js/day2/equityDay2TransferPricing.js" type="text/javascript"></script>
 <%String nextLegNumber = (String) request.getAttribute("nextLegNumber");%>
<script type="text/javascript">
$(document).ready(function(){
	
	//Show next leg navigation based on lastLeg value
	
	
	  var nextLegNumberVar = '<%=nextLegNumber%>';
	  if(nextLegNumberVar!=null && nextLegNumberVar!="" && nextLegNumberVar!="null"){
	     $("#nextLegNumberID").val(nextLegNumberVar);
	  }
	
	 if(nextLegNumberVar<=0 )
	  {  
		 $("#savegotonextlegid").hide(); 
	   }else{
		 $("#savegotonextlegid").show(); 
	   }
	
});


//Embed Leg Seq ID in the save action request	
function saveTP(obj){
	
	$("#pageID").val(4);
	var actionType = $('input[name=saveEquityLeg]:radio:checked').val();
	if(actionType == 'saveNextLeg'){
		obj.form.action = contextURL + '/transferPricing/transferPricingOtherLeg.do?command=saveAndGoToNextLeg&id=' + ${param.id};
		obj.form.submit();
	}else if (actionType == 'saveandreturntodeal'){
		obj.form.action = contextURL + '/transferPricing/transferPricingOtherLeg.do?command=saveAndReturnToDeal&id=' + ${param.id};
		obj.form.submit();
	}else{
		$("#saveSpanID1").show();
		$("#saveSpanID2").show();
		return false;
	};	
		
}
</script>
<input type="hidden" name="legNbr" id="legNbrID"   value="${ param.id }">
 <input type="hidden" name="nextLegNumber"  id="nextLegNumberID"/>
<c:set var="equityLegSummary" value="${deal:fetchLegSummary(param.id, pageContext.request)}" scope="page"/>
<c:set var="legSummaryVO" value="${deal:fetchLegSummary(requestScope.legNumber, pageContext.request)}" scope="page"/>
<div class="row">
	<div class="span12">
		<h2>Leg ${legSummaryVO.legSeqId}</h2>
		<jsp:include page="../rca/currentLegdetails.jsp">
			<jsp:param name="id" value="${param.id}" />
		</jsp:include>
	</div>
</div>
<c:choose>
	<c:when test="${param.actionId eq 3}">
		<html:form action="/RCALegRequest.do" styleId="ICFPLegRequestForm" method="post" enctype="multipart/form-data">
		<input type="hidden" name="legNumber" value="${ param.id }">
		<input type="hidden" name="legSeqId" value="${legSummaryVO.legSeqId}" />
	<input type="hidden" name="isCPA" id="isCPA" value="no" />
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
						<span class="required"></span>
						<label>Comments</label>
						<div class="char-count">1000</div>
							<textarea class="xlarge autosize messageinput" name="otherEquityComments"	rows="4" id="dealCommentsId" data-max="1000" onblur="scriptInjection(this);">${requestScope.OtherComments}</textarea>
						</div>
				</div> <!-- end of block -->
			</div>

		<div class="form-mod">
		
				<jsp:include page="../../common/inc/commentsLog.jsp">
					<jsp:param name="formName" value="fourBlockerForm"/> 
					<jsp:param value="transferPricing/transferPricing" name="path"/>
			        <jsp:param value="Leg ${legSummaryVO.legSeqId}: Summary" name="name"/>
			        <jsp:param value="legDetails" name="method"/>
			        <jsp:param value="Transfer Pricing" name="origin"/>
			        <jsp:param value="${param.id}" name="legNumber"/>
				</jsp:include>
				
			<div class="row comment-container">
				<div class="span5">
					<div class="form-row autosize-container">
						<label>Comments</label>
						<div class="char-count">500</div>
						<html:textarea name="ICFPLegRequestForm" styleId="requestException" property="legSummary.comments" styleClass="xlarge autosize messageinput" rows="1" onblur="scriptInjection(this);" />
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
				<jsp:param value="transferPricing/transferPricing" name="path"/>
			    <jsp:param value="Leg ${legSummaryVO.legSeqId}: Summary" name="name"/>
			    <jsp:param value="legDetails" name="method"/>
			    <jsp:param value="Transfer Pricing" name="origin"/>
			    <jsp:param value="${param.id}" name="legNumber"/>			
		</jsp:include>

		<div class="span12 btn-container" style="margin-left:-10px!important;">
			<div class="span3 right submit-box">
				<div class="form-row">
					<span class="req-error" id="saveSpanID1" style="display: none;">a
					</span>
					<div class="radio-container">
						<label class="radio" style="color:#3A87AD;margin-bottom: 10px;" onmouseover="this.style.color='#348433'" onmouseout="this.style.color='#3A87AD'" id="savegotonextlegid">
							<input type="radio" name="saveEquityLeg" value="saveNextLeg"  class="condition">
							Save and go to next Leg
						</label>
						<span id="saveSpanID2" class="req-error" style="display: none;">a</span>
						<label class="radio"> <span id="saveSpanID"
							class="req-error" style="display: none;">a</span> <input
							type="radio" value="saveandreturntodeal"
							id="savereturndealradioID" name="saveEquityLeg"> Save and
							return to deal
						</label>
					</div>
				</div>

				<div id="actionButton">

					<button type="submit" name="command" value="saveLeg" id="submitID"
						onclick="javascript:saveTP(this);"
						class="btn btn-success btn-large"
						style="display: block; width: 100%;">Submit</button>
				</div>
			</div>
			<a class="btn right save-btn single" id="saveLegID"
				style="margin-top: 65px;" href="#">Save</a>
			<a style="margin-top: 75px" href="#confirm"
				class="btn-link right cancel modal-confirm" data-toggle="modal">Cancel</a>
		</div>
		<div class="modal hide fade" id="confirm">
			<div class="modal-header">
				<a class="close" href="javascript:closeConfirmModal()">X</a>
				<h3>Cancel Leg</h3>
			</div>
			<div class="modal-body" style="margin-top:-16px;">
				<div class="row">
					<p>
						<b>Are you sure you want to cancel?</b><br> Any changes you
						have made will be lost
					</p>
				</div>
			</div>
			<div class="modal-footer">
				<a href="${context}/transferPricing/transferPricing.do?command=load&DealRequestID=${sessionScope.deal.dealSeqId}" class="btn right btn-success">Yes, cancel the Leg</a>
				<a class="btn-link right cancel" href="javascript:closeConfirmModal()">No, take me back to the leg</a>
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
			
		<!-- attachments rca start of block -->
		  <jsp:include page="/jsp/common/attachments/legPageAttachments.jsp">
        	<jsp:param name="legIndex" value="${legNumber}" />
        	<jsp:param name="mode" value="edit" />
        </jsp:include>  
		    <!-- need to add param for the form to differentiate -->
		
		<jsp:include page="../../common/inc/auditLog.jsp">
			<jsp:param name="formName" value="ICFPLegRequestForm" />
			<jsp:param value="${param.source}" name="path"/>
			<jsp:param value="${param.origin}" name="origin"/>
			<jsp:param value="${param.source}" name="source"/>
			<jsp:param value="${param.name}" name="name"/>
		</jsp:include>
		
<div class="span8 right btn-container">
			<a onclick="history.back();" class="right cancel single" style="margin-top:95px">Cancel</a>
</div>
	</c:otherwise>
</c:choose>
