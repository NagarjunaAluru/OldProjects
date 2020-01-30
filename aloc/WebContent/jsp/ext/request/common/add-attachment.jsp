<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="/jsp/common/error.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags"%>	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		<td> 			
			<div class="alocDeleteAttachmentContainer">							
					<div class="alocDeleteAttachment">
						<p style="padding-left: 10px;">--</p>
					</div>
			</div>
		</td>
		<td>										
	        <div class="form-row">
	            <p style="padding: 5px 0 0 5px;">		            
					<c:if test="${param.instrumentTypeId eq '3'  || param.instrumentTypeId eq '6'}"> 																																									
						<s:checkbox label="%{getText('label.attachment.surety')}"
							theme="aloc" 
							name="requestDetailsBO.attachmentBOList[%{#parameters['newAttachmentIndex']}].suretyPermission" cssClass="bankOrSuretyAtmtPermission" />
					</c:if>
					<c:if test="${param.instrumentTypeId eq '1' || param.instrumentTypeId ==  '2' || param.instrumentTypeId ==  '5' || param.instrumentTypeId == '4'}">
						<s:checkbox label="%{getText('label.attachment.bank')}"	theme="aloc" name="requestDetailsBO.attachmentBOList[%{#parameters['newAttachmentIndex']}].bankPermission" cssClass="bankOrSuretyAtmtPermission" />
					</c:if>	
           		   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:checkbox label="%{getText('label.attachment.treasury')}" theme="aloc"
					name="requestDetailsBO.attachmentBOList[%{#parameters['newAttachmentIndex']}].treasuryPermission" cssClass="treasuryAtmtPermission" />					
			 </p>
	        </div>
		</td>
		<td>
				<div class="alocAttachmentContainer"> 					 		
					<p>
					   <input type="file" class="alocFileupload" name=fileUpload data-url="${pageContext.request.contextPath}/ext/atmt/upload.action?typeId=${param.atmtTypeId}&formatId=&index=${param.newAttachmentIndex}"/>
					</p>					
					<div class="alocAttachment">
						
					</div>
			</div>				
		</td>			
	<script type="text/javascript" src="${pageContext.request.contextPath}/ext/public/js/ext/attachmentOperations.js"></script>	 												