<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<script type="text/javascript">
$(document).ready(function() {
 	decCounter("deleteReasonId", 400);
});
</script>
	
<s:form id="deleteRequestForm" action="deleteRequest" namespace="/int/dashboard" onsubmit="return deleteSelRequestBtn();">
		<div class="modal-header">
			<a class="close" data-dismiss="modal">X</a>
			<h3><s:text name="label.dashboard.modal.header.deleteRequest" /><span></span></h3>
        </div>
        <div class="modal-body">
	        <c:if test="${amdRiderExist eq 'Y'}">
	        	<c:if test="${instrumentTypeId eq '1' or instrumentTypeId eq '2'}">
					<p><s:text name="alert.deleteRequest.amendmentFeespaid" /> </p>
				</c:if>
			</c:if>
			<c:if test="${(empty amdRiderExist or amdRiderExist eq 'N') && paymentsPaid eq 'Y'}">
					<p><s:text name="alert.deleteRequest.feesPaid" /> </p>
			</c:if>
			<c:if test="${(instrumentTypeId eq '3') || (empty amdRiderExist or amdRiderExist eq 'N') && (empty paymentsPaid or paymentsPaid eq 'N')}">
				<p><s:text name="label.dashboard.modal.body.deleteRequest" /> </p>
			</c:if>
		          	<p><s:text name="label.dashboard.modal.body.refNo" />
		          	<s:if test="%{amendmentId != null && amendmentId !=''}">
		          		<s:property value="amendmentId" />
		          	</s:if>
		          	<s:else>
		          		<s:property value="alocRecordId" />
		          	</s:else>
		          	</p>
		            <s:if test="%{bundleId != null && bundleId !=''}" >
		           		<p><s:text name="label.dashboard.modal.body.bundleID" /> <s:property value="bundleId" /></p>
		           	</s:if>
		     <c:choose>
		     <c:when test="${(instrumentTypeId eq '3') || (empty amdRiderExist or amdRiderExist eq 'N') && (empty paymentsPaid or paymentsPaid eq 'N')}">   
		     	<h3><s:text name="label.dashboard.modal.body.actionUndone" /></h3>
		        <div>
			    	<p class="deleteReasonError hide" style="color: #990000;"><s:text name="error.required.deleteRequest.deleteReason"/></p>
					<label><s:text name="label.dashboard.modal.body.deleteReason" /></label>
					<s:textarea name="deleteReason" theme="aloc" cssClass="autosize messageinput" 
					 onKeyPress="return imposeMaxLength(this, 399);" id="deleteReasonId" required="false"/>
		           	<div class="clear"></div>
		           	<div class="counter"><s:text name="label.request.fourHundred"/></div> <!-- fix positions -->
		           	<div class="counterTxt"><p class="guidance"><s:text name="label.request.textSize"/></p></div>
	           	</div>
			</c:when>
			<c:otherwise><s:text name="alert.deleteRequest.doYouContinue" /></c:otherwise>
			</c:choose>
			<s:hidden name="requestId" value="%{requestId}"></s:hidden>
		    <s:hidden name="stageName" value="%{stageName}"> </s:hidden>
			<s:hidden name="wfid" value="%{wfid}"> </s:hidden>
			<s:hidden name="queueName" value="%{queueName}"> </s:hidden>
			<s:hidden name="procedureName" value="%{procedureName}"> </s:hidden>
			<s:hidden name="workFlowstageId" value="%{workFlowstageId}"> </s:hidden>
			<s:hidden name="amendmentId" value="%{amendmentId}"> </s:hidden>
			<s:hidden name="instrumentTypeId" value="%{instrumentTypeId}"> </s:hidden>
			<s:hidden name="alocRecordId" value="%{alocRecordId}"> </s:hidden>
		</div>
		<div class="modal-footer">
			<c:if test="${instrumentTypeId != '3' && (amdRiderExist eq 'Y' or paymentsPaid eq 'Y')}">
				<a data-dismiss="modal" href="#" class="btn-primary" onclick="popUpDeleteRequestWithAmdRider();"><s:text name="label.request.common.yes"/></a>
				&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" class="btn-primary" onclick="closePopUpDeleteRequest();" ><s:text name="label.request.common.no"/></a>
			</c:if>
			<c:if test="${(instrumentTypeId eq '3') || (empty amdRiderExist or amdRiderExist eq 'N') && (empty paymentsPaid or paymentsPaid eq 'N')}">
				<sj:submit formIds="deleteRequestForm" value="Delete" cssClass="left btn-primary" onCompleteTopics="closePopUpDeleteRequest();" />
				<a href="#" class="btn-tertiary left cancel" onclick="closePopUpDeleteRequest();"><s:text name="label.dashboard.bundle.cancel"/></a>
			</c:if>
		</div>
</s:form>