<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sjr" uri="/struts-jquery-richtext-tags"%>
<!DOCTYPE html>
<html>
<head>
 <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><s:text name="label.userannouncementmgmt.pageTitle" /></title>
<link href="${pageContext.request.contextPath}/css/others/toggle.css" rel="stylesheet">
<%@include file="../common/includeCommonScripts.jsp" %> 
<link href="${pageContext.request.contextPath}/css/common/user-announcement-mgmt.css" rel="stylesheet" type="text/css">
</head>
<s:url action="treasuryAdminPortal.action" namespace="/int/admin" var="cancelBtnlURL"/>
<s:url action="saveUserAnnouncementAttchments.action" namespace="/int/admin" var="uploadAttachmentsURL" />
<body>
<div class="container main" >
	<jsp:include page="../common/headerSection.jsp">
		<jsp:param name="createReqPopup" value="Yes"></jsp:param>
	</jsp:include>
	<h1 class="page-title span12"><s:text name="label.userannouncementmgmt.pageTitle" /></h1>
	<p class="span12 left clear dashdesc"><s:text name="label.userannouncementmgmt.pageSubTitle" /></p>        
	<hr class="page-title-hr">
	
	<s:form id="saveUserAnnouncementFormId" namespace="/int/admin"> 
	<span class="required-fields" style="margin-top: -35px!important;"><s:text name="label.request.common.allFieldsRequiredUnlessSpecified"/></span>
	<s:hidden name="userAnnouncementBo.model.userAnnouncementID" id="AnnouncementID"></s:hidden>
    <h3 class="small"><s:text name="label.userannouncementmgmt.messageContent"/></h3>
     
    <p>&nbsp;</p>   
   	 <div id="userannouncementAttachmentId">		
   		 <jsp:include page="/jsp/admin/userAnnouncementAttachment.jsp" />  			                  							 		       
	 </div>	 
	</s:form>
</div>

<div class="clear"></div> 
<div class="modal hide" id="uploadUserAnnouncementModel">
	<div class="modal-header">
		<a class="close" data-dismiss="modal">X</a>
		<h3><s:text name="label.userannouncementmgmt.uploadDocument"/></h3>		
	</div>
	<div class="modal-body">				
			<p><s:text name="label.userannouncementmgmt.uploadDocumentText"/></p>
			<div style="height:10px;"></div>
			<div class="alocAttachmentContainer">	
			<span style="color:red">
				<p class="errorMessage"></p>
				<br/>				
			</span>		
			 <p>				
			 	<input  type="file" class="alocFileupload" name="fileUpload" data-url="${pageContext.request.contextPath}/int/admin/uploadUserAnnouncementAtmt.action?typeId=4"/>
			 </p>	
			</div>
	</div>				
	 <div class="clear"></div>
	<div class="modal-footer">	
			<a href="#" class="btn-tertiary left cancel" data-dismiss="modal"><s:text name="label.treasuryAdminPortal.cancel"/></a>							                       
	</div>
</div>

<div class="modal hide fade" id="atmtConfirmModal">
<s:hidden id="userAnnouncementAtmtGeLibFileId" name="userAnnouncementAtmtGeLibFileId" value="" />
<s:hidden id="userAnnouncementAtmtIndex" name="userAnnouncementAtmtIndex" value="" />
	<div class="modal-header">
			<a class="close" data-dismiss="modal">X</a>
			<h3><span><s:text name="label.attachment.attachmentConfirm"/></span></h3>
	</div>
	<div class="modal-body" >
		<p><s:text name="label.attachment.attachmentConfirmMessage"/></p>
	</div>
	<div class="modal-footer">
			<a data-dismiss="modal" href="javascript:void(0);" onclick="deleteAtmtConfirm();" class="left btn-primary"  id="saveSelectionlb">
				 <s:text name="label.attachment.attachmentDeleteMessage"/>
				</a>	
			<a href="#" class="btn-tertiary left cancel" data-dismiss="modal"><s:text name="label.request.common.cancel" /></a>				
	</div>			
</div> 
<%@include file="../common/footerSection.jsp"%>
<jsp:include page="../admin/treasuryAdminExitPopup.jsp" />
</body>
</html>
