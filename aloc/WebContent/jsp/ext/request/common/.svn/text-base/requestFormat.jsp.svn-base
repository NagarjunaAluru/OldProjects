<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sjr" uri="/struts-jquery-richtext-tags"%>
<%@ taglib prefix="hwfs"  uri="/hwf-security-tags" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/ext/public/js/attachments/requestTinymce.js"></script>
<s:url id="generateFormatDoc" action="generateFormatDoc" namespace="/ext/approver" />
<div style="color: red;">	<!-- validation error occurs at edit level -->
	<s:fielderror fieldName="requestDetailsBO.formatBO.model.formatTypeId" />
	<s:fielderror fieldName="requestDetailsBO.formatBO.model.attachments" /> 
</div>
<div class="row">
	<div class="span12">
		<div class="form-row">
			<label><s:text name="label.format.formatSelection" /><span
				class="ttip info"
				data-original-title="<s:text name="label.request.tooltip.formatSelection"/>"></span> 
			</label>	
		</div>
		<s:select theme="aloc"
			list="%{#attr['com.ge.aloc.StaticDataFactory'].formatSelection}"
			listKey="ID" listValue="name" id="pole2" headerKey=""
			headerValue="Select..."
			name="requestDetailsBO.formatBO.model.formatTypeId" />		
	</div>
	<!-- end of block -->
</div>

<div class="row lastrow">
	<div class="span12">
		<div class="hide" id="formatStandard">
			<div class="row hide">
				<div class="span12">
					<div class="form-row">
						<label><s:text name="label.format.geStandardFormat" /></label>
					</div>
					<div class="form-row" >
						<s:textarea id="standardFormatTextArea" wrap="true" name="standardFormat"
							style="width:950px;height: 400px;" />
					</div>					
				</div>
			</div>
			
			<div class="row">
				<div class="span12">
				 	<div class="form-row">
						<label><s:text name="label.format.geStandardFormatRequestData" /></label>
			    	</div>
					<div class="form-row" style="border:1px solid black!important;">
						<s:textarea id="standardFormatReadOnlyView" cssClass="xlarge autosize messageinpu" wrap="true" name="standardFormatView" style="width:950px;height: 400px;" />  													
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="row lastrow">
	<div class="span12">
		<div class="hide" id="formatModified"> 
			<div class="row">
				<div class="span12">
					<div class="form-row"> 
						<label><s:text name="label.format.modifyFormat" /></label>
					</div>												
					<div class="form-row">
						<div id="content">
							<div id="tinymce-wrapper">
								<s:textarea id="modifiedFormatTextArea" wrap="true"
									name="modifiedStandardFormat"
									style="width:950px;height: 400px;"
									cssClass="xlarge autosize messageinpu"
									/>			                								
							</div>
						</div>
					</div>
					<!-- end of block -->					
				</div>
			</div>
			
			<div class="row">
				<div class="span12">
					<div class="form-row">
						<label><s:text name="label.format.modifyFormatRequstData" /></label> 
					</div>
					<div class="form-row">	
						<div id="content">
			                <div id="tinymce-wrapper" style="border:1px solid black!important;" >					               
			                  <s:textarea id="modifiedFormatReadOnlyView" cssClass="xlarge autosize messageinpu" wrap="true" name="modifiedStandardFormatView" style="width:950px;height: 400px;" />
			                </div>
			            </div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="row lastrow">
	<div class="span12">
		<div class="hide" id="formatAttachment">
			<div class="row">
				<div class="span12">
					<h3>
						<s:text name="label.format.formatAndAdditionalAttachments" />
					</h3>
					<table class="table table-striped table-bordered">
						<thead>
							<tr class="spantr1">
								<th colspan="2" class="spantd2"><p style="padding-left: 10px;">
									<s:text name="label.format.permissions"/>
										<c:if test="${requestDetailsBO.model.instrumentTypeId eq '3'}">
										<span class="ttip info" data-original-title="<s:text  name="label.attachment.tooltip.suretyPermissionsInfo"/>"></span>	
										</c:if>	
										<c:if test="${requestDetailsBO.model.instrumentTypeId eq '1' || requestDetailsBO.model.instrumentTypeId eq '2' || requestDetailsBO.model.instrumentTypeId eq '5' || requestDetailsBO.model.instrumentTypeId eq '4'}">
											<span class="ttip info" data-original-title="<s:text  name="label.attachment.tooltip.bankPermissionsInfo"/>"></span>	
										</c:if>								
								    </p>
								  </th>				
									<th colspan="1" class="spantd3"><p style="padding-left: 10px;"><s:label key="label.format.documents"  cssStyle="color:#FFFFFF;" /></p></th>
								</tr>
							</thead>
						<tbody>
							<s:if test="%{requestDetailsBO.formatBO != null && requestDetailsBO.formatBO.attachmentBOList.size> 0}">
								<s:iterator value="requestDetailsBO.formatBO.attachmentBOList" status="formatAtmtBOItrStatus">
									<tr class="spantr2" id="attachment-added">										
									 <td colspan="2" class="spantd2">
										 <c:choose>
												<c:when
													test="${requestDetailsBO.formatBO.model.formatTypeId == 1 || requestDetailsBO.formatBO.model.formatTypeId==2}">
													<div class="form-row">
														<p style="align: left;">
															<c:if
																test="${requestDetailsBO.model.instrumentTypeId eq '3'}">
																<s:checkbox label="%{getText('label.attachment.surety')}"
																	name="requestDetailsBO.formatBO.attachmentBOList[%{#formatAtmtBOItrStatus.index}].suretyPermission"
																	theme="aloc" value="" />
															</c:if>
															<c:if test="${requestDetailsBO.model.instrumentTypeId eq '1' || requestDetailsBO.model.instrumentTypeId eq '2' || requestDetailsBO.model.instrumentTypeId eq '5' || requestDetailsBO.model.instrumentTypeId eq '4'}">
																<s:checkbox label="%{getText('label.attachment.bank')}"
																	name="requestDetailsBO.formatBO.attachmentBOList[%{#formatAtmtBOItrStatus.index}].bankPermission"
																	theme="aloc" value="true" fieldValue="true" disabled="true"/>
																<s:hidden name="requestDetailsBO.formatBO.attachmentBOList[%{#formatAtmtBOItrStatus.index}].bankPermission" value="true"/>
															</c:if>
															&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:checkbox
																label="%{getText('label.attachment.treasury')}"
																name="requestDetailsBO.formatBO.attachmentBOList[%{#formatAtmtBOItrStatus.index}].treasuryPermission"
																theme="aloc" value="" />															
														</p>
													</div>
												</c:when>
												<c:when
													test="${empty requestDetailsBO.formatBO.model.formatTypeId  || requestDetailsBO.formatBO.model.formatTypeId == 3}"> 
													<div class="form-row">
														<p style="align: left;">															
															 <c:if test="${requestDetailsBO.model.instrumentTypeId eq '3'}">															
																<s:checkbox
																	label="%{getText('label.attachment.surety')}"
																	name="requestDetailsBO.formatBO.attachmentBOList[%{#formatAtmtBOItrStatus.index}].suretyPermission"
																	theme="aloc" cssClass="bankOrSuretyAtmtPermission" />
															</c:if>
															<c:if test="${requestDetailsBO.model.instrumentTypeId eq '1' || requestDetailsBO.model.instrumentTypeId eq '2' || requestDetailsBO.model.instrumentTypeId eq '5' || requestDetailsBO.model.instrumentTypeId eq '4'}">
															<s:checkbox label="%{getText('label.attachment.bank')}"
																name="requestDetailsBO.formatBO.attachmentBOList[%{#formatAtmtBOItrStatus.index}].bankPermission"
																theme="aloc" disabled="true" fieldValue="true" value="true"/>
															<s:hidden name="requestDetailsBO.formatBO.attachmentBOList[%{#formatAtmtBOItrStatus.index}].bankPermission" value="true"/>
															</c:if>	
															&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:checkbox
																label="%{getText('label.attachment.treasury')}"
																name="requestDetailsBO.formatBO.attachmentBOList[%{#formatAtmtBOItrStatus.index}].treasuryPermission"
																theme="aloc"  cssClass="treasuryAtmtPermission"/>															
														</p>
													</div>
												</c:when>
											</c:choose>
										</td> 
										<td>
										<div class="alocAttachmentContainer"> 
											<p>
												<input  type="file" class="alocFileupload" name="fileUpload" data-url="${pageContext.request.contextPath}/ext/atmt/upload.action?typeId=1&formatId=3&index=0"/>												
											</p>									
											<div class="alocAttachment">
												<s:if test="%{model.geFileId !=null && model.geFileId !=0}">
														<s:url id="fileDownload" action="download.action"
															namespace="/ext/atmt">
															<s:param name="geLibFileId" value="model.geFileId" />
															<s:param name="formatId" value="3" />
															<s:param name="typeId" value="1" />
															<s:param name="index" value="%{#formatAtmtBOItrStatus.index}" />
														</s:url>
														<%-- <c:if test="${requestDetailsBO.formatBO.model.formatTypeId == 3}"> --%>
														<s:a href="%{fileDownload}">
															 <s:property value="model.attachmentOriginalName" />
														</s:a>	
														<%-- </c:if> --%>
												</s:if> 
											</div>
										</div>				
										</td>
									</tr>
								</s:iterator>
							</s:if>
							<s:else>
								<tr class="spantr2">	
									<td colspan="2" class="spantd2">
										<div class="form-row">
											<p style="align: left;" >												
													<c:if test="${requestDetailsBO.model.instrumentTypeId eq '3'}">																								
														<s:checkbox label="%{getText('label.attachment.surety')}"
															theme="aloc"
															name="requestDetailsBO.formatBO.attachmentBOList[0].suretyPermission" cssClass="bankOrSuretyAtmtPermission"/>
													</c:if>											
													<c:if test="${requestDetailsBO.model.instrumentTypeId eq '1' || requestDetailsBO.model.instrumentTypeId eq '2' || requestDetailsBO.model.instrumentTypeId eq '5' || requestDetailsBO.model.instrumentTypeId eq '4'}">
														<s:checkbox label="%{getText('label.attachment.bank')}"
														theme="aloc" fieldValue="true" value="true" disabled="true"
														name="requestDetailsBO.formatBO.attachmentBOList[0].bankPermission" />
													<s:hidden name="requestDetailsBO.formatBO.attachmentBOList[%{#formatAtmtBOItrStatus.index}].bankPermission" value="true"/>
													</c:if>	
														&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;																							
														<s:checkbox label="%{getText('label.attachment.treasury')}"
														theme="aloc"
														name="requestDetailsBO.formatBO.attachmentBOList[0].treasuryPermission" cssClass="treasuryAtmtPermission"/>																							
											</p>
										</div>
									</td>
									<td>
										<div class="alocAttachmentContainer"> 
											<p>
												<input  type="file" class="alocFileupload" name="fileUpload" data-url="${pageContext.request.contextPath}/ext/atmt/upload.action?typeId=1&formatId=3&index=0"/>
											</p>
											<div class="alocAttachment">
												
											</div>
										</div>
									</td>
								</tr>								
							</s:else>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>	
	<!-- Attachment Error Modal -->
	<div class="modal hide fade" id="formatAtmtErrorModal" style="top:200px;">
			<div class="modal-header">
				<a class="close" data-dismiss="modal">X</a>
				<h3><span><s:text name="label.attachment.attachmentError"/></span></h3>
			</div>
			<div class="modal-body" style="margin-top:-32px;">
				<p></p>
			</div>
			<div class="modal-footer">
				<a href="#" class="btn-tertiary left cancel" data-dismiss="modal"><s:text name="label.request.common.cancel" /></a>				
			</div>			
	</div> 