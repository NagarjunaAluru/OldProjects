<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="hwfs" uri="/hwf-security-tags"%>
<s:url action="cancel.action" namespace="/int/approver" var="cancelBtnlURL"/>  
 <p class="span12 left clear dashdesc lastrow"><s:text name="label.attachment.header" /></p>
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
				<s:if test="%{taxonomyClosureAtmts != null && taxonomyClosureAtmts.size >0}">
					<s:iterator value="taxonomyClosureAtmts" status="atmtBOItrStatus">		
					<c:if test="${attachmentTypeId eq '4'}">						
						<tr>
							<td>
								<div class="alocDeleteAttachmentContainer">
									<div class="alocDeleteAttachment">
										<p style="padding: 10px 0 0 10px;">
										<s:text name="label.request.clear" /> 
										</p>
									</div>
								</div>
							</td>
							<td>
								<div class="form-row">
									<p style="padding: 5px 0 0 5px;">
									<s:iterator value="attachmentPermissions" status="atmtPerms">
										<c:if test="${requestDetails.instrumentTypeId eq '3' || requestDetails.instrumentTypeId eq '6'}">					
											<s:if test="%{permissionId == 2}">
												<s:text name="label.attachment.surety" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  
												<c:set var="isSurety" value="true"></c:set>
											</s:if>										
										</c:if>											
										<c:if test="${requestDetails.instrumentTypeId eq '1' || requestDetails.instrumentTypeId eq '2' || requestDetails.instrumentTypeId eq '5' || requestDetails.instrumentTypeId eq '4'}">
											<s:if test="%{permissionId == 3}">
												  <s:text name="label.attachment.bank" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
												  <c:set var="isBank" value="true"></c:set>
											</s:if>				
										</c:if>	
										<s:if test="%{permissionId == 1}"> 
											 <s:text name="label.attachment.treasury" />	 
											 <c:set var="isTreasury" value="true"></c:set> 													
										</s:if>
									</s:iterator>		
									</p>
								</div>
							</td>
							<td>
								<s:textarea style="resize: none; overflow-y: hidden;" disabled="true"
									cssClass="autosize1 messageinput" 
									name="issuanceDesc"
									cols="50" rows="2" id="closureUploadDescription" theme="aloc"/> 
							</td>
							<td>
								<div class="alocAttachmentContainer">									
									<div class="alocAttachment">
										<s:if test="%{geFileId!= null && geFileId !=0}">										
											<s:url id="fileDownload" action="download.action"
												namespace="/int/atmt">
												<s:param name="geLibFileId" value="geFileId" />
												<s:param name="typeId" value="4" />
												<s:param name="atmtsFlag" value="true" />
												<s:param name="index" value="%{#atmtBOItrStatus.index}" />
											</s:url>
											<s:a href="%{fileDownload}">
												<s:property value="attachmentOriginalName" />
											</s:a>
										</s:if>
									</div>
								</div>											
							</td>
						</tr>
					</c:if>
					</s:iterator>
				</s:if>				
			</tbody>
		</table>
	</div>
</div></div>