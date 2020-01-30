<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<div class="form-mod">
	<div id="requestSummary">
		<p class="heading"><strong><s:text name="label.request.requestSummary" /></strong> - <span><s:text name="label.request.alocRecNo" /></span>
	<strong><c:out value="${requestDetails.alocRecordId}" /></strong></p>
		<div class="row lastrow">
			<div class="span1ab"><div class="right"><label><s:text name="label.request.requestorName" /></label></div></div>
				<div class="span5 left"><c:out	value="${requestDetails.requestSummary.requestor.lastName}" />,
 					<c:out value="${requestDetails.requestSummary.requestor.firstName}" /></div>
				</div>
	 		<div class="row">
		<div class="span1ab"><div class="right"><label><s:text name="label.request.requestorSSO" /></label></div></div>
	    <div class="span5 left"><c:out	value="${requestDetails.requestSummary.requestor.ssoId}" /></div>
	</div>				
	</div>
</div>