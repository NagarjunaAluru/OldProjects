<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="row highlighted">
	<div class="span12">
		<div class="form-row" style="margin-left: 0px;">
			<%-- Replace with the actual action types --%>
			<s:submit key="label.request.submitBidReply" cssClass="btn-primary submitBidReplyButton" id="sbSubmitBidReplyButton">
			</s:submit>
			<s:hidden id="actionTypeId" name="actionType" value="9"></s:hidden>
			<s:url id="homePageURL" action="cancel"/>
			<s:a href="%{homePageURL}" key="label.request.common.cancel" cssClass="btn-tertiary cancel" >
				<s:text name="label.request.common.cancel"></s:text>
			</s:a>
		</div>
	</div>
</div>