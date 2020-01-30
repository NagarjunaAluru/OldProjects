<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="hwfs"  uri="/hwf-security-tags" %>
    <c:set var="isEligible" value="false"></c:set>
	<hwfs:checkComponentPermission name="AttachmentsAccess" domainName="BusinessAccess">
		<c:set var="isEligible" value="true"></c:set>
	</hwfs:checkComponentPermission>
	
	<p class="span12 left clear dashdesc">		
		<s:text name="label.attachment.header" />
	</p>	
	<br />		
	<label> <s:text name="label.attachment.subHeader" /></label>
	<div class="row">
		<div class="span12">
			<table class="table table-striped table-bordered attachment">
				<thead>
					<tr class="spantr1">
						<th colspan="1" class="spantd1"><p style="padding-left: 10px;">
								<s:label key="label.attachment.actions"
									cssStyle="color:#FFFFFF;" />
								</p>
						</th>
						<th colspan="1" class="spantd2"><p style="padding-left: 10px;">
							<s:text name="label.attachment.permissions"/>
								<c:if test="${requestDetailsBO.model.instrumentTypeId eq '3' || requestDetailsBO.model.instrumentTypeId eq '6'}">
								<span class="ttip info" data-original-title="<s:text  name="label.attachment.tooltip.suretyPermissionsInfo"/>"></span>	
								</c:if>	
								<c:if test="${requestDetailsBO.model.instrumentTypeId eq '1' || requestDetailsBO.model.instrumentTypeId eq '2' || requestDetailsBO.model.instrumentTypeId eq '5' || requestDetailsBO.model.instrumentTypeId eq '4'}">
									<span class="ttip info" data-original-title="<s:text  name="label.attachment.tooltip.bankPermissionsInfo"/>"></span>	
								</c:if>								
							</p>
						</th>
						<th colspan="1" class="spantd3"><p
								style="padding-left: 10px;">
								<s:label key="label.attachment.documents"
									cssStyle="color:#FFFFFF;" />
							</p></th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="requestDetailsBO.attachmentBOList" status="atmtBOItrStatus">
					<c:if test="${model.attachmentTypeId eq '2'}">	
						  <c:set var="isBank" value="false"></c:set>
						  <c:set var="isSurety" value="false"></c:set>
						  <c:set var="isTreasury" value="false"></c:set>						
						<tr class="spantr2"
							id="uploadedToGELib<s:property value="#atmtBOItrStatus.index" />">
							<td>
								<p style="padding: 10px 0 0 10px;">
									<img src='${pageContext.request.contextPath}/img/delete.gif' border='0'/>							
								</p>
							</td>
							<td>
								<div class="form-row">
									<p style="align: left;">												
										<c:if test="${requestDetailsBO.model.instrumentTypeId eq '3' || requestDetailsBO.model.instrumentTypeId eq '6'}">					
											<s:if test="%{requestDetailsBO.attachmentBOList[#atmtBOItrStatus.index].suretyPermission}">
												<s:text name="label.attachment.surety" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  
												<c:set var="isSurety" value="true"></c:set>
											</s:if>										
										</c:if>											
										<c:if test="${requestDetailsBO.model.instrumentTypeId eq '1' || requestDetailsBO.model.instrumentTypeId eq '2' || requestDetailsBO.model.instrumentTypeId eq '5' || requestDetailsBO.model.instrumentTypeId eq '4'}">
											<s:if test="%{requestDetailsBO.attachmentBOList[#atmtBOItrStatus.index].bankPermission}">
												  <s:text name="label.attachment.bank" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
												  <c:set var="isBank" value="true"></c:set>
											</s:if>				
										</c:if>	
										<s:if test="%{requestDetailsBO.attachmentBOList[#atmtBOItrStatus.index].treasuryPermission}"> 
											 <s:text name="label.attachment.treasury" />	 
											 <c:set var="isTreasury" value="true"></c:set> 													
										</s:if>																									
									</p>
								</div>
							</td>
							<td>
								<div class="alocAttachment">
									<p>
									 <s:if test="%{model.geFileId != null && model.geFileId !=0}"> 
										<s:url id="fileDownload" action="download.action"
												namespace="/int/atmt">
												<s:param name="geLibFileId" value="model.geFileId" />
												<s:param name="formatId" value="" />
												<s:param name="typeId" value="2" />
												<s:param name="index" value="%{#atmtBOItrStatus.index}" />
											</s:url>												
											<c:if test="${isEligible && (isBank || isSurety || isTreasury)}">
												<s:a href="%{fileDownload}">
													<s:property value="model.attachmentOriginalName" />
												</s:a>	
											</c:if>	
											<c:if test="${not (isEligible && (isBank || isSurety || isTreasury))}">	
													<s:a href="">																								
													   <s:property value="model.attachmentOriginalName" />		
													</s:a>																												
											</c:if>		
										</s:if>																																						
									</p>
								</div>
							</td>
						</tr>
						</c:if>
					</s:iterator>
				</tbody>
			</table>
		</div>
	</div>