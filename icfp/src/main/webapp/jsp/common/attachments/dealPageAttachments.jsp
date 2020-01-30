<%@taglib tagdir="/WEB-INF/tags/attachments" prefix="atmt" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://ge.com/icfp/taglibs/attachment-functions" prefix="atmtfunctions" %>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/attachments/attachmentOperations.js"></script>

<c:choose>
	<c:when test="${fn:toUpperCase(param.mode) == 'VIEW' and atmtfunctions:getDealPermissions(pageContext.request).pipelineReview == true}">
		<c:set var="mode" value="edit" />
	</c:when>
	<c:otherwise>
		<c:set var="mode" value="${param.mode}" />
	</c:otherwise>
</c:choose>

<c:if test="param.mode">
</c:if>

<c:set var="attachmentCount" value="${atmtfunctions:getDealPageAttachmentsCount(pageContext.request)}" />

<div class="form-mod attachments-mod">
	<h2 class="span12 collapsible">Attachments -[
		<span id="icfpAttachmentCount" refreshURL="${pageContext.request.contextPath}/attachmentAction.do?command=getAttachmentCount">
			<c:if test="${attachmentCount ne 0}" >
				${attachmentCount}
			</c:if> 
		</span>] 
	</h2>
	<div class="clear"></div>
		<span class="sub">Attached documents appear below. Click on a document name to view or browse your computer to upload a replacement.</span>
		
		<atmt:dealAttachments>
			<jsp:attribute name="mode">${mode}</jsp:attribute>
		</atmt:dealAttachments>
		
		<atmt:allLegsAttachments>
			<jsp:attribute name="mode">${mode}</jsp:attribute>
		</atmt:allLegsAttachments>
</div>
