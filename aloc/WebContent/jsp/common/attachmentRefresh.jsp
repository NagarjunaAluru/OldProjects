<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/attachments/attachmentOperations.js"></script>
	<s:hidden name="atmtInstrumentTypeId" id="atmtInstrumentTypeId"  value="%{requestDetailsBO.model.instrumentTypeId}"/>	
<div id="attachmnetRefresh">

	<table class="table table-striped table-bordered attachment" id="attachmentsTableId">
		<thead> 
			<tr class="spantr1">
			<th colspan="1" class="spantd1"><p style="padding-left: 10px;">
						<s:text name="label.attachment.actions" />
					</p></th>
				<th colspan="1" class="spantd2"><p style="padding-left: 10px;">
				<s:text name="label.attachment.permissions"/>
					<c:if test="${requestDetailsBO.model.instrumentTypeId eq '3' || requestDetailsBO.model.instrumentTypeId eq '6'}">
					<span class="ttip info" data-original-title="<s:text  name="label.attachment.tooltip.suretyPermissionsInfo"/>"></span>	
					</c:if>	
					<c:if test="${requestDetailsBO.model.instrumentTypeId eq '1' || requestDetailsBO.model.instrumentTypeId eq '2' || requestDetailsBO.model.instrumentTypeId eq '5' || requestDetailsBO.model.instrumentTypeId eq '4'}">
						<span class="ttip info" data-original-title="<s:text  name="label.attachment.tooltip.bankPermissionsInfo"/>"></span>	
					</c:if>								
				</p></th>
				<th colspan="1" class="spantd3"><p style="padding-left: 10px;">
						<s:text name="label.attachment.documents"/>
					</p></th>
			</tr> 
		</thead>
		<tbody>
			<s:if test="%{requestDetailsBO.attachmentBOList != null && requestDetailsBO.attachmentBOList.size > 0}">
				<s:iterator value="requestDetailsBO.attachmentBOList" status="atmtBOItrStatus">
					<tr class="spantr2">
						<td>
						<s:if test="%{model.geFileId !=null && model.geFileId !=0}">
							<div class="alocDeleteAttachmentContainer">	 						
								<div class="alocDeleteAttachment">		
									<p style="padding: 0px 0 0 10px;">														
										<a href='javascript:void(0)' class="delete-tr-hide"
											onclick="javascript:deleteAttachment(<s:property value="model.geFileId"/>,'2',<s:property value="#atmtBOItrStatus.index"/>)">											
										</a> &nbsp;
									</p>						
								</div>
							</div>						
						</s:if>
						<s:else>
						<div class="alocDeleteAttachmentContainer">	 						
							<div class="alocDeleteAttachment">								
								<p style="padding: 0px 0 0 10px;">--</p>	
							</div>
						</div>
						</s:else>
					</td>		
						<td>
							<div class="form-row">
								<p style="padding: 0px 0 0 5px;">
									<c:if test="${requestDetailsBO.model.instrumentTypeId eq '3' || requestDetailsBO.model.instrumentTypeId eq '6'}">
										<s:checkbox label="%{getText('label.attachment.surety')}"
											theme="aloc"
											name="requestDetailsBO.attachmentBOList[%{#atmtBOItrStatus.index}].suretyPermission" cssClass="bankOrSuretyAtmtPermission"  id="bankOrSuretyAtmtPermission%{#atmtBOItrStatus.index}"											
											onclick="javascript:checkAtmtPermissions(%{#atmtBOItrStatus.index})" />
									</c:if>
									<c:if
										test="${requestDetailsBO.model.instrumentTypeId eq '1' || requestDetailsBO.model.instrumentTypeId eq '2' || requestDetailsBO.model.instrumentTypeId eq '5' || requestDetailsBO.model.instrumentTypeId eq '4'}">
										<s:checkbox label="%{getText('label.attachment.bank')}"
											theme="aloc"
											name="requestDetailsBO.attachmentBOList[%{#atmtBOItrStatus.index}].bankPermission" cssClass="bankOrSuretyAtmtPermission" id="bankOrSuretyAtmtPermission%{#atmtBOItrStatus.index}"
											onclick="javascript:checkAtmtPermissions(%{#atmtBOItrStatus.index})"/>
									</c:if>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <s:checkbox label="%{getText('label.attachment.treasury')}" 
										theme="aloc"
										name="requestDetailsBO.attachmentBOList[%{#atmtBOItrStatus.index}].treasuryPermission" cssClass="treasuryAtmtPermission" id="treasuryAtmtPermission%{#atmtBOItrStatus.index}"/>  									
								</p>
							</div>
						</td>
						<td>
							<div class="alocAttachmentContainer">
								<p>
									<input type="file" class="alocFileupload" name="fileUpload"
										data-url="${pageContext.request.contextPath}/int/atmt/upload.action?typeId=2&index=<s:property value="%{#atmtBOItrStatus.index}"/>" />
								</p>
								<div class="alocAttachment">
									<s:if test="%{model.geFileId !=null && model.geFileId !=0}">
										<s:url id="fileDownload" action="download.action"
											namespace="/int/atmt">
											<s:param name="geLibFileId" value="model.geFileId" />											
											<s:param name="typeId" value="2" />
											<s:param name="index" value="%{#atmtBOItrStatus.index}" />
										</s:url>
										<s:a href="%{fileDownload}">
											<s:property value="model.attachmentOriginalName" />
										</s:a>
									</s:if>
								</div>
							</div>
						</td>
					</tr>
				</s:iterator>				
				<s:hidden id="newAttachmentIndex" name="newAttachmentIndex" value="%{requestDetailsBO.attachmentBOList.size}" />
				<s:hidden id="atmtTypeId" name="atmtTypeId" value="2" />
				<s:hidden id="instrumentTypeId" name="instrumentTypeId" value="%{requestDetailsBO.model.instrumentTypeId}" />
			</s:if>
			<s:else>
				<tr class="spantr2">
					<td>						
						<div class="alocDeleteAttachmentContainer">	 						
							<div class="alocDeleteAttachment">								
								<p style="padding: 0px 0 0 10px;">--</p> 
							</div>
						</div>
					</td>
					<td>
						<div class="form-row">
							<p style="align: left; padding: 0px 0 0 10px;">
								<c:if test="${requestDetailsBO.model.instrumentTypeId eq '3' || requestDetailsBO.model.instrumentTypeId eq '6'}">
									<s:checkbox label="%{getText('label.attachment.surety')}"
										theme="aloc"
										name="requestDetailsBO.attachmentBOList[0].suretyPermission" cssClass="bankOrSuretyAtmtPermission" id="bankOrSuretyAtmtPermission0" onclick="javascript:checkAtmtPermissions(0)"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								</c:if>
								<c:if
									test="${requestDetailsBO.model.instrumentTypeId eq '1' || requestDetailsBO.model.instrumentTypeId eq '2' || requestDetailsBO.model.instrumentTypeId eq '5' || requestDetailsBO.model.instrumentTypeId eq '4'}">
									<s:checkbox label="%{getText('label.attachment.bank')}"
										theme="aloc"
										name="requestDetailsBO.attachmentBOList[0].bankPermission" cssClass="bankOrSuretyAtmtPermission" id="bankOrSuretyAtmtPermission0" onclick="javascript:checkAtmtPermissions(0)"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								</c:if>
								<s:checkbox label="%{getText('label.attachment.treasury')}"
									theme="aloc"
									name="requestDetailsBO.attachmentBOList[0].treasuryPermission" cssClass="treasuryAtmtPermission" id="treasuryAtmtPermission0" />								
							</p>
						</div>
					</td>
					<td>
						<div class="alocAttachmentContainer">
							<p>
								<input type="file" class="alocFileupload" name="fileUpload"
									data-url="${pageContext.request.contextPath}/int/atmt/upload.action?typeId=2&index=0&formatId=" />
							</p>
							<div class="alocAttachment"></div>
						</div>
					</td>
				</tr>
				<s:hidden id="newAttachmentIndex" name="newAttachmentIndex" value="1" />
				<s:hidden id="atmtTypeId" name="atmtTypeId" value="2" />
				<s:hidden id="instrumentTypeId" name="instrumentTypeId" value="%{requestDetailsBO.model.instrumentTypeId}" />
			</s:else>
		</tbody>
	</table>
	<s:if test="%{requestDetailsBO.attachmentBOList.size < 5 }">	
			<a href="javascript:;" class="left add-attachment add" id="addAttachment"> <s:text	name="label.attachment.addAdditionalAttachment" /></a>
	</s:if>
</div>
<!-- Attachment Delete Confirmation Modal -->
<div class="modal hide fade" id="atmtConfirmModal">
<s:hidden id="modelGeLibFileId" name="modelGeLibFileId" value="" />
<s:hidden id="modelTypeId" name="modelTypeId" value="" />
<s:hidden id="modalIndex" name="modalIndex" value="" />
		<div class="modal-header">
			<a class="close" data-dismiss="modal">X</a>
			<h3><span><s:text name="label.attachment.attachmentConfirm"/></span></h3>
		</div>
		<div class="modal-body">
			<p><s:text name="label.attachment.attachmentConfirmMessage"/></p>
		</div>
		<div class="modal-footer">
			<a data-dismiss="modal" href="javascript:void(0);" onclick="deleteConfirm();" class="left btn-primary"  id="saveSelectionlb">
				 <s:text name="label.attachment.attachmentDeleteMessage"/>
				</a>	
			<a href="#" class="btn-tertiary left cancel" data-dismiss="modal"><s:text name="label.request.common.cancel" /></a>				
		</div>			
</div> 		

<div class="modal hide fade" id="atmtPermissionsConfirmModal">
<s:hidden id="permissionsIndexId" name="permissionsIndexId" value="" />
			<div class="modal-header"> 
				<a class="close" data-dismiss="modal">X</a>
				<h3><span><s:text name="label.attachment.attachmentPermissionsConfirm"/></span></h3>
			</div>  
			<div class="modal-body">
				<p id="bankPermissionsTestId"><s:text name="label.attachment.attachmentPermissionsConfirmBankAlert"/></p> 
				<p id="suretyPermissionsTestId"><s:text name="label.attachment.attachmentPermissionsConfirmSuretyAlert"/></p> 
			</div>
			<div class="modal-footer">
				<a data-dismiss="modal" href="#" class="left btn-primary" id="yesId"><s:text name="label.request.common.yes"/></a>
				<a data-dismiss="modal" href="javascript:void(0);" onclick="atmtPermissionsConfim();" class="btn-tertiary left cancel"  id="yesId">
					 <s:text name="label.request.common.cancel" />
				</a>						
			</div>			
	</div> 