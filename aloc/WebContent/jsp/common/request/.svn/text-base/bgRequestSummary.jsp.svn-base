<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="form-mod">
		 <!-- REQUEST SUMMARY -->
	<div id="requestSummary">
    	<div class="leftColRS">
        	<p><strong><s:text name="label.request.requestSummary"/></strong>
        	<c:if test="${not empty requestDetails.requestId}">
        	 - <s:text name="label.request.alocRecNo"/> <strong><c:out value="${requestDetails.alocRecordId}"/></strong>
        	</c:if>
        	</p>
            <label class="leftRS"><s:text name="label.request.requestorName"/></label> <label class="rightRS"><c:out value="${requestDetails.requestSummary.requestor.lastName}"/>,<c:out value="${requestDetails.requestSummary.requestor.firstName}"/></label>
            <label class="leftRS clear"><s:text name="label.request.requestorSSO"/></label> <label class="rightRS"><c:out value="${requestDetails.requestSummary.requestor.ssoId}"/></label>
        </div><!-- leftColRS ends here -->
        <div class="rightColRS" style="width:300px;">
            <s:if test="%{requestDetails.requestSummary.modelCode !=null}">
        	<s:text name="label.request.modelCode" />: <c:out value="${requestDetails.requestSummary.modelCode}" />
        	</s:if>
        </div>
        <div class="clear"></div>
    </div><!-- requestSummary ends here -->
</div>