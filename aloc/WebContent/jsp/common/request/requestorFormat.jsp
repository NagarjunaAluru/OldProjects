<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sjr" uri="/struts-jquery-richtext-tags"%>
<%@ taglib prefix="hwfs"  uri="/hwf-security-tags" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/attachments/attachmentOperations.js"></script>
<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/js/attachments/requestTinymce.js"></script> --%>	
<c:if test="${param.includeScripts != false}">
<%-- <script src="${pageContext.request.contextPath}/js/tiny_mce/plugins/ice/js/ice.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/tiny_mce/tiny_mce.js" type="text/javascript"></script> --%>	
<script	type="text/javascript">
	$(document).ready(function() {
		onloadFormatSelection();
		sendbackOnloadShow();
		
	});	
</script>
</c:if>
<s:if test="%{(requestDetails.WFDetails.WFStage == 'REQEST' || requestDetails.WFDetails.WFStage == 'REQUEST') && requestDetails.format.requiresEdits}">
			<div class="row">
				<div class="span12">
					<div class="errorbox">
						<div class="noteHead">
							<p class="noteicon">
								<s:text name="label.common.alert" />
							</p>
						</div>
						<div class="noteContent">
							<p>
								<s:property value="requestDetails.format.sendBackNotes" />
							</p>
						</div>
					</div>
				</div>
			</div>
</s:if>
 <jsp:include page="/jsp/common/request/requestFormat.jsp" />
		<!-- formatAdditional ends here --> 		