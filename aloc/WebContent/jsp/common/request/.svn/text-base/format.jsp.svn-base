<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sjr" uri="/struts-jquery-richtext-tags"%>
<%@ taglib prefix="hwfs"  uri="/hwf-security-tags" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/attachments/attachmentOperations.js"></script>
<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/js/attachments/requestTinymce.js"></script> --%>	
<s:set name="isEditMode" value="editMode"/>
<s:if test="%{#isEditMode==true}">
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
 <jsp:include page="/jsp/common/request/requestFormat.jsp" />
</s:if>
 <s:elseif test="%{#isEditMode==false}">
<script type="text/javascript">
	$(document).ready(function() {
		onloadReadOnlySection();
	});	
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/attachments/requestTinymce.js"></script>
 <c:set var="isEligible" value="false"></c:set>
 <c:set var="isBusiness" value="false"></c:set>
<hwfs:checkComponentPermission name="AttachmentsAccess" domainName="BusinessAccess">
	<c:set var="isEligible" value="true"></c:set>
</hwfs:checkComponentPermission>	
<hwfs:checkComponentPermission name="BusinessDashboardAccess" domainName="BusinessAccess">
	<c:set var="isBusiness" value="true"></c:set>
</hwfs:checkComponentPermission>
			<s:hidden value="%{requestDetailsBO.formatBO.model.formatTypeId}" id="readOnlyFormatTypeId" />	
		    <div class="row">		 			 	
				<div class="span2b">
					<div class="form-row">
						<label><s:text name="label.format.formatSelection" /></label>
					</div>
				</div>
				<div class="span5 left">
					<p class="padding40"> <c:out value="${requestDetailsBO.formatBO.model.formatType}"/> </p>
				</div>
				<!-- end of block -->
			</div>
			<c:choose>			
				<c:when test="${requestDetailsBO.formatBO.model.formatTypeId == 1}">
					<div class="row lastrow hide">
						<div class="span12">
						<div class="row">
								<div class="span12">
						 	<div class="form-row">
								<label><s:text name="label.format.geStandardFormat" /></label>
					    	</div>
								<div class="form-row" style="border:1px solid black!important;">
								 <s:textarea id="formatReadOnly" cssClass="xlarge autosize messageinpu" wrap="true" name="standardFormat" style="width:950px;height: 400px;" />  													
									<%--  <p class="padding40">
									 <s:property escapeHtml="false" value="standardFormat"/></p> --%>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="row lastrow">
						<div class="span12">
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
		   </c:when>	
	   		<c:when test="${requestDetailsBO.formatBO.model.formatTypeId == 2}">
		   <div class="row lastrow">
			<div class="span12">
					<div class="row">
						<div class="span12">
							<div class="form-row">
								<label><s:text name="label.format.modifyFormat" /></label> 
							</div>
							<div class="form-row">	
								<div id="content">
					                <div id="tinymce-wrapper" style="border:1px solid black!important;" >					               
					                 <%-- <p class="padding40" ><s:property escapeHtml="false" value="modifiedStandardFormat" /></p>  --%>
					                  <s:textarea id="formatReadOnly" cssClass="xlarge autosize messageinpu" wrap="true" name="modifiedStandardFormat" style="width:950px;height: 400px;" />
					                </div>
					            </div>
							</div>
						</div>
					</div>
				</div>
			</div>
			
			<div class="row lastrow">
			<div class="span12">
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
		</c:when>	
	
		<c:when test="${requestDetailsBO.formatBO.model.formatTypeId == 3}">
			<div class="row lastrow">
				<div class="span12">
						<div class="row">
							<div class="span12">
								<h3><s:text name="label.format.formatAndAdditionalAttachments" /></h3>
								<table class="table table-striped table-bordered"> 
								<thead>
									<tr class="spantr1">
										<th colspan="2" class="spantd2"><p style="padding-left: 20px;">
											<s:text name="label.format.permissions"/>
												<c:if test="${requestDetailsBO.model.instrumentTypeId eq '3'}">
												<span class="ttip info" data-original-title="<s:text  name="label.attachment.tooltip.suretyPermissionsInfo"/>"></span>	
												</c:if>	
												<c:if test="${requestDetailsBO.model.instrumentTypeId eq '1' || requestDetailsBO.model.instrumentTypeId eq '2' || requestDetailsBO.model.instrumentTypeId eq '5' || requestDetailsBO.model.instrumentTypeId eq '4'}">
													<span class="ttip info" data-original-title="<s:text  name="label.attachment.tooltip.bankPermissionsInfo"/>"></span>	
												</c:if>								
										    </p>
										  </th>				
											<th colspan="1" class="spantd3"><p
													style="padding-left: 10px;"><s:label key="label.format.documents"  cssStyle="color:#FFFFFF;" /></p></th>
										</tr>
								</thead>
									<tbody>
									<s:if test="%{requestDetailsBO.formatBO != null && requestDetailsBO.formatBO.attachmentBOList.size> 0}">
									 <s:iterator value="requestDetailsBO.formatBO.attachmentBOList" status="formatAtmtBOItrStatus">	
									   	  <c:set var="isBank" value="false"></c:set>
										  <c:set var="isSurety" value="false"></c:set>
  										  <c:set var="isTreasury" value="false"></c:set>
  										  
  										  
  										  <c:if test="${requestDetailsBO.model.instrumentTypeId eq '3'}">												
												<s:if test="%{requestDetailsBO.formatBO.attachmentBOList[#formatAtmtBOItrStatus.index].suretyPermission}">
 														  <c:set var="isSurety" value="true"></c:set>
												</s:if>
										  </c:if>
										  <c:if test="${requestDetailsBO.model.instrumentTypeId eq '1' || requestDetailsBO.model.instrumentTypeId eq '2' || requestDetailsBO.model.instrumentTypeId eq '5' || requestDetailsBO.model.instrumentTypeId eq '4'}">
												<s:if test="%{requestDetailsBO.formatBO.attachmentBOList[#formatAtmtBOItrStatus.index].bankPermission}">
													  <c:set var="isBank" value="true"></c:set>
												</s:if>													
										   </c:if>
										   <s:if test="%{requestDetailsBO.formatBO.attachmentBOList[#formatAtmtBOItrStatus.index].treasuryPermission}">
												 <c:set var="isTreasury" value="true"></c:set>																										
										   </s:if>	
  										  
  									<c:if test="${isEligible && (isBank || isSurety || isTreasury || isBusiness)}">	  
									 <tr class="spantr2" id="attachment-added">
											<td colspan="2">
											<div class="form-row">																											
												<c:if test="${requestDetailsBO.model.instrumentTypeId eq '3'}">												
													<s:if test="%{requestDetailsBO.formatBO.attachmentBOList[#formatAtmtBOItrStatus.index].suretyPermission}">
														  <s:text name="label.attachment.surety" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;														    
  														  <c:set var="isSurety" value="true"></c:set>
													</s:if>
												</c:if>
												<c:if test="${requestDetailsBO.model.instrumentTypeId eq '1' || requestDetailsBO.model.instrumentTypeId eq '2' || requestDetailsBO.model.instrumentTypeId eq '5' || requestDetailsBO.model.instrumentTypeId eq '4'}">
													<s:if test="%{requestDetailsBO.formatBO.attachmentBOList[#formatAtmtBOItrStatus.index].bankPermission}">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
														  <s:text name="label.attachment.bank" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
														  <c:set var="isBank" value="true"></c:set>
													</s:if>													
												</c:if>
												
												<s:if test="%{requestDetailsBO.formatBO.attachmentBOList[#formatAtmtBOItrStatus.index].treasuryPermission}">
													 <s:text name="label.attachment.treasury" /> 
													 <c:set var="isTreasury" value="true"></c:set>																										
												</s:if>												
		  									</div>
											</td>
											<td>
												<p>		
												 <s:if test="%{model.geFileId != null && model.geFileId !=0}">
													<s:url id="fileDownload" action="download.action"
														namespace="/int/atmt">
														<s:param name="geLibFileId" value="model.geFileId" />
														<s:param name="formatId" value="3" />
														<s:param name="typeId" value="1" />
														<s:param name="index" value="%{#formatAtmtBOItrStatus.index}" />
													</s:url>													
													<s:if test="%{requestDetailsBO.formatBO.model.formatTypeId==3}">
														<c:if test="${isEligible && (isBank || isSurety || isTreasury || isBusiness)}">
															<s:a href="%{fileDownload}">
																<s:property value="model.attachmentOriginalName" />
															</s:a>	
														</c:if>	
													</s:if>		
												</s:if>																																									
												</p>
											</td>
										</tr>
										</c:if>
										</s:iterator>																	 
									</s:if> 			
			   					    </tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			   </c:when> 
		  </c:choose>
		  <c:if test="${requestDetails.WFDetails.WFStage eq 'REQEST'}">
		<s:if test="%{requestDetailsBO.formatBO.model.requiresEdits}">
						<div class="row">
							<div class="span44">
								<div class="form-row">
									<label> <s:text name="label.request.Sendbacknotes" /> :
									</label>
								</div>
							</div>
							<div class="span5 left">
								<div class="form-row">
									<p class="padding40">
										<c:out
											value="${requestDetailsBO.formatBO.model.sendBackNotes}" />
									</p>
								</div>
							</div>
	
						</div>
					</s:if>
		</c:if> 
	  </s:elseif> 	  	
		<!-- formatAdditional ends here --> 		