<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<div class="row">
	<div class="span12 request-summary">
		<p class="heading"><s:text name="label.request.requestSummary" /> -<span><s:text name="label.request.alocRecNo" /></span> <s:property value="requestDetails.alocRecordId" />
		</p>
			<div class="row lastrow">
			<div class="span1ab"><div class="right"><label><s:text name="label.request.requestorName" /></label></div></div>
				<div class="span5 left"><s:property	value="requestDetails.requestSummary.requestor.lastName" />,
 					<s:property value="requestDetails.requestSummary.requestor.firstName" /></div>
				</div>
	 		<div class="row">
		<div class="span1ab"><div class="right"><label><s:text name="label.request.requestorSSO" /></label></div></div>
	    <div class="span5 left"><s:property	value="requestDetails.requestSummary.requestor.ssoId" /></div>
	</div>				
	</div>
</div>