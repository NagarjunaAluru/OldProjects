<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="hwfs" uri="/hwf-security-tags"%>
<script type="text/javascript">
  var contextURL = "${pageContext.request.contextPath}";
</script>
<s:url action="cancel.action" namespace="/ext/approver" var="cancelBtnlURL"/>  
<script type="text/javascript" src="${pageContext.request.contextPath}/ext/public/js/ext/attachmentOperations.js"></script>
<div style="color: red;">
	<s:fielderror fieldName="requestDetailsBO.attachmentBOList.attachments" />		
</div>

<h2 class="acc_triggerExtra"><s:text name="label.request.bglocSectionName.9" /></h2><hr class="h2-hr">
<%--  - &#60;
<s:if test="%{requestDetailsBO.attachmentBOList != null && requestDetailsBO.attachmentBOList[0].model.geFileId!= null}">
<s:property value="requestDetailsBO.attachmentBOList.size" />
</s:if>
<s:else><s:property value="0" />
</s:else>
&#62;		 --%>
<br/>
<p class="span12 left clear dashdesc1">	<s:text name="label.attachment.header" /></p>	
<div class="acc_container4"> 
<label class="optional"> <s:text name="label.attachment.subHeader" /></label>
<div class="row">
	<div class="span12">
			<table class="table table-striped table-bordered sortable attachment">
			<thead>
				<tr>
					<th colspan="1" class="spantd1"><p style="padding-left: 10px;">
							<s:text name="label.request.action" />
						</p></th>
					<th colspan="1" class="spantd2"><p style="padding-left: 10px;">
							<s:text name="label.attachment.permissions" />
							<c:if test="${requestDetails.instrumentTypeId eq '3'}">
								<span class="ttip info"
									data-original-title="<s:text  name="label.attachment.tooltip.suretyPermissionsInfo"/>"></span>
							</c:if>
							<c:if
								test="${requestDetails.instrumentTypeId eq '1' || requestDetails.instrumentTypeId eq '2' || requestDetails.instrumentTypeId eq '5' || requestDetails.instrumentTypeId eq '4'}">
								<span class="ttip info"
									data-original-title="<s:text  name="label.attachment.tooltip.bankPermissionsInfo"/>"></span>
							</c:if>
						</p></th>
					<th colspan="1" class="spantd2"><p style="padding-left: 10px;">
							<s:text name="label.request.uploadDescription" />
						</p></th>
					<th colspan="1" class="spantd3"><p style="padding-left: 10px;">
							<s:text name="label.attachment.documents" />
						</p></th>
				</tr>
			</thead>
			<tbody>
				<s:if test="%{requestDetailsBO.attachmentBOList != null && requestDetailsBO.attachmentBOList.size>0}">
					<s:iterator value="requestDetailsBO.attachmentBOList" status="atmtBOItrStatus">					
						<tr>
							<td>
								<div class="alocDeleteAttachmentContainer">
									<div class="alocDeleteAttachment">
										<p style="padding: 10px 0 0 10px;">
											<s:if test="%{model.geFileId !=null && model.geFileId !=0}"> 									
												<a href='javascript:void(0)' onclick="javascript:deleteAttachment('<s:property value="model.geFileId"/>','4','<s:property value="#atmtBOItrStatus.index"/>')">
												 <s:text name="label.request.clear" />
												</a>
											</s:if>
											<s:else>
												<a href='javascript:clearClosureData()'><s:text name="label.request.clear" /> </a>													
											</s:else> 									
										</p>
									</div>
								</div>
							</td>
							<td>
								<div class="form-row">
									<p style="padding: 5px 0 0 5px;">
										<c:if
											test="${requestDetailsBO.model.instrumentTypeId eq '3' || requestDetailsBO.model.instrumentTypeId eq '6'}">
											<s:checkbox label="%{getText('label.attachment.surety')}"
												theme="aloc"
												name="requestDetailsBO.attachmentBOList[%{#atmtBOItrStatus.index}].suretyPermission"
												cssClass="bankOrSuretyAtmtPermission" />
										</c:if>
										<c:if
											test="${requestDetailsBO.model.instrumentTypeId eq '1' || requestDetailsBO.model.instrumentTypeId eq '2' || requestDetailsBO.model.instrumentTypeId eq '5' || requestDetailsBO.model.instrumentTypeId eq '4'}">
											<s:checkbox label="%{getText('label.attachment.bank')}"
												theme="aloc"
												name="requestDetailsBO.attachmentBOList[%{#atmtBOItrStatus.index}].bankPermission"
												cssClass="bankOrSuretyAtmtPermission" />
										</c:if>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<s:checkbox label="%{getText('label.attachment.treasury')}"
											theme="aloc"
											name="requestDetailsBO.attachmentBOList[%{#atmtBOItrStatus.index}].treasuryPermission"
											cssClass="treasuryAtmtPermission" />
									</p>
								</div>
							</td>
							<td>
							<s:textarea style="resize: none; overflow-y: hidden;"
								cssClass="autosize1 messageinput" 
								name="requestDetailsBO.attachmentBOList[%{#atmtBOItrStatus.index}].issuanceDesc"
								cols="50" rows="2" id="closureUploadDescription" theme="aloc"
								onkeypress="return imposeMaxLength(this, 99);"></s:textarea> 
							<div class="clear"></div>
							<div class="counter closureCounter">100</div> <!-- fix positions -->
							<div class="counterTxt span4"><p class="guidance"><s:text name="label.request.characters" /></p>	
								</div></td>
							<td>
								<div class="alocAttachmentContainer">
									<hwfs:checkComponentPermission name="NotBankBrokerReadOnly" domainName="BusinessAccess">
										<p>
											<input type="file" class="alocFileupload" name="fileUpload"
												data-url="${pageContext.request.contextPath}/ext/atmt/upload.action?typeId=4&index=<s:property value="%{#atmtBOItrStatus.index}"/>" />
										</p>
									</hwfs:checkComponentPermission>
									<div class="alocAttachment">
										<s:if test="%{model.geFileId!= null && model.geFileId !=0}">										
											<s:url id="fileDownload" action="download.action"
												namespace="/ext/atmt">
												<s:param name="geLibFileId" value="model.geFileId" />
												<s:param name="typeId" value="4" />
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
				</s:if>
				<s:else>
					<tr>
						<td>
							<div class="alocDeleteAttachmentContainer">
								<div class="alocDeleteAttachment">
									<p style="padding: 10px 0 0 10px;"><a href='javascript:clearClosureData()'><s:text name="label.request.clear" /> </a></p>
								</div>
							</div>
						</td>
						<td>
							<div class="form-row">
								<p style="padding: 5px 0 0 5px;">
									<c:if
										test="${requestDetailsBO.model.instrumentTypeId eq '3' || requestDetailsBO.model.instrumentTypeId eq '6'}">
										<s:checkbox label="%{getText('label.attachment.surety')}"
											theme="aloc"
											name="requestDetailsBO.attachmentBOList[0].suretyPermission"
											cssClass="bankOrSuretyAtmtPermission" />
									</c:if>
									<c:if
										test="${requestDetailsBO.model.instrumentTypeId eq '1' || requestDetailsBO.model.instrumentTypeId eq '2' || requestDetailsBO.model.instrumentTypeId eq '5' || requestDetailsBO.model.instrumentTypeId eq '4'}">
										<s:checkbox label="%{getText('label.attachment.bank')}"
											theme="aloc"
											name="requestDetailsBO.attachmentBOList[0].bankPermission"
											cssClass="bankOrSuretyAtmtPermission" />
									</c:if>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<s:checkbox label="%{getText('label.attachment.treasury')}"
										theme="aloc"
										name="requestDetailsBO.attachmentBOList[0].treasuryPermission"
										cssClass="treasuryAtmtPermission" />
								</p>
							</div>
						</td>
						<td>																							
				              <s:textarea style="resize: none; overflow-y: hidden;"
								cssClass="autosize1 messageinput"
								name="requestDetailsBO.attachmentBOList[0].issuanceDesc" theme="aloc" 
								cols="50" rows="2" id="closureUploadDescription"
								onkeypress="return imposeMaxLength(this, 99);"></s:textarea>
				                
				               <div class="clear"></div>
				               <div class="counter closureCounter">100</div>
				               <div class="counterTxt span4"><p style="padding-left: 5px;" class="guidance"><s:text name="label.request.characters"/></p></div>				          
						</td>
						<td>
							<div class="alocAttachmentContainer">
								<hwfs:checkComponentPermission name="NotBankBrokerReadOnly" domainName="BusinessAccess">
									<p>
										<input type="file" class="alocFileupload" name="fileUpload"
											data-url="${pageContext.request.contextPath}/ext/atmt/upload.action?typeId=4&index=0" />
									</p>
								</hwfs:checkComponentPermission>
								<div class="alocAttachment"></div>
							</div> 
						</td>
					</tr>
				</s:else>
			</tbody>
		</table>
	</div>
</div></div>

<!-- Complete REQUEST ISSUANCE POPUP WINDOW -->
<div class="modal hide fade" id="completeClosureRequest">
<s:hidden id="closureGeLibFileId" name="closureGeLibFileId" value="" />
<s:hidden id="closureTypeId" name="closureTypeId" value="" />
<s:hidden id="closureIndex" name="closureIndex" value="" />
		<div class="modal-header"> 
			<a class="close" data-dismiss="modal">X</a>
			<h3><span><s:text name="label.request.thisActionCannotbeUndone"/> </span></h3>
		</div>
		<div class="modal-body">		
		<p><s:text name="label.request.issuanceTextAreaConfirm"/></p>
           
           <h3><s:text name="label.request.thisActionCannotbeUndone"/></h3>
		</div>
		<div class="modal-footer">
		<a data-dismiss="modal" href="javascript:void(0);" onclick="openClosureDocSection()" class="left btn-primary">
			  <s:text name="label.request.continue"/>
	    </a>			    
	    <a href="javascript:;" class="btn-tertiary left cancel" data-dismiss="modal"><s:text name="label.request.closeWindow"/></a>					  		
		</div>
</div>


<!-- Attachment Delete Confirmation Modal -->
<div class="modal hide fade" id="atmtConfirmModal">
<s:hidden id="modelGeLibFileId" name="modelGeLibFileId" value="" />
<s:hidden id="modelTypeId" name="modelTypeId" value="" />
<s:hidden id="modalIndexId" name="modalIndexId" value="" />
		<div class="modal-header">
			<a class="close" data-dismiss="modal">X</a>
			<h3><span><s:text name="label.attachment.attachmentConfirm"/></span></h3>
		</div>
		<div class="modal-body">
			<p><s:text name="label.attachment.attachmentDataClear"/></p>
		</div>
		<div class="modal-footer">
			<a data-dismiss="modal" href="javascript:void(0);" onclick="deleteConfirm();" class="left btn-primary"  id="saveSelectionlb">
				 <s:text name="label.attachment.attachmentDeleteMessage"/>
				</a>		
			<a href="#" class="btn-tertiary left cancel" data-dismiss="modal"><s:text name="label.request.common.cancel" /></a>				
		</div>			
</div> 		
  
<!-- EXIT REQUEST POPUP WINDOW -->         
<div class="modal hide fade" id="clearEntries">
		<div class="modal-header">
			<a class="close" data-dismiss="modal">X</a>
			<h3><s:text name="label.request.clearEntries"/> <span></span></h3>
		</div>
		<div class="modal-body">
		<p><b><s:text name="label.request.popUpMsg"/></b><br> 
				<s:text name="label.request.popUpsubMsg"/> 
		</p>
		</div>
		<div class="modal-footer">
		    <a href="<s:property value="#cancelBtnlURL" />" class="btn left"><s:text name="label.request.popUpCancelYes"/></a>
			<a href="#" class="btn-tertiary left cancel" data-dismiss="modal"><s:text name="label.request.popUpCancelNo"/></a>
		</div>
</div>  

<!-- Attachment Error Modal -->
	<div class="modal hide fade" id="attachmentErrorModal"  style="top:200px;">
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