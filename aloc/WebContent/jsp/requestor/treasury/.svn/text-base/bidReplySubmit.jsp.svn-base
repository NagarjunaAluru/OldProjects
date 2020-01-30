<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="row smallrow highlighted">
    <c:if test="${param.suretBond != true }">
	<s:if test="%{requestDetails.bundleDetails != null && requestDetails.bundleDetails.bundleId != null }">
		<div class="row bidReplyWithBundleNotification" style="display: none;">
		            <div class="span12">
		            <div class="errorbox">
						<div class="noteHead"><p class="noteicon"><s:text name="label.common.alert"/></p></div>
						<div class="noteContent">
							<p><s:text name="label.request.bundleBidReplyAlert1"/> <s:property value="requestDetails.bundleDetails.bundleId"/>
							   <s:text name="label.request.bundleBidReplyAlert2"/></p>
						</div>
						</div>
		           </div>
		</div>
	</s:if>
</c:if>
	<div class="span12">
		<div class="form-row" style="margin-left: 0px;">
			<c:if test="${empty bidFlag or (not empty bidFlag and bidFlag eq '')}">
				<c:if test="${param.suretBond != true }">
				<s:if test="%{requestDetails.pendingBundleRequestCount == 0 || requestDetails.pendingBundleRequestCount == null}">
					<s:submit key="label.request.submitBidReply" cssClass="btn-primary submitBidReplyButton hide" id="submitBidReplyButton">
				</s:submit>
				</s:if>
				<s:else>
					<s:submit key="label.request.saveGotoNext"  cssClass="btn-primary saveGotoNextButton hide" id="saveGotoNextButton">
				</s:submit>
				</s:else>
				</c:if>
			</c:if>
			<c:if test="${empty bidFlag or (not empty bidFlag and bidFlag eq '')}">
				<c:if test="${param.suretBond == true }">
				<s:submit key="label.request.submitBidReply" cssClass="btn-primary submitBidReplyButton hide" id="submitBidReplyButton">
				</s:submit>
				</c:if>
			</c:if>
			<c:if test="${empty bidFlag or (not empty bidFlag and bidFlag eq '')}">
				<s:submit key="label.request.optOut"  cssClass="btn-primary optOutButton hide" id="optOutButton">
				</s:submit>
			</c:if>
			<s:url id="homePageURL" action="cancel"/>
			<s:a href="%{homePageURL}" key="label.request.common.cancel" cssClass="btn-tertiary cancel" >
				<s:text name="label.request.common.cancel"></s:text>
			</s:a>
			<s:hidden name="hours" value="%{hours}"></s:hidden>
			<s:hidden name="minutes" value="%{minutes}"></s:hidden>
			<s:hidden name="period" value="%{period}"></s:hidden>
			<s:hidden id="actionTypeId" name="actionType"></s:hidden>
			<s:hidden id="bidBundleId" name="requestDetails.bundleDetails.bundleId" value="%{requestDetails.bundleDetails.bundleId}"></s:hidden>
			<s:hidden id="bidBundleCount" name="requestDetails.pendingBundleRequestCount" value="%{requestDetails.pendingBundleRequestCount}"></s:hidden>
		</div>
	</div>
</div>