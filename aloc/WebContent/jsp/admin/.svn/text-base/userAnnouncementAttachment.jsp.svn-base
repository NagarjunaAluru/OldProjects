<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<script src="${pageContext.request.contextPath}/js/admin/treasuryAdminManagement.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/admin/userAttachmentOperations.js"></script>
<script src="${pageContext.request.contextPath}/js/admin/userAnnouncement.js" type="text/javascript"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common/date.js"></script>
<div id="userMgmt"> 
    	<div class="leftBox">
				<s:textarea            				
               		id="userAnnouncementMgmtId" 
               		cssStyle="width: 375px;"
               		name="userAnnouncementBO.model.messageContent"               		
               		cssClass="mceEditor"
               		value="%{userAnnouncementBO.model.messageContent}"  theme="aloc"
               		 />             		                			
			<script >
				registerCommonTinyMCE('200','userAnnouncementMgmtId');            		
			</script>	
         </div> 
         
         <div class="midBox">
            	<h4><s:text name="label.userannouncementmgmt.uploadLinkedDocument"/></h4>
                <div class="span12">
                    <div class="row">
                    	<div class="rounded">1</div> <s:text name="label.userannouncementmgmt.uploadLinkedItem1"/>
                    </div>
                </div>
                <div class="span12">
                    <div class="row"> 	                          	
                    	<div class="rounded">2</div> Click the  <s:a href="javascript:uploadUserAnnouncementAtmt()" id="upLoadPopup"><img src="${pageContext.request.contextPath}/img/attach-small.png" border="0" align="middle" /></s:a> to upload document and create link.
                    </div>
                </div> 
 
            </div>            
            
            <div class="rightBox">
            	<h4><s:text name="label.userannouncementmgmt.hyperlink"/></h4>
                <div class="span12">
                    <div class="row">
                    	<div class="rounded">1</div> <s:text name="label.userannouncementmgmt.hyperlinkTextMain"/>
                    </div>
                </div>
                <div class="span12">
                    <div class="row">
                    	<div class="rounded">2</div> Click on the <img src="${pageContext.request.contextPath}/img/link.png" border="0" align="middle" /> to create link in editor.
                    </div>
                </div>                
            </div>
        	
            <div class="clear"></div>
        </div><!-- geStandardFormat ends here -->
         
	<div class="form-mod">
		<h2 class="acc_triggerExtra acc_blue">
		<a href="javascript:;"><s:text name="label.userannouncementmgmt.announcementAttachment"/></a></h2><hr class="h2-hr">
			<div class="acc_containerExtra">
                   <table class="table table-striped table-bordered sortable no-bottom">
                <thead>
                    <tr>
	                    <td><s:text name="label.request.documents"/></td>
	                </tr>
                </thead>
                <tbody>
	                <tr>
						<td>
							<s:if test="%{userAnnouncementBO != null && userAnnouncementBO.model.attachments.size> 0}">
							 		<s:iterator value="userAnnouncementBO.model.attachments" status="atmtItrStatus">																			
										<p>																								
											<s:if test="%{geFileId !=0}">																																	
												<s:url id="fileDownload" action="downloadAttachment.action" namespace="/int/admin" encode="true" escapeAmp="false">
													<s:param name="geLibFileId"><s:property value="geFileId"/></s:param>
								   					<s:param name="announcementType">userAnnouncement</s:param>													
												</s:url>
													<div class="userAnnouncementAttachment">	
												  		<div class="alocAttachment"> 															
															 <a href='javascript:void(0)' class="deleteIcon"  
																onclick="javascript:deleteUserannouncementAttachment(<s:property value="geFileId"/>)"></a>											
																 &nbsp;	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <s:a href="%{fileDownload}" cssClass="userDownload" ><s:property value="attachmentOriginalName" /></s:a>		
														</div>								
												  </div>																																																											
											</s:if>																																		
										</p>							
									</s:iterator>	
							  </s:if>
							  <s:else>
							 		 <div class="userAnnouncementAttachment">	
											<div class="alocAttachment">																
											</div>								
									</div>	
							  </s:else>							
						</td>
					</tr> 
				</tbody>
				</table>
			</div>
	</div>
	<div class="clear"></div>          
	   	<div style=color:red;>
		 <s:actionerror/>      				
		</div> 	
	<div class="row">
		<div class="span5">
			<div class="form-row">
						<label><s:text name="label.request.siteSelection" /></label>
			</div>
			<div class="form-row">
			     <div class="checkboxSelectionDiv">
                    <s:checkboxlist name="userAnnouncementBO.model.siteSelections" id="siteSelectionId" cssClass="siteSelectionCls checkBoxAlign"
                       list="%{#attr['com.ge.aloc.StaticDataFactory'].siteTypes}" 
						listKey="ID" 
						listValue="Name" theme="aloc"/>
				 </div>
				 <span class="siteSelections-error hide" style="color: #AE2C2C;"></span>   
			 </div>
		</div>
	</div>
		
	<div class="row">
		<div class="span5">
			<div class="form-row">
				<label>
					<s:text name="label.userannouncementmgmt.roleSelection"/>
					<span class="ttip info" data-original-title="<s:text name="label.treasuryAdminPortal.tooltip.userannouncementManagement.rolesSelection"/>"></span>
				</label>
			</div>
			<div class="form-row">
				<div class="checkboxSelectionDiv">
	                   <s:checkboxlist id="rolesSelectionId" name="userAnnouncementBO.model.selectedRoles" cssClass="roleSelectionCls checkBoxAlign"
	                       list="%{allRoles}" 
	                       listKey="roleId" 
						   listValue="roleName" theme="aloc"/> 
                 </div>
	        </div>
		</div>
	</div>
	
	<div class="row">
		<div class="span12">
			<div class="form-row">
				<label><s:text name="label.userannouncementmgmt.startDate"/></label>
				<s:textfield  name="userAnnouncementBO.model.startDate" id="startDate" cssClass="span2 date" theme="aloc"/>
			</div>
		</div>
	</div>
	
	<div class="row">
		<div class="span12">
			<div class="form-row">
				<label><s:text name="label.userannouncementmgmt.endDate"/></label>
				<s:textfield  name="userAnnouncementBO.model.endDate" id="endDate" cssClass="span2 date" theme="aloc"/>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="span12">
			<div class="form-row"> 
				<s:submit action="previewUserAnnouncement" key="label.userannouncementmgmt.preview" cssClass="btn-secondary"/>					
			</div>
		</div>
	</div>
    <div class="clear"></div>
	    <div class="form-mod">
				<h2 class="acc_triggerExtra acc_blue"><s:text name="label.userannouncementmgmt.announcementAudience"/></h2><hr class="h2-hr">
		           	<div class="acc_containerExtra">
				    <div id="infoMsg">
		        	<div class="inMsg">		        	
		        	<img src='${pageContext.request.contextPath}/img/info1.png' style="margin-left:-30px;" /><span style="padding-left:5px;">
		        	<s:text name="label.userannouncementmgmt.success"/></span></div>
				            <div class="inContent"><s:property value="userAnnouncementBO.model.messageContent" escape="false"/></br>
				            	<s:if test="%{userAnnouncementBO != null && userAnnouncementBO.model.attachments.size> 0}">
							 		<s:iterator value="userAnnouncementBO.model.attachments">																			
										<p>																								
											<s:if test="%{geFileId !=0}">																																	
												<s:url id="fileDownload" action="downloadAttachment.action" namespace="/int/admin" encode="true" escapeAmp="false">
													<s:param name="geLibFileId"><s:property value="geFileId"/></s:param>
								   					<s:param name="announcementType">userAnnouncement</s:param>													
												</s:url>																									
												   <div class="userAnnouncementAttachmentPreview">	
												  		<div class="alocAttachment">
																<s:a href="%{fileDownload}"><s:property value="attachmentOriginalName" /></s:a>			
														</div>								
												  </div>															
											</s:if>																																		
										</p>							
									</s:iterator>	
							  </s:if>
							   <s:else>
							 		 <div class="userAnnouncementAttachmentPreview"> 
										<div class="alocAttachment">																
										</div>								
									</div>	
							  </s:else>	
				            </div>
				        </div>
				  </div>
		</div>
        <div class="clear"></div>   
           <div class="highlighted">
                <s:submit action="saveUserAnnouncement" key="label.standardFormatMgmt.save" cssClass="btn-primary" />
                <a href="#" class="btn-tertiary cancel clearEntries" data-toggle="modal" ><s:text name="label.request.common.cancel"></s:text></a>  
         </div>