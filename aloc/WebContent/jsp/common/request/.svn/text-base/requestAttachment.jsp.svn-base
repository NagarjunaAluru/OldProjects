<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<s:if test="%{(requestDetails.WFDetails.WFStage == 'REQEST' || requestDetails.WFDetails.WFStage == 'REQUEST') && requestDetails.attachments[0].requiresEdits}">
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
								<s:property value="requestDetails.attachments[0].sendBackNotes" />
							</p>
						</div>
					</div>
				</div>
			</div>
</s:if>
 <div style=color:red;>    
		<s:fielderror fieldName="requestDetailsBO.attachmentBOList" />       				
 </div>  
	<p class="span12 left clear dashdesc1">		
		<s:text name="label.attachment.header" />
	</p>	  
	<br />		  		
	<s:text name="label.attachment.subHeader" />
	<div class="row">
		<div class="span12">							
				<jsp:include page="/jsp/common/attachmentRefresh.jsp" />																	
		</div>
	</div>	
		<!-- Attachment Error Modal -->
<div class="modal hide fade" id="attachmentErrorModal" style="top:200px;">
		<div class="modal-header">
			<a class="close" data-dismiss="modal">X</a>
			<h3><span><s:text name="label.attachment.attachmentError"/></span></h3>
		</div>
		<div class="modal-body">
			<p></p>
		</div>
		<div class="modal-footer">
			<a href="#" class="btn-tertiary left cancel" data-dismiss="modal"><s:text name="label.request.common.cancel" /></a>				
		</div>			
</div> 