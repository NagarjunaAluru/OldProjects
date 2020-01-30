<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<div class="modal hide" id="uploadUserAnnouncementModel">
	<div class="modal-header">
		<a class="close" data-dismiss="modal">X</a>
		<h3><s:text name="label.userannouncementmgmt.uploadDocument"/></h3>		
	</div>
	<div class="modal-body">		
		<s:form id="uploadAtmtFormId" action="saveUserAnnouncementAttchments" namespace="/int/admin" enctype="multipart/form-data"> 
			<p><s:text name="label.userannouncementmgmt.uploadDocumentText"/></p>
			<div style="height:10px;"></div> 
			<div class="form-row">							
				 <s:file key="label.userannouncementmgmt.uploadDocument" name="userAnnouncementBO.attachmentBOList[0].uploadFiles" class="input-file-attach span4" theme="aloc" />
				     <s:if test="hasActionErrors()">
						<div class="row">
							<label style="color: red; width: 100%;"><s:actionerror/></label>
						</div>
					</s:if>     			
			</div>
		 </s:form>
	</div>				
	 <div class="clear"></div>
	<div class="modal-footer">	
			<sj:submit formIds="uploadAtmtFormId" value="Upload" cssClass="btn left" />			
			<a href="#" class="btn-tertiary left cancel" data-dismiss="modal"><s:text name="label.treasuryAdminPortal.cancel"/></a>							                       
	</div>
</div>