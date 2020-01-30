<%@taglib tagdir="/WEB-INF/tags/attachments" prefix="atmt" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://ge.com/icfp/taglibs/attachment-functions" prefix="atmtfunctions" %>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/attachments/attachmentOperations.js"></script>

<c:set var="attachmentCount" value="${atmtfunctions:getLegPageAttachmentsCount(1, pageContext.request)}" />

<c:set var="mode" value="${param.mode}" />

<div class="form-mod attachments-mod">
	<h2 class="span12 collapsible">Attachments - [
		<span id="${((not empty mode) && mode == 'edit') ? 'icfpAttachmentCount' : ''}" refreshURL="${pageContext.request.contextPath}/attachmentAction.do?command=getAttachmentCount&legIndex=${param.legIndex}">
			<c:if test="${attachmentCount ne 0}" >
				${attachmentCount}
			</c:if> 
		</span>
		] 
	</h2>
	<div class="clear"></div>
		<span class="sub">Attached documents appear below. Click on a document name to view or browse your computer to upload a replacement.</span>
		
		
	<atmt:cpaLegAttachments>
		<jsp:attribute name="mode">${mode}</jsp:attribute>
	</atmt:cpaLegAttachments>
</div>


