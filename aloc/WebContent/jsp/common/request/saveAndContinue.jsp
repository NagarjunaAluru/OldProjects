<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div class="row hide" id="floatDiv">
	<div class="span12">
		<p class="left">
		<s:hidden name="requestId" value="%{requestDetails.requestId}"/>
		<input type="hidden" name= "actionType" id="actionTypeId" />
		<input type="hidden" name= "sncWorkingSection" id="sncWorkingSectionId" value="${sncWorkingSection}"/>
			<s:submit action="saveAndContinue"
				key="label.request.saveAndContinue" cssClass="btn-secondary"
				cssStyle="margin-left: 20px;" onclick="javascript:submitAction(0);setWorkingSection();"/>

			<s:submit action="submitToReview" key="label.request.reviewAndSubmit"
				cssClass="btn-secondary" cssStyle="margin-left: 20px;" onclick="javascript:submitAction(0);"
				 />

			<s:submit action="saveAsDraft" key="label.request.saveAsDraft"
				cssClass="btn-secondary" cssStyle="margin-left: 20px;" onclick="javascript:submitAction(1);"/>
			<s:url action="cancel.action" namespace="/int/requestor"
				var="cancelBtnlURL" />
			<a href="<s:property value="#cancelBtnlURL" />"
				class="btn-tertiary cancel"><s:text
					name="label.request.common.cancel"></s:text></a>
		</p>
		<c:if test="${not empty requestDetails.lastSaveTime}">
		<p class="right" style="padding-right: 10px;">Last saved: <s:date name="requestDetails.lastSaveTime" format="MMM dd, yyyy - HH:mm aa zzz"/></p>
		</c:if>
	</div>
</div>