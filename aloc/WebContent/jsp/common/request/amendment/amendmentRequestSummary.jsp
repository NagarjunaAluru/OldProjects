<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${param.pageType eq 'CreateNewAmendment'}">
<div class="form-mod">		
	<div class="row">
		<div class="span12 request-summary">
			<p class="heading"><s:text name="label.request.requestSummary" /> - <span><s:text name="label.request.AlocRecordNo"/></span>
			<s:property value="requestDetails.alocRecordId" /></p>
			<div class="row lastrow">
				<div class="span22"><div class="right"><s:label key="label.request.requestorName"/></div></div>
				<div class="span2 left"><s:property value="requestDetails.requestSummary.requestor.lastName" />, <s:property value="requestDetails.requestSummary.requestor.firstName" /></div>
				<div class="span2a"><div class="right"><s:label key="label.amendment.seqNo"/></div></div>
				<div class="span2 left"><s:property value="requestDetails.amendment.amendmentRequestId" /></div>
				<div class="span2ab"><div class="right"><s:label key="label.amendment.bankRefNo" /></div></div>
				<div class="span1a left"><s:property value="requestDetails.amendment.bankReferenceNumber" /></div>
			</div>
			<div class="row">
				<div class="span22"><div class="right"><s:label key="label.request.requestorSSO"/></div></div>
				<div class="span3 left"><s:property value="requestDetails.requestSummary.requestor.ssoId" /></div>
				
			</div>				
		</div>
	</div>
</div>
</c:if>

<c:if test="${param.pageType eq 'ReSubmitAmendment'}">
<div class="form-mod">		
	<div class="row">
		<div class="span12 request-summary">
		<div class="row lastrow">
			<div class="span8"><p class="heading"><s:text name="label.request.requestSummary" /> - <span><s:text name="label.request.AlocRecordNo"/></span>
			<s:property value="requestDetails.alocRecordId" /></p></div>
        	<s:if test="%{requestDetails.requestSummary.modelCode !=null}">
				<div class="span2a"><div class="right"><label><s:text name="label.request.modelCode" />:</label></div></div>
				<div class="span1 left"><s:property value="requestDetails.requestSummary.modelCode" /></div>
			</s:if>
		</div>
			<div class="row lastrow">
				<div class="span22"><div class="right"><s:label key="label.request.requestorName"/></div></div>
				<div class="span2 left"><s:property value="requestDetails.requestSummary.requestor.lastName" />, <s:property value="requestDetails.requestSummary.requestor.firstName" /></div>
				<div class="span2a"><div class="right"><s:label key="label.request.instrumentPurpose"/> </div></div>
				<div class="span1 left"><s:property value="requestDetails.transactionParties.instrumentPurpose"/></div>
				<div class="span2a"><div class="right"> <s:label key="label.amendment.seqNo"/> </div></div>
				<div class="span1a left"><s:property value="requestDetails.amendment.amendmentRequestId" /></div>
			</div>
			<div class="row lastrow">
				<div class="span22"><div class="right"><s:label key="label.request.requestorSSO"/></div></div>
				<div class="span3 left"><s:property value="requestDetails.requestSummary.requestor.ssoId" /></div>
			</div>
			<div class="row">
				<div class="span22"><div class="right"><label>Returned by:</label></div></div>
				<div class="span2 left"><s:property value="requestDetails.actionLogs[0].approverLastName" />, <s:property value="requestDetails.actionLogs[0].approverFirstName" /></div>
				<div class="span2a"><div class="right"><label><s:text name="label.request.reasonForReturn"/>:</label></div></div>
				<div class="span5 left" style="word-wrap:break-word;"><s:property value="requestDetails.actionLogs[0].reasonForRejection" /></div>
			</div>				
		</div>
	</div>
</div>
</c:if>





